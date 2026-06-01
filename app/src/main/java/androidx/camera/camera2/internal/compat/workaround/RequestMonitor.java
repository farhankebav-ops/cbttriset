package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.ironsource.C2300e4;
import j2.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class RequestMonitor {
    private static final String TAG = "RequestMonitor";
    private final boolean mQuirkEnabled;
    private final List<q> mRequestTasks = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RequestCompleteListener extends CameraCaptureSession.CaptureCallback {
        CallbackToFutureAdapter.Completer<Void> mStartRequestCompleter;
        final q mStartRequestFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.compat.workaround.d
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f3419a.lambda$new$0(completer);
            }
        });

        private void completeFuture() {
            CallbackToFutureAdapter.Completer<Void> completer = this.mStartRequestCompleter;
            if (completer != null) {
                completer.set(null);
                this.mStartRequestCompleter = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mStartRequestCompleter = completer;
            return "RequestCompleteListener[" + this + C2300e4.i.e;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i2) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i2, long j) {
            completeFuture();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j3) {
            completeFuture();
        }
    }

    public RequestMonitor(boolean z2) {
        this.mQuirkEnabled = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMonitorListener$1(RequestCompleteListener requestCompleteListener, q qVar) {
        Log.d(TAG, "RequestListener " + requestCompleteListener + " done " + this);
        this.mRequestTasks.remove(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getRequestsProcessedFuture$0(List list) {
        return null;
    }

    public CameraCaptureSession.CaptureCallback createMonitorListener(CameraCaptureSession.CaptureCallback captureCallback) {
        return shouldMonitorRequest() ? Camera2CaptureCallbacks.createComboCallback(createMonitorListener(), captureCallback) : captureCallback;
    }

    public q getRequestsProcessedFuture() {
        return this.mRequestTasks.isEmpty() ? Futures.immediateFuture(null) : Futures.nonCancellationPropagating(Futures.transform(Futures.successfulAsList(new ArrayList(this.mRequestTasks)), new c(0), CameraXExecutors.directExecutor()));
    }

    public boolean shouldMonitorRequest() {
        return this.mQuirkEnabled;
    }

    public void stop() {
        LinkedList linkedList = new LinkedList(this.mRequestTasks);
        while (!linkedList.isEmpty()) {
            q qVar = (q) linkedList.poll();
            Objects.requireNonNull(qVar);
            qVar.cancel(true);
        }
    }

    private CameraCaptureSession.CaptureCallback createMonitorListener() {
        final RequestCompleteListener requestCompleteListener = new RequestCompleteListener();
        final q qVar = requestCompleteListener.mStartRequestFuture;
        this.mRequestTasks.add(qVar);
        Log.d(TAG, "RequestListener " + requestCompleteListener + " monitoring " + this);
        qVar.addListener(new Runnable() { // from class: androidx.camera.camera2.internal.compat.workaround.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f3415a.lambda$createMonitorListener$1(requestCompleteListener, qVar);
            }
        }, CameraXExecutors.directExecutor());
        return requestCompleteListener;
    }
}
