package com.bytedance.adsdk.MY.vCE;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import com.bytedance.adsdk.MY.IlO.IlO.oeT;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class vCE {
    private static final ThreadLocal<PathMeasure> IlO = new ThreadLocal<PathMeasure>() { // from class: com.bytedance.adsdk.MY.vCE.vCE.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> MY = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.MY.vCE.vCE.2
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> EO = new ThreadLocal<Path>() { // from class: com.bytedance.adsdk.MY.vCE.vCE.3
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> tV = new ThreadLocal<float[]>() { // from class: com.bytedance.adsdk.MY.vCE.vCE.4
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    private static final float Cc = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int IlO(float f4, float f8, float f9, float f10) {
        int i2 = f4 != 0.0f ? (int) (f4 * 527.0f) : 17;
        if (f8 != 0.0f) {
            i2 = (int) (i2 * 31 * f8);
        }
        if (f9 != 0.0f) {
            i2 = (int) (i2 * 31 * f9);
        }
        return f10 != 0.0f ? (int) (i2 * 31 * f10) : i2;
    }

    public static boolean MY(Matrix matrix) {
        float[] fArr = tV.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static boolean IlO(int i2, int i8, int i9, int i10, int i11, int i12) {
        if (i2 < i10) {
            return false;
        }
        if (i2 > i10) {
            return true;
        }
        if (i8 < i11) {
            return false;
        }
        return i8 > i11 || i9 >= i12;
    }

    public static Path IlO(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f4 = pointF.x + pointF3.x;
            float f8 = pointF.y + pointF3.y;
            float f9 = pointF2.x;
            float f10 = f9 + pointF4.x;
            float f11 = pointF2.y;
            path.cubicTo(f4, f8, f10, f11 + pointF4.y, f9, f11);
            return path;
        }
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    public static void IlO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float IlO(Matrix matrix) {
        float[] fArr = tV.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f4 = Cc;
        fArr[2] = f4;
        fArr[3] = f4;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void IlO(Path path, oeT oet) {
        if (oet == null || oet.vCE()) {
            return;
        }
        IlO(path, ((com.bytedance.adsdk.MY.IlO.MY.tV) oet.EO()).DmF() / 100.0f, ((com.bytedance.adsdk.MY.IlO.MY.tV) oet.tV()).DmF() / 100.0f, ((com.bytedance.adsdk.MY.IlO.MY.tV) oet.Cc()).DmF() / 360.0f);
    }

    public static void IlO(Path path, float f4, float f8, float f9) {
        com.bytedance.adsdk.MY.Cc.IlO("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = IlO.get();
        Path path2 = MY.get();
        Path path3 = EO.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f4 == 1.0f && f8 == 0.0f) {
            com.bytedance.adsdk.MY.Cc.MY("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f8 - f4) - 1.0f) >= 0.01d) {
            float f10 = f4 * length;
            float f11 = f8 * length;
            float f12 = f9 * length;
            float fMin = Math.min(f10, f11) + f12;
            float fMax = Math.max(f10, f11) + f12;
            if (fMin >= length && fMax >= length) {
                fMin = Cc.IlO(fMin, length);
                fMax = Cc.IlO(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = Cc.IlO(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = Cc.IlO(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                com.bytedance.adsdk.MY.Cc.MY("applyTrimPathIfNeeded");
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.bytedance.adsdk.MY.Cc.MY("applyTrimPathIfNeeded");
            return;
        }
        com.bytedance.adsdk.MY.Cc.MY("applyTrimPathIfNeeded");
    }

    public static float IlO() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float IlO(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap IlO(Bitmap bitmap, int i2, int i8) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i8) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i8, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean IlO(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void IlO(Canvas canvas, RectF rectF, Paint paint) {
        IlO(canvas, rectF, paint, 31);
    }

    public static void IlO(Canvas canvas, RectF rectF, Paint paint, int i2) {
        com.bytedance.adsdk.MY.Cc.IlO("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.bytedance.adsdk.MY.Cc.MY("Utils#saveLayer");
    }
}
