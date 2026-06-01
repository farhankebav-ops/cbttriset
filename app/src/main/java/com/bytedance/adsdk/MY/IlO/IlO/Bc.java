package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements Cc, EV, IlO.InterfaceC0025IlO {
    private final List<hp> Bc;
    private final String Cc;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> DmF;
    private final Paint EO;
    private final com.bytedance.adsdk.MY.DmF EV;
    float IlO;
    private final Path MY;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> NV;
    private com.bytedance.adsdk.MY.IlO.MY.EO hp;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> lEW;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> rp;
    private final com.bytedance.adsdk.MY.EO.EO.IlO tV;
    private final boolean vCE;

    public Bc(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.ea eaVar) {
        Path path = new Path();
        this.MY = path;
        this.EO = new com.bytedance.adsdk.MY.IlO.IlO(1);
        this.Bc = new ArrayList();
        this.tV = ilO;
        this.Cc = eaVar.IlO();
        this.vCE = eaVar.Cc();
        this.EV = dmF;
        if (ilO.NV() != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = ilO.NV().IlO().IlO();
            this.rp = IlO;
            IlO.IlO(this);
            ilO.IlO(this.rp);
        }
        if (ilO.EV() != null) {
            this.hp = new com.bytedance.adsdk.MY.IlO.MY.EO(this, ilO, ilO.EV());
        }
        if (eaVar.MY() == null || eaVar.EO() == null) {
            this.lEW = null;
            this.DmF = null;
            return;
        }
        path.setFillType(eaVar.tV());
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO2 = eaVar.MY().IlO();
        this.lEW = IlO2;
        IlO2.IlO(this);
        ilO.IlO(IlO2);
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO3 = eaVar.EO().IlO();
        this.DmF = IlO3;
        IlO3.IlO(this);
        ilO.IlO(IlO3);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.EV.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            EO eo = list2.get(i2);
            if (eo instanceof hp) {
                this.Bc.add((hp) eo);
            }
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        if (this.vCE) {
            return;
        }
        com.bytedance.adsdk.MY.Cc.IlO("FillContent#draw");
        this.EO.setColor((com.bytedance.adsdk.MY.vCE.Cc.IlO((int) ((((i2 / 255.0f) * this.DmF.Bc().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.MY.IlO.MY.MY) this.lEW).DmF() & ViewCompat.MEASURED_SIZE_MASK));
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.NV;
        if (ilO != null) {
            this.EO.setColorFilter(ilO.Bc());
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO2 = this.rp;
        if (ilO2 != null) {
            float fFloatValue = ilO2.Bc().floatValue();
            if (fFloatValue == 0.0f) {
                this.EO.setMaskFilter(null);
            } else if (fFloatValue != this.IlO) {
                this.EO.setMaskFilter(this.tV.MY(fFloatValue));
            }
            this.IlO = fFloatValue;
        }
        com.bytedance.adsdk.MY.IlO.MY.EO eo = this.hp;
        if (eo != null) {
            eo.IlO(this.EO);
        }
        this.MY.reset();
        for (int i8 = 0; i8 < this.Bc.size(); i8++) {
            this.MY.addPath(this.Bc.get(i8).tV(), matrix);
        }
        canvas.drawPath(this.MY, this.EO);
        com.bytedance.adsdk.MY.Cc.MY("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        this.MY.reset();
        for (int i2 = 0; i2 < this.Bc.size(); i2++) {
            this.MY.addPath(this.Bc.get(i2).tV(), matrix);
        }
        this.MY.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
