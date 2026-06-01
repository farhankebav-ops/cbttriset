package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i2;
        int width = bitmap.getWidth();
        int i8 = point.x;
        return i8 >= 0 && i8 < width && (i2 = point.y) >= 0 && i2 < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i2, int i8, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i8, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i2, i8, config);
    }

    public static final int get(Bitmap bitmap, int i2, int i8) {
        return bitmap.getPixel(i2, i8);
    }

    public static final Bitmap scale(Bitmap bitmap, int i2, int i8, boolean z2) {
        return Bitmap.createScaledBitmap(bitmap, i2, i8, z2);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i8, boolean z2, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            z2 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i2, i8, z2);
    }

    public static final void set(Bitmap bitmap, int i2, int i8, @ColorInt int i9) {
        bitmap.setPixel(i2, i8, i9);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f4 = pointF.x;
        if (f4 < 0.0f || f4 >= bitmap.getWidth()) {
            return false;
        }
        float f8 = pointF.y;
        return f8 >= 0.0f && f8 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i2, int i8, Bitmap.Config config, boolean z2, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i2, i8, config, z2, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i2, int i8, Bitmap.Config config, boolean z2, ColorSpace colorSpace, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i9 & 8) != 0) {
            z2 = true;
        }
        if ((i9 & 16) != 0) {
            ColorSpace.Named unused = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i2, i8, config, z2, colorSpace);
    }
}
