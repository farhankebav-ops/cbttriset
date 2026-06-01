package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static boolean a(Camera camera, boolean z2, UseCase... useCaseArr) {
        return true;
    }

    public static boolean b(Camera camera, UseCase... useCaseArr) {
        return camera.isUseCasesCombinationSupported(true, useCaseArr);
    }

    public static boolean c(Camera camera, UseCase... useCaseArr) {
        return camera.isUseCasesCombinationSupported(false, useCaseArr);
    }
}
