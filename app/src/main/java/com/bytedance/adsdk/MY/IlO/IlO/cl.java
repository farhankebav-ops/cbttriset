package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.PointF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl implements xF, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> EO;
    private final com.bytedance.adsdk.MY.DmF IlO;
    private final String MY;
    private com.bytedance.adsdk.MY.EO.MY.bWL tV;

    public cl(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.hp hpVar) {
        this.IlO = dmF;
        this.MY = hpVar.IlO();
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = hpVar.MY().IlO();
        this.EO = IlO;
        ilO.IlO(IlO);
        IlO.IlO(this);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
    }

    public com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> MY() {
        return this.EO;
    }

    private com.bytedance.adsdk.MY.EO.MY.bWL MY(com.bytedance.adsdk.MY.EO.MY.bWL bwl) {
        List<com.bytedance.adsdk.MY.EO.IlO> listEO = bwl.EO();
        boolean zMY = bwl.MY();
        int size = listEO.size() - 1;
        int i2 = 0;
        while (size >= 0) {
            com.bytedance.adsdk.MY.EO.IlO ilO = listEO.get(size);
            com.bytedance.adsdk.MY.EO.IlO ilO2 = listEO.get(IlO(size - 1, listEO.size()));
            PointF pointFEO = (size != 0 || zMY) ? ilO2.EO() : bwl.IlO();
            i2 = (((size != 0 || zMY) ? ilO2.MY() : pointFEO).equals(pointFEO) && ilO.IlO().equals(pointFEO) && !(!bwl.MY() && size == 0 && size == listEO.size() - 1)) ? i2 + 2 : i2 + 1;
            size--;
        }
        com.bytedance.adsdk.MY.EO.MY.bWL bwl2 = this.tV;
        if (bwl2 == null || bwl2.EO().size() != i2) {
            ArrayList arrayList = new ArrayList(i2);
            for (int i8 = 0; i8 < i2; i8++) {
                arrayList.add(new com.bytedance.adsdk.MY.EO.IlO());
            }
            this.tV = new com.bytedance.adsdk.MY.EO.MY.bWL(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.tV.IlO(zMY);
        return this.tV;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.IlO.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    @Override // com.bytedance.adsdk.MY.IlO.IlO.xF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.adsdk.MY.EO.MY.bWL IlO(com.bytedance.adsdk.MY.EO.MY.bWL r19) {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.IlO.IlO.cl.IlO(com.bytedance.adsdk.MY.EO.MY.bWL):com.bytedance.adsdk.MY.EO.MY.bWL");
    }

    private static int MY(int i2, int i8) {
        int i9 = i2 / i8;
        return ((i2 ^ i8) >= 0 || i8 * i9 == i2) ? i9 : i9 - 1;
    }

    private static int IlO(int i2, int i8) {
        return i2 - (MY(i2, i8) * i8);
    }
}
