package com.bytedance.adsdk.MY.EO.MY;

import com.bytedance.adsdk.MY.IlO.IlO.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF implements EO {
    private final com.bytedance.adsdk.MY.EO.IlO.MY Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.MY EO;
    private final String IlO;
    private final IlO MY;
    private final com.bytedance.adsdk.MY.EO.IlO.MY tV;
    private final boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static IlO IlO(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i2)));
        }
    }

    public xF(String str, IlO ilO, com.bytedance.adsdk.MY.EO.IlO.MY my, com.bytedance.adsdk.MY.EO.IlO.MY my2, com.bytedance.adsdk.MY.EO.IlO.MY my3, boolean z2) {
        this.IlO = str;
        this.MY = ilO;
        this.EO = my;
        this.tV = my2;
        this.Cc = my3;
        this.vCE = z2;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY Cc() {
        return this.Cc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY EO() {
        return this.tV;
    }

    public String IlO() {
        return this.IlO;
    }

    public IlO MY() {
        return this.MY;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY tV() {
        return this.EO;
    }

    public String toString() {
        return "Trim Path: {start: " + this.EO + ", end: " + this.tV + ", offset: " + this.Cc + "}";
    }

    public boolean vCE() {
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new oeT(ilO, this);
    }
}
