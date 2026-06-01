package com.bytedance.adsdk.MY;

import a1.a;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class zPa implements Interpolator {
    private final float[] IlO;
    private final float[] MY;

    public zPa(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = (int) (length / 0.002f);
        int i8 = i2 + 1;
        this.IlO = new float[i8];
        this.MY = new float[i8];
        float[] fArr = new float[2];
        for (int i9 = 0; i9 < i8; i9++) {
            pathMeasure.getPosTan((i9 * length) / i2, fArr, null);
            this.IlO[i9] = fArr[0];
            this.MY[i9] = fArr[1];
        }
    }

    private static Path IlO(float f4, float f8, float f9, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f8, f9, f10, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        int length = this.IlO.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i8 = (i2 + length) / 2;
            if (f4 < this.IlO[i8]) {
                length = i8;
            } else {
                i2 = i8;
            }
        }
        float[] fArr = this.IlO;
        float f8 = fArr[length];
        float f9 = fArr[i2];
        float f10 = f8 - f9;
        if (f10 == 0.0f) {
            return this.MY[i2];
        }
        float f11 = (f4 - f9) / f10;
        float[] fArr2 = this.MY;
        float f12 = fArr2[i2];
        return a.a(fArr2[length], f12, f11, f12);
    }

    public zPa(float f4, float f8, float f9, float f10) {
        this(IlO(f4, f8, f9, f10));
    }
}
