package k4;

import j4.w4;
import java.io.IOException;
import java.net.Socket;
import l7.n0;
import l7.r0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w4 f12619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f12620d;
    public final int e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n0 f12622i;
    public Socket j;
    public boolean k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12617a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7.j f12618b = new l7.j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12621f = false;
    public boolean g = false;
    public boolean h = false;

    public c(w4 w4Var, n nVar) {
        r2.q.D(w4Var, "executor");
        this.f12619c = w4Var;
        this.f12620d = nVar;
        this.e = 10000;
    }

    public final void a(n0 n0Var, Socket socket) {
        r2.q.H(this.f12622i == null, "AsyncSink's becomeConnected should only be called once.");
        r2.q.D(n0Var, "sink");
        this.f12622i = n0Var;
        this.j = socket;
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f12619c.execute(new a4.c(this, 16));
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() throws IOException {
        if (this.h) {
            throw new IOException("closed");
        }
        r4.b.c();
        try {
            synchronized (this.f12617a) {
                if (!this.g) {
                    this.g = true;
                    this.f12619c.execute(new a(this, 1));
                }
            }
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // l7.n0
    public final r0 timeout() {
        return r0.NONE;
    }

    @Override // l7.n0
    public final void write(l7.j jVar, long j) throws IOException {
        r2.q.D(jVar, "source");
        if (this.h) {
            throw new IOException("closed");
        }
        r4.b.c();
        try {
            synchronized (this.f12617a) {
                try {
                    this.f12618b.write(jVar, j);
                    int i2 = this.m + this.l;
                    this.m = i2;
                    boolean z2 = false;
                    this.l = 0;
                    if (!this.k && i2 > this.e) {
                        this.k = true;
                        z2 = true;
                    } else if (!this.f12621f && !this.g && this.f12618b.e() > 0) {
                        this.f12621f = true;
                    }
                    if (z2) {
                        try {
                            this.j.close();
                        } catch (IOException e) {
                            this.f12620d.o(e);
                        }
                    } else {
                        this.f12619c.execute(new a(this, 0));
                    }
                } finally {
                }
            }
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
