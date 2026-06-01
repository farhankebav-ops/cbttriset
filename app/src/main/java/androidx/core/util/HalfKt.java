package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s7) {
        return Half.valueOf(s7);
    }

    @RequiresApi(26)
    public static final Half toHalf(float f4) {
        return Half.valueOf(f4);
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    public static final Half toHalf(double d8) {
        return Half.valueOf((float) d8);
    }
}
