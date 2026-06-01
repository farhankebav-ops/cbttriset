package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.ArrayList;
import java.util.Collections;
import q1.l;
import q1.m;
import r2.q;
import w1.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ImageView.ScaleType[] f5239f = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f5240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView.ScaleType f5243d;
    public Boolean e;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2 = R.attr.toolbarStyle;
        super(b2.a.a(context, attributeSet, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Toolbar), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayD = l.d(context2, attributeSet, b1.a.f4142z, i2, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayD.hasValue(2)) {
            setNavigationIconTint(typedArrayD.getColor(2, -1));
        }
        this.f5241b = typedArrayD.getBoolean(4, false);
        this.f5242c = typedArrayD.getBoolean(3, false);
        int i8 = typedArrayD.getInt(1, -1);
        if (i8 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f5239f;
            if (i8 < scaleTypeArr.length) {
                this.f5243d = scaleTypeArr[i8];
            }
        }
        if (typedArrayD.hasValue(0)) {
            this.e = Boolean.valueOf(typedArrayD.getBoolean(0, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : o1.c.a(background);
        if (colorStateListValueOf != null) {
            k kVar = new k();
            kVar.p(colorStateListValueOf);
            kVar.l(context2);
            kVar.o(getElevation());
            setBackground(kVar);
        }
    }

    public final void a(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i8 = measuredWidth2 + i2;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i8 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i2 += iMax;
            i8 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i8 - i2, BasicMeasure.EXACTLY), textView.getMeasuredHeightAndState());
        }
        textView.layout(i2, textView.getTop(), i8, textView.getBottom());
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f5243d;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.f5240a;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof k) {
            q.u0(this, (k) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z2, i2, i8, i9, i10);
        int i11 = 0;
        ImageView imageView2 = null;
        if (this.f5241b || this.f5242c) {
            ArrayList arrayListA = m.a(this, getTitle());
            boolean zIsEmpty = arrayListA.isEmpty();
            b0.a aVar = m.f13426a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListA, aVar);
            ArrayList arrayListA2 = m.a(this, getSubtitle());
            TextView textView2 = arrayListA2.isEmpty() ? null : (TextView) Collections.max(arrayListA2, aVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i12 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i13 = 0; i13 < getChildCount(); i13++) {
                    View childAt = getChildAt(i13);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i12 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i12 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f5241b && textView != null) {
                    a(textView, pair);
                }
                if (this.f5242c && textView2 != null) {
                    a(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i11 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i11);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i11++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.e;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f5243d;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        Drawable background = getBackground();
        if (background instanceof k) {
            ((k) background).o(f4);
        }
    }

    public void setLogoAdjustViewBounds(boolean z2) {
        Boolean bool = this.e;
        if (bool == null || bool.booleanValue() != z2) {
            this.e = Boolean.valueOf(z2);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f5243d != scaleType) {
            this.f5243d = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.f5240a != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            drawable.setTint(this.f5240a.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.f5240a = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.f5242c != z2) {
            this.f5242c = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.f5241b != z2) {
            this.f5241b = z2;
            requestLayout();
        }
    }
}
