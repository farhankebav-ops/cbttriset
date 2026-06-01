package a0;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import b0.c;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends MediaDataSource {
    public static final ConcurrentHashMap e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3200b = -2147483648L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bykv.vk.openvk.IlO.IlO.IlO.EO.a f3202d;

    public a(Context context, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        this.f3201c = context;
        this.f3202d = aVar;
        this.f3199a = new c(aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3202d.zPa();
        c cVar = this.f3199a;
        if (cVar != null) {
            try {
                if (!cVar.g) {
                    cVar.f4125i.close();
                }
                File file = cVar.f4122c;
                if (file != null) {
                    file.setLastModified(System.currentTimeMillis());
                }
                File file2 = cVar.f4123d;
                if (file2 != null) {
                    file2.setLastModified(System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            cVar.g = true;
        }
        e.remove(this.f3202d.cl());
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        if (this.f3200b == -2147483648L) {
            long j = -1;
            if (this.f3201c == null || TextUtils.isEmpty(this.f3202d.zPa())) {
                return -1L;
            }
            c cVar = this.f3199a;
            if (cVar.f4123d.exists()) {
                cVar.f4120a = cVar.f4123d.length();
            } else {
                synchronized (cVar.f4121b) {
                    int i2 = 0;
                    while (cVar.f4120a == -2147483648L) {
                        try {
                            i2 += 15;
                            try {
                                cVar.f4121b.wait(5L);
                                if (i2 > 20000) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new IOException("total length InterruptException");
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                this.f3200b = j;
            }
            j = cVar.f4120a;
            this.f3200b = j;
        }
        return this.f3200b;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i2, int i8) throws IOException {
        c cVar = this.f3199a;
        cVar.getClass();
        try {
            int i9 = -1;
            if (j != cVar.f4120a) {
                int i10 = 0;
                int i11 = 0;
                do {
                    if (!cVar.g) {
                        synchronized (cVar.f4121b) {
                            try {
                                File file = cVar.f4123d;
                                if (j < (file.exists() ? file.length() : cVar.f4122c.length())) {
                                    cVar.f4125i.seek(j);
                                    i11 = cVar.f4125i.read(bArr, i2, i8);
                                } else {
                                    i10 += 33;
                                    cVar.f4121b.wait(33L);
                                }
                            } finally {
                            }
                        }
                        if (i11 > 0) {
                            i9 = i11;
                        } else if (cVar.j.IlO() && cVar.f4124f != -100 && (!cVar.h || cVar.f4120a == -1)) {
                            throw new IOException();
                        }
                    }
                } while (i10 < 20000);
                throw new SocketTimeoutException();
            }
            int length = bArr.length;
            Objects.toString(Thread.currentThread());
            return i9;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }
}
