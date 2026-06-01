package l4;

import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends k {
    public final e2.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e2.h f12797f;
    public final e2.h g;
    public final e2.h h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12798i;

    public g(e2.h hVar, e2.h hVar2, e2.h hVar3, e2.h hVar4, Provider provider, int i2) {
        super(provider);
        this.e = hVar;
        this.f12797f = hVar2;
        this.g = hVar3;
        this.h = hVar4;
        this.f12798i = i2;
    }

    @Override // l4.k
    public final void c(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.e.j(sSLSocket, Boolean.TRUE);
            this.f12797f.j(sSLSocket, str);
        }
        Class<?> cls = sSLSocket.getClass();
        e2.h hVar = this.h;
        if (hVar.b(cls) != null) {
            hVar.k(sSLSocket, k.b(list));
        }
    }

    @Override // l4.k
    public final String d(SSLSocket sSLSocket) {
        byte[] bArr;
        Class<?> cls = sSLSocket.getClass();
        e2.h hVar = this.g;
        if (hVar.b(cls) == null || (bArr = (byte[]) hVar.k(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, n.f12820b);
    }

    @Override // l4.k
    public final int e() {
        return this.f12798i;
    }
}
