package com.ironsource;

import android.content.Context;
import android.os.Handler;
import com.ironsource.U8;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAd;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.ironsource.zf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2678zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final U8.a f10655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<TestSuiteActivity> f10656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f10657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference<LevelPlayBannerAdView> f10658d;
    private final AtomicReference<LevelPlayInterstitialAd> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<LevelPlayRewardedAd> f10659f;

    public C2678zf(TestSuiteActivity activity, Handler handler) {
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(handler, "handler");
        this.f10655a = Mb.f7131s.a().c();
        this.f10656b = new WeakReference<>(activity);
        this.f10657c = handler;
        this.f10658d = new AtomicReference<>();
        this.e = new AtomicReference<>();
        this.f10659f = new AtomicReference<>();
    }

    public final void a(Hf loadAdConfig) {
        kotlin.jvm.internal.k.e(loadAdConfig, "loadAdConfig");
        this.f10655a.a(loadAdConfig);
        AtomicReference<LevelPlayInterstitialAd> atomicReference = this.e;
        String strA = loadAdConfig.a();
        if (strA == null) {
            strA = "";
        }
        LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(strA);
        levelPlayInterstitialAd.setListener(new Ef());
        levelPlayInterstitialAd.loadAd();
        atomicReference.set(levelPlayInterstitialAd);
    }

    public final void b(Hf loadAdConfig) {
        kotlin.jvm.internal.k.e(loadAdConfig, "loadAdConfig");
        this.f10655a.a(loadAdConfig);
        AtomicReference<LevelPlayRewardedAd> atomicReference = this.f10659f;
        String strA = loadAdConfig.a();
        if (strA == null) {
            strA = "";
        }
        LevelPlayRewardedAd levelPlayRewardedAd = new LevelPlayRewardedAd(strA);
        levelPlayRewardedAd.setListener(new Nf());
        levelPlayRewardedAd.loadAd();
        atomicReference.set(levelPlayRewardedAd);
    }

    public final void e() {
        TestSuiteActivity testSuiteActivityB = b();
        if (testSuiteActivityB != null) {
            LevelPlayInterstitialAd levelPlayInterstitialAd = this.e.get();
            kotlin.jvm.internal.k.d(levelPlayInterstitialAd, "interstitialAdRef.get()");
            LevelPlayInterstitialAd.showAd$default(levelPlayInterstitialAd, testSuiteActivityB, null, 2, null);
        }
    }

    public final void f() {
        TestSuiteActivity testSuiteActivityB = b();
        if (testSuiteActivityB != null) {
            LevelPlayRewardedAd levelPlayRewardedAd = this.f10659f.get();
            kotlin.jvm.internal.k.d(levelPlayRewardedAd, "rewardedAdRef.get()");
            LevelPlayRewardedAd.showAd$default(levelPlayRewardedAd, testSuiteActivityB, null, 2, null);
        }
    }

    public final boolean c() {
        LevelPlayInterstitialAd levelPlayInterstitialAd = this.e.get();
        if (levelPlayInterstitialAd != null) {
            return levelPlayInterstitialAd.isAdReady();
        }
        return false;
    }

    public final boolean d() {
        LevelPlayRewardedAd levelPlayRewardedAd = this.f10659f.get();
        if (levelPlayRewardedAd != null) {
            return levelPlayRewardedAd.isAdReady();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView it) {
        kotlin.jvm.internal.k.e(testSuiteActivity, "$testSuiteActivity");
        kotlin.jvm.internal.k.e(it, "$it");
        testSuiteActivity.getContainer().removeView(it);
    }

    public final void a(Hf loadAdConfig, String description, int i2, int i8) {
        kotlin.jvm.internal.k.e(loadAdConfig, "loadAdConfig");
        kotlin.jvm.internal.k.e(description, "description");
        a();
        TestSuiteActivity testSuiteActivityB = b();
        if (testSuiteActivityB != null) {
            this.f10655a.a(loadAdConfig);
            LevelPlayBannerAdView.Config configBuild = new LevelPlayBannerAdView.Config.Builder().setAdSize(Kf.f7064a.b(description, i2, i8)).build();
            AtomicReference<LevelPlayBannerAdView> atomicReference = this.f10658d;
            String strA = loadAdConfig.a();
            if (strA == null) {
                strA = "";
            }
            LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(testSuiteActivityB, strA, configBuild);
            levelPlayBannerAdView.setBannerListener(new Af());
            levelPlayBannerAdView.pauseAutoRefresh();
            levelPlayBannerAdView.loadAd();
            atomicReference.set(levelPlayBannerAdView);
        }
    }

    private final TestSuiteActivity b() {
        return this.f10656b.get();
    }

    public final void a(double d8) {
        LevelPlayBannerAdView levelPlayBannerAdView;
        TestSuiteActivity testSuiteActivityB = b();
        if (testSuiteActivityB == null || (levelPlayBannerAdView = this.f10658d.get()) == null || levelPlayBannerAdView.getParent() != null) {
            return;
        }
        this.f10657c.post(new gj(testSuiteActivityB, levelPlayBannerAdView, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView banner) {
        kotlin.jvm.internal.k.e(testSuiteActivity, "$testSuiteActivity");
        kotlin.jvm.internal.k.e(banner, "$banner");
        testSuiteActivity.getContainer().addView(banner, Pf.f7396a.a((Context) testSuiteActivity));
    }

    public final void a() {
        LevelPlayBannerAdView andSet;
        TestSuiteActivity testSuiteActivityB = b();
        if (testSuiteActivityB == null || (andSet = this.f10658d.getAndSet(null)) == null) {
            return;
        }
        andSet.destroy();
        this.f10657c.post(new gj(testSuiteActivityB, andSet, 1));
    }
}
