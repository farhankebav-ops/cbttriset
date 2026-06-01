package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.processing.util.a;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.ironsource.C2300e4;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    private static final DecodeCallbacks EMPTY_CALLBACKS;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onObtainBounds() {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
            }
        };
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d8) {
        int densityMultiplier = getDensityMultiplier(d8);
        int iRound = round(((double) densityMultiplier) * d8);
        return round((d8 / ((double) (iRound / densityMultiplier))) * ((double) iRound));
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z2, boolean z7, BitmapFactory.Options options, int i2, int i8) {
        boolean zHasAlpha;
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i2, i8, options, z2, z7)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = imageReader.getImageType().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i8, int i9, int i10, int i11, BitmapFactory.Options options) throws IOException {
        int i12;
        int i13;
        int i14;
        int i15;
        int iFloor;
        double dFloor;
        int iRound;
        if (i8 <= 0 || i9 <= 0) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i10 + "x" + i11 + C2300e4.i.e);
                return;
            }
            return;
        }
        if (isRotationRequired(i2)) {
            i13 = i8;
            i12 = i9;
        } else {
            i12 = i8;
            i13 = i9;
        }
        float scaleFactor = downsampleStrategy.getScaleFactor(i12, i13, i10, i11);
        if (scaleFactor <= 0.0f) {
            StringBuilder sb = new StringBuilder("Cannot scale with factor: ");
            sb.append(scaleFactor);
            sb.append(" from: ");
            sb.append(downsampleStrategy);
            sb.append(", source: [");
            a.w(i8, i9, "x", "], target: [", sb);
            sb.append(i10);
            sb.append("x");
            sb.append(i11);
            sb.append(C2300e4.i.e);
            throw new IllegalArgumentException(sb.toString());
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i12, i13, i10, i11);
        if (sampleSizeRounding == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f4 = i12;
        float f8 = i13;
        int i16 = i12;
        int i17 = i13;
        int iRound2 = i16 / round(scaleFactor * f4);
        int iRound3 = i17 / round(scaleFactor * f8);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = sampleSizeRounding == sampleSizeRounding2 ? Math.max(iRound2, iRound3) : Math.min(iRound2, iRound3);
        int i18 = Build.VERSION.SDK_INT;
        int i19 = iMax;
        if (i18 > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(i19));
            i14 = (sampleSizeRounding != sampleSizeRounding2 || ((float) iMax2) >= 1.0f / scaleFactor) ? iMax2 : iMax2 << 1;
        } else {
            i14 = 1;
        }
        options.inSampleSize = i14;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i14, 8);
            i15 = 0;
            iFloor = (int) Math.ceil(f4 / fMin);
            iRound = (int) Math.ceil(f8 / fMin);
            int i20 = i14 / 8;
            if (i20 > 0) {
                iFloor /= i20;
                iRound /= i20;
            }
        } else {
            i15 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f9 = i14;
                iFloor = (int) Math.floor(f4 / f9);
                dFloor = Math.floor(f8 / f9);
            } else if (imageType.isWebp()) {
                if (i18 >= 24) {
                    float f10 = i14;
                    iFloor = Math.round(f4 / f10);
                    iRound = Math.round(f8 / f10);
                } else {
                    float f11 = i14;
                    iFloor = (int) Math.floor(f4 / f11);
                    dFloor = Math.floor(f8 / f11);
                }
            } else if (i16 % i14 == 0 && i17 % i14 == 0) {
                iFloor = i16 / i14;
                iRound = i17 / i14;
            } else {
                int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, bitmapPool);
                iFloor = dimensions[0];
                iRound = dimensions[1];
            }
            iRound = (int) dFloor;
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(iFloor, iRound, i10, i11);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = getDensityMultiplier(scaleFactor2);
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = i15;
            options.inDensity = i15;
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sbW = a1.a.w(i8, "Calculate scaling, source: [", "x", i9, "], degreesToRotate: ");
            a.w(i2, i10, ", target: [", "x", sbW);
            a.w(i11, iFloor, "], power of two scaled: [", "x", sbW);
            sbW.append(iRound);
            sbW.append("], exact scale factor: ");
            sbW.append(scaleFactor);
            sbW.append(", power of 2 sample size: ");
            sbW.append(i14);
            sbW.append(", adjusted scale factor: ");
            sbW.append(scaleFactor2);
            sbW.append(", target density: ");
            sbW.append(options.inTargetDensity);
            sbW.append(", density: ");
            sbW.append(options.inDensity);
            Log.v(TAG, sbW.toString());
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z2, int i2, int i8, boolean z7, DecodeCallbacks decodeCallbacks) throws IOException {
        int i9;
        String str;
        String str2;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, this.bitmapPool);
        int i10 = dimensions[0];
        int i11 = dimensions[1];
        String str3 = options.outMimeType;
        boolean z8 = (i10 == -1 || i11 == -1) ? false : z2;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean zIsExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i12 = i2;
        if (i12 != Integer.MIN_VALUE) {
            i9 = i8;
        } else if (isRotationRequired(exifOrientationDegrees)) {
            i9 = i8;
            i12 = i11;
        } else {
            i9 = i8;
            i12 = i10;
        }
        if (i9 == Integer.MIN_VALUE) {
            i9 = isRotationRequired(exifOrientationDegrees) ? i10 : i11;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i10, i11, i12, i9, options);
        int i13 = i12;
        int i14 = i9;
        calculateConfig(imageReader, decodeFormat, z8, zIsExifOrientationRequired, options, i13, i14);
        int i15 = Build.VERSION.SDK_INT;
        if (shouldUsePool(imageType)) {
            if (i10 < 0 || i11 < 0 || !z7) {
                float f4 = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i16 = options.inSampleSize;
                float f8 = i16;
                int iCeil = (int) Math.ceil(i10 / f8);
                int iCeil2 = (int) Math.ceil(i11 / f8);
                int iRound = Math.round(iCeil * f4);
                int iRound2 = Math.round(iCeil2 * f4);
                str = TAG;
                if (Log.isLoggable(str, 2)) {
                    str2 = str3;
                    StringBuilder sbW = a1.a.w(iRound, "Calculated target [", "x", iRound2, "] for source [");
                    a.w(i10, i11, "x", "], sampleSize: ", sbW);
                    sbW.append(i16);
                    sbW.append(", targetDensity: ");
                    sbW.append(options.inTargetDensity);
                    sbW.append(", density: ");
                    sbW.append(options.inDensity);
                    sbW.append(", density multiplier: ");
                    sbW.append(f4);
                    Log.v(str, sbW.toString());
                } else {
                    str2 = str3;
                }
                i13 = iRound;
                i14 = iRound2;
            } else {
                str = TAG;
                str2 = str3;
            }
            if (i13 > 0 && i14 > 0) {
                setInBitmap(options, this.bitmapPool, i13, i14);
            }
        } else {
            str = TAG;
            str2 = str3;
        }
        if (preferredColorSpace != null) {
            if (i15 >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (i15 >= 26) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapDecodeStream = decodeStream(imageReader, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, bitmapDecodeStream);
        if (Log.isLoggable(str, 2)) {
            logDecode(i10, i11, str2, options, bitmapDecodeStream, i2, i8, logTime);
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        bitmapDecodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap bitmapRotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, bitmapDecodeStream, imageOrientation);
        if (!bitmapDecodeStream.equals(bitmapRotateImageExif)) {
            this.bitmapPool.put(bitmapDecodeStream);
        }
        return bitmapRotateImageExif;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.onObtainBounds()
            r5.stopGrowingBuffers()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            android.graphics.Bitmap r5 = r5.decodeBitmap(r6)     // Catch: java.lang.IllegalArgumentException -> L25 java.lang.Throwable -> L47
        L1d:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L25:
            r4 = move-exception
            java.io.IOException r1 = newIoExceptionForInBitmapAssertion(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L47
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L36
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L47
        L36:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L46
            r8.put(r0)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            r0 = 0
            r6.inBitmap = r0     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            goto L1d
        L45:
            throw r1     // Catch: java.lang.Throwable -> L47
        L46:
            throw r1     // Catch: java.lang.Throwable -> L47
        L47:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @Nullable
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return C2300e4.i.f8403d + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            resetOptions(optionsPoll);
        }
        return optionsPoll;
    }

    private static int getDensityMultiplier(double d8) {
        if (d8 > 1.0d) {
            d8 = 1.0d / d8;
        }
        return (int) Math.round(d8 * 2.147483647E9d);
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i2;
        int i8 = options.inTargetDensity;
        return i8 > 0 && (i2 = options.inDensity) > 0 && i8 != i2;
    }

    private static void logDecode(int i2, int i8, String str, BitmapFactory.Options options, Bitmap bitmap, int i9, int i10, long j) {
        Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i2 + "x" + i8 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i9 + "x" + i10 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i2, int i8, String str, BitmapFactory.Options options) {
        StringBuilder sbW = a1.a.w(i2, "Exception decoding bitmap, outWidth: ", ", outHeight: ", i8, ", outMimeType: ");
        sbW.append(str);
        sbW.append(", inBitmap: ");
        sbW.append(getInBitmapString(options));
        return new IOException(sbW.toString(), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d8) {
        return (int) (d8 + 0.5d);
    }

    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i8) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i2, i8, config);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i2, int i8, Options options) throws IOException {
        return decode(inputStream, i2, i8, options, EMPTY_CALLBACKS);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i2, int i8, Options options) throws IOException {
        return decode(new ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i2, i8, options, EMPTY_CALLBACKS);
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i2, int i8, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode(new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i2, i8, options, decodeCallbacks);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    @VisibleForTesting
    public void decode(byte[] bArr, int i2, int i8, Options options) throws IOException {
        decode(new ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i2, i8, options, EMPTY_CALLBACKS);
    }

    @VisibleForTesting
    public void decode(File file, int i2, int i8, Options options) throws IOException {
        decode(new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i2, i8, options, EMPTY_CALLBACKS);
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i2, int i8, Options options) throws IOException {
        return decode(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i2, i8, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i2, int i8, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean zBooleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i2, i8, zBooleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }
}
