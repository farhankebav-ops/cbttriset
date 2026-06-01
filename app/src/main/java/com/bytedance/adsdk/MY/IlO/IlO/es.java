package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Path;
import com.bytedance.adsdk.MY.IlO.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements hp, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.hp Cc;
    private final boolean EO;
    private final String MY;
    private final com.bytedance.adsdk.MY.DmF tV;
    private boolean vCE;
    private final Path IlO = new Path();
    private final MY Bc = new MY();

    public es(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.cl clVar) {
        this.MY = clVar.IlO();
        this.EO = clVar.EO();
        this.tV = dmF;
        com.bytedance.adsdk.MY.IlO.MY.hp hpVarIlO = clVar.MY().IlO();
        this.Cc = hpVarIlO;
        ilO.IlO(hpVarIlO);
        hpVarIlO.IlO(this);
    }

    private void MY() {
        this.vCE = false;
        this.tV.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        MY();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        if (this.vCE) {
            return this.IlO;
        }
        this.IlO.reset();
        if (this.EO) {
            this.vCE = true;
            return this.IlO;
        }
        Path pathBc = this.Cc.Bc();
        if (pathBc == null) {
            return this.IlO;
        }
        this.IlO.set(pathBc);
        this.IlO.setFillType(Path.FillType.EVEN_ODD);
        this.Bc.IlO(this.IlO);
        this.vCE = true;
        return this.IlO;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r6, java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L39
            java.lang.Object r1 = r6.get(r0)
            com.bytedance.adsdk.MY.IlO.IlO.EO r1 = (com.bytedance.adsdk.MY.IlO.IlO.EO) r1
            boolean r2 = r1 instanceof com.bytedance.adsdk.MY.IlO.IlO.oeT
            if (r2 == 0) goto L26
            r2 = r1
            com.bytedance.adsdk.MY.IlO.IlO.oeT r2 = (com.bytedance.adsdk.MY.IlO.IlO.oeT) r2
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r3 = r2.MY()
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r4 = com.bytedance.adsdk.MY.EO.MY.xF.IlO.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            com.bytedance.adsdk.MY.IlO.IlO.MY r1 = r5.Bc
            r1.IlO(r2)
            r2.IlO(r5)
            goto L36
        L26:
            boolean r2 = r1 instanceof com.bytedance.adsdk.MY.IlO.IlO.xF
            if (r2 == 0) goto L36
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            com.bytedance.adsdk.MY.IlO.IlO.xF r1 = (com.bytedance.adsdk.MY.IlO.IlO.xF) r1
            r7.add(r1)
        L36:
            int r0 = r0 + 1
            goto L2
        L39:
            com.bytedance.adsdk.MY.IlO.MY.hp r6 = r5.Cc
            r6.IlO(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.IlO.IlO.es.IlO(java.util.List, java.util.List):void");
    }
}
