package com.mimikridev.ads.appopen;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.mimikridev.ads.listener.OnShowAdCompleteListener;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AppOpenAdPangle {
    private PAGAppOpenAd appOpenAd = null;
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
        PAGAppOpenRequest pAGAppOpenRequest = new PAGAppOpenRequest();
        pAGAppOpenRequest.setTimeout(3000);
        PAGAppOpenAd.loadAd(str, pAGAppOpenRequest, new PAGAppOpenAdLoadListener() { // from class: com.mimikridev.ads.appopen.AppOpenAdPangle.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
            public void onError(int i2, String str2) {
                AppOpenAdPangle.this.isLoadingAd = false;
                Log.d(AppOpenAd.TAG, "Failed to load Pangle App Open Ad: " + str2);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
                AppOpenAdPangle.this.appOpenAd = pAGAppOpenAd;
                AppOpenAdPangle.this.isLoadingAd = false;
                AppOpenAdPangle.this.loadTime = new Date().getTime();
                Log.d(AppOpenAd.TAG, "Pangle App Open Ad Loaded.");
            }
        });
    }

    public void showAdIfAvailable(@NonNull Activity activity, String str) {
        showAdIfAvailable(activity, str, new b(2));
    }

    public boolean wasLoadTimeLessThanNHoursAgo(long j) {
        return new Date().getTime() - this.loadTime < j * 3600000;
    }

    public void showAdIfAvailable(@NonNull final Activity activity, final String str, @NonNull final OnShowAdCompleteListener onShowAdCompleteListener) {
        if (this.isShowingAd) {
            Log.d(AppOpenAd.TAG, "The app open ad is already showing.");
            return;
        }
        if (!isAdAvailable()) {
            Log.d(AppOpenAd.TAG, "The app open ad is not ready yet.");
            onShowAdCompleteListener.onShowAdComplete();
            loadAd(activity, str);
            return;
        }
        Log.d(AppOpenAd.TAG, "Will show ad.");
        this.appOpenAd.setAdInteractionListener(new PAGAppOpenAdInteractionListener() { // from class: com.mimikridev.ads.appopen.AppOpenAdPangle.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AppOpenAdPangle.this.appOpenAd = null;
                AppOpenAdPangle.this.isShowingAd = false;
                Log.d(AppOpenAd.TAG, "onAdDismissedFullScreenContent.");
                onShowAdCompleteListener.onShowAdComplete();
                AppOpenAdPangle.this.loadAd(activity, str);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
            }
        });
        this.isShowingAd = true;
        PAGAppOpenAd pAGAppOpenAd = this.appOpenAd;
        if (pAGAppOpenAd != null) {
            pAGAppOpenAd.show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAdIfAvailable$0() {
    }
}
