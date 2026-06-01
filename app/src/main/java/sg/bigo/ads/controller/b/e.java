package sg.bigo.ads.controller.b;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.n;
import sg.bigo.ads.api.a.o;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.s;
import sg.bigo.ads.api.core.t;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e extends sg.bigo.ads.common.e implements sg.bigo.ads.api.a.h {
    protected int A;
    protected boolean B;
    protected String C;
    protected String D;
    protected m E;
    protected sg.bigo.ads.api.a.g F;
    protected n G;
    protected o H;

    @Deprecated
    protected String I;
    protected Map<String, sg.bigo.ads.api.a.c> J;

    @Deprecated
    protected String K;
    protected String L;
    protected c M;
    protected int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sg.bigo.ads.api.a.b f16413a;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16414f;
    private String g;
    protected sg.bigo.ads.common.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected sg.bigo.ads.common.a f16415i;
    protected sg.bigo.ads.common.s.a j;
    protected sg.bigo.ads.common.a k;
    protected long l;
    protected boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected long f16416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f16417o;
    protected String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f16418q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f16419r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected String f16420s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected String f16421t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected String f16422u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected String f16423v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected String f16424w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected String f16425x;

    @Deprecated
    protected String y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected String f16426z;

    public e(@NonNull Context context) {
        super(context);
        this.f16419r = 1;
        this.E = new m();
        this.F = new l();
        this.G = new s();
        this.H = new t();
        this.J = new HashMap();
        this.M = new c();
        this.f16413a = new b();
        this.S = 0;
        this.T = 0;
    }

    public static long E() {
        return r.f16034a.a(30);
    }

    @Override // sg.bigo.ads.api.a.h
    public final int A() {
        return this.R;
    }

    public final void B() {
        L();
        K();
        M();
    }

    public final int C() {
        boolean z2 = Math.abs((r.b() / 1000) - this.l) > ((long) this.f16417o);
        return this.f16419r == 0 ? z2 ? 4 : 5 : z2 ? 3 : 2;
    }

    public final int D() {
        return this.A;
    }

    public final String F() {
        return this.f16426z;
    }

    public final String G() {
        return this.L;
    }

    public final boolean H() {
        return this.m;
    }

    public final String I() {
        return this.C;
    }

    @NonNull
    public final n J() {
        return this.G;
    }

    public final sg.bigo.ads.common.a K() {
        if (this.h == null) {
            this.h = sg.bigo.ads.common.a.f15554a;
        }
        if (this.h.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.h = sg.bigo.ads.common.o.c.a(eVar.f15602b);
                    e.this.a(0L);
                }
            });
        }
        return this.h;
    }

    public final sg.bigo.ads.common.a L() {
        if (this.f16415i == null) {
            this.f16415i = sg.bigo.ads.common.a.f15554a;
        }
        if (this.f16415i.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.f16415i = sg.bigo.ads.common.l.b.a(eVar.f15602b);
                    e.this.a(0L);
                }
            });
        }
        return this.f16415i;
    }

    public final sg.bigo.ads.common.a M() {
        if (this.k == null) {
            this.k = sg.bigo.ads.common.a.f15554a;
        }
        if (this.k.a()) {
            sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.controller.b.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = e.this;
                    eVar.k = sg.bigo.ads.common.k.a.a(eVar.f15602b);
                    e.this.a(0L);
                }
            });
        }
        return this.k;
    }

    public final boolean N() {
        return this.l != 0;
    }

    @Override // sg.bigo.ads.common.e
    public final String a() {
        return "bigoad_config.dat";
    }

    public abstract void a(JSONObject jSONObject);

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.h = new sg.bigo.ads.common.a(parcel);
        this.f16415i = new sg.bigo.ads.common.a(parcel);
        this.j = new sg.bigo.ads.common.s.a(this.f15602b, parcel);
        this.m = parcel.readInt() != 0;
        this.f16416n = parcel.readLong();
        this.f16417o = parcel.readInt();
        this.p = parcel.readString();
        this.f16418q = parcel.readString();
        this.f16419r = parcel.readInt();
        this.f16420s = parcel.readString();
        this.f16421t = parcel.readString();
        this.f16422u = parcel.readString();
        this.f16423v = parcel.readString();
        this.f16424w = parcel.readString();
        this.f16425x = parcel.readString();
        this.y = parcel.readString();
        this.f16426z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readInt() != 0;
        this.C = parcel.readString();
        this.l = parcel.readLong();
        if (parcel.dataAvail() > 0) {
            this.E.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.D = parcel.readString();
        }
        if (parcel.dataAvail() > 0) {
            this.F.b(parcel);
        }
        this.I = sg.bigo.ads.common.n.a(parcel, "");
        this.J = sg.bigo.ads.common.n.a(parcel, sg.bigo.ads.api.a.c.f15445b, new HashMap());
        this.K = sg.bigo.ads.common.n.a(parcel, "");
        if (parcel.dataAvail() > 0) {
            this.G.b(parcel);
        }
        if (parcel.dataAvail() > 0) {
            this.H.b(parcel);
        }
        this.L = sg.bigo.ads.common.n.a(parcel, "");
        sg.bigo.ads.common.n.b(parcel, this.M);
        this.N = sg.bigo.ads.common.n.a(parcel, 0);
        sg.bigo.ads.common.n.b(parcel, this.f16413a);
        this.e = sg.bigo.ads.common.n.a(parcel, 0);
        this.f16414f = sg.bigo.ads.common.n.a(parcel, 0);
        this.k = new sg.bigo.ads.common.a(parcel);
        this.S = sg.bigo.ads.common.n.a(parcel, 0);
        this.T = sg.bigo.ads.common.n.a(parcel, 0);
        String strA = sg.bigo.ads.common.n.a(parcel, "");
        this.g = strA;
        a(strA);
    }

    public abstract void b(JSONObject jSONObject);

    public abstract void c(JSONObject jSONObject);

    @Override // sg.bigo.ads.api.a.h
    public final boolean c() {
        return this.E.a(6);
    }

    public abstract void d(JSONObject jSONObject);

    @Override // sg.bigo.ads.api.a.h
    public final boolean d() {
        return this.E.a(7);
    }

    @CallSuper
    public final void e(@NonNull JSONObject jSONObject) {
        this.m = jSONObject.optInt("state", 1) == 1;
        this.f16416n = jSONObject.optLong("config_id", 0L);
        this.f16417o = jSONObject.optInt("conf_interval", 3600);
        this.p = jSONObject.optString("token", "");
        this.f16418q = jSONObject.optString("anti_ban", "");
        this.f16419r = jSONObject.optInt("config_strategy", 1);
        this.f16420s = jSONObject.optString("abflags", "");
        this.f16421t = jSONObject.optString("country", "");
        this.L = jSONObject.optString("req_country", "");
        this.N = jSONObject.optInt("app_flag", 0);
        this.e = jSONObject.optInt("ad_net", 0);
        this.f16414f = jSONObject.optInt("orientation", 0);
        this.S = jSONObject.optInt("token_v", 0);
        this.T = jSONObject.optInt("token_exp", 0);
        String strOptString = jSONObject.optString("host_retry_cfg", "");
        this.g = strOptString;
        a(strOptString);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("creatives");
        if (jSONObjectOptJSONObject != null) {
            this.f16422u = jSONObjectOptJSONObject.toString();
        } else {
            this.f16422u = "";
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("track");
        if (jSONObjectOptJSONObject2 != null) {
            this.f16423v = jSONObjectOptJSONObject2.toString();
        } else {
            this.f16423v = "";
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("cb");
        if (jSONObjectOptJSONObject3 != null) {
            this.f16424w = jSONObjectOptJSONObject3.toString();
        } else {
            this.f16424w = "";
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("report");
        if (jSONObjectOptJSONObject4 != null) {
            this.f16425x = jSONObjectOptJSONObject4.toString();
        } else {
            this.f16425x = "";
        }
        this.y = "";
        this.K = "";
        String strOptString2 = jSONObject.optString("uid", "");
        if (!TextUtils.isEmpty(strOptString2)) {
            this.f16426z = strOptString2;
        }
        int iOptInt = jSONObject.optInt("concurrent_req_num", 3);
        this.A = iOptInt;
        if (iOptInt <= 0) {
            this.A = Integer.MAX_VALUE;
        }
        this.B = jSONObject.optInt("neg_feedback", 1) == 1;
        this.C = jSONObject.optString("om_js_url", "");
        this.D = jSONObject.optString("banner_js_url", "");
        this.F.a(jSONObject.optJSONObject("free_material"));
        this.G.a(jSONObject.optJSONObject("u_running_conf"));
        this.H.a(jSONObject.optJSONObject("u_running_inf"));
        this.E.f15519a = jSONObject.optLong("global_switch", 0L);
        this.I = "";
        c cVar = this.M;
        String strOptString3 = jSONObject.optString("ad_fill_strategy");
        if (!TextUtils.isEmpty(strOptString3)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString3);
                cVar.f16401a = jSONObject2.optInt("video_resolution", 0);
                cVar.f16402b = jSONObject2.optString("white_dsp", "");
                cVar.f16403c = jSONObject2.optString("black_dsp", "");
                cVar.f16404d = jSONObject2.optInt("int_time", 0);
                cVar.e = jSONObject2.optInt("rew_time", 0);
                cVar.f16405f = jSONObject2.optInt("spl_time", 0);
                cVar.g = jSONObject2.optInt("nat_time", 0);
                cVar.h = jSONObject2.optInt("pop_time", 0);
                cVar.f16406i.a(jSONObject2);
                cVar.j.a(jSONObject2);
                cVar.k.a(jSONObject2);
                cVar.l.a(jSONObject2);
                cVar.m.a(jSONObject2);
            } catch (JSONException unused) {
            }
        }
        this.f16413a.a(jSONObject.optString("ad_fill_cost_optimize_strategy"));
        String strOptString4 = jSONObject.optString("global_conf");
        JSONArray jSONArray = null;
        try {
            if (!q.a((CharSequence) strOptString4)) {
                jSONArray = new JSONArray(strOptString4);
            }
        } catch (JSONException unused2) {
        }
        HashMap map = new HashMap();
        for (int i2 = 0; jSONArray != null && i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                String strOptString5 = jSONObjectOptJSONObject5.optString(C2300e4.h.W);
                if (!q.a((CharSequence) strOptString5)) {
                    map.put(strOptString5, new sg.bigo.ads.api.a.c(jSONObjectOptJSONObject5.optString("value", "")));
                }
            }
        }
        this.J = map;
        a(jSONObjectOptJSONObject2);
        b(jSONObjectOptJSONObject);
        c(jSONObjectOptJSONObject4);
        d(jSONObjectOptJSONObject3);
        this.l = r.b() / 1000;
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean f() {
        return this.E.a(5);
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean g() {
        return this.E.a(4);
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean h() {
        return this.E.a(22);
    }

    @Override // sg.bigo.ads.api.a.h
    public final long i() {
        return this.f16416n;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String j() {
        return this.f16420s;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String k() {
        return this.f16421t;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String l() {
        return this.p;
    }

    @Override // sg.bigo.ads.api.a.h
    @NonNull
    public final sg.bigo.ads.api.a.j n() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.a.h
    public final String o() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.a.h
    @NonNull
    public final sg.bigo.ads.api.a.g p() {
        return this.F;
    }

    @Override // sg.bigo.ads.api.a.h
    @NonNull
    public final sg.bigo.ads.api.a.b q() {
        return this.f16413a;
    }

    @Override // sg.bigo.ads.api.a.h
    public final sg.bigo.ads.api.a.d r() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int s() {
        return this.N;
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean t() {
        return this.e == 1;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int u() {
        return this.f16414f;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int v() {
        return this.S;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int w() {
        return this.T;
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean x() {
        return 1 == this.O;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int y() {
        return this.P;
    }

    @Override // sg.bigo.ads.api.a.h
    public final int z() {
        return this.Q;
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        if (this.h == null) {
            this.h = sg.bigo.ads.common.a.f15554a;
        }
        this.h.a(parcel);
        if (this.f16415i == null) {
            this.f16415i = sg.bigo.ads.common.a.f15554a;
        }
        this.f16415i.a(parcel);
        if (this.j == null) {
            this.j = new sg.bigo.ads.common.s.a(this.f15602b);
        }
        this.j.a(parcel);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeLong(this.f16416n);
        parcel.writeInt(this.f16417o);
        parcel.writeString(this.p);
        parcel.writeString(this.f16418q);
        parcel.writeInt(this.f16419r);
        parcel.writeString(this.f16420s);
        parcel.writeString(this.f16421t);
        parcel.writeString(this.f16422u);
        parcel.writeString(this.f16423v);
        parcel.writeString(this.f16424w);
        parcel.writeString(this.f16425x);
        parcel.writeString(this.y);
        parcel.writeString(this.f16426z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeString(this.C);
        parcel.writeLong(this.l);
        this.E.a(parcel);
        parcel.writeString(this.D);
        this.F.a(parcel);
        parcel.writeString(this.I);
        Map<String, sg.bigo.ads.api.a.c> map = this.J;
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size != 0) {
            for (Map.Entry<String, sg.bigo.ads.api.a.c> entry : map.entrySet()) {
                String key = entry.getKey();
                sg.bigo.ads.api.a.c value = entry.getValue();
                if (key == null || value == null) {
                    parcel.writeInt(0);
                } else {
                    sg.bigo.ads.common.n.a(parcel, value);
                    parcel.writeString(key);
                }
            }
        }
        parcel.writeString(this.K);
        this.G.a(parcel);
        this.H.a(parcel);
        parcel.writeString(this.L);
        sg.bigo.ads.common.n.a(parcel, this.M);
        parcel.writeInt(this.N);
        sg.bigo.ads.common.n.a(parcel, this.f16413a);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f16414f);
        if (this.k == null) {
            this.k = sg.bigo.ads.common.a.f15554a;
        }
        this.k.a(parcel);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeString(this.g);
    }

    @Override // sg.bigo.ads.api.a.h
    public final boolean e() {
        return d();
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.O = jSONObject.optInt("host_retry", 0);
            this.P = jSONObject.optInt("retry_times", 3);
            this.Q = jSONObject.optInt("retry_interval", 60);
            this.R = jSONObject.optInt("next_retry_interval", 7);
        } catch (JSONException unused) {
        }
    }
}
