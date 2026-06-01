package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface CameraUseCaseAdapterProvider {
    CameraUseCaseAdapter provide(CameraInternal cameraInternal, CameraInternal cameraInternal2, AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2);

    CameraUseCaseAdapter provide(String str) throws IllegalArgumentException;
}
