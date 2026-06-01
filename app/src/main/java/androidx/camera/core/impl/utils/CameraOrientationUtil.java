package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 90) {
            return 1;
        }
        if (i2 == 180) {
            return 2;
        }
        if (i2 == 270) {
            return 3;
        }
        throw new IllegalStateException(a1.a.g(i2, "Invalid sensor rotation: "));
    }

    public static int getRelativeImageRotation(int i2, int i8, boolean z2) {
        int i9 = z2 ? ((i8 - i2) + 360) % 360 : (i8 + i2) % 360;
        if (Logger.isVerboseEnabled(TAG)) {
            StringBuilder sbW = a1.a.w(i2, "getRelativeImageRotation: destRotationDegrees=", ", sourceRotationDegrees=", i8, ", isOppositeFacing=");
            sbW.append(z2);
            sbW.append(", result=");
            sbW.append(i9);
            Logger.d(TAG, sbW.toString());
        }
        return i9;
    }

    public static int surfaceRotationToDegrees(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 90;
        }
        if (i2 == 2) {
            return 180;
        }
        if (i2 == 3) {
            return 270;
        }
        throw new IllegalArgumentException(a1.a.g(i2, "Unsupported surface rotation: "));
    }
}
