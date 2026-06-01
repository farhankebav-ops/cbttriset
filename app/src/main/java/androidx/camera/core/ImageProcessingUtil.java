package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ImageProcessingUtil {
    public static final String JNI_LIB_NAME = "image_processing_util_jni";
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class NV21ImageProxy extends ForwardingImageProxy {
        private final int mHeight;
        private final ImageProxy.PlaneProxy[] mPlanes;
        private final int mWidth;

        public NV21ImageProxy(ImageProxy imageProxy, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i8, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i9) {
            super(imageProxy);
            this.mPlanes = createPlanes(byteBuffer, byteBuffer2, byteBuffer3, i2);
            this.mWidth = i2;
            this.mHeight = i8;
        }

        private ImageProxy.PlaneProxy[] createPlanes(final ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, final int i2) {
            return new ImageProxy.PlaneProxy[]{new ImageProxy.PlaneProxy() { // from class: androidx.camera.core.ImageProcessingUtil.NV21ImageProxy.1
                @Override // androidx.camera.core.ImageProxy.PlaneProxy
                public ByteBuffer getBuffer() {
                    return byteBuffer;
                }

                @Override // androidx.camera.core.ImageProxy.PlaneProxy
                public int getPixelStride() {
                    return 1;
                }

                @Override // androidx.camera.core.ImageProxy.PlaneProxy
                public int getRowStride() {
                    return i2;
                }
            }, new NV21PlaneProxy(byteBuffer2, i2), new NV21PlaneProxy(byteBuffer3, i2)};
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mWidth;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class NV21PlaneProxy implements ImageProxy.PlaneProxy {
        private final ByteBuffer mByteBuffer;
        private final int mRowStride;

        public NV21PlaneProxy(ByteBuffer byteBuffer, int i2) {
            this.mByteBuffer = byteBuffer;
            this.mRowStride = i2;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public ByteBuffer getBuffer() {
            return this.mByteBuffer;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getPixelStride() {
            return 2;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getRowStride() {
            return this.mRowStride;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary(JNI_LIB_NAME);
    }

    private ImageProcessingUtil() {
    }

    public static boolean applyPixelShiftForYUV(ImageProxy imageProxy) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return false;
        }
        if (applyPixelShiftInternal(imageProxy) != Result.ERROR_CONVERSION) {
            return true;
        }
        Logger.e(TAG, "One pixel shift for YUV failure");
        return false;
    }

    private static Result applyPixelShiftInternal(ImageProxy imageProxy) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        return nativeShiftPixel(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, width, height, pixelStride, pixelStride2, pixelStride2) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static ImageProxy convertJpegBytesToImage(ImageReaderProxy imageReaderProxy, byte[] bArr) {
        Preconditions.checkArgument(imageReaderProxy.getImageFormat() == 256);
        Preconditions.checkNotNull(bArr);
        Surface surface = imageReaderProxy.getSurface();
        Preconditions.checkNotNull(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            Logger.e(TAG, "Failed to enqueue JPEG image.");
            return null;
        }
        ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (imageProxyAcquireLatestImage == null) {
            Logger.e(TAG, "Failed to get acquire JPEG image.");
        }
        return imageProxyAcquireLatestImage;
    }

    public static Bitmap convertYUVToBitmap(ImageProxy imageProxy) {
        if (imageProxy.getFormat() != 35) {
            throw new IllegalArgumentException("Input image format must be YUV_420_888");
        }
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
        if (nativeConvertAndroid420ToBitmap(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, bitmapCreateBitmap, bitmapCreateBitmap.getRowBytes(), width, height) == 0) {
            return bitmapCreateBitmap;
        }
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    }

    public static ImageProxy convertYUVToRGB(ImageProxy imageProxy, ImageReaderProxy imageReaderProxy, ByteBuffer byteBuffer, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2, boolean z2) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for YUV to RGB");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!isSupportedRotationDegrees(i2)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (convertYUVToRGBInternal(imageProxy, imageReaderProxy.getSurface(), byteBuffer, i2, z2) == Result.ERROR_CONVERSION) {
            Logger.e(TAG, "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            Locale locale = Locale.US;
            Logger.d(TAG, "Image processing performance profiling, duration: [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "], image count: " + sImageCount);
            sImageCount = sImageCount + 1;
        }
        ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (imageProxyAcquireLatestImage == null) {
            Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
            return null;
        }
        SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxyAcquireLatestImage);
        singleCloseImageProxy.addOnImageCloseListener(new z(imageProxyAcquireLatestImage, imageProxy, 0));
        return singleCloseImageProxy;
    }

    private static Result convertYUVToRGBInternal(ImageProxy imageProxy, Surface surface, ByteBuffer byteBuffer, int i2, boolean z2) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[0].getPixelStride();
        int pixelStride2 = imageProxy.getPlanes()[1].getPixelStride();
        return nativeConvertAndroid420ToABGR(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, pixelStride2, surface, byteBuffer, width, height, z2 ? pixelStride : 0, z2 ? pixelStride2 : 0, z2 ? pixelStride2 : 0, i2) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(Image image, @IntRange(from = 1, to = 100) int i2, int i8, Surface surface) {
        return convertYuvToJpegBytesIntoSurface(new AndroidImageProxy(image), i2, i8, surface);
    }

    public static void copyBitmapToByteBuffer(Bitmap bitmap, ByteBuffer byteBuffer, int i2) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i2, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void copyByteBufferToBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i2) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i2, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    public static boolean isNV21FormatImage(ImageProxy imageProxy) {
        return imageProxy.getPlanes().length == 3 && imageProxy.getPlanes()[1].getPixelStride() == 2 && nativeGetYUVImageVUOff(imageProxy.getPlanes()[2].getBuffer(), imageProxy.getPlanes()[1].getBuffer()) == -1;
    }

    private static boolean isSupportedRotationDegrees(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2) {
        return i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270;
    }

    private static boolean isSupportedYUVFormat(ImageProxy imageProxy) {
        return imageProxy.getFormat() == 35 && imageProxy.getPlanes().length == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertYUVToRGB$0(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$rotateYUV$1(ImageProxy imageProxy, ImageProxy imageProxy2, ImageProxy imageProxy3) {
        if (imageProxy == null || imageProxy2 == null) {
            return;
        }
        imageProxy2.close();
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, int i10, int i11, Surface surface, ByteBuffer byteBuffer4, int i12, int i13, int i14, int i15, int i16, int i17);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, int i10, int i11, Bitmap bitmap, int i12, int i13, int i14);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i2, int i8, int i9, int i10, boolean z2);

    public static native int nativeGetYUVImageVUOff(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public static native ByteBuffer nativeNewDirectByteBuffer(ByteBuffer byteBuffer, int i2, int i8);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, int i10, ByteBuffer byteBuffer4, int i11, int i12, ByteBuffer byteBuffer5, int i13, int i14, ByteBuffer byteBuffer6, int i15, int i16, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i17, int i18, int i19);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);

    public static ImageProxy rotateYUV(ImageProxy imageProxy, ImageReaderProxy imageReaderProxy, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2) {
        ImageProxy imageProxy2;
        Result resultRotateYUVInternal;
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for rotate YUV");
            return null;
        }
        if (!isSupportedRotationDegrees(i2)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        Result result = Result.ERROR_CONVERSION;
        if (i2 > 0) {
            imageProxy2 = imageProxy;
            resultRotateYUVInternal = rotateYUVInternal(imageProxy2, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i2);
        } else {
            imageProxy2 = imageProxy;
            resultRotateYUVInternal = result;
        }
        if (resultRotateYUVInternal == result) {
            Logger.e(TAG, "rotate YUV failure");
            return null;
        }
        ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
        if (imageProxyAcquireLatestImage == null) {
            Logger.e(TAG, "YUV rotation acquireLatestImage failure");
            return null;
        }
        SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxyAcquireLatestImage);
        singleCloseImageProxy.addOnImageCloseListener(new z(imageProxyAcquireLatestImage, imageProxy2, 1));
        return singleCloseImageProxy;
    }

    public static ImageProxy rotateYUVAndConvertToNV21(ImageProxy imageProxy, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, ByteBuffer byteBuffer5, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2) {
        if (!isSupportedYUVFormat(imageProxy)) {
            Logger.e(TAG, "Unsupported format for rotate YUV");
            return null;
        }
        if (!isSupportedRotationDegrees(i2)) {
            Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        if (i2 == 0 && isNV21FormatImage(imageProxy)) {
            return null;
        }
        int i8 = i2 % 180;
        int width = i8 == 0 ? imageProxy.getWidth() : imageProxy.getHeight();
        int height = i8 == 0 ? imageProxy.getHeight() : imageProxy.getWidth();
        ByteBuffer byteBufferNativeNewDirectByteBuffer = nativeNewDirectByteBuffer(byteBuffer5, 1, byteBuffer5.capacity());
        int i9 = height;
        if (nativeRotateYUV(imageProxy.getPlanes()[0].getBuffer(), imageProxy.getPlanes()[0].getRowStride(), imageProxy.getPlanes()[1].getBuffer(), imageProxy.getPlanes()[1].getRowStride(), imageProxy.getPlanes()[2].getBuffer(), imageProxy.getPlanes()[2].getRowStride(), imageProxy.getPlanes()[2].getPixelStride(), byteBuffer4, width, 1, byteBufferNativeNewDirectByteBuffer, width, 2, byteBuffer5, width, 2, byteBuffer, byteBuffer2, byteBuffer3, imageProxy.getWidth(), imageProxy.getHeight(), i2) == 0) {
            return new SingleCloseImageProxy(new NV21ImageProxy(imageProxy, byteBuffer4, byteBufferNativeNewDirectByteBuffer, byteBuffer5, width, i9, i2));
        }
        Logger.e(TAG, "rotate YUV failure");
        return null;
    }

    @RequiresApi(23)
    private static Result rotateYUVInternal(ImageProxy imageProxy, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        int width = imageProxy.getWidth();
        int height = imageProxy.getHeight();
        int rowStride = imageProxy.getPlanes()[0].getRowStride();
        int rowStride2 = imageProxy.getPlanes()[1].getRowStride();
        int rowStride3 = imageProxy.getPlanes()[2].getRowStride();
        int pixelStride = imageProxy.getPlanes()[1].getPixelStride();
        Image imageDequeueInputImage = ImageWriterCompat.dequeueInputImage(imageWriter);
        if (imageDequeueInputImage == null) {
            return Result.ERROR_CONVERSION;
        }
        if (nativeRotateYUV(imageProxy.getPlanes()[0].getBuffer(), rowStride, imageProxy.getPlanes()[1].getBuffer(), rowStride2, imageProxy.getPlanes()[2].getBuffer(), rowStride3, pixelStride, imageDequeueInputImage.getPlanes()[0].getBuffer(), imageDequeueInputImage.getPlanes()[0].getRowStride(), imageDequeueInputImage.getPlanes()[0].getPixelStride(), imageDequeueInputImage.getPlanes()[1].getBuffer(), imageDequeueInputImage.getPlanes()[1].getRowStride(), imageDequeueInputImage.getPlanes()[1].getPixelStride(), imageDequeueInputImage.getPlanes()[2].getBuffer(), imageDequeueInputImage.getPlanes()[2].getRowStride(), imageDequeueInputImage.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i2) != 0) {
            return Result.ERROR_CONVERSION;
        }
        ImageWriterCompat.queueInputImage(imageWriter, imageDequeueInputImage);
        return Result.SUCCESS;
    }

    public static boolean writeJpegBytesToSurface(Surface surface, byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(surface);
        if (nativeWriteJpegToSurface(bArr, surface) == 0) {
            return true;
        }
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return false;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(ImageProxy imageProxy, @IntRange(from = 1, to = 100) int i2, int i8, Surface surface) {
        try {
            return writeJpegBytesToSurface(surface, ImageUtil.yuvImageToJpegByteArray(imageProxy, null, i2, i8));
        } catch (ImageUtil.CodecFailedException e) {
            Logger.e(TAG, "Failed to encode YUV to JPEG", e);
            return false;
        }
    }
}
