package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.z;
import androidx.camera.extensions.CameraExtensionsControl;
import androidx.camera.extensions.CameraExtensionsInfo;
import androidx.camera.extensions.internal.Camera2ExtensionsUtil;
import androidx.camera.extensions.internal.ExtensionsUtils;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
public final class Camera2ExtensionsSessionProcessor implements SessionProcessor, CameraExtensionsInfo, CameraExtensionsControl {
    private final List<CaptureRequest.Key<?>> availableCaptureRequestKeys;
    private final int camera2ExtensionMode;
    private CameraCaptureCallback cameraCaptureCallback;
    private CameraInfoInternal cameraInfoInternal;

    @GuardedBy("lock")
    private SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor;
    private final AtomicInteger currentExtensionType;
    private MutableLiveData<Integer> currentExtensionTypeLiveData;
    private final AtomicInteger extensionStrength;
    private MutableLiveData<Integer> extensionStrengthLiveData;
    private final Object lock;
    private final int mode;
    private final Set<Integer> supportedCameraOperations;
    private final VendorExtender vendorExtender;

    /* JADX WARN: Multi-variable type inference failed */
    public Camera2ExtensionsSessionProcessor(List<? extends CaptureRequest.Key<?>> availableCaptureRequestKeys, int i2, VendorExtender vendorExtender) {
        k.e(availableCaptureRequestKeys, "availableCaptureRequestKeys");
        k.e(vendorExtender, "vendorExtender");
        this.availableCaptureRequestKeys = availableCaptureRequestKeys;
        this.mode = i2;
        this.vendorExtender = vendorExtender;
        this.camera2ExtensionMode = Camera2ExtensionsUtil.INSTANCE.convertCameraXModeToCamera2Mode(i2);
        this.extensionStrength = new AtomicInteger(100);
        this.currentExtensionType = new AtomicInteger(i2);
        Set<Integer> supportedCameraOperations = ExtensionsUtils.getSupportedCameraOperations(availableCaptureRequestKeys);
        k.d(supportedCameraOperations, "getSupportedCameraOperations(...)");
        this.supportedCameraOperations = supportedCameraOperations;
        this.lock = new Object();
        if (isCurrentExtensionModeAvailable()) {
            this.currentExtensionTypeLiveData = new MutableLiveData<>(Integer.valueOf(i2));
        }
        if (isExtensionStrengthAvailable()) {
            this.extensionStrengthLiveData = new MutableLiveData<>(100);
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void abortCapture(int i2) {
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#abortCapture should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void deInitSession() {
        CameraCaptureCallback cameraCaptureCallback;
        CameraInfoInternal cameraInfoInternal = this.cameraInfoInternal;
        if (cameraInfoInternal == null || (cameraCaptureCallback = this.cameraCaptureCallback) == null) {
            return;
        }
        cameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public List<Pair<CameraCharacteristics.Key<?>, ? super Object>> getAvailableCharacteristicsKeyValues() {
        List<Pair<CameraCharacteristics.Key<?>, ? super Object>> availableCharacteristicsKeyValues = this.vendorExtender.getAvailableCharacteristicsKeyValues();
        k.d(availableCharacteristicsKeyValues, "getAvailableCharacteristicsKeyValues(...)");
        return availableCharacteristicsKeyValues;
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getCurrentExtensionMode() {
        return this.currentExtensionTypeLiveData;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int[] getExtensionAvailableStabilizationModes() {
        return z.b(this);
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public LiveData<Integer> getExtensionStrength() {
        return this.extensionStrengthLiveData;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public final /* synthetic */ Range getExtensionZoomRange() {
        return z.c(this);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Pair<Integer, Integer> getImplementationType() {
        Pair<Integer, Integer> pairCreate = Pair.create(1, Integer.valueOf(this.camera2ExtensionMode));
        k.d(pairCreate, "create(...)");
        return pairCreate;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Pair<Long, Long> getRealtimeCaptureLatency() {
        Pair<Long, Long> realtimeStillCaptureLatency;
        synchronized (this.lock) {
            SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor = this.captureSessionRequestProcessor;
            realtimeStillCaptureLatency = captureSessionRequestProcessor != null ? captureSessionRequestProcessor.getRealtimeStillCaptureLatency() : null;
        }
        return realtimeStillCaptureLatency;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Set<Integer> getSupportedCameraOperations() {
        return this.supportedCameraOperations;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public Map<Integer, List<Size>> getSupportedPostviewSize(Size captureSize) {
        k.e(captureSize, "captureSize");
        Map<Integer, List<Size>> supportedPostviewResolutions = this.vendorExtender.getSupportedPostviewResolutions(captureSize);
        k.d(supportedPostviewResolutions, "getSupportedPostviewResolutions(...)");
        return supportedPostviewResolutions;
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public SessionConfig initSession(CameraInfo cameraInfo, OutputSurfaceConfiguration outputSurfaceConfiguration) {
        k.e(cameraInfo, "cameraInfo");
        this.cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        this.cameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.extensions.internal.sessionprocessor.Camera2ExtensionsSessionProcessor.initSession.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(int i2, CameraCaptureResult cameraCaptureResult) {
                CaptureResult captureResult;
                Integer num;
                MutableLiveData mutableLiveData;
                CaptureResult captureResult2;
                Integer num2;
                MutableLiveData mutableLiveData2;
                k.e(cameraCaptureResult, "cameraCaptureResult");
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 34 && Camera2ExtensionsSessionProcessor.this.isCurrentExtensionModeAvailable() && (captureResult2 = cameraCaptureResult.getCaptureResult()) != null && (num2 = (Integer) captureResult2.get(CaptureResult.EXTENSION_CURRENT_TYPE)) != null) {
                    Camera2ExtensionsSessionProcessor camera2ExtensionsSessionProcessor = Camera2ExtensionsSessionProcessor.this;
                    int iIntValue = num2.intValue();
                    int iConvertCamera2ModeToCameraXMode = Camera2ExtensionsUtil.INSTANCE.convertCamera2ModeToCameraXMode(iIntValue);
                    if (camera2ExtensionsSessionProcessor.currentExtensionType.getAndSet(iConvertCamera2ModeToCameraXMode) != iConvertCamera2ModeToCameraXMode && (mutableLiveData2 = camera2ExtensionsSessionProcessor.extensionStrengthLiveData) != null) {
                        mutableLiveData2.postValue(Integer.valueOf(iIntValue));
                    }
                }
                if (i8 < 34 || !Camera2ExtensionsSessionProcessor.this.isExtensionStrengthAvailable() || (captureResult = cameraCaptureResult.getCaptureResult()) == null || (num = (Integer) captureResult.get(CaptureResult.EXTENSION_STRENGTH)) == null) {
                    return;
                }
                Camera2ExtensionsSessionProcessor camera2ExtensionsSessionProcessor2 = Camera2ExtensionsSessionProcessor.this;
                int iIntValue2 = num.intValue();
                if (camera2ExtensionsSessionProcessor2.extensionStrength.getAndSet(iIntValue2) == iIntValue2 || (mutableLiveData = camera2ExtensionsSessionProcessor2.extensionStrengthLiveData) == null) {
                    return;
                }
                mutableLiveData.postValue(Integer.valueOf(iIntValue2));
            }
        };
        CameraInfoInternal cameraInfoInternal = this.cameraInfoInternal;
        k.b(cameraInfoInternal);
        Executor executorDirectExecutor = CameraXExecutors.directExecutor();
        CameraCaptureCallback cameraCaptureCallback = this.cameraCaptureCallback;
        k.b(cameraCaptureCallback);
        cameraInfoInternal.addSessionCaptureCallback(executorDirectExecutor, cameraCaptureCallback);
        return null;
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public boolean isCurrentExtensionModeAvailable() {
        return this.vendorExtender.isCurrentExtensionModeAvailable();
    }

    @Override // androidx.camera.extensions.CameraExtensionsInfo
    public boolean isExtensionStrengthAvailable() {
        return this.vendorExtender.isExtensionStrengthAvailable();
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionEnd() {
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#onCaptureSessionEnd should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void onCaptureSessionStart(RequestProcessor requestProcessor) {
        k.e(requestProcessor, "requestProcessor");
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#onCaptureSessionStart should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void setCaptureSessionRequestProcessor(SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor) {
        synchronized (this.lock) {
            this.captureSessionRequestProcessor = captureSessionRequestProcessor;
        }
    }

    @Override // androidx.camera.extensions.CameraExtensionsControl
    public void setExtensionStrength(int i2) {
        synchronized (this.lock) {
            SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor = this.captureSessionRequestProcessor;
            if (captureSessionRequestProcessor != null) {
                captureSessionRequestProcessor.setExtensionStrength(i2);
            }
        }
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void setParameters(Config config) {
        k.e(config, "config");
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#setParameters should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startCapture(boolean z2, TagBundle tagBundle, SessionProcessor.CaptureCallback callback) {
        k.e(tagBundle, "tagBundle");
        k.e(callback, "callback");
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#startCapture should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public int startRepeating(TagBundle tagBundle, SessionProcessor.CaptureCallback callback) {
        k.e(tagBundle, "tagBundle");
        k.e(callback, "callback");
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#startRepeating should not be invoked!");
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public final /* synthetic */ int startTrigger(Config config, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        return z.i(this, config, tagBundle, captureCallback);
    }

    @Override // androidx.camera.core.impl.SessionProcessor
    public void stopRepeating() {
        throw new UnsupportedOperationException("Camera2ExtensionsSessionProcessor#stopRepeating should not be invoked!");
    }

    private static /* synthetic */ void getSupportedCameraOperations$annotations() {
    }
}
