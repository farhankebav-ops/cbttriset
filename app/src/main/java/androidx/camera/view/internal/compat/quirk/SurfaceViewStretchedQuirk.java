package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceViewStretchedQuirk implements Quirk {
    private static final String GALAXY_Z_FOLD_2 = "F2Q";
    private static final String GALAXY_Z_FOLD_3 = "Q2Q";
    private static final String LENOVO = "LENOVO";
    private static final String LENOVO_TAB_P12_PRO = "Q706F";
    private static final String OPPO = "OPPO";
    private static final String OPPO_FIND_N = "OP4E75L1";
    private static final String SAMSUNG = "SAMSUNG";

    private static boolean isLenovoTablet() {
        return LENOVO.equalsIgnoreCase(Build.MANUFACTURER) && LENOVO_TAB_P12_PRO.equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isOppoFoldable() {
        return OPPO.equalsIgnoreCase(Build.MANUFACTURER) && OPPO_FIND_N.equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isSamsungFold2OrFold3() {
        if (!SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER)) {
            return false;
        }
        String str = Build.DEVICE;
        return GALAXY_Z_FOLD_2.equalsIgnoreCase(str) || GALAXY_Z_FOLD_3.equalsIgnoreCase(str);
    }

    public static boolean load() {
        if (Build.VERSION.SDK_INT < 33) {
            return isSamsungFold2OrFold3() || isOppoFoldable() || isLenovoTablet();
        }
        return false;
    }
}
