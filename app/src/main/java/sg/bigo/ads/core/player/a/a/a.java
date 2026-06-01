package sg.bigo.ads.core.player.a.a;

import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import sg.bigo.ads.common.utils.f;
import sg.bigo.ads.core.d.b;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements sg.bigo.ads.core.player.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f17273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public sg.bigo.ads.common.h.a f17274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RandomAccessFile f17275c;

    public a(sg.bigo.ads.common.h.a aVar) {
        try {
            this.f17274b = aVar;
            File file = new File(aVar.a());
            this.f17273a = file;
            this.f17273a = file.exists() ? this.f17273a : new File(this.f17273a.getParentFile(), f.c(this.f17273a.getName()));
            this.f17275c = new RandomAccessFile(this.f17273a, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        } catch (IOException e) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error using file " + this.f17273a + " as disc cache, error message is : " + e.toString());
        }
    }

    @Override // sg.bigo.ads.core.player.a.a
    public final synchronized int a(byte[] bArr, long j) {
        int i2;
        i2 = 0;
        try {
            this.f17275c.seek(j);
            i2 = this.f17275c.read(bArr, 0, 8192);
        } catch (IOException e) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error reading 8192 bytes with offset " + j + " from file[" + a() + " bytes] to buffer[" + bArr.length + " bytes], error message is : " + e.toString());
        }
        return i2;
    }

    @Override // sg.bigo.ads.core.player.a.a
    public final synchronized void b() {
        try {
            this.f17275c.close();
        } catch (IOException e) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error closing file " + this.f17273a + ", error message is : " + e.toString());
        }
    }

    @Override // sg.bigo.ads.core.player.a.a
    public final synchronized boolean c() {
        return this.f17274b.b();
    }

    @Override // sg.bigo.ads.core.player.a.a
    public final synchronized long a() {
        long length;
        try {
            length = this.f17275c.length();
        } catch (IOException e) {
            b.a(3005, 10112, e.toString());
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Error reading length of file " + this.f17273a + ", error message is : " + e.toString());
            length = 0;
        }
        return length;
    }
}
