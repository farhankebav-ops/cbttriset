package androidx.camera.video.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.w;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.f;
import androidx.camera.core.internal.g;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCaptureConfig<T extends VideoOutput> implements UseCaseConfig<VideoCapture<T>>, ImageOutputConfig, ThreadConfig {
    private final OptionsBundle mConfig;
    public static final Config.Option<VideoOutput> OPTION_VIDEO_OUTPUT = Config.Option.create("camerax.video.VideoCapture.videoOutput", VideoOutput.class);
    public static final Config.Option<VideoEncoderInfo.Finder> OPTION_VIDEO_ENCODER_INFO_FINDER = Config.Option.create("camerax.video.VideoCapture.videoEncoderInfoFinder", VideoEncoderInfo.Finder.class);
    public static final Config.Option<Boolean> OPTION_FORCE_ENABLE_SURFACE_PROCESSING = Config.Option.create("camerax.video.VideoCapture.forceEnableSurfaceProcessing", Boolean.class);

    public VideoCaptureConfig(OptionsBundle optionsBundle) {
        Preconditions.checkArgument(optionsBundle.containsOption(OPTION_VIDEO_OUTPUT));
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option option) {
        return w.a(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        w.b(this, str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getAppTargetRotation(int i2) {
        return t.a(this, i2);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    public final /* synthetic */ Executor getBackgroundExecutor() {
        return g.a(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return UseCaseConfig.CC.a(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return UseCaseConfig.CC.c(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getCustomOrderedResolutions() {
        return t.b(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return UseCaseConfig.CC.d(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getDefaultResolution() {
        return t.d(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return UseCaseConfig.CC.f(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ DynamicRange getDynamicRange() {
        return s.a(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public int getInputFormat() {
        return 34;
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getMaxResolution() {
        return t.f(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getMirrorMode(int i2) {
        return t.h(this, i2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return w.c(this, option);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getPreviewStabilizationMode() {
        return UseCaseConfig.CC.h(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option option) {
        return w.d(this, option);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ ResolutionSelector getResolutionSelector() {
        return t.i(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ int getSecondaryInputFormat() {
        return s.c(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return UseCaseConfig.CC.i(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSessionType() {
        return UseCaseConfig.CC.k(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ StreamUseCase getStreamUseCase() {
        return UseCaseConfig.CC.m(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getSupportedResolutions() {
        return t.k(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSurfaceOccupancyPriority() {
        return UseCaseConfig.CC.n(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ TakePictureManager.Provider getTakePictureManagerProvider() {
        return UseCaseConfig.CC.p(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetAspectRatio() {
        return t.m(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class getTargetClass() {
        return f.a(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ Range getTargetFrameRate() {
        return UseCaseConfig.CC.q(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return f.c(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getTargetResolution() {
        return t.n(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetRotation() {
        return t.p(this);
    }

    public VideoEncoderInfo.Finder getVideoEncoderInfoFinder() {
        VideoEncoderInfo.Finder finder = (VideoEncoderInfo.Finder) w.f(this, OPTION_VIDEO_ENCODER_INFO_FINDER);
        Objects.requireNonNull(finder);
        return finder;
    }

    public T getVideoOutput() {
        VideoOutput videoOutput = (VideoOutput) w.f(this, OPTION_VIDEO_OUTPUT);
        Objects.requireNonNull(videoOutput);
        return (T) videoOutput;
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getVideoStabilizationMode() {
        return UseCaseConfig.CC.s(this);
    }

    @Override // androidx.camera.core.impl.ImageInputConfig
    public final /* synthetic */ boolean hasDynamicRange() {
        return s.d(this);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ boolean hasTargetAspectRatio() {
        return t.r(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean hasTargetFrameRate() {
        return UseCaseConfig.CC.t(this);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isHighResolutionDisabled(boolean z2) {
        return UseCaseConfig.CC.u(this, z2);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isStrictFrameRateRequired() {
        return UseCaseConfig.CC.v(this);
    }

    public boolean isSurfaceProcessingForceEnabled() {
        Boolean bool = (Boolean) w.g(this, OPTION_FORCE_ENABLE_SURFACE_PROCESSING, Boolean.FALSE);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ boolean isZslDisabled(boolean z2) {
        return UseCaseConfig.CC.w(this, z2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return w.e(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option option) {
        return w.f(this, option);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
        return w.h(this, option, optionPriority);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    public final /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return g.b(this, executor);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig.CC.b(this, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getCustomOrderedResolutions(List list) {
        return t.c(this, list);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return UseCaseConfig.CC.e(this, captureConfig);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getDefaultResolution(Size size) {
        return t.e(this, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return UseCaseConfig.CC.g(this, sessionConfig);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getMaxResolution(Size size) {
        return t.g(this, size);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ ResolutionSelector getResolutionSelector(ResolutionSelector resolutionSelector) {
        return t.j(this, resolutionSelector);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig.CC.j(this, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSessionType(int i2) {
        return UseCaseConfig.CC.l(this, i2);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ List getSupportedResolutions(List list) {
        return t.l(this, list);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ int getSurfaceOccupancyPriority(int i2) {
        return UseCaseConfig.CC.o(this, i2);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class getTargetClass(Class cls) {
        return f.b(this, cls);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public final /* synthetic */ Range getTargetFrameRate(Range range) {
        return UseCaseConfig.CC.r(this, range);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String str) {
        return f.d(this, str);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ Size getTargetResolution(Size size) {
        return t.o(this, size);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public final /* synthetic */ int getTargetRotation(int i2) {
        return t.q(this, i2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return w.g(this, option, obj);
    }
}
