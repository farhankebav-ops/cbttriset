package k4;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends j4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.j f12686a;

    public r(l7.j jVar) {
        this.f12686a = jVar;
    }

    @Override // j4.e, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        this.f12686a.a();
    }

    @Override // j4.e
    public final j4.e g(int i2) {
        l7.j jVar = new l7.j();
        jVar.write(this.f12686a, i2);
        return new r(jVar);
    }

    @Override // j4.e
    public final void i(OutputStream outputStream, int i2) throws IOException {
        this.f12686a.b0(outputStream, i2);
    }

    @Override // j4.e
    public final void j(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // j4.e
    public final void k(byte[] bArr, int i2, int i8) {
        while (i8 > 0) {
            int i9 = this.f12686a.read(bArr, i2, i8);
            if (i9 == -1) {
                throw new IndexOutOfBoundsException(a1.a.h(i8, "EOF trying to read ", " bytes"));
            }
            i8 -= i9;
            i2 += i9;
        }
    }

    @Override // j4.e
    public final int l() {
        try {
            return this.f12686a.readByte() & 255;
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // j4.e
    public final int n() {
        return (int) this.f12686a.f12868b;
    }

    @Override // j4.e
    public final void p(int i2) {
        try {
            this.f12686a.skip(i2);
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }
}
