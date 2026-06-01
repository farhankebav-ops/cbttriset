package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private IlO<?, PointF> Bc;
    private final float[] Cc;
    private IlO<Float, Float> DmF;
    private final Matrix EO;
    private tV EV;
    private final Matrix IlO = new Matrix();
    private final Matrix MY;
    private IlO<Integer, Integer> NV;
    private IlO<?, Float> bWL;
    private IlO<?, Float> hp;
    private IlO<com.bytedance.adsdk.MY.Bc.EO, com.bytedance.adsdk.MY.Bc.EO> lEW;
    private tV rp;
    private final Matrix tV;
    private IlO<PointF, PointF> vCE;

    public zPa(com.bytedance.adsdk.MY.EO.IlO.rp rpVar) {
        this.vCE = rpVar.IlO() == null ? null : rpVar.IlO().IlO();
        this.Bc = rpVar.MY() == null ? null : rpVar.MY().IlO();
        this.lEW = rpVar.EO() == null ? null : rpVar.EO().IlO();
        this.DmF = rpVar.tV() == null ? null : rpVar.tV().IlO();
        tV tVVar = rpVar.lEW() == null ? null : (tV) rpVar.lEW().IlO();
        this.EV = tVVar;
        if (tVVar != null) {
            this.MY = new Matrix();
            this.EO = new Matrix();
            this.tV = new Matrix();
            this.Cc = new float[9];
        } else {
            this.MY = null;
            this.EO = null;
            this.tV = null;
            this.Cc = null;
        }
        this.rp = rpVar.DmF() == null ? null : (tV) rpVar.DmF().IlO();
        if (rpVar.Cc() != null) {
            this.NV = rpVar.Cc().IlO();
        }
        if (rpVar.vCE() != null) {
            this.hp = rpVar.vCE().IlO();
        } else {
            this.hp = null;
        }
        if (rpVar.Bc() != null) {
            this.bWL = rpVar.Bc().IlO();
        } else {
            this.bWL = null;
        }
    }

    private void Cc() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.Cc[i2] = 0.0f;
        }
    }

    public IlO<?, Float> EO() {
        return this.bWL;
    }

    public void IlO(com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        ilO.IlO(this.NV);
        ilO.IlO(this.hp);
        ilO.IlO(this.bWL);
        ilO.IlO(this.vCE);
        ilO.IlO(this.Bc);
        ilO.IlO(this.lEW);
        ilO.IlO(this.DmF);
        ilO.IlO(this.EV);
        ilO.IlO(this.rp);
    }

    public IlO<?, Float> MY() {
        return this.hp;
    }

    public Matrix tV() {
        PointF pointFBc;
        PointF pointFBc2;
        this.IlO.reset();
        IlO<?, PointF> ilO = this.Bc;
        if (ilO != null && (pointFBc2 = ilO.Bc()) != null) {
            float f4 = pointFBc2.x;
            if (f4 != 0.0f || pointFBc2.y != 0.0f) {
                this.IlO.preTranslate(f4, pointFBc2.y);
            }
        }
        IlO<Float, Float> ilO2 = this.DmF;
        if (ilO2 != null) {
            float fFloatValue = ilO2 instanceof cl ? ilO2.Bc().floatValue() : ((tV) ilO2).DmF();
            if (fFloatValue != 0.0f) {
                this.IlO.preRotate(fFloatValue);
            }
        }
        if (this.EV != null) {
            float fCos = this.rp == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.DmF()) + 90.0f));
            float fSin = this.rp == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.DmF()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.DmF()));
            Cc();
            float[] fArr = this.Cc;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f8 = -fSin;
            fArr[3] = f8;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.MY.setValues(fArr);
            Cc();
            float[] fArr2 = this.Cc;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.EO.setValues(fArr2);
            Cc();
            float[] fArr3 = this.Cc;
            fArr3[0] = fCos;
            fArr3[1] = f8;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.tV.setValues(fArr3);
            this.EO.preConcat(this.MY);
            this.tV.preConcat(this.EO);
            this.IlO.preConcat(this.tV);
        }
        IlO<com.bytedance.adsdk.MY.Bc.EO, com.bytedance.adsdk.MY.Bc.EO> ilO3 = this.lEW;
        if (ilO3 != null) {
            com.bytedance.adsdk.MY.Bc.EO eoBc = ilO3.Bc();
            if (eoBc.IlO() != 1.0f || eoBc.MY() != 1.0f) {
                this.IlO.preScale(eoBc.IlO(), eoBc.MY());
            }
        }
        IlO<PointF, PointF> ilO4 = this.vCE;
        if (ilO4 != null && (((pointFBc = ilO4.Bc()) != null && pointFBc.x != 0.0f) || pointFBc.y != 0.0f)) {
            this.IlO.preTranslate(-pointFBc.x, -pointFBc.y);
        }
        return this.IlO;
    }

    public Matrix MY(float f4) {
        IlO<?, PointF> ilO = this.Bc;
        PointF pointFBc = ilO == null ? null : ilO.Bc();
        IlO<com.bytedance.adsdk.MY.Bc.EO, com.bytedance.adsdk.MY.Bc.EO> ilO2 = this.lEW;
        com.bytedance.adsdk.MY.Bc.EO eoBc = ilO2 == null ? null : ilO2.Bc();
        this.IlO.reset();
        if (pointFBc != null) {
            this.IlO.preTranslate(pointFBc.x * f4, pointFBc.y * f4);
        }
        if (eoBc != null) {
            double d8 = f4;
            this.IlO.preScale((float) Math.pow(eoBc.IlO(), d8), (float) Math.pow(eoBc.MY(), d8));
        }
        IlO<Float, Float> ilO3 = this.DmF;
        if (ilO3 != null) {
            float fFloatValue = ilO3.Bc().floatValue();
            IlO<PointF, PointF> ilO4 = this.vCE;
            PointF pointFBc2 = ilO4 != null ? ilO4.Bc() : null;
            this.IlO.preRotate(fFloatValue * f4, pointFBc2 == null ? 0.0f : pointFBc2.x, pointFBc2 != null ? pointFBc2.y : 0.0f);
        }
        return this.IlO;
    }

    public void IlO(IlO.InterfaceC0025IlO interfaceC0025IlO) {
        IlO<Integer, Integer> ilO = this.NV;
        if (ilO != null) {
            ilO.IlO(interfaceC0025IlO);
        }
        IlO<?, Float> ilO2 = this.hp;
        if (ilO2 != null) {
            ilO2.IlO(interfaceC0025IlO);
        }
        IlO<?, Float> ilO3 = this.bWL;
        if (ilO3 != null) {
            ilO3.IlO(interfaceC0025IlO);
        }
        IlO<PointF, PointF> ilO4 = this.vCE;
        if (ilO4 != null) {
            ilO4.IlO(interfaceC0025IlO);
        }
        IlO<?, PointF> ilO5 = this.Bc;
        if (ilO5 != null) {
            ilO5.IlO(interfaceC0025IlO);
        }
        IlO<com.bytedance.adsdk.MY.Bc.EO, com.bytedance.adsdk.MY.Bc.EO> ilO6 = this.lEW;
        if (ilO6 != null) {
            ilO6.IlO(interfaceC0025IlO);
        }
        IlO<Float, Float> ilO7 = this.DmF;
        if (ilO7 != null) {
            ilO7.IlO(interfaceC0025IlO);
        }
        tV tVVar = this.EV;
        if (tVVar != null) {
            tVVar.IlO(interfaceC0025IlO);
        }
        tV tVVar2 = this.rp;
        if (tVVar2 != null) {
            tVVar2.IlO(interfaceC0025IlO);
        }
    }

    public void IlO(float f4) {
        IlO<Integer, Integer> ilO = this.NV;
        if (ilO != null) {
            ilO.IlO(f4);
        }
        IlO<?, Float> ilO2 = this.hp;
        if (ilO2 != null) {
            ilO2.IlO(f4);
        }
        IlO<?, Float> ilO3 = this.bWL;
        if (ilO3 != null) {
            ilO3.IlO(f4);
        }
        IlO<PointF, PointF> ilO4 = this.vCE;
        if (ilO4 != null) {
            ilO4.IlO(f4);
        }
        IlO<?, PointF> ilO5 = this.Bc;
        if (ilO5 != null) {
            ilO5.IlO(f4);
        }
        IlO<com.bytedance.adsdk.MY.Bc.EO, com.bytedance.adsdk.MY.Bc.EO> ilO6 = this.lEW;
        if (ilO6 != null) {
            ilO6.IlO(f4);
        }
        IlO<Float, Float> ilO7 = this.DmF;
        if (ilO7 != null) {
            ilO7.IlO(f4);
        }
        tV tVVar = this.EV;
        if (tVVar != null) {
            tVVar.IlO(f4);
        }
        tV tVVar2 = this.rp;
        if (tVVar2 != null) {
            tVVar2.IlO(f4);
        }
    }

    public IlO<?, Integer> IlO() {
        return this.NV;
    }
}
