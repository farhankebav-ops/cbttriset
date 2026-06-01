package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends vCE {
    private Runnable AXM;
    ObjectAnimator IlO;
    ObjectAnimator MY;
    private int xF;

    public tV(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.xF = 0;
        this.AXM = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tV.1
            @Override // java.lang.Runnable
            public void run() {
                tV.this.IlO();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj
    public void MY() {
        removeCallbacks(this.AXM);
        ObjectAnimator objectAnimator = this.IlO;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.IlO.cancel();
        }
        ObjectAnimator objectAnimator2 = this.MY;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.MY.cancel();
        }
        super.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.lEW - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i2 != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.AXM, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO() {
        final View childAt = getChildAt(this.xF);
        final View childAt2 = getChildAt((this.xF + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(getChildAt(this.xF).getHeight() + this.lEW)) / 2);
        this.IlO = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.IlO.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tV.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (childAt2.getHeight() + this.lEW) / 2, 0.0f);
        this.MY = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.MY.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tV.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.IlO.setDuration(500L);
        this.MY.setDuration(500L);
        this.IlO.start();
        this.MY.start();
        int i2 = this.xF + 1;
        this.xF = i2;
        this.xF = i2 % getChildCount();
        postDelayed(this.AXM, 2000L);
    }
}
