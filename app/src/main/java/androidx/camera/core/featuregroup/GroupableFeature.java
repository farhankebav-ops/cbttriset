package androidx.camera.core.featuregroup;

import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.featuregroup.impl.feature.DynamicRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.featuregroup.impl.feature.FpsRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.ImageFormatFeature;
import androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature;
import androidx.camera.core.impl.CameraInfoInternal;
import e2.s;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalSessionConfig
public abstract class GroupableFeature {
    public static final Companion Companion = new Companion(null);
    public static final int FEATURE_TYPE_DYNAMIC_RANGE = 0;
    public static final int FEATURE_TYPE_FPS_RANGE = 1;
    public static final int FEATURE_TYPE_IMAGE_FORMAT = 3;
    public static final int FEATURE_TYPE_VIDEO_STABILIZATION = 2;
    public static final GroupableFeature FPS_60;
    public static final GroupableFeature HDR_HLG10;
    public static final GroupableFeature IMAGE_ULTRA_HDR;
    public static final GroupableFeature PREVIEW_STABILIZATION;
    private final f featureType$delegate = b.C(new androidx.activity.result.b(this, 1));

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ExperimentalSessionConfig
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FeatureType {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeatureTypeInternal.values().length];
            try {
                iArr[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureTypeInternal.FPS_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        DynamicRange HLG_10_BIT = DynamicRange.HLG_10_BIT;
        k.d(HLG_10_BIT, "HLG_10_BIT");
        HDR_HLG10 = new DynamicRangeFeature(HLG_10_BIT);
        FPS_60 = new FpsRangeFeature(60, 60);
        PREVIEW_STABILIZATION = new VideoStabilizationFeature(VideoStabilizationFeature.StabilizationMode.PREVIEW);
        IMAGE_ULTRA_HDR = new ImageFormatFeature(1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public GroupableFeature() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int featureType_delegate$lambda$0(GroupableFeature groupableFeature) {
        return groupableFeature.toFeatureType(groupableFeature.getFeatureTypeInternal$camera_core_release());
    }

    private final int toFeatureType(FeatureTypeInternal featureTypeInternal) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[featureTypeInternal.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new s(3);
    }

    public final int getFeatureType() {
        return ((Number) this.featureType$delegate.getValue()).intValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract FeatureTypeInternal getFeatureTypeInternal$camera_core_release();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isSupportedIndividually(CameraInfoInternal cameraInfoInternal, SessionConfig sessionConfig) {
        k.e(cameraInfoInternal, "cameraInfoInternal");
        k.e(sessionConfig, "sessionConfig");
        return true;
    }
}
