package com.ironsource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.C2569t8;
import com.ironsource.O;
import com.ironsource.Q8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q9 implements InterfaceC2364he, InterfaceC2650y4, InterfaceC2633x4, InterfaceC2599v4, InterfaceC2616w4, W9, Oc {
    private static final String m = "IronSourceAdsPublisherAgent";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Q9 f7491n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.sdk.controller.e f7492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Z4 f7495d;
    private C2506pc e;
    private C2354h4 g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7496f = false;
    private FeaturesManager h = FeaturesManager.getInstance();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Q8.a f7497i = Mb.O().j();
    private O.a j = Mb.O().E();
    private O k = Mb.U().G();
    private InterfaceC2535r8 l = Mb.U().t();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Y4 f7500c;

        public a(String str, String str2, Y4 y42) {
            this.f7498a = str;
            this.f7499b = str2;
            this.f7500c = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7498a, this.f7499b, this.f7500c, (InterfaceC2650y4) q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f7502a;

        public b(JSONObject jSONObject) {
            this.f7502a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7502a, (InterfaceC2650y4) q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Y4 f7506c;

        public c(String str, String str2, Y4 y42) {
            this.f7504a = str;
            this.f7505b = str2;
            this.f7506c = y42;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7504a, this.f7505b, this.f7506c, (InterfaceC2633x4) q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7508a;

        public d(String str) {
            this.f7508a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7508a, q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f7510a;

        public e(JSONObject jSONObject) {
            this.f7510a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7510a, (InterfaceC2633x4) q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ M9 f7512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f7513b;

        public f(M9 m9, Map map) {
            this.f7512a = m9;
            this.f7513b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2569t8.e eVar = this.f7512a.i() ? C2569t8.e.Banner : C2569t8.e.Interstitial;
            Y4 y4A = Q9.this.f7495d.a(eVar, this.f7512a);
            C2603v8 c2603v8 = new C2603v8();
            c2603v8.a(G5.f6817x, Boolean.valueOf(this.f7512a.j())).a(G5.G, Boolean.valueOf(this.f7512a.m())).a(G5.f6815v, this.f7512a.g()).a(G5.f6816w, X9.a(this.f7512a)).a(G5.I, Long.valueOf(L.f7071a.b(this.f7512a.e())));
            A8.a(C2328fe.h, c2603v8.a());
            if (eVar == C2569t8.e.Banner) {
                Q9 q9 = Q9.this;
                q9.f7492a.a(q9.f7493b, q9.f7494c, y4A, (InterfaceC2616w4) q9);
                Q9 q92 = Q9.this;
                q92.f7492a.a(y4A, this.f7513b, (InterfaceC2616w4) q92);
                return;
            }
            Q9 q93 = Q9.this;
            q93.f7492a.a(q93.f7493b, q93.f7494c, y4A, (InterfaceC2633x4) q93);
            Q9 q94 = Q9.this;
            q94.f7492a.b(y4A, this.f7513b, q94);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Y4 f7515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f7516b;

        public g(Y4 y42, Map map) {
            this.f7515a = y42;
            this.f7516b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Q9 q9 = Q9.this;
            q9.f7492a.a(this.f7515a, this.f7516b, (InterfaceC2633x4) q9);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ M9 f7518a;

        public h(M9 m9) {
            this.f7518a = m9;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2569t8.e eVar = this.f7518a.i() ? C2569t8.e.Banner : C2569t8.e.Interstitial;
            Y4 y4A = Q9.this.f7495d.a(eVar, this.f7518a);
            C2603v8 c2603v8 = new C2603v8();
            c2603v8.a(G5.f6817x, Boolean.valueOf(this.f7518a.j())).a(G5.f6815v, this.f7518a.g()).a(G5.f6816w, X9.a(this.f7518a)).a("isMultipleAdObjects", Boolean.valueOf(this.f7518a.l()));
            A8.a(C2328fe.m, c2603v8.a());
            if (eVar == C2569t8.e.Banner) {
                Q9.this.f7492a.a(y4A);
            } else {
                y4A.a(false);
                Q9.this.f7492a.b(y4A);
            }
        }
    }

    private Q9(Context context, int i2) {
        c(context);
    }

    @Override // com.ironsource.InterfaceC2633x4
    public void onInterstitialAdRewarded(String str, int i2) {
        Y4 y4D = d(C2569t8.e.Interstitial, str);
        Lc lcB = b(y4D);
        if (y4D == null || lcB == null) {
            return;
        }
        lcB.onInterstitialAdRewarded(str, i2);
    }

    @Override // com.ironsource.InterfaceC2364he, com.ironsource.W9
    public void onPause(Activity activity) {
        if (this.f7496f) {
            return;
        }
        b(activity);
    }

    @Override // com.ironsource.InterfaceC2364he, com.ironsource.W9
    public void onResume(Activity activity) {
        if (this.f7496f) {
            return;
        }
        c(activity);
    }

    public static W9 a(Context context, String str, String str2) {
        return a(str, str2, context);
    }

    public static synchronized Q9 b(Context context) throws Exception {
        return a(context, 0);
    }

    private void c(Context context) {
        try {
            SDKUtils.getNetworkConfiguration();
            C2306ea.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new C2559sf(SDKUtils.getNetworkConfiguration().optJSONObject(C2300e4.a.k)));
            C2306ea.e().d(SDKUtils.getSDKVersion());
            this.f7495d = new Z4();
            C2354h4 c2354h4 = new C2354h4();
            this.g = c2354h4;
            if (context instanceof Activity) {
                c2354h4.a((Activity) context);
            }
            int debugMode = this.h.getDebugMode();
            this.e = new C2506pc();
            this.f7492a = new com.ironsource.sdk.controller.e(context, this.g, this.f7495d, V7.f7731a, debugMode, this.h.getDataManagerConfig(), this.f7493b, this.f7494c, this.e);
            Logger.enableLogging(debugMode);
            Logger.i(m, "C'tor");
            a(context);
            this.e.d();
            this.e.e();
            this.e.a(context);
            this.e.b();
            this.e.a();
            this.e.b(context);
            this.e.c();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    @Override // com.ironsource.InterfaceC2633x4
    public void d(String str, String str2) {
        Y4 y4D = d(C2569t8.e.Interstitial, str);
        if (y4D != null) {
            M9 m9C = y4D.c();
            this.j.a(EnumC2439m0.SHOW_FAIL, m9C.e());
            if (c(m9C)) {
                this.f7497i.a(new C2257bf(this.k.a(m9C.e())));
            }
            Lc lcB = b(y4D);
            if (lcB != null) {
                lcB.onInterstitialShowFailed(str2);
            }
        }
    }

    public static synchronized W9 a(String str, String str2, Context context) {
        try {
            if (f7491n == null) {
                A8.a(C2328fe.f8533a);
                f7491n = new Q9(str, str2, context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7491n;
    }

    private Lc b(Y4 y42) {
        if (y42 == null) {
            return null;
        }
        return (Lc) y42.i();
    }

    @Override // com.ironsource.InterfaceC2364he
    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.f7492a.a(new d(strOptString));
    }

    public static synchronized Q9 a(Context context, int i2) throws Exception {
        try {
            Logger.i(m, "getInstance()");
            if (f7491n == null) {
                f7491n = new Q9(context, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7491n;
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void b(C2569t8.e eVar, String str) {
        Lc lcB;
        Y4 y4D = d(eVar, str);
        if (y4D != null) {
            if (eVar == C2569t8.e.RewardedVideo) {
                Qc qcC = c(y4D);
                if (qcC != null) {
                    qcC.d();
                    return;
                }
                return;
            }
            if (eVar != C2569t8.e.Interstitial || (lcB = b(y4D)) == null) {
                return;
            }
            lcB.onInterstitialClose();
        }
    }

    public Q9(String str, String str2, Context context) {
        this.f7493b = str;
        this.f7494c = str2;
        c(context);
    }

    @Override // com.ironsource.W9
    public com.ironsource.sdk.controller.e a() {
        return this.f7492a;
    }

    private Jc a(Y4 y42) {
        if (y42 == null) {
            return null;
        }
        return (Jc) y42.i();
    }

    private Y4 d(C2569t8.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f7495d.a(eVar, str);
    }

    @Override // com.ironsource.InterfaceC2364he
    public void a(String str, String str2, String str3, Map<String, String> map, Qc qc) {
        this.f7493b = str;
        this.f7494c = str2;
        this.f7492a.a(new a(str, str2, this.f7495d.a(C2569t8.e.RewardedVideo, str3, map, qc)));
    }

    @Override // com.ironsource.InterfaceC2650y4
    public void b(String str, String str2) {
        Qc qcC;
        Y4 y4D = d(C2569t8.e.RewardedVideo, str);
        if (y4D == null || (qcC = c(y4D)) == null) {
            return;
        }
        qcC.a(str2);
    }

    @Override // com.ironsource.InterfaceC2364he
    public void a(JSONObject jSONObject) {
        this.f7492a.a(new b(jSONObject));
    }

    @Override // com.ironsource.InterfaceC2633x4
    public void b(String str) {
        Y4 y4D = d(C2569t8.e.Interstitial, str);
        if (y4D != null) {
            M9 m9C = y4D.c();
            this.j.a(EnumC2439m0.SHOW_SUCCESS, m9C.e());
            if (c(m9C)) {
                this.f7497i.a(new C2275cf(this.k.a(m9C.e())));
            }
            Lc lcB = b(y4D);
            if (lcB != null) {
                lcB.onInterstitialShowSuccess();
            }
        }
    }

    @Override // com.ironsource.InterfaceC2364he
    public void a(String str, String str2, String str3, Map<String, String> map, Lc lc) {
        this.f7493b = str;
        this.f7494c = str2;
        this.f7492a.a(new c(str, str2, this.f7495d.a(C2569t8.e.Interstitial, str3, map, lc)));
    }

    @Override // com.ironsource.InterfaceC2364he
    public boolean a(String str) {
        return this.f7492a.a(str);
    }

    @Override // com.ironsource.InterfaceC2364he, com.ironsource.W9
    public void a(Activity activity) {
        try {
            Logger.i(m, "release()");
            C2265c5.g();
            this.g.b();
            this.f7492a.a((Context) activity);
            this.f7492a.a();
            this.f7492a = null;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
        }
        f7491n = null;
    }

    @Override // com.ironsource.Y9
    public void b(Activity activity, M9 m9, Map<String, String> map) {
        if (Mb.U().g().d()) {
            this.g.a(activity);
        }
        a(m9, map);
    }

    private Qc c(Y4 y42) {
        if (y42 == null) {
            return null;
        }
        return (Qc) y42.i();
    }

    @Override // com.ironsource.InterfaceC2364he
    public void c(JSONObject jSONObject) {
        this.f7492a.a(new e(jSONObject));
    }

    private void b(M9 m9, Map<String, String> map) {
        Logger.d(m, "loadOnNewInstance " + m9.e());
        this.f7492a.a(new f(m9, map));
    }

    @Override // com.ironsource.InterfaceC2650y4
    public void c(String str) {
        Qc qcC;
        Y4 y4D = d(C2569t8.e.RewardedVideo, str);
        if (y4D == null || (qcC = c(y4D)) == null) {
            return;
        }
        qcC.c();
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void a(C2569t8.e eVar, String str, Y0 y02) {
        Jc jcA;
        Y4 y4D = d(eVar, str);
        if (y4D != null) {
            y4D.b(2);
            if (eVar == C2569t8.e.RewardedVideo) {
                Qc qcC = c(y4D);
                if (qcC != null) {
                    qcC.a(y02);
                    return;
                }
                return;
            }
            if (eVar == C2569t8.e.Interstitial) {
                Lc lcB = b(y4D);
                if (lcB != null) {
                    lcB.onInterstitialInitSuccess();
                    return;
                }
                return;
            }
            if (eVar != C2569t8.e.Banner || (jcA = a(y4D)) == null) {
                return;
            }
            jcA.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.Y9
    public void b(M9 m9) {
        Logger.d(m, "destroyInstance " + m9.e());
        if (c(m9)) {
            this.j.a(EnumC2439m0.DESTROYED, m9.e());
            this.f7497i.a(new Ye(this.k.a(m9.e())));
        }
        this.f7492a.a(new h(m9));
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void c(C2569t8.e eVar, String str) {
        Qc qcC;
        Y4 y4D = d(eVar, str);
        if (y4D != null) {
            if (eVar == C2569t8.e.Interstitial) {
                Lc lcB = b(y4D);
                if (lcB != null) {
                    lcB.onInterstitialOpen();
                    return;
                }
                return;
            }
            if (eVar != C2569t8.e.RewardedVideo || (qcC = c(y4D)) == null) {
                return;
            }
            qcC.b();
        }
    }

    @Override // com.ironsource.Oc
    public void b(Activity activity) {
        try {
            this.f7492a.e();
            this.f7492a.a((Context) activity);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    @Override // com.ironsource.InterfaceC2616w4
    public void c(String str, String str2) {
        Jc jcA;
        Y4 y4D = d(C2569t8.e.Banner, str);
        if (y4D == null || (jcA = a(y4D)) == null) {
            return;
        }
        jcA.onBannerLoadFail(str2);
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void a(C2569t8.e eVar, String str, String str2) {
        Jc jcA;
        Y4 y4D = d(eVar, str);
        C2603v8 c2603v8A = new C2603v8().a(G5.f6815v, str).a(G5.f6816w, eVar).a(G5.A, str2);
        if (y4D != null) {
            L l = L.f7071a;
            c2603v8A.a(G5.I, Long.valueOf(l.b(y4D.h())));
            c2603v8A.a(G5.f6817x, Boolean.valueOf(B8.a(y4D)));
            l.a(y4D.h());
            y4D.b(3);
            if (eVar == C2569t8.e.RewardedVideo) {
                Qc qcC = c(y4D);
                if (qcC != null) {
                    qcC.b(str2);
                }
            } else if (eVar == C2569t8.e.Interstitial) {
                Lc lcB = b(y4D);
                if (lcB != null) {
                    lcB.onInterstitialInitFailed(str2);
                }
            } else if (eVar == C2569t8.e.Banner && (jcA = a(y4D)) != null) {
                jcA.onBannerLoadFail(str2);
            }
        }
        A8.a(C2328fe.f8538i, c2603v8A.a());
    }

    private void c(M9 m9, Map<String, String> map) {
        try {
            map = a(map);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            C2603v8 c2603v8A = new C2603v8().a(G5.A, e4.getMessage()).a(G5.f6817x, Boolean.valueOf(m9.j())).a(G5.G, Boolean.valueOf(m9.m())).a(G5.f6815v, m9.g()).a(G5.f6816w, X9.a(m9)).a(G5.I, Long.valueOf(L.f7071a.b(m9.e())));
            L.f7071a.a(m9.e());
            A8.a(C2328fe.k, c2603v8A.a());
            IronLog.INTERNAL.error(e4.toString());
            Logger.d(m, "loadInAppBiddingAd failed decoding  ADM " + e4.getMessage());
        }
        b(m9, map);
    }

    @Override // com.ironsource.Oc
    public void c(Activity activity) {
        this.g.a(activity);
        this.f7492a.g();
        this.f7492a.b(activity);
    }

    @Override // com.ironsource.InterfaceC2650y4
    public void a(String str, int i2) {
        Qc qcC;
        Y4 y4D = d(C2569t8.e.RewardedVideo, str);
        if (y4D == null || (qcC = c(y4D)) == null) {
            return;
        }
        qcC.a(i2);
    }

    public boolean c(M9 m9) {
        return m9.l() && !m9.i() && a(m9);
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void a(C2569t8.e eVar, String str) {
        Jc jcA;
        Y4 y4D = d(eVar, str);
        if (y4D != null) {
            if (eVar == C2569t8.e.RewardedVideo) {
                Qc qcC = c(y4D);
                if (qcC != null) {
                    qcC.a();
                    return;
                }
                return;
            }
            if (eVar == C2569t8.e.Interstitial) {
                Lc lcB = b(y4D);
                if (lcB != null) {
                    lcB.onInterstitialClick();
                    return;
                }
                return;
            }
            if (eVar != C2569t8.e.Banner || (jcA = a(y4D)) == null) {
                return;
            }
            jcA.onBannerClick();
        }
    }

    @Override // com.ironsource.InterfaceC2599v4
    public void a(C2569t8.e eVar, String str, String str2, JSONObject jSONObject) {
        Jc jcA;
        Y4 y4D = d(eVar, str);
        if (y4D == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            Logger.i(m, "Received Event Notification: " + str2 + " for demand source: " + y4D.f());
            if (eVar == C2569t8.e.Interstitial) {
                Lc lcB = b(y4D);
                if (lcB != null) {
                    jSONObject.put("demandSourceName", str);
                    lcB.onInterstitialEventNotificationReceived(str2, jSONObject);
                    return;
                }
                return;
            }
            if (eVar == C2569t8.e.RewardedVideo) {
                Qc qcC = c(y4D);
                if (qcC != null) {
                    jSONObject.put("demandSourceName", str);
                    qcC.a(str2, jSONObject);
                    return;
                }
                return;
            }
            if (eVar != C2569t8.e.Banner || (jcA = a(y4D)) == null) {
                return;
            }
            jSONObject.put("demandSourceName", str);
            if (str2.equalsIgnoreCase("impressions")) {
                jcA.onBannerShowSuccess();
            }
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    @Override // com.ironsource.InterfaceC2633x4
    public void a(String str, JSONObject jSONObject) {
        C2569t8.e eVar = C2569t8.e.Interstitial;
        Y4 y4D = d(eVar, str);
        C2603v8 c2603v8A = new C2603v8().a(G5.f6815v, str);
        if (y4D != null) {
            M9 m9C = y4D.c();
            this.j.a(jSONObject, EnumC2439m0.LOAD_SUCCESS, m9C.e());
            if (c(m9C)) {
                this.f7497i.a(new C2239af(this.k.a(m9C.e())));
            }
            C2603v8 c2603v8A2 = c2603v8A.a(G5.f6816w, B8.a(y4D, eVar)).a(G5.f6817x, Boolean.valueOf(B8.a(y4D)));
            L l = L.f7071a;
            c2603v8A2.a(G5.I, Long.valueOf(l.b(y4D.h())));
            l.a(y4D.h());
            Lc lcB = b(y4D);
            if (lcB != null) {
                lcB.onInterstitialLoadSuccess(y4D.c());
            }
        }
        A8.a(C2328fe.l, c2603v8A.a());
    }

    @Override // com.ironsource.InterfaceC2633x4
    public void a(String str, String str2) {
        Object obj;
        C2569t8.e eVar = C2569t8.e.Interstitial;
        Y4 y4D = d(eVar, str);
        C2603v8 c2603v8 = new C2603v8();
        c2603v8.a(G5.A, str2).a(G5.f6815v, str);
        if (y4D != null) {
            C2603v8 c2603v8A = c2603v8.a(G5.f6816w, B8.a(y4D, eVar));
            if (y4D.e() == 2) {
                obj = G5.E;
            } else {
                obj = G5.F;
            }
            C2603v8 c2603v8A2 = c2603v8A.a(G5.y, obj).a(G5.f6817x, Boolean.valueOf(B8.a(y4D)));
            L l = L.f7071a;
            c2603v8A2.a(G5.I, Long.valueOf(l.b(y4D.h())));
            l.a(y4D.h());
            Lc lcB = b(y4D);
            if (lcB != null) {
                lcB.onInterstitialLoadFailed(str2);
            }
        }
        A8.a(C2328fe.g, c2603v8.a());
    }

    @Override // com.ironsource.InterfaceC2364he
    public void a(String str, String str2, int i2) {
        C2569t8.e productType;
        Y4 y4A;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (productType = SDKUtils.getProductType(str)) == null || (y4A = this.f7495d.a(productType, str2)) == null) {
            return;
        }
        y4A.c(i2);
    }

    @Override // com.ironsource.InterfaceC2616w4
    public void a(String str, C2411k8 c2411k8) {
        Jc jcA;
        Y4 y4D = d(C2569t8.e.Banner, str);
        if (y4D == null || (jcA = a(y4D)) == null) {
            return;
        }
        jcA.onBannerLoadSuccess(y4D.c(), c2411k8);
    }

    @Override // com.ironsource.Y9
    public void a(M9 m9, Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put(C2300e4.h.f8394y0, String.valueOf(jCurrentTimeMillis));
        L.f7071a.a(m9.e(), jCurrentTimeMillis);
        C2603v8 c2603v8 = new C2603v8();
        c2603v8.a(G5.f6817x, Boolean.valueOf(m9.j())).a(G5.G, Boolean.valueOf(m9.m())).a(G5.f6815v, m9.g()).a(G5.f6816w, X9.a(m9)).a(G5.I, Long.valueOf(jCurrentTimeMillis));
        A8.a(C2328fe.f8537f, c2603v8.a());
        Logger.d(m, "loadAd " + m9.e());
        N n2 = new N(m9);
        this.j.a(n2);
        this.j.a(new JSONObject(map), EnumC2439m0.LOAD_REQUEST, n2.c());
        if (c(m9)) {
            this.f7497i.a(new Ze(n2));
        }
        if (m9.k()) {
            c(m9, map);
        } else {
            b(m9, map);
        }
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", SDKUtils.decodeString(map.get("adm")));
        return map;
    }

    @Override // com.ironsource.Y9
    public void a(Activity activity, M9 m9, Map<String, String> map) {
        this.g.a(activity);
        Logger.i(m, "showAd " + m9.e());
        Y4 y4A = this.f7495d.a(C2569t8.e.Interstitial, m9.e());
        if (y4A == null) {
            return;
        }
        this.f7492a.a(new g(y4A, map));
    }

    @Override // com.ironsource.Y9
    public boolean a(M9 m9) {
        Logger.d(m, "isAdAvailable " + m9.e());
        Y4 y4A = this.f7495d.a(C2569t8.e.Interstitial, m9.e());
        if (y4A == null) {
            return false;
        }
        return y4A.d();
    }

    public void a(Context context) {
        this.f7496f = false;
        Boolean boolC = this.l.c(C2300e4.a.g);
        if (boolC == null) {
            boolC = Boolean.FALSE;
        }
        boolean zBooleanValue = boolC.booleanValue();
        this.f7496f = zBooleanValue;
        if (zBooleanValue) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new C2367i(this));
            } catch (Throwable th) {
                C2531r4.d().a(th);
                C2603v8 c2603v8 = new C2603v8();
                c2603v8.a(G5.y, th.getMessage());
                A8.a(C2328fe.f8545u, c2603v8.a());
            }
        }
    }
}
