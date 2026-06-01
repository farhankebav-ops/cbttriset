package l7;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends q {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Closeable f12840f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(boolean z2, Closeable closeable, int i2) {
        super(z2);
        this.e = i2;
        this.f12840f = closeable;
    }

    private final synchronized void l() {
        ((RandomAccessFile) this.f12840f).close();
    }

    private final synchronized void n() {
        ((FileChannel) this.f12840f).close();
    }

    private final synchronized void o() {
        ((RandomAccessFile) this.f12840f).getFD().sync();
    }

    private final synchronized void p() {
        ((FileChannel) this.f12840f).force(true);
    }

    private final synchronized int q(long j, byte[] array, int i2, int i8) {
        kotlin.jvm.internal.k.e(array, "array");
        ((RandomAccessFile) this.f12840f).seek(j);
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                break;
            }
            int i10 = ((RandomAccessFile) this.f12840f).read(array, i2, i8 - i9);
            if (i10 != -1) {
                i9 += i10;
            } else if (i9 == 0) {
                return -1;
            }
        }
        return i9;
    }

    private final synchronized int r(long j, byte[] array, int i2, int i8) {
        kotlin.jvm.internal.k.e(array, "array");
        ((FileChannel) this.f12840f).position(j);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i2, i8);
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                break;
            }
            int i10 = ((FileChannel) this.f12840f).read(byteBufferWrap);
            if (i10 != -1) {
                i9 += i10;
            } else if (i9 == 0) {
                return -1;
            }
        }
        return i9;
    }

    private final synchronized long s() {
        return ((RandomAccessFile) this.f12840f).length();
    }

    private final synchronized long t() {
        return ((FileChannel) this.f12840f).size();
    }

    private final synchronized void u(long j, byte[] array, int i2, int i8) {
        kotlin.jvm.internal.k.e(array, "array");
        ((RandomAccessFile) this.f12840f).seek(j);
        ((RandomAccessFile) this.f12840f).write(array, i2, i8);
    }

    private final synchronized void v(long j, byte[] array, int i2, int i8) {
        kotlin.jvm.internal.k.e(array, "array");
        ((FileChannel) this.f12840f).position(j);
        ((FileChannel) this.f12840f).write(ByteBuffer.wrap(array, i2, i8));
    }

    @Override // l7.q
    public final synchronized void a() {
        switch (this.e) {
            case 0:
                l();
                break;
            default:
                n();
                break;
        }
    }

    @Override // l7.q
    public final synchronized void b() {
        switch (this.e) {
            case 0:
                o();
                break;
            default:
                p();
                break;
        }
    }

    @Override // l7.q
    public final synchronized int e(long j, byte[] bArr, int i2, int i8) {
        switch (this.e) {
            case 0:
                return q(j, bArr, i2, i8);
            default:
                return r(j, bArr, i2, i8);
        }
    }

    @Override // l7.q
    public final synchronized long g() {
        switch (this.e) {
            case 0:
                return s();
            default:
                return t();
        }
    }

    @Override // l7.q
    public final synchronized void i(long j, byte[] bArr, int i2, int i8) {
        switch (this.e) {
            case 0:
                u(j, bArr, i2, i8);
                break;
            default:
                v(j, bArr, i2, i8);
                break;
        }
    }
}
