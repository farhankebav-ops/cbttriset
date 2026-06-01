package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF extends LinearLayout {
    private IlO Bc;
    private TextView Cc;
    private int DmF;
    private ImageView EO;
    private int EV;
    private TextView IlO;
    private TextView MY;
    private int NV;
    private LinearLayout lEW;
    private JSONObject rp;
    private com.bytedance.sdk.component.utils.tl tV;
    private TextView vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.vCE.xF$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xF.this.EO != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new MY(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.xF.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        xF.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.xF.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                xF.this.EO.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                xF.this.EO.startAnimation(rotateAnimation);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements Interpolator {
        private MY() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 <= 0.25f ? (f4 * (-2.0f)) + 0.5f : f4 <= 0.5f ? (f4 * 4.0f) - 1.0f : f4 <= 0.75f ? (f4 * (-4.0f)) + 3.0f : (f4 * 2.0f) - 1.5f;
        }

        public /* synthetic */ MY(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public xF(@NonNull Context context, View view, int i2, int i8, int i9, JSONObject jSONObject) {
        super(context);
        this.DmF = i2;
        this.NV = i8;
        this.EV = i9;
        this.rp = jSONObject;
        IlO(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.lEW;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.tV == null) {
                this.tV = new com.bytedance.sdk.component.utils.tl(getContext().getApplicationContext(), 1);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.vCE.xF.2
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setOnShakeViewListener(IlO ilO) {
        this.Bc = ilO;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Cc.setText(str);
        } else {
            this.Cc.setVisibility(8);
            this.vCE.setVisibility(8);
        }
    }

    public void IlO(Context context, View view) {
        addView(view);
        this.lEW = (LinearLayout) findViewById(2097610727);
        this.EO = (ImageView) findViewById(2097610725);
        this.IlO = (TextView) findViewById(2097610724);
        this.MY = (TextView) findViewById(2097610726);
        this.Cc = (TextView) findViewById(2097610723);
        this.vCE = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.lEW.setBackground(gradientDrawable);
    }

    public void IlO() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
    }
}
