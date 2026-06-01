package com.bytedance.sdk.openadsdk.api;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface PAGExpressAdWrapperListener extends PAGAdWrapperListener {
    void onAdDismissed();

    void onAdShow(View view, int i2);

    void onRenderFail(View view, String str, int i2);

    void onRenderSuccess(View view, float f4, float f8);
}
