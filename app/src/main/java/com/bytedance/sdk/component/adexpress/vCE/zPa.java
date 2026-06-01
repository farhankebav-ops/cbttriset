package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa extends FrameLayout {
    private boolean Cc;
    private kBB EO;
    private Context IlO;
    private ImageView MY;
    private AnimatorSet tV;
    private TextView vCE;

    public zPa(@NonNull Context context) {
        super(context);
        this.Cc = true;
        this.IlO = context;
        this.tV = new AnimatorSet();
        EO();
        tV();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.zPa.1
            @Override // java.lang.Runnable
            public void run() {
                int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.IlO, 50.0f);
                int iIlO2 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.IlO, 50.0f);
                if (zPa.this.EO.getMeasuredHeight() > 0) {
                    iIlO = zPa.this.EO.getMeasuredHeight();
                }
                if (zPa.this.EO.getMeasuredWidth() > 0) {
                    iIlO2 = zPa.this.EO.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) zPa.this.MY.getLayoutParams();
                layoutParams.topMargin = ((int) ((iIlO / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.IlO, 40.0f));
                layoutParams.leftMargin = ((int) ((iIlO2 / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.IlO, 20.0f));
                layoutParams.bottomMargin = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.getContext(), 5.0f) + ((-iIlO) / 2.0f));
                layoutParams.rightMargin = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(zPa.this.getContext(), 5.0f) + ((-iIlO2) / 2.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                zPa.this.MY.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.vCE.setVisibility(0);
        this.vCE.setText(str);
    }

    public void setGuideTextColor(int i2) {
        this.vCE.setTextColor(i2);
    }

    private void EO() {
        this.EO = new kBB(this.IlO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 50.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 40.0f);
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 20.0f);
        layoutParams.leftMargin = iIlO;
        layoutParams.setMarginStart(iIlO);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.EO, layoutParams);
        this.MY = new ImageView(this.IlO);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 78.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 78.0f));
        this.MY.setImageResource(com.bytedance.sdk.component.utils.pP.tV(this.IlO, "tt_splash_hand"));
        addView(this.MY, layoutParams2);
        TextView textView = new TextView(this.IlO);
        this.vCE = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 10.0f);
        addView(this.vCE, layoutParams3);
        this.vCE.setVisibility(8);
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.MY, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.zPa.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (zPa.this.Cc) {
                    zPa.this.EO.IlO();
                }
                zPa.this.Cc = !r2.Cc;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(zPa.this.MY, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                zPa.this.MY.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.MY, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tV.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void MY() {
        AnimatorSet animatorSet = this.tV;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        kBB kbb = this.EO;
        if (kbb != null) {
            kbb.MY();
        }
        ImageView imageView = this.MY;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void IlO() {
        this.tV.start();
    }
}
