package androidx.camera.extensions.internal.sessionprocessor;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.os.Build;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.w;
import androidx.camera.extensions.impl.advanced.Camera2OutputConfigImpl;
import androidx.camera.extensions.impl.advanced.Camera2SessionConfigImpl;
import androidx.camera.extensions.impl.advanced.ImageProcessorImpl;
import androidx.camera.extensions.impl.advanced.ImageReferenceImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceConfigurationImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceImpl;
import androidx.camera.extensions.impl.advanced.RequestProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AdvancedSessionProcessor extends SessionProcessorBase {
    private static final String TAG = "AdvancedSessionProcessor";
    private final Context mContext;
    private final MutableLiveData<Integer> mCurrentExtensionTypeLiveData;
    private final ExtensionMetadataMonitor mExtensionMetadataMonitor;
    private final MutableLiveData<Integer> mExtensionStrengthLiveData;
    private final SessionProcessorImpl mImpl;
    private boolean mIsPostviewConfigured;
    private final int mMode;

    @GuardedBy("mLock")
    private SessionProcessorImplCaptureCallbackAdapter mRepeatingCaptureCallbackAdapter;
    private final VendorExtender mVendorExtender;
    private final boolean mWillReceiveOnCaptureCompleted;

    @GuardedBy("mLock")
    private HashMap<CaptureRequest.Key<?>, Object> mWorkingCaptureConfigMap;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CallbackAdapter implements RequestProcessor.Callback {
        private final RequestProcessorImpl.Callback mCallback;

        public CallbackAdapter(RequestProcessorImpl.Callback callback) {
            this.mCallback = callback;
        }

        private RequestProcessorImpl.Request getImplRequest(RequestProcessor.Request request) {
            Preconditions.checkArgument(request instanceof RequestAdapter);
            return ((RequestAdapter) request).getImplRequest();
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureBufferLost(RequestProcessor.Request request, long j, int i2) {
            this.mCallback.onCaptureBufferLost(getImplRequest(request), j, i2);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
            CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "CaptureResult in cameraCaptureResult is not a TotalCaptureResult");
            this.mCallback.onCaptureCompleted(getImplRequest(request), (TotalCaptureResult) captureResult);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
            Object captureFailure = cameraCaptureFailure.getCaptureFailure();
            Preconditions.checkArgument(captureFailure instanceof CaptureFailure, "CameraCaptureFailure does not contain CaptureFailure.");
            this.mCallback.onCaptureFailed(getImplRequest(request), (CaptureFailure) captureFailure);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
            CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            Preconditions.checkArgument(captureResult != null, "Cannot get CaptureResult from the cameraCaptureResult ");
            this.mCallback.onCaptureProgressed(getImplRequest(request), captureResult);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureSequenceAborted(int i2) {
            this.mCallback.onCaptureSequenceAborted(i2);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureSequenceCompleted(int i2, long j) {
            this.mCallback.onCaptureSequenceCompleted(i2, j);
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Callback
        public void onCaptureStarted(RequestProcessor.Request request, long j, long j3) {
            this.mCallback.onCaptureStarted(getImplRequest(request), j, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ExtensionMetadataMonitor {
        private final MutableLiveData<Integer> mCurrentExtensionTypeLiveData;
        private final MutableLiveData<Integer> mExtensionStrengthLiveData;

        public ExtensionMetadataMonitor(MutableLiveData<Integer> mutableLiveData, MutableLiveData<Integer> mutableLiveData2) {
            this.mCurrentExtensionTypeLiveData = mutableLiveData;
            this.mExtensionStrengthLiveData = mutableLiveData2;
        }

        private int convertExtensionMode(int i2) {
            if (i2 == 0) {
                return 5;
            }
            if (i2 == 1) {
                return 4;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 != 3) {
                return i2 != 4 ? 0 : 3;
            }
            return 2;
        }

        public void checkExtensionMetadata(Map<CaptureResult.Key, Object> map) {
            Object obj;
            Object obj2;
            if (Build.VERSION.SDK_INT >= 34) {
                if (this.mCurrentExtensionTypeLiveData != null && (obj2 = map.get(CaptureResult.EXTENSION_CURRENT_TYPE)) != null) {
                    Integer num = (Integer) obj2;
                    if (!Objects.equals(this.mCurrentExtensionTypeLiveData.getValue(), Integer.valueOf(convertExtensionMode(num.intValue())))) {
                        this.mCurrentExtensionTypeLiveData.postValue(Integer.valueOf(convertExtensionMode(num.intValue())));
                    }
                }
                if (this.mExtensionStrengthLiveData == null || (obj = map.get(CaptureResult.EXTENSION_STRENGTH)) == null || Objects.equals(this.mExtensionStrengthLiveData.getValue(), obj)) {
                    return;
                }
                this.mExtensionStrengthLiveData.postValue((Integer) obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ImageProcessorAdapter implements ImageProcessor {
        private final ImageProcessorImpl mImpl;

        public ImageProcessorAdapter(ImageProcessorImpl imageProcessorImpl) {
            this.mImpl = imageProcessorImpl;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.ImageProcessor
        public void onNextImageAvailable(int i2, long j, ImageReference imageReference, String str) {
            this.mImpl.onNextImageAvailable(i2, j, new ImageReferenceImplAdapter(imageReference), str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ImageReferenceImplAdapter implements ImageReferenceImpl {
        private final ImageReference mImageReference;

        public ImageReferenceImplAdapter(ImageReference imageReference) {
            this.mImageReference = imageReference;
        }

        public boolean decrement() {
            return this.mImageReference.decrement();
        }

        public Image get() {
            return this.mImageReference.get();
        }

        public boolean increment() {
            return this.mImageReference.increment();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class OutputSurfaceConfigurationImplAdapter implements OutputSurfaceConfigurationImpl {
        private final OutputSurfaceImpl mAnalysisOutputSurface;
        private final OutputSurfaceImpl mCaptureOutputSurface;
        private final OutputSurfaceImpl mPostviewOutputSurface;
        private final OutputSurfaceImpl mPreviewOutputSurface;

        public OutputSurfaceConfigurationImplAdapter(OutputSurfaceConfiguration outputSurfaceConfiguration) {
            this.mPreviewOutputSurface = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPreviewOutputSurface());
            this.mCaptureOutputSurface = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageCaptureOutputSurface());
            this.mAnalysisOutputSurface = outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null ? new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageAnalysisOutputSurface()) : null;
            this.mPostviewOutputSurface = outputSurfaceConfiguration.getPostviewOutputSurface() != null ? new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPostviewOutputSurface()) : null;
        }

        public OutputSurfaceImpl getImageAnalysisOutputSurface() {
            return this.mAnalysisOutputSurface;
        }

        public OutputSurfaceImpl getImageCaptureOutputSurface() {
            return this.mCaptureOutputSurface;
        }

        public OutputSurfaceImpl getPostviewOutputSurface() {
            return this.mPostviewOutputSurface;
        }

        public OutputSurfaceImpl getPreviewOutputSurface() {
            return this.mPreviewOutputSurface;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class OutputSurfaceImplAdapter implements OutputSurfaceImpl {
        private final OutputSurface mOutputSurface;

        public OutputSurfaceImplAdapter(OutputSurface outputSurface) {
            this.mOutputSurface = outputSurface;
        }

        public int getImageFormat() {
            return this.mOutputSurface.getImageFormat();
        }

        public Size getSize() {
            return this.mOutputSurface.getSize();
        }

        public Surface getSurface() {
            return this.mOutputSurface.getSurface();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RequestAdapter implements RequestProcessor.Request {
        private final RequestProcessorImpl.Request mImplRequest;
        private final Config mParameters;
        private final List<Integer> mTargetOutputConfigIds;
        private final int mTemplateId;

        public RequestAdapter(RequestProcessorImpl.Request request) {
            this.mImplRequest = request;
            ArrayList arrayList = new ArrayList();
            Iterator it = request.getTargetOutputConfigIds().iterator();
            while (it.hasNext()) {
                arrayList.add((Integer) it.next());
            }
            this.mTargetOutputConfigIds = arrayList;
            RequestOptionConfig.Builder builder = new RequestOptionConfig.Builder();
            for (CaptureRequest.Key key : request.getParameters().keySet()) {
                builder.setCaptureRequestOption(key, request.getParameters().get(key));
            }
            this.mParameters = builder.build();
            this.mTemplateId = request.getTemplateId().intValue();
        }

        public RequestProcessorImpl.Request getImplRequest() {
            return this.mImplRequest;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public Config getParameters() {
            return this.mParameters;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public List<Integer> getTargetOutputConfigIds() {
            return this.mTargetOutputConfigIds;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public int getTemplateId() {
            return this.mTemplateId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class RequestProcessorImplAdapter implements RequestProcessorImpl {
        private final RequestProcessor mRequestProcessor;

        public RequestProcessorImplAdapter(RequestProcessor requestProcessor) {
            this.mRequestProcessor = requestProcessor;
        }

        public void abortCaptures() {
            this.mRequestProcessor.abortCaptures();
        }

        public void setImageProcessor(int i2, ImageProcessorImpl imageProcessorImpl) {
            AdvancedSessionProcessor.this.setImageProcessor(i2, new ImageProcessorAdapter(imageProcessorImpl));
        }

        public int setRepeating(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.setRepeating(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public void stopRepeating() {
            this.mRequestProcessor.stopRepeating();
        }

        public int submit(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.submit(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public int submit(List<RequestProcessorImpl.Request> list, RequestProcessorImpl.Callback callback) {
            ArrayList arrayList = new ArrayList();
            Iterator<RequestProcessorImpl.Request> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new RequestAdapter(it.next()));
            }
            return this.mRequestProcessor.submit(arrayList, new CallbackAdapter(callback));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SessionProcessorImplCaptureCallbackAdapter implements SessionProcessorImpl.CaptureCallback {
        private final SessionProcessor.CaptureCallback mCaptureCallback;
        private final ExtensionMetadataMonitor mExtensionMetadataMonitor;
        private long mOnCaptureStartedTimestamp;
        private final TagBundle mTagBundle;
        private boolean mWillReceiveOnCaptureCompleted;

        public SessionProcessorImplCaptureCallbackAdapter(SessionProcessor.CaptureCallback captureCallback, TagBundle tagBundle, boolean z2) {
            this(captureCallback, tagBundle, null, z2);
        }

        public void onCaptureCompleted(long j, int i2, Map<CaptureResult.Key, Object> map) {
            ExtensionMetadataMonitor extensionMetadataMonitor = this.mExtensionMetadataMonitor;
            if (extensionMetadataMonitor != null) {
                extensionMetadataMonitor.checkExtensionMetadata(map);
            }
            if (this.mWillReceiveOnCaptureCompleted) {
                this.mCaptureCallback.onCaptureCompleted(j, i2, new KeyValueMapCameraCaptureResult(j, this.mTagBundle, map));
                this.mCaptureCallback.onCaptureSequenceCompleted(i2);
            }
        }

        public void onCaptureFailed(int i2) {
            this.mCaptureCallback.onCaptureFailed(i2);
        }

        public void onCaptureProcessProgressed(int i2) {
            this.mCaptureCallback.onCaptureProcessProgressed(i2);
        }

        public void onCaptureProcessStarted(int i2) {
            this.mCaptureCallback.onCaptureProcessStarted(i2);
        }

        public void onCaptureSequenceAborted(int i2) {
            this.mCaptureCallback.onCaptureSequenceAborted(i2);
        }

        public void onCaptureSequenceCompleted(int i2) {
            if (this.mWillReceiveOnCaptureCompleted) {
                return;
            }
            SessionProcessor.CaptureCallback captureCallback = this.mCaptureCallback;
            long j = this.mOnCaptureStartedTimestamp;
            captureCallback.onCaptureCompleted(j, i2, new KeyValueMapCameraCaptureResult(j, this.mTagBundle, Collections.EMPTY_MAP));
            this.mCaptureCallback.onCaptureSequenceCompleted(i2);
        }

        public void onCaptureStarted(int i2, long j) {
            this.mOnCaptureStartedTimestamp = j;
            this.mCaptureCallback.onCaptureStarted(i2, j);
        }

        public SessionProcessorImplCaptureCallbackAdapter(SessionProcessor.CaptureCallback captureCallback, TagBundle tagBundle, ExtensionMetadataMonitor extensionMetadataMonitor, boolean z2) {
            this.mOnCaptureStartedTimestamp = -1L;
            this.mCaptureCallback = captureCallback;
            this.mTagBundle = tagBundle;
            this.mExtensionMetadataMonitor = extensionMetadataMonitor;
            this.mWillReceiveOnCaptureCompleted = z2;
        }
    }

    public AdvancedSessionProcessor(SessionProcessorImpl sessionProcessorImpl, List<CaptureRequest.Key<?>> list, VendorExtender vendorExtender, Context context) {
        this(sessionProcessorImpl, list, vendorExtender, context, 0);
    }

    private static HashMap<CaptureRequest.Key<?>, Object> convertConfigToMap(Config config) {
        HashMap<CaptureRequest.Key<?>, Object> map = new HashMap<>();
        RequestOptionConfig requestOptionConfigBuild = RequestOptionConfig.Builder.from(config).build();
        requestOptionConfigBuild.getClass();
        for (Config.Option option : w.e(requestOptionConfigBuild)) {
            map.put((CaptureRequest.Key) option.getToken(), w.f(requestOptionConfigBuild, option));
        }
        return map;
    }

    private Camera2SessionConfig convertToCamera2SessionConfig(Camera2SessionConfigImpl camera2SessionConfigImpl) {
        Camera2SessionConfigBuilder camera2SessionConfigBuilder = new Camera2SessionConfigBuilder();
        Iterator it = camera2SessionConfigImpl.getOutputConfigs().iterator();
        while (it.hasNext()) {
            camera2SessionConfigBuilder.addOutputConfig(Camera2OutputConfigConverter.fromImpl((Camera2OutputConfigImpl) it.next()));
        }
        for (CaptureRequest.Key key : camera2SessionConfigImpl.getSessionParameters().keySet()) {
            camera2SessionConfigBuilder.addSessionParameter(key, camera2SessionConfigImpl.getSessionParameters().get(key));
        }
        camera2SessionConfigBuilder.setSessionTemplateId(camera2SessionConfigImpl.getSessionTemplateId());
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            try {
                int sessionType = camera2SessionConfigImpl.getSessionType();
                if (sessionType == -1) {
                    sessionType = 0;
                }
                camera2SessionConfigBuilder.setSessionType(sessionType);
            } catch (NoSuchMethodError unused) {
                camera2SessionConfigBuilder.setSessionType(0);
            }
        }
        return camera2SessionConfigBuilder.build();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void abortCapture(int i2) {
        this.mImpl.abortCapture(i2);
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase
    public void deInitSessionInternal() {
        synchronized (this.mLock) {
            this.mWorkingCaptureConfigMap = new HashMap<>();
            this.mRepeatingCaptureCallbackAdapter = null;
        }
        this.mImpl.deInitSession();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public List<Pair<CameraCharacteristics.Key, Object>> getAvailableCharacteristicsKeyValues() {
        return this.mVendorExtender.getAvailableCharacteristicsKeyValues();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getCurrentExtensionMode() {
        return this.mCurrentExtensionTypeLiveData;
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getExtensionStrength() {
        return this.mExtensionStrengthLiveData;
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public /* bridge */ /* synthetic */ Pair getImplementationType() {
        return super.getImplementationType();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public Pair<Long, Long> getRealtimeCaptureLatency() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return this.mImpl.getRealtimeCaptureLatency();
        }
        return null;
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public /* bridge */ /* synthetic */ Set getSupportedCameraOperations() {
        return super.getSupportedCameraOperations();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public Map<Integer, List<Size>> getSupportedPostviewSize(Size size) {
        return this.mVendorExtender.getSupportedPostviewResolutions(size);
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase
    public Camera2SessionConfig initSessionInternal(String str, Map<String, CameraCharacteristics> map, OutputSurfaceConfiguration outputSurfaceConfiguration) {
        Version version = Version.VERSION_1_4;
        Camera2SessionConfigImpl camera2SessionConfigImplInitSession = (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) ? this.mImpl.initSession(str, map, this.mContext, new OutputSurfaceConfigurationImplAdapter(outputSurfaceConfiguration)) : null;
        if (camera2SessionConfigImplInitSession == null) {
            camera2SessionConfigImplInitSession = this.mImpl.initSession(str, map, this.mContext, new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPreviewOutputSurface()), new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageCaptureOutputSurface()), outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null ? new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageAnalysisOutputSurface()) : null);
        }
        this.mIsPostviewConfigured = outputSurfaceConfiguration.getPostviewOutputSurface() != null;
        MutableLiveData<Integer> mutableLiveData = this.mCurrentExtensionTypeLiveData;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(Integer.valueOf(this.mMode));
        }
        MutableLiveData<Integer> mutableLiveData2 = this.mExtensionStrengthLiveData;
        if (mutableLiveData2 != null) {
            mutableLiveData2.postValue(100);
        }
        return convertToCamera2SessionConfig(camera2SessionConfigImplInitSession);
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.extensions.CameraExtensionsInfo
    public boolean isCurrentExtensionModeAvailable() {
        return this.mVendorExtender.isCurrentExtensionModeAvailable();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.extensions.CameraExtensionsInfo
    public boolean isExtensionStrengthAvailable() {
        return this.mVendorExtender.isExtensionStrengthAvailable();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionEnd() {
        this.mImpl.onCaptureSessionEnd();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionStart(RequestProcessor requestProcessor) {
        this.mImpl.onCaptureSessionStart(new RequestProcessorImplAdapter(requestProcessor));
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.extensions.CameraExtensionsControl
    public void setExtensionStrength(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100) int i2) {
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter;
        HashMap map;
        if (!isExtensionStrengthAvailable() || Build.VERSION.SDK_INT < 34) {
            return;
        }
        synchronized (this.mLock) {
            this.mExtensionStrength = i2;
            this.mWorkingCaptureConfigMap.put(CaptureRequest.EXTENSION_STRENGTH, Integer.valueOf(this.mExtensionStrength));
            sessionProcessorImplCaptureCallbackAdapter = this.mRepeatingCaptureCallbackAdapter;
            map = (HashMap) this.mWorkingCaptureConfigMap.clone();
        }
        this.mImpl.setParameters(map);
        if (sessionProcessorImplCaptureCallbackAdapter != null) {
            this.mImpl.startRepeating(sessionProcessorImplCaptureCallbackAdapter);
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void setParameters(Config config) {
        HashMap<CaptureRequest.Key<?>, Object> mapConvertConfigToMap;
        synchronized (this.mLock) {
            try {
                mapConvertConfigToMap = convertConfigToMap(config);
                if (this.mExtensionStrength != -1 && Build.VERSION.SDK_INT >= 34) {
                    mapConvertConfigToMap.put(CaptureRequest.EXTENSION_STRENGTH, Integer.valueOf(this.mExtensionStrength));
                }
                this.mWorkingCaptureConfigMap = mapConvertConfigToMap;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mImpl.setParameters(mapConvertConfigToMap);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startCapture(boolean z2, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        Logger.d(TAG, "startCapture postviewEnabled = " + z2 + " mWillReceiveOnCaptureCompleted = " + this.mWillReceiveOnCaptureCompleted);
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter = new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mWillReceiveOnCaptureCompleted);
        Version version = Version.VERSION_1_4;
        return (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version) && this.mIsPostviewConfigured && z2 && this.mVendorExtender.isPostviewAvailable()) ? this.mImpl.startCaptureWithPostview(sessionProcessorImplCaptureCallbackAdapter) : this.mImpl.startCapture(sessionProcessorImplCaptureCallbackAdapter);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startRepeating(TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter;
        synchronized (this.mLock) {
            sessionProcessorImplCaptureCallbackAdapter = new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mExtensionMetadataMonitor, this.mWillReceiveOnCaptureCompleted);
            this.mRepeatingCaptureCallbackAdapter = sessionProcessorImplCaptureCallbackAdapter;
        }
        return this.mImpl.startRepeating(sessionProcessorImplCaptureCallbackAdapter);
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public int startTrigger(Config config, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        HashMap<CaptureRequest.Key<?>, Object> mapConvertConfigToMap = convertConfigToMap(config);
        Version version = Version.VERSION_1_3;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return this.mImpl.startTrigger(mapConvertConfigToMap, new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mWillReceiveOnCaptureCompleted));
        }
        return -1;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void stopRepeating() {
        this.mImpl.stopRepeating();
        synchronized (this.mLock) {
            this.mRepeatingCaptureCallbackAdapter = null;
        }
    }

    public AdvancedSessionProcessor(SessionProcessorImpl sessionProcessorImpl, List<CaptureRequest.Key<?>> list, VendorExtender vendorExtender, Context context, int i2) {
        super(list, i2);
        this.mIsPostviewConfigured = false;
        this.mWorkingCaptureConfigMap = new HashMap<>();
        this.mRepeatingCaptureCallbackAdapter = null;
        this.mImpl = sessionProcessorImpl;
        this.mVendorExtender = vendorExtender;
        this.mContext = context;
        this.mWillReceiveOnCaptureCompleted = vendorExtender.willReceiveOnCaptureCompleted();
        this.mMode = i2;
        MutableLiveData<Integer> mutableLiveData = isCurrentExtensionModeAvailable() ? new MutableLiveData<>(Integer.valueOf(i2)) : null;
        this.mCurrentExtensionTypeLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = isExtensionStrengthAvailable() ? new MutableLiveData<>(100) : null;
        this.mExtensionStrengthLiveData = mutableLiveData2;
        if (mutableLiveData == null && mutableLiveData2 == null) {
            this.mExtensionMetadataMonitor = null;
        } else {
            this.mExtensionMetadataMonitor = new ExtensionMetadataMonitor(mutableLiveData, mutableLiveData2);
        }
    }
}
