package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import b2.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mimikridev.utilmanager.config.b;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.c;
import q1.d;
import q1.l;
import r2.q;
import w1.f;
import w1.h;
import w1.k;
import w1.m;
import w1.o;
import z1.a0;
import z1.g;
import z1.j;
import z1.n;
import z1.r;
import z1.u;
import z1.w;
import z1.x;
import z1.y;
import z1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] D0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public boolean A0;
    public ColorStateList B;
    public boolean B0;
    public ColorStateList C;
    public boolean C0;
    public boolean D;
    public CharSequence E;
    public boolean F;
    public k G;
    public k H;
    public StateListDrawable I;
    public boolean J;
    public k K;
    public k L;
    public o M;
    public boolean N;
    public final int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public final Rect W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f5449a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Rect f5450a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f5451b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final RectF f5452b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f5453c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Typeface f5454c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5455d;
    public ColorDrawable d0;
    public EditText e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f5456e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f5457f;
    public final LinkedHashSet f0;
    public int g;
    public ColorDrawable g0;
    public int h;
    public int h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5458i;
    public Drawable i0;
    public int j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ColorStateList f5459j0;
    public final r k;
    public ColorStateList k0;
    public boolean l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f5460l0;
    public int m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f5461m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5462n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f5463n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public z f5464o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public ColorStateList f5465o0;
    public AppCompatTextView p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f5466p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5467q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f5468q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5469r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f5470r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f5471s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f5472s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5473t;
    public int t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AppCompatTextView f5474u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f5475u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f5476v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f5477v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5478w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final c f5479w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Fade f5480x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f5481x0;
    public Fade y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f5482y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f5483z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ValueAnimator f5484z0;

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(a.a(context, attributeSet, com.cbt.exam.browser.R.attr.textInputStyle, com.cbt.exam.browser.R.style.Widget_Design_TextInputLayout), attributeSet, com.cbt.exam.browser.R.attr.textInputStyle);
        this.g = -1;
        this.h = -1;
        this.f5458i = -1;
        this.j = -1;
        this.k = new r(this);
        this.f5464o = new b(12);
        this.W = new Rect();
        this.f5450a0 = new Rect();
        this.f5452b0 = new RectF();
        this.f0 = new LinkedHashSet();
        c cVar = new c(this);
        this.f5479w0 = cVar;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f5449a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = c1.a.f4168a;
        cVar.R = linearInterpolator;
        cVar.j(false);
        cVar.Q = linearInterpolator;
        cVar.j(false);
        if (cVar.g != 8388659) {
            cVar.g = 8388659;
            cVar.j(false);
        }
        l.a(context2, attributeSet, com.cbt.exam.browser.R.attr.textInputStyle, com.cbt.exam.browser.R.style.Widget_Design_TextInputLayout);
        int[] iArr = b1.a.I;
        l.b(context2, attributeSet, iArr, com.cbt.exam.browser.R.attr.textInputStyle, com.cbt.exam.browser.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, com.cbt.exam.browser.R.attr.textInputStyle, com.cbt.exam.browser.R.style.Widget_Design_TextInputLayout);
        w wVar = new w(this, tintTypedArrayObtainStyledAttributes);
        this.f5451b = wVar;
        this.D = tintTypedArrayObtainStyledAttributes.getBoolean(48, true);
        setHint(tintTypedArrayObtainStyledAttributes.getText(4));
        this.f5482y0 = tintTypedArrayObtainStyledAttributes.getBoolean(47, true);
        this.f5481x0 = tintTypedArrayObtainStyledAttributes.getBoolean(42, true);
        if (tintTypedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(tintTypedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(tintTypedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.M = o.b(context2, attributeSet, com.cbt.exam.browser.R.attr.textInputStyle, com.cbt.exam.browser.R.style.Widget_Design_TextInputLayout).a();
        this.O = context2.getResources().getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.Q = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f5455d = getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.S = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.T = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.R = this.S;
        float dimension = tintTypedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = tintTypedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = tintTypedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = tintTypedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        w1.n nVarF = this.M.f();
        if (dimension >= 0.0f) {
            nVarF.e = new w1.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            nVarF.f17737f = new w1.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            nVarF.g = new w1.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            nVarF.h = new w1.a(dimension4);
        }
        this.M = nVarF.a();
        ColorStateList colorStateListB = t1.c.b(context2, tintTypedArrayObtainStyledAttributes, 7);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f5466p0 = defaultColor;
            this.V = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f5468q0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f5470r0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f5472s0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f5470r0 = this.f5466p0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, com.cbt.exam.browser.R.color.mtrl_filled_background_color);
                this.f5468q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.f5472s0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.f5466p0 = 0;
            this.f5468q0 = 0;
            this.f5470r0 = 0;
            this.f5472s0 = 0;
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList2 = tintTypedArrayObtainStyledAttributes.getColorStateList(1);
            this.k0 = colorStateList2;
            this.f5459j0 = colorStateList2;
        }
        ColorStateList colorStateListB2 = t1.c.b(context2, tintTypedArrayObtainStyledAttributes, 14);
        this.f5463n0 = tintTypedArrayObtainStyledAttributes.getColor(14, 0);
        this.f5460l0 = ContextCompat.getColor(context2, com.cbt.exam.browser.R.color.mtrl_textinput_default_box_stroke_color);
        this.t0 = ContextCompat.getColor(context2, com.cbt.exam.browser.R.color.mtrl_textinput_disabled_color);
        this.f5461m0 = ContextCompat.getColor(context2, com.cbt.exam.browser.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(t1.c.b(context2, tintTypedArrayObtainStyledAttributes, 15));
        }
        if (tintTypedArrayObtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(tintTypedArrayObtainStyledAttributes.getResourceId(50, 0));
        }
        this.B = tintTypedArrayObtainStyledAttributes.getColorStateList(24);
        this.C = tintTypedArrayObtainStyledAttributes.getColorStateList(25);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = tintTypedArrayObtainStyledAttributes.getText(35);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z2 = tintTypedArrayObtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(45, 0);
        boolean z7 = tintTypedArrayObtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(43);
        int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = tintTypedArrayObtainStyledAttributes.getText(57);
        boolean z8 = tintTypedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(tintTypedArrayObtainStyledAttributes.getInt(19, -1));
        this.f5469r = tintTypedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f5467q = tintTypedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(tintTypedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i2);
        setCounterOverflowTextAppearance(this.f5467q);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f5469r);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (tintTypedArrayObtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(41));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(46));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(51)) {
            setHintTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(51));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(23));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(21));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(59));
        }
        n nVar = new n(this, tintTypedArrayObtainStyledAttributes);
        this.f5453c = nVar;
        boolean z9 = tintTypedArrayObtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(tintTypedArrayObtainStyledAttributes.getInt(49, 1));
        tintTypedArrayObtainStyledAttributes.recycle();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(wVar);
        frameLayout.addView(nVar);
        addView(frameLayout);
        setEnabled(z9);
        setHelperTextEnabled(z7);
        setErrorEnabled(z2);
        setCounterEnabled(z8);
        setHelperText(text2);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.e;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.G;
        }
        int iB = m1.a.b(this.e, androidx.appcompat.R.attr.colorControlHighlight);
        int i2 = this.P;
        int[][] iArr = D0;
        if (i2 != 2) {
            if (i2 != 1) {
                return null;
            }
            k kVar = this.G;
            int i8 = this.V;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{m1.a.c(iB, i8, 0.1f), i8}), kVar, kVar);
        }
        Context context = getContext();
        k kVar2 = this.G;
        TypedValue typedValueC = t1.b.c(context, com.cbt.exam.browser.R.attr.colorSurface, "TextInputLayout");
        int i9 = typedValueC.resourceId;
        int color = i9 != 0 ? ContextCompat.getColor(context, i9) : typedValueC.data;
        k kVar3 = new k(kVar2.f17716b.f17705a);
        int iC = m1.a.c(iB, color, 0.1f);
        kVar3.p(new ColorStateList(iArr, new int[]{iC, 0}));
        kVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iC, color});
        k kVar4 = new k(kVar2.f17716b.f17705a);
        kVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, kVar3, kVar4), kVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], h(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = h(true);
        }
        return this.H;
    }

    public static void m(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z2);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i2 = this.g;
        if (i2 != -1) {
            setMinEms(i2);
        } else {
            setMinWidth(this.f5458i);
        }
        int i8 = this.h;
        if (i8 != -1) {
            setMaxEms(i8);
        } else {
            setMaxWidth(this.j);
        }
        this.J = false;
        k();
        setTextInputAccessibilityDelegate(new y(this));
        Typeface typeface = this.e.getTypeface();
        c cVar = this.f5479w0;
        cVar.n(typeface);
        float textSize = this.e.getTextSize();
        if (cVar.h != textSize) {
            cVar.h = textSize;
            cVar.j(false);
        }
        float letterSpacing = this.e.getLetterSpacing();
        if (cVar.X != letterSpacing) {
            cVar.X = letterSpacing;
            cVar.j(false);
        }
        int gravity = this.e.getGravity();
        int i9 = (gravity & (-113)) | 48;
        if (cVar.g != i9) {
            cVar.g = i9;
            cVar.j(false);
        }
        if (cVar.f13392f != gravity) {
            cVar.f13392f = gravity;
            cVar.j(false);
        }
        this.f5475u0 = editText.getMinimumHeight();
        this.e.addTextChangedListener(new x(this, editText));
        if (this.f5459j0 == null) {
            this.f5459j0 = this.e.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.e.getHint();
                this.f5457f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        if (this.p != null) {
            p(this.e.getText());
        }
        t();
        this.k.b();
        this.f5451b.bringToFront();
        n nVar = this.f5453c;
        nVar.bringToFront();
        Iterator it = this.f0.iterator();
        while (it.hasNext()) {
            ((z1.l) it.next()).a(this);
        }
        nVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        c cVar = this.f5479w0;
        if (charSequence == null || !TextUtils.equals(cVar.B, charSequence)) {
            cVar.B = charSequence;
            cVar.C = null;
            cVar.j(false);
        }
        if (this.f5477v0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.f5473t == z2) {
            return;
        }
        if (z2) {
            AppCompatTextView appCompatTextView = this.f5474u;
            if (appCompatTextView != null) {
                this.f5449a.addView(appCompatTextView);
                this.f5474u.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f5474u;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.f5474u = null;
        }
        this.f5473t = z2;
    }

    public final void a() {
        if (this.e == null || this.P != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f5479w0.f() + this.f5455d), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_filled_edittext_font_2_0_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (t1.c.d(getContext())) {
            EditText editText3 = this.e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_filled_edittext_font_1_3_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f5449a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f4) {
        c cVar = this.f5479w0;
        if (cVar.f13386b == f4) {
            return;
        }
        int i2 = 1;
        if (this.f5484z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f5484z0 = valueAnimator;
            valueAnimator.setInterpolator(a.a.T(getContext(), com.cbt.exam.browser.R.attr.motionEasingEmphasizedInterpolator, c1.a.f4169b));
            this.f5484z0.setDuration(a.a.S(getContext(), com.cbt.exam.browser.R.attr.motionDurationMedium4, 167));
            this.f5484z0.addUpdateListener(new g1.b(this, i2));
        }
        this.f5484z0.setFloatValues(cVar.f13386b, f4);
        this.f5484z0.start();
    }

    public final void c() {
        int i2;
        int i8;
        k kVar = this.G;
        if (kVar == null) {
            return;
        }
        o oVar = kVar.f17716b.f17705a;
        o oVar2 = this.M;
        if (oVar != oVar2) {
            kVar.setShapeAppearanceModel(oVar2);
        }
        if (this.P == 2 && (i2 = this.R) > -1 && (i8 = this.U) != 0) {
            k kVar2 = this.G;
            kVar2.f17716b.k = i2;
            kVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i8);
            h hVar = kVar2.f17716b;
            if (hVar.e != colorStateListValueOf) {
                hVar.e = colorStateListValueOf;
                kVar2.onStateChange(kVar2.getState());
            }
        }
        int iCompositeColors = this.V;
        if (this.P == 1) {
            iCompositeColors = ColorUtils.compositeColors(this.V, m1.a.a(getContext(), com.cbt.exam.browser.R.attr.colorSurface, 0));
        }
        this.V = iCompositeColors;
        this.G.p(ColorStateList.valueOf(iCompositeColors));
        k kVar3 = this.K;
        if (kVar3 != null && this.L != null) {
            if (this.R > -1 && this.U != 0) {
                kVar3.p(this.e.isFocused() ? ColorStateList.valueOf(this.f5460l0) : ColorStateList.valueOf(this.U));
                this.L.p(ColorStateList.valueOf(this.U));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.e == null) {
            throw new IllegalStateException();
        }
        boolean z2 = getLayoutDirection() == 1;
        int i2 = rect.bottom;
        Rect rect2 = this.f5450a0;
        rect2.bottom = i2;
        int i8 = this.P;
        if (i8 == 1) {
            rect2.left = i(rect.left, z2);
            rect2.top = rect.top + this.Q;
            rect2.right = j(rect.right, z2);
            return rect2;
        }
        if (i8 != 2) {
            rect2.left = i(rect.left, z2);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z2);
            return rect2;
        }
        rect2.left = this.e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f5457f != null) {
            boolean z2 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f5457f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.e.setHint(hint);
                this.F = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        FrameLayout frameLayout = this.f5449a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i8 = 0; i8 < frameLayout.getChildCount(); i8++) {
            View childAt = frameLayout.getChildAt(i8);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i8);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i2);
            if (childAt == this.e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        k kVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z2 = this.D;
        c cVar = this.f5479w0;
        if (z2) {
            TextPaint textPaint = cVar.O;
            RectF rectF = cVar.e;
            int iSave = canvas2.save();
            if (cVar.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(cVar.G);
                float f4 = cVar.f13397q;
                float f8 = cVar.f13398r;
                float f9 = cVar.F;
                if (f9 != 1.0f) {
                    canvas2.scale(f9, f9, f4, f8);
                }
                if ((cVar.f13391e0 > 1 || cVar.f0 > 1) && !cVar.D && cVar.o()) {
                    float lineStart = cVar.f13397q - cVar.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f8);
                    float f10 = alpha;
                    textPaint.setAlpha((int) (cVar.f13389c0 * f10));
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 31) {
                        float f11 = cVar.H;
                        float f12 = cVar.I;
                        float f13 = cVar.J;
                        int i8 = cVar.K;
                        textPaint.setShadowLayer(f11, f12, f13, ColorUtils.setAlphaComponent(i8, (textPaint.getAlpha() * Color.alpha(i8)) / 255));
                    }
                    cVar.Z.draw(canvas2);
                    textPaint.setAlpha((int) (cVar.f13387b0 * f10));
                    if (i2 >= 31) {
                        float f14 = cVar.H;
                        float f15 = cVar.I;
                        float f16 = cVar.J;
                        int i9 = cVar.K;
                        textPaint.setShadowLayer(f14, f15, f16, ColorUtils.setAlphaComponent(i9, (Color.alpha(i9) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = cVar.Z.getLineBaseline(0);
                    CharSequence charSequence = cVar.d0;
                    float f17 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f17, textPaint);
                    if (i2 >= 31) {
                        textPaint.setShadowLayer(cVar.H, cVar.I, cVar.J, cVar.K);
                    }
                    String strTrim = cVar.d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(cVar.Z.getLineEnd(0), str.length()), 0.0f, f17, (Paint) textPaint);
                } else {
                    canvas2.translate(f4, f8);
                    cVar.Z.draw(canvas2);
                }
                canvas2.restoreToCount(iSave);
            }
        }
        if (this.L == null || (kVar = this.K) == null) {
            return;
        }
        kVar.draw(canvas2);
        if (this.e.isFocused()) {
            Rect bounds = this.L.getBounds();
            Rect bounds2 = this.K.getBounds();
            float f18 = cVar.f13386b;
            int iCenterX = bounds2.centerX();
            bounds.left = c1.a.c(iCenterX, bounds2.left, f18);
            bounds.right = c1.a.c(iCenterX, bounds2.right, f18);
            this.L.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.A0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.A0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            q1.c r3 = r4.f5479w0
            if (r3 == 0) goto L2f
            r3.M = r1
            android.content.res.ColorStateList r1 = r3.k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.j(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.e
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = r2
        L42:
            r4.w(r0, r2)
        L45:
            r4.t()
            r4.z()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.A0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.D) {
            int i2 = this.P;
            c cVar = this.f5479w0;
            if (i2 == 0) {
                return (int) cVar.f();
            }
            if (i2 == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (cVar.f() / 2.0f);
                }
                float f4 = cVar.f();
                TextPaint textPaint = cVar.P;
                textPaint.setTextSize(cVar.f13393i);
                textPaint.setTypeface(cVar.f13399s);
                textPaint.setLetterSpacing(cVar.W);
                return Math.max(0, (int) (f4 - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final Fade f() {
        Fade fade = new Fade();
        fade.setDuration(a.a.S(getContext(), com.cbt.exam.browser.R.attr.motionDurationShort2, 87));
        fade.setInterpolator(a.a.T(getContext(), com.cbt.exam.browser.R.attr.motionEasingLinearInterpolator, c1.a.f4168a));
        return fade;
    }

    public final boolean g() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof g);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public k getBoxBackground() {
        int i2 = this.P;
        if (i2 == 1 || i2 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5452b0;
        return layoutDirection == 1 ? this.M.h.a(rectF) : this.M.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5452b0;
        return layoutDirection == 1 ? this.M.g.a(rectF) : this.M.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5452b0;
        return layoutDirection == 1 ? this.M.e.a(rectF) : this.M.f17743f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5452b0;
        return layoutDirection == 1 ? this.M.f17743f.a(rectF) : this.M.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f5463n0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f5465o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.l && this.f5462n && (appCompatTextView = this.p) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f5483z;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.B;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f5459j0;
    }

    @Nullable
    public EditText getEditText() {
        return this.e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f5453c.g.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f5453c.g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f5453c.m;
    }

    public int getEndIconMode() {
        return this.f5453c.f17924i;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f5453c.f17925n;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f5453c.g;
    }

    @Nullable
    public CharSequence getError() {
        r rVar = this.k;
        if (rVar.f17950q) {
            return rVar.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.k.f17953t;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.k.f17952s;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.k.f17951r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f5453c.f17921c.getDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        r rVar = this.k;
        if (rVar.f17957x) {
            return rVar.f17956w;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.k.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.f5479w0.f();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        c cVar = this.f5479w0;
        return cVar.g(cVar.k);
    }

    public int getHintMaxLines() {
        return this.f5479w0.f13391e0;
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.k0;
    }

    @NonNull
    public z getLengthCounter() {
        return this.f5464o;
    }

    public int getMaxEms() {
        return this.h;
    }

    @Px
    public int getMaxWidth() {
        return this.j;
    }

    public int getMinEms() {
        return this.g;
    }

    @Px
    public int getMinWidth() {
        return this.f5458i;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f5453c.g.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f5453c.g.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f5473t) {
            return this.f5471s;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f5478w;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f5476v;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f5451b.f17971c;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f5451b.f17970b.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f5451b.f17970b;
    }

    @NonNull
    public o getShapeAppearanceModel() {
        return this.M;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f5451b.f17972d.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f5451b.f17972d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f5451b.g;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f5451b.h;
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f5453c.p;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f5453c.f17927q.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f5453c.f17927q;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f5454c0;
    }

    public final k h(boolean z2) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_shape_corner_size_small_component);
        float f4 = z2 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.e;
        float popupElevation = editText instanceof u ? ((u) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        m mVar = new m();
        m mVar2 = new m();
        m mVar3 = new m();
        m mVar4 = new m();
        int i2 = 0;
        f fVar = new f(i2);
        f fVar2 = new f(i2);
        f fVar3 = new f(i2);
        f fVar4 = new f(i2);
        w1.a aVar = new w1.a(f4);
        w1.a aVar2 = new w1.a(f4);
        w1.a aVar3 = new w1.a(dimensionPixelOffset);
        w1.a aVar4 = new w1.a(dimensionPixelOffset);
        o oVar = new o();
        oVar.f17739a = mVar;
        oVar.f17740b = mVar2;
        oVar.f17741c = mVar3;
        oVar.f17742d = mVar4;
        oVar.e = aVar;
        oVar.f17743f = aVar2;
        oVar.g = aVar4;
        oVar.h = aVar3;
        oVar.f17744i = fVar;
        oVar.j = fVar2;
        oVar.k = fVar3;
        oVar.l = fVar4;
        EditText editText2 = this.e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof u ? ((u) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = k.F;
            TypedValue typedValueC = t1.b.c(context, com.cbt.exam.browser.R.attr.colorSurface, k.class.getSimpleName());
            int i8 = typedValueC.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i8 != 0 ? ContextCompat.getColor(context, i8) : typedValueC.data);
        }
        k kVar = new k();
        kVar.l(context);
        kVar.p(dropDownBackgroundTintList);
        kVar.o(popupElevation);
        kVar.setShapeAppearanceModel(oVar);
        h hVar = kVar.f17716b;
        if (hVar.h == null) {
            hVar.h = new Rect();
        }
        kVar.f17716b.h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        kVar.invalidateSelf();
        return kVar;
    }

    public final int i(int i2, boolean z2) {
        return ((z2 || getPrefixText() == null) ? (!z2 || getSuffixText() == null) ? this.e.getCompoundPaddingLeft() : this.f5453c.c() : this.f5451b.a()) + i2;
    }

    public final int j(int i2, boolean z2) {
        return i2 - ((z2 || getSuffixText() == null) ? (!z2 || getPrefixText() == null) ? this.e.getCompoundPaddingRight() : this.f5451b.a() : this.f5453c.c());
    }

    public final void k() {
        int i2 = this.P;
        if (i2 == 0) {
            this.G = null;
            this.K = null;
            this.L = null;
        } else if (i2 == 1) {
            this.G = new k(this.M);
            this.K = new k();
            this.L = new k();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(a1.a.q(new StringBuilder(), " is illegal; only @BoxBackgroundMode constants are supported.", this.P));
            }
            if (!this.D || (this.G instanceof g)) {
                this.G = new k(this.M);
            } else {
                o oVar = this.M;
                int i8 = g.I;
                if (oVar == null) {
                    oVar = new o();
                }
                z1.f fVar = new z1.f(oVar, new RectF());
                g gVar = new g(fVar);
                gVar.H = fVar;
                this.G = gVar;
            }
            this.K = null;
            this.L = null;
        }
        u();
        z();
        if (this.P == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.Q = getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (t1.c.d(getContext())) {
                this.Q = getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.P != 0) {
            v();
        }
        EditText editText = this.e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i9 = this.P;
                if (i9 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i9 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public final void n(AppCompatTextView appCompatTextView, int i2) {
        try {
            TextViewCompat.setTextAppearance(appCompatTextView, i2);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.setTextAppearance(appCompatTextView, androidx.appcompat.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(ContextCompat.getColor(getContext(), com.cbt.exam.browser.R.color.design_error));
    }

    public final boolean o() {
        r rVar = this.k;
        return (rVar.f17949o != 1 || rVar.f17951r == null || TextUtils.isEmpty(rVar.p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5479w0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        n nVar = this.f5453c;
        nVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z2 = false;
        this.C0 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (iMax = Math.max(nVar.getMeasuredHeight(), this.f5451b.getMeasuredHeight()))) {
            this.e.setMinimumHeight(iMax);
            z2 = true;
        }
        boolean zS = s();
        if (z2 || zS) {
            this.e.post(new com.vungle.ads.internal.omsdk.a(this, 17));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        float fDescent;
        int i11;
        int compoundPaddingTop;
        super.onLayout(z2, i2, i8, i9, i10);
        EditText editText = this.e;
        if (editText != null) {
            Rect rect = this.W;
            d.a(this, editText, rect);
            k kVar = this.K;
            if (kVar != null) {
                int i12 = rect.bottom;
                kVar.setBounds(rect.left, i12 - this.S, rect.right, i12);
            }
            k kVar2 = this.L;
            if (kVar2 != null) {
                int i13 = rect.bottom;
                kVar2.setBounds(rect.left, i13 - this.T, rect.right, i13);
            }
            if (this.D) {
                float textSize = this.e.getTextSize();
                c cVar = this.f5479w0;
                float f4 = cVar.h;
                TextPaint textPaint = cVar.P;
                if (f4 != textSize) {
                    cVar.h = textSize;
                    cVar.j(false);
                }
                int gravity = this.e.getGravity();
                int i14 = (gravity & (-113)) | 48;
                if (cVar.g != i14) {
                    cVar.g = i14;
                    cVar.j(false);
                }
                if (cVar.f13392f != gravity) {
                    cVar.f13392f = gravity;
                    cVar.j(false);
                }
                Rect rectD = d(rect);
                int i15 = rectD.left;
                int i16 = rectD.top;
                int i17 = rectD.right;
                int i18 = rectD.bottom;
                Rect rect2 = cVar.f13390d;
                if (rect2.left != i15 || rect2.top != i16 || rect2.right != i17 || rect2.bottom != i18) {
                    rect2.set(i15, i16, i17, i18);
                    cVar.N = true;
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(cVar.h);
                    textPaint.setTypeface(cVar.f13402v);
                    textPaint.setLetterSpacing(cVar.X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(cVar.h);
                    textPaint.setTypeface(cVar.f13402v);
                    textPaint.setLetterSpacing(cVar.X);
                    fDescent = cVar.l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f5450a0;
                rect3.left = compoundPaddingLeft;
                if (this.P != 1 || this.e.getMinLines() > 1) {
                    if (this.P != 0 || getHintMaxLines() == 1) {
                        i11 = 0;
                    } else {
                        textPaint.setTextSize(cVar.h);
                        textPaint.setTypeface(cVar.f13402v);
                        textPaint.setLetterSpacing(cVar.X);
                        i11 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.e.getCompoundPaddingTop() + rect.top) - i11;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.P != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i19 = rect3.left;
                int i20 = rect3.top;
                int i21 = rect3.right;
                Rect rect4 = cVar.f13388c;
                if (rect4.left != i19 || rect4.top != i20 || rect4.right != i21 || rect4.bottom != compoundPaddingBottom || true != cVar.k0) {
                    rect4.set(i19, i20, i21, compoundPaddingBottom);
                    cVar.N = true;
                    cVar.k0 = true;
                }
                cVar.j(false);
                if (!g() || this.f5477v0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        float f4;
        EditText editText;
        super.onMeasure(i2, i8);
        boolean z2 = this.C0;
        n nVar = this.f5453c;
        if (!z2) {
            nVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        if (this.f5474u != null && (editText = this.e) != null) {
            this.f5474u.setGravity(editText.getGravity());
            this.f5474u.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        nVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.e.getMeasuredWidth() - this.e.getCompoundPaddingLeft()) - this.e.getCompoundPaddingRight();
        c cVar = this.f5479w0;
        TextPaint textPaint = cVar.P;
        textPaint.setTextSize(cVar.f13393i);
        textPaint.setTypeface(cVar.f13399s);
        textPaint.setLetterSpacing(cVar.W);
        float f8 = measuredWidth;
        cVar.i0 = cVar.e(cVar.f0, textPaint, cVar.B, (cVar.f13393i / cVar.h) * f8, cVar.D).getHeight();
        textPaint.setTextSize(cVar.h);
        textPaint.setTypeface(cVar.f13402v);
        textPaint.setLetterSpacing(cVar.X);
        cVar.f13394j0 = cVar.e(cVar.f13391e0, textPaint, cVar.B, f8, cVar.D).getHeight();
        EditText editText2 = this.e;
        Rect rect = this.W;
        d.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i9 = rectD.left;
        int i10 = rectD.top;
        int i11 = rectD.right;
        int i12 = rectD.bottom;
        Rect rect2 = cVar.f13390d;
        if (rect2.left != i9 || rect2.top != i10 || rect2.right != i11 || rect2.bottom != i12) {
            rect2.set(i9, i10, i11, i12);
            cVar.N = true;
        }
        v();
        a();
        if (this.e == null) {
            return;
        }
        int i13 = cVar.f13394j0;
        if (i13 != -1) {
            f4 = i13;
        } else {
            TextPaint textPaint2 = cVar.P;
            textPaint2.setTextSize(cVar.h);
            textPaint2.setTypeface(cVar.f13402v);
            textPaint2.setLetterSpacing(cVar.X);
            f4 = -textPaint2.ascent();
        }
        if (this.f5471s != null) {
            TextPaint textPaint3 = new TextPaint(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
            textPaint3.set(this.f5474u.getPaint());
            textPaint3.setTextSize(this.f5474u.getTextSize());
            textPaint3.setTypeface(this.f5474u.getTypeface());
            textPaint3.setLetterSpacing(this.f5474u.getLetterSpacing());
            q1.h hVar = new q1.h(this.f5471s, textPaint3, measuredWidth);
            hVar.k = getLayoutDirection() == 1;
            hVar.j = true;
            float lineSpacingExtra = this.f5474u.getLineSpacingExtra();
            float lineSpacingMultiplier = this.f5474u.getLineSpacingMultiplier();
            hVar.g = lineSpacingExtra;
            hVar.h = lineSpacingMultiplier;
            hVar.m = new j7.a(this, 10);
            f = (this.P == 1 ? cVar.f() + this.Q + this.f5455d : 0.0f) + hVar.a().getHeight();
        }
        float fMax = Math.max(f4, f);
        if (this.e.getMeasuredHeight() < fMax) {
            this.e.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a0 a0Var = (a0) parcelable;
        super.onRestoreInstanceState(a0Var.getSuperState());
        setError(a0Var.f17896a);
        if (a0Var.f17897b) {
            post(new a4.c(this, 23));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        boolean z2 = i2 == 1;
        if (z2 != this.N) {
            w1.d dVar = this.M.e;
            RectF rectF = this.f5452b0;
            float fA = dVar.a(rectF);
            float fA2 = this.M.f17743f.a(rectF);
            float fA3 = this.M.h.a(rectF);
            float fA4 = this.M.g.a(rectF);
            o oVar = this.M;
            n7.b bVar = oVar.f17739a;
            n7.b bVar2 = oVar.f17740b;
            n7.b bVar3 = oVar.f17742d;
            n7.b bVar4 = oVar.f17741c;
            f fVar = new f(0);
            f fVar2 = new f(0);
            f fVar3 = new f(0);
            f fVar4 = new f(0);
            w1.a aVar = new w1.a(fA2);
            w1.a aVar2 = new w1.a(fA);
            w1.a aVar3 = new w1.a(fA4);
            w1.a aVar4 = new w1.a(fA3);
            o oVar2 = new o();
            oVar2.f17739a = bVar2;
            oVar2.f17740b = bVar;
            oVar2.f17741c = bVar3;
            oVar2.f17742d = bVar4;
            oVar2.e = aVar;
            oVar2.f17743f = aVar2;
            oVar2.g = aVar4;
            oVar2.h = aVar3;
            oVar2.f17744i = fVar;
            oVar2.j = fVar2;
            oVar2.k = fVar3;
            oVar2.l = fVar4;
            this.N = z2;
            setShapeAppearanceModel(oVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a0 a0Var = new a0(super.onSaveInstanceState());
        if (o()) {
            a0Var.f17896a = getError();
        }
        n nVar = this.f5453c;
        a0Var.f17897b = nVar.f17924i != 0 && nVar.g.f5415a;
        return a0Var;
    }

    public final void p(Editable editable) {
        ((b) this.f5464o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z2 = this.f5462n;
        int i2 = this.m;
        if (i2 == -1) {
            this.p.setText(String.valueOf(length));
            this.p.setContentDescription(null);
            this.f5462n = false;
        } else {
            this.f5462n = length > i2;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.f5462n ? com.cbt.exam.browser.R.string.character_counter_overflowed_content_description : com.cbt.exam.browser.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.m)));
            if (z2 != this.f5462n) {
                q();
            }
            this.p.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(com.cbt.exam.browser.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m))));
        }
        if (this.e == null || z2 == this.f5462n) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.p;
        if (appCompatTextView != null) {
            n(appCompatTextView, this.f5462n ? this.f5467q : this.f5469r);
            if (!this.f5462n && (colorStateList2 = this.f5483z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.f5462n || (colorStateList = this.A) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r() {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.B
            if (r0 == 0) goto L5
            goto L25
        L5:
            android.content.Context r0 = r4.getContext()
            int r1 = androidx.appcompat.R.attr.colorControlActivated
            android.util.TypedValue r1 = t1.b.a(r0, r1)
            r2 = 0
            if (r1 != 0) goto L14
        L12:
            r0 = r2
            goto L25
        L14:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1d
            android.content.res.ColorStateList r0 = androidx.core.content.ContextCompat.getColorStateList(r0, r3)
            goto L25
        L1d:
            int r0 = r1.data
            if (r0 == 0) goto L12
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L25:
            android.widget.EditText r1 = r4.e
            if (r1 == 0) goto L54
            android.graphics.drawable.Drawable r1 = k7.a.e(r1)
            if (r1 != 0) goto L30
            goto L54
        L30:
            android.widget.EditText r1 = r4.e
            android.graphics.drawable.Drawable r1 = k7.a.e(r1)
            android.graphics.drawable.Drawable r1 = androidx.core.graphics.drawable.DrawableCompat.wrap(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L4c
            androidx.appcompat.widget.AppCompatTextView r2 = r4.p
            if (r2 == 0) goto L51
            boolean r2 = r4.f5462n
            if (r2 == 0) goto L51
        L4c:
            android.content.res.ColorStateList r2 = r4.C
            if (r2 == 0) goto L51
            r0 = r2
        L51:
            r1.setTintList(r0)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.r():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean s() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.V != i2) {
            this.V = i2;
            this.f5466p0 = i2;
            this.f5470r0 = i2;
            this.f5472s0 = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f5466p0 = defaultColor;
        this.V = defaultColor;
        this.f5468q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f5470r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f5472s0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.P) {
            return;
        }
        this.P = i2;
        if (this.e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i2) {
        this.Q = i2;
    }

    public void setBoxCornerFamily(int i2) {
        w1.n nVarF = this.M.f();
        w1.d dVar = this.M.e;
        nVarF.f17733a = q.L(i2);
        nVarF.e = dVar;
        w1.d dVar2 = this.M.f17743f;
        nVarF.f17734b = q.L(i2);
        nVarF.f17737f = dVar2;
        w1.d dVar3 = this.M.h;
        nVarF.f17736d = q.L(i2);
        nVarF.h = dVar3;
        w1.d dVar4 = this.M.g;
        nVarF.f17735c = q.L(i2);
        nVarF.g = dVar4;
        this.M = nVarF.a();
        c();
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.f5463n0 != i2) {
            this.f5463n0 = i2;
            z();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f5460l0 = colorStateList.getDefaultColor();
            this.t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f5461m0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f5463n0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f5463n0 != colorStateList.getDefaultColor()) {
            this.f5463n0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f5465o0 != colorStateList) {
            this.f5465o0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.S = i2;
        z();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.T = i2;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.l != z2) {
            r rVar = this.k;
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.p = appCompatTextView;
                appCompatTextView.setId(com.cbt.exam.browser.R.id.textinput_counter);
                Typeface typeface = this.f5454c0;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                rVar.a(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.p != null) {
                    EditText editText = this.e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                rVar.g(this.p, 2);
                this.p = null;
            }
            this.l = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.m != i2) {
            if (i2 > 0) {
                this.m = i2;
            } else {
                this.m = -1;
            }
            if (!this.l || this.p == null) {
                return;
            }
            EditText editText = this.e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.f5467q != i2) {
            this.f5467q = i2;
            q();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.f5469r != i2) {
            this.f5469r = i2;
            q();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f5483z != colorStateList) {
            this.f5483z = colorStateList;
            q();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            r();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (o() || (this.p != null && this.f5462n)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f5459j0 = colorStateList;
        this.k0 = colorStateList;
        if (this.e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        m(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f5453c.g.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f5453c.g.setCheckable(z2);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        n nVar = this.f5453c;
        CharSequence text = i2 != 0 ? nVar.getResources().getText(i2) : null;
        CheckableImageButton checkableImageButton = nVar.g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        n nVar = this.f5453c;
        Drawable drawable = i2 != 0 ? AppCompatResources.getDrawable(nVar.getContext(), i2) : null;
        TextInputLayout textInputLayout = nVar.f17919a;
        CheckableImageButton checkableImageButton = nVar.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            q.j(textInputLayout, checkableImageButton, nVar.k, nVar.l);
            q.n0(textInputLayout, checkableImageButton, nVar.k);
        }
    }

    public void setEndIconMinSize(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        n nVar = this.f5453c;
        if (i2 < 0) {
            nVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i2 != nVar.m) {
            nVar.m = i2;
            CheckableImageButton checkableImageButton = nVar.g;
            checkableImageButton.setMinimumWidth(i2);
            checkableImageButton.setMinimumHeight(i2);
            CheckableImageButton checkableImageButton2 = nVar.f17921c;
            checkableImageButton2.setMinimumWidth(i2);
            checkableImageButton2.setMinimumHeight(i2);
        }
    }

    public void setEndIconMode(int i2) {
        this.f5453c.g(i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        n nVar = this.f5453c;
        CheckableImageButton checkableImageButton = nVar.g;
        View.OnLongClickListener onLongClickListener = nVar.f17926o;
        checkableImageButton.setOnClickListener(onClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        n nVar = this.f5453c;
        nVar.f17926o = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        n nVar = this.f5453c;
        nVar.f17925n = scaleType;
        nVar.g.setScaleType(scaleType);
        nVar.f17921c.setScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f5453c;
        if (nVar.k != colorStateList) {
            nVar.k = colorStateList;
            q.j(nVar.f17919a, nVar.g, colorStateList, nVar.l);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f5453c;
        if (nVar.l != mode) {
            nVar.l = mode;
            q.j(nVar.f17919a, nVar.g, nVar.k, mode);
        }
    }

    public void setEndIconVisible(boolean z2) {
        this.f5453c.h(z2);
    }

    public void setError(@Nullable CharSequence charSequence) {
        r rVar = this.k;
        if (!rVar.f17950q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            rVar.f();
            return;
        }
        rVar.c();
        rVar.p = charSequence;
        rVar.f17951r.setText(charSequence);
        int i2 = rVar.f17948n;
        if (i2 != 1) {
            rVar.f17949o = 1;
        }
        rVar.i(i2, rVar.f17949o, rVar.h(rVar.f17951r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i2) {
        r rVar = this.k;
        rVar.f17953t = i2;
        AppCompatTextView appCompatTextView = rVar.f17951r;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i2);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        r rVar = this.k;
        rVar.f17952s = charSequence;
        AppCompatTextView appCompatTextView = rVar.f17951r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        r rVar = this.k;
        TextInputLayout textInputLayout = rVar.h;
        if (rVar.f17950q == z2) {
            return;
        }
        rVar.c();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(rVar.g);
            rVar.f17951r = appCompatTextView;
            appCompatTextView.setId(com.cbt.exam.browser.R.id.textinput_error);
            rVar.f17951r.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.f17951r.setTypeface(typeface);
            }
            int i2 = rVar.f17954u;
            rVar.f17954u = i2;
            AppCompatTextView appCompatTextView2 = rVar.f17951r;
            if (appCompatTextView2 != null) {
                rVar.h.n(appCompatTextView2, i2);
            }
            ColorStateList colorStateList = rVar.f17955v;
            rVar.f17955v = colorStateList;
            AppCompatTextView appCompatTextView3 = rVar.f17951r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = rVar.f17952s;
            rVar.f17952s = charSequence;
            AppCompatTextView appCompatTextView4 = rVar.f17951r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i8 = rVar.f17953t;
            rVar.f17953t = i8;
            AppCompatTextView appCompatTextView5 = rVar.f17951r;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setAccessibilityLiveRegion(i8);
            }
            rVar.f17951r.setVisibility(4);
            rVar.a(rVar.f17951r, 0);
        } else {
            rVar.f();
            rVar.g(rVar.f17951r, 0);
            rVar.f17951r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f17950q = z2;
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        n nVar = this.f5453c;
        nVar.i(i2 != 0 ? AppCompatResources.getDrawable(nVar.getContext(), i2) : null);
        q.n0(nVar.f17919a, nVar.f17921c, nVar.f17922d);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        n nVar = this.f5453c;
        CheckableImageButton checkableImageButton = nVar.f17921c;
        View.OnLongClickListener onLongClickListener = nVar.f17923f;
        checkableImageButton.setOnClickListener(onClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        n nVar = this.f5453c;
        nVar.f17923f = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f17921c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f5453c;
        if (nVar.f17922d != colorStateList) {
            nVar.f17922d = colorStateList;
            q.j(nVar.f17919a, nVar.f17921c, colorStateList, nVar.e);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f5453c;
        if (nVar.e != mode) {
            nVar.e = mode;
            q.j(nVar.f17919a, nVar.f17921c, nVar.f17922d, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        r rVar = this.k;
        rVar.f17954u = i2;
        AppCompatTextView appCompatTextView = rVar.f17951r;
        if (appCompatTextView != null) {
            rVar.h.n(appCompatTextView, i2);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        r rVar = this.k;
        rVar.f17955v = colorStateList;
        AppCompatTextView appCompatTextView = rVar.f17951r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.f5481x0 != z2) {
            this.f5481x0 = z2;
            w(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        r rVar = this.k;
        if (zIsEmpty) {
            if (rVar.f17957x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!rVar.f17957x) {
            setHelperTextEnabled(true);
        }
        rVar.c();
        rVar.f17956w = charSequence;
        rVar.y.setText(charSequence);
        int i2 = rVar.f17948n;
        if (i2 != 2) {
            rVar.f17949o = 2;
        }
        rVar.i(i2, rVar.f17949o, rVar.h(rVar.y, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        r rVar = this.k;
        rVar.A = colorStateList;
        AppCompatTextView appCompatTextView = rVar.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        r rVar = this.k;
        TextInputLayout textInputLayout = rVar.h;
        if (rVar.f17957x == z2) {
            return;
        }
        rVar.c();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(rVar.g);
            rVar.y = appCompatTextView;
            appCompatTextView.setId(com.cbt.exam.browser.R.id.textinput_helper_text);
            rVar.y.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.y.setTypeface(typeface);
            }
            rVar.y.setVisibility(4);
            rVar.y.setAccessibilityLiveRegion(1);
            int i2 = rVar.f17958z;
            rVar.f17958z = i2;
            AppCompatTextView appCompatTextView2 = rVar.y;
            if (appCompatTextView2 != null) {
                TextViewCompat.setTextAppearance(appCompatTextView2, i2);
            }
            ColorStateList colorStateList = rVar.A;
            rVar.A = colorStateList;
            AppCompatTextView appCompatTextView3 = rVar.y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            rVar.a(rVar.y, 1);
            rVar.y.setAccessibilityDelegate(new z1.q(rVar));
        } else {
            rVar.c();
            int i8 = rVar.f17948n;
            if (i8 == 2) {
                rVar.f17949o = 0;
            }
            rVar.i(i8, rVar.f17949o, rVar.h(rVar.y, ""));
            rVar.g(rVar.y, 1);
            rVar.y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f17957x = z2;
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        r rVar = this.k;
        rVar.f17958z = i2;
        AppCompatTextView appCompatTextView = rVar.y;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i2);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.f5482y0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.D) {
            this.D = z2;
            if (z2) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i2) {
        c cVar = this.f5479w0;
        if (i2 != cVar.f0) {
            cVar.f0 = i2;
            cVar.j(false);
        }
        if (i2 != cVar.f13391e0) {
            cVar.f13391e0 = i2;
            cVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        c cVar = this.f5479w0;
        TextInputLayout textInputLayout = cVar.f13384a;
        t1.f fVar = new t1.f(textInputLayout.getContext(), i2);
        ColorStateList colorStateList = fVar.k;
        if (colorStateList != null) {
            cVar.k = colorStateList;
        }
        float f4 = fVar.l;
        if (f4 != 0.0f) {
            cVar.f13393i = f4;
        }
        ColorStateList colorStateList2 = fVar.f17392a;
        if (colorStateList2 != null) {
            cVar.V = colorStateList2;
        }
        cVar.T = fVar.f17396f;
        cVar.U = fVar.g;
        cVar.S = fVar.h;
        cVar.W = fVar.j;
        t1.a aVar = cVar.f13405z;
        if (aVar != null) {
            aVar.f17385c = true;
        }
        a4.a aVar2 = new a4.a(cVar, 24);
        fVar.a();
        cVar.f13405z = new t1.a(aVar2, fVar.p);
        fVar.b(textInputLayout.getContext(), cVar.f13405z);
        cVar.j(false);
        this.k0 = cVar.k;
        if (this.e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            if (this.f5459j0 == null) {
                c cVar = this.f5479w0;
                if (cVar.k != colorStateList) {
                    cVar.k = colorStateList;
                    cVar.j(false);
                }
            }
            this.k0 = colorStateList;
            if (this.e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(@NonNull z zVar) {
        this.f5464o = zVar;
    }

    public void setMaxEms(int i2) {
        this.h = i2;
        EditText editText = this.e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxEms(i2);
    }

    public void setMaxWidth(@Px int i2) {
        this.j = i2;
        EditText editText = this.e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxWidth(i2);
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinEms(int i2) {
        this.g = i2;
        EditText editText = this.e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinEms(i2);
    }

    public void setMinWidth(@Px int i2) {
        this.f5458i = i2;
        EditText editText = this.e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinWidth(i2);
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        n nVar = this.f5453c;
        nVar.g.setContentDescription(i2 != 0 ? nVar.getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        n nVar = this.f5453c;
        nVar.g.setImageDrawable(i2 != 0 ? AppCompatResources.getDrawable(nVar.getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        n nVar = this.f5453c;
        if (z2 && nVar.f17924i != 1) {
            nVar.g(1);
        } else if (z2) {
            nVar.getClass();
        } else {
            nVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f5453c;
        nVar.k = colorStateList;
        q.j(nVar.f17919a, nVar.g, colorStateList, nVar.l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f5453c;
        nVar.l = mode;
        q.j(nVar.f17919a, nVar.g, nVar.k, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f5474u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f5474u = appCompatTextView;
            appCompatTextView.setId(com.cbt.exam.browser.R.id.textinput_placeholder);
            this.f5474u.setImportantForAccessibility(1);
            this.f5474u.setAccessibilityLiveRegion(1);
            Fade fadeF = f();
            this.f5480x = fadeF;
            fadeF.setStartDelay(67L);
            this.y = f();
            setPlaceholderTextAppearance(this.f5478w);
            setPlaceholderTextColor(this.f5476v);
            ViewCompat.setAccessibilityDelegate(this.f5474u, new com.google.android.material.datepicker.g(3));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f5473t) {
                setPlaceholderTextEnabled(true);
            }
            this.f5471s = charSequence;
        }
        EditText editText = this.e;
        x(editText == null ? null : editText.getText());
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.f5478w = i2;
        AppCompatTextView appCompatTextView = this.f5474u;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f5476v != colorStateList) {
            this.f5476v = colorStateList;
            AppCompatTextView appCompatTextView = this.f5474u;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        w wVar = this.f5451b;
        wVar.getClass();
        wVar.f17971c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        wVar.f17970b.setText(charSequence);
        wVar.e();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f5451b.f17970b, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f5451b.f17970b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull o oVar) {
        k kVar = this.G;
        if (kVar == null || kVar.f17716b.f17705a == oVar) {
            return;
        }
        this.M = oVar;
        c();
    }

    public void setStartIconCheckable(boolean z2) {
        this.f5451b.f17972d.setCheckable(z2);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconMinSize(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        w wVar = this.f5451b;
        if (i2 < 0) {
            wVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i2 != wVar.g) {
            wVar.g = i2;
            CheckableImageButton checkableImageButton = wVar.f17972d;
            checkableImageButton.setMinimumWidth(i2);
            checkableImageButton.setMinimumHeight(i2);
        }
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        w wVar = this.f5451b;
        CheckableImageButton checkableImageButton = wVar.f17972d;
        View.OnLongClickListener onLongClickListener = wVar.f17974i;
        checkableImageButton.setOnClickListener(onClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        w wVar = this.f5451b;
        wVar.f17974i = onLongClickListener;
        CheckableImageButton checkableImageButton = wVar.f17972d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q.t0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        w wVar = this.f5451b;
        wVar.h = scaleType;
        wVar.f17972d.setScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f5451b;
        if (wVar.e != colorStateList) {
            wVar.e = colorStateList;
            q.j(wVar.f17969a, wVar.f17972d, colorStateList, wVar.f17973f);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f5451b;
        if (wVar.f17973f != mode) {
            wVar.f17973f = mode;
            q.j(wVar.f17969a, wVar.f17972d, wVar.e, mode);
        }
    }

    public void setStartIconVisible(boolean z2) {
        this.f5451b.c(z2);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        n nVar = this.f5453c;
        nVar.getClass();
        nVar.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        nVar.f17927q.setText(charSequence);
        nVar.n();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f5453c.f17927q, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f5453c.f17927q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable y yVar) {
        EditText editText = this.e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, yVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f5454c0) {
            this.f5454c0 = typeface;
            this.f5479w0.n(typeface);
            r rVar = this.k;
            if (typeface != rVar.B) {
                rVar.B = typeface;
                AppCompatTextView appCompatTextView = rVar.f17951r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = rVar.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.p;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.e;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (o()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f5462n && (appCompatTextView = this.p) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.e.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.e;
        if (editText == null || this.G == null) {
            return;
        }
        if ((this.J || editText.getBackground() == null) && this.P != 0) {
            this.e.setBackground(getEditTextBoxBackground());
            this.J = true;
        }
    }

    public final void v() {
        if (this.P != 1) {
            FrameLayout frameLayout = this.f5449a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z2, boolean z7) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.e;
        boolean z8 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z9 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f5459j0;
        c cVar = this.f5479w0;
        if (colorStateList2 != null) {
            cVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f5459j0;
            cVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.t0) : this.t0));
        } else if (o()) {
            AppCompatTextView appCompatTextView2 = this.k.f17951r;
            cVar.k(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f5462n && (appCompatTextView = this.p) != null) {
            cVar.k(appCompatTextView.getTextColors());
        } else if (z9 && (colorStateList = this.k0) != null && cVar.k != colorStateList) {
            cVar.k = colorStateList;
            cVar.j(false);
        }
        n nVar = this.f5453c;
        w wVar = this.f5451b;
        if (z8 || !this.f5481x0 || (isEnabled() && z9)) {
            if (z7 || this.f5477v0) {
                ValueAnimator valueAnimator = this.f5484z0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f5484z0.cancel();
                }
                if (z2 && this.f5482y0) {
                    b(1.0f);
                } else {
                    cVar.m(1.0f);
                }
                this.f5477v0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.e;
                x(editText3 != null ? editText3.getText() : null);
                wVar.j = false;
                wVar.e();
                nVar.f17928r = false;
                nVar.n();
                return;
            }
            return;
        }
        if (z7 || !this.f5477v0) {
            ValueAnimator valueAnimator2 = this.f5484z0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f5484z0.cancel();
            }
            if (z2 && this.f5482y0) {
                b(0.0f);
            } else {
                cVar.m(0.0f);
            }
            if (g() && !((g) this.G).H.f17904r.isEmpty() && g()) {
                ((g) this.G).x(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f5477v0 = true;
            AppCompatTextView appCompatTextView3 = this.f5474u;
            if (appCompatTextView3 != null && this.f5473t) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(this.f5449a, this.y);
                this.f5474u.setVisibility(4);
            }
            wVar.j = true;
            wVar.e();
            nVar.f17928r = true;
            nVar.n();
        }
    }

    public final void x(Editable editable) {
        ((b) this.f5464o).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f5449a;
        if (length != 0 || this.f5477v0) {
            AppCompatTextView appCompatTextView = this.f5474u;
            if (appCompatTextView == null || !this.f5473t) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(frameLayout, this.y);
            this.f5474u.setVisibility(4);
            return;
        }
        if (this.f5474u == null || !this.f5473t || TextUtils.isEmpty(this.f5471s)) {
            return;
        }
        this.f5474u.setText(this.f5471s);
        TransitionManager.beginDelayedTransition(frameLayout, this.f5480x);
        this.f5474u.setVisibility(0);
        this.f5474u.bringToFront();
    }

    public final void y(boolean z2, boolean z7) {
        int defaultColor = this.f5465o0.getDefaultColor();
        int colorForState = this.f5465o0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f5465o0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.U = colorForState2;
        } else if (z7) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    public final void z() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.P == 0) {
            return;
        }
        boolean z2 = false;
        boolean z7 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z2 = true;
        }
        if (!isEnabled()) {
            this.U = this.t0;
        } else if (o()) {
            if (this.f5465o0 != null) {
                y(z7, z2);
            } else {
                this.U = getErrorCurrentTextColors();
            }
        } else if (!this.f5462n || (appCompatTextView = this.p) == null) {
            if (z7) {
                this.U = this.f5463n0;
            } else if (z2) {
                this.U = this.f5461m0;
            } else {
                this.U = this.f5460l0;
            }
        } else if (this.f5465o0 != null) {
            y(z7, z2);
        } else {
            this.U = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        n nVar = this.f5453c;
        TextInputLayout textInputLayout = nVar.f17919a;
        CheckableImageButton checkableImageButton = nVar.g;
        TextInputLayout textInputLayout2 = nVar.f17919a;
        nVar.l();
        q.n0(textInputLayout2, nVar.f17921c, nVar.f17922d);
        q.n0(textInputLayout2, checkableImageButton, nVar.k);
        if (nVar.b() instanceof j) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                q.j(textInputLayout, checkableImageButton, nVar.k, nVar.l);
            } else {
                Drawable drawableMutate = DrawableCompat.wrap(checkableImageButton.getDrawable()).mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        w wVar = this.f5451b;
        q.n0(wVar.f17969a, wVar.f17972d, wVar.e);
        if (this.P == 2) {
            int i2 = this.R;
            if (z7 && isEnabled()) {
                this.R = this.T;
            } else {
                this.R = this.S;
            }
            if (this.R != i2 && g() && !this.f5477v0) {
                if (g()) {
                    ((g) this.G).x(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.P == 1) {
            if (!isEnabled()) {
                this.V = this.f5468q0;
            } else if (z2 && !z7) {
                this.V = this.f5472s0;
            } else if (z7) {
                this.V = this.f5470r0;
            } else {
                this.V = this.f5466p0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f5451b.f17972d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f5451b.b(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f5453c.g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f5453c.g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f5453c.i(drawable);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f5453c.g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        n nVar = this.f5453c;
        TextInputLayout textInputLayout = nVar.f17919a;
        CheckableImageButton checkableImageButton = nVar.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            q.j(textInputLayout, checkableImageButton, nVar.k, nVar.l);
            q.n0(textInputLayout, checkableImageButton, nVar.k);
        }
    }
}
