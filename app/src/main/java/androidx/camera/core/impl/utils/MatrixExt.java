package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MatrixExt {
    private static final float[] sTemp = new float[16];

    private MatrixExt() {
    }

    private static void denormalize(float[] fArr, float f4, float f8) {
        Matrix.translateM(fArr, 0, -f4, -f8, 0.0f);
    }

    private static void normalize(float[] fArr, float f4, float f8) {
        Matrix.translateM(fArr, 0, f4, f8, 0.0f);
    }

    public static void postRotate(float[] fArr, float f4, float f8, float f9) throws Throwable {
        float[] fArr2 = sTemp;
        synchronized (fArr2) {
            try {
                Matrix.setIdentityM(fArr2, 0);
                normalize(fArr2, f8, f9);
                Matrix.rotateM(fArr2, 0, f4, 0.0f, 0.0f, 1.0f);
                denormalize(fArr2, f8, f9);
                try {
                    Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
                } catch (Throwable th) {
                    th = th;
                    fArr2 = fArr2;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void preRotate(float[] fArr, float f4, float f8, float f9) {
        normalize(fArr, f8, f9);
        Matrix.rotateM(fArr, 0, f4, 0.0f, 0.0f, 1.0f);
        denormalize(fArr, f8, f9);
    }

    public static void preVerticalFlip(float[] fArr, float f4) {
        normalize(fArr, 0.0f, f4);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        denormalize(fArr, 0.0f, f4);
    }

    public static void setRotate(float[] fArr, float f4, float f8, float f9) {
        Matrix.setIdentityM(fArr, 0);
        preRotate(fArr, f4, f8, f9);
    }

    public static String toString(float[] fArr, int i2) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", Float.valueOf(fArr[i2]), Float.valueOf(fArr[i2 + 4]), Float.valueOf(fArr[i2 + 8]), Float.valueOf(fArr[i2 + 12]), Float.valueOf(fArr[i2 + 1]), Float.valueOf(fArr[i2 + 5]), Float.valueOf(fArr[i2 + 9]), Float.valueOf(fArr[i2 + 13]), Float.valueOf(fArr[i2 + 2]), Float.valueOf(fArr[i2 + 6]), Float.valueOf(fArr[i2 + 10]), Float.valueOf(fArr[i2 + 14]), Float.valueOf(fArr[i2 + 3]), Float.valueOf(fArr[i2 + 7]), Float.valueOf(fArr[i2 + 11]), Float.valueOf(fArr[i2 + 15]));
    }
}
