package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C2243b1;
import com.ironsource.C2280d2;
import com.ironsource.C2334g2;
import com.ironsource.C2426l5;
import com.ironsource.C2461n2;
import com.ironsource.C2516q5;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.H9;
import com.ironsource.InterfaceC2244b2;
import com.ironsource.Mb;
import com.ironsource.P8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.e;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class g extends m implements n.a, InterstitialSmashListener, InterfaceC2244b2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C2426l5 f9112n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private C2426l5 f9113o;
    private ISDemandOnlyInterstitialListener p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private C2280d2 f9114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f9115r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f9116s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final P8 f9117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final P8.a f9118u;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    public g(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener, long j, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new C2243b1(networkSettings, networkSettings.getInterstitialSettings(), IronSource.a.INTERSTITIAL), abstractAdapter);
        this.f9116s = new p.b();
        this.f9117t = Mb.U().s();
        this.f9118u = Mb.O().h();
        this.p = iSDemandOnlyInterstitialListener;
        this.f9153f = j;
        this.f9115r = eVar;
        this.f9149a.initInterstitial(str, str2, this.f9151c, this);
    }

    private void c(o oVar) {
        this.f9112n = new C2426l5();
        a(new a());
        if (!n()) {
            a(new IronSourceError(e.a.k, "loadInterstitialWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new C2516q5());
            C2461n2 c2461n2A = new a.C0192a(aVar.h()).a(h());
            if (c2461n2A == null) {
                IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm invalid enriched adm");
                a(D5.IS_INSTANCE_LOAD_FAILED, (Object[][]) null);
                a(ironSourceErrorBuildLoadFailedError);
                return;
            }
            String strK = c2461n2A.k();
            if (strK == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(e.a.f9108i, "No available ad to load"));
                return;
            }
            b(strK);
            a(aVar.a());
            a(aVar.f());
            a(D5.TROUBLESHOOTING_IS_INSTANCE_LOAD_WITH_ADM, (Object[][]) null);
            this.f9114q.a(c2461n2A.b());
            this.f9113o = new C2426l5();
            this.f9149a.loadInterstitialForBidding(this.f9151c, null, strK, this);
        } catch (Exception e) {
            C2531r4.d().a(e);
            a(ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm: Exception= " + e.getMessage()));
        }
    }

    private com.ironsource.mediationsdk.i q() {
        String str = i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.m);
        iVar.b(IronSourceUtils.g());
        iVar.a(true);
        iVar.c(true);
        iVar.d(str);
        iVar.c(l());
        iVar.a(this.f9117t.a(this.m));
        C2334g2 c2334g2 = new C2334g2(h(), false);
        c2334g2.a(this.f9116s.value());
        Map<String, Object> interstitialBiddingData = this.f9149a.getInterstitialBiddingData(this.f9151c, new JSONObject());
        if (interstitialBiddingData != null) {
            c2334g2.b(interstitialBiddingData);
        }
        iVar.a(c2334g2);
        return iVar;
    }

    private void r() {
        this.f9113o = new C2426l5();
        this.f9149a.loadInterstitial(this.f9151c, null, this);
    }

    private void s() {
        if (!this.f9115r.a()) {
            IronLog.INTERNAL.verbose("can't load the interstitial the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a(D5.TROUBLESHOOTING_IS_INSTANCE_AUCTION_REQUEST, (Object[][]) null);
        com.ironsource.mediationsdk.i iVarQ = q();
        IronLog.INTERNAL.verbose("auction waterfallString = " + iVarQ.r());
        a(D5.TROUBLESHOOTING_IS_INSTANCE_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, iVarQ.r()}});
        this.f9115r.a(ContextProvider.getInstance().getApplicationContext(), iVarQ, this);
    }

    private void t() {
        this.g = null;
        this.h = null;
        this.j = null;
        this.f9114q = new C2280d2();
    }

    private void u() {
        this.f9112n = new C2426l5();
        a(new b());
        if (n()) {
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial must be called by non bidder instances");
            a(D5.IS_INSTANCE_LOAD_FAILED, (Object[][]) null);
            a(ironSourceErrorBuildLoadFailedError);
        } else if (o()) {
            s();
        } else {
            r();
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void a(o oVar) {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            a(new IronSourceError(1050, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        t();
        a(D5.IS_INSTANCE_LOAD, (Object[][]) null);
        c(oVar);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void b() {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            this.p.onInterstitialAdLoadFailed(l(), new IronSourceError(1050, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        t();
        a(D5.IS_INSTANCE_LOAD, (Object[][]) null);
        u();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void e() {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", state=" + k());
        a(D5.IS_INSTANCE_SHOW, (Object[][]) null);
        m.a aVar = m.a.LOADED;
        m.a aVar2 = m.a.SHOW_IN_PROGRESS;
        if (a(aVar, aVar2)) {
            this.f9149a.showInterstitial(this.f9151c, this);
        } else {
            onInterstitialAdShowFailed(a(aVar2) ? new IronSourceError(1064, "showInterstitial error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1065, "showInterstitial error: can't show ad while an ad is loading") : new IronSourceError(1066, "showInterstitial error: no available ads to show"));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdClicked(Map map) {
        d3.b.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdClosed(Map map) {
        d3.b.b(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdLoadFailed(IronSourceError ironSourceError, Map map) {
        d3.b.c(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdOpened(Map map) {
        d3.b.d(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdReady(Map map) {
        d3.b.e(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdShowFailed(IronSourceError ironSourceError, Map map) {
        d3.b.f(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdVisible(Map map) {
        d3.b.h(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(D5.IS_INSTANCE_CLICKED, new Object[0][]);
        this.p.onInterstitialAdClicked(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(D5.IS_INSTANCE_CLOSED, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.f9117t.a(this.m))}});
        this.f9118u.b(this.m);
        this.p.onInterstitialAdClosed(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.getErrorMessage() + " instance name= " + h() + " state=" + k());
        a(D5.TROUBLESHOOTING_IS_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9113o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(D5.IS_INSTANCE_OPENED, new Object[0][]);
        a(this.f9114q.a(), IronSourceUtils.a());
        this.p.onInterstitialAdOpened(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h() + " state=" + k());
        p();
        a(D5.TROUBLESHOOTING_IS_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9113o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(D5.IS_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C2426l5.a(this.f9112n))}});
            a(this.f9114q.c(), IronSourceUtils.a());
            this.p.onInterstitialAdReady(l());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(D5.IS_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.p.onInterstitialAdShowFailed(l(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialAdShowSucceeded(Map map) {
        d3.b.g(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(D5.IS_INSTANCE_VISIBLE, new Object[0][]);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialInitFailed(IronSourceError ironSourceError, Map map) {
        d3.b.i(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public final /* synthetic */ void onInterstitialInitSuccess(Map map) {
        d3.b.j(this, map);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public boolean a() {
        D5 d52;
        boolean zIsInterstitialReady = false;
        if (!a(m.a.LOADED)) {
            a(D5.IS_INSTANCE_READY_FALSE, (Object[][]) null);
            return false;
        }
        try {
            zIsInterstitialReady = this.f9149a.isInterstitialReady(this.f9151c);
            if (zIsInterstitialReady) {
                d52 = D5.IS_INSTANCE_READY_TRUE;
            } else {
                d52 = D5.IS_INSTANCE_READY_FALSE;
            }
            a(d52, (Object[][]) null);
            return zIsInterstitialReady;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("exception=" + e.getMessage());
            return zIsInterstitialReady;
        }
    }

    public void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, C2426l5.a(this.f9112n));
            a(this.f9114q.b(), IronSourceUtils.a());
            this.p.onInterstitialAdLoadFailed(l(), ironSourceError);
        }
    }

    private void a(D5 d52, Object[][] objArr) {
        Map<String, Object> mapJ = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapJ.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e));
            }
        }
        H9.i().a(new C5(d52, new JSONObject(mapJ)));
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(e.a.f9108i, "No available ad to load"));
            } else {
                a(D5.TROUBLESHOOTING_IS_INSTANCE_LOAD_WITH_ADM, (Object[][]) null);
                this.f9149a.loadInterstitialForBidding(this.f9151c, null, str, this);
            }
        }
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 1158) {
            a(D5.IS_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        } else {
            a(D5.IS_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        }
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    @Override // com.ironsource.InterfaceC2244b2
    public void a(d.a aVar, int i2, long j, int i8, String str) {
        String strK;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        this.f9116s = aVar.a(l());
        a.C0192a c0192a = new a.C0192a(aVar.h());
        if (!c0192a.isEmpty()) {
            C2461n2 c2461n2 = c0192a.get(0);
            this.f9114q.a(c2461n2.b());
            this.f9114q.c(c2461n2.h());
            this.f9114q.b(c2461n2.g());
            strK = c2461n2.k();
            b(strK);
        } else {
            strK = "";
        }
        if (!TextUtils.isEmpty(str)) {
            a(D5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"reason", str}});
        }
        a(D5.TROUBLESHOOTING_IS_INSTANCE_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(D5.TROUBLESHOOTING_IS_INSTANCE_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0192a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (c0192a.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(1158, "There is no available ad to load");
                ironLog.error("interstitial - empty waterfall");
                a(ironSourceError);
                return;
            }
            c(strK);
        }
    }

    @Override // com.ironsource.S1
    public void a(List<C2461n2> list, String str, C2461n2 c2461n2, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i8, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    @Override // com.ironsource.S1
    public void a(int i2, String str, int i8, String str2, long j) {
        IronLog.INTERNAL.verbose("error " + i2 + " - " + str);
        this.g = null;
        this.h = null;
        a(D5.TROUBLESHOOTING_IS_INSTANCE_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(e.a.j, "No available ad to load"));
        }
    }
}
