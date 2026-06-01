package androidx.camera.core.featuregroup.impl.resolver;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.featuregroup.impl.UseCaseType;
import androidx.camera.core.featuregroup.impl.feature.DynamicRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.FpsRangeFeature;
import androidx.camera.core.featuregroup.impl.feature.ImageFormatFeature;
import androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature;
import androidx.camera.core.featuregroup.impl.resolver.FeatureGroupResolutionResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultFeatureGroupResolver implements FeatureGroupResolver {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "DefaultFeatureGroupResolver";
    private final CameraInfoInternal cameraInfoInternal;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public DefaultFeatureGroupResolver(CameraInfoInternal cameraInfoInternal) {
        k.e(cameraInfoInternal, "cameraInfoInternal");
        this.cameraInfoInternal = cameraInfoInternal;
    }

    private final FeatureGroupResolutionResult getFeatureListResolvedByPriority(SessionConfig sessionConfig, List<? extends GroupableFeature> list, int i2, List<? extends GroupableFeature> list2) {
        if (i2 < list.size()) {
            int i8 = i2 + 1;
            FeatureGroupResolutionResult featureListResolvedByPriority = getFeatureListResolvedByPriority(sessionConfig, list, i8, l.g1(list2, list.get(i2)));
            return featureListResolvedByPriority instanceof FeatureGroupResolutionResult.Supported ? featureListResolvedByPriority : getFeatureListResolvedByPriority(sessionConfig, list, i8, list2);
        }
        LinkedHashSet linkedHashSetG = b.G(sessionConfig.getRequiredFeatureGroup(), list2);
        Logger.d(TAG, "getFeatureListResolvedByPriority: features = " + linkedHashSetG + ", useCases = " + sessionConfig.getUseCases());
        return this.cameraInfoInternal.isResolvedFeatureGroupSupported(new ResolvedFeatureGroup(linkedHashSetG), sessionConfig) ? new FeatureGroupResolutionResult.Supported(new ResolvedFeatureGroup(linkedHashSetG)) : FeatureGroupResolutionResult.Unsupported.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureGroupResolutionResult getFeatureListResolvedByPriority$default(DefaultFeatureGroupResolver defaultFeatureGroupResolver, SessionConfig sessionConfig, List list, int i2, List list2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i2 = 0;
        }
        if ((i8 & 8) != 0) {
            list2 = r.f13638a;
        }
        return defaultFeatureGroupResolver.getFeatureListResolvedByPriority(sessionConfig, list, i2, list2);
    }

    @Override // androidx.camera.core.featuregroup.impl.resolver.FeatureGroupResolver
    public FeatureGroupResolutionResult resolveFeatureGroup(SessionConfig sessionConfig) {
        boolean z2;
        k.e(sessionConfig, "sessionConfig");
        List<UseCase> useCases = sessionConfig.getUseCases();
        Set<GroupableFeature> requiredFeatureGroup = sessionConfig.getRequiredFeatureGroup();
        List<GroupableFeature> preferredFeatureGroup = sessionConfig.getPreferredFeatureGroup();
        if (requiredFeatureGroup.isEmpty() && preferredFeatureGroup.isEmpty()) {
            throw new IllegalArgumentException("Must have at least one required or preferred feature");
        }
        boolean z7 = false;
        if (useCases == null || !useCases.isEmpty()) {
            Iterator<T> it = useCases.iterator();
            while (it.hasNext()) {
                if (((UseCase) it.next()) instanceof ImageCapture) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (useCases == null || !useCases.isEmpty()) {
            for (UseCase useCase : useCases) {
                if ((useCase instanceof Preview) || CameraUseCaseAdapter.isVideoCapture(useCase)) {
                    z7 = true;
                    break;
                }
            }
        }
        for (UseCase useCase2 : useCases) {
            if (UseCaseType.Companion.getFeatureGroupUseCaseType(useCase2) == UseCaseType.UNDEFINED) {
                return new FeatureGroupResolutionResult.UnsupportedUseCase(useCase2);
            }
        }
        for (GroupableFeature groupableFeature : requiredFeatureGroup) {
            if (groupableFeature instanceof ImageFormatFeature) {
                if (!z2) {
                    return new FeatureGroupResolutionResult.UseCaseMissing(UseCaseType.IMAGE_CAPTURE.toString(), groupableFeature);
                }
            } else if ((groupableFeature instanceof DynamicRangeFeature) || (groupableFeature instanceof FpsRangeFeature) || (groupableFeature instanceof VideoStabilizationFeature)) {
                if (!z7) {
                    return new FeatureGroupResolutionResult.UseCaseMissing(UseCaseType.PREVIEW + " or " + UseCaseType.VIDEO_CAPTURE, groupableFeature);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : preferredFeatureGroup) {
            if (((GroupableFeature) obj) instanceof ImageFormatFeature ? z2 : true) {
                arrayList.add(obj);
            }
        }
        return getFeatureListResolvedByPriority$default(this, sessionConfig, arrayList, 0, null, 12, null);
    }
}
