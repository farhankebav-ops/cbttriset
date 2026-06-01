package com.ironsource;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.AbstractC2547s3;
import com.ironsource.C3;
import com.ironsource.D0;
import com.ironsource.N0;
import com.ironsource.P7;
import com.ironsource.P8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.p3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2497p3<Smash extends AbstractC2547s3<?>, Listener extends AdapterAdListener> implements Q0, S1, C0, Gb, Dc, InterfaceC2476o, Eg, A3, InterfaceC2591ud {
    private AdInfo A;
    private C2469na B;
    final P8 C;
    final P8.a D;
    protected final P7 E;
    private final P7.a F;
    private boolean G;
    private Hf H;
    private AtomicBoolean I;
    private T9 J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Dg<Smash> f9589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ConcurrentHashMap<String, h.a> f9590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.ironsource.mediationsdk.e f9591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.ironsource.mediationsdk.h f9592d;
    protected int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f9593f;
    protected JSONObject g;
    protected C2461n2 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected C2434ld f9594i;
    protected boolean j;
    private NetworkStateReceiver k;
    protected Se l;
    protected C2426l5 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected C2426l5 f9595n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected U f9596o;
    protected f p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected P0 f9597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected R5 f9598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected D0 f9599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected K0 f9600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected r f9601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected C2270ca f9602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected UUID f9603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected final Object f9604x;
    private long y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Boolean f9605z;

    /* JADX INFO: renamed from: com.ironsource.p3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {
        public a() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2497p3.this.B();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f9607a;

        public b(NetworkSettings networkSettings) {
            this.f9607a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2497p3.this.c(this.f9607a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p3$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbstractC2497p3.this.D();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p3$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2497p3.this.g = new JSONObject();
            AbstractC2497p3.this.f9599s.h.a((Double) null);
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            AbstractC2497p3.this.b(map, arrayList, sb, arrayList2);
            AbstractC2497p3.this.a(map, arrayList, sb, arrayList2);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p3$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements C3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f9611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f9612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f9613c;

        public e(Map map, StringBuilder sb, List list) {
            this.f9611a = map;
            this.f9612b = sb;
            this.f9613c = list;
        }

        @Override // com.ironsource.C3.b
        public void a(List<D3> list, long j, List<String> list2) {
            AbstractC2497p3.this.f9599s.g.a(j);
            for (D3 d32 : list) {
                NetworkSettings networkSettingsA = AbstractC2497p3.this.f9596o.a(d32.c());
                Map<String, Object> mapB = AbstractC2497p3.this.b(networkSettingsA, com.ironsource.mediationsdk.c.b().b(networkSettingsA, AbstractC2497p3.this.f9596o.b(), AbstractC2497p3.this.k()));
                if (d32.a() != null) {
                    this.f9611a.put(d32.c(), d32.a());
                    StringBuilder sb = this.f9612b;
                    sb.append(d32.d());
                    sb.append(d32.c());
                    sb.append(",");
                    AbstractC2497p3.this.f9599s.g.a(mapB, d32.e());
                } else {
                    AbstractC2497p3.this.f9599s.g.a(mapB, d32.e(), d32.b());
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                NetworkSettings networkSettingsA2 = AbstractC2497p3.this.f9596o.a(it.next());
                AbstractC2497p3.this.f9599s.g.b(AbstractC2497p3.this.b(networkSettingsA2, com.ironsource.mediationsdk.c.b().b(networkSettingsA2, AbstractC2497p3.this.f9596o.b(), AbstractC2497p3.this.k())), j);
            }
            AbstractC2497p3.this.a((Map<String, Object>) this.f9611a, (List<String>) this.f9613c, this.f9612b.toString());
        }

        @Override // com.ironsource.C3.b
        public void onFailure(String str) {
            AbstractC2497p3.this.f9599s.g.a(str);
            AbstractC2497p3.this.a((Map<String, Object>) this.f9611a, (List<String>) this.f9613c, this.f9612b.toString());
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p3$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum f {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    public AbstractC2497p3(U u2, C2469na c2469na, C2270ca c2270ca) {
        this(Mb.U(), Mb.O(), u2, c2469na, c2270ca);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        f fVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        synchronized (this.f9604x) {
            try {
                if (this.f9596o.h().e() && this.l.a()) {
                    ironLog.verbose(b("all smashes are capped"));
                    a(C2663z0.a(this.f9596o.b()), "all smashes are capped", false);
                    return;
                }
                if (!t() && this.p == f.SHOWING) {
                    IronLog.API.error(b("load cannot be invoked while showing an ad"));
                    a(new IronSourceError(C2663z0.d(this.f9596o.b()), "load cannot be invoked while showing an ad"));
                    return;
                }
                if (this.f9596o.h().a() != N0.a.AUTOMATIC_LOAD_WHILE_SHOW && this.f9596o.h().a() != N0.a.MANUAL_WITH_LOAD_ON_SHOW && (((fVar = this.p) != f.READY_TO_LOAD && fVar != f.READY_TO_SHOW) || com.ironsource.mediationsdk.n.a().b(this.f9596o.b()))) {
                    IronLog.API.error(b("load is already in progress"));
                    return;
                }
                this.g = new JSONObject();
                F();
                if (v()) {
                    this.f9599s.f6419f.a();
                } else {
                    this.f9599s.f6419f.a(q());
                }
                this.f9595n = new C2426l5();
                if (this.f9596o.q()) {
                    if (!this.f9590b.isEmpty()) {
                        this.f9592d.a(this.f9590b);
                        this.f9590b.clear();
                    }
                    K();
                } else {
                    a(f.LOADING);
                }
                if (this.f9596o.q()) {
                    return;
                }
                ironLog.verbose(b("auction disabled"));
                L();
                C();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void C() {
        Jg<Smash> jgE = E();
        if (jgE.c()) {
            a(509, "Mediation No fill", false);
        }
        Iterator<Smash> it = jgE.a().iterator();
        while (it.hasNext()) {
            it.next().E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        IronLog.INTERNAL.verbose(i());
        AsyncTask.execute(new d());
    }

    private Jg<Smash> E() {
        IronLog.INTERNAL.verbose();
        return new Ig(this.f9596o).d(this.f9589a.b());
    }

    private void F() {
        this.f9601u.a(this.f9596o.b(), false);
    }

    private void K() {
        IronLog.INTERNAL.verbose(i());
        synchronized (this.f9604x) {
            try {
                f fVar = this.p;
                f fVar2 = f.AUCTION;
                if (fVar == fVar2) {
                    return;
                }
                a(fVar2);
                this.I.set(false);
                long jK = this.f9596o.d().k() - C2426l5.a(this.m);
                if (jK > 0) {
                    new Timer().schedule(new c(), jK);
                } else {
                    D();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void L() {
        IronLog.INTERNAL.verbose(i());
        a(j(), m());
    }

    private List<C2461n2> j() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings networkSettings : this.f9596o.j()) {
            if (!networkSettings.isBidder(this.f9596o.b()) && d(networkSettings)) {
                Re re = new Re(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f9596o.b()));
                if (!this.l.b(re)) {
                    copyOnWriteArrayList.add(new C2461n2(re.c()));
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private int p() {
        return 1;
    }

    private void r() {
        IronLog.INTERNAL.verbose(i());
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.f9596o.j()) {
            if (c(networkSettings, com.ironsource.mediationsdk.c.b().b(networkSettings, this.f9596o.b(), k()))) {
                arrayList.add(new b(networkSettings));
            }
        }
        IronSourceThreadManager.INSTANCE.executeTasks(this.f9596o.k(), this.f9596o.p(), arrayList);
    }

    private void s() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.f9596o.j()) {
            arrayList.add(new Re(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f9596o.b())));
        }
        Se se = new Se();
        this.l = se;
        se.a(arrayList);
    }

    public void A() {
        if (e()) {
            a(new a());
        } else {
            B();
        }
    }

    public void G() {
        com.ironsource.mediationsdk.n.a().a(this.f9596o.b(), this.f9596o.f());
    }

    public boolean H() {
        return true;
    }

    public boolean I() {
        return true;
    }

    public void J() {
        Iterator<NetworkSettings> it = this.f9596o.j().iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.c.b().b(it.next(), this.f9596o.b(), k());
        }
    }

    public abstract Smash a(NetworkSettings networkSettings, BaseAdAdapter<?, Listener> baseAdAdapter, int i2, String str, C2461n2 c2461n2);

    public abstract JSONObject b(NetworkSettings networkSettings);

    public abstract K0 g();

    public P0 h() {
        return new P0(this.f9596o.h(), this);
    }

    public String i() {
        return b((String) null);
    }

    public UUID k() {
        return this.f9603w;
    }

    public abstract String l();

    public String m() {
        return "fallback_" + System.currentTimeMillis();
    }

    public String n() {
        C2434ld c2434ld = this.f9594i;
        return c2434ld == null ? "" : c2434ld.c();
    }

    public abstract String o();

    public boolean q() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return false;
    }

    public abstract boolean v();

    public boolean w() {
        boolean z2;
        synchronized (this.f9604x) {
            try {
                f fVar = this.p;
                z2 = fVar == f.LOADING || fVar == f.READY_TO_SHOW;
            } finally {
            }
        }
        return z2;
    }

    public boolean x() {
        boolean z2;
        synchronized (this.f9604x) {
            z2 = this.p == f.READY_TO_SHOW;
        }
        return z2;
    }

    public boolean y() {
        boolean z2;
        synchronized (this.f9604x) {
            z2 = this.p == f.AUCTION;
        }
        return z2;
    }

    public boolean z() {
        boolean z2;
        synchronized (this.f9604x) {
            z2 = this.p == f.LOADING;
        }
        return z2;
    }

    private boolean c(boolean z2) {
        Boolean bool = this.f9605z;
        if (bool == null) {
            return false;
        }
        if (z2 && !bool.booleanValue() && u()) {
            return true;
        }
        return !z2 && this.f9605z.booleanValue();
    }

    private boolean d(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f9596o.b(), k());
        if (adapterBaseInterfaceB instanceof AdapterSettingsInterface) {
            return this.f9589a.a(this.f9596o.h().a(), networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), a(networkSettings, adapterBaseInterfaceB), adapterBaseInterfaceB, this.f9596o.b());
        }
        return false;
    }

    public void a(Context context, boolean z2) {
        IronLog.INTERNAL.verbose(b("track = " + z2));
        try {
            this.j = z2;
            if (z2) {
                if (this.k == null) {
                    this.k = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.k != null) {
                context.getApplicationContext().unregisterReceiver(this.k);
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e4.getMessage());
        }
    }

    public void b(boolean z2) {
        a(false, z2, (AbstractC2547s3<?>) null);
    }

    @Override // com.ironsource.Q0
    public void e(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose(b(abstractC2547s3.k()));
        this.f9599s.f6420i.a(n());
        this.f9600t.a(this.f9594i, abstractC2547s3.f());
    }

    public void g(AbstractC2547s3<?> abstractC2547s3) {
        this.f9600t.d(abstractC2547s3.f());
    }

    public void h(AbstractC2547s3<?> abstractC2547s3) {
        if (this.f9596o.h().f()) {
            a(abstractC2547s3, abstractC2547s3.f());
        } else {
            a(true, false, abstractC2547s3);
        }
    }

    public void i(AbstractC2547s3<?> abstractC2547s3) {
        if (this.f9596o.q() && this.I.compareAndSet(false, true)) {
            C2461n2 c2461n2I = abstractC2547s3.i();
            this.f9591c.a(c2461n2I, abstractC2547s3.l(), this.h);
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, C2461n2> concurrentHashMap = new ConcurrentHashMap<>();
            for (Smash smash : this.f9589a.b()) {
                arrayList.add(smash.c());
                concurrentHashMap.put(smash.c(), smash.i());
            }
            this.f9591c.a(arrayList, concurrentHashMap, abstractC2547s3.l(), this.h, c2461n2I);
        }
    }

    public void b() {
        IronLog.INTERNAL.verbose(i());
        A();
    }

    public AbstractC2497p3(L7 l72, K7 k72, U u2, C2469na c2469na, C2270ca c2270ca) {
        this.f9593f = "";
        this.j = false;
        this.f9604x = new Object();
        this.y = 0L;
        this.I = new AtomicBoolean(false);
        this.f9603w = UUID.randomUUID();
        this.C = l72.s();
        this.D = k72.h();
        this.E = l72.w();
        this.F = k72.x();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + u2.b() + ", loading mode = " + u2.h().a());
        StringBuilder sb = new StringBuilder();
        sb.append(u2.b());
        sb.append(" initiated object per waterfall mode");
        IronSourceUtils.i(sb.toString());
        C2426l5 c2426l5 = new C2426l5();
        this.J = a(u2);
        this.f9602v = c2270ca;
        this.f9596o = u2;
        this.f9599s = new D0(u2.b(), D0.b.MEDIATION, this);
        this.f9600t = g();
        this.f9597q = h();
        a(f.NONE);
        this.B = c2469na;
        this.f9589a = new Dg<>(this.f9596o.d().f(), this.f9596o.d().i(), this);
        this.f9599s.e.a(o(), this.f9596o.h().a().toString());
        this.f9590b = new ConcurrentHashMap<>();
        this.f9594i = null;
        G();
        this.g = new JSONObject();
        if (this.f9596o.q()) {
            this.f9591c = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(this.f9596o.d(), IronSourceUtils.d()));
        }
        this.f9592d = new com.ironsource.mediationsdk.h(this.f9596o.j(), this.f9596o.d().c());
        s();
        r();
        this.m = new C2426l5();
        a(f.READY_TO_LOAD);
        this.f9598r = new R5(u2.a(), this);
        this.f9601u = new r();
        this.f9599s.e.a(C2426l5.a(c2426l5));
        if (this.f9596o.h().e()) {
            ironLog.verbose("first automatic load");
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        for (NetworkSettings networkSettings : this.f9596o.j()) {
            Hf hf = this.H;
            if (hf == null || hf.a(networkSettings, this.f9596o.b())) {
                if (!this.l.b(new Re(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f9596o.b()))) && d(networkSettings)) {
                    AdData adDataA = a(networkSettings, (String) null);
                    if (networkSettings.isBidder(this.f9596o.b())) {
                        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f9596o.b(), k());
                        if (adapterBaseInterfaceB instanceof B3) {
                            list2.add(new CallableC2666z3(networkSettings.getInstanceType(this.f9596o.b()), networkSettings.getProviderInstanceName(), adDataA, (B3) adapterBaseInterfaceB, this, networkSettings));
                        } else {
                            this.f9599s.j.g(adapterBaseInterfaceB == null ? "prepareAuctionCandidates - could not load network adapter " + networkSettings.getProviderName() : "network adapter " + networkSettings.getProviderName() + " does not implementing BiddingDataInterface");
                        }
                    } else {
                        list.add(networkSettings.getProviderInstanceName());
                        sb.append(networkSettings.getInstanceType(this.f9596o.b()));
                        sb.append(networkSettings.getProviderInstanceName());
                        sb.append(",");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(b("Start initializing provider " + networkSettings.getProviderInstanceName() + " on thread " + Thread.currentThread().getName()));
        AdData adDataA = a(networkSettings, this.f9596o.o());
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f9596o.b(), k());
        if (adapterBaseInterfaceB != null) {
            try {
                adapterBaseInterfaceB.init(adDataA, ContextProvider.getInstance().getApplicationContext(), null);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                this.f9599s.j.g("initProvider - exception while calling networkAdapter.init with " + networkSettings.getProviderName() + " - " + e4);
            }
        }
        IronLog.INTERNAL.verbose(b("Done initializing provider " + networkSettings.getProviderInstanceName() + " on thread " + Thread.currentThread().getName()));
    }

    @Override // com.ironsource.InterfaceC2591ud
    public boolean e() {
        T9 t9 = this.J;
        if (t9 == null || t9 == Thread.currentThread()) {
            return false;
        }
        return this.f9596o.l();
    }

    public void a(f fVar) {
        synchronized (this.f9604x) {
            IronLog.INTERNAL.verbose("set current state to = " + fVar);
            this.p = fVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009c A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:11:0x0090, B:13:0x0096, B:19:0x00a9, B:16:0x009c, B:18:0x00a2), top: B:37:0x0090 }] */
    @Override // com.ironsource.Q0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.ironsource.AbstractC2547s3<?> r5) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.AbstractC2497p3.d(com.ironsource.s3):void");
    }

    public boolean a(f fVar, f fVar2) {
        boolean z2;
        synchronized (this.f9604x) {
            try {
                if (this.p == fVar) {
                    IronLog.INTERNAL.verbose("expected state = " + fVar + ", state to set = " + fVar2);
                    this.p = fVar2;
                    z2 = true;
                } else {
                    IronLog.INTERNAL.verbose("wrong state, current state = " + this.p + ", expected state = " + fVar);
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    private T9 a(U u2) {
        if (u2.l()) {
            return IronSourceThreadManager.INSTANCE.getSharedManagersThread();
        }
        return null;
    }

    private boolean c(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (this.f9589a.a(adapterBaseInterface, this.f9596o.b(), networkSettings.getProviderInstanceName())) {
            return false;
        }
        return networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.f9596o.b());
    }

    public void a(K0 k0) {
        this.f9600t = k0;
    }

    public BaseAdAdapter<?, Listener> a(NetworkSettings networkSettings, IronSource.a aVar) {
        BaseAdAdapter<?, Listener> baseAdAdapter = (BaseAdAdapter<?, Listener>) com.ironsource.mediationsdk.c.b().a(networkSettings, aVar, k());
        if (baseAdAdapter != null) {
            return baseAdAdapter;
        }
        return null;
    }

    public void a(boolean z2, boolean z7, AbstractC2547s3<?> abstractC2547s3) {
        synchronized (this.f9604x) {
            try {
                Boolean bool = this.f9605z;
                if (bool == null || bool.booleanValue() != z2) {
                    this.f9605z = Boolean.valueOf(z2);
                    long time = 0;
                    if (this.y != 0) {
                        time = new Date().getTime() - this.y;
                    }
                    this.y = new Date().getTime();
                    this.f9599s.f6419f.a(z2, time, z7);
                    AdInfo adInfoF = abstractC2547s3 != null ? abstractC2547s3.f() : this.A;
                    this.A = adInfoF;
                    K0 k0 = this.f9600t;
                    if (!z2) {
                        adInfoF = null;
                    }
                    k0.a(z2, adInfoF);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c(A0 a02) {
        return new ArrayList(Arrays.asList(A0.LOAD_AD_SUCCESS, A0.LOAD_AD_FAILED, A0.LOAD_AD_FAILED_WITH_REASON, A0.AUCTION_SUCCESS, A0.AUCTION_FAILED, A0.AUCTION_FAILED_NO_CANDIDATES, A0.AD_FORMAT_CAPPED, A0.AD_OPENED, A0.SHOW_AD, A0.SHOW_AD_FAILED, A0.AD_CLICKED, A0.RELOAD_AD_FAILED_WITH_REASON, A0.RELOAD_AD_SUCCESS, A0.AD_LEFT_APPLICATION)).contains(a02);
    }

    private boolean b(A0 a02) {
        return !new ArrayList(Arrays.asList(A0.INIT_STARTED, A0.LOAD_AD, A0.AUCTION_REQUEST, A0.AUCTION_REQUEST_WATERFALL, A0.AUCTION_FAILED_NO_CANDIDATES, A0.COLLECT_TOKEN, A0.COLLECT_TOKENS_COMPLETED, A0.COLLECT_TOKENS_FAILED, A0.INSTANCE_COLLECT_TOKEN, A0.INSTANCE_COLLECT_TOKEN_SUCCESS, A0.INSTANCE_COLLECT_TOKEN_FAILED, A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT)).contains(a02);
    }

    public void b(C2461n2 c2461n2, String str) {
        if (c2461n2 != null) {
            Y8 y8A = c2461n2.a(str);
            if (y8A != null) {
                for (InterfaceC2233a9 interfaceC2233a9 : new HashSet(this.B.a())) {
                    IronLog.CALLBACK.info(b("onImpressionSuccess " + interfaceC2233a9.getClass().getSimpleName() + ": " + y8A));
                    interfaceC2233a9.a(y8A);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.error(b("reportImpressionDataToPublisher - no auctionResponseItem or listener"));
        D0 d0 = this.f9599s;
        if (d0 != null) {
            d0.j.g("reportImpressionDataToPublisher - no auctionResponseItem or listener");
        }
    }

    @Override // com.ironsource.InterfaceC2476o
    public void a() {
        if (this.f9596o.h().e()) {
            a(f.READY_TO_LOAD);
            b(true);
            A();
        }
    }

    @Override // com.ironsource.Dc
    public void a(boolean z2) {
        if (!this.j || this.f9596o.h().f()) {
            return;
        }
        IronLog.INTERNAL.verbose("network availability changed to - " + z2);
        if (c(z2)) {
            a(z2, false, (AbstractC2547s3<?>) null);
        }
    }

    public LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return LoadWhileShowSupportState.NONE;
    }

    private String a(List<C2461n2> list, String str) {
        IronLog.INTERNAL.verbose(b("waterfall.size() = " + list.size()));
        this.f9590b.clear();
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2461n2 c2461n2 = list.get(i2);
            AbstractC2547s3 abstractC2547s3A = a(c2461n2, str);
            if (abstractC2547s3A != null) {
                copyOnWriteArrayList.add(abstractC2547s3A);
                sb.append(a(c2461n2, abstractC2547s3A.l()));
            }
            if (i2 != list.size() - 1) {
                sb.append(",");
            }
        }
        this.f9589a.a(this.f9596o.h().a(), (CopyOnWriteArrayList<Smash>) copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(b("updateWaterfall() - next waterfall is " + ((Object) sb)));
        return sb.toString();
    }

    private void b(JSONObject jSONObject) {
        int i2;
        try {
            if (jSONObject == null) {
                this.f9596o.b(false);
                IronLog.INTERNAL.verbose(b("loading configuration from auction response is null, using the following: " + this.f9596o.r()));
                return;
            }
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.f9048x) && (i2 = jSONObject.getInt(com.ironsource.mediationsdk.d.f9048x)) > 0) {
                    this.f9596o.a(i2);
                }
                if (jSONObject.has(com.ironsource.mediationsdk.d.y)) {
                    this.f9596o.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.y));
                }
                this.f9596o.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.f9049z, false));
                IronLog.INTERNAL.verbose(b(this.f9596o.r()));
            } catch (JSONException e4) {
                C2531r4.d().a(e4);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.f9596o.b() + " Error: " + e4.getMessage());
                ironLog.verbose(b(this.f9596o.r()));
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.verbose(b(this.f9596o.r()));
            throw th;
        }
    }

    @Override // com.ironsource.Eg
    public void a(int i2) {
        this.f9599s.j.v("waterfalls hold too many with size = " + i2);
    }

    private Smash a(C2461n2 c2461n2, String str) {
        NetworkSettings networkSettingsA = this.f9596o.a(c2461n2.c());
        if (networkSettingsA != null) {
            com.ironsource.mediationsdk.c.b().b(networkSettingsA, this.f9596o.b(), k());
            BaseAdAdapter<?, Listener> baseAdAdapterA = a(networkSettingsA, this.f9596o.b());
            if (baseAdAdapterA != null) {
                Smash smash = (Smash) a(networkSettingsA, baseAdAdapterA, this.C.a(this.f9596o.b()), str, c2461n2);
                this.f9590b.put(c2461n2.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return smash;
            }
            IronLog.INTERNAL.error(b("addSmashToWaterfall - could not load ad adapter for " + networkSettingsA.getProviderInstanceName()));
            return null;
        }
        String str2 = "could not find matching provider settings for auction response item - item = " + c2461n2.c() + " state = " + this.p;
        IronLog.INTERNAL.error(b(str2));
        this.f9599s.j.i(str2);
        return null;
    }

    public String b(String str) {
        String str2 = this.f9596o.b().name() + " state:" + this.p;
        return TextUtils.isEmpty(str) ? str2 : a1.a.D(str2, " - ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        HashMap map = new HashMap();
        try {
            map.put(IronSourceConstants.EVENTS_PROVIDER, networkSettings.getProviderDefaultInstance());
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface.getAdapterVersion());
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface.getNetworkSDKVersion());
            map.put("spId", networkSettings.getSubProviderId());
            map.put("instanceType", Integer.valueOf(networkSettings.getInstanceType(this.f9596o.b())));
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(p()));
            return map;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + networkSettings.getProviderDefaultInstance(), e4);
            return map;
        }
    }

    public void a(int i2, String str, boolean z2) {
        int i8;
        String str2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(f.READY_TO_LOAD);
        ironLog.verbose(b("errorCode = " + i2 + ", errorReason = " + str));
        if (this.f9596o.h().f()) {
            if (z2) {
                i8 = i2;
                str2 = str;
            } else {
                i8 = i2;
                str2 = str;
                this.f9599s.f6419f.a(C2426l5.a(this.f9595n), i8, str2, q());
            }
            a(new IronSourceError(i8, str2));
        } else {
            if (!z2) {
                this.f9599s.j.b(i2, str);
            }
            b(false);
        }
        this.f9597q.e();
    }

    public void a(AbstractC2547s3<?> abstractC2547s3, AdInfo adInfo) {
        this.f9600t.c(adInfo);
    }

    public void a(IronSourceError ironSourceError) {
        com.ironsource.mediationsdk.n.a().b(this.f9596o.b(), ironSourceError);
    }

    public AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.f9596o.b(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC2666z3> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        C3 c32 = new C3();
        e eVar = new e(map, sb, list);
        this.f9599s.g.a();
        c32.a(list2, eVar, this.f9596o.e(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("auction waterfallString = " + str));
        boolean z2 = false;
        if (map.size() == 0 && list.size() == 0) {
            ironLog.verbose(b("auction failed - no candidates"));
            this.f9599s.h.a(1005, "No candidates available for auctioning");
            a(C2663z0.e(this.f9596o.b()), "no available ad to load", false);
            return;
        }
        this.f9599s.h.b(str);
        if (this.f9591c != null) {
            int iA = this.C.a(this.f9596o.b());
            com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f9596o.b());
            iVar.b(IronSourceUtils.g());
            iVar.a(map);
            iVar.a(list);
            iVar.a(this.f9592d);
            iVar.a(iA);
            iVar.a(this.f9602v);
            iVar.d(this.G);
            Hf hf = this.H;
            if (hf != null && hf.b()) {
                z2 = true;
            }
            iVar.e(z2);
            a(ContextProvider.getInstance().getApplicationContext(), iVar, this);
            return;
        }
        ironLog.error(b("mAuctionHandler is null"));
    }

    public void a(Context context, com.ironsource.mediationsdk.i iVar, S1 s12) {
        com.ironsource.mediationsdk.e eVar = this.f9591c;
        if (eVar != null) {
            eVar.a(context, iVar, s12);
        } else {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        }
    }

    @Override // com.ironsource.S1
    public void a(List<C2461n2> list, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (y()) {
            this.f9593f = "";
            this.e = i2;
            this.h = c2461n2;
            this.g = jSONObject;
            if (!TextUtils.isEmpty(str2)) {
                this.f9599s.j.a(i8, str2);
            }
            a(jSONObject2);
            if (this.f9601u.a(this.f9596o.b())) {
                this.f9599s.h.a(str);
                a(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped", true);
                return;
            }
            String strA = a(list, str);
            this.f9599s.h.a(j, this.f9596o.r() + ";wtf=" + list.size());
            this.f9599s.h.c(strA);
            a(f.LOADING);
            C();
            return;
        }
        StringBuilder sbY = a1.a.y("unexpected auction success for auctionId - ", str, " state = ");
        sbY.append(this.p);
        ironLog.error(b(sbY.toString()));
        this.f9599s.j.k("unexpected auction success, state = " + this.p);
    }

    @Override // com.ironsource.S1
    public void a(int i2, String str, int i8, String str2, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (y()) {
            String str3 = "Auction failed (error " + i2 + " - " + str + ")";
            ironLog.verbose(b(str3));
            IronSourceUtils.i(l() + ": " + str3);
            this.e = i8;
            this.f9593f = str2;
            this.g = new JSONObject();
            if (this.f9596o.d().n()) {
                ironLog.verbose(b("Moving to fallback waterfall"));
                L();
            }
            this.f9599s.h.a(j, i2, str);
            a(f.LOADING);
            C();
            return;
        }
        String str4 = "unexpected auction fail - error = " + i2 + ", " + str + " state = " + this.p;
        ironLog.error(b(str4));
        this.f9599s.j.j(str4);
    }

    @Override // com.ironsource.Q0
    public void a(IronSourceError ironSourceError, AbstractC2547s3<?> abstractC2547s3) {
        Jg<Smash> jgE;
        AbstractC2547s3<?> abstractC2547s3C;
        synchronized (this.f9604x) {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(b(abstractC2547s3.k() + " - error = " + ironSourceError));
                if (abstractC2547s3.h().equals(this.f9589a.c()) && this.p != f.AUCTION) {
                    this.f9590b.put(abstractC2547s3.c(), h.a.ISAuctionPerformanceFailedToLoad);
                    if (z() || x()) {
                        jgE = E();
                        if (jgE.c()) {
                            a(509, "Mediation No fill", false);
                            return;
                        }
                    } else {
                        jgE = null;
                    }
                    if (jgE == null) {
                        return;
                    }
                    if (this.f9596o.m()) {
                        synchronized (this.f9604x) {
                            try {
                                if (jgE.b() && w() && (abstractC2547s3C = new Ig(this.f9596o).c(this.f9589a.b())) != null) {
                                    i(abstractC2547s3C);
                                }
                            } finally {
                            }
                        }
                    }
                    Iterator<Smash> it = jgE.a().iterator();
                    while (it.hasNext()) {
                        it.next().E();
                    }
                    return;
                }
                ironLog.error(b("onAdLoadFailed was invoked from " + abstractC2547s3.c() + " with state =" + this.p + " auctionId: " + abstractC2547s3.h() + " and the current id is " + this.f9589a.c()));
                C2294dg c2294dg = this.f9599s.j;
                StringBuilder sb = new StringBuilder("onAdLoadFailed was invoked with state =");
                sb.append(this.p);
                c2294dg.o(sb.toString());
            } finally {
            }
        }
    }

    @Override // com.ironsource.Q0
    public void a(AbstractC2547s3<?> abstractC2547s3) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(abstractC2547s3.k()));
        this.f9599s.f6420i.g(n());
        this.f9589a.a(abstractC2547s3);
        this.f9589a.b(abstractC2547s3);
        this.l.a(abstractC2547s3);
        if (this.l.b(abstractC2547s3)) {
            ironLog.verbose(b(abstractC2547s3.c() + " was session capped"));
            abstractC2547s3.N();
            IronSourceUtils.i(abstractC2547s3.c() + " was session capped");
        }
        this.F.a(ContextProvider.getInstance().getApplicationContext(), n(), this.f9596o.b());
        if (this.E.c(ContextProvider.getInstance().getApplicationContext(), this.f9594i, this.f9596o.b())) {
            ironLog.verbose(b("placement " + n() + " is capped"));
            this.f9599s.f6420i.b(n(), null);
        }
        this.D.b(this.f9596o.b());
        if (this.f9596o.q()) {
            C2461n2 c2461n2I = abstractC2547s3.i();
            this.f9591c.a(c2461n2I, abstractC2547s3.l(), this.h, n());
            this.f9590b.put(abstractC2547s3.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (H()) {
                b(c2461n2I, n());
            }
        }
        g(abstractC2547s3);
        if (this.f9596o.h().e()) {
            b(false);
        }
        this.f9597q.h();
    }

    public Map<String, Object> a(A0 a02) {
        HashMap mapU = androidx.camera.core.processing.util.a.u(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        mapU.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        JSONObject jSONObject = this.g;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapU.put("genericParams", this.g);
        }
        mapU.put("sessionDepth", Integer.valueOf(this.C.a(this.f9596o.b())));
        if (c(a02)) {
            mapU.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.e));
            if (!TextUtils.isEmpty(this.f9593f)) {
                mapU.put(IronSourceConstants.AUCTION_FALLBACK, this.f9593f);
            }
        }
        if (b(a02) && !TextUtils.isEmpty(this.f9589a.c())) {
            mapU.put("auctionId", this.f9589a.c());
        }
        return mapU;
    }

    public void a(C2270ca c2270ca) {
        this.f9602v = c2270ca;
    }

    private void a(JSONObject jSONObject) {
        this.f9601u.a(this.f9596o.b(), jSONObject != null ? jSONObject.optBoolean(com.ironsource.mediationsdk.d.f9037f, false) : false);
        b(jSONObject);
    }

    public String a(C2461n2 c2461n2, int i2) {
        return i2 + c2461n2.c();
    }

    public void a(Hf hf) {
        this.H = hf;
        if (hf != null) {
            this.G = true;
        } else {
            this.G = false;
        }
        this.f9605z = null;
    }

    @Override // com.ironsource.A3
    public void a(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f9596o.b(), k());
        if (adapterBaseInterfaceB != null) {
            this.f9599s.g.a(b(networkSettings, adapterBaseInterfaceB));
        }
    }

    @Override // com.ironsource.A3
    public void a(String str) {
        this.f9599s.j.g(str);
    }

    @Override // com.ironsource.InterfaceC2591ud
    public void a(Runnable runnable) {
        T9 t9 = this.J;
        if (t9 != null) {
            t9.a(runnable);
        }
    }
}
