package com.bytedance.adsdk.ugeno.yoga.MY;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.Bc;
import com.bytedance.adsdk.ugeno.yoga.EV;
import com.bytedance.adsdk.ugeno.yoga.MY.EO;
import com.bytedance.adsdk.ugeno.yoga.NV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends ViewGroup {
    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MY) {
            throw null;
        }
        NV nvIlO = EV.IlO();
        EO.IlO(new EO.IlO(layoutParams), nvIlO, view);
        nvIlO.IlO(view);
        nvIlO.IlO((Bc) new EO.MY());
        throw null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof EO.IlO;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new EO.IlO(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new EO.IlO(layoutParams);
    }

    public NV getYogaNode() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }
}
