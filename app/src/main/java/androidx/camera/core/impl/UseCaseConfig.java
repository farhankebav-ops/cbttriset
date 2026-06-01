package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureManagerImpl;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, ImageInputConfig {
    public static final Config.Option<UseCaseConfigFactory.CaptureType> OPTION_CAPTURE_TYPE;
    public static final Config.Option<Boolean> OPTION_HIGH_RESOLUTION_DISABLED;
    public static final Config.Option<Boolean> OPTION_IS_STRICT_FRAME_RATE_REQUIRED;
    public static final Config.Option<Integer> OPTION_PREVIEW_STABILIZATION_MODE;
    public static final Config.Option<Integer> OPTION_SESSION_TYPE;
    public static final Config.Option<StreamUseCase> OPTION_STREAM_USE_CASE;
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY;
    public static final Config.Option<TakePictureManager.Provider> OPTION_TAKE_PICTURE_MANAGER_PROVIDER;
    public static final Config.Option<Range<Integer>> OPTION_TARGET_FRAME_RATE;
    public static final Config.Option<Integer> OPTION_VIDEO_STABILIZATION_MODE;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);

    /* JADX INFO: renamed from: androidx.camera.core.impl.UseCaseConfig$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public abstract /* synthetic */ class CC {
        public static CaptureConfig.OptionUnpacker a(UseCaseConfig useCaseConfig) {
            return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
        }

        public static CaptureConfig.OptionUnpacker b(UseCaseConfig useCaseConfig, CaptureConfig.OptionUnpacker optionUnpacker) {
            return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
        }

        public static UseCaseConfigFactory.CaptureType c(UseCaseConfig useCaseConfig) {
            return (UseCaseConfigFactory.CaptureType) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
        }

        public static CaptureConfig d(UseCaseConfig useCaseConfig) {
            return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
        }

        public static CaptureConfig e(UseCaseConfig useCaseConfig, CaptureConfig captureConfig) {
            return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
        }

        public static SessionConfig f(UseCaseConfig useCaseConfig) {
            return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
        }

        public static SessionConfig g(UseCaseConfig useCaseConfig, SessionConfig sessionConfig) {
            return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
        }

        public static int h(UseCaseConfig useCaseConfig) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
        }

        public static SessionConfig.OptionUnpacker i(UseCaseConfig useCaseConfig) {
            return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
        }

        public static SessionConfig.OptionUnpacker j(UseCaseConfig useCaseConfig, SessionConfig.OptionUnpacker optionUnpacker) {
            return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
        }

        public static int k(UseCaseConfig useCaseConfig) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_TYPE)).intValue();
        }

        public static int l(UseCaseConfig useCaseConfig, int i2) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_TYPE, Integer.valueOf(i2))).intValue();
        }

        public static StreamUseCase m(UseCaseConfig useCaseConfig) {
            StreamUseCase streamUseCase = (StreamUseCase) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_STREAM_USE_CASE, StreamUseCase.DEFAULT);
            Objects.requireNonNull(streamUseCase);
            return streamUseCase;
        }

        public static int n(UseCaseConfig useCaseConfig) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
        }

        public static int o(UseCaseConfig useCaseConfig, int i2) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2))).intValue();
        }

        public static TakePictureManager.Provider p(final UseCaseConfig useCaseConfig) {
            TakePictureManager.Provider provider = (TakePictureManager.Provider) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TAKE_PICTURE_MANAGER_PROVIDER, new TakePictureManager.Provider() { // from class: androidx.camera.core.impl.UseCaseConfig.1
                @Override // androidx.camera.core.imagecapture.TakePictureManager.Provider
                public TakePictureManager newInstance(ImageCaptureControl imageCaptureControl) {
                    return new TakePictureManagerImpl(imageCaptureControl);
                }
            });
            Objects.requireNonNull(provider);
            return provider;
        }

        public static Range q(UseCaseConfig useCaseConfig) {
            return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
        }

        public static Range r(UseCaseConfig useCaseConfig, Range range) {
            return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
        }

        public static int s(UseCaseConfig useCaseConfig) {
            return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
        }

        public static boolean t(UseCaseConfig useCaseConfig) {
            return useCaseConfig.containsOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
        }

        public static boolean u(UseCaseConfig useCaseConfig, boolean z2) {
            return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z2))).booleanValue();
        }

        public static boolean v(UseCaseConfig useCaseConfig) {
            Boolean bool = (Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_IS_STRICT_FRAME_RATE_REQUIRED, Boolean.FALSE);
            Objects.requireNonNull(bool);
            return bool.booleanValue();
        }

        public static boolean w(UseCaseConfig useCaseConfig, boolean z2) {
            return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z2))).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends TargetConfig.Builder<T, B>, ExtendableBuilder<T> {
        C getUseCaseConfig();

        B setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker);

        B setCaptureType(UseCaseConfigFactory.CaptureType captureType);

        B setDefaultCaptureConfig(CaptureConfig captureConfig);

        B setDefaultSessionConfig(SessionConfig sessionConfig);

        B setHighResolutionDisabled(boolean z2);

        B setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker);

        B setStreamUseCase(StreamUseCase streamUseCase);

        B setSurfaceOccupancyPriority(int i2);

        B setZslDisabled(boolean z2);
    }

    static {
        Class cls = Integer.TYPE;
        OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create("camerax.core.useCase.surfaceOccupancyPriority", cls);
        OPTION_SESSION_TYPE = Config.Option.create("camerax.core.useCase.sessionType", cls);
        OPTION_TARGET_FRAME_RATE = Config.Option.create("camerax.core.useCase.targetFrameRate", Range.class);
        OPTION_IS_STRICT_FRAME_RATE_REQUIRED = Config.Option.create("camerax.core.useCase.isStrictFrameRateRequired", Boolean.class);
        Class cls2 = Boolean.TYPE;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.useCase.zslDisabled", cls2);
        OPTION_HIGH_RESOLUTION_DISABLED = Config.Option.create("camerax.core.useCase.highResolutionDisabled", cls2);
        OPTION_CAPTURE_TYPE = Config.Option.create("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
        OPTION_PREVIEW_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.previewStabilizationMode", cls);
        OPTION_VIDEO_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.videoStabilizationMode", cls);
        OPTION_TAKE_PICTURE_MANAGER_PROVIDER = Config.Option.create("camerax.core.useCase.takePictureManagerProvider", TakePictureManager.Provider.class);
        OPTION_STREAM_USE_CASE = Config.Option.create("camerax.core.useCase.streamUseCase", StreamUseCase.class);
    }

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker();

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker);

    UseCaseConfigFactory.CaptureType getCaptureType();

    CaptureConfig getDefaultCaptureConfig();

    CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig);

    SessionConfig getDefaultSessionConfig();

    SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig);

    int getPreviewStabilizationMode();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker);

    int getSessionType();

    int getSessionType(int i2);

    StreamUseCase getStreamUseCase();

    int getSurfaceOccupancyPriority();

    int getSurfaceOccupancyPriority(int i2);

    TakePictureManager.Provider getTakePictureManagerProvider();

    Range<Integer> getTargetFrameRate();

    Range<Integer> getTargetFrameRate(Range<Integer> range);

    int getVideoStabilizationMode();

    boolean hasTargetFrameRate();

    boolean isHighResolutionDisabled(boolean z2);

    boolean isStrictFrameRateRequired();

    boolean isZslDisabled(boolean z2);
}
