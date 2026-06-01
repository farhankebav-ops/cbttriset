package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    private static final String RED_MI_NOTE_10_MODEL = "M2101K7AG";
    private static final String XIAOMI = "XIAOMI";

    public static boolean load() {
        return XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) && RED_MI_NOTE_10_MODEL.equalsIgnoreCase(Build.MODEL);
    }
}
