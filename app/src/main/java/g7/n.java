package g7;

import f7.c1;
import f7.h0;
import f7.q1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f11618a = c1.a("kotlinx.serialization.json.JsonUnquotedLiteral", q1.f11501a);

    public static final b0 a(Number number) {
        return number == null ? u.INSTANCE : new r(number, false, null);
    }

    public static final b0 b(String str) {
        return str == null ? u.INSTANCE : new r(str, true, null);
    }

    public static final void c(m mVar, String str) {
        throw new IllegalArgumentException("Element " + kotlin.jvm.internal.b0.a(mVar.getClass()) + " is not a " + str);
    }

    public static final int d(b0 b0Var) {
        try {
            long jH = new h7.b0(b0Var.a()).h();
            if (-2147483648L <= jH && jH <= 2147483647L) {
                return (int) jH;
            }
            throw new NumberFormatException(b0Var.a() + " is not an Int");
        } catch (h7.k e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final b0 e(m mVar) {
        kotlin.jvm.internal.k.e(mVar, "<this>");
        b0 b0Var = mVar instanceof b0 ? (b0) mVar : null;
        if (b0Var != null) {
            return b0Var;
        }
        c(mVar, "JsonPrimitive");
        throw null;
    }
}
