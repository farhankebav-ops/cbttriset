package l7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f12863b;

    public /* synthetic */ i(l lVar, int i2) {
        this.f12862a = i2;
        this.f12863b = lVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.f12862a) {
            case 0:
                jMin = Math.min(((j) this.f12863b).f12868b, Integer.MAX_VALUE);
                break;
            default:
                j0 j0Var = (j0) this.f12863b;
                if (j0Var.f12871c) {
                    throw new IOException("closed");
                }
                jMin = Math.min(j0Var.f12870b.f12868b, Integer.MAX_VALUE);
                break;
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f12862a) {
            case 0:
                break;
            default:
                ((j0) this.f12863b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f12862a) {
            case 0:
                j jVar = (j) this.f12863b;
                if (jVar.f12868b > 0) {
                    return jVar.readByte() & 255;
                }
                return -1;
            default:
                j0 j0Var = (j0) this.f12863b;
                j jVar2 = j0Var.f12870b;
                if (j0Var.f12871c) {
                    throw new IOException("closed");
                }
                if (jVar2.f12868b == 0 && j0Var.f12869a.read(jVar2, 8192L) == -1) {
                    return -1;
                }
                return jVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f12862a) {
            case 0:
                return ((j) this.f12863b) + ".inputStream()";
            default:
                return ((j0) this.f12863b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream out) throws IOException {
        switch (this.f12862a) {
            case 1:
                kotlin.jvm.internal.k.e(out, "out");
                j0 j0Var = (j0) this.f12863b;
                j jVar = j0Var.f12870b;
                if (j0Var.f12871c) {
                    throw new IOException("closed");
                }
                long j = 0;
                while (true) {
                    if (jVar.f12868b == 0 && j0Var.f12869a.read(jVar, 8192L) == -1) {
                        return j;
                    }
                    long j3 = jVar.f12868b;
                    j += j3;
                    jVar.b0(out, j3);
                }
                break;
            default:
                return super.transferTo(out);
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i2, int i8) throws IOException {
        switch (this.f12862a) {
            case 0:
                kotlin.jvm.internal.k.e(sink, "sink");
                return ((j) this.f12863b).read(sink, i2, i8);
            default:
                kotlin.jvm.internal.k.e(sink, "data");
                j0 j0Var = (j0) this.f12863b;
                j jVar = j0Var.f12870b;
                if (!j0Var.f12871c) {
                    b.e(sink.length, i2, i8);
                    if (jVar.f12868b == 0 && j0Var.f12869a.read(jVar, 8192L) == -1) {
                        return -1;
                    }
                    return jVar.read(sink, i2, i8);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
