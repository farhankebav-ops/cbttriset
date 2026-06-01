package j4;

import java.nio.charset.Charset;
import java.util.Locale;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i1 extends c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final i4.y0 f12251u = i4.g0.a(Header.RESPONSE_STATUS_UTF8, new e3(15));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i4.n1 f12252q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i4.a1 f12253r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Charset f12254s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12255t;

    public static Charset i(i4.a1 a1Var) {
        String str = (String) a1Var.c(f1.f12188i);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return e2.d.f11228b;
    }

    public static i4.n1 j(i4.a1 a1Var) {
        char cCharAt;
        Integer num = (Integer) a1Var.c(f12251u);
        if (num == null) {
            return i4.n1.l.h("Missing HTTP status code");
        }
        String str = (String) a1Var.c(f1.f12188i);
        if (str != null && 16 <= str.length()) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.startsWith("application/grpc") && (lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';')) {
                return null;
            }
        }
        return f1.g(num.intValue()).b("invalid content-type: " + str);
    }
}
