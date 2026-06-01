package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.B3;
import com.ironsource.C2243b1;
import com.ironsource.C2371i3;
import com.ironsource.C2395ja;
import com.ironsource.C2426l5;
import com.ironsource.C2531r4;
import com.ironsource.C2542rf;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.H9;
import com.ironsource.InterfaceC2625wd;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class z extends A implements BannerSmashListener, C2542rf.a, B3 {
    private k h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private C2542rf f9438i;
    private a j;
    private InterfaceC2625wd k;
    private q l;
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONObject f9439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9440o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private C2371i3 f9441q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f9442r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private C2426l5 f9443s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9444t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9445u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private JSONObject f9446v;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    public z(k kVar, InterfaceC2625wd interfaceC2625wd, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, boolean z2) {
        this(kVar, interfaceC2625wd, networkSettings, abstractAdapter, i2, "", null, 0, "", z2);
    }

    private void A() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        F();
        try {
            if (this.f8973a != null) {
                if (p()) {
                    this.f8973a.initBannerForBidding(this.h.a(), this.h.i(), this.f8976d, this);
                } else {
                    this.f8973a.initBanners(this.h.a(), this.h.i(), this.f8976d, this);
                }
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to init banner from " + this.f8973a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            onBannerInitFailed(new IronSourceError(612, th.getLocalizedMessage()));
            a(D5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean B() {
        boolean z2;
        synchronized (this.f9442r) {
            z2 = this.j == a.DESTROYED;
        }
        return z2;
    }

    private boolean C() {
        boolean z2;
        synchronized (this.f9442r) {
            z2 = this.j == a.LOADED;
        }
        return z2;
    }

    private void F() {
        if (this.f8973a == null) {
            return;
        }
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f8973a.setPluginData(pluginType);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to set custom params from " + this.f8973a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(D5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean b(D5 d52) {
        return d52 == D5.BN_INSTANCE_LOAD_SUCCESS || d52 == D5.BN_INSTANCE_LOAD || d52 == D5.BN_INSTANCE_RELOAD || d52 == D5.BN_INSTANCE_RELOAD_SUCCESS || d52 == D5.BN_INSTANCE_CLICK || d52 == D5.BN_INSTANCE_DESTROY || d52 == D5.BN_INSTANCE_LOAD_ERROR || d52 == D5.BN_INSTANCE_LOAD_NO_FILL || d52 == D5.BN_INSTANCE_RELOAD_NO_FILL || d52 == D5.BN_INSTANCE_PRESENT_SCREEN || d52 == D5.BN_INSTANCE_DISMISS_SCREEN || d52 == D5.BN_INSTANCE_LEAVE_APP || d52 == D5.BN_INSTANCE_SHOW;
    }

    private void u() {
        IronLog.INTERNAL.verbose("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.f9445u = true;
        A();
    }

    public void D() {
        this.f8973a.onBannerViewBound(this.f8974b.h().getBannerSettings());
    }

    public void E() {
        this.f8973a.onBannerViewWillBind(this.f8974b.h().getBannerSettings());
    }

    public void a(q qVar, C2371i3 c2371i3, String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        this.f9441q = c2371i3;
        this.f9446v = jSONObject;
        if (!l.c(qVar)) {
            String str2 = qVar == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            this.k.a(new IronSourceError(610, str2), this, false);
            return;
        }
        if (this.f8973a == null) {
            ironLog.verbose("mAdapter is null");
            this.k.a(new IronSourceError(611, "mAdapter is null"), this, false);
            return;
        }
        this.l = qVar;
        this.f9438i.a((C2542rf.a) this);
        try {
            if (p()) {
                a(str, this.f9446v);
            } else {
                A();
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
            onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
        }
    }

    @Override // com.ironsource.B3
    public void collectBiddingData(AdData adData, Context context, BiddingDataCallback biddingDataCallback) {
        a(D5.BN_INSTANCE_COLLECT_TOKEN);
        try {
            this.f8973a.collectBannerBiddingData(this.f8976d, adData != null ? C2395ja.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to collectBannerBiddingData from " + this.f8973a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.A
    public IronSource.a d() {
        return IronSource.a.BANNER;
    }

    @Override // com.ironsource.mediationsdk.A
    public String k() {
        return "ProgBannerSmash";
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdClicked(Map map) {
        d3.a.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdLeftApplication(Map map) {
        d3.a.b(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdLoadFailed(IronSourceError ironSourceError, Map map) {
        d3.a.c(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams, Map map) {
        d3.a.d(this, view, layoutParams, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdScreenDismissed(Map map) {
        d3.a.e(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdScreenPresented(Map map) {
        d3.a.f(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerAdShown(Map map) {
        d3.a.g(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerInitFailed(IronSourceError ironSourceError, Map map) {
        d3.a.h(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerInitSuccess(Map map) {
        d3.a.i(this, map);
    }

    @Override // com.ironsource.mediationsdk.A
    public void q() {
        this.f9438i.d();
        super.q();
    }

    public void t() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a(D5.BN_INSTANCE_DESTROY);
        a(a.DESTROYED);
        AbstractAdapter abstractAdapter = this.f8973a;
        if (abstractAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            abstractAdapter.destroyBanner(this.f8974b.h().getBannerSettings());
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to destroy banner from " + this.f8973a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(D5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    public String v() {
        return !TextUtils.isEmpty(this.f8974b.h().getAdSourceNameForEvents()) ? this.f8974b.h().getAdSourceNameForEvents() : i();
    }

    public AbstractAdapter w() {
        return this.f8973a;
    }

    public String x() {
        return this.m;
    }

    public String y() {
        return a1.a.C(f(), " - ");
    }

    public String z() {
        return this.f8974b.i();
    }

    public z(k kVar, InterfaceC2625wd interfaceC2625wd, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, String str, JSONObject jSONObject, int i8, String str2, boolean z2) {
        super(new C2243b1(networkSettings, networkSettings.getBannerSettings(), IronSource.a.BANNER), abstractAdapter);
        this.f9442r = new Object();
        this.j = a.NONE;
        this.h = kVar;
        this.f9438i = new C2542rf(kVar.e());
        this.k = interfaceC2625wd;
        this.f8977f = i2;
        this.m = str;
        this.f9440o = i8;
        this.p = str2;
        this.f9439n = jSONObject;
        this.f9444t = z2;
        this.f9446v = null;
        if (r()) {
            u();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(f());
        a(D5.BN_INSTANCE_CLICK);
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(f());
        a(D5.BN_INSTANCE_LEAVE_APP);
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose(y() + "error = " + ironSourceError);
        this.f9438i.e();
        if (a(a.LOADING, a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(f());
        this.f9438i.e();
        if (!a(a.LOADING, a.LOADED)) {
            a(this.f9444t ? D5.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : D5.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
            return;
        }
        a(this.f9444t ? D5.BN_INSTANCE_RELOAD_SUCCESS : D5.BN_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9443s))}});
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.a(this, view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(f());
        a(D5.BN_INSTANCE_DISMISS_SCREEN);
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(f());
        a(D5.BN_INSTANCE_PRESENT_SCREEN);
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (C()) {
            a(D5.BN_INSTANCE_SHOW);
            InterfaceC2625wd interfaceC2625wd = this.k;
            if (interfaceC2625wd != null) {
                interfaceC2625wd.a(this);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.j);
        a(D5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, c()}});
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.f9438i.e();
        if (!a(a.INIT_IN_PROGRESS, a.NONE)) {
            ironLog.warning("wrong state - mState = " + this.j);
        } else {
            InterfaceC2625wd interfaceC2625wd = this.k;
            if (interfaceC2625wd != null) {
                interfaceC2625wd.a(ironSourceError, this, false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(f());
        if (a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            if (this.f9445u) {
                this.f9445u = false;
            } else {
                if (p()) {
                    return;
                }
                if (l.c(this.l)) {
                    a((String) null, this.f9446v);
                } else {
                    this.k.a(new IronSourceError(605, this.l == null ? "banner is null" : "banner is destroyed"), this, false);
                }
            }
        }
    }

    private void a(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (a(a.READY_TO_LOAD, a.LOADING)) {
            this.f9443s = new C2426l5();
            a(this.f9444t ? D5.BN_INSTANCE_RELOAD : D5.BN_INSTANCE_LOAD);
            if (this.f8973a != null) {
                try {
                    try {
                        if (p()) {
                            this.f8973a.loadBannerForBidding(this.f8976d, this.f9446v, str, this.l.getSize(), this);
                            return;
                        } else {
                            this.f8973a.loadBanner(this.f8976d, this.f9446v, this.l.getSize(), this);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                Throwable th3 = th;
                C2531r4.d().a(th3);
                IronLog.INTERNAL.error("Exception while trying to load banner from " + this.f8973a.getProviderName() + ", exception =  " + th3.getLocalizedMessage());
                onBannerAdLoadFailed(new IronSourceError(605, th3.getLocalizedMessage()));
                a(D5.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{"reason", th3.getLocalizedMessage()}});
                return;
            }
            return;
        }
        ironLog.error("wrong state - state = " + this.j);
    }

    private boolean a(a aVar, a aVar2) {
        boolean z2;
        synchronized (this.f9442r) {
            try {
                if (this.j == aVar) {
                    IronLog.INTERNAL.verbose(y() + "set state from '" + this.j + "' to '" + aVar2 + "'");
                    this.j = aVar2;
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

    private void a(a aVar) {
        IronLog.INTERNAL.verbose(y() + "state = " + aVar.name());
        synchronized (this.f9442r) {
            this.j = aVar;
        }
    }

    @Override // com.ironsource.C2542rf.a
    public void a() {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a aVar = a.INIT_IN_PROGRESS;
        a aVar2 = a.LOAD_FAILED;
        if (a(aVar, aVar2)) {
            ironLog.verbose("init timed out");
            ironSourceError = new IronSourceError(607, "Timed out");
        } else if (a(a.LOADING, aVar2)) {
            ironLog.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        } else {
            ironLog.error("unexpected state - " + this.j);
            return;
        }
        a(ironSourceError);
    }

    private void a(IronSourceError ironSourceError) {
        boolean z2 = ironSourceError.getErrorCode() == 606;
        if (z2) {
            a(this.f9444t ? D5.BN_INSTANCE_RELOAD_NO_FILL : D5.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9443s))}});
        } else {
            a(this.f9444t ? D5.BN_INSTANCE_RELOAD_ERROR : D5.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9443s))}});
        }
        InterfaceC2625wd interfaceC2625wd = this.k;
        if (interfaceC2625wd != null) {
            interfaceC2625wd.a(ironSourceError, this, z2);
        }
    }

    public void a(D5 d52) {
        a(d52, (Object[][]) null);
    }

    public void a(D5 d52, Object[][] objArr) {
        Map<String, Object> mapM = m();
        if (B()) {
            mapM.put("reason", "banner is destroyed");
        } else {
            q qVar = this.l;
            if (qVar != null) {
                l.a(mapM, qVar.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.m)) {
            mapM.put("auctionId", this.m);
        }
        JSONObject jSONObject = this.f9439n;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f9439n);
        }
        C2371i3 c2371i3 = this.f9441q;
        if (c2371i3 != null) {
            mapM.put("placement", c2371i3.c());
        }
        if (b(d52)) {
            H9.i().a(mapM, this.f9440o, this.p);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f8977f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapM.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(c() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        H9.i().a(new C5(d52, new JSONObject(mapM)));
    }
}
