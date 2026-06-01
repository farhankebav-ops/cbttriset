package androidx.graphics.shapes;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Format_jvmKt {
    public static final String toStringWithLessPrecision(float f4) {
        return String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f4)}, 1));
    }
}
