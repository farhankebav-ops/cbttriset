package androidx.camera.core.impl;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.UseCase;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.LiveDataUtil;
import androidx.camera.core.impl.utils.SessionProcessorUtil;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.core.math.MathUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AdapterCameraInfo extends ForwardingCameraInfo {
    public static final int CAMERA_OPERATION_AE_REGION = 3;
    public static final int CAMERA_OPERATION_AF_REGION = 2;
    public static final int CAMERA_OPERATION_AUTO_FOCUS = 1;
    public static final int CAMERA_OPERATION_AWB_REGION = 4;
    public static final int CAMERA_OPERATION_EXPOSURE_COMPENSATION = 7;
    public static final int CAMERA_OPERATION_EXTENSION_STRENGTH = 8;
    public static final int CAMERA_OPERATION_FLASH = 5;
    public static final int CAMERA_OPERATION_TORCH = 6;
    public static final int CAMERA_OPERATION_ZOOM = 0;
    private final CameraConfig mCameraConfig;
    private final CameraInfoInternal mCameraInfo;
    private LiveData<ZoomState> mExtensionZoomStateLiveData;
    private boolean mIsCaptureProcessProgressSupported;
    private boolean mIsPostviewSupported;
    private final SessionProcessor mSessionProcessor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraOperation {
    }

    public AdapterCameraInfo(CameraInfoInternal cameraInfoInternal, CameraConfig cameraConfig) {
        super(cameraInfoInternal);
        this.mIsPostviewSupported = false;
        this.mIsCaptureProcessProgressSupported = false;
        this.mExtensionZoomStateLiveData = null;
        this.mCameraInfo = cameraInfoInternal;
        this.mCameraConfig = cameraConfig;
        this.mSessionProcessor = cameraConfig.getSessionProcessor(null);
        setPostviewSupported(cameraConfig.isPostviewSupported());
        setCaptureProcessProgressSupported(cameraConfig.isCaptureProcessProgressSupported());
    }

    public static float getPercentageByRatio(float f4, float f8, float f9) {
        if (f9 == f8) {
            return 0.0f;
        }
        if (f4 == f9) {
            return 1.0f;
        }
        if (f4 == f8) {
            return 0.0f;
        }
        float f10 = 1.0f / f8;
        return ((1.0f / f4) - f10) / ((1.0f / f9) - f10);
    }

    public static float getZoomRatioByPercentage(float f4, float f8, float f9) {
        if (f4 == 1.0f) {
            return f9;
        }
        if (f4 == 0.0f) {
            return f8;
        }
        double d8 = 1.0f / f8;
        return (float) MathUtils.clamp(1.0d / (((((double) (1.0f / f9)) - d8) * ((double) f4)) + d8), f8, f9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ZoomState lambda$getZoomState$0(Range range, ZoomState zoomState) {
        return ImmutableZoomState.create(zoomState.getZoomRatio(), ((Float) range.getUpper()).floatValue(), ((Float) range.getLower()).floatValue(), getPercentageByRatio(zoomState.getZoomRatio(), ((Float) range.getLower()).floatValue(), ((Float) range.getUpper()).floatValue()));
    }

    public CameraConfig getCameraConfig() {
        return this.mCameraConfig;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 7) ? new ExposureState() { // from class: androidx.camera.core.impl.AdapterCameraInfo.1
            @Override // androidx.camera.core.ExposureState
            public int getExposureCompensationIndex() {
                return 0;
            }

            @Override // androidx.camera.core.ExposureState
            public Range<Integer> getExposureCompensationRange() {
                return new Range<>(0, 0);
            }

            @Override // androidx.camera.core.ExposureState
            public Rational getExposureCompensationStep() {
                return Rational.ZERO;
            }

            @Override // androidx.camera.core.ExposureState
            public boolean isExposureCompensationSupported() {
                return false;
            }
        } : this.mCameraInfo.getExposureState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }

    public SessionProcessor getSessionProcessor() {
        return this.mSessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 6) ? new MutableLiveData(0) : this.mCameraInfo.getTorchState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        if (!SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 0)) {
            return new MutableLiveData(ImmutableZoomState.create(1.0f, 1.0f, 1.0f, 0.0f));
        }
        if (this.mSessionProcessor != null) {
            ZoomState value = this.mCameraInfo.getZoomState().getValue();
            Range<Float> extensionZoomRange = this.mSessionProcessor.getExtensionZoomRange();
            if (extensionZoomRange != null && (((Float) extensionZoomRange.getLower()).floatValue() != value.getMinZoomRatio() || ((Float) extensionZoomRange.getUpper()).floatValue() != value.getMaxZoomRatio())) {
                if (this.mExtensionZoomStateLiveData == null) {
                    this.mExtensionZoomStateLiveData = LiveDataUtil.map(this.mCameraInfo.getZoomState(), new b(extensionZoomRange, 0));
                }
                return this.mExtensionZoomStateLiveData;
            }
        }
        return this.mCameraInfo.getZoomState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 5)) {
            return this.mCameraInfo.hasFlashUnit();
        }
        return false;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isCaptureProcessProgressSupported() {
        return this.mIsCaptureProcessProgressSupported;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = SessionProcessorUtil.getModifiedFocusMeteringAction(this.mSessionProcessor, focusMeteringAction);
        if (modifiedFocusMeteringAction == null) {
            return false;
        }
        return this.mCameraInfo.isFocusMeteringSupported(modifiedFocusMeteringAction);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isPostviewSupported() {
        return this.mIsPostviewSupported;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isPreviewStabilizationSupported() {
        int[] extensionAvailableStabilizationModes;
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        if (sessionProcessor == null || (extensionAvailableStabilizationModes = sessionProcessor.getExtensionAvailableStabilizationModes()) == null) {
            return super.isPreviewStabilizationSupported();
        }
        for (int i2 : extensionAvailableStabilizationModes) {
            if (i2 == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isUseCaseCombinationSupported(List<UseCase> list, int i2, boolean z2) {
        return this.mCameraInfo.isUseCaseCombinationSupported(list, i2, z2, this.mCameraConfig);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isVideoStabilizationSupported() {
        int[] extensionAvailableStabilizationModes;
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        if (sessionProcessor == null || (extensionAvailableStabilizationModes = sessionProcessor.getExtensionAvailableStabilizationModes()) == null) {
            return super.isVideoStabilizationSupported();
        }
        for (int i2 : extensionAvailableStabilizationModes) {
            if (i2 == 1) {
                return true;
            }
        }
        return false;
    }

    public void setCaptureProcessProgressSupported(boolean z2) {
        this.mIsCaptureProcessProgressSupported = z2;
    }

    public void setPostviewSupported(boolean z2) {
        this.mIsPostviewSupported = z2;
    }
}
