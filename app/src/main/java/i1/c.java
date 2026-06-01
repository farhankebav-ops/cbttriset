package i1;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import com.cbt.exam.browser.R;
import com.google.android.material.card.MaterialCardView;
import com.google.mlkit.common.MlKitException;
import w1.e;
import w1.k;
import w1.m;
import w1.n;
import w1.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final double y = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ColorDrawable f11792z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f11793a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f11795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f11796d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11797f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f11798i;
    public Drawable j;
    public ColorStateList k;
    public ColorStateList l;
    public o m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f11799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RippleDrawable f11800o;
    public LayerDrawable p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f11801q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f11804t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f11805u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11806v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11807w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f11794b = new Rect();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11802r = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f11808x = 0.0f;

    static {
        f11792z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public c(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.f11793a = materialCardView;
        k kVar = new k(materialCardView.getContext(), attributeSet, R.attr.materialCardViewStyle, R.style.Widget_MaterialComponents_CardView);
        this.f11795c = kVar;
        kVar.l(materialCardView.getContext());
        kVar.r();
        n nVarF = kVar.f17716b.f17705a.f();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, R.attr.materialCardViewStyle, androidx.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R.styleable.CardView_cardCornerRadius)) {
            float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
            nVarF.e = new w1.a(dimension);
            nVarF.f17737f = new w1.a(dimension);
            nVarF.g = new w1.a(dimension);
            nVarF.h = new w1.a(dimension);
        }
        this.f11796d = new k();
        h(nVarF.a());
        this.f11805u = a.a.T(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, c1.a.f4168a);
        this.f11806v = a.a.S(materialCardView.getContext(), R.attr.motionDurationShort2, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
        this.f11807w = a.a.S(materialCardView.getContext(), R.attr.motionDurationShort1, MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(n7.b bVar, float f4) {
        if (bVar instanceof m) {
            return (float) ((1.0d - y) * ((double) f4));
        }
        if (bVar instanceof e) {
            return f4 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        n7.b bVar = this.m.f17739a;
        k kVar = this.f11795c;
        float fB = b(bVar, kVar.j());
        n7.b bVar2 = this.m.f17740b;
        float[] fArr = kVar.C;
        float fMax = Math.max(fB, b(bVar2, fArr != null ? fArr[0] : kVar.f17716b.f17705a.f17743f.a(kVar.g())));
        n7.b bVar3 = this.m.f17741c;
        float[] fArr2 = kVar.C;
        float fB2 = b(bVar3, fArr2 != null ? fArr2[1] : kVar.f17716b.f17705a.g.a(kVar.g()));
        n7.b bVar4 = this.m.f17742d;
        float[] fArr3 = kVar.C;
        return Math.max(fMax, Math.max(fB2, b(bVar4, fArr3 != null ? fArr3[2] : kVar.f17716b.f17705a.h.a(kVar.g()))));
    }

    public final LayerDrawable c() {
        if (this.f11800o == null) {
            this.f11801q = new k(this.m);
            this.f11800o = new RippleDrawable(this.k, null, this.f11801q);
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f11800o, this.f11796d, this.j});
            this.p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.p;
    }

    public final b d(Drawable drawable) {
        int iCeil;
        int i2;
        if (this.f11793a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i2 = iCeil2;
        } else {
            iCeil = 0;
            i2 = 0;
        }
        return new b(drawable, iCeil, i2, iCeil, i2);
    }

    public final void e(int i2, int i8) {
        int iCeil;
        int iCeil2;
        int i9;
        int i10;
        if (this.p != null) {
            MaterialCardView materialCardView = this.f11793a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i11 = this.g;
            int i12 = (i11 & GravityCompat.END) == 8388613 ? ((i2 - this.e) - this.f11797f) - iCeil2 : this.e;
            int i13 = (i11 & 80) == 80 ? this.e : ((i8 - this.e) - this.f11797f) - iCeil;
            int i14 = (i11 & GravityCompat.END) == 8388613 ? this.e : ((i2 - this.e) - this.f11797f) - iCeil2;
            int i15 = (i11 & 80) == 80 ? ((i8 - this.e) - this.f11797f) - iCeil : this.e;
            if (materialCardView.getLayoutDirection() == 1) {
                i10 = i14;
                i9 = i12;
            } else {
                i9 = i14;
                i10 = i12;
            }
            this.p.setLayerInset(2, i10, i15, i9, i13);
        }
    }

    public final void f(boolean z2, boolean z7) {
        Drawable drawable = this.j;
        if (drawable != null) {
            if (!z7) {
                drawable.setAlpha(z2 ? 255 : 0);
                this.f11808x = z2 ? 1.0f : 0.0f;
                return;
            }
            float f4 = z2 ? 1.0f : 0.0f;
            float f8 = z2 ? 1.0f - this.f11808x : this.f11808x;
            ValueAnimator valueAnimator = this.f11804t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f11804t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f11808x, f4);
            this.f11804t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new com.onesignal.inAppMessages.internal.display.impl.a(this, 1));
            this.f11804t.setInterpolator(this.f11805u);
            this.f11804t.setDuration((long) ((z2 ? this.f11806v : this.f11807w) * f8));
            this.f11804t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.j = drawableMutate;
            drawableMutate.setTintList(this.l);
            f(this.f11793a.f5315c, false);
        } else {
            this.j = f11792z;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.j);
        }
    }

    public final void h(o oVar) {
        this.m = oVar;
        k kVar = this.f11795c;
        kVar.setShapeAppearanceModel(oVar);
        kVar.f17730x = !kVar.m();
        k kVar2 = this.f11796d;
        if (kVar2 != null) {
            kVar2.setShapeAppearanceModel(oVar);
        }
        k kVar3 = this.f11801q;
        if (kVar3 != null) {
            kVar3.setShapeAppearanceModel(oVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f11793a;
        return materialCardView.getPreventCornerOverlap() && this.f11795c.m() && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.f11793a;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void k() {
        Drawable drawable = this.f11798i;
        Drawable drawableC = j() ? c() : this.f11796d;
        this.f11798i = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.f11793a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    public final void l() {
        MaterialCardView materialCardView = this.f11793a;
        float cardViewRadius = 0.0f;
        float fA = ((!materialCardView.getPreventCornerOverlap() || this.f11795c.m()) && !i()) ? 0.0f : a();
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - y) * ((double) materialCardView.getCardViewRadius()));
        }
        int i2 = (int) (fA - cardViewRadius);
        Rect rect = this.f11794b;
        materialCardView.b(rect.left + i2, rect.top + i2, rect.right + i2, rect.bottom + i2);
    }

    public final void m() {
        boolean z2 = this.f11802r;
        MaterialCardView materialCardView = this.f11793a;
        if (!z2) {
            materialCardView.setBackgroundInternal(d(this.f11795c));
        }
        materialCardView.setForeground(d(this.f11798i));
    }
}
