package i4;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends SocketAddress {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f11975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f11976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11978d;

    public y(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        r2.q.D(inetSocketAddress, "proxyAddress");
        r2.q.D(inetSocketAddress2, "targetAddress");
        r2.q.G(inetSocketAddress, "The proxy address %s is not resolved", !inetSocketAddress.isUnresolved());
        this.f11975a = inetSocketAddress;
        this.f11976b = inetSocketAddress2;
        this.f11977c = str;
        this.f11978d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Objects.equals(this.f11975a, yVar.f11975a) && Objects.equals(this.f11976b, yVar.f11976b) && Objects.equals(this.f11977c, yVar.f11977c) && Objects.equals(this.f11978d, yVar.f11978d);
    }

    public final int hashCode() {
        return Objects.hash(this.f11975a, this.f11976b, this.f11977c, this.f11978d);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11975a, "proxyAddr");
        iVarY.c(this.f11976b, "targetAddr");
        iVarY.c(this.f11977c, "username");
        iVarY.e("hasPassword", this.f11978d != null);
        return iVarY.toString();
    }
}
