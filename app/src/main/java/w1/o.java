package w1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n7.b f17739a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n7.b f17740b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n7.b f17741c = new m();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n7.b f17742d = new m();
    public d e = new a(0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f17743f = new a(0.0f);
    public d g = new a(0.0f);
    public d h = new a(0.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f17744i;
    public f j;
    public f k;
    public f l;

    public o() {
        int i2 = 0;
        this.f17744i = new f(i2);
        this.j = new f(i2);
        this.k = new f(i2);
        this.l = new f(i2);
    }

    public static n a(Context context, int i2, int i8, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
        if (i8 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i8, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(b1.a.C);
        try {
            int i9 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i10 = typedArrayObtainStyledAttributes.getInt(3, i9);
            int i11 = typedArrayObtainStyledAttributes.getInt(4, i9);
            int i12 = typedArrayObtainStyledAttributes.getInt(2, i9);
            int i13 = typedArrayObtainStyledAttributes.getInt(1, i9);
            d dVarC = c(typedArrayObtainStyledAttributes, 5, aVar);
            d dVarC2 = c(typedArrayObtainStyledAttributes, 8, dVarC);
            d dVarC3 = c(typedArrayObtainStyledAttributes, 9, dVarC);
            d dVarC4 = c(typedArrayObtainStyledAttributes, 7, dVarC);
            d dVarC5 = c(typedArrayObtainStyledAttributes, 6, dVarC);
            n nVar = new n();
            nVar.f17733a = r2.q.L(i10);
            nVar.e = dVarC2;
            nVar.f17734b = r2.q.L(i11);
            nVar.f17737f = dVarC3;
            nVar.f17735c = r2.q.L(i12);
            nVar.g = dVarC4;
            nVar.f17736d = r2.q.L(i13);
            nVar.h = dVarC5;
            return nVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static n b(Context context, AttributeSet attributeSet, int i2, int i8) {
        a aVar = new a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.f4139v, i2, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i2, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        if (typedValuePeekValue != null) {
            int i8 = typedValuePeekValue.type;
            if (i8 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i8 == 6) {
                return new l(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean d() {
        return (this.f17740b instanceof m) && (this.f17739a instanceof m) && (this.f17741c instanceof m) && (this.f17742d instanceof m);
    }

    public final boolean e(RectF rectF) {
        boolean z2 = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.f17744i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float fA = this.e.a(rectF);
        return z2 && ((this.f17743f.a(rectF) > fA ? 1 : (this.f17743f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final n f() {
        n nVar = new n();
        nVar.f17733a = this.f17739a;
        nVar.f17734b = this.f17740b;
        nVar.f17735c = this.f17741c;
        nVar.f17736d = this.f17742d;
        nVar.e = this.e;
        nVar.f17737f = this.f17743f;
        nVar.g = this.g;
        nVar.h = this.h;
        nVar.f17738i = this.f17744i;
        nVar.j = this.j;
        nVar.k = this.k;
        nVar.l = this.l;
        return nVar;
    }

    public final String toString() {
        return C2300e4.i.f8403d + this.e + ", " + this.f17743f + ", " + this.g + ", " + this.h + C2300e4.i.e;
    }
}
