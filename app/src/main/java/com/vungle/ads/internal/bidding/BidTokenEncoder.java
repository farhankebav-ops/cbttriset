package com.vungle.ads.internal.bidding;

import a1.a;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.GzipEncodeError;
import com.vungle.ads.JsonEncodeError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.RtbRequest;
import com.vungle.ads.internal.model.RtbToken;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.InputOutputUtils;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import g7.c;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.g;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BidTokenEncoder {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BidTokenEncoder";
    public static final int TOKEN_VERSION = 6;
    private SingleValueMetric bidTokenRequestedMetric;
    private final Context context;
    private long enterBackgroundTime;
    private final c json;
    private int ordinalView;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class BiddingTokenInfo {
        private final String bidToken;
        private final String errorMessage;

        public BiddingTokenInfo(String bidToken, String errorMessage) {
            k.e(bidToken, "bidToken");
            k.e(errorMessage, "errorMessage");
            this.bidToken = bidToken;
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ BiddingTokenInfo copy$default(BiddingTokenInfo biddingTokenInfo, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = biddingTokenInfo.bidToken;
            }
            if ((i2 & 2) != 0) {
                str2 = biddingTokenInfo.errorMessage;
            }
            return biddingTokenInfo.copy(str, str2);
        }

        public final String component1() {
            return this.bidToken;
        }

        public final String component2() {
            return this.errorMessage;
        }

        public final BiddingTokenInfo copy(String bidToken, String errorMessage) {
            k.e(bidToken, "bidToken");
            k.e(errorMessage, "errorMessage");
            return new BiddingTokenInfo(bidToken, errorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BiddingTokenInfo)) {
                return false;
            }
            BiddingTokenInfo biddingTokenInfo = (BiddingTokenInfo) obj;
            return k.a(this.bidToken, biddingTokenInfo.bidToken) && k.a(this.errorMessage, biddingTokenInfo.errorMessage);
        }

        public final String getBidToken() {
            return this.bidToken;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode() + (this.bidToken.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BiddingTokenInfo(bidToken=");
            sb.append(this.bidToken);
            sb.append(", errorMessage=");
            return a.e(')', this.errorMessage, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public BidTokenEncoder(Context context) {
        k.e(context, "context");
        this.context = context;
        this.bidTokenRequestedMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.BID_TOKEN_REQUESTED);
        this.json = a.a.b(BidTokenEncoder$json$1.INSTANCE);
        ActivityManager.Companion.addLifecycleListener(new ActivityManager.LifeCycleCallback() { // from class: com.vungle.ads.internal.bidding.BidTokenEncoder.1
            @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
            public void onBackground() {
                BidTokenEncoder.this.onPause$vungle_ads_release();
            }

            @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
            public void onForeground() {
                BidTokenEncoder.this.onResume$vungle_ads_release();
            }
        });
    }

    /* JADX INFO: renamed from: constructV6Token$lambda-0, reason: not valid java name */
    private static final VungleApiClient m3311constructV6Token$lambda0(q5.f fVar) {
        return (VungleApiClient) fVar.getValue();
    }

    private final BiddingTokenInfo generateBidToken() throws Throwable {
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.bidTokenRequestedMetric, (LogEntry) null, (String) null, 6, (Object) null);
        try {
            String strConstructV6Token$vungle_ads_release = constructV6Token$vungle_ads_release();
            Logger.Companion companion = Logger.Companion;
            companion.d(TAG, "BidToken: " + strConstructV6Token$vungle_ads_release);
            try {
                String str = "6:" + InputOutputUtils.INSTANCE.convertForSending(strConstructV6Token$vungle_ads_release);
                companion.d(TAG, "After conversion: " + str);
                return new BiddingTokenInfo(str, "");
            } catch (Throwable th) {
                String str2 = "Fail to gzip token data. " + th.getLocalizedMessage();
                new GzipEncodeError(str2).logErrorNoReturnValue$vungle_ads_release();
                return new BiddingTokenInfo("", str2);
            }
        } catch (Throwable th2) {
            String str3 = "Failed to encode TokenParameters. " + th2.getLocalizedMessage();
            new JsonEncodeError(str3).logErrorNoReturnValue$vungle_ads_release();
            return new BiddingTokenInfo("", str3);
        }
    }

    @VisibleForTesting
    public final String constructV6Token$vungle_ads_release() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        CommonRequestBody commonRequestBodyRequestBody = m3311constructV6Token$lambda0(b.B(g.f13494a, new BidTokenEncoder$constructV6Token$$inlined$inject$1(this.context))).requestBody(!r1.signalsDisabled(), ConfigManager.INSTANCE.fpdEnabled());
        RtbToken rtbToken = new RtbToken(commonRequestBodyRequestBody.getDevice(), commonRequestBodyRequestBody.getUser(), commonRequestBodyRequestBody.getExt(), new RtbRequest(VungleHeader.INSTANCE.getHeaderUa()), this.ordinalView);
        c cVar = this.json;
        return cVar.b(q.q0(cVar.f11599b, b0.b(RtbToken.class)), rtbToken);
    }

    public final BiddingTokenInfo encode() {
        this.ordinalView++;
        return generateBidToken();
    }

    public final long getEnterBackgroundTime$vungle_ads_release() {
        return this.enterBackgroundTime;
    }

    public final int getOrdinalView$vungle_ads_release() {
        return this.ordinalView;
    }

    @VisibleForTesting(otherwise = 2)
    public final void onPause$vungle_ads_release() {
        Logger.Companion.d(TAG, "BidTokenEncoder#onBackground()");
        this.enterBackgroundTime = System.currentTimeMillis();
    }

    @VisibleForTesting(otherwise = 2)
    public final void onResume$vungle_ads_release() {
        Logger.Companion.d(TAG, "BidTokenEncoder#onForeground()");
        if (System.currentTimeMillis() > this.enterBackgroundTime + ConfigManager.INSTANCE.getSessionTimeout()) {
            this.ordinalView = 0;
            this.enterBackgroundTime = 0L;
        }
    }

    public final void setEnterBackgroundTime$vungle_ads_release(long j) {
        this.enterBackgroundTime = j;
    }

    public final void setOrdinalView$vungle_ads_release(int i2) {
        this.ordinalView = i2;
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getEnterBackgroundTime$vungle_ads_release$annotations() {
    }

    private static /* synthetic */ void getJson$annotations() {
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getOrdinalView$vungle_ads_release$annotations() {
    }
}
