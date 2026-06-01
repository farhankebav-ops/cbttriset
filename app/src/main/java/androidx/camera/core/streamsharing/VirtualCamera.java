package androidx.camera.core.streamsharing;

import androidx.annotation.MainThread;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.streamsharing.StreamSharing;
import j2.q;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";
    private final CameraInternal mParentCamera;
    private final UseCase.StateChangeCallback mStateChangeCallback;
    private final VirtualCameraControl mVirtualCameraControl;
    private final VirtualCameraInfo mVirtualCameraInfo;

    public VirtualCamera(CameraInternal cameraInternal, UseCase.StateChangeCallback stateChangeCallback, StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mStateChangeCallback = stateChangeCallback;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal(), control);
        this.mVirtualCameraInfo = new VirtualCameraInfo(cameraInternal.getCameraInfoInternal());
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraControl getCameraControl() {
        return l.a(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraInfo getCameraInfo() {
        return l.b(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mVirtualCameraInfo;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraConfig getExtendedConfig() {
        return l.c(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean getHasTransform() {
        return false;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean isFrontFacing() {
        return l.e(this);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(boolean z2, UseCase... useCaseArr) {
        return androidx.camera.core.c.a(this, z2, useCaseArr);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return androidx.camera.core.c.c(this, useCaseArr);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void onRemoved() {
        l.f(this);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseActive(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseActive(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseInactive(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseInactive(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseReset(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseReset(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseUpdated(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseUpdated(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public q release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setActiveResumingMode(boolean z2) {
        l.g(this, z2);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setExtendedConfig(CameraConfig cameraConfig) {
        l.h(this, cameraConfig);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setPrimary(boolean z2) {
        l.i(this, z2);
    }

    public void setRotationDegrees(int i2) {
        this.mVirtualCameraInfo.setVirtualCameraRotationDegrees(i2);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return androidx.camera.core.c.b(this, useCaseArr);
    }
}
