package l7;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f12869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f12870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12871c;

    public j0(o0 source) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f12869a = source;
        this.f12870b = new j();
    }

    @Override // l7.l
    public final String D() {
        return h(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // l7.l
    public final void F(long j) {
        if (!c(j)) {
            throw new EOFException();
        }
    }

    @Override // l7.l
    public final boolean I(long j, m bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        int iD = bytes.d();
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        if (iD >= 0 && iD <= bytes.d()) {
            return iD == 0 || m7.b.d(this, bytes, iD, 1L) != -1;
        }
        return false;
    }

    @Override // l7.l
    public final m J(long j) {
        F(j);
        return this.f12870b.J(j);
    }

    @Override // l7.l
    public final long K(j jVar) {
        j jVar2;
        long j = 0;
        while (true) {
            o0 o0Var = this.f12869a;
            jVar2 = this.f12870b;
            if (o0Var.read(jVar2, 8192L) == -1) {
                break;
            }
            long jE = jVar2.e();
            if (jE > 0) {
                j += jE;
                jVar.write(jVar2, jE);
            }
        }
        long j3 = jVar2.f12868b;
        if (j3 <= 0) {
            return j;
        }
        long j8 = j + j3;
        jVar.write(jVar2, j3);
        return j8;
    }

    @Override // l7.l
    public final byte[] L() {
        o0 o0Var = this.f12869a;
        j jVar = this.f12870b;
        jVar.H(o0Var);
        return jVar.o(jVar.f12868b);
    }

    @Override // l7.l
    public final boolean M() {
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        j jVar = this.f12870b;
        return jVar.M() && this.f12869a.read(jVar, 8192L) == -1;
    }

    @Override // l7.l
    public final long N(long j, m bytes) {
        kotlin.jvm.internal.k.e(bytes, "bytes");
        return m7.b.d(this, bytes, bytes.d(), j);
    }

    @Override // l7.l
    public final long O() {
        j jVar;
        byte bI;
        F(1L);
        long j = 0;
        while (true) {
            long j3 = j + 1;
            boolean zC = c(j3);
            jVar = this.f12870b;
            if (!zC) {
                break;
            }
            bI = jVar.i(j);
            if ((bI < 48 || bI > 57) && !(j == 0 && bI == 45)) {
                break;
            }
            j = j3;
        }
        if (j == 0) {
            n7.b.i(16);
            String string = Integer.toString(bI, 16);
            kotlin.jvm.internal.k.d(string, "toString(...)");
            throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
        }
        return jVar.O();
    }

    @Override // l7.l
    public final String P(Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        o0 o0Var = this.f12869a;
        j jVar = this.f12870b;
        jVar.H(o0Var);
        return jVar.P(charset);
    }

    @Override // l7.l
    public final m R() {
        o0 o0Var = this.f12869a;
        j jVar = this.f12870b;
        jVar.H(o0Var);
        return jVar.J(jVar.f12868b);
    }

    @Override // l7.l
    public final long U() {
        j jVar;
        byte bI;
        F(1L);
        int i2 = 0;
        while (true) {
            int i8 = i2 + 1;
            boolean zC = c(i8);
            jVar = this.f12870b;
            if (!zC) {
                break;
            }
            bI = jVar.i(i2);
            if ((bI < 48 || bI > 57) && ((bI < 97 || bI > 102) && (bI < 65 || bI > 70))) {
                break;
            }
            i2 = i8;
        }
        if (i2 == 0) {
            n7.b.i(16);
            String string = Integer.toString(bI, 16);
            kotlin.jvm.internal.k.d(string, "toString(...)");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return jVar.U();
    }

    @Override // l7.l
    public final InputStream V() {
        return new i(this, 1);
    }

    public final long a(byte b8, long j, long j3) {
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j3) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("fromIndex=0 toIndex=", j3).toString());
        }
        long jMax = 0;
        while (jMax < j3) {
            j jVar = this.f12870b;
            byte b9 = b8;
            long j8 = j3;
            long j9 = jVar.j(b9, jMax, j8);
            if (j9 != -1) {
                return j9;
            }
            long j10 = jVar.f12868b;
            if (j10 >= j8 || this.f12869a.read(jVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j10);
            b8 = b9;
            j3 = j8;
        }
        return -1L;
    }

    public final int b() {
        F(4L);
        return b.g(this.f12870b.readInt());
    }

    @Override // l7.l
    public final boolean c(long j) {
        j jVar;
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
        }
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        do {
            jVar = this.f12870b;
            if (jVar.f12868b >= j) {
                return true;
            }
        } while (this.f12869a.read(jVar, 8192L) != -1);
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f12871c) {
            return;
        }
        this.f12871c = true;
        this.f12869a.close();
        this.f12870b.a();
    }

    @Override // l7.l
    public final void d(j sink, long j) throws EOFException {
        j jVar = this.f12870b;
        kotlin.jvm.internal.k.e(sink, "sink");
        try {
            F(j);
            jVar.d(sink, j);
        } catch (EOFException e) {
            sink.H(jVar);
            throw e;
        }
    }

    public final long e() throws EOFException {
        F(8L);
        long j = this.f12870b.readLong();
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    @Override // l7.l
    public final int f(f0 options) throws EOFException {
        kotlin.jvm.internal.k.e(options, "options");
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            j jVar = this.f12870b;
            int iD = m7.a.d(jVar, options, true);
            if (iD != -2) {
                if (iD != -1) {
                    jVar.skip(options.f12848a[iD].d());
                    return iD;
                }
            } else if (this.f12869a.read(jVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public final short g() {
        F(2L);
        return this.f12870b.p();
    }

    @Override // l7.l, l7.k
    public final j getBuffer() {
        return this.f12870b;
    }

    @Override // l7.l
    public final String h(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("limit < 0: ", j).toString());
        }
        long j3 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long jA = a((byte) 10, 0L, j3);
        j jVar = this.f12870b;
        if (jA != -1) {
            return m7.a.c(jVar, jA);
        }
        if (j3 < LocationRequestCompat.PASSIVE_INTERVAL && c(j3) && jVar.i(j3 - 1) == 13 && c(j3 + 1) && jVar.i(j3) == 10) {
            return m7.a.c(jVar, j3);
        }
        j jVar2 = new j();
        jVar.g(0L, jVar2, Math.min(32, jVar.f12868b));
        throw new EOFException("\\n not found: limit=" + Math.min(jVar.f12868b, j) + " content=" + jVar2.J(jVar2.f12868b).e() + (char) 8230);
    }

    public final String i(long j) {
        F(j);
        j jVar = this.f12870b;
        jVar.getClass();
        return jVar.q(j, n6.a.f13073a);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f12871c;
    }

    @Override // l7.l
    public final j0 peek() {
        return b.c(new h0(this));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        j jVar = this.f12870b;
        if (jVar.f12868b == 0 && this.f12869a.read(jVar, 8192L) == -1) {
            return -1;
        }
        return jVar.read(sink);
    }

    @Override // l7.l
    public final byte readByte() {
        F(1L);
        return this.f12870b.readByte();
    }

    @Override // l7.l
    public final void readFully(byte[] sink) throws EOFException {
        j jVar = this.f12870b;
        kotlin.jvm.internal.k.e(sink, "sink");
        try {
            F(sink.length);
            jVar.readFully(sink);
        } catch (EOFException e) {
            int i2 = 0;
            while (true) {
                long j = jVar.f12868b;
                if (j <= 0) {
                    throw e;
                }
                int i8 = jVar.read(sink, i2, (int) j);
                if (i8 == -1) {
                    throw new AssertionError();
                }
                i2 += i8;
            }
        }
    }

    @Override // l7.l
    public final int readInt() {
        F(4L);
        return this.f12870b.readInt();
    }

    @Override // l7.l
    public final long readLong() {
        F(8L);
        return this.f12870b.readLong();
    }

    @Override // l7.l
    public final short readShort() {
        F(2L);
        return this.f12870b.readShort();
    }

    @Override // l7.l
    public final void skip(long j) {
        if (this.f12871c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            j jVar = this.f12870b;
            if (jVar.f12868b == 0 && this.f12869a.read(jVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, jVar.f12868b);
            jVar.skip(jMin);
            j -= jMin;
        }
    }

    @Override // l7.o0
    public final r0 timeout() {
        return this.f12869a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f12869a + ')';
    }

    @Override // l7.o0
    public final long read(j sink, long j) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j >= 0) {
            if (!this.f12871c) {
                j jVar = this.f12870b;
                if (jVar.f12868b == 0) {
                    if (j == 0) {
                        return 0L;
                    }
                    if (this.f12869a.read(jVar, 8192L) == -1) {
                        return -1L;
                    }
                }
                return jVar.read(sink, Math.min(j, jVar.f12868b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("byteCount < 0: ", j).toString());
    }
}
