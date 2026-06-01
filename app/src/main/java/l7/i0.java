package l7;

import j4.c3;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f12864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f12865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12866c;

    public i0(n0 sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        this.f12864a = sink;
        this.f12865b = new j();
    }

    @Override // l7.k
    public final k A(int i2) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.e0(i2);
        B();
        return this;
    }

    @Override // l7.k
    public final k B() {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f12865b;
        long jE = jVar.e();
        if (jE > 0) {
            this.f12864a.write(jVar, jE);
        }
        return this;
    }

    @Override // l7.k
    public final k C(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.d0(string);
        B();
        return this;
    }

    @Override // l7.k
    public final k E(m byteString) {
        kotlin.jvm.internal.k.e(byteString, "byteString");
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.w(byteString);
        B();
        return this;
    }

    @Override // l7.k
    public final k G(long j) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.y(j);
        B();
        return this;
    }

    @Override // l7.k
    public final long H(o0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        long j = 0;
        while (true) {
            long j3 = source.read(this.f12865b, 8192L);
            if (j3 == -1) {
                return j;
            }
            j += j3;
            B();
        }
    }

    @Override // l7.k
    public final k Q(long j) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.W(j);
        B();
        return this;
    }

    @Override // l7.k
    public final k S(int i2, int i8, String string) {
        kotlin.jvm.internal.k.e(string, "string");
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.c0(i2, i8, string);
        B();
        return this;
    }

    @Override // l7.k
    public final OutputStream T() {
        return new c3(this, 2);
    }

    @Override // l7.n0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        n0 n0Var = this.f12864a;
        if (this.f12866c) {
            return;
        }
        try {
            j jVar = this.f12865b;
            long j = jVar.f12868b;
            if (j > 0) {
                n0Var.write(jVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            n0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f12866c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // l7.k, l7.n0, java.io.Flushable
    public final void flush() {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f12865b;
        long j = jVar.f12868b;
        n0 n0Var = this.f12864a;
        if (j > 0) {
            n0Var.write(jVar, j);
        }
        n0Var.flush();
    }

    @Override // l7.k
    public final j getBuffer() {
        return this.f12865b;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f12866c;
    }

    @Override // l7.n0
    public final r0 timeout() {
        return this.f12864a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f12864a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f12865b.write(source);
        B();
        return iWrite;
    }

    @Override // l7.k
    public final k writeByte(int i2) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.x(i2);
        B();
        return this;
    }

    @Override // l7.k
    public final k writeInt(int i2) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.X(i2);
        B();
        return this;
    }

    @Override // l7.k
    public final k writeShort(int i2) {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        this.f12865b.Z(i2);
        B();
        return this;
    }

    @Override // l7.k
    public final k z() {
        if (this.f12866c) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f12865b;
        long j = jVar.f12868b;
        if (j > 0) {
            this.f12864a.write(jVar, j);
        }
        return this;
    }

    @Override // l7.n0
    public final void write(j source, long j) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!this.f12866c) {
            this.f12865b.write(source, j);
            B();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // l7.k
    public final k write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!this.f12866c) {
            this.f12865b.m3450write(source);
            B();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // l7.k
    public final k write(byte[] source, int i2, int i8) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!this.f12866c) {
            this.f12865b.m3451write(source, i2, i8);
            B();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
