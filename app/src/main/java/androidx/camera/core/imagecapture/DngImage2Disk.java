package androidx.camera.core.imagecapture;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.DngCreator;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.processing.Operation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DngImage2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private DngCreator mDngCreator;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class In {
        public static In of(ImageProxy imageProxy, int i2, ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_DngImage2Disk_In(imageProxy, i2, outputFileOptions);
        }

        public abstract ImageProxy getImageProxy();

        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        public abstract int getRotationDegrees();
    }

    public DngImage2Disk(CameraCharacteristics cameraCharacteristics, CaptureResult captureResult) {
        this(new DngCreator(cameraCharacteristics, captureResult));
    }

    public static int computeExifOrientation(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 90) {
            return 6;
        }
        if (i2 != 180) {
            return i2 != 270 ? 0 : 8;
        }
        return 3;
    }

    @OptIn(markerClass = {ExperimentalGetImage.class})
    private void writeImageToFile(File file, ImageProxy imageProxy, int i2) throws ImageCaptureException {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    this.mDngCreator.setOrientation(computeExifOrientation(i2));
                    this.mDngCreator.writeImage(fileOutputStream, imageProxy.getImage());
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to write to temp file", e);
            } catch (IllegalArgumentException e4) {
                throw new ImageCaptureException(1, "Image with an unsupported format was used", e4);
            } catch (IllegalStateException e8) {
                throw new ImageCaptureException(1, "Not enough metadata information has been set to write a well-formatted DNG file", e8);
            }
        } finally {
            imageProxy.close();
        }
    }

    @VisibleForTesting
    public DngImage2Disk(DngCreator dngCreator) {
        this.mDngCreator = dngCreator;
    }

    @Override // androidx.camera.core.processing.Operation
    public ImageCapture.OutputFileResults apply(In in) throws ImageCaptureException {
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File fileCreateTempFile = FileUtil.createTempFile(outputFileOptions);
        writeImageToFile(fileCreateTempFile, in.getImageProxy(), in.getRotationDegrees());
        return new ImageCapture.OutputFileResults(FileUtil.moveFileToTarget(fileCreateTempFile, outputFileOptions), 32);
    }
}
