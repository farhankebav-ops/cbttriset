package com.mimikridev.ads.appopen;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.ironsource.C2300e4;
import com.mimikridev.ads.listener.OnShowAdCompleteListener;
import com.mimikridev.ads.util.Constant;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AppOpenAd {
    public static final String TAG = "AppOpenAd";
    public static boolean isAppOpenAdLoaded = false;
    Activity activity;
    AppOpenAdManager appOpenAdManager;
    AppOpenAdMob appOpenAdMob;
    AppOpenAdPangle appOpenAdPangle;
    boolean placementOnResume;
    boolean placementOnStart;
    public com.google.android.gms.ads.appopen.AppOpenAd appOpenAd = null;
    public PAGAppOpenAd pangleAppOpenAd = null;
    private String adStatus = "";
    private String adNetwork = "";
    private String backupAdNetwork = "";
    private String adMobAppOpenId = "";
    private String adManagerAppOpenId = "";
    private String applovinAppOpenId = "";
    private String pangleAppOpenId = "";
    boolean withListener = false;

    /* JADX INFO: renamed from: com.mimikridev.ads.appopen.AppOpenAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 implements PAGAppOpenAdLoadListener {
        final /* synthetic */ OnShowAdCompleteListener val$onShowAdCompleteListener;
        final /* synthetic */ boolean val$withListener;

        public AnonymousClass2(boolean z2, OnShowAdCompleteListener onShowAdCompleteListener) {
            this.val$withListener = z2;
            this.val$onShowAdCompleteListener = onShowAdCompleteListener;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            AppOpenAd appOpenAd = AppOpenAd.this;
            appOpenAd.pangleAppOpenAd = null;
            AppOpenAd.isAppOpenAdLoaded = false;
            appOpenAd.loadBackupAppOpenAd(this.val$withListener, this.val$onShowAdCompleteListener);
            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] failed to load app open ad : " + str);
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
            AppOpenAd appOpenAd = AppOpenAd.this;
            appOpenAd.pangleAppOpenAd = pAGAppOpenAd;
            if (this.val$withListener) {
                appOpenAd.showAppOpenAd(this.val$onShowAdCompleteListener);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a(0), 2000L);
            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] app open ad loaded");
        }
    }

    /* JADX INFO: renamed from: com.mimikridev.ads.appopen.AppOpenAd$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass6 implements PAGAppOpenAdLoadListener {
        final /* synthetic */ OnShowAdCompleteListener val$onShowAdCompleteListener;
        final /* synthetic */ boolean val$withListener;

        public AnonymousClass6(boolean z2, OnShowAdCompleteListener onShowAdCompleteListener) {
            this.val$withListener = z2;
            this.val$onShowAdCompleteListener = onShowAdCompleteListener;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
        public void onError(int i2, String str) {
            AppOpenAd.this.pangleAppOpenAd = null;
            AppOpenAd.isAppOpenAdLoaded = false;
            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] failed to load app open ad : " + str);
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
            AppOpenAd appOpenAd = AppOpenAd.this;
            appOpenAd.pangleAppOpenAd = pAGAppOpenAd;
            if (this.val$withListener) {
                appOpenAd.showAppOpenAd(this.val$onShowAdCompleteListener);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a(1), 2000L);
            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] app open ad loaded");
        }
    }

    public AppOpenAd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAppOpenAd(final boolean z2, final OnShowAdCompleteListener onShowAdCompleteListener) {
        if (this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                PAGAppOpenRequest pAGAppOpenRequest = new PAGAppOpenRequest();
                pAGAppOpenRequest.setTimeout(3000);
                PAGAppOpenAd.loadAd(this.pangleAppOpenId, pAGAppOpenRequest, new AnonymousClass2(z2, onShowAdCompleteListener));
            } else {
                if (str.equals(Constant.ADMOB)) {
                    com.google.android.gms.ads.appopen.AppOpenAd.load(this.activity, this.adMobAppOpenId, new AdRequest.Builder().build(), new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAd.1
                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            AppOpenAd appOpenAd = AppOpenAd.this;
                            appOpenAd.appOpenAd = null;
                            AppOpenAd.isAppOpenAdLoaded = false;
                            appOpenAd.loadBackupAppOpenAd(z2, onShowAdCompleteListener);
                            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] Failed to Load App Open Ad: " + loadAdError.getMessage());
                        }

                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdLoaded(@NonNull com.google.android.gms.ads.appopen.AppOpenAd appOpenAd) {
                            AppOpenAd appOpenAd2 = AppOpenAd.this;
                            appOpenAd2.appOpenAd = appOpenAd;
                            AppOpenAd.isAppOpenAdLoaded = true;
                            if (z2) {
                                appOpenAd2.showAppOpenAd(onShowAdCompleteListener);
                            }
                            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] App Open Ad Loaded");
                        }
                    });
                    return;
                }
                loadBackupAppOpenAd(z2, onShowAdCompleteListener);
                Log.d(TAG, C2300e4.i.f8403d + this.adNetwork + "] does not Support App Open Ad Format, try to load Backup Ads");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBackupAppOpenAd(final boolean z2, final OnShowAdCompleteListener onShowAdCompleteListener) {
        if (this.adStatus.equals("1")) {
            String str = this.backupAdNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                PAGAppOpenRequest pAGAppOpenRequest = new PAGAppOpenRequest();
                pAGAppOpenRequest.setTimeout(3000);
                PAGAppOpenAd.loadAd(this.pangleAppOpenId, pAGAppOpenRequest, new AnonymousClass6(z2, onShowAdCompleteListener));
            } else {
                if (str.equals(Constant.ADMOB)) {
                    com.google.android.gms.ads.appopen.AppOpenAd.load(this.activity, this.adMobAppOpenId, new AdRequest.Builder().build(), new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAd.5
                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            AppOpenAd.this.appOpenAd = null;
                            AppOpenAd.isAppOpenAdLoaded = false;
                            if (z2) {
                                onShowAdCompleteListener.onShowAdComplete();
                            }
                            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] Failed to Load App Open Ad: " + loadAdError.getMessage());
                        }

                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdLoaded(@NonNull com.google.android.gms.ads.appopen.AppOpenAd appOpenAd) {
                            AppOpenAd appOpenAd2 = AppOpenAd.this;
                            appOpenAd2.appOpenAd = appOpenAd;
                            AppOpenAd.isAppOpenAdLoaded = true;
                            if (z2) {
                                appOpenAd2.showBackupAppOpenAd(onShowAdCompleteListener);
                            }
                            Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] App Open Ad Loaded");
                        }
                    });
                    return;
                }
                onShowAdCompleteListener.onShowAdComplete();
                Log.d(TAG, C2300e4.i.f8403d + this.backupAdNetwork + "] [backup] Selected Ad Network does not Support App Open Ad Format");
            }
        }
    }

    private void onStartActivityLifecycleCallbacks(Activity activity) {
        if (this.placementOnStart && this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                if (this.pangleAppOpenId.equals("0") || this.appOpenAdPangle.isShowingAd) {
                    return;
                }
                this.activity = activity;
                return;
            }
            if (!str.equals(Constant.ADMOB) || this.adMobAppOpenId.equals("0") || this.appOpenAdMob.isShowingAd) {
                return;
            }
            this.activity = activity;
        }
    }

    private void onStartLifecycleObserver() {
        if (this.placementOnResume && this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                if (this.pangleAppOpenId.equals("0") || this.activity.getIntent().hasExtra("unique_id")) {
                    return;
                }
                this.appOpenAdPangle.showAdIfAvailable(this.activity, this.pangleAppOpenId);
                return;
            }
            if (!str.equals(Constant.ADMOB) || this.adMobAppOpenId.equals("0") || this.activity.getIntent().hasExtra("unique_id")) {
                return;
            }
            this.appOpenAdMob.showAdIfAvailable(this.activity, this.adMobAppOpenId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAppOpenAd(final OnShowAdCompleteListener onShowAdCompleteListener) {
        String str = this.adNetwork;
        str.getClass();
        if (str.equals(Constant.PANGLE)) {
            PAGAppOpenAd pAGAppOpenAd = this.pangleAppOpenAd;
            if (pAGAppOpenAd != null) {
                pAGAppOpenAd.setAdInteractionListener(new PAGAppOpenAdInteractionListener() { // from class: com.mimikridev.ads.appopen.AppOpenAd.4
                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdDismissed() {
                        AppOpenAd appOpenAd = AppOpenAd.this;
                        appOpenAd.pangleAppOpenAd = null;
                        if (appOpenAd.withListener) {
                            onShowAdCompleteListener.onShowAdComplete();
                        } else {
                            appOpenAd.loadAppOpenAd(false, onShowAdCompleteListener);
                        }
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] close app open ad");
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdShowed() {
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] show app open ad");
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdClicked() {
                    }
                });
                this.pangleAppOpenAd.show(this.activity);
                return;
            }
            showBackupAppOpenAd(onShowAdCompleteListener);
            Log.d(TAG, C2300e4.i.f8403d + this.adNetwork + "]  Failed to Show App Open Ad, try to show Backup Ads");
            return;
        }
        if (!str.equals(Constant.ADMOB)) {
            showBackupAppOpenAd(onShowAdCompleteListener);
            return;
        }
        com.google.android.gms.ads.appopen.AppOpenAd appOpenAd = this.appOpenAd;
        if (appOpenAd == null) {
            showBackupAppOpenAd(onShowAdCompleteListener);
            Log.d(TAG, C2300e4.i.f8403d + this.adNetwork + "]  Failed to Show App Open Ad, try to show Backup Ads");
            return;
        }
        appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAd.3
            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                AppOpenAd appOpenAd2 = AppOpenAd.this;
                appOpenAd2.appOpenAd = null;
                AppOpenAd.isAppOpenAdLoaded = false;
                if (appOpenAd2.withListener) {
                    onShowAdCompleteListener.onShowAdComplete();
                } else {
                    appOpenAd2.loadAppOpenAd(false, onShowAdCompleteListener);
                }
                Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] App Open Ad Dismissed");
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                AppOpenAd appOpenAd2 = AppOpenAd.this;
                appOpenAd2.appOpenAd = null;
                appOpenAd2.showBackupAppOpenAd(onShowAdCompleteListener);
                Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] Failed to Show App Open Ad Full Screen Content: " + adError.getMessage());
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.adNetwork + "] App Open Ad Shown");
            }
        });
        this.appOpenAd.show(this.activity);
        Log.d(TAG, C2300e4.i.f8403d + this.adNetwork + "]  App Open Ad is Showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBackupAppOpenAd(final OnShowAdCompleteListener onShowAdCompleteListener) {
        String str = this.backupAdNetwork;
        str.getClass();
        if (str.equals(Constant.PANGLE)) {
            PAGAppOpenAd pAGAppOpenAd = this.pangleAppOpenAd;
            if (pAGAppOpenAd == null) {
                onShowAdCompleteListener.onShowAdComplete();
                return;
            } else {
                pAGAppOpenAd.setAdInteractionListener(new PAGAppOpenAdInteractionListener() { // from class: com.mimikridev.ads.appopen.AppOpenAd.8
                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdDismissed() {
                        AppOpenAd appOpenAd = AppOpenAd.this;
                        appOpenAd.pangleAppOpenAd = null;
                        if (appOpenAd.withListener) {
                            onShowAdCompleteListener.onShowAdComplete();
                        } else {
                            appOpenAd.loadAppOpenAd(false, onShowAdCompleteListener);
                        }
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] close app open ad");
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdShowed() {
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] show app open ad");
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                    public void onAdClicked() {
                    }
                });
                this.pangleAppOpenAd.show(this.activity);
                return;
            }
        }
        if (str.equals(Constant.ADMOB)) {
            com.google.android.gms.ads.appopen.AppOpenAd appOpenAd = this.appOpenAd;
            if (appOpenAd == null) {
                onShowAdCompleteListener.onShowAdComplete();
            } else {
                appOpenAd.show(this.activity);
                this.appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAd.7
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        AppOpenAd appOpenAd2 = AppOpenAd.this;
                        appOpenAd2.appOpenAd = null;
                        if (appOpenAd2.withListener) {
                            onShowAdCompleteListener.onShowAdComplete();
                        } else {
                            appOpenAd2.loadAppOpenAd(false, onShowAdCompleteListener);
                        }
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] App Open Ad Dismissed");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        AppOpenAd.this.appOpenAd = null;
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] Failed to Show App Open Ad Full Screen Content: " + adError.getMessage());
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        Log.d(AppOpenAd.TAG, C2300e4.i.f8403d + AppOpenAd.this.backupAdNetwork + "] [backup] App Open Ad Shown");
                    }
                });
            }
        }
    }

    public AppOpenAd build(OnShowAdCompleteListener onShowAdCompleteListener) {
        loadAppOpenAd(this.withListener, onShowAdCompleteListener);
        return this;
    }

    public void destroyOpenAd() {
        isAppOpenAdLoaded = false;
        if (this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                if (this.pangleAppOpenAd != null) {
                    this.pangleAppOpenAd = null;
                }
            } else if (str.equals(Constant.ADMOB) && this.appOpenAd != null) {
                this.appOpenAd = null;
            }
        }
    }

    public AppOpenAd initAppOpenAdManager(AppOpenAdManager appOpenAdManager) {
        this.appOpenAdManager = appOpenAdManager;
        return this;
    }

    public AppOpenAd initAppOpenAdMob(AppOpenAdMob appOpenAdMob) {
        this.appOpenAdMob = appOpenAdMob;
        return this;
    }

    public AppOpenAd initAppOpenAdPangle(AppOpenAdPangle appOpenAdPangle) {
        this.appOpenAdPangle = appOpenAdPangle;
        return this;
    }

    public AppOpenAd setAdManagerAppOpenId(String str) {
        this.adManagerAppOpenId = str;
        return this;
    }

    public AppOpenAd setAdMobAppOpenId(String str) {
        this.adMobAppOpenId = str;
        return this;
    }

    public AppOpenAd setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public AppOpenAd setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public AppOpenAd setApplovinAppOpenId(String str) {
        this.applovinAppOpenId = str;
        return this;
    }

    public AppOpenAd setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public AppOpenAd setOnStartActivityLifecycleCallbacks(Activity activity) {
        onStartActivityLifecycleCallbacks(activity);
        return this;
    }

    public AppOpenAd setOnStartLifecycleObserver() {
        onStartLifecycleObserver();
        return this;
    }

    public AppOpenAd setPangleAppOpenId(String str) {
        this.pangleAppOpenId = str;
        return this;
    }

    public AppOpenAd setPlacementOnResume(boolean z2) {
        this.placementOnResume = z2;
        return this;
    }

    public AppOpenAd setPlacementOnStart(boolean z2) {
        this.placementOnStart = z2;
        return this;
    }

    public AppOpenAd setWithListener(boolean z2) {
        this.withListener = z2;
        return this;
    }

    public AppOpenAd show(OnShowAdCompleteListener onShowAdCompleteListener) {
        showAppOpenAd(onShowAdCompleteListener);
        return this;
    }

    public void showAdIfAvailable(@NonNull Activity activity, @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
        if (this.placementOnStart && this.adStatus.equals("1")) {
            String str = this.adNetwork;
            str.getClass();
            if (str.equals(Constant.PANGLE)) {
                if (this.pangleAppOpenId.equals("0")) {
                    return;
                }
                this.appOpenAdPangle.showAdIfAvailable(activity, this.pangleAppOpenId, onShowAdCompleteListener);
                isAppOpenAdLoaded = true;
                return;
            }
            if (!str.equals(Constant.ADMOB)) {
                onShowAdCompleteListener.onShowAdComplete();
            } else {
                if (this.adMobAppOpenId.equals("0")) {
                    return;
                }
                this.appOpenAdMob.showAdIfAvailable(activity, this.adMobAppOpenId, onShowAdCompleteListener);
                isAppOpenAdLoaded = true;
            }
        }
    }

    public void updateActivity(Activity activity) {
        this.activity = activity;
    }

    public AppOpenAd(Activity activity) {
        this.activity = activity;
    }
}
