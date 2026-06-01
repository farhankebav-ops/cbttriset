package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.impl.utils.SessionProcessorUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AdapterCameraControl extends ForwardingCameraControl {
    private final CameraControlInternal mCameraControl;
    private final SessionProcessor mSessionProcessor;

    public AdapterCameraControl(CameraControlInternal cameraControlInternal, SessionProcessor sessionProcessor) {
        super(cameraControlInternal);
        this.mCameraControl = cameraControlInternal;
        this.mSessionProcessor = sessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q enableTorch(boolean z2) {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 6) ? Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported")) : this.mCameraControl.enableTorch(z2);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    public SessionProcessor getSessionProcessor() {
        return this.mSessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q setExposureCompensationIndex(int i2) {
        return !SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 7) ? Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported")) : this.mCameraControl.setExposureCompensationIndex(i2);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q setLinearZoom(float f4) {
        if (!SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        if (sessionProcessor == null) {
            return this.mCameraControl.setLinearZoom(f4);
        }
        Range<Float> extensionZoomRange = sessionProcessor.getExtensionZoomRange();
        if (extensionZoomRange == null) {
            return this.mCameraControl.setLinearZoom(f4);
        }
        if (f4 <= 1.0f && f4 >= 0.0f) {
            return this.mCameraControl.setZoomRatio(AdapterCameraInfo.getZoomRatioByPercentage(f4, ((Float) extensionZoomRange.getLower()).floatValue(), ((Float) extensionZoomRange.getUpper()).floatValue()));
        }
        return Futures.immediateFailedFuture(new IllegalArgumentException("Requested linearZoom " + f4 + " is not within valid range [0..1]"));
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q setZoomRatio(float f4) {
        Range<Float> extensionZoomRange;
        if (!SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, 0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        SessionProcessor sessionProcessor = this.mSessionProcessor;
        if (sessionProcessor == null || (extensionZoomRange = sessionProcessor.getExtensionZoomRange()) == null || (f4 >= ((Float) extensionZoomRange.getLower()).floatValue() && f4 <= ((Float) extensionZoomRange.getUpper()).floatValue())) {
            return this.mCameraControl.setZoomRatio(f4);
        }
        return Futures.immediateFailedFuture(new IllegalArgumentException("Requested zoomRatio " + f4 + " is not within valid range [" + extensionZoomRange.getLower() + " , " + extensionZoomRange.getUpper() + C2300e4.i.e));
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public j2.q startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = SessionProcessorUtil.getModifiedFocusMeteringAction(this.mSessionProcessor, focusMeteringAction);
        return modifiedFocusMeteringAction == null ? Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported")) : this.mCameraControl.startFocusAndMetering(modifiedFocusMeteringAction);
    }
}
