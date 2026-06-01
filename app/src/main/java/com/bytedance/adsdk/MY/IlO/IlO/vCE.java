package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.MY.EO.MY.xF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements EV, hp, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, PointF> Cc;
    private final com.bytedance.adsdk.MY.DmF EO;
    private final String MY;
    private boolean lEW;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<?, PointF> tV;
    private final com.bytedance.adsdk.MY.EO.MY.MY vCE;
    private final Path IlO = new Path();
    private final MY Bc = new MY();

    public vCE(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.MY my) {
        this.MY = my.IlO();
        this.EO = dmF;
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO = my.EO().IlO();
        this.tV = IlO;
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO2 = my.MY().IlO();
        this.Cc = IlO2;
        this.vCE = my;
        ilO.IlO(IlO);
        ilO.IlO(IlO2);
        IlO.IlO(this);
        IlO2.IlO(this);
    }

    private void MY() {
        this.lEW = false;
        this.EO.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        MY();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        if (this.lEW) {
            return this.IlO;
        }
        this.IlO.reset();
        if (this.vCE.Cc()) {
            this.lEW = true;
            return this.IlO;
        }
        PointF pointFBc = this.tV.Bc();
        float f4 = pointFBc.x / 2.0f;
        float f8 = pointFBc.y / 2.0f;
        float f9 = f4 * 0.55228f;
        float f10 = 0.55228f * f8;
        this.IlO.reset();
        if (this.vCE.tV()) {
            float f11 = -f8;
            this.IlO.moveTo(0.0f, f11);
            float f12 = 0.0f - f9;
            float f13 = -f4;
            float f14 = 0.0f - f10;
            this.IlO.cubicTo(f12, f11, f13, f14, f13, 0.0f);
            float f15 = f10 + 0.0f;
            this.IlO.cubicTo(f13, f15, f12, f8, 0.0f, f8);
            float f16 = f9 + 0.0f;
            this.IlO.cubicTo(f16, f8, f4, f15, f4, 0.0f);
            this.IlO.cubicTo(f4, f14, f16, f11, 0.0f, f11);
        } else {
            float f17 = -f8;
            this.IlO.moveTo(0.0f, f17);
            float f18 = f9 + 0.0f;
            float f19 = 0.0f - f10;
            this.IlO.cubicTo(f18, f17, f4, f19, f4, 0.0f);
            float f20 = f10 + 0.0f;
            this.IlO.cubicTo(f4, f20, f18, f8, 0.0f, f8);
            float f21 = 0.0f - f9;
            float f22 = -f4;
            this.IlO.cubicTo(f21, f8, f22, f20, f22, 0.0f);
            this.IlO.cubicTo(f22, f19, f21, f17, 0.0f, f17);
        }
        PointF pointFBc2 = this.Cc.Bc();
        this.IlO.offset(pointFBc2.x, pointFBc2.y);
        this.IlO.close();
        this.Bc.IlO(this.IlO);
        this.lEW = true;
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            EO eo = list.get(i2);
            if (eo instanceof oeT) {
                oeT oet = (oeT) eo;
                if (oet.MY() == xF.IlO.SIMULTANEOUSLY) {
                    this.Bc.IlO(oet);
                    oet.IlO(this);
                }
            }
        }
    }
}
