package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh extends RelativeLayout {
    private AnimatorSet Bc;
    private TextView Cc;
    private AnimatorSet DmF;
    private ImageView EO;
    private int EV;
    private ImageView IlO;
    private ImageView MY;
    private String NV;
    private AnimatorSet lEW;
    private TextView tV;
    private AnimatorSet vCE;

    public vAh(Context context) {
        super(context);
        this.vCE = new AnimatorSet();
        this.Bc = new AnimatorSet();
        this.lEW = new AnimatorSet();
        this.DmF = new AnimatorSet();
        this.EV = 100;
        IlO(context);
    }

    public void EO() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.IlO, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.IlO, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.IlO, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), -this.EV));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.EV));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.vAh.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (vAh.this.EO != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vAh.this.EO.getLayoutParams();
                    layoutParams.height = num.intValue();
                    vAh.this.EO.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.EO, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.EO, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.MY, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.MY, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.MY, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.MY, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.MY, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), -this.EV));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.Bc.setDuration(50L);
        this.DmF.setDuration(1500L);
        this.lEW.setDuration(50L);
        this.Bc.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.lEW.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.DmF.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.vCE.playSequentially(this.lEW, this.DmF, this.Bc);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.vCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MY();
    }

    public void setGuideText(String str) {
        TextView textView = this.tV;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.Cc != null) {
            if (TextUtils.isEmpty(str)) {
                this.Cc.setText("");
            } else {
                this.Cc.setText(str);
            }
        }
    }

    public void IlO(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.tV.IlO();
        }
        if ("5".equals(this.NV)) {
            addView(com.bytedance.sdk.component.adexpress.EO.IlO.vCE(context));
            this.EV = (int) (((double) this.EV) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.EO.IlO.Cc(context));
        }
        this.IlO = (ImageView) findViewById(2097610734);
        this.MY = (ImageView) findViewById(2097610735);
        this.tV = (TextView) findViewById(2097610730);
        this.EO = (ImageView) findViewById(2097610733);
        this.Cc = (TextView) findViewById(2097610731);
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
            AnimatorSet animatorSet3 = this.Bc;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.DmF;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public vAh(Context context, String str) {
        super(context);
        this.vCE = new AnimatorSet();
        this.Bc = new AnimatorSet();
        this.lEW = new AnimatorSet();
        this.DmF = new AnimatorSet();
        this.EV = 100;
        setClipChildren(false);
        this.NV = str;
        IlO(context);
    }

    public void IlO() {
        EO();
        this.vCE.start();
        this.vCE.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.vCE.vAh.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                vAh.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.vAh.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        vAh.this.vCE.start();
                    }
                }, 200L);
            }
        });
    }
}
