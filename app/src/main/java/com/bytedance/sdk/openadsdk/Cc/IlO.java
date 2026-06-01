package com.bytedance.sdk.openadsdk.Cc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.oc;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IlO.Cc.MY;
import com.bytedance.sdk.openadsdk.IlO.MY.Cc;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.Bc;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements IADTypeLoaderFactory {
    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new IADLoader<PAGBannerRequest, PAGBannerAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.2
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, final PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(str, pAGBannerRequest, pAGBannerAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(codeId, pAGBannerRequest);
                if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                    codeId.withBid(pAGBannerRequest.getAdString());
                }
                final PAGBannerSize adSize = pAGBannerRequest.getAdSize();
                if (adSize != null) {
                    if (adSize.getType() == 3) {
                        codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getMaxHeight());
                    } else {
                        codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getHeight());
                    }
                    codeId.setBannerType(adSize.getType());
                }
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
                final com.bytedance.sdk.openadsdk.IlO.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.IlO.IlO.IlO(pAGBannerAdLoadListener);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(new lEW("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!cl.tV().ea() && zLG.oeT()) {
                            ilO.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(ilO)) {
                            return;
                        }
                        PAGBannerSize pAGBannerSize = adSize;
                        if (pAGBannerSize != null && ((pAGBannerSize.getType() == 2 || adSize.getType() == 3) && TextUtils.isEmpty(pAGBannerRequest.getAdString()))) {
                            int iTV = BS.tV(cl.IlO());
                            int iVCE = BS.vCE(cl.IlO());
                            int height = adSize.getType() == 2 ? adSize.getHeight() : adSize.getMaxHeight();
                            if (adSize.getWidth() > iTV || adSize.getWidth() <= 0 || height > iVCE || height < 0) {
                                ilO.onError(-19, "The banner size invalid width=" + adSize.getWidth() + ",height=" + height);
                                return;
                            }
                        }
                        AdSlot adSlot = adSlotBuild;
                        if (adSlot == null) {
                            ilO.onError(-4, "adslot is null");
                            return;
                        }
                        adSlot.setNativeAdType(1);
                        adSlotBuild.setDurationSlotType(1);
                        Bc.IlO(cl.IlO()).IlO(adSlotBuild, 1, ilO);
                    }
                }, ilO, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.5
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(codeId, pAGInterstitialRequest);
                if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                    codeId.withBid(pAGInterstitialRequest.getAdString());
                }
                final AdSlot adSlotBuild = codeId.build();
                final com.bytedance.sdk.openadsdk.IlO.EO.IlO ilO = new com.bytedance.sdk.openadsdk.IlO.EO.IlO(pAGInterstitialAdLoadListener);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(new lEW("loadInterstitialAd") { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!cl.tV().ea() && zLG.oeT()) {
                            ilO.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(ilO)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            ilO.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodIlO = oc.IlO("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                            if (methodIlO != null) {
                                methodIlO.invoke(null, cl.IlO(), adSlotBuild, ilO);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, ilO, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new IADLoader<PAGNativeRequest, PAGNativeAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.3
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(str, pAGNativeRequest, pAGNativeAdLoadListener)) {
                    return;
                }
                final Cc cc = new Cc(pAGNativeAdLoadListener);
                AdSlot.Builder builderWithBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(builderWithBid, pAGNativeRequest);
                final AdSlot adSlotBuild = builderWithBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(new lEW("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!cl.tV().ea() && zLG.oeT()) {
                            cc.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(cc)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            cc.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodIlO = oc.IlO("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                            if (methodIlO != null) {
                                methodIlO.invoke(null, cl.IlO(), adSlotBuild, cc);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, cc, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.1
            private int MY;

            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener)) {
                    return;
                }
                AdSlot.Builder builder = new AdSlot.Builder();
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(builder, pAGAppOpenRequest);
                if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                    builder.withBid(pAGAppOpenRequest.getAdString());
                }
                final AdSlot adSlotBuild = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
                this.MY = pAGAppOpenRequest.getTimeout();
                final com.bytedance.sdk.openadsdk.IlO.tV.IlO ilO = new com.bytedance.sdk.openadsdk.IlO.tV.IlO(pAGAppOpenAdLoadListener);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(new lEW("loadSplashAd") { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!cl.tV().ea() && zLG.oeT()) {
                                ilO.onError(-18, "Blind mode does not allow requesting ads");
                                return;
                            }
                            if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(ilO)) {
                                return;
                            }
                            if (adSlotBuild == null) {
                                ilO.onError(-4, "adslot is null");
                                return;
                            }
                            Method methodIlO = oc.IlO("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE);
                            if (methodIlO != null) {
                                methodIlO.invoke(null, cl.IlO(), adSlotBuild, ilO, Integer.valueOf(AnonymousClass1.this.MY));
                            }
                        } catch (Throwable th) {
                            oeT.IlO("ADNFactory", "open component maybe not exist, please check", th);
                        }
                    }
                }, ilO, adSlotBuild);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.4
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(str, pAGRewardedRequest, pAGRewardedAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                    codeId.withBid(pAGRewardedRequest.getAdString());
                }
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(codeId, pAGRewardedRequest);
                final AdSlot adSlotBuild = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                final MY my = new MY(pAGRewardedAdLoadListener);
                com.bytedance.sdk.openadsdk.IlO.IlO.IlO(new lEW("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.Cc.IlO.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!cl.tV().ea() && zLG.oeT()) {
                            my.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.IlO.IlO.IlO(my)) {
                            return;
                        }
                        if (adSlotBuild == null) {
                            my.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            Method methodIlO = oc.IlO("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                            if (methodIlO != null) {
                                methodIlO.invoke(null, cl.IlO(), adSlotBuild, my);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, my, adSlotBuild);
            }
        };
    }
}
