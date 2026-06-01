package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT extends FrameLayout {
    private AnimatorSet Bc;
    private TextView Cc;
    private AnimatorSet DmF;
    private ImageView EO;
    private Context IlO;
    private ImageView MY;
    private AnimatorSet lEW;
    private ImageView tV;
    private AnimatorSet vCE;

    public oeT(@NonNull Context context) {
        super(context);
        this.vCE = new AnimatorSet();
        this.Bc = new AnimatorSet();
        this.lEW = new AnimatorSet();
        this.DmF = new AnimatorSet();
        this.IlO = context;
        EO();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
    }

    public void setGuideText(String str) {
        this.Cc.setText(str);
    }

    private void EO() {
        ImageView imageView = new ImageView(this.IlO);
        this.tV = imageView;
        imageView.setBackgroundResource(com.bytedance.sdk.component.utils.pP.tV(this.IlO, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 30.0f);
        addView(this.tV, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.IlO);
        this.EO = imageView2;
        imageView2.setImageResource(com.bytedance.sdk.component.utils.pP.tV(this.IlO, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 50.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 30.0f);
        addView(this.EO, layoutParams2);
        ImageView imageView3 = new ImageView(this.IlO);
        this.MY = imageView3;
        imageView3.setImageResource(com.bytedance.sdk.component.utils.pP.tV(this.IlO, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 30.0f);
        addView(this.MY, layoutParams3);
        TextView textView = new TextView(this.IlO);
        this.Cc = textView;
        textView.setTextColor(-1);
        this.Cc.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.Cc, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.oeT.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) oeT.this.MY.getLayoutParams();
                layoutParams5.topMargin = (int) ((oeT.this.EO.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(oeT.this.getContext(), 7.0f));
                int iIlO = (-oeT.this.EO.getMeasuredWidth()) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(oeT.this.IlO, 30.0f));
                layoutParams5.leftMargin = iIlO;
                layoutParams5.setMarginStart(iIlO);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                oeT.this.MY.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) oeT.this.tV.getLayoutParams();
                layoutParams6.topMargin = (int) ((oeT.this.EO.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(oeT.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((oeT.this.EO.getMeasuredWidth() / 2.0f) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(oeT.this.IlO, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                oeT.this.tV.setLayoutParams(layoutParams6);
            }
        });
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.MY, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.EO, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.EO, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.tV, "alpha", 0.0f, 1.0f);
        this.lEW.setDuration(300L);
        this.lEW.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.MY, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.oeT.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oeT.this.tV.getLayoutParams();
                layoutParams.width = num.intValue();
                oeT.this.tV.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.EO, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.DmF.setDuration(1500L);
        this.DmF.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.MY, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.tV, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.EO, "alpha", 1.0f, 0.0f);
        this.Bc.setDuration(50L);
        this.Bc.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.vCE.playSequentially(this.lEW, this.DmF, this.Bc);
    }

    public void IlO() {
        tV();
        this.vCE.start();
        this.vCE.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.vCE.oeT.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                oeT.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.oeT.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        oeT.this.vCE.start();
                    }
                }, 200L);
            }
        });
    }

    public void MY() {
        try {
            AnimatorSet animatorSet = this.vCE;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.lEW;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.DmF;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.Bc;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }
}
