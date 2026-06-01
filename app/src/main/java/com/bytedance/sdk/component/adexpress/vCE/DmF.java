package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends View {
    private Paint Bc;
    private Paint Cc;
    private final RectF EO;
    private int IlO;
    private int MY;
    private int lEW;
    private Paint tV;
    private int vCE;

    public DmF(Context context) {
        super(context);
        this.EO = new RectF();
        IlO();
    }

    private void IlO() {
        Paint paint = new Paint();
        this.tV = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.Bc = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.Cc = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.EO;
        int i2 = this.vCE;
        canvas.drawRoundRect(rectF, i2, i2, this.Cc);
        RectF rectF2 = this.EO;
        int i8 = this.vCE;
        canvas.drawRoundRect(rectF2, i8, i8, this.tV);
        int i9 = this.IlO;
        int i10 = this.MY;
        canvas.drawLine(i9 * 0.3f, i10 * 0.3f, i9 * 0.7f, i10 * 0.7f, this.Bc);
        int i11 = this.IlO;
        int i12 = this.MY;
        canvas.drawLine(i11 * 0.7f, i12 * 0.3f, i11 * 0.3f, i12 * 0.7f, this.Bc);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.IlO = i2;
        this.MY = i8;
        RectF rectF = this.EO;
        int i11 = this.lEW;
        rectF.set(i11, i11, i2 - i11, i8 - i11);
    }

    public void setBgColor(int i2) {
        this.Cc.setStyle(Paint.Style.FILL);
        this.Cc.setColor(i2);
    }

    public void setDislikeColor(int i2) {
        this.Bc.setColor(i2);
    }

    public void setDislikeWidth(int i2) {
        this.Bc.setStrokeWidth(i2);
    }

    public void setRadius(int i2) {
        this.vCE = i2;
    }

    public void setStrokeColor(int i2) {
        this.tV.setStyle(Paint.Style.STROKE);
        this.tV.setColor(i2);
    }

    public void setStrokeWidth(int i2) {
        this.tV.setStrokeWidth(i2);
        this.lEW = i2;
    }
}
