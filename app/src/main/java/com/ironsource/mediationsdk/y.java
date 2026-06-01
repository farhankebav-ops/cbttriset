package com.ironsource.mediationsdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.C2270ca;
import com.ironsource.C2371i3;
import com.ironsource.C2426l5;
import com.ironsource.C2461n2;
import com.ironsource.C2531r4;
import com.ironsource.C2580u2;
import com.ironsource.C2640xb;
import com.ironsource.C3;
import com.ironsource.C5;
import com.ironsource.CallableC2666z3;
import com.ironsource.D3;
import com.ironsource.D5;
import com.ironsource.E3;
import com.ironsource.H9;
import com.ironsource.InterfaceC2233a9;
import com.ironsource.InterfaceC2625wd;
import com.ironsource.K7;
import com.ironsource.L7;
import com.ironsource.Mb;
import com.ironsource.P7;
import com.ironsource.P8;
import com.ironsource.S1;
import com.ironsource.Wf;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
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
public class y extends m implements InterfaceC2625wd, S1 {
    private ConcurrentHashMap<String, h.a> A;
    private long B;
    private final Object C;
    private C2426l5 D;
    private boolean E;
    private final long F;
    private final Runnable G;
    private final P8 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final P8.a f9403f;
    private final P7 g;
    private final P7.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k f9404i;
    private i j;
    private C2640xb k;
    private q l;
    private C2371i3 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private z f9406o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ConcurrentHashMap<String, z> f9407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CopyOnWriteArrayList<z> f9408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private JSONObject f9410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f9411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f9413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private C2461n2 f9414x;
    private com.ironsource.mediationsdk.h y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ConcurrentHashMap<String, C2461n2> f9415z;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                y yVar = y.this;
                if (yVar.l == null) {
                    IronLog.INTERNAL.verbose("mIronSourceBanner is null");
                    y.this.a(D5.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL)}});
                } else {
                    if (yVar.o()) {
                        y.this.v();
                        return;
                    }
                    IronLog.INTERNAL.verbose("banner is not visible, reload skipped");
                    y.this.a(D5.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE)}});
                    y.this.k.a(TimeUnit.SECONDS.toMillis(r3.f9404i.f()));
                }
            } catch (Throwable th) {
                C2531r4.d().a(th);
                y.this.a(D5.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, new Object[][]{new Object[]{"reason", th.getMessage()}});
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.w();
            if (y.this.y()) {
                return;
            }
            y.this.a(D5.BN_AUCTION_REQUEST);
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            y.this.b(map, arrayList, sb, arrayList2);
            y.this.a(map, arrayList, sb, arrayList2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements C3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f9423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f9424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f9425c;

        public e(Map map, StringBuilder sb, List list) {
            this.f9423a = map;
            this.f9424b = sb;
            this.f9425c = list;
        }

        @Override // com.ironsource.C3.b
        public void a(List<D3> list, long j, List<String> list2) {
            y.this.a(D5.BN_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            for (D3 d32 : list) {
                if (d32.a() != null) {
                    this.f9423a.put(d32.c(), d32.a());
                    StringBuilder sb = this.f9424b;
                    sb.append(d32.d());
                    sb.append(d32.c());
                    sb.append(",");
                    ((z) y.this.f9407q.get(d32.c())).a(D5.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(d32.e())}});
                } else {
                    ((z) y.this.f9407q.get(d32.c())).a(D5.BN_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(d32.e())}, new Object[]{"reason", d32.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                ((z) y.this.f9407q.get(it.next())).a(D5.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            }
            y.this.a((Map<String, Object>) this.f9423a, (List<String>) this.f9425c, this.f9424b);
        }

        @Override // com.ironsource.C3.b
        public void onFailure(String str) {
            y.this.a(D5.BN_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{"duration", str}});
            y.this.a((Map<String, Object>) this.f9423a, (List<String>) this.f9425c, this.f9424b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f9427a;

        public f(NetworkSettings networkSettings) {
            this.f9427a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.a(this.f9427a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements E3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f9429a;

        public g(z zVar) {
            this.f9429a = zVar;
        }

        @Override // com.ironsource.E3
        public void a() {
            this.f9429a.D();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h extends TimerTask {
        public h() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            y.this.u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum i {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    public y(List<NetworkSettings> list, k kVar, HashSet<InterfaceC2233a9> hashSet, C2270ca c2270ca) {
        this(Mb.U(), Mb.O(), list, kVar, hashSet, c2270ca);
    }

    private boolean a(i iVar, i iVar2) {
        boolean z2;
        synchronized (this.C) {
            try {
                if (this.j == iVar) {
                    IronLog.INTERNAL.verbose("set state from '" + this.j + "' to '" + iVar2 + "'");
                    this.j = iVar2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.j);
        if (!a(i.STARTED_LOADING, this.f9404i.j() ? z2 ? i.AUCTION : i.FIRST_AUCTION : z2 ? i.RELOADING : i.LOADING)) {
            ironLog.error("wrong state - " + this.j);
            return;
        }
        this.D = new C2426l5();
        this.f9409s = "";
        this.f9410t = null;
        this.f9405n = 0;
        this.p = this.e.a(IronSource.a.BANNER);
        if (z2) {
            a(D5.BN_RELOAD);
        } else {
            a(D5.BN_LOAD);
        }
        if (this.f9404i.j()) {
            u();
        } else {
            x();
            t();
        }
    }

    private void f(z zVar) {
        String strK;
        q qVar = this.l;
        if (qVar == null || qVar.b()) {
            return;
        }
        q qVarC = null;
        if (zVar.p()) {
            strK = this.f9415z.get(zVar.c()).k();
            zVar.c(strK);
        } else {
            strK = null;
        }
        JSONObject jSONObjectA = this.f9415z.get(zVar.c()).a();
        try {
            qVarC = this.l.c();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.verbose("Failed to make copy of banner layout: " + e4.getMessage());
        }
        zVar.a(qVarC, this.m, strK, jSONObjectA);
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void c(z zVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(zVar.f());
        if (g()) {
            C2580u2.a().f(this.f9232d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(D5.BN_CALLBACK_PRESENT_SCREEN, objArr, zVar.n());
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void e(z zVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(zVar.f());
        if (g()) {
            C2580u2.a().e(this.f9232d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(D5.BN_CALLBACK_DISMISS_SCREEN, objArr, zVar.n());
    }

    private boolean g() {
        q qVar = this.l;
        return (qVar == null || qVar.b()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f9406o != null) {
            IronLog.INTERNAL.verbose("mActiveSmash = " + this.f9406o.f());
            this.f9406o.t();
            this.f9406o = null;
        }
    }

    private List<C2461n2> i() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (z zVar : this.f9407q.values()) {
            if (!zVar.p() && !this.g.c(ContextProvider.getInstance().getApplicationContext(), this.m, IronSource.a.BANNER)) {
                copyOnWriteArrayList.add(new C2461n2(zVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private ISBannerSize j() {
        q qVar = this.l;
        if (qVar == null || qVar.getSize() == null) {
            return null;
        }
        return this.l.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? ISBannerSize.f8978f : ISBannerSize.BANNER : this.l.getSize();
    }

    private ISBannerSize k() {
        q qVar = this.l;
        if (qVar != null) {
            return qVar.getSize();
        }
        return null;
    }

    private String l() {
        C2371i3 c2371i3 = this.m;
        return c2371i3 != null ? c2371i3.c() : "";
    }

    private void m() {
        String str = this.f9408r.isEmpty() ? "Empty waterfall" : "Mediation No fill";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = ".concat(str));
        g((z) null);
        i iVar = i.LOADING;
        i iVar2 = i.READY_TO_LOAD;
        if (a(iVar, iVar2)) {
            a(D5.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 606}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.D))}});
            n.a().b(IronSource.a.BANNER, new IronSourceError(606, str));
        } else if (a(i.RELOADING, i.LOADED)) {
            a(D5.BN_CALLBACK_RELOAD_ERROR, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.D))}});
            n.a().b(IronSource.a.BANNER, new IronSourceError(606, str));
            this.k.a(TimeUnit.SECONDS.toMillis(this.f9404i.f()));
        } else {
            a(iVar2);
            ironLog.error("wrong state = " + this.j);
        }
    }

    private void n() {
        String strL = l();
        P7.a aVar = this.h;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        IronSource.a aVar2 = IronSource.a.BANNER;
        aVar.a(applicationContext, strL, aVar2);
        if (this.g.c(ContextProvider.getInstance().getApplicationContext(), this.m, aVar2)) {
            a(D5.BN_PLACEMENT_CAPPED);
        }
    }

    private boolean p() {
        i iVar = this.j;
        return iVar == i.RELOADING || iVar == i.AUCTION;
    }

    private boolean q() {
        boolean z2;
        synchronized (this.C) {
            z2 = this.j == i.LOADED;
        }
        return z2;
    }

    private boolean r() {
        boolean z2;
        synchronized (this.C) {
            try {
                i iVar = this.j;
                z2 = iVar == i.FIRST_AUCTION || iVar == i.AUCTION;
            } finally {
            }
        }
        return z2;
    }

    private boolean s() {
        boolean z2;
        synchronized (this.C) {
            try {
                i iVar = this.j;
                z2 = iVar == i.LOADING || iVar == i.RELOADING;
            } finally {
            }
        }
        return z2;
    }

    private void t() {
        try {
            for (int i2 = this.f9405n; i2 < this.f9408r.size(); i2++) {
                z zVar = this.f9408r.get(i2);
                if (zVar.h()) {
                    IronLog.INTERNAL.verbose("loading smash - " + zVar.f());
                    this.f9405n = i2 + 1;
                    f(zVar);
                    return;
                }
            }
            m();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            a(D5.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "loadNextSmash"}, new Object[]{"reason", Log.getStackTraceString(e4)}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        IronLog.INTERNAL.verbose();
        AsyncTask.execute(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        if (a(i.LOADED, i.STARTED_LOADING)) {
            b(true);
            return;
        }
        ironLog.error("wrong state = " + this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.A.isEmpty()) {
            return;
        }
        this.y.a(this.A);
        this.A.clear();
    }

    private void x() {
        List<C2461n2> listI = i();
        this.f9409s = e();
        a(listI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        long jA = l.a(this.B, this.f9404i.h());
        if (jA <= 0) {
            return false;
        }
        IronLog.INTERNAL.verbose("waiting before auction - timeToWaitBeforeAuction = " + jA);
        new Timer().schedule(new h(), jA);
        return true;
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void d(z zVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(zVar.f());
        if (g()) {
            C2580u2.a().b(this.f9232d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(D5.BN_CALLBACK_CLICK, objArr, zVar.n());
    }

    public boolean o() {
        if (!this.l.isShown()) {
            IronLog.INTERNAL.verbose("banner or one of its parents are INVISIBLE or GONE");
            return false;
        }
        if (!this.l.hasWindowFocus()) {
            IronLog.INTERNAL.verbose("banner has no window focus");
            return false;
        }
        boolean globalVisibleRect = this.l.getGlobalVisibleRect(new Rect());
        IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
        return globalVisibleRect;
    }

    public void g(z zVar) {
        for (z zVar2 : this.f9408r) {
            if (!zVar2.equals(zVar)) {
                zVar2.q();
            }
        }
    }

    public y(L7 l72, K7 k72, List<NetworkSettings> list, k kVar, HashSet<InterfaceC2233a9> hashSet, C2270ca c2270ca) {
        super(hashSet, c2270ca);
        this.j = i.NONE;
        this.f9411u = "";
        this.C = new Object();
        this.E = false;
        c cVar = new c();
        this.G = cVar;
        P8 p8S = l72.s();
        this.e = p8S;
        this.f9403f = k72.h();
        this.g = l72.w();
        this.h = k72.x();
        long time = new Date().getTime();
        a(D5.BN_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_BN_MANAGER_NAME}});
        IronLog.INTERNAL.verbose("isAuctionEnabled = " + kVar.j());
        this.f9404i = kVar;
        this.f9407q = new ConcurrentHashMap<>();
        this.f9408r = new CopyOnWriteArrayList<>();
        this.f9415z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        IronSource.a aVar = IronSource.a.BANNER;
        this.p = p8S.a(aVar);
        n.a().a(aVar, this.f9404i.d());
        if (this.f9404i.j()) {
            this.f9413w = new com.ironsource.mediationsdk.e(aVar, this.f9404i.b(), this);
        }
        this.y = new com.ironsource.mediationsdk.h(list, this.f9404i.b().c());
        a(list, kVar);
        this.B = new Date().getTime();
        a(i.READY_TO_LOAD);
        this.F = kVar.g();
        this.k = new C2640xb(cVar, com.ironsource.lifecycle.b.d(), new Wf());
        a(D5.BN_MANAGER_INIT_ENDED, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        IronLog.INTERNAL.verbose("from '" + this.j + "' to '" + iVar + "'");
        synchronized (this.C) {
            this.j = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f9419a;

        public b(q qVar) {
            this.f9419a = qVar;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog.INTERNAL.verbose("destroying banner");
            y.this.k.b();
            y yVar = y.this;
            z zVar = yVar.f9406o;
            y.this.a(D5.BN_DESTROY, (Object[][]) null, zVar != null ? zVar.n() : yVar.p);
            y.this.h();
            this.f9419a.a();
            y yVar2 = y.this;
            yVar2.l = null;
            yVar2.m = null;
            yVar2.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("destroy banner failed - errorMessage = " + str);
        }
    }

    public void a(q qVar, C2371i3 c2371i3) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        IronSource.a aVar = IronSource.a.BANNER;
        a(aVar);
        f();
        if (a(i.READY_TO_LOAD, i.STARTED_LOADING)) {
            if (!n.a().b(aVar)) {
                l.a(qVar, c2371i3, new a(c2371i3, qVar));
                return;
            } else {
                ironLog.verbose("can't load banner - already has pending invocation");
                return;
            }
        }
        IronLog.API.error("can't load banner - loadBanner already called and still in progress");
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2371i3 f9416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f9417b;

        public a(C2371i3 c2371i3, q qVar) {
            this.f9416a = c2371i3;
            this.f9417b = qVar;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("placement = " + this.f9416a.c());
            l.b(this.f9417b);
            y yVar = y.this;
            yVar.l = this.f9417b;
            yVar.m = this.f9416a;
            P7 p7 = yVar.g;
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            C2371i3 c2371i3 = this.f9416a;
            IronSource.a aVar = IronSource.a.BANNER;
            if (!p7.c(applicationContext, c2371i3, aVar)) {
                y.this.b(false);
                return;
            }
            ironLog.verbose("placement is capped");
            n.a().b(aVar, new IronSourceError(604, "placement " + this.f9416a.c() + " is capped"));
            y.this.a(D5.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 604}});
            y.this.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("can't load banner - errorMessage = " + str);
        }
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void b(z zVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(zVar.f());
        if (g()) {
            C2580u2.a().c(this.f9232d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(D5.BN_CALLBACK_LEAVE_APP, objArr, zVar.n());
    }

    public void a(q qVar) {
        IronLog.INTERNAL.verbose();
        l.a(qVar, new b(qVar));
    }

    @Override // com.ironsource.S1
    public void a(List<C2461n2> list, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        i iVar;
        IronLog ironLog = IronLog.INTERNAL;
        com.google.android.gms.ads.internal.client.a.p("auctionId = ", str, ironLog);
        if (r()) {
            this.f9411u = "";
            this.f9409s = str;
            this.f9412v = i2;
            this.f9414x = c2461n2;
            this.f9410t = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                a(D5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"reason", str2}});
            }
            IronSource.a aVar = IronSource.a.BANNER;
            a(jSONObject2, aVar);
            if (this.f9230b.a(aVar)) {
                a(D5.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}});
                i iVar2 = this.j;
                a(i.READY_TO_LOAD);
                if (iVar2 == i.FIRST_AUCTION) {
                    n.a().b(aVar, new IronSourceError(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped"));
                    return;
                }
                return;
            }
            a(D5.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            if (this.j == i.FIRST_AUCTION) {
                iVar = i.LOADING;
            } else {
                iVar = i.RELOADING;
            }
            a(iVar);
            a(D5.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, a(list)}});
            t();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        if (this.g.c(ContextProvider.getInstance().getApplicationContext(), this.m, IronSource.a.BANNER)) {
            return;
        }
        for (z zVar : this.f9407q.values()) {
            AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(zVar.f8976d, IronSource.a.BANNER, null, this.l);
            if (zVar.p()) {
                list2.add(new CallableC2666z3(zVar.g(), zVar.c(), adDataCreateAdDataForNetworkAdapter, zVar, null, null));
            } else if (!zVar.p()) {
                list.add(zVar.c());
                sb.append(zVar.g() + zVar.c() + ",");
            }
        }
    }

    private void b(z zVar, View view, FrameLayout.LayoutParams layoutParams) {
        if (this.l != null) {
            zVar.E();
            l.a(this.l, view, layoutParams, new g(zVar));
        }
    }

    private String b(C2461n2 c2461n2) {
        z zVar = this.f9407q.get(c2461n2.c());
        String str = "1";
        if (zVar == null ? !TextUtils.isEmpty(c2461n2.k()) : zVar.p()) {
            str = "2";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(str);
        sbR.append(c2461n2.c());
        return sbR.toString();
    }

    private boolean b(D5 d52) {
        return d52 == D5.BN_CALLBACK_RELOAD_ERROR || d52 == D5.BN_CALLBACK_LOAD_SUCCESS || d52 == D5.BN_CALLBACK_LOAD_ERROR || d52 == D5.BN_CALLBACK_RELOAD_SUCCESS || d52 == D5.BN_CALLBACK_SHOW || d52 == D5.BN_CALLBACK_CLICK || d52 == D5.BN_CALLBACK_LEAVE_APP || d52 == D5.BN_AUCTION_FAILED || d52 == D5.BN_AUCTION_SUCCESS || d52 == D5.BN_AD_UNIT_CAPPED;
    }

    @Override // com.ironsource.S1
    public void a(int i2, String str, int i8, String str2, long j) {
        i iVar;
        String str3 = "Auction failed (error " + i2 + " - " + str + ")";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str3);
        IronSourceUtils.i("BN: " + str3);
        if (r()) {
            this.f9411u = str2;
            this.f9412v = i8;
            this.f9410t = null;
            if (this.f9404i.b().n()) {
                ironLog.verbose("Moving to fallback waterfall");
                x();
            }
            a(D5.BN_AUCTION_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}});
            if (this.j == i.FIRST_AUCTION) {
                iVar = i.LOADING;
            } else {
                iVar = i.RELOADING;
            }
            a(iVar);
            t();
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.j);
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void a(z zVar, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + zVar.f());
        if (zVar.x() != this.f9409s) {
            ironLog.error("invoked with auctionId: " + zVar.x() + " and the current id is " + this.f9409s);
            zVar.a(D5.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 2}, new Object[]{"reason", "Wrong auction id " + zVar.x() + " State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, zVar.c()}});
            return;
        }
        if (s()) {
            z zVar2 = this.f9406o;
            if (zVar2 != null) {
                zVar2.q();
            }
            g(zVar);
            this.f9406o = zVar;
            b(zVar, view, layoutParams);
            this.A.put(zVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (this.f9404i.j()) {
                C2461n2 c2461n2 = this.f9415z.get(zVar.c());
                if (c2461n2 != null) {
                    a(c2461n2.a(l()), c2461n2.d());
                    this.f9413w.a(c2461n2, zVar.g(), this.f9414x);
                    this.f9413w.a(this.f9408r, this.f9415z, zVar.g(), this.f9414x, c2461n2);
                    if (!this.f9404i.b().r()) {
                        a(zVar, c2461n2);
                    }
                } else {
                    String strC = zVar.c();
                    StringBuilder sbY = a1.a.y("onLoadSuccess winner instance ", strC, " missing from waterfall. auctionId = ");
                    sbY.append(this.f9409s);
                    ironLog.error(sbY.toString());
                    a(D5.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}});
                }
            }
            if (this.j == i.LOADING) {
                if (g()) {
                    C2580u2.a().d(this.f9232d);
                    objArr = new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.D))}};
                } else {
                    objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.D))}};
                }
                a(D5.BN_CALLBACK_LOAD_SUCCESS, objArr);
            } else {
                if (g()) {
                    C2580u2.a().d(this.f9232d);
                }
                IronSourceUtils.i("bannerReloadSucceeded");
                a(D5.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.D))}});
            }
            n();
            this.f9403f.b(IronSource.a.BANNER);
            a(i.LOADED);
            this.k.a(TimeUnit.SECONDS.toMillis(this.f9404i.f()));
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.j);
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void a(IronSourceError ironSourceError, z zVar, boolean z2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (zVar.x() != this.f9409s) {
            ironLog.error("invoked with auctionId: " + zVar.x() + " and the current id is " + this.f9409s);
            zVar.a(D5.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 3}, new Object[]{"reason", "Wrong auction " + zVar.x() + " State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, zVar.c()}});
            return;
        }
        if (s()) {
            this.A.put(zVar.c(), h.a.ISAuctionPerformanceFailedToLoad);
            t();
        } else {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
        }
    }

    @Override // com.ironsource.InterfaceC2625wd
    public void a(z zVar) {
        C2461n2 c2461n2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(zVar.f());
        if (q()) {
            if (this.f9404i.j() && this.f9404i.b().r() && (c2461n2 = this.f9415z.get(zVar.c())) != null) {
                a(zVar, c2461n2);
            }
            a(D5.BN_CALLBACK_SHOW);
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.j);
        String strC = zVar.c();
        a(D5.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}});
    }

    private void a(z zVar, C2461n2 c2461n2) {
        this.f9413w.a(c2461n2, zVar.g(), this.f9414x, l());
        a(this.f9415z.get(zVar.c()), l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb);
            return;
        }
        C3 c32 = new C3();
        e eVar = new e(map, sb, list);
        a(D5.BN_COLLECT_TOKENS);
        c32.a(list2, eVar, this.F, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + ((Object) sb));
        if (map.size() == 0 && list.size() == 0) {
            a(D5.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}});
            if (a(i.AUCTION, i.LOADED)) {
                this.k.a(TimeUnit.SECONDS.toMillis(this.f9404i.f()));
                return;
            }
            n.a().b(IronSource.a.BANNER, new IronSourceError(1005, "No candidates available for auctioning"));
            a(D5.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}});
            a(i.READY_TO_LOAD);
            return;
        }
        a(D5.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
        com.ironsource.mediationsdk.e eVar = this.f9413w;
        if (eVar != null) {
            eVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.y, this.p, this.f9231c, j());
        } else {
            ironLog.error("mAuctionHandler is null");
        }
    }

    private void a(List<NetworkSettings> list, k kVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new f(it.next()));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(kVar.c().l(), kVar.c().n(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings) {
        NetworkSettings networkSettings2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("Start initializing provider " + networkSettings.getProviderInstanceName() + " on thread " + Thread.currentThread().getName());
        AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getBannerSettings(), false);
        if (abstractAdapterA != null) {
            networkSettings2 = networkSettings;
            z zVar = new z(this.f9404i, this, networkSettings2, abstractAdapterA, this.p, p());
            this.f9407q.put(zVar.c(), zVar);
        } else {
            networkSettings2 = networkSettings;
            ironLog.verbose(networkSettings2.getProviderInstanceName() + " can't load adapter");
        }
        com.google.android.gms.ads.internal.client.a.r("Done initializing provider ", networkSettings2.getProviderInstanceName(), " on thread ", Thread.currentThread().getName(), ironLog);
    }

    private String a(List<C2461n2> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.f9408r.clear();
        this.f9415z.clear();
        this.A.clear();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2461n2 c2461n2 = list.get(i2);
            a(c2461n2);
            sb.append(b(c2461n2));
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    private void a(C2461n2 c2461n2) {
        z zVar = this.f9407q.get(c2461n2.c());
        if (zVar != null) {
            AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(zVar.f8974b.h());
            if (abstractAdapterA != null) {
                z zVar2 = new z(this.f9404i, this, zVar.f8974b.h(), abstractAdapterA, this.p, this.f9409s, this.f9410t, this.f9412v, this.f9411u, p());
                zVar2.a(true);
                this.f9408r.add(zVar2);
                this.f9415z.put(zVar2.c(), c2461n2);
                this.A.put(c2461n2.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return;
            }
            return;
        }
        IronLog.INTERNAL.error("could not find matching smash for auction response item - item = " + c2461n2.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(D5 d52) {
        a(d52, (Object[][]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(D5 d52, Object[][] objArr) {
        a(d52, objArr, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(D5 d52, Object[][] objArr, int i2) {
        JSONObject jSONObjectA = IronSourceUtils.a(false, true, 1);
        try {
            ISBannerSize iSBannerSizeK = k();
            if (iSBannerSizeK != null) {
                a(jSONObjectA, iSBannerSizeK);
            }
            if (this.m != null) {
                jSONObjectA.put("placement", l());
            }
            jSONObjectA.put("sessionDepth", i2);
            if (!TextUtils.isEmpty(this.f9409s)) {
                jSONObjectA.put("auctionId", this.f9409s);
            }
            JSONObject jSONObject = this.f9410t;
            if (jSONObject != null && jSONObject.length() > 0) {
                jSONObjectA.put("genericParams", this.f9410t);
            }
            if (b(d52)) {
                jSONObjectA.put(IronSourceConstants.AUCTION_TRIALS, this.f9412v);
                if (!TextUtils.isEmpty(this.f9411u)) {
                    jSONObjectA.put(IronSourceConstants.AUCTION_FALLBACK, this.f9411u);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(Log.getStackTraceString(e4));
        }
        H9.i().a(new C5(d52, jSONObjectA));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void a(JSONObject jSONObject, ISBannerSize iSBannerSize) {
        try {
            String description = iSBannerSize.getDescription();
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals(l.f9206c)) {
                        jSONObject.put(l.h, 3);
                    }
                    break;
                case 72205083:
                    if (description.equals(l.f9205b)) {
                        jSONObject.put(l.h, 2);
                    }
                    break;
                case 79011241:
                    if (description.equals(l.e)) {
                        jSONObject.put(l.h, 5);
                    }
                    break;
                case 1951953708:
                    if (description.equals(l.f9204a)) {
                        jSONObject.put(l.h, 1);
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        jSONObject.put(l.h, 6);
                        jSONObject.put("custom_banner_size", iSBannerSize.getWidth() + "x" + iSBannerSize.getHeight());
                    }
                    break;
            }
            if (iSBannerSize.isAdaptive()) {
                String str = l.f9212q;
                if (jSONObject.has(IronSourceConstants.EVENTS_EXT1)) {
                    str = jSONObject.optString(IronSourceConstants.EVENTS_EXT1) + " , Adaptive=true";
                }
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(Log.getStackTraceString(e4));
        }
    }
}
