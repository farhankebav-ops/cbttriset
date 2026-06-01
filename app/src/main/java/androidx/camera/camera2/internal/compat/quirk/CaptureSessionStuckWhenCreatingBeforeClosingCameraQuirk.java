package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk implements Quirk {
    public static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return shouldLoadForMotoE20(cameraCharacteristicsCompat);
    }

    private static boolean shouldLoadForMotoE20(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e20".equalsIgnoreCase(Build.MODEL) && cameraCharacteristicsCompat.getCameraId().equals("1");
    }
}
