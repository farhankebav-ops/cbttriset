package k4;

import j4.a0;
import j4.b0;
import j4.b5;
import j4.c5;
import j4.e3;
import j4.f0;
import j4.s1;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4.a f12633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f12634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.a f12635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f12636d;
    public final e3 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SSLSocketFactory f12637f;
    public final l4.c g;
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12638i;
    public final j4.f j;
    public final long k;
    public final int l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12639n;

    public g(a4.a aVar, a4.a aVar2, SSLSocketFactory sSLSocketFactory, l4.c cVar, int i2, boolean z2, long j, long j3, int i8, int i9, e3 e3Var) {
        this.f12633a = aVar;
        this.f12634b = (Executor) c5.a((b5) aVar.f3216b);
        this.f12635c = aVar2;
        this.f12636d = (ScheduledExecutorService) c5.a((b5) aVar2.f3216b);
        this.f12637f = sSLSocketFactory;
        this.g = cVar;
        this.h = i2;
        this.f12638i = z2;
        this.j = new j4.f(j);
        this.k = j3;
        this.l = i8;
        this.m = i9;
        r2.q.D(e3Var, "transportTracerFactory");
        this.e = e3Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f12639n) {
            return;
        }
        this.f12639n = true;
        c5.b((b5) this.f12633a.f3216b, this.f12634b);
        c5.b((b5) this.f12635c.f3216b, this.f12636d);
    }

    @Override // j4.b0
    public final f0 m(SocketAddress socketAddress, a0 a0Var, s1 s1Var) {
        if (this.f12639n) {
            throw new IllegalStateException("The transport factory is closed.");
        }
        j4.f fVar = this.j;
        long j = fVar.f12182b.get();
        n nVar = new n(this, (InetSocketAddress) socketAddress, a0Var.f12099a, a0Var.f12100b, a0Var.f12101c, new a4.c(new c0.b(fVar, j), 17));
        if (this.f12638i) {
            nVar.G = true;
            nVar.H = j;
            nVar.I = this.k;
        }
        return nVar;
    }
}
