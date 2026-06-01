package m4;

import java.io.Closeable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import l7.i0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f12960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7.j f12961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f12962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12963d;
    public boolean e;

    public i(i0 i0Var) {
        this.f12960a = i0Var;
        l7.j jVar = new l7.j();
        this.f12961b = jVar;
        this.f12962c = new d(jVar);
        this.f12963d = 16384;
    }

    public final void a(int i2, int i8, byte b8, byte b9) {
        Logger logger = j.f12964a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(g.a(false, i2, i8, b8, b9));
        }
        int i9 = this.f12963d;
        if (i8 > i9) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("FRAME_SIZE_ERROR length > ", i9, ": ", i8));
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException(a1.a.g(i2, "reserved bit set: "));
        }
        i0 i0Var = this.f12960a;
        i0Var.writeByte((i8 >>> 16) & 255);
        i0Var.writeByte((i8 >>> 8) & 255);
        i0Var.writeByte(i8 & 255);
        i0Var.writeByte(b8 & 255);
        i0Var.writeByte(b9 & 255);
        i0Var.writeInt(i2 & Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r18, int r19, java.util.List r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.i.b(boolean, int, java.util.List):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.e = true;
        this.f12960a.close();
    }
}
