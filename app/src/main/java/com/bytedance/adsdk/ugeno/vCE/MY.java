package com.bytedance.adsdk.ugeno.vCE;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO<com.bytedance.adsdk.ugeno.MY.EO> {
    private com.bytedance.adsdk.ugeno.tV tV;

    public MY(Context context) {
        super(context);
    }

    public void IlO(com.bytedance.adsdk.ugeno.tV tVVar) {
        this.tV = tVVar;
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.IlO
    public View NV(int i2) {
        return ((com.bytedance.adsdk.ugeno.MY.EO) this.IlO.get(i2)).EV();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        com.bytedance.adsdk.ugeno.tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.vCE();
        }
        super.onLayout(z2, i2, i8, i9, i10);
        com.bytedance.adsdk.ugeno.tV tVVar2 = this.tV;
        if (tVVar2 != null) {
            tVVar2.IlO(i2, i8, i9, i10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        com.bytedance.adsdk.ugeno.tV tVVar = this.tV;
        if (tVVar != null) {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            super.onMeasure(iArrIlO[0], iArrIlO[1]);
        } else {
            super.onMeasure(i2, i8);
        }
        com.bytedance.adsdk.ugeno.tV tVVar2 = this.tV;
        if (tVVar2 != null) {
            tVVar2.Cc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        com.bytedance.adsdk.ugeno.tV tVVar = this.tV;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }
}
