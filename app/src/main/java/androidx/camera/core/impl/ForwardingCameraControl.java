package androidx.camera.core.impl;

import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingCameraControl implements CameraControlInternal {
    private final CameraControlInternal mCameraControlInternal;

    public ForwardingCameraControl(CameraControlInternal cameraControlInternal) {
        this.mCameraControlInternal = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config config) {
        this.mCameraControlInternal.addInteropConfig(config);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder builder) {
        this.mCameraControlInternal.addZslConfig(builder);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q cancelFocusAndMetering() {
        return this.mCameraControlInternal.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.mCameraControlInternal.clearInteropConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearZslConfig() {
        this.mCameraControlInternal.clearZslConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void decrementVideoUsage() {
        this.mCameraControlInternal.decrementVideoUsage();
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q enableLowLightBoostAsync(boolean z2) {
        return this.mCameraControlInternal.enableLowLightBoostAsync(z2);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q enableTorch(boolean z2) {
        return this.mCameraControlInternal.enableTorch(z2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public j2.q getCameraCapturePipelineAsync(int i2, int i8) {
        return this.mCameraControlInternal.getCameraCapturePipelineAsync(i2, i8);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mCameraControlInternal.getFlashMode();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public CameraControlInternal getImplementation() {
        return this.mCameraControlInternal.getImplementation();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return this.mCameraControlInternal.getInteropConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public SessionConfig getSessionConfig() {
        return this.mCameraControlInternal.getSessionConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void incrementVideoUsage() {
        this.mCameraControlInternal.incrementVideoUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @VisibleForTesting
    public boolean isInVideoUsage() {
        return this.mCameraControlInternal.isInVideoUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mCameraControlInternal.isZslDisabledByByUserCaseConfig();
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setExposureCompensationIndex(int i2) {
        return this.mCameraControlInternal.setExposureCompensationIndex(i2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i2) {
        this.mCameraControlInternal.setFlashMode(i2);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setLinearZoom(float f4) {
        return this.mCameraControlInternal.setLinearZoom(f4);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final /* synthetic */ void setLowLightBoostDisabledByUseCaseSessionConfig(boolean z2) {
        CameraControlInternal.CC.f(this, z2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
        this.mCameraControlInternal.setScreenFlash(screenFlash);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setTorchStrengthLevel(@IntRange(from = 1) int i2) {
        return this.mCameraControlInternal.setTorchStrengthLevel(i2);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setZoomRatio(float f4) {
        return this.mCameraControlInternal.setZoomRatio(f4);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setZslDisabledByUserCaseConfig(boolean z2) {
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(z2);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return this.mCameraControlInternal.startFocusAndMetering(focusMeteringAction);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public j2.q submitStillCaptureRequests(List<CaptureConfig> list, int i2, int i8) {
        return this.mCameraControlInternal.submitStillCaptureRequests(list, i2, i8);
    }
}
