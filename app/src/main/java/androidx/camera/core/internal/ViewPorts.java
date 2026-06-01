package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.annotation.IntRange;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ViewPorts {
    private ViewPorts() {
    }

    public static Map<UseCase, Rect> calculateViewPortRects(Rect rect, boolean z2, Rational rational, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2, int i8, int i9, Map<UseCase, StreamSpec> map) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap map2 = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry<UseCase, StreamSpec> entry : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, entry.getValue().getResolution().getWidth(), entry.getValue().getResolution().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            map2.put(entry.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF scaledRect = getScaledRect(rectF2, ImageUtil.getRotatedAspectRatio(i2, rational), i8, z2, i9, i2);
        HashMap map3 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry2 : map2.entrySet()) {
            ((Matrix) entry2.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, scaledRect);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            map3.put((UseCase) entry2.getKey(), rect2);
        }
        return map3;
    }

    private static RectF correctStartOrEnd(boolean z2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2, RectF rectF, RectF rectF2) {
        boolean z7 = false;
        boolean z8 = i2 == 0 && !z2;
        boolean z9 = i2 == 90 && z2;
        if (z8 || z9) {
            return rectF2;
        }
        boolean z10 = i2 == 0 && z2;
        boolean z11 = i2 == 270 && !z2;
        if (z10 || z11) {
            return flipHorizontally(rectF2, rectF.centerX());
        }
        boolean z12 = i2 == 90 && !z2;
        boolean z13 = i2 == 180 && z2;
        if (z12 || z13) {
            return flipVertically(rectF2, rectF.centerY());
        }
        boolean z14 = i2 == 180 && !z2;
        if (i2 == 270 && z2) {
            z7 = true;
        }
        if (z14 || z7) {
            return flipHorizontally(flipVertically(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z2 + " rotation " + i2);
    }

    private static RectF flipHorizontally(RectF rectF, float f4) {
        return new RectF(flipX(rectF.right, f4), rectF.top, flipX(rectF.left, f4), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f4) {
        return new RectF(rectF.left, flipY(rectF.bottom, f4), rectF.right, flipY(rectF.top, f4));
    }

    private static float flipX(float f4, float f8) {
        return (f8 + f8) - f4;
    }

    private static float flipY(float f4, float f8) {
        return (f8 + f8) - f4;
    }

    public static RectF getScaledRect(RectF rectF, Rational rational, int i2, boolean z2, int i8, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i9) {
        if (i2 == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, rational.getNumerator(), rational.getDenominator());
        if (i2 == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i2 == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException(a1.a.g(i2, "Unexpected scale type: "));
            }
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return correctStartOrEnd(shouldMirrorStartAndEnd(z2, i8), i9, rectF, rectF3);
    }

    private static boolean shouldMirrorStartAndEnd(boolean z2, int i2) {
        return z2 ^ (i2 == 1);
    }
}
