package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageAnalysis extends UseCase {
    public static final int COORDINATE_SYSTEM_ORIGINAL = 0;
    public static final int COORDINATE_SYSTEM_SENSOR = 2;
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
    private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
    private static final int DEFAULT_OUTPUT_IMAGE_FORMAT = 1;
    private static final boolean DEFAULT_OUTPUT_IMAGE_ROTATION_ENABLED = false;
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int OUTPUT_IMAGE_FORMAT_NV21 = 3;
    public static final int OUTPUT_IMAGE_FORMAT_RGBA_8888 = 2;
    public static final int OUTPUT_IMAGE_FORMAT_YUV_420_888 = 1;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private DeferrableSurface mDeferrableSurface;

    @GuardedBy("mAnalysisLock")
    ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;

    @GuardedBy("mAnalysisLock")
    private Matrix mSensorToBufferTransformMatrix;
    SessionConfig.Builder mSessionConfigBuilder;

    @GuardedBy("mAnalysisLock")
    private Analyzer mSubscribedAnalyzer;

    @GuardedBy("mAnalysisLock")
    private Executor mSubscribedAnalyzerExecutor;

    @GuardedBy("mAnalysisLock")
    private Rect mViewPortCropRect;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final Boolean DEFAULT_ONE_PIXEL_SHIFT_ENABLED = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Analyzer {
        void analyze(ImageProxy imageProxy);

        Size getDefaultTargetResolution();

        int getTargetCoordinateSystem();

        void updateTransform(Matrix matrix);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface BackpressureStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder implements ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder>, UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, Builder>, ImageInputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public Builder setBackpressureStrategy(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setCustomOrderedResolutions(List list) {
            return setCustomOrderedResolutions((List<Size>) list);
        }

        public Builder setImageQueueDepth(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i2));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, imageReaderProxyProvider);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setOnePixelShiftEnabled(boolean z2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_ONE_PIXEL_SHIFT_ENABLED, Boolean.valueOf(z2));
            return this;
        }

        public Builder setOutputImageFormat(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_FORMAT, Integer.valueOf(i2));
            return this;
        }

        @RequiresApi(23)
        public Builder setOutputImageRotationEnabled(boolean z2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, Boolean.valueOf(z2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setTargetClass(Class cls) {
            return setTargetClass((Class<ImageAnalysis>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageAnalysis.class)) {
                setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
                setTargetClass(ImageAnalysis.class);
            } else {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(ImageAnalysisConfig imageAnalysisConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageAnalysisConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public ImageAnalysis build() {
            ImageAnalysisConfig useCaseConfig = getUseCaseConfig();
            androidx.camera.core.impl.t.s(useCaseConfig);
            return new ImageAnalysis(useCaseConfig);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ImageAnalysisConfig getUseCaseConfig() {
            return new ImageAnalysisConfig(OptionsBundle.from(this.mMutableConfig));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public Builder setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCustomOrderedResolutions(List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultSessionConfig(androidx.camera.core.impl.SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setDynamicRange(DynamicRange dynamicRange) {
            if (!Objects.equals(DynamicRange.SDR, dynamicRange)) {
                throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
            }
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setHighResolutionDisabled(boolean z2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMirrorMode(int i2) {
            throw new UnsupportedOperationException("setMirrorMode is not supported.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setStreamUseCase(StreamUseCase streamUseCase) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_STREAM_USE_CASE, streamUseCase);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSurfaceOccupancyPriority(int i2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @Deprecated
        public Builder setTargetAspectRatio(int i2) {
            if (i2 == -1) {
                i2 = 0;
            }
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(Class<ImageAnalysis> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @Deprecated
        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetRotation(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setZslDisabled(boolean z2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z2));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<ImageAnalysisConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageAnalysisConfig DEFAULT_CONFIG;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
        private static final Size DEFAULT_TARGET_RESOLUTION;

        static {
            Size size = new Size(640, 480);
            DEFAULT_TARGET_RESOLUTION = size;
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(new ResolutionStrategy(SizeUtil.RESOLUTION_VGA, 1)).build();
            DEFAULT_RESOLUTION_SELECTOR = resolutionSelectorBuild;
            DEFAULT_CONFIG = new Builder().setDefaultResolution(size).setSurfaceOccupancyPriority(1).setTargetAspectRatio(0).setResolutionSelector(resolutionSelectorBuild).setDynamicRange(dynamicRange).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public ImageAnalysisConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface OutputImageFormat {
    }

    public ImageAnalysis(ImageAnalysisConfig imageAnalysisConfig) {
        super(imageAnalysisConfig);
        this.mAnalysisLock = new Object();
    }

    private boolean isFlipWH(CameraInternal cameraInternal) {
        return isOutputImageRotationEnabled() && getRelativeRotation(cameraInternal) % 180 != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPipeline$1(SafeCloseImageReaderProxy safeCloseImageReaderProxy, SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        safeCloseImageReaderProxy.safeClose();
        if (safeCloseImageReaderProxy2 != null) {
            safeCloseImageReaderProxy2.safeClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$2(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, androidx.camera.core.impl.SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (getCamera() == null) {
            return;
        }
        clearPipeline();
        imageAnalysisAbstractAnalyzer.clearCache();
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageAnalysisConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyReset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$onMergeConfig$0(Size size, List list, int i2) {
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.contains(size)) {
            arrayList.remove(size);
            arrayList.add(0, size);
        }
        return arrayList;
    }

    private void recreateImageAnalysisAbstractAnalyzer() {
        Analyzer analyzer;
        synchronized (this.mAnalysisLock) {
            try {
                ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) getCurrentConfig();
                if (imageAnalysisConfig.getBackpressureStrategy(0) == 1) {
                    this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisBlockingAnalyzer();
                } else {
                    this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisNonBlockingAnalyzer(androidx.camera.core.internal.g.b(imageAnalysisConfig, CameraXExecutors.highPriorityExecutor()));
                }
                this.mImageAnalysisAbstractAnalyzer.setOutputImageFormat(getOutputImageFormat());
                this.mImageAnalysisAbstractAnalyzer.setOutputImageRotationEnabled(isOutputImageRotationEnabled());
                CameraInternal camera = getCamera();
                Boolean onePixelShiftEnabled = getOnePixelShiftEnabled();
                boolean zContains = camera != null ? camera.getCameraInfoInternal().getCameraQuirks().contains(OnePixelShiftQuirk.class) : false;
                ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
                if (onePixelShiftEnabled != null) {
                    zContains = onePixelShiftEnabled.booleanValue();
                }
                imageAnalysisAbstractAnalyzer.setOnePixelShiftEnabled(zContains);
                if (camera != null) {
                    this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(getRelativeRotation(camera));
                }
                Rect rect = this.mViewPortCropRect;
                if (rect != null) {
                    this.mImageAnalysisAbstractAnalyzer.setViewPortCropRect(rect);
                }
                Matrix matrix = this.mSensorToBufferTransformMatrix;
                if (matrix != null) {
                    this.mImageAnalysisAbstractAnalyzer.setSensorToBufferTransformMatrix(matrix);
                }
                Executor executor = this.mSubscribedAnalyzerExecutor;
                if (executor != null && (analyzer = this.mSubscribedAnalyzer) != null) {
                    this.mImageAnalysisAbstractAnalyzer.setAnalyzer(executor, analyzer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void tryUpdateRelativeRotation() {
        synchronized (this.mAnalysisLock) {
            try {
                CameraInternal camera = getCamera();
                if (camera != null) {
                    this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(getRelativeRotation(camera));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearAnalyzer() {
        synchronized (this.mAnalysisLock) {
            try {
                ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
                if (imageAnalysisAbstractAnalyzer != null) {
                    imageAnalysisAbstractAnalyzer.setAnalyzer(null, null);
                }
                if (this.mSubscribedAnalyzer != null) {
                    notifyInactive();
                }
                this.mSubscribedAnalyzerExecutor = null;
                this.mSubscribedAnalyzer = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearPipeline() {
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mDeferrableSurface = null;
        }
    }

    public SessionConfig.Builder createPipeline(String str, ImageAnalysisConfig imageAnalysisConfig, StreamSpec streamSpec) {
        final ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer;
        Threads.checkMainThread();
        Size resolution = streamSpec.getResolution();
        Executor executorHighPriorityExecutor = CameraXExecutors.highPriorityExecutor();
        imageAnalysisConfig.getClass();
        Executor executor = (Executor) Preconditions.checkNotNull(androidx.camera.core.internal.g.b(imageAnalysisConfig, executorHighPriorityExecutor));
        boolean z2 = true;
        int imageQueueDepth = getBackpressureStrategy() == 1 ? getImageQueueDepth() : 4;
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = imageAnalysisConfig.getImageReaderProxyProvider() != null ? new SafeCloseImageReaderProxy(imageAnalysisConfig.getImageReaderProxyProvider().newInstance(resolution.getWidth(), resolution.getHeight(), getImageFormat(), imageQueueDepth, 0L)) : new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(resolution.getWidth(), resolution.getHeight(), getImageFormat(), imageQueueDepth));
        synchronized (this.mAnalysisLock) {
            recreateImageAnalysisAbstractAnalyzer();
            imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
        }
        boolean zIsFlipWH = getCamera() != null ? isFlipWH(getCamera()) : false;
        int height = zIsFlipWH ? resolution.getHeight() : resolution.getWidth();
        int width = zIsFlipWH ? resolution.getWidth() : resolution.getHeight();
        int i2 = getOutputImageFormat() == 2 ? 1 : 35;
        boolean z7 = getImageFormat() == 35 && getOutputImageFormat() == 2;
        boolean z8 = getImageFormat() == 35 && getOutputImageFormat() == 3;
        if (getImageFormat() != 35 || ((getCamera() == null || getRelativeRotation(getCamera()) == 0) && !Boolean.TRUE.equals(getOnePixelShiftEnabled()))) {
            z2 = false;
        }
        SafeCloseImageReaderProxy safeCloseImageReaderProxy2 = (z7 || (z2 && !z8)) ? new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(height, width, i2, safeCloseImageReaderProxy.getMaxImages())) : null;
        if (safeCloseImageReaderProxy2 != null) {
            imageAnalysisAbstractAnalyzer.setProcessedImageReaderProxy(safeCloseImageReaderProxy2);
        }
        tryUpdateRelativeRotation();
        safeCloseImageReaderProxy.setOnImageAvailableListener(imageAnalysisAbstractAnalyzer, executor);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(imageAnalysisConfig, streamSpec.getResolution());
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(safeCloseImageReaderProxy.getSurface(), resolution, getImageFormat());
        this.mDeferrableSurface = immediateSurface;
        immediateSurface.getTerminationFuture().addListener(new a(2, safeCloseImageReaderProxy, safeCloseImageReaderProxy2), CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.setSessionType(streamSpec.getSessionType());
        applyExpectedFrameRateRange(builderCreateFrom, streamSpec);
        builderCreateFrom.addSurface(this.mDeferrableSurface, streamSpec.getDynamicRange(), null, -1);
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.n
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(androidx.camera.core.impl.SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.f3676a.lambda$createPipeline$2(imageAnalysisAbstractAnalyzer, sessionConfig, sessionError);
            }
        });
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateFrom.setErrorListener(closeableErrorListener2);
        return builderCreateFrom;
    }

    @ExperimentalUseCaseApi
    public Executor getBackgroundExecutor() {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) getCurrentConfig();
        imageAnalysisConfig.getClass();
        return androidx.camera.core.internal.g.b(imageAnalysisConfig, null);
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getBackpressureStrategy(0);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        ImageAnalysisConfig config = defaults.getConfig();
        config.getClass();
        Config config2 = useCaseConfigFactory.getConfig(UseCaseConfig.CC.c(config), 1);
        if (z2) {
            config2 = androidx.camera.core.impl.o.b(config2, defaults.getConfig());
        }
        if (config2 == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config2).getUseCaseConfig();
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getImageQueueDepth(6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Boolean getOnePixelShiftEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOnePixelShiftEnabled(DEFAULT_ONE_PIXEL_SHIFT_ENABLED);
    }

    public int getOutputImageFormat() {
        return ((ImageAnalysisConfig) getCurrentConfig()).getOutputImageFormat(1);
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    public boolean isOutputImageRotationEnabled() {
        return ((ImageAnalysisConfig) getCurrentConfig()).isOutputImageRotationEnabled(Boolean.FALSE).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        Size defaultTargetResolution;
        synchronized (this.mAnalysisLock) {
            try {
                Analyzer analyzer = this.mSubscribedAnalyzer;
                defaultTargetResolution = analyzer != null ? analyzer.getDefaultTargetResolution() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (defaultTargetResolution == null) {
            return builder.getUseCaseConfig();
        }
        if (cameraInfoInternal.getSensorRotationDegrees(((Integer) builder.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, 0)).intValue()) % 180 == 90) {
            defaultTargetResolution = new Size(defaultTargetResolution.getHeight(), defaultTargetResolution.getWidth());
        }
        UseCaseConfig useCaseConfig = builder.getUseCaseConfig();
        Config.Option<Size> option = ImageOutputConfig.OPTION_TARGET_RESOLUTION;
        if (!useCaseConfig.containsOption(option)) {
            builder.getMutableConfig().insertOption(option, defaultTargetResolution);
        }
        UseCaseConfig useCaseConfig2 = builder.getUseCaseConfig();
        Config.Option option2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (useCaseConfig2.containsOption(option2)) {
            ResolutionSelector resolutionSelector = (ResolutionSelector) getAppConfig().retrieveOption(option2, null);
            ResolutionSelector.Builder builder2 = resolutionSelector == null ? new ResolutionSelector.Builder() : ResolutionSelector.Builder.fromResolutionSelector(resolutionSelector);
            if (resolutionSelector == null || resolutionSelector.getResolutionStrategy() == null) {
                builder2.setResolutionStrategy(new ResolutionStrategy(defaultTargetResolution, 1));
            }
            if (resolutionSelector == null) {
                builder2.setResolutionFilter(new m(defaultTargetResolution));
            }
            builder.getMutableConfig().insertOption(option2, builder2.build());
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        Object[] objArr = {this.mSessionConfigBuilder.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec, StreamSpec streamSpec2) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + streamSpec + ", secondaryStreamSpec " + streamSpec2);
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageAnalysisConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnbind() {
        clearPipeline();
        synchronized (this.mAnalysisLock) {
            this.mImageAnalysisAbstractAnalyzer.detach();
            this.mImageAnalysisAbstractAnalyzer = null;
        }
    }

    public void setAnalyzer(Executor executor, Analyzer analyzer) {
        synchronized (this.mAnalysisLock) {
            try {
                ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
                if (imageAnalysisAbstractAnalyzer != null) {
                    imageAnalysisAbstractAnalyzer.setAnalyzer(executor, new m(analyzer));
                }
                if (this.mSubscribedAnalyzer == null) {
                    notifyActive();
                }
                this.mSubscribedAnalyzerExecutor = executor;
                this.mSubscribedAnalyzer = analyzer;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        super.setSensorToBufferTransformMatrix(matrix);
        synchronized (this.mAnalysisLock) {
            try {
                ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
                if (imageAnalysisAbstractAnalyzer != null) {
                    imageAnalysisAbstractAnalyzer.setSensorToBufferTransformMatrix(matrix);
                }
                this.mSensorToBufferTransformMatrix = matrix;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setTargetRotation(int i2) {
        if (setTargetRotationInternal(i2)) {
            tryUpdateRelativeRotation();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(Rect rect) {
        super.setViewPortCropRect(rect);
        synchronized (this.mAnalysisLock) {
            try {
                ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
                if (imageAnalysisAbstractAnalyzer != null) {
                    imageAnalysisAbstractAnalyzer.setViewPortCropRect(rect);
                }
                this.mViewPortCropRect = rect;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "ImageAnalysis:" + getName();
    }
}
