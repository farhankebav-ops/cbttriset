package com.bytedance.adsdk.MY.EO.EO;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    protected final com.bytedance.adsdk.MY.NV Bc;
    private final Rect DmF;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> EV;
    private final Rect NV;
    private final Paint lEW;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Bitmap, Bitmap> rp;

    public tV(com.bytedance.adsdk.MY.DmF dmF, Cc cc) {
        super(dmF, cc);
        this.lEW = new com.bytedance.adsdk.MY.IlO.IlO(3);
        this.DmF = new Rect();
        this.NV = new Rect();
        this.Bc = dmF.vCE(cc.Bc());
    }

    private Bitmap rp() {
        Bitmap bitmapBc;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Bitmap, Bitmap> ilO = this.rp;
        if (ilO != null && (bitmapBc = ilO.Bc()) != null) {
            return bitmapBc;
        }
        Bitmap bitmapCc = this.MY.Cc(this.EO.Bc());
        if (bitmapCc != null) {
            return bitmapCc;
        }
        com.bytedance.adsdk.MY.NV nv = this.Bc;
        if (nv != null) {
            return nv.EV();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        super.IlO(rectF, matrix, z2);
        if (this.Bc != null) {
            float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
            rectF.set(0.0f, 0.0f, this.Bc.IlO() * fIlO, this.Bc.MY() * fIlO);
            this.IlO.mapRect(rectF);
        }
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        super.MY(canvas, matrix, i2);
        Bitmap bitmapRp = rp();
        if (bitmapRp == null || bitmapRp.isRecycled() || this.Bc == null) {
            return;
        }
        float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
        this.lEW.setAlpha(i2);
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.EV;
        if (ilO != null) {
            this.lEW.setColorFilter(ilO.Bc());
        }
        canvas.save();
        canvas.concat(matrix);
        this.DmF.set(0, 0, bitmapRp.getWidth(), bitmapRp.getHeight());
        if (this.MY.Cc()) {
            this.NV.set(0, 0, (int) (this.Bc.IlO() * fIlO), (int) (this.Bc.MY() * fIlO));
        } else {
            this.NV.set(0, 0, (int) (bitmapRp.getWidth() * fIlO), (int) (bitmapRp.getHeight() * fIlO));
        }
        canvas.drawBitmap(bitmapRp, this.DmF, this.NV, this.lEW);
        canvas.restore();
    }
}
