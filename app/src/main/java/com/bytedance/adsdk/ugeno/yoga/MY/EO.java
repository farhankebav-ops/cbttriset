package com.bytedance.adsdk.ugeno.yoga.MY;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.adsdk.ugeno.IlO.Cc;
import com.bytedance.adsdk.ugeno.IlO.vCE;
import com.bytedance.adsdk.ugeno.tV;
import com.bytedance.adsdk.ugeno.yoga.Bc;
import com.bytedance.adsdk.ugeno.yoga.DmF;
import com.bytedance.adsdk.ugeno.yoga.EV;
import com.bytedance.adsdk.ugeno.yoga.NV;
import com.bytedance.adsdk.ugeno.yoga.bWL;
import com.bytedance.adsdk.ugeno.yoga.hp;
import com.bytedance.adsdk.ugeno.yoga.lEW;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends ViewGroup implements Cc, com.bytedance.adsdk.ugeno.MY.MY {
    private tV EO;
    private final Map<View, NV> IlO;
    private final NV MY;
    private vCE tV;

    public EO(Context context) {
        this(context, null, 0);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.MY
    public void EO(View view, int i2) {
        tV(view, i2);
    }

    public NV IlO(View view) {
        return this.IlO.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.MY
    public void MY(int i2) {
        NV nv = this.MY;
        if (nv != null) {
            MY(nv, i2);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        NV nvIlO;
        this.MY.IlO((Bc) null);
        if (view instanceof com.bytedance.adsdk.ugeno.yoga.MY.MY) {
            throw null;
        }
        super.addView(view, i2, layoutParams);
        if (this.IlO.containsKey(view)) {
            return;
        }
        if (view instanceof EO) {
            nvIlO = ((EO) view).getYogaNode();
        } else {
            nvIlO = this.IlO.containsKey(view) ? this.IlO.get(view) : EV.IlO();
            nvIlO.IlO(view);
            nvIlO.IlO((Bc) new MY());
        }
        IlO((IlO) view.getLayoutParams(), nvIlO, view);
        this.IlO.put(view, nvIlO);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.MY.IlO()));
        } else {
            NV nv = this.MY;
            nv.IlO(nvIlO, nv.IlO());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof IlO;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.MY(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new IlO(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new IlO(layoutParams);
    }

    public float getBorderRadius() {
        return this.tV.IlO();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc, com.bytedance.adsdk.ugeno.core.IAnimation
    public float getRipple() {
        return this.tV.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getRubIn() {
        return this.tV.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getShine() {
        return this.tV.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getStretch() {
        return this.tV.getStretch();
    }

    public NV getYogaNode() {
        return this.MY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.IlO(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.vCE();
        }
        if (!(getParent() instanceof EO)) {
            IlO(View.MeasureSpec.makeMeasureSpec(i9 - i2, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i10 - i8, BasicMeasure.EXACTLY));
        }
        IlO(this.MY, 0.0f, 0.0f);
        tV tVVar2 = this.EO;
        if (tVVar2 != null) {
            tVVar2.IlO(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        if (!(getParent() instanceof EO)) {
            IlO(i2, i8);
        }
        tV tVVar = this.EO;
        if (tVVar != null) {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            setMeasuredDimension(iArrIlO[0], iArrIlO[1]);
        } else {
            setMeasuredDimension(Math.round(this.MY.lEW()), Math.round(this.MY.DmF()));
        }
        tV tVVar2 = this.EO;
        if (tVVar2 != null) {
            tVVar2.Cc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.EO;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i10);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            IlO(getChildAt(i2), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            IlO(getChildAt(i2), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IlO(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        IlO(getChildAt(i2), false);
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        IlO(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i8) {
        for (int i9 = i2; i9 < i2 + i8; i9++) {
            IlO(getChildAt(i9), false);
        }
        super.removeViews(i2, i8);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i8) {
        for (int i9 = i2; i9 < i2 + i8; i9++) {
            IlO(getChildAt(i9), true);
        }
        super.removeViewsInLayout(i2, i8);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.tV.IlO(i2);
    }

    public void setBorderRadius(float f4) {
        this.tV.IlO(f4);
    }

    public void setRipple(float f4) {
        vCE vce = this.tV;
        if (vce != null) {
            vce.MY(f4);
        }
    }

    public void setRubIn(float f4) {
        vCE vce = this.tV;
        if (vce != null) {
            vce.Cc(f4);
        }
    }

    public void setShine(float f4) {
        vCE vce = this.tV;
        if (vce != null) {
            vce.EO(f4);
        }
    }

    public void setStretch(float f4) {
        vCE vce = this.tV;
        if (vce != null) {
            vce.tV(f4);
        }
    }

    public void tV(View view, int i2) {
        int iIlO;
        view.setVisibility(i2);
        try {
            NV nv = this.IlO.get(view);
            Object tag = view.getTag(151060224);
            if (i2 != 0) {
                if (i2 != 8 || (iIlO = this.MY.IlO(nv)) == -1) {
                    return;
                }
                this.MY.MY(iIlO);
                view.setTag(151060224, Integer.valueOf(iIlO));
                IlO(this.MY);
                return;
            }
            if (tag == null || this.MY.IlO(nv) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.MY.IlO()) {
                this.MY.IlO(this.IlO.get(view), iIntValue);
            } else {
                this.MY.IlO(this.IlO.get(view), this.MY.IlO());
            }
            IlO(this.MY);
        } catch (Throwable unused) {
        }
    }

    public EO(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.tV = new vCE(this);
        NV nvIlO = EV.IlO();
        this.MY = nvIlO;
        this.IlO = new HashMap();
        nvIlO.IlO(this);
        nvIlO.IlO((Bc) new MY());
        IlO((IlO) generateDefaultLayoutParams(), nvIlO, this);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.MY
    public void IlO(int i2) {
        NV nv = this.MY;
        if (nv != null) {
            IlO(nv, i2);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.MY
    public void MY(View view, int i2) {
        NV nvIlO;
        if (view == null || (nvIlO = IlO(view)) == null) {
            return;
        }
        MY(nvIlO, i2);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.MY.MY
    public void IlO(View view, int i2) {
        NV nvIlO;
        if (view == null || (nvIlO = IlO(view)) == null) {
            return;
        }
        IlO(nvIlO, i2);
        view.requestLayout();
    }

    private void MY(NV nv, int i2) {
        if (i2 == -1) {
            nv.Bc(100.0f);
        } else if (i2 == -2) {
            nv.Cc();
        } else {
            nv.vCE(i2);
        }
    }

    private void IlO(NV nv, int i2) {
        if (i2 == -1) {
            nv.Cc(100.0f);
        } else if (i2 == -2) {
            nv.tV();
        } else {
            nv.tV(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements Bc {
        @Override // com.bytedance.adsdk.ugeno.yoga.Bc
        public long IlO(NV nv, float f4, lEW lew, float f8, lEW lew2) {
            View view = (View) nv.NV();
            if (view == null || (view instanceof EO)) {
                return DmF.IlO(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f4, IlO(lew)), View.MeasureSpec.makeMeasureSpec((int) f8, IlO(lew2)));
            return DmF.IlO(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int IlO(lEW lew) {
            if (lew == lEW.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            if (lew == lEW.EXACTLY) {
                return BasicMeasure.EXACTLY;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends ViewGroup.LayoutParams {
        private float Bc;
        private float Cc;
        private float DmF;
        private float EO;
        private float EV;
        SparseArray<Float> IlO;
        SparseArray<String> MY;
        private float NV;
        private float bWL;
        private float cL;
        private float cl;
        private float ea;
        private float es;
        private float hp;
        private float lEW;
        private float rp;
        private float tV;
        private float vCE;
        private float zPa;

        public IlO(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof IlO) {
                IlO ilO = (IlO) layoutParams;
                this.IlO = ilO.IlO.clone();
                this.MY = ilO.MY.clone();
                return;
            }
            this.IlO = new SparseArray<>();
            this.MY = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.IlO.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.IlO.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void Bc(float f4) {
            this.hp = f4;
            this.IlO.put(10, Float.valueOf(f4));
        }

        public void Cc(float f4) {
            this.EV = f4;
            this.IlO.put(9, Float.valueOf(f4));
        }

        public void DmF(float f4) {
            this.ea = f4;
            this.IlO.put(12, Float.valueOf(f4));
        }

        public void EO(float f4) {
            this.DmF = f4;
            this.IlO.put(7, Float.valueOf(f4));
        }

        public void EV(float f4) {
            this.EO = f4;
            this.IlO.put(17, Float.valueOf(f4));
        }

        public void IlO(float f4) {
            this.Bc = f4;
            this.IlO.put(5, Float.valueOf(f4));
        }

        public void MY(float f4) {
            this.lEW = f4;
            this.IlO.put(6, Float.valueOf(f4));
        }

        public void NV(float f4) {
            this.zPa = f4;
            this.IlO.put(13, Float.valueOf(f4));
        }

        public void bWL(float f4) {
            this.vCE = f4;
            this.IlO.put(20, Float.valueOf(f4));
        }

        public void cl(float f4) {
            this.es = f4;
            this.IlO.put(28, Float.valueOf(f4));
        }

        public void ea(float f4) {
            this.cl = f4;
            this.IlO.put(25, Float.valueOf(f4));
        }

        public void hp(float f4) {
            this.Cc = f4;
            this.IlO.put(19, Float.valueOf(f4));
        }

        public void lEW(float f4) {
            this.bWL = f4;
            this.IlO.put(11, Float.valueOf(f4));
        }

        public void rp(float f4) {
            this.tV = f4;
            this.IlO.put(18, Float.valueOf(f4));
        }

        public void tV(float f4) {
            this.NV = f4;
            this.IlO.put(8, Float.valueOf(f4));
        }

        public void vCE(float f4) {
            this.rp = f4;
            this.IlO.put(14, Float.valueOf(f4));
        }

        public void zPa(float f4) {
            this.cL = f4;
            this.IlO.put(27, Float.valueOf(f4));
        }

        public IlO(int i2, int i8) {
            super(i2, i8);
            this.IlO = new SparseArray<>();
            this.MY = new SparseArray<>();
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.IlO.put(15, Float.valueOf(i2));
            }
            if (i8 == -2 || i8 == -1 || i8 >= 0) {
                this.IlO.put(16, Float.valueOf(i8));
            }
        }
    }

    private void IlO(NV nv) {
        if (nv.MY() != null) {
            IlO(nv.MY());
        } else {
            nv.IlO(Float.NaN, Float.NaN);
        }
    }

    private void IlO(View view, boolean z2) {
        NV nv = this.IlO.get(view);
        if (nv == null) {
            return;
        }
        NV nvMY = nv.MY();
        int i2 = 0;
        while (true) {
            if (i2 >= nvMY.IlO()) {
                break;
            }
            if (nvMY.IlO(i2).equals(nv)) {
                nvMY.MY(i2);
                break;
            }
            i2++;
        }
        nv.IlO((Object) null);
        this.IlO.remove(view);
        if (z2) {
            this.MY.IlO(Float.NaN, Float.NaN);
        }
    }

    private void IlO(NV nv, float f4, float f8) {
        View view = (View) nv.NV();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(nv.vCE() + f4);
            int iRound2 = Math.round(nv.Bc() + f8);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(nv.lEW()), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.round(nv.DmF()), BasicMeasure.EXACTLY));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iIlO = nv.IlO();
        for (int i2 = 0; i2 < iIlO; i2++) {
            if (equals(view)) {
                IlO(nv.IlO(i2), f4, f8);
            } else if (!(view instanceof EO)) {
                IlO(nv.IlO(i2), nv.vCE() + f4, nv.Bc() + f8);
            }
        }
    }

    private void IlO(int i2, int i8) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i8);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i8);
        if (mode2 == 1073741824) {
            this.MY.vCE(size2);
        }
        if (mode == 1073741824) {
            this.MY.tV(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.MY.EV(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.MY.NV(size);
        }
        this.MY.IlO(Float.NaN, Float.NaN);
    }

    public static void IlO(IlO ilO, NV nv, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            nv.IlO(com.bytedance.adsdk.ugeno.yoga.EO.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.LEFT, r0.left);
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.TOP, r0.top);
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.RIGHT, r0.right);
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.BOTTOM, r0.bottom);
            }
        }
        for (int i2 = 0; i2 < ilO.IlO.size(); i2++) {
            int iKeyAt = ilO.IlO.keyAt(i2);
            float fFloatValue = ilO.IlO.valueAt(i2).floatValue();
            if (iKeyAt == 4) {
                nv.EO(com.bytedance.adsdk.ugeno.yoga.IlO.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.IlO.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.IlO.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                nv.rp(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    nv.EO();
                } else {
                    nv.EO(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.Cc.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                nv.IlO(fFloatValue);
            } else if (iKeyAt == 7) {
                nv.MY(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    nv.Bc(100.0f);
                } else if (fFloatValue == -2.0f) {
                    nv.Cc();
                } else {
                    nv.vCE(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.tV.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.vCE.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.tV.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.tV.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                nv.IlO(com.bytedance.adsdk.ugeno.yoga.tV.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                nv.DmF(fFloatValue);
            } else if (iKeyAt == 27) {
                nv.lEW(fFloatValue);
            } else if (iKeyAt == 22) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                nv.MY(com.bytedance.adsdk.ugeno.yoga.tV.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                nv.EO(com.bytedance.adsdk.ugeno.yoga.tV.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                nv.EO(com.bytedance.adsdk.ugeno.yoga.tV.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                nv.EO(com.bytedance.adsdk.ugeno.yoga.tV.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                nv.EO(com.bytedance.adsdk.ugeno.yoga.tV.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                nv.IlO(hp.IlO(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    nv.Cc(100.0f);
                } else if (fFloatValue == -2.0f) {
                    nv.tV();
                } else {
                    nv.tV(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                nv.IlO(bWL.IlO(Math.round(fFloatValue)));
            }
        }
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        this.EO = eo;
    }
}
