package com.bytedance.sdk.openadsdk.api.bidding;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGBiddingRequest {
    private PAGBannerSize IlO = null;
    private String MY = null;
    private String EO = null;

    public String getAdxId() {
        return this.EO;
    }

    public PAGBannerSize getBannerSize() {
        return this.IlO;
    }

    public String getSlotId() {
        return this.MY;
    }

    public void setAdxId(String str) {
        this.EO = str;
    }

    public void setBannerSize(PAGBannerSize pAGBannerSize) {
        this.IlO = pAGBannerSize;
    }

    public void setSlotId(String str) {
        this.MY = str;
    }
}
