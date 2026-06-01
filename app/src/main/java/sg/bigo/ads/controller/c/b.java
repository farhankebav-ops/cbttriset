package sg.bigo.ads.controller.c;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public class b implements sg.bigo.ads.api.core.c {
    int A;
    public final Map<String, String> B;
    int C;

    @Nullable
    private JSONObject D;
    private final long E;
    private final long G;

    @NonNull
    private final sg.bigo.ads.api.core.h H;
    private long I;
    private int J;
    private int K;
    private boolean M;
    private long N;
    private final String O;
    private String P;
    private boolean Q;
    private boolean R;
    private String S;
    private final double U;
    private String V;
    private final boolean W;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    List<sg.bigo.ads.api.core.c> f16453a;
    private c.d aa;
    private String ab;
    private int ac;
    private int ad;
    private boolean ae;
    private int af;
    private boolean ag;
    private int ai;
    private int aj;
    private sg.bigo.ads.api.core.q ak;
    private String al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private String ar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    protected final sg.bigo.ads.api.a.l f16454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected String f16455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    protected String f16456d;

    @Nullable
    protected String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    protected String f16457f;

    @NonNull
    protected final String g;
    protected int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f16458i;
    protected long j;

    @Nullable
    protected String k;

    @Nullable
    protected String l;

    @Nullable
    protected c.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    protected c.f[] f16459n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    protected c.f[] f16460o;

    @Nullable
    protected c.f[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    protected c.f[] f16461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    protected List<c.InterfaceC0279c> f16462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    protected String f16463s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected long f16464t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    protected String f16465u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    protected String f16466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    protected c.b f16467w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected c.a f16468x;
    sg.bigo.ads.api.a.m y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f16469z;
    private int L = 0;
    private int T = 2;
    private int ah = 1;
    private sg.bigo.ads.api.core.j aq = new sg.bigo.ads.api.core.j();
    private final long F = SystemClock.elapsedRealtime();

    public b(long j, @NonNull sg.bigo.ads.api.core.h hVar, @NonNull sg.bigo.ads.api.a.l lVar, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        this.am = 1;
        this.an = 0;
        this.ao = 1;
        this.C = 0;
        this.ar = "";
        this.G = j;
        this.H = hVar;
        this.f16454b = lVar;
        this.f16455c = jSONObject.optString("ad_id", "");
        this.f16456d = jSONObject.optString("title", "");
        this.e = jSONObject.optString("description", "");
        this.f16457f = jSONObject.optString(C2300e4.h.G0, "");
        String strOptString = jSONObject.optString("dsp_name", "");
        this.g = strOptString;
        this.W = "BigoDsp".equalsIgnoreCase(strOptString);
        this.h = jSONObject.optInt("adx_type", 0);
        this.f16458i = jSONObject.optInt("ad_type", -1);
        this.j = jSONObject.optLong(Q6.f7434c1);
        this.k = jSONObject.optString("creative_id", "");
        this.l = jSONObject.optString("series_id", "");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("privacy");
        if (jSONObjectOptJSONObject != null) {
            this.m = new o(jSONObjectOptJSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("track_clicks_third");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    arrayList.add(new q(jSONObjectOptJSONObject2));
                }
            }
            c.f[] fVarArr = new c.f[arrayList.size()];
            this.f16460o = fVarArr;
            this.f16460o = (c.f[]) arrayList.toArray(fVarArr);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("track_impls_third");
        if (jSONArrayOptJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i8);
                if (jSONObjectOptJSONObject3 != null) {
                    arrayList2.add(new q(jSONObjectOptJSONObject3));
                }
            }
            c.f[] fVarArr2 = new c.f[arrayList2.size()];
            this.f16459n = fVarArr2;
            this.f16459n = (c.f[]) arrayList2.toArray(fVarArr2);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ad_nurls");
        if (jSONArrayOptJSONArray3 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (int i9 = 0; i9 < jSONArrayOptJSONArray3.length(); i9++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray3.optJSONObject(i9);
                if (jSONObjectOptJSONObject4 != null) {
                    arrayList3.add(new q(jSONObjectOptJSONObject4));
                }
            }
            c.f[] fVarArr3 = new c.f[arrayList3.size()];
            this.p = fVarArr3;
            this.p = (c.f[]) arrayList3.toArray(fVarArr3);
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("ad_lurls");
        if (jSONArrayOptJSONArray4 != null) {
            ArrayList arrayList4 = new ArrayList();
            for (int i10 = 0; i10 < jSONArrayOptJSONArray4.length(); i10++) {
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i10);
                if (jSONObjectOptJSONObject5 != null) {
                    arrayList4.add(new q(jSONObjectOptJSONObject5));
                }
            }
            c.f[] fVarArr4 = new c.f[arrayList4.size()];
            this.f16461q = fVarArr4;
            this.f16461q = (c.f[]) arrayList4.toArray(fVarArr4);
        }
        this.f16462r = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("om_data");
        if (jSONArrayOptJSONArray5 != null) {
            this.f16462r = new ArrayList();
            for (int i11 = 0; i11 < jSONArrayOptJSONArray5.length(); i11++) {
                this.f16462r.add(new m(jSONArrayOptJSONArray5.optJSONObject(i11)));
            }
        }
        this.f16463s = jSONObject.optString("enc_price", "");
        this.f16467w = new k(jSONObject);
        this.f16468x = new f(jSONObject);
        this.f16464t = jSONObject.optLong("switch_bit_map", 0L);
        this.f16465u = jSONObject.optString("abflags", "");
        this.E = jSONObject.optLong("expired_interval", 0L);
        this.f16466v = jSONObject.optString("mapping_slot", "");
        this.I = jSONObject.optLong("probe_interval");
        this.J = jSONObject.optInt("playable_ad_switch", 0);
        this.f16469z = jSONObject.optString("req_slot");
        String strOptString2 = jSONObject.optString("interstitial_style_getad_config");
        if (!TextUtils.isEmpty(strOptString2)) {
            try {
                this.y = new sg.bigo.ads.controller.b.j(new JSONObject(strOptString2));
            } catch (JSONException unused) {
            }
        }
        this.aq.a(jSONObject.optString("ad_form"));
        this.P = jSONObject.optString(C2300e4.h.F0);
        this.O = jSONObject.optString("sdk_style_id");
        this.Q = jSONObject.optInt("banner_show_ad", 0) == 1;
        this.R = jSONObject.optInt("banner_show_domain", 0) == 1;
        this.S = jSONObject.optString("ru_ad_marker");
        this.U = (jSONObject.optLong("bid_price", 0L) * 1.0d) / 1.0E8d;
        this.V = jSONObject.optString("adx_country");
        this.aj = jSONObject.optInt("orientation", 0);
        if (sg.bigo.ads.api.core.b.d(this.f16458i)) {
            this.D = jSONObject;
        }
        this.X = jSONObject.optString("ad_bundle_id", "");
        this.Y = jSONObject.optString("pop_h5");
        this.Z = jSONObject.optString("pop_img");
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("pop_page");
        if (jSONObjectOptJSONObject6 != null) {
            this.aa = new n(jSONObjectOptJSONObject6);
        }
        int iOptInt = jSONObject.optInt("ad_resp_type");
        this.A = iOptInt;
        if (iOptInt == 1) {
            jSONObject2 = jSONObject;
            a(jSONObject2, j, hVar, lVar);
        } else {
            jSONObject2 = jSONObject;
        }
        this.B = sg.bigo.ads.common.utils.l.a(jSONObject2.optString("pub_extra_info"));
        this.al = jSONObject2.optString("dsp_extra");
        this.am = jSONObject2.optInt("native_banner_fill_strategy", 1);
        this.an = jSONObject2.optInt("guide_type", 0);
        this.ao = jSONObject2.optInt("native_banner_click_type", 0);
        this.ap = jSONObject2.optInt("is_interactive", 0);
        this.C = jSONObject2.optInt("vpaid_imp_method", 0);
        this.ar = jSONObject2.optString("sponsored", "");
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String A() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.e B() {
        return this.m;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.f[] C() {
        return this.f16459n;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.f[] D() {
        return this.f16460o;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.f[] E() {
        return this.p;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.f[] F() {
        return this.f16461q;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final List<c.InterfaceC0279c> G() {
        return this.f16462r;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String H() {
        return this.f16463s;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String I() {
        return this.f16465u;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean J() {
        return (!this.M || this.N <= 0) ? SystemClock.elapsedRealtime() - this.F >= this.E * 1000 : System.currentTimeMillis() > this.N;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    @Override // sg.bigo.ads.api.core.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long K() {
        /*
            r9 = this;
            boolean r0 = r9.M
            r1 = 0
            if (r0 == 0) goto L1e
            long r3 = r9.N
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1e
            long r5 = r9.E
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1c
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            goto L26
        L1c:
            r5 = r1
            goto L26
        L1e:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r9.F
            long r5 = r3 - r5
        L26:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
            return r5
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.c.b.K():long");
    }

    @Override // sg.bigo.ads.api.core.c
    public final long L() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String M() {
        return this.f16466v;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final c.b N() {
        return this.f16467w;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final c.a O() {
        return this.f16468x;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int P() {
        return this.A;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String Q() {
        return this.ab;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int R() {
        return this.ac;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void S() {
        this.ac = this.ad;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void T() {
        this.ae = true;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean U() {
        return this.ae;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int V() {
        return this.af;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int W() {
        return this.ah;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int X() {
        return this.ai;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.core.q Y() {
        return this.ak;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long Z() {
        return this.G;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final long a() {
        return sg.bigo.ads.api.a.i.f15457a.i();
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final sg.bigo.ads.api.core.h aa() {
        return this.H;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String ab() {
        return !sg.bigo.ads.common.utils.q.a((CharSequence) this.O) ? this.O : this.f16454b.p();
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ac() {
        return this.J == 1;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ad() {
        return this.K;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ae() {
        return this.L;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final JSONObject af() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void ag() {
        this.M = true;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ah() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.core.c
    public final double ai() {
        return this.U;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int aj() {
        return this.f16454b.v();
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ak() {
        return this.f16454b.v() == 2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean al() {
        return this.W;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final List<sg.bigo.ads.api.core.c> am() {
        return this.f16453a;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String an() {
        return this.al;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ao() {
        return this.am;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int ap() {
        return this.an;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int aq() {
        return this.ao;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean ar() {
        return this.aj == 1;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int as() {
        return this.ap;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int at() {
        return this.C;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String au() {
        return this.ar;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final String b() {
        return this.f16454b.l();
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final String c() {
        return this.f16454b.n();
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final sg.bigo.ads.api.a.l d() {
        return this.f16454b;
    }

    @Override // sg.bigo.ads.api.core.c
    public final sg.bigo.ads.api.a.m e() {
        return this.y;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final sg.bigo.ads.api.a.e f() {
        return this.aq;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int g() {
        return this.T;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean h() {
        sg.bigo.ads.api.a.m mVar = this.y;
        return mVar != null && mVar.a("endpage.ad_component_layout") == 5;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String i() {
        return this.P;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean j() {
        return this.Q;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean k() {
        return this.R;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String l() {
        return this.S;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String m() {
        return this.V;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String n() {
        return this.X;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String o() {
        return this.Y;
    }

    @Override // sg.bigo.ads.api.core.c
    public final String p() {
        return this.Z;
    }

    @Override // sg.bigo.ads.api.core.c
    public final c.d q() {
        return this.aa;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final String r() {
        return this.f16455c;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public String s() {
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.f16456d)) {
            return this.f16456d;
        }
        c.d dVar = this.aa;
        return (dVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) dVar.b())) ? this.f16456d : this.aa.b();
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public String t() {
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.e)) {
            return this.e;
        }
        c.d dVar = this.aa;
        return (dVar == null || sg.bigo.ads.common.utils.q.a((CharSequence) dVar.c())) ? this.e : this.aa.c();
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String u() {
        return this.f16457f;
    }

    @Override // sg.bigo.ads.api.core.c
    @NonNull
    public final String v() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int w() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.core.c
    public final int x() {
        return this.f16458i;
    }

    @Override // sg.bigo.ads.api.core.c
    public final long y() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.core.c
    @Nullable
    public final String z() {
        return this.k;
    }

    @Nullable
    public static b a(long j, @NonNull sg.bigo.ads.api.core.h hVar, @NonNull sg.bigo.ads.api.a.l lVar, String str) {
        try {
            return a(j, hVar, lVar, new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // sg.bigo.ads.api.core.c
    public final String b(String str) {
        if (str == null) {
            return "";
        }
        Map<String, String> map = this.B;
        String str2 = map != null ? map.get(str) : "";
        return str2 == null ? "" : str2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void c(int i2) {
        this.af = i2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void d(int i2) {
        this.K = i2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void e(int i2) {
        this.L = i2;
    }

    @Nullable
    public static b a(long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("adx_type", 0);
        if (iOptInt != 1 && iOptInt != 2) {
            if (iOptInt == 3) {
                return new d(j, hVar, lVar, jSONObject);
            }
            if (iOptInt != 5) {
                return null;
            }
        }
        return new l(j, hVar, lVar, jSONObject);
    }

    @Override // sg.bigo.ads.api.core.c
    public final void b(int i2) {
        this.ad = i2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(int i2, int i8, boolean z2) {
        if (!this.ag || z2) {
            this.ag = true;
            this.ah = i2;
            this.ai = i8;
        }
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(long j) {
        this.N = j;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(String str) {
        this.ab = str;
    }

    private void a(JSONObject jSONObject, long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ads");
        ArrayList arrayList = null;
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    b bVarA = a(j, hVar, lVar, jSONObjectOptJSONObject);
                    if (bVarA != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        bVarA.A = this.A;
                        arrayList.add(bVarA);
                    } else {
                        sg.bigo.ads.core.d.b.a(1005, 10205, "Error ad in ads");
                    }
                }
            }
        }
        this.f16453a = arrayList;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(sg.bigo.ads.api.core.q qVar) {
        this.ak = qVar;
    }

    @Override // sg.bigo.ads.api.core.c
    public final void a(boolean z2) {
        this.T = z2 ? 1 : 2;
    }

    @Override // sg.bigo.ads.api.core.c
    public final boolean a(int i2) {
        return (this.f16464t & ((long) i2)) > 0;
    }
}
