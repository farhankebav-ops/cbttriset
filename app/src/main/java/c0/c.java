package c0;

import android.content.Context;
import com.bytedance.sdk.component.MY.IlO.EV;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bykv.vk.openvk.IlO.IlO.IlO.EO.a f4164b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f4166d;
    public final File e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f4165c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f4167f = new ArrayList();
    public volatile boolean g = false;

    public c(Context context, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        this.f4166d = null;
        this.e = null;
        this.f4163a = context;
        this.f4164b = aVar;
        this.f4166d = n7.b.c(aVar.Cc(), aVar.cl());
        this.e = n7.b.a(aVar.Cc(), aVar.cl());
    }

    public static void a(c cVar, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, int i2, String str) {
        synchronized (t.a.class) {
            try {
                ArrayList arrayList = cVar.f4167f;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    t.a aVar2 = (t.a) obj;
                    if (aVar2 != null) {
                        aVar2.IlO(aVar, i2, str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(c cVar, Closeable closeable) {
        cVar.getClass();
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void e(c cVar) {
        File file = cVar.e;
        File file2 = cVar.f4166d;
        try {
            if (file2.renameTo(file)) {
                return;
            }
            throw new IOException("Error renaming file " + file2 + " to " + file + " for completion!");
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void c(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, int i2) {
        synchronized (t.a.class) {
            try {
                ArrayList arrayList = this.f4167f;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    t.a aVar2 = (t.a) obj;
                    if (aVar2 != null) {
                        aVar2.IlO(aVar, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(t.a aVar) {
        if (this.g) {
            synchronized (t.a.class) {
                this.f4167f.add(aVar);
            }
            return;
        }
        this.f4167f.add(aVar);
        File file = this.f4166d;
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar2 = this.f4164b;
        boolean z2 = true;
        if (this.e.exists() || (!aVar2.hp() && (file.length() >= aVar2.vCE() || (aVar2.tV() > 0 && file.length() >= aVar2.tV())))) {
            this.f4164b.lEW(1);
            c(this.f4164b, 200);
            a.a(this.f4164b);
            return;
        }
        this.g = true;
        this.f4164b.lEW(0);
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar3 = this.f4164b;
        EV.IlO ilOMY = r.a.a() != null ? r.a.a().MY() : new EV.IlO("v_preload");
        long jEs = aVar3.es();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ilOMY.IlO(jEs, timeUnit).MY(aVar3.xF(), timeUnit).EO(aVar3.AXM(), timeUnit);
        EV evIlO = ilOMY.IlO();
        rp.IlO ilO = new rp.IlO();
        long length = this.f4166d.length();
        int iVCE = aVar3.vCE();
        boolean zHp = aVar3.hp();
        int iTV = aVar3.tV();
        if (iTV <= 0) {
            z2 = zHp;
        } else if (iTV < aVar3.rp()) {
            z2 = zHp;
            iVCE = iTV;
        }
        ilO.IlO("videoPreload").IlO(6);
        if (z2) {
            ilO.IlO("RANGE", "bytes=" + length + "-").MY(aVar3.zPa()).IlO().MY();
        } else {
            ilO.IlO("RANGE", "bytes=" + length + "-" + iVCE).MY(aVar3.zPa()).IlO().MY();
        }
        evIlO.IlO(ilO.MY()).IlO(new b(this, length));
    }
}
