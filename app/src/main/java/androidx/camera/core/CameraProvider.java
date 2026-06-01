package androidx.camera.core;

import androidx.annotation.RestrictTo;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraProvider {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void addCameraPresenceListener(Executor executor, CameraPresenceListener cameraPresenceListener);

    List<CameraInfo> getAvailableCameraInfos();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    List<List<CameraInfo>> getAvailableConcurrentCameraInfos();

    CameraInfo getCameraInfo(CameraSelector cameraSelector);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getConfigImplType();

    boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isConcurrentCameraModeOn();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void removeCameraPresenceListener(CameraPresenceListener cameraPresenceListener);
}
