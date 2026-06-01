package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.TransformExperimental;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@TransformExperimental
public final class CoordinateTransform {
    private static final String MISMATCH_MSG = "The source viewport (%s) does not match the target viewport (%s). Please make sure they are associated with the same Viewport.";
    private static final String TAG = "CoordinateTransform";
    private final Matrix mMatrix;

    public CoordinateTransform(OutputTransform outputTransform, OutputTransform outputTransform2) {
        if (!TransformUtils.isAspectRatioMatchingWithRoundingError(outputTransform.getViewPortSize(), outputTransform2.getViewPortSize())) {
            Logger.w(TAG, "The source viewport (" + outputTransform.getViewPortSize() + ") does not match the target viewport (" + outputTransform2.getViewPortSize() + "). Please make sure they are associated with the same Viewport.");
        }
        Matrix matrix = new Matrix();
        this.mMatrix = matrix;
        Preconditions.checkState(outputTransform.getMatrix().invert(matrix), "The source transform cannot be inverted");
        matrix.postConcat(outputTransform2.getMatrix());
    }

    public void mapPoint(PointF pointF) {
        float[] fArr = {pointF.x, pointF.y};
        this.mMatrix.mapPoints(fArr);
        pointF.x = fArr[0];
        pointF.y = fArr[1];
    }

    public void mapPoints(float[] fArr) {
        this.mMatrix.mapPoints(fArr);
    }

    public void mapRect(RectF rectF) {
        this.mMatrix.mapRect(rectF);
    }

    public void transform(Matrix matrix) {
        matrix.set(this.mMatrix);
    }
}
