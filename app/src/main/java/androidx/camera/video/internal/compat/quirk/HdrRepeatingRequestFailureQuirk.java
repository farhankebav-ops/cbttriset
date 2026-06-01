package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class HdrRepeatingRequestFailureQuirk implements Quirk {
    private static boolean isSamsungS25Ultra() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "pa3q".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean load() {
        return isSamsungS25Ultra();
    }

    public boolean workaroundBySurfaceProcessing(DynamicRange dynamicRange) {
        return isSamsungS25Ultra() && (dynamicRange != DynamicRange.SDR);
    }
}
