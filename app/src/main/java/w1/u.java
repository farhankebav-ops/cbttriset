package w1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class u extends w {
    public static final RectF h = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f17757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f17758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f17759d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f17760f;
    public float g;

    public u(float f4, float f8, float f9, float f10) {
        this.f17757b = f4;
        this.f17758c = f8;
        this.f17759d = f9;
        this.e = f10;
    }

    @Override // w1.w
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f17763a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f4 = this.f17759d;
        float f8 = this.e;
        RectF rectF = h;
        rectF.set(this.f17757b, this.f17758c, f4, f8);
        path.arcTo(rectF, this.f17760f, this.g, false);
        path.transform(matrix);
    }
}
