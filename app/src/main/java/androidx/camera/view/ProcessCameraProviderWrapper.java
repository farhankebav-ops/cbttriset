package androidx.camera.view;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.lifecycle.LifecycleOwner;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface ProcessCameraProviderWrapper {
    @MainThread
    Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup);

    CameraInfo getCameraInfo(CameraSelector cameraSelector);

    boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    @VisibleForTesting
    q shutdownAsync();

    void unbind(UseCase... useCaseArr);

    void unbindAll();
}
