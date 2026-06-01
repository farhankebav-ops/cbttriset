package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW implements Cc, EV, IlO.InterfaceC0025IlO {
    private com.bytedance.adsdk.MY.IlO.MY.EO AXM;
    private final Path Bc;
    private final RectF DmF;
    private final boolean EO;
    private final com.bytedance.adsdk.MY.EO.MY.Bc EV;
    float IlO;
    private final String MY;
    private final List<hp> NV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> bWL;
    private final com.bytedance.adsdk.MY.DmF cL;
    private com.bytedance.adsdk.MY.IlO.MY.cl cl;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> ea;
    private final int es;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> hp;
    private final Paint lEW;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> rp;
    private final com.bytedance.adsdk.MY.EO.EO.IlO tV;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> xF;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> zPa;
    private final LongSparseArray<LinearGradient> Cc = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> vCE = new LongSparseArray<>();

    public lEW(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.Cc cc) {
        Path path = new Path();
        this.Bc = path;
        this.lEW = new com.bytedance.adsdk.MY.IlO.IlO(1);
        this.DmF = new RectF();
        this.NV = new ArrayList();
        this.IlO = 0.0f;
        this.tV = ilO;
        this.MY = cc.IlO();
        this.EO = cc.lEW();
        this.cL = dmF;
        this.EV = cc.MY();
        path.setFillType(cc.EO());
        this.es = (int) (bc.Cc() / 32.0f);
        com.bytedance.adsdk.MY.IlO.MY.IlO<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> IlO = cc.tV().IlO();
        this.rp = IlO;
        IlO.IlO(this);
        ilO.IlO(IlO);
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO2 = cc.Cc().IlO();
        this.hp = IlO2;
        IlO2.IlO(this);
        ilO.IlO(IlO2);
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO3 = cc.vCE().IlO();
        this.bWL = IlO3;
        IlO3.IlO(this);
        ilO.IlO(IlO3);
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO4 = cc.Bc().IlO();
        this.ea = IlO4;
        IlO4.IlO(this);
        ilO.IlO(IlO4);
        if (ilO.NV() != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO5 = ilO.NV().IlO().IlO();
            this.xF = IlO5;
            IlO5.IlO(this);
            ilO.IlO(this.xF);
        }
        if (ilO.EV() != null) {
            this.AXM = new com.bytedance.adsdk.MY.IlO.MY.EO(this, ilO, ilO.EV());
        }
    }

    private RadialGradient EO() {
        long jTV = tV();
        RadialGradient radialGradient = this.vCE.get(jTV);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFBc = this.bWL.Bc();
        PointF pointFBc2 = this.ea.Bc();
        com.bytedance.adsdk.MY.EO.MY.tV tVVarBc = this.rp.Bc();
        int[] iArrIlO = IlO(tVVarBc.MY());
        float[] fArrIlO = tVVarBc.IlO();
        float f4 = pointFBc.x;
        float f8 = pointFBc.y;
        float fHypot = (float) Math.hypot(pointFBc2.x - f4, pointFBc2.y - f8);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f4, f8, fHypot, iArrIlO, fArrIlO, Shader.TileMode.CLAMP);
        this.vCE.put(jTV, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient MY() {
        long jTV = tV();
        LinearGradient linearGradient = this.Cc.get(jTV);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFBc = this.bWL.Bc();
        PointF pointFBc2 = this.ea.Bc();
        com.bytedance.adsdk.MY.EO.MY.tV tVVarBc = this.rp.Bc();
        LinearGradient linearGradient2 = new LinearGradient(pointFBc.x, pointFBc.y, pointFBc2.x, pointFBc2.y, IlO(tVVarBc.MY()), tVVarBc.IlO(), Shader.TileMode.CLAMP);
        this.Cc.put(jTV, linearGradient2);
        return linearGradient2;
    }

    private int tV() {
        int iRound = Math.round(this.bWL.lEW() * this.es);
        int iRound2 = Math.round(this.ea.lEW() * this.es);
        int iRound3 = Math.round(this.rp.lEW() * this.es);
        int i2 = iRound != 0 ? iRound * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.cL.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            EO eo = list2.get(i2);
            if (eo instanceof hp) {
                this.NV.add((hp) eo);
            }
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        Shader shaderEO;
        if (this.EO) {
            return;
        }
        com.bytedance.adsdk.MY.Cc.IlO("GradientFillContent#draw");
        this.Bc.reset();
        for (int i8 = 0; i8 < this.NV.size(); i8++) {
            this.Bc.addPath(this.NV.get(i8).tV(), matrix);
        }
        this.Bc.computeBounds(this.DmF, false);
        if (this.EV == com.bytedance.adsdk.MY.EO.MY.Bc.LINEAR) {
            shaderEO = MY();
        } else {
            shaderEO = EO();
        }
        shaderEO.setLocalMatrix(matrix);
        this.lEW.setShader(shaderEO);
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.zPa;
        if (ilO != null) {
            this.lEW.setColorFilter(ilO.Bc());
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO2 = this.xF;
        if (ilO2 != null) {
            float fFloatValue = ilO2.Bc().floatValue();
            if (fFloatValue == 0.0f) {
                this.lEW.setMaskFilter(null);
            } else if (fFloatValue != this.IlO) {
                this.lEW.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.IlO = fFloatValue;
        }
        com.bytedance.adsdk.MY.IlO.MY.EO eo = this.AXM;
        if (eo != null) {
            eo.IlO(this.lEW);
        }
        this.lEW.setAlpha(com.bytedance.adsdk.MY.vCE.Cc.IlO((int) ((((i2 / 255.0f) * this.hp.Bc().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.Bc, this.lEW);
        com.bytedance.adsdk.MY.Cc.MY("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        this.Bc.reset();
        for (int i2 = 0; i2 < this.NV.size(); i2++) {
            this.Bc.addPath(this.NV.get(i2).tV(), matrix);
        }
        this.Bc.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] IlO(int[] iArr) {
        if (this.cl == null) {
            return iArr;
        }
        throw null;
    }
}
