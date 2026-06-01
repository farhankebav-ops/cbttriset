package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import b2.a;
import i1.c;
import q1.l;
import r2.q;
import w1.h;
import w1.k;
import w1.n;
import w1.o;
import w1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MaterialCardView extends CardView implements Checkable, z {
    public static final int[] e = {R.attr.state_checkable};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f5312f = {R.attr.state_checked};
    public static final int[] g = {com.cbt.exam.browser.R.attr.state_dragged};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5316d;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, com.cbt.exam.browser.R.attr.materialCardViewStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CardView), attributeSet, com.cbt.exam.browser.R.attr.materialCardViewStyle);
        this.f5315c = false;
        this.f5316d = false;
        this.f5314b = true;
        TypedArray typedArrayD = l.d(getContext(), attributeSet, b1.a.f4135r, com.cbt.exam.browser.R.attr.materialCardViewStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_CardView, new int[0]);
        c cVar = new c(this, attributeSet);
        this.f5313a = cVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        k kVar = cVar.f11795c;
        kVar.p(cardBackgroundColor);
        cVar.f11794b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.l();
        MaterialCardView materialCardView = cVar.f11793a;
        ColorStateList colorStateListA = t1.c.a(materialCardView.getContext(), typedArrayD, 11);
        cVar.f11799n = colorStateListA;
        if (colorStateListA == null) {
            cVar.f11799n = ColorStateList.valueOf(-1);
        }
        cVar.h = typedArrayD.getDimensionPixelSize(12, 0);
        boolean z2 = typedArrayD.getBoolean(0, false);
        cVar.f11803s = z2;
        materialCardView.setLongClickable(z2);
        cVar.l = t1.c.a(materialCardView.getContext(), typedArrayD, 6);
        cVar.g(t1.c.c(materialCardView.getContext(), typedArrayD, 2));
        cVar.f11797f = typedArrayD.getDimensionPixelSize(5, 0);
        cVar.e = typedArrayD.getDimensionPixelSize(4, 0);
        cVar.g = typedArrayD.getInteger(3, 8388661);
        ColorStateList colorStateListA2 = t1.c.a(materialCardView.getContext(), typedArrayD, 7);
        cVar.k = colorStateListA2;
        if (colorStateListA2 == null) {
            cVar.k = ColorStateList.valueOf(m1.a.b(materialCardView, androidx.appcompat.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateListA3 = t1.c.a(materialCardView.getContext(), typedArrayD, 1);
        colorStateListA3 = colorStateListA3 == null ? ColorStateList.valueOf(0) : colorStateListA3;
        k kVar2 = cVar.f11796d;
        kVar2.p(colorStateListA3);
        RippleDrawable rippleDrawable = cVar.f11800o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(cVar.k);
        }
        kVar.o(materialCardView.getCardElevation());
        float f4 = cVar.h;
        ColorStateList colorStateList = cVar.f11799n;
        kVar2.f17716b.k = f4;
        kVar2.invalidateSelf();
        h hVar = kVar2.f17716b;
        if (hVar.e != colorStateList) {
            hVar.e = colorStateList;
            kVar2.onStateChange(kVar2.getState());
        }
        materialCardView.setBackgroundInternal(cVar.d(kVar));
        Drawable drawableC = cVar.j() ? cVar.c() : kVar2;
        cVar.f11798i = drawableC;
        materialCardView.setForeground(cVar.d(drawableC));
        typedArrayD.recycle();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f5313a.f11795c.getBounds());
        return rectF;
    }

    public final void a() {
        c cVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (cVar = this.f5313a).f11800o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i2 = bounds.bottom;
        cVar.f11800o.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
        cVar.f11800o.setBounds(bounds.left, bounds.top, bounds.right, i2);
    }

    public final void b(int i2, int i8, int i9, int i10) {
        super.setContentPadding(i2, i8, i9, i10);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f5313a.f11795c.f17716b.f17708d;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f5313a.f11796d.f17716b.f17708d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f5313a.j;
    }

    public int getCheckedIconGravity() {
        return this.f5313a.g;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f5313a.e;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f5313a.f11797f;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f5313a.l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f5313a.f11794b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f5313a.f11794b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f5313a.f11794b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f5313a.f11794b.top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f5313a.f11795c.f17716b.j;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f5313a.f11795c.j();
    }

    public ColorStateList getRippleColor() {
        return this.f5313a.k;
    }

    @NonNull
    public o getShapeAppearanceModel() {
        return this.f5313a.m;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f5313a.f11799n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f5313a.f11799n;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f5313a.h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f5315c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.f5313a;
        cVar.k();
        q.u0(this, cVar.f11795c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        c cVar = this.f5313a;
        if (cVar != null && cVar.f11803s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, e);
        }
        if (this.f5315c) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f5312f);
        }
        if (this.f5316d) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f5315c);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        c cVar = this.f5313a;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f11803s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f5315c);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.f5313a.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f5314b) {
            c cVar = this.f5313a;
            if (!cVar.f11802r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                cVar.f11802r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.f5313a.f11795c.p(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f4) {
        super.setCardElevation(f4);
        c cVar = this.f5313a;
        cVar.f11795c.o(cVar.f11793a.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        k kVar = this.f5313a.f11796d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        kVar.p(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.f5313a.f11803s = z2;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f5315c != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f5313a.g(drawable);
    }

    public void setCheckedIconGravity(int i2) {
        c cVar = this.f5313a;
        if (cVar.g != i2) {
            cVar.g = i2;
            MaterialCardView materialCardView = cVar.f11793a;
            cVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.f5313a.e = i2;
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.f5313a.e = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.f5313a.g(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.f5313a.f11797f = i2;
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.f5313a.f11797f = getResources().getDimensionPixelSize(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        c cVar = this.f5313a;
        cVar.l = colorStateList;
        Drawable drawable = cVar.j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        c cVar = this.f5313a;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public final void setContentPadding(int i2, int i8, int i9, int i10) {
        c cVar = this.f5313a;
        cVar.f11794b.set(i2, i8, i9, i10);
        cVar.l();
    }

    public void setDragged(boolean z2) {
        if (this.f5316d != z2) {
            this.f5316d = z2;
            refreshDrawableState();
            a();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f4) {
        super.setMaxCardElevation(f4);
        this.f5313a.m();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        c cVar = this.f5313a;
        cVar.m();
        cVar.l();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        c cVar = this.f5313a;
        cVar.f11795c.q(f4);
        k kVar = cVar.f11796d;
        if (kVar != null) {
            kVar.q(f4);
        }
        k kVar2 = cVar.f11801q;
        if (kVar2 != null) {
            kVar2.q(f4);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f4) {
        super.setRadius(f4);
        c cVar = this.f5313a;
        n nVarF = cVar.m.f();
        nVarF.e = new w1.a(f4);
        nVarF.f17737f = new w1.a(f4);
        nVarF.g = new w1.a(f4);
        nVarF.h = new w1.a(f4);
        cVar.h(nVarF.a());
        cVar.f11798i.invalidateSelf();
        if (cVar.i() || (cVar.f11793a.getPreventCornerOverlap() && !cVar.f11795c.m())) {
            cVar.l();
        }
        if (cVar.i()) {
            cVar.m();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.f5313a;
        cVar.k = colorStateList;
        RippleDrawable rippleDrawable = cVar.f11800o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), i2);
        c cVar = this.f5313a;
        cVar.k = colorStateList;
        RippleDrawable rippleDrawable = cVar.f11800o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    @Override // w1.z
    public void setShapeAppearanceModel(@NonNull o oVar) {
        setClipToOutline(oVar.e(getBoundsAsRectF()));
        this.f5313a.h(oVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        c cVar = this.f5313a;
        if (i2 != cVar.h) {
            cVar.h = i2;
            k kVar = cVar.f11796d;
            ColorStateList colorStateList = cVar.f11799n;
            kVar.f17716b.k = i2;
            kVar.invalidateSelf();
            h hVar = kVar.f17716b;
            if (hVar.e != colorStateList) {
                hVar.e = colorStateList;
                kVar.onStateChange(kVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        c cVar = this.f5313a;
        cVar.m();
        cVar.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        c cVar = this.f5313a;
        if (cVar != null && cVar.f11803s && isEnabled()) {
            this.f5315c = !this.f5315c;
            refreshDrawableState();
            a();
            cVar.f(this.f5315c, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.f5313a;
        if (cVar.f11799n != colorStateList) {
            cVar.f11799n = colorStateList;
            k kVar = cVar.f11796d;
            kVar.f17716b.k = cVar.h;
            kVar.invalidateSelf();
            h hVar = kVar.f17716b;
            if (hVar.e != colorStateList) {
                hVar.e = colorStateList;
                kVar.onStateChange(kVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f5313a.f11795c.p(colorStateList);
    }

    public void setOnCheckedChangeListener(@Nullable i1.a aVar) {
    }
}
