package com.bytedance.sdk.openadsdk.api.model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGErrorModel {
    private final int IlO;
    private final String MY;

    public PAGErrorModel(int i2, String str) {
        this.IlO = i2;
        this.MY = str;
    }

    public int getErrorCode() {
        return this.IlO;
    }

    public String getErrorMessage() {
        return this.MY;
    }
}
