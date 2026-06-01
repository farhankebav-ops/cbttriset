package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.A9;
import com.ironsource.AbstractC2581u3;
import com.ironsource.B7;
import com.ironsource.Be;
import com.ironsource.Bf;
import com.ironsource.C2229a5;
import com.ironsource.C2234aa;
import com.ironsource.C2236ac;
import com.ironsource.C2240ag;
import com.ironsource.C2256be;
import com.ironsource.C2258bg;
import com.ironsource.C2264c4;
import com.ironsource.C2270ca;
import com.ironsource.C2272cc;
import com.ironsource.C2350h0;
import com.ironsource.C2358h8;
import com.ironsource.C2359h9;
import com.ironsource.C2371i3;
import com.ironsource.C2375i7;
import com.ironsource.C2381id;
import com.ironsource.C2385j0;
import com.ironsource.C2394j9;
import com.ironsource.C2398jd;
import com.ironsource.C2434ld;
import com.ironsource.C2469na;
import com.ironsource.C2482o5;
import com.ironsource.C2499p5;
import com.ironsource.C2507pd;
import com.ironsource.C2531r4;
import com.ironsource.C2576tf;
import com.ironsource.C2674zb;
import com.ironsource.C5;
import com.ironsource.Ce;
import com.ironsource.Cf;
import com.ironsource.D5;
import com.ironsource.Ec;
import com.ironsource.Ed;
import com.ironsource.F9;
import com.ironsource.G3;
import com.ironsource.H1;
import com.ironsource.H2;
import com.ironsource.H9;
import com.ironsource.InterfaceC2233a9;
import com.ironsource.InterfaceC2250b8;
import com.ironsource.InterfaceC2361hb;
import com.ironsource.InterfaceC2466n7;
import com.ironsource.InterfaceC2555sb;
import com.ironsource.K1;
import com.ironsource.K9;
import com.ironsource.L9;
import com.ironsource.M8;
import com.ironsource.Mb;
import com.ironsource.Mc;
import com.ironsource.Me;
import com.ironsource.Nb;
import com.ironsource.O6;
import com.ironsource.Oe;
import com.ironsource.P7;
import com.ironsource.R7;
import com.ironsource.Rb;
import com.ironsource.S5;
import com.ironsource.T4;
import com.ironsource.T7;
import com.ironsource.U3;
import com.ironsource.U4;
import com.ironsource.U9;
import com.ironsource.V2;
import com.ironsource.V3;
import com.ironsource.V6;
import com.ironsource.V9;
import com.ironsource.Wd;
import com.ironsource.Zd;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.u;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.sdk.controller.FeaturesManager;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class r implements U9, Mc, T4, T4.b, T4.c, T4.a {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static boolean f9270m0 = false;
    private C2270ca A;
    private final String B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private Boolean J;
    private q K;
    private String L;
    private Boolean M;
    private R7 N;
    private y O;
    private A9 P;
    private Wd Q;
    private H2 R;
    private Ec S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private final ConcurrentHashMap<String, h.d> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9271a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final ConcurrentHashMap<String, h.b> f9272a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9273b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final ConcurrentHashMap<String, h.d> f9274b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final B7 f9275c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private com.ironsource.mediationsdk.demandOnly.f f9276c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final B7.a f9277d;
    private com.ironsource.mediationsdk.demandOnly.k d0;
    private final P7 e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private com.ironsource.mediationsdk.demandOnly.c f9278e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2466n7 f9279f;
    private S5 f0;
    private final M8.a g;
    private V9 g0;
    private IronSourceLoggerManager h;
    private V6 h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private C2674zb f9280i;
    private boolean i0;
    private AtomicBoolean j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private AdQualityBridge f9281j0;
    private final Object k;
    InterfaceC2250b8<ISDemandOnlyInterstitialListener> k0;
    private Me l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    InterfaceC2250b8<ISDemandOnlyRewardedVideoListener> f9282l0;
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f9283n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f9284o;
    private Map<String, String> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9285q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AtomicBoolean f9286r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9287s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<IronSource.a> f9288t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f9289u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Context f9290v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Boolean f9291w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Set<IronSource.a> f9292x;
    private Set<IronSource.a> y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f9293z;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f9295b;

        static {
            int[] iArr = new int[u.d.values().length];
            f9295b = iArr;
            try {
                iArr[u.d.NOT_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9295b[u.d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9295b[u.d.INIT_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9295b[u.d.INITIATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.a.values().length];
            f9294a = iArr2;
            try {
                iArr2[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9294a[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9294a[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9294a[IronSource.a.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        void a(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile r f9296a = new r(0);

        private c() {
        }
    }

    public /* synthetic */ r(int i2) {
        this();
    }

    private boolean A() {
        Me me = this.l;
        return (me == null || me.j() == null || this.l.j().a() == null || this.l.j().a().size() <= 0) ? false : true;
    }

    private synchronized boolean C() {
        return this.f9287s;
    }

    private boolean D() {
        Me me = this.l;
        return (me == null || me.c() == null || this.l.c().d() == null) ? false : true;
    }

    private boolean E() {
        return D() && G();
    }

    private boolean G() {
        Me me = this.l;
        return (me == null || me.j() == null || this.l.j().b() == null || this.l.j().b().size() <= 0) ? false : true;
    }

    private boolean H() {
        Me me = this.l;
        return (me == null || me.c() == null || this.l.c().e() == null) ? false : true;
    }

    private boolean I() {
        return H() && J();
    }

    private boolean J() {
        Me me = this.l;
        return (me == null || me.j() == null || this.l.j().c() == null || this.l.j().c().isEmpty()) ? false : true;
    }

    private boolean L() {
        Me me = this.l;
        return (me == null || me.c() == null || this.l.c().f() == null) ? false : true;
    }

    private boolean M() {
        return L() && N();
    }

    private boolean N() {
        Me me = this.l;
        return (me == null || me.j() == null || this.l.j().d() == null || this.l.j().d().size() <= 0) ? false : true;
    }

    private void T() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = C2469na.b().c();
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.f9239c)) {
            if (TextUtils.isEmpty(concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f9239c).get(0))) {
                return;
            }
            C2229a5.f7951a.b(!MetaDataUtils.getMetaDataBooleanValue(r0));
        }
    }

    private void U() {
        if (this.F) {
            W();
            return;
        }
        boolean zH = this.l.c().c().d().h();
        this.X = zH;
        if (zH) {
            V();
        } else {
            c0();
        }
    }

    private void V() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.l.j().a());
        if (listA.size() > 0) {
            this.R = new H2(listA, this.l.c().c(), IronSourceUtils.f(), C2469na.b(), this.A);
            u();
        } else {
            JSONObject jSONObjectA = IronSourceUtils.a(false, true, 1);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(D5.TROUBLESHOOTING_BN_INIT_FAILED, jSONObjectA);
            a(IronSource.a.BANNER, false);
        }
    }

    private void W() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.l.j().a().size(); i2++) {
            String str = this.l.j().a().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.l.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject jSONObjectA = IronSourceUtils.a(false, false, 1);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(D5.TROUBLESHOOTING_BN_INIT_FAILED, jSONObjectA);
            a(IronSource.a.BANNER, false);
            return;
        }
        synchronized (this.f9272a0) {
            try {
                V2 v2C = this.l.c().c();
                U4.a aVar = new U4.a("Mediation");
                if (v2C.k()) {
                    aVar.a("isOneFlow", 1);
                }
                this.f9278e0 = new com.ironsource.mediationsdk.demandOnly.c(arrayList, v2C, n(), o(), new U4.b(H9.i(), aVar));
            } catch (Throwable th) {
                throw th;
            }
        }
        for (h.b bVar : this.f9272a0.values()) {
            this.f9278e0.a(bVar.g(), bVar.e());
        }
        this.f9272a0.clear();
    }

    private void X() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.l.j().b().size(); i2++) {
            String str = this.l.j().b().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.l.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject jSONObjectA = IronSourceUtils.a(false, false, 1);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(D5.TROUBLESHOOTING_IS_INIT_FAILED, jSONObjectA);
            a(IronSource.a.INTERSTITIAL, false);
            return;
        }
        synchronized (this.Z) {
            this.f9276c0 = a((List<NetworkSettings>) arrayList);
        }
        Iterator<h.d> it = this.Z.values().iterator();
        while (it.hasNext()) {
            this.f9276c0.a(it.next());
        }
        this.Z.clear();
    }

    private void Y() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.l.j().d().size(); i2++) {
            String str = this.l.j().d().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.l.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            a(IronSource.a.REWARDED_VIDEO, false);
            return;
        }
        synchronized (this.f9274b0) {
            this.d0 = b(arrayList);
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            a(IronSource.a.REWARDED_VIDEO, false);
            return;
        }
        Iterator<h.d> it = this.f9274b0.values().iterator();
        while (it.hasNext()) {
            this.d0.a(it.next());
        }
        this.f9274b0.clear();
    }

    private void Z() {
        if (this.E) {
            X();
        } else {
            a0();
        }
    }

    private void a0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.l.j().b());
        if (listA.size() <= 0) {
            JSONObject jSONObjectA = IronSourceUtils.a(false, true, 1);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(D5.TROUBLESHOOTING_IS_INIT_FAILED, jSONObjectA);
            a(IronSource.a.INTERSTITIAL, false);
            return;
        }
        A9 a9 = new A9(listA, this.l.c().d(), IronSourceUtils.f(), C2469na.b(), this.A);
        this.P = a9;
        Boolean bool = this.f9291w;
        if (bool != null) {
            a9.a(this.f9290v, bool.booleanValue());
        }
        if (this.W) {
            this.W = false;
            this.P.A();
        }
    }

    private boolean b(List<IronSource.a> list, boolean z2, V3 v32) {
        IronLog.INTERNAL.verbose();
        try {
            this.f9288t = list;
            c(true);
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.i("init success");
            if (z2) {
                JSONObject jSONObjectB = IronSourceUtils.b(false);
                try {
                    jSONObjectB.put("revived", true);
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
                Mb.U().q().a(new C5(D5.FIRST_INSTANCE_RESULT, jSONObjectB));
            }
            int iB = v32.b().f().b();
            if (iB >= 0) {
                C2264c4 c2264c4 = new C2264c4();
                c2264c4.a(iB);
                c2264c4.a(iB, this.l.k().d());
            }
            H9.i().h();
            C2256be.i().h();
            Mb.U().q().h();
            com.ironsource.mediationsdk.c.b().b(n(), o());
            for (IronSource.a aVar : IronSource.a.values()) {
                if (this.f9292x.contains(aVar)) {
                    if (list.contains(aVar)) {
                        b(aVar);
                    } else {
                        a(aVar, false);
                    }
                }
            }
            Ec ecQ = q();
            if (ecQ != null) {
                ecQ.a(this.l);
            }
            return true;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            Ec ecQ2 = q();
            if (ecQ2 != null) {
                ecQ2.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "onInitSuccess() had failed"));
            }
            return false;
        }
    }

    private void b0() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> listA = a(this.l.j().d());
        if (listA.size() <= 0) {
            JSONObject jSONObjectA = IronSourceUtils.a(false, true, this.Y);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(D5.TROUBLESHOOTING_RV_INIT_FAILED, jSONObjectA);
            a(IronSource.a.REWARDED_VIDEO, false);
            return;
        }
        s sVar = new s(listA, this.l.c().f(), n(), IronSourceUtils.f(), C2469na.b().a(), this.A);
        this.N = sVar;
        Boolean bool = this.f9291w;
        if (bool != null) {
            sVar.a(this.f9290v, bool.booleanValue());
        }
    }

    private synchronized void c(boolean z2) {
        this.f9287s = z2;
    }

    private void c0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.l.j().a());
        if (listA.size() > 0) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.O = new y(listA, new k(n(), IronSourceUtils.f(), this.l.c().c()), C2469na.b().a(), this.A);
            u();
        } else {
            JSONObject jSONObjectA = IronSourceUtils.a(false, true, 1);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(D5.TROUBLESHOOTING_BN_INIT_FAILED, jSONObjectA);
            a(IronSource.a.BANNER, false);
        }
    }

    private void d(Context context) {
        AtomicBoolean atomicBoolean = this.j;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        C2576tf.a().a(new O6(context));
        Mb.U().q().a(context, this.A);
        H9.i().a(context, this.A);
        C2256be.i().a(context, this.A);
        C2381id.O.a(context, this.A);
    }

    private void d0() {
        if (this.D) {
            Y();
            return;
        }
        Zd zdF = this.l.c().f();
        this.V = zdF.k().h();
        this.Y = a(zdF);
        if (this.T || this.V) {
            e0();
        } else {
            b0();
        }
    }

    private void e(Activity activity, String str) {
        C2434ld c2434ldN;
        try {
            c2434ldN = n(str);
            if (c2434ldN == null) {
                try {
                    c2434ldN = j();
                } catch (Exception e) {
                    e = e;
                    C2531r4.d().a(e);
                    this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo()", e);
                }
            }
            if (c2434ldN == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
                Ed.a().a(new IronSourceError(1021, "showProgrammaticRewardedVideo error: empty default placement in response"), (AdInfo) null);
                return;
            }
        } catch (Exception e4) {
            e = e4;
            c2434ldN = null;
        }
        if (activity != null) {
            e(activity);
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showRewardedVideo when initializing SDK with context", 3);
            Ed.a().a(ErrorBuilder.buildInitFailedError("Activity must be provided in showRewardedVideo when initializing SDK with context", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            return;
        }
        Wd wd = this.Q;
        if (wd != null && (this.T || this.V)) {
            wd.a(activity, c2434ldN);
            return;
        }
        R7 r7 = this.N;
        if (r7 != null) {
            r7.a(activity, c2434ldN);
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet", 3);
        Ed.a().a(new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"), (AdInfo) null);
    }

    private void e0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.l.j().d());
        if (listA.size() <= 0) {
            JSONObject jSONObjectA = IronSourceUtils.a(false, true, this.Y);
            a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(D5.TROUBLESHOOTING_RV_INIT_FAILED, jSONObjectA);
            a(IronSource.a.REWARDED_VIDEO, false);
            return;
        }
        Wd wd = new Wd(listA, this.l.c().f(), IronSourceUtils.f(), this.T, C2469na.b(), this.A);
        this.Q = wd;
        Boolean bool = this.f9291w;
        if (bool != null) {
            wd.a(this.f9290v, bool.booleanValue());
        }
        if (this.U && this.T) {
            this.U = false;
            this.Q.A();
        }
    }

    private K9 i() {
        F9 f9D = this.l.c().d();
        if (f9D != null) {
            return f9D.a();
        }
        return null;
    }

    private C2434ld j() {
        Zd zdF = this.l.c().f();
        if (zdF != null) {
            return zdF.a();
        }
        return null;
    }

    private C2371i3 k(String str) {
        V2 v2C = this.l.c().c();
        if (v2C == null) {
            return new C2482o5();
        }
        if (TextUtils.isEmpty(str)) {
            return v2C.i();
        }
        C2371i3 c2371i3A = v2C.a(str);
        return c2371i3A != null ? c2371i3A : v2C.i();
    }

    public static r m() {
        return c.f9296a;
    }

    private C2434ld n(String str) {
        Zd zdF = this.l.c().f();
        if (zdF != null) {
            return zdF.a(str);
        }
        return null;
    }

    private synchronized Ec q() {
        return this.S;
    }

    private void u() {
        if (this.J.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.J = Boolean.FALSE;
            a(this.K, this.L);
            this.K = null;
            this.L = null;
        }
    }

    private void v() {
        this.h = IronSourceLoggerManager.getLogger(0);
        this.f9280i = new C2674zb();
    }

    private boolean w() {
        try {
            IronLog.INTERNAL.verbose("AdQuality SDK exist: ".concat(IronSourceAdQuality.class.getName()));
            return true;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private boolean x() {
        Me me = this.l;
        return (me == null || me.c() == null || this.l.c().b() == null || this.l.c().b().b() == null) ? false : true;
    }

    private boolean y() {
        Me me = this.l;
        return (me == null || me.c() == null || this.l.c().c() == null) ? false : true;
    }

    private boolean z() {
        return y() && A();
    }

    public boolean B() {
        return this.D || this.E || this.F;
    }

    public boolean F() {
        boolean z2;
        try {
            if (this.E) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            A9 a9 = this.P;
            boolean z7 = a9 != null && a9.u();
            try {
                H9.i().a(new C5(z7 ? D5.IS_CHECK_READY_TRUE : D5.IS_CHECK_READY_FALSE, IronSourceUtils.a(false, true, 1)));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z7, 1);
                return z7;
            } catch (Throwable th) {
                z2 = z7;
                th = th;
                C2531r4.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isInterstitialReady():" + z2, 1);
                this.h.logException(ironSourceTag, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    public boolean K() {
        boolean z2;
        boolean z7;
        try {
            if (this.D) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            if (this.T || this.V) {
                Wd wd = this.Q;
                z7 = wd != null && wd.u();
            } else {
                R7 r7 = this.N;
                if (r7 != null && r7.d()) {
                }
            }
            try {
                JSONObject jSONObjectB = IronSourceUtils.b(false);
                a(jSONObjectB, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.Y)}});
                C2256be.i().a(new C5(z7 ? D5.RV_API_HAS_AVAILABILITY_TRUE : D5.RV_API_HAS_AVAILABILITY_FALSE, jSONObjectB));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z7, 1);
                return z7;
            } catch (Throwable th) {
                z2 = z7;
                th = th;
                C2531r4.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isRewardedVideoAvailable():" + z2, 1);
                this.h.logException(ironSourceTag, "isRewardedVideoAvailable()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    public boolean O() {
        return C();
    }

    public void P() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.E) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
                return;
            }
            if (!this.H) {
                this.h.log(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
                return;
            }
            u.d dVarA = u.c().a();
            if (dVarA == u.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            if (dVarA == u.d.INIT_IN_PROGRESS) {
                if (!u.c().d()) {
                    this.W = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
            }
            if (!E()) {
                this.h.log(ironSourceTag, "No interstitial configurations found", 3);
                n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            A9 a9 = this.P;
            if (a9 == null) {
                this.W = true;
            } else {
                a9.A();
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            n.a().b(IronSource.a.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public void Q() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadRewardedVideo()", 1);
        try {
            if (this.D) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (!this.T && !this.i0) {
                this.h.log(ironSourceTag, "Rewarded Video is not initiated with manual load", 3);
                return;
            }
            if (!this.G) {
                this.h.log(ironSourceTag, "init() must be called before loadRewardedVideo()", 3);
                n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            u.d dVarA = u.c().a();
            if (dVarA == u.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (dVarA == u.d.INIT_IN_PROGRESS) {
                if (!u.c().d()) {
                    this.U = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
            }
            if (!M()) {
                this.h.log(ironSourceTag, "No rewarded video configurations found", 3);
                n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            Wd wd = this.Q;
            if (wd == null) {
                this.U = true;
            } else {
                wd.A();
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            n.a().b(IronSource.a.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public void R() {
        this.i0 = false;
    }

    public void S() {
        if (f9270m0) {
            return;
        }
        f9270m0 = true;
        JSONObject jSONObjectB = IronSourceUtils.b(false);
        try {
            jSONObjectB.put("status", "false");
            jSONObjectB.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.U().q().a(new C5(D5.FIRST_INSTANCE_RESULT, jSONObjectB));
    }

    public void a(long j, Me.a aVar) {
        JSONObject jSONObjectB = IronSourceUtils.b(B());
        try {
            jSONObjectB.put("duration", j);
            jSONObjectB.put("sessionDepth", this.C);
            jSONObjectB.put(IronSourceConstants.EVENTS_EXT1, aVar.b());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.U().q().a(new C5(D5.INIT_COMPLETE, jSONObjectB));
    }

    public C2236ac f() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.l.j().c());
        if (listA.size() > 0) {
            return new C2236ac(listA, this.l.c().e(), IronSourceUtils.f(), C2469na.b(), this.A);
        }
        JSONObject jSONObjectA = IronSourceUtils.a(false, true, 1);
        a(jSONObjectA, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a(D5.TROUBLESHOOTING_NT_INIT_FAILED, jSONObjectA);
        return null;
    }

    @Override // com.ironsource.U9
    public void g(String str) {
        try {
            String str2 = this.f9271a + ":setMediationType(mediationType:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            if (!a(str, 1, 64) || !p(str)) {
                this.h.log(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            } else {
                this.f9285q = str;
                this.g0.f(str);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, androidx.camera.core.processing.util.a.n(new StringBuilder(), this.f9271a, ":setMediationType(mediationType:", str, ")"), e);
        }
    }

    @Override // com.ironsource.Mc
    public void h(String str) {
        try {
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.i("Mediation init failed");
            if (this.f9280i != null) {
                Iterator<IronSource.a> it = this.f9292x.iterator();
                while (it.hasNext()) {
                    a(it.next(), true);
                }
            }
            Ec ecQ = q();
            if (ecQ != null) {
                ecQ.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed"));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public String l() {
        return this.f9284o;
    }

    public void o(String str) {
        com.google.android.gms.ads.internal.client.a.p("userId = ", str, IronLog.API);
        this.f9283n = str;
        Mb.U().q().a(new C5(D5.SET_USER_ID, IronSourceUtils.a(false)));
        AdQualityBridge adQualityBridge = this.f9281j0;
        if (adQualityBridge != null) {
            adQualityBridge.changeUserId(str);
        }
    }

    public String p() {
        return this.f9285q;
    }

    public Map<String, String> r() {
        return this.p;
    }

    public C2270ca s() {
        return this.A;
    }

    public String t() {
        return this.f9289u;
    }

    private r() {
        this(Mb.U().i(), Mb.O().b(), Mb.U().w(), Mb.U().k(), Mb.O().C());
    }

    private K9 l(String str) {
        F9 f9D = this.l.c().d();
        if (f9D != null) {
            return f9D.a(str);
        }
        return null;
    }

    private boolean p(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private U3 q(String str) {
        U3 u32 = new U3();
        if (str == null) {
            u32.a(new IronSourceError(506, "Init Fail - appKey is missing"));
            return u32;
        }
        if (!a(str, 5, 10)) {
            u32.a(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "length should be between 5-10 characters"));
            return u32;
        }
        if (!p(str)) {
            u32.a(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "should contain only english characters and numbers"));
        }
        return u32;
    }

    @Override // com.ironsource.U9
    public void c() {
        this.p = null;
    }

    public C2272cc m(String str) {
        Rb rbE = this.l.c().e();
        if (rbE == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return rbE.e();
        }
        C2272cc c2272ccA = rbE.a(str);
        return c2272ccA != null ? c2272ccA : rbE.e();
    }

    public void c(Activity activity) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showInterstitial()", 1);
        try {
            if (this.E) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C2358h8.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else {
                if (!D()) {
                    C2358h8.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
                    return;
                }
                K9 k9I = i();
                if (k9I != null) {
                    c(activity, k9I.c());
                } else {
                    C2358h8.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e);
            C2358h8.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    @Override // com.ironsource.U9
    public C2434ld i(String str) {
        C2434ld c2434ldN;
        try {
            c2434ldN = n(str);
            if (c2434ldN == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    c2434ldN = j();
                } catch (Exception e) {
                    e = e;
                    C2531r4.d().a(e);
                    return c2434ldN;
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + c2434ldN, 1);
            return c2434ldN;
        } catch (Exception e4) {
            e = e4;
            c2434ldN = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    @Override // com.ironsource.T4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean j(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.mediationsdk.demandOnly.k r0 = r1.d0     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            boolean r2 = r0.a(r2)     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto Lf
            r2 = 1
            goto L10
        Ld:
            r2 = move-exception
            goto L12
        Lf:
            r2 = 0
        L10:
            monitor-exit(r1)
            return r2
        L12:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.r.j(java.lang.String):boolean");
    }

    public String n() {
        return this.m;
    }

    public void d(Activity activity) {
        if (!L()) {
            Ed.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        C2434ld c2434ldJ = j();
        if (c2434ldJ == null) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
            Ed.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
            return;
        }
        f(activity, c2434ldJ.c());
    }

    public r(B7 b72, B7.a aVar, P7 p7, InterfaceC2466n7 interfaceC2466n7, M8.a aVar2) {
        this.f9271a = getClass().getName();
        this.f9273b = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:\u200b9.0.0";
        this.k = new Object();
        this.l = null;
        this.m = null;
        this.f9283n = "";
        this.f9284o = null;
        this.p = null;
        this.f9285q = null;
        this.f9287s = false;
        this.f9291w = null;
        this.f9293z = true;
        this.B = "sessionDepth";
        this.M = null;
        this.i0 = false;
        this.f9275c = b72;
        this.f9277d = aVar;
        this.e = p7;
        this.f9279f = interfaceC2466n7;
        this.g = aVar2;
        v();
        this.j = new AtomicBoolean();
        this.f9292x = new HashSet();
        this.y = new HashSet();
        this.E = false;
        this.D = false;
        this.F = false;
        this.f9286r = new AtomicBoolean(true);
        this.C = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.f9289u = IronSourceUtils.d();
        this.J = Boolean.FALSE;
        this.W = false;
        this.L = null;
        this.N = null;
        this.S = null;
        this.O = null;
        this.T = false;
        this.Z = new ConcurrentHashMap<>();
        this.f9274b0 = new ConcurrentHashMap<>();
        this.f9272a0 = new ConcurrentHashMap<>();
        this.f9276c0 = null;
        this.d0 = null;
        this.f9278e0 = null;
        this.Y = 1;
        this.f0 = new S5();
        V9 v9 = new V9();
        this.g0 = v9;
        this.h0 = new V6(v9);
        this.f9281j0 = null;
        this.k0 = new InterfaceC2250b8.a();
        this.f9282l0 = new InterfaceC2250b8.b();
    }

    private U4 k() {
        return new U4.b(Mb.U().q(), new U4.a("IronSource"));
    }

    public synchronized IronSourceError a(Context context, String str, boolean z2, Ec ec, IronSource.a... aVarArr) {
        Throwable th;
        boolean z7;
        r rVar;
        boolean z8;
        try {
            try {
                IronLog.INTERNAL.verbose("GitHash: 9f697d2");
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            if (!C2234aa.a((Object) context, "Init Failed - provided context is null")) {
                h("Provided context is null");
                return new IronSourceError(2000, "Provided context is null");
            }
            this.g.a(context);
            boolean z9 = context instanceof Activity;
            if (z9) {
                e((Activity) context);
            }
            AtomicBoolean atomicBoolean = this.f9286r;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(true, false)) {
                Ce.f6411a.a(ec == null);
                if ((aVarArr == null || aVarArr.length == 0) && ec == null) {
                    for (IronSource.a aVar : IronSource.a.values()) {
                        this.f9292x.add(aVar);
                    }
                    this.G = true;
                    this.H = true;
                    this.I = true;
                } else {
                    for (IronSource.a aVar2 : aVarArr) {
                        this.f9292x.add(aVar2);
                        this.y.add(aVar2);
                        if (aVar2.equals(IronSource.a.INTERSTITIAL)) {
                            this.H = true;
                        }
                        if (aVar2.equals(IronSource.a.BANNER)) {
                            this.I = true;
                        }
                        if (aVar2.equals(IronSource.a.REWARDED_VIDEO)) {
                            this.G = true;
                        }
                    }
                }
                IronLog.API.info("init(appKey:" + str + ")");
                U3 u3Q = q(str);
                if (u3Q.b()) {
                    this.m = str;
                }
                Me meA = a(context, this.m);
                if (meA != null) {
                    IronLog.INTERNAL.verbose("init cache exists");
                    a(meA.c().b().f());
                } else {
                    IronLog.INTERNAL.verbose("init cache does not exist");
                }
                ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
                this.f9277d.a(context.getApplicationContext(), TimeUnit.HOURS.toMillis(C2229a5.f7951a.d()));
                this.g0.g(LevelPlay.getSdkVersion());
                this.g0.a(T7.a());
                this.g0.b(IronSourceUtils.f(context));
                this.g0.a(C2385j0.a());
                T();
                d(context);
                if (this.m == null) {
                    u.c().f();
                    if (this.f9292x.contains(IronSource.a.REWARDED_VIDEO)) {
                        Ed.a().a(false, (AdInfo) null);
                    }
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, u3Q.a().toString(), 1);
                    return new IronSourceError(2010, "App key is null");
                }
                this.g0.a(context);
                this.g0.c(this.m);
                this.g0.h(this.f9289u);
                if (this.f9293z) {
                    JSONObject jSONObjectB = IronSourceUtils.b(z2);
                    if (aVarArr != null) {
                        for (IronSource.a aVar3 : aVarArr) {
                            try {
                                jSONObjectB.put(aVar3.toString(), true);
                            } catch (Exception e) {
                                C2531r4.d().a(e);
                            }
                        }
                    }
                    int i2 = this.C + 1;
                    this.C = i2;
                    if (ec != null) {
                        z7 = true;
                        z8 = z2;
                        rVar = this;
                    } else {
                        z7 = false;
                        rVar = this;
                        z8 = z2;
                    }
                    try {
                        rVar.a(z9, z8, i2, jSONObjectB, z7);
                        rVar.f9293z = false;
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        throw th;
                    }
                }
                return null;
            }
            if (aVarArr != null) {
                a(z9, z2, ec != null, aVarArr);
            } else {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
            }
            Be beB = Ce.f6411a.b();
            if (C()) {
                a(this.l);
                return new IronSourceError(IronSourceError.ERROR_INIT_ALREADY_FINISHED, "Already finished init");
            }
            if (beB == Be.INIT_FAILED) {
                return new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed");
            }
            if (beB != Be.NOT_INIT) {
                if (ec != null) {
                    a(ec);
                }
                return new IronSourceError(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, "Old Api init in progress");
            }
            return new IronSourceError(IronSourceError.ERROR_NEW_INIT_API_ALREADY_CALLED, "Already called new init");
        } catch (Throwable th5) {
            th = th5;
            throw th;
        }
    }

    public Me h() {
        return this.l;
    }

    public void f(Activity activity, String str) {
        String strM = a1.a.m("showRewardedVideo(", str, ")");
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, strM, 1);
        try {
            if (this.D) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                Ed.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (!L()) {
                Ed.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else {
                e(activity, str);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, strM, e);
            Ed.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    public String o() {
        return this.f9283n;
    }

    private void d(Activity activity, String str) {
        try {
            K9 k9L = l(str);
            if (k9L == null) {
                k9L = i();
            }
            if (k9L == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                C2358h8.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                e(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                C2358h8.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            this.P.a(activity, new C2434ld(k9L));
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e);
        }
    }

    public Boolean g() {
        return this.M;
    }

    public void c(Activity activity, String str) {
        String strM = a1.a.m("showInterstitial(", str, ")");
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, strM, 1);
        try {
            if (this.E) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                C2358h8.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (!D()) {
                C2358h8.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            } else {
                d(activity, str);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, strM, e);
            C2358h8.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    @Override // com.ironsource.T4.a
    public void e(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            com.ironsource.mediationsdk.demandOnly.c cVar = this.f9278e0;
            if (cVar != null) {
                cVar.a(str);
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    public String e() {
        u uVarC = u.c();
        int i2 = a.f9295b[uVarC.a().ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i2 != 3 ? (i2 == 4 && !I()) ? "No Native Ad configurations found" : "" : uVarC.d() ? "init() had failed" : "init() not finished yet" : "init() had failed";
        }
        return "init() must be called first";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    @Override // com.ironsource.T4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean d(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.mediationsdk.demandOnly.f r0 = r1.f9276c0     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            boolean r2 = r0.b(r2)     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto Lf
            r2 = 1
            goto L10
        Ld:
            r2 = move-exception
            goto L12
        Lf:
            r2 = 0
        L10:
            monitor-exit(r1)
            return r2
        L12:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.r.d(java.lang.String):boolean");
    }

    @Override // com.ironsource.U9
    public void d() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        C2358h8.a().a((InterfaceC2361hb) null);
    }

    private void b(IronSource.a aVar) {
        int i2 = a.f9294a[aVar.ordinal()];
        if (i2 == 1) {
            d0();
        } else if (i2 == 2) {
            Z();
        } else {
            if (i2 != 3) {
                return;
            }
            U();
        }
    }

    private void e(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog.INTERNAL.verbose("activity is updated to: " + activity.hashCode());
    }

    private boolean d(Me me) {
        com.ironsource.mediationsdk.adquality.a aVarA = me.c().a();
        return this.f9281j0 == null && aVarA != null && aVarA.b() && AdQualityBridge.adQualityAvailable();
    }

    @Override // com.ironsource.U9
    public K9 f(String str) {
        K9 k9L;
        try {
            k9L = l(str);
            if (k9L == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    k9L = i();
                } catch (Exception e) {
                    e = e;
                    C2531r4.d().a(e);
                    return k9L;
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + k9L, 1);
            return k9L;
        } catch (Exception e4) {
            e = e4;
            k9L = null;
        }
    }

    private com.ironsource.mediationsdk.demandOnly.k b(List<NetworkSettings> list) {
        Zd zdF = this.l.c().f();
        U4.a aVar = new U4.a("Mediation");
        if (zdF.d()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.k(list, zdF, com.ironsource.mediationsdk.c.b(), this.f9282l0, n(), o(), new U4.b(C2256be.i(), aVar));
    }

    @Override // com.ironsource.T4.b
    public void c(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "showDemandOnlyInterstitial() instanceId=" + str, 1);
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = this.k0.a(str);
        try {
            if (!this.E) {
                IronLog.API.error("Interstitial was initialized in mediation mode. Use showInterstitial instead");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was initialized in mediation mode. Use showInterstitial instead"));
                return;
            }
            com.ironsource.mediationsdk.demandOnly.f fVar = this.f9276c0;
            if (fVar == null) {
                IronLog.API.error("Interstitial was not initiated");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was not initiated"));
            } else {
                fVar.a(str);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.API.error(e.getMessage());
            if (iSDemandOnlyInterstitialListenerA != null) {
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            }
        }
    }

    public void b(Activity activity) {
        IronLog ironLog = IronLog.API;
        ironLog.info("onResume()");
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                ironLog.info("onResume() is disabled");
            } else {
                ContextProvider.getInstance().onResume(activity);
            }
        } catch (Throwable th) {
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
            C2531r4.d().a(th);
        }
    }

    @Override // com.ironsource.U9
    public boolean b(String str) {
        try {
            U3 u32 = new U3();
            a(str, u32);
            if (u32.b()) {
                this.f9284o = str;
                Mb.U().q().a(new C5(D5.SET_USER_ID, IronSourceUtils.a(true)));
                return true;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, u32.a().toString(), 2);
            return false;
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, androidx.camera.core.processing.util.a.n(new StringBuilder(), this.f9271a, ":setDynamicUserId(dynamicUserId:", str, ")"), e);
            return false;
        }
    }

    public void c(Context context) {
        Bf bf = Bf.f6395a;
        bf.b();
        if (!C()) {
            bf.a(IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
            return;
        }
        if (!c(this.l)) {
            bf.a(IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
            return;
        }
        if (!IronSourceUtils.g(context)) {
            bf.a(IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
            return;
        }
        A9 a9 = this.P;
        if (a9 != null) {
            a9.J();
        }
        Wd wd = this.Q;
        if (wd != null) {
            wd.J();
        }
        H2 h22 = this.R;
        if (h22 != null) {
            h22.J();
            this.R.T();
        }
        new Cf().a(context, n(), this.l.i(), LevelPlay.getSdkVersion(), this.l.c().g().b(), g(), this.T);
        this.i0 = true;
        bf.c();
    }

    @Override // com.ironsource.T4.c
    public synchronized void b(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.a.REWARDED_VIDEO).b(), this.f9282l0.a(str));
    }

    @Override // com.ironsource.T4.b
    public synchronized void b(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.a.INTERSTITIAL).a(true).a(str2).b(), this.k0.a(str));
    }

    private void a(K1 k12) {
        C2229a5 c2229a5 = C2229a5.f7951a;
        c2229a5.c(k12.g());
        c2229a5.a(k12.f());
        c2229a5.a(k12.j());
        this.f9279f.a(k12);
    }

    private boolean c(Me me) {
        return me != null && me.o();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:3:0x0001, B:5:0x0009, B:23:0x0046, B:25:0x004a, B:27:0x0054, B:29:0x0058, B:30:0x005c, B:32:0x0064, B:33:0x0067, B:35:0x006f, B:37:0x0073, B:38:0x0077, B:40:0x007f, B:41:0x0082, B:43:0x008a, B:45:0x008e, B:46:0x0092, B:48:0x009a, B:49:0x009d, B:51:0x00a2, B:53:0x00a6, B:54:0x00ac, B:11:0x0012, B:13:0x0016, B:15:0x0023, B:17:0x0027, B:19:0x0034, B:21:0x0038, B:22:0x003e, B:18:0x002d, B:14:0x001c), top: B:59:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.ironsource.mediationsdk.IronSource.a> a(android.content.Context r5, java.lang.String r6, boolean r7, com.ironsource.mediationsdk.IronSource.a... r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld
            r6.<init>()     // Catch: java.lang.Throwable -> Ld
            r0 = 1
            if (r8 == 0) goto L10
            int r1 = r8.length     // Catch: java.lang.Throwable -> Ld
            if (r1 != 0) goto L46
            goto L10
        Ld:
            r5 = move-exception
            goto Lb9
        L10:
            if (r7 == 0) goto L46
            boolean r7 = r4.G     // Catch: java.lang.Throwable -> Ld
            if (r7 == 0) goto L1c
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.REWARDED_VIDEO     // Catch: java.lang.Throwable -> Ld
            r4.a(r7)     // Catch: java.lang.Throwable -> Ld
            goto L23
        L1c:
            r4.D = r0     // Catch: java.lang.Throwable -> Ld
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.REWARDED_VIDEO     // Catch: java.lang.Throwable -> Ld
            r6.add(r7)     // Catch: java.lang.Throwable -> Ld
        L23:
            boolean r7 = r4.H     // Catch: java.lang.Throwable -> Ld
            if (r7 == 0) goto L2d
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.INTERSTITIAL     // Catch: java.lang.Throwable -> Ld
            r4.a(r7)     // Catch: java.lang.Throwable -> Ld
            goto L34
        L2d:
            r4.E = r0     // Catch: java.lang.Throwable -> Ld
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.INTERSTITIAL     // Catch: java.lang.Throwable -> Ld
            r6.add(r7)     // Catch: java.lang.Throwable -> Ld
        L34:
            boolean r7 = r4.I     // Catch: java.lang.Throwable -> Ld
            if (r7 == 0) goto L3e
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.BANNER     // Catch: java.lang.Throwable -> Ld
            r4.a(r7)     // Catch: java.lang.Throwable -> Ld
            goto La0
        L3e:
            r4.F = r0     // Catch: java.lang.Throwable -> Ld
            com.ironsource.mediationsdk.IronSource$a r7 = com.ironsource.mediationsdk.IronSource.a.BANNER     // Catch: java.lang.Throwable -> Ld
            r6.add(r7)     // Catch: java.lang.Throwable -> Ld
            goto La0
        L46:
            int r7 = r8.length     // Catch: java.lang.Throwable -> Ld
            r1 = 0
        L48:
            if (r1 >= r7) goto La0
            r2 = r8[r1]     // Catch: java.lang.Throwable -> Ld
            com.ironsource.mediationsdk.IronSource$a r3 = com.ironsource.mediationsdk.IronSource.a.INTERSTITIAL     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L67
            boolean r3 = r4.H     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L5c
            r4.a(r2)     // Catch: java.lang.Throwable -> Ld
            goto L67
        L5c:
            r4.E = r0     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r6.contains(r2)     // Catch: java.lang.Throwable -> Ld
            if (r3 != 0) goto L67
            r6.add(r2)     // Catch: java.lang.Throwable -> Ld
        L67:
            com.ironsource.mediationsdk.IronSource$a r3 = com.ironsource.mediationsdk.IronSource.a.REWARDED_VIDEO     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L82
            boolean r3 = r4.G     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L77
            r4.a(r2)     // Catch: java.lang.Throwable -> Ld
            goto L82
        L77:
            r4.D = r0     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r6.contains(r2)     // Catch: java.lang.Throwable -> Ld
            if (r3 != 0) goto L82
            r6.add(r2)     // Catch: java.lang.Throwable -> Ld
        L82:
            com.ironsource.mediationsdk.IronSource$a r3 = com.ironsource.mediationsdk.IronSource.a.BANNER     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L9d
            boolean r3 = r4.I     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L92
            r4.a(r2)     // Catch: java.lang.Throwable -> Ld
            goto L9d
        L92:
            r4.F = r0     // Catch: java.lang.Throwable -> Ld
            boolean r3 = r6.contains(r2)     // Catch: java.lang.Throwable -> Ld
            if (r3 != 0) goto L9d
            r6.add(r2)     // Catch: java.lang.Throwable -> Ld
        L9d:
            int r1 = r1 + 1
            goto L48
        La0:
            if (r5 == 0) goto Lb7
            boolean r7 = r5 instanceof android.app.Activity     // Catch: java.lang.Throwable -> Ld
            if (r7 == 0) goto Lac
            r7 = r5
            android.app.Activity r7 = (android.app.Activity) r7     // Catch: java.lang.Throwable -> Ld
            r4.e(r7)     // Catch: java.lang.Throwable -> Ld
        Lac:
            com.ironsource.environment.ContextProvider r7 = com.ironsource.environment.ContextProvider.getInstance()     // Catch: java.lang.Throwable -> Ld
            android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> Ld
            r7.updateAppContext(r5)     // Catch: java.lang.Throwable -> Ld
        Lb7:
            monitor-exit(r4)
            return r6
        Lb9:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Ld
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.r.a(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.IronSource$a[]):java.util.List");
    }

    public q b(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBanner()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new q(activity, iSBannerSize);
    }

    public void b(q qVar) {
        a(qVar, "");
    }

    private boolean b(h.b bVar) {
        synchronized (this.f9272a0) {
            try {
                if (this.f9278e0 != null) {
                    return false;
                }
                this.f9272a0.put(bVar.e(), bVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Me b(Context context, String str, b bVar) {
        synchronized (this.k) {
            try {
                Me me = this.l;
                if (me != null) {
                    return new Me(me);
                }
                Me meA = a(context, str, bVar);
                if (meA == null || !meA.p()) {
                    IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
                    meA = a(context, n());
                    if (meA != null) {
                        IronSourceError ironSourceErrorBuildUsingCachedConfigurationError = ErrorBuilder.buildUsingCachedConfigurationError(n(), str);
                        this.h.log(ironSourceTag, ironSourceErrorBuildUsingCachedConfigurationError.toString() + ": " + meA.toString(), 1);
                        Mb.U().q().a(new C5(D5.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.b(false)));
                    }
                }
                if (meA != null) {
                    this.l = meA;
                    IronSourceUtils.e(context, meA.toString());
                    b(this.l, context);
                    H9.i().c(true);
                    C2256be.i().c(true);
                    C2381id.O.c(true);
                    Mb.U().q().c(true);
                }
                return meA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Me me, Context context) {
        b(me);
        a(me, context);
    }

    private void a(IronSource.a aVar) {
        String str = aVar + " ad unit has already been initialized";
        this.h.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.i(str);
    }

    private void b(Me me) {
        this.h.setLoggerDebugLevel("console", me.c().b().h().a());
    }

    private synchronized void a(boolean z2, boolean z7, boolean z8, IronSource.a... aVarArr) throws Throwable {
        Throwable th;
        int i2;
        try {
            try {
                i2 = 0;
                for (IronSource.a aVar : aVarArr) {
                    try {
                        if (aVar.equals(IronSource.a.INTERSTITIAL)) {
                            this.H = true;
                        } else if (aVar.equals(IronSource.a.BANNER)) {
                            this.I = true;
                        } else if (aVar.equals(IronSource.a.REWARDED_VIDEO)) {
                            this.G = true;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (u.c().a() == u.d.INIT_FAILED) {
            try {
                if (this.f9280i != null) {
                    int length = aVarArr.length;
                    while (i2 < length) {
                        IronSource.a aVar2 = aVarArr[i2];
                        if (!this.f9292x.contains(aVar2)) {
                            a(aVar2, true);
                        }
                        i2++;
                    }
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        } else if (!C()) {
            JSONObject jSONObjectB = IronSourceUtils.b(z7);
            int length2 = aVarArr.length;
            while (i2 < length2) {
                IronSource.a aVar3 = aVarArr[i2];
                if (!this.f9292x.contains(aVar3)) {
                    this.f9292x.add(aVar3);
                    this.y.add(aVar3);
                    try {
                        jSONObjectB.put(aVar3.toString(), true);
                    } catch (Exception e4) {
                        C2531r4.d().a(e4);
                        IronLog.INTERNAL.error(e4.toString());
                    }
                } else {
                    this.h.log(IronSourceLogger.IronSourceTag.API, aVar3 + " ad unit has started initializing.", 3);
                }
                i2++;
            }
            int i8 = this.C + 1;
            this.C = i8;
            a(z2, z7, i8, jSONObjectB, z8);
        } else {
            if (this.f9288t == null) {
                return;
            }
            try {
                new Nb().a(this.l.c().b().e().b(), B());
            } catch (Exception e8) {
                C2531r4.d().a(e8);
                IronLog.INTERNAL.error(e8.toString());
            }
            JSONObject jSONObjectB2 = IronSourceUtils.b(z7);
            for (IronSource.a aVar4 : aVarArr) {
                if (!this.f9292x.contains(aVar4)) {
                    this.f9292x.add(aVar4);
                    this.y.add(aVar4);
                    try {
                        jSONObjectB2.put(aVar4.toString(), true);
                    } catch (Exception e9) {
                        C2531r4.d().a(e9);
                        IronLog.INTERNAL.error(e9.toString());
                    }
                    List<IronSource.a> list = this.f9288t;
                    if (list != null && list.contains(aVar4)) {
                        b(aVar4);
                    } else {
                        a(aVar4, false);
                    }
                } else {
                    a(aVar4);
                }
            }
            int i9 = this.C + 1;
            this.C = i9;
            try {
                a(z2, z7, i9, jSONObjectB2, z8);
            } catch (Throwable th5) {
                th = th5;
            }
            th = th;
            throw th;
        }
    }

    @Override // com.ironsource.U9
    public void b() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        Ed.a().a((InterfaceC2555sb) null);
    }

    @Override // com.ironsource.U9
    public String b(Context context) {
        String strI = this.f9275c.I(context);
        Mb.U().q().a(new C5(D5.GET_ADVERTISING_ID, IronSourceUtils.b(false)));
        return !TextUtils.isEmpty(strI) ? strI : "";
    }

    private void b(D5 d52, JSONObject jSONObject) {
        C2256be.i().a(new C5(d52, jSONObject));
    }

    public void b(boolean z2) {
        this.M = Boolean.valueOf(z2);
        com.ironsource.mediationsdk.c.b().b(z2);
        this.g0.a(z2);
        Mb.U().q().a(new C5(z2 ? D5.CONSENT_TRUE_CODE : D5.CONSENT_FALSE_CODE, IronSourceUtils.b(false)));
    }

    public void b(String str, JSONObject jSONObject) {
        com.ironsource.mediationsdk.c.b().b(new x(str, jSONObject));
    }

    @Override // com.ironsource.Z8
    public void b(InterfaceC2233a9 interfaceC2233a9) {
        if (C2234aa.a((Object) interfaceC2233a9, "removeImpressionDataListener - listener is null")) {
            C2469na.b().b(interfaceC2233a9);
            R7 r7 = this.N;
            if (r7 != null) {
                r7.b(interfaceC2233a9);
            }
            y yVar = this.O;
            if (yVar != null) {
                yVar.b(interfaceC2233a9);
            }
        }
    }

    private void a(boolean z2, boolean z7, int i2, JSONObject jSONObject, boolean z8) {
        try {
            StringBuilder sb = new StringBuilder();
            if (z7) {
                sb.append(",Activity=" + (ContextProvider.getInstance().getCurrentActiveActivity() != null));
            } else if (!z2) {
                sb.append(",init_context_flow");
            }
            sb.append(",cachedUserAgent=" + this.f9275c.n());
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
            jSONObject.put("sessionDepth", i2);
            if (z8) {
                if (z7) {
                    jSONObject.put("isMultipleAdObjects", 1);
                } else {
                    jSONObject.put("isMultipleAdUnits", 1);
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.U().q().a(new C5(D5.FIRST_INSTANCE, jSONObject));
    }

    private synchronized void a(Ec ec) {
        this.S = ec;
    }

    public boolean a(boolean z2, Me me) {
        a(me);
        if (C()) {
            return true;
        }
        synchronized (this.k) {
            this.l = me;
        }
        return b(me.g(), z2, me.c());
    }

    @Override // com.ironsource.Mc
    public void a(List<IronSource.a> list, boolean z2, V3 v32) {
        a(this.l);
        b(list, z2, v32);
    }

    private void a(Me me) {
        if (w() && d(me)) {
            AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), n(), o(), new C2350h0(), me.c().b().h().a());
            this.f9281j0 = adQualityBridge;
            C2270ca c2270ca = this.A;
            if (c2270ca != null) {
                adQualityBridge.setSegment(c2270ca);
            }
        }
    }

    private com.ironsource.mediationsdk.demandOnly.f a(List<NetworkSettings> list) {
        F9 f9D = this.l.c().d();
        U4.a aVar = new U4.a("Mediation");
        if (f9D.j()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.f(list, f9D, com.ironsource.mediationsdk.c.b(), this.k0, n(), o(), new U4.b(H9.i(), aVar));
    }

    private int a(Zd zd) {
        return (this.V || this.T || !zd.k().e()) ? 1 : 2;
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.l.k().b(str));
            }
        }
        return arrayList2;
    }

    @Override // com.ironsource.Mc
    public void a() {
        if (this.J.booleanValue()) {
            this.J = Boolean.FALSE;
            n.a().b(IronSource.a.BANNER, new IronSourceError(603, "init() had failed"));
            this.K = null;
            this.L = null;
        }
        if (this.W) {
            this.W = false;
            n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        if (this.U) {
            this.U = false;
            n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.Z) {
            try {
                Iterator<h.d> it = this.Z.values().iterator();
                while (it.hasNext()) {
                    String strE = it.next().e();
                    this.k0.a(strE).onInterstitialAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                }
                this.Z.clear();
            } finally {
            }
        }
        synchronized (this.f9274b0) {
            try {
                Iterator<h.d> it2 = this.f9274b0.values().iterator();
                while (it2.hasNext()) {
                    String strE2 = it2.next().e();
                    this.f9282l0.a(strE2).onRewardedVideoAdLoadFailed(strE2, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                }
                this.f9274b0.clear();
            } finally {
            }
        }
        synchronized (this.f9272a0) {
            try {
                for (h.b bVar : this.f9272a0.values()) {
                    ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.g();
                    if (iSDemandOnlyBannerLayoutG != null) {
                        iSDemandOnlyBannerLayoutG.getListener().a(bVar.e(), ErrorBuilder.buildInitFailedError("init() had failed", "Banner"));
                    }
                }
                this.f9272a0.clear();
            } finally {
            }
        }
    }

    private void a(IronSource.a aVar, boolean z2) {
        int i2 = a.f9294a[aVar.ordinal()];
        if (i2 == 1) {
            if (this.D) {
                Iterator<h.d> it = this.f9274b0.values().iterator();
                while (it.hasNext()) {
                    String strE = it.next().e();
                    this.f9282l0.a(strE).onRewardedVideoAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                }
                this.f9274b0.clear();
                return;
            }
            if (this.T) {
                if (this.U) {
                    this.U = false;
                    n.a().b(IronSource.a.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
                return;
            }
            if (z2 || L() || this.y.contains(aVar)) {
                Ed.a().a(false, (AdInfo) null);
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (this.E) {
                Iterator<h.d> it2 = this.Z.values().iterator();
                while (it2.hasNext()) {
                    String strE2 = it2.next().e();
                    this.k0.a(strE2).onInterstitialAdLoadFailed(strE2, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
                }
                this.Z.clear();
                return;
            }
            if (this.W) {
                this.W = false;
                n.a().b(IronSource.a.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            return;
        }
        if (i2 != 3) {
            return;
        }
        if (this.F) {
            for (h.b bVar : this.f9272a0.values()) {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.g();
                if (iSDemandOnlyBannerLayoutG != null) {
                    iSDemandOnlyBannerLayoutG.getListener().a(bVar.e(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Banner"));
                }
            }
            this.f9272a0.clear();
            return;
        }
        if (this.J.booleanValue()) {
            this.J = Boolean.FALSE;
            n.a().b(IronSource.a.BANNER, new IronSourceError(602, "init() had failed"));
            this.K = null;
            this.L = null;
        }
    }

    public void a(Activity activity) {
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                return;
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    public void a(C2270ca c2270ca) {
        this.A = c2270ca;
        Wd wd = this.Q;
        if (wd != null) {
            wd.a(c2270ca);
        }
        R7 r7 = this.N;
        if (r7 != null) {
            r7.a(c2270ca);
        }
        A9 a9 = this.P;
        if (a9 != null) {
            a9.a(c2270ca);
        }
        y yVar = this.O;
        if (yVar != null) {
            yVar.a(c2270ca);
        }
        H2 h22 = this.R;
        if (h22 != null) {
            h22.a(c2270ca);
        }
        AdQualityBridge adQualityBridge = this.f9281j0;
        if (adQualityBridge != null) {
            adQualityBridge.setSegment(c2270ca);
        }
        H9.i().a(this.A);
        C2256be.i().a(this.A);
        C2381id.O.a(this.A);
        Mb.U().q().a(this.A);
    }

    @Override // com.ironsource.U9
    public void a(boolean z2) {
        com.ironsource.mediationsdk.c.b().a(z2);
    }

    @Override // com.ironsource.U9
    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                this.h.log(IronSourceLogger.IronSourceTag.API, this.f9271a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                this.p = new HashMap(map);
                C5 c52 = new C5(D5.SET_RV_SERVER_PARAMS, IronSourceUtils.b(false));
                c52.a(IronSourceConstants.EVENTS_EXT1, map.toString());
                C2256be.i().a(c52);
            } catch (Exception e) {
                C2531r4.d().a(e);
                this.h.logException(IronSourceLogger.IronSourceTag.API, this.f9271a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e);
            }
        }
    }

    @Override // com.ironsource.T4.c
    public synchronized void a(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(str2).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(true).a(IronSource.a.REWARDED_VIDEO).b(), this.f9282l0.a(str));
    }

    public void a(h.d dVar, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        String strE = dVar.e();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strE);
        try {
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, new IronSourceError(510, th.getMessage()));
        }
        if (!this.G) {
            ironLog.error("initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, new IronSourceError(510, "initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()"));
            return;
        }
        if (!this.D) {
            ironLog.error("Rewarded video was initialized in mediation mode");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, new IronSourceError(510, "Rewarded video was initialized in mediation mode"));
            return;
        }
        u.d dVarA = u.c().a();
        if (dVarA == u.d.INIT_FAILED) {
            ironLog.error("init() had failed");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronSourceError ironSourceErrorA = dVar.a();
        if (ironSourceErrorA != null) {
            if (ironSourceErrorA.getErrorCode() == 1060) {
                b(D5.TROUBLESHOOTING_DO_CALLED_RV_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            ironLog.error(ironSourceErrorA.toString());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, ironSourceErrorA);
            return;
        }
        e(dVar.d());
        if (dVarA == u.d.INIT_IN_PROGRESS) {
            if (u.c().d()) {
                ironLog.error("init() had failed");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            synchronized (this.f9274b0) {
                this.f9274b0.put(strE, dVar);
            }
            if (TextUtils.isEmpty(dVar.b())) {
                return;
            }
            b(D5.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
            return;
        }
        if (!M()) {
            ironLog.error("No rewarded video configurations found");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        synchronized (this.f9274b0) {
            try {
                com.ironsource.mediationsdk.demandOnly.k kVar = this.d0;
                if (kVar == null) {
                    this.f9274b0.put(strE, dVar);
                    if (!TextUtils.isEmpty(dVar.b())) {
                        b(D5.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
                    }
                    return;
                }
                kVar.a(dVar);
                return;
            } finally {
            }
        }
        C2531r4.d().a(th);
        IronLog.API.error(th.getMessage());
        iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strE, new IronSourceError(510, th.getMessage()));
    }

    @Override // com.ironsource.T4.c
    public synchronized void a(String str) {
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + str);
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListenerA = this.f9282l0.a(str);
        try {
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.API.error(e.getMessage());
            if (iSDemandOnlyRewardedVideoListenerA != null) {
                iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(510, e.getMessage()));
            }
        }
        if (!this.D) {
            ironLog.error("Rewarded video was initialized in mediation mode. Use showRewardedVideo instead");
            iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
            return;
        }
        com.ironsource.mediationsdk.demandOnly.k kVar = this.d0;
        if (kVar == null) {
            ironLog.error("Rewarded video was not initiated");
            iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was not initiated"));
        } else {
            kVar.b(str);
        }
    }

    @Override // com.ironsource.T4.c
    public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.f9282l0.a(iSDemandOnlyRewardedVideoListener);
    }

    @Override // com.ironsource.T4.b
    public synchronized void a(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.a.INTERSTITIAL).b(), this.k0.a(str));
    }

    private synchronized void a(h.d dVar, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        String strE = dVar.e();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strE);
        try {
            if (!this.H) {
                ironLog.error("initISDemandOnly() must be called before loadISDemandOnlyInterstitial()");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, new IronSourceError(510, "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"));
                return;
            }
            if (!this.E) {
                ironLog.error("Interstitial was initialized in mediation mode. Use loadInterstitial instead");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, new IronSourceError(510, "Interstitial was initialized in mediation mode. Use loadInterstitial instead"));
                return;
            }
            u.d dVarA = u.c().a();
            if (dVarA == u.d.INIT_FAILED) {
                ironLog.error("init() had failed");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            IronSourceError ironSourceErrorA = dVar.a();
            if (ironSourceErrorA != null) {
                if (ironSourceErrorA.getErrorCode() == 1060) {
                    b(D5.TROUBLESHOOTING_DO_CALLED_IS_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
                }
                ironLog.error(ironSourceErrorA.toString());
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, ironSourceErrorA);
                return;
            }
            e(dVar.d());
            if (dVarA == u.d.INIT_IN_PROGRESS) {
                if (u.c().d()) {
                    ironLog.error("init() had failed");
                    iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                } else {
                    synchronized (this.Z) {
                        this.Z.put(dVar.e(), dVar);
                    }
                    if (!TextUtils.isEmpty(dVar.e())) {
                        a(D5.TROUBLESHOOTING_DO_IAB_IS_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
                    }
                }
                return;
            }
            if (!E()) {
                ironLog.error("No interstitial configurations found");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            synchronized (this.Z) {
                try {
                    com.ironsource.mediationsdk.demandOnly.f fVar = this.f9276c0;
                    if (fVar == null) {
                        this.Z.put(dVar.e(), dVar);
                        if (!TextUtils.isEmpty(dVar.b())) {
                            a(D5.TROUBLESHOOTING_DO_IAB_IS_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.a(true, !TextUtils.isEmpty(dVar.b()), 1));
                        }
                        return;
                    }
                    fVar.a(dVar);
                } finally {
                }
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strE, new IronSourceError(510, th.getMessage()));
        }
    }

    @Override // com.ironsource.T4.b
    public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.k0.a(iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.T4.a
    public ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    public void a(q qVar, String str) {
        com.google.android.gms.ads.internal.client.a.p("placementName = ", str, IronLog.INTERNAL);
        if (this.F) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            n.a().b(IronSource.a.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", "Banner"));
            return;
        }
        if (qVar != null && !qVar.b()) {
            if (!this.I) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
                n.a().b(IronSource.a.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
                return;
            }
            if (qVar.getSize().getDescription().equals("CUSTOM") && (qVar.getSize().getWidth() <= 0 || qVar.getSize().getHeight() <= 0)) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
                n.a().b(IronSource.a.BANNER, ErrorBuilder.unsupportedBannerSize(""));
                return;
            }
            u.d dVarA = u.c().a();
            if (dVarA == u.d.INIT_FAILED) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                n.a().b(IronSource.a.BANNER, new IronSourceError(600, "Init() had failed"));
                return;
            }
            if (dVarA == u.d.INIT_IN_PROGRESS) {
                if (u.c().d()) {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    n.a().b(IronSource.a.BANNER, new IronSourceError(601, "Init() had failed"));
                    return;
                } else {
                    this.K = qVar;
                    this.J = Boolean.TRUE;
                    this.L = str;
                    return;
                }
            }
            if (!z()) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                n.a().b(IronSource.a.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "the server response does not contain banner data"));
                return;
            }
            y yVar = this.O;
            if (yVar == null && this.R == null) {
                this.K = qVar;
                this.J = Boolean.TRUE;
                this.L = str;
                return;
            } else if (this.X) {
                this.R.a(qVar, new C2434ld(k(str)));
                return;
            } else {
                yVar.a(qVar, k(str));
                return;
            }
        }
        String strConcat = "loadBanner can't be called - ".concat(qVar == null ? "banner layout is null " : "banner layout is destroyed");
        this.h.log(IronSourceLogger.IronSourceTag.API, strConcat, 3);
        n.a().b(IronSource.a.BANNER, ErrorBuilder.buildLoadFailedError(strConcat));
    }

    public void a(q qVar) {
        H2 h22;
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (this.X && (h22 = this.R) != null) {
                h22.a(qVar);
                return;
            }
            y yVar = this.O;
            if (yVar != null) {
                yVar.a(qVar);
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    @Override // com.ironsource.T4.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        h.b bVarA = new h.c().b(str).a(activity).a(iSDemandOnlyBannerLayout).a(IronSource.a.BANNER).a();
        IronSourceError ironSourceErrorA = bVarA.a();
        if (ironSourceErrorA != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA);
            }
            return;
        }
        IronSourceError ironSourceErrorA2 = a(u.c().a());
        if (ironSourceErrorA2 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA2.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA2);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(bVarA)) {
            return;
        }
        if (!z()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(bVarA)) {
                return;
            }
            this.f9278e0.a(iSDemandOnlyBannerLayout, str);
        }
    }

    private boolean a(h.b bVar) {
        if (u.c().a() != u.d.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.f9272a0) {
            this.f9272a0.put(bVar.e(), bVar);
        }
        return true;
    }

    private IronSourceError a(u.d dVar) {
        if (!this.I) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.F) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (dVar == u.d.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (dVar == u.d.INIT_IN_PROGRESS && u.c().d()) {
            return new IronSourceError(510, "ironSource initialization in progress");
        }
        return null;
    }

    public Me a(Context context, String str) {
        if (!C2394j9.a(context)) {
            return null;
        }
        G3 g3C = C2394j9.c(context);
        String strD = g3C.d();
        String strF = g3C.f();
        String strE = g3C.e();
        if (!strD.equals(str)) {
            return null;
        }
        Me me = new Me(context, strD, strF, strE);
        me.a(Me.a.CACHE);
        return me;
    }

    private Me a(Context context, String str, b bVar) throws Throwable {
        Exception exc;
        Me me = null;
        if (!IronSourceUtils.g(context)) {
            return null;
        }
        try {
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                strB = this.f9275c.M(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = strB;
            C2270ca c2270ca = this.A;
            String strA = C2375i7.a(Oe.a(context, n(), str, str2, p(), this.T, c2270ca != null ? c2270ca.f() : null, B()), C2359h9.a().toString(), bVar);
            if (strA == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.g()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(strA);
                String strOptString = jSONObject.optString(Me.f7195n, null);
                if (TextUtils.isEmpty(strOptString)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return null;
                }
                strA = a(strOptString, Boolean.valueOf(jSONObject.optBoolean("compression", false)));
                if (TextUtils.isEmpty(strA)) {
                    ironLog.warning("encoded response invalid - return null");
                    S();
                    return null;
                }
            }
            Me me2 = new Me(context, n(), str, strA);
            try {
                me2.a(Me.a.SERVER);
                if (me2.p()) {
                    return me2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e) {
                exc = e;
                me = me2;
                C2531r4.d().a(exc);
                IronLog.INTERNAL.warning("exception = " + exc);
                return me;
            }
        } catch (Exception e4) {
            exc = e4;
        }
    }

    private String a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            return L9.d(C2499p5.b().c(), str);
        }
        return L9.b(C2499p5.b().c(), str);
    }

    private void a(Me me, Context context) {
        boolean zL = x() ? me.c().b().b().l() : false;
        boolean zL2 = L() ? me.c().f().m().l() : false;
        boolean zL3 = D() ? me.c().d().i().l() : false;
        boolean zL4 = y() ? me.c().c().g().l() : false;
        boolean zL5 = H() ? me.c().e().g().l() : false;
        C2398jd c2398jdI = me.c().b().i();
        boolean zI = c2398jdI.i();
        if (zL) {
            a((AbstractC2581u3) Mb.U().q(), me.c().b().b(), context, me, true);
        }
        if (zL2) {
            a((AbstractC2581u3) C2256be.i(), me.c().f().m(), context, me, true);
        } else {
            C2256be.i().a(false);
        }
        if (zL3) {
            a((AbstractC2581u3) H9.i(), me.c().d().i(), context, me, true);
        } else if (zL4) {
            a((AbstractC2581u3) H9.i(), me.c().c().g(), context, me, true);
        } else if (zL5) {
            a((AbstractC2581u3) H9.i(), me.c().e().g(), context, me, true);
        } else {
            H9.i().a(false);
        }
        C2381id c2381id = C2381id.O;
        c2381id.a(zI);
        if (zI) {
            c2381id.b(c2398jdI.j(), context);
            c2381id.b(c2398jdI.l(), context);
            c2381id.c(c2398jdI.k(), context);
            c2381id.b(c2398jdI.g());
            c2381id.c(c2398jdI.h());
        }
    }

    private void a(AbstractC2581u3 abstractC2581u3, H1 h12, Context context, Me me, boolean z2) {
        abstractC2581u3.a(z2);
        abstractC2581u3.a(h12.c(), context);
        abstractC2581u3.b(h12.d(), context);
        abstractC2581u3.a(h12.f());
        abstractC2581u3.d(h12.e());
        abstractC2581u3.b(h12.a());
        abstractC2581u3.b(h12.i(), context);
        abstractC2581u3.c(h12.h(), context);
        abstractC2581u3.a(h12.j(), context);
        abstractC2581u3.d(h12.g(), context);
        abstractC2581u3.a(me.c().b().j());
        abstractC2581u3.b(h12.k());
        abstractC2581u3.c(h12.b());
    }

    private void a(String str, U3 u32) {
        if (a(str, 1, 128)) {
            return;
        }
        u32.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, "dynamicUserId is invalid, should be between 1-128 chars in length."));
    }

    private boolean a(String str, int i2, int i8) {
        return str != null && str.length() >= i2 && str.length() <= i8;
    }

    @Override // com.ironsource.U9
    public void a(Context context, boolean z2) {
        this.f9290v = context;
        this.f9291w = Boolean.valueOf(z2);
        A9 a9 = this.P;
        if (a9 != null) {
            a9.a(context, z2);
        }
        if (this.V) {
            Wd wd = this.Q;
            if (wd != null) {
                wd.a(context, z2);
            }
        } else {
            R7 r7 = this.N;
            if (r7 != null) {
                r7.a(context, z2);
            }
        }
        Mb.U().q().a(new C5(D5.SHOULD_TRACK_NETWORK_STATE, IronSourceUtils.b(false)));
    }

    public boolean a(C2371i3 c2371i3) {
        return this.e.c(ContextProvider.getInstance().getApplicationContext(), c2371i3, IronSource.a.BANNER);
    }

    public C2507pd.b a(C2434ld c2434ld) {
        return this.e.a(ContextProvider.getInstance().getApplicationContext(), c2434ld, IronSource.a.REWARDED_VIDEO);
    }

    private void a(D5 d52, JSONObject jSONObject) {
        H9.i().a(new C5(d52, jSONObject));
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e), 3);
            }
        }
    }

    public void a(String str, List<String> list) {
        String strCheckMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String strCheckMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (strCheckMetaDataKeyValidity.length() > 0) {
            IronLog.API.verbose(strCheckMetaDataKeyValidity);
            return;
        }
        if (strCheckMetaDataValueValidity.length() > 0) {
            IronLog.API.verbose(strCheckMetaDataValueValidity);
            return;
        }
        MetaData metaData = MetaDataUtils.formatMetaData(str, list);
        String metaDataKey = metaData.getMetaDataKey();
        List<String> metaDataValue = metaData.getMetaDataValue();
        if (MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
            if (C() && MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
                IronLog.API.error("setMetaData with key = " + metaDataKey + " must to be called before init");
            } else {
                C2469na.b().a(metaDataKey, metaDataValue);
            }
        } else {
            com.ironsource.mediationsdk.c.b().c(metaDataKey, metaDataValue);
        }
        try {
            ConcurrentHashMap<String, List<String>> concurrentHashMapD = com.ironsource.mediationsdk.c.b().d();
            concurrentHashMapD.putAll(C2469na.b().c());
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : concurrentHashMapD.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.h0.a(jSONObject);
            this.g0.a(jSONObject);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("got the following error " + e.getMessage());
        }
        Mb.U().q().a(new C5(C() ? D5.SET_META_DATA_AFTER_INIT : D5.SET_META_DATA, IronSourceUtils.a(str, list, metaDataValue)));
    }

    @Override // com.ironsource.T4
    public String a(Context context) {
        String str;
        Be beA;
        String str2;
        String strC;
        C2258bg c2258bgK;
        U4 u4K = k();
        Be be = null;
        try {
            beA = Ce.f6411a.a();
            try {
                u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_IN_INIT_STATUS, beA);
            } catch (Exception unused) {
                str = null;
                be = beA;
                u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_ENRICH_TOKEN_ERROR, be);
                beA = be;
                str2 = str;
            }
        } catch (Exception unused2) {
            str = null;
        }
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_WITHOUT_CONTEXT, (Be) null);
            return null;
        }
        if (beA == Be.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_NO_INIT_RETURNED_NULL, (Be) null);
            return null;
        }
        u.c().g();
        Me me = this.l;
        boolean zE = (me == null || (c2258bgK = me.c().b().k()) == null) ? true : c2258bgK.e();
        this.g0.b(context);
        JSONObject jSONObjectA = new C2240ag().a(context);
        d.b().a(jSONObjectA, true);
        if (zE) {
            strC = L9.a(jSONObjectA.toString());
        } else {
            strC = L9.c(jSONObjectA.toString());
        }
        str2 = strC;
        if (TextUtils.isEmpty(str2)) {
            u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, beA);
        }
        u4K.a(D5.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_TOKEN_RETURNED, beA);
        return str2;
    }

    @Override // com.ironsource.Z8
    public void a(InterfaceC2233a9 interfaceC2233a9) {
        if (C2234aa.a((Object) interfaceC2233a9, "addImpressionDataListener - listener is null")) {
            C2469na.b().a(interfaceC2233a9);
            R7 r7 = this.N;
            if (r7 != null) {
                r7.a(interfaceC2233a9);
            }
            y yVar = this.O;
            if (yVar != null) {
                yVar.a(interfaceC2233a9);
            }
            IronLog.API.info("add impression data listener to ".concat(interfaceC2233a9.getClass().getSimpleName()));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (C2234aa.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && C2234aa.a((Object) str, "setAdRevenueData - dataSource is null")) {
            this.f0.a(str, jSONObject);
        }
    }
}
