package y1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import com.cbt.exam.browser.R;
import q1.p;
import w1.k;
import w1.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q.a f17828i = new q.a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f17829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f17831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f17832d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17833f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    public c(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        Drawable drawableWrap;
        super(b2.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, b1.a.E);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f17830b = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f17829a = o.b(context2, attributeSet, 0, 0).a();
        }
        this.f17831c = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(t1.c.a(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(p.a(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f17832d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f17833f = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f17828i);
        setFocusable(true);
        if (getBackground() == null) {
            int iC = m1.a.c(m1.a.b(this, R.attr.colorSurface), m1.a.b(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
            o oVar = this.f17829a;
            if (oVar != null) {
                int i2 = d.f17834a;
                k kVar = new k(oVar);
                kVar.p(ColorStateList.valueOf(iC));
                drawable = kVar;
            } else {
                Resources resources = getResources();
                int i8 = d.f17834a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(iC);
                drawable = gradientDrawable;
            }
            if (this.g != null) {
                drawableWrap = DrawableCompat.wrap(drawable);
                drawableWrap.setTintList(this.g);
            } else {
                drawableWrap = DrawableCompat.wrap(drawable);
            }
            setBackground(drawableWrap);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f17832d;
    }

    public int getAnimationMode() {
        return this.f17830b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f17831c;
    }

    public int getMaxInlineActionWidth() {
        return this.f17833f;
    }

    public int getMaxWidth() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int i9 = this.e;
        if (i9 <= 0 || getMeasuredWidth() <= i9) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY), i8);
    }

    public void setAnimationMode(int i2) {
        this.f17830b = i2;
    }

    @Override // android.view.View
    public void setBackground(@Nullable Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null && this.g != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            drawable.setTintList(this.g);
            drawable.setTintMode(this.h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.g = colorStateList;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            drawableWrap.setTintList(colorStateList);
            drawableWrap.setTintMode(this.h);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.h = mode;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            drawableWrap.setTintMode(mode);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f17828i);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(d dVar) {
    }
}
