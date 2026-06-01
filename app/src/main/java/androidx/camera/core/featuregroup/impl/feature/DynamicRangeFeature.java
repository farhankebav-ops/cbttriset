package androidx.camera.core.featuregroup.impl.feature;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicRangeFeature extends GroupableFeature {
    public static final Companion Companion = new Companion(null);
    public static final DynamicRange DEFAULT_DYNAMIC_RANGE;
    private static final String TAG = "DynamicRangeFeature";
    private final DynamicRange dynamicRange;
    private final FeatureTypeInternal featureTypeInternal;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        DynamicRange SDR = DynamicRange.SDR;
        k.d(SDR, "SDR");
        DEFAULT_DYNAMIC_RANGE = SDR;
    }

    public DynamicRangeFeature(DynamicRange dynamicRange) {
        k.e(dynamicRange, "dynamicRange");
        this.dynamicRange = dynamicRange;
        this.featureTypeInternal = FeatureTypeInternal.DYNAMIC_RANGE;
    }

    public final DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.featuregroup.GroupableFeature
    public FeatureTypeInternal getFeatureTypeInternal$camera_core_release() {
        return this.featureTypeInternal;
    }

    @Override // androidx.camera.core.featuregroup.GroupableFeature
    public boolean isSupportedIndividually(CameraInfoInternal cameraInfoInternal, SessionConfig sessionConfig) {
        k.e(cameraInfoInternal, "cameraInfoInternal");
        k.e(sessionConfig, "sessionConfig");
        Set<DynamicRange> supportedDynamicRanges = cameraInfoInternal.getSupportedDynamicRanges();
        k.d(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Logger.d(TAG, "isSupportedIndividually: cameraInfoSupportedDynamicRanges = " + supportedDynamicRanges + ", this = " + this);
        if (!supportedDynamicRanges.contains(this.dynamicRange)) {
            return false;
        }
        for (UseCase useCase : sessionConfig.getUseCases()) {
            Set<DynamicRange> supportedDynamicRanges2 = useCase.getSupportedDynamicRanges(cameraInfoInternal);
            Logger.d(TAG, "isSupportedIndividually: useCaseSupportedDynamicRanges = " + supportedDynamicRanges2 + ", this = " + this + ", useCases = " + useCase);
            if (supportedDynamicRanges2 != null && !supportedDynamicRanges2.contains(this.dynamicRange)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "DynamicRangeFeature(dynamicRange=" + this.dynamicRange + ')';
    }
}
