package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config hardwareBitmapConfig = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                hardwareBitmapConfig = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(hardwareBitmapConfig, true);
        }

        @DoNotInline
        public static Bitmap createBitmapWithSourceColorspace(int i2, int i8, Bitmap bitmap, boolean z2) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z2 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i2, i8, config, bitmap.hasAlpha(), colorSpace);
        }

        @DoNotInline
        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap bitmap, int i2, int i8, @Nullable Rect rect, boolean z2) {
        float f4;
        int i9;
        double dFloor;
        Bitmap bitmapCreateBitmap;
        int i10;
        int i11;
        boolean z7;
        char c7;
        if (i2 <= 0 || i8 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        int i12 = Build.VERSION.SDK_INT;
        Bitmap bitmapCopyBitmapIfHardware = i12 >= 27 ? Api27Impl.copyBitmapIfHardware(bitmap) : bitmap;
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f8 = i2 / iWidth;
        float f9 = i8 / iHeight;
        int i13 = rect != null ? rect.left : 0;
        int i14 = rect != null ? rect.top : 0;
        if (i13 == 0 && i14 == 0 && i2 == bitmap.getWidth() && i8 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapCopyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : bitmapCopyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        if (i12 >= 29) {
            Api29Impl.setPaintBlendMode(paint);
        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (iWidth == i2 && iHeight == i8) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i2, i8, bitmapCopyBitmapIfHardware.getConfig());
            new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapCopyBitmapIfHardware, -i13, -i14, paint);
            return bitmapCreateBitmap2;
        }
        double dLog = Math.log(2.0d);
        if (f8 > 1.0f) {
            f4 = 1.0f;
            i9 = i13;
            dFloor = Math.ceil(Math.log(f8) / dLog);
        } else {
            f4 = 1.0f;
            i9 = i13;
            dFloor = Math.floor(Math.log(f8) / dLog);
        }
        int i15 = (int) dFloor;
        int iCeil = (int) (f9 > f4 ? Math.ceil(Math.log(f9) / dLog) : Math.floor(Math.log(f9) / dLog));
        if (!z2 || i12 < 27 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmapCreateBitmap = null;
            i10 = i9;
            i11 = 0;
        } else {
            Bitmap bitmapCreateBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(i15 > 0 ? sizeAtStep(iWidth, i2, 1, i15) : iWidth, iCeil > 0 ? sizeAtStep(iHeight, i8, 1, iCeil) : iHeight, bitmap, true);
            new Canvas(bitmapCreateBitmapWithSourceColorspace).drawBitmap(bitmapCopyBitmapIfHardware, -i9, -i14, paint);
            Bitmap bitmap2 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmapWithSourceColorspace;
            bitmapCreateBitmap = bitmap2;
            i11 = 1;
            i14 = 0;
            i10 = 0;
        }
        Rect rect2 = new Rect(i10, i14, iWidth, iHeight);
        Rect rect3 = new Rect();
        int i16 = i15;
        int i17 = iCeil;
        while (true) {
            if (i16 == 0 && i17 == 0) {
                break;
            }
            if (i16 < 0) {
                i16++;
            } else if (i16 > 0) {
                i16--;
            }
            if (i17 < 0) {
                i17++;
            } else if (i17 > 0) {
                i17--;
            }
            int i18 = i17;
            int i19 = i11;
            int i20 = i16;
            rect3.set(0, 0, sizeAtStep(iWidth, i2, i16, i15), sizeAtStep(iHeight, i8, i18, iCeil));
            boolean z8 = i20 == 0 && i18 == 0;
            boolean z9 = bitmapCreateBitmap != null && bitmapCreateBitmap.getWidth() == i2 && bitmapCreateBitmap.getHeight() == i8;
            if (bitmapCreateBitmap == null || bitmapCreateBitmap == bitmap) {
                z7 = z8;
            } else {
                if (z2) {
                    z7 = z8;
                    if (Build.VERSION.SDK_INT < 27 || Api27Impl.isAlreadyF16AndLinear(bitmapCreateBitmap)) {
                    }
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                    rect2.set(rect3);
                    Bitmap bitmap3 = bitmapCopyBitmapIfHardware;
                    bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                    bitmapCreateBitmap = bitmap3;
                    i17 = i18;
                    i11 = i19;
                    i16 = i20;
                } else {
                    z7 = z8;
                }
                if (!z7 || (z9 && i19 == 0)) {
                    c7 = 27;
                }
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
                rect2.set(rect3);
                Bitmap bitmap32 = bitmapCopyBitmapIfHardware;
                bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
                bitmapCreateBitmap = bitmap32;
                i17 = i18;
                i11 = i19;
                i16 = i20;
            }
            if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
                bitmapCreateBitmap.recycle();
            }
            int iSizeAtStep = sizeAtStep(iWidth, i2, i20 > 0 ? i19 : i20, i15);
            int iSizeAtStep2 = sizeAtStep(iHeight, i8, i18 > 0 ? i19 : i18, iCeil);
            c7 = 27;
            if (Build.VERSION.SDK_INT >= 27) {
                bitmapCreateBitmap = Api27Impl.createBitmapWithSourceColorspace(iSizeAtStep, iSizeAtStep2, bitmap, z2 && !z7);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iSizeAtStep, iSizeAtStep2, bitmapCopyBitmapIfHardware.getConfig());
            }
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, rect2, rect3, paint);
            rect2.set(rect3);
            Bitmap bitmap322 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmap;
            bitmapCreateBitmap = bitmap322;
            i17 = i18;
            i11 = i19;
            i16 = i20;
        }
        if (bitmapCreateBitmap != bitmap && bitmapCreateBitmap != null) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCopyBitmapIfHardware;
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z2) {
        bitmap.setHasMipMap(z2);
    }

    @VisibleForTesting
    public static int sizeAtStep(int i2, int i8, int i9, int i10) {
        return i9 == 0 ? i8 : i9 > 0 ? i2 * (1 << (i10 - i9)) : i8 << ((-i9) - 1);
    }
}
