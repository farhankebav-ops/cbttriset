package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.CompositionSettings;
import androidx.camera.core.LegacySessionConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import e6.l;
import j2.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalCameraProviderConfiguration.class})
public final class LifecycleCameraProviderImpl implements LifecycleCameraProvider {

    @GuardedBy("mLock")
    private final Map<CameraIdentifier, AdapterCameraInfo> cameraInfoMap;
    private CameraX cameraX;

    @GuardedBy("mLock")
    private CameraXConfig.Provider cameraXConfigProvider;

    @GuardedBy("mLock")
    private q cameraXInitializeFuture;

    @GuardedBy("mLock")
    private q cameraXShutdownFuture;
    private int configImplType;
    private Context context;
    private final HashSet<LifecycleCameraRepository.Key> lifecycleCameraKeys;
    private final LifecycleCameraRepository lifecycleCameraRepository;
    private final Object lock = new Object();

    public LifecycleCameraProviderImpl() {
        q qVarImmediateFuture = Futures.immediateFuture(null);
        k.d(qVarImmediateFuture, "immediateFuture(...)");
        this.cameraXShutdownFuture = qVarImmediateFuture;
        LifecycleCameraRepository lifecycleCameraRepository = LifecycleCameraRepository.getInstance();
        k.d(lifecycleCameraRepository, "getInstance(...)");
        this.lifecycleCameraRepository = lifecycleCameraRepository;
        this.cameraInfoMap = new HashMap();
        this.lifecycleCameraKeys = new HashSet<>();
        this.configImplType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Camera bindToLifecycleInternal(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, CameraSelector cameraSelector2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, SessionConfig sessionConfig) {
        CameraInternal cameraInternal;
        AdapterCameraInfo adapterCameraInfo;
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            Threads.checkMainThread();
            CameraX cameraX = this.cameraX;
            k.b(cameraX);
            CameraInternal cameraInternalSelect = cameraSelector.select(cameraX.getCameraRepository().getCameras());
            k.d(cameraInternalSelect, "select(...)");
            cameraInternalSelect.setPrimary(true);
            CameraInfo cameraInfo = getCameraInfo(cameraSelector);
            k.c(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
            AdapterCameraInfo adapterCameraInfo2 = (AdapterCameraInfo) cameraInfo;
            if (cameraSelector2 != null) {
                CameraX cameraX2 = this.cameraX;
                k.b(cameraX2);
                CameraInternal cameraInternalSelect2 = cameraSelector2.select(cameraX2.getCameraRepository().getCameras());
                cameraInternalSelect2.setPrimary(false);
                CameraInfo cameraInfo2 = getCameraInfo(cameraSelector2);
                k.c(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.AdapterCameraInfo");
                adapterCameraInfo = (AdapterCameraInfo) cameraInfo2;
                cameraInternal = cameraInternalSelect2;
            } else {
                cameraInternal = null;
                adapterCameraInfo = null;
            }
            CameraIdentifier cameraIdentifierFromAdapterInfos = CameraIdentifier.Companion.fromAdapterInfos(adapterCameraInfo2, adapterCameraInfo);
            LifecycleCamera lifecycleCamera = this.lifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, cameraIdentifierFromAdapterInfos);
            Collection<LifecycleCamera> lifecycleCameras = this.lifecycleCameraRepository.getLifecycleCameras();
            for (UseCase useCase : sessionConfig.getUseCases()) {
                for (LifecycleCamera lifecycleCamera2 : lifecycleCameras) {
                    k.d(lifecycleCamera2, "next(...)");
                    LifecycleCamera lifecycleCamera3 = lifecycleCamera2;
                    if (lifecycleCamera3.isBound(useCase) && !k.a(lifecycleCamera3.getLifecycleOwner(), lifecycleOwner)) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1)));
                    }
                }
            }
            if (lifecycleCamera == null) {
                LifecycleCameraRepository lifecycleCameraRepository = this.lifecycleCameraRepository;
                CameraX cameraX3 = this.cameraX;
                k.b(cameraX3);
                lifecycleCamera = lifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, cameraX3.getCameraUseCaseAdapterProvider().provide(cameraInternalSelect, cameraInternal, adapterCameraInfo2, adapterCameraInfo, compositionSettings, compositionSettings2));
            }
            if (sessionConfig.getUseCases().isEmpty()) {
                k.b(lifecycleCamera);
            } else {
                LifecycleCameraRepository lifecycleCameraRepository2 = this.lifecycleCameraRepository;
                k.b(lifecycleCamera);
                CameraX cameraX4 = this.cameraX;
                k.b(cameraX4);
                lifecycleCameraRepository2.bindToLifecycleCamera(lifecycleCamera, sessionConfig, cameraX4.getCameraFactory().getCameraCoordinator());
                this.lifecycleCameraKeys.add(LifecycleCameraRepository.Key.create(lifecycleOwner, cameraIdentifierFromAdapterInfos));
            }
            Trace.endSection();
            return lifecycleCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static /* synthetic */ Camera bindToLifecycleInternal$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, CameraSelector cameraSelector2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, SessionConfig sessionConfig, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cameraSelector2 = null;
        }
        CameraSelector cameraSelector3 = cameraSelector2;
        if ((i2 & 8) != 0) {
            compositionSettings = CompositionSettings.DEFAULT;
        }
        CompositionSettings compositionSettings3 = compositionSettings;
        if ((i2 & 16) != 0) {
            compositionSettings2 = CompositionSettings.DEFAULT;
        }
        return lifecycleCameraProviderImpl.bindToLifecycleInternal(lifecycleOwner, cameraSelector, cameraSelector3, compositionSettings3, compositionSettings2, sessionConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return new ArrayList();
        }
        k.b(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        k.d(activeConcurrentCameraInfos, "getActiveConcurrentCameraInfos(...)");
        return activeConcurrentCameraInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        Iterator<CameraFilter> it = cameraSelector.getCameraFilterSet().iterator();
        k.d(it, "iterator(...)");
        CameraConfig cameraConfig = null;
        while (it.hasNext()) {
            CameraFilter next = it.next();
            k.d(next, "next(...)");
            CameraFilter cameraFilter = next;
            if (!k.a(cameraFilter.getIdentifier(), CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter.getIdentifier());
                Context context = this.context;
                k.b(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
        }
        return cameraConfig == null ? CameraConfigs.defaultConfig() : cameraConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCameraOperatingMode() {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return 0;
        }
        k.b(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    public static /* synthetic */ q initAsync$camera_lifecycle_release$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, Context context, CameraXConfig cameraXConfig, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cameraXConfig = null;
        }
        return lifecycleCameraProviderImpl.initAsync$camera_lifecycle_release(context, cameraXConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q initAsync$lambda$3$lambda$1(CameraX cameraX, Void r1) {
        return cameraX.getInitializeFuture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q initAsync$lambda$3$lambda$2(l lVar, Object obj) {
        return (q) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVideoCapture(UseCase useCase) {
        return useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) && useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return;
        }
        k.b(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraOperatingMode(int i2) {
        CameraX cameraX = this.cameraX;
        if (cameraX == null) {
            return;
        }
        k.b(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i2);
    }

    public static /* synthetic */ q shutdownAsync$camera_lifecycle_release$default(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = true;
        }
        return lifecycleCameraProviderImpl.shutdownAsync$camera_lifecycle_release(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shutdownAsync$lambda$6(LifecycleCameraProviderImpl lifecycleCameraProviderImpl) {
        lifecycleCameraProviderImpl.unbindAll();
        lifecycleCameraProviderImpl.lifecycleCameraRepository.removeLifecycleCameras(lifecycleCameraProviderImpl.lifecycleCameraKeys);
    }

    @Override // androidx.camera.core.CameraProvider
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addCameraPresenceListener(Executor executor, CameraPresenceListener listener) {
        k.e(executor, "executor");
        k.e(listener, "listener");
        CameraX cameraX = this.cameraX;
        k.b(cameraX);
        cameraX.getCameraAvailabilityProvider().addCameraPresenceListener(listener, executor);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(useCases, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
        try {
            if (getCameraOperatingMode() == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            setCameraOperatingMode(1);
            Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, new LegacySessionConfig(j.n0(useCases), null, null, 6, null), 28, null);
            Trace.endSection();
            return cameraBindToLifecycleInternal$default;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void configure$camera_lifecycle_release(final CameraXConfig cameraXConfig) {
        k.e(cameraXConfig, "cameraXConfig");
        Trace.beginSection("CX:configureInstanceInternal");
        try {
            synchronized (this.lock) {
                Preconditions.checkNotNull(cameraXConfig);
                Preconditions.checkState(getCameraXConfigProvider$camera_lifecycle_release() == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                setCameraXConfigProvider$camera_lifecycle_release(new CameraXConfig.Provider() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$configure$1$1$1
                    @Override // androidx.camera.core.CameraXConfig.Provider
                    public final CameraXConfig getCameraXConfig() {
                        return cameraXConfig;
                    }
                });
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        try {
            ArrayList arrayList = new ArrayList();
            CameraX cameraX = this.cameraX;
            k.b(cameraX);
            LinkedHashSet<CameraInternal> cameras = cameraX.getCameraRepository().getCameras();
            k.d(cameras, "getCameras(...)");
            Iterator<CameraInternal> it = cameras.iterator();
            while (it.hasNext()) {
                CameraInfo cameraInfo = it.next().getCameraInfo();
                k.d(cameraInfo, "getCameraInfo(...)");
                arrayList.add(cameraInfo);
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        try {
            Objects.requireNonNull(this.cameraX);
            CameraX cameraX = this.cameraX;
            k.b(cameraX);
            Objects.requireNonNull(cameraX.getCameraFactory().getCameraCoordinator());
            CameraX cameraX2 = this.cameraX;
            k.b(cameraX2);
            List<List<CameraSelector>> concurrentCameraSelectors = cameraX2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
            k.d(concurrentCameraSelectors, "getConcurrentCameraSelectors(...)");
            ArrayList arrayList = new ArrayList();
            for (List<CameraSelector> list : concurrentCameraSelectors) {
                ArrayList arrayList2 = new ArrayList();
                for (CameraSelector cameraSelector : list) {
                    try {
                        k.b(cameraSelector);
                        arrayList2.add(getCameraInfo(cameraSelector));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                arrayList.add(arrayList2);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        Object adapterCameraInfo;
        k.e(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraX cameraX = this.cameraX;
            k.b(cameraX);
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(cameraX.getCameraRepository().getCameras()).getCameraInfoInternal();
            k.d(cameraInfoInternal, "getCameraInfoInternal(...)");
            CameraConfig cameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
            CameraIdentifier.Companion companion = CameraIdentifier.Companion;
            String cameraId = cameraInfoInternal.getCameraId();
            k.d(cameraId, "getCameraId(...)");
            CameraIdentifier cameraIdentifierCreate = companion.create(cameraId, null, cameraConfig.getCompatibilityId());
            synchronized (this.lock) {
                adapterCameraInfo = this.cameraInfoMap.get(cameraIdentifierCreate);
                if (adapterCameraInfo == null) {
                    adapterCameraInfo = new AdapterCameraInfo(cameraInfoInternal, cameraConfig);
                    this.cameraInfoMap.put(cameraIdentifierCreate, adapterCameraInfo);
                }
            }
            return (AdapterCameraInfo) adapterCameraInfo;
        } finally {
            Trace.endSection();
        }
    }

    public final CameraXConfig.Provider getCameraXConfigProvider$camera_lifecycle_release() {
        return this.cameraXConfigProvider;
    }

    @Override // androidx.camera.core.CameraProvider
    public int getConfigImplType() {
        return this.configImplType;
    }

    public final Context getContext$camera_lifecycle_release() {
        return this.context;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        boolean z2;
        k.e(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        try {
            CameraX cameraX = this.cameraX;
            k.b(cameraX);
            cameraSelector.select(cameraX.getCameraRepository().getCameras());
            z2 = true;
        } catch (IllegalArgumentException unused) {
            z2 = false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
        Trace.endSection();
        return z2;
    }

    public final q initAsync$camera_lifecycle_release(final Context context, CameraXConfig cameraXConfig) {
        k.e(context, "context");
        synchronized (this.lock) {
            try {
                q qVar = this.cameraXInitializeFuture;
                if (qVar != null) {
                    return qVar;
                }
                if (cameraXConfig != null) {
                    configure$camera_lifecycle_release(cameraXConfig);
                }
                final CameraX cameraX = new CameraX(context, this.cameraXConfigProvider);
                setConfigImplType(cameraX.getConfigImplType());
                FutureChain futureChainFrom = FutureChain.from(this.cameraXShutdownFuture);
                final androidx.camera.core.impl.utils.a aVar = new androidx.camera.core.impl.utils.a(cameraX, 2);
                FutureChain futureChainTransformAsync = futureChainFrom.transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.b
                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final q apply(Object obj) {
                        return LifecycleCameraProviderImpl.initAsync$lambda$3$lambda$2(aVar, obj);
                    }
                }, CameraXExecutors.directExecutor());
                k.d(futureChainTransformAsync, "transformAsync(...)");
                this.cameraXInitializeFuture = futureChainTransformAsync;
                Futures.addCallback(futureChainTransformAsync, new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.LifecycleCameraProviderImpl$initAsync$1$2
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable t3) {
                        k.e(t3, "t");
                        this.this$0.shutdownAsync$camera_lifecycle_release(false);
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(Void r22) {
                        this.this$0.cameraX = cameraX;
                        this.this$0.setContext$camera_lifecycle_release(ContextUtil.getApplicationContext(context));
                    }
                }, CameraXExecutors.directExecutor());
                q qVarNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
                k.d(qVarNonCancellationPropagating, "nonCancellationPropagating(...)");
                return qVarNonCancellationPropagating;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase useCase) {
        k.e(useCase, "useCase");
        for (LifecycleCamera lifecycleCamera : this.lifecycleCameraRepository.getLifecycleCameras()) {
            k.d(lifecycleCamera, "next(...)");
            if (lifecycleCamera.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraProvider
    @MainThread
    public boolean isConcurrentCameraModeOn() {
        return getCameraOperatingMode() == 2;
    }

    @Override // androidx.camera.core.CameraProvider
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeCameraPresenceListener(CameraPresenceListener listener) {
        k.e(listener, "listener");
        CameraX cameraX = this.cameraX;
        k.b(cameraX);
        cameraX.getCameraAvailabilityProvider().removeCameraPresenceListener(listener);
    }

    public final void setCameraXConfigProvider$camera_lifecycle_release(CameraXConfig.Provider provider) {
        this.cameraXConfigProvider = provider;
    }

    public void setConfigImplType(int i2) {
        this.configImplType = i2;
    }

    public final void setContext$camera_lifecycle_release(Context context) {
        this.context = context;
    }

    public final q shutdownAsync$camera_lifecycle_release(boolean z2) {
        Threads.runOnMainSync(new a3.b(this, 8));
        CameraX cameraX = this.cameraX;
        q qVarShutdown = cameraX != null ? cameraX.shutdown() : Futures.immediateFuture(null);
        k.b(qVarShutdown);
        synchronized (this.lock) {
            if (z2) {
                try {
                    this.cameraXConfigProvider = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.cameraXInitializeFuture = null;
            this.cameraXShutdownFuture = qVarShutdown;
            this.cameraInfoMap.clear();
            this.lifecycleCameraKeys.clear();
        }
        this.cameraX = null;
        this.context = null;
        return qVarShutdown;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbind(UseCase... useCases) {
        k.e(useCases, "useCases");
        Trace.beginSection("CX:unbind");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() == 2) {
                throw new UnsupportedOperationException("Unbind UseCase is not supported in concurrent camera mode, call unbindAll() first.");
            }
            this.lifecycleCameraRepository.unbind(new LegacySessionConfig(j.n0(useCases), null, null, 6, null), this.lifecycleCameraKeys);
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        try {
            Threads.checkMainThread();
            setCameraOperatingMode(0);
            this.lifecycleCameraRepository.unbindAll(this.lifecycleCameraKeys);
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(SessionConfig sessionConfig) {
        k.e(sessionConfig, "sessionConfig");
        for (LifecycleCamera lifecycleCamera : this.lifecycleCameraRepository.getLifecycleCameras()) {
            k.d(lifecycleCamera, "next(...)");
            if (lifecycleCamera.isBound(sessionConfig)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(useCaseGroup, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, new LegacySessionConfig(useCaseGroup), 28, null);
                Trace.endSection();
                return cameraBindToLifecycleInternal$default;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbind(SessionConfig sessionConfig) {
        k.e(sessionConfig, "sessionConfig");
        Trace.beginSection("CX:unbind-sessionConfig");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                this.lifecycleCameraRepository.unbind(sessionConfig, this.lifecycleCameraKeys);
                return;
            }
            throw new UnsupportedOperationException("Unbind SessionConfig is not supported in concurrent camera mode call unbindAll() first.");
        } finally {
            Trace.endSection();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getCameraXConfigProvider$camera_lifecycle_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getContext$camera_lifecycle_release$annotations() {
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, SessionConfig sessionConfig) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(sessionConfig, "sessionConfig");
        Trace.beginSection("CX:bindToLifecycle-SessionConfig");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                Camera cameraBindToLifecycleInternal$default = bindToLifecycleInternal$default(this, lifecycleOwner, cameraSelector, null, null, null, sessionConfig, 28, null);
                Trace.endSection();
                return cameraBindToLifecycleInternal$default;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01df A[Catch: all -> 0x00f6, TryCatch #1 {all -> 0x00f6, blocks: (B:3:0x000e, B:5:0x0015, B:7:0x001b, B:10:0x0050, B:12:0x0056, B:14:0x0064, B:16:0x007a, B:18:0x0090, B:19:0x00bc, B:21:0x00c2, B:22:0x00d7, B:24:0x00dd, B:26:0x00f2, B:29:0x00f9, B:30:0x010a, B:67:0x0266, B:31:0x0123, B:32:0x012a, B:33:0x012b, B:34:0x0130, B:35:0x0131, B:37:0x0144, B:39:0x014a, B:40:0x014f, B:41:0x0165, B:43:0x0175, B:46:0x0180, B:47:0x0187, B:48:0x0188, B:51:0x01a3, B:53:0x01b1, B:55:0x01d6, B:61:0x01ee, B:66:0x0263, B:57:0x01df, B:59:0x01e5, B:62:0x0227, B:63:0x022b, B:65:0x0231, B:70:0x026f, B:71:0x0276, B:72:0x0277, B:73:0x027c, B:74:0x027d, B:75:0x0284, B:76:0x0285, B:77:0x028c, B:78:0x028d, B:79:0x0294), top: B:84:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0231 A[Catch: all -> 0x00f6, LOOP:2: B:63:0x022b->B:65:0x0231, LOOP_END, TryCatch #1 {all -> 0x00f6, blocks: (B:3:0x000e, B:5:0x0015, B:7:0x001b, B:10:0x0050, B:12:0x0056, B:14:0x0064, B:16:0x007a, B:18:0x0090, B:19:0x00bc, B:21:0x00c2, B:22:0x00d7, B:24:0x00dd, B:26:0x00f2, B:29:0x00f9, B:30:0x010a, B:67:0x0266, B:31:0x0123, B:32:0x012a, B:33:0x012b, B:34:0x0130, B:35:0x0131, B:37:0x0144, B:39:0x014a, B:40:0x014f, B:41:0x0165, B:43:0x0175, B:46:0x0180, B:47:0x0187, B:48:0x0188, B:51:0x01a3, B:53:0x01b1, B:55:0x01d6, B:61:0x01ee, B:66:0x0263, B:57:0x01df, B:59:0x01e5, B:62:0x0227, B:63:0x022b, B:65:0x0231, B:70:0x026f, B:71:0x0276, B:72:0x0277, B:73:0x027c, B:74:0x027d, B:75:0x0284, B:76:0x0285, B:77:0x028c, B:78:0x028d, B:79:0x0294), top: B:84:0x000e, inners: #0 }] */
    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @androidx.annotation.MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.camera.core.ConcurrentCamera bindToLifecycle(java.util.List<androidx.camera.core.ConcurrentCamera.SingleCameraConfig> r16) {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.lifecycle.LifecycleCameraProviderImpl.bindToLifecycle(java.util.List):androidx.camera.core.ConcurrentCamera");
    }
}
