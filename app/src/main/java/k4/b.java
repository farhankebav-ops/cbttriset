package k4;

import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m4.i f12615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f12616b;

    public b(c cVar, m4.i iVar) {
        this.f12616b = cVar;
        this.f12615a = iVar;
    }

    public final void a(com.unity3d.scar.adapter.common.a aVar) {
        this.f12616b.l++;
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            if (iVar.e) {
                throw new IOException("closed");
            }
            int i2 = iVar.f12963d;
            if ((aVar.f10958b & 32) != 0) {
                i2 = ((int[]) aVar.f10959c)[5];
            }
            iVar.f12963d = i2;
            iVar.a(0, 0, (byte) 4, (byte) 1);
            iVar.f12960a.flush();
        }
    }

    public final void b() {
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            try {
                if (iVar.e) {
                    throw new IOException("closed");
                }
                Logger logger = m4.j.f12964a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(">> CONNECTION " + m4.j.f12965b.e());
                }
                iVar.f12960a.write(m4.j.f12965b.s());
                iVar.f12960a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12615a.close();
    }

    public final void e(m4.a aVar, byte[] bArr) {
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            try {
                if (iVar.e) {
                    throw new IOException("closed");
                }
                if (aVar.f12931a == -1) {
                    Locale locale = Locale.US;
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
                iVar.a(0, bArr.length + 8, (byte) 7, (byte) 0);
                iVar.f12960a.writeInt(0);
                iVar.f12960a.writeInt(aVar.f12931a);
                if (bArr.length > 0) {
                    iVar.f12960a.write(bArr);
                }
                iVar.f12960a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void flush() {
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            if (iVar.e) {
                throw new IOException("closed");
            }
            iVar.f12960a.flush();
        }
    }

    public final void g(boolean z2, int i2, int i8) {
        if (z2) {
            this.f12616b.l++;
        }
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            if (iVar.e) {
                throw new IOException("closed");
            }
            iVar.a(0, 8, (byte) 6, z2 ? (byte) 1 : (byte) 0);
            iVar.f12960a.writeInt(i2);
            iVar.f12960a.writeInt(i8);
            iVar.f12960a.flush();
        }
    }

    public final void i(int i2, m4.a aVar) {
        this.f12616b.l++;
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            if (iVar.e) {
                throw new IOException("closed");
            }
            if (aVar.f12931a == -1) {
                throw new IllegalArgumentException();
            }
            iVar.a(i2, 4, (byte) 3, (byte) 0);
            iVar.f12960a.writeInt(aVar.f12931a);
            iVar.f12960a.flush();
        }
    }

    public final void j(com.unity3d.scar.adapter.common.a aVar) {
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            try {
                if (iVar.e) {
                    throw new IOException("closed");
                }
                int i2 = 0;
                iVar.a(0, Integer.bitCount(aVar.f10958b) * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (aVar.d(i2)) {
                        iVar.f12960a.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                        iVar.f12960a.writeInt(((int[]) aVar.f10959c)[i2]);
                    }
                    i2++;
                }
                iVar.f12960a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(int i2, long j) {
        m4.i iVar = this.f12615a;
        synchronized (iVar) {
            if (iVar.e) {
                throw new IOException("closed");
            }
            if (j == 0 || j > 2147483647L) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j);
            }
            iVar.a(i2, 4, (byte) 8, (byte) 0);
            iVar.f12960a.writeInt((int) j);
            iVar.f12960a.flush();
        }
    }
}
