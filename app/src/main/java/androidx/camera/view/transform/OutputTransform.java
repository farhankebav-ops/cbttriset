package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;
import androidx.annotation.RestrictTo;
import androidx.camera.view.TransformExperimental;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@TransformExperimental
public final class OutputTransform {
    final Matrix mMatrix;
    final Size mViewPortSize;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public OutputTransform(Matrix matrix, Size size) {
        this.mMatrix = matrix;
        this.mViewPortSize = size;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public Size getViewPortSize() {
        return this.mViewPortSize;
    }
}
