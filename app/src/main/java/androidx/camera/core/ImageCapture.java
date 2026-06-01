package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.feature.ImageFormatFeature;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.PostviewSettings;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.ScreenFlashWrapper;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;

    @ExperimentalZeroShutterLag
    public static final int CAPTURE_MODE_ZERO_SHUTTER_LAG = 2;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    public static final int FLASH_MODE_SCREEN = 3;
    private static final int FLASH_MODE_UNKNOWN = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FLASH_TYPE_ONE_SHOT_FLASH = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FLASH_TYPE_USE_TORCH_AS_FLASH = 1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    public static final int OUTPUT_FORMAT_JPEG = 0;
    public static final int OUTPUT_FORMAT_JPEG_ULTRA_HDR = 1;
    public static final int OUTPUT_FORMAT_RAW = 2;
    public static final int OUTPUT_FORMAT_RAW_JPEG = 3;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long SCREEN_FLASH_UI_APPLY_TIMEOUT_SECONDS = 3;
    private static final String TAG = "ImageCapture";
    private final int mCaptureMode;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio;

    @GuardedBy("mLockedFlashMode")
    private int mFlashMode;
    private final int mFlashType;
    private final ImageCaptureControl mImageCaptureControl;
    private ImagePipeline mImagePipeline;

    @GuardedBy("mLockedFlashMode")
    private final AtomicReference<Integer> mLockedFlashMode;
    private ScreenFlashWrapper mScreenFlashWrapper;
    SessionConfig.Builder mSessionConfigBuilder;
    private TakePictureManager mTakePictureManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder>, ImageInputConfig.Builder<Builder> {
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

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBufferFormat(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(i2));
            return this;
        }

        public Builder setCaptureMode(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setCustomOrderedResolutions(List list) {
            return setCustomOrderedResolutions((List<Size>) list);
        }

        public Builder setFlashMode(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(i2));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setFlashType(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_TYPE, Integer.valueOf(i2));
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, imageReaderProxyProvider);
            return this;
        }

        public Builder setJpegQuality(@IntRange(from = 1, to = 100) int i2) {
            Preconditions.checkArgumentInRange(i2, 1, 100, "jpegQuality");
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(i2));
            return this;
        }

        public Builder setOutputFormat(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, Integer.valueOf(i2));
            return this;
        }

        public Builder setPostviewEnabled(boolean z2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.valueOf(z2));
            return this;
        }

        public Builder setPostviewResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        public Builder setScreenFlash(ScreenFlash screenFlash) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, screenFlash);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSoftwareJpegEncoderRequested(boolean z2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.valueOf(z2));
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
            return setTargetClass((Class<ImageCapture>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
                setTargetClass(ImageCapture.class);
            } else {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(ImageCaptureConfig imageCaptureConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public ImageCapture build() {
            Integer num = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num != null) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, num);
            } else if (ImageCapture.isOutputFormatRaw(getMutableConfig())) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 32);
            } else if (ImageCapture.isOutputFormatRawJpeg(getMutableConfig())) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 32);
                getMutableConfig().insertOption(ImageInputConfig.OPTION_SECONDARY_INPUT_FORMAT, 256);
            } else if (ImageCapture.isOutputFormatUltraHdr(getMutableConfig())) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            } else {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            }
            ImageCaptureConfig useCaseConfig = getUseCaseConfig();
            androidx.camera.core.impl.t.s(useCaseConfig);
            ImageCapture imageCapture = new ImageCapture(useCaseConfig);
            Size size = (Size) getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null);
            if (size != null) {
                imageCapture.setCropAspectRatio(new Rational(size.getWidth(), size.getHeight()));
            }
            Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(IoConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
            MutableConfig mutableConfig = getMutableConfig();
            Config.Option<Integer> option = ImageCaptureConfig.OPTION_FLASH_MODE;
            if (mutableConfig.containsOption(option)) {
                Integer num2 = (Integer) getMutableConfig().retrieveOption(option);
                if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
                }
                if (num2.intValue() == 3 && getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, null) == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
            return imageCapture;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
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
        @Override // androidx.camera.core.internal.IoConfig.Builder
        public Builder setIoExecutor(Executor executor) {
            getMutableConfig().insertOption(IoConfig.OPTION_IO_EXECUTOR, executor);
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
        public Builder setTargetClass(Class<ImageCapture> cls) {
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
    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface CaptureMode {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageCaptureConfig DEFAULT_CONFIG;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        private static final int DEFAULT_OUTPUT_FORMAT = 0;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR;
        private static final StreamUseCase DEFAULT_STREAM_USE_CASE;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        static {
            StreamUseCase streamUseCase = StreamUseCase.STILL_CAPTURE;
            DEFAULT_STREAM_USE_CASE = streamUseCase;
            ResolutionSelector resolutionSelectorBuild = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = resolutionSelectorBuild;
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setStreamUseCase(streamUseCase).setTargetAspectRatio(0).setResolutionSelector(resolutionSelectorBuild).setOutputFormat(0).setDynamicRange(dynamicRange).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FlashMode {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FlashType {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ImageCaptureCapabilitiesImpl implements ImageCaptureCapabilities {
        private final CameraInfo mCameraInfo;

        public ImageCaptureCapabilitiesImpl(CameraInfo cameraInfo) {
            this.mCameraInfo = cameraInfo;
        }

        private Set<Integer> getSupportedOutputFormatsFromAdapterCameraInfo() {
            Config config;
            CameraInfo cameraInfo = this.mCameraInfo;
            if (!(cameraInfo instanceof AdapterCameraInfo) || (config = ((AdapterCameraInfo) cameraInfo).getCameraConfig().getUseCaseConfigFactory().getConfig(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, 1)) == null) {
                return null;
            }
            Config.Option<List<Pair<Integer, Size[]>>> option = ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS;
            if (!config.containsOption(option)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(0);
            Iterator it = ((List) config.retrieveOption(option)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((Integer) ((Pair) it.next()).first).intValue() == 4101) {
                    hashSet.add(1);
                    break;
                }
            }
            return hashSet;
        }

        private boolean isRawSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (!(cameraInfo instanceof CameraInfoInternal)) {
                return false;
            }
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
            if (cameraInfoInternal.getAvailableCapabilities().contains(3)) {
                return cameraInfoInternal.getSupportedOutputFormats().contains(32);
            }
            return false;
        }

        private boolean isUltraHdrSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).getSupportedOutputFormats().contains(4101);
            }
            return false;
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public Set<Integer> getSupportedOutputFormats() {
            Set<Integer> supportedOutputFormatsFromAdapterCameraInfo = getSupportedOutputFormatsFromAdapterCameraInfo();
            if (supportedOutputFormatsFromAdapterCameraInfo != null) {
                return supportedOutputFormatsFromAdapterCameraInfo;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(0);
            if (isUltraHdrSupported()) {
                hashSet.add(1);
            }
            if (isRawSupported()) {
                hashSet.add(2);
                hashSet.add(3);
            }
            return hashSet;
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isCaptureProcessProgressSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).isCaptureProcessProgressSupported();
            }
            return false;
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isPostviewSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).isPostviewSupported();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImageCaptureError {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedHorizontalSet = false;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public Location getLocation() {
            return this.mLocation;
        }

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean isReversedHorizontalSet() {
            return this.mIsReversedHorizontalSet;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }

        public void setReversedHorizontal(boolean z2) {
            this.mIsReversedHorizontal = z2;
            this.mIsReversedHorizontalSet = true;
        }

        public void setReversedVertical(boolean z2) {
            this.mIsReversedVertical = z2;
        }

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.mIsReversedHorizontal + ", mIsReversedVertical=" + this.mIsReversedVertical + ", mLocation=" + this.mLocation + "}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnImageSavedCallback {
        void onCaptureProcessProgressed(int i2);

        void onCaptureStarted();

        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(OutputFileResults outputFileResults);

        void onPostviewBitmapAvailable(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class OutputFileOptions {
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        public OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, Metadata metadata) {
            this.mFile = file;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mOutputStream = outputStream;
            this.mMetadata = metadata == null ? new Metadata() : metadata;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public File getFile() {
            return this.mFile;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Metadata getMetadata() {
            return this.mMetadata;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.mFile + ", mContentResolver=" + this.mContentResolver + ", mSaveCollection=" + this.mSaveCollection + ", mContentValues=" + this.mContentValues + ", mOutputStream=" + this.mOutputStream + ", mMetadata=" + this.mMetadata + "}";
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public Builder(File file) {
                this.mFile = file;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder(OutputStream outputStream) {
                this.mOutputStream = outputStream;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class OutputFileResults {
        private final int mImageFormat;
        private final Uri mSavedUri;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OutputFileResults(Uri uri) {
            this(uri, 256);
        }

        public int getImageFormat() {
            return this.mImageFormat;
        }

        public Uri getSavedUri() {
            return this.mSavedUri;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OutputFileResults(Uri uri, int i2) {
            this.mSavedUri = uri;
            this.mImageFormat = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface OutputFormat {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ScreenFlash {
        @UiThread
        void apply(long j, ScreenFlashListener screenFlashListener);

        @UiThread
        void clear();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ScreenFlashListener {
        void onCompleted();
    }

    public ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        this.mClosingListener = new v();
        this.mLockedFlashMode = new AtomicReference<>(null);
        this.mFlashMode = -1;
        this.mCropAspectRatio = null;
        this.mImageCaptureControl = new ImageCaptureControl() { // from class: androidx.camera.core.ImageCapture.1
            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            @MainThread
            public void lockFlashMode() {
                ImageCapture.this.lockFlashMode();
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            @MainThread
            public j2.q submitStillCaptureRequests(List<CaptureConfig> list) {
                return ImageCapture.this.submitStillCaptureRequest(list);
            }

            @Override // androidx.camera.core.imagecapture.ImageCaptureControl
            @MainThread
            public void unlockFlashMode() {
                ImageCapture.this.unlockFlashMode();
            }
        };
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        imageCaptureConfig2.getClass();
        if (androidx.camera.core.impl.w.a(imageCaptureConfig2, option)) {
            this.mCaptureMode = imageCaptureConfig2.getCaptureMode();
        } else {
            this.mCaptureMode = 1;
        }
        this.mFlashType = imageCaptureConfig2.getFlashType(0);
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(imageCaptureConfig2.getScreenFlash());
    }

    @UiThread
    private void abortImageCaptureRequests() {
        this.mScreenFlashWrapper.completePendingTasks();
        TakePictureManager takePictureManager = this.mTakePictureManager;
        if (takePictureManager != null) {
            takePictureManager.abortRequests();
        }
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    private void applyFeatureGroupToConfig(UseCaseConfig.Builder<?, ?, ?> builder) {
        Set<GroupableFeature> featureGroup = getFeatureGroup();
        if (featureGroup != null) {
            int imageCaptureOutputFormat = 0;
            for (GroupableFeature groupableFeature : featureGroup) {
                if (groupableFeature instanceof ImageFormatFeature) {
                    imageCaptureOutputFormat = ((ImageFormatFeature) groupableFeature).getImageCaptureOutputFormat();
                }
            }
            builder.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, Integer.valueOf(imageCaptureOutputFormat));
        }
    }

    private PostviewSettings calculatePostviewSettings(int i2, Size size) {
        SessionProcessor sessionProcessor = getSessionProcessor();
        if (sessionProcessor != null) {
            Map<Integer, List<Size>> supportedPostviewSize = sessionProcessor.getSupportedPostviewSize(size);
            ArrayList arrayList = new ArrayList();
            if (isPostviewImageFormatSupported(supportedPostviewSize, 35)) {
                arrayList.add(35);
            }
            if (isPostviewImageFormatSupported(supportedPostviewSize, 256)) {
                arrayList.add(256);
            }
            if (isPostviewImageFormatSupported(supportedPostviewSize, 4101)) {
                arrayList.add(4101);
            }
            int iSelect = !arrayList.isEmpty() ? getCamera().getExtendedConfig().getPostviewFormatSelector().select(i2, arrayList) : 0;
            if (iSelect != 0) {
                List<Size> list = supportedPostviewSize.get(Integer.valueOf(iSelect));
                ResolutionSelector resolutionSelector = (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
                if (resolutionSelector == null) {
                    return PostviewSettings.create((Size) Collections.max(list, new CompareSizesByArea()), iSelect);
                }
                Collections.sort(list, new CompareSizesByArea(true));
                CameraInternal camera = getCamera();
                Rect sensorRect = camera.getCameraInfoInternal().getSensorRect();
                CameraInfoInternal cameraInfoInternal = camera.getCameraInfoInternal();
                List<Size> listSortSupportedOutputSizesByResolutionSelector = SupportedOutputSizesSorter.sortSupportedOutputSizesByResolutionSelector(resolutionSelector, list, null, getTargetRotation(), new Rational(sensorRect.width(), sensorRect.height()), cameraInfoInternal.getSensorRotationDegrees(), cameraInfoInternal.getLensFacing());
                if (listSortSupportedOutputSizesByResolutionSelector.isEmpty()) {
                    throw new IllegalArgumentException("The postview ResolutionSelector cannot select a valid size for the postview.");
                }
                return PostviewSettings.create(listSortSupportedOutputSizesByResolutionSelector.get(0), iSelect);
            }
        }
        return null;
    }

    @MainThread
    private void clearPipeline() {
        clearPipeline(false);
    }

    public static Rect computeDispatchCropRect(Rect rect, Rational rational, int i2, Size size, int i8) {
        if (rect != null) {
            return ImageUtil.computeCropRectFromDispatchInfo(rect, i2, size, i8);
        }
        if (rational != null) {
            if (i8 % 180 != 0) {
                rational = new Rational(rational.getDenominator(), rational.getNumerator());
            }
            if (ImageUtil.isAspectRatioValid(size, rational)) {
                Rect rectComputeCropRectFromAspectRatio = ImageUtil.computeCropRectFromAspectRatio(size, rational);
                Objects.requireNonNull(rectComputeCropRectFromAspectRatio);
                return rectComputeCropRectFromAspectRatio;
            }
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    @MainThread
    private SessionConfig.Builder createPipeline(String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec) {
        Threads.checkMainThread();
        int i2 = 0;
        Log.d(TAG, String.format("createPipeline(cameraId: %s, streamSpec: %s)", str, streamSpec));
        Size resolution = streamSpec.getResolution();
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        boolean z2 = !camera.getHasTransform();
        if (this.mImagePipeline != null) {
            Preconditions.checkState(z2);
            this.mImagePipeline.close();
        }
        Set<Integer> supportedOutputFormats = getImageCaptureCapabilities(getCamera().getCameraInfo()).getSupportedOutputFormats();
        Preconditions.checkArgument(supportedOutputFormats.contains(Integer.valueOf(getOutputFormat())), "The specified output format (" + getOutputFormat() + ") is not supported by current configuration. Supported output formats: " + supportedOutputFormats);
        CameraCharacteristics cameraCharacteristics = null;
        PostviewSettings postviewSettingsCalculatePostviewSettings = isPostviewEnabled() ? calculatePostviewSettings(imageCaptureConfig.getInputFormat(), resolution) : null;
        if (getCamera() != null) {
            try {
                Object cameraCharacteristics2 = getCamera().getCameraInfoInternal().getCameraCharacteristics();
                if (cameraCharacteristics2 instanceof CameraCharacteristics) {
                    cameraCharacteristics = (CameraCharacteristics) cameraCharacteristics2;
                }
            } catch (Exception e) {
                Log.e(TAG, "getCameraCharacteristics failed", e);
            }
        }
        this.mImagePipeline = new ImagePipeline(imageCaptureConfig, resolution, cameraCharacteristics, getEffect(), z2, postviewSettingsCalculatePostviewSettings);
        if (this.mTakePictureManager == null) {
            this.mTakePictureManager = getCurrentConfig().getTakePictureManagerProvider().newInstance(this.mImageCaptureControl);
        }
        this.mTakePictureManager.setImagePipeline(this.mImagePipeline);
        SessionConfig.Builder builderCreateSessionConfigBuilder = this.mImagePipeline.createSessionConfigBuilder(streamSpec.getResolution());
        builderCreateSessionConfigBuilder.setSessionType(streamSpec.getSessionType());
        if (getCaptureMode() == 2 && !streamSpec.getZslDisabled()) {
            getCameraControl().addZslConfig(builderCreateSessionConfigBuilder);
        }
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateSessionConfigBuilder.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new t(this, i2));
        this.mCloseableErrorListener = closeableErrorListener2;
        builderCreateSessionConfigBuilder.setErrorListener(closeableErrorListener2);
        return builderCreateSessionConfigBuilder;
    }

    private int getCameraLens() {
        CameraInternal camera = getCamera();
        if (camera != null) {
            return camera.getCameraInfo().getLensFacing();
        }
        return -1;
    }

    public static int getError(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        if (th instanceof ImageCaptureException) {
            return ((ImageCaptureException) th).getImageCaptureError();
        }
        return 0;
    }

    public static ImageCaptureCapabilities getImageCaptureCapabilities(CameraInfo cameraInfo) {
        return new ImageCaptureCapabilitiesImpl(cameraInfo);
    }

    @IntRange(from = 1, to = 100)
    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    private int getJpegQualityInternal() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY;
        imageCaptureConfig.getClass();
        if (androidx.camera.core.impl.w.a(imageCaptureConfig, option)) {
            return imageCaptureConfig.getJpegQuality();
        }
        int i2 = this.mCaptureMode;
        if (i2 == 0) {
            return 100;
        }
        if (i2 == 1 || i2 == 2) {
            return 95;
        }
        throw new IllegalStateException(a1.a.q(new StringBuilder("CaptureMode "), " is invalid", this.mCaptureMode));
    }

    private SessionProcessor getSessionProcessor() {
        return getCamera().getExtendedConfig().getSessionProcessor(null);
    }

    private Rect getTakePictureCropRect() {
        Rect viewPortCropRect = getViewPortCropRect();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        Objects.requireNonNull(attachedSurfaceResolution);
        if (viewPortCropRect != null) {
            return viewPortCropRect;
        }
        if (!ImageUtil.isAspectRatioValid(this.mCropAspectRatio)) {
            return new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        int relativeRotation = getRelativeRotation(camera);
        Rational rational = new Rational(this.mCropAspectRatio.getDenominator(), this.mCropAspectRatio.getNumerator());
        if (!TransformUtils.is90or270(relativeRotation)) {
            rational = this.mCropAspectRatio;
        }
        Rect rectComputeCropRectFromAspectRatio = ImageUtil.computeCropRectFromAspectRatio(attachedSurfaceResolution, rational);
        Objects.requireNonNull(rectComputeCropRectFromAspectRatio);
        return rectComputeCropRectFromAspectRatio;
    }

    private static boolean isImageFormatSupported(List<Pair<Integer, Size[]>> list, int i2) {
        if (list == null) {
            return false;
        }
        Iterator<Pair<Integer, Size[]>> it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next().first).equals(Integer.valueOf(i2))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isOutputFormatRaw(MutableConfig mutableConfig) {
        return Objects.equals(mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isOutputFormatRawJpeg(MutableConfig mutableConfig) {
        return Objects.equals(mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isOutputFormatUltraHdr(MutableConfig mutableConfig) {
        return Objects.equals(mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 1);
    }

    private boolean isPostviewImageFormatSupported(Map<Integer, List<Size>> map, int i2) {
        return map.containsKey(Integer.valueOf(i2)) && !map.get(Integer.valueOf(i2)).isEmpty();
    }

    private boolean isSessionProcessorEnabledInCurrentCamera() {
        return (getCamera() == null || getCamera().getExtendedConfig().getSessionProcessor(null) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$4(androidx.camera.core.impl.SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (getCamera() == null) {
            return;
        }
        this.mTakePictureManager.pause();
        clearPipeline(true);
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyReset();
        this.mTakePictureManager.resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            try {
                Log.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxyAcquireLatestImage);
                if (imageProxyAcquireLatestImage != null) {
                    imageProxyAcquireLatestImage.close();
                }
            } finally {
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to acquire latest image.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$submitStillCaptureRequest$5(List list) {
        return null;
    }

    private void sendInvalidCameraError(Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback) {
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + C2300e4.i.e, null);
        if (onImageCapturedCallback != null) {
            onImageCapturedCallback.onError(imageCaptureException);
        } else {
            if (onImageSavedCallback == null) {
                throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
            }
            onImageSavedCallback.onError(imageCaptureException);
        }
    }

    private void setScreenFlashToCameraControl() {
        setScreenFlashToCameraControl(this.mScreenFlashWrapper);
    }

    @MainThread
    private void takePictureInternal(Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback, OutputFileOptions outputFileOptions, OutputFileOptions outputFileOptions2) {
        Threads.checkMainThread();
        if (getFlashMode() == 3 && this.mScreenFlashWrapper.getBaseScreenFlash() == null) {
            throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
        }
        Log.d(TAG, "takePictureInternal");
        CameraInternal camera = getCamera();
        if (camera == null || !isInSession()) {
            sendInvalidCameraError(executor, onImageCapturedCallback, onImageSavedCallback);
            return;
        }
        boolean z2 = getCurrentConfig().getSecondaryInputFormat() != 0;
        if (z2 && outputFileOptions2 == null) {
            throw new IllegalArgumentException("Simultaneous capture RAW and JPEG needs two output file options");
        }
        if (!z2 && outputFileOptions2 != null) {
            throw new IllegalArgumentException("Non simultaneous capture cannot have two output file options");
        }
        TakePictureManager takePictureManager = this.mTakePictureManager;
        Objects.requireNonNull(takePictureManager);
        takePictureManager.offerRequest(TakePictureRequest.of(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, outputFileOptions2, getTakePictureCropRect(), getSensorToBufferTransformMatrix(), getRelativeRotation(camera), getJpegQualityInternal(), getCaptureMode(), z2, this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks()));
    }

    private void trySetFlashModeToCameraControl() {
        synchronized (this.mLockedFlashMode) {
            try {
                if (this.mLockedFlashMode.get() != null) {
                    return;
                }
                getCameraControl().setFlashMode(getFlashMode());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        boolean z2;
        Boolean bool = Boolean.TRUE;
        Config.Option<Boolean> option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean bool2 = Boolean.FALSE;
        boolean z7 = false;
        if (bool.equals(mutableConfig.retrieveOption(option, bool2))) {
            if (isSessionProcessorEnabledInCurrentCamera()) {
                Logger.w(TAG, "Software JPEG cannot be used with Extensions.");
                z2 = false;
            } else {
                z2 = true;
            }
            Integer num = (Integer) mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num == null || num.intValue() == 256) {
                z7 = z2;
            } else {
                Logger.w(TAG, "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z7) {
                Logger.w(TAG, "Unable to support software JPEG. Disabling.");
                mutableConfig.insertOption(option, bool2);
            }
        }
        return z7;
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        ImageCaptureConfig config = defaults.getConfig();
        config.getClass();
        Config config2 = useCaseConfigFactory.getConfig(UseCaseConfig.CC.c(config), getCaptureMode());
        if (z2) {
            config2 = androidx.camera.core.impl.o.b(config2, defaults.getConfig());
        }
        if (config2 == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config2).getUseCaseConfig();
    }

    public int getFlashMode() {
        int flashMode;
        synchronized (this.mLockedFlashMode) {
            flashMode = this.mFlashMode;
            if (flashMode == -1) {
                flashMode = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);
            }
        }
        return flashMode;
    }

    @VisibleForTesting
    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality() {
        return getJpegQualityInternal();
    }

    public int getOutputFormat() {
        return ((Integer) Preconditions.checkNotNull((Integer) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, 0))).intValue();
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
    }

    public ImageCaptureLatencyEstimate getRealtimeCaptureLatencyEstimate() {
        CameraInternal camera = getCamera();
        if (camera == null) {
            return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
        }
        SessionProcessor sessionProcessor = camera.getExtendedConfig().getSessionProcessor(null);
        Pair<Long, Long> realtimeCaptureLatency = sessionProcessor != null ? sessionProcessor.getRealtimeCaptureLatency() : null;
        return realtimeCaptureLatency == null ? ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY : new ImageCaptureLatencyEstimate(((Long) realtimeCaptureLatency.first).longValue(), ((Long) realtimeCaptureLatency.second).longValue());
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        Rational rational = this.mCropAspectRatio;
        if (viewPortCropRect == null) {
            viewPortCropRect = rational != null ? ImageUtil.computeCropRectFromAspectRatio(attachedSurfaceResolution, rational) : new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        int relativeRotation = getRelativeRotation(camera);
        Objects.requireNonNull(viewPortCropRect);
        return new ResolutionInfo(attachedSurfaceResolution, viewPortCropRect, relativeRotation);
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public ScreenFlash getScreenFlash() {
        return this.mScreenFlashWrapper.getBaseScreenFlash();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @VisibleForTesting
    public TakePictureManager getTakePictureManager() {
        TakePictureManager takePictureManager = this.mTakePictureManager;
        Objects.requireNonNull(takePictureManager);
        return takePictureManager;
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue();
    }

    @VisibleForTesting
    public boolean isProcessingPipelineEnabled() {
        return (this.mImagePipeline == null || this.mTakePictureManager == null) ? false : true;
    }

    public void lockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            try {
                if (this.mLockedFlashMode.get() != null) {
                    return;
                }
                this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
        if (getFlashMode() == 3 && getCameraLens() != 0) {
            throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onCameraControlReady() {
        Logger.d(TAG, "onCameraControlReady");
        trySetFlashModeToCameraControl();
        setScreenFlashToCameraControl();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        applyFeatureGroupToConfig(builder);
        if (cameraInfoInternal.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            MutableConfig mutableConfig = builder.getMutableConfig();
            Config.Option<Boolean> option = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(mutableConfig.retrieveOption(option, bool2))) {
                Logger.w(TAG, "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                Logger.i(TAG, "Requesting software JPEG due to device quirk.");
                builder.getMutableConfig().insertOption(option, bool2);
            }
        }
        boolean zEnforceSoftwareJpegConstraints = enforceSoftwareJpegConstraints(builder.getMutableConfig());
        Integer num = (Integer) builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (num != null) {
            Preconditions.checkArgument(!isSessionProcessorEnabledInCurrentCamera() || num.intValue() == 256, "Cannot set non-JPEG buffer format with Extensions enabled.");
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, Integer.valueOf(zEnforceSoftwareJpegConstraints ? 35 : num.intValue()));
        } else if (isOutputFormatRaw(builder.getMutableConfig())) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 32);
        } else if (isOutputFormatRawJpeg(builder.getMutableConfig())) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 32);
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_SECONDARY_INPUT_FORMAT, 256);
        } else if (isOutputFormatUltraHdr(builder.getMutableConfig())) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
        } else if (zEnforceSoftwareJpegConstraints) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        } else {
            List list = (List) builder.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
            if (list == null || isImageFormatSupported(list, 256)) {
                builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            } else if (isImageFormatSupported(list, 35)) {
                builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
            }
        }
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSessionStop() {
        abortImageCaptureRequests();
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
        SessionConfig.Builder builderCreatePipeline = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        Object[] objArr = {builderCreatePipeline.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnbind() {
        abortImageCaptureRequests();
        clearPipeline();
        setScreenFlashToCameraControl(null);
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    public void setFlashMode(int i2) {
        Logger.d(TAG, "setFlashMode: flashMode = " + i2);
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                throw new IllegalArgumentException(a1.a.g(i2, "Invalid flash mode: "));
            }
            if (this.mScreenFlashWrapper.getBaseScreenFlash() == null) {
                throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
            }
            if (getCamera() != null && getCameraLens() != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
            }
        }
        synchronized (this.mLockedFlashMode) {
            this.mFlashMode = i2;
            trySetFlashModeToCameraControl();
        }
    }

    public void setScreenFlash(ScreenFlash screenFlash) {
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(screenFlash);
        setScreenFlashToCameraControl();
    }

    public void setTargetRotation(int i2) {
        int targetRotation = getTargetRotation();
        if (!setTargetRotationInternal(i2) || this.mCropAspectRatio == null) {
            return;
        }
        this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio(Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i2) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)), this.mCropAspectRatio);
    }

    @MainThread
    public j2.q submitStillCaptureRequest(List<CaptureConfig> list) {
        Threads.checkMainThread();
        return Futures.transform(getCameraControl().submitStillCaptureRequests(list, this.mCaptureMode, this.mFlashType), new androidx.camera.camera2.internal.compat.workaround.c(1), CameraXExecutors.directExecutor());
    }

    /* JADX INFO: renamed from: takePicture, reason: merged with bridge method [inline-methods] */
    public void lambda$takePicture$1(final Executor executor, final OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3752a.lambda$takePicture$1(executor, onImageCapturedCallback);
                }
            });
        } else {
            takePictureInternal(executor, onImageCapturedCallback, null, null, null);
        }
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    public void unlockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            try {
                Integer andSet = this.mLockedFlashMode.getAndSet(null);
                if (andSet == null) {
                    return;
                }
                if (andSet.intValue() != getFlashMode()) {
                    trySetFlashModeToCameraControl();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @MainThread
    private void clearPipeline(boolean z2) {
        TakePictureManager takePictureManager;
        Log.d(TAG, "clearPipeline");
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        ImagePipeline imagePipeline = this.mImagePipeline;
        if (imagePipeline != null) {
            imagePipeline.close();
            this.mImagePipeline = null;
        }
        if (!z2 && (takePictureManager = this.mTakePictureManager) != null) {
            takePictureManager.abortRequests();
            this.mTakePictureManager = null;
        }
        getCameraControl().clearZslConfig();
    }

    private void setScreenFlashToCameraControl(ScreenFlash screenFlash) {
        getCameraControl().setScreenFlash(screenFlash);
    }

    /* JADX INFO: renamed from: takePicture, reason: merged with bridge method [inline-methods] */
    public void lambda$takePicture$2(OutputFileOptions outputFileOptions, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new a3.d(this, outputFileOptions, executor, onImageSavedCallback, 1));
        } else {
            takePictureInternal(executor, null, onImageSavedCallback, outputFileOptions, null);
        }
    }

    /* JADX INFO: renamed from: takePicture, reason: merged with bridge method [inline-methods] */
    public void lambda$takePicture$3(OutputFileOptions outputFileOptions, OutputFileOptions outputFileOptions2, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new w(this, outputFileOptions, outputFileOptions2, executor, onImageSavedCallback, 0));
        } else {
            takePictureInternal(executor, null, onImageSavedCallback, outputFileOptions, outputFileOptions2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class OnImageCapturedCallback {
        public void onCaptureStarted() {
        }

        public void onCaptureProcessProgressed(int i2) {
        }

        public void onCaptureSuccess(ImageProxy imageProxy) {
        }

        public void onError(ImageCaptureException imageCaptureException) {
        }

        public void onPostviewBitmapAvailable(Bitmap bitmap) {
        }
    }
}
