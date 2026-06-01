package androidx.camera.core;

import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.internal.compat.MediaActionSoundCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {
    public static CameraIdentifier a(CameraInfo cameraInfo) {
        return null;
    }

    public static float b(CameraInfo cameraInfo) {
        return 1.0f;
    }

    public static int c(CameraInfo cameraInfo) {
        return -1;
    }

    public static LiveData d(CameraInfo cameraInfo) {
        return new MutableLiveData(-1);
    }

    public static int e(CameraInfo cameraInfo) {
        return 0;
    }

    public static Set f(CameraInfo cameraInfo) {
        return Collections.EMPTY_SET;
    }

    public static Set g(CameraInfo cameraInfo) {
        return Collections.EMPTY_SET;
    }

    public static Set h(CameraInfo cameraInfo, SessionConfig sessionConfig) {
        return Collections.EMPTY_SET;
    }

    public static LiveData i(CameraInfo cameraInfo) {
        return new MutableLiveData(0);
    }

    public static boolean j(CameraInfo cameraInfo, SessionConfig sessionConfig) {
        return false;
    }

    public static boolean k(CameraInfo cameraInfo, FocusMeteringAction focusMeteringAction) {
        return false;
    }

    public static boolean l(CameraInfo cameraInfo) {
        return false;
    }

    public static boolean m(CameraInfo cameraInfo) {
        return false;
    }

    public static boolean n(CameraInfo cameraInfo) {
        return false;
    }

    public static boolean o(CameraInfo cameraInfo) {
        return false;
    }

    public static boolean p(CameraInfo cameraInfo) {
        return false;
    }

    public static Set q(CameraInfo cameraInfo, Set set) {
        return DynamicRanges.findAllPossibleMatches(set, Collections.singleton(DynamicRange.SDR));
    }

    public static boolean r() {
        return MediaActionSoundCompat.mustPlayShutterSound();
    }
}
