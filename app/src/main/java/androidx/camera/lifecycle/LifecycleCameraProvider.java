package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
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
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import e6.l;
import j2.q;
import java.util.List;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalCameraProviderConfiguration
public interface LifecycleCameraProvider extends CameraProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ Object createInstance$default(Companion companion, Context context, CameraXConfig cameraXConfig, c cVar, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstance(context, cameraXConfig, cVar);
        }

        public static /* synthetic */ q createInstanceAsync$default(Companion companion, Context context, CameraXConfig cameraXConfig, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstanceAsync(context, cameraXConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LifecycleCameraProvider createInstanceAsync$lambda$1(l lVar, Object obj) {
            return (LifecycleCameraProvider) lVar.invoke(obj);
        }

        public final Object createInstance(Context context, c<? super LifecycleCameraProvider> cVar) {
            return createInstance$default(this, context, null, cVar, 2, null);
        }

        public final q createInstanceAsync(Context context) {
            k.e(context, "context");
            return createInstanceAsync$default(this, context, null, 2, null);
        }

        public final Object createInstance(Context context, CameraXConfig cameraXConfig, c<? super LifecycleCameraProvider> cVar) {
            return ListenableFutureKt.await(createInstanceAsync(context, cameraXConfig), cVar);
        }

        public final q createInstanceAsync(Context context, CameraXConfig cameraXConfig) {
            k.e(context, "context");
            Preconditions.checkNotNull(context);
            LifecycleCameraProviderImpl lifecycleCameraProviderImpl = new LifecycleCameraProviderImpl();
            q qVarTransform = Futures.transform(lifecycleCameraProviderImpl.initAsync$camera_lifecycle_release(context, cameraXConfig), new androidx.camera.core.impl.b(new androidx.camera.core.impl.utils.a(lifecycleCameraProviderImpl, 1), 3), CameraXExecutors.directExecutor());
            k.d(qVarTransform, "transform(...)");
            return qVarTransform;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LifecycleCameraProvider createInstanceAsync$lambda$0(LifecycleCameraProviderImpl lifecycleCameraProviderImpl, Void r1) {
            return lifecycleCameraProviderImpl;
        }
    }

    @ExperimentalSessionConfig
    Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, SessionConfig sessionConfig);

    Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup);

    Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr);

    ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> list);

    @ExperimentalSessionConfig
    boolean isBound(SessionConfig sessionConfig);

    boolean isBound(UseCase useCase);

    @ExperimentalSessionConfig
    void unbind(SessionConfig sessionConfig);

    void unbind(UseCase... useCaseArr);

    void unbindAll();
}
