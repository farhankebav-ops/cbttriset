package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v0 implements AsyncFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3528a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraDevice f3529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3531d;
    public final /* synthetic */ Object e;

    public /* synthetic */ v0(ProcessingCaptureSession processingCaptureSession, SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSession.Opener opener) {
        this.f3530c = processingCaptureSession;
        this.f3531d = sessionConfig;
        this.f3529b = cameraDevice;
        this.e = opener;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
    public final j2.q apply(Object obj) {
        switch (this.f3528a) {
            case 0:
                return ((ProcessingCaptureSession) this.f3530c).lambda$open$2((SessionConfig) this.f3531d, this.f3529b, (SynchronizedCaptureSession.Opener) this.e, (List) obj);
            default:
                return ((SynchronizedCaptureSessionImpl) this.f3530c).lambda$openCaptureSession$0(this.f3529b, (SessionConfigurationCompat) this.f3531d, (List) this.e, (List) obj);
        }
    }

    public /* synthetic */ v0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        this.f3530c = synchronizedCaptureSessionImpl;
        this.f3529b = cameraDevice;
        this.f3531d = sessionConfigurationCompat;
        this.e = list;
    }
}
