package com.ironsource.mediationsdk;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.L2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class j extends AbstractC2454a<BannerAdListener> implements BannerSmashListener {
    public j(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, UUID uuid) {
        super(abstractAdapter, networkSettings, IronSource.a.BANNER, uuid);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        q qVar = (q) adData.getAdUnitData().get(L2.f7079t);
        if (qVar == null) {
            IronLog.INTERNAL.error(a("Banner layout is null, cannot load banner ad"));
            if (this.f8990b.get() != null) {
                ((BannerAdListener) this.f8990b.get()).onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "Banner layout is null");
                return;
            }
            return;
        }
        if (num == null || num.intValue() != 1) {
            this.f8989a.loadBannerForBidding(jSONObject, jSONObject2, adData.getServerData(), qVar.getSize(), this);
        } else {
            this.f8989a.loadBanner(jSONObject, jSONObject2, qVar.getSize(), this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public IronSource.a b() {
        return IronSource.a.BANNER;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void c(JSONObject jSONObject) {
        this.f8989a.onBannerViewBound(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void d(JSONObject jSONObject) {
        this.f8989a.onBannerViewWillBind(jSONObject);
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
    public void onBannerInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdLeftApplication();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdLoadFailed(a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdLoadSuccess(view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdScreenDismissed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdScreenPresented();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((BannerAdListener) this.f8990b.get()).onAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerInitFailed(IronSourceError ironSourceError, Map map) {
        d3.a.h(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public final /* synthetic */ void onBannerInitSuccess(Map map) {
        d3.a.i(this, map);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject) {
        this.f8989a.destroyBanner(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        this.f8989a.collectBannerBiddingData(jSONObject, jSONObject2, biddingDataCallback);
    }

    public boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 606;
    }
}
