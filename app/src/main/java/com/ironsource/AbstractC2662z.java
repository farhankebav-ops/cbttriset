package com.ironsource;

import com.ironsource.C2494p0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.ironsource.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2662z implements AdapterAdListener, NetworkInitializationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f10591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final A f10592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final G f10593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<D> f10594d;
    private E e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseAdAdapter<?, ?> f10595f;
    private C2426l5 g;
    private AbstractRunnableC2382ie h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Object> f10596i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AdData f10597n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final C2461n2 f10598o;
    private final C2461n2 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f10599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f10600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f10601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f10602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final IronSource.a f10603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f10604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final H f10605w;

    /* JADX INFO: renamed from: com.ironsource.z$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends AbstractRunnableC2382ie {
        public a() {
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            long jA = C2426l5.a(AbstractC2662z.this.g);
            IronLog ironLog = IronLog.INTERNAL;
            AbstractC2662z abstractC2662z = AbstractC2662z.this;
            ironLog.verbose(abstractC2662z.a("Load duration = " + jA + ", isBidder = " + abstractC2662z.u()));
            AbstractC2662z.this.m = true;
            AbstractC2662z.this.f().e().e().a(jA, 1025, false);
            AbstractC2662z.this.f().e().e().a(jA, 1025, "time out", false);
            AbstractC2662z abstractC2662z2 = AbstractC2662z.this;
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("time out");
            kotlin.jvm.internal.k.d(ironSourceErrorBuildLoadFailedError, "buildLoadFailedError(errorMessage)");
            abstractC2662z2.a(ironSourceErrorBuildLoadFailedError);
        }
    }

    public AbstractC2662z(V0 adTools, A instanceData, G adInstancePayload, D listener) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(instanceData, "instanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        kotlin.jvm.internal.k.e(listener, "listener");
        this.f10591a = adTools;
        this.f10592b = instanceData;
        this.f10593c = adInstancePayload;
        this.f10594d = new WeakReference<>(listener);
        this.f10596i = new LinkedHashMap();
        this.f10597n = instanceData.g();
        this.f10598o = instanceData.n();
        this.p = instanceData.p();
        this.f10599q = instanceData.j().j();
        this.f10600r = instanceData.r();
        this.f10601s = instanceData.s();
        this.f10602t = instanceData.w();
        this.f10603u = instanceData.h();
        this.f10604v = instanceData.v();
        this.f10605w = instanceData.t();
        BaseAdAdapter<?, ?> baseAdAdapterA = a(instanceData);
        this.f10595f = baseAdAdapterA;
        adTools.e().a(new B(adTools, instanceData, baseAdAdapterA));
        adTools.e().a(new U1(instanceData.k()));
    }

    private final void B() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        try {
            G();
            A();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("unexpected error while calling adapter.loadAd() - ", th.getMessage());
            IronLog.INTERNAL.error(a(strL));
            this.f10591a.e().h().g(strL);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, strL);
        }
    }

    private final void C() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        this.f10591a.e().a().a(k());
        D d8 = this.f10594d.get();
        if (d8 != null) {
            d8.a(this);
        }
    }

    private final void D() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        H();
        if (this.m) {
            c();
            this.f10591a.e().h().f("instance load success after it was already failed");
            return;
        }
        if (this.k) {
            this.f10591a.e().h().f("instance load success after it was already loaded");
            return;
        }
        this.k = true;
        long jA = C2426l5.a(this.g);
        ironLog.verbose(a("Load duration = " + jA));
        this.f10591a.e().e().a(jA, false);
        a(C2494p0.a.LoadedSuccessfully);
        E e = this.e;
        if (e != null) {
            e.a(this);
        } else {
            kotlin.jvm.internal.k.l("loadListener");
            throw null;
        }
    }

    private final void E() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        if (this.l) {
            this.f10591a.e().h().f("instance opened after it was already opened");
            return;
        }
        this.l = true;
        this.f10591a.e().a().g(k());
        a(C2494p0.a.ShowedSuccessfully);
        D d8 = this.f10594d.get();
        if (d8 != null) {
            d8.b(this);
        }
    }

    private final void F() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        H();
        if (this.m) {
            return;
        }
        B();
    }

    private final void G() {
        H();
        a aVarA = a();
        this.h = aVarA;
        if (aVarA != null) {
            this.f10591a.a((AbstractRunnableC2382ie) aVarA, TimeUnit.SECONDS.toMillis(o()));
        }
    }

    private final void H() {
        AbstractRunnableC2382ie abstractRunnableC2382ie = this.h;
        if (abstractRunnableC2382ie != null) {
            this.f10591a.b(abstractRunnableC2382ie);
            this.h = null;
        }
    }

    private final int o() {
        Integer numF = this.f10592b.n().f();
        return (numF == null || numF.intValue() <= 0) ? this.f10592b.i().h() : numF.intValue();
    }

    public abstract void A();

    public abstract void a(I i2);

    public void b() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        H();
        this.f10591a.e().e().a(this.f10604v);
    }

    public void c() {
    }

    public final IronSource.a d() {
        return this.f10603u;
    }

    public final Map<String, Object> l() {
        return this.f10596i;
    }

    public final C2461n2 m() {
        return this.p;
    }

    public final A n() {
        return this.f10592b;
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
    public void onAdLoadSuccess() {
        onAdLoadSuccess(new LinkedHashMap());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        onAdOpened(new LinkedHashMap());
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

    public final String p() {
        return this.f10600r;
    }

    public final String q() {
        return this.f10602t;
    }

    public final int r() {
        return this.f10601s;
    }

    public final H s() {
        return this.f10605w;
    }

    public final int t() {
        return this.f10604v;
    }

    public final boolean u() {
        return this.f10599q;
    }

    public final boolean v() {
        return this.m;
    }

    public final boolean w() {
        return this.k;
    }

    public final boolean x() {
        return this.j;
    }

    public final boolean y() {
        return this.l;
    }

    public boolean z() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AbstractC2662z this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AbstractC2662z this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.F();
    }

    public LevelPlayAdInfo e() {
        String string = this.f10592b.i().b().b().toString();
        kotlin.jvm.internal.k.d(string, "instanceData.adUnitData.…roperties.adId.toString()");
        String strC = this.f10592b.i().b().c();
        String string2 = this.f10592b.h().toString();
        kotlin.jvm.internal.k.d(string2, "instanceData.adFormat.toString()");
        return new LevelPlayAdInfo(string, strC, string2, this.f10592b.n().a(k()), this.f10592b.n().d(), null, this.f10592b.i().l(), r5.x.n0(this.f10596i));
    }

    public final V0 f() {
        return this.f10591a;
    }

    public final BaseAdAdapter<?, ?> g() {
        return this.f10595f;
    }

    public final C2461n2 h() {
        return this.f10598o;
    }

    public final AdData i() {
        return this.f10597n;
    }

    public final C2434ld j() {
        return this.f10592b.i().b().f();
    }

    public final String k() {
        return this.f10592b.i().l();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        a(new cj(this, 0));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(adapterErrorType, "adapterErrorType");
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        a(new dj(this, adapterErrorType, i2, errorMessage, 0));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess(Map<String, Object> extraData) {
        kotlin.jvm.internal.k.e(extraData, "extraData");
        a(new bj(1, this, extraData));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened(Map<String, Object> extraData) {
        kotlin.jvm.internal.k.e(extraData, "extraData");
        a(new cj(this, 2));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdShowFailed(int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        a(new ej(this, i2, errorMessage, 1));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitFailed(int i2, String str) {
        a(new ej(this, i2, str, 0));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitSuccess() {
        a(new cj(this, 1));
    }

    private final void b(int i2, String str) {
        IronLog.INTERNAL.verbose(a("error = " + i2 + ", " + str));
        H();
        this.m = true;
        a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i2, str, C2426l5.a(this.g));
        a(new IronSourceError(i2, str));
    }

    public final void a(C2494p0.a performance) {
        kotlin.jvm.internal.k.e(performance, "performance");
        this.f10592b.a(performance);
    }

    public final void a(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        this.f10591a.a(callback);
    }

    public final void a(boolean z2) {
        this.f10591a.e().a().a(z2);
    }

    private final BaseAdAdapter<?, ?> a(A a8) {
        if (a8.i().e().q()) {
            return this.f10593c.b();
        }
        return this.f10591a.a(a8);
    }

    public final void a(E listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        this.e = listener;
        this.j = true;
        try {
            this.f10591a.e().e().a(false);
            this.g = new C2426l5();
            G();
            BaseAdAdapter<?, ?> baseAdAdapter = this.f10595f;
            kotlin.jvm.internal.k.b(baseAdAdapter);
            AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.f10592b.g(), ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str = "loadAd - network adapter not available " + this.f10602t;
            ironLog.error(a(str));
            b(C2663z0.c(this.f10592b.h()), str);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strL = a1.a.l("loadAd - exception = ", th.getLocalizedMessage());
            IronLog.INTERNAL.error(a(strL));
            this.f10591a.e().h().g(strL);
            b(C2663z0.c(this.f10592b.h()), strL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AbstractC2662z this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AbstractC2662z this$0, int i2, String str) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.b(i2, str);
    }

    public static /* synthetic */ String a(AbstractC2662z abstractC2662z, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return abstractC2662z.a(str);
    }

    public final String a(String str) {
        return this.f10591a.a(str, this.f10602t);
    }

    private final a a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IronSourceError ironSourceError) {
        a(C2494p0.a.FailedToLoad);
        E e = this.e;
        if (e != null) {
            e.a(ironSourceError, this);
        } else {
            kotlin.jvm.internal.k.l("loadListener");
            throw null;
        }
    }

    private final void a(AdapterErrorType adapterErrorType, int i2, String str) {
        long jA = C2426l5.a(this.g);
        IronLog.INTERNAL.verbose(a("Load duration = " + jA + ", error = " + i2 + ", " + str));
        H();
        if (this.m) {
            c();
            a(adapterErrorType, i2, str, jA);
        } else {
            if (this.k) {
                a(adapterErrorType);
                return;
            }
            this.m = true;
            c();
            a(adapterErrorType, i2, str, jA);
            a(new IronSourceError(i2, str));
        }
    }

    public final void a(int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        IronLog.INTERNAL.verbose(a("Show error = " + i2 + ", " + errorMessage));
        this.f10591a.e().a().a(k(), i2, errorMessage, "");
        a(C2494p0.a.FailedToShow);
        D d8 = this.f10594d.get();
        if (d8 != null) {
            d8.a(this, new IronSourceError(i2, errorMessage));
        }
        c();
    }

    private final void a(AdapterErrorType adapterErrorType) {
        if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
            this.f10591a.e().h().a("");
        } else {
            this.f10591a.e().h().f("instance load failed after it was already loaded");
        }
    }

    private final void a(AdapterErrorType adapterErrorType, int i2, String str, long j) {
        if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
            this.f10591a.e().e().a(j, i2);
        } else if (str != null && str.length() != 0) {
            this.f10591a.e().e().a(j, i2, str, false);
        } else {
            this.f10591a.e().e().a(j, i2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AbstractC2662z this$0, Map extraData) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(extraData, "$extraData");
        this$0.f10596i.putAll(extraData);
        this$0.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AbstractC2662z this$0, AdapterErrorType adapterErrorType, int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adapterErrorType, "$adapterErrorType");
        kotlin.jvm.internal.k.e(errorMessage, "$errorMessage");
        this$0.a(adapterErrorType, i2, errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AbstractC2662z this$0, int i2, String errorMessage) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(errorMessage, "$errorMessage");
        this$0.a(i2, errorMessage);
    }
}
