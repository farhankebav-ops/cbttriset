package com.bytedance.adsdk.MY.IlO.MY;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends Bc<Float> {
    public tV(List<com.bytedance.adsdk.MY.Bc.IlO<Float>> list) {
        super(list);
    }

    public float DmF() {
        return EO(EO(), Cc());
    }

    public float EO(com.bytedance.adsdk.MY.Bc.IlO<Float> ilO, float f4) {
        if (ilO.IlO == null || ilO.MY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.EO == null) {
            return com.bytedance.adsdk.MY.vCE.Cc.IlO(ilO.vCE(), ilO.Bc(), f4);
        }
        ilO.Bc.getClass();
        tV();
        lEW();
        throw null;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public Float IlO(com.bytedance.adsdk.MY.Bc.IlO<Float> ilO, float f4) {
        return Float.valueOf(EO(ilO, f4));
    }
}
