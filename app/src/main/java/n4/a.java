package n4;

import androidx.webkit.ProxyConfig;
import f2.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13065c;

    public a(g gVar) {
        String str = (String) gVar.f11325b;
        this.f13063a = (String) gVar.f11327d;
        int i2 = gVar.f11326c;
        this.f13064b = i2 == -1 ? str.equals(ProxyConfig.MATCH_HTTP) ? 80 : str.equals("https") ? 443 : -1 : i2;
        this.f13065c = gVar.toString();
    }

    public static int a(char c7) {
        if (c7 >= '0' && c7 <= '9') {
            return c7 - '0';
        }
        if (c7 >= 'a' && c7 <= 'f') {
            return c7 - 'W';
        }
        if (c7 < 'A' || c7 > 'F') {
            return -1;
        }
        return c7 - '7';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f13065c.equals(this.f13065c);
    }

    public final int hashCode() {
        return this.f13065c.hashCode();
    }

    public final String toString() {
        return this.f13065c;
    }
}
