package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.ImageProcessorRequest;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class BitmapEffect implements Operation<Packet<Bitmap>, Packet<Bitmap>> {
    private final InternalImageProcessor mProcessor;

    public BitmapEffect(InternalImageProcessor internalImageProcessor) {
        this.mProcessor = internalImageProcessor;
    }

    @Override // androidx.camera.core.processing.Operation
    public Packet<Bitmap> apply(Packet<Bitmap> packet) throws ImageCaptureException {
        ImageProxy outputImage = this.mProcessor.safeProcess(new ImageProcessorRequest(new RgbaImageProxy(packet), 1)).getOutputImage();
        Objects.requireNonNull(outputImage);
        Bitmap bitmapCreateBitmapFromPlane = ImageUtil.createBitmapFromPlane(outputImage.getPlanes(), outputImage.getWidth(), outputImage.getHeight());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(bitmapCreateBitmapFromPlane, exif, packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }
}
