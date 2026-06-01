package androidx.camera.core.featuregroup.impl;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import j2.q;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface FeatureCombinationQuery {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FeatureCombinationQuery NO_OP_FEATURE_COMBINATION_QUERY = new FeatureCombinationQuery() { // from class: androidx.camera.core.featuregroup.impl.FeatureCombinationQuery$Companion$NO_OP_FEATURE_COMBINATION_QUERY$1
        @Override // androidx.camera.core.featuregroup.impl.FeatureCombinationQuery
        public boolean isSupported(SessionConfig sessionConfig) {
            k.e(sessionConfig, "sessionConfig");
            return false;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SessionConfig.Builder createSessionConfigBuilder(UseCaseConfig<?> useCaseConfig, final Size resolution, DynamicRange dynamicRange) {
            k.e(useCaseConfig, "<this>");
            k.e(resolution, "resolution");
            k.e(dynamicRange, "dynamicRange");
            final int inputFormat = useCaseConfig.getInputFormat();
            DeferrableSurface deferrableSurface = new DeferrableSurface(resolution, inputFormat) { // from class: androidx.camera.core.featuregroup.impl.FeatureCombinationQuery$Companion$createSessionConfigBuilder$deferrableSurface$1
                @Override // androidx.camera.core.impl.DeferrableSurface
                public q provideSurface() {
                    q qVarImmediateFuture = Futures.immediateFuture(null);
                    k.d(qVarImmediateFuture, "immediateFuture(...)");
                    return qVarImmediateFuture;
                }
            };
            Class<?> surfaceClass = UseCaseType.Companion.getFeatureGroupUseCaseType(useCaseConfig).getSurfaceClass();
            if (surfaceClass != null) {
                deferrableSurface.setContainerClass(surfaceClass);
            }
            SessionConfig.Builder builderAddSurface = SessionConfig.Builder.createFrom(useCaseConfig, resolution).addSurface(deferrableSurface, dynamicRange);
            k.d(builderAddSurface, "addSurface(...)");
            return builderAddSurface;
        }
    }

    boolean isSupported(SessionConfig sessionConfig);
}
