package com.bytedance.adsdk.MY.IlO.MY;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends Bc<com.bytedance.adsdk.MY.Bc.EO> {
    private final com.bytedance.adsdk.MY.Bc.EO tV;

    public rp(List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.Bc.EO>> list) {
        super(list);
        this.tV = new com.bytedance.adsdk.MY.Bc.EO();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.MY.Bc.EO IlO(com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.Bc.EO> ilO, float f4) {
        com.bytedance.adsdk.MY.Bc.EO eo;
        com.bytedance.adsdk.MY.Bc.EO eo2 = ilO.IlO;
        if (eo2 == null || (eo = ilO.MY) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.MY.Bc.EO eo3 = eo2;
        com.bytedance.adsdk.MY.Bc.EO eo4 = eo;
        if (this.EO == null) {
            this.tV.IlO(com.bytedance.adsdk.MY.vCE.Cc.IlO(eo3.IlO(), eo4.IlO(), f4), com.bytedance.adsdk.MY.vCE.Cc.IlO(eo3.MY(), eo4.MY(), f4));
            return this.tV;
        }
        ilO.Bc.getClass();
        tV();
        lEW();
        throw null;
    }
}
