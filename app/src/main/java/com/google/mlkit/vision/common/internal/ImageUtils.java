package com.google.mlkit.vision.common.internal;

import a1.a;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    @NonNull
    @KeepForSdk
    public static ImageUtils getInstance() {
        return zzb;
    }

    @NonNull
    @KeepForSdk
    public IObjectWrapper getImageDataWrapper(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
        }
        if (format != 17) {
            if (format == 35) {
                return ObjectWrapper.wrap(inputImage.getMediaImage());
            }
            if (format != 842094169) {
                throw new MlKitException(a.g(inputImage.getFormat(), "Unsupported image format: "), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
    }

    @KeepForSdk
    public int getMobileVisionImageFormat(@NonNull InputImage inputImage) {
        return inputImage.getFormat();
    }

    @KeepForSdk
    public int getMobileVisionImageSize(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix(int i2, int i8, int i9) {
        if (i9 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i2) / 2.0f, (-i8) / 2.0f);
        matrix.postRotate(i9 * 90);
        int i10 = i9 % 2;
        int i11 = i10 != 0 ? i8 : i2;
        if (i10 == 0) {
            i2 = i8;
        }
        matrix.postTranslate(i11 / 2.0f, i2 / 2.0f);
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f A[PHI: r5
  0x008f: PHI (r5v3 android.graphics.Matrix) = (r5v0 android.graphics.Matrix), (r5v1 android.graphics.Matrix) binds: [B:39:0x008c, B:48:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[Catch: FileNotFoundException -> 0x0025, TryCatch #1 {FileNotFoundException -> 0x0025, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0018, B:38:0x0077, B:39:0x008c, B:50:0x00bd, B:52:0x00c6, B:41:0x0091, B:42:0x0095, B:43:0x009c, B:44:0x00a0, B:45:0x00a7, B:46:0x00ab, B:48:0x00b2, B:37:0x0071, B:34:0x005f, B:54:0x00cb, B:55:0x00d2), top: B:61:0x0004 }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap zza(@androidx.annotation.NonNull android.content.ContentResolver r11, @androidx.annotation.NonNull android.net.Uri r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.common.internal.ImageUtils.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }
}
