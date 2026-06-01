package com.bytedance.adsdk.MY.IlO.MY;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends Bc<Integer> {
    public vCE(List<com.bytedance.adsdk.MY.Bc.IlO<Integer>> list) {
        super(list);
    }

    public int DmF() {
        return EO(EO(), Cc());
    }

    public int EO(com.bytedance.adsdk.MY.Bc.IlO<Integer> ilO, float f4) {
        if (ilO.IlO == null || ilO.MY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.EO == null) {
            return com.bytedance.adsdk.MY.vCE.Cc.IlO(ilO.lEW(), ilO.DmF(), f4);
        }
        ilO.Bc.getClass();
        tV();
        lEW();
        throw null;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public Integer IlO(com.bytedance.adsdk.MY.Bc.IlO<Integer> ilO, float f4) {
        return Integer.valueOf(EO(ilO, f4));
    }
}
