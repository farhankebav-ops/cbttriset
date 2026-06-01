package com.mimikridev.ads.appopen;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.mimikridev.ads.listener.OnShowAdCompleteListener;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AppOpenAdMob {
    private static final String LOG_TAG = "AppOpenAd";
    private com.google.android.gms.ads.appopen.AppOpenAd appOpenAd = null;
    private boolean isLoadingAd = false;
    public boolean isShowingAd = false;
    private long loadTime = 0;

    public boolean isAdAvailable() {
        return this.appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4L);
    }

    public void loadAd(Context context, String str) {
        if (this.isLoadingAd || isAdAvailable()) {
            return;
        }
        this.isLoadingAd = true;
        com.google.android.gms.ads.appopen.AppOpenAd.load(context, str, new AdRequest.Builder().build(), new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAdMob.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                AppOpenAdMob.this.isLoadingAd = false;
                Log.d("AppOpenAd", "onAdFailedToLoad: " + loadAdError.getMessage());
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(@NonNull com.google.android.gms.ads.appopen.AppOpenAd appOpenAd) {
                AppOpenAdMob.this.appOpenAd = appOpenAd;
                AppOpenAdMob.this.isLoadingAd = false;
                AppOpenAdMob.this.loadTime = new Date().getTime();
                Log.d("AppOpenAd", "onAdLoaded.");
            }
        });
    }

    public void showAdIfAvailable(@NonNull Activity activity, String str) {
        showAdIfAvailable(activity, str, new b(1));
    }

    public boolean wasLoadTimeLessThanNHoursAgo(long j) {
        return new Date().getTime() - this.loadTime < j * 3600000;
    }

    public void showAdIfAvailable(@NonNull final Activity activity, final String str, @NonNull final OnShowAdCompleteListener onShowAdCompleteListener) {
        if (this.isShowingAd) {
            Log.d("AppOpenAd", "The app open ad is already showing.");
            return;
        }
        if (!isAdAvailable()) {
            Log.d("AppOpenAd", "The app open ad is not ready yet.");
            onShowAdCompleteListener.onShowAdComplete();
            loadAd(activity, str);
        } else {
            Log.d("AppOpenAd", "Will show ad.");
            this.appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.appopen.AppOpenAdMob.2
                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdDismissedFullScreenContent() {
                    AppOpenAdMob.this.appOpenAd = null;
                    AppOpenAdMob.this.isShowingAd = false;
                    Log.d("AppOpenAd", "onAdDismissedFullScreenContent.");
                    onShowAdCompleteListener.onShowAdComplete();
                    AppOpenAdMob.this.loadAd(activity, str);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    AppOpenAdMob.this.appOpenAd = null;
                    AppOpenAdMob.this.isShowingAd = false;
                    Log.d("AppOpenAd", "onAdFailedToShowFullScreenContent: " + adError.getMessage());
                    onShowAdCompleteListener.onShowAdComplete();
                    AppOpenAdMob.this.loadAd(activity, str);
                }

                @Override // com.google.android.gms.ads.FullScreenContentCallback
                public void onAdShowedFullScreenContent() {
                    Log.d("AppOpenAd", "onAdShowedFullScreenContent.");
                }
            });
            this.isShowingAd = true;
            this.appOpenAd.show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAdIfAvailable$0() {
    }
}
