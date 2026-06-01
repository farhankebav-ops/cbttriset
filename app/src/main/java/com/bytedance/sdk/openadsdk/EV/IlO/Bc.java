package com.bytedance.sdk.openadsdk.EV.IlO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.ironsource.C2300e4;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private final String IlO;
    private final vSq MY;

    public Bc(String str, vSq vsq) {
        this.MY = vsq;
        this.IlO = str;
    }

    public static void IlO(cl clVar, vSq vsq) {
        clVar.IlO("appInfo", new Bc("appInfo", vsq));
        clVar.IlO("adInfo", new Bc("adInfo", vsq));
        clVar.IlO("sendLog", new Bc("sendLog", vsq));
        clVar.IlO("playable_style", new Bc("playable_style", vsq));
        clVar.IlO("getTemplateInfo", new Bc("getTemplateInfo", vsq));
        clVar.IlO("getTeMaiAds", new Bc("getTeMaiAds", vsq));
        clVar.IlO(C2300e4.h.f8376o, new Bc(C2300e4.h.f8376o, vsq));
        clVar.IlO("getScreenSize", new Bc("getScreenSize", vsq));
        clVar.IlO("getCloseButtonInfo", new Bc("getCloseButtonInfo", vsq));
        clVar.IlO("getVolume", new Bc("getVolume", vsq));
        clVar.IlO("removeLoading", new Bc("removeLoading", vsq));
        clVar.IlO("sendReward", new Bc("sendReward", vsq));
        clVar.IlO("subscribe_app_ad", new Bc("subscribe_app_ad", vsq));
        clVar.IlO("download_app_ad", new Bc("download_app_ad", vsq));
        clVar.IlO("cancel_download_app_ad", new Bc("cancel_download_app_ad", vsq));
        clVar.IlO("unsubscribe_app_ad", new Bc("unsubscribe_app_ad", vsq));
        clVar.IlO("landscape_click", new Bc("landscape_click", vsq));
        clVar.IlO("clickEvent", new Bc("clickEvent", vsq));
        clVar.IlO("renderDidFinish", new Bc("renderDidFinish", vsq));
        clVar.IlO("dynamicTrack", new Bc("dynamicTrack", vsq));
        clVar.IlO("skipVideo", new Bc("skipVideo", vsq));
        clVar.IlO("muteVideo", new Bc("muteVideo", vsq));
        clVar.IlO("changeVideoState", new Bc("changeVideoState", vsq));
        clVar.IlO("getCurrentVideoState", new Bc("getCurrentVideoState", vsq));
        clVar.IlO("send_temai_product_ids", new Bc("send_temai_product_ids", vsq));
        clVar.IlO("getMaterialMeta", new Bc("getMaterialMeta", vsq));
        clVar.IlO("endcard_load", new Bc("endcard_load", vsq));
        clVar.IlO("pauseWebView", new Bc("pauseWebView", vsq));
        clVar.IlO("pauseWebViewTimers", new Bc("pauseWebViewTimers", vsq));
        clVar.IlO("webview_time_track", new Bc("webview_time_track", vsq));
        clVar.IlO("openPrivacy", new Bc("openPrivacy", vsq));
        clVar.IlO("openAdLandPageLinks", new Bc("openAdLandPageLinks", vsq));
        clVar.IlO("getNativeSiteCustomData", new Bc("getNativeSiteCustomData", vsq));
        clVar.IlO(MRAIDPresenter.CLOSE, new Bc(MRAIDPresenter.CLOSE, vsq));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    @Nullable
    public JSONObject IlO(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        vSq.MY my = new vSq.MY();
        my.IlO = NotificationCompat.CATEGORY_CALL;
        my.EO = this.IlO;
        my.tV = jSONObject;
        return this.MY.IlO(my, 3);
    }
}
