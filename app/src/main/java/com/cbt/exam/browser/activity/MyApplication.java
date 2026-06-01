package com.cbt.exam.browser.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import com.mimikridev.ads.appopen.AppOpenAd;
import com.mimikridev.ads.appopen.AppOpenAdMob;
import com.mimikridev.ads.appopen.AppOpenAdPangle;
import com.mimikridev.ads.listener.OnShowAdCompleteListener;
import com.mimikridev.utilmanager.config.SharedPrefConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MyApplication extends Application {
    private j0.a adsManager;
    AppOpenAd appOpenAds;
    SharedPrefConfig pref;
    LifecycleObserver lifecycleObserver = new c0(this);
    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new d0(this);

    private void initOpenAds() {
        registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.lifecycleObserver);
        this.appOpenAds = new AppOpenAd().initAppOpenAdMob(new AppOpenAdMob()).initAppOpenAdPangle(new AppOpenAdPangle()).setAdStatus(this.pref.getAd_status()).setAdNetwork(this.pref.getAd_type()).setBackupAdNetwork(this.pref.getBackup_ads()).setPlacementOnStart(true).setPlacementOnResume(false).setAdMobAppOpenId(this.pref.getAdmob_app_open_id()).setPangleAppOpenId(this.pref.getPangle_app_open_id());
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public j0.a getAdsManager() {
        return this.adsManager;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.pref = new SharedPrefConfig(this);
        initOpenAds();
    }

    public void setAdsManager(j0.a aVar) {
        this.adsManager = aVar;
    }

    public void showAdIfAvailable(@NonNull Activity activity, @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
        AppOpenAd appOpenAd = this.appOpenAds;
        if (appOpenAd != null) {
            appOpenAd.showAdIfAvailable(activity, onShowAdCompleteListener);
        } else {
            onShowAdCompleteListener.onShowAdComplete();
        }
    }
}
