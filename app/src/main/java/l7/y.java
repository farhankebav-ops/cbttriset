package l7;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f12908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f12909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f12910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12911d;
    public final CRC32 e;

    public y(k sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        i0 i0Var = new i0(sink);
        this.f12908a = i0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f12909b = deflater;
        this.f12910c = new n(i0Var, deflater);
        this.e = new CRC32();
        j jVar = i0Var.f12865b;
        jVar.Z(8075);
        jVar.x(8);
        jVar.x(0);
        jVar.X(0);
        jVar.x(0);
        jVar.x(0);
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        int value;
        boolean z2;
        j jVar;
        Deflater deflater = this.f12909b;
        i0 i0Var = this.f12908a;
        if (this.f12911d) {
            return;
        }
        try {
            n nVar = this.f12910c;
            nVar.f12886b.finish();
            nVar.a(false);
            value = (int) this.e.getValue();
            z2 = i0Var.f12866c;
            jVar = i0Var.f12865b;
        } catch (Throwable th) {
            th = th;
        }
        if (z2) {
            throw new IllegalStateException("closed");
        }
        jVar.X(b.g(value));
        i0Var.B();
        int bytesRead = (int) deflater.getBytesRead();
        if (i0Var.f12866c) {
            throw new IllegalStateException("closed");
        }
        jVar.X(b.g(bytesRead));
        i0Var.B();
        th = null;
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            i0Var.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f12911d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() throws IOException {
        this.f12910c.flush();
    }

    @Override // l7.n0
    public final r0 timeout() {
        return this.f12908a.f12864a.timeout();
    }

    @Override // l7.n0
    public final void write(j source, long j) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return;
        }
        k0 k0Var = source.f12867a;
        kotlin.jvm.internal.k.b(k0Var);
        long j3 = j;
        while (j3 > 0) {
            int iMin = (int) Math.min(j3, k0Var.f12874c - k0Var.f12873b);
            this.e.update(k0Var.f12872a, k0Var.f12873b, iMin);
            j3 -= (long) iMin;
            k0Var = k0Var.f12876f;
            kotlin.jvm.internal.k.b(k0Var);
        }
        this.f12910c.write(source, j);
    }
}
