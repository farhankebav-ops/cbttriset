package z1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import com.cbt.exam.browser.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f17919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f17920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f17921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f17922d;
    public PorterDuff.Mode e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f17923f;
    public final CheckableImageButton g;
    public final m h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17924i;
    public final LinkedHashSet j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f17925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f17926o;
    public CharSequence p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f17927q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17928r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EditText f17929s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f17930t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f17931u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f17932v;

    public n(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f17924i = 0;
        this.j = new LinkedHashSet();
        this.f17932v = new k(this);
        l lVar = new l(this);
        this.f17930t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f17919a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f17920b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f17921c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.g = checkableImageButtonA2;
        this.h = new m(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f17927q = appCompatTextView;
        if (tintTypedArray.hasValue(38)) {
            this.f17922d = t1.c.b(getContext(), tintTypedArray, 38);
        }
        if (tintTypedArray.hasValue(39)) {
            this.e = q1.p.a(tintTypedArray.getInt(39, -1), null);
        }
        if (tintTypedArray.hasValue(37)) {
            i(tintTypedArray.getDrawable(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!tintTypedArray.hasValue(54)) {
            if (tintTypedArray.hasValue(32)) {
                this.k = t1.c.b(getContext(), tintTypedArray, 32);
            }
            if (tintTypedArray.hasValue(33)) {
                this.l = q1.p.a(tintTypedArray.getInt(33, -1), null);
            }
        }
        if (tintTypedArray.hasValue(30)) {
            g(tintTypedArray.getInt(30, 0));
            if (tintTypedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = tintTypedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(tintTypedArray.getBoolean(26, true));
        } else if (tintTypedArray.hasValue(54)) {
            if (tintTypedArray.hasValue(55)) {
                this.k = t1.c.b(getContext(), tintTypedArray, 55);
            }
            if (tintTypedArray.hasValue(56)) {
                this.l = q1.p.a(tintTypedArray.getInt(56, -1), null);
            }
            g(tintTypedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = tintTypedArray.getText(52);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.m) {
            this.m = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (tintTypedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeK = r2.q.K(tintTypedArray.getInt(31, -1));
            this.f17925n = scaleTypeK;
            checkableImageButtonA2.setScaleType(scaleTypeK);
            checkableImageButtonA.setScaleType(scaleTypeK);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        TextViewCompat.setTextAppearance(appCompatTextView, tintTypedArray.getResourceId(73, 0));
        if (tintTypedArray.hasValue(74)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(74));
        }
        CharSequence text3 = tintTypedArray.getText(72);
        this.p = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f0.add(lVar);
        if (textInputLayout.e != null) {
            lVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new e1.b(this, 2));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i2) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i2);
        if (t1.c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final o b() {
        o eVar;
        int i2 = this.f17924i;
        m mVar = this.h;
        SparseArray sparseArray = mVar.f17915a;
        o oVar = (o) sparseArray.get(i2);
        if (oVar != null) {
            return oVar;
        }
        n nVar = mVar.f17916b;
        if (i2 == -1) {
            eVar = new e(nVar, 0);
        } else if (i2 == 0) {
            eVar = new e(nVar, 1);
        } else if (i2 == 1) {
            eVar = new v(nVar, mVar.f17918d);
        } else if (i2 == 2) {
            eVar = new d(nVar);
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(a1.a.g(i2, "Invalid end icon mode: "));
            }
            eVar = new j(nVar);
        }
        sparseArray.append(i2, eVar);
        return eVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f17927q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f17920b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f17921c.getVisibility() == 0;
    }

    public final void f(boolean z2) {
        boolean z7;
        boolean zIsActivated;
        boolean z8;
        o oVarB = b();
        boolean zJ = oVarB.j();
        CheckableImageButton checkableImageButton = this.g;
        boolean z9 = true;
        if (!zJ || (z8 = checkableImageButton.f5415a) == oVarB.k()) {
            z7 = false;
        } else {
            checkableImageButton.setChecked(!z8);
            z7 = true;
        }
        if (!(oVarB instanceof j) || (zIsActivated = checkableImageButton.isActivated()) == ((j) oVarB).l) {
            z9 = z7;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z2 || z9) {
            r2.q.n0(this.f17919a, checkableImageButton, this.k);
        }
    }

    public final void g(int i2) {
        if (this.f17924i == i2) {
            return;
        }
        o oVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f17931u;
        AccessibilityManager accessibilityManager = this.f17930t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.f17931u = null;
        oVarB.r();
        this.f17924i = i2;
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        h(i2 != 0);
        o oVarB2 = b();
        int iD = this.h.f17917c;
        if (iD == 0) {
            iD = oVarB2.d();
        }
        Drawable drawable = iD != 0 ? AppCompatResources.getDrawable(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.g;
        checkableImageButton.setImageDrawable(drawable);
        TextInputLayout textInputLayout = this.f17919a;
        if (drawable != null) {
            r2.q.j(textInputLayout, checkableImageButton, this.k, this.l);
            r2.q.n0(textInputLayout, checkableImageButton, this.k);
        }
        int iC = oVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(oVarB2.j());
        if (!oVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i2);
        }
        oVarB2.q();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = oVarB2.h();
        this.f17931u = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.f17931u);
        }
        View.OnClickListener onClickListenerF = oVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f17926o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        r2.q.t0(checkableImageButton, onLongClickListener);
        EditText editText = this.f17929s;
        if (editText != null) {
            oVarB2.l(editText);
            j(oVarB2);
        }
        r2.q.j(textInputLayout, checkableImageButton, this.k, this.l);
        f(true);
    }

    public final void h(boolean z2) {
        if (d() != z2) {
            this.g.setVisibility(z2 ? 0 : 8);
            k();
            m();
            this.f17919a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f17921c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        r2.q.j(this.f17919a, checkableImageButton, this.f17922d, this.e);
    }

    public final void j(o oVar) {
        if (this.f17929s == null) {
            return;
        }
        if (oVar.e() != null) {
            this.f17929s.setOnFocusChangeListener(oVar.e());
        }
        if (oVar.g() != null) {
            this.g.setOnFocusChangeListener(oVar.g());
        }
    }

    public final void k() {
        this.f17920b.setVisibility((this.g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.p == null || this.f17928r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f17921c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f17919a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.k.f17950q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.f17924i != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f17919a;
        if (textInputLayout.e == null) {
            return;
        }
        this.f17927q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.e.getPaddingEnd(), textInputLayout.e.getPaddingBottom());
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.f17927q;
        int visibility = appCompatTextView.getVisibility();
        int i2 = (this.p == null || this.f17928r) ? 8 : 0;
        if (visibility != i2) {
            b().o(i2 == 0);
        }
        k();
        appCompatTextView.setVisibility(i2);
        this.f17919a.s();
    }
}
