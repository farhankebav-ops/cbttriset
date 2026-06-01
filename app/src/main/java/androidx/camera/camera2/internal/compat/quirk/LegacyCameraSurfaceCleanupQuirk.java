package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class LegacyCameraSurfaceCleanupQuirk implements Quirk {
    public static boolean isLegacyDevice(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    public static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 23 && i2 < 29 && isLegacyDevice(cameraCharacteristicsCompat);
    }
}
