package com.vungle.ads.internal.load;

import android.content.Context;
import com.unity3d.services.ads.operation.show.b;
import com.vungle.ads.APIFailedStatusCodeError;
import com.vungle.ads.AdResponseEmptyError;
import com.vungle.ads.AdRetryActiveError;
import com.vungle.ads.AdRetryError;
import com.vungle.ads.NetworkTimeoutError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.PathProvider;
import java.net.SocketTimeoutException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DefaultAdLoader extends BaseAdLoader {

    /* JADX INFO: renamed from: com.vungle.ads.internal.load.DefaultAdLoader$fetchAdMetadata$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Callback<AdPayload> {
        final /* synthetic */ Placement $placement;

        public AnonymousClass1(Placement placement) {
            this.$placement = placement;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onFailure$lambda-1, reason: not valid java name */
        public static final void m3325onFailure$lambda1(DefaultAdLoader this$0, Throwable th) {
            k.e(this$0, "this$0");
            this$0.onAdLoadFailed(this$0.retrofitToVungleError(th).setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onResponse$lambda-0, reason: not valid java name */
        public static final void m3326onResponse$lambda0(DefaultAdLoader this$0, Placement placement, Response response) {
            k.e(this$0, "this$0");
            k.e(placement, "$placement");
            if (this$0.getVungleApiClient().getRetryAfterHeaderValue(placement.getReferenceId()) > 0) {
                this$0.onAdLoadFailed(new AdRetryError().setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
                return;
            }
            if (response != null && !response.isSuccessful()) {
                this$0.onAdLoadFailed(new APIFailedStatusCodeError("ads API: " + response.code()).setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            } else {
                AdPayload adPayload = response != null ? (AdPayload) response.body() : null;
                if ((adPayload != null ? adPayload.adUnit() : null) == null) {
                    this$0.onAdLoadFailed(new AdResponseEmptyError("Ad response is empty").setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
                } else {
                    this$0.handleAdMetaData$vungle_ads_release(adPayload, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.CONFIG_LOADED_FROM_AD_LOAD));
                }
            }
        }

        @Override // com.vungle.ads.internal.network.Callback
        public void onFailure(Call<AdPayload> call, Throwable th) {
            DefaultAdLoader.this.getSdkExecutors().getBackgroundExecutor().execute(new b(4, DefaultAdLoader.this, th));
        }

        @Override // com.vungle.ads.internal.network.Callback
        public void onResponse(Call<AdPayload> call, Response<AdPayload> response) {
            DefaultAdLoader.this.getSdkExecutors().getBackgroundExecutor().execute(new com.vungle.ads.b(DefaultAdLoader.this, this.$placement, response, 2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultAdLoader(Context context, VungleApiClient vungleApiClient, Executors sdkExecutors, OMInjector omInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        super(context, vungleApiClient, sdkExecutors, omInjector, downloader, pathProvider, adRequest);
        k.e(context, "context");
        k.e(vungleApiClient, "vungleApiClient");
        k.e(sdkExecutors, "sdkExecutors");
        k.e(omInjector, "omInjector");
        k.e(downloader, "downloader");
        k.e(pathProvider, "pathProvider");
        k.e(adRequest, "adRequest");
    }

    private final void fetchAdMetadata(VungleAdSize vungleAdSize, Placement placement) {
        if (getVungleApiClient().checkIsRetryAfterActive(placement.getReferenceId())) {
            onAdLoadFailed(new AdRetryActiveError().setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
            return;
        }
        Call<AdPayload> callRequestAd = getVungleApiClient().requestAd(placement.getReferenceId(), vungleAdSize);
        if (callRequestAd == null) {
            onAdLoadFailed(new NetworkUnreachable("adsCall is null").setLogEntry$vungle_ads_release(getLogEntry$vungle_ads_release()).logError$vungle_ads_release());
        } else {
            callRequestAd.enqueue(new AnonymousClass1(placement));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VungleError retrofitToVungleError(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return new NetworkTimeoutError();
        }
        StringBuilder sb = new StringBuilder("ads request fail: ");
        sb.append(th != null ? th.getMessage() : null);
        return new NetworkUnreachable(sb.toString());
    }

    @Override // com.vungle.ads.internal.load.BaseAdLoader
    public void requestAd() {
        fetchAdMetadata(getAdRequest().getRequestAdSize(), getAdRequest().getPlacement());
    }

    @Override // com.vungle.ads.internal.load.BaseAdLoader
    public void onAdLoadReady() {
    }
}
