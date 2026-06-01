package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraManager;
import android.util.Log;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.impl.AbstractCameraPresenceSource;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2PresenceSource extends AbstractCameraPresenceSource {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "Camera2PresenceSrc";
    private final CameraManagerCompat cameraManager;
    private CameraManager.AvailabilityCallback systemAvailabilityCallback;
    private final Executor systemCallbackExecutor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2PresenceSource(List<String> initialCameraIds, CameraManagerCompat cameraManager, Executor systemCallbackExecutor) {
        super(initialCameraIds);
        kotlin.jvm.internal.k.e(initialCameraIds, "initialCameraIds");
        kotlin.jvm.internal.k.e(cameraManager, "cameraManager");
        kotlin.jvm.internal.k.e(systemCallbackExecutor, "systemCallbackExecutor");
        this.cameraManager = cameraManager;
        this.systemCallbackExecutor = systemCallbackExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object fetchData$lambda$3(Camera2PresenceSource camera2PresenceSource, CallbackToFutureAdapter.Completer completer) {
        kotlin.jvm.internal.k.e(completer, "completer");
        camera2PresenceSource.systemCallbackExecutor.execute(new j(8, camera2PresenceSource, completer));
        return "FetchData for CameraAvailability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchData$lambda$3$lambda$2(Camera2PresenceSource camera2PresenceSource, CallbackToFutureAdapter.Completer completer) {
        try {
            String[] cameraIdList = camera2PresenceSource.cameraManager.getCameraIdList();
            kotlin.jvm.internal.k.d(cameraIdList, "getCameraIdList(...)");
            ArrayList arrayList = new ArrayList(cameraIdList.length);
            for (String str : cameraIdList) {
                CameraIdentifier.Companion companion = CameraIdentifier.Companion;
                kotlin.jvm.internal.k.b(str);
                arrayList.add(CameraIdentifier.Companion.create$default(companion, str, null, null, 6, null));
            }
            Log.d(TAG, "[FetchData] Refreshed camera list: " + r5.l.c1(arrayList, null, null, null, null, 63));
            camera2PresenceSource.updateData(arrayList);
            completer.set(arrayList);
        } catch (CameraAccessExceptionCompat e) {
            Log.e(TAG, "[FetchData] Failed to get camera list for refresh.", e);
            Throwable thCreateFrom = CameraUnavailableExceptionHelper.createFrom(e);
            kotlin.jvm.internal.k.d(thCreateFrom, "createFrom(...)");
            camera2PresenceSource.updateError(thCreateFrom);
            completer.setException(thCreateFrom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDataAndForget(j2.q qVar) {
        Futures.transformAsyncOnCompletion(qVar);
    }

    @Override // androidx.camera.core.impl.AbstractCameraPresenceSource, androidx.camera.core.impl.Observable
    public j2.q fetchData() {
        j2.q future = CallbackToFutureAdapter.getFuture(new v(this, 9));
        kotlin.jvm.internal.k.d(future, "getFuture(...)");
        return future;
    }

    @Override // androidx.camera.core.impl.AbstractCameraPresenceSource
    public void startMonitoring() {
        if (this.systemAvailabilityCallback != null) {
            Log.w(TAG, "Monitoring already started. Unregistering existing callback.");
            stopMonitoring();
        }
        Log.i(TAG, "Starting system availability monitoring.");
        CameraManager.AvailabilityCallback availabilityCallback = new CameraManager.AvailabilityCallback() { // from class: androidx.camera.camera2.internal.Camera2PresenceSource.startMonitoring.1
            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAccessPrioritiesChanged() {
                Log.d(Camera2PresenceSource.TAG, "System onCameraAccessPrioritiesChanged.");
                Camera2PresenceSource camera2PresenceSource = Camera2PresenceSource.this;
                camera2PresenceSource.fetchDataAndForget(camera2PresenceSource.fetchData());
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAvailable(String cameraId) {
                kotlin.jvm.internal.k.e(cameraId, "cameraId");
                Log.d(Camera2PresenceSource.TAG, "System onCameraAvailable: ".concat(cameraId));
                Camera2PresenceSource camera2PresenceSource = Camera2PresenceSource.this;
                camera2PresenceSource.fetchDataAndForget(camera2PresenceSource.fetchData());
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraUnavailable(String cameraId) {
                kotlin.jvm.internal.k.e(cameraId, "cameraId");
                Log.d(Camera2PresenceSource.TAG, "System onCameraUnavailable: ".concat(cameraId));
                Camera2PresenceSource camera2PresenceSource = Camera2PresenceSource.this;
                camera2PresenceSource.fetchDataAndForget(camera2PresenceSource.fetchData());
            }
        };
        this.systemAvailabilityCallback = availabilityCallback;
        this.cameraManager.registerAvailabilityCallback(this.systemCallbackExecutor, availabilityCallback);
        fetchDataAndForget(fetchData());
    }

    @Override // androidx.camera.core.impl.AbstractCameraPresenceSource
    public void stopMonitoring() {
        Log.i(TAG, "Stopping system availability monitoring.");
        CameraManager.AvailabilityCallback availabilityCallback = this.systemAvailabilityCallback;
        if (availabilityCallback != null) {
            try {
                try {
                    this.cameraManager.unregisterAvailabilityCallback(availabilityCallback);
                } catch (Exception e) {
                    Log.w(TAG, "Failed to unregister system availability callback.", e);
                }
            } finally {
                this.systemAvailabilityCallback = null;
            }
        }
    }
}
