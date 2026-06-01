package sg.bigo.ads.controller.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.C2228a4;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements sg.bigo.ads.common.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public AdConfig f16588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final Context f16589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.controller.b.d f16590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f16591d;
    String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f16592f;
    String g;
    String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f16593i;
    String j;
    String k;
    public int l;
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f16594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f16595o;
    int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    long f16596q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    long f16597r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f16598s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String f16599t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f16600u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f16601v = 0;

    public d(@NonNull Context context, @NonNull AdConfig adConfig, @NonNull sg.bigo.ads.controller.b.d dVar) {
        this.f16589b = context;
        this.f16588a = adConfig;
        this.f16590c = dVar;
    }

    @Override // sg.bigo.ads.common.g
    public final String A() {
        sg.bigo.ads.common.a aVarL = this.f16590c.L();
        return aVarL != null ? aVarL.f15555b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final String B() {
        return sg.bigo.ads.common.b.a.a(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final String C() {
        return this.f16590c.F();
    }

    @Override // sg.bigo.ads.common.g
    public final int D() {
        return (int) (r.b() / 1000);
    }

    @Override // sg.bigo.ads.common.g
    public final String E() {
        return this.f16590c.j();
    }

    @Override // sg.bigo.ads.common.g
    public final boolean F() {
        sg.bigo.ads.common.a aVarK = this.f16590c.K();
        if (aVarK != null) {
            return aVarK.f15556c;
        }
        return true;
    }

    @Override // sg.bigo.ads.common.g
    public final String G() {
        sg.bigo.ads.common.a aVarK = this.f16590c.K();
        return aVarK != null ? aVarK.f15555b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final String H() {
        return this.f16594n;
    }

    @Override // sg.bigo.ads.common.g
    public final String I() {
        return this.f16595o;
    }

    @Override // sg.bigo.ads.common.g
    public final int J() {
        return this.p;
    }

    @Override // sg.bigo.ads.common.g
    public final long K() {
        return this.f16596q;
    }

    @Override // sg.bigo.ads.common.g
    public final long L() {
        return this.f16597r;
    }

    @Override // sg.bigo.ads.common.g
    public final long M() {
        return p.a(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final long N() {
        return p.c();
    }

    @Override // sg.bigo.ads.common.g
    public final long O() {
        return p.a();
    }

    @Override // sg.bigo.ads.common.g
    public final String P() {
        return this.f16590c.l();
    }

    @Override // sg.bigo.ads.common.g
    public final String Q() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String R() {
        return q.d(sg.bigo.ads.common.aa.b.e(this.f16589b));
    }

    @Override // sg.bigo.ads.common.g
    public final String S() {
        return q.d(sg.bigo.ads.common.aa.b.c(this.f16589b));
    }

    @Override // sg.bigo.ads.common.g
    public final String T() {
        return this.f16599t;
    }

    @Override // sg.bigo.ads.common.g
    public final String U() {
        sg.bigo.ads.controller.b.d dVar = this.f16590c;
        return dVar != null ? dVar.G() : "";
    }

    @Override // sg.bigo.ads.common.g
    public final long V() {
        return h.a().e.f16639a;
    }

    @Override // sg.bigo.ads.common.g
    public final long W() {
        return h.a().e.f16640b;
    }

    @Override // sg.bigo.ads.common.g
    public final String X() {
        return sg.bigo.ads.common.x.a.r();
    }

    @Override // sg.bigo.ads.common.g
    public final long Y() {
        if (this.f16600u == 0) {
            try {
                Context context = this.f16589b;
                this.f16600u = sg.bigo.ads.common.utils.c.c(context, context.getPackageName());
            } catch (Exception unused) {
                this.f16600u = -1L;
            }
        }
        return this.f16600u;
    }

    @Override // sg.bigo.ads.common.g
    public final long Z() {
        if (this.f16601v == 0) {
            try {
                Context context = this.f16589b;
                this.f16601v = sg.bigo.ads.common.utils.c.d(context, context.getPackageName());
            } catch (Exception unused) {
                this.f16601v = -1L;
            }
        }
        return this.f16601v;
    }

    @Override // sg.bigo.ads.common.g
    @NonNull
    public final String a() {
        return this.f16588a.getAppKey();
    }

    @Override // sg.bigo.ads.common.g
    public final String aa() {
        return "official";
    }

    @Override // sg.bigo.ads.common.g
    public final int ab() {
        return this.f16598s;
    }

    @Override // sg.bigo.ads.common.g
    public final sg.bigo.ads.common.b ac() {
        if (this.f16590c.n().a(15)) {
            return sg.bigo.ads.common.aa.b.h(this.f16589b);
        }
        sg.bigo.ads.common.aa.b.j(this.f16589b);
        return null;
    }

    @Override // sg.bigo.ads.common.g
    public final boolean ad() {
        sg.bigo.ads.common.a aVarM = this.f16590c.M();
        if (aVarM != null) {
            return aVarM.f15556c;
        }
        return true;
    }

    @Override // sg.bigo.ads.common.g
    public final String ae() {
        sg.bigo.ads.common.a aVarM = this.f16590c.M();
        return aVarM != null ? aVarM.f15555b : "";
    }

    @Override // sg.bigo.ads.common.g
    public final Context af() {
        return this.f16589b;
    }

    @Override // sg.bigo.ads.common.g
    public final boolean ag() {
        return sg.bigo.ads.common.aa.b.k(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int ah() {
        return sg.bigo.ads.common.aa.b.l(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final boolean ai() {
        return sg.bigo.ads.common.aa.b.c();
    }

    @Override // sg.bigo.ads.common.g
    public final float aj() {
        return sg.bigo.ads.common.aa.b.m(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int ak() {
        return sg.bigo.ads.common.aa.b.o(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final float al() {
        return sg.bigo.ads.common.aa.b.p(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int am() {
        return sg.bigo.ads.common.aa.b.q(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int an() {
        return sg.bigo.ads.common.aa.b.r(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final boolean ao() {
        return sg.bigo.ads.common.aa.b.u(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int ap() {
        return sg.bigo.ads.common.aa.b.s(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final int aq() {
        return sg.bigo.ads.common.aa.b.t(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final long ar() {
        return sg.bigo.ads.common.aa.b.v(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final boolean as() {
        return sg.bigo.ads.common.aa.b.w(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final boolean at() {
        return sg.bigo.ads.common.aa.b.n(this.f16589b);
    }

    @Override // sg.bigo.ads.common.g
    public final boolean au() {
        return sg.bigo.ads.common.aa.b.d();
    }

    @Override // sg.bigo.ads.common.g
    public final String b() {
        return this.f16591d;
    }

    @Override // sg.bigo.ads.common.g
    public final String c() {
        return this.e;
    }

    @Override // sg.bigo.ads.common.g
    public final int d() {
        return this.f16592f;
    }

    @Override // sg.bigo.ads.common.g
    public final String e() {
        return this.f16588a.getChannel();
    }

    @Override // sg.bigo.ads.common.g
    public final int f() {
        return this.f16588a.getAge();
    }

    @Override // sg.bigo.ads.common.g
    public final int g() {
        return this.f16588a.getGender();
    }

    @Override // sg.bigo.ads.common.g
    public final long h() {
        return this.f16588a.getActivatedTime();
    }

    @Override // sg.bigo.ads.common.g
    public final String i() {
        return "android";
    }

    @Override // sg.bigo.ads.common.g
    public final String j() {
        return Build.VERSION.RELEASE;
    }

    @Override // sg.bigo.ads.common.g
    public final String k() {
        return this.g;
    }

    @Override // sg.bigo.ads.common.g
    public final String l() {
        return this.h;
    }

    @Override // sg.bigo.ads.common.g
    public final String m() {
        return this.f16593i;
    }

    @Override // sg.bigo.ads.common.g
    public final String n() {
        return this.j;
    }

    @Override // sg.bigo.ads.common.g
    public final String o() {
        return this.k;
    }

    @Override // sg.bigo.ads.common.g
    public final int p() {
        return this.l;
    }

    @Override // sg.bigo.ads.common.g
    public final String q() {
        return this.m;
    }

    @Override // sg.bigo.ads.common.g
    public final String r() {
        int iA = sg.bigo.ads.common.aa.c.a(this.f16589b);
        return iA != 1 ? iA != 2 ? iA != 3 ? iA != 4 ? iA != 5 ? "unknown" : "5g" : "4g" : C2228a4.f7946b : C2228a4.f7945a : "2g";
    }

    @Override // sg.bigo.ads.common.g
    public final String s() {
        return q.d(sg.bigo.ads.common.utils.c.a());
    }

    @Override // sg.bigo.ads.common.g
    public final String t() {
        String strK = this.f16590c.k();
        return !TextUtils.isEmpty(strK) ? strK : v();
    }

    @Override // sg.bigo.ads.common.g
    public final String u() {
        return this.f16590c.k();
    }

    @Override // sg.bigo.ads.common.g
    public final String v() {
        if (!TextUtils.isEmpty("")) {
            return "";
        }
        String strR = R();
        return !TextUtils.isEmpty(strR) ? strR : S();
    }

    @Override // sg.bigo.ads.common.g
    public final String w() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String x() {
        return "";
    }

    @Override // sg.bigo.ads.common.g
    public final String y() {
        return "5.5.1";
    }

    @Override // sg.bigo.ads.common.g
    public final boolean z() {
        sg.bigo.ads.common.a aVarL = this.f16590c.L();
        if (aVarL != null) {
            return aVarL.f15556c;
        }
        return true;
    }
}
