package com.bytedance.adsdk.MY.EO.MY;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa implements EO {
    private final boolean EO;
    private final String IlO;
    private final List<EO> MY;

    public zPa(String str, List<EO> list, boolean z2) {
        this.IlO = str;
        this.MY = list;
        this.EO = z2;
    }

    public boolean EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public List<EO> MY() {
        return this.MY;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.IlO + "' Shapes: " + Arrays.toString(this.MY.toArray()) + '}';
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.tV(dmF, ilO, this, bc);
    }
}
