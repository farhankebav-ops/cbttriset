package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PrematureEndOfStreamVideoQuirk implements Quirk {
    public static final PrematureEndOfStreamVideoQuirk INSTANCE = new PrematureEndOfStreamVideoQuirk();
    private static final boolean isCph1931;

    static {
        isCph1931 = "OPPO".equalsIgnoreCase(Build.BRAND) && "CPH1931".equalsIgnoreCase(Build.MODEL);
    }

    private PrematureEndOfStreamVideoQuirk() {
    }

    public static final boolean load() {
        return isCph1931;
    }
}
