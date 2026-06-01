package com.ironsource;

import android.content.Context;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.rc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2539rc implements InterfaceC2523qc {
    @Override // com.ironsource.InterfaceC2523qc
    public void a(Nc onNetworkSDKInitListener) {
        kotlin.jvm.internal.k.e(onNetworkSDKInitListener, "onNetworkSDKInitListener");
        IronSourceNetwork.addInitListener(onNetworkSDKInitListener);
    }

    @Override // com.ironsource.InterfaceC2523qc
    public void b(String controllerUrl) {
        kotlin.jvm.internal.k.e(controllerUrl, "controllerUrl");
        SDKUtils.setControllerUrl(controllerUrl);
    }

    @Override // com.ironsource.InterfaceC2523qc
    public void a(Context applicationContext, String applicationKey, String userId, Map<String, String> initParams) {
        kotlin.jvm.internal.k.e(applicationContext, "applicationContext");
        kotlin.jvm.internal.k.e(applicationKey, "applicationKey");
        kotlin.jvm.internal.k.e(userId, "userId");
        kotlin.jvm.internal.k.e(initParams, "initParams");
        IronSourceNetwork.initSDK(applicationContext, applicationKey, userId, initParams);
    }

    @Override // com.ironsource.InterfaceC2523qc
    public void a(String controllerConfig) {
        kotlin.jvm.internal.k.e(controllerConfig, "controllerConfig");
        SDKUtils.setControllerConfig(controllerConfig);
    }

    @Override // com.ironsource.InterfaceC2523qc
    public void a(int i2) {
        SDKUtils.setDebugMode(i2);
    }
}
