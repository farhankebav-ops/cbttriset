package androidx.camera.core.impl;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {
    public static CameraControl a(CameraInternal cameraInternal) {
        return cameraInternal.getCameraControlInternal();
    }

    public static CameraInfo b(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal();
    }

    public static CameraConfig c(CameraInternal cameraInternal) {
        return CameraConfigs.defaultConfig();
    }

    public static boolean d(CameraInternal cameraInternal) {
        return true;
    }

    public static boolean e(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfo().getLensFacing() == 0;
    }

    public static void f(CameraInternal cameraInternal) {
    }

    public static void g(CameraInternal cameraInternal, boolean z2) {
    }

    public static void h(CameraInternal cameraInternal, CameraConfig cameraConfig) {
    }

    public static void i(CameraInternal cameraInternal, boolean z2) {
    }
}
