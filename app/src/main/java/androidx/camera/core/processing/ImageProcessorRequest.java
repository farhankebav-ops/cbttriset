package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ImageProcessorRequest implements ImageProcessor.Request {
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProcessorRequest(ImageProxy imageProxy, int i2) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i2;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public int getOutputFormat() {
        return this.mOutputFormat;
    }
}
