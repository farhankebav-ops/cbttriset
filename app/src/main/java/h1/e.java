package h1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.dynamicanimation.animation.SpringForce;
import com.cbt.exam.browser.R;
import com.google.android.material.button.MaterialButton;
import w1.c0;
import w1.h;
import w1.i;
import w1.k;
import w1.o;
import w1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f11666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f11667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f11668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpringForce f11669d;
    public i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11670f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11671i;
    public int j;
    public int k;
    public PorterDuff.Mode l;
    public ColorStateList m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f11672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f11673o;
    public k p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11677t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RippleDrawable f11679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11680w;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11674q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11675r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11676s = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11678u = true;

    public e(MaterialButton materialButton, o oVar) {
        this.f11666a = materialButton;
        this.f11667b = oVar;
    }

    public final k a(boolean z2) {
        RippleDrawable rippleDrawable = this.f11679v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (k) ((LayerDrawable) ((InsetDrawable) this.f11679v.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0);
    }

    public final void b(int i2, int i8) {
        MaterialButton materialButton = this.f11666a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i9 = this.h;
        int i10 = this.f11671i;
        this.f11671i = i8;
        this.h = i2;
        if (!this.f11675r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i2) - i9, paddingEnd, (paddingBottom + i8) - i10);
    }

    public final void c() {
        k kVar = new k(this.f11667b);
        c0 c0Var = this.f11668c;
        if (c0Var != null) {
            kVar.s(c0Var);
        }
        SpringForce springForce = this.f11669d;
        if (springForce != null) {
            kVar.n(springForce);
        }
        i iVar = this.e;
        if (iVar != null) {
            kVar.E = iVar;
        }
        MaterialButton materialButton = this.f11666a;
        kVar.l(materialButton.getContext());
        kVar.setTintList(this.m);
        PorterDuff.Mode mode = this.l;
        if (mode != null) {
            kVar.setTintMode(mode);
        }
        float f4 = this.k;
        ColorStateList colorStateList = this.f11672n;
        kVar.f17716b.k = f4;
        kVar.invalidateSelf();
        h hVar = kVar.f17716b;
        if (hVar.e != colorStateList) {
            hVar.e = colorStateList;
            kVar.onStateChange(kVar.getState());
        }
        k kVar2 = new k(this.f11667b);
        c0 c0Var2 = this.f11668c;
        if (c0Var2 != null) {
            kVar2.s(c0Var2);
        }
        SpringForce springForce2 = this.f11669d;
        if (springForce2 != null) {
            kVar2.n(springForce2);
        }
        kVar2.setTint(0);
        float f8 = this.k;
        int iB = this.f11674q ? m1.a.b(materialButton, R.attr.colorSurface) : 0;
        kVar2.f17716b.k = f8;
        kVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iB);
        h hVar2 = kVar2.f17716b;
        if (hVar2.e != colorStateListValueOf) {
            hVar2.e = colorStateListValueOf;
            kVar2.onStateChange(kVar2.getState());
        }
        k kVar3 = new k(this.f11667b);
        this.p = kVar3;
        c0 c0Var3 = this.f11668c;
        if (c0Var3 != null) {
            kVar3.s(c0Var3);
        }
        SpringForce springForce3 = this.f11669d;
        if (springForce3 != null) {
            this.p.n(springForce3);
        }
        this.p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(u1.a.a(this.f11673o), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{kVar2, kVar}), this.f11670f, this.h, this.g, this.f11671i), this.p);
        this.f11679v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        k kVarA = a(false);
        if (kVarA != null) {
            kVarA.o(this.f11680w);
            kVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        k kVarA = a(false);
        if (kVarA != null) {
            c0 c0Var = this.f11668c;
            if (c0Var != null) {
                kVarA.s(c0Var);
            } else {
                kVarA.setShapeAppearanceModel(this.f11667b);
            }
            SpringForce springForce = this.f11669d;
            if (springForce != null) {
                kVarA.n(springForce);
            }
        }
        k kVarA2 = a(true);
        if (kVarA2 != null) {
            c0 c0Var2 = this.f11668c;
            if (c0Var2 != null) {
                kVarA2.s(c0Var2);
            } else {
                kVarA2.setShapeAppearanceModel(this.f11667b);
            }
            SpringForce springForce2 = this.f11669d;
            if (springForce2 != null) {
                kVarA2.n(springForce2);
            }
        }
        RippleDrawable rippleDrawable = this.f11679v;
        z zVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f11679v.getNumberOfLayers() > 2 ? (z) this.f11679v.getDrawable(2) : (z) this.f11679v.getDrawable(1);
        if (zVar != null) {
            zVar.setShapeAppearanceModel(this.f11667b);
            if (zVar instanceof k) {
                k kVar = (k) zVar;
                c0 c0Var3 = this.f11668c;
                if (c0Var3 != null) {
                    kVar.s(c0Var3);
                }
                SpringForce springForce3 = this.f11669d;
                if (springForce3 != null) {
                    kVar.n(springForce3);
                }
            }
        }
    }

    public final void e() {
        k kVarA = a(false);
        k kVarA2 = a(true);
        if (kVarA != null) {
            float f4 = this.k;
            ColorStateList colorStateList = this.f11672n;
            kVarA.f17716b.k = f4;
            kVarA.invalidateSelf();
            h hVar = kVarA.f17716b;
            if (hVar.e != colorStateList) {
                hVar.e = colorStateList;
                kVarA.onStateChange(kVarA.getState());
            }
            if (kVarA2 != null) {
                float f8 = this.k;
                int iB = this.f11674q ? m1.a.b(this.f11666a, R.attr.colorSurface) : 0;
                kVarA2.f17716b.k = f8;
                kVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iB);
                h hVar2 = kVarA2.f17716b;
                if (hVar2.e != colorStateListValueOf) {
                    hVar2.e = colorStateListValueOf;
                    kVarA2.onStateChange(kVarA2.getState());
                }
            }
        }
    }
}
