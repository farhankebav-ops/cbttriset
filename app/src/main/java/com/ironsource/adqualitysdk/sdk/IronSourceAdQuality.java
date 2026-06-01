package com.ironsource.adqualitysdk.sdk;

import android.content.Context;
import com.ironsource.adqualitysdk.sdk.i.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class IronSourceAdQuality {
    public static final String TAG = "ISAdQuality Agent SDK";
    public static final String VERSION = "9.0.2";

    public static IronSourceAdQuality getInstance() {
        return q.m3013();
    }

    public static String getSDKVersion() {
        return "9.0.2";
    }

    public abstract void changeUserId(String str);

    public abstract void initialize(Context context, String str);

    public abstract void initialize(Context context, String str, ISAdQualityConfig iSAdQualityConfig);

    public abstract void sendCustomMediationRevenue(ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue);

    public abstract void setAdListener(ISAdQualityAdListener iSAdQualityAdListener);

    public abstract void setConfig(ISAdQualityConfig iSAdQualityConfig);

    public abstract void setSegment(ISAdQualitySegment iSAdQualitySegment);

    @Deprecated
    public abstract void setUserConsent(boolean z2);

    public abstract void shutdown();
}
