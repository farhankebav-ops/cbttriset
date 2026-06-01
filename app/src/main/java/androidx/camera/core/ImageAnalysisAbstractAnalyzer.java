package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mNV21UVDelegatedBuffer;

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mNV21YDelegatedBuffer;
    private volatile boolean mOnePixelShiftEnabled;
    private volatile boolean mOutputImageRotationEnabled;

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359)
    private volatile int mPrevBufferRotationDegrees;

    @GuardedBy("mAnalyzerLock")
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;

    @GuardedBy("mAnalyzerLock")
    private ImageWriter mProcessedImageWriter;

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mRGBConvertedBuffer;

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359)
    private volatile int mRelativeRotation;

    @GuardedBy("mAnalyzerLock")
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mURotatedBuffer;

    @GuardedBy("mAnalyzerLock")
    private Executor mUserExecutor;

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mVRotatedBuffer;

    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mYRotatedBuffer;
    private volatile int mOutputImageFormat = 1;

    @GuardedBy("mAnalyzerLock")
    private Rect mOriginalViewPortCropRect = new Rect();

    @GuardedBy("mAnalyzerLock")
    private Rect mUpdatedViewPortCropRect = new Rect();

    @GuardedBy("mAnalyzerLock")
    private Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();

    @GuardedBy("mAnalyzerLock")
    private Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;

    @GuardedBy("mAnalyzerLock")
    private void createHelperBuffer(ImageProxy imageProxy) {
        if (this.mOutputImageFormat != 1 && this.mOutputImageFormat != 3) {
            if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
                this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth() * 4);
                return;
            }
            return;
        }
        if (this.mYRotatedBuffer == null) {
            this.mYRotatedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth());
        }
        this.mYRotatedBuffer.position(0);
        if (this.mURotatedBuffer == null) {
            this.mURotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
        }
        this.mURotatedBuffer.position(0);
        if (this.mVRotatedBuffer == null) {
            this.mVRotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
        }
        this.mVRotatedBuffer.position(0);
        if (this.mOutputImageFormat == 3) {
            if (this.mNV21YDelegatedBuffer == null) {
                this.mNV21YDelegatedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth());
            }
            this.mNV21YDelegatedBuffer.position(0);
            if (this.mNV21UVDelegatedBuffer == null) {
                this.mNV21UVDelegatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 2);
            }
            this.mNV21UVDelegatedBuffer.position(0);
        }
    }

    private static SafeCloseImageReaderProxy createImageReaderProxy(int i2, int i8, int i9, int i10, int i11) {
        boolean z2 = i9 == 90 || i9 == 270;
        int i12 = z2 ? i8 : i2;
        if (!z2) {
            i2 = i8;
        }
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(i12, i2, i10, i11));
    }

    @VisibleForTesting
    public static Matrix getAdditionalTransformMatrixAppliedByProcessor(int i2, int i8, int i9, int i10, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i11) {
        Matrix matrix = new Matrix();
        if (i11 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i2, i8), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            matrix.postRotate(i11);
            matrix.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, i9, i10)));
        }
        return matrix;
    }

    public static Rect getUpdatedCropRect(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$analyzeImage$0(ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (!this.mIsAttached) {
            completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
            return;
        }
        SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy2, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), this.mOutputImageRotationEnabled ? 0 : this.mRelativeRotation, matrix, imageProxy.getImageInfo().getFlashState()));
        if (!rect.isEmpty()) {
            settableImageProxy.setCropRect(rect);
        }
        analyzer.analyze(settableImageProxy);
        completer.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$analyzeImage$1(Executor executor, final ImageProxy imageProxy, final Matrix matrix, final ImageProxy imageProxy2, final Rect rect, final ImageAnalysis.Analyzer analyzer, final CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new Runnable() { // from class: androidx.camera.core.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f3678a.lambda$analyzeImage$0(imageProxy, matrix, imageProxy2, rect, analyzer, completer);
            }
        });
        return "analyzeImage";
    }

    @GuardedBy("mAnalyzerLock")
    private void recalculateTransformMatrixAndCropRect(int i2, int i8, int i9, int i10) {
        Matrix additionalTransformMatrixAppliedByProcessor = getAdditionalTransformMatrixAppliedByProcessor(i2, i8, i9, i10, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, additionalTransformMatrixAppliedByProcessor);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, additionalTransformMatrixAppliedByProcessor);
    }

    @GuardedBy("mAnalyzerLock")
    private void recreateImageReaderProxy(ImageProxy imageProxy, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
        if (safeCloseImageReaderProxy == null) {
            return;
        }
        safeCloseImageReaderProxy.safeClose();
        this.mProcessedImageReaderProxy = createImageReaderProxy(imageProxy.getWidth(), imageProxy.getHeight(), i2, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
        if (this.mOutputImageFormat == 1) {
            ImageWriter imageWriter = this.mProcessedImageWriter;
            if (imageWriter != null) {
                ImageWriterCompat.close(imageWriter);
            }
            this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
        }
    }

    public abstract ImageProxy acquireImage(ImageReaderProxy imageReaderProxy);

    public j2.q analyzeImage(final ImageProxy imageProxy) throws Throwable {
        Object obj;
        final Executor executor;
        final ImageAnalysis.Analyzer analyzer;
        boolean z2;
        SafeCloseImageReaderProxy safeCloseImageReaderProxy;
        ImageWriter imageWriter;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        ByteBuffer byteBuffer5;
        ByteBuffer byteBuffer6;
        ImageProxy imageProxyRotateYUVAndConvertToNV21;
        ImageProxy imageProxy2;
        int i2 = this.mOutputImageRotationEnabled ? this.mRelativeRotation : 0;
        Object obj2 = this.mAnalyzerLock;
        synchronized (obj2) {
            try {
                try {
                    executor = this.mUserExecutor;
                    analyzer = this.mSubscribedAnalyzer;
                    z2 = this.mOutputImageRotationEnabled && i2 != this.mPrevBufferRotationDegrees;
                    if (z2) {
                        recreateImageReaderProxy(imageProxy, i2);
                    }
                    if (this.mOutputImageRotationEnabled || this.mOutputImageFormat == 3) {
                        createHelperBuffer(imageProxy);
                    }
                    try {
                        safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
                    } catch (Throwable th) {
                        th = th;
                        obj = obj2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                imageWriter = this.mProcessedImageWriter;
                byteBuffer = this.mRGBConvertedBuffer;
                byteBuffer2 = this.mYRotatedBuffer;
                byteBuffer3 = this.mURotatedBuffer;
                byteBuffer4 = this.mVRotatedBuffer;
                byteBuffer5 = this.mNV21YDelegatedBuffer;
                byteBuffer6 = this.mNV21UVDelegatedBuffer;
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
                throw th;
            }
        }
        if (analyzer == null || executor == null || !this.mIsAttached) {
            return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
        }
        if (safeCloseImageReaderProxy != null) {
            if (this.mOutputImageFormat == 2) {
                imageProxyRotateYUVAndConvertToNV21 = ImageProcessingUtil.convertYUVToRGB(imageProxy, safeCloseImageReaderProxy, byteBuffer, i2, this.mOnePixelShiftEnabled);
            } else {
                if (this.mOutputImageFormat == 1) {
                    if (this.mOnePixelShiftEnabled) {
                        ImageProcessingUtil.applyPixelShiftForYUV(imageProxy);
                    }
                    if (imageWriter != null && byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null) {
                        imageProxyRotateYUVAndConvertToNV21 = ImageProcessingUtil.rotateYUV(imageProxy, safeCloseImageReaderProxy, imageWriter, byteBuffer2, byteBuffer3, byteBuffer4, i2);
                    }
                }
                imageProxy2 = null;
            }
            imageProxy2 = imageProxyRotateYUVAndConvertToNV21;
        } else {
            if (this.mOutputImageFormat == 3) {
                if (this.mOnePixelShiftEnabled) {
                    ImageProcessingUtil.applyPixelShiftForYUV(imageProxy);
                }
                if (byteBuffer2 != null && byteBuffer3 != null && byteBuffer4 != null && byteBuffer5 != null && byteBuffer6 != null) {
                    imageProxyRotateYUVAndConvertToNV21 = ImageProcessingUtil.rotateYUVAndConvertToNV21(imageProxy, byteBuffer2, byteBuffer3, byteBuffer4, byteBuffer5, byteBuffer6, i2);
                    imageProxy2 = imageProxyRotateYUVAndConvertToNV21;
                }
            }
            imageProxy2 = null;
        }
        boolean z7 = imageProxy2 == null;
        final ImageProxy imageProxy3 = z7 ? imageProxy : imageProxy2;
        final Rect rect = new Rect();
        final Matrix matrix = new Matrix();
        synchronized (this.mAnalyzerLock) {
            if (z2 && !z7) {
                try {
                    recalculateTransformMatrixAndCropRect(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy3.getWidth(), imageProxy3.getHeight());
                } finally {
                }
            }
            this.mPrevBufferRotationDegrees = i2;
            rect.set(this.mUpdatedViewPortCropRect);
            matrix.set(this.mUpdatedSensorToBufferTransformMatrix);
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.q
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f3733a.lambda$analyzeImage$1(executor, imageProxy, matrix, imageProxy3, rect, analyzer, completer);
            }
        });
    }

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireImage = acquireImage(imageReaderProxy);
            if (imageProxyAcquireImage != null) {
                onValidImageAvailable(imageProxyAcquireImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire image.", e);
        }
    }

    public abstract void onValidImageAvailable(ImageProxy imageProxy);

    public void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        if (analyzer == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    public void setOnePixelShiftEnabled(boolean z2) {
        this.mOnePixelShiftEnabled = z2;
    }

    public void setOutputImageFormat(int i2) {
        this.mOutputImageFormat = i2;
    }

    public void setOutputImageRotationEnabled(boolean z2) {
        this.mOutputImageRotationEnabled = z2;
    }

    public void setProcessedImageReaderProxy(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.mAnalyzerLock) {
            this.mProcessedImageReaderProxy = safeCloseImageReaderProxy;
        }
    }

    public void setRelativeRotation(int i2) {
        this.mRelativeRotation = i2;
    }

    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalSensorToBufferTransformMatrix = matrix;
            this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);
        }
    }

    public void setViewPortCropRect(Rect rect) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalViewPortCropRect = rect;
            this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);
        }
    }
}
