package com.ironsource.mediationsdk.sdk;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface BannerSmashListener {
    void onBannerAdClicked();

    void onBannerAdClicked(Map<String, Object> map);

    void onBannerAdLeftApplication();

    void onBannerAdLeftApplication(Map<String, Object> map);

    void onBannerAdLoadFailed(IronSourceError ironSourceError);

    void onBannerAdLoadFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams);

    void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams, Map<String, Object> map);

    void onBannerAdScreenDismissed();

    void onBannerAdScreenDismissed(Map<String, Object> map);

    void onBannerAdScreenPresented();

    void onBannerAdScreenPresented(Map<String, Object> map);

    void onBannerAdShown();

    void onBannerAdShown(Map<String, Object> map);

    void onBannerInitFailed(IronSourceError ironSourceError);

    void onBannerInitFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onBannerInitSuccess();

    void onBannerInitSuccess(Map<String, Object> map);
}
