package androidx.camera.core.impl;

import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() { // from class: androidx.camera.core.impl.CameraControlInternal.2
        @Override // androidx.camera.core.CameraControl
        public j2.q cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ void decrementVideoUsage() {
            CC.a(this);
        }

        @Override // androidx.camera.core.CameraControl
        public final /* synthetic */ j2.q enableLowLightBoostAsync(boolean z2) {
            return androidx.camera.core.d.a(this, z2);
        }

        @Override // androidx.camera.core.CameraControl
        public j2.q enableTorch(boolean z2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ j2.q getCameraCapturePipelineAsync(int i2, int i8) {
            return CC.b(this, i2, i8);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public int getFlashMode() {
            return 2;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ CameraControlInternal getImplementation() {
            return CC.c(this);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public Config getInteropConfig() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public SessionConfig getSessionConfig() {
            return SessionConfig.defaultEmptySessionConfig();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ void incrementVideoUsage() {
            CC.d(this);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ boolean isInVideoUsage() {
            return CC.e(this);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public boolean isZslDisabledByByUserCaseConfig() {
            return false;
        }

        @Override // androidx.camera.core.CameraControl
        public j2.q setExposureCompensationIndex(int i2) {
            return Futures.immediateFuture(0);
        }

        @Override // androidx.camera.core.CameraControl
        public j2.q setLinearZoom(float f4) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ void setLowLightBoostDisabledByUseCaseSessionConfig(boolean z2) {
            CC.f(this, z2);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public final /* synthetic */ void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
            CC.g(this, screenFlash);
        }

        @Override // androidx.camera.core.CameraControl
        public final /* synthetic */ j2.q setTorchStrengthLevel(int i2) {
            return androidx.camera.core.d.b(this, i2);
        }

        @Override // androidx.camera.core.CameraControl
        public j2.q setZoomRatio(float f4) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        public j2.q startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public j2.q submitStillCaptureRequests(List<CaptureConfig> list, int i2, int i8) {
            return Futures.immediateFuture(Collections.EMPTY_LIST);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void clearInteropConfig() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void clearZslConfig() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void addInteropConfig(Config config) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void addZslConfig(SessionConfig.Builder builder) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setFlashMode(int i2) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setZslDisabledByUserCaseConfig(boolean z2) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(Config config);

    void addZslConfig(SessionConfig.Builder builder);

    void clearInteropConfig();

    void clearZslConfig();

    void decrementVideoUsage();

    j2.q getCameraCapturePipelineAsync(int i2, int i8);

    int getFlashMode();

    CameraControlInternal getImplementation();

    Config getInteropConfig();

    SessionConfig getSessionConfig();

    void incrementVideoUsage();

    @VisibleForTesting
    boolean isInVideoUsage();

    boolean isZslDisabledByByUserCaseConfig();

    void setFlashMode(int i2);

    void setLowLightBoostDisabledByUseCaseSessionConfig(boolean z2);

    void setScreenFlash(ImageCapture.ScreenFlash screenFlash);

    void setZslDisabledByUserCaseConfig(boolean z2);

    j2.q submitStillCaptureRequests(List<CaptureConfig> list, int i2, int i8);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CameraControlException extends Exception {
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure, Throwable th) {
            super(th);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraControlInternal$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public abstract /* synthetic */ class CC {
        public static j2.q b(final CameraControlInternal cameraControlInternal, int i2, int i8) {
            return Futures.immediateFuture(new CameraCapturePipeline() { // from class: androidx.camera.core.impl.CameraControlInternal.1
                @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
                public j2.q invokePostCapture() {
                    return Futures.immediateFuture(null);
                }

                @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
                public j2.q invokePreCapture() {
                    return Futures.immediateFuture(null);
                }
            });
        }

        public static boolean e(CameraControlInternal cameraControlInternal) {
            return false;
        }

        public static void a(CameraControlInternal cameraControlInternal) {
        }

        public static CameraControlInternal c(CameraControlInternal cameraControlInternal) {
            return cameraControlInternal;
        }

        public static void d(CameraControlInternal cameraControlInternal) {
        }

        public static void f(CameraControlInternal cameraControlInternal, boolean z2) {
        }

        public static void g(CameraControlInternal cameraControlInternal, ImageCapture.ScreenFlash screenFlash) {
        }
    }
}
