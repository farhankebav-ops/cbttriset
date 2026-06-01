package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class ImageConvertUtils {
    private static final ImageConvertUtils zza = new ImageConvertUtils();

    private ImageConvertUtils() {
    }

    @NonNull
    @KeepForSdk
    public static ByteBuffer bufferWithBackingArray(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return byteBuffer;
        }
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return ByteBuffer.wrap(bArr);
    }

    @NonNull
    @KeepForSdk
    public static ImageConvertUtils getInstance() {
        return zza;
    }

    @NonNull
    @KeepForSdk
    public static Bitmap yv12ToBitmap(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9) throws MlKitException {
        byte[] bArrZzb = zzb(yv12ToNv21Buffer(byteBuffer, true).array(), i2, i8);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrZzb, 0, bArrZzb.length);
        return zza(bitmapDecodeByteArray, i9, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public static ByteBuffer yv12ToNv21Buffer(@NonNull ByteBuffer byteBuffer, boolean z2) {
        int i2;
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        int i8 = iLimit / 6;
        ByteBuffer byteBufferAllocate = z2 ? ByteBuffer.allocate(iLimit) : ByteBuffer.allocateDirect(iLimit);
        int i9 = 0;
        while (true) {
            i2 = i8 * 4;
            if (i9 >= i2) {
                break;
            }
            byteBufferAllocate.put(i9, byteBuffer.get(i9));
            i9++;
        }
        for (int i10 = 0; i10 < i8 + i8; i10++) {
            byteBufferAllocate.put(i2 + i10, byteBuffer.get((i10 / 2) + ((i10 % 2) * i8) + i2));
        }
        return byteBufferAllocate;
    }

    @NonNull
    public static Bitmap zza(@NonNull Bitmap bitmap, int i2, int i8, int i9) {
        if (i2 == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i8, i9);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, i8, i9, matrix, true);
    }

    private static byte[] zzb(@NonNull byte[] bArr, int i2, int i8) throws MlKitException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i2, i8, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i2, i8), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e) {
            Log.w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
            throw new MlKitException("Image conversion error from NV21 format", 13, e);
        }
    }

    private static final void zzc(Image.Plane plane, int i2, int i8, byte[] bArr, int i9, int i10) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int rowStride = ((plane.getRowStride() + buffer.limit()) - 1) / plane.getRowStride();
        if (rowStride == 0) {
            return;
        }
        int i11 = i2 / (i8 / rowStride);
        int rowStride2 = 0;
        for (int i12 = 0; i12 < rowStride; i12++) {
            int pixelStride = rowStride2;
            for (int i13 = 0; i13 < i11; i13++) {
                bArr[i9] = buffer.get(pixelStride);
                i9 += i10;
                pixelStride += plane.getPixelStride();
            }
            rowStride2 += plane.getRowStride();
        }
    }

    @NonNull
    @KeepForSdk
    public byte[] byteBufferToByteArray(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer cloneByteBuffer(@NonNull ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferAllocateDirect = byteBuffer.isDirect() ? ByteBuffer.allocateDirect(iCapacity) : ByteBuffer.allocate(iCapacity);
        byteBufferAllocateDirect.limit(byteBuffer.limit());
        byteBufferAllocateDirect.put((ByteBuffer) byteBuffer.rewind());
        byteBufferAllocateDirect.position(iPosition);
        byteBuffer.position(iPosition);
        return byteBufferAllocateDirect;
    }

    @NonNull
    @KeepForSdk
    public Bitmap convertJpegToUpRightBitmap(@NonNull Image image, int i2) {
        Preconditions.checkArgument(image.getFormat() == 256, "Only JPEG is supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.get(bArr);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
        return zza(bitmapDecodeByteArray, i2, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer convertToNv21Buffer(@NonNull InputImage inputImage, boolean z2) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format == 17) {
                return z2 ? bufferWithBackingArray((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())) : (ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer());
            }
            if (format == 35) {
                return yuv420ThreePlanesToNV21((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight());
            }
            if (format == 842094169) {
                return yv12ToNv21Buffer((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), z2);
            }
            throw new MlKitException("Unsupported image format", 13);
        }
        Bitmap bitmapCopy = (Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal());
        if (Build.VERSION.SDK_INT >= 26 && bitmapCopy.getConfig() == Bitmap.Config.HARDWARE) {
            bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
        }
        Bitmap bitmap = bitmapCopy;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (int) Math.ceil(((double) height) / 2.0d);
        int iCeil2 = ((iCeil + iCeil) * ((int) Math.ceil(((double) width) / 2.0d))) + i2;
        ByteBuffer byteBufferAllocate = z2 ? ByteBuffer.allocate(iCeil2) : ByteBuffer.allocateDirect(iCeil2);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < height; i10++) {
            int i11 = 0;
            while (i11 < width) {
                int i12 = iArr[i9];
                int i13 = i12 >> 16;
                int i14 = i12 >> 8;
                int i15 = i12 & 255;
                int i16 = i8 + 1;
                int i17 = i13 & 255;
                int i18 = i14 & 255;
                byteBufferAllocate.put(i8, (byte) Math.min(255, ((((i15 * 25) + ((i18 * Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE) + (i17 * 66))) + 128) >> 8) + 16));
                if (i10 % 2 == 0 && i9 % 2 == 0) {
                    int i19 = ((((i17 * 112) - (i18 * 94)) - (i15 * 18)) + 128) >> 8;
                    int i20 = (((((i17 * (-38)) - (i18 * 74)) + (i15 * 112)) + 128) >> 8) + 128;
                    int i21 = i2 + 1;
                    byteBufferAllocate.put(i2, (byte) Math.min(255, i19 + 128));
                    i2 += 2;
                    byteBufferAllocate.put(i21, (byte) Math.min(255, i20));
                }
                i9++;
                i11++;
                i8 = i16;
            }
        }
        return byteBufferAllocate;
    }

    @NonNull
    @KeepForSdk
    public Bitmap convertToUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return zza((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        if (format == 17) {
            return nv21ToBitmap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 35) {
            return nv21ToBitmap(yuv420ThreePlanesToNV21((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 842094169) {
            return yv12ToBitmap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        throw new MlKitException("Unsupported image format", 13);
    }

    @NonNull
    @KeepForSdk
    public Bitmap getUpRightBitmap(@NonNull InputImage inputImage) throws MlKitException {
        Bitmap bitmapInternal = inputImage.getBitmapInternal();
        return bitmapInternal != null ? zza(bitmapInternal, inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight()) : convertToUpRightBitmap(inputImage);
    }

    @NonNull
    @KeepForSdk
    public Bitmap nv21ToBitmap(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9) throws MlKitException {
        byte[] bArrZzb = zzb(byteBufferToByteArray(byteBuffer), i2, i8);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrZzb, 0, bArrZzb.length);
        return zza(bitmapDecodeByteArray, i9, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer yuv420ThreePlanesToNV21(@NonNull Image.Plane[] planeArr, int i2, int i8) {
        int i9 = i2 * i8;
        int i10 = i9 / 4;
        byte[] bArr = new byte[i10 + i10 + i9];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i11 = (i9 + i9) / 4;
        boolean z2 = buffer2.remaining() == i11 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z2) {
            planeArr[0].getBuffer().get(bArr, 0, i9);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i9, 1);
            buffer3.get(bArr, i9 + 1, i11 - 1);
        } else {
            zzc(planeArr[0], i2, i8, bArr, 0, 1);
            zzc(planeArr[1], i2, i8, bArr, i9 + 1, 2);
            zzc(planeArr[2], i2, i8, bArr, i9, 2);
        }
        return ByteBuffer.wrap(bArr);
    }
}
