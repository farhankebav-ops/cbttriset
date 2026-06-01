package com.ironsource;

import android.text.TextUtils;
import com.ironsource.C2542rf;
import com.ironsource.D0;
import com.ironsource.O8;
import com.ironsource.Q0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.s3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2547s3<Listener extends Q0> implements NetworkInitializationListener, C2542rf.a, C0, AdapterAdListener, O8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected C2421l0 f9791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Listener f9792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected BaseAdAdapter<?, AdapterAdListener> f9793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected D0 f9794d;
    protected h e;
    protected C2434ld g;
    protected C2243b1 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected JSONObject f9796i;
    protected String j;
    protected AdData k;
    protected Long l;
    protected C2426l5 m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final C2461n2 f9798o;
    private final InterfaceC2591ud p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f9795f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C2542rf f9797n = new C2542rf(TimeUnit.SECONDS.toMillis(s()));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final Object f9799q = new Object();

    /* JADX INFO: renamed from: com.ironsource.s3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends AbstractRunnableC2382ie {
        public a() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.L();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends AbstractRunnableC2382ie {
        public b() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.K();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9803c;

        public c(int i2, String str) {
            this.f9802b = i2;
            this.f9803c = str;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.a(this.f9802b, this.f9803c);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d extends AbstractRunnableC2382ie {
        public d() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.I();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdapterErrorType f9806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f9808d;

        public e(AdapterErrorType adapterErrorType, int i2, String str) {
            this.f9806b = adapterErrorType;
            this.f9807c = i2;
            this.f9808d = str;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.a(this.f9806b, this.f9807c, this.f9808d);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f extends AbstractRunnableC2382ie {
        public f() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.J();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$g */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g extends AbstractRunnableC2382ie {
        public g() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            AbstractC2547s3.this.H();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.s3$h */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum h {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC2547s3(InterfaceC2591ud interfaceC2591ud, C2421l0 c2421l0, BaseAdAdapter<?, ?> baseAdAdapter, C2243b1 c2243b1, C2461n2 c2461n2, Listener listener) {
        this.f9791a = c2421l0;
        this.f9792b = listener;
        this.f9794d = new D0(c2421l0.a(), D0.b.PROVIDER, this);
        this.h = c2243b1;
        this.f9796i = c2243b1.c();
        this.f9793c = baseAdAdapter;
        this.f9798o = c2461n2;
        this.p = interfaceC2591ud;
        a(h.NONE);
    }

    private boolean D() {
        return this.e == h.INIT_IN_PROGRESS;
    }

    private void F() {
        IronLog.INTERNAL.verbose(d());
        a(h.LOADING);
        a(false);
        try {
            this.f9797n.a((C2542rf.a) this);
            G();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g(str);
            }
            onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.a(j());
        }
        this.f9792b.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean zO;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        C2542rf c2542rf = this.f9797n;
        if (c2542rf != null) {
            c2542rf.e();
        }
        synchronized (this.f9799q) {
            try {
                h hVar = this.e;
                zO = false;
                if (hVar == h.LOADING) {
                    long jA = C2426l5.a(this.m);
                    ironLog.verbose(a("Load duration = " + jA));
                    if (this.f9794d != null) {
                        if (v()) {
                            this.f9794d.f6419f.a(jA);
                        } else {
                            this.f9794d.f6419f.a(jA, false);
                        }
                    }
                    a(h.LOADED);
                    zO = O();
                } else if (hVar != h.FAILED) {
                    ironLog.error(a("unexpected load success for " + k() + ", state - " + this.e));
                    h hVar2 = this.e;
                    StringBuilder sb = new StringBuilder("unexpected load success, state - ");
                    sb.append(hVar2);
                    String string = sb.toString();
                    if (this.f9794d != null) {
                        if (v()) {
                            this.f9794d.j.s(string);
                        } else {
                            this.f9794d.j.p(string);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zO) {
            this.f9792b.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog.INTERNAL.verbose(d());
        a(h.SHOWING);
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.g(j());
        }
        this.f9792b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (D()) {
            C2542rf c2542rf = this.f9797n;
            if (c2542rf != null) {
                c2542rf.e();
            }
            a(h.READY_TO_LOAD);
            F();
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a("unexpected init success for " + k() + ", state - " + this.e));
        if (this.f9794d != null) {
            this.f9794d.j.n("unexpected init success, state - " + this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        long jA = C2426l5.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("Load duration = ", jA, ", state = ");
        sbT.append(this.e);
        sbT.append(", isBidder = ");
        sbT.append(w());
        ironLog.verbose(a(sbT.toString()));
        synchronized (this.f9799q) {
            try {
                if (z()) {
                    a(h.FAILED);
                    D0 d0 = this.f9794d;
                    if (d0 != null) {
                        d0.f6419f.a(jA, 1025, false);
                        this.f9794d.f6419f.a(jA, 1025, "time out", false);
                    }
                    this.f9792b.a(ErrorBuilder.buildLoadFailedError("time out"), this);
                    return;
                }
                ironLog.error(a("unexpected timeout for " + k() + ", state - " + this.e + ", error - 1025"));
                if (this.f9794d != null) {
                    this.f9794d.j.u("unexpected timeout, state - " + this.e + ", error - 1025");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int o() {
        return 1;
    }

    private int s() {
        C2461n2 c2461n2 = this.f9798o;
        if (c2461n2 == null) {
            return this.f9791a.f();
        }
        Integer numF = c2461n2.f();
        int iF = (numF == null || numF.intValue() <= 0) ? this.f9791a.f() : numF.intValue();
        IronLog.INTERNAL.verbose(a("Load timeout for " + this.f9798o.c() + " - " + iF + " seconds"));
        return iF;
    }

    public AtomicBoolean A() {
        return this.f9795f;
    }

    public boolean B() {
        return y();
    }

    public boolean C() {
        return this.e == h.SHOWING;
    }

    public void E() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        C2461n2 c2461n2I = i();
        String strK = c2461n2I.k();
        Map<String, Object> mapA = C2395ja.a(c2461n2I.a());
        mapA.put("adUnit", this.f9791a.a());
        b(strK);
        try {
            boolean z2 = false;
            if (v()) {
                this.f9794d.f6419f.a();
            } else {
                this.f9794d.f6419f.a(false);
            }
            this.l = null;
            this.m = new C2426l5();
            this.k = a(strK, mapA);
            synchronized (this.f9799q) {
                if (this.e != h.NONE) {
                    z2 = true;
                } else {
                    a(h.INIT_IN_PROGRESS);
                }
            }
            if (z2) {
                String str = "loadAd - incorrect state while loading, state = " + this.e;
                ironLog.error(a(str));
                this.f9794d.j.g(str);
                onInitFailed(C2663z0.c(this.f9791a.a()), str);
                return;
            }
            this.f9797n.a((C2542rf.a) this);
            AdapterBaseInterface networkAdapter = this.f9793c.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.k, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + k();
            ironLog.error(a(str2));
            onInitFailed(C2663z0.c(this.f9791a.a()), str2);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            D0 d0 = this.f9794d;
            if (d0 != null) {
                d0.j.g(str3);
            }
            onInitFailed(C2663z0.c(this.f9791a.a()), str3);
        }
    }

    public void G() {
        Object obj = this.f9793c;
        if (obj instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[Catch: all -> 0x000b, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:15:0x0051, B:17:0x0055, B:18:0x005a, B:20:0x005e, B:21:0x0063, B:12:0x000e, B:14:0x004a), top: B:27:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: all -> 0x000b, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:15:0x0051, B:17:0x0055, B:18:0x005a, B:20:0x005e, B:21:0x0063, B:12:0x000e, B:14:0x004a), top: B:27:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void M() {
        /*
            r4 = this;
            java.lang.String r0 = "Exception while calling adapter.releaseMemory() from "
            monitor-enter(r4)
            com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter<?, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener> r1 = r4.f9793c     // Catch: java.lang.Throwable -> Lb
            r2 = 0
            if (r1 == 0) goto L51
            r4.f9793c = r2     // Catch: java.lang.Throwable -> Lb java.lang.Exception -> Ld
            goto L51
        Lb:
            r0 = move-exception
            goto L65
        Ld:
            r1 = move-exception
            com.ironsource.r4 r3 = com.ironsource.C2531r4.d()     // Catch: java.lang.Throwable -> Lb
            r3.a(r1)     // Catch: java.lang.Throwable -> Lb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Lb
            com.ironsource.b1 r0 = r4.h     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = r0.f()     // Catch: java.lang.Throwable -> Lb
            r3.append(r0)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = " - "
            r3.append(r0)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> Lb
            r3.append(r0)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = " - state = "
            r3.append(r0)     // Catch: java.lang.Throwable -> Lb
            com.ironsource.s3$h r0 = r4.e     // Catch: java.lang.Throwable -> Lb
            r3.append(r0)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lb
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> Lb
            java.lang.String r3 = r4.a(r0)     // Catch: java.lang.Throwable -> Lb
            r1.error(r3)     // Catch: java.lang.Throwable -> Lb
            com.ironsource.D0 r1 = r4.f9794d     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L51
            com.ironsource.D0 r1 = r4.f9794d     // Catch: java.lang.Throwable -> Lb
            com.ironsource.dg r1 = r1.j     // Catch: java.lang.Throwable -> Lb
            r1.g(r0)     // Catch: java.lang.Throwable -> Lb
        L51:
            com.ironsource.D0 r0 = r4.f9794d     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto L5a
            r0.f()     // Catch: java.lang.Throwable -> Lb
            r4.f9794d = r2     // Catch: java.lang.Throwable -> Lb
        L5a:
            com.ironsource.rf r0 = r4.f9797n     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto L63
            r0.d()     // Catch: java.lang.Throwable -> Lb
            r4.f9797n = r2     // Catch: java.lang.Throwable -> Lb
        L63:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lb
            return
        L65:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lb
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.AbstractC2547s3.M():void");
    }

    public void N() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.f9794d;
        if (d0 != null) {
            d0.f6420i.a();
        }
    }

    public boolean O() {
        return true;
    }

    public String h() {
        return this.f9791a.c();
    }

    public C2461n2 i() {
        return this.f9798o;
    }

    public String j() {
        C2434ld c2434ld = this.g;
        return c2434ld == null ? "" : c2434ld.c();
    }

    public String k() {
        return c() + " " + hashCode();
    }

    public int l() {
        return this.h.d();
    }

    public String m() {
        return this.h.h().isMultipleInstances() ? this.h.h().getProviderTypeForReflection() : this.h.f();
    }

    public String n() {
        return this.h.g();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public final /* synthetic */ void onAdClicked(Map map) {
        b3.b.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public final /* synthetic */ void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str, Map map) {
        b3.b.b(this, adapterErrorType, i2, str, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public final /* synthetic */ void onAdLoadSuccess(Map map) {
        b3.b.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public final /* synthetic */ void onAdOpened(Map map) {
        b3.b.d(this, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public final /* synthetic */ void onAdShowFailed(int i2, String str, Map map) {
        b3.b.e(this, i2, str, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public final /* synthetic */ void onInitFailed(int i2, String str, Map map) {
        c3.a.a(this, i2, str, map);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public final /* synthetic */ void onInitSuccess(Map map) {
        c3.a.b(this, map);
    }

    public NetworkSettings p() {
        return this.f9791a.g();
    }

    public Map<String, Object> q() {
        HashMap map = new HashMap();
        map.putAll(C2395ja.a(this.f9796i));
        return map;
    }

    public Integer r() {
        C2421l0 c2421l0 = this.f9791a;
        if (c2421l0 != null) {
            return Integer.valueOf(c2421l0.h());
        }
        return null;
    }

    public h t() {
        return this.e;
    }

    public InterfaceC2591ud u() {
        return this.p;
    }

    public boolean v() {
        return false;
    }

    public boolean w() {
        return this.h.j();
    }

    public boolean x() {
        return this.e == h.FAILED;
    }

    public boolean y() {
        return this.e == h.LOADED;
    }

    public boolean z() {
        h hVar = this.e;
        return hVar == h.INIT_IN_PROGRESS || hVar == h.LOADING;
    }

    public Map<String, Object> a(A0 a02) {
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.f9793c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : "");
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter2 = this.f9793c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, baseAdAdapter2 != null ? baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion() : "");
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(a("could not get adapter version for event data" + k()));
        }
        map.put("spId", this.h.i());
        map.put(IronSourceConstants.EVENTS_PROVIDER, this.h.a());
        map.put("instanceType", Integer.valueOf(l()));
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(o()));
        if (!TextUtils.isEmpty(this.j)) {
            map.put("dynamicDemandSource", this.j);
        }
        map.put("sessionDepth", r());
        if (this.f9791a.e() != null && this.f9791a.e().length() > 0) {
            map.put("genericParams", this.f9791a.e());
        }
        if (!TextUtils.isEmpty(this.f9791a.c())) {
            map.put("auctionId", this.f9791a.c());
        }
        if (b(a02)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f9791a.d()));
            if (!TextUtils.isEmpty(this.f9791a.b())) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f9791a.b());
            }
        }
        if (!TextUtils.isEmpty(this.f9791a.g().getCustomNetwork())) {
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.f9791a.g().getCustomNetwork());
        }
        return map;
    }

    public void b(String str) {
        this.j = com.ironsource.mediationsdk.d.b().c(str);
    }

    @Override // com.ironsource.O8.b
    public String c() {
        return this.h.f();
    }

    public String d() {
        return a((String) null);
    }

    public Long e() {
        return this.l;
    }

    public AdInfo f() {
        return new AdInfo(this.f9798o.a(j()), this.f9798o.d());
    }

    public IronSource.a g() {
        return this.f9791a.a();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        if (this.p.e()) {
            this.p.a(new g());
        } else {
            H();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str) {
        if (this.p.e()) {
            this.p.a(new e(adapterErrorType, i2, str));
        } else {
            a(adapterErrorType, i2, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        if (this.p.e()) {
            this.p.a(new d());
        } else {
            I();
        }
    }

    public void onAdOpened() {
        if (this.p.e()) {
            this.p.a(new f());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitFailed(int i2, String str) {
        if (this.p.e()) {
            this.p.a(new c(i2, str));
        } else {
            a(i2, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitSuccess() {
        if (this.p.e()) {
            this.p.a(new b());
        } else {
            K();
        }
    }

    @Override // com.ironsource.O8.b
    public int b() {
        return this.h.e();
    }

    private boolean b(A0 a02) {
        return new ArrayList(Arrays.asList(A0.LOAD_AD, A0.LOAD_AD_SUCCESS, A0.LOAD_AD_FAILED, A0.LOAD_AD_FAILED_WITH_REASON, A0.LOAD_AD_NO_FILL, A0.RELOAD_AD, A0.RELOAD_AD_SUCCESS, A0.RELOAD_AD_FAILED_WITH_REASON, A0.RELOAD_AD_NO_FILL, A0.DESTROY_AD, A0.AD_PRESENT_SCREEN, A0.AD_DISMISS_SCREEN, A0.AD_LEFT_APPLICATION, A0.AD_OPENED, A0.AD_CLOSED, A0.SHOW_AD, A0.SHOW_AD_FAILED, A0.AD_CLICKED, A0.AD_REWARDED)).contains(a02);
    }

    public void a(h hVar) {
        IronLog.INTERNAL.verbose(d());
        this.e = hVar;
    }

    public void a(boolean z2) {
        this.f9795f.set(z2);
    }

    public Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("userId", this.f9791a.i());
        return map;
    }

    public AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    public String a(String str) {
        String str2 = this.f9791a.a().name() + " - " + k() + " - state = " + this.e;
        return TextUtils.isEmpty(str) ? str2 : a1.a.D(str2, " - ", str);
    }

    @Override // com.ironsource.C2542rf.a
    public void a() {
        if (!this.p.e()) {
            L();
        } else {
            this.p.a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i2 + ", " + str));
        if (D()) {
            C2542rf c2542rf = this.f9797n;
            if (c2542rf != null) {
                c2542rf.e();
            }
            a(h.FAILED);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i2, str, C2426l5.a(this.m));
            this.f9792b.a(new IronSourceError(i2, str), this);
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a("unexpected init failed for " + k() + ", state - " + this.e + ", error - " + i2 + ", " + str));
        if (this.f9794d != null) {
            this.f9794d.j.m("unexpected init failed, state - " + this.e + ", error - " + i2 + ", " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterErrorType adapterErrorType, int i2, String str) {
        long jA = C2426l5.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + jA + ", error = " + i2 + ", " + str));
        C2542rf c2542rf = this.f9797n;
        if (c2542rf != null) {
            c2542rf.e();
        }
        synchronized (this.f9799q) {
            h hVar = this.e;
            if (hVar == h.LOADING) {
                a(adapterErrorType, i2, str, jA);
                a(h.FAILED);
                this.f9792b.a(new IronSourceError(i2, str), this);
                return;
            }
            if (hVar == h.FAILED) {
                a(adapterErrorType, i2, str, jA);
                return;
            }
            if (hVar == h.LOADED && adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
                this.l = Long.valueOf(System.currentTimeMillis());
                ironLog.error(a("ad expired for " + this.h.f() + ", state = " + this.e));
                D0 d0 = this.f9794d;
                if (d0 != null) {
                    d0.j.a("ad expired, state = " + this.e);
                }
                return;
            }
            ironLog.error(a("unexpected load failed for " + k() + ", state - " + this.e + ", error - " + i2 + ", " + str));
            h hVar2 = this.e;
            StringBuilder sb = new StringBuilder("unexpected load failed, state - ");
            sb.append(hVar2);
            sb.append(", error - ");
            sb.append(i2);
            sb.append(", ");
            sb.append(str);
            String string = sb.toString();
            if (this.f9794d != null) {
                if (v()) {
                    this.f9794d.j.r(string);
                } else if (this.f9791a.a() != IronSource.a.REWARDED_VIDEO || this.e != h.SHOWING) {
                    this.f9794d.j.o(string);
                }
            }
        }
    }

    private void a(AdapterErrorType adapterErrorType, int i2, String str, long j) {
        if (this.f9794d != null) {
            if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
                if (v()) {
                    this.f9794d.f6419f.b(j, i2);
                    return;
                } else {
                    this.f9794d.f6419f.a(j, i2);
                    return;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (v()) {
                    this.f9794d.f6419f.a(j, i2, str);
                    return;
                } else {
                    this.f9794d.f6419f.a(j, i2, str, false);
                    return;
                }
            }
            this.f9794d.f6419f.a(j, i2, false);
        }
    }
}
