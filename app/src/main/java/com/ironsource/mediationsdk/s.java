package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C2256be;
import com.ironsource.C2270ca;
import com.ironsource.C2292de;
import com.ironsource.C2434ld;
import com.ironsource.C2449ma;
import com.ironsource.C2461n2;
import com.ironsource.C2496p2;
import com.ironsource.C2531r4;
import com.ironsource.C2639xa;
import com.ironsource.C3;
import com.ironsource.C5;
import com.ironsource.CallableC2666z3;
import com.ironsource.D3;
import com.ironsource.D5;
import com.ironsource.Dc;
import com.ironsource.Ed;
import com.ironsource.InterfaceC2233a9;
import com.ironsource.InterfaceC2310ee;
import com.ironsource.InterfaceC2476o;
import com.ironsource.InterfaceC2622wa;
import com.ironsource.Mb;
import com.ironsource.P7;
import com.ironsource.R5;
import com.ironsource.R7;
import com.ironsource.S1;
import com.ironsource.Se;
import com.ironsource.Zd;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class s extends m implements InterfaceC2622wa, InterfaceC2310ee, S1, R7, Dc, InterfaceC2476o {
    private e A;
    private long B;
    private Boolean C;
    private final Object D;
    private R5 E;
    private final long F;
    private final P7.a G;
    private final P7 H;
    private C2639xa e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, C2461n2> f9297f;
    private ConcurrentHashMap<String, h.a> g;
    private C2461n2 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f9298i;
    private com.ironsource.mediationsdk.e j;
    private JSONObject k;
    private C2292de l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9300o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private NetworkStateReceiver f9302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ConcurrentHashMap<String, t> f9304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Se f9305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f9307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f9308x;
    private boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f9309z;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f9310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Zd f9311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f9313d;

        public a(NetworkSettings networkSettings, Zd zd, String str, String str2) {
            this.f9310a = networkSettings;
            this.f9311b = zd;
            this.f9312c = str;
            this.f9313d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.a(this.f9310a, this.f9311b, this.f9312c, this.f9313d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            s.this.j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.d("makeAuction()");
            s.this.f9300o = new Date().getTime();
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            s.this.b(map, arrayList, sb, arrayList2);
            s.this.a(map, arrayList, sb, arrayList2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements C3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f9316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f9317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f9318c;

        public d(Map map, StringBuilder sb, List list) {
            this.f9316a = map;
            this.f9317b = sb;
            this.f9318c = list;
        }

        @Override // com.ironsource.C3.b
        public void a(List<D3> list, long j, List<String> list2) {
            s.this.c(D5.RV_COLLECT_TOKENS_COMPLETED, C2449ma.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            for (D3 d32 : list) {
                t tVar = (t) s.this.f9304t.get(d32.c());
                if (d32.a() != null) {
                    this.f9316a.put(d32.c(), d32.a());
                    StringBuilder sb = this.f9317b;
                    sb.append(d32.d());
                    sb.append(d32.c());
                    sb.append(",");
                    if (tVar != null) {
                        tVar.a(D5.RV_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(d32.e())}});
                    }
                } else if (tVar != null) {
                    tVar.a(D5.RV_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(d32.e())}, new Object[]{"reason", d32.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                t tVar2 = (t) s.this.f9304t.get(it.next());
                if (tVar2 != null) {
                    tVar2.a(D5.RV_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                }
            }
            s.this.a((Map<String, Object>) this.f9316a, (List<String>) this.f9318c, this.f9317b.toString());
        }

        @Override // com.ironsource.C3.b
        public void onFailure(String str) {
            s.this.c(D5.RV_COLLECT_TOKENS_FAILED, C2449ma.a(new Object[][]{new Object[]{"reason", str}}));
            s.this.a((Map<String, Object>) this.f9316a, (List<String>) this.f9318c, this.f9317b.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum e {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public s(List<NetworkSettings> list, Zd zd, String str, String str2, HashSet<InterfaceC2233a9> hashSet, C2270ca c2270ca) {
        super(hashSet, c2270ca);
        this.p = "";
        this.f9303s = false;
        this.f9306v = 1;
        this.D = new Object();
        this.G = Mb.O().x();
        this.H = Mb.U().w();
        long time = new Date().getTime();
        c(D5.RV_MANAGER_INIT_STARTED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(e.RV_STATE_INITIATING);
        this.C = null;
        this.f9308x = zd.g();
        this.y = zd.j();
        this.f9307w = "";
        this.k = null;
        C2496p2 c2496p2K = zd.k();
        this.f9309z = false;
        this.e = new C2639xa(zd.k().f(), zd.k().i());
        this.f9297f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.B = new Date().getTime();
        this.m = c2496p2K.g() > 0;
        this.f9299n = c2496p2K.n();
        if (this.m) {
            this.j = new com.ironsource.mediationsdk.e(IronSource.a.REWARDED_VIDEO, c2496p2K, this);
        }
        this.l = new C2292de(c2496p2K, this);
        ConcurrentHashMap<String, t> concurrentHashMap = new ConcurrentHashMap<>();
        this.f9304t = concurrentHashMap;
        a(list, zd, str, str2);
        this.f9298i = new h(list, c2496p2K.c());
        Se se = new Se();
        this.f9305u = se;
        se.a(new ArrayList(concurrentHashMap.values()));
        this.E = new R5(zd.c(), this);
        this.F = zd.l();
        c(D5.RV_MANAGER_INIT_ENDED, C2449ma.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}}));
        a(c2496p2K.k());
    }

    private void a(List<NetworkSettings> list, Zd zd, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next(), zd, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(zd.f(), zd.o(), arrayList);
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void b(t tVar) {
        a(tVar, "onRewardedVideoAdStarted");
        Ed.a().c();
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void c(t tVar) {
        a(tVar, "onRewardedVideoAdClosed, mediation state: " + this.A.name());
        Ed.a().b(this.e.a(tVar.u()));
        this.f9309z = false;
        boolean z2 = this.A == e.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            for (t tVar2 : this.e.c()) {
                if (tVar2.y()) {
                    sb.append(tVar2.c() + ";");
                }
            }
        }
        D5 d52 = D5.RV_INSTANCE_CLOSED;
        StringBuilder sb2 = new StringBuilder("otherRVAvailable = ");
        sb2.append(sb.length() > 0 ? com.google.android.gms.ads.internal.client.a.i(sb, "true|") : "false");
        tVar.b(d52, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb2.toString()}});
        if (tVar.equals(this.e.f())) {
            this.e.a((t) null);
            if (this.A != e.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void e(t tVar) {
        a(tVar, "onRewardedVideoAdEnded");
        Ed.a().b();
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void f(t tVar) {
        this.e.a(tVar);
        this.f9306v++;
        a(tVar, "onRewardedVideoAdOpened");
        if (this.m) {
            C2461n2 c2461n2 = this.f9297f.get(tVar.c());
            if (c2461n2 != null) {
                C2639xa c2639xa = this.e;
                c2639xa.a(c2639xa.d(), c2461n2.a(this.f9307w), c2461n2.d());
                this.j.a(c2461n2, tVar.g(), this.h, this.f9307w);
                this.g.put(tVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                a(c2461n2, this.f9307w);
            } else {
                String strC = tVar.c();
                c(a1.a.m("onRewardedVideoAdOpened showing instance ", strC, " missing from waterfall"));
                a(D5.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{"reason", "Showing missing " + this.A}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
            }
        }
        Ed.a().c(this.e.a(tVar.u()));
        b(false);
        this.l.c();
    }

    private List<C2461n2> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (t tVar : this.f9304t.values()) {
            if (!tVar.p() && !this.f9305u.b(tVar) && this.e.b(tVar)) {
                copyOnWriteArrayList.add(new C2461n2(tVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void h() {
        a(e.RV_STATE_NOT_LOADED);
        if (!this.f9309z) {
            b(false);
        }
        this.l.a();
    }

    private void i() {
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(D5.TROUBLESHOOTING_RV_LOAD_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
            return;
        }
        a(e.RV_STATE_LOADING_SMASHES);
        int i2 = 0;
        for (int i8 = 0; i8 < this.e.c().size() && i2 < this.f9308x; i8++) {
            t tVar = this.e.c().get(i8);
            if (tVar.h()) {
                if (this.y && tVar.p()) {
                    if (i2 != 0) {
                        String str = "Advanced Loading: Won't start loading bidder " + tVar.c() + " as a non bidder is being loaded";
                        d(str);
                        IronSourceUtils.i(str);
                        return;
                    }
                    String str2 = "Advanced Loading: Starting to load bidder " + tVar.c() + ". No other instances will be loaded at the same time.";
                    d(str2);
                    IronSourceUtils.i(str2);
                    g(tVar);
                    return;
                }
                g(tVar);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.D) {
            try {
                e eVar = this.A;
                e eVar2 = e.RV_STATE_AUCTION_IN_PROGRESS;
                if (eVar != eVar2) {
                    a(eVar2);
                    AsyncTask.execute(new c());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void k() {
        a(g(), "fallback_" + System.currentTimeMillis(), this.k);
    }

    @Override // com.ironsource.R7
    public boolean d() {
        if ((!this.f9303s || IronSourceUtils.g(ContextProvider.getInstance().getApplicationContext())) && this.A == e.RV_STATE_READY_TO_SHOW && !this.f9309z) {
            Iterator<t> it = this.e.c().iterator();
            while (it.hasNext()) {
                if (it.next().A()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void b(t tVar, C2434ld c2434ld) {
        a(tVar, "onRewardedVideoAdClicked");
        Ed.a().a(c2434ld, this.e.a(tVar.u()));
    }

    @Override // com.ironsource.InterfaceC2310ee
    public void b() {
        d("onLoadTriggered: RV load was triggered in " + this.A + " state");
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, Zd zd, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("Start initializing provider " + networkSettings.getProviderInstanceName() + " on thread " + Thread.currentThread().getName());
        AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getRewardedVideoSettings(), false);
        if (abstractAdapterA != null) {
            t tVar = new t(str, str2, networkSettings, this, zd.h(), abstractAdapterA, this.f9306v);
            this.f9304t.put(tVar.c(), tVar);
        }
        com.google.android.gms.ads.internal.client.a.r("Done initializing provider ", networkSettings.getProviderInstanceName(), " on thread ", Thread.currentThread().getName(), ironLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        for (t tVar : this.f9304t.values()) {
            if (!this.f9305u.b(tVar) && this.e.b(tVar)) {
                if (tVar.p()) {
                    list2.add(new CallableC2666z3(tVar.g(), tVar.c(), null, tVar, null, null));
                } else {
                    list.add(tVar.c());
                    sb.append(tVar.g() + tVar.c() + ",");
                }
            }
        }
    }

    private void g(t tVar) {
        String strK = this.f9297f.get(tVar.c()).k();
        JSONObject jSONObjectA = this.f9297f.get(tVar.c()).a();
        tVar.c(strK);
        tVar.a(strK, jSONObjectA);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x005c A[SYNTHETIC] */
    @Override // com.ironsource.InterfaceC2622wa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.ironsource.mediationsdk.t r12) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.s.d(com.ironsource.mediationsdk.t):void");
    }

    private void b(boolean z2) {
        a(z2, (Map<String, Object>) null);
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 0);
    }

    private void b(D5 d52) {
        a(d52, (Map<String, Object>) null, false, false);
    }

    private void b(D5 d52, Map<String, Object> map) {
        a(d52, map, true, true);
    }

    private void c(t tVar, C2434ld c2434ld) {
        d("showVideo()");
        this.f9305u.a(tVar);
        if (this.f9305u.b(tVar)) {
            tVar.B();
            IronSourceUtils.i(tVar.c() + " rewarded video is now session capped");
        }
        P7.a aVar = this.G;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String strC = c2434ld.c();
        IronSource.a aVar2 = IronSource.a.REWARDED_VIDEO;
        aVar.a(applicationContext, strC, aVar2);
        if (this.H.c(ContextProvider.getInstance().getApplicationContext(), c2434ld, aVar2)) {
            a(D5.RV_CAP_PLACEMENT);
        }
        this.E.a();
        tVar.a(c2434ld);
    }

    @Override // com.ironsource.R7
    public void a(Activity activity, C2434ld c2434ld) {
        synchronized (this.D) {
            try {
                if (c2434ld == null) {
                    a("showRewardedVideo error: empty default placement");
                    IronSourceError ironSourceError = new IronSourceError(1021, "showRewardedVideo error: empty default placement");
                    Ed edA = Ed.a();
                    C2639xa c2639xa = this.e;
                    edA.a(ironSourceError, c2639xa.a(c2639xa.d()));
                    a(D5.RV_CALLBACK_SHOW_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}), false, true);
                    return;
                }
                this.f9307w = c2434ld.c();
                b("showRewardedVideo(" + c2434ld + ")");
                t tVar = null;
                b(D5.RV_API_SHOW_CALLED, activity != null ? C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}}) : null);
                if (this.f9309z) {
                    a("showRewardedVideo error: can't show ad while an ad is already showing");
                    IronSourceError ironSourceError2 = new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW, "showRewardedVideo error: can't show ad while an ad is already showing");
                    Ed edA2 = Ed.a();
                    C2639xa c2639xa2 = this.e;
                    edA2.a(ironSourceError2, c2639xa2.a(c2639xa2.d()));
                    b(D5.RV_CALLBACK_SHOW_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW)}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}}));
                    return;
                }
                if (this.A != e.RV_STATE_READY_TO_SHOW) {
                    a("showRewardedVideo error: show called while no ads are available");
                    IronSourceError ironSourceError3 = new IronSourceError(IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE, "showRewardedVideo error: show called while no ads are available");
                    Ed edA3 = Ed.a();
                    C2639xa c2639xa3 = this.e;
                    edA3.a(ironSourceError3, c2639xa3.a(c2639xa3.d()));
                    b(D5.RV_CALLBACK_SHOW_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE)}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}}));
                    return;
                }
                if (this.H.c(ContextProvider.getInstance().getApplicationContext(), c2434ld, IronSource.a.REWARDED_VIDEO)) {
                    String str = "showRewardedVideo error: placement " + this.f9307w + " is capped";
                    a(str);
                    IronSourceError ironSourceError4 = new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, str);
                    Ed edA4 = Ed.a();
                    C2639xa c2639xa4 = this.e;
                    edA4.a(ironSourceError4, c2639xa4.a(c2639xa4.d()));
                    b(D5.RV_CALLBACK_SHOW_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_PLACEMENT_CAPPED)}, new Object[]{"reason", str}}));
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<t> it = this.e.c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    t next = it.next();
                    if (next.A()) {
                        this.f9309z = true;
                        next.b(true);
                        a(e.RV_STATE_NOT_LOADED);
                        tVar = next;
                        break;
                    }
                    if (next.e() != null) {
                        stringBuffer.append(next.c() + ":" + next.e() + ",");
                    }
                    next.b(false);
                }
                if (tVar == null) {
                    d("showRewardedVideo(): No ads to show");
                    Ed edA5 = Ed.a();
                    IronSourceError ironSourceErrorBuildNoAdsToShowError = ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                    C2639xa c2639xa5 = this.e;
                    edA5.a(ironSourceErrorBuildNoAdsToShowError, c2639xa5.a(c2639xa5.d()));
                    HashMap map = new HashMap();
                    map.put(IronSourceConstants.EVENTS_ERROR_CODE, 509);
                    map.put("reason", "showRewardedVideo(): No ads to show");
                    if (stringBuffer.length() != 0) {
                        map.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
                    }
                    b(D5.RV_CALLBACK_SHOW_FAILED, map);
                    this.l.b();
                    return;
                }
                c(tVar, c2434ld);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c(D5 d52) {
        return d52 == D5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS || d52 == D5.RV_AUCTION_SUCCESS || d52 == D5.RV_AUCTION_FAILED || d52 == D5.RV_AD_UNIT_CAPPED;
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(D5 d52, Map<String, Object> map) {
        a(d52, map, false, false);
    }

    private boolean c(boolean z2) {
        Boolean bool = this.C;
        if (bool == null) {
            return false;
        }
        if (z2 && !bool.booleanValue() && d()) {
            return true;
        }
        return !z2 && this.C.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 0);
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void a(t tVar) {
        synchronized (this.D) {
            try {
                a(tVar, "onLoadSuccess mState=" + this.A);
                if (tVar.u() == this.e.d() && this.A != e.RV_STATE_AUCTION_IN_PROGRESS) {
                    this.g.put(tVar.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
                    e eVar = this.A;
                    e eVar2 = e.RV_STATE_LOADING_SMASHES;
                    if (eVar == eVar2) {
                        a(e.RV_STATE_READY_TO_SHOW);
                        a(D5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS, C2449ma.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.f9300o)}}));
                        this.E.a(0L);
                        if (this.m) {
                            C2461n2 c2461n2 = this.f9297f.get(tVar.c());
                            if (c2461n2 != null) {
                                C2639xa c2639xa = this.e;
                                c2639xa.a(c2639xa.d(), c2461n2.a(""), c2461n2.d());
                                this.j.a(c2461n2, tVar.g(), this.h);
                                this.j.a(this.e.c(), this.f9297f, tVar.g(), this.h, c2461n2);
                            } else {
                                String strC = tVar.c();
                                c("onLoadSuccess winner instance " + strC + " missing from waterfall. auctionId: " + tVar.u() + " and the current id is " + this.e.d());
                                D5 d52 = D5.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR;
                                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1010};
                                StringBuilder sb = new StringBuilder("Loaded missing ");
                                sb.append(eVar2);
                                a(d52, C2449ma.a(new Object[][]{objArr, new Object[]{"reason", sb.toString()}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
                            }
                        }
                        b(true);
                    }
                    return;
                }
                d("onLoadSuccess was invoked with auctionId: " + tVar.u() + " and the current id is " + this.e.d());
                tVar.a(D5.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 2}, new Object[]{"reason", "onLoadSuccess wrong auction ID " + this.A}});
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void a(IronSourceError ironSourceError, t tVar) {
        C2461n2 c2461n2;
        if (this.m && (c2461n2 = this.f9297f.get(tVar.c())) != null) {
            C2639xa c2639xa = this.e;
            c2639xa.a(c2639xa.d(), c2461n2.a(this.f9307w), c2461n2.d());
        }
        a(tVar, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.f9309z = false;
        b(D5.RV_CALLBACK_SHOW_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}}));
        Ed.a().a(ironSourceError, this.e.a(tVar.u()));
        this.g.put(tVar.c(), h.a.ISAuctionPerformanceFailedToShow);
        if (this.A != e.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.l.b();
    }

    @Override // com.ironsource.InterfaceC2622wa
    public void a(t tVar, C2434ld c2434ld) {
        a(tVar, "onRewardedVideoAdRewarded");
        Ed.a().b(c2434ld, this.e.a(tVar.u()));
    }

    @Override // com.ironsource.S1
    public void a(List<C2461n2> list, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        d("makeAuction(): success");
        this.h = c2461n2;
        this.f9301q = i2;
        this.k = jSONObject;
        this.p = "";
        if (!TextUtils.isEmpty(str2)) {
            a(D5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"reason", str2}}));
        }
        IronSource.a aVar = IronSource.a.REWARDED_VIDEO;
        a(jSONObject2, aVar);
        if (this.f9230b.a(aVar)) {
            a(D5.RV_AD_UNIT_CAPPED, C2449ma.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
        } else {
            a(list, str, this.k);
            a(D5.RV_AUCTION_SUCCESS, C2449ma.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            i();
        }
    }

    @Override // com.ironsource.S1
    public void a(int i2, String str, int i8, String str2, long j) {
        String str3 = "Auction failed (error " + i2 + " - " + str + ")";
        d(str3);
        IronSourceUtils.i("RV: " + str3);
        this.f9301q = i8;
        this.p = str2;
        this.k = null;
        if (this.f9299n) {
            d("Moving to fallback waterfall");
            k();
        }
        if (TextUtils.isEmpty(str)) {
            a(D5.RV_AUCTION_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(j)}}));
        } else {
            a(D5.RV_AUCTION_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}}));
        }
        i();
    }

    private void a(long j) {
        if (this.f9305u.a()) {
            d("all smashes are capped");
            a(D5.TROUBLESHOOTING_RV_LOAD_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80001}, new Object[]{"reason", "all smashes are capped"}}));
            h();
            return;
        }
        a(IronSource.a.REWARDED_VIDEO);
        if (this.m) {
            if (!this.g.isEmpty()) {
                this.f9298i.a(this.g);
                this.g.clear();
            }
            new Timer().schedule(new b(), j);
            return;
        }
        d("auction fallback flow starting");
        k();
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(D5.TROUBLESHOOTING_RV_LOAD_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
        } else {
            b(D5.RV_BUSINESS_MEDIATION_LOAD);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        C3 c32 = new C3();
        d dVar = new d(map, sb, list);
        b(D5.RV_COLLECT_TOKENS);
        c32.a(list2, dVar, this.F, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            c(D5.RV_AUCTION_FAILED, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}}));
            d("makeAuction() failed - No candidates available for auctioning");
            h();
        } else {
            d(a1.a.l("makeAuction() - request waterfall is: ", str));
            b(D5.RV_BUSINESS_MEDIATION_LOAD);
            b(D5.RV_AUCTION_REQUEST);
            c(D5.RV_AUCTION_REQUEST_WATERFALL, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
            this.j.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.f9298i, this.f9306v, this.f9231c);
        }
    }

    private void a(List<C2461n2> list, String str, JSONObject jSONObject) {
        this.f9297f.clear();
        this.g.clear();
        CopyOnWriteArrayList<t> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (C2461n2 c2461n2 : list) {
            sb.append(a(c2461n2) + ",");
            t tVar = this.f9304t.get(c2461n2.c());
            if (tVar != null) {
                AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(tVar.f8974b.h());
                if (abstractAdapterA != null) {
                    t tVar2 = new t(tVar, this, abstractAdapterA, this.f9306v, str, jSONObject, this.f9301q, this.p);
                    tVar2.a(true);
                    copyOnWriteArrayList.add(tVar2);
                    this.f9297f.put(tVar2.c(), c2461n2);
                    this.g.put(c2461n2.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + c2461n2.c());
            }
        }
        this.e.a(copyOnWriteArrayList, str);
        if (this.e.a()) {
            a(D5.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, C2449ma.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.e.e()}}));
        }
        d("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(D5.RV_AUCTION_RESPONSE_WATERFALL, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    private String a(C2461n2 c2461n2) {
        String string;
        t tVar = this.f9304t.get(c2461n2.c());
        if (tVar != null) {
            string = Integer.toString(tVar.g());
        } else {
            string = TextUtils.isEmpty(c2461n2.k()) ? "1" : "2";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(string);
        sbR.append(c2461n2.c());
        return sbR.toString();
    }

    private void a(e eVar) {
        d("current state=" + this.A + ", new state=" + eVar);
        this.A = eVar;
    }

    private void a(boolean z2, Map<String, Object> map) {
        D5 d52;
        synchronized (this.D) {
            try {
                Boolean bool = this.C;
                if (bool == null || bool.booleanValue() != z2) {
                    this.C = Boolean.valueOf(z2);
                    long time = new Date().getTime() - this.B;
                    this.B = new Date().getTime();
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("duration", Long.valueOf(time));
                    if (z2) {
                        d52 = D5.RV_CALLBACK_AVAILABILITY_TRUE;
                    } else {
                        d52 = D5.RV_CALLBACK_AVAILABILITY_FALSE;
                    }
                    a(d52, map);
                    Ed edA = Ed.a();
                    C2639xa c2639xa = this.e;
                    edA.a(z2, c2639xa.a(c2639xa.d()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(t tVar, String str) {
        String str2 = tVar.c() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(D5 d52, Map<String, Object> map) {
        a(d52, map, false, true);
    }

    private void a(D5 d52) {
        a(d52, (Map<String, Object>) null, true, true);
    }

    private void a(D5 d52, Map<String, Object> map, boolean z2, boolean z7) {
        HashMap mapU = androidx.camera.core.processing.util.a.u(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        mapU.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z7 && !TextUtils.isEmpty(this.e.d())) {
            mapU.put("auctionId", this.e.d());
        }
        JSONObject jSONObject = this.k;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapU.put("genericParams", this.k);
        }
        if (z2 && !TextUtils.isEmpty(this.f9307w)) {
            mapU.put("placement", this.f9307w);
        }
        if (c(d52)) {
            C2256be.i().a(mapU, this.f9301q, this.p);
        }
        mapU.put("sessionDepth", Integer.valueOf(this.f9306v));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    mapU.putAll(map);
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e4), 3);
            }
        }
        C2256be.i().a(new C5(d52, new JSONObject(mapU)));
    }

    @Override // com.ironsource.InterfaceC2476o
    public void a() {
        a(e.RV_STATE_NOT_LOADED);
        a(false, C2449ma.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{"reason", "loaded ads are expired"}}));
        a(0L);
    }

    @Override // com.ironsource.Dc
    public void a(boolean z2) {
        if (this.f9303s) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z2, 0);
            if (c(z2)) {
                b(z2);
            }
        }
    }

    @Override // com.ironsource.R7
    public void a(Context context, boolean z2) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager Should Track Network State: " + z2, 0);
        try {
            this.f9303s = z2;
            if (z2) {
                if (this.f9302r == null) {
                    this.f9302r = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.f9302r, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.f9302r != null) {
                context.getApplicationContext().unregisterReceiver(this.f9302r);
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e4.getMessage());
        }
    }
}
