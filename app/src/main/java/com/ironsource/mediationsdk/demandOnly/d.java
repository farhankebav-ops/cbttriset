package com.ironsource.mediationsdk.demandOnly;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.C2243b1;
import com.ironsource.C2280d2;
import com.ironsource.C2426l5;
import com.ironsource.C2461n2;
import com.ironsource.C2516q5;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.H9;
import com.ironsource.InterfaceC2244b2;
import com.ironsource.Mb;
import com.ironsource.P8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.b;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class d extends m implements BannerSmashListener, InterfaceC2244b2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C2426l5 f9092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private C2426l5 f9093o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f9094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private C2280d2 f9095r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f9096s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ISDemandOnlyBannerLayout f9097t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final P8 f9098u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final P8.a f9099v;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ironsource.mediationsdk.i f9100a;

        public a(com.ironsource.mediationsdk.i iVar) {
            this.f9100a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(83500, (Object[][]) null);
            IronLog.INTERNAL.verbose("auction waterfallString = " + this.f9100a.r());
            d.this.a(83510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.f9100a.r()}});
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            d dVar = d.this;
            dVar.f9096s.a(applicationContext, this.f9100a, dVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + d.this.k());
            d.this.a(new IronSourceError(608, "load timed out"));
        }
    }

    public d(String str, String str2, NetworkSettings networkSettings, long j, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new C2243b1(networkSettings, networkSettings.getBannerSettings(), IronSource.a.BANNER), abstractAdapter);
        this.f9098u = Mb.U().s();
        this.f9099v = Mb.O().h();
        this.f9153f = j;
        this.p = str;
        this.f9094q = str2;
        this.f9095r = new C2280d2();
        this.f9149a.initBannerForBidding(str, str2, this.f9151c, this);
        this.f9096s = eVar;
    }

    private boolean t() {
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.f9097t;
        return iSDemandOnlyBannerLayout == null || iSDemandOnlyBannerLayout.isDestroyed();
    }

    private void u() {
        IronLog.INTERNAL.verbose();
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(q()));
    }

    private void v() {
        this.g = null;
        this.h = null;
        this.f9095r = new C2280d2();
    }

    private void w() {
        IronLog.INTERNAL.verbose();
        a(new b());
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(aVarArr, aVar);
        if (aVarA == aVar || aVarA == m.a.SHOW_IN_PROGRESS) {
            if (iSDemandOnlyBannerLayout.isDestroyed()) {
                a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
                return;
            } else {
                String str = "banner layout in blocking state | state: " + k();
                iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
                a(b.c.e, new Object[][]{new Object[]{"reason", str}});
                return;
            }
        }
        v();
        a(3002, (Object[][]) null);
        if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a(new IronSourceError(610, "bannerLayout is destroyed"));
            return;
        }
        this.f9097t = iSDemandOnlyBannerLayout;
        if (!n()) {
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadBannerForBidder in IAB flow must be called by bidder instances");
            a(3300, (Object[][]) null);
            a(ironSourceErrorBuildLoadFailedError);
            return;
        }
        try {
            d.a aVar2 = (d.a) oVar.a(new C2516q5());
            C2461n2 c2461n2A = new a.C0192a(aVar2.h()).a(h());
            if (c2461n2A == null) {
                IronSourceError ironSourceErrorBuildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadBannerForBidder invalid enriched ADM");
                a(3300, (Object[][]) null);
                a(ironSourceErrorBuildLoadFailedError2);
                return;
            }
            String strK = c2461n2A.k();
            if (strK == null) {
                ironLog.error("serverData is null");
                a(new IronSourceError(618, "No available ad to load"));
                return;
            }
            b(strK);
            a(aVar2.a());
            a(aVar2.f());
            a(83302, (Object[][]) null);
            this.f9095r.a(c2461n2A.b());
            this.f9092n = new C2426l5();
            w();
            this.f9149a.initBannerForBidding(this.p, this.f9094q, this.f9151c, this);
            this.f9149a.loadBannerForDemandOnlyForBidding(this.f9151c, strK, iSDemandOnlyBannerLayout, this);
        } catch (Exception e) {
            C2531r4.d().a(e);
            a(ErrorBuilder.buildLoadFailedError("loadBannerForBidder: Exception= " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.m
    public Map<String, Object> j() {
        HashMap map = new HashMap();
        try {
            if (t()) {
                map.put("reason", "banner is destroyed");
            } else {
                com.ironsource.mediationsdk.l.a(map, this.f9097t.getSize());
            }
            AbstractAdapter abstractAdapter = this.f9149a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f9149a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            map.put("spId", this.f9150b.i());
            map.put(IronSourceConstants.EVENTS_PROVIDER, this.f9150b.a());
            map.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (o()) {
                map.put("isOneFlow", 1);
            }
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            map.put("instanceType", Integer.valueOf(this.f9150b.d()));
            if (!TextUtils.isEmpty(this.g)) {
                map.put("auctionId", this.g);
            }
            JSONObject jSONObject = this.h;
            if (jSONObject != null && jSONObject.length() > 0) {
                map.put("genericParams", this.h);
            }
            if (!TextUtils.isEmpty(this.j)) {
                map.put("dynamicDemandSource", this.j);
            }
            return map;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("Instance: " + h() + " " + e.getMessage());
            return map;
        }
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
    public void onBannerAdScreenDismissed() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
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

    public com.ironsource.mediationsdk.i q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h());
        String str = "" + i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(IronSource.a.BANNER);
        iVar.a(arrayList);
        iVar.d(str);
        iVar.c(l());
        iVar.b(IronSourceUtils.g());
        iVar.a(true);
        iVar.c(true);
        iVar.a(this.f9097t.getSize());
        return iVar;
    }

    public void r() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(new m.a[]{m.a.LOADED, m.a.LOAD_IN_PROGRESS, m.a.SHOW_IN_PROGRESS}, m.a.NOT_LOADED);
        if (t()) {
            ironLog.error("Banner is null or already destroyed and can't be used anymore");
            return;
        }
        p();
        ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = this.f9097t;
        if (iSDemandOnlyBannerLayout != null) {
            iSDemandOnlyBannerLayout.a();
        }
        this.f9097t = null;
        AbstractAdapter abstractAdapter = this.f9149a;
        if (abstractAdapter == null) {
            ironLog.error("can't destroy adapter. mAdapter == null");
        } else {
            abstractAdapter.destroyBanner(this.f9151c);
        }
        a(3305, (Object[][]) null);
        ironLog.verbose("banner layout was destroyed. bannerId: " + l());
    }

    public String s() {
        return this.f9150b.h().isMultipleInstances() ? this.f9150b.h().getProviderTypeForReflection() : this.f9150b.h().getProviderName();
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(618, "No available ad to load"));
            } else {
                a(83302, (Object[][]) null);
                this.f9093o = new C2426l5();
                this.f9149a.initBannerForBidding(this.p, this.f9094q, this.f9151c, this);
                this.f9149a.loadBannerForDemandOnlyForBidding(this.f9151c, str, this.f9097t, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(3008, (Object[][]) null);
        if (t()) {
            return;
        }
        this.f9097t.getListener().a(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(b.C0193b.g, (Object[][]) null);
        if (t()) {
            return;
        }
        this.f9097t.getListener().b(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("smash - " + s());
        a(83300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9093o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("smash = " + s());
        P8 p8 = this.f9098u;
        IronSource.a aVar = IronSource.a.BANNER;
        int iA = p8.a(aVar);
        a(b.c.f9087d, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(iA)}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9093o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            p();
            if (!t()) {
                this.f9097t.a(view, layoutParams);
            }
            a(3005, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(iA)}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9092n))}});
            this.f9099v.b(aVar);
            a(this.f9095r.c(), IronSourceUtils.a());
            if (t()) {
                return;
            }
            this.f9097t.getListener().c(l());
        }
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
    public void onBannerAdShown() {
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            IronLog.INTERNAL.verbose("smash - " + s());
            a(3009, (Object[][]) null);
            a(this.f9095r.a(), IronSourceUtils.a());
            if (t()) {
                return;
            }
            this.f9097t.getListener().d(l());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("smash - " + s() + " " + ironSourceError.toString());
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose("smash - " + s());
    }

    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + k());
        if (iSDemandOnlyBannerLayout == null) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is null | state: " + k()}});
            return;
        }
        m.a[] aVarArr = {m.a.NOT_LOADED, m.a.LOADED};
        m.a aVar = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(aVarArr, aVar);
        if (aVarA != aVar && aVarA != m.a.SHOW_IN_PROGRESS) {
            v();
            a(3002, (Object[][]) null);
            if (!o()) {
                ironLog.verbose("can't load banner when isOneFlow = false");
                a(new IronSourceError(1063, "Missing configuration settings"));
                return;
            }
            this.f9097t = iSDemandOnlyBannerLayout;
            this.f9092n = new C2426l5();
            w();
            if (this.f9096s.a()) {
                u();
                return;
            } else {
                ironLog.verbose("can't load the banner the auction isn't enabled");
                a(new IronSourceError(1063, "Missing server configuration"));
                return;
            }
        }
        if (iSDemandOnlyBannerLayout.isDestroyed()) {
            a(b.c.e, new Object[][]{new Object[]{"reason", "bannerLayout is destroyed | state: " + k()}});
        } else {
            String str = "banner layout in blocking state | state: " + k();
            iSDemandOnlyBannerLayout.getListener().a(l(), new IronSourceError(619, str));
            a(b.c.e, new Object[][]{new Object[]{"reason", str}});
        }
    }

    @Override // com.ironsource.S1
    public void a(int i2, String str, int i8, String str2, long j) {
        IronLog.INTERNAL.verbose("Auction failed. error " + i2 + " - " + str);
        this.g = null;
        this.h = null;
        a(b.c.g, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(621, "No available ad to load"));
        }
    }

    @Override // com.ironsource.S1
    public void a(List<C2461n2> list, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        IronLog.INTERNAL.error("onAuctionSuccess - Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("error = " + ironSourceError.getErrorMessage() + " smash - " + s());
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            p();
            a(ironSourceError, C2426l5.a(this.f9092n));
            a(this.f9095r.b(), IronSourceUtils.a());
            if (t()) {
                return;
            }
            this.f9097t.getListener().a(l(), ironSourceError);
        }
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 606) {
            a(b.C0193b.f9083i, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            a(3300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(j)}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        Map<String, Object> mapJ = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    if (objArr2[1] != null) {
                        mapJ.put(objArr2[0].toString(), objArr2[1]);
                    }
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
        H9.i().a(new C5(i2, new JSONObject(mapJ)));
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    @Override // com.ironsource.InterfaceC2244b2
    public void a(d.a aVar, int i2, long j, int i8, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        a.C0192a c0192a = new a.C0192a(aVar.h());
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"reason", str}});
        }
        a(b.c.h, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(b.c.j, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0192a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (c0192a.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(b.C0193b.f9083i, "There is no available ad to load");
                ironLog.error("loadBanner - empty waterfall");
                a(ironSourceError);
                return;
            }
            C2461n2 c2461n2 = c0192a.get(0);
            this.f9095r.a(c2461n2.b());
            this.f9095r.c(c2461n2.h());
            this.f9095r.b(c2461n2.g());
            String strK = c2461n2.k();
            b(strK);
            c(strK);
        }
    }
}
