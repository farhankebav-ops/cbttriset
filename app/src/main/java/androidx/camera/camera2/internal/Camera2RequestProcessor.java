package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Camera2RequestProcessor implements RequestProcessor {
    private static final String TAG = "Camera2RequestProcessor";

    @GuardedBy("mLock")
    private CaptureSession mCaptureSession;

    @GuardedBy("mLock")
    private List<SessionProcessorSurface> mProcessorSurfaces;

    @GuardedBy("mLock")
    private volatile SessionConfig mSessionConfig;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private volatile boolean mIsClosed = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class Camera2CallbackWrapper extends CameraCaptureSession.CaptureCallback {
        private final RequestProcessor.Callback mCallback;
        private final boolean mInvokeSequenceCallback;
        private final RequestProcessor.Request mRequest;

        public Camera2CallbackWrapper(RequestProcessor.Request request, RequestProcessor.Callback callback, boolean z2) {
            this.mCallback = callback;
            this.mRequest = request;
            this.mInvokeSequenceCallback = z2;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            this.mCallback.onCaptureBufferLost(this.mRequest, j, Camera2RequestProcessor.this.findOutputConfigId(surface));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.mCallback.onCaptureCompleted(this.mRequest, new Camera2CameraCaptureResult(totalCaptureResult));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.mCallback.onCaptureFailed(this.mRequest, new Camera2CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR, captureFailure));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.mCallback.onCaptureProgressed(this.mRequest, new Camera2CameraCaptureResult(captureResult));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i2) {
            if (this.mInvokeSequenceCallback) {
                this.mCallback.onCaptureSequenceAborted(i2);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i2, long j) {
            if (this.mInvokeSequenceCallback) {
                this.mCallback.onCaptureSequenceCompleted(i2, j);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j3) {
            this.mCallback.onCaptureStarted(this.mRequest, j3, j);
        }
    }

    public Camera2RequestProcessor(CaptureSession captureSession, List<SessionProcessorSurface> list) {
        Preconditions.checkArgument(captureSession.mState == CaptureSession.State.OPENED, "CaptureSession state must be OPENED. Current state:" + captureSession.mState);
        this.mCaptureSession = captureSession;
        this.mProcessorSurfaces = Collections.unmodifiableList(new ArrayList(list));
    }

    private boolean areRequestsValid(List<RequestProcessor.Request> list) {
        Iterator<RequestProcessor.Request> it = list.iterator();
        while (it.hasNext()) {
            if (!isRequestValid(it.next())) {
                return false;
            }
        }
        return true;
    }

    private DeferrableSurface findSurface(int i2) {
        synchronized (this.mLock) {
            try {
                List<SessionProcessorSurface> list = this.mProcessorSurfaces;
                if (list == null) {
                    return null;
                }
                for (SessionProcessorSurface sessionProcessorSurface : list) {
                    if (sessionProcessorSurface.getOutputConfigId() == i2) {
                        return sessionProcessorSurface;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean isRequestValid(RequestProcessor.Request request) {
        if (request.getTargetOutputConfigIds().isEmpty()) {
            Logger.e(TAG, "Unable to submit the RequestProcessor.Request: empty targetOutputConfigIds");
            return false;
        }
        for (Integer num : request.getTargetOutputConfigIds()) {
            if (findSurface(num.intValue()) == null) {
                Logger.e(TAG, "Unable to submit the RequestProcessor.Request: targetOutputConfigId(" + num + ") is not a valid id");
                return false;
            }
        }
        return true;
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public void abortCaptures() {
        CaptureSession captureSession;
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed && (captureSession = this.mCaptureSession) != null) {
                    captureSession.abortCaptures();
                }
            } finally {
            }
        }
    }

    public void close() {
        synchronized (this.mLock) {
            this.mIsClosed = true;
            this.mCaptureSession = null;
            this.mSessionConfig = null;
            this.mProcessorSurfaces = null;
        }
    }

    public int findOutputConfigId(Surface surface) {
        synchronized (this.mLock) {
            try {
                List<SessionProcessorSurface> list = this.mProcessorSurfaces;
                if (list == null) {
                    return -1;
                }
                for (SessionProcessorSurface sessionProcessorSurface : list) {
                    try {
                        if (sessionProcessorSurface.getSurface().get() == surface) {
                            return sessionProcessorSurface.getOutputConfigId();
                        }
                        continue;
                    } catch (InterruptedException | ExecutionException unused) {
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int setRepeating(RequestProcessor.Request request, RequestProcessor.Callback callback) {
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed && isRequestValid(request) && this.mCaptureSession != null) {
                    SessionConfig.Builder builder = new SessionConfig.Builder();
                    builder.setTemplateType(request.getTemplateId());
                    builder.setImplementationOptions(request.getParameters());
                    builder.addCameraCaptureCallback(CaptureCallbackContainer.create(new Camera2CallbackWrapper(request, callback, true)));
                    if (this.mSessionConfig != null) {
                        Iterator<CameraCaptureCallback> it = this.mSessionConfig.getRepeatingCameraCaptureCallbacks().iterator();
                        while (it.hasNext()) {
                            builder.addCameraCaptureCallback(it.next());
                        }
                        TagBundle tagBundle = this.mSessionConfig.getRepeatingCaptureConfig().getTagBundle();
                        for (String str : tagBundle.listKeys()) {
                            builder.addTag(str, tagBundle.getTag(str));
                        }
                    }
                    Iterator<Integer> it2 = request.getTargetOutputConfigIds().iterator();
                    while (it2.hasNext()) {
                        builder.addSurface(findSurface(it2.next().intValue()));
                    }
                    return this.mCaptureSession.issueRepeatingCaptureRequests(builder.build());
                }
                return -1;
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public void stopRepeating() {
        CaptureSession captureSession;
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed && (captureSession = this.mCaptureSession) != null) {
                    captureSession.stopRepeating();
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int submit(RequestProcessor.Request request, RequestProcessor.Callback callback) {
        return submit(Arrays.asList(request), callback);
    }

    public void updateSessionConfig(SessionConfig sessionConfig) {
        synchronized (this.mLock) {
            this.mSessionConfig = sessionConfig;
        }
    }

    @Override // androidx.camera.core.impl.RequestProcessor
    public int submit(List<RequestProcessor.Request> list, RequestProcessor.Callback callback) {
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed && areRequestsValid(list) && this.mCaptureSession != null) {
                    ArrayList arrayList = new ArrayList();
                    boolean z2 = true;
                    for (RequestProcessor.Request request : list) {
                        CaptureConfig.Builder builder = new CaptureConfig.Builder();
                        builder.setTemplateType(request.getTemplateId());
                        builder.setImplementationOptions(request.getParameters());
                        builder.addCameraCaptureCallback(CaptureCallbackContainer.create(new Camera2CallbackWrapper(request, callback, z2)));
                        Iterator<Integer> it = request.getTargetOutputConfigIds().iterator();
                        while (it.hasNext()) {
                            builder.addSurface(findSurface(it.next().intValue()));
                        }
                        arrayList.add(builder.build());
                        z2 = false;
                    }
                    return this.mCaptureSession.issueBurstCaptureRequest(arrayList);
                }
                return -1;
            } finally {
            }
        }
    }
}
