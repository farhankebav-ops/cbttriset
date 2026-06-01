package j4;

import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k4.g f12326a;

    public n(k4.g gVar, i2 i2Var) {
        this.f12326a = gVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12326a.close();
    }

    @Override // j4.b0
    public final f0 m(SocketAddress socketAddress, a0 a0Var, s1 s1Var) {
        return new m(this, this.f12326a.m(socketAddress, a0Var, s1Var), a0Var.f12099a);
    }
}
