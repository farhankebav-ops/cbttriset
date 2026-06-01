package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGBannerRequest extends PAGRequest {
    private PAGBannerSize IlO;

    public PAGBannerRequest(PAGBannerSize pAGBannerSize) {
        this.IlO = pAGBannerSize;
    }

    public PAGBannerSize getAdSize() {
        return this.IlO;
    }

    public void setAdSize(PAGBannerSize pAGBannerSize) {
        this.IlO = pAGBannerSize;
    }
}
