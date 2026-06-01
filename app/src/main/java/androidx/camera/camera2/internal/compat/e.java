package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AutoCloseable f3399d;

    public /* synthetic */ e(Object obj, AutoCloseable autoCloseable, int i2, int i8) {
        this.f3396a = i8;
        this.f3398c = obj;
        this.f3399d = autoCloseable;
        this.f3397b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3396a) {
            case 0:
                ((CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper) this.f3398c).lambda$onCaptureSequenceAborted$5((CameraCaptureSession) this.f3399d, this.f3397b);
                break;
            default:
                ((CameraDeviceCompat.StateCallbackExecutorWrapper) this.f3398c).lambda$onError$2((CameraDevice) this.f3399d, this.f3397b);
                break;
        }
    }
}
