package com.bytedance.sdk.openadsdk.api;

import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.common.vCE;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface PAGLoadListener<Ad> extends vCE {
    @MainThread
    void onAdLoaded(Ad ad);

    @Override // com.bytedance.sdk.openadsdk.common.vCE
    @MainThread
    void onError(int i2, String str);
}
