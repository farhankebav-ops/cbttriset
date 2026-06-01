package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import b2.a;
import com.cbt.exam.browser.R;
import q1.l;
import t1.c;
import w1.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f5408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5411d;
    public int e;

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f5408a = new k();
        TypedArray typedArrayD = l.d(context2, attributeSet, b1.a.f4137t, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f5409b = typedArrayD.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f5411d = typedArrayD.getDimensionPixelOffset(2, 0);
        this.e = typedArrayD.getDimensionPixelOffset(1, 0);
        setDividerColor(c.a(context2, typedArrayD, 0).getDefaultColor());
        typedArrayD.recycle();
    }

    public int getDividerColor() {
        return this.f5410c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f5411d;
    }

    public int getDividerThickness() {
        return this.f5409b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i2;
        super.onDraw(canvas);
        boolean z2 = getLayoutDirection() == 1;
        int i8 = z2 ? this.e : this.f5411d;
        if (z2) {
            width = getWidth();
            i2 = this.f5411d;
        } else {
            width = getWidth();
            i2 = this.e;
        }
        int i9 = width - i2;
        int bottom = getBottom() - getTop();
        k kVar = this.f5408a;
        kVar.setBounds(i8, 0, i9, bottom);
        kVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int mode = View.MeasureSpec.getMode(i8);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i9 = this.f5409b;
            if (i9 > 0 && measuredHeight != i9) {
                measuredHeight = i9;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i2) {
        if (this.f5410c != i2) {
            this.f5410c = i2;
            this.f5408a.p(ColorStateList.valueOf(i2));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i2) {
        setDividerColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setDividerInsetEnd(@Px int i2) {
        this.e = i2;
    }

    public void setDividerInsetEndResource(@DimenRes int i2) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerInsetStart(@Px int i2) {
        this.f5411d = i2;
    }

    public void setDividerInsetStartResource(@DimenRes int i2) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerThickness(@Px int i2) {
        if (this.f5409b != i2) {
            this.f5409b = i2;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i2) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i2));
    }
}
