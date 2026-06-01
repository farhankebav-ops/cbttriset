package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TakePictureRequest {
    private static final String TAG = "TakePictureRequest";
    private int mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();
    private final Map<Integer, Boolean> mFormatCaptureStatus = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface RetryControl {
        void retryRequest(TakePictureRequest takePictureRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCaptureProcessProgressed$3(int i2) {
        if (getOnDiskCallback() != null) {
            getOnDiskCallback().onCaptureProcessProgressed(i2);
        } else if (getInMemoryCallback() != null) {
            getInMemoryCallback().onCaptureProcessProgressed(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$0(ImageCaptureException imageCaptureException) {
        boolean z2 = getInMemoryCallback() != null;
        boolean z7 = getOnDiskCallback() != null;
        if (z2 && !z7) {
            ImageCapture.OnImageCapturedCallback inMemoryCallback = getInMemoryCallback();
            Objects.requireNonNull(inMemoryCallback);
            inMemoryCallback.onError(imageCaptureException);
        } else {
            if (!z7 || z2) {
                throw new IllegalStateException("One and only one callback is allowed.");
            }
            ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
            Objects.requireNonNull(onDiskCallback);
            onDiskCallback.onError(imageCaptureException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPostviewBitmapAvailable$4(Bitmap bitmap) {
        if (getOnDiskCallback() != null) {
            getOnDiskCallback().onPostviewBitmapAvailable(bitmap);
        } else if (getInMemoryCallback() != null) {
            getInMemoryCallback().onPostviewBitmapAvailable(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$1(ImageCapture.OutputFileResults outputFileResults) {
        ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
        Objects.requireNonNull(onDiskCallback);
        Objects.requireNonNull(outputFileResults);
        onDiskCallback.onImageSaved(outputFileResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$2(ImageProxy imageProxy) {
        ImageCapture.OnImageCapturedCallback inMemoryCallback = getInMemoryCallback();
        Objects.requireNonNull(inMemoryCallback);
        Objects.requireNonNull(imageProxy);
        inMemoryCallback.onCaptureSuccess(imageProxy);
    }

    public static TakePictureRequest of(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, ImageCapture.OutputFileOptions outputFileOptions2, Rect rect, Matrix matrix, int i2, int i8, int i9, boolean z2, List<CameraCaptureCallback> list) {
        Preconditions.checkArgument((onImageSavedCallback == null) == (outputFileOptions == null), "onDiskCallback and outputFileOptions should be both null or both non-null.");
        Preconditions.checkArgument((onImageCapturedCallback == null) ^ (onImageSavedCallback == null), "One and only one on-disk or in-memory callback should be present.");
        AutoValue_TakePictureRequest autoValue_TakePictureRequest = new AutoValue_TakePictureRequest(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, outputFileOptions2, rect, matrix, i2, i8, i9, z2, list);
        if (z2) {
            autoValue_TakePictureRequest.initFormatProcessStatusInSimultaneousCapture();
        }
        return autoValue_TakePictureRequest;
    }

    @MainThread
    public boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int i2 = this.mRemainingRetires;
        if (i2 <= 0) {
            return false;
        }
        this.mRemainingRetires = i2 - 1;
        return true;
    }

    public abstract Executor getAppExecutor();

    public abstract int getCaptureMode();

    public abstract Rect getCropRect();

    public abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    @IntRange(from = 1, to = 100)
    public abstract int getJpegQuality();

    public abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    @MainThread
    @VisibleForTesting
    public int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    public abstract int getRotationDegrees();

    public abstract ImageCapture.OutputFileOptions getSecondaryOutputFileOptions();

    public abstract Matrix getSensorToBufferTransform();

    public abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    @MainThread
    public void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    public void initFormatProcessStatusInSimultaneousCapture() {
        Map<Integer, Boolean> map = this.mFormatCaptureStatus;
        Boolean bool = Boolean.FALSE;
        map.put(32, bool);
        this.mFormatCaptureStatus.put(256, bool);
    }

    public boolean isFormatProcessedInSimultaneousCapture() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.mFormatCaptureStatus.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean isSimultaneousCapture();

    public void markFormatProcessStatusInSimultaneousCapture(int i2, boolean z2) {
        if (this.mFormatCaptureStatus.containsKey(Integer.valueOf(i2))) {
            this.mFormatCaptureStatus.put(Integer.valueOf(i2), Boolean.valueOf(z2));
        } else {
            Logger.e(TAG, "The format is not supported in simultaneous capture");
        }
    }

    public void onCaptureProcessProgressed(int i2) {
        getAppExecutor().execute(new d(this, i2, 1));
    }

    public void onError(ImageCaptureException imageCaptureException) {
        getAppExecutor().execute(new h(8, this, imageCaptureException));
    }

    public void onPostviewBitmapAvailable(Bitmap bitmap) {
        getAppExecutor().execute(new h(6, this, bitmap));
    }

    public void onResult(ImageCapture.OutputFileResults outputFileResults) {
        getAppExecutor().execute(new h(7, this, outputFileResults));
    }

    public void onResult(ImageProxy imageProxy) {
        getAppExecutor().execute(new h(5, this, imageProxy));
    }
}
