package com.bytedance.adsdk.MY.IlO.MY;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends Bc<com.bytedance.adsdk.MY.EO.MY.tV> {
    private final com.bytedance.adsdk.MY.EO.MY.tV tV;

    public Cc(List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV>> list) {
        super(list);
        com.bytedance.adsdk.MY.EO.MY.tV tVVar = list.get(0).IlO;
        int iEO = tVVar != null ? tVVar.EO() : 0;
        this.tV = new com.bytedance.adsdk.MY.EO.MY.tV(new float[iEO], new int[iEO]);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.MY.EO.MY.tV IlO(com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV> ilO, float f4) {
        this.tV.IlO(ilO.IlO, ilO.MY, f4);
        return this.tV;
    }
}
