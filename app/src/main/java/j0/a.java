package j0;

import android.util.Log;
import com.cbt.exam.browser.activity.BaseActivity;
import com.mimikridev.ads.appopen.AppOpenAd;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.ads.gdpr.GDPR;
import com.mimikridev.ads.initialization.InitializeAd;
import com.mimikridev.ads.interstitial.InterstitialAd;
import com.mimikridev.ads.nativead.NativeAd;
import com.mimikridev.ads.rewarded.RewardedAd;
import com.mimikridev.ads.util.Constant;
import com.mimikridev.utilmanager.config.SharedPrefConfig;
import com.mimikridev.utilmanager.config.b;
import java.lang.ref.WeakReference;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f12047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPrefConfig f12048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InitializeAd f12049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GDPR f12050d;
    public AppOpenAd e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BannerAd f12051f;
    public InterstitialAd g;
    public RewardedAd h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NativeAd f12052i;
    public int j;

    public static boolean c(long j) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public final void a() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        long lastRewardTime = sharedPrefConfig.getLastRewardTime();
        int rewardCountToday = sharedPrefConfig.getRewardCountToday();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!c(lastRewardTime)) {
            rewardCountToday = 0;
            sharedPrefConfig.setRewardCountToday(0);
        }
        if (rewardCountToday >= sharedPrefConfig.getMaxRewardPerDay() || jCurrentTimeMillis - lastRewardTime <= 7200000) {
            return;
        }
        Log.d("AdNetwork_admanager", "Loading Rewarded Ad...");
        Log.d("AdNetwork_admanager", "Loading preloadRewarded Ad...");
        RewardedAd rewardedAd = this.h;
        if (rewardedAd != null) {
            rewardedAd.setAdStatus(sharedPrefConfig.getAd_status()).setMainAds(sharedPrefConfig.getAd_type()).setBackupAds(sharedPrefConfig.getBackup_ads()).setAdMobRewardedId(sharedPrefConfig.getAdmob_reward_id()).setIronSourceRewardedId(sharedPrefConfig.getIronsource_reward_id()).setPangleRewardedId(sharedPrefConfig.getPangle_reward_id()).build(null, null);
        }
        Log.d("AdNetwork_admanager", "Reward loade. Count today: " + (rewardCountToday + 1));
    }

    public final void b() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        long lastRewardTime = sharedPrefConfig.getLastRewardTime();
        int rewardCountToday = sharedPrefConfig.getRewardCountToday();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!c(lastRewardTime)) {
            rewardCountToday = 0;
            sharedPrefConfig.setRewardCountToday(0);
        }
        if (rewardCountToday >= sharedPrefConfig.getMaxRewardPerDay() || jCurrentTimeMillis - lastRewardTime <= 7200000) {
            Log.d("AdNetwork_admanager", "Reward limit reached, showing Interstitial instead...");
            InterstitialAd interstitialAd = this.g;
            if (interstitialAd != null) {
                interstitialAd.show();
                return;
            }
            return;
        }
        Log.d("AdNetwork_admanager", "Showing Rewarded Ad...");
        RewardedAd rewardedAd = this.h;
        if (rewardedAd != null) {
            rewardedAd.show(new b(6), new b(7), new b(8));
        }
        sharedPrefConfig.setLastRewardTime(jCurrentTimeMillis);
        int i2 = rewardCountToday + 1;
        sharedPrefConfig.setRewardCountToday(i2);
        Log.d("AdNetwork_admanager", "Reward shown. Count today: " + i2);
    }

    public final void d() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        BannerAd bannerAd = this.f12051f;
        if (bannerAd != null) {
            bannerAd.setAdStatus(sharedPrefConfig.getAd_status()).setAdNetwork(sharedPrefConfig.getAd_type()).setBackupAdNetwork(sharedPrefConfig.getBackup_ads()).setAdMobBannerId(sharedPrefConfig.getAdmob_banner_id()).setFanBannerId(sharedPrefConfig.getFan_banner_id()).setIronSourceBannerId(sharedPrefConfig.getIronsource_banner_id()).setPangleBannerId(sharedPrefConfig.getPangle_banner_id()).setIsCollapsibleBanner(false).setDarkTheme(false).build();
        }
    }

    public final void e() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        Log.d("AdNetwork_admanager", "Loading preloadInterstitial Ad...");
        InterstitialAd interstitialAd = this.g;
        if (interstitialAd != null) {
            interstitialAd.setAdStatus(sharedPrefConfig.getAd_status()).setAdNetwork(sharedPrefConfig.getAd_type()).setBackupAdNetwork(sharedPrefConfig.getBackup_ads()).setAdMobInterstitialId(sharedPrefConfig.getAdmob_inter_id()).setFanInterstitialId(sharedPrefConfig.getFan_inter_id()).setIronSourceInterstitialId(sharedPrefConfig.getIronsource_inter_id()).setPangleInterstitialId(sharedPrefConfig.getPangle_inter_id()).setInterval(1).build();
        }
    }

    public final void f() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        if (!sharedPrefConfig.getAd_status().equals("1") || sharedPrefConfig.getIronsource_banner_id().equals("0")) {
            return;
        }
        if (sharedPrefConfig.getAd_type().equals(Constant.IRONSOURCE) || sharedPrefConfig.getBackup_ads().equals(Constant.IRONSOURCE)) {
            d();
        }
    }

    public final void g() {
        SharedPrefConfig sharedPrefConfig = this.f12048b;
        int interAdInterval = sharedPrefConfig.getInterAdInterval();
        int i2 = this.j;
        if (i2 == interAdInterval) {
            InterstitialAd interstitialAd = this.g;
            if (interstitialAd != null) {
                interstitialAd.show();
            }
            this.j = 1;
            sharedPrefConfig.setAd_counter(1);
        } else {
            int i8 = i2 + 1;
            this.j = i8;
            sharedPrefConfig.setAd_counter(i8);
        }
        if (this.j > interAdInterval) {
            sharedPrefConfig.setAd_counter(1);
        }
        Log.d("AdNetwork_admanager", "Counter " + this.j);
    }

    public final void h(BaseActivity baseActivity) {
        this.f12047a = new WeakReference(baseActivity);
        BannerAd bannerAd = this.f12051f;
        if (bannerAd != null) {
            bannerAd.updateActivity(baseActivity);
        }
        NativeAd nativeAd = this.f12052i;
        if (nativeAd != null) {
            nativeAd.updateActivity(baseActivity);
        }
    }
}
