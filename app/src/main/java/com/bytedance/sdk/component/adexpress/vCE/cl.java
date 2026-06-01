package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl extends View {
    private boolean Bc;
    private ValueAnimator Cc;
    private RectF EO;
    private Context IlO;
    private Paint MY;
    private float tV;
    private int vCE;

    public cl(Context context) {
        super(context);
        this.vCE = 1500;
        this.IlO = context;
        Paint paint = new Paint();
        this.MY = paint;
        paint.setAntiAlias(true);
        this.MY.setStyle(Paint.Style.STROKE);
        this.MY.setStrokeWidth(10.0f);
        this.MY.setColor(Color.parseColor("#80FFFFFF"));
        this.EO = new RectF();
    }

    public void EO() {
        this.Bc = true;
        invalidate();
    }

    public void MY() {
        ValueAnimator valueAnimator = this.Cc;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Bc) {
            return;
        }
        canvas.drawArc(this.EO, 270.0f, this.tV, false, this.MY);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i8);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.EO.set(5.0f, 5.0f, i2 - 5, i8 - 5);
    }

    public void setDuration(int i2) {
        this.vCE = i2;
    }

    public void IlO() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.Cc = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vCE);
        this.Cc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.cl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cl.this.tV = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cl.this.requestLayout();
            }
        });
        this.Cc.start();
    }
}
