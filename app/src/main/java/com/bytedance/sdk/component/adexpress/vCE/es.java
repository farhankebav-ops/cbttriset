package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es extends View {
    private float Bc;
    private Paint Cc;
    private Animator.AnimatorListener DmF;
    private ValueAnimator EO;
    private float IlO;
    private float MY;
    private int NV;
    private float lEW;
    private ValueAnimator tV;
    private long vCE;

    public es(Context context, int i2) {
        super(context);
        this.vCE = 300L;
        this.Bc = 0.0f;
        this.NV = i2;
        IlO();
    }

    public void EO() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.lEW, 0.0f);
        this.tV = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vCE);
        this.tV.setInterpolator(new LinearInterpolator());
        this.tV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.es.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                es.this.Bc = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                es.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.DmF;
        if (animatorListener != null) {
            this.tV.addListener(animatorListener);
        }
        this.tV.start();
    }

    public void MY() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.lEW);
        this.EO = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vCE);
        this.EO.setInterpolator(new LinearInterpolator());
        this.EO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.es.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                es.this.Bc = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                es.this.invalidate();
            }
        });
        this.EO.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.IlO, this.MY, this.Bc, this.Cc);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.IlO = i2 / 2.0f;
        this.MY = i8 / 2.0f;
        this.lEW = (float) (Math.hypot(i2, i8) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.DmF = animatorListener;
    }

    public void IlO() {
        Paint paint = new Paint(1);
        this.Cc = paint;
        paint.setStyle(Paint.Style.FILL);
        this.Cc.setColor(this.NV);
    }
}
