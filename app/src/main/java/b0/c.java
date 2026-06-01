package b0;

import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.rp;
import com.bytedance.sdk.component.utils.oeT;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f4122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f4123d;
    public final long e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RandomAccessFile f4125i;
    public final com.bykv.vk.openvk.IlO.IlO.IlO.EO.a j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f4120a = -2147483648L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4121b = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f4124f = -100;
    public volatile boolean g = false;
    public volatile boolean h = false;

    public c(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        this.e = 0L;
        this.f4125i = null;
        this.j = aVar;
        try {
            File fileC = n7.b.c(aVar.Cc(), aVar.cl());
            this.f4122c = fileC;
            File fileA = n7.b.a(aVar.Cc(), aVar.cl());
            this.f4123d = fileA;
            if (fileA.exists()) {
                this.f4125i = new RandomAccessFile(fileA, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            } else {
                this.f4125i = new RandomAccessFile(fileC, "rw");
            }
            if (fileA.exists()) {
                return;
            }
            this.e = fileC.length();
            a();
        } catch (Throwable unused) {
            aVar.zPa();
        }
    }

    public static void b(c cVar, int i2, String str) {
        JSONObject jSONObjectEO;
        cVar.h = false;
        cVar.f4124f = i2;
        cVar.f4120a = -1L;
        oeT.MY("CSJ_MediaDLPlay", "handleFailResponse: ", Integer.valueOf(i2), " ", str);
        if (!cVar.j.IlO() || (jSONObjectEO = cVar.j.EO()) == null) {
            return;
        }
        try {
            jSONObjectEO.put("error_real_code", i2);
            jSONObjectEO.put("error_real_msg", str);
        } catch (Throwable th) {
            oeT.IlO("CSJ_MediaDLPlay", "handleFailResponse: ", th);
        }
    }

    public static void c(c cVar) {
        synchronized (cVar.f4121b) {
            if (cVar.f4123d.exists()) {
                cVar.j.zPa();
                cVar.j.cl();
                return;
            }
            try {
            } finally {
            }
            if (!cVar.f4122c.renameTo(cVar.f4123d)) {
                throw new IOException("Error renaming file " + cVar.f4122c + " to " + cVar.f4123d + " for completion!");
            }
            RandomAccessFile randomAccessFile = cVar.f4125i;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            cVar.f4125i = new RandomAccessFile(cVar.f4123d, "rw");
            cVar.j.cl();
            cVar.j.zPa();
        }
    }

    public final void a() {
        EV.IlO ilOMY = r.a.a() != null ? r.a.a().MY() : new EV.IlO("v_cache");
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar = this.j;
        long jEs = aVar.es();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ilOMY.IlO(jEs, timeUnit).MY(aVar.xF(), timeUnit).EO(aVar.AXM(), timeUnit);
        EV evIlO = ilOMY.IlO();
        aVar.cl();
        evIlO.IlO(new rp.IlO().IlO("RANGE", a1.a.p(new StringBuilder("bytes="), this.e, "-")).MY(aVar.zPa()).IlO().IlO("videoLoadWhenPlaying").IlO(9).MY()).IlO(new a4.a(this, 4));
    }
}
