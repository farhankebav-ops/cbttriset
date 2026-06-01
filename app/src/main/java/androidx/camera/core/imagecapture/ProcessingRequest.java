package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.MainThread;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import j2.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ProcessingRequest {
    static final int PROGRESS_NOT_RECEIVED = -1;
    private final TakePictureCallback mCallback;
    final q mCaptureFuture;
    private final Rect mCropRect;
    private final int mJpegQuality;
    private int mLastCaptureProcessProgressed;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRequestId;
    private final int mRotationDegrees;
    private final ImageCapture.OutputFileOptions mSecondaryOutputFileOptions;
    private final Matrix mSensorToBufferTransform;
    private final List<Integer> mStageIds;
    private final String mTagBundleKey;
    TakePictureRequest mTakePictureRequest;

    public ProcessingRequest(CaptureBundle captureBundle, TakePictureRequest takePictureRequest, TakePictureCallback takePictureCallback, q qVar) {
        this(captureBundle, takePictureRequest, takePictureCallback, qVar, 0);
    }

    public q getCaptureFuture() {
        return this.mCaptureFuture;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public ImageCapture.OutputFileOptions getSecondaryOutputFileOptions() {
        return this.mSecondaryOutputFileOptions;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    public TakePictureRequest getTakePictureRequest() {
        return this.mTakePictureRequest;
    }

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public boolean isInMemoryCapture() {
        return getOutputFileOptions() == null && getSecondaryOutputFileOptions() == null;
    }

    @MainThread
    public void onCaptureFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onCaptureFailure(imageCaptureException);
    }

    @MainThread
    public void onCaptureProcessProgressed(int i2) {
        if (this.mLastCaptureProcessProgressed != i2) {
            this.mLastCaptureProcessProgressed = i2;
            this.mCallback.onCaptureProcessProgressed(i2);
        }
    }

    @MainThread
    public void onCaptureStarted() {
        this.mCallback.onCaptureStarted();
    }

    @MainThread
    public void onFinalResult(ImageCapture.OutputFileResults outputFileResults) {
        this.mCallback.onFinalResult(outputFileResults);
    }

    @MainThread
    public void onImageCaptured() {
        if (this.mLastCaptureProcessProgressed != -1) {
            onCaptureProcessProgressed(100);
        }
        this.mCallback.onImageCaptured();
    }

    public void onPostviewBitmapAvailable(Bitmap bitmap) {
        this.mCallback.onPostviewBitmapAvailable(bitmap);
    }

    @MainThread
    public void onProcessFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onProcessFailure(imageCaptureException);
    }

    public ProcessingRequest(CaptureBundle captureBundle, TakePictureRequest takePictureRequest, TakePictureCallback takePictureCallback, q qVar, int i2) {
        this.mLastCaptureProcessProgressed = -1;
        this.mRequestId = i2;
        this.mTakePictureRequest = takePictureRequest;
        this.mOutputFileOptions = takePictureRequest.getOutputFileOptions();
        this.mSecondaryOutputFileOptions = takePictureRequest.getSecondaryOutputFileOptions();
        this.mJpegQuality = takePictureRequest.getJpegQuality();
        this.mRotationDegrees = takePictureRequest.getRotationDegrees();
        this.mCropRect = takePictureRequest.getCropRect();
        this.mSensorToBufferTransform = takePictureRequest.getSensorToBufferTransform();
        this.mCallback = takePictureCallback;
        this.mTagBundleKey = String.valueOf(captureBundle.hashCode());
        this.mStageIds = new ArrayList();
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        Iterator<CaptureStage> it = captureStages.iterator();
        while (it.hasNext()) {
            this.mStageIds.add(Integer.valueOf(it.next().getId()));
        }
        this.mCaptureFuture = qVar;
    }

    @MainThread
    public void onFinalResult(ImageProxy imageProxy) {
        this.mCallback.onFinalResult(imageProxy);
    }
}
