package com.bytedance.sdk.openadsdk.core.Cc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends FrameLayout {
    private ValueAnimator Bc;
    private Drawable Cc;
    private Drawable EO;
    private int IlO;
    private int MY;
    private boolean lEW;
    private Drawable tV;
    private boolean vCE;

    public vCE(Context context) {
        super(context);
        this.IlO = 100;
    }

    private void IlO() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 10000);
        this.Bc = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(2000L);
        this.Bc.setRepeatCount(-1);
        this.Bc.setInterpolator(new LinearInterpolator());
        this.Bc.setRepeatMode(1);
        this.Bc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.Cc.vCE.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                vCE.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.Bc.start();
        setMax(10000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.vCE = true;
        if (this.Cc != null) {
            IlO();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.vCE = false;
        ValueAnimator valueAnimator = this.Bc;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.Bc.removeAllUpdateListeners();
            this.Bc = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            ValueAnimator valueAnimator = this.Bc;
            if (valueAnimator == null || this.lEW) {
                return;
            }
            this.lEW = true;
            valueAnimator.pause();
            return;
        }
        if (this.lEW) {
            this.lEW = false;
            ValueAnimator valueAnimator2 = this.Bc;
            if (valueAnimator2 != null) {
                valueAnimator2.resume();
            } else {
                IlO();
            }
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.Cc = drawable;
        setProgressDrawable(drawable);
        if (this.vCE && this.Bc == null) {
            IlO();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(DmF.IlO(this, layoutParams));
    }

    public void setMax(int i2) {
        this.IlO = i2;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i8, int i9, int i10) {
        super.setPaddingRelative(i2, i8, i9, i10);
    }

    public void setProgress(int i2) {
        this.MY = i2;
        Drawable drawable = this.EO;
        if (drawable != null) {
            drawable.setLevel((int) ((i2 * 10000.0f) / this.IlO));
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        this.tV = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.tV;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                Drawable drawable3 = ((LayerDrawable) this.tV).getDrawable(i2);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.EO = drawable3;
                }
            }
        }
        Drawable drawable4 = this.tV;
        if (drawable4 instanceof RotateDrawable) {
            this.EO = drawable4;
        }
    }

    public vCE(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.IlO = 100;
    }
}
