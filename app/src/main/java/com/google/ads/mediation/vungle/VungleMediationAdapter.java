package com.google.ads.mediation.vungle;

import a1.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.rtb.VungleRtbAppOpenAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbBannerAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbInterstitialAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbNativeAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbRewardedAd;
import com.google.ads.mediation.vungle.waterfall.VungleWaterfallAppOpenAd;
import com.google.ads.mediation.vungle.waterfall.VungleWaterfallBannerAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BaseAd;
import com.vungle.ads.RewardedAd;
import com.vungle.ads.RewardedAdListener;
import com.vungle.ads.VungleError;
import com.vungle.mediation.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class VungleMediationAdapter extends RtbAdapter implements MediationRewardedAd, RewardedAdListener {
    public static final int ERROR_CANNOT_GET_BID_TOKEN = 108;
    public static final int ERROR_CANNOT_PLAY_AD = 107;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.vungle";
    public static final int ERROR_INITIALIZATION_FAILURE = 105;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final String TAG = "VungleMediationAdapter";
    public static final String VUNGLE_SDK_ERROR_DOMAIN = "com.vungle.ads";
    private AdConfig adConfig;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private MediationRewardedAdCallback mediationRewardedAdCallback;
    private RewardedAd rewardedAd;
    private VungleRtbAppOpenAd rtbAppOpenAd;
    private VungleRtbBannerAd rtbBannerAd;
    private VungleRtbInterstitialAd rtbInterstitialAd;
    private VungleRtbNativeAd rtbNativeAd;
    private VungleRtbRewardedAd rtbRewardedAd;
    private VungleRtbRewardedAd rtbRewardedInterstitialAd;
    private String userId;
    private final VungleFactory vungleFactory;
    private VungleWaterfallAppOpenAd waterfallAppOpenAd;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public VungleMediationAdapter() {
        this.vungleFactory = new VungleFactory();
    }

    @NonNull
    public static AdError getAdError(@NonNull VungleError vungleError) {
        return new AdError(vungleError.getCode(), vungleError.getErrorMessage(), "com.vungle.ads");
    }

    public static String getAdapterVersion() {
        return BuildConfig.ADAPTER_VERSION;
    }

    private static boolean isVersionGreaterThanOrEqualTo(VersionInfo versionInfo, VersionInfo versionInfo2) {
        if (versionInfo.getMajorVersion() > versionInfo2.getMajorVersion()) {
            return true;
        }
        if (versionInfo.getMajorVersion() == versionInfo2.getMajorVersion()) {
            if (versionInfo.getMinorVersion() > versionInfo2.getMinorVersion()) {
                return true;
            }
            if (versionInfo.getMinorVersion() == versionInfo2.getMinorVersion() && versionInfo.getMicroVersion() >= versionInfo2.getMicroVersion()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVersionLowerThan(VersionInfo versionInfo, VersionInfo versionInfo2) {
        if (versionInfo.getMajorVersion() < versionInfo2.getMajorVersion()) {
            return true;
        }
        if (versionInfo.getMajorVersion() == versionInfo2.getMajorVersion()) {
            if (versionInfo.getMinorVersion() < versionInfo2.getMinorVersion()) {
                return true;
            }
            if (versionInfo.getMinorVersion() == versionInfo2.getMinorVersion() && versionInfo.getMicroVersion() < versionInfo2.getMicroVersion()) {
                return true;
            }
        }
        return false;
    }

    public static boolean runtimeGmaSdkListensToAdapterReportedImpressions() {
        VersionInfo version = MobileAds.getVersion();
        if (isVersionLowerThan(version, new VersionInfo(6, 5, 0)) && isVersionGreaterThanOrEqualTo(version, new VersionInfo(0, 18, 0))) {
            return true;
        }
        return isVersionGreaterThanOrEqualTo(version, new VersionInfo(24, 4, 0));
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull SignalCallbacks signalCallbacks) {
        String biddingToken = VungleSdkWrapper.delegate.getBiddingToken(rtbSignalData.getContext());
        if (TextUtils.isEmpty(biddingToken)) {
            AdError adError = new AdError(108, "Liftoff Monetize returned an empty bid token.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            signalCallbacks.onFailure(adError);
        } else {
            Log.d(TAG, "Liftoff Monetize bidding token=" + biddingToken);
            signalCallbacks.onSuccess(biddingToken);
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String sdkVersion = VungleSdkWrapper.delegate.getSdkVersion();
        String[] strArrSplit = sdkVersion.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, a.m("Unexpected SDK version format: ", sdkVersion, ". Returning 0.0.0 for SDK version."));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        String adapterVersion = getAdapterVersion();
        String[] strArrSplit = adapterVersion.split("\\.");
        if (strArrSplit.length < 4) {
            Log.w(TAG, a.m("Unexpected adapter version format: ", adapterVersion, ". Returning 0.0.0 for adapter version."));
            return new VersionInfo(0, 0, 0);
        }
        return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[3]) + (Integer.parseInt(strArrSplit[2]) * 100));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull final InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) {
        if (VungleSdkWrapper.delegate.isInitialized()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("appid");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            String str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the Vungle SDK.", "appid", hashSet, str));
            }
            VungleInitializer.getInstance().initialize(str, context, new VungleInitializer.VungleInitializationListener() { // from class: com.google.ads.mediation.vungle.VungleMediationAdapter.1
                @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
                public void onInitializeError(AdError adError) {
                    Log.w(VungleMediationAdapter.TAG, adError.toString());
                    initializationCompleteCallback.onInitializationFailed(adError.toString());
                }

                @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
                public void onInitializeSuccess() {
                    initializationCompleteCallback.onInitializationSucceeded();
                }
            });
            return;
        }
        if (initializationCompleteCallback != null) {
            AdError adError = new AdError(101, "Missing or Invalid App ID.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            initializationCompleteCallback.onInitializationFailed(adError.toString());
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadAppOpenAd(@NonNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NonNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        VungleInitializer.getInstance().updateCoppaStatus(mediationAppOpenAdConfiguration.taggedForChildDirectedTreatment());
        VungleWaterfallAppOpenAd vungleWaterfallAppOpenAd = new VungleWaterfallAppOpenAd(mediationAdLoadCallback, this.vungleFactory);
        this.waterfallAppOpenAd = vungleWaterfallAppOpenAd;
        vungleWaterfallAppOpenAd.render(mediationAppOpenAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        VungleInitializer.getInstance().updateCoppaStatus(mediationBannerAdConfiguration.taggedForChildDirectedTreatment());
        new VungleWaterfallBannerAd(mediationAdLoadCallback, this.vungleFactory).validateParamsAndLoadAd(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadNativeAd(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadNativeAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbNativeAd vungleRtbNativeAd = new VungleRtbNativeAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbNativeAd = vungleRtbNativeAd;
        vungleRtbNativeAd.render(mediationNativeAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        Bundle mediationExtras = mediationRewardedAdConfiguration.getMediationExtras();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        if (mediationExtras != null) {
            this.userId = mediationExtras.getString("userId");
        }
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load waterfall rewarded ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            mediationAdLoadCallback.onFailure(adError);
            return;
        }
        final String string2 = serverParameters.getString(VungleConstants.KEY_PLACEMENT_ID);
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load waterfall rewarded ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", ERROR_DOMAIN);
            Log.w(TAG, adError2.toString());
            mediationAdLoadCallback.onFailure(adError2);
            return;
        }
        this.adConfig = this.vungleFactory.createAdConfig();
        if (mediationExtras != null && mediationExtras.containsKey(VungleConstants.KEY_ORIENTATION)) {
            this.adConfig.setAdOrientation(mediationExtras.getInt(VungleConstants.KEY_ORIENTATION, 2));
        }
        VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        final Context context = mediationRewardedAdConfiguration.getContext();
        VungleInitializer.getInstance().initialize(string, context, new VungleInitializer.VungleInitializationListener() { // from class: com.google.ads.mediation.vungle.VungleMediationAdapter.2
            @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
            public void onInitializeError(AdError adError3) {
                Log.w(VungleMediationAdapter.TAG, adError3.toString());
                VungleMediationAdapter.this.mediationAdLoadCallback.onFailure(adError3);
            }

            @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
            public void onInitializeSuccess() {
                VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                vungleMediationAdapter.rewardedAd = vungleMediationAdapter.vungleFactory.createRewardedAd(context, string2, VungleMediationAdapter.this.adConfig);
                VungleMediationAdapter.this.rewardedAd.setAdListener(VungleMediationAdapter.this);
                if (!TextUtils.isEmpty(VungleMediationAdapter.this.userId)) {
                    VungleMediationAdapter.this.rewardedAd.setUserId(VungleMediationAdapter.this.userId);
                }
                VungleMediationAdapter.this.rewardedAd.load(null);
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        String str = TAG;
        Log.d(str, "loadRewardedInterstitialAd()...");
        Log.d(str, "Liftoff Monetize adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Liftoff Monetize.");
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbAppOpenAd(@NonNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NonNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        VungleInitializer.getInstance().updateCoppaStatus(mediationAppOpenAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbAppOpenAd vungleRtbAppOpenAd = new VungleRtbAppOpenAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbAppOpenAd = vungleRtbAppOpenAd;
        vungleRtbAppOpenAd.render(mediationAppOpenAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbBannerAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationBannerAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbBannerAd vungleRtbBannerAd = new VungleRtbBannerAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbBannerAd = vungleRtbBannerAd;
        vungleRtbBannerAd.validateParamsAndLoadAd(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbInterstitialAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationInterstitialAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbInterstitialAd vungleRtbInterstitialAd = new VungleRtbInterstitialAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbInterstitialAd = vungleRtbInterstitialAd;
        vungleRtbInterstitialAd.render(mediationInterstitialAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbNativeAd(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbNativeAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbNativeAd vungleRtbNativeAd = new VungleRtbNativeAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbNativeAd = vungleRtbNativeAd;
        vungleRtbNativeAd.render(mediationNativeAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbRewardedAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbRewardedAd vungleRtbRewardedAd = new VungleRtbRewardedAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbRewardedAd = vungleRtbRewardedAd;
        vungleRtbRewardedAd.render(mediationRewardedAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        String str = TAG;
        Log.d(str, "loadRtbRewardedInterstitialAd()...");
        Log.d(str, "Liftoff Monetize adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Liftoff Monetize.");
        VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        VungleRtbRewardedAd vungleRtbRewardedAd = new VungleRtbRewardedAd(mediationAdLoadCallback, this.vungleFactory);
        this.rtbRewardedInterstitialAd = vungleRtbRewardedAd;
        vungleRtbRewardedAd.render(mediationRewardedAdConfiguration);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(@NonNull BaseAd baseAd) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad was clicked.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(@NonNull BaseAd baseAd) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad has ended.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        AdError adError = getAdError(vungleError);
        Log.w(TAG, "Failed to load waterfall rewarded ad from Liftoff Monetize with error: " + adError.toString());
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        AdError adError = getAdError(vungleError);
        Log.w(TAG, "Failed to play waterfall rewarded ad from Liftoff Monetize with error: " + adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(@NonNull BaseAd baseAd) {
        this.mediationRewardedAdCallback.onVideoStart();
        this.mediationRewardedAdCallback.reportAdImpression();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(@NonNull BaseAd baseAd) {
        Log.d(TAG, "Loaded waterfall rewarded ad from Liftoff Monetize.");
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mediationRewardedAdCallback = mediationAdLoadCallback.onSuccess(this);
        }
    }

    @Override // com.vungle.ads.RewardedAdListener
    public void onAdRewarded(@NonNull BaseAd baseAd) {
        Log.d(TAG, "Received reward from Liftoff Monetize waterfall rewarded ad.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            this.mediationRewardedAdCallback.onUserEarnedReward();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(@NonNull BaseAd baseAd) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad has started.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        RewardedAd rewardedAd = this.rewardedAd;
        if (rewardedAd != null) {
            rewardedAd.play(context);
        } else if (this.mediationRewardedAdCallback != null) {
            AdError adError = new AdError(107, "Failed to show waterfall rewarded ad from Liftoff Monetize.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            this.mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    @VisibleForTesting
    public VungleMediationAdapter(VungleFactory vungleFactory) {
        this.vungleFactory = vungleFactory;
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(@NonNull BaseAd baseAd) {
    }
}
