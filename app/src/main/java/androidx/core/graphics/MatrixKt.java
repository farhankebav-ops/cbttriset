package androidx.core.graphics;

import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MatrixKt {
    public static final Matrix rotationMatrix(float f4, float f8, float f9) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f4, f8, f9);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f4, float f8, float f9, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f8 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f9 = 0.0f;
        }
        return rotationMatrix(f4, f8, f9);
    }

    public static final Matrix scaleMatrix(float f4, float f8) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f8);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f4, float f8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 1.0f;
        }
        return scaleMatrix(f4, f8);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f4, float f8) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f4, f8);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f4, float f8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 0.0f;
        }
        return translationMatrix(f4, f8);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
