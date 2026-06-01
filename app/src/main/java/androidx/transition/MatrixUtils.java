package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f4, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f4, float f8, float f9, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f4, float f8, float f9, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f4, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f4, float f8, float f9, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f4, float f8, float f9, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i2, float[] fArr2, int i8, int i9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f4, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f4, float f8, float f9, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f4, float f8, float f9, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f4, float f8, float f9, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f4, float f8) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f4, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f4, float f8) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f4, float f8) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f4, float f8) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
