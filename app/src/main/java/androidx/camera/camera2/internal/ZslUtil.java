package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ZslUtil {
    private ZslUtil() {
    }

    public static boolean isCapabilitySupported(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2) {
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == i2) {
                    return true;
                }
            }
        }
        return false;
    }
}
