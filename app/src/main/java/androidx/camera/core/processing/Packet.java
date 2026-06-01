package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Packet<T> {
    public static Packet<Bitmap> of(Bitmap bitmap, Exif exif, Rect rect, int i2, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bitmap, exif, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i2, matrix, cameraCaptureResult);
    }

    public abstract CameraCaptureResult getCameraCaptureResult();

    public abstract Rect getCropRect();

    public abstract T getData();

    public abstract Exif getExif();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract Size getSize();

    public boolean hasCropping() {
        return TransformUtils.hasCropping(getCropRect(), getSize());
    }

    public static Packet<ImageProxy> of(ImageProxy imageProxy, Exif exif, Rect rect, int i2, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return of(imageProxy, exif, new Size(imageProxy.getWidth(), imageProxy.getHeight()), rect, i2, matrix, cameraCaptureResult);
    }

    public static Packet<ImageProxy> of(ImageProxy imageProxy, Exif exif, Size size, Rect rect, int i2, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        if (ImageUtil.isJpegFormats(imageProxy.getFormat())) {
            Preconditions.checkNotNull(exif, "JPEG image must have Exif.");
        }
        return new AutoValue_Packet(imageProxy, exif, imageProxy.getFormat(), size, rect, i2, matrix, cameraCaptureResult);
    }

    public static Packet<byte[]> of(byte[] bArr, Exif exif, int i2, Size size, Rect rect, int i8, Matrix matrix, CameraCaptureResult cameraCaptureResult) {
        return new AutoValue_Packet(bArr, exif, i2, size, rect, i8, matrix, cameraCaptureResult);
    }
}
