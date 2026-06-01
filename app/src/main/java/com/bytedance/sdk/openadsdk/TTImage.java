package com.bytedance.sdk.openadsdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTImage {
    private final String EO;
    private final int IlO;
    private final int MY;
    private double tV;

    public TTImage(int i2, int i8, String str, double d8) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = str;
        this.tV = d8;
    }

    public double getDuration() {
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

    public boolean isValid() {
        String str;
        return this.IlO > 0 && this.MY > 0 && (str = this.EO) != null && str.length() > 0;
    }

    public TTImage(int i2, int i8, String str) {
        this(i2, i8, str, 0.0d);
    }
}
