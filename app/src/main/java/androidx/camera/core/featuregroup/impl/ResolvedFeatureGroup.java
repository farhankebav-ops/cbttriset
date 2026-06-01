package androidx.camera.core.featuregroup.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.resolver.DefaultFeatureGroupResolver;
import androidx.camera.core.featuregroup.impl.resolver.FeatureGroupResolutionResult;
import androidx.camera.core.featuregroup.impl.resolver.FeatureGroupResolver;
import androidx.camera.core.impl.CameraInfoInternal;
import e2.s;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolvedFeatureGroup {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ResolvedFeatureGroup";
    private final Set<GroupableFeature> features;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ResolvedFeatureGroup resolveFeatureGroup$default(Companion companion, SessionConfig sessionConfig, CameraInfoInternal cameraInfoInternal, FeatureGroupResolver featureGroupResolver, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                featureGroupResolver = new DefaultFeatureGroupResolver(cameraInfoInternal);
            }
            return companion.resolveFeatureGroup(sessionConfig, cameraInfoInternal, featureGroupResolver);
        }

        public final ResolvedFeatureGroup resolveFeatureGroup(SessionConfig sessionConfig, CameraInfoInternal cameraInfoInternal) {
            k.e(sessionConfig, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            return resolveFeatureGroup$default(this, sessionConfig, cameraInfoInternal, null, 2, null);
        }

        private Companion() {
        }

        public final ResolvedFeatureGroup resolveFeatureGroup(SessionConfig sessionConfig, CameraInfoInternal cameraInfoInternal, FeatureGroupResolver resolver) {
            k.e(sessionConfig, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(resolver, "resolver");
            Logger.d(ResolvedFeatureGroup.TAG, "resolveFeatureGroup: sessionConfig = " + sessionConfig + ", lensFacing = " + cameraInfoInternal.getLensFacing());
            if (sessionConfig.getRequiredFeatureGroup().isEmpty() && sessionConfig.getPreferredFeatureGroup().isEmpty()) {
                return null;
            }
            FeatureGroupResolutionResult featureGroupResolutionResultResolveFeatureGroup = resolver.resolveFeatureGroup(sessionConfig);
            if (featureGroupResolutionResultResolveFeatureGroup instanceof FeatureGroupResolutionResult.Supported) {
                ResolvedFeatureGroup resolvedFeatureGroup = ((FeatureGroupResolutionResult.Supported) featureGroupResolutionResultResolveFeatureGroup).getResolvedFeatureGroup();
                Logger.d(ResolvedFeatureGroup.TAG, "resolvedFeatureGroup = " + resolvedFeatureGroup);
                return resolvedFeatureGroup;
            }
            if (featureGroupResolutionResultResolveFeatureGroup instanceof FeatureGroupResolutionResult.Unsupported) {
                throw new IllegalArgumentException("Feature group is not supported");
            }
            if (featureGroupResolutionResultResolveFeatureGroup instanceof FeatureGroupResolutionResult.UnsupportedUseCase) {
                throw new IllegalArgumentException(((FeatureGroupResolutionResult.UnsupportedUseCase) featureGroupResolutionResultResolveFeatureGroup).getUnsupportedUseCase() + " is not supported");
            }
            if (!(featureGroupResolutionResultResolveFeatureGroup instanceof FeatureGroupResolutionResult.UseCaseMissing)) {
                throw new s(3);
            }
            StringBuilder sb = new StringBuilder();
            FeatureGroupResolutionResult.UseCaseMissing useCaseMissing = (FeatureGroupResolutionResult.UseCaseMissing) featureGroupResolutionResultResolveFeatureGroup;
            sb.append(useCaseMissing.getRequiredUseCases());
            sb.append(" must be added for ");
            sb.append(useCaseMissing.getFeatureRequiring());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResolvedFeatureGroup(Set<? extends GroupableFeature> features) {
        k.e(features, "features");
        this.features = features;
    }

    public static final ResolvedFeatureGroup resolveFeatureGroup(SessionConfig sessionConfig, CameraInfoInternal cameraInfoInternal) {
        return Companion.resolveFeatureGroup(sessionConfig, cameraInfoInternal);
    }

    public final Set<GroupableFeature> getFeatures() {
        return this.features;
    }

    public String toString() {
        return "ResolvedFeatureGroup(features=" + this.features + ')';
    }

    public static final ResolvedFeatureGroup resolveFeatureGroup(SessionConfig sessionConfig, CameraInfoInternal cameraInfoInternal, FeatureGroupResolver featureGroupResolver) {
        return Companion.resolveFeatureGroup(sessionConfig, cameraInfoInternal, featureGroupResolver);
    }
}
