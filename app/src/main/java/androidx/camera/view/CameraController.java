package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalLensFacing;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.LiveDataUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.RotationProvider;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.video.AudioConfig;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j2.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";

    @Deprecated
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final ImageCapture.ScreenFlash NO_OP_SCREEN_FLASH = new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.CameraController.1
        @Override // androidx.camera.core.ImageCapture.ScreenFlash
        public void apply(long j, ImageCapture.ScreenFlashListener screenFlashListener) {
            screenFlashListener.onCompleted();
        }

        @Override // androidx.camera.core.ImageCapture.ScreenFlash
        public void clear() {
        }
    };
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private static final String VIDEO_RECORDING_UNFINISHED = "Recording video. Only one recording can be active at a time.";
    Recording mActiveRecording;
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisBackgroundExecutor;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    Camera mCamera;
    ProcessCameraProviderWrapper mCameraProvider;
    CameraSelector mCameraSelector;

    @VisibleForTesting
    final RotationProvider.Listener mDeviceRotationListener;
    private final Set<CameraEffect> mEffects;
    private int mEnabledUseCases;
    private FocusMeteringResultCallback mFocusMeteringResultCallback;
    ImageAnalysis mImageAnalysis;
    ResolutionSelector mImageAnalysisResolutionSelector;
    OutputSize mImageAnalysisTargetSize;
    ImageCapture mImageCapture;
    Executor mImageCaptureIoExecutor;
    ResolutionSelector mImageCaptureResolutionSelector;
    OutputSize mImageCaptureTargetSize;
    private final q mInitializationFuture;
    private final PendingValue<Boolean> mPendingEnableTorch;
    private final PendingValue<Float> mPendingLinearZoom;
    private final PendingValue<Float> mPendingZoomRatio;
    private boolean mPinchToZoomEnabled;
    Preview mPreview;
    private DynamicRange mPreviewDynamicRange;
    ResolutionSelector mPreviewResolutionSelector;
    OutputSize mPreviewTargetSize;
    Map<Consumer<VideoRecordEvent>, Recording> mRecordingMap;
    private final RotationProvider mRotationProvider;
    private final Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> mScreenFlashUiInfoMap;
    Preview.SurfaceProvider mSurfaceProvider;
    private long mTapToFocusAutoCancelDurationNanos;
    private boolean mTapToFocusEnabled;
    final MutableLiveData<TapToFocusInfo> mTapToFocusInfoState;
    final LiveData<Integer> mTapToFocusState;
    private final ForwardingLiveData<Integer> mTorchState;
    VideoCapture<Recorder> mVideoCapture;
    private DynamicRange mVideoCaptureDynamicRange;
    private int mVideoCaptureMirrorMode;
    QualitySelector mVideoCaptureQualitySelector;
    private Range<Integer> mVideoCaptureTargetFrameRate;
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState;

    /* JADX INFO: renamed from: androidx.camera.view.CameraController$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 implements Consumer<VideoRecordEvent> {
        final /* synthetic */ Consumer val$listener;
        final /* synthetic */ Executor val$mainExecutor;

        public AnonymousClass2(Executor executor, Consumer consumer) {
            this.val$mainExecutor = executor;
            this.val$listener = consumer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$accept$0() {
            CameraController.this.deactivateRecordingByListener(this);
        }

        @Override // androidx.core.util.Consumer
        public void accept(VideoRecordEvent videoRecordEvent) {
            if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                if (Threads.isMainThread()) {
                    CameraController.this.deactivateRecordingByListener(this);
                } else {
                    this.val$mainExecutor.execute(new a(this, 1));
                }
            }
            this.val$listener.accept(videoRecordEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class FocusMeteringResultCallback implements FutureCallback<FocusMeteringResult> {
        private boolean mIsCanceled = false;
        private final Object mLock = new Object();
        private final PointF mTapPoint;
        private final MutableLiveData<TapToFocusInfo> mTapToFocusInfoState;

        public FocusMeteringResultCallback(PointF pointF, MutableLiveData<TapToFocusInfo> mutableLiveData) {
            this.mTapPoint = pointF;
            this.mTapToFocusInfoState = mutableLiveData;
        }

        public void close() {
            synchronized (this.mLock) {
                this.mIsCanceled = true;
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
            synchronized (this.mLock) {
                try {
                    if (this.mIsCanceled) {
                        return;
                    }
                    if (!(th instanceof CameraControl.OperationCanceledException)) {
                        Logger.d(CameraController.TAG, "Tap-to-focus failed.", th);
                        this.mTapToFocusInfoState.postValue(new TapToFocusInfo(4, this.mTapPoint));
                    } else {
                        Logger.d(CameraController.TAG, "Tap-to-focus canceled", th);
                        this.mTapToFocusInfoState.postValue(new TapToFocusInfo(0, null));
                        close();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void resetStateAndClose() {
            synchronized (this.mLock) {
                try {
                    if (this.mIsCanceled) {
                        return;
                    }
                    Logger.d(CameraController.TAG, "Tap-to-focus reset.");
                    this.mTapToFocusInfoState.postValue(new TapToFocusInfo(0, null));
                    this.mIsCanceled = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(FocusMeteringResult focusMeteringResult) {
            synchronized (this.mLock) {
                try {
                    if (this.mIsCanceled) {
                        return;
                    }
                    if (focusMeteringResult == null) {
                        return;
                    }
                    Logger.d(CameraController.TAG, "Tap-to-focus onSuccess: " + focusMeteringResult.isFocusSuccessful());
                    this.mTapToFocusInfoState.postValue(new TapToFocusInfo(focusMeteringResult.isFocusSuccessful() ? 2 : 3, this.mTapPoint));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface UseCases {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CameraController(Context context) {
        final int i2 = 0;
        this(context, Futures.transform(ProcessCameraProvider.getInstance(context), new Function() { // from class: androidx.camera.view.c
            @Override // androidx.arch.core.util.Function, m0.f, x4.c
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        return new ProcessCameraProviderWrapperImpl((ProcessCameraProvider) obj);
                    default:
                        return Integer.valueOf(((TapToFocusInfo) obj).getFocusState());
                }
            }
        }, CameraXExecutors.directExecutor()));
    }

    private void checkAudioPermissionGranted() {
        if (PermissionChecker.checkSelfPermission(this.mAppContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to start recording with audio, but application does not have RECORD_AUDIO permission granted.");
        }
    }

    private void configureResolution(ImageOutputConfig.Builder<?> builder, ResolutionSelector resolutionSelector, OutputSize outputSize) {
        AspectRatioStrategy viewportAspectRatioStrategy;
        if (resolutionSelector != null) {
            builder.setResolutionSelector(resolutionSelector);
            return;
        }
        if (outputSize != null) {
            setTargetOutputSize(builder, outputSize);
            return;
        }
        ViewPort viewPort = this.mViewPort;
        if (viewPort == null || (viewportAspectRatioStrategy = getViewportAspectRatioStrategy(viewPort)) == null) {
            return;
        }
        builder.setResolutionSelector(new ResolutionSelector.Builder().setAspectRatioStrategy(viewportAspectRatioStrategy).build());
    }

    private FocusMeteringAction createFocusMeteringAction(MeteringPointFactory meteringPointFactory, PointF pointF) {
        FocusMeteringAction.Builder builderAddPoint = new FocusMeteringAction.Builder(meteringPointFactory.createPoint(pointF.x, pointF.y, AF_SIZE), 1).addPoint(meteringPointFactory.createPoint(pointF.x, pointF.y, AE_SIZE), 2);
        long j = this.mTapToFocusAutoCancelDurationNanos;
        return (j > 0 ? builderAddPoint.setAutoCancelDuration(j, TimeUnit.NANOSECONDS) : builderAddPoint.disableAutoCancel()).build();
    }

    private ImageAnalysis createImageAnalysis(Integer num, Integer num2, Integer num3) {
        ImageAnalysis.Builder builder = new ImageAnalysis.Builder();
        if (num != null) {
            builder.setBackpressureStrategy(num.intValue());
        }
        if (num2 != null) {
            builder.setImageQueueDepth(num2.intValue());
        }
        if (num3 != null) {
            builder.setOutputImageFormat(num3.intValue());
        }
        configureResolution(builder, this.mImageAnalysisResolutionSelector, this.mImageAnalysisTargetSize);
        Executor executor = this.mAnalysisBackgroundExecutor;
        if (executor != null) {
            builder.setBackgroundExecutor(executor);
        }
        return builder.build();
    }

    private ImageCapture createImageCapture(Integer num) {
        ImageCapture.Builder builder = new ImageCapture.Builder();
        if (num != null) {
            builder.setCaptureMode(num.intValue());
        }
        configureResolution(builder, this.mImageCaptureResolutionSelector, this.mImageCaptureTargetSize);
        Executor executor = this.mImageCaptureIoExecutor;
        if (executor != null) {
            builder.setIoExecutor(executor);
        }
        return builder.build();
    }

    private Preview createPreview() {
        Preview.Builder builder = new Preview.Builder();
        configureResolution(builder, this.mPreviewResolutionSelector, this.mPreviewTargetSize);
        builder.setDynamicRange(this.mPreviewDynamicRange);
        return builder.build();
    }

    private VideoCapture<Recorder> createVideoCapture() {
        int viewportAspectRatioInt;
        Recorder.Builder qualitySelector = new Recorder.Builder().setQualitySelector(this.mVideoCaptureQualitySelector);
        ViewPort viewPort = this.mViewPort;
        if (viewPort != null && this.mVideoCaptureQualitySelector == Recorder.DEFAULT_QUALITY_SELECTOR && (viewportAspectRatioInt = getViewportAspectRatioInt(viewPort)) != -1) {
            qualitySelector.setAspectRatio(viewportAspectRatioInt);
        }
        return new VideoCapture.Builder(qualitySelector.build()).setTargetFrameRate(this.mVideoCaptureTargetFrameRate).setMirrorMode(this.mVideoCaptureMirrorMode).setDynamicRange(this.mVideoCaptureDynamicRange).build();
    }

    @MainThread
    private void deactivateRecording(Recording recording) {
        if (this.mActiveRecording == recording) {
            this.mActiveRecording = null;
        }
    }

    @OptIn(markerClass = {ExperimentalLensFacing.class})
    private String getReadableSelectorString(CameraSelector cameraSelector) {
        if (cameraSelector == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("CameraSelector{");
        Integer lensFacing = cameraSelector.getLensFacing();
        if (lensFacing != null) {
            int iIntValue = lensFacing.intValue();
            if (iIntValue == 0) {
                sb.append("lensFacing=FRONT");
            } else if (iIntValue == 1) {
                sb.append("lensFacing=BACK");
            } else if (iIntValue != 2) {
                sb.append("lensFacing=UNKNOWN(");
                sb.append(lensFacing);
                sb.append(")");
            } else {
                sb.append("lensFacing=EXTERNAL");
            }
        } else {
            sb.append("lensFacing=NOT_SPECIFIED");
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getViewportAspectRatioInt(androidx.camera.core.ViewPort r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L5
            r1 = r0
            goto Ld
        L5:
            int r1 = r9.getRotation()
            int r1 = androidx.camera.core.impl.utils.CameraOrientationUtil.surfaceRotationToDegrees(r1)
        Ld:
            r2 = 1
            androidx.camera.view.ProcessCameraProviderWrapper r3 = r8.mCameraProvider     // Catch: java.lang.IllegalArgumentException -> L27
            if (r3 == 0) goto L2a
            androidx.camera.core.CameraSelector r4 = r8.mCameraSelector     // Catch: java.lang.IllegalArgumentException -> L27
            androidx.camera.core.CameraInfo r3 = r3.getCameraInfo(r4)     // Catch: java.lang.IllegalArgumentException -> L27
            int r4 = r3.getSensorRotationDegrees()     // Catch: java.lang.IllegalArgumentException -> L27
            int r3 = r3.getLensFacing()     // Catch: java.lang.IllegalArgumentException -> L25
            if (r3 != r2) goto L23
            goto L45
        L23:
            r3 = r0
            goto L46
        L25:
            r3 = move-exception
            goto L2c
        L27:
            r3 = move-exception
            r4 = r0
            goto L2c
        L2a:
            r4 = r0
            goto L45
        L2c:
            androidx.camera.core.CameraSelector r5 = r8.mCameraSelector
            java.lang.String r5 = r8.getReadableSelectorString(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to retrieve CameraInfo for selector: "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "CameraController"
            androidx.camera.core.Logger.w(r6, r5, r3)
        L45:
            r3 = r2
        L46:
            int r1 = androidx.camera.core.impl.utils.CameraOrientationUtil.getRelativeImageRotation(r1, r4, r3)
            android.util.Rational r9 = r9.getAspectRatio()
            r3 = 90
            if (r1 == r3) goto L56
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L64
        L56:
            android.util.Rational r1 = new android.util.Rational
            int r3 = r9.getDenominator()
            int r9 = r9.getNumerator()
            r1.<init>(r3, r9)
            r9 = r1
        L64:
            android.util.Rational r1 = androidx.camera.core.impl.utils.AspectRatioUtil.ASPECT_RATIO_4_3
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L6d
            return r0
        L6d:
            android.util.Rational r0 = androidx.camera.core.impl.utils.AspectRatioUtil.ASPECT_RATIO_16_9
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L76
            return r2
        L76:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.CameraController.getViewportAspectRatioInt(androidx.camera.core.ViewPort):int");
    }

    private AspectRatioStrategy getViewportAspectRatioStrategy(ViewPort viewPort) {
        int viewportAspectRatioInt = getViewportAspectRatioInt(viewPort);
        if (viewportAspectRatioInt != -1) {
            return new AspectRatioStrategy(viewportAspectRatioInt, 1);
        }
        return null;
    }

    private boolean isCameraAttached() {
        return this.mCamera != null;
    }

    private boolean isCameraInitialized() {
        return this.mCameraProvider != null;
    }

    private boolean isOutputSizeEqual(OutputSize outputSize, OutputSize outputSize2) {
        if (outputSize == outputSize2) {
            return true;
        }
        return outputSize != null && outputSize.equals(outputSize2);
    }

    private boolean isPreviewViewAttached() {
        return (this.mSurfaceProvider == null || this.mViewPort == null) ? false : true;
    }

    private boolean isUseCaseEnabled(int i2) {
        return (i2 & this.mEnabledUseCases) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$new$0(ProcessCameraProviderWrapper processCameraProviderWrapper) {
        this.mCameraProvider = processCameraProviderWrapper;
        unbindAllAndRecreate();
        startCameraAndTrackStates();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i2) {
        this.mImageAnalysis.setTargetRotation(i2);
        this.mImageCapture.setTargetRotation(i2);
        this.mVideoCapture.setTargetRotation(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCameraSelector$3(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEnabledUseCases$2(int i2, int i8) {
        this.mEnabledUseCases = i2;
        Logger.w(TAG, "setEnabledUseCases: failed to enable use cases properly for enabledUseCases = " + Integer.toBinaryString(i8) + ", restoring back previous values " + Integer.toBinaryString(i2));
    }

    @MainThread
    private PendingRecording prepareRecording(OutputOptions outputOptions) {
        Recorder recorder = (Recorder) this.mVideoCapture.getOutput();
        if (outputOptions instanceof FileOutputOptions) {
            return recorder.prepareRecording(this.mAppContext, (FileOutputOptions) outputOptions);
        }
        if (outputOptions instanceof FileDescriptorOutputOptions) {
            if (Build.VERSION.SDK_INT >= 26) {
                return recorder.prepareRecording(this.mAppContext, (FileDescriptorOutputOptions) outputOptions);
            }
            throw new UnsupportedOperationException("File descriptors are not supported on pre-Android O (API 26) devices.");
        }
        if (outputOptions instanceof MediaStoreOutputOptions) {
            return recorder.prepareRecording(this.mAppContext, (MediaStoreOutputOptions) outputOptions);
        }
        throw new IllegalArgumentException("Unsupported OutputOptions type.");
    }

    private void restartCameraIfAnalyzerResolutionChanged(ImageAnalysis.Analyzer analyzer, ImageAnalysis.Analyzer analyzer2) {
        if (Objects.equals(analyzer == null ? null : analyzer.getDefaultTargetResolution(), analyzer2 != null ? analyzer2.getDefaultTargetResolution() : null)) {
            return;
        }
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    private void setActiveRecording(Recording recording, Consumer<VideoRecordEvent> consumer) {
        this.mRecordingMap.put(consumer, recording);
        this.mActiveRecording = recording;
    }

    private void setTargetOutputSize(ImageOutputConfig.Builder<?> builder, OutputSize outputSize) {
        if (outputSize == null) {
            return;
        }
        if (outputSize.getResolution() != null) {
            builder.setTargetResolution(outputSize.getResolution());
        } else {
            if (outputSize.getAspectRatio() != -1) {
                builder.setTargetAspectRatio(outputSize.getAspectRatio());
                return;
            }
            Logger.e(TAG, "Invalid target surface size. " + outputSize);
        }
    }

    private float speedUpZoomBy2X(float f4) {
        return f4 > 1.0f ? a1.a.a(f4, 1.0f, 2.0f, 1.0f) : 1.0f - ((1.0f - f4) * 2.0f);
    }

    private void startListeningToRotationEvents() {
        if (this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener)) {
            return;
        }
        Logger.w(TAG, "The device cannot detect rotation changes.");
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @MainThread
    private Recording startRecordingInternal(OutputOptions outputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        Preconditions.checkState(!isRecording(), VIDEO_RECORDING_UNFINISHED);
        Consumer<VideoRecordEvent> consumerWrapListenerToDeactivateRecordingOnFinalized = wrapListenerToDeactivateRecordingOnFinalized(consumer);
        PendingRecording pendingRecordingPrepareRecording = prepareRecording(outputOptions);
        if (audioConfig.getAudioEnabled()) {
            checkAudioPermissionGranted();
            pendingRecordingPrepareRecording.withAudioEnabled();
        }
        Recording recordingStart = pendingRecordingPrepareRecording.start(executor, consumerWrapListenerToDeactivateRecordingOnFinalized);
        setActiveRecording(recordingStart, consumerWrapListenerToDeactivateRecordingOnFinalized);
        return recordingStart;
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    @MainThread
    private void stopRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        if (recording != null) {
            recording.stop();
            deactivateRecording(this.mActiveRecording);
        }
    }

    private void throwExceptionForInvalidScreenFlashCapture() {
        if (getImageCaptureFlashMode() == 3) {
            if (getScreenFlashUiInfoByPriority() == null || getScreenFlashUiInfoByPriority().getScreenFlash() == null) {
                throw new IllegalStateException("No window set in PreviewView despite setting FLASH_MODE_SCREEN");
            }
        }
    }

    @MainThread
    private void unbindAllAndRecreate() {
        unbindPreviewAndRecreate();
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        unbindVideoAndRecreate();
    }

    @MainThread
    private void unbindImageAnalysisAndRecreate(Integer num, Integer num2, Integer num3) {
        ImageAnalysis.Analyzer analyzer;
        Threads.checkMainThread();
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        ImageAnalysis imageAnalysisCreateImageAnalysis = createImageAnalysis(num, num2, num3);
        this.mImageAnalysis = imageAnalysisCreateImageAnalysis;
        Executor executor = this.mAnalysisExecutor;
        if (executor == null || (analyzer = this.mAnalysisAnalyzer) == null) {
            return;
        }
        imageAnalysisCreateImageAnalysis.setAnalyzer(executor, analyzer);
    }

    @MainThread
    private void unbindImageCaptureAndRecreate(Integer num) {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        int flashMode = this.mImageCapture.getFlashMode();
        this.mImageCapture = createImageCapture(num);
        setImageCaptureFlashMode(flashMode);
    }

    @MainThread
    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mPreview);
        }
        Preview previewCreatePreview = createPreview();
        this.mPreview = previewCreatePreview;
        Preview.SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        if (surfaceProvider != null) {
            previewCreatePreview.setSurfaceProvider(surfaceProvider);
        }
    }

    @MainThread
    private void unbindVideoAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        this.mVideoCapture = createVideoCapture();
    }

    private Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized(Consumer<VideoRecordEvent> consumer) {
        return new AnonymousClass2(ContextCompat.getMainExecutor(this.mAppContext), consumer);
    }

    @MainThread
    public void attachPreviewSurface(Preview.SurfaceProvider surfaceProvider, ViewPort viewPort) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        boolean z2 = this.mViewPort == null || getViewportAspectRatioStrategy(viewPort) != getViewportAspectRatioStrategy(this.mViewPort);
        this.mViewPort = viewPort;
        startListeningToRotationEvents();
        if (z2) {
            unbindAllAndRecreate();
        }
        startCameraAndTrackStates();
    }

    @MainThread
    public void clearEffects() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbindAll();
        }
        this.mEffects.clear();
        startCameraAndTrackStates();
    }

    @MainThread
    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(analyzer, null);
    }

    @MainThread
    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        stopListeningToRotationEvents();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseGroup createUseCaseGroup() {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        }
        if (!isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        UseCaseGroup.Builder builderAddUseCase = new UseCaseGroup.Builder().addUseCase(this.mPreview);
        if (isImageCaptureEnabled()) {
            builderAddUseCase.addUseCase(this.mImageCapture);
        } else {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        if (isImageAnalysisEnabled()) {
            builderAddUseCase.addUseCase(this.mImageAnalysis);
        } else {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        if (isVideoCaptureEnabled()) {
            builderAddUseCase.addUseCase(this.mVideoCapture);
        } else {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        builderAddUseCase.setViewPort(this.mViewPort);
        Iterator<CameraEffect> it = this.mEffects.iterator();
        while (it.hasNext()) {
            builderAddUseCase.addEffect(it.next());
        }
        return builderAddUseCase.build();
    }

    @MainThread
    public void deactivateRecordingByListener(Consumer<VideoRecordEvent> consumer) {
        Recording recordingRemove = this.mRecordingMap.remove(consumer);
        if (recordingRemove != null) {
            deactivateRecording(recordingRemove);
        }
    }

    @MainThread
    public q enableTorch(boolean z2) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingEnableTorch.setValue(Boolean.valueOf(z2)) : this.mCamera.getCameraControl().enableTorch(z2);
    }

    @MainThread
    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraControl();
    }

    @MainThread
    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraInfo();
    }

    @MainThread
    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    @MainThread
    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    @MainThread
    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    @MainThread
    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    @MainThread
    public int getImageAnalysisOutputImageFormat() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getOutputImageFormat();
    }

    @MainThread
    public ResolutionSelector getImageAnalysisResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageAnalysisResolutionSelector;
    }

    @MainThread
    @Deprecated
    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    @MainThread
    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    @MainThread
    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    @MainThread
    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    @MainThread
    public ResolutionSelector getImageCaptureResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageCaptureResolutionSelector;
    }

    @MainThread
    @Deprecated
    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    public q getInitializationFuture() {
        return this.mInitializationFuture;
    }

    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DynamicRange getPreviewDynamicRange() {
        Threads.checkMainThread();
        return this.mPreviewDynamicRange;
    }

    @MainThread
    public ResolutionSelector getPreviewResolutionSelector() {
        Threads.checkMainThread();
        return this.mPreviewResolutionSelector;
    }

    @MainThread
    @Deprecated
    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ScreenFlashUiInfo getScreenFlashUiInfoByPriority() {
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> map = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType providerType = ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW;
        if (map.get(providerType) != null) {
            return this.mScreenFlashUiInfoMap.get(providerType);
        }
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> map2 = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType providerType2 = ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW;
        if (map2.get(providerType2) != null) {
            return this.mScreenFlashUiInfoMap.get(providerType2);
        }
        return null;
    }

    @MainThread
    public LiveData<TapToFocusInfo> getTapToFocusInfoState() {
        Threads.checkMainThread();
        return this.mTapToFocusInfoState;
    }

    @MainThread
    @Deprecated
    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    @MainThread
    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    @MainThread
    public DynamicRange getVideoCaptureDynamicRange() {
        Threads.checkMainThread();
        return this.mVideoCaptureDynamicRange;
    }

    @MainThread
    public int getVideoCaptureMirrorMode() {
        Threads.checkMainThread();
        return this.mVideoCaptureMirrorMode;
    }

    @MainThread
    public QualitySelector getVideoCaptureQualitySelector() {
        Threads.checkMainThread();
        return this.mVideoCaptureQualitySelector;
    }

    @MainThread
    public Range<Integer> getVideoCaptureTargetFrameRate() {
        Threads.checkMainThread();
        return this.mVideoCaptureTargetFrameRate;
    }

    @MainThread
    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    @MainThread
    public boolean hasCamera(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(cameraSelector);
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper == null) {
            throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
        }
        try {
            return processCameraProviderWrapper.hasCamera(cameraSelector);
        } catch (CameraInfoUnavailableException e) {
            Logger.w(TAG, "Failed to check camera availability", e);
            return false;
        }
    }

    @MainThread
    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    @MainThread
    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    @MainThread
    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    @MainThread
    public boolean isRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        return (recording == null || recording.isClosed()) ? false : true;
    }

    @MainThread
    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    @MainThread
    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    public void onPinchToZoom(float f4) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mPinchToZoomEnabled) {
            Logger.d(TAG, "Pinch to zoom disabled.");
            return;
        }
        Logger.d(TAG, "Pinch to zoom with scale: " + f4);
        ZoomState value = getZoomState().getValue();
        if (value == null) {
            return;
        }
        setZoomRatio(Math.min(Math.max(value.getZoomRatio() * speedUpZoomBy2X(f4), value.getMinZoomRatio()), value.getMaxZoomRatio()));
    }

    public void onTapToFocus(MeteringPointFactory meteringPointFactory, float f4, float f8) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mTapToFocusEnabled) {
            Logger.d(TAG, "Tap to focus disabled. ");
            return;
        }
        PointF pointF = new PointF(f4, f8);
        FocusMeteringAction focusMeteringActionCreateFocusMeteringAction = createFocusMeteringAction(meteringPointFactory, pointF);
        Logger.d(TAG, "Tap to focus started: " + f4 + ", " + f8);
        FocusMeteringResultCallback focusMeteringResultCallback = this.mFocusMeteringResultCallback;
        if (focusMeteringResultCallback != null) {
            focusMeteringResultCallback.close();
        }
        this.mTapToFocusInfoState.postValue(new TapToFocusInfo(1, pointF));
        FocusMeteringResultCallback focusMeteringResultCallback2 = new FocusMeteringResultCallback(pointF, this.mTapToFocusInfoState);
        this.mFocusMeteringResultCallback = focusMeteringResultCallback2;
        Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(focusMeteringActionCreateFocusMeteringAction), focusMeteringResultCallback2, CameraXExecutors.directExecutor());
        long millis = TimeUnit.NANOSECONDS.toMillis(this.mTapToFocusAutoCancelDurationNanos);
        Logger.d(TAG, "Tap to focus auto cancel duration: " + millis + " ms");
        if (millis > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(focusMeteringResultCallback2, 0), millis);
        }
    }

    @MainThread
    public void setCameraSelector(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        if (this.mCameraSelector == cameraSelector) {
            return;
        }
        Integer lensFacing = cameraSelector.getLensFacing();
        int i2 = 3;
        if (this.mImageCapture.getFlashMode() == 3 && lensFacing != null && lensFacing.intValue() != 0) {
            throw new IllegalStateException("Not a front camera despite setting FLASH_MODE_SCREEN");
        }
        CameraSelector cameraSelector2 = this.mCameraSelector;
        this.mCameraSelector = cameraSelector;
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper == null) {
            return;
        }
        processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        startCameraAndTrackStates(new j(i2, this, cameraSelector2));
    }

    @MainThread
    public void setEffects(Set<CameraEffect> set) {
        Threads.checkMainThread();
        if (Objects.equals(this.mEffects, set)) {
            return;
        }
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbindAll();
        }
        this.mEffects.clear();
        this.mEffects.addAll(set);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setEnabledUseCases(int i2) {
        Threads.checkMainThread();
        int i8 = this.mEnabledUseCases;
        if (i2 == i8) {
            return;
        }
        this.mEnabledUseCases = i2;
        if (!isVideoCaptureEnabled() && isRecording()) {
            stopRecording();
        }
        startCameraAndTrackStates(new androidx.camera.core.processing.o(this, i8, i2, 1));
    }

    @MainThread
    public void setImageAnalysisAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer2 = this.mAnalysisAnalyzer;
        if (analyzer2 == analyzer && this.mAnalysisExecutor == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = analyzer;
        this.mImageAnalysis.setAnalyzer(executor, analyzer);
        restartCameraIfAnalyzerResolutionChanged(analyzer2, analyzer);
    }

    @MainThread
    public void setImageAnalysisBackgroundExecutor(Executor executor) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor == executor) {
            return;
        }
        this.mAnalysisBackgroundExecutor = executor;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisBackpressureStrategy(int i2) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() == i2) {
            return;
        }
        unbindImageAnalysisAndRecreate(Integer.valueOf(i2), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisImageQueueDepth(int i2) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() == i2) {
            return;
        }
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(i2), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisOutputImageFormat(int i2) {
        Threads.checkMainThread();
        if (i2 == this.mImageAnalysis.getOutputImageFormat()) {
            return;
        }
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(i2));
    }

    @MainThread
    public void setImageAnalysisResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        if (this.mImageAnalysisResolutionSelector == resolutionSelector) {
            return;
        }
        this.mImageAnalysisResolutionSelector = resolutionSelector;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    @Deprecated
    public void setImageAnalysisTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, outputSize)) {
            return;
        }
        this.mImageAnalysisTargetSize = outputSize;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureFlashMode(int i2) {
        Threads.checkMainThread();
        if (i2 == 3) {
            Integer lensFacing = this.mCameraSelector.getLensFacing();
            if (lensFacing != null && lensFacing.intValue() != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
            }
            updateScreenFlashToImageCapture();
        }
        this.mImageCapture.setFlashMode(i2);
    }

    @MainThread
    public void setImageCaptureIoExecutor(Executor executor) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor == executor) {
            return;
        }
        this.mImageCaptureIoExecutor = executor;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureMode(int i2) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() == i2) {
            return;
        }
        unbindImageCaptureAndRecreate(Integer.valueOf(i2));
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        if (this.mImageCaptureResolutionSelector == resolutionSelector) {
            return;
        }
        this.mImageCaptureResolutionSelector = resolutionSelector;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    @MainThread
    @Deprecated
    public void setImageCaptureTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, outputSize)) {
            return;
        }
        this.mImageCaptureTargetSize = outputSize;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    @MainThread
    public q setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingLinearZoom.setValue(Float.valueOf(f4)) : this.mCamera.getCameraControl().setLinearZoom(f4);
    }

    @MainThread
    public void setPinchToZoomEnabled(boolean z2) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = z2;
    }

    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setPreviewDynamicRange(DynamicRange dynamicRange) {
        Threads.checkMainThread();
        this.mPreviewDynamicRange = dynamicRange;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setPreviewResolutionSelector(ResolutionSelector resolutionSelector) {
        Threads.checkMainThread();
        if (this.mPreviewResolutionSelector == resolutionSelector) {
            return;
        }
        this.mPreviewResolutionSelector = resolutionSelector;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    @Deprecated
    public void setPreviewTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mPreviewTargetSize, outputSize)) {
            return;
        }
        this.mPreviewTargetSize = outputSize;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setScreenFlashUiInfo(ScreenFlashUiInfo screenFlashUiInfo) {
        ScreenFlashUiInfo screenFlashUiInfoByPriority = getScreenFlashUiInfoByPriority();
        this.mScreenFlashUiInfoMap.put(screenFlashUiInfo.getProviderType(), screenFlashUiInfo);
        ScreenFlashUiInfo screenFlashUiInfoByPriority2 = getScreenFlashUiInfoByPriority();
        if (screenFlashUiInfoByPriority2 == null || screenFlashUiInfoByPriority2.equals(screenFlashUiInfoByPriority)) {
            return;
        }
        updateScreenFlashToImageCapture();
    }

    @MainThread
    public void setTapToFocusAutoCancelDuration(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j >= 0, "Tap-to-focus auto-cancellation duration must be at least 0");
        this.mTapToFocusAutoCancelDurationNanos = timeUnit.toNanos(j);
        Logger.d(TAG, "setTapToFocusAutoCancelDuration: " + this.mTapToFocusAutoCancelDurationNanos + " ns set!");
    }

    @MainThread
    public void setTapToFocusEnabled(boolean z2) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = z2;
    }

    @MainThread
    public void setVideoCaptureDynamicRange(DynamicRange dynamicRange) {
        Threads.checkMainThread();
        this.mVideoCaptureDynamicRange = dynamicRange;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setVideoCaptureMirrorMode(int i2) {
        Threads.checkMainThread();
        this.mVideoCaptureMirrorMode = i2;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setVideoCaptureQualitySelector(QualitySelector qualitySelector) {
        Threads.checkMainThread();
        this.mVideoCaptureQualitySelector = qualitySelector;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setVideoCaptureTargetFrameRate(Range<Integer> range) {
        Threads.checkMainThread();
        this.mVideoCaptureTargetFrameRate = range;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public q setZoomRatio(float f4) {
        Threads.checkMainThread();
        return !isCameraAttached() ? this.mPendingZoomRatio.setValue(Float.valueOf(f4)) : this.mCamera.getCameraControl().setZoomRatio(f4);
    }

    public abstract Camera startCamera();

    public void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    @MainThread
    public Recording startRecording(FileOutputOptions fileOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileOutputOptions, audioConfig, executor, consumer);
    }

    @MainThread
    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.lambda$takePicture$2(outputFileOptions, executor, onImageSavedCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() == null || outputFileOptions.getMetadata().isReversedHorizontalSet()) {
            return;
        }
        outputFileOptions.getMetadata().setReversedHorizontal(this.mCameraSelector.getLensFacing().intValue() == 0);
    }

    @OptIn(markerClass = {TransformExperimental.class})
    @MainThread
    public void updatePreviewViewTransform(Matrix matrix) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        if (analyzer != null && analyzer.getTargetCoordinateSystem() == 1) {
            this.mAnalysisAnalyzer.updateTransform(matrix);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void updateScreenFlashToImageCapture() {
        ScreenFlashUiInfo screenFlashUiInfoByPriority = getScreenFlashUiInfoByPriority();
        if (screenFlashUiInfoByPriority == null) {
            Logger.d(TAG, "No ScreenFlash instance set yet, need to wait for controller to be set to either ScreenFlashView or PreviewView");
            this.mImageCapture.setScreenFlash(NO_OP_SCREEN_FLASH);
        } else {
            this.mImageCapture.setScreenFlash(screenFlashUiInfoByPriority.getScreenFlash());
            Logger.d(TAG, "Set ScreenFlash instance to ImageCapture, provided by " + screenFlashUiInfoByPriority.getProviderType().name());
        }
    }

    public void startCameraAndTrackStates(Runnable runnable) {
        try {
            this.mCamera = startCamera();
            if (!isCameraAttached()) {
                Logger.d(TAG, CAMERA_NOT_ATTACHED);
                return;
            }
            this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
            this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
            this.mPendingEnableTorch.propagateIfHasValue(new b(this, 1));
            this.mPendingLinearZoom.propagateIfHasValue(new b(this, 2));
            this.mPendingZoomRatio.propagateIfHasValue(new b(this, 3));
        } catch (RuntimeException e) {
            if (runnable != null) {
                runnable.run();
            }
            throw e;
        }
    }

    @RequiresApi(26)
    @MainThread
    public Recording startRecording(FileDescriptorOutputOptions fileDescriptorOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileDescriptorOutputOptions, audioConfig, executor, consumer);
    }

    @MainThread
    public Recording startRecording(MediaStoreOutputOptions mediaStoreOutputOptions, AudioConfig audioConfig, Executor executor, Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(mediaStoreOutputOptions, audioConfig, executor, consumer);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Deprecated
    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        private final Size mResolution;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface OutputAspectRatio {
        }

        public OutputSize(int i2) {
            Preconditions.checkArgument(i2 != -1);
            this.mAspectRatio = i2;
            this.mResolution = null;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        public Size getResolution() {
            return this.mResolution;
        }

        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }

        public OutputSize(Size size) {
            Preconditions.checkNotNull(size);
            this.mAspectRatio = -1;
            this.mResolution = size;
        }
    }

    public CameraController(Context context, q qVar) {
        this.mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mEnabledUseCases = 3;
        this.mActiveRecording = null;
        this.mRecordingMap = new HashMap();
        this.mVideoCaptureQualitySelector = Recorder.DEFAULT_QUALITY_SELECTOR;
        this.mVideoCaptureMirrorMode = 0;
        DynamicRange dynamicRange = DynamicRange.UNSPECIFIED;
        this.mVideoCaptureDynamicRange = dynamicRange;
        this.mPreviewDynamicRange = dynamicRange;
        this.mVideoCaptureTargetFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        this.mPinchToZoomEnabled = true;
        this.mTapToFocusEnabled = true;
        this.mZoomState = new ForwardingLiveData<>();
        this.mTorchState = new ForwardingLiveData<>();
        MutableLiveData<TapToFocusInfo> mutableLiveData = new MutableLiveData<>(new TapToFocusInfo(0, null));
        this.mTapToFocusInfoState = mutableLiveData;
        final int i2 = 1;
        this.mTapToFocusState = LiveDataUtil.map(mutableLiveData, new Function() { // from class: androidx.camera.view.c
            @Override // androidx.arch.core.util.Function, m0.f, x4.c
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        return new ProcessCameraProviderWrapperImpl((ProcessCameraProvider) obj);
                    default:
                        return Integer.valueOf(((TapToFocusInfo) obj).getFocusState());
                }
            }
        });
        this.mPendingEnableTorch = new PendingValue<>();
        this.mPendingLinearZoom = new PendingValue<>();
        this.mPendingZoomRatio = new PendingValue<>();
        this.mEffects = new HashSet();
        this.mScreenFlashUiInfoMap = new HashMap();
        this.mTapToFocusAutoCancelDurationNanos = TimeUnit.MILLISECONDS.toNanos(5000L);
        Context applicationContext = ContextUtil.getApplicationContext(context);
        this.mAppContext = applicationContext;
        this.mPreview = createPreview();
        this.mImageCapture = createImageCapture(null);
        this.mImageAnalysis = createImageAnalysis(null, null, null);
        this.mVideoCapture = createVideoCapture();
        this.mInitializationFuture = Futures.transform(qVar, new b(this, 0), CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(applicationContext);
        this.mDeviceRotationListener = new b(this, 4);
    }

    @MainThread
    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        this.mImageCapture.lambda$takePicture$1(executor, onImageCapturedCallback);
    }
}
