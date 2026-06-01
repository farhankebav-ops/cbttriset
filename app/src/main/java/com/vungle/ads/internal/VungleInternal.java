package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Utils;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleInternal {
    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-0, reason: not valid java name */
    private static final BidTokenEncoder m3308getAvailableBidTokensAsync$lambda0(f fVar) {
        return (BidTokenEncoder) fVar.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-1, reason: not valid java name */
    private static final SDKExecutors m3309getAvailableBidTokensAsync$lambda1(f fVar) {
        return (SDKExecutors) fVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-2, reason: not valid java name */
    public static final void m3310getAvailableBidTokensAsync$lambda2(BidTokenCallback callback, f bidTokenEncoder$delegate) throws Throwable {
        k.e(callback, "$callback");
        k.e(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_RESPONSE_DURATION_MS);
        timeIntervalMetric.markStart();
        BidTokenEncoder.BiddingTokenInfo biddingTokenInfoEncode = m3308getAvailableBidTokensAsync$lambda0(bidTokenEncoder$delegate).encode();
        timeIntervalMetric.markEnd();
        if (biddingTokenInfoEncode.getBidToken().length() > 0) {
            callback.onBidTokenCollected(biddingTokenInfoEncode.getBidToken());
        } else {
            timeIntervalMetric.setMetricType(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUEST_TO_FAIL_DURATION_MS);
            timeIntervalMetric.setMeta(biddingTokenInfoEncode.getErrorMessage());
            callback.onBidTokenError(biddingTokenInfoEncode.getErrorMessage());
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, (LogEntry) null, (String) null, 6, (Object) null);
    }

    public final void getAvailableBidTokensAsync(Context context, BidTokenCallback callback) {
        k.e(context, "context");
        k.e(callback, "callback");
        if (Utils.INSTANCE.isOSVersionInvalid()) {
            new SdkVersionTooLow("RTB: SDK is supported only for API versions 25 and above.").logErrorNoReturnValue$vungle_ads_release();
            callback.onBidTokenError("RTB: SDK is supported only for API versions 25 and above.");
            return;
        }
        if (!VungleAds.Companion.isInitialized()) {
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            k.d(applicationContext, "context.applicationContext");
            privacyManager.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        g gVar = g.f13494a;
        m3309getAvailableBidTokensAsync$lambda1(b.B(gVar, new VungleInternal$getAvailableBidTokensAsync$$inlined$inject$2(context))).getApiExecutor().execute(new com.unity3d.services.ads.operation.show.b(2, callback, b.B(gVar, new VungleInternal$getAvailableBidTokensAsync$$inlined$inject$1(context))));
    }

    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
