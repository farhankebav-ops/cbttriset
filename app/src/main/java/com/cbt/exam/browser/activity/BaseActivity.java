package com.cbt.exam.browser.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.mimikridev.ads.appopen.AppOpenAd;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.ads.gdpr.GDPR;
import com.mimikridev.ads.initialization.InitializeAd;
import com.mimikridev.ads.interstitial.InterstitialAd;
import com.mimikridev.ads.nativead.NativeAd;
import com.mimikridev.ads.nativead.NativeAdView;
import com.mimikridev.ads.rewarded.RewardedAd;
import com.mimikridev.utilmanager.config.SharedPrefConfig;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0.a f5124a;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean zIsAdReady;
        super.onCreate(bundle);
        MyApplication myApplication = (MyApplication) getApplication();
        j0.a adsManager = myApplication.getAdsManager();
        this.f5124a = adsManager;
        boolean zIsAdReady2 = false;
        if (adsManager == null) {
            j0.a aVar = new j0.a();
            aVar.j = 1;
            aVar.f12047a = new WeakReference(this);
            SharedPrefConfig sharedPrefConfig = new SharedPrefConfig(this);
            aVar.f12048b = sharedPrefConfig;
            this.f5124a = aVar;
            Activity activity = (Activity) aVar.f12047a.get();
            if (activity != null) {
                aVar.f12049c = new InitializeAd(activity);
                aVar.f12050d = new GDPR(activity);
                aVar.e = new AppOpenAd(activity);
                aVar.f12051f = new BannerAd(activity);
                aVar.g = new InterstitialAd(activity);
                aVar.h = new RewardedAd(activity);
                aVar.f12052i = new NativeAd(activity);
                new NativeAdView(activity);
                aVar.j = sharedPrefConfig.getAd_counter();
                aVar.f12049c.setAdStatus(sharedPrefConfig.getAd_status()).setAdNetwork(sharedPrefConfig.getAd_type()).setBackupAdNetwork(sharedPrefConfig.getBackup_ads()).setIronSourceAppKey(sharedPrefConfig.getIronsource_app_id()).setPangleAppId(sharedPrefConfig.getPangle_app_id()).setDebug(false).build();
                aVar.f12050d.updateGDPRConsentStatus(sharedPrefConfig.getAd_type(), false, false);
            }
            this.f5124a.e();
            this.f5124a.a();
            myApplication.setAdsManager(this.f5124a);
            Log.d("AdNetwork", "Created new AdsManager instance");
            return;
        }
        adsManager.h(this);
        try {
            j0.a aVar2 = this.f5124a;
            if (aVar2.g == null) {
                zIsAdReady = false;
            } else {
                Log.d("AdNetwork_admanager", "InterstitialReady : " + aVar2.g.isAdReady());
                zIsAdReady = aVar2.g.isAdReady();
            }
            if (!zIsAdReady) {
                this.f5124a.e();
            }
            try {
                j0.a aVar3 = this.f5124a;
                if (aVar3.h != null) {
                    Log.d("AdNetwork_admanager", "isRewardReady : " + aVar3.h.isAdReady());
                    zIsAdReady2 = aVar3.h.isAdReady();
                }
                if (zIsAdReady2) {
                    return;
                }
                this.f5124a.a();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
