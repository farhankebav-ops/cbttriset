package i4;

import java.nio.charset.Charset;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f11865a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g2.c f11866b = a1.e;

    public static y0 a(String str, f0 f0Var) {
        boolean z2 = false;
        if (!str.isEmpty() && str.charAt(0) == ':') {
            z2 = true;
        }
        BitSet bitSet = x0.f11971d;
        return new y0(str, z2, f0Var);
    }
}
