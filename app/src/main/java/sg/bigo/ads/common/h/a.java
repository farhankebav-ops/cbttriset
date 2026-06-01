package sg.bigo.ads.common.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.f;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15730d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15731f;
    public long g;
    public long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f15732i;
    long m;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f15735q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c f15737s;
    public int j = 0;
    public int k = 0;
    public long l = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15733n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15734o = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private C0288a f15736r = new C0288a();

    /* JADX INFO: renamed from: sg.bigo.ads.common.h.a$a, reason: collision with other inner class name */
    public static class C0288a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15738a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15739b = false;

        public final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("support_pd_flag", Integer.valueOf(this.f15738a));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2, boolean z7, boolean z8, @Nullable c cVar) {
        this.f15728b = str;
        this.f15729c = str2;
        this.f15730d = str3;
        this.e = z2 ? 1 : 0;
        this.f15731f = z8;
        this.f15735q = z7;
        String strA = a();
        long jA = f.a(strA, 1);
        this.g = jA <= 0 ? f.a(f.d(strA), 1) : jA;
        String strValueOf = String.valueOf(str.hashCode());
        this.f15727a = strValueOf;
        this.f15737s = cVar;
        StringBuilder sbY = a1.a.y("newInstance mId = ", strValueOf, ", savedSize = ");
        sbY.append(this.g);
        sbY.append(", mIsSupportFillTime = ");
        sbY.append(c());
        sg.bigo.ads.common.t.a.a(0, 3, "DownloadInfo", sbY.toString());
    }

    public final String a() {
        return this.f15729c + File.separator + this.f15730d;
    }

    public final boolean b() {
        return this.j == 3;
    }

    public final boolean c() {
        c cVar = this.f15737s;
        return cVar != null && cVar.f15780a;
    }

    public final boolean d() {
        c cVar = this.f15737s;
        return cVar != null && cVar.f15781b;
    }

    public final int e() {
        c cVar = this.f15737s;
        if (cVar != null) {
            return cVar.f15782c;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.f15728b.equals(aVar.f15728b) && this.f15730d.equals(aVar.f15730d) && this.f15729c.equals(aVar.f15729c);
    }

    public final int f() {
        c cVar = this.f15737s;
        if (cVar != null) {
            return cVar.f15783d;
        }
        return 5;
    }

    public final int g() {
        c cVar = this.f15737s;
        if (cVar != null) {
            return cVar.e;
        }
        return 20;
    }

    public final boolean h() {
        if (this.f15728b.endsWith(".mp4") && this.f15736r.f15738a == -1) {
            if (f.a(f.d(a()))) {
                this.f15736r.f15738a = 1;
            } else {
                this.f15736r.f15738a = 0;
            }
        }
        return this.f15736r.f15738a == 1;
    }

    @NonNull
    public String toString() {
        return " url = " + this.f15728b + ", fileName = " + this.f15730d + ", filePath = " + this.f15729c + ", downloadCount = " + this.k + ", totalSize = " + this.f15732i + ", loadedSize = " + this.g + ", mState = " + this.j + ", mLastDownloadEndTime = " + this.l + ", mExt = " + this.f15736r.a() + ", contentType = " + this.p + " isSupportFillTime = " + c() + " adFillTime = " + e() + " adCheckProcessTime = " + f() + " adCheckMinProcess = " + g();
    }
}
