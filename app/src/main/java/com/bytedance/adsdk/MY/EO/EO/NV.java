package com.bytedance.adsdk.MY.EO.EO;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends tV {
    private int DmF;
    private int NV;
    private Path lEW;

    public NV(com.bytedance.adsdk.MY.DmF dmF, Cc cc, Context context) {
        super(dmF, cc);
        this.lEW = null;
        this.DmF = -1;
        this.NV = -1;
        if (((tV) this).Bc != null) {
            float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
            this.DmF = (int) (((tV) this).Bc.IlO() * fIlO);
            this.NV = (int) (((tV) this).Bc.MY() * fIlO);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.DmF, this.NV);
            Path path = new Path();
            this.lEW = path;
            float f4 = fIlO * 40.0f;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        }
    }

    private static void IlO(View view, int i2, int i8) {
        view.layout(0, 0, i2, i8);
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i8, BasicMeasure.EXACTLY));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.tV, com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        View viewIlO = this.MY.IlO();
        if (this.DmF <= 0 || viewIlO == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        IlO(i2);
        float fVCE = vCE();
        IlO(viewIlO, this.DmF, this.NV);
        viewIlO.setAlpha(fVCE);
        canvas.clipPath(this.lEW);
        viewIlO.draw(canvas);
        canvas.restore();
    }
}
