package androidx.camera.lifecycle;

import android.content.Context;
import androidx.activity.u;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.location.LocationRequestCompat;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import e6.l;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import o6.c;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalCameraProviderConfiguration.class})
public final class ProcessCameraProvider implements CameraProvider {
    public static final Companion Companion = new Companion(null);
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider(new LifecycleCameraProviderImpl());
    private final LifecycleCameraProviderImpl lifecycleCameraProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: renamed from: clearConfiguration-LRDsOJo$default, reason: not valid java name */
        public static /* synthetic */ void m4clearConfigurationLRDsOJo$default(Companion companion, long j, int i2, Object obj) throws ExecutionException, InterruptedException, TimeoutException {
            if ((i2 & 1) != 0) {
                int i8 = o6.a.f13207d;
                j = q.A0(10, c.f13212d);
            }
            companion.m5clearConfigurationLRDsOJo(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$0(Void r02) {
            return ProcessCameraProvider.sAppInstance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$1(l lVar, Object obj) {
            return (ProcessCameraProvider) lVar.invoke(obj);
        }

        @ExperimentalCameraProviderConfiguration
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        /* JADX INFO: renamed from: clearConfiguration-LRDsOJo, reason: not valid java name */
        public final void m5clearConfigurationLRDsOJo(long j) throws ExecutionException, InterruptedException, TimeoutException {
            j2.q qVarShutdownAsync = ProcessCameraProvider.sAppInstance.shutdownAsync();
            long j3 = j >> 1;
            int i2 = o6.a.f13207d;
            if ((((int) j) & 1) != 0) {
                j3 = j3 > 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : j3 < -9223372036854L ? Long.MIN_VALUE : j3 * ((long) 1000000);
            }
            qVarShutdownAsync.get(j3, TimeUnit.NANOSECONDS);
        }

        @ExperimentalCameraProviderConfiguration
        public final void configureInstance(CameraXConfig cameraXConfig) {
            k.e(cameraXConfig, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            try {
                ProcessCameraProvider.sAppInstance.configure(cameraXConfig);
            } finally {
                Trace.endSection();
            }
        }

        public final j2.q getInstance(Context context) {
            k.e(context, "context");
            Preconditions.checkNotNull(context);
            j2.q qVarTransform = Futures.transform(ProcessCameraProvider.sAppInstance.initAsync(context), new androidx.camera.core.impl.b(new u(3), 4), CameraXExecutors.directExecutor());
            k.d(qVarTransform, "transform(...)");
            return qVarTransform;
        }

        @ExperimentalCameraProviderConfiguration
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final j2.q shutdown() {
            return ProcessCameraProvider.sAppInstance.shutdownAsync();
        }

        private Companion() {
        }
    }

    private ProcessCameraProvider(LifecycleCameraProviderImpl lifecycleCameraProviderImpl) {
        this.lifecycleCameraProvider = lifecycleCameraProviderImpl;
    }

    @ExperimentalCameraProviderConfiguration
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    /* JADX INFO: renamed from: clearConfiguration-LRDsOJo, reason: not valid java name */
    public static final void m3clearConfigurationLRDsOJo(long j) throws ExecutionException, InterruptedException, TimeoutException {
        Companion.m5clearConfigurationLRDsOJo(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configure(CameraXConfig cameraXConfig) {
        this.lifecycleCameraProvider.configure$camera_lifecycle_release(cameraXConfig);
    }

    @ExperimentalCameraProviderConfiguration
    public static final void configureInstance(CameraXConfig cameraXConfig) {
        Companion.configureInstance(cameraXConfig);
    }

    public static final j2.q getInstance(Context context) {
        return Companion.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j2.q initAsync(Context context) {
        return this.lifecycleCameraProvider.initAsync$camera_lifecycle_release(context, null);
    }

    @ExperimentalCameraProviderConfiguration
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public static final j2.q shutdown() {
        return Companion.shutdown();
    }

    @Override // androidx.camera.core.CameraProvider
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addCameraPresenceListener(Executor executor, CameraPresenceListener listener) {
        k.e(executor, "executor");
        k.e(listener, "listener");
        this.lifecycleCameraProvider.addCameraPresenceListener(executor, listener);
    }

    @MainThread
    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(useCases, "useCases");
        return this.lifecycleCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, (UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        return this.lifecycleCameraProvider.getAvailableCameraInfos();
    }

    @Override // androidx.camera.core.CameraProvider
    public List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        return this.lifecycleCameraProvider.getAvailableConcurrentCameraInfos();
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        k.e(cameraSelector, "cameraSelector");
        return this.lifecycleCameraProvider.getCameraInfo(cameraSelector);
    }

    @Override // androidx.camera.core.CameraProvider
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getConfigImplType() {
        return this.lifecycleCameraProvider.getConfigImplType();
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        k.e(cameraSelector, "cameraSelector");
        return this.lifecycleCameraProvider.hasCamera(cameraSelector);
    }

    public final boolean isBound(UseCase useCase) {
        k.e(useCase, "useCase");
        return this.lifecycleCameraProvider.isBound(useCase);
    }

    @Override // androidx.camera.core.CameraProvider
    @MainThread
    public boolean isConcurrentCameraModeOn() {
        return this.lifecycleCameraProvider.isConcurrentCameraModeOn();
    }

    @Override // androidx.camera.core.CameraProvider
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeCameraPresenceListener(CameraPresenceListener listener) {
        k.e(listener, "listener");
        this.lifecycleCameraProvider.removeCameraPresenceListener(listener);
    }

    @VisibleForTesting
    public final j2.q shutdownAsync() {
        return LifecycleCameraProviderImpl.shutdownAsync$camera_lifecycle_release$default(this.lifecycleCameraProvider, false, 1, null);
    }

    @MainThread
    public final void unbind(UseCase... useCases) {
        k.e(useCases, "useCases");
        this.lifecycleCameraProvider.unbind((UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }

    @MainThread
    public final void unbindAll() {
        this.lifecycleCameraProvider.unbindAll();
    }

    @MainThread
    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(useCaseGroup, "useCaseGroup");
        return this.lifecycleCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup);
    }

    @ExperimentalSessionConfig
    public final boolean isBound(SessionConfig sessionConfig) {
        k.e(sessionConfig, "sessionConfig");
        return this.lifecycleCameraProvider.isBound(sessionConfig);
    }

    @ExperimentalSessionConfig
    public final void unbind(SessionConfig sessionConfig) {
        k.e(sessionConfig, "sessionConfig");
        this.lifecycleCameraProvider.unbind(sessionConfig);
    }

    @ExperimentalSessionConfig
    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, SessionConfig sessionConfig) {
        k.e(lifecycleOwner, "lifecycleOwner");
        k.e(cameraSelector, "cameraSelector");
        k.e(sessionConfig, "sessionConfig");
        return this.lifecycleCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, sessionConfig);
    }

    @MainThread
    public final ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs) {
        k.e(singleCameraConfigs, "singleCameraConfigs");
        return this.lifecycleCameraProvider.bindToLifecycle(singleCameraConfigs);
    }
}
