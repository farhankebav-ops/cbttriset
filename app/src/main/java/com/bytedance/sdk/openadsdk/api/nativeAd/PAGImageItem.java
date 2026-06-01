package com.bytedance.sdk.openadsdk.api.nativeAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGImageItem {
    private final String EO;
    private final int IlO;
    private final int MY;
    private float tV;

    public PAGImageItem(int i2, int i8, String str, float f4) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = str;
        this.tV = f4;
    }

    public float getDuration() {
        return this.tV;
    }

    public int getHeight() {
        return this.IlO;
    }

    public String getImageUrl() {
        return this.EO;
    }

    public int getWidth() {
        return this.MY;
    }

    public PAGImageItem(int i2, int i8, String str) {
        this(i2, i8, str, 0.0f);
    }
}
