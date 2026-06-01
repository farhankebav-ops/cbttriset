package j4;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s3 extends InputStream implements i4.i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f12448a;

    @Override // java.io.InputStream
    public final int available() {
        return this.f12448a.n();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12448a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.f12448a.b();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f12448a.e();
    }

    @Override // java.io.InputStream
    public final int read() {
        e eVar = this.f12448a;
        if (eVar.n() == 0) {
            return -1;
        }
        return eVar.l();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f12448a.o();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        e eVar = this.f12448a;
        int iMin = (int) Math.min(eVar.n(), j);
        eVar.p(iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) {
        e eVar = this.f12448a;
        if (eVar.n() == 0) {
            return -1;
        }
        int iMin = Math.min(eVar.n(), i8);
        eVar.k(bArr, i2, iMin);
        return iMin;
    }
}
