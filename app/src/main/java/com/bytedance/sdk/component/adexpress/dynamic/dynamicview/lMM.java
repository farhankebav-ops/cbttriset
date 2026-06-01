package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lMM extends vCE {
    private boolean AXM;
    ObjectAnimator IlO;
    ObjectAnimator MY;
    private Runnable oeT;
    private int xF;

    public lMM(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.xF = 0;
        this.AXM = false;
        this.oeT = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lMM.1
            @Override // java.lang.Runnable
            public void run() {
                lMM.this.IlO();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj
    public void MY() {
        removeCallbacks(this.oeT);
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
        postDelayed(this.oeT, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO() {
        final View childAt;
        final View childAt2 = getChildAt(this.xF);
        int i2 = this.xF;
        if (i2 == 0) {
            this.AXM = false;
        }
        boolean z2 = i2 + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.xF + 1)).getChildCount() <= 0;
        if (this.hp.NV().Cc().IlO() || !z2) {
            View childAt3 = z2 ? getChildAt((this.xF + 2) % getChildCount()) : getChildAt((this.xF + 1) % getChildCount());
            this.IlO = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(getChildAt(this.xF).getHeight() + this.lEW)) / 2);
            if (z2) {
                this.xF++;
            }
            childAt = childAt3;
        } else {
            this.AXM = true;
            childAt = getChildAt(this.xF - 1);
            this.IlO = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (getChildAt(this.xF).getHeight() + this.lEW) / 2);
        }
        this.IlO.setInterpolator(new LinearInterpolator());
        this.IlO.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lMM.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
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
        if (this.AXM) {
            this.MY = ObjectAnimator.ofFloat(childAt, "translationY", (-(childAt.getHeight() + this.lEW)) / 2, 0.0f);
        } else {
            this.MY = ObjectAnimator.ofFloat(childAt, "translationY", (childAt.getHeight() + this.lEW) / 2, 0.0f);
        }
        this.MY.setInterpolator(new LinearInterpolator());
        this.MY.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lMM.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
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
        if (this.AXM) {
            this.xF--;
        } else {
            int i8 = this.xF + 1;
            this.xF = i8;
            this.xF = i8 % getChildCount();
        }
        postDelayed(this.oeT, 3000L);
    }
}
