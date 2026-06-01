package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.workaround.c;
import androidx.privacysandbox.ads.adservices.topics.a;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlideBitmapFactory {
    private static final String TAG = "GlideBitmapFactory";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        private GainmapCopier() {
        }

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmapU = a.u(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmapU.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmapU.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmapU.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmapU.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmapU.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmapU.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmapU.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmapU;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier<Boolean> REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new c(12));
        private static final String TAG = "GainmapWorkaroundCalc";

        private GainmapDecoderWorkaroundStateCalculator() {
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z2 = bitmapCopy == null;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "calculateNeedsGainmapDecodeWorkaround=" + z2);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$static$0() {
            return Boolean.valueOf(calculateNeedsGainmapDecodeWorkaround());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return REQUIRES_GAIN_MAP_FIX.get().booleanValue();
            }
            return false;
        }
    }

    private GlideBitmapFactory() {
    }

    @Nullable
    public static Bitmap decodeByteArray(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(bArr, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    @Nullable
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options) : BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    @Nullable
    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) ? safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options) : BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            boolean zHasJpegMpf = imageReader.hasJpegMpf();
            if (!Log.isLoggable(TAG, 2)) {
                return zHasJpegMpf;
            }
            Log.v(TAG, "isLikelyToContainGainmap=" + zHasJpegMpf);
            return zHasJpegMpf;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 2)) {
                return false;
            }
            Log.v(TAG, "isLikelyToContainGainmap failed", e);
            return false;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream == null) {
                if (bitmapDecodeStream != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapSafeDecodeBitmapWithGainmap;
            }
            try {
                bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeStream);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeStream.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                if (bitmapDecodeByteArray != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapSafeDecodeBitmapWithGainmap;
            }
            try {
                bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeByteArray);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeByteArray.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeByteArray = null;
        }
    }

    @Nullable
    @RequiresApi(34)
    private static Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        Preconditions.checkArgument(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapSafeDecodeBitmapWithGainmap = null;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor == null) {
                if (bitmapDecodeFileDescriptor != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapSafeDecodeBitmapWithGainmap;
            }
            try {
                bitmapSafeDecodeBitmapWithGainmap = safeDecodeBitmapWithGainmap(bitmapDecodeFileDescriptor);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeFileDescriptor.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapSafeDecodeBitmapWithGainmap;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }
}
