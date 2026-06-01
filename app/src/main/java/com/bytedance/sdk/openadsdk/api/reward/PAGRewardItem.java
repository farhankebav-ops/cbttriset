package com.bytedance.sdk.openadsdk.api.reward;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGRewardItem {
    private final int IlO;
    private final String MY;

    public PAGRewardItem(int i2, String str) {
        this.IlO = i2;
        this.MY = str;
    }

    public int getRewardAmount() {
        return this.IlO;
    }

    public String getRewardName() {
        return this.MY;
    }
}
