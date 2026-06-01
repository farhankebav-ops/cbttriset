package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewMeasure {
    private boolean flex;
    private int maxHeight;
    private int maxWidth;
    private View view;

    public ViewMeasure(View view, boolean z2) {
        this.view = view;
        this.flex = z2;
    }

    public int getDesiredHeight() {
        if (this.view.getVisibility() == 8) {
            return 0;
        }
        View view = this.view;
        if (!(view instanceof ScrollView)) {
            return view.getMeasuredHeight();
        }
        ScrollView scrollView = (ScrollView) view;
        return scrollView.getChildAt(0).getMeasuredHeight() + scrollView.getPaddingTop() + scrollView.getPaddingBottom();
    }

    public int getDesiredWidth() {
        if (this.view.getVisibility() == 8) {
            return 0;
        }
        return this.view.getMeasuredHeight();
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public View getView() {
        return this.view;
    }

    public boolean isFlex() {
        return this.flex;
    }

    public void preMeasure(int i2, int i8) {
        MeasureUtils.measureAtMost(this.view, i2, i8);
    }

    public void setMaxDimens(int i2, int i8) {
        this.maxWidth = i2;
        this.maxHeight = i8;
    }
}
