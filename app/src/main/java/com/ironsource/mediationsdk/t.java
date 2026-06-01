package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.B3;
import com.ironsource.C2243b1;
import com.ironsource.C2256be;
import com.ironsource.C2395ja;
import com.ironsource.C2434ld;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.InterfaceC2622wa;
import com.ironsource.Mb;
import com.ironsource.P8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class t extends A implements RewardedVideoSmashListener, B3 {
    private b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC2622wa f9325i;
    private Timer j;
    private int k;
    private String l;
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private C2434ld f9326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9327o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONObject f9328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9329r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9330s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Object f9331t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Object f9332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f9333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final P8.a f9334w;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2;
            int i8;
            boolean z2;
            t tVar = t.this;
            b bVar = tVar.h;
            b bVar2 = b.LOAD_IN_PROGRESS;
            String str = "Rewarded Video - load instance time out";
            if (bVar == bVar2 || bVar == b.INIT_IN_PROGRESS) {
                if (bVar == bVar2) {
                    i2 = 1025;
                } else {
                    i2 = IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT;
                    str = "Rewarded Video - init instance time out";
                }
                tVar.a(b.NOT_LOADED);
                i8 = i2;
                z2 = true;
            } else {
                i8 = 510;
                z2 = false;
            }
            t.this.a(str);
            if (!z2) {
                t.this.a(D5.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{"duration", Long.valueOf(t.this.v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, t.this.h.name()}});
                return;
            }
            t.this.a(D5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"duration", Long.valueOf(t.this.v())}});
            t.this.a(D5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i8)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(t.this.v())}});
            t tVar2 = t.this;
            tVar2.f9325i.d(tVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum b {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    public t(String str, String str2, NetworkSettings networkSettings, InterfaceC2622wa interfaceC2622wa, int i2, AbstractAdapter abstractAdapter, int i8) {
        super(new C2243b1(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.a.REWARDED_VIDEO), abstractAdapter);
        this.f9331t = new Object();
        this.f9332u = new Object();
        this.f9334w = Mb.O().h();
        this.l = str;
        this.m = str2;
        this.f9325i = interfaceC2622wa;
        this.j = null;
        this.k = i2;
        this.f8977f = i8;
        this.h = b.NO_INIT;
        this.f9333v = 0L;
        if (r()) {
            t();
        }
    }

    private void C() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f8973a.setPluginData(pluginType);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            a("setCustomParams() " + th.getMessage());
        }
    }

    private void D() {
        synchronized (this.f9332u) {
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), this.k * 1000);
        }
    }

    private void E() {
        synchronized (this.f9332u) {
            try {
                Timer timer = this.j;
                if (timer != null) {
                    timer.cancel();
                    this.j = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c(D5 d52) {
        return d52 == D5.RV_BUSINESS_INSTANCE_LOAD || d52 == D5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS || d52 == D5.RV_INSTANCE_LOAD_FAILED || d52 == D5.RV_INSTANCE_LOAD_FAILED_REASON || d52 == D5.RV_INSTANCE_LOAD_NO_FILL || d52 == D5.RV_BUSINESS_INSTANCE_OPENED || d52 == D5.RV_INSTANCE_CLOSED || d52 == D5.RV_INSTANCE_SHOW || d52 == D5.RV_INSTANCE_SHOW_FAILED || d52 == D5.RV_BUSINESS_INSTANCE_CLICKED || d52 == D5.RV_BUSINESS_INSTANCE_REWARDED;
    }

    public boolean A() {
        if (this.h != b.LOADED) {
            return false;
        }
        try {
            return this.f8973a.isRewardedVideoAvailable(this.f8976d);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("isReadyToShow exception: " + th.getLocalizedMessage());
            a(D5.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_isReadyException)}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public void B() {
        a(D5.RV_CAP_SESSION);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:47:0x0117
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void a(java.lang.String r12, org.json.JSONObject r13) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.t.a(java.lang.String, org.json.JSONObject):void");
    }

    public void b(boolean z2) {
        b(D5.RV_INSTANCE_SHOW_CHANCE, new Object[][]{new Object[]{"status", z2 ? com.ironsource.mediationsdk.metadata.a.g : "false"}});
    }

    @Override // com.ironsource.B3
    public void collectBiddingData(AdData adData, Context context, BiddingDataCallback biddingDataCallback) {
        a(D5.RV_INSTANCE_COLLECT_TOKEN);
        try {
            this.f8973a.collectRewardedVideoBiddingData(this.f8976d, adData != null ? C2395ja.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("collectBiddingData exception: " + th.getLocalizedMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    @Override // com.ironsource.mediationsdk.A
    public IronSource.a d() {
        return IronSource.a.REWARDED_VIDEO;
    }

    @Override // com.ironsource.mediationsdk.A
    public String k() {
        return "LWSProgRvSmash";
    }

    @Override // com.ironsource.mediationsdk.A
    public int l() {
        return 2;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdClicked(Map map) {
        d3.c.a(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdClosed(Map map) {
        d3.c.b(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdEnded(Map map) {
        d3.c.c(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdOpened(Map map) {
        d3.c.d(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdRewarded(Map map) {
        d3.c.e(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, Map map) {
        d3.c.f(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdStarted(Map map) {
        d3.c.g(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAdVisible(Map map) {
        d3.c.h(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoAvailabilityChanged(boolean z2, Map map) {
        d3.c.i(this, z2, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoInitFailed(IronSourceError ironSourceError, Map map) {
        d3.c.j(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoInitSuccess(Map map) {
        d3.c.k(this, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoLoadFailed(IronSourceError ironSourceError, Map map) {
        d3.c.l(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }

    public C2434ld x() {
        return this.f9326n;
    }

    public boolean y() {
        return this.h == b.LOADED;
    }

    public boolean z() {
        b bVar = this.h;
        return bVar == b.INIT_IN_PROGRESS || bVar == b.LOAD_IN_PROGRESS;
    }

    private void t() {
        a("isBidder = " + p() + ", shouldEarlyInit = " + s());
        a(b.INIT_IN_PROGRESS);
        C();
        try {
            this.f8973a.initRewardedVideoWithCallback(this.l, this.m, this.f8976d, this);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("initForBidding exception: " + th.getLocalizedMessage());
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long v() {
        return new Date().getTime() - this.f9327o;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        a("onRewardedVideoAdClicked");
        this.f9325i.b(this, this.f9326n);
        b(D5.RV_BUSINESS_INSTANCE_CLICKED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        a("onRewardedVideoAdClosed");
        synchronized (this.f9331t) {
            try {
                if (this.h == b.SHOW_IN_PROGRESS) {
                    a(b.ENDED);
                    this.f9333v = new Date().getTime();
                    this.f9325i.c(this);
                } else {
                    b(D5.RV_INSTANCE_CLOSED);
                    a(D5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_adClosed)}, new Object[]{"reason", "adClosed: " + this.h}});
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        a("onRewardedVideoAdEnded");
        this.f9325i.e(this);
        b(D5.RV_INSTANCE_ENDED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        a("onRewardedVideoAdOpened");
        this.f9325i.f(this);
        b(D5.RV_BUSINESS_INSTANCE_OPENED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        a("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.f9325i.a(this, this.f9326n);
        Map<String, Object> mapM = m();
        C2434ld c2434ld = this.f9326n;
        if (c2434ld != null) {
            mapM.put("placement", c2434ld.c());
            mapM.put(IronSourceConstants.EVENTS_REWARD_NAME, this.f9326n.f());
            mapM.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.f9326n.e()));
        }
        if (!TextUtils.isEmpty(r.m().l())) {
            mapM.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, r.m().l());
        }
        if (r.m().r() != null) {
            for (String str : r.m().r().keySet()) {
                mapM.put(a1.a.l("custom_", str), r.m().r().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.p)) {
            mapM.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.f9328q;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f9328q);
        }
        D5 d52 = D5.RV_BUSINESS_INSTANCE_REWARDED;
        if (c(d52)) {
            C2256be.i().a(mapM, this.f9329r, this.f9330s);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f8977f));
        C5 c52 = new C5(d52, new JSONObject(mapM));
        c52.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.a(c52.d(), c()));
        long j = this.f9333v;
        if (j != 0) {
            long j3 = time - j;
            a("onRewardedVideoAdRewarded timeAfterClosed=" + j3);
            c52.a("duration", Long.valueOf(j3));
        }
        C2256be.i().a(c52);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        b(D5.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        synchronized (this.f9331t) {
            try {
                if (this.h == b.SHOW_IN_PROGRESS) {
                    a(b.ENDED);
                    this.f9325i.a(ironSourceError, this);
                    return;
                }
                a(D5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)}, new Object[]{"reason", "showFailed: " + this.h}});
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        a("onRewardedVideoAdStarted");
        this.f9325i.b(this);
        b(D5.RV_INSTANCE_STARTED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        a("onRewardedVideoAdVisible");
        b(D5.RV_INSTANCE_VISIBLE);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z2) {
        boolean z7;
        a("onRewardedVideoAvailabilityChanged available=" + z2 + " state=" + this.h.name());
        synchronized (this.f9331t) {
            try {
                if (this.h == b.LOAD_IN_PROGRESS) {
                    a(z2 ? b.LOADED : b.NOT_LOADED);
                    z7 = false;
                } else {
                    z7 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            if (z2) {
                a(D5.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
                return;
            } else {
                a(D5.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{"duration", Long.valueOf(v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
                return;
            }
        }
        E();
        a(z2 ? D5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS : D5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(v())}});
        if (z2) {
            this.f9325i.a(this);
        } else {
            this.f9325i.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        E();
        a(D5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{"duration", Long.valueOf(v())}});
        a(D5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
        synchronized (this.f9331t) {
            try {
                if (this.h == b.INIT_IN_PROGRESS) {
                    a(b.NO_INIT);
                    this.f9325i.d(this);
                    return;
                }
                a(D5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", "initFailed: " + this.h}});
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
        a("onRewardedVideoInitSuccess");
        synchronized (this.f9331t) {
            try {
                if (this.h == b.INIT_IN_PROGRESS) {
                    a(b.NOT_LOADED);
                    return;
                }
                a(D5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initSuccess)}, new Object[]{"reason", "initSuccess: " + this.h}});
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(D5.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(v())}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.g = Long.valueOf(System.currentTimeMillis());
        }
        a(D5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoLoadSuccess(Map map) {
        d3.c.m(this, map);
    }

    public String u() {
        return this.p;
    }

    public LoadWhileShowSupportState w() {
        try {
            return this.f8973a.getLoadWhileShowSupportState(this.f8976d);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("Exception while calling adapter.getLoadWhileShowSupportState() - " + th.getLocalizedMessage());
            return LoadWhileShowSupportState.NONE;
        }
    }

    private void b(D5 d52) {
        b(d52, null);
    }

    public void b(D5 d52, Object[][] objArr) {
        a(d52, objArr, true);
    }

    public t(t tVar, InterfaceC2622wa interfaceC2622wa, AbstractAdapter abstractAdapter, int i2, String str, JSONObject jSONObject, int i8, String str2) {
        this(tVar.l, tVar.m, tVar.f8974b.h(), interfaceC2622wa, tVar.k, abstractAdapter, i2);
        this.p = str;
        this.f9328q = jSONObject;
        this.f9329r = i8;
        this.f9330s = str2;
    }

    public void a(C2434ld c2434ld) {
        E();
        a("showVideo()");
        this.f9326n = c2434ld;
        a(b.SHOW_IN_PROGRESS);
        b(D5.RV_INSTANCE_SHOW);
        try {
            this.f8973a.showRewardedVideo(this.f8976d, this);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            b("showVideo exception: " + th.getLocalizedMessage());
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        a("current state=" + this.h + ", new state=" + bVar);
        synchronized (this.f9331t) {
            this.h = bVar;
        }
    }

    public void a(D5 d52) {
        a(d52, null, false);
    }

    public void a(D5 d52, Object[][] objArr) {
        a(d52, objArr, false);
    }

    private void a(D5 d52, Object[][] objArr, boolean z2) {
        C2434ld c2434ld;
        Map<String, Object> mapM = m();
        if (!TextUtils.isEmpty(this.p)) {
            mapM.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.f9328q;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f9328q);
        }
        if (z2 && (c2434ld = this.f9326n) != null && !TextUtils.isEmpty(c2434ld.c())) {
            mapM.put("placement", this.f9326n.c());
        }
        if (c(d52)) {
            C2256be.i().a(mapM, this.f9329r, this.f9330s);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f8977f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapM.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, c() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        C2256be.i().a(new C5(d52, new JSONObject(mapM)));
        if (d52 == D5.RV_INSTANCE_CLOSED) {
            this.f9334w.b(IronSource.a.REWARDED_VIDEO);
        }
    }
}
