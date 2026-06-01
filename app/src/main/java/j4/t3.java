package j4;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t3 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f12478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12479d = -1;

    public t3(byte[] bArr, int i2, int i8) {
        r2.q.y(i2 >= 0, "offset must be >= 0");
        r2.q.y(i8 >= 0, "length must be >= 0");
        int i9 = i8 + i2;
        r2.q.y(i9 <= bArr.length, "offset + length exceeds array boundary");
        this.f12478c = bArr;
        this.f12476a = i2;
        this.f12477b = i9;
    }

    @Override // j4.e
    public final void b() {
        this.f12479d = this.f12476a;
    }

    @Override // j4.e
    public final e g(int i2) {
        a(i2);
        int i8 = this.f12476a;
        this.f12476a = i8 + i2;
        return new t3(this.f12478c, i8, i2);
    }

    @Override // j4.e
    public final void i(OutputStream outputStream, int i2) throws IOException {
        a(i2);
        outputStream.write(this.f12478c, this.f12476a, i2);
        this.f12476a += i2;
    }

    @Override // j4.e
    public final void j(ByteBuffer byteBuffer) {
        r2.q.D(byteBuffer, "dest");
        int iRemaining = byteBuffer.remaining();
        a(iRemaining);
        byteBuffer.put(this.f12478c, this.f12476a, iRemaining);
        this.f12476a += iRemaining;
    }

    @Override // j4.e
    public final void k(byte[] bArr, int i2, int i8) {
        System.arraycopy(this.f12478c, this.f12476a, bArr, i2, i8);
        this.f12476a += i8;
    }

    @Override // j4.e
    public final int l() {
        a(1);
        int i2 = this.f12476a;
        this.f12476a = i2 + 1;
        return this.f12478c[i2] & 255;
    }

    @Override // j4.e
    public final int n() {
        return this.f12477b - this.f12476a;
    }

    @Override // j4.e
    public final void o() {
        int i2 = this.f12479d;
        if (i2 == -1) {
            throw new InvalidMarkException();
        }
        this.f12476a = i2;
    }

    @Override // j4.e
    public final void p(int i2) {
        a(i2);
        this.f12476a += i2;
    }
}
