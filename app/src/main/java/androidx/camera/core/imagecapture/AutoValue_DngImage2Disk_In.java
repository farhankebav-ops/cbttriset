package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.DngImage2Disk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_DngImage2Disk_In extends DngImage2Disk.In {
    private final ImageProxy imageProxy;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;

    public AutoValue_DngImage2Disk_In(ImageProxy imageProxy, int i2, ImageCapture.OutputFileOptions outputFileOptions) {
        if (imageProxy == null) {
            throw new NullPointerException("Null imageProxy");
        }
        this.imageProxy = imageProxy;
        this.rotationDegrees = i2;
        if (outputFileOptions == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.outputFileOptions = outputFileOptions;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DngImage2Disk.In) {
            DngImage2Disk.In in = (DngImage2Disk.In) obj;
            if (this.imageProxy.equals(in.getImageProxy()) && this.rotationDegrees == in.getRotationDegrees() && this.outputFileOptions.equals(in.getOutputFileOptions())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.In
    public ImageProxy getImageProxy() {
        return this.imageProxy;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.In
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.In
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.imageProxy.hashCode() ^ 1000003) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.outputFileOptions.hashCode();
    }

    public String toString() {
        return "In{imageProxy=" + this.imageProxy + ", rotationDegrees=" + this.rotationDegrees + ", outputFileOptions=" + this.outputFileOptions + "}";
    }
}
