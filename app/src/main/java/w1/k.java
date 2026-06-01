package w1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class k extends Drawable implements TintAwareDrawable, z {
    public static final Paint F;
    public static final j[] G;
    public SpringForce A;
    public final SpringAnimation[] B;
    public float[] C;
    public float[] D;
    public i E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f17715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f17716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x[] f17717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x[] f17718d;
    public final BitSet e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17719f;
    public boolean g;
    public final Matrix h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f17720i;
    public final Path j;
    public final RectF k;
    public final RectF l;
    public final Region m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Region f17721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f17722o;
    public final Paint p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v1.a f17723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f17724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final q f17725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f17726t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f17727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f17728v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f17729w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f17730x;
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public o f17731z;

    static {
        Paint paint = new Paint(1);
        F = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        G = new j[4];
        int i2 = 0;
        while (true) {
            j[] jVarArr = G;
            if (i2 >= jVarArr.length) {
                return;
            }
            jVarArr[i2] = new j(i2);
            i2++;
        }
    }

    public k() {
        this(new o());
    }

    public static float b(RectF rectF, o oVar, float[] fArr) {
        if (fArr == null) {
            if (oVar.e(rectF)) {
                return oVar.e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f4 = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (fArr[i2] != f4) {
                    return -1.0f;
                }
            }
        }
        if (oVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void a(RectF rectF, Path path) {
        h hVar = this.f17716b;
        this.f17725s.a(hVar.f17705a, this.C, hVar.j, rectF, this.f17724r, path);
        if (this.f17716b.f17710i != 1.0f) {
            Matrix matrix = this.h;
            matrix.reset();
            float f4 = this.f17716b.f17710i;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f17729w, true);
    }

    public final int c(int i2) {
        h hVar = this.f17716b;
        float f4 = hVar.f17711n + 0.0f + hVar.m;
        p1.a aVar = hVar.f17707c;
        return aVar != null ? aVar.a(i2, f4) : i2;
    }

    public final void d(Canvas canvas) {
        if (this.e.cardinality() > 0) {
            Log.w("k", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i2 = this.f17716b.p;
        Path path = this.f17720i;
        v1.a aVar = this.f17723q;
        if (i2 != 0) {
            canvas.drawPath(path, aVar.f17597a);
        }
        for (int i8 = 0; i8 < 4; i8++) {
            x xVar = this.f17717c[i8];
            int i9 = this.f17716b.f17712o;
            Matrix matrix = x.f17764b;
            xVar.a(matrix, aVar, i9, canvas);
            this.f17718d[i8].a(matrix, aVar, this.f17716b.f17712o, canvas);
        }
        if (this.f17730x) {
            double d8 = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d8)) * ((double) this.f17716b.p));
            int iCos = (int) (Math.cos(Math.toRadians(d8)) * ((double) this.f17716b.p));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, F);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        PorterDuffColorFilter porterDuffColorFilter = this.f17726t;
        Paint paint2 = this.f17722o;
        paint2.setColorFilter(porterDuffColorFilter);
        int alpha = paint2.getAlpha();
        int i2 = this.f17716b.l;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.f17727u;
        Paint paint3 = this.p;
        paint3.setColorFilter(porterDuffColorFilter2);
        paint3.setStrokeWidth(this.f17716b.k);
        int alpha2 = paint3.getAlpha();
        int i8 = this.f17716b.l;
        paint3.setAlpha(((i8 + (i8 >>> 7)) * alpha2) >>> 8);
        Paint.Style style = this.f17716b.f17713q;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z2 = this.f17719f;
            paint = paint2;
            Path path = this.f17720i;
            if (z2) {
                a(g(), path);
                this.f17719f = false;
            }
            h hVar = this.f17716b;
            hVar.getClass();
            if (hVar.f17712o > 0 && !m() && !path.isConvex() && Build.VERSION.SDK_INT < 29) {
                canvas.save();
                double d8 = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d8)) * ((double) this.f17716b.p)), (int) (Math.cos(Math.toRadians(d8)) * ((double) this.f17716b.p)));
                if (this.f17730x) {
                    RectF rectF = this.f17729w;
                    int iWidth = (int) (rectF.width() - getBounds().width());
                    int iHeight = (int) (rectF.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f17716b.f17712o * 2) + ((int) rectF.width()) + iWidth, (this.f17716b.f17712o * 2) + ((int) rectF.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f4 = (getBounds().left - this.f17716b.f17712o) - iWidth;
                    float f8 = (getBounds().top - this.f17716b.f17712o) - iHeight;
                    canvas2.translate(-f4, -f8);
                    d(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f4, f8, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    d(canvas);
                    canvas.restore();
                }
            }
            e(canvas, paint, path, this.f17716b.f17705a, this.C, g());
        } else {
            paint = paint2;
        }
        if (k()) {
            if (this.g) {
                o oVar = this.f17716b.f17705a;
                n nVarF = oVar.f();
                d dVar = oVar.e;
                g gVar = this.f17715a;
                nVarF.e = gVar.a(dVar);
                nVarF.f17737f = gVar.a(oVar.f17743f);
                nVarF.h = gVar.a(oVar.h);
                nVarF.g = gVar.a(oVar.g);
                this.f17731z = nVarF.a();
                float[] fArr = this.C;
                if (fArr != null) {
                    if (this.D == null) {
                        this.D = new float[fArr.length];
                    }
                    float fI = i();
                    int i9 = 0;
                    while (true) {
                        float[] fArr2 = this.C;
                        if (i9 >= fArr2.length) {
                            break;
                        }
                        this.D[i9] = Math.max(0.0f, fArr2[i9] - fI);
                        i9++;
                    }
                } else {
                    this.D = null;
                }
                o oVar2 = this.f17731z;
                float[] fArr3 = this.D;
                float f9 = this.f17716b.j;
                RectF rectFG = g();
                RectF rectF2 = this.l;
                rectF2.set(rectFG);
                float fI2 = i();
                rectF2.inset(fI2, fI2);
                this.f17725s.a(oVar2, fArr3, f9, rectF2, null, this.j);
                this.g = false;
            }
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint3.setAlpha(alpha2);
    }

    public final void e(Canvas canvas, Paint paint, Path path, o oVar, float[] fArr, RectF rectF) {
        float fB = b(rectF, oVar, fArr);
        if (fB < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f4 = fB * this.f17716b.j;
            canvas.drawRoundRect(rectF, f4, f4, paint);
        }
    }

    public void f(Canvas canvas) {
        o oVar = this.f17731z;
        float[] fArr = this.D;
        RectF rectFG = g();
        RectF rectF = this.l;
        rectF.set(rectFG);
        float fI = i();
        rectF.inset(fI, fI);
        e(canvas, this.p, this.j, oVar, fArr, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.k;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17716b.l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f17716b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f17716b.getClass();
        RectF rectFG = g();
        if (rectFG.isEmpty()) {
            return;
        }
        float fB = b(rectFG, this.f17716b.f17705a, this.C);
        if (fB >= 0.0f) {
            outline.setRoundRect(getBounds(), fB * this.f17716b.j);
            return;
        }
        boolean z2 = this.f17719f;
        Path path = this.f17720i;
        if (z2) {
            a(rectFG, path);
            this.f17719f = false;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            o1.b.a(outline, path);
            return;
        }
        if (i2 >= 29) {
            try {
                o1.a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            o1.a.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f17716b.h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.m;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.f17720i;
        a(rectFG, path);
        Region region2 = this.f17721n;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        float[] fArr = this.C;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFG = g();
        o oVar = this.f17716b.f17705a;
        q qVar = this.f17725s;
        qVar.getClass();
        float fA = oVar.e.a(rectFG);
        o oVar2 = this.f17716b.f17705a;
        qVar.getClass();
        float fA2 = oVar2.h.a(rectFG) + fA;
        o oVar3 = this.f17716b.f17705a;
        qVar.getClass();
        float fA3 = fA2 - oVar3.g.a(rectFG);
        o oVar4 = this.f17716b.f17705a;
        qVar.getClass();
        return (fA3 - oVar4.f17743f.a(rectFG)) / 2.0f;
    }

    public final float i() {
        if (k()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f17719f = true;
        this.g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f17716b.f17709f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f17716b.getClass();
        ColorStateList colorStateList2 = this.f17716b.e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f17716b.f17708d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        c0 c0Var = this.f17716b.f17706b;
        return c0Var != null && c0Var.d();
    }

    public final float j() {
        float[] fArr = this.C;
        return fArr != null ? fArr[3] : this.f17716b.f17705a.e.a(g());
    }

    public final boolean k() {
        Paint.Style style = this.f17716b.f17713q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public final void l(Context context) {
        this.f17716b.f17707c = new p1.a(context);
        w();
    }

    public final boolean m() {
        if (!this.f17716b.f17705a.e(g())) {
            float[] fArr = this.C;
            if (fArr != null) {
                if (fArr.length > 1) {
                    float f4 = fArr[0];
                    for (int i2 = 1; i2 < fArr.length; i2++) {
                        if (fArr[i2] != f4) {
                            break;
                        }
                    }
                }
                if (this.f17716b.f17705a.d()) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f17716b = new h(this.f17716b);
        return this;
    }

    public final void n(SpringForce springForce) {
        if (this.A == springForce) {
            return;
        }
        this.A = springForce;
        int i2 = 0;
        while (true) {
            SpringAnimation[] springAnimationArr = this.B;
            if (i2 >= springAnimationArr.length) {
                u(getState(), true);
                invalidateSelf();
                return;
            } else {
                if (springAnimationArr[i2] == null) {
                    springAnimationArr[i2] = new SpringAnimation(this, G[i2]);
                }
                springAnimationArr[i2].setSpring(new SpringForce().setDampingRatio(springForce.getDampingRatio()).setStiffness(springForce.getStiffness()));
                i2++;
            }
        }
    }

    public final void o(float f4) {
        h hVar = this.f17716b;
        if (hVar.f17711n != f4) {
            hVar.f17711n = f4;
            w();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f17719f = true;
        this.g = true;
        super.onBoundsChange(rect);
        if (this.f17716b.f17706b != null && !rect.isEmpty()) {
            u(getState(), this.y);
        }
        this.y = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f17716b.f17706b != null) {
            u(iArr, false);
        }
        boolean z2 = t(iArr) || v();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public final void p(ColorStateList colorStateList) {
        h hVar = this.f17716b;
        if (hVar.f17708d != colorStateList) {
            hVar.f17708d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void q(float f4) {
        h hVar = this.f17716b;
        if (hVar.j != f4) {
            hVar.j = f4;
            this.f17719f = true;
            this.g = true;
            invalidateSelf();
        }
    }

    public final void r() {
        this.f17723q.a(-12303292);
        this.f17716b.getClass();
        super.invalidateSelf();
    }

    public final void s(c0 c0Var) {
        h hVar = this.f17716b;
        if (hVar.f17706b != c0Var) {
            hVar.f17706b = c0Var;
            u(getState(), true);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        h hVar = this.f17716b;
        if (hVar.l != i2) {
            hVar.l = i2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17716b.getClass();
        super.invalidateSelf();
    }

    @Override // w1.z
    public final void setShapeAppearanceModel(o oVar) {
        h hVar = this.f17716b;
        hVar.f17705a = oVar;
        hVar.f17706b = null;
        this.C = null;
        this.D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17716b.f17709f = colorStateList;
        v();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f17716b;
        if (hVar.g != mode) {
            hVar.g = mode;
            v();
            super.invalidateSelf();
        }
    }

    public final boolean t(int[] iArr) {
        boolean z2;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f17716b.f17708d == null || color2 == (colorForState2 = this.f17716b.f17708d.getColorForState(iArr, (color2 = (paint2 = this.f17722o).getColor())))) {
            z2 = false;
        } else {
            paint2.setColor(colorForState2);
            z2 = true;
        }
        if (this.f17716b.e == null || color == (colorForState = this.f17716b.e.getColorForState(iArr, (color = (paint = this.p).getColor())))) {
            return z2;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void u(int[] iArr, boolean z2) {
        o oVarA;
        int i2;
        RectF rectFG = g();
        if (this.f17716b.f17706b == null || rectFG.isEmpty()) {
            return;
        }
        boolean z7 = z2 | (this.A == null);
        if (this.C == null) {
            this.C = new float[4];
        }
        c0 c0Var = this.f17716b.f17706b;
        o[] oVarArr = c0Var.f17695d;
        int i8 = c0Var.f17692a;
        int[][] iArr2 = c0Var.f17694c;
        a0 a0Var = c0Var.h;
        a0 a0Var2 = c0Var.g;
        a0 a0Var3 = c0Var.f17696f;
        a0 a0Var4 = c0Var.e;
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                i9 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i9], iArr)) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i10 = 0;
            while (true) {
                if (i10 >= i8) {
                    i2 = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i10], iArr3)) {
                        i2 = i10;
                        break;
                    }
                    i10++;
                }
            }
            i9 = i2;
        }
        if (a0Var4 == null && a0Var3 == null && a0Var2 == null && a0Var == null) {
            oVarA = oVarArr[i9];
        } else {
            n nVarF = oVarArr[i9].f();
            if (a0Var4 != null) {
                nVarF.e = a0Var4.c(iArr);
            }
            if (a0Var3 != null) {
                nVarF.f17737f = a0Var3.c(iArr);
            }
            if (a0Var2 != null) {
                nVarF.h = a0Var2.c(iArr);
            }
            if (a0Var != null) {
                nVarF.g = a0Var.c(iArr);
            }
            oVarA = nVarF.a();
        }
        int i11 = 0;
        while (i11 < 4) {
            this.f17725s.getClass();
            float fA = (i11 != 1 ? i11 != 2 ? i11 != 3 ? oVarA.f17743f : oVarA.e : oVarA.h : oVarA.g).a(rectFG);
            if (z7) {
                this.C[i11] = fA;
            }
            SpringAnimation[] springAnimationArr = this.B;
            SpringAnimation springAnimation = springAnimationArr[i11];
            if (springAnimation != null) {
                springAnimation.animateToFinalPosition(fA);
                if (z7) {
                    springAnimationArr[i11].skipToEnd();
                }
            }
            i11++;
        }
        if (z7) {
            invalidateSelf();
        }
    }

    public final boolean v() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f17726t;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f17727u;
        h hVar = this.f17716b;
        ColorStateList colorStateList = hVar.f17709f;
        PorterDuff.Mode mode = hVar.g;
        if (colorStateList == null || mode == null) {
            int color = this.f17722o.getColor();
            int iC = c(color);
            this.f17728v = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.f17728v = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.f17726t = porterDuffColorFilter;
        this.f17716b.getClass();
        this.f17727u = null;
        this.f17716b.getClass();
        return (ObjectsCompat.equals(porterDuffColorFilter2, this.f17726t) && ObjectsCompat.equals(porterDuffColorFilter3, this.f17727u)) ? false : true;
    }

    public final void w() {
        h hVar = this.f17716b;
        float f4 = hVar.f17711n + 0.0f;
        hVar.f17712o = (int) Math.ceil(0.75f * f4);
        this.f17716b.p = (int) Math.ceil(f4 * 0.25f);
        v();
        super.invalidateSelf();
    }

    public k(Context context, AttributeSet attributeSet, int i2, int i8) {
        this(o.b(context, attributeSet, i2, i8).a());
    }

    public k(o oVar) {
        this(new h(oVar));
    }

    public k(h hVar) {
        q qVar;
        this.f17715a = new g(this);
        this.f17717c = new x[4];
        this.f17718d = new x[4];
        this.e = new BitSet(8);
        this.h = new Matrix();
        this.f17720i = new Path();
        this.j = new Path();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new Region();
        this.f17721n = new Region();
        Paint paint = new Paint(1);
        this.f17722o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.f17723q = new v1.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            qVar = p.f17745a;
        } else {
            qVar = new q();
        }
        this.f17725s = qVar;
        this.f17729w = new RectF();
        this.f17730x = true;
        this.y = true;
        this.B = new SpringAnimation[4];
        this.f17716b = hVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        v();
        t(getState());
        this.f17724r = new g(this);
    }
}
