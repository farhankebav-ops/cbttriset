package com.bytedance.adsdk.ugeno.IlO;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements Cc {
    private float Cc;
    private float EO;
    private View IlO;
    private float MY;
    private float tV;
    private float vCE;

    public vCE(View view) {
        this.IlO = view;
    }

    public void Cc(float f4) {
        this.vCE = f4;
        this.IlO.postInvalidate();
    }

    public void EO(float f4) {
        View view = this.IlO;
        if (view == null) {
            return;
        }
        this.tV = f4;
        view.postInvalidate();
    }

    public void IlO(float f4) {
        View view = this.IlO;
        if (view == null) {
            return;
        }
        this.MY = f4;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f4);
        }
    }

    public void MY(float f4) {
        View view = this.IlO;
        if (view == null) {
            return;
        }
        this.EO = f4;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc, com.bytedance.adsdk.ugeno.core.IAnimation
    public float getRipple() {
        return this.EO;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getRubIn() {
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getShine() {
        return this.tV;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getStretch() {
        return this.Cc;
    }

    public void tV(float f4) {
        this.Cc = f4;
        this.IlO.postInvalidate();
    }

    public float IlO() {
        return this.MY;
    }

    public void IlO(int i2) {
        View view = this.IlO;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i2);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i2);
        }
    }
}
