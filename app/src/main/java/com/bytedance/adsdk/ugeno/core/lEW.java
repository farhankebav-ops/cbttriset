package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.core.IlO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private String Bc;
    private int Cc;
    private AnimatorSet EO = new AnimatorSet();
    Paint IlO;
    private IlO MY;
    private View tV;
    private int vCE;

    public lEW(View view, IlO ilO) {
        this.tV = view;
        this.MY = ilO;
        Paint paint = new Paint();
        this.IlO = paint;
        paint.setAntiAlias(true);
    }

    public void MY() {
        AnimatorSet animatorSet = this.EO;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void IlO() {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        List<IlO.C0033IlO> listEO = this.MY.EO();
        if (listEO == null || listEO.size() <= 0) {
            return;
        }
        for (IlO.C0033IlO c0033IlO : listEO) {
            if (c0033IlO != null) {
                objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0033IlO.IlO());
                if (TextUtils.equals(c0033IlO.Cc(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0033IlO.Cc(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0033IlO.Cc());
                }
                objectAnimator.setStartDelay(c0033IlO.tV());
                objectAnimator.setTarget(this.tV);
                if (TextUtils.equals(c0033IlO.Cc(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0033IlO.vCE(), (int) c0033IlO.Bc());
                    Log.d("UGenAnimation", "playAnimation: from = " + c0033IlO.vCE() + "; to=" + c0033IlO.Bc());
                } else {
                    objectAnimator.setFloatValues(c0033IlO.vCE(), c0033IlO.Bc());
                }
                int iMY = (int) this.MY.MY();
                if (iMY != 0) {
                    objectAnimator.setRepeatCount(iMY);
                } else {
                    objectAnimator.setRepeatCount((int) c0033IlO.MY());
                }
                if (TextUtils.equals(c0033IlO.Cc(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strVCE = this.MY.vCE();
                if (TextUtils.isEmpty(strVCE)) {
                    strVCE = c0033IlO.EO();
                }
                if (TextUtils.equals(strVCE, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0033IlO.lEW() != null && c0033IlO.lEW().length > 0) {
                    objectAnimator.setFloatValues(c0033IlO.lEW());
                }
                if (TextUtils.equals(c0033IlO.Cc(), "rotationX")) {
                    this.tV.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.lEW.1
                        @Override // java.lang.Runnable
                        public void run() {
                            lEW.this.tV.setPivotX(lEW.this.tV.getWidth() / 2.0f);
                            lEW.this.tV.setPivotY(lEW.this.tV.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0033IlO.Cc(), "ripple")) {
                    this.Bc = c0033IlO.NV();
                }
                String strDmF = c0033IlO.DmF();
                strDmF.getClass();
                switch (strDmF) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.MY.tV() != 0) {
            this.EO.setDuration(this.MY.tV());
        }
        this.EO.setStartDelay(this.MY.Cc());
        if (TextUtils.equals(this.MY.IlO(), "sequentially")) {
            this.EO.playSequentially(arrayList);
        } else {
            this.EO.playTogether(arrayList);
        }
        this.EO.start();
    }

    public void IlO(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.Bc)) {
                return;
            }
            this.IlO.setColor(com.bytedance.adsdk.ugeno.Bc.IlO.IlO(this.Bc));
            this.IlO.setAlpha(90);
            ((ViewGroup) this.tV.getParent()).setClipChildren(true);
            canvas.drawCircle(this.Cc, this.vCE, Math.min(r0, r2) * 2 * iAnimation.getRipple(), this.IlO);
        } catch (Throwable th) {
            Log.d("UGenAnimation", "ripple animation error " + th.getMessage());
        }
    }

    public void IlO(int i2, int i8) {
        this.Cc = i2 / 2;
        this.vCE = i8 / 2;
    }
}
