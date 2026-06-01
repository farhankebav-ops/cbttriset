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
public class bWL extends FrameLayout {
    private boolean Cc;
    private tV EO;
    private Context IlO;
    private ImageView MY;
    private AnimatorSet tV;
    private TextView vCE;

    public bWL(@NonNull Context context) {
        super(context);
        this.Cc = true;
        this.IlO = context;
        this.tV = new AnimatorSet();
        EO();
        tV();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.bWL.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bWL.this.MY.getLayoutParams();
                layoutParams.topMargin = ((int) ((bWL.this.EO.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.IlO, 20.0f));
                layoutParams.leftMargin = ((int) ((bWL.this.EO.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.IlO, 20.0f));
                layoutParams.bottomMargin = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.getContext(), 5.0f) + ((-bWL.this.EO.getMeasuredHeight()) / 2.0f));
                layoutParams.rightMargin = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(bWL.this.getContext(), 5.0f) + ((-bWL.this.EO.getMeasuredWidth()) / 2.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                bWL.this.MY.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.vCE.setText(str);
    }

    public void setGuideTextColor(int i2) {
        this.vCE.setTextColor(i2);
    }

    private void EO() {
        this.EO = new tV(this.IlO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 20.0f);
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 20.0f);
        layoutParams.leftMargin = iIlO;
        layoutParams.setMarginStart(iIlO);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.EO, layoutParams);
        this.EO.IlO();
        this.MY = new ImageView(this.IlO);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 80.0f));
        this.MY.setImageResource(com.bytedance.sdk.component.utils.pP.tV(this.IlO, "tt_splash_hand"));
        addView(this.MY, layoutParams2);
        TextView textView = new TextView(this.IlO);
        this.vCE = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 10.0f);
        addView(this.vCE, layoutParams3);
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.MY, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.bWL.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (bWL.this.Cc) {
                    bWL.this.EO.IlO();
                    bWL.this.EO.setAlpha(1.0f);
                } else {
                    bWL.this.EO.MY();
                    bWL.this.EO.setAlpha(0.0f);
                }
                bWL.this.Cc = !r2.Cc;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(bWL.this.MY, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                bWL.this.MY.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.MY, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tV.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void MY() {
        AnimatorSet animatorSet = this.tV;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.MY();
        }
    }

    public void IlO() {
        this.tV.start();
    }
}
