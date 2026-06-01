package j4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z2 extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d5 f12565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12567d;
    public long e;

    public z2(InputStream inputStream, int i2, d5 d5Var) {
        super(inputStream);
        this.e = -1L;
        this.f12564a = i2;
        this.f12565b = d5Var;
    }

    public final void a() {
        long j = this.f12567d;
        long j3 = this.f12566c;
        if (j > j3) {
            long j8 = j - j3;
            for (i4.i iVar : this.f12565b.f12162a) {
                iVar.f(j8);
            }
            this.f12566c = this.f12567d;
        }
    }

    public final void b() {
        long j = this.f12567d;
        int i2 = this.f12564a;
        if (j <= i2) {
            return;
        }
        throw i4.n1.j.h("Decompressed gRPC message exceeds maximum size " + i2).a();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        this.e = this.f12567d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 != -1) {
            this.f12567d++;
        }
        b();
        a();
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.e == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f12567d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j);
        this.f12567d += jSkip;
        b();
        a();
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = ((FilterInputStream) this).in.read(bArr, i2, i8);
        if (i9 != -1) {
            this.f12567d += (long) i9;
        }
        b();
        a();
        return i9;
    }
}
