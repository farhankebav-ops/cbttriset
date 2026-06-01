package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.core.util.Preconditions;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TransformUtils {
    public static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    private TransformUtils() {
    }

    public static float calculateSignedAngle(float f4, float f8, float f9, float f10) {
        float f11 = (f8 * f10) + (f4 * f9);
        float f12 = (f4 * f10) - (f8 * f9);
        double dSqrt = Math.sqrt((f8 * f8) + (f4 * f4)) * Math.sqrt((f10 * f10) + (f9 * f9));
        return (float) Math.toDegrees(Math.atan2(((double) f12) / dSqrt, ((double) f11) / dSqrt));
    }

    public static Matrix getExifTransform(int i2, int i8, int i9) {
        Matrix matrix = new Matrix();
        float f4 = i8;
        float f8 = i9;
        RectF rectF = new RectF(0.0f, 0.0f, f4, f8);
        RectF rectF2 = NORMALIZED_RECT;
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        matrix.setRectToRect(rectF, rectF2, scaleToFit);
        switch (i2) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(270.0f);
                rectF = new RectF(0.0f, 0.0f, f8, f4);
                break;
            case 6:
                matrix.postRotate(90.0f);
                rectF = new RectF(0.0f, 0.0f, f8, f4);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(90.0f);
                rectF = new RectF(0.0f, 0.0f, f8, f4);
                break;
            case 8:
                matrix.postRotate(270.0f);
                rectF = new RectF(0.0f, 0.0f, f8, f4);
                break;
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public static Matrix getNormalizedToBuffer(Rect rect) {
        return getNormalizedToBuffer(new RectF(rect));
    }

    public static Matrix getRectToRect(RectF rectF, RectF rectF2, int i2) {
        return getRectToRect(rectF, rectF2, i2, false);
    }

    public static Size getRotatedSize(Rect rect, int i2) {
        return rotateSize(rectToSize(rect), i2);
    }

    public static int getRotationDegrees(Matrix matrix) {
        matrix.getValues(new float[9]);
        return within360((int) Math.round(Math.atan2(r0[3], r0[0]) * 57.29577951308232d));
    }

    public static boolean hasCropping(Rect rect, Size size) {
        return (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) ? false : true;
    }

    public static boolean is90or270(int i2) {
        if (i2 == 90 || i2 == 270) {
            return true;
        }
        if (i2 == 0 || i2 == 180) {
            return false;
        }
        throw new IllegalArgumentException(a1.a.g(i2, "Invalid rotation degrees: "));
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size size, Size size2) {
        return isAspectRatioMatchingWithRoundingError(size, false, size2, false);
    }

    public static boolean isMirrored(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        return calculateSignedAngle(fArr[0], fArr[1], fArr[2], fArr[3]) > 0.0f;
    }

    public static float max(float f4, float f8, float f9, float f10) {
        return Math.max(Math.max(f4, f8), Math.max(f9, f10));
    }

    public static float min(float f4, float f8, float f9, float f10) {
        return Math.min(Math.min(f4, f8), Math.min(f9, f10));
    }

    public static Size rectToSize(Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    public static String rectToString(Rect rect) {
        Locale locale = Locale.US;
        return rect + "(" + rect.width() + "x" + rect.height() + ")";
    }

    public static float[] rectToVertices(RectF rectF) {
        float f4 = rectF.left;
        float f8 = rectF.top;
        float f9 = rectF.right;
        float f10 = rectF.bottom;
        return new float[]{f4, f8, f9, f8, f9, f10, f4, f10};
    }

    public static Size reverseSize(Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    public static SizeF reverseSizeF(SizeF sizeF) {
        return new SizeF(sizeF.getHeight(), sizeF.getWidth());
    }

    public static RectF rotateRect(RectF rectF, int i2) {
        Preconditions.checkArgument(i2 % 90 == 0, "Invalid rotation degrees: " + i2);
        return is90or270(within360(i2)) ? new RectF(0.0f, 0.0f, rectF.height(), rectF.width()) : rectF;
    }

    public static Size rotateSize(Size size, int i2) {
        Preconditions.checkArgument(i2 % 90 == 0, "Invalid rotation degrees: " + i2);
        return is90or270(within360(i2)) ? reverseSize(size) : size;
    }

    public static Rect sizeToRect(Size size) {
        return sizeToRect(size, 0, 0);
    }

    public static RectF sizeToRectF(Size size) {
        return sizeToRectF(size, 0, 0);
    }

    public static float[] sizeToVertices(Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    public static Matrix updateSensorToBufferTransform(Matrix matrix, Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(-rect.left, -rect.top);
        return matrix2;
    }

    public static RectF verticesToRect(float[] fArr) {
        return new RectF(min(fArr[0], fArr[2], fArr[4], fArr[6]), min(fArr[1], fArr[3], fArr[5], fArr[7]), max(fArr[0], fArr[2], fArr[4], fArr[6]), max(fArr[1], fArr[3], fArr[5], fArr[7]));
    }

    public static int within360(int i2) {
        return ((i2 % 360) + 360) % 360;
    }

    public static Matrix getNormalizedToBuffer(RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    public static Matrix getRectToRect(RectF rectF, RectF rectF2, int i2, boolean z2) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate(i2);
        if (z2) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(getNormalizedToBuffer(rectF2));
        return matrix;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size size, boolean z2, Size size2, boolean z7) {
        float width;
        float width2;
        float width3;
        float width4;
        if (z2) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        if (z7) {
            width3 = size2.getWidth() / size2.getHeight();
            width4 = width3;
        } else {
            width3 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
            width4 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
        }
        return width >= width3 && width4 >= width2;
    }

    public static Rect sizeToRect(Size size, int i2, int i8) {
        return new Rect(i2, i8, size.getWidth() + i2, size.getHeight() + i8);
    }

    public static RectF sizeToRectF(Size size, int i2, int i8) {
        return new RectF(i2, i8, size.getWidth() + i2, size.getHeight() + i8);
    }
}
