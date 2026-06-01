package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends com.bytedance.sdk.openadsdk.core.Cc.lEW {
    private int EO;
    private Paint IlO;
    private RectF MY;

    public bWL(Context context) {
        this(context, null);
    }

    private void IlO() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.IlO.setColor(Color.parseColor("#99333333"));
        this.IlO.setAntiAlias(true);
        this.IlO.setStrokeWidth(0.0f);
        this.MY = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.MY;
        float f4 = rectF.bottom;
        canvas.drawRoundRect(rectF, f4 / 2.0f, f4 / 2.0f, this.IlO);
        canvas.translate((this.MY.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.lEW, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.MY.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int iMeasureText = (int) getPaint().measureText("00");
        this.EO = iMeasureText;
        if (measuredWidth < iMeasureText) {
            measuredWidth = iMeasureText;
        }
        int i9 = ((measuredHeight / 2) * 2) + measuredWidth;
        setMeasuredDimension(i9, measuredHeight);
        this.MY.set(0.0f, 0.0f, i9, measuredHeight);
    }

    public bWL(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bWL(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.EO = 0;
        IlO();
    }
}
