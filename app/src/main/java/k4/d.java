package k4;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f12623d = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f12624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.g f12626c;

    public d(n nVar, b bVar) {
        Level level = Level.FINE;
        this.f12626c = new android.support.v4.media.g(15);
        this.f12624a = nVar;
        this.f12625b = bVar;
    }

    public final void a(boolean z2, int i2, l7.j jVar, int i8) {
        android.support.v4.media.g gVar = this.f12626c;
        jVar.getClass();
        gVar.k(2, i2, jVar, i8, z2);
        try {
            m4.i iVar = this.f12625b.f12615a;
            synchronized (iVar) {
                if (iVar.e) {
                    throw new IOException("closed");
                }
                iVar.a(i2, i8, (byte) 0, z2 ? (byte) 1 : (byte) 0);
                if (i8 > 0) {
                    iVar.f12960a.write(jVar, i8);
                }
            }
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    public final void b(m4.a aVar, byte[] bArr) {
        b bVar = this.f12625b;
        l7.m mVar = l7.m.f12880d;
        this.f12626c.l(2, 0, aVar, r4.c.f(bArr));
        try {
            bVar.e(aVar, bArr);
            bVar.flush();
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f12625b.close();
        } catch (IOException e) {
            f12623d.log(e.getClass().equals(IOException.class) ? Level.FINE : Level.INFO, "Failed closing connection", (Throwable) e);
        }
    }

    public final void e(boolean z2, int i2, int i8) {
        android.support.v4.media.g gVar = this.f12626c;
        if (z2) {
            long j = (4294967295L & ((long) i8)) | (((long) i2) << 32);
            if (gVar.j()) {
                ((Logger) gVar.f3263b).log((Level) gVar.f3264c, "OUTBOUND PING: ack=true bytes=" + j);
            }
        } else {
            gVar.m(2, (4294967295L & ((long) i8)) | (((long) i2) << 32));
        }
        try {
            this.f12625b.g(z2, i2, i8);
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    public final void flush() {
        try {
            this.f12625b.flush();
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    public final void g(int i2, m4.a aVar) {
        this.f12626c.n(2, i2, aVar);
        try {
            this.f12625b.i(i2, aVar);
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    public final void i(int i2, List list, boolean z2) {
        try {
            m4.i iVar = this.f12625b.f12615a;
            synchronized (iVar) {
                if (iVar.e) {
                    throw new IOException("closed");
                }
                iVar.b(z2, i2, list);
            }
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }

    public final void j(int i2, long j) {
        this.f12626c.p(2, i2, j);
        try {
            this.f12625b.k(i2, j);
        } catch (IOException e) {
            this.f12624a.o(e);
        }
    }
}
