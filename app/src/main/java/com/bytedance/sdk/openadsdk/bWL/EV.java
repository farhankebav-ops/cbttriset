package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends View {
    private float EO;
    private final Paint IlO;
    private float MY;

    public EV(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#8A8A8A"));
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f4 = this.EO;
        if (f4 > 0.0f) {
            float f8 = this.MY;
            canvas.drawLine(0.0f, f8, f4, f8, this.IlO);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        float f4 = i8;
        this.MY = (1.0f * f4) / 2.0f;
        this.IlO.setStrokeWidth(f4);
    }

    public void setProgress(float f4) {
        this.EO = getWidth() * f4;
        invalidate();
    }
}
