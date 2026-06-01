package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends IlO {
    private final LongSparseArray<RadialGradient> Bc;
    private final boolean Cc;
    private final com.bytedance.adsdk.MY.EO.MY.Bc DmF;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> EV;
    private final int NV;
    private com.bytedance.adsdk.MY.IlO.MY.cl bWL;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> hp;
    private final RectF lEW;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> rp;
    private final String tV;
    private final LongSparseArray<LinearGradient> vCE;

    public DmF(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.vCE vce) {
        super(dmF, ilO, vce.lEW().IlO(), vce.DmF().IlO(), vce.rp(), vce.tV(), vce.Bc(), vce.NV(), vce.EV());
        this.vCE = new LongSparseArray<>();
        this.Bc = new LongSparseArray<>();
        this.lEW = new RectF();
        this.tV = vce.IlO();
        this.DmF = vce.MY();
        this.Cc = vce.hp();
        this.NV = (int) (dmF.tl().Cc() / 32.0f);
        com.bytedance.adsdk.MY.IlO.MY.IlO<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> IlO = vce.EO().IlO();
        this.EV = IlO;
        IlO.IlO(this);
        ilO.IlO(IlO);
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO2 = vce.Cc().IlO();
        this.rp = IlO2;
        IlO2.IlO(this);
        ilO.IlO(IlO2);
        com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO3 = vce.vCE().IlO();
        this.hp = IlO3;
        IlO3.IlO(this);
        ilO.IlO(IlO3);
    }

    private RadialGradient EO() {
        long jTV = tV();
        RadialGradient radialGradient = this.Bc.get(jTV);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFBc = this.rp.Bc();
        PointF pointFBc2 = this.hp.Bc();
        com.bytedance.adsdk.MY.EO.MY.tV tVVarBc = this.EV.Bc();
        int[] iArrIlO = IlO(tVVarBc.MY());
        float[] fArrIlO = tVVarBc.IlO();
        RadialGradient radialGradient2 = new RadialGradient(pointFBc.x, pointFBc.y, (float) Math.hypot(pointFBc2.x - r7, pointFBc2.y - r8), iArrIlO, fArrIlO, Shader.TileMode.CLAMP);
        this.Bc.put(jTV, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient MY() {
        long jTV = tV();
        LinearGradient linearGradient = this.vCE.get(jTV);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFBc = this.rp.Bc();
        PointF pointFBc2 = this.hp.Bc();
        com.bytedance.adsdk.MY.EO.MY.tV tVVarBc = this.EV.Bc();
        LinearGradient linearGradient2 = new LinearGradient(pointFBc.x, pointFBc.y, pointFBc2.x, pointFBc2.y, IlO(tVVarBc.MY()), tVVarBc.IlO(), Shader.TileMode.CLAMP);
        this.vCE.put(jTV, linearGradient2);
        return linearGradient2;
    }

    private int tV() {
        int iRound = Math.round(this.rp.lEW() * this.NV);
        int iRound2 = Math.round(this.hp.lEW() * this.NV);
        int iRound3 = Math.round(this.EV.lEW() * this.NV);
        int i2 = iRound != 0 ? iRound * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        if (this.Cc) {
            return;
        }
        IlO(this.lEW, matrix, false);
        Shader shaderMY = this.DmF == com.bytedance.adsdk.MY.EO.MY.Bc.LINEAR ? MY() : EO();
        shaderMY.setLocalMatrix(matrix);
        this.MY.setShader(shaderMY);
        super.IlO(canvas, matrix, i2);
    }

    private int[] IlO(int[] iArr) {
        if (this.bWL == null) {
            return iArr;
        }
        throw null;
    }
}
