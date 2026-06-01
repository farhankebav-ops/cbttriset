package com.bytedance.adsdk.MY.EO.EO;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends IlO {
    private final RectF Bc;
    private final float[] DmF;
    private final Cc EV;
    private final Path NV;
    private final Paint lEW;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> rp;

    public lEW(com.bytedance.adsdk.MY.DmF dmF, Cc cc) {
        super(dmF, cc);
        this.Bc = new RectF();
        com.bytedance.adsdk.MY.IlO.IlO ilO = new com.bytedance.adsdk.MY.IlO.IlO();
        this.lEW = ilO;
        this.DmF = new float[8];
        this.NV = new Path();
        this.EV = cc;
        ilO.setAlpha(0);
        ilO.setStyle(Paint.Style.FILL);
        ilO.setColor(cc.zPa());
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        super.IlO(rectF, matrix, z2);
        this.Bc.set(0.0f, 0.0f, this.EV.cL(), this.EV.cl());
        this.IlO.mapRect(this.Bc);
        rectF.set(this.Bc);
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        super.MY(canvas, matrix, i2);
        int iAlpha = Color.alpha(this.EV.zPa());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.tV.IlO() == null ? 100 : this.tV.IlO().Bc().intValue())) / 100.0f) * (i2 / 255.0f) * 255.0f);
        this.lEW.setAlpha(iIntValue);
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.rp;
        if (ilO != null) {
            this.lEW.setColorFilter(ilO.Bc());
        }
        if (iIntValue > 0) {
            float[] fArr = this.DmF;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.EV.cL();
            float[] fArr2 = this.DmF;
            fArr2[3] = 0.0f;
            fArr2[4] = this.EV.cL();
            this.DmF[5] = this.EV.cl();
            float[] fArr3 = this.DmF;
            fArr3[6] = 0.0f;
            fArr3[7] = this.EV.cl();
            matrix.mapPoints(this.DmF);
            this.NV.reset();
            Path path = this.NV;
            float[] fArr4 = this.DmF;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.NV;
            float[] fArr5 = this.DmF;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.NV;
            float[] fArr6 = this.DmF;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.NV;
            float[] fArr7 = this.DmF;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.NV;
            float[] fArr8 = this.DmF;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.NV.close();
            canvas.drawPath(this.NV, this.lEW);
        }
    }
}
