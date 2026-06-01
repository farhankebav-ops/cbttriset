package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements EV, hp, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, PointF> Bc;
    private final com.bytedance.adsdk.MY.DmF Cc;
    private final String EO;
    private boolean EV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> lEW;
    private final boolean tV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, PointF> vCE;
    private final Path IlO = new Path();
    private final RectF MY = new RectF();
    private final MY DmF = new MY();
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> NV = null;

    public ea(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.EV ev) {
        this.EO = ev.IlO();
        this.tV = ev.Cc();
        this.Cc = dmF;
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO = ev.tV().IlO();
        this.vCE = IlO;
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO2 = ev.EO().IlO();
        this.Bc = IlO2;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO3 = ev.MY().IlO();
        this.lEW = IlO3;
        ilO.IlO(IlO);
        ilO.IlO(IlO2);
        ilO.IlO(IlO3);
        IlO.IlO(this);
        IlO2.IlO(this);
        IlO3.IlO(this);
    }

    private void MY() {
        this.EV = false;
        this.Cc.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        MY();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO;
        if (this.EV) {
            return this.IlO;
        }
        this.IlO.reset();
        if (this.tV) {
            this.EV = true;
            return this.IlO;
        }
        PointF pointFBc = this.Bc.Bc();
        float f4 = pointFBc.x / 2.0f;
        float f8 = pointFBc.y / 2.0f;
        com.bytedance.adsdk.MY.IlO.MY.IlO<?, Float> ilO2 = this.lEW;
        float fDmF = ilO2 == null ? 0.0f : ((com.bytedance.adsdk.MY.IlO.MY.tV) ilO2).DmF();
        if (fDmF == 0.0f && (ilO = this.NV) != null) {
            fDmF = Math.min(ilO.Bc().floatValue(), Math.min(f4, f8));
        }
        float fMin = Math.min(f4, f8);
        if (fDmF > fMin) {
            fDmF = fMin;
        }
        PointF pointFBc2 = this.vCE.Bc();
        this.IlO.moveTo(pointFBc2.x + f4, (pointFBc2.y - f8) + fDmF);
        this.IlO.lineTo(pointFBc2.x + f4, (pointFBc2.y + f8) - fDmF);
        if (fDmF > 0.0f) {
            RectF rectF = this.MY;
            float f9 = pointFBc2.x;
            float f10 = fDmF * 2.0f;
            float f11 = pointFBc2.y;
            rectF.set((f9 + f4) - f10, (f11 + f8) - f10, f9 + f4, f11 + f8);
            this.IlO.arcTo(this.MY, 0.0f, 90.0f, false);
        }
        this.IlO.lineTo((pointFBc2.x - f4) + fDmF, pointFBc2.y + f8);
        if (fDmF > 0.0f) {
            RectF rectF2 = this.MY;
            float f12 = pointFBc2.x;
            float f13 = pointFBc2.y;
            float f14 = fDmF * 2.0f;
            rectF2.set(f12 - f4, (f13 + f8) - f14, (f12 - f4) + f14, f13 + f8);
            this.IlO.arcTo(this.MY, 90.0f, 90.0f, false);
        }
        this.IlO.lineTo(pointFBc2.x - f4, (pointFBc2.y - f8) + fDmF);
        if (fDmF > 0.0f) {
            RectF rectF3 = this.MY;
            float f15 = pointFBc2.x;
            float f16 = pointFBc2.y;
            float f17 = fDmF * 2.0f;
            rectF3.set(f15 - f4, f16 - f8, (f15 - f4) + f17, (f16 - f8) + f17);
            this.IlO.arcTo(this.MY, 180.0f, 90.0f, false);
        }
        this.IlO.lineTo((pointFBc2.x + f4) - fDmF, pointFBc2.y - f8);
        if (fDmF > 0.0f) {
            RectF rectF4 = this.MY;
            float f18 = pointFBc2.x;
            float f19 = fDmF * 2.0f;
            float f20 = pointFBc2.y;
            rectF4.set((f18 + f4) - f19, f20 - f8, f18 + f4, (f20 - f8) + f19);
            this.IlO.arcTo(this.MY, 270.0f, 90.0f, false);
        }
        this.IlO.close();
        this.DmF.IlO(this.IlO);
        this.EV = true;
        return this.IlO;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r5, java.util.List<com.bytedance.adsdk.MY.IlO.IlO.EO> r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            com.bytedance.adsdk.MY.IlO.IlO.EO r0 = (com.bytedance.adsdk.MY.IlO.IlO.EO) r0
            boolean r1 = r0 instanceof com.bytedance.adsdk.MY.IlO.IlO.oeT
            if (r1 == 0) goto L25
            r1 = r0
            com.bytedance.adsdk.MY.IlO.IlO.oeT r1 = (com.bytedance.adsdk.MY.IlO.IlO.oeT) r1
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r2 = r1.MY()
            com.bytedance.adsdk.MY.EO.MY.xF$IlO r3 = com.bytedance.adsdk.MY.EO.MY.xF.IlO.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            com.bytedance.adsdk.MY.IlO.IlO.MY r0 = r4.DmF
            r0.IlO(r1)
            r1.IlO(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof com.bytedance.adsdk.MY.IlO.IlO.cl
            if (r1 == 0) goto L31
            com.bytedance.adsdk.MY.IlO.IlO.cl r0 = (com.bytedance.adsdk.MY.IlO.IlO.cl) r0
            com.bytedance.adsdk.MY.IlO.MY.IlO r0 = r0.MY()
            r4.NV = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.IlO.IlO.ea.IlO(java.util.List, java.util.List):void");
    }
}
