package com.google.ads.mediation.ironsource;

import a1.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import com.unity3d.ironsourceads.IronSourceAds;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceMediationAdapter extends RtbAdapter {
    public static final String ADAPTER_ERROR_DOMAIN = "com.google.ads.mediation.ironsource";
    public static final int ERROR_AD_ALREADY_LOADED = 103;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 105;
    public static final int ERROR_CALL_SHOW_BEFORE_LOADED_SUCCESS = 107;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 102;
    public static final int ERROR_SDK_NOT_INITIALIZED = 106;
    public static final String IRONSOURCE_SDK_ERROR_DOMAIN = "com.ironsource.mediationsdk";
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull SignalCallbacks signalCallbacks) {
        signalCallbacks.onSuccess(IronSource.getISDemandOnlyBiddingData(rtbSignalData.getContext()));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String sdkVersion = IronSourceAds.getSdkVersion();
        String[] strArrSplit = sdkVersion.split("\\.");
        if (strArrSplit.length < 3) {
            Log.w(IronSourceConstants.TAG, a.m("Unexpected SDK version format: ", sdkVersion, ". Returning 0.0.0 for SDK version."));
            return new VersionInfo(0, 0, 0);
        }
        int i2 = Integer.parseInt(strArrSplit[0]);
        int i8 = Integer.parseInt(strArrSplit[1]);
        int i9 = Integer.parseInt(strArrSplit[2]);
        if (strArrSplit.length >= 4) {
            i9 = (i9 * 100) + Integer.parseInt(strArrSplit[3]);
        }
        return new VersionInfo(i2, i8, i9);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        String adapterVersion = IronSourceAdapterUtils.getAdapterVersion();
        String[] strArrSplit = adapterVersion.split("\\.");
        if (strArrSplit.length < 4) {
            Log.w(IronSourceConstants.TAG, a.m("Unexpected adapter version format: ", adapterVersion, ". Returning 0.0.0 for adapter version."));
            return new VersionInfo(0, 0, 0);
        }
        int i2 = Integer.parseInt(strArrSplit[0]);
        int i8 = Integer.parseInt(strArrSplit[1]);
        int i9 = Integer.parseInt(strArrSplit[3]) + (Integer.parseInt(strArrSplit[2]) * 100);
        if (strArrSplit.length >= 5) {
            i9 = (i9 * 100) + Integer.parseInt(strArrSplit[4]);
        }
        return new VersionInfo(i2, i8, i9);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull final InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) {
        if (isInitialized.get()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("appKey");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size <= 0) {
            initializationCompleteCallback.onInitializationFailed(new AdError(101, "Missing or invalid app key.", "com.google.ads.mediation.ironsource").getMessage());
            return;
        }
        String str = (String) hashSet.iterator().next();
        if (TextUtils.isEmpty(str)) {
            initializationCompleteCallback.onInitializationFailed(new AdError(101, "Missing or invalid app key.", "com.google.ads.mediation.ironsource").getMessage());
            return;
        }
        if (size > 1) {
            Log.w(IronSourceConstants.TAG, String.format("Multiple '%s' entries found: %s. Using app key '%s' to initialize the IronSource SDK.", "appKey", hashSet, str));
        }
        IronSource.setMediationType(IronSourceAdapterUtils.getMediationType());
        Log.d(IronSourceConstants.TAG, "Initializing IronSource SDK with app key: " + str);
        IronSourceAds.init(context, new InitRequest.Builder(str).withLegacyAdFormats(new ArrayList(Arrays.asList(IronSourceAds.AdFormat.BANNER, IronSourceAds.AdFormat.INTERSTITIAL, IronSourceAds.AdFormat.REWARDED))).build(), new InitListener() { // from class: com.google.ads.mediation.ironsource.IronSourceMediationAdapter.1
            @Override // com.unity3d.ironsourceads.InitListener
            public void onInitFailed(@NonNull IronSourceError ironSourceError) {
                initializationCompleteCallback.onInitializationFailed(ironSourceError.getErrorMessage());
            }

            @Override // com.unity3d.ironsourceads.InitListener
            public void onInitSuccess() {
                IronSourceMediationAdapter.isInitialized.set(true);
                initializationCompleteCallback.onInitializationSucceeded();
            }
        });
        IronSource.setISDemandOnlyInterstitialListener(IronSourceInterstitialAd.getIronSourceInterstitialListener());
        IronSource.setISDemandOnlyRewardedVideoListener(IronSourceRewardedAd.getIronSourceRewardedListener());
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        if (isInitialized.get()) {
            new IronSourceBannerAd(mediationAdLoadCallback).loadAd(mediationBannerAdConfiguration);
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource banner ad since IronSource SDK is not initialized.", IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(IronSourceConstants.TAG, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (isInitialized.get()) {
            new IronSourceInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback).loadWaterfallAd(mediationInterstitialAdConfiguration);
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource interstitial ad since IronSource SDK is not initialized.", IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(IronSourceConstants.TAG, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (isInitialized.get()) {
            new IronSourceRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback).loadWaterfallAd(mediationRewardedAdConfiguration);
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource rewarded ad since IronSource SDK is not initialized.", "com.google.ads.mediation.ironsource");
        Log.w(IronSourceConstants.TAG, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(IronSourceConstants.TAG, "IronSource adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from IronSource.");
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        new IronSourceRtbBannerAd(mediationAdLoadCallback).loadRtbAd(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        new IronSourceRtbInterstitialAd(mediationAdLoadCallback).loadRtbAd(mediationInterstitialAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        new IronSourceRtbRewardedAd(mediationAdLoadCallback).loadRtbAd(mediationRewardedAdConfiguration);
    }

    @VisibleForTesting
    public void setIsInitialized(boolean z2) {
        isInitialized.set(z2);
    }
}
