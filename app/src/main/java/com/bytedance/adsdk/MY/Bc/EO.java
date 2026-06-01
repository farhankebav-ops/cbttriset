package com.bytedance.adsdk.MY.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private float IlO;
    private float MY;

    public EO(float f4, float f8) {
        this.IlO = f4;
        this.MY = f8;
    }

    public float IlO() {
        return this.IlO;
    }

    public float MY() {
        return this.MY;
    }

    public String toString() {
        return IlO() + "x" + MY();
    }

    public void IlO(float f4, float f8) {
        this.IlO = f4;
        this.MY = f8;
    }

    public boolean MY(float f4, float f8) {
        return this.IlO == f4 && this.MY == f8;
    }

    public EO() {
        this(1.0f, 1.0f);
    }
}
