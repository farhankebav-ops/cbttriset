package l7;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f12885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deflater f12886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12887c;

    public n(i0 i0Var, Deflater deflater) {
        this.f12885a = i0Var;
        this.f12886b = deflater;
    }

    public final void a(boolean z2) throws IOException {
        k0 k0VarV;
        int iDeflate;
        i0 i0Var = this.f12885a;
        j jVar = i0Var.f12865b;
        while (true) {
            k0VarV = jVar.v(1);
            byte[] bArr = k0VarV.f12872a;
            Deflater deflater = this.f12886b;
            if (z2) {
                try {
                    int i2 = k0VarV.f12874c;
                    iDeflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                int i8 = k0VarV.f12874c;
                iDeflate = deflater.deflate(bArr, i8, 8192 - i8);
            }
            if (iDeflate > 0) {
                k0VarV.f12874c += iDeflate;
                jVar.f12868b += (long) iDeflate;
                i0Var.B();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (k0VarV.f12873b == k0VarV.f12874c) {
            jVar.f12867a = k0VarV.a();
            l0.a(k0VarV);
        }
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f12886b;
        if (this.f12887c) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f12885a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f12887c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // l7.n0, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f12885a.flush();
    }

    @Override // l7.n0
    public final r0 timeout() {
        return this.f12885a.f12864a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f12885a + ')';
    }

    @Override // l7.n0
    public final void write(j source, long j) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        b.e(source.f12868b, 0L, j);
        while (true) {
            Deflater deflater = this.f12886b;
            if (j <= 0) {
                deflater.setInput(m7.b.f12999b, 0, 0);
                return;
            }
            k0 k0Var = source.f12867a;
            kotlin.jvm.internal.k.b(k0Var);
            int iMin = (int) Math.min(j, k0Var.f12874c - k0Var.f12873b);
            deflater.setInput(k0Var.f12872a, k0Var.f12873b, iMin);
            a(false);
            long j3 = iMin;
            source.f12868b -= j3;
            int i2 = k0Var.f12873b + iMin;
            k0Var.f12873b = i2;
            if (i2 == k0Var.f12874c) {
                source.f12867a = k0Var.a();
                l0.a(k0Var);
            }
            j -= j3;
        }
    }
}
