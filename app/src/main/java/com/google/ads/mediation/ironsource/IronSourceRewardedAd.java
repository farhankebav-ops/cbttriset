package com.google.ads.mediation.ironsource;

import a1.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.ironsource.mediationsdk.IronSource;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceRewardedAd implements MediationRewardedAd {

    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<IronSourceRewardedAd>> availableInstances = new ConcurrentHashMap<>();
    private static final IronSourceRewardedAdListener ironSourceRewardedListener = new IronSourceRewardedAdListener();
    private final String instanceID;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private MediationRewardedAdCallback mediationRewardedAdCallback;

    public IronSourceRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.instanceID = mediationRewardedAdConfiguration.getServerParameters().getString("instanceId", "0");
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public static IronSourceRewardedAd getFromAvailableInstances(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<IronSourceRewardedAd>> concurrentHashMap = availableInstances;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    public static IronSourceRewardedAdListener getIronSourceRewardedListener() {
        return ironSourceRewardedListener;
    }

    private boolean isParamsValid(@NonNull Context context) {
        AdError adErrorValidateIronSourceAdLoadParams = IronSourceAdapterUtils.validateIronSourceAdLoadParams(context, this.instanceID);
        if (adErrorValidateIronSourceAdLoadParams != null) {
            onAdFailedToLoad(adErrorValidateIronSourceAdLoadParams);
            return false;
        }
        if (IronSourceAdapterUtils.canLoadIronSourceAdInstance(this.instanceID, availableInstances)) {
            return true;
        }
        onAdFailedToLoad(new AdError(103, a.l("An IronSource Rewarded ad is already loading for instance ID: ", this.instanceID), "com.google.ads.mediation.ironsource"));
        return false;
    }

    private boolean loadValidConfig(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        if (!isParamsValid(mediationRewardedAdConfiguration.getContext())) {
            return false;
        }
        availableInstances.put(this.instanceID, new WeakReference<>(this));
        Log.d(IronSourceConstants.TAG, "Loading IronSource rewarded ad with instance ID: " + this.instanceID);
        return true;
    }

    private void onAdFailedToLoad(@NonNull AdError adError) {
        Log.w(IronSourceConstants.TAG, adError.toString());
        this.mediationAdLoadCallback.onFailure(adError);
    }

    public static void removeFromAvailableInstances(@NonNull String str) {
        availableInstances.remove(str);
    }

    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> getMediationAdLoadCallback() {
        return this.mediationAdLoadCallback;
    }

    public MediationRewardedAdCallback getRewardedAdCallback() {
        return this.mediationRewardedAdCallback;
    }

    public void loadWaterfallAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        if (loadValidConfig(mediationRewardedAdConfiguration)) {
            IronSource.loadISDemandOnlyRewardedVideo((Activity) mediationRewardedAdConfiguration.getContext(), this.instanceID);
        }
    }

    public void setRewardedAdCallback(@NonNull MediationRewardedAdCallback mediationRewardedAdCallback) {
        this.mediationRewardedAdCallback = mediationRewardedAdCallback;
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        Log.d(IronSourceConstants.TAG, "Showing IronSource rewarded ad for instance ID: " + this.instanceID);
        IronSource.showISDemandOnlyRewardedVideo(this.instanceID);
    }
}
