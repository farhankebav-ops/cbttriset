package androidx.camera.core.internal.compat;

import android.hardware.Camera;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class MediaActionSoundCompatBaseImpl {
    private static final int SAMPLE_CAMERA_ID = 0;

    private MediaActionSoundCompatBaseImpl() {
    }

    public static boolean mustPlayShutterSound() {
        if (Camera.getNumberOfCameras() < 1) {
            return false;
        }
        try {
            Camera.getCameraInfo(0, new Camera.CameraInfo());
            return !r0.canDisableShutterSound;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
