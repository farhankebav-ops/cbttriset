package q1;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.textfield.TextInputLayout;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int[] M;
    public boolean N;
    public final TextPaint O;
    public final TextPaint P;
    public TimeInterpolator Q;
    public TimeInterpolator R;
    public float S;
    public float T;
    public float U;
    public ColorStateList V;
    public float W;
    public float X;
    public float Y;
    public StaticLayout Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13384a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f13385a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13386b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f13387b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f13388c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f13389c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f13390d;
    public CharSequence d0;
    public final RectF e;
    public ColorStateList j;
    public ColorStateList k;
    public boolean k0;
    public int l;
    public float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13396o;
    public float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f13399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f13400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f13401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f13402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f13403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f13404x;
    public Typeface y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public t1.a f13405z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13392f = 16;
    public int g = 16;
    public float h = 15.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13393i = 15.0f;
    public final TextUtils.TruncateAt A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f13391e0 = 1;
    public int f0 = 1;
    public final float g0 = 1.0f;
    public final int h0 = 1;
    public int i0 = -1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f13394j0 = -1;

    public c(TextInputLayout textInputLayout) {
        this.f13384a = textInputLayout;
        TextPaint textPaint = new TextPaint(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.f13390d = new Rect();
        this.f13388c = new Rect();
        this.e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(int i2, int i8, float f4) {
        float f8 = 1.0f - f4;
        return Color.argb(Math.round((Color.alpha(i8) * f4) + (Color.alpha(i2) * f8)), Math.round((Color.red(i8) * f4) + (Color.red(i2) * f8)), Math.round((Color.green(i8) * f4) + (Color.green(i2) * f8)), Math.round((Color.blue(i8) * f4) + (Color.blue(i2) * f8)));
    }

    public static float h(float f4, float f8, float f9, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        return c1.a.a(f4, f8, f9);
    }

    public final void b() {
        float f4 = this.f13386b;
        float f8 = this.f13388c.left;
        Rect rect = this.f13390d;
        float fH = h(f8, rect.left, f4, this.Q);
        RectF rectF = this.e;
        rectF.left = fH;
        rectF.top = h(this.m, this.f13395n, f4, this.Q);
        rectF.right = h(r1.right, rect.right, f4, this.Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f4, this.Q);
        this.f13397q = h(this.f13396o, this.p, f4, this.Q);
        this.f13398r = h(this.m, this.f13395n, f4, this.Q);
        d(f4, false);
        TextInputLayout textInputLayout = this.f13384a;
        textInputLayout.postInvalidateOnAnimation();
        FastOutSlowInInterpolator fastOutSlowInInterpolator = c1.a.f4169b;
        this.f13387b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f4, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        this.f13389c0 = h(1.0f, 0.0f, f4, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.k;
        ColorStateList colorStateList2 = this.j;
        TextPaint textPaint = this.O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(g(colorStateList2), g(this.k), f4));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f9 = this.W;
        float f10 = this.X;
        if (f9 != f10) {
            textPaint.setLetterSpacing(h(f10, f9, f4, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f9);
        }
        this.H = c1.a.a(0.0f, this.S, f4);
        this.I = c1.a.a(0.0f, this.T, f4);
        this.J = c1.a.a(0.0f, this.U, f4);
        int iA = a(0, g(this.V), f4);
        this.K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z2 = this.f13384a.getLayoutDirection() == 1;
        if (this.E) {
            return (z2 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
        }
        return z2;
    }

    public final void d(float f4, boolean z2) {
        float f8;
        Typeface typeface;
        float f9;
        if (this.B == null) {
            return;
        }
        float fWidth = this.f13390d.width();
        float fWidth2 = this.f13388c.width();
        if (Math.abs(f4 - 1.0f) < 1.0E-5f) {
            f8 = o() ? this.f13393i : this.h;
            f9 = o() ? this.W : this.X;
            this.F = o() ? 1.0f : h(this.h, this.f13393i, f4, this.R) / this.h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f13399s;
            fWidth2 = fWidth;
        } else {
            f8 = this.h;
            float f10 = this.X;
            typeface = this.f13402v;
            if (Math.abs(f4 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = h(this.h, this.f13393i, f4, this.R) / this.h;
            }
            float f11 = this.f13393i / this.h;
            float f12 = fWidth2 * f11;
            if (!z2 && f12 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f11, fWidth2);
            }
            f9 = f10;
        }
        int i2 = f4 < 0.5f ? this.f13391e0 : this.f0;
        TextPaint textPaint = this.O;
        if (fWidth2 > 0.0f) {
            boolean z7 = this.G != f8;
            boolean z8 = this.Y != f9;
            boolean z9 = this.y != typeface;
            StaticLayout staticLayout = this.Z;
            boolean z10 = z7 || z8 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z9 || (this.L != i2) || this.N;
            this.G = f8;
            this.Y = f9;
            this.y = typeface;
            this.N = false;
            this.L = i2;
            textPaint.setLinearText(this.F != 1.0f);
            z = z10;
        }
        if (this.C == null || z) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.y);
            textPaint.setLetterSpacing(this.Y);
            boolean zC = c(this.B);
            this.D = zC;
            StaticLayout staticLayoutE = e(((this.f13391e0 > 1 || this.f0 > 1) && !zC) ? i2 : 1, textPaint, this.B, fWidth2 * (o() ? 1.0f : this.F), this.D);
            this.Z = staticLayoutE;
            this.C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i2, TextPaint textPaint, CharSequence charSequence, float f4, boolean z2) {
        Layout.Alignment alignment;
        if (i2 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f13392f, this.D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        h hVar = new h(charSequence, textPaint, (int) f4);
        hVar.l = this.A;
        hVar.k = z2;
        hVar.e = alignment;
        hVar.j = false;
        hVar.f13417f = i2;
        float f8 = this.g0;
        hVar.g = 0.0f;
        hVar.h = f8;
        hVar.f13418i = this.h0;
        hVar.m = null;
        return (StaticLayout) Preconditions.checkNotNull(hVar.a());
    }

    public final float f() {
        int i2 = this.i0;
        if (i2 != -1) {
            return i2;
        }
        float f4 = this.f13393i;
        TextPaint textPaint = this.P;
        textPaint.setTextSize(f4);
        textPaint.setTypeface(this.f13399s);
        textPaint.setLetterSpacing(this.W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f13401u;
            if (typeface != null) {
                this.f13400t = t1.h.a(configuration, typeface);
            }
            Typeface typeface2 = this.f13404x;
            if (typeface2 != null) {
                this.f13403w = t1.h.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f13400t;
            if (typeface3 == null) {
                typeface3 = this.f13401u;
            }
            this.f13399s = typeface3;
            Typeface typeface4 = this.f13403w;
            if (typeface4 == null) {
                typeface4 = this.f13404x;
            }
            this.f13402v = typeface4;
            j(true);
        }
    }

    public final void j(boolean z2) {
        float fMeasureText;
        TextInputLayout textInputLayout = this.f13384a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z2) {
            return;
        }
        d(1.0f, z2);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.O;
        if (charSequence != null && this.Z != null) {
            this.d0 = o() ? TextUtils.ellipsize(this.C, textPaint, this.Z.getWidth(), this.A) : this.C;
        }
        CharSequence charSequence2 = this.d0;
        if (charSequence2 != null) {
            this.f13385a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f13385a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.g, this.D ? 1 : 0);
        int i2 = absoluteGravity & 112;
        Rect rect = this.f13390d;
        if (i2 == 48) {
            this.f13395n = rect.top;
        } else if (i2 != 80) {
            this.f13395n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f13395n = textPaint.ascent() + rect.bottom;
        }
        int i8 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i8 == 1) {
            this.p = rect.centerX() - (this.f13385a0 / 2.0f);
        } else if (i8 != 5) {
            this.p = rect.left;
        } else {
            this.p = rect.right - this.f13385a0;
        }
        if (this.f13385a0 <= rect.width()) {
            float f4 = this.p;
            float fMax = Math.max(0.0f, rect.left - f4) + f4;
            this.p = fMax;
            this.p = Math.min(0.0f, rect.right - (this.f13385a0 + fMax)) + fMax;
        }
        float f8 = this.f13393i;
        TextPaint textPaint2 = this.P;
        textPaint2.setTextSize(f8);
        textPaint2.setTypeface(this.f13399s);
        textPaint2.setLetterSpacing(this.W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f9 = this.f13395n;
            float fMax2 = Math.max(0.0f, rect.top - f9) + f9;
            this.f13395n = fMax2;
            this.f13395n = Math.min(0.0f, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(0.0f, z2);
        float height = this.Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.Z;
        if (staticLayout == null || this.f13391e0 <= 1) {
            CharSequence charSequence3 = this.C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.Z;
        this.l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f13392f, this.D ? 1 : 0);
        int i9 = absoluteGravity2 & 112;
        Rect rect2 = this.f13388c;
        if (i9 == 48) {
            this.m = rect2.top;
        } else if (i9 != 80) {
            this.m = rect2.centerY() - (height / 2.0f);
        } else {
            this.m = (rect2.bottom - height) + (this.k0 ? textPaint.descent() : 0.0f);
        }
        int i10 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i10 == 1) {
            this.f13396o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i10 != 5) {
            this.f13396o = rect2.left;
        } else {
            this.f13396o = rect2.right - fMeasureText;
        }
        d(this.f13386b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.k == colorStateList && this.j == colorStateList) {
            return;
        }
        this.k = colorStateList;
        this.j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        t1.a aVar = this.f13405z;
        if (aVar != null) {
            aVar.f17385c = true;
        }
        if (this.f13401u == typeface) {
            return false;
        }
        this.f13401u = typeface;
        Typeface typefaceA = t1.h.a(this.f13384a.getContext().getResources().getConfiguration(), typeface);
        this.f13400t = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.f13401u;
        }
        this.f13399s = typefaceA;
        return true;
    }

    public final void m(float f4) {
        float fClamp = MathUtils.clamp(f4, 0.0f, 1.0f);
        if (fClamp != this.f13386b) {
            this.f13386b = fClamp;
            b();
        }
    }

    public final void n(Typeface typeface) {
        boolean z2;
        boolean zL = l(typeface);
        if (this.f13404x != typeface) {
            this.f13404x = typeface;
            Typeface typefaceA = t1.h.a(this.f13384a.getContext().getResources().getConfiguration(), typeface);
            this.f13403w = typefaceA;
            if (typefaceA == null) {
                typefaceA = this.f13404x;
            }
            this.f13402v = typefaceA;
            z2 = true;
        } else {
            z2 = false;
        }
        if (zL || z2) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f0 == 1;
    }
}
