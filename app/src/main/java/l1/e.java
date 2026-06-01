package l1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import q1.i;
import q1.j;
import t1.f;
import w1.g;
import w1.h;
import w1.k;
import w1.n;
import w1.o;
import w1.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends k implements Drawable.Callback, i {
    public static final int[] P0 = {R.attr.state_enabled};
    public static final ShapeDrawable Q0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public boolean B0;
    public int C0;
    public int D0;
    public ColorFilter E0;
    public PorterDuffColorFilter F0;
    public ColorStateList G0;
    public ColorStateList H;
    public PorterDuff.Mode H0;
    public ColorStateList I;
    public int[] I0;
    public float J;
    public ColorStateList J0;
    public float K;
    public WeakReference K0;
    public ColorStateList L;
    public TextUtils.TruncateAt L0;
    public float M;
    public boolean M0;
    public ColorStateList N;
    public int N0;
    public CharSequence O;
    public boolean O0;
    public boolean P;
    public Drawable Q;
    public ColorStateList R;
    public float S;
    public boolean T;
    public boolean U;
    public Drawable V;
    public RippleDrawable W;
    public ColorStateList X;
    public float Y;
    public CharSequence Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f12744a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f12745b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Drawable f12746c0;
    public ColorStateList d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public c1.b f12747e0;
    public c1.b f0;
    public float g0;
    public float h0;
    public float i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f12748j0;
    public float k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f12749l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f12750m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f12751n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final Context f12752o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Paint f12753p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final Paint.FontMetrics f12754q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final RectF f12755r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final PointF f12756s0;
    public final Path t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final j f12757u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f12758v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f12759w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f12760x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f12761y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f12762z0;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.cbt.exam.browser.R.attr.chipStyle, com.cbt.exam.browser.R.style.Widget_MaterialComponents_Chip_Action);
        this.K = -1.0f;
        this.f12753p0 = new Paint(1);
        this.f12754q0 = new Paint.FontMetrics();
        this.f12755r0 = new RectF();
        this.f12756s0 = new PointF();
        this.t0 = new Path();
        this.D0 = 255;
        this.H0 = PorterDuff.Mode.SRC_IN;
        this.K0 = new WeakReference(null);
        l(context);
        this.f12752o0 = context;
        j jVar = new j(this);
        this.f12757u0 = jVar;
        this.O = "";
        jVar.f13419a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = P0;
        setState(iArr);
        V(iArr);
        this.M0 = true;
        Q0.setTint(-1);
    }

    public static boolean C(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean D(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void f0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final float A() {
        if (e0()) {
            return this.f12749l0 + this.Y + this.f12750m0;
        }
        return 0.0f;
    }

    public final float B() {
        return this.O0 ? j() : this.K;
    }

    public final void E() {
        d dVar = (d) this.K0.get();
        if (dVar != null) {
            Chip chip = (Chip) dVar;
            chip.c(chip.l);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean F(int[] r10, int[] r11) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.e.F(int[], int[]):boolean");
    }

    public final void G(boolean z2) {
        if (this.f12744a0 != z2) {
            this.f12744a0 = z2;
            float fZ = z();
            if (!z2 && this.B0) {
                this.B0 = false;
            }
            float fZ2 = z();
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void H(Drawable drawable) {
        if (this.f12746c0 != drawable) {
            float fZ = z();
            this.f12746c0 = drawable;
            float fZ2 = z();
            f0(this.f12746c0);
            x(this.f12746c0);
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void I(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.d0 != colorStateList) {
            this.d0 = colorStateList;
            if (this.f12745b0 && (drawable = this.f12746c0) != null && this.f12744a0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void J(boolean z2) {
        if (this.f12745b0 != z2) {
            boolean zC0 = c0();
            this.f12745b0 = z2;
            boolean zC02 = c0();
            if (zC0 != zC02) {
                if (zC02) {
                    x(this.f12746c0);
                } else {
                    f0(this.f12746c0);
                }
                invalidateSelf();
                E();
            }
        }
    }

    public final void K(float f4) {
        if (this.K != f4) {
            this.K = f4;
            n nVarF = this.f17716b.f17705a.f();
            nVarF.e = new w1.a(f4);
            nVarF.f17737f = new w1.a(f4);
            nVarF.g = new w1.a(f4);
            nVarF.h = new w1.a(f4);
            setShapeAppearanceModel(nVarF.a());
        }
    }

    public final void L(Drawable drawable) {
        Drawable drawable2 = this.Q;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fZ = z();
            this.Q = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fZ2 = z();
            f0(drawableUnwrap);
            if (d0()) {
                x(this.Q);
            }
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void M(float f4) {
        if (this.S != f4) {
            float fZ = z();
            this.S = f4;
            float fZ2 = z();
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void N(ColorStateList colorStateList) {
        this.T = true;
        if (this.R != colorStateList) {
            this.R = colorStateList;
            if (d0()) {
                this.Q.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void O(boolean z2) {
        if (this.P != z2) {
            boolean zD0 = d0();
            this.P = z2;
            boolean zD02 = d0();
            if (zD0 != zD02) {
                if (zD02) {
                    x(this.Q);
                } else {
                    f0(this.Q);
                }
                invalidateSelf();
                E();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            if (this.O0) {
                h hVar = this.f17716b;
                if (hVar.e != colorStateList) {
                    hVar.e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void Q(float f4) {
        if (this.M != f4) {
            this.M = f4;
            this.f12753p0.setStrokeWidth(f4);
            if (this.O0) {
                this.f17716b.k = f4;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void R(Drawable drawable) {
        Drawable drawable2 = this.V;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fA = A();
            this.V = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            this.W = new RippleDrawable(u1.a.a(this.N), this.V, Q0);
            float fA2 = A();
            f0(drawableUnwrap);
            if (e0()) {
                x(this.V);
            }
            invalidateSelf();
            if (fA != fA2) {
                E();
            }
        }
    }

    public final void S(float f4) {
        if (this.f12750m0 != f4) {
            this.f12750m0 = f4;
            invalidateSelf();
            if (e0()) {
                E();
            }
        }
    }

    public final void T(float f4) {
        if (this.Y != f4) {
            this.Y = f4;
            invalidateSelf();
            if (e0()) {
                E();
            }
        }
    }

    public final void U(float f4) {
        if (this.f12749l0 != f4) {
            this.f12749l0 = f4;
            invalidateSelf();
            if (e0()) {
                E();
            }
        }
    }

    public final boolean V(int[] iArr) {
        if (Arrays.equals(this.I0, iArr)) {
            return false;
        }
        this.I0 = iArr;
        if (e0()) {
            return F(getState(), iArr);
        }
        return false;
    }

    public final void W(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            if (e0()) {
                this.V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void X(boolean z2) {
        if (this.U != z2) {
            boolean zE0 = e0();
            this.U = z2;
            boolean zE02 = e0();
            if (zE0 != zE02) {
                if (zE02) {
                    x(this.V);
                } else {
                    f0(this.V);
                }
                invalidateSelf();
                E();
            }
        }
    }

    public final void Y(float f4) {
        if (this.i0 != f4) {
            float fZ = z();
            this.i0 = f4;
            float fZ2 = z();
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void Z(float f4) {
        if (this.h0 != f4) {
            float fZ = z();
            this.h0 = f4;
            float fZ2 = z();
            invalidateSelf();
            if (fZ != fZ2) {
                E();
            }
        }
    }

    public final void a0(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            this.J0 = null;
            onStateChange(getState());
        }
    }

    public final void b0(f fVar) {
        j jVar = this.f12757u0;
        a aVar = jVar.f13420b;
        TextPaint textPaint = jVar.f13419a;
        if (jVar.f13423f != fVar) {
            jVar.f13423f = fVar;
            if (fVar != null) {
                Context context = this.f12752o0;
                fVar.e(context, textPaint, aVar);
                i iVar = (i) jVar.e.get();
                if (iVar != null) {
                    textPaint.drawableState = iVar.getState();
                }
                fVar.d(context, textPaint, aVar);
                jVar.f13422d = true;
            }
            i iVar2 = (i) jVar.e.get();
            if (iVar2 != null) {
                e eVar = (e) iVar2;
                eVar.E();
                eVar.invalidateSelf();
                eVar.onStateChange(iVar2.getState());
            }
        }
    }

    public final boolean c0() {
        return this.f12745b0 && this.f12746c0 != null && this.B0;
    }

    public final boolean d0() {
        return this.P && this.Q != null;
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f4;
        int i8;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i2 = this.D0) == 0) {
            return;
        }
        if (i2 < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i2);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z2 = this.O0;
        Paint paint = this.f12753p0;
        RectF rectF = this.f12755r0;
        if (!z2) {
            paint.setColor(this.f12758v0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, B(), B(), paint);
        }
        if (!this.O0) {
            paint.setColor(this.f12759w0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.E0;
            if (colorFilter == null) {
                colorFilter = this.F0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, B(), B(), paint);
        }
        if (this.O0) {
            super.draw(canvas);
        }
        if (this.M > 0.0f && !this.O0) {
            paint.setColor(this.f12761y0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.O0) {
                ColorFilter colorFilter2 = this.E0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.F0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f8 = bounds.left;
            float f9 = this.M / 2.0f;
            rectF.set(f8 + f9, bounds.top + f9, bounds.right - f9, bounds.bottom - f9);
            float f10 = this.K - (this.M / 2.0f);
            canvas2.drawRoundRect(rectF, f10, f10, paint);
        }
        paint.setColor(this.f12762z0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.O0) {
            RectF rectF2 = new RectF(bounds);
            h hVar = this.f17716b;
            o oVar = hVar.f17705a;
            float[] fArr = this.C;
            float f11 = hVar.j;
            g gVar = this.f17724r;
            q qVar = this.f17725s;
            f4 = 2.0f;
            Path path = this.t0;
            qVar.a(oVar, fArr, f11, rectF2, gVar, path);
            e(canvas2, paint, path, this.f17716b.f17705a, this.C, g());
        } else {
            canvas2.drawRoundRect(rectF, B(), B(), paint);
            f4 = 2.0f;
        }
        if (d0()) {
            y(bounds, rectF);
            float f12 = rectF.left;
            float f13 = rectF.top;
            canvas2.translate(f12, f13);
            this.Q.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Q.draw(canvas2);
            canvas2.translate(-f12, -f13);
        }
        if (c0()) {
            y(bounds, rectF);
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.f12746c0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f12746c0.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.M0 && this.O != null) {
            PointF pointF = this.f12756s0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.O;
            j jVar = this.f12757u0;
            if (charSequence != null) {
                float fZ = z() + this.g0 + this.f12748j0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + fZ;
                } else {
                    pointF.x = bounds.right - fZ;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = jVar.f13419a;
                Paint.FontMetrics fontMetrics = this.f12754q0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f4);
            }
            rectF.setEmpty();
            if (this.O != null) {
                float fZ2 = z() + this.g0 + this.f12748j0;
                float fA = A() + this.f12751n0 + this.k0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.left = bounds.left + fZ2;
                    rectF.right = bounds.right - fA;
                } else {
                    rectF.left = bounds.left + fA;
                    rectF.right = bounds.right - fZ2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            f fVar = jVar.f13423f;
            TextPaint textPaint2 = jVar.f13419a;
            if (fVar != null) {
                textPaint2.drawableState = getState();
                jVar.f13423f.d(this.f12752o0, textPaint2, jVar.f13420b);
            }
            textPaint2.setTextAlign(align);
            boolean z7 = Math.round(jVar.a(this.O.toString())) > Math.round(rectF.width());
            if (z7) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i8 = iSave;
            } else {
                i8 = 0;
            }
            CharSequence charSequenceEllipsize = this.O;
            if (z7 && this.L0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.L0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z7) {
                canvas2.restoreToCount(i8);
            }
        }
        if (e0()) {
            rectF.setEmpty();
            if (e0()) {
                float f16 = this.f12751n0 + this.f12750m0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f17 = bounds.right - f16;
                    rectF.right = f17;
                    rectF.left = f17 - this.Y;
                } else {
                    float f18 = bounds.left + f16;
                    rectF.left = f18;
                    rectF.right = f18 + this.Y;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f19 = this.Y;
                float f20 = fExactCenterY - (f19 / f4);
                rectF.top = f20;
                rectF.bottom = f20 + f19;
            }
            float f21 = rectF.left;
            float f22 = rectF.top;
            canvas2.translate(f21, f22);
            this.V.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.W.setBounds(this.V.getBounds());
            this.W.jumpToCurrentState();
            this.W.draw(canvas2);
            canvas2.translate(-f21, -f22);
        }
        if (this.D0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    public final boolean e0() {
        return this.U && this.V != null;
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.D0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.E0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(A() + this.f12757u0.a(this.O.toString()) + z() + this.g0 + this.f12748j0 + this.k0 + this.f12751n0), this.N0);
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.O0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.J, this.K);
        } else {
            outline.setRoundRect(bounds, this.K);
            outline2 = outline;
        }
        outline2.setAlpha(this.D0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (C(this.H) || C(this.I) || C(this.L)) {
            return true;
        }
        f fVar = this.f12757u0.f13423f;
        if (fVar == null || (colorStateList = fVar.k) == null || !colorStateList.isStateful()) {
            return (this.f12745b0 && this.f12746c0 != null && this.f12744a0) || D(this.Q) || D(this.f12746c0) || C(this.G0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i2) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (d0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Q, i2);
        }
        if (c0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f12746c0, i2);
        }
        if (e0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.V, i2);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        boolean zOnLevelChange = super.onLevelChange(i2);
        if (d0()) {
            zOnLevelChange |= this.Q.setLevel(i2);
        }
        if (c0()) {
            zOnLevelChange |= this.f12746c0.setLevel(i2);
        }
        if (e0()) {
            zOnLevelChange |= this.V.setLevel(i2);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.O0) {
            super.onStateChange(iArr);
        }
        return F(iArr, this.I0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.D0 != i2) {
            this.D0 = i2;
            invalidateSelf();
        }
    }

    @Override // w1.k, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.E0 != colorFilter) {
            this.E0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // w1.k, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // w1.k, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.H0 != mode) {
            this.H0 = mode;
            ColorStateList colorStateList = this.G0;
            this.F0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z7) {
        boolean visible = super.setVisible(z2, z7);
        if (d0()) {
            visible |= this.Q.setVisible(z2, z7);
        }
        if (c0()) {
            visible |= this.f12746c0.setVisible(z2, z7);
        }
        if (e0()) {
            visible |= this.V.setVisible(z2, z7);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void x(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.V) {
            if (drawable.isStateful()) {
                drawable.setState(this.I0);
            }
            drawable.setTintList(this.X);
            return;
        }
        Drawable drawable2 = this.Q;
        if (drawable == drawable2 && this.T) {
            drawable2.setTintList(this.R);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void y(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (d0() || c0()) {
            float f4 = this.g0 + this.h0;
            Drawable drawable = this.B0 ? this.f12746c0 : this.Q;
            float intrinsicWidth = this.S;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f8 = rect.left + f4;
                rectF.left = f8;
                rectF.right = f8 + intrinsicWidth;
            } else {
                float f9 = rect.right - f4;
                rectF.right = f9;
                rectF.left = f9 - intrinsicWidth;
            }
            Drawable drawable2 = this.B0 ? this.f12746c0 : this.Q;
            float fCeil = this.S;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f12752o0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float z() {
        if (!d0() && !c0()) {
            return 0.0f;
        }
        float f4 = this.h0;
        Drawable drawable = this.B0 ? this.f12746c0 : this.Q;
        float intrinsicWidth = this.S;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f4 + this.i0;
    }
}
