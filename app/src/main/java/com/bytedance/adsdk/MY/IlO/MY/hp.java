package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Path;
import com.bytedance.adsdk.MY.IlO.IlO.xF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp extends IlO<com.bytedance.adsdk.MY.EO.MY.bWL, Path> {
    private final Path Cc;
    private final com.bytedance.adsdk.MY.EO.MY.bWL tV;
    private List<xF> vCE;

    public hp(List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.bWL>> list) {
        super(list);
        this.tV = new com.bytedance.adsdk.MY.EO.MY.bWL();
        this.Cc = new Path();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public Path IlO(com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.bWL> ilO, float f4) {
        this.tV.IlO(ilO.IlO, ilO.MY, f4);
        com.bytedance.adsdk.MY.EO.MY.bWL bwlIlO = this.tV;
        List<xF> list = this.vCE;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                bwlIlO = this.vCE.get(size).IlO(bwlIlO);
            }
        }
        com.bytedance.adsdk.MY.vCE.Cc.IlO(bwlIlO, this.Cc);
        return this.Cc;
    }

    public void IlO(List<xF> list) {
        this.vCE = list;
    }
}
