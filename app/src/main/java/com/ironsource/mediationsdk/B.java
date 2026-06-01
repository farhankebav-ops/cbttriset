package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class B extends AbstractC2454a<RewardedVideoAdListener> implements RewardedVideoSmashListener {
    public B(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, UUID uuid) {
        super(abstractAdapter, networkSettings, IronSource.a.REWARDED_VIDEO, uuid);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.f8989a.loadRewardedVideoForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.f8989a.loadRewardedVideo(jSONObject, jSONObject2, this);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public boolean b(JSONObject jSONObject) {
        return this.f8989a.isRewardedVideoAvailable(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void e(JSONObject jSONObject) {
        this.f8989a.showRewardedVideo(jSONObject, this);
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
    public void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdOpened();
        }
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
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public final /* synthetic */ void onRewardedVideoLoadFailed(IronSourceError ironSourceError, Map map) {
        d3.c.l(this, ironSourceError, map);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdLoadSuccess();
        }
    }

    public boolean b(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1058;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdClosed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdEnded();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdRewarded();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdStarted();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdVisible();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z2) {
        IronLog.INTERNAL.verbose(a("available = " + z2));
        if (this.f8990b.get() != null) {
            if (z2) {
                ((RewardedVideoAdListener) this.f8990b.get()).onAdLoadSuccess();
            } else {
                ((RewardedVideoAdListener) this.f8990b.get()).onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, "");
            }
        }
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
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdLoadFailed(b(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public IronSource.a b() {
        return IronSource.a.REWARDED_VIDEO;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdOpened(map);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.f8990b.get() != null) {
            ((RewardedVideoAdListener) this.f8990b.get()).onAdLoadSuccess(map);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        this.f8989a.collectRewardedVideoBiddingData(jSONObject, jSONObject2, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2454a
    public void a(JSONObject jSONObject) {
        this.f8989a.destroyRewardedVideoAd(jSONObject);
    }

    private boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1057;
    }
}
