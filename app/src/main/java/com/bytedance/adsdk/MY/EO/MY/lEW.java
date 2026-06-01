package com.bytedance.adsdk.MY.EO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private final com.bytedance.adsdk.MY.EO.IlO.tV EO;
    private final IlO IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.lEW MY;
    private final boolean tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public lEW(IlO ilO, com.bytedance.adsdk.MY.EO.IlO.lEW lew, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, boolean z2) {
        this.IlO = ilO;
        this.MY = lew;
        this.EO = tVVar;
        this.tV = z2;
    }

    public com.bytedance.adsdk.MY.EO.IlO.tV EO() {
        return this.EO;
    }

    public IlO IlO() {
        return this.IlO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.lEW MY() {
        return this.MY;
    }

    public boolean tV() {
        return this.tV;
    }
}
