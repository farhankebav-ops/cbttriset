package com.bytedance.adsdk.MY.vCE;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private float IlO;
    private int MY;

    public void IlO(float f4) {
        float f8 = this.IlO + f4;
        this.IlO = f8;
        int i2 = this.MY + 1;
        this.MY = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.IlO = f8 / 2.0f;
            this.MY = i2 / 2;
        }
    }
}
