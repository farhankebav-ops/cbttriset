package com.google.ads.mediation.ironsource;

import a1.a;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceBannerAd implements MediationBannerAd {

    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<IronSourceBannerAd>> availableBannerInstances = new ConcurrentHashMap<>();
    private static final IronSourceBannerAdListener ironSourceBannerListener = new IronSourceBannerAdListener();
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback;
    private MediationBannerAdCallback bannerAdCallback;
    private ISBannerSize bannerSizeIronSource;
    private FrameLayout ironSourceAdView;
    private ISDemandOnlyBannerLayout ironSourceBannerLayout;

    public IronSourceBannerAd(@NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.adLoadCallback = mediationAdLoadCallback;
    }

    public static void clearAllAvailableInstancesExceptOne(@NonNull String str) {
        for (String str2 : availableBannerInstances.keySet()) {
            if (!str2.equals(str)) {
                Log.d(IronSourceConstants.TAG, "IronSource Banner Destroy ad with instance ID: ".concat(str2));
                IronSource.destroyISDemandOnlyBanner(str2);
                removeFromAvailableInstances(str2);
            }
        }
    }

    public static IronSourceBannerAd getFromAvailableInstances(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<IronSourceBannerAd>> concurrentHashMap = availableBannerInstances;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    private boolean isParamsValid(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        String string = mediationBannerAdConfiguration.getServerParameters().getString("instanceId", "0");
        Context context = mediationBannerAdConfiguration.getContext();
        AdError adErrorValidateIronSourceAdLoadParams = IronSourceAdapterUtils.validateIronSourceAdLoadParams(context, string);
        if (adErrorValidateIronSourceAdLoadParams != null) {
            onAdFailedToLoad(adErrorValidateIronSourceAdLoadParams);
            return false;
        }
        if (!IronSourceAdapterUtils.canLoadIronSourceAdInstance(string, availableBannerInstances)) {
            onAdFailedToLoad(new AdError(103, a.l("An IronSource banner is already loaded for instance ID: ", string), "com.google.ads.mediation.ironsource"));
            return false;
        }
        AdSize adSize = mediationBannerAdConfiguration.getAdSize();
        ISBannerSize iSBannerSizeFromGoogleAdSize = IronSourceAdapterUtils.getISBannerSizeFromGoogleAdSize(context, adSize);
        this.bannerSizeIronSource = iSBannerSizeFromGoogleAdSize;
        if (iSBannerSizeFromGoogleAdSize != null) {
            return true;
        }
        onAdFailedToLoad(new AdError(105, "There is no matching IronSource banner ad size for Google ad size: " + adSize, "com.google.ads.mediation.ironsource"));
        return false;
    }

    private void onAdFailedToLoad(@NonNull AdError adError) {
        Log.w(IronSourceConstants.TAG, adError.toString());
        MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback = this.adLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    public static void removeFromAvailableInstances(@NonNull String str) {
        availableBannerInstances.remove(str);
    }

    public MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> getAdLoadCallback() {
        return this.adLoadCallback;
    }

    public MediationBannerAdCallback getBannerAdCallback() {
        return this.bannerAdCallback;
    }

    public FrameLayout getIronSourceAdView() {
        return this.ironSourceAdView;
    }

    public ISDemandOnlyBannerLayout getIronSourceBannerLayout() {
        return this.ironSourceBannerLayout;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.ironSourceAdView;
    }

    public void loadAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        if (isParamsValid(mediationBannerAdConfiguration)) {
            String string = mediationBannerAdConfiguration.getServerParameters().getString("instanceId", "0");
            Context context = mediationBannerAdConfiguration.getContext();
            Activity activity = (Activity) context;
            availableBannerInstances.put(string, new WeakReference<>(this));
            this.ironSourceAdView = new FrameLayout(context);
            ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutCreateBannerForDemandOnly = IronSource.createBannerForDemandOnly(activity, this.bannerSizeIronSource);
            this.ironSourceBannerLayout = iSDemandOnlyBannerLayoutCreateBannerForDemandOnly;
            iSDemandOnlyBannerLayoutCreateBannerForDemandOnly.setBannerDemandOnlyListener(ironSourceBannerListener);
            Log.d(IronSourceConstants.TAG, "Loading IronSource banner ad with instance ID: " + string);
            IronSource.loadISDemandOnlyBanner(activity, this.ironSourceBannerLayout, string);
        }
    }

    public void setBannerAdCallback(MediationBannerAdCallback mediationBannerAdCallback) {
        this.bannerAdCallback = mediationBannerAdCallback;
    }
}
