package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface Camera {
    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraConfig getExtendedConfig();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupported(boolean z2, UseCase... useCaseArr);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupported(UseCase... useCaseArr);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr);
}
