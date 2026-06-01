package com.vungle.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.signals.SignaledAd;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.jvm.internal.k;
import q5.f;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseAd implements Ad {
    private final AdConfig adConfig;
    private final f adInternal$delegate;
    private BaseAdListener adListener;
    private final Context context;
    private String creativeId;
    private final TimeIntervalMetric displayToClickMetric;
    private String eventId;
    private final SingleValueMetric leaveApplicationMetric;
    private final LogEntry logEntry;
    private final String placementId;
    private final TimeIntervalMetric presentToDisplayMetric;
    private final TimeIntervalMetric requestToResponseMetric;
    private final TimeIntervalMetric responseToShowMetric;
    private final SingleValueMetric rewardedMetric;
    private final TimeIntervalMetric showToCloseMetric;
    private final TimeIntervalMetric showToFailMetric;
    private final f signalManager$delegate;
    private SignaledAd signaledAd;

    public BaseAd(Context context, String placementId, AdConfig adConfig) {
        k.e(context, "context");
        k.e(placementId, "placementId");
        k.e(adConfig, "adConfig");
        this.context = context;
        this.placementId = placementId;
        this.adConfig = adConfig;
        this.adInternal$delegate = n7.b.C(new BaseAd$adInternal$2(this));
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = n7.b.B(g.f13494a, new BaseAd$special$$inlined$inject$1(context));
        LogEntry logEntry = new LogEntry();
        logEntry.setPlacementRefId$vungle_ads_release(placementId);
        this.logEntry = logEntry;
        this.requestToResponseMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_REQUEST_TO_RESPONSE_DURATION_MS);
        this.responseToShowMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_RESPONSE_TO_SHOW_DURATION_MS);
        this.presentToDisplayMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_PRESENT_TO_DISPLAY_DURATION_MS);
        this.showToFailMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_SHOW_TO_FAIL_DURATION_MS);
        this.displayToClickMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_DISPLAY_TO_CLICK_DURATION_MS);
        this.leaveApplicationMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_LEAVE_APPLICATION);
        this.rewardedMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.AD_REWARD_USER);
        this.showToCloseMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.AD_SHOW_TO_CLOSE_DURATION_MS);
    }

    private final void onLoadEnd() throws Throwable {
        this.requestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.requestToResponseMetric, this.logEntry, (String) null, 4, (Object) null);
        this.responseToShowMetric.markStart();
    }

    @Override // com.vungle.ads.Ad
    public Boolean canPlayAd() {
        return Boolean.valueOf(AdInternal.canPlayAd$default(getAdInternal$vungle_ads_release(), false, 1, null) == null);
    }

    public abstract AdInternal constructAdInternal$vungle_ads_release(Context context);

    public final AdConfig getAdConfig() {
        return this.adConfig;
    }

    public final AdInternal getAdInternal$vungle_ads_release() {
        return (AdInternal) this.adInternal$delegate.getValue();
    }

    public final BaseAdListener getAdListener() {
        return this.adListener;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final TimeIntervalMetric getDisplayToClickMetric$vungle_ads_release() {
        return this.displayToClickMetric;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final SingleValueMetric getLeaveApplicationMetric$vungle_ads_release() {
        return this.leaveApplicationMetric;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final TimeIntervalMetric getPresentToDisplayMetric$vungle_ads_release() {
        return this.presentToDisplayMetric;
    }

    public final TimeIntervalMetric getRequestToResponseMetric$vungle_ads_release() {
        return this.requestToResponseMetric;
    }

    public final TimeIntervalMetric getResponseToShowMetric$vungle_ads_release() {
        return this.responseToShowMetric;
    }

    public final SingleValueMetric getRewardedMetric$vungle_ads_release() {
        return this.rewardedMetric;
    }

    public final TimeIntervalMetric getShowToCloseMetric$vungle_ads_release() {
        return this.showToCloseMetric;
    }

    public final TimeIntervalMetric getShowToFailMetric$vungle_ads_release() {
        return this.showToFailMetric;
    }

    public final SignalManager getSignalManager$vungle_ads_release() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    public final SignaledAd getSignaledAd$vungle_ads_release() {
        return this.signaledAd;
    }

    @Override // com.vungle.ads.Ad
    public void load(final String str) throws Throwable {
        this.requestToResponseMetric.markStart();
        getAdInternal$vungle_ads_release().loadAd(this.placementId, str, new AdLoaderCallback() { // from class: com.vungle.ads.BaseAd.load.1
            @Override // com.vungle.ads.internal.load.AdLoaderCallback
            public void onFailure(VungleError error) throws Throwable {
                k.e(error, "error");
                BaseAd baseAd = BaseAd.this;
                baseAd.onLoadFailure$vungle_ads_release(baseAd, error);
            }

            @Override // com.vungle.ads.internal.load.AdLoaderCallback
            public void onSuccess(AdPayload advertisement) throws Throwable {
                k.e(advertisement, "advertisement");
                BaseAd.this.onAdLoaded$vungle_ads_release(advertisement);
                BaseAd baseAd = BaseAd.this;
                baseAd.onLoadSuccess$vungle_ads_release(baseAd, str);
            }
        });
    }

    public void onAdLoaded$vungle_ads_release(AdPayload advertisement) {
        k.e(advertisement, "advertisement");
        advertisement.setAdConfig(this.adConfig);
        this.creativeId = advertisement.getCreativeId();
        String strEventId = advertisement.eventId();
        this.eventId = strEventId;
        SignaledAd signaledAd = this.signaledAd;
        if (signaledAd == null) {
            return;
        }
        signaledAd.setEventId(strEventId);
    }

    public void onLoadFailure$vungle_ads_release(BaseAd baseAd, VungleError vungleError) throws Throwable {
        k.e(baseAd, "baseAd");
        k.e(vungleError, "vungleError");
        onLoadEnd();
        ThreadUtil.INSTANCE.runOnUiThread(new BaseAd$onLoadFailure$1(this, vungleError));
    }

    public void onLoadSuccess$vungle_ads_release(BaseAd baseAd, String str) throws Throwable {
        k.e(baseAd, "baseAd");
        onLoadEnd();
        ThreadUtil.INSTANCE.runOnUiThread(new BaseAd$onLoadSuccess$1(this));
    }

    public final void setAdListener(BaseAdListener baseAdListener) {
        this.adListener = baseAdListener;
    }

    public final void setSignaledAd$vungle_ads_release(SignaledAd signaledAd) {
        this.signaledAd = signaledAd;
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getRequestToResponseMetric$vungle_ads_release$annotations() {
    }
}
