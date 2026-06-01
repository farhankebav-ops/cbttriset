package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterstitialSmashListener {
    void onInterstitialAdClicked();

    void onInterstitialAdClicked(Map<String, Object> map);

    void onInterstitialAdClosed();

    void onInterstitialAdClosed(Map<String, Object> map);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onInterstitialAdOpened();

    void onInterstitialAdOpened(Map<String, Object> map);

    void onInterstitialAdReady();

    void onInterstitialAdReady(Map<String, Object> map);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onInterstitialAdShowSucceeded();

    void onInterstitialAdShowSucceeded(Map<String, Object> map);

    void onInterstitialAdVisible();

    void onInterstitialAdVisible(Map<String, Object> map);

    void onInterstitialInitFailed(IronSourceError ironSourceError);

    void onInterstitialInitFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onInterstitialInitSuccess();

    void onInterstitialInitSuccess(Map<String, Object> map);
}
