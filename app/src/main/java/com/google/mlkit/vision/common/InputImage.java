package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzms;
import com.google.android.gms.internal.mlkit_vision_common.zzmu;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class InputImage implements MLTaskInput {

    @KeepForSdk
    public static final int IMAGE_FORMAT_BITMAP = -1;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;

    @Nullable
    private volatile Bitmap zza;

    @Nullable
    private volatile ByteBuffer zzb;

    @Nullable
    private volatile zzb zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;

    @ImageFormat
    private final int zzg;

    @Nullable
    private final Matrix zzh;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ImageFormat {
    }

    private InputImage(@NonNull Bitmap bitmap, int i2) {
        this.zza = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        zza(i2);
        this.zzf = i2;
        this.zzg = -1;
        this.zzh = null;
    }

    @NonNull
    public static InputImage fromBitmap(@NonNull Bitmap bitmap, int i2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i2);
        zzc(-1, 1, jElapsedRealtime, bitmap.getHeight(), bitmap.getWidth(), bitmap.getAllocationByteCount(), i2);
        return inputImage;
    }

    @NonNull
    public static InputImage fromByteArray(@NonNull byte[] bArr, int i2, int i8, int i9, @ImageFormat int i10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), i2, i8, i9, i10);
        zzc(i10, 2, jElapsedRealtime, i8, i2, bArr.length, i9);
        return inputImage;
    }

    @NonNull
    public static InputImage fromByteBuffer(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9, @ImageFormat int i10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i2, i8, i9, i10);
        zzc(i10, 3, jElapsedRealtime, i8, i2, byteBuffer.limit(), i9);
        return inputImage;
    }

    @NonNull
    public static InputImage fromFilePath(@NonNull Context context, @NonNull Uri uri) throws IOException {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Bitmap bitmapZza = ImageUtils.getInstance().zza(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(bitmapZza, 0);
        zzc(-1, 4, jElapsedRealtime, bitmapZza.getHeight(), bitmapZza.getWidth(), bitmapZza.getAllocationByteCount(), 0);
        return inputImage;
    }

    @NonNull
    public static InputImage fromMediaImage(@NonNull Image image, int i2) {
        return zzb(image, i2, null);
    }

    private static int zza(int i2) {
        boolean z2 = true;
        if (i2 != 0 && i2 != 90 && i2 != 180) {
            if (i2 == 270) {
                i2 = 270;
            } else {
                z2 = false;
            }
        }
        Preconditions.checkArgument(z2, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        return i2;
    }

    private static InputImage zzb(@NonNull Image image, int i2, @Nullable Matrix matrix) {
        Image image2;
        int i8;
        int iLimit;
        InputImage inputImage;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Preconditions.checkNotNull(image, "Please provide a valid image");
        zza(i2);
        boolean z2 = true;
        if (image.getFormat() != 256 && image.getFormat() != 35) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            image2 = image;
            i8 = i2;
            inputImage = new InputImage(ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, i2), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            image2 = image;
            i8 = i2;
            InputImage inputImage2 = new InputImage(image2, image.getWidth(), image.getHeight(), i8, matrix);
            iLimit = (image2.getPlanes()[0].getBuffer().limit() * 3) / 2;
            inputImage = inputImage2;
        }
        zzc(image2.getFormat(), 5, jElapsedRealtime, image2.getHeight(), image2.getWidth(), iLimit, i8);
        return inputImage;
    }

    private static void zzc(int i2, int i8, long j, int i9, int i10, int i11, int i12) {
        zzmu.zza(zzms.zzb("vision-common"), i2, i8, j, i9, i10, i11, i12);
    }

    @Nullable
    @KeepForSdk
    public Bitmap getBitmapInternal() {
        return this.zza;
    }

    @Nullable
    @KeepForSdk
    public ByteBuffer getByteBuffer() {
        return this.zzb;
    }

    @Nullable
    @KeepForSdk
    public Matrix getCoordinatesMatrix() {
        return this.zzh;
    }

    @KeepForSdk
    @ImageFormat
    public int getFormat() {
        return this.zzg;
    }

    @KeepForSdk
    public int getHeight() {
        return this.zze;
    }

    @Nullable
    @KeepForSdk
    public Image getMediaImage() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zza();
    }

    @Nullable
    @KeepForSdk
    public Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zzb();
    }

    @KeepForSdk
    public int getRotationDegrees() {
        return this.zzf;
    }

    @KeepForSdk
    public int getWidth() {
        return this.zzd;
    }

    @NonNull
    @KeepForSdk
    public static InputImage fromMediaImage(@NonNull Image image, int i2, @NonNull Matrix matrix) {
        Preconditions.checkArgument(image.getFormat() == 35, "Only YUV_420_888 is supported now");
        return zzb(image, i2, matrix);
    }

    private InputImage(@NonNull Image image, int i2, int i8, int i9, @Nullable Matrix matrix) {
        Preconditions.checkNotNull(image);
        this.zzc = new zzb(image);
        this.zzd = i2;
        this.zze = i8;
        zza(i9);
        this.zzf = i9;
        this.zzg = 35;
        this.zzh = matrix;
    }

    private InputImage(@NonNull ByteBuffer byteBuffer, int i2, int i8, int i9, @ImageFormat int i10) {
        boolean z2;
        if (i10 == 842094169) {
            z2 = true;
        } else if (i10 == 17) {
            i10 = 17;
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.zzb = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        Preconditions.checkArgument(byteBuffer.limit() > i2 * i8, "Image dimension, ByteBuffer size and format don't match. Please check if the ByteBuffer is in the decalred format.");
        byteBuffer.rewind();
        this.zzd = i2;
        this.zze = i8;
        zza(i9);
        this.zzf = i9;
        this.zzg = i10;
        this.zzh = null;
    }
}
