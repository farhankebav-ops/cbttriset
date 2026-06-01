package com.bytedance.adsdk.ugeno.DmF.vCE;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.IlO.Cc;
import com.bytedance.adsdk.ugeno.IlO.vCE;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends TextView implements Cc, IAnimation {
    private vCE EO;
    private tV IlO;
    private float MY;

    public IlO(Context context) {
        super(context);
        this.EO = new vCE(this);
    }

    public void IlO(tV tVVar) {
        this.IlO = tVVar;
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.MY(canvas);
        }
    }

    public float getBorderRadius() {
        return this.EO.IlO();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc, com.bytedance.adsdk.ugeno.core.IAnimation
    public float getRipple() {
        return this.MY;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getRubIn() {
        return this.EO.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getShine() {
        return this.EO.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getStretch() {
        return this.EO.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.IlO(canvas, this);
            this.IlO.IlO(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.IlO(i2, i8, i9, i10);
        }
        super.onLayout(z2, i2, i8, i9, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i8) {
        tV tVVar = this.IlO;
        if (tVVar == null) {
            super.onMeasure(i2, i8);
        } else {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            super.onMeasure(iArrIlO[0], iArrIlO[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i9);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.EO.IlO(i2);
    }

    public void setBorderRadius(float f4) {
        vCE vce = this.EO;
        if (vce != null) {
            vce.IlO(f4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f4) {
        this.MY = f4;
        vCE vce = this.EO;
        if (vce != null) {
            vce.MY(f4);
        }
        postInvalidate();
    }

    public void setRubIn(float f4) {
        vCE vce = this.EO;
        if (vce != null) {
            vce.Cc(f4);
        }
    }

    public void setShine(float f4) {
        vCE vce = this.EO;
        if (vce != null) {
            vce.EO(f4);
        }
    }

    public void setStretch(float f4) {
        vCE vce = this.EO;
        if (vce != null) {
            vce.tV(f4);
        }
    }
}
