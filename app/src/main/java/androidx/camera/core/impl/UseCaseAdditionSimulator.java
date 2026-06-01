package androidx.camera.core.impl;

import androidx.camera.core.CameraUseCaseAdapterProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.internal.CalculatedUseCaseInfo;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseAdditionSimulator {
    public static final UseCaseAdditionSimulator INSTANCE = new UseCaseAdditionSimulator();
    public static CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider;

    private UseCaseAdditionSimulator() {
    }

    public static final CameraUseCaseAdapterProvider getCameraUseCaseAdapterProvider() {
        CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider2 = cameraUseCaseAdapterProvider;
        if (cameraUseCaseAdapterProvider2 != null) {
            return cameraUseCaseAdapterProvider2;
        }
        kotlin.jvm.internal.k.l("cameraUseCaseAdapterProvider");
        throw null;
    }

    public static final void setCameraUseCaseAdapterProvider(CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider2) {
        kotlin.jvm.internal.k.e(cameraUseCaseAdapterProvider2, "<set-?>");
        cameraUseCaseAdapterProvider = cameraUseCaseAdapterProvider2;
    }

    public static final CalculatedUseCaseInfo simulateAddUseCases(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig) throws IllegalStateException, CameraUseCaseAdapter.CameraException {
        kotlin.jvm.internal.k.e(cameraInfoInternal, "cameraInfoInternal");
        kotlin.jvm.internal.k.e(sessionConfig, "sessionConfig");
        return simulateAddUseCases$default(cameraInfoInternal, sessionConfig, false, null, 12, null);
    }

    public static /* synthetic */ CalculatedUseCaseInfo simulateAddUseCases$default(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig, boolean z2, ResolvedFeatureGroup resolvedFeatureGroup, int i2, Object obj) throws IllegalStateException, CameraUseCaseAdapter.CameraException {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            resolvedFeatureGroup = null;
        }
        return simulateAddUseCases(cameraInfoInternal, sessionConfig, z2, resolvedFeatureGroup);
    }

    public static final CalculatedUseCaseInfo simulateAddUseCases(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig, boolean z2) throws IllegalStateException, CameraUseCaseAdapter.CameraException {
        kotlin.jvm.internal.k.e(cameraInfoInternal, "cameraInfoInternal");
        kotlin.jvm.internal.k.e(sessionConfig, "sessionConfig");
        return simulateAddUseCases$default(cameraInfoInternal, sessionConfig, z2, null, 8, null);
    }

    public static final CalculatedUseCaseInfo simulateAddUseCases(CameraInfoInternal cameraInfoInternal, androidx.camera.core.SessionConfig sessionConfig, boolean z2, ResolvedFeatureGroup resolvedFeatureGroup) throws IllegalStateException, CameraUseCaseAdapter.CameraException {
        kotlin.jvm.internal.k.e(cameraInfoInternal, "cameraInfoInternal");
        kotlin.jvm.internal.k.e(sessionConfig, "sessionConfig");
        if (cameraUseCaseAdapterProvider != null) {
            CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider2 = getCameraUseCaseAdapterProvider();
            String cameraId = cameraInfoInternal.getCameraId();
            kotlin.jvm.internal.k.d(cameraId, "getCameraId(...)");
            CameraUseCaseAdapter cameraUseCaseAdapterProvide = cameraUseCaseAdapterProvider2.provide(cameraId);
            cameraUseCaseAdapterProvide.setViewPort(sessionConfig.getViewPort());
            cameraUseCaseAdapterProvide.setEffects(sessionConfig.getEffects());
            cameraUseCaseAdapterProvide.setSessionType(sessionConfig.getSessionType());
            cameraUseCaseAdapterProvide.setFrameRate(sessionConfig.getFrameRateRange());
            List<UseCase> useCases = sessionConfig.getUseCases();
            if (resolvedFeatureGroup == null) {
                resolvedFeatureGroup = ResolvedFeatureGroup.Companion.resolveFeatureGroup$default(ResolvedFeatureGroup.Companion, sessionConfig, cameraInfoInternal, null, 2, null);
            }
            CalculatedUseCaseInfo calculatedUseCaseInfoSimulateAddUseCases = cameraUseCaseAdapterProvide.simulateAddUseCases(useCases, resolvedFeatureGroup, z2);
            kotlin.jvm.internal.k.d(calculatedUseCaseInfoSimulateAddUseCases, "simulateAddUseCases(...)");
            return calculatedUseCaseInfoSimulateAddUseCases;
        }
        throw new IllegalStateException("mCameraUseCaseAdapterProvider must be initialized first!");
    }

    public static /* synthetic */ void getCameraUseCaseAdapterProvider$annotations() {
    }
}
