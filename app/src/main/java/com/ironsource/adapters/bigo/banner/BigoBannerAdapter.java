package com.ironsource.adapters.bigo.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.internal.omsdk.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdSize;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.BannerAdLoader;
import sg.bigo.ads.api.BannerAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoBannerAdapter extends AbstractBannerAdapter<BigoAdapter> {
    private BigoBannerAdListener mAdListener;
    private BannerAdLoader mAdLoader;
    private BannerAd mBannerViewAd;
    private BannerSmashListener mSmashListener;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BigoAdapter.Companion.InitState.values().length];
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BigoAdapter.Companion.InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigoBannerAdapter(BigoAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
    }

    private final void destroyBannerViewAd() {
        postOnUIThread(new a(this, 11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBannerViewAd$lambda$0(BigoBannerAdapter this$0) {
        k.e(this$0, "this$0");
        BannerAd bannerAd = this$0.mBannerViewAd;
        if (bannerAd != null) {
            bannerAd.setAdInteractionListener(null);
        }
        BannerAd bannerAd2 = this$0.mBannerViewAd;
        if (bannerAd2 != null) {
            bannerAd2.destroy();
        }
        this$0.mBannerViewAd = null;
        this$0.mAdLoader = null;
    }

    private final AdSize getBannerSize(ISBannerSize iSBannerSize) {
        String description = iSBannerSize != null ? iSBannerSize.getDescription() : null;
        if (k.a(description, ISBannerSize.BANNER.getDescription())) {
            return AdSize.BANNER;
        }
        if (k.a(description, ISBannerSize.RECTANGLE.getDescription())) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (k.a(description, ISBannerSize.SMART.getDescription())) {
            return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? AdSize.LARGE_BANNER : AdSize.BANNER;
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        k.e(config, "config");
        IronLog.ADAPTER_API.verbose();
        destroyBannerViewAd();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public Map<String, Object> getBannerBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return getAdapter().getBiddingData$bigoadapter_release();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject config, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String configStringValueFromKey = getConfigStringValueFromKey(config, BigoAdapter.Companion.getAppIdKey());
        if (configStringValueFromKey.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), "Banner"));
            return;
        }
        this.mSmashListener = listener;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            listener.onBannerInitSuccess();
        } else if (i2 == 2 || i2 == 3) {
            getAdapter().initSdk(configStringValueFromKey);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject jSONObject, String str, ISBannerSize iSBannerSize, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (iSBannerSize == null) {
            IronLog.INTERNAL.error("banner size is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("serverData is empty");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("serverData is empty"));
            return;
        }
        AdSize bannerSize = getBannerSize(iSBannerSize);
        if (bannerSize == null) {
            listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        this.mAdListener = new BigoBannerAdListener(new WeakReference(this), listener, new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, bannerSize.getWidth()), AdapterUtils.dpToPixels(applicationContext, bannerSize.getHeight()), 17));
        BannerAdLoader.Builder builderWithAdLoadListener = new BannerAdLoader.Builder().withAdLoadListener((AdLoadListener<BannerAd>) this.mAdListener);
        BigoAdapter.Companion companion = BigoAdapter.Companion;
        BannerAdLoader bannerAdLoaderBuild = builderWithAdLoadListener.withExt(companion.getMEDIATION_INFO()).build();
        k.d(bannerAdLoaderBuild, "Builder().withAdLoadList…\n                .build()");
        this.mAdLoader = bannerAdLoaderBuild;
        bannerAdLoaderBuild.loadAd(new BannerAdRequest.Builder().withBid(str).withSlotId(getConfigStringValueFromKey(config, companion.getSlotIdKey())).withAdSizes(bannerSize).build());
    }

    public final void setBannerView$bigoadapter_release(BannerAd ad) {
        k.e(ad, "ad");
        ad.setAdInteractionListener(this.mAdListener);
        this.mBannerViewAd = ad;
    }
}
