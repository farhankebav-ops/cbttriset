package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final ImageCapture.OutputFileOptions secondaryOutputFileOptions;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;
    private final boolean simultaneousCapture;

    public AutoValue_TakePictureRequest(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, ImageCapture.OutputFileOptions outputFileOptions2, Rect rect, Matrix matrix, int i2, int i8, int i9, boolean z2, List<CameraCaptureCallback> list) {
        if (executor == null) {
            throw new NullPointerException("Null appExecutor");
        }
        this.appExecutor = executor;
        this.inMemoryCallback = onImageCapturedCallback;
        this.onDiskCallback = onImageSavedCallback;
        this.outputFileOptions = outputFileOptions;
        this.secondaryOutputFileOptions = outputFileOptions2;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.cropRect = rect;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransform");
        }
        this.sensorToBufferTransform = matrix;
        this.rotationDegrees = i2;
        this.jpegQuality = i8;
        this.captureMode = i9;
        this.simultaneousCapture = z2;
        if (list == null) {
            throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
        }
        this.sessionConfigCameraCaptureCallbacks = list;
    }

    public boolean equals(Object obj) {
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback;
        ImageCapture.OnImageSavedCallback onImageSavedCallback;
        ImageCapture.OutputFileOptions outputFileOptions;
        ImageCapture.OutputFileOptions outputFileOptions2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TakePictureRequest) {
            TakePictureRequest takePictureRequest = (TakePictureRequest) obj;
            if (this.appExecutor.equals(takePictureRequest.getAppExecutor()) && ((onImageCapturedCallback = this.inMemoryCallback) != null ? onImageCapturedCallback.equals(takePictureRequest.getInMemoryCallback()) : takePictureRequest.getInMemoryCallback() == null) && ((onImageSavedCallback = this.onDiskCallback) != null ? onImageSavedCallback.equals(takePictureRequest.getOnDiskCallback()) : takePictureRequest.getOnDiskCallback() == null) && ((outputFileOptions = this.outputFileOptions) != null ? outputFileOptions.equals(takePictureRequest.getOutputFileOptions()) : takePictureRequest.getOutputFileOptions() == null) && ((outputFileOptions2 = this.secondaryOutputFileOptions) != null ? outputFileOptions2.equals(takePictureRequest.getSecondaryOutputFileOptions()) : takePictureRequest.getSecondaryOutputFileOptions() == null) && this.cropRect.equals(takePictureRequest.getCropRect()) && this.sensorToBufferTransform.equals(takePictureRequest.getSensorToBufferTransform()) && this.rotationDegrees == takePictureRequest.getRotationDegrees() && this.jpegQuality == takePictureRequest.getJpegQuality() && this.captureMode == takePictureRequest.getCaptureMode() && this.simultaneousCapture == takePictureRequest.isSimultaneousCapture() && this.sessionConfigCameraCaptureCallbacks.equals(takePictureRequest.getSessionConfigCameraCaptureCallbacks())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Executor getAppExecutor() {
        return this.appExecutor;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getCaptureMode() {
        return this.captureMode;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @IntRange(from = 1, to = 100)
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OutputFileOptions getSecondaryOutputFileOptions() {
        return this.secondaryOutputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public int hashCode() {
        int iHashCode = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback = this.inMemoryCallback;
        int iHashCode2 = (iHashCode ^ (onImageCapturedCallback == null ? 0 : onImageCapturedCallback.hashCode())) * 1000003;
        ImageCapture.OnImageSavedCallback onImageSavedCallback = this.onDiskCallback;
        int iHashCode3 = (iHashCode2 ^ (onImageSavedCallback == null ? 0 : onImageSavedCallback.hashCode())) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions = this.outputFileOptions;
        int iHashCode4 = (iHashCode3 ^ (outputFileOptions == null ? 0 : outputFileOptions.hashCode())) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions2 = this.secondaryOutputFileOptions;
        return ((((((((((((((iHashCode4 ^ (outputFileOptions2 != null ? outputFileOptions2.hashCode() : 0)) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ (this.simultaneousCapture ? 1231 : 1237)) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public boolean isSimultaneousCapture() {
        return this.simultaneousCapture;
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", secondaryOutputFileOptions=" + this.secondaryOutputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", simultaneousCapture=" + this.simultaneousCapture + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + "}";
    }
}
