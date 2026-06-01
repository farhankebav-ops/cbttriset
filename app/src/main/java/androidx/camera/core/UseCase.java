package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.feature.DynamicRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.FpsRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UseCase {
    private static final String TAG = "UseCase";
    private StreamSpec mAttachedStreamSpec;

    @GuardedBy("mCameraLock")
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private UseCaseConfig<?> mCurrentConfig;
    private CameraEffect mEffect;
    private UseCaseConfig<?> mExtendedConfig;

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    private Set<GroupableFeature> mFeatureGroup;
    private String mPhysicalCameraId;

    @GuardedBy("mCameraLock")
    private CameraInternal mSecondaryCamera;
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;
    private boolean mInSession = false;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private final Object mCameraLock = new Object();
    private State mState = State.INACTIVE;
    private Matrix mSensorToBufferTransformMatrix = new Matrix();
    private androidx.camera.core.impl.SessionConfig mAttachedSessionConfig = androidx.camera.core.impl.SessionConfig.defaultEmptySessionConfig();
    private androidx.camera.core.impl.SessionConfig mAttachedSecondarySessionConfig = androidx.camera.core.impl.SessionConfig.defaultEmptySessionConfig();

    /* JADX INFO: renamed from: androidx.camera.core.UseCase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$featuregroup$impl$feature$VideoStabilizationFeature$StabilizationMode;

        static {
            int[] iArr = new int[VideoStabilizationFeature.StabilizationMode.values().length];
            $SwitchMap$androidx$camera$core$featuregroup$impl$feature$VideoStabilizationFeature$StabilizationMode = iArr;
            try {
                iArr[VideoStabilizationFeature.StabilizationMode.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$featuregroup$impl$feature$VideoStabilizationFeature$StabilizationMode[VideoStabilizationFeature.StabilizationMode.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$featuregroup$impl$feature$VideoStabilizationFeature$StabilizationMode[VideoStabilizationFeature.StabilizationMode.PREVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum State {
        ACTIVE,
        INACTIVE
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StateChangeCallback {
        void onUseCaseActive(UseCase useCase);

        void onUseCaseInactive(UseCase useCase);

        void onUseCaseReset(UseCase useCase);

        void onUseCaseUpdated(UseCase useCase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCase(UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    private void addStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void applyFeatureGroupToConfig(MutableOptionsBundle mutableOptionsBundle) {
        Logger.d(TAG, "applyFeaturesToConfig: mFeatureGroup = " + this.mFeatureGroup + ", this = " + this);
        Set<GroupableFeature> set = this.mFeatureGroup;
        if (set == null) {
            return;
        }
        DynamicRange dynamicRange = DynamicRangeFeature.DEFAULT_DYNAMIC_RANGE;
        Range<Integer> range = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        VideoStabilizationFeature.StabilizationMode mode = VideoStabilizationFeature.DEFAULT_STABILIZATION_MODE;
        for (GroupableFeature groupableFeature : set) {
            if (groupableFeature instanceof DynamicRangeFeature) {
                dynamicRange = ((DynamicRangeFeature) groupableFeature).getDynamicRange();
            } else if (groupableFeature instanceof FpsRangeFeature) {
                FpsRangeFeature fpsRangeFeature = (FpsRangeFeature) groupableFeature;
                range = new Range<>(Integer.valueOf(fpsRangeFeature.getMinFps()), Integer.valueOf(fpsRangeFeature.getMaxFps()));
            } else if (groupableFeature instanceof VideoStabilizationFeature) {
                mode = ((VideoStabilizationFeature) groupableFeature).getMode();
            }
        }
        if ((this instanceof Preview) || CameraUseCaseAdapter.isVideoCapture(this)) {
            mutableOptionsBundle.insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
        }
        mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
        int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$featuregroup$impl$feature$VideoStabilizationFeature$StabilizationMode[mode.ordinal()];
        if (i2 == 1) {
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 1);
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 1);
        } else if (i2 == 2) {
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0);
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 2);
        } else {
            if (i2 != 3) {
                return;
            }
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 2);
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0);
        }
    }

    private void removeStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    public static int snapToSurfaceRotation(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i2) {
        Preconditions.checkArgumentInRange(i2, 0, 359, "orientation");
        if (i2 >= 315 || i2 < 45) {
            return 0;
        }
        if (i2 >= 225) {
            return 1;
        }
        return i2 >= 135 ? 2 : 3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void applyExpectedFrameRateRange(SessionConfig.Builder builder, StreamSpec streamSpec) {
        if (!StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(streamSpec.getExpectedFrameRateRange())) {
            builder.setExpectedFrameRateRange(streamSpec.getExpectedFrameRateRange());
            return;
        }
        synchronized (this.mCameraLock) {
            try {
                List all = ((CameraInternal) Preconditions.checkNotNull(this.mCamera)).getCameraInfoInternal().getCameraQuirks().getAll(AeFpsRangeQuirk.class);
                boolean z2 = true;
                if (all.size() > 1) {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "There should not have more than one AeFpsRangeQuirk.");
                if (!all.isEmpty()) {
                    builder.setExpectedFrameRateRange(((AeFpsRangeQuirk) all.get(0)).getTargetAeFpsRange());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void bindToCamera(CameraInternal cameraInternal, CameraInternal cameraInternal2, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.mCameraLock) {
            try {
                this.mCamera = cameraInternal;
                this.mSecondaryCamera = cameraInternal2;
                addStateChangeCallback(cameraInternal);
                if (cameraInternal2 != null) {
                    addStateChangeCallback(cameraInternal2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        this.mCurrentConfig = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        onBind();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getAppConfig() {
        return this.mUseCaseConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getAttachedSurfaceResolution() {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.getResolution();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            try {
                CameraInternal cameraInternal = this.mCamera;
                if (cameraInternal == null) {
                    return CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                }
                return cameraInternal.getCameraControlInternal();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getCamera(), "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig<?> getDefaultConfig(boolean z2, UseCaseConfigFactory useCaseConfigFactory);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect getEffect() {
        return this.mEffect;
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<GroupableFeature> getFeatureGroup() {
        return this.mFeatureGroup;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(-1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getName() {
        String targetName = this.mCurrentConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(targetName);
        return targetName;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getRelativeRotation(CameraInternal cameraInternal) {
        return getRelativeRotation(cameraInternal, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        if (viewPortCropRect == null) {
            viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        return new ResolutionInfo(attachedSurfaceResolution, viewPortCropRect, getRelativeRotation(camera));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getSecondaryCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mSecondaryCamera;
        }
        return cameraInternal;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getSecondaryCameraId() {
        if (getSecondaryCamera() == null) {
            return null;
        }
        return getSecondaryCamera().getCameraInfoInternal().getCameraId();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public androidx.camera.core.impl.SessionConfig getSecondarySessionConfig() {
        return this.mAttachedSecondarySessionConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public androidx.camera.core.impl.SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<DynamicRange> getSupportedDynamicRanges(CameraInfoInternal cameraInfoInternal) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Integer> getSupportedEffectTargets() {
        return Collections.EMPTY_SET;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isCurrentCamera(String str) {
        if (getCamera() == null) {
            return false;
        }
        return Objects.equals(str, getCameraId());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEffectTargetsSupported(int i2) {
        Iterator<Integer> it = getSupportedEffectTargets().iterator();
        while (it.hasNext()) {
            if (TargetUtils.isSuperset(i2, it.next().intValue())) {
                return true;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isInSession() {
        return this.mInSession;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isMirroringRequired(CameraInternal cameraInternal) {
        int mirrorModeInternal = getMirrorModeInternal();
        if (mirrorModeInternal == -1 || mirrorModeInternal == 0) {
            return false;
        }
        if (mirrorModeInternal == 1) {
            return true;
        }
        if (mirrorModeInternal == 2) {
            return cameraInternal.isFrontFacing();
        }
        throw new AssertionError(a1.a.g(mirrorModeInternal, "Unknown mirrorMode: "));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle mutableOptionsBundleCreate;
        if (useCaseConfig2 != null) {
            mutableOptionsBundleCreate = MutableOptionsBundle.from((Config) useCaseConfig2);
            mutableOptionsBundleCreate.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundleCreate = MutableOptionsBundle.create();
        }
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) || this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<ResolutionSelector> option = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
            if (mutableOptionsBundleCreate.containsOption(option)) {
                mutableOptionsBundleCreate.removeOption(option);
            }
        }
        UseCaseConfig<?> useCaseConfig3 = this.mUseCaseConfig;
        Config.Option<ResolutionSelector> option2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (useCaseConfig3.containsOption(option2)) {
            Config.Option<Size> option3 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
            if (mutableOptionsBundleCreate.containsOption(option3) && ((ResolutionSelector) this.mUseCaseConfig.retrieveOption(option2)).getResolutionStrategy() != null) {
                mutableOptionsBundleCreate.removeOption(option3);
            }
        }
        Iterator<Config.Option<?>> it = this.mUseCaseConfig.listOptions().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.o.c(mutableOptionsBundleCreate, mutableOptionsBundleCreate, this.mUseCaseConfig, it.next());
        }
        if (useCaseConfig != null) {
            for (Config.Option<?> option4 : useCaseConfig.listOptions()) {
                if (!option4.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) {
                    androidx.camera.core.impl.o.c(mutableOptionsBundleCreate, mutableOptionsBundleCreate, useCaseConfig, option4);
                }
            }
        }
        if (mutableOptionsBundleCreate.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<Integer> option5 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
            if (mutableOptionsBundleCreate.containsOption(option5)) {
                mutableOptionsBundleCreate.removeOption(option5);
            }
        }
        Config.Option<ResolutionSelector> option6 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (mutableOptionsBundleCreate.containsOption(option6) && ((ResolutionSelector) mutableOptionsBundleCreate.retrieveOption(option6)).getAllowedResolutionMode() != 0) {
            mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        }
        applyFeatureGroupToConfig(mutableOptionsBundleCreate);
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(mutableOptionsBundleCreate));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyReset() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseReset(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyState() {
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 0) {
            Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onUseCaseActive(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator<StateChangeCallback> it2 = this.mStateChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onUseCaseInactive(this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyUpdated() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseUpdated(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        return builder.getUseCaseConfig();
    }

    @CallSuper
    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSessionStart() {
        this.mInSession = true;
    }

    @MainThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSessionStop() {
        this.mInSession = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.toBuilder().setImplementationOptions(config).build();
        }
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEffect(CameraEffect cameraEffect) {
        Preconditions.checkArgument(cameraEffect == null || isEffectTargetsSupported(cameraEffect.getTargets()));
        this.mEffect = cameraEffect;
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFeatureGroup(Set<GroupableFeature> set) {
        this.mFeatureGroup = set != null ? new HashSet(set) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setPhysicalCameraId(String str) {
        this.mPhysicalCameraId = str;
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        this.mSensorToBufferTransformMatrix = new Matrix(matrix);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean setTargetRotationInternal(int i2) {
        int targetRotation = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (targetRotation != -1 && targetRotation == i2) {
            return false;
        }
        UseCaseConfig.Builder<?, ?, ?> useCaseConfigBuilder = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(useCaseConfigBuilder, i2);
        this.mUseCaseConfig = useCaseConfigBuilder.getUseCaseConfig();
        CameraInternal camera = getCamera();
        if (camera == null) {
            this.mCurrentConfig = this.mUseCaseConfig;
            return true;
        }
        this.mCurrentConfig = mergeConfigs(camera.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void unbindFromCamera(CameraInternal cameraInternal) {
        onUnbind();
        synchronized (this.mCameraLock) {
            try {
                CameraInternal cameraInternal2 = this.mCamera;
                if (cameraInternal == cameraInternal2) {
                    removeStateChangeCallback(cameraInternal2);
                    this.mCamera = null;
                }
                CameraInternal cameraInternal3 = this.mSecondaryCamera;
                if (cameraInternal == cameraInternal3) {
                    removeStateChangeCallback(cameraInternal3);
                    this.mSecondaryCamera = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSessionConfig(List<androidx.camera.core.impl.SessionConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        this.mAttachedSessionConfig = list.get(0);
        if (list.size() > 1) {
            this.mAttachedSecondarySessionConfig = list.get(1);
        }
        Iterator<androidx.camera.core.impl.SessionConfig> it = list.iterator();
        while (it.hasNext()) {
            for (DeferrableSurface deferrableSurface : it.next().getSurfaces()) {
                if (deferrableSurface.getContainerClass() == null) {
                    deferrableSurface.setContainerClass(getClass());
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedStreamSpec(StreamSpec streamSpec, StreamSpec streamSpec2) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(streamSpec, streamSpec2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedStreamSpecImplementationOptions(Config config) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(config);
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getRelativeRotation(CameraInternal cameraInternal, boolean z2) {
        int sensorRotationDegrees = cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        return (cameraInternal.getHasTransform() || !z2) ? sensorRotationDegrees : TransformUtils.within360(-sensorRotationDegrees);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onBind() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onCameraControlReady() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnbind() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec, StreamSpec streamSpec2) {
        return streamSpec;
    }
}
