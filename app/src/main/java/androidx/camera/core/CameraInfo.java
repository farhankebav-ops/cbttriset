package androidx.camera.core;

import android.util.Range;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraInfo {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;
    public static final int TORCH_STRENGTH_LEVEL_UNSUPPORTED = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImplementationType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraIdentifier getCameraIdentifier();

    CameraSelector getCameraSelector();

    LiveData<CameraState> getCameraState();

    ExposureState getExposureState();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    String getImplementationType();

    @FloatRange(from = 0.0d, fromInclusive = false)
    float getIntrinsicZoomRatio();

    int getLensFacing();

    LiveData<Integer> getLowLightBoostState();

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    int getMaxTorchStrengthLevel();

    Set<CameraInfo> getPhysicalCameraInfos();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i2);

    Set<Range<Integer>> getSupportedFrameRateRanges();

    @ExperimentalSessionConfig
    Set<Range<Integer>> getSupportedFrameRateRanges(SessionConfig sessionConfig);

    LiveData<Integer> getTorchState();

    LiveData<Integer> getTorchStrengthLevel();

    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    @ExperimentalSessionConfig
    boolean isFeatureGroupSupported(SessionConfig sessionConfig);

    boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction);

    boolean isLogicalMultiCameraSupported();

    boolean isLowLightBoostSupported();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isPrivateReprocessingSupported();

    boolean isTorchStrengthSupported();

    @ExperimentalZeroShutterLag
    boolean isZslSupported();

    Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> set);
}
