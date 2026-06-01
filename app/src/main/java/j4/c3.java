package j4;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c3 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12143b;

    public /* synthetic */ c3(Object obj, int i2) {
        this.f12142a = i2;
        this.f12143b = obj;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        switch (this.f12142a) {
            case 1:
                break;
            case 2:
                ((l7.i0) this.f12143b).close();
                break;
            default:
                super.close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        switch (this.f12142a) {
            case 1:
                break;
            case 2:
                l7.i0 i0Var = (l7.i0) this.f12143b;
                if (!i0Var.f12866c) {
                    i0Var.flush();
                }
                break;
            default:
                super.flush();
                break;
        }
    }

    public String toString() {
        switch (this.f12142a) {
            case 1:
                return ((l7.j) this.f12143b) + ".outputStream()";
            case 2:
                return ((l7.i0) this.f12143b) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        int i8 = this.f12142a;
        Object obj = this.f12143b;
        switch (i8) {
            case 0:
                write(new byte[]{(byte) i2}, 0, 1);
                return;
            case 1:
                ((l7.j) obj).x(i2);
                return;
            default:
                l7.i0 i0Var = (l7.i0) obj;
                if (i0Var.f12866c) {
                    throw new IOException("closed");
                }
                i0Var.f12865b.x((byte) i2);
                i0Var.B();
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i2, int i8) throws IOException {
        switch (this.f12142a) {
            case 0:
                ((d3) this.f12143b).g(data, i2, i8);
                return;
            case 1:
                kotlin.jvm.internal.k.e(data, "data");
                ((l7.j) this.f12143b).m3451write(data, i2, i8);
                return;
            default:
                kotlin.jvm.internal.k.e(data, "data");
                l7.i0 i0Var = (l7.i0) this.f12143b;
                if (!i0Var.f12866c) {
                    i0Var.f12865b.m3451write(data, i2, i8);
                    i0Var.B();
                    return;
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }

    private final void b() {
    }
}
