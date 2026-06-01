package com.bytedance.adsdk.ugeno.DmF.MY;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.tV;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends FrameLayout {
    private tV IlO;
    private Map<Integer, EV> MY;

    public IlO(Context context) {
        super(context);
    }

    public void IlO(tV tVVar) {
        this.IlO = tVVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, EV> map = this.MY;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.vCE();
        }
        super.onLayout(z2, i2, i8, i9, i10);
        tV tVVar2 = this.IlO;
        if (tVVar2 != null) {
            tVVar2.IlO(i2, i8, i9, i10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        tV tVVar = this.IlO;
        if (tVVar != null) {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            super.onMeasure(iArrIlO[0], iArrIlO[1]);
        } else {
            super.onMeasure(i2, i8);
        }
        tV tVVar2 = this.IlO;
        if (tVVar2 != null) {
            tVVar2.Cc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.IlO;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    public void setEventMap(Map<Integer, EV> map) {
        this.MY = map;
    }
}
