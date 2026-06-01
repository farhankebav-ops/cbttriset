package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.tV.Bc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends ImageView implements IAnimation {
    private float Cc;
    private float EO;
    EO IlO;
    private float MY;
    private float tV;
    private Bc vCE;

    public MY(Context context) {
        super(context);
        this.IlO = new EO();
    }

    public Bc getBrickNativeValue() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.Cc;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bc bc;
        super.onDraw(canvas);
        this.IlO.IlO(canvas, this, this);
        if (getRippleValue() == 0.0f || (bc = this.vCE) == null || bc.MY() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.IlO.IlO(this, i2, i8);
    }

    public void setBrickNativeValue(Bc bc) {
        this.vCE = bc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f4) {
        this.tV = f4;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f4) {
        this.MY = f4;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f4) {
        this.EO = f4;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f4) {
        this.Cc = f4;
        this.IlO.IlO(this, f4);
    }
}
