package com.bytedance.adsdk.MY.EO.MY;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl implements EO {
    private final com.bytedance.adsdk.MY.EO.IlO.lEW EO;
    private final String IlO;
    private final int MY;
    private final boolean tV;

    public cl(String str, int i2, com.bytedance.adsdk.MY.EO.IlO.lEW lew, boolean z2) {
        this.IlO = str;
        this.MY = i2;
        this.EO = lew;
        this.tV = z2;
    }

    public boolean EO() {
        return this.tV;
    }

    public String IlO() {
        return this.IlO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.lEW MY() {
        return this.EO;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShapePath{name=");
        sb.append(this.IlO);
        sb.append(", index=");
        return a0.c(sb, this.MY, '}');
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.es(dmF, ilO, this);
    }
}
