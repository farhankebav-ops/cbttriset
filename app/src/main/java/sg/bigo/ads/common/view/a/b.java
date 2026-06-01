package sg.bigo.ads.common.view.a;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final float f16174d;
    protected final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final float f16175f;
    protected final float g;
    protected final Rect h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final int f16176i;
    protected final int j;
    protected final float k;
    protected final float l;
    protected final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected final Drawable f16177n;

    public b() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 1291845632, 0, 0.0f);
    }

    public final void a(Rect rect) {
        Rect rect2 = this.h;
        if (rect2 == null) {
            rect2 = new Rect();
        }
        rect.left = rect2.left;
        rect.top = rect2.top;
        rect.right = rect2.right;
        rect.bottom = rect2.bottom;
    }

    public final int b() {
        return this.f16176i;
    }

    @FloatRange(from = 0.0d, to = 25.0d)
    public final float c() {
        return this.l;
    }

    public final float d() {
        return this.m;
    }

    @Nullable
    public final Drawable e() {
        return this.f16177n;
    }

    public b(float f4, float f8, float f9, float f10, int i2, int i8, float f11) {
        this(f4, f8, f9, f10, null, i2, i8, f11, null);
    }

    public final void a(float[] fArr) {
        float f4 = this.f16174d;
        fArr[0] = f4;
        fArr[1] = f4;
        float f8 = this.e;
        fArr[2] = f8;
        fArr[3] = f8;
        float f9 = this.f16175f;
        fArr[4] = f9;
        fArr[5] = f9;
        float f10 = this.g;
        fArr[6] = f10;
        fArr[7] = f10;
    }

    public b(float f4, float f8, float f9, float f10, @Nullable Rect rect, int i2, int i8, float f11, @Nullable boolean[] zArr) {
        this.f16174d = f4;
        this.e = f8;
        this.f16175f = f9;
        this.g = f10;
        this.h = rect;
        this.f16176i = i2;
        this.j = i8;
        this.k = f11;
        this.l = Math.max(0.0f, Math.min(25.0f, 23.0f));
        this.m = 4.0f;
        this.f16177n = (i8 == 0 || f11 <= 0.0f) ? null : sg.bigo.ads.common.utils.d.a(f4, f8, f9, f10, i8, f11, zArr);
    }
}
