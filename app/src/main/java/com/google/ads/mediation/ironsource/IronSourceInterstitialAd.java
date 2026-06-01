package com.google.ads.mediation.ironsource;

import a1.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.ironsource.mediationsdk.IronSource;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceInterstitialAd implements MediationInterstitialAd {

    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<IronSourceInterstitialAd>> availableInterstitialInstances = new ConcurrentHashMap<>();
    private static final IronSourceInterstitialAdListener ironSourceInterstitialListener = new IronSourceInterstitialAdListener();
    private final String instanceID;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback;

    public IronSourceInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.instanceID = mediationInterstitialAdConfiguration.getServerParameters().getString("instanceId", "0");
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public static IronSourceInterstitialAd getFromAvailableInstances(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<IronSourceInterstitialAd>> concurrentHashMap = availableInterstitialInstances;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    public static IronSourceInterstitialAdListener getIronSourceInterstitialListener() {
        return ironSourceInterstitialListener;
    }

    private boolean isParamsValid(@NonNull Context context) {
        AdError adErrorValidateIronSourceAdLoadParams = IronSourceAdapterUtils.validateIronSourceAdLoadParams(context, this.instanceID);
        if (adErrorValidateIronSourceAdLoadParams != null) {
            onAdFailedToLoad(adErrorValidateIronSourceAdLoadParams);
            return false;
        }
        if (IronSourceAdapterUtils.canLoadIronSourceAdInstance(this.instanceID, availableInterstitialInstances)) {
            return true;
        }
        onAdFailedToLoad(new AdError(103, a.l("An IronSource interstitial ad is already loading for instance ID: ", this.instanceID), "com.google.ads.mediation.ironsource"));
        return false;
    }

    private boolean loadValidConfig(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        if (!isParamsValid(mediationInterstitialAdConfiguration.getContext())) {
            return false;
        }
        availableInterstitialInstances.put(this.instanceID, new WeakReference<>(this));
        Log.d(IronSourceConstants.TAG, "Loading IronSource interstitial ad with instance ID: " + this.instanceID);
        return true;
    }

    private void onAdFailedToLoad(@NonNull AdError adError) {
        Log.e(IronSourceConstants.TAG, adError.toString());
        MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    public static void removeFromAvailableInstances(@NonNull String str) {
        availableInterstitialInstances.remove(str);
    }

    public MediationInterstitialAdCallback getInterstitialAdCallback() {
        return this.interstitialAdCallback;
    }

    public MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> getMediationAdLoadCallback() {
        return this.mediationAdLoadCallback;
    }

    public void loadWaterfallAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        if (loadValidConfig(mediationInterstitialAdConfiguration)) {
            IronSource.loadISDemandOnlyInterstitial((Activity) mediationInterstitialAdConfiguration.getContext(), this.instanceID);
        }
    }

    public void setInterstitialAdCallback(@NonNull MediationInterstitialAdCallback mediationInterstitialAdCallback) {
        this.interstitialAdCallback = mediationInterstitialAdCallback;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        IronSource.showISDemandOnlyInterstitial(this.instanceID);
    }
}
