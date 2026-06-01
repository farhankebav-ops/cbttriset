package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import h1.a;
import h1.b;
import h1.d;
import h1.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.l;
import q1.p;
import r2.q;
import t1.c;
import w1.c0;
import w1.e0;
import w1.k;
import w1.n;
import w1.o;
import w1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MaterialButton extends AppCompatButton implements Checkable, z {
    public static final int[] C = {R.attr.state_checkable};
    public static final int[] D = {R.attr.state_checked};
    public static final a E = new a("widthIncrease");
    public float A;
    public SpringAnimation B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f5293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f5294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f5295d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f5296f;
    public String g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5297i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5299o;
    public float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5300q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5301r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LinearLayout.LayoutParams f5302s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5303t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5304u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5305v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5306w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e0 f5307x;
    public int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f5308z;

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(b2.a.b(context, attributeSet, new int[]{com.cbt.exam.browser.R.attr.materialSizeOverlay}, com.cbt.exam.browser.R.attr.materialButtonStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Button), attributeSet, com.cbt.exam.browser.R.attr.materialButtonStyle);
        this.f5293b = new LinkedHashSet();
        this.l = false;
        this.m = false;
        this.f5299o = -1;
        this.p = -1.0f;
        this.f5300q = -1;
        this.f5301r = -1;
        this.f5306w = -1;
        Context context2 = getContext();
        TypedArray typedArrayD = l.d(context2, attributeSet, b1.a.m, com.cbt.exam.browser.R.attr.materialButtonStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.k = typedArrayD.getDimensionPixelSize(13, 0);
        int i2 = typedArrayD.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f5295d = p.a(i2, mode);
        this.e = c.a(getContext(), typedArrayD, 15);
        this.f5296f = c.c(getContext(), typedArrayD, 11);
        this.f5298n = typedArrayD.getInteger(12, 1);
        this.h = typedArrayD.getDimensionPixelSize(14, 0);
        c0 c0VarB = c0.b(context2, typedArrayD, 19);
        o oVarC = c0VarB != null ? c0VarB.c() : o.b(context2, attributeSet, com.cbt.exam.browser.R.attr.materialButtonStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Button).a();
        boolean z2 = typedArrayD.getBoolean(17, false);
        e eVar = new e(this, oVarC);
        this.f5292a = eVar;
        eVar.f11670f = typedArrayD.getDimensionPixelOffset(2, 0);
        eVar.g = typedArrayD.getDimensionPixelOffset(3, 0);
        eVar.h = typedArrayD.getDimensionPixelOffset(4, 0);
        eVar.f11671i = typedArrayD.getDimensionPixelOffset(5, 0);
        if (typedArrayD.hasValue(9)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(9, -1);
            eVar.j = dimensionPixelSize;
            float f4 = dimensionPixelSize;
            n nVarF = eVar.f11667b.f();
            nVarF.e = new w1.a(f4);
            nVarF.f17737f = new w1.a(f4);
            nVarF.g = new w1.a(f4);
            nVarF.h = new w1.a(f4);
            eVar.f11667b = nVarF.a();
            eVar.f11668c = null;
            eVar.d();
            eVar.f11676s = true;
        }
        eVar.k = typedArrayD.getDimensionPixelSize(22, 0);
        eVar.l = p.a(typedArrayD.getInt(8, -1), mode);
        eVar.m = c.a(getContext(), typedArrayD, 7);
        eVar.f11672n = c.a(getContext(), typedArrayD, 21);
        eVar.f11673o = c.a(getContext(), typedArrayD, 18);
        eVar.f11677t = typedArrayD.getBoolean(6, false);
        eVar.f11680w = typedArrayD.getDimensionPixelSize(10, 0);
        eVar.f11678u = typedArrayD.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(0)) {
            eVar.f11675r = true;
            setSupportBackgroundTintList(eVar.m);
            setSupportBackgroundTintMode(eVar.l);
        } else {
            eVar.c();
        }
        setPaddingRelative(paddingStart + eVar.f11670f, paddingTop + eVar.h, paddingEnd + eVar.g, paddingBottom + eVar.f11671i);
        setCheckedInternal(typedArrayD.getBoolean(1, false));
        if (c0VarB != null) {
            eVar.f11669d = d();
            if (eVar.f11668c != null) {
                eVar.d();
            }
            eVar.f11668c = c0VarB;
            eVar.d();
        }
        setOpticalCenterEnabled(z2);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.k);
        h(this.f5296f != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.f5304u = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f5308z;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        k kVarA;
        if (this.f5303t && this.f5305v && (kVarA = this.f5292a.a(false)) != null) {
            return (int) (kVarA.h() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < lineCount; i2++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i2));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z2) {
        e eVar = this.f5292a;
        if (eVar == null || !eVar.f11677t || this.l == z2) {
            return;
        }
        this.l = z2;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z7 = this.l;
            if (!materialButtonToggleGroup.l) {
                materialButtonToggleGroup.f(getId(), z7);
            }
        }
        if (this.m) {
            return;
        }
        this.m = true;
        Iterator it = this.f5293b.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f4) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.f5308z != f4) {
            this.f5308z = f4;
            j();
            invalidate();
            if (getParent() instanceof d) {
                d dVar = (d) getParent();
                int i2 = (int) this.f5308z;
                int iIndexOfChild = dVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i8 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i8 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (dVar.c(i8)) {
                            materialButton2 = (MaterialButton) dVar.getChildAt(i8);
                            break;
                        }
                        i8--;
                    }
                }
                int childCount = dVar.getChildCount();
                while (true) {
                    iIndexOfChild++;
                    if (iIndexOfChild >= childCount) {
                        break;
                    } else if (dVar.c(iIndexOfChild)) {
                        materialButton = (MaterialButton) dVar.getChildAt(iIndexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i2);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i2);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i2 / 2);
                materialButton.setDisplayedWidthDecrease((i2 + 1) / 2);
            }
        }
    }

    public final SpringForce d() {
        Context context = getContext();
        TypedValue typedValueA = t1.b.a(context, com.cbt.exam.browser.R.attr.motionSpringFastSpatial);
        int[] iArr = b1.a.f4140w;
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, iArr, 0, com.cbt.exam.browser.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueA.resourceId, iArr);
        SpringForce springForce = new SpringForce();
        try {
            float f4 = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f4 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f8 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f8 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            springForce.setStiffness(f4);
            springForce.setDampingRatio(f8);
            return springForce;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean e() {
        e eVar = this.f5292a;
        return (eVar == null || eVar.f11675r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            w1.e0 r0 = r8.f5307x
            if (r0 != 0) goto L6
            goto L86
        L6:
            androidx.dynamicanimation.animation.SpringAnimation r0 = r8.B
            if (r0 != 0) goto L1a
            androidx.dynamicanimation.animation.SpringAnimation r0 = new androidx.dynamicanimation.animation.SpringAnimation
            h1.a r1 = com.google.android.material.button.MaterialButton.E
            r0.<init>(r8, r1)
            r8.B = r0
            androidx.dynamicanimation.animation.SpringForce r1 = r8.d()
            r0.setSpring(r1)
        L1a:
            boolean r0 = r8.f5305v
            if (r0 == 0) goto L86
            int r0 = r8.y
            w1.e0 r1 = r8.f5307x
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f17701c
            r4 = 0
            r5 = r4
        L2a:
            int r6 = r1.f17699a
            r7 = -1
            if (r5 >= r6) goto L3b
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L38
            goto L3c
        L38:
            int r5 = r5 + 1
            goto L2a
        L3b:
            r5 = r7
        L3c:
            if (r5 >= 0) goto L55
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f17701c
            r5 = r4
        L43:
            int r6 = r1.f17699a
            if (r5 >= r6) goto L54
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L51
            r7 = r5
            goto L54
        L51:
            int r5 = r5 + 1
            goto L43
        L54:
            r5 = r7
        L55:
            if (r5 >= 0) goto L5a
            a4.a r1 = r1.f17700b
            goto L5e
        L5a:
            a4.a[] r1 = r1.f17702d
            r1 = r1[r5]
        L5e:
            java.lang.Object r1 = r1.f3216b
            w1.d0 r1 = (w1.d0) r1
            int r2 = r8.getWidth()
            float r3 = r1.f17698b
            int r1 = r1.f17697a
            r5 = 1
            if (r1 != r5) goto L71
            float r1 = (float) r2
            float r3 = r3 * r1
        L6f:
            int r4 = (int) r3
            goto L75
        L71:
            r2 = 2
            if (r1 != r2) goto L75
            goto L6f
        L75:
            int r0 = java.lang.Math.min(r0, r4)
            androidx.dynamicanimation.animation.SpringAnimation r1 = r8.B
            float r0 = (float) r0
            r1.animateToFinalPosition(r0)
            if (r9 == 0) goto L86
            androidx.dynamicanimation.animation.SpringAnimation r9 = r8.B
            r9.skipToEnd()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i2 = this.f5298n;
        if (i2 == 1 || i2 == 2) {
            setCompoundDrawablesRelative(this.f5296f, null, null, null);
            return;
        }
        if (i2 == 3 || i2 == 4) {
            setCompoundDrawablesRelative(null, null, this.f5296f, null);
        } else if (i2 == 16 || i2 == 32) {
            setCompoundDrawablesRelative(null, this.f5296f, null, null);
        }
    }

    @NonNull
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        e eVar = this.f5292a;
        return ((eVar == null || !eVar.f11677t) ? Button.class : CompoundButton.class).getName();
    }

    @Px
    public int getAllowedWidthDecrease() {
        return this.f5306w;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (e()) {
            return this.f5292a.j;
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SpringForce getCornerSpringForce() {
        return this.f5292a.f11669d;
    }

    public Drawable getIcon() {
        return this.f5296f;
    }

    public int getIconGravity() {
        return this.f5298n;
    }

    @Px
    public int getIconPadding() {
        return this.k;
    }

    @Px
    public int getIconSize() {
        return this.h;
    }

    public ColorStateList getIconTint() {
        return this.e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f5295d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f5292a.f11671i;
    }

    @Dimension
    public int getInsetTop() {
        return this.f5292a.h;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f5292a.f11673o;
        }
        return null;
    }

    @NonNull
    public o getShapeAppearanceModel() {
        if (e()) {
            return this.f5292a.f11667b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public c0 getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f5292a.f11668c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f5292a.f11672n;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (e()) {
            return this.f5292a.k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f5292a.m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f5292a.l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z2) {
        Drawable drawable = this.f5296f;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f5296f = drawableMutate;
            drawableMutate.setTintList(this.e);
            PorterDuff.Mode mode = this.f5295d;
            if (mode != null) {
                this.f5296f.setTintMode(mode);
            }
            int intrinsicWidth = this.h;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f5296f.getIntrinsicWidth();
            }
            int intrinsicHeight = this.h;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f5296f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f5296f;
            int i2 = this.f5297i;
            int i8 = this.j;
            drawable2.setBounds(i2, i8, intrinsicWidth + i2, intrinsicHeight + i8);
            this.f5296f.setVisible(true, z2);
        }
        if (z2) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i9 = this.f5298n;
        if (((i9 == 1 || i9 == 2) && drawable3 != this.f5296f) || (((i9 == 3 || i9 == 4) && drawable5 != this.f5296f) || ((i9 == 16 || i9 == 32) && drawable4 != this.f5296f))) {
            g();
        }
    }

    public final void i(int i2, int i8) {
        if (this.f5296f == null || getLayout() == null) {
            return;
        }
        int i9 = this.f5298n;
        if (i9 != 1 && i9 != 2 && i9 != 3 && i9 != 4) {
            if (i9 == 16 || i9 == 32) {
                this.f5297i = 0;
                if (i9 == 16) {
                    this.j = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.h;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f5296f.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i8 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.k) - getPaddingBottom()) / 2);
                if (this.j != iMax) {
                    this.j = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i10 = this.f5298n;
        if (i10 == 1 || i10 == 3 || ((i10 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i10 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f5297i = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.h;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f5296f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i2 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.k) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f5298n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f5297i != textLayoutWidth) {
            this.f5297i = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.l;
    }

    public final void j() {
        int i2 = (int) (this.f5308z - this.A);
        int i8 = (i2 / 2) + this.f5304u;
        getLayoutParams().width = (int) (this.p + i2);
        setPaddingRelative(this.f5300q + i8, getPaddingTop(), (this.f5301r + i2) - i8, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            q.u0(this, this.f5292a.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        e eVar = this.f5292a;
        if (eVar != null && eVar.f11677t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        if (this.l) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.l);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        e eVar = this.f5292a;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.f11677t);
        accessibilityNodeInfo.setChecked(this.l);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        super.onLayout(z2, i2, i8, i9, i10);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i12 = getResources().getConfiguration().orientation;
        if (this.f5299o != i12) {
            this.f5299o = i12;
            this.p = -1.0f;
        }
        if (this.p == -1.0f) {
            this.p = getMeasuredWidth();
            if (this.f5302s == null && (getParent() instanceof d) && ((d) getParent()).getButtonSizeChange() != null) {
                this.f5302s = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f5302s);
                layoutParams.width = (int) this.p;
                setLayoutParams(layoutParams);
            }
        }
        boolean z7 = false;
        if (this.f5306w == -1) {
            if (this.f5296f == null) {
                i11 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.h;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f5296f.getIntrinsicWidth();
                }
                i11 = iconPadding + intrinsicWidth;
            }
            this.f5306w = (getMeasuredWidth() - getTextLayoutWidth()) - i11;
        }
        if (this.f5300q == -1) {
            this.f5300q = getPaddingStart();
        }
        if (this.f5301r == -1) {
            this.f5301r = getPaddingEnd();
        }
        if ((getParent() instanceof d) && ((d) getParent()).getOrientation() == 0) {
            z7 = true;
        }
        this.f5305v = z7;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h1.c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h1.c cVar = (h1.c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        setChecked(cVar.f11659a);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        h1.c cVar = new h1.c(super.onSaveInstanceState());
        cVar.f11659a = this.l;
        return cVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
        super.onTextChanged(charSequence, i2, i8, i9);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f5292a.f11678u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f5296f != null) {
            if (this.f5296f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setA11yClassName(@Nullable String str) {
        this.g = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (!e()) {
            super.setBackgroundColor(i2);
            return;
        }
        e eVar = this.f5292a;
        if (eVar.a(false) != null) {
            eVar.a(false).setTint(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        e eVar = this.f5292a;
        eVar.f11675r = true;
        MaterialButton materialButton = eVar.f11666a;
        materialButton.setSupportBackgroundTintList(eVar.m);
        materialButton.setSupportBackgroundTintMode(eVar.l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (e()) {
            this.f5292a.f11677t = z2;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedInternal(z2);
    }

    public void setCornerRadius(@Px int i2) {
        if (e()) {
            e eVar = this.f5292a;
            if (eVar.f11676s && eVar.j == i2) {
                return;
            }
            eVar.j = i2;
            eVar.f11676s = true;
            float f4 = i2;
            n nVarF = eVar.f11667b.f();
            nVarF.e = new w1.a(f4);
            nVarF.f17737f = new w1.a(f4);
            nVarF.g = new w1.a(f4);
            nVarF.h = new w1.a(f4);
            eVar.f11667b = nVarF.a();
            eVar.f11668c = null;
            eVar.d();
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCornerSpringForce(@NonNull SpringForce springForce) {
        e eVar = this.f5292a;
        eVar.f11669d = springForce;
        if (eVar.f11668c != null) {
            eVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i2) {
        this.A = Math.min(i2, this.f5306w);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (e()) {
            this.f5292a.a(false).o(f4);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f5296f != drawable) {
            this.f5296f = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.f5298n != i2) {
            this.f5298n = i2;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.k != i2) {
            this.k = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.h != i2) {
            this.h = i2;
            h(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f5295d != mode) {
            this.f5295d = mode;
            h(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        e eVar = this.f5292a;
        eVar.b(eVar.h, i2);
    }

    public void setInsetTop(@Dimension int i2) {
        e eVar = this.f5292a;
        eVar.b(i2, eVar.f11671i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f5294c = bVar;
    }

    public void setOpticalCenterEnabled(boolean z2) {
        if (this.f5303t != z2) {
            this.f5303t = z2;
            e eVar = this.f5292a;
            if (z2) {
                androidx.camera.core.impl.b bVar = new androidx.camera.core.impl.b(this, 29);
                eVar.e = bVar;
                k kVarA = eVar.a(false);
                if (kVarA != null) {
                    kVarA.E = bVar;
                }
            } else {
                eVar.e = null;
                k kVarA2 = eVar.a(false);
                if (kVarA2 != null) {
                    kVarA2.E = null;
                }
            }
            post(new com.vungle.ads.internal.omsdk.a(this, 3));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        b bVar = this.f5294c;
        if (bVar != null) {
            ((MaterialButtonToggleGroup) ((a4.a) bVar).f3216b).invalidate();
        }
        super.setPressed(z2);
        f(false);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            e eVar = this.f5292a;
            MaterialButton materialButton = eVar.f11666a;
            if (eVar.f11673o != colorStateList) {
                eVar.f11673o = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(u1.a.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (e()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // w1.z
    public void setShapeAppearanceModel(@NonNull o oVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f5292a;
        eVar.f11667b = oVar;
        eVar.f11668c = null;
        eVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (e()) {
            e eVar = this.f5292a;
            eVar.f11674q = z2;
            eVar.e();
        }
    }

    public void setSizeChange(@NonNull e0 e0Var) {
        if (this.f5307x != e0Var) {
            this.f5307x = e0Var;
            f(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearanceModel(@NonNull c0 c0Var) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f5292a;
        if (eVar.f11669d == null && c0Var.d()) {
            eVar.f11669d = d();
            if (eVar.f11668c != null) {
                eVar.d();
            }
        }
        eVar.f11668c = c0Var;
        eVar.d();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            e eVar = this.f5292a;
            if (eVar.f11672n != colorStateList) {
                eVar.f11672n = colorStateList;
                eVar.e();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (e()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (e()) {
            e eVar = this.f5292a;
            if (eVar.k != i2) {
                eVar.k = i2;
                eVar.e();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        e eVar = this.f5292a;
        if (eVar.m != colorStateList) {
            eVar.m = colorStateList;
            if (eVar.a(false) != null) {
                eVar.a(false).setTintList(eVar.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        e eVar = this.f5292a;
        if (eVar.l != mode) {
            eVar.l = mode;
            if (eVar.a(false) == null || eVar.l == null) {
                return;
            }
            eVar.a(false).setTintMode(eVar.l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i2) {
        super.setTextAlignment(i2);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z2) {
        this.f5292a.f11678u = z2;
    }

    @Override // android.widget.TextView
    public void setWidth(@Px int i2) {
        this.p = -1.0f;
        super.setWidth(i2);
    }

    public void setWidthChangeMax(@Px int i2) {
        if (this.y != i2) {
            this.y = i2;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.l);
    }
}
