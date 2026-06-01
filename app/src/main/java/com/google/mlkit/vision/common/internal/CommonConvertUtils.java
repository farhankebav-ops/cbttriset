package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c2.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzms;
import com.google.android.gms.internal.mlkit_vision_common.zzmu;
import com.google.mlkit.vision.common.InputImage;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class CommonConvertUtils {
    @Nullable
    @KeepForSdk
    public static InputImage convertMlImagetoInputImage(@NonNull a aVar) {
        throw null;
    }

    @KeepForSdk
    public static int convertToAndroidImageFormat(@InputImage.ImageFormat int i2) {
        int i8 = 17;
        if (i2 != 17) {
            i8 = 35;
            if (i2 != 35) {
                i8 = InputImage.IMAGE_FORMAT_YV12;
                if (i2 != 842094169) {
                    return 0;
                }
            }
        }
        return i8;
    }

    @KeepForSdk
    public static int convertToMVRotation(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 90) {
            return 1;
        }
        if (i2 == 180) {
            return 2;
        }
        if (i2 == 270) {
            return 3;
        }
        throw new IllegalArgumentException(a1.a.g(i2, "Invalid rotation: "));
    }

    @KeepForSdk
    public static void transformPointArray(@NonNull Point[] pointArr, @NonNull Matrix matrix) {
        int length = pointArr.length;
        float[] fArr = new float[length + length];
        for (int i2 = 0; i2 < pointArr.length; i2++) {
            Point point = pointArr[i2];
            int i8 = i2 + i2;
            fArr[i8] = point.x;
            fArr[i8 + 1] = point.y;
        }
        matrix.mapPoints(fArr);
        for (int i9 = 0; i9 < pointArr.length; i9++) {
            int i10 = i9 + i9;
            pointArr[i9].set((int) fArr[i10], (int) fArr[i10 + 1]);
        }
    }

    @KeepForSdk
    public static void transformPointF(@NonNull PointF pointF, @NonNull Matrix matrix) {
        float[] fArr = {pointF.x, pointF.y};
        matrix.mapPoints(fArr);
        pointF.set(fArr[0], fArr[1]);
    }

    @KeepForSdk
    public static void transformPointList(@NonNull List<PointF> list, @NonNull Matrix matrix) {
        int size = list.size();
        float[] fArr = new float[size + size];
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i8 = i2 + i2;
            fArr[i8] = list.get(i2).x;
            fArr[i8 + 1] = list.get(i2).y;
        }
        matrix.mapPoints(fArr);
        for (int i9 = 0; i9 < list.size(); i9++) {
            int i10 = i9 + i9;
            list.get(i9).set(fArr[i10], fArr[i10 + 1]);
        }
    }

    @KeepForSdk
    public static void transformRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    private static void zza(int i2, int i8, long j, int i9, int i10, int i11, int i12) {
        zzmu.zzb(zzms.zzb("vision-common"), i2, i8, j, i9, i10, i11, i12);
    }
}
