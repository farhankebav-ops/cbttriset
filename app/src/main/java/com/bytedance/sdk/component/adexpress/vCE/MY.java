package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends FrameLayout {
    private ImageView Bc;
    private View Cc;
    private int DmF;
    private boolean EO;
    private AnimatorSet IlO;
    private ObjectAnimator MY;
    private Context NV;
    private int lEW;
    private View tV;
    private View vCE;

    public MY(Context context, int i2, int i8) {
        super(context);
        this.EO = false;
        this.IlO = new AnimatorSet();
        this.lEW = i2;
        this.DmF = i8;
        this.NV = context;
        EO();
        tV();
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tV, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tV, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.Cc, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.Cc, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.vCE, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.vCE, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.Bc, Key.ROTATION, 0.0f, -20.0f, 0.0f);
        this.MY = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.IlO.setDuration(1500L);
        this.IlO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.IlO.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.IlO.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.MY.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                MY.this.EO = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MY.this.EO) {
                    return;
                }
                MY.this.MY.start();
                MY.this.IlO.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void EO() {
        View view = new View(this.NV);
        this.tV = view;
        view.setBackground(IlO("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.lEW) * 0.45d), (int) (((double) this.DmF) * 0.45d));
        layoutParams.gravity = 17;
        this.tV.setLayoutParams(layoutParams);
        addView(this.tV);
        View view2 = new View(this.NV);
        this.Cc = view2;
        view2.setBackground(IlO("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.lEW) * 0.25d), (int) (((double) this.DmF) * 0.25d));
        layoutParams2.gravity = 17;
        this.Cc.setLayoutParams(layoutParams2);
        addView(this.Cc);
        View view3 = new View(this.NV);
        this.vCE = view3;
        view3.setBackground(IlO("#807BBEFF", "#FF7BBEFF"));
        int i2 = this.lEW;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i2) * 0.25d), (int) (((double) i2) * 0.25d));
        layoutParams3.gravity = 17;
        this.vCE.setLayoutParams(layoutParams3);
        addView(this.vCE);
        ImageView imageView = new ImageView(this.NV);
        this.Bc = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_blue_hand"));
        this.Bc.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.lEW) * 0.62d), (int) (((double) this.DmF) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.Bc.setLayoutParams(layoutParams4);
        addView(this.Bc);
    }

    public void MY() {
        this.EO = true;
        ObjectAnimator objectAnimator = this.MY;
        if (objectAnimator == null || this.IlO == null) {
            return;
        }
        objectAnimator.cancel();
        this.IlO.cancel();
    }

    private GradientDrawable IlO(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void IlO() {
        this.EO = false;
        ObjectAnimator objectAnimator = this.MY;
        if (objectAnimator == null || this.IlO == null) {
            return;
        }
        objectAnimator.start();
        this.IlO.start();
    }
}
