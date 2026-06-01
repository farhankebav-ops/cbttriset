package m4;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import l7.j0;
import l7.o0;
import l7.r0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f12949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f12951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12952d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short f12953f;

    public f(j0 j0Var) {
        this.f12949a = j0Var;
    }

    @Override // l7.o0
    public final long read(l7.j jVar, long j) throws IOException {
        int i2;
        int i8;
        do {
            int i9 = this.e;
            j0 j0Var = this.f12949a;
            if (i9 == 0) {
                j0Var.skip(this.f12953f);
                this.f12953f = (short) 0;
                if ((this.f12951c & 4) == 0) {
                    i2 = this.f12952d;
                    int iA = j.a(j0Var);
                    this.e = iA;
                    this.f12950b = iA;
                    byte b8 = (byte) (j0Var.readByte() & 255);
                    this.f12951c = (byte) (j0Var.readByte() & 255);
                    Logger logger = j.f12964a;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(g.a(true, this.f12952d, this.f12950b, b8, this.f12951c));
                    }
                    i8 = j0Var.readInt() & Integer.MAX_VALUE;
                    this.f12952d = i8;
                    if (b8 != 9) {
                        j.c("%s != TYPE_CONTINUATION", Byte.valueOf(b8));
                        throw null;
                    }
                }
            } else {
                long j3 = j0Var.read(jVar, Math.min(j, i9));
                if (j3 != -1) {
                    this.e -= (int) j3;
                    return j3;
                }
            }
            return -1L;
        } while (i8 == i2);
        j.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // l7.o0
    public final r0 timeout() {
        return this.f12949a.f12869a.timeout();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
