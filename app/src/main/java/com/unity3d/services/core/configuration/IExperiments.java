package com.unity3d.services.core.configuration;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IExperiments {
    JSONObject getCurrentSessionExperiments();

    Map<String, String> getExperimentTags();

    JSONObject getExperimentsAsJson();

    JSONObject getNextSessionExperiments();

    String getScarBiddingManager();

    boolean isBoldSdkNextSessionEnabled();

    boolean isCaptureHDRCapabilitiesEnabled();

    boolean isJetpackLifecycle();

    boolean isNativeLoadTimeoutDisabled();

    boolean isNativeShowTimeoutDisabled();

    boolean isOkHttpEnabled();

    boolean isPCCheckEnabled();

    boolean isScarBannerHbEnabled();

    boolean isScarInitEnabled();

    boolean isWebAssetAdCaching();

    boolean isWebGestureNotRequired();

    boolean isWebMessageEnabled();

    boolean isWebViewAsyncDownloadEnabled();

    boolean shouldNativeTokenAwaitPrivacy();
}
