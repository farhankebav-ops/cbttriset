package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp extends com.bytedance.sdk.openadsdk.core.Cc.tV {
    private Paint IlO;
    private RectF MY;

    public hp(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.IlO.setColor(Color.parseColor("#99333333"));
        this.IlO.setAntiAlias(true);
        this.IlO.setStrokeWidth(0.0f);
        this.MY = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.MY;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.IlO);
        super.onDraw(canvas);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.tV, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        if (this.MY.right == getMeasuredWidth() && this.MY.bottom == getMeasuredHeight()) {
            return;
        }
        this.MY.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
