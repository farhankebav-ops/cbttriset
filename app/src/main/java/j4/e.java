package j4;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e implements Closeable {
    public final void a(int i2) {
        if (n() < i2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean e() {
        return this instanceof t3;
    }

    public abstract e g(int i2);

    public abstract void i(OutputStream outputStream, int i2);

    public abstract void j(ByteBuffer byteBuffer);

    public abstract void k(byte[] bArr, int i2, int i8);

    public abstract int l();

    public abstract int n();

    public void o() {
        throw new UnsupportedOperationException();
    }

    public abstract void p(int i2);

    public void b() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
