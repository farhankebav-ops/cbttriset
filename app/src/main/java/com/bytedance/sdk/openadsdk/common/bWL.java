package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends View {
    private final IlO IlO;
    private View MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        View IlO(Context context);
    }

    public bWL(Context context, IlO ilO) {
        super(context);
        this.IlO = ilO;
        IlO();
    }

    private void IlO() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    private View MY() {
        IlO ilO;
        if (this.MY == null && (ilO = this.IlO) != null) {
            this.MY = ilO.IlO(getContext());
            IlO(this.MY, (ViewGroup) getParent());
        }
        return this.MY;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        View view = this.MY;
        if (view != null) {
            view.setVisibility(i2);
            return;
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            MY();
        }
    }

    private void IlO(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }
}
