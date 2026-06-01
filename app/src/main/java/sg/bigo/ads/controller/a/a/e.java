package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.a.k;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends g implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f16289a = r.f16037d.a(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f16290b = r.f16035b.a(30);
    private long g;
    private long h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<a> f16292f = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16291d = f16289a;
    private long e = f16290b;

    private static List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(AndroidStaticDeviceInfoDataSource.STORE_GOOGLE, "https://drive.google.com/uc?export=download&id=1ms4F7Cn_aInE9oFMMaZEiwMIuMKt1DZc", true));
        return arrayList;
    }

    @Override // sg.bigo.ads.controller.a.a.g
    @Nullable
    public final k a(String str) {
        a aVarA;
        synchronized (this) {
            try {
                if (sg.bigo.ads.common.utils.k.a((Collection) this.f16292f) || ((aVarA = g.a((List<a>) sg.bigo.ads.common.utils.k.a(this.f16292f, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.e.1
                    @Override // java.lang.Comparable
                    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
                        a aVar2 = aVar;
                        return (aVar2 == null || !aVar2.f16268d || aVar2.f16385b) ? 0 : 1;
                    }
                }))) == null && (aVarA = g.a((List<a>) sg.bigo.ads.common.utils.k.a(this.f16292f, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.e.2
                    @Override // java.lang.Comparable
                    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
                        a aVar2 = aVar;
                        return (aVar2 != null && aVar2.f16268d && aVar2.f16385b) ? 1 : 0;
                    }
                }))) == null)) {
                    return null;
                }
                return aVarA;
            } finally {
            }
        }
    }

    public final void b() {
        this.g = System.currentTimeMillis();
        synchronized (this) {
            try {
                if (!sg.bigo.ads.common.utils.k.a((Collection) this.f16292f)) {
                    Iterator<a> it = this.f16292f.iterator();
                    while (it.hasNext()) {
                        it.next().f16268d = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        synchronized (this) {
            parcel.writeLong(this.f16291d);
            parcel.writeLong(this.e);
            n.a(parcel, this.f16292f);
            parcel.writeLong(this.g);
            parcel.writeLong(this.h);
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        synchronized (this) {
            try {
                this.f16291d = n.a(parcel, f16289a);
                this.e = n.a(parcel, f16290b);
                List<a> listA = n.a(parcel, a.f16267c);
                this.f16292f = listA;
                if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                    this.f16292f = c();
                }
                this.g = n.a(parcel, 0L);
                this.h = n.a(parcel, 0L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(@NonNull JSONObject jSONObject) {
        synchronized (this) {
            try {
                long jOptLong = jSONObject.optLong("suc_interval", f16289a / 1000) * 1000;
                long j = g.f16305c;
                long jMax = Math.max(jOptLong, j);
                long jMax2 = Math.max(jSONObject.optLong("fail_interval", f16290b / 1000) * 1000, j);
                List<a> listC = c();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urls");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        String strOptString = jSONObjectOptJSONObject.optString("name", "");
                        String strOptString2 = jSONObjectOptJSONObject.optString("url", "");
                        if (URLUtil.isNetworkUrl(strOptString2)) {
                            listC.add(new a(strOptString, strOptString2, false));
                        }
                    }
                }
                this.f16291d = jMax;
                this.e = jMax2;
                this.f16292f = listC;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sg.bigo.ads.controller.a.a.g
    public final void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.h = System.currentTimeMillis();
        }
    }

    public final boolean a() {
        long j = this.g;
        long j3 = this.h;
        if (j == j3) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j > j3 ? Math.abs(jCurrentTimeMillis - this.g) > this.e : Math.abs(jCurrentTimeMillis - this.h) > this.f16291d;
    }
}
