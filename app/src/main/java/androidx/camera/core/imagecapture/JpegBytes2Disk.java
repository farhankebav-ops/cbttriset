package androidx.camera.core.imagecapture;

import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class In {
        public static In of(Packet<byte[]> packet, ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }

        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        public abstract Packet<byte[]> getPacket();
    }

    public static void writeBytesToFile(File file, byte[] bArr) throws ImageCaptureException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, new InvalidJpegDataParser().getValidDataLength(bArr));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    public ImageCapture.OutputFileResults apply(In in) throws ImageCaptureException {
        Packet<byte[]> packet = in.getPacket();
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File fileCreateTempFile = FileUtil.createTempFile(outputFileOptions);
        writeBytesToFile(fileCreateTempFile, packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        FileUtil.updateFileExif(fileCreateTempFile, exif, outputFileOptions, packet.getRotationDegrees());
        return new ImageCapture.OutputFileResults(FileUtil.moveFileToTarget(fileCreateTempFile, outputFileOptions), 256);
    }
}
