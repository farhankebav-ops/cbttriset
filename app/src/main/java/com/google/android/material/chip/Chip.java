package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import c1.b;
import com.cbt.exam.browser.activity.r;
import java.lang.ref.WeakReference;
import l1.a;
import l1.c;
import l1.d;
import l1.e;
import q1.j;
import q1.l;
import r2.q;
import t1.f;
import w1.o;
import w1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Chip extends AppCompatCheckBox implements d, z, Checkable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Rect f5320s = new Rect();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f5321t = {R.attr.state_selected};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f5322u = {R.attr.state_checkable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f5323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InsetDrawable f5324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RippleDrawable f5325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f5326d;
    public CompoundButton.OnCheckedChangeListener e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5327f;
    public boolean g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5328i;
    public boolean j;
    public int k;
    public int l;
    public CharSequence m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f5329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5330o;
    public final Rect p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f5331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f5332r;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(b2.a.a(context, attributeSet, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.cbt.exam.browser.R.attr.chipStyle);
        this.p = new Rect();
        this.f5331q = new RectF();
        this.f5332r = new a(this, 0);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        e eVar = new e(context2, attributeSet);
        Context context3 = eVar.f12752o0;
        int[] iArr = b1.a.e;
        TypedArray typedArrayD = l.d(context3, attributeSet, iArr, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        eVar.O0 = typedArrayD.hasValue(37);
        Context context4 = eVar.f12752o0;
        ColorStateList colorStateListA = t1.c.a(context4, typedArrayD, 24);
        if (eVar.H != colorStateListA) {
            eVar.H = colorStateListA;
            eVar.onStateChange(eVar.getState());
        }
        ColorStateList colorStateListA2 = t1.c.a(context4, typedArrayD, 11);
        if (eVar.I != colorStateListA2) {
            eVar.I = colorStateListA2;
            eVar.onStateChange(eVar.getState());
        }
        float dimension = typedArrayD.getDimension(19, 0.0f);
        if (eVar.J != dimension) {
            eVar.J = dimension;
            eVar.invalidateSelf();
            eVar.E();
        }
        if (typedArrayD.hasValue(12)) {
            eVar.K(typedArrayD.getDimension(12, 0.0f));
        }
        eVar.P(t1.c.a(context4, typedArrayD, 22));
        eVar.Q(typedArrayD.getDimension(23, 0.0f));
        eVar.a0(t1.c.a(context4, typedArrayD, 36));
        String text = typedArrayD.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(eVar.O, text)) {
            eVar.O = text;
            eVar.f12757u0.f13422d = true;
            eVar.invalidateSelf();
            eVar.E();
        }
        f fVar = (!typedArrayD.hasValue(0) || (resourceId3 = typedArrayD.getResourceId(0, 0)) == 0) ? null : new f(context4, resourceId3);
        fVar.l = typedArrayD.getDimension(1, fVar.l);
        eVar.b0(fVar);
        int i2 = typedArrayD.getInt(3, 0);
        if (i2 == 1) {
            eVar.L0 = TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            eVar.L0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i2 == 3) {
            eVar.L0 = TextUtils.TruncateAt.END;
        }
        eVar.O(typedArrayD.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            eVar.O(typedArrayD.getBoolean(15, false));
        }
        eVar.L(t1.c.c(context4, typedArrayD, 14));
        if (typedArrayD.hasValue(17)) {
            eVar.N(t1.c.a(context4, typedArrayD, 17));
        }
        eVar.M(typedArrayD.getDimension(16, -1.0f));
        eVar.X(typedArrayD.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            eVar.X(typedArrayD.getBoolean(26, false));
        }
        eVar.R(t1.c.c(context4, typedArrayD, 25));
        eVar.W(t1.c.a(context4, typedArrayD, 30));
        eVar.T(typedArrayD.getDimension(28, 0.0f));
        eVar.G(typedArrayD.getBoolean(6, false));
        eVar.J(typedArrayD.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            eVar.J(typedArrayD.getBoolean(8, false));
        }
        eVar.H(t1.c.c(context4, typedArrayD, 7));
        if (typedArrayD.hasValue(9)) {
            eVar.I(t1.c.a(context4, typedArrayD, 9));
        }
        eVar.f12747e0 = (!typedArrayD.hasValue(39) || (resourceId2 = typedArrayD.getResourceId(39, 0)) == 0) ? null : b.a(context4, resourceId2);
        eVar.f0 = (!typedArrayD.hasValue(33) || (resourceId = typedArrayD.getResourceId(33, 0)) == 0) ? null : b.a(context4, resourceId);
        float dimension2 = typedArrayD.getDimension(21, 0.0f);
        if (eVar.g0 != dimension2) {
            eVar.g0 = dimension2;
            eVar.invalidateSelf();
            eVar.E();
        }
        eVar.Z(typedArrayD.getDimension(35, 0.0f));
        eVar.Y(typedArrayD.getDimension(34, 0.0f));
        float dimension3 = typedArrayD.getDimension(41, 0.0f);
        if (eVar.f12748j0 != dimension3) {
            eVar.f12748j0 = dimension3;
            eVar.invalidateSelf();
            eVar.E();
        }
        float dimension4 = typedArrayD.getDimension(40, 0.0f);
        if (eVar.k0 != dimension4) {
            eVar.k0 = dimension4;
            eVar.invalidateSelf();
            eVar.E();
        }
        eVar.U(typedArrayD.getDimension(29, 0.0f));
        eVar.S(typedArrayD.getDimension(27, 0.0f));
        float dimension5 = typedArrayD.getDimension(13, 0.0f);
        if (eVar.f12751n0 != dimension5) {
            eVar.f12751n0 = dimension5;
            eVar.invalidateSelf();
            eVar.E();
        }
        eVar.N0 = typedArrayD.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayD.recycle();
        l.a(context2, attributeSet, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action);
        l.b(context2, attributeSet, iArr, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action);
        this.j = typedArrayObtainStyledAttributes.getBoolean(32, false);
        TypedValue typedValueA = t1.b.a(context2, com.cbt.exam.browser.R.attr.minTouchTargetSize);
        this.l = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (int) ((typedValueA == null || typedValueA.type != 5) ? context2.getResources().getDimension(com.cbt.exam.browser.R.dimen.mtrl_min_touch_target_size) : typedValueA.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(eVar);
        eVar.o(getElevation());
        l.a(context2, attributeSet, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action);
        l.b(context2, attributeSet, iArr, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f5329n = new c(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new l1.b(this));
        }
        setChecked(this.f5327f);
        setText(eVar.O);
        setEllipsize(eVar.L0);
        h();
        if (!this.f5323a.M0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.j) {
            setMinHeight(this.l);
        }
        this.k = getLayoutDirection();
        super.setOnCheckedChangeListener(new r(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f5331q;
        rectF.setEmpty();
        if (d() && this.f5326d != null) {
            e eVar = this.f5323a;
            Rect bounds = eVar.getBounds();
            rectF.setEmpty();
            if (eVar.e0()) {
                float f4 = eVar.f12751n0 + eVar.f12750m0 + eVar.Y + eVar.f12749l0 + eVar.k0;
                if (DrawableCompat.getLayoutDirection(eVar) == 0) {
                    float f8 = bounds.right;
                    rectF.right = f8;
                    rectF.left = f8 - f4;
                } else {
                    float f9 = bounds.left;
                    rectF.left = f9;
                    rectF.right = f9 + f4;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i2 = (int) closeIconTouchBounds.left;
        int i8 = (int) closeIconTouchBounds.top;
        int i9 = (int) closeIconTouchBounds.right;
        int i10 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.p;
        rect.set(i2, i8, i9, i10);
        return rect;
    }

    @Nullable
    private f getTextAppearance() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12757u0.f13423f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.h != z2) {
            this.h = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.g != z2) {
            this.g = z2;
            refreshDrawableState();
        }
    }

    public final void c(int i2) {
        this.l = i2;
        if (!this.j) {
            InsetDrawable insetDrawable = this.f5324b;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f5324b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i2 - ((int) this.f5323a.J));
        int iMax2 = Math.max(0, i2 - this.f5323a.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f5324b;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f5324b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i8 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i9 = iMax > 0 ? iMax / 2 : 0;
        if (this.f5324b != null) {
            Rect rect = new Rect();
            this.f5324b.getPadding(rect);
            if (rect.top == i9 && rect.bottom == i9 && rect.left == i8 && rect.right == i8) {
                f();
                return;
            }
        }
        if (getMinHeight() != i2) {
            setMinHeight(i2);
        }
        if (getMinWidth() != i2) {
            setMinWidth(i2);
        }
        this.f5324b = new InsetDrawable((Drawable) this.f5323a, i8, i9, i8, i9);
        f();
    }

    public final boolean d() {
        e eVar = this.f5323a;
        if (eVar == null) {
            return false;
        }
        Drawable drawable = eVar.V;
        return (drawable != null ? DrawableCompat.unwrap(drawable) : null) != null;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f5330o ? super.dispatchHoverEvent(motionEvent) : this.f5329n.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f5330o) {
            return super.dispatchKeyEvent(keyEvent);
        }
        c cVar = this.f5329n;
        if (!cVar.dispatchKeyEvent(keyEvent) || cVar.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f5323a;
        boolean zV = false;
        int i2 = 0;
        zV = false;
        if (eVar != null && e.D(eVar.V)) {
            e eVar2 = this.f5323a;
            ?? IsEnabled = isEnabled();
            int i8 = IsEnabled;
            if (this.f5328i) {
                i8 = IsEnabled + 1;
            }
            int i9 = i8;
            if (this.h) {
                i9 = i8 + 1;
            }
            int i10 = i9;
            if (this.g) {
                i10 = i9 + 1;
            }
            int i11 = i10;
            if (isChecked()) {
                i11 = i10 + 1;
            }
            int[] iArr = new int[i11];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            }
            if (this.f5328i) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.h) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.g) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            zV = eVar2.V(iArr);
        }
        if (zV) {
            invalidate();
        }
    }

    public final void e() {
        e eVar;
        if (!d() || (eVar = this.f5323a) == null || !eVar.U || this.f5326d == null) {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.f5330o = false;
        } else {
            ViewCompat.setAccessibilityDelegate(this, this.f5329n);
            this.f5330o = true;
        }
    }

    public final void f() {
        this.f5325c = new RippleDrawable(u1.a.a(this.f5323a.N), getBackgroundDrawable(), null);
        this.f5323a.getClass();
        setBackground(this.f5325c);
        g();
    }

    public final void g() {
        e eVar;
        if (TextUtils.isEmpty(getText()) || (eVar = this.f5323a) == null) {
            return;
        }
        int iA = (int) (eVar.A() + eVar.f12751n0 + eVar.k0);
        e eVar2 = this.f5323a;
        int iZ = (int) (eVar2.z() + eVar2.g0 + eVar2.f12748j0);
        if (this.f5324b != null) {
            Rect rect = new Rect();
            this.f5324b.getPadding(rect);
            iZ += rect.left;
            iA += rect.right;
        }
        setPaddingRelative(iZ, getPaddingTop(), iA, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        e eVar = this.f5323a;
        if (eVar == null || !eVar.f12744a0) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f5324b;
        return insetDrawable == null ? this.f5323a : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12746c0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.d0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.I;
        }
        return null;
    }

    public float getChipCornerRadius() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return Math.max(0.0f, eVar.B());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f5323a;
    }

    public float getChipEndPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12751n0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        e eVar = this.f5323a;
        if (eVar == null || (drawable = eVar.Q) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public float getChipIconSize() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.S;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.R;
        }
        return null;
    }

    public float getChipMinHeight() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.J;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.g0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.L;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.M;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable;
        e eVar = this.f5323a;
        if (eVar == null || (drawable = eVar.V) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.Z;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12750m0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.Y;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12749l0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.X;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.L0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f5330o) {
            c cVar = this.f5329n;
            if (cVar.getKeyboardFocusedVirtualViewId() == 1 || cVar.getAccessibilityFocusedVirtualViewId() == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Nullable
    public b getHideMotionSpec() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f0;
        }
        return null;
    }

    public float getIconEndPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.i0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.h0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.N;
        }
        return null;
    }

    @NonNull
    public o getShapeAppearanceModel() {
        return this.f5323a.f17716b.f17705a;
    }

    @Nullable
    public b getShowMotionSpec() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12747e0;
        }
        return null;
    }

    public float getTextEndPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.k0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        e eVar = this.f5323a;
        if (eVar != null) {
            return eVar.f12748j0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        e eVar = this.f5323a;
        if (eVar != null) {
            paint.drawableState = eVar.getState();
        }
        f textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f5332r);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q.u0(this, this.f5323a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f5321t);
        }
        e eVar = this.f5323a;
        if (eVar != null && eVar.f12744a0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f5322u);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.f5330o) {
            this.f5329n.onFocusChanged(z2, i2, rect);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        e eVar = this.f5323a;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.f12744a0);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.k != i2) {
            this.k = i2;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.g
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.g
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f5326d
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f5330o
            if (r0 == 0) goto L43
            l1.c r0 = r5.f5329n
            r0.sendEventForVirtualView(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.m = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f5325c) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f5325c) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.G(z2);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.G(eVar.f12752o0.getResources().getBoolean(i2));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        e eVar = this.f5323a;
        if (eVar == null) {
            this.f5327f = z2;
        } else if (eVar.f12744a0) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.H(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.H(AppCompatResources.getDrawable(eVar.f12752o0, i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.I(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.I(AppCompatResources.getColorStateList(eVar.f12752o0, i2));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.J(eVar.f12752o0.getResources().getBoolean(i2));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.I == colorStateList) {
            return;
        }
        eVar.I = colorStateList;
        eVar.onStateChange(eVar.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        ColorStateList colorStateList;
        e eVar = this.f5323a;
        if (eVar == null || eVar.I == (colorStateList = AppCompatResources.getColorStateList(eVar.f12752o0, i2))) {
            return;
        }
        eVar.I = colorStateList;
        eVar.onStateChange(eVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.K(f4);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.K(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(@NonNull e eVar) {
        e eVar2 = this.f5323a;
        if (eVar2 != eVar) {
            if (eVar2 != null) {
                eVar2.K0 = new WeakReference(null);
            }
            this.f5323a = eVar;
            eVar.M0 = false;
            eVar.K0 = new WeakReference(this);
            c(this.l);
        }
    }

    public void setChipEndPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.f12751n0 == f4) {
            return;
        }
        eVar.f12751n0 = f4;
        eVar.invalidateSelf();
        eVar.E();
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            float dimension = eVar.f12752o0.getResources().getDimension(i2);
            if (eVar.f12751n0 != dimension) {
                eVar.f12751n0 = dimension;
                eVar.invalidateSelf();
                eVar.E();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.L(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.L(AppCompatResources.getDrawable(eVar.f12752o0, i2));
        }
    }

    public void setChipIconSize(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.M(f4);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.M(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.N(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.N(AppCompatResources.getColorStateList(eVar.f12752o0, i2));
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.O(eVar.f12752o0.getResources().getBoolean(i2));
        }
    }

    public void setChipMinHeight(float f4) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.J == f4) {
            return;
        }
        eVar.J = f4;
        eVar.invalidateSelf();
        eVar.E();
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            float dimension = eVar.f12752o0.getResources().getDimension(i2);
            if (eVar.J != dimension) {
                eVar.J = dimension;
                eVar.invalidateSelf();
                eVar.E();
            }
        }
    }

    public void setChipStartPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.g0 == f4) {
            return;
        }
        eVar.g0 = f4;
        eVar.invalidateSelf();
        eVar.E();
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            float dimension = eVar.f12752o0.getResources().getDimension(i2);
            if (eVar.g0 != dimension) {
                eVar.g0 = dimension;
                eVar.invalidateSelf();
                eVar.E();
            }
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.P(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.P(AppCompatResources.getColorStateList(eVar.f12752o0, i2));
        }
    }

    public void setChipStrokeWidth(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Q(f4);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Q(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.R(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.Z == charSequence) {
            return;
        }
        eVar.Z = BidiFormatter.getInstance().unicodeWrap(charSequence);
        eVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.S(f4);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.S(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.R(AppCompatResources.getDrawable(eVar.f12752o0, i2));
        }
        e();
    }

    public void setCloseIconSize(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.T(f4);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.T(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.U(f4);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.U(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.W(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.W(AppCompatResources.getColorStateList(eVar.f12752o0, i2));
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i8, int i9, int i10) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i2, int i8, int i9, int i10) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i8, i9, i10);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.o(f4);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f5323a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.L0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.j = z2;
        c(this.l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@Nullable b bVar) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.f0 = bVar;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.f0 = b.a(eVar.f12752o0, i2);
        }
    }

    public void setIconEndPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Y(f4);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Y(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Z(f4);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.Z(eVar.f12752o0.getResources().getDimension(i2));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f5323a == null) {
            return;
        }
        super.setLayoutDirection(i2);
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.N0 = i2;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f5326d = onClickListener;
        e();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.a0(colorStateList);
        }
        this.f5323a.getClass();
        f();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.a0(AppCompatResources.getColorStateList(eVar.f12752o0, i2));
            this.f5323a.getClass();
            f();
        }
    }

    @Override // w1.z
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.f5323a.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(@Nullable b bVar) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.f12747e0 = bVar;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.f12747e0 = b.a(eVar.f12752o0, i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        e eVar = this.f5323a;
        if (eVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(eVar.M0 ? null : charSequence, bufferType);
        e eVar2 = this.f5323a;
        if (eVar2 == null || TextUtils.equals(eVar2.O, charSequence)) {
            return;
        }
        eVar2.O = charSequence;
        eVar2.f12757u0.f13422d = true;
        eVar2.invalidateSelf();
        eVar2.E();
    }

    public void setTextAppearance(@Nullable f fVar) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.b0(fVar);
        }
        h();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.k0 == f4) {
            return;
        }
        eVar.k0 = f4;
        eVar.invalidateSelf();
        eVar.E();
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            float dimension = eVar.f12752o0.getResources().getDimension(i2);
            if (eVar.k0 != dimension) {
                eVar.k0 = dimension;
                eVar.invalidateSelf();
                eVar.E();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f4) {
        super.setTextSize(i2, f4);
        e eVar = this.f5323a;
        if (eVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i2, f4, getResources().getDisplayMetrics());
            j jVar = eVar.f12757u0;
            f fVar = jVar.f13423f;
            if (fVar != null) {
                fVar.l = fApplyDimension;
                jVar.f13419a.setTextSize(fApplyDimension);
                eVar.E();
                eVar.invalidateSelf();
            }
        }
        h();
    }

    public void setTextStartPadding(float f4) {
        e eVar = this.f5323a;
        if (eVar == null || eVar.f12748j0 == f4) {
            return;
        }
        eVar.f12748j0 = f4;
        eVar.invalidateSelf();
        eVar.E();
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            float dimension = eVar.f12752o0.getResources().getDimension(i2);
            if (eVar.f12748j0 != dimension) {
                eVar.f12748j0 = dimension;
                eVar.invalidateSelf();
                eVar.E();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.X(z2);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.J(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.O(z2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.b0(new f(eVar.f12752o0, i2));
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        e eVar = this.f5323a;
        if (eVar != null) {
            eVar.b0(new f(eVar.f12752o0, i2));
        }
        h();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable q1.f fVar) {
    }
}
