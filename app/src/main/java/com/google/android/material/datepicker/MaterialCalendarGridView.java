package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5333a;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a0.c(null);
        if (p.d(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(com.cbt.exam.browser.R.id.cancel_button);
            setNextFocusRightId(com.cbt.exam.browser.R.id.confirm_button);
        }
        this.f5333a = p.d(getContext(), com.cbt.exam.browser.R.attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new g(2));
    }

    public final s a() {
        return (s) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (s) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((s) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        s sVar = (s) super.getAdapter();
        sVar.getClass();
        int iMax = Math.max(sVar.a(), getFirstVisiblePosition());
        int iMin = Math.min(sVar.c(), getLastVisiblePosition());
        sVar.getItem(iMax);
        sVar.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (!z2) {
            super.onFocusChanged(false, i2, rect);
            return;
        }
        if (i2 == 33) {
            setSelection(((s) super.getAdapter()).c());
        } else if (i2 == 130) {
            setSelection(((s) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((s) super.getAdapter()).a() && selectedItemPosition <= ((s) super.getAdapter()).c())) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(((s) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i2, int i8) {
        if (!this.f5333a) {
            super.onMeasure(i2, i8);
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i2) {
        if (i2 < ((s) super.getAdapter()).a()) {
            super.setSelection(((s) super.getAdapter()).a());
        } else {
            super.setSelection(i2);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (s) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof s)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), s.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
