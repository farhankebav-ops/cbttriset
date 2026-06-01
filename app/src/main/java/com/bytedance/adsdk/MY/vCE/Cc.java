package com.bytedance.adsdk.MY.vCE;

import a1.a;
import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.MY.EO.MY.bWL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static final PointF IlO = new PointF();

    public static boolean EO(float f4, float f8, float f9) {
        return f4 >= f8 && f4 <= f9;
    }

    public static int IlO(int i2, int i8, float f4) {
        return (int) ((f4 * (i8 - i2)) + i2);
    }

    private static int MY(int i2, int i8) {
        int i9 = i2 / i8;
        return (((i2 ^ i8) >= 0) || i2 % i8 == 0) ? i9 : i9 - 1;
    }

    public static PointF IlO(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void IlO(bWL bwl, Path path) {
        Path path2;
        path.reset();
        PointF pointFIlO = bwl.IlO();
        path.moveTo(pointFIlO.x, pointFIlO.y);
        IlO.set(pointFIlO.x, pointFIlO.y);
        int i2 = 0;
        while (i2 < bwl.EO().size()) {
            com.bytedance.adsdk.MY.EO.IlO ilO = bwl.EO().get(i2);
            PointF pointFIlO2 = ilO.IlO();
            PointF pointFMY = ilO.MY();
            PointF pointFEO = ilO.EO();
            PointF pointF = IlO;
            if (pointFIlO2.equals(pointF) && pointFMY.equals(pointFEO)) {
                path.lineTo(pointFEO.x, pointFEO.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(pointFIlO2.x, pointFIlO2.y, pointFMY.x, pointFMY.y, pointFEO.x, pointFEO.y);
            }
            pointF.set(pointFEO.x, pointFEO.y);
            i2++;
            path = path2;
        }
        Path path3 = path;
        if (bwl.MY()) {
            path3.close();
        }
    }

    public static float MY(float f4, float f8, float f9) {
        return Math.max(f8, Math.min(f9, f4));
    }

    public static float IlO(float f4, float f8, float f9) {
        return a.a(f8, f4, f9, f4);
    }

    public static int IlO(float f4, float f8) {
        return IlO((int) f4, (int) f8);
    }

    private static int IlO(int i2, int i8) {
        return i2 - (i8 * MY(i2, i8));
    }

    public static int IlO(int i2, int i8, int i9) {
        return Math.max(i8, Math.min(i9, i2));
    }
}
