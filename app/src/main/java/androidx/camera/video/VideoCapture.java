package androidx.camera.video;

import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.ResolutionInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.impl.VideoCaptureConfig;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.HdrRepeatingRequestFailureQuirk;
import androidx.camera.video.internal.compat.quirk.SizeCannotEncodeVideoQuirk;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.SwappedVideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCapture<T extends VideoOutput> extends UseCase {
    private static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final String SURFACE_UPDATE_KEY = "androidx.camera.video.VideoCapture.streamUpdate";
    private static final String TAG = "VideoCapture";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private Rect mCropRect;
    DeferrableSurface mDeferrableSurface;
    private boolean mHasCompensatingTransformation;
    private SurfaceProcessorNode mNode;
    private Map<Quality, List<Size>> mQualityToCustomSizesMap;
    private int mRotationDegrees;
    SessionConfig.Builder mSessionConfigBuilder;
    VideoOutput.SourceState mSourceState;
    private SourceStreamRequirementObserver mSourceStreamRequirementObserver;
    StreamInfo mStreamInfo;
    private final Observable.Observer<StreamInfo> mStreamInfoObserver;
    private SurfaceRequest mSurfaceRequest;
    j2.q mSurfaceUpdateFuture;

    /* JADX INFO: renamed from: androidx.camera.video.VideoCapture$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 extends CameraCaptureCallback {
        private boolean mIsFirstCaptureResult = true;
        final /* synthetic */ CallbackToFutureAdapter.Completer val$completer;
        final /* synthetic */ SessionConfig.Builder val$sessionConfigBuilder;
        final /* synthetic */ AtomicBoolean val$surfaceUpdateComplete;

        public AnonymousClass2(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, SessionConfig.Builder builder) {
            this.val$surfaceUpdateComplete = atomicBoolean;
            this.val$completer = completer;
            this.val$sessionConfigBuilder = builder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptureCompleted$0(SessionConfig.Builder builder) {
            builder.removeCameraCaptureCallback(this);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int i2, CameraCaptureResult cameraCaptureResult) {
            Object tag;
            super.onCaptureCompleted(i2, cameraCaptureResult);
            if (this.mIsFirstCaptureResult) {
                this.mIsFirstCaptureResult = false;
                Logger.d(VideoCapture.TAG, "cameraCaptureResult timestampNs = " + cameraCaptureResult.getTimestamp() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
            }
            if (this.val$surfaceUpdateComplete.get() || (tag = cameraCaptureResult.getTagBundle().getTag(VideoCapture.SURFACE_UPDATE_KEY)) == null || ((Integer) tag).intValue() != this.val$completer.hashCode() || !this.val$completer.set(null) || this.val$surfaceUpdateComplete.getAndSet(true)) {
                return;
            }
            CameraXExecutors.mainThreadExecutor().execute(new n(1, this, this.val$sessionConfigBuilder));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder<T extends VideoOutput> implements UseCaseConfig.Builder<VideoCapture<T>, VideoCaptureConfig<T>, Builder<T>>, ImageOutputConfig.Builder<Builder<T>>, ImageInputConfig.Builder<Builder<T>>, ThreadConfig.Builder<Builder<T>> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder(T t3) {
            this(createInitialBundle(t3));
        }

        private static <T extends VideoOutput> MutableOptionsBundle createInitialBundle(T t3) {
            MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
            mutableOptionsBundleCreate.insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, t3);
            return mutableOptionsBundleCreate;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder<? extends VideoOutput> fromConfig(Config config) {
            return new Builder<>(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setCustomOrderedResolutions(List list) {
            return setCustomOrderedResolutions((List<Size>) list);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setSupportedResolutions(List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSurfaceProcessingForceEnabled() {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_FORCE_ENABLE_SURFACE_PROCESSING, Boolean.TRUE);
            return this;
        }

        public Builder<T> setTargetFrameRate(Range<Integer> range) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
            return this;
        }

        public Builder<T> setVideoEncoderInfoFinder(VideoEncoderInfo.Finder finder) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_ENCODER_INFO_FINDER, finder);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setVideoOutput(VideoOutput videoOutput) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, videoOutput);
            return this;
        }

        public Builder<T> setVideoStabilizationEnabled(boolean z2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, Integer.valueOf(z2 ? 2 : 1));
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            if (!mutableOptionsBundle.containsOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT)) {
                throw new IllegalArgumentException("VideoOutput is required");
            }
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
                setTargetClass((Class) VideoCapture.class);
            } else {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <T extends VideoOutput> Builder<T> fromConfig(VideoCaptureConfig<T> videoCaptureConfig) {
            return new Builder<>(MutableOptionsBundle.from((Config) videoCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public VideoCapture<T> build() {
            return new VideoCapture<>(getUseCaseConfig());
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public VideoCaptureConfig<T> getUseCaseConfig() {
            return new VideoCaptureConfig<>(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCustomOrderedResolutions(List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public Builder<T> setDynamicRange(DynamicRange dynamicRange) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setHighResolutionDisabled(boolean z2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setMirrorMode(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setStreamUseCase(StreamUseCase streamUseCase) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_STREAM_USE_CASE, streamUseCase);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSurfaceOccupancyPriority(int i2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetAspectRatio(int i2) {
            throw new UnsupportedOperationException("setTargetAspectRatio is not supported.");
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetClass(Class<VideoCapture<T>> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetResolution(Size size) {
            throw new UnsupportedOperationException("setTargetResolution is not supported.");
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder<T> setTargetRotation(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setZslDisabled(boolean z2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z2));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<VideoCaptureConfig<?>> {
        private static final VideoCaptureConfig<?> DEFAULT_CONFIG;
        static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        static final Range<Integer> DEFAULT_FPS_RANGE;
        static final Range<Integer> DEFAULT_HIGH_SPEED_FPS_RANGE;
        private static final StreamUseCase DEFAULT_STREAM_USE_CASE;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 5;
        private static final VideoEncoderInfo.Finder DEFAULT_VIDEO_ENCODER_INFO_FINDER;
        private static final VideoOutput DEFAULT_VIDEO_OUTPUT;

        static {
            StreamUseCase streamUseCase = StreamUseCase.VIDEO_RECORD;
            DEFAULT_STREAM_USE_CASE = streamUseCase;
            w wVar = new w();
            DEFAULT_VIDEO_OUTPUT = wVar;
            VideoEncoderInfo.Finder finder = VideoEncoderInfoImpl.FINDER;
            DEFAULT_VIDEO_ENCODER_INFO_FINDER = finder;
            DEFAULT_FPS_RANGE = new Range<>(30, 30);
            DEFAULT_HIGH_SPEED_FPS_RANGE = new Range<>(120, 120);
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder(wVar).setSurfaceOccupancyPriority(5).setStreamUseCase(streamUseCase).setVideoEncoderInfoFinder(finder).setDynamicRange(dynamicRange).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public VideoCaptureConfig<?> getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SourceStreamRequirementObserver implements Observable.Observer<Boolean> {
        private CameraControlInternal mCameraControl;
        private boolean mIsSourceStreamRequired = false;

        public SourceStreamRequirementObserver(CameraControlInternal cameraControlInternal) {
            this.mCameraControl = cameraControlInternal;
        }

        private void updateVideoUsageInCamera(boolean z2) {
            if (this.mIsSourceStreamRequired == z2) {
                return;
            }
            this.mIsSourceStreamRequired = z2;
            CameraControlInternal cameraControlInternal = this.mCameraControl;
            if (cameraControlInternal == null) {
                Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#isSourceStreamRequired: Received new data despite being closed already");
            } else if (z2) {
                cameraControlInternal.incrementVideoUsage();
            } else {
                cameraControlInternal.decrementVideoUsage();
            }
        }

        @MainThread
        public void close() {
            Preconditions.checkState(Threads.isMainThread(), "SourceStreamRequirementObserver can be closed from main thread only");
            Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#close: mIsSourceStreamRequired = " + this.mIsSourceStreamRequired);
            if (this.mCameraControl == null) {
                Logger.d(VideoCapture.TAG, "SourceStreamRequirementObserver#close: Already closed!");
            } else {
                updateVideoUsageInCamera(false);
                this.mCameraControl = null;
            }
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(Throwable th) {
            Logger.w(VideoCapture.TAG, "SourceStreamRequirementObserver#onError", th);
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        @MainThread
        public void onNewData(Boolean bool) {
            Preconditions.checkState(Threads.isMainThread(), "SourceStreamRequirementObserver can be updated from main thread only");
            updateVideoUsageInCamera(Boolean.TRUE.equals(bool));
        }
    }

    public VideoCapture(VideoCaptureConfig<T> videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mSessionConfigBuilder = new SessionConfig.Builder();
        this.mSurfaceUpdateFuture = null;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mHasCompensatingTransformation = false;
        this.mQualityToCustomSizesMap = Collections.EMPTY_MAP;
        this.mStreamInfoObserver = new Observable.Observer<StreamInfo>() { // from class: androidx.camera.video.VideoCapture.1
            @Override // androidx.camera.core.impl.Observable.Observer
            public void onError(Throwable th) {
                Logger.w(VideoCapture.TAG, "Receive onError from StreamState observer", th);
            }

            @Override // androidx.camera.core.impl.Observable.Observer
            public void onNewData(StreamInfo streamInfo) {
                if (streamInfo == null) {
                    throw new IllegalArgumentException("StreamInfo can't be null");
                }
                if (VideoCapture.this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                Logger.d(VideoCapture.TAG, "Stream info update: old: " + VideoCapture.this.mStreamInfo + " new: " + streamInfo);
                VideoCapture videoCapture = VideoCapture.this;
                StreamInfo streamInfo2 = videoCapture.mStreamInfo;
                videoCapture.mStreamInfo = streamInfo;
                StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(videoCapture.getAttachedStreamSpec());
                if (VideoCapture.this.isStreamIdChanged(streamInfo2.getId(), streamInfo.getId()) || VideoCapture.this.shouldResetCompensatingTransformation(streamInfo2, streamInfo)) {
                    VideoCapture.this.resetPipeline();
                    return;
                }
                if ((streamInfo2.getId() != -1 && streamInfo.getId() == -1) || (streamInfo2.getId() == -1 && streamInfo.getId() != -1)) {
                    VideoCapture videoCapture2 = VideoCapture.this;
                    videoCapture2.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture2.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture3 = VideoCapture.this;
                    Object[] objArr = {videoCapture3.mSessionConfigBuilder.build()};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                    videoCapture3.updateSessionConfig(Collections.unmodifiableList(arrayList));
                    VideoCapture.this.notifyReset();
                    return;
                }
                if (streamInfo2.getStreamState() != streamInfo.getStreamState()) {
                    VideoCapture videoCapture4 = VideoCapture.this;
                    videoCapture4.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture4.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture5 = VideoCapture.this;
                    Object[] objArr2 = {videoCapture5.mSessionConfigBuilder.build()};
                    ArrayList arrayList2 = new ArrayList(1);
                    Object obj2 = objArr2[0];
                    Objects.requireNonNull(obj2);
                    arrayList2.add(obj2);
                    videoCapture5.updateSessionConfig(Collections.unmodifiableList(arrayList2));
                    VideoCapture.this.notifyUpdated();
                }
            }
        };
    }

    private static void addBySupportedSize(Set<Size> set, int i2, int i8, Size size, VideoEncoderInfo videoEncoderInfo) {
        if (i2 > size.getWidth() || i8 > size.getHeight()) {
            return;
        }
        try {
            set.add(new Size(i2, ((Integer) videoEncoderInfo.getSupportedHeightsFor(i2).clamp(Integer.valueOf(i8))).intValue()));
        } catch (IllegalArgumentException e) {
            Logger.w(TAG, "No supportedHeights for width: " + i2, e);
        }
        try {
            set.add(new Size(((Integer) videoEncoderInfo.getSupportedWidthsFor(i8).clamp(Integer.valueOf(i2))).intValue(), i8));
        } catch (IllegalArgumentException e4) {
            Logger.w(TAG, "No supportedWidths for height: " + i8, e4);
        }
    }

    private static Rect adjustCropRectByQuirk(Rect rect, int i2, boolean z2, VideoEncoderInfo videoEncoderInfo) {
        SizeCannotEncodeVideoQuirk sizeCannotEncodeVideoQuirk = (SizeCannotEncodeVideoQuirk) DeviceQuirks.get(SizeCannotEncodeVideoQuirk.class);
        if (sizeCannotEncodeVideoQuirk == null) {
            return rect;
        }
        if (!z2) {
            i2 = 0;
        }
        return sizeCannotEncodeVideoQuirk.adjustCropRectForProblematicEncodeSize(rect, i2, videoEncoderInfo);
    }

    private static Rect adjustCropRectToValidSize(final Rect rect, Size size, VideoEncoderInfo videoEncoderInfo) {
        Logger.d(TAG, String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", TransformUtils.rectToString(rect), Integer.valueOf(videoEncoderInfo.getWidthAlignment()), Integer.valueOf(videoEncoderInfo.getHeightAlignment()), videoEncoderInfo.getSupportedWidths(), videoEncoderInfo.getSupportedHeights()));
        if ((!videoEncoderInfo.getSupportedWidths().contains(Integer.valueOf(rect.width())) || !videoEncoderInfo.getSupportedHeights().contains(Integer.valueOf(rect.height()))) && videoEncoderInfo.canSwapWidthHeight() && videoEncoderInfo.getSupportedHeights().contains(Integer.valueOf(rect.width())) && videoEncoderInfo.getSupportedWidths().contains(Integer.valueOf(rect.height()))) {
            videoEncoderInfo = new SwappedVideoEncoderInfo(videoEncoderInfo);
        }
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        Range<Integer> supportedWidths = videoEncoderInfo.getSupportedWidths();
        Range<Integer> supportedHeights = videoEncoderInfo.getSupportedHeights();
        int iAlignDown = alignDown(rect.width(), widthAlignment, supportedWidths);
        int iAlignUp = alignUp(rect.width(), widthAlignment, supportedWidths);
        int iAlignDown2 = alignDown(rect.height(), heightAlignment, supportedHeights);
        int iAlignUp2 = alignUp(rect.height(), heightAlignment, supportedHeights);
        HashSet hashSet = new HashSet();
        addBySupportedSize(hashSet, iAlignDown, iAlignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignDown, iAlignUp2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignUp, iAlignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, iAlignUp, iAlignUp2, size, videoEncoderInfo);
        if (hashSet.isEmpty()) {
            Logger.w(TAG, "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.d(TAG, "candidatesList = " + arrayList);
        Collections.sort(arrayList, new Comparator() { // from class: androidx.camera.video.v
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return VideoCapture.lambda$adjustCropRectToValidSize$4(rect, (Size) obj, (Size) obj2);
            }
        });
        Logger.d(TAG, "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            Logger.d(TAG, "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        Preconditions.checkState(width % 2 == 0 && height % 2 == 0 && width <= size.getWidth() && height <= size.getHeight());
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int iMax = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = iMax;
            int i2 = iMax + width;
            rect2.right = i2;
            if (i2 > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int iMax2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = iMax2;
            int i8 = iMax2 + height;
            rect2.bottom = i8;
            if (i8 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        Logger.d(TAG, "Adjust cropRect from " + TransformUtils.rectToString(rect) + " to " + TransformUtils.rectToString(rect2));
        return rect2;
    }

    private Rect adjustCropRectWithInProgressTransformation(Rect rect, int i2) {
        return shouldCompensateTransformation() ? TransformUtils.sizeToRect(TransformUtils.getRotatedSize(((SurfaceRequest.TransformationInfo) Preconditions.checkNotNull(this.mStreamInfo.getInProgressTransformationInfo())).getCropRect(), i2)) : rect;
    }

    private Size adjustResolutionWithInProgressTransformation(Size size, Rect rect, Rect rect2) {
        if (!shouldCompensateTransformation() || rect2.equals(rect)) {
            return size;
        }
        float fHeight = rect2.height() / rect.height();
        return new Size((int) Math.ceil(size.getWidth() * fHeight), (int) Math.ceil(size.getHeight() * fHeight));
    }

    private static int align(boolean z2, int i2, int i8, Range<Integer> range) {
        int i9 = i2 % i8;
        if (i9 != 0) {
            i2 = z2 ? i2 - i9 : i2 + (i8 - i9);
        }
        return ((Integer) range.clamp(Integer.valueOf(i2))).intValue();
    }

    private static int alignDown(int i2, int i8, Range<Integer> range) {
        return align(true, i2, i8, range);
    }

    private static int alignUp(int i2, int i8, Range<Integer> range) {
        return align(false, i2, i8, range);
    }

    private Rect calculateCropRect(Size size, VideoEncoderInfo videoEncoderInfo) {
        Rect viewPortCropRect = getViewPortCropRect() != null ? getViewPortCropRect() : new Rect(0, 0, size.getWidth(), size.getHeight());
        return (videoEncoderInfo == null || videoEncoderInfo.isSizeSupportedAllowSwapping(viewPortCropRect.width(), viewPortCropRect.height())) ? viewPortCropRect : adjustCropRectToValidSize(viewPortCropRect, size, videoEncoderInfo);
    }

    @MainThread
    private void clearPipeline() {
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
        SurfaceProcessorNode surfaceProcessorNode = this.mNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mNode = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        this.mCropRect = null;
        this.mSurfaceRequest = null;
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mRotationDegrees = 0;
        this.mHasCompensatingTransformation = false;
    }

    private SurfaceProcessorNode createNodeIfNeeded(CameraInternal cameraInternal, VideoCaptureConfig<T> videoCaptureConfig, Rect rect, Size size, DynamicRange dynamicRange) {
        if (!isCreateNodeNeeded(cameraInternal, videoCaptureConfig, rect, size, dynamicRange)) {
            return null;
        }
        Logger.d(TAG, "Surface processing is enabled.");
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        return new SurfaceProcessorNode(camera, getEffect() != null ? getEffect().createSurfaceProcessorInternal() : DefaultSurfaceProcessor.Factory.newInstance(dynamicRange));
    }

    private LinkedHashMap<Quality, List<Size>> createOrderedQualityToSizesMap(CameraInfoInternal cameraInfoInternal, MediaSpec mediaSpec, DynamicRange dynamicRange, VideoCapabilities videoCapabilities, int i2, Range<Integer> range, VideoEncoderInfo.Finder finder, List<Quality> list) {
        int aspectRatio = mediaSpec.getVideoSpec().getAspectRatio();
        Map<Quality, Size> qualityToResolutionMap = QualitySelector.getQualityToResolutionMap(videoCapabilities, dynamicRange);
        QualityRatioToResolutionsTable qualityRatioToResolutionsTable = new QualityRatioToResolutionsTable(getSupportedResolutions(cameraInfoInternal, i2, range), qualityToResolutionMap);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Quality quality : list) {
            linkedHashMap.put(quality, qualityRatioToResolutionsTable.getResolutions(quality, aspectRatio));
        }
        return filterOutEncoderUnsupportedResolutions(finder, mediaSpec, dynamicRange, videoCapabilities, linkedHashMap, qualityToResolutionMap);
    }

    @MainThread
    private SessionConfig.Builder createPipeline(final VideoCaptureConfig<T> videoCaptureConfig, StreamSpec streamSpec) {
        final boolean z2;
        final VideoCapture<T> videoCapture = this;
        Threads.checkMainThread();
        final CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(videoCapture.getCamera());
        Size resolution = streamSpec.getResolution();
        q qVar = new q(videoCapture, 3);
        Range<Integer> rangeResolveFrameRate = resolveFrameRate(streamSpec);
        MediaSpec mediaSpec = videoCapture.getMediaSpec();
        Objects.requireNonNull(mediaSpec);
        VideoCapabilities videoCapabilities = videoCapture.getVideoCapabilities(cameraInternal.getCameraInfo(), streamSpec.getSessionType());
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        VideoEncoderInfo videoEncoderInfoResolveVideoEncoderInfo = resolveVideoEncoderInfo(videoCaptureConfig.getVideoEncoderInfoFinder(), videoCapabilities.findNearestHigherSupportedEncoderProfilesFor(resolution, dynamicRange), mediaSpec, dynamicRange);
        videoCapture.mRotationDegrees = videoCapture.getCompensatedRotation(cameraInternal);
        Rect rectCalculateCropRect = videoCapture.calculateCropRect(resolution, videoEncoderInfoResolveVideoEncoderInfo);
        Rect rectAdjustCropRectWithInProgressTransformation = videoCapture.adjustCropRectWithInProgressTransformation(rectCalculateCropRect, videoCapture.mRotationDegrees);
        videoCapture.mCropRect = rectAdjustCropRectWithInProgressTransformation;
        Size sizeAdjustResolutionWithInProgressTransformation = videoCapture.adjustResolutionWithInProgressTransformation(resolution, rectCalculateCropRect, rectAdjustCropRectWithInProgressTransformation);
        if (videoCapture.shouldCompensateTransformation()) {
            videoCapture.mHasCompensatingTransformation = true;
        }
        Rect rect = videoCapture.mCropRect;
        Rect rectAdjustCropRectByQuirk = adjustCropRectByQuirk(rect, videoCapture.mRotationDegrees, videoCapture.isCreateNodeNeeded(cameraInternal, videoCaptureConfig, rect, resolution, dynamicRange), videoEncoderInfoResolveVideoEncoderInfo);
        videoCapture.mCropRect = rectAdjustCropRectByQuirk;
        videoCapture.mNode = videoCapture.createNodeIfNeeded(cameraInternal, videoCaptureConfig, rectAdjustCropRectByQuirk, resolution, dynamicRange);
        boolean z7 = (cameraInternal.getHasTransform() && videoCapture.mNode == null) ? false : true;
        final Timebase timebaseResolveTimebase = resolveTimebase(cameraInternal, videoCapture.mNode);
        Logger.d(TAG, "camera timebase = " + cameraInternal.getCameraInfoInternal().getTimebase() + ", processing timebase = " + timebaseResolveTimebase);
        StreamSpec streamSpecBuild = streamSpec.toBuilder().setResolution(sizeAdjustResolutionWithInProgressTransformation).setExpectedFrameRateRange(rangeResolveFrameRate).build();
        Preconditions.checkState(videoCapture.mCameraEdge == null);
        SurfaceEdge surfaceEdge = new SurfaceEdge(2, 34, streamSpecBuild, videoCapture.getSensorToBufferTransformMatrix(), cameraInternal.getHasTransform(), videoCapture.mCropRect, videoCapture.mRotationDegrees, videoCapture.getAppTargetRotation(), videoCapture.shouldMirror(cameraInternal));
        videoCapture.mCameraEdge = surfaceEdge;
        surfaceEdge.addOnInvalidatedListener(qVar);
        if (videoCapture.mNode != null) {
            OutConfig outConfigOf = OutConfig.of(videoCapture.mCameraEdge);
            final SurfaceEdge surfaceEdge2 = videoCapture.mNode.transform(SurfaceProcessorNode.In.of(videoCapture.mCameraEdge, Collections.singletonList(outConfigOf))).get(outConfigOf);
            Objects.requireNonNull(surfaceEdge2);
            z2 = z7;
            videoCapture = this;
            surfaceEdge2.addOnInvalidatedListener(new Runnable() { // from class: androidx.camera.video.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3872a.lambda$createPipeline$1(surfaceEdge2, cameraInternal, videoCaptureConfig, timebaseResolveTimebase, z2);
                }
            });
            videoCapture.mSurfaceRequest = surfaceEdge2.createSurfaceRequest(cameraInternal);
            DeferrableSurface deferrableSurface = videoCapture.mCameraEdge.getDeferrableSurface();
            videoCapture.mDeferrableSurface = deferrableSurface;
            deferrableSurface.getTerminationFuture().addListener(new n(5, videoCapture, deferrableSurface), CameraXExecutors.mainThreadExecutor());
        } else {
            z2 = z7;
            SurfaceRequest surfaceRequestCreateSurfaceRequest = videoCapture.mCameraEdge.createSurfaceRequest(cameraInternal);
            videoCapture.mSurfaceRequest = surfaceRequestCreateSurfaceRequest;
            videoCapture.mDeferrableSurface = surfaceRequestCreateSurfaceRequest.getDeferrableSurface();
        }
        videoCaptureConfig.getVideoOutput().onSurfaceRequested(videoCapture.mSurfaceRequest, timebaseResolveTimebase, z2);
        videoCapture.sendTransformationInfoIfReady();
        videoCapture.mDeferrableSurface.setContainerClass(MediaCodec.class);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(videoCaptureConfig, streamSpec.getResolution());
        builderCreateFrom.setSessionType(streamSpec.getSessionType());
        videoCapture.applyExpectedFrameRateRange(builderCreateFrom, streamSpec);
        builderCreateFrom.setVideoStabilization(UseCaseConfig.CC.s(videoCaptureConfig));
        SessionConfig.CloseableErrorListener closeableErrorListener = videoCapture.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.video.u
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.f3877a.lambda$createPipeline$3(sessionConfig, sessionError);
            }
        });
        videoCapture.mCloseableErrorListener = closeableErrorListener2;
        builderCreateFrom.setErrorListener(closeableErrorListener2);
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        return builderCreateFrom;
    }

    private static <T> T fetchObservableValue(Observable<T> observable, T t3) {
        j2.q qVarFetchData = observable.fetchData();
        if (!qVarFetchData.isDone()) {
            return t3;
        }
        try {
            return (T) qVarFetchData.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    private static LinkedHashMap<Quality, List<Size>> filterOutEncoderUnsupportedResolutions(VideoEncoderInfo.Finder finder, MediaSpec mediaSpec, DynamicRange dynamicRange, VideoCapabilities videoCapabilities, LinkedHashMap<Quality, List<Size>> linkedHashMap, Map<Quality, Size> map) {
        VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor;
        VideoEncoderInfo videoEncoderInfoFindLargestSupportedSizeVideoEncoderInfo;
        if (linkedHashMap.isEmpty()) {
            return new LinkedHashMap<>();
        }
        LinkedHashMap<Quality, List<Size>> linkedHashMap2 = new LinkedHashMap<>();
        for (Map.Entry<Quality, List<Size>> entry : linkedHashMap.entrySet()) {
            ArrayList arrayList = new ArrayList(entry.getValue());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if (!map.containsValue(size) && (videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor = videoCapabilities.findNearestHigherSupportedEncoderProfilesFor(size, dynamicRange)) != null && (videoEncoderInfoFindLargestSupportedSizeVideoEncoderInfo = findLargestSupportedSizeVideoEncoderInfo(finder, videoValidatedEncoderProfilesProxyFindNearestHigherSupportedEncoderProfilesFor, dynamicRange, mediaSpec)) != null && !videoEncoderInfoFindLargestSupportedSizeVideoEncoderInfo.isSizeSupportedAllowSwapping(size.getWidth(), size.getHeight())) {
                    it.remove();
                }
            }
            if (!arrayList.isEmpty()) {
                linkedHashMap2.put(entry.getKey(), arrayList);
            }
        }
        return linkedHashMap2;
    }

    private static VideoEncoderInfo findLargestSupportedSizeVideoEncoderInfo(VideoEncoderInfo.Finder finder, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, DynamicRange dynamicRange, MediaSpec mediaSpec) {
        VideoEncoderInfo videoEncoderInfoResolveVideoEncoderInfo;
        int area;
        if (dynamicRange.isFullySpecified()) {
            return resolveVideoEncoderInfo(finder, videoValidatedEncoderProfilesProxy, mediaSpec, dynamicRange);
        }
        VideoEncoderInfo videoEncoderInfo = null;
        int i2 = Integer.MIN_VALUE;
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : videoValidatedEncoderProfilesProxy.getVideoProfiles()) {
            if (DynamicRangeUtil.isHdrSettingsMatched(videoProfileProxy, dynamicRange) && (videoEncoderInfoResolveVideoEncoderInfo = resolveVideoEncoderInfo(finder, videoValidatedEncoderProfilesProxy, mediaSpec, new DynamicRange(DynamicRangeUtil.videoProfileHdrFormatsToDynamicRangeEncoding(videoProfileProxy.getHdrFormat()), DynamicRangeUtil.videoProfileBitDepthToDynamicRangeBitDepth(videoProfileProxy.getBitDepth())))) != null && (area = SizeUtil.getArea(((Integer) videoEncoderInfoResolveVideoEncoderInfo.getSupportedWidths().getUpper()).intValue(), ((Integer) videoEncoderInfoResolveVideoEncoderInfo.getSupportedHeights().getUpper()).intValue())) > i2) {
                videoEncoderInfo = videoEncoderInfoResolveVideoEncoderInfo;
                i2 = area;
            }
        }
        return videoEncoderInfo;
    }

    private static Quality findNearestSizeFor(Map<Quality, List<Size>> map, Size size) {
        int area = SizeUtil.getArea(size);
        Quality key = null;
        int i2 = Integer.MAX_VALUE;
        for (Map.Entry<Quality, List<Size>> entry : map.entrySet()) {
            Iterator<Size> it = entry.getValue().iterator();
            while (it.hasNext()) {
                int iAbs = Math.abs(SizeUtil.getArea(it.next()) - area);
                if (iAbs < i2) {
                    key = entry.getKey();
                    i2 = iAbs;
                }
            }
        }
        return key;
    }

    private int getCompensatedRotation(CameraInternal cameraInternal) {
        boolean zIsMirroringRequired = isMirroringRequired(cameraInternal);
        int relativeRotation = getRelativeRotation(cameraInternal, zIsMirroringRequired);
        if (!shouldCompensateTransformation()) {
            return relativeRotation;
        }
        SurfaceRequest.TransformationInfo inProgressTransformationInfo = this.mStreamInfo.getInProgressTransformationInfo();
        Objects.requireNonNull(inProgressTransformationInfo);
        int rotationDegrees = inProgressTransformationInfo.getRotationDegrees();
        if (zIsMirroringRequired != inProgressTransformationInfo.isMirroring()) {
            rotationDegrees = -rotationDegrees;
        }
        return TransformUtils.within360(relativeRotation - rotationDegrees);
    }

    private MediaSpec getMediaSpec() {
        return (MediaSpec) fetchObservableValue(getOutput().getMediaSpec(), null);
    }

    private MediaSpec getMediaSpecOrThrow() throws IllegalArgumentException {
        MediaSpec mediaSpec = getMediaSpec();
        if (mediaSpec != null) {
            return mediaSpec;
        }
        throw new IllegalArgumentException("MediaSpec can't be null");
    }

    private List<Quality> getSelectedQualityOrThrow(List<Quality> list, QualitySelector qualitySelector) throws IllegalArgumentException {
        List<Quality> prioritizedQualities = qualitySelector.getPrioritizedQualities(list);
        Logger.d(TAG, "Found selectedQualities " + prioritizedQualities + " by " + qualitySelector);
        if (prioritizedQualities.isEmpty()) {
            throw new IllegalArgumentException("Unable to find selected quality");
        }
        return prioritizedQualities;
    }

    private int getSessionType(VideoCaptureConfig<T> videoCaptureConfig) {
        videoCaptureConfig.getClass();
        return UseCaseConfig.CC.l(videoCaptureConfig, 0);
    }

    private List<Quality> getSupportedQualitiesOrThrow(DynamicRange dynamicRange, VideoCapabilities videoCapabilities, int i2) throws IllegalArgumentException {
        List<Quality> supportedQualities = videoCapabilities.getSupportedQualities(dynamicRange);
        Logger.d(TAG, "supportedQualities = " + supportedQualities);
        if (supportedQualities.isEmpty() && i2 == 1) {
            throw new IllegalArgumentException("No supported quality on the device for high-speed capture.");
        }
        return supportedQualities;
    }

    private List<Size> getSupportedResolutions(CameraInfoInternal cameraInfoInternal, int i2, Range<Integer> range) {
        return i2 == 1 ? StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(range) ? cameraInfoInternal.getSupportedHighSpeedResolutions() : cameraInfoInternal.getSupportedHighSpeedResolutionsFor(range) : cameraInfoInternal.getSupportedResolutions(getImageFormat());
    }

    private VideoCapabilities getVideoCapabilities(CameraInfo cameraInfo, int i2) {
        return getOutput().getMediaCapabilities(cameraInfo, i2);
    }

    private boolean isCreateNodeNeeded(CameraInternal cameraInternal, VideoCaptureConfig<?> videoCaptureConfig, Rect rect, Size size, DynamicRange dynamicRange) {
        return getEffect() != null || shouldEnableSurfaceProcessingByConfig(cameraInternal, videoCaptureConfig) || shouldEnableSurfaceProcessingByQuirk(cameraInternal) || shouldEnableSurfaceProcessingBasedOnDynamicRangeByQuirk(cameraInternal, dynamicRange) || shouldCrop(rect, size) || shouldMirror(cameraInternal) || shouldCompensateTransformation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$adjustCropRectToValidSize$4(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getHeight() - rect.height()) + Math.abs(size.getWidth() - rect.width())) - (Math.abs(size2.getHeight() - rect.height()) + Math.abs(size2.getWidth() - rect.width()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$2(DeferrableSurface deferrableSurface) {
        if (deferrableSurface == this.mDeferrableSurface) {
            clearPipeline();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPipeline$3(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        resetPipeline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setupSurfaceUpdateNotifier$5(AtomicBoolean atomicBoolean, SessionConfig.Builder builder, CameraCaptureCallback cameraCaptureCallback) {
        Preconditions.checkState(Threads.isMainThread(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        builder.removeCameraCaptureCallback(cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setupSurfaceUpdateNotifier$6(SessionConfig.Builder builder, CallbackToFutureAdapter.Completer completer) throws Exception {
        builder.addTag(SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(atomicBoolean, completer, builder);
        completer.addCancellationListener(new p(atomicBoolean, builder, anonymousClass2, 1), CameraXExecutors.directExecutor());
        builder.addRepeatingCameraCaptureCallback(anonymousClass2);
        return String.format("%s[0x%x]", SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAppEdgeInvalidated, reason: merged with bridge method [inline-methods] */
    public void lambda$createPipeline$1(SurfaceEdge surfaceEdge, CameraInternal cameraInternal, VideoCaptureConfig<T> videoCaptureConfig, Timebase timebase, boolean z2) {
        if (cameraInternal == getCamera()) {
            this.mSurfaceRequest = surfaceEdge.createSurfaceRequest(cameraInternal);
            videoCaptureConfig.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, timebase, z2);
            sendTransformationInfoIfReady();
        }
    }

    private static Range<Integer> resolveFrameRate(StreamSpec streamSpec) {
        Range<Integer> expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
        return Objects.equals(expectedFrameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) ? streamSpec.getSessionType() == 1 ? Defaults.DEFAULT_HIGH_SPEED_FPS_RANGE : Defaults.DEFAULT_FPS_RANGE : expectedFrameRateRange;
    }

    private static Timebase resolveTimebase(CameraInternal cameraInternal, SurfaceProcessorNode surfaceProcessorNode) {
        return (surfaceProcessorNode == null && cameraInternal.getHasTransform()) ? Timebase.UPTIME : cameraInternal.getCameraInfoInternal().getTimebase();
    }

    private static VideoEncoderInfo resolveVideoEncoderInfo(VideoEncoderInfo.Finder finder, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, DynamicRange dynamicRange) {
        VideoEncoderInfo videoEncoderInfoFind = finder.find(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy).getMimeType());
        if (videoEncoderInfoFind != null) {
            return VideoEncoderInfoWrapper.from(videoEncoderInfoFind, videoValidatedEncoderProfilesProxy != null ? videoValidatedEncoderProfilesProxy.getDefaultVideoProfile().getResolution() : null);
        }
        Logger.w(TAG, "Can't find videoEncoderInfo");
        return null;
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal camera = getCamera();
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (camera == null || surfaceEdge == null) {
            return;
        }
        int compensatedRotation = getCompensatedRotation(camera);
        this.mRotationDegrees = compensatedRotation;
        surfaceEdge.updateTransformation(compensatedRotation, getAppTargetRotation());
    }

    private void setCustomOrderedResolutions(UseCaseConfig.Builder<?, ?, ?> builder, LinkedHashMap<Quality, List<Size>> linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<Size>> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        Logger.d(TAG, "Set custom ordered resolutions = " + arrayList);
        builder.getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, arrayList);
        this.mQualityToCustomSizesMap = linkedHashMap;
    }

    @MainThread
    private void setupSurfaceUpdateNotifier(SessionConfig.Builder builder, final boolean z2) {
        j2.q qVar = this.mSurfaceUpdateFuture;
        if (qVar != null && qVar.cancel(false)) {
            Logger.d(TAG, "A newer surface update is requested. Previous surface update cancelled.");
        }
        final j2.q future = CallbackToFutureAdapter.getFuture(new c(2, this, builder));
        this.mSurfaceUpdateFuture = future;
        Futures.addCallback(future, new FutureCallback<Void>() { // from class: androidx.camera.video.VideoCapture.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof CancellationException) {
                    return;
                }
                Logger.e(VideoCapture.TAG, "Surface update completed with unexpected exception", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r32) {
                j2.q qVar2 = future;
                VideoCapture videoCapture = VideoCapture.this;
                if (qVar2 != videoCapture.mSurfaceUpdateFuture || videoCapture.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                videoCapture.setSourceState(z2 ? VideoOutput.SourceState.ACTIVE_STREAMING : VideoOutput.SourceState.ACTIVE_NON_STREAMING);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    private boolean shouldCompensateTransformation() {
        return this.mStreamInfo.getInProgressTransformationInfo() != null;
    }

    private static boolean shouldCrop(Rect rect, Size size) {
        return (size.getWidth() == rect.width() && size.getHeight() == rect.height()) ? false : true;
    }

    private static boolean shouldEnableSurfaceProcessingBasedOnDynamicRangeByQuirk(CameraInternal cameraInternal, DynamicRange dynamicRange) {
        HdrRepeatingRequestFailureQuirk hdrRepeatingRequestFailureQuirk = (HdrRepeatingRequestFailureQuirk) DeviceQuirks.get(HdrRepeatingRequestFailureQuirk.class);
        return cameraInternal.getHasTransform() && hdrRepeatingRequestFailureQuirk != null && hdrRepeatingRequestFailureQuirk.workaroundBySurfaceProcessing(dynamicRange);
    }

    private static <T extends VideoOutput> boolean shouldEnableSurfaceProcessingByConfig(CameraInternal cameraInternal, VideoCaptureConfig<T> videoCaptureConfig) {
        return cameraInternal.getHasTransform() && videoCaptureConfig.isSurfaceProcessingForceEnabled();
    }

    private static boolean shouldEnableSurfaceProcessingByQuirk(CameraInternal cameraInternal) {
        if (cameraInternal.getHasTransform()) {
            return androidx.camera.core.internal.compat.quirk.b.b(DeviceQuirks.getAll()) || androidx.camera.core.internal.compat.quirk.b.b(cameraInternal.getCameraInfoInternal().getCameraQuirks());
        }
        return false;
    }

    private boolean shouldMirror(CameraInternal cameraInternal) {
        return cameraInternal.getHasTransform() && isMirroringRequired(cameraInternal);
    }

    private void updateCustomOrderedResolutionsByQuality(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) throws IllegalArgumentException {
        MediaSpec mediaSpecOrThrow = getMediaSpecOrThrow();
        QualitySelector qualitySelector = mediaSpecOrThrow.getVideoSpec().getQualitySelector();
        VideoCaptureConfig<T> videoCaptureConfig = (VideoCaptureConfig) builder.getUseCaseConfig();
        Config.Option<List<Size>> option = ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS;
        videoCaptureConfig.getClass();
        if (androidx.camera.core.impl.w.a(videoCaptureConfig, option)) {
            Preconditions.checkArgument(qualitySelector == VideoSpec.QUALITY_SELECTOR_AUTO, "Custom ordered resolutions and QualitySelector can't both be set");
            return;
        }
        DynamicRange dynamicRangeA = androidx.camera.core.impl.s.a(videoCaptureConfig);
        int sessionType = getSessionType(videoCaptureConfig);
        Range<Integer> targetFrameRate = getTargetFrameRate(videoCaptureConfig);
        VideoCapabilities videoCapabilities = getVideoCapabilities(cameraInfoInternal, sessionType);
        Logger.d(TAG, "Update custom order resolutions: requestedDynamicRange = " + dynamicRangeA + ", sessionType = " + sessionType + ", targetFrameRate = " + targetFrameRate);
        List<Quality> supportedQualitiesOrThrow = getSupportedQualitiesOrThrow(dynamicRangeA, videoCapabilities, sessionType);
        if (supportedQualitiesOrThrow.isEmpty()) {
            Logger.w(TAG, "Can't find any supported quality on the device.");
        } else {
            setCustomOrderedResolutions(builder, createOrderedQualityToSizesMap(cameraInfoInternal, mediaSpecOrThrow, dynamicRangeA, videoCapabilities, sessionType, targetFrameRate, videoCaptureConfig.getVideoEncoderInfoFinder(), getSelectedQualityOrThrow(supportedQualitiesOrThrow, qualitySelector)));
        }
    }

    public static <T extends VideoOutput> VideoCapture<T> withOutput(T t3) {
        return new Builder((VideoOutput) Preconditions.checkNotNull(t3)).build();
    }

    @MainThread
    public void applyStreamInfoAndStreamSpecToSessionConfigBuilder(SessionConfig.Builder builder, StreamInfo streamInfo, StreamSpec streamSpec) {
        DeferrableSurface deferrableSurface;
        boolean z2 = streamInfo.getId() == -1;
        boolean z7 = streamInfo.getStreamState() == StreamInfo.StreamState.ACTIVE;
        if (z2 && z7) {
            throw new IllegalStateException("Unexpected stream state, stream is error but active");
        }
        builder.clearSurfaces();
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        if (!z2 && (deferrableSurface = this.mDeferrableSurface) != null) {
            if (z7) {
                builder.addSurface(deferrableSurface, dynamicRange, null, -1);
            } else {
                builder.addNonRepeatingSurface(deferrableSurface, dynamicRange);
            }
        }
        setupSurfaceUpdateNotifier(builder, z7);
    }

    @VisibleForTesting
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @VisibleForTesting
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        VideoCaptureConfig<?> config = defaults.getConfig();
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

    public DynamicRange getDynamicRange() {
        return getCurrentConfig().hasDynamicRange() ? getCurrentConfig().getDynamicRange() : Defaults.DEFAULT_DYNAMIC_RANGE;
    }

    public int getMirrorMode() {
        int mirrorModeInternal = getMirrorModeInternal();
        if (mirrorModeInternal == -1) {
            return 0;
        }
        return mirrorModeInternal;
    }

    @VisibleForTesting
    public SurfaceProcessorNode getNode() {
        return this.mNode;
    }

    public T getOutput() {
        return (T) ((VideoCaptureConfig) getCurrentConfig()).getVideoOutput();
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        Rect rect = this.mCropRect;
        int i2 = this.mRotationDegrees;
        if (camera == null || attachedSurfaceResolution == null || rect == null) {
            return null;
        }
        return new ResolutionInfo(attachedSurfaceResolution, rect, i2);
    }

    @VisibleForTesting
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Quality getSelectedQuality() {
        StreamSpec attachedStreamSpec = getAttachedStreamSpec();
        if (attachedStreamSpec == null) {
            return null;
        }
        Size originalConfiguredResolution = attachedStreamSpec.getOriginalConfiguredResolution();
        for (Map.Entry<Quality, List<Size>> entry : this.mQualityToCustomSizesMap.entrySet()) {
            if (entry.getValue().contains(originalConfiguredResolution)) {
                return entry.getKey();
            }
        }
        Logger.w(TAG, "Can't find matched Quality for " + originalConfiguredResolution);
        return findNearestSizeFor(this.mQualityToCustomSizesMap, originalConfiguredResolution);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<DynamicRange> getSupportedDynamicRanges(CameraInfoInternal cameraInfoInternal) {
        return getVideoCapabilities(cameraInfoInternal, 0).getSupportedDynamicRanges();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        return hashSet;
    }

    @VisibleForTesting
    public SurfaceRequest getSurfaceRequest() {
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Objects.requireNonNull(surfaceRequest);
        return surfaceRequest;
    }

    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    public boolean isStreamIdChanged(int i2, int i8) {
        Set<Integer> set = StreamInfo.NON_SURFACE_STREAM_ID;
        return (set.contains(Integer.valueOf(i2)) || set.contains(Integer.valueOf(i8)) || i2 == i8) ? false : true;
    }

    public boolean isVideoStabilizationEnabled() {
        return getCurrentConfig().getVideoStabilizationMode() == 2;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        updateCustomOrderedResolutionsByQuality(cameraInfoInternal, builder);
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSessionStart() {
        super.onSessionStart();
        Logger.d(TAG, "VideoCapture#onStateAttached: cameraID = " + getCameraId());
        if (getAttachedStreamSpec() == null || this.mSurfaceRequest != null) {
            return;
        }
        StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec());
        this.mStreamInfo = (StreamInfo) fetchObservableValue(getOutput().getStreamInfo(), StreamInfo.STREAM_INFO_ANY_INACTIVE);
        SessionConfig.Builder builderCreatePipeline = createPipeline((VideoCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = builderCreatePipeline;
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(builderCreatePipeline, this.mStreamInfo, streamSpec);
        Object[] objArr = {this.mSessionConfigBuilder.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyActive();
        getOutput().getStreamInfo().addObserver(CameraXExecutors.mainThreadExecutor(), this.mStreamInfoObserver);
        SourceStreamRequirementObserver sourceStreamRequirementObserver = this.mSourceStreamRequirementObserver;
        if (sourceStreamRequirementObserver != null) {
            sourceStreamRequirementObserver.close();
        }
        this.mSourceStreamRequirementObserver = new SourceStreamRequirementObserver(getCameraControl());
        getOutput().isSourceStreamRequired().addObserver(CameraXExecutors.mainThreadExecutor(), this.mSourceStreamRequirementObserver);
        setSourceState(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    @Override // androidx.camera.core.UseCase
    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSessionStop() {
        Logger.d(TAG, "VideoCapture#onStateDetached");
        Preconditions.checkState(Threads.isMainThread(), "VideoCapture can only be detached on the main thread.");
        if (this.mSourceStreamRequirementObserver != null) {
            getOutput().isSourceStreamRequired().removeObserver(this.mSourceStreamRequirementObserver);
            this.mSourceStreamRequirementObserver.close();
            this.mSourceStreamRequirementObserver = null;
        }
        setSourceState(VideoOutput.SourceState.INACTIVE);
        getOutput().getStreamInfo().removeObserver(this.mStreamInfoObserver);
        j2.q qVar = this.mSurfaceUpdateFuture;
        if (qVar != null && qVar.cancel(false)) {
            Logger.d(TAG, "VideoCapture is detached from the camera. Surface update cancelled.");
        }
        clearPipeline();
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
        StreamSpec attachedStreamSpec = getAttachedStreamSpec();
        Objects.requireNonNull(attachedStreamSpec);
        return attachedStreamSpec.toBuilder().setImplementationOptions(config).build();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec, StreamSpec streamSpec2) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + streamSpec + ", secondaryStreamSpec " + streamSpec2);
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
        videoCaptureConfig.getClass();
        List listC = androidx.camera.core.impl.t.c(videoCaptureConfig, null);
        if (listC != null && !listC.contains(streamSpec.getResolution())) {
            Logger.w(TAG, "suggested resolution " + streamSpec.getResolution() + " is not in custom ordered resolutions " + listC);
        }
        return streamSpec;
    }

    @MainThread
    public void resetPipeline() {
        if (getCamera() == null) {
            return;
        }
        clearPipeline();
        SessionConfig.Builder builderCreatePipeline = createPipeline((VideoCaptureConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = builderCreatePipeline;
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(builderCreatePipeline, this.mStreamInfo, getAttachedStreamSpec());
        Object[] objArr = {this.mSessionConfigBuilder.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        notifyReset();
    }

    @MainThread
    public void setSourceState(VideoOutput.SourceState sourceState) {
        if (sourceState != this.mSourceState) {
            this.mSourceState = sourceState;
            getOutput().onSourceStateChanged(sourceState);
        }
    }

    public void setTargetRotation(int i2) {
        if (setTargetRotationInternal(i2)) {
            sendTransformationInfoIfReady();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(Rect rect) {
        super.setViewPortCropRect(rect);
        sendTransformationInfoIfReady();
    }

    public boolean shouldResetCompensatingTransformation(StreamInfo streamInfo, StreamInfo streamInfo2) {
        return this.mHasCompensatingTransformation && streamInfo.getInProgressTransformationInfo() != null && streamInfo2.getInProgressTransformationInfo() == null;
    }

    public String toString() {
        return "VideoCapture:" + getName();
    }

    private Range<Integer> getTargetFrameRate(VideoCaptureConfig<T> videoCaptureConfig) {
        Range<Integer> range = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        videoCaptureConfig.getClass();
        Range<Integer> rangeR = UseCaseConfig.CC.r(videoCaptureConfig, range);
        Objects.requireNonNull(rangeR);
        return rangeR;
    }
}
