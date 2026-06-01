package androidx.camera.extensions.internal.sessionprocessor;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.GuardedBy;
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
import androidx.camera.core.impl.x;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import androidx.camera.extensions.impl.RequestUpdateProcessorImpl;
import androidx.camera.extensions.internal.Camera2CameraCaptureResult;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.compat.workaround.OnEnableDisableSessionDurationCheck;
import androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor;
import androidx.camera.extensions.internal.sessionprocessor.RequestBuilder;
import androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class BasicExtenderSessionProcessor extends SessionProcessorBase {
    private static final long INVALID_TIMESTAMP = -1;
    private static final int PREVIEW_PROCESS_MAX_IMAGES = 2;
    private static final String TAG = "BasicSessionProcessor";
    static AtomicInteger sLastOutputConfigId = new AtomicInteger(0);
    private volatile Camera2OutputConfig mAnalysisOutputConfig;
    private volatile Camera2OutputConfig mCaptureOutputConfig;
    private volatile OutputSurface mCaptureOutputSurface;
    private final Context mContext;
    private final ImageCaptureExtenderImpl mImageCaptureExtenderImpl;
    volatile boolean mIsCapturing;
    private final AtomicInteger mNextCaptureSequenceId;
    private OnEnableDisableSessionDurationCheck mOnEnableDisableSessionDurationCheck;

    @GuardedBy("mLock")
    private final Map<CaptureRequest.Key<?>, Object> mParameters;
    private OutputSurface mPostviewOutputSurface;
    private final PreviewExtenderImpl mPreviewExtenderImpl;
    private volatile Camera2OutputConfig mPreviewOutputConfig;
    private volatile OutputSurface mPreviewOutputSurface;
    volatile PreviewProcessor mPreviewProcessor;

    @GuardedBy("mLock")
    private final Map<Integer, Long> mRequestCompletedTimestampMap;
    private volatile RequestProcessor mRequestProcessor;
    volatile RequestUpdateProcessorImpl mRequestUpdateProcessor;
    volatile StillCaptureProcessor mStillCaptureProcessor;
    private final VendorExtender mVendorExtender;
    private final boolean mWillReceiveOnCaptureCompleted;

    public BasicExtenderSessionProcessor(PreviewExtenderImpl previewExtenderImpl, ImageCaptureExtenderImpl imageCaptureExtenderImpl, List<CaptureRequest.Key<?>> list, VendorExtender vendorExtender, Context context, int i2) {
        super(list, i2);
        this.mStillCaptureProcessor = null;
        this.mPreviewProcessor = null;
        this.mRequestUpdateProcessor = null;
        this.mAnalysisOutputConfig = null;
        this.mIsCapturing = false;
        this.mNextCaptureSequenceId = new AtomicInteger(0);
        this.mParameters = new LinkedHashMap();
        this.mRequestCompletedTimestampMap = new HashMap();
        this.mOnEnableDisableSessionDurationCheck = new OnEnableDisableSessionDurationCheck();
        this.mPreviewExtenderImpl = previewExtenderImpl;
        this.mImageCaptureExtenderImpl = imageCaptureExtenderImpl;
        this.mContext = context;
        this.mVendorExtender = vendorExtender;
        this.mWillReceiveOnCaptureCompleted = vendorExtender.willReceiveOnCaptureCompleted();
    }

    private void applyParameters(RequestBuilder requestBuilder) {
        synchronized (this.mLock) {
            try {
                for (CaptureRequest.Key<?> key : this.mParameters.keySet()) {
                    Object obj = this.mParameters.get(key);
                    if (obj != null) {
                        requestBuilder.setParameters(key, obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void applyPreviewStagesParameters(RequestBuilder requestBuilder) {
        CaptureStageImpl captureStage = this.mPreviewExtenderImpl.getCaptureStage();
        if (captureStage != null) {
            for (Pair pair : captureStage.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getRequestCompletedTimestamp(int i2) {
        synchronized (this.mLock) {
            try {
                Long l = this.mRequestCompletedTimestampMap.get(Integer.valueOf(i2));
                if (l == null) {
                    return -1L;
                }
                this.mRequestCompletedTimestampMap.remove(Integer.valueOf(i2));
                return l.longValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRepeating$0(SessionProcessor.CaptureCallback captureCallback, int i2, TagBundle tagBundle, long j, List list) {
        captureCallback.onCaptureCompleted(j, i2, new KeyValueMapCameraCaptureResult(j, tagBundle, getCaptureResultKeyMapFromList(list)));
    }

    private void submitRequestByCaptureStages(RequestProcessor requestProcessor, List<CaptureStageImpl> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureStageImpl captureStageImpl : list) {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
            if (this.mAnalysisOutputConfig != null) {
                requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
            }
            for (Pair pair : captureStageImpl.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
            requestBuilder.setTemplateId(1);
            arrayList.add(requestBuilder.build());
        }
        requestProcessor.submit(arrayList, new RequestProcessor.Callback() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.2
            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i2) {
                x.a(this, request, j, i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                x.b(this, request, cameraCaptureResult);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                x.c(this, request, cameraCaptureFailure);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                x.d(this, request, cameraCaptureResult);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceAborted(int i2) {
                x.e(this, i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceCompleted(int i2, long j) {
                x.f(this, i2, j);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j3) {
                x.g(this, request, j, j3);
            }
        });
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void abortCapture(int i2) {
        this.mRequestProcessor.abortCaptures();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase
    public void deInitSessionInternal() {
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.close();
            this.mPreviewProcessor = null;
        }
        if (this.mStillCaptureProcessor != null) {
            this.mStillCaptureProcessor.close();
            this.mStillCaptureProcessor = null;
        }
        Logger.d(TAG, "preview onDeInit");
        this.mPreviewExtenderImpl.onDeInit();
        Logger.d(TAG, "capture onDeInit");
        this.mImageCaptureExtenderImpl.onDeInit();
    }

    public Map<CaptureResult.Key, Object> getCaptureResultKeyMapFromList(List<Pair<CaptureResult.Key, Object>> list) {
        HashMap map = new HashMap();
        for (Pair<CaptureResult.Key, Object> pair : list) {
            map.put((CaptureResult.Key) pair.first, pair.second);
        }
        return map;
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public /* bridge */ /* synthetic */ Pair getImplementationType() {
        return super.getImplementationType();
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public Pair<Long, Long> getRealtimeCaptureLatency() {
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return this.mImageCaptureExtenderImpl.getRealtimeCaptureLatency();
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
        Logger.d(TAG, "PreviewExtenderImpl.onInit");
        this.mPreviewExtenderImpl.onInit(str, map.get(str), this.mContext);
        Logger.d(TAG, "ImageCaptureExtenderImpl.onInit");
        this.mImageCaptureExtenderImpl.onInit(str, map.get(str), this.mContext);
        this.mPreviewOutputSurface = outputSurfaceConfiguration.getPreviewOutputSurface();
        this.mCaptureOutputSurface = outputSurfaceConfiguration.getImageCaptureOutputSurface();
        this.mPostviewOutputSurface = outputSurfaceConfiguration.getPostviewOutputSurface();
        PreviewExtenderImpl.ProcessorType processorType = this.mPreviewExtenderImpl.getProcessorType();
        Logger.d(TAG, "preview processorType=" + processorType);
        if (processorType == PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_IMAGE_PROCESSOR) {
            this.mPreviewOutputConfig = ImageReaderOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSize(), 35, 2);
            this.mPreviewProcessor = new PreviewProcessor(this.mPreviewExtenderImpl.getProcessor(), this.mPreviewOutputSurface.getSurface(), this.mPreviewOutputSurface.getSize());
        } else if (processorType == PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_REQUEST_UPDATE_ONLY) {
            this.mPreviewOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSurface());
            this.mRequestUpdateProcessor = this.mPreviewExtenderImpl.getProcessor();
        } else {
            this.mPreviewOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSurface());
        }
        CaptureProcessorImpl captureProcessor = this.mImageCaptureExtenderImpl.getCaptureProcessor();
        Logger.d(TAG, "CaptureProcessor=" + captureProcessor);
        if (captureProcessor != null) {
            this.mCaptureOutputConfig = ImageReaderOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mCaptureOutputSurface.getSize(), 35, this.mImageCaptureExtenderImpl.getMaxCaptureStage());
            this.mStillCaptureProcessor = new StillCaptureProcessor(captureProcessor, this.mCaptureOutputSurface.getSurface(), this.mCaptureOutputSurface.getSize(), this.mPostviewOutputSurface, !this.mWillReceiveOnCaptureCompleted);
        } else {
            this.mCaptureOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mCaptureOutputSurface.getSurface());
        }
        if (outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null) {
            this.mAnalysisOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), outputSurfaceConfiguration.getImageAnalysisOutputSurface().getSurface());
        }
        Camera2SessionConfigBuilder sessionTemplateId = new Camera2SessionConfigBuilder().addOutputConfig(this.mPreviewOutputConfig).addOutputConfig(this.mCaptureOutputConfig).setSessionTemplateId(1);
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            int iOnSessionType = this.mPreviewExtenderImpl.onSessionType();
            Preconditions.checkArgument(iOnSessionType == this.mImageCaptureExtenderImpl.onSessionType(), "Needs same session type in both PreviewExtenderImpl and ImageCaptureExtenderImpl");
            if (iOnSessionType == -1) {
                iOnSessionType = 0;
            }
            sessionTemplateId.setSessionType(iOnSessionType);
        }
        if (this.mAnalysisOutputConfig != null) {
            sessionTemplateId.addOutputConfig(this.mAnalysisOutputConfig);
        }
        CaptureStageImpl captureStageImplOnPresetSession = this.mPreviewExtenderImpl.onPresetSession();
        Logger.d(TAG, "preview onPresetSession:" + captureStageImplOnPresetSession);
        CaptureStageImpl captureStageImplOnPresetSession2 = this.mImageCaptureExtenderImpl.onPresetSession();
        Logger.d(TAG, "capture onPresetSession:" + captureStageImplOnPresetSession2);
        if (captureStageImplOnPresetSession != null && captureStageImplOnPresetSession.getParameters() != null) {
            for (Pair pair : captureStageImplOnPresetSession.getParameters()) {
                sessionTemplateId.addSessionParameter((CaptureRequest.Key) pair.first, pair.second);
            }
        }
        if (captureStageImplOnPresetSession2 != null && captureStageImplOnPresetSession2.getParameters() != null) {
            for (Pair pair2 : captureStageImplOnPresetSession2.getParameters()) {
                sessionTemplateId.addSessionParameter((CaptureRequest.Key) pair2.first, pair2.second);
            }
        }
        return sessionTemplateId.build();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionEnd() {
        this.mOnEnableDisableSessionDurationCheck.onDisableSessionInvoked();
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.pause();
        }
        ArrayList arrayList = new ArrayList();
        CaptureStageImpl captureStageImplOnDisableSession = this.mPreviewExtenderImpl.onDisableSession();
        Logger.d(TAG, "preview onDisableSession: " + captureStageImplOnDisableSession);
        if (captureStageImplOnDisableSession != null) {
            arrayList.add(captureStageImplOnDisableSession);
        }
        CaptureStageImpl captureStageImplOnDisableSession2 = this.mImageCaptureExtenderImpl.onDisableSession();
        Logger.d(TAG, "capture onDisableSession:" + captureStageImplOnDisableSession2);
        if (captureStageImplOnDisableSession2 != null) {
            arrayList.add(captureStageImplOnDisableSession2);
        }
        if (!arrayList.isEmpty()) {
            submitRequestByCaptureStages(this.mRequestProcessor, arrayList);
        }
        this.mRequestProcessor = null;
        this.mIsCapturing = false;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionStart(RequestProcessor requestProcessor) {
        this.mRequestProcessor = requestProcessor;
        ArrayList arrayList = new ArrayList();
        CaptureStageImpl captureStageImplOnEnableSession = this.mPreviewExtenderImpl.onEnableSession();
        Logger.d(TAG, "preview onEnableSession: " + captureStageImplOnEnableSession);
        if (captureStageImplOnEnableSession != null) {
            arrayList.add(captureStageImplOnEnableSession);
        }
        CaptureStageImpl captureStageImplOnEnableSession2 = this.mImageCaptureExtenderImpl.onEnableSession();
        Logger.d(TAG, "capture onEnableSession:" + captureStageImplOnEnableSession2);
        if (captureStageImplOnEnableSession2 != null) {
            arrayList.add(captureStageImplOnEnableSession2);
        }
        this.mOnEnableDisableSessionDurationCheck.onEnableSessionInvoked();
        if (!arrayList.isEmpty()) {
            submitRequestByCaptureStages(requestProcessor, arrayList);
        }
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.resume();
            setImageProcessor(this.mPreviewOutputConfig.getId(), new ImageProcessor() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.1
                @Override // androidx.camera.extensions.internal.sessionprocessor.ImageProcessor
                public void onNextImageAvailable(int i2, long j, ImageReference imageReference, String str) {
                    if (BasicExtenderSessionProcessor.this.mPreviewProcessor != null) {
                        BasicExtenderSessionProcessor.this.mPreviewProcessor.notifyImage(imageReference);
                    } else {
                        imageReference.decrement();
                    }
                }
            });
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void setParameters(Config config) {
        synchronized (this.mLock) {
            try {
                HashMap map = new HashMap();
                RequestOptionConfig requestOptionConfigBuild = RequestOptionConfig.Builder.from(config).build();
                requestOptionConfigBuild.getClass();
                for (Config.Option option : w.e(requestOptionConfigBuild)) {
                    map.put((CaptureRequest.Key) option.getToken(), w.f(requestOptionConfigBuild, option));
                }
                this.mParameters.clear();
                this.mParameters.putAll(map);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startCapture(boolean z2, final TagBundle tagBundle, final SessionProcessor.CaptureCallback captureCallback) {
        Logger.d(TAG, "startCapture postviewEnabled = " + z2 + " mWillReceiveOnCaptureCompleted = " + this.mWillReceiveOnCaptureCompleted);
        final int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        if (this.mRequestProcessor == null || this.mIsCapturing) {
            Logger.d(TAG, "startCapture failed");
            captureCallback.onCaptureFailed(andIncrement);
            captureCallback.onCaptureSequenceAborted(andIncrement);
            return andIncrement;
        }
        this.mIsCapturing = true;
        ArrayList arrayList = new ArrayList();
        List<CaptureStageImpl> captureStages = this.mImageCaptureExtenderImpl.getCaptureStages();
        ArrayList arrayList2 = new ArrayList();
        for (CaptureStageImpl captureStageImpl : captureStages) {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.addTargetOutputConfigIds(this.mCaptureOutputConfig.getId());
            requestBuilder.setTemplateId(2);
            requestBuilder.setCaptureStageId(captureStageImpl.getId());
            arrayList2.add(Integer.valueOf(captureStageImpl.getId()));
            applyParameters(requestBuilder);
            applyPreviewStagesParameters(requestBuilder);
            for (Pair pair : captureStageImpl.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
            arrayList.add(requestBuilder.build());
        }
        Logger.d(TAG, "Wait for capture stage id: " + arrayList2);
        RequestProcessor.Callback callback = new RequestProcessor.Callback() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.4
            boolean mIsCaptureFailed = false;
            boolean mIsCaptureStarted = false;

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i2) {
                x.a(this, request, j, i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
                Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "Cannot get capture TotalCaptureResult from the cameraCaptureResult ");
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) captureResult;
                RequestBuilder.RequestProcessorRequest requestProcessorRequest = (RequestBuilder.RequestProcessorRequest) request;
                if (BasicExtenderSessionProcessor.this.mStillCaptureProcessor != null) {
                    synchronized (BasicExtenderSessionProcessor.this.mLock) {
                        try {
                            if (!BasicExtenderSessionProcessor.this.mRequestCompletedTimestampMap.containsKey(Integer.valueOf(andIncrement))) {
                                BasicExtenderSessionProcessor.this.mRequestCompletedTimestampMap.put(Integer.valueOf(andIncrement), Long.valueOf(cameraCaptureResult.getTimestamp()));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    BasicExtenderSessionProcessor.this.mStillCaptureProcessor.notifyCaptureResult(totalCaptureResult, requestProcessorRequest.getCaptureStageId());
                    return;
                }
                BasicExtenderSessionProcessor.this.mIsCapturing = false;
                if (BasicExtenderSessionProcessor.this.mRequestProcessor == null) {
                    captureCallback.onCaptureSequenceAborted(andIncrement);
                    return;
                }
                captureCallback.onCaptureProcessStarted(andIncrement);
                captureCallback.onCaptureCompleted(cameraCaptureResult.getTimestamp(), andIncrement, new Camera2CameraCaptureResult(tagBundle, cameraCaptureResult.getCaptureResult()));
                captureCallback.onCaptureSequenceCompleted(andIncrement);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                if (this.mIsCaptureFailed) {
                    return;
                }
                this.mIsCaptureFailed = true;
                captureCallback.onCaptureFailed(andIncrement);
                captureCallback.onCaptureSequenceAborted(andIncrement);
                BasicExtenderSessionProcessor.this.mIsCapturing = false;
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                x.d(this, request, cameraCaptureResult);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureSequenceAborted(int i2) {
                captureCallback.onCaptureSequenceAborted(andIncrement);
                BasicExtenderSessionProcessor.this.mIsCapturing = false;
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceCompleted(int i2, long j) {
                x.f(this, i2, j);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureStarted(RequestProcessor.Request request, long j, long j3) {
                if (this.mIsCaptureStarted) {
                    return;
                }
                this.mIsCaptureStarted = true;
                captureCallback.onCaptureStarted(andIncrement, j3);
            }
        };
        Logger.d(TAG, "startCapture");
        if (this.mStillCaptureProcessor != null) {
            setImageProcessor(this.mCaptureOutputConfig.getId(), new ImageProcessor() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.5
                boolean mIsFirstFrame = true;

                @Override // androidx.camera.extensions.internal.sessionprocessor.ImageProcessor
                public void onNextImageAvailable(int i2, long j, ImageReference imageReference, String str) {
                    Logger.d(BasicExtenderSessionProcessor.TAG, "onNextImageAvailable  outputStreamId=" + i2);
                    if (BasicExtenderSessionProcessor.this.mStillCaptureProcessor != null) {
                        BasicExtenderSessionProcessor.this.mStillCaptureProcessor.notifyImage(imageReference);
                    } else {
                        imageReference.decrement();
                    }
                    if (this.mIsFirstFrame) {
                        captureCallback.onCaptureProcessStarted(andIncrement);
                        this.mIsFirstFrame = false;
                    }
                }
            });
            this.mStillCaptureProcessor.startCapture(z2, arrayList2, new StillCaptureProcessor.OnCaptureResultCallback() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.6
                @Override // androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback
                public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                    if (BasicExtenderSessionProcessor.this.mWillReceiveOnCaptureCompleted) {
                        captureCallback.onCaptureCompleted(j, andIncrement, new KeyValueMapCameraCaptureResult(j, tagBundle, BasicExtenderSessionProcessor.this.getCaptureResultKeyMapFromList(list)));
                        captureCallback.onCaptureSequenceCompleted(andIncrement);
                    }
                }

                @Override // androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback
                public void onCaptureProcessProgressed(int i2) {
                    captureCallback.onCaptureProcessProgressed(i2);
                }

                @Override // androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback
                public void onError(Exception exc) {
                    captureCallback.onCaptureFailed(andIncrement);
                    BasicExtenderSessionProcessor.this.mIsCapturing = false;
                }

                @Override // androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback
                public void onProcessCompleted() {
                    if (!BasicExtenderSessionProcessor.this.mWillReceiveOnCaptureCompleted) {
                        long requestCompletedTimestamp = BasicExtenderSessionProcessor.this.getRequestCompletedTimestamp(andIncrement);
                        if (requestCompletedTimestamp == -1) {
                            Logger.e(BasicExtenderSessionProcessor.TAG, "Cannot get timestamp for the capture result");
                            captureCallback.onCaptureFailed(andIncrement);
                            captureCallback.onCaptureSequenceAborted(andIncrement);
                            BasicExtenderSessionProcessor.this.mIsCapturing = false;
                            return;
                        }
                        captureCallback.onCaptureCompleted(requestCompletedTimestamp, andIncrement, new KeyValueMapCameraCaptureResult(requestCompletedTimestamp, tagBundle, Collections.EMPTY_MAP));
                        captureCallback.onCaptureSequenceCompleted(andIncrement);
                    }
                    BasicExtenderSessionProcessor.this.mIsCapturing = false;
                }
            });
        }
        this.mRequestProcessor.submit(arrayList, callback);
        return andIncrement;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startRepeating(final TagBundle tagBundle, final SessionProcessor.CaptureCallback captureCallback) {
        final int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        if (this.mRequestProcessor == null) {
            captureCallback.onCaptureFailed(andIncrement);
            captureCallback.onCaptureSequenceAborted(andIncrement);
            return andIncrement;
        }
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.start(new PreviewProcessor.OnCaptureResultCallback() { // from class: androidx.camera.extensions.internal.sessionprocessor.a
                @Override // androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor.OnCaptureResultCallback
                public final void onCaptureResult(long j, List list) {
                    this.f3768a.lambda$startRepeating$0(captureCallback, andIncrement, tagBundle, j, list);
                }
            });
        }
        updateRepeating(andIncrement, captureCallback);
        return andIncrement;
    }

    @Override // androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase, androidx.camera.core.impl.SessionProcessor
    public int startTrigger(Config config, final TagBundle tagBundle, final SessionProcessor.CaptureCallback captureCallback) {
        Logger.d(TAG, "startTrigger");
        final int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
        if (this.mAnalysisOutputConfig != null) {
            requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
        }
        requestBuilder.setTemplateId(1);
        applyParameters(requestBuilder);
        applyPreviewStagesParameters(requestBuilder);
        RequestOptionConfig requestOptionConfigBuild = RequestOptionConfig.Builder.from(config).build();
        requestOptionConfigBuild.getClass();
        for (Config.Option option : w.e(requestOptionConfigBuild)) {
            requestBuilder.setParameters((CaptureRequest.Key) option.getToken(), w.f(requestOptionConfigBuild, option));
        }
        this.mRequestProcessor.submit(requestBuilder.build(), new RequestProcessor.Callback() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.7
            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i2) {
                x.a(this, request, j, i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                captureCallback.onCaptureCompleted(cameraCaptureResult.getTimestamp(), andIncrement, new Camera2CameraCaptureResult(tagBundle, cameraCaptureResult.getCaptureResult()));
                captureCallback.onCaptureSequenceCompleted(andIncrement);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                captureCallback.onCaptureFailed(andIncrement);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                x.d(this, request, cameraCaptureResult);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceAborted(int i2) {
                x.e(this, i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceCompleted(int i2, long j) {
                x.f(this, i2, j);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j3) {
                x.g(this, request, j, j3);
            }
        });
        return andIncrement;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void stopRepeating() {
        this.mRequestProcessor.stopRepeating();
    }

    public void updateRepeating(final int i2, final SessionProcessor.CaptureCallback captureCallback) {
        if (this.mRequestProcessor == null) {
            Logger.d(TAG, "mRequestProcessor is null, ignore repeating request");
            return;
        }
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
        if (this.mAnalysisOutputConfig != null) {
            requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
        }
        requestBuilder.setTemplateId(1);
        applyParameters(requestBuilder);
        applyPreviewStagesParameters(requestBuilder);
        RequestProcessor.Callback callback = new RequestProcessor.Callback() { // from class: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.3
            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i8) {
                x.a(this, request, j, i8);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                Long l;
                CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
                Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "Cannot get TotalCaptureResult from the cameraCaptureResult ");
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) captureResult;
                if (BasicExtenderSessionProcessor.this.mPreviewProcessor != null) {
                    BasicExtenderSessionProcessor.this.mPreviewProcessor.notifyCaptureResult(totalCaptureResult);
                } else {
                    Version version = Version.VERSION_1_3;
                    if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version) && (l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)) != null) {
                        captureCallback.onCaptureCompleted(l.longValue(), i2, new Camera2CameraCaptureResult(totalCaptureResult));
                    }
                }
                if (BasicExtenderSessionProcessor.this.mRequestUpdateProcessor != null && BasicExtenderSessionProcessor.this.mRequestUpdateProcessor.process(totalCaptureResult) != null) {
                    BasicExtenderSessionProcessor.this.updateRepeating(i2, captureCallback);
                }
                captureCallback.onCaptureSequenceCompleted(i2);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                x.c(this, request, cameraCaptureFailure);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                x.d(this, request, cameraCaptureResult);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceAborted(int i8) {
                x.e(this, i8);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureSequenceCompleted(int i8, long j) {
                x.f(this, i8, j);
            }

            @Override // androidx.camera.core.impl.RequestProcessor.Callback
            public final /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j3) {
                x.g(this, request, j, j3);
            }
        };
        Logger.d(TAG, "requestProcessor setRepeating");
        this.mRequestProcessor.setRepeating(requestBuilder.build(), callback);
    }
}
