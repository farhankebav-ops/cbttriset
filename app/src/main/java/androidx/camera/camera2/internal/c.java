package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControlImpl f3372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3373c;

    public /* synthetic */ c(Camera2CameraControlImpl camera2CameraControlImpl, CallbackToFutureAdapter.Completer completer, int i2) {
        this.f3371a = i2;
        this.f3372b = camera2CameraControlImpl;
        this.f3373c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3371a) {
            case 0:
                this.f3372b.lambda$isRepeatingRequestAvailable$10(this.f3373c);
                break;
            default:
                this.f3372b.lambda$updateSessionConfigAsync$6(this.f3373c);
                break;
        }
    }
}
