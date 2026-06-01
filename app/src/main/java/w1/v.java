package w1;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class v extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17762c;

    @Override // w1.w
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f17763a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f17761b, this.f17762c);
        path.transform(matrix);
    }
}
