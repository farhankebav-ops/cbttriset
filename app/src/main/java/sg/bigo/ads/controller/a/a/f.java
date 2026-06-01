package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.a.i;
import sg.bigo.ads.controller.a.k;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends g implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f16295a = r.f16036c.a(2);
    private long e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f16297d = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16296b = f16295a;

    public static class a extends sg.bigo.ads.controller.a.a.a {
        private static final f.a<a> e = new f.a<a>() { // from class: sg.bigo.ads.controller.a.a.f.a.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new a();
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f16304f;

        public a() {
        }

        @Override // sg.bigo.ads.controller.a.k, sg.bigo.ads.common.f
        public final void b(@NonNull Parcel parcel) {
            super.b(parcel);
            this.f16304f = n.a(parcel, "");
        }

        public a(String str, String str2, boolean z2, String str3) {
            super(str, str2, z2);
            this.f16304f = str3;
        }

        @Override // sg.bigo.ads.controller.a.k, sg.bigo.ads.common.f
        public final void a(@NonNull Parcel parcel) {
            super.a(parcel);
            parcel.writeString(this.f16304f);
        }
    }

    @Nullable
    private k b(final String str) {
        k kVarA;
        synchronized (this) {
            try {
                if (!sg.bigo.ads.common.utils.k.a((Collection) this.f16297d)) {
                    a aVar = (a) g.a(sg.bigo.ads.common.utils.k.a(this.f16297d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.1
                        @Override // java.lang.Comparable
                        public final /* synthetic */ int compareTo(a aVar2) {
                            a aVar3 = aVar2;
                            return (aVar3 == null || !aVar3.f16268d || aVar3.f16385b || !TextUtils.equals(aVar3.f16304f, str)) ? 0 : 1;
                        }
                    }));
                    if (aVar != null) {
                        return aVar;
                    }
                    List listA = sg.bigo.ads.common.utils.k.a(this.f16297d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.2
                        @Override // java.lang.Comparable
                        public final /* synthetic */ int compareTo(a aVar2) {
                            a aVar3 = aVar2;
                            return (aVar3 != null && aVar3.f16268d && aVar3.f16385b && TextUtils.equals(aVar3.f16304f, str)) ? 1 : 0;
                        }
                    });
                    if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                        listA = sg.bigo.ads.common.utils.k.a(this.f16297d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.3
                            @Override // java.lang.Comparable
                            public final /* bridge */ /* synthetic */ int compareTo(a aVar2) {
                                a aVar3 = aVar2;
                                return (aVar3 == null || !aVar3.f16268d || aVar3.f16385b) ? 0 : 1;
                            }
                        });
                        if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                            kVarA = (a) g.a(sg.bigo.ads.common.utils.k.a(this.f16297d, new Comparable<a>() { // from class: sg.bigo.ads.controller.a.a.f.4
                                @Override // java.lang.Comparable
                                public final /* bridge */ /* synthetic */ int compareTo(a aVar2) {
                                    a aVar3 = aVar2;
                                    return (aVar3 != null && aVar3.f16268d && aVar3.f16385b) ? 1 : 0;
                                }
                            }));
                            if (kVarA != null) {
                            }
                        } else {
                            kVarA = g.a((List<k>) listA);
                        }
                    } else {
                        kVarA = g.a((List<k>) listA);
                    }
                    return kVarA;
                }
                return null;
            } finally {
            }
        }
    }

    private static List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("AWS", "https://ad-host-backup-asia.oss-ap-southeast-1.aliyuncs.com/uni/v2/au.pj", true, "asia"));
        arrayList.add(new a("AWS", "https://ad-host-backup-europe.oss-eu-central-1.aliyuncs.com/uni/v2/au.pj", true, "europe"));
        arrayList.add(new a("AWS", "https://ad-host-backup-america.oss-us-west-1.aliyuncs.com/uni/v2/au.pj", true, "america"));
        return arrayList;
    }

    @Override // sg.bigo.ads.controller.a.a.g
    @Nullable
    public final k a(String str) {
        if (sg.bigo.ads.common.utils.k.a((Collection) this.f16297d)) {
            return null;
        }
        return b(i.a(str));
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        synchronized (this) {
            parcel.writeLong(this.f16296b);
            n.a(parcel, this.f16297d);
            parcel.writeLong(this.e);
        }
    }

    public final void b() {
        this.e = System.currentTimeMillis();
        synchronized (this) {
            try {
                if (!sg.bigo.ads.common.utils.k.a((Collection) this.f16297d)) {
                    Iterator<a> it = this.f16297d.iterator();
                    while (it.hasNext()) {
                        it.next().f16268d = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(@NonNull JSONObject jSONObject) {
        synchronized (this) {
            try {
                long jMax = Math.max(jSONObject.optLong("interval", f16295a / 1000) * 1000, g.f16305c);
                List<a> listC = c();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urls");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        String strOptString = jSONObjectOptJSONObject.optString("name", "");
                        String strOptString2 = jSONObjectOptJSONObject.optString("url", "");
                        String strOptString3 = jSONObjectOptJSONObject.optString("region", "");
                        if (URLUtil.isNetworkUrl(strOptString2)) {
                            listC.add(new a(strOptString, strOptString2, false, strOptString3));
                        }
                    }
                }
                this.f16296b = jMax;
                this.f16297d = listC;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        synchronized (this) {
            try {
                this.f16296b = n.a(parcel, f16295a);
                List<a> listA = n.a(parcel, a.e);
                this.f16297d = listA;
                if (sg.bigo.ads.common.utils.k.a((Collection) listA)) {
                    this.f16297d = c();
                }
                this.e = n.a(parcel, 0L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean a() {
        return Math.abs(System.currentTimeMillis() - this.e) > this.f16296b;
    }
}
