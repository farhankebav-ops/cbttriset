package okhttp3;

import java.nio.charset.Charset;
import kotlin.jvm.internal.k;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String username, String password) {
        k.e(username, "username");
        k.e(password, "password");
        return basic$default(username, password, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            charset = n6.a.f13076d;
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String username, String password, Charset charset) {
        k.e(username, "username");
        k.e(password, "password");
        k.e(charset, "charset");
        String str = username + ':' + password;
        m mVar = m.f12880d;
        k.e(str, "<this>");
        byte[] bytes = str.getBytes(charset);
        k.d(bytes, "getBytes(...)");
        return a1.a.l("Basic ", new m(bytes).a());
    }
}
