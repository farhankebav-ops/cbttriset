package androidx.camera.core;

import androidx.annotation.RestrictTo;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.internal.StreamSpecsCalculator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CameraUseCaseAdapterProviderImpl implements CameraUseCaseAdapterProvider {
    private final CameraCoordinator cameraCoordinator;
    private final CameraRepository cameraRepository;
    private final StreamSpecsCalculator streamSpecsCalculator;
    private final UseCaseConfigFactory useCaseConfigFactory;

    public CameraUseCaseAdapterProviderImpl(CameraRepository cameraRepository, CameraCoordinator cameraCoordinator, UseCaseConfigFactory useCaseConfigFactory, StreamSpecsCalculator streamSpecsCalculator) {
        kotlin.jvm.internal.k.e(cameraRepository, "cameraRepository");
        kotlin.jvm.internal.k.e(cameraCoordinator, "cameraCoordinator");
        kotlin.jvm.internal.k.e(useCaseConfigFactory, "useCaseConfigFactory");
        kotlin.jvm.internal.k.e(streamSpecsCalculator, "streamSpecsCalculator");
        this.cameraRepository = cameraRepository;
        this.cameraCoordinator = cameraCoordinator;
        this.useCaseConfigFactory = useCaseConfigFactory;
        this.streamSpecsCalculator = streamSpecsCalculator;
    }

    private final CameraUseCaseAdapter provideInternal(CameraInternal cameraInternal, CameraInternal cameraInternal2, AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2) {
        return new CameraUseCaseAdapter(cameraInternal, cameraInternal2, adapterCameraInfo, adapterCameraInfo2, compositionSettings, compositionSettings2, this.cameraCoordinator, this.streamSpecsCalculator, this.useCaseConfigFactory);
    }

    public static /* synthetic */ CameraUseCaseAdapter provideInternal$default(CameraUseCaseAdapterProviderImpl cameraUseCaseAdapterProviderImpl, CameraInternal cameraInternal, CameraInternal cameraInternal2, AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cameraInternal2 = null;
        }
        if ((i2 & 8) != 0) {
            adapterCameraInfo2 = null;
        }
        if ((i2 & 16) != 0) {
            compositionSettings = CompositionSettings.DEFAULT;
        }
        if ((i2 & 32) != 0) {
            compositionSettings2 = CompositionSettings.DEFAULT;
        }
        return cameraUseCaseAdapterProviderImpl.provideInternal(cameraInternal, cameraInternal2, adapterCameraInfo, adapterCameraInfo2, compositionSettings, compositionSettings2);
    }

    @Override // androidx.camera.core.CameraUseCaseAdapterProvider
    public CameraUseCaseAdapter provide(String cameraId) throws IllegalArgumentException {
        kotlin.jvm.internal.k.e(cameraId, "cameraId");
        CameraInternal camera = this.cameraRepository.getCamera(cameraId);
        kotlin.jvm.internal.k.d(camera, "getCamera(...)");
        return provideInternal$default(this, camera, null, new AdapterCameraInfo(camera.getCameraInfoInternal(), CameraConfigs.defaultConfig()), null, null, null, 58, null);
    }

    @Override // androidx.camera.core.CameraUseCaseAdapterProvider
    public CameraUseCaseAdapter provide(CameraInternal camera, CameraInternal cameraInternal, AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2, CompositionSettings compositionSettings, CompositionSettings secondaryCompositionSettings) {
        kotlin.jvm.internal.k.e(camera, "camera");
        kotlin.jvm.internal.k.e(adapterCameraInfo, "adapterCameraInfo");
        kotlin.jvm.internal.k.e(compositionSettings, "compositionSettings");
        kotlin.jvm.internal.k.e(secondaryCompositionSettings, "secondaryCompositionSettings");
        return provideInternal(camera, cameraInternal, adapterCameraInfo, adapterCameraInfo2, compositionSettings, secondaryCompositionSettings);
    }
}
