package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f3500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3501c;

    public /* synthetic */ p(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.Completer completer, int i2) {
        this.f3499a = i2;
        this.f3500b = camera2CameraImpl;
        this.f3501c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3499a) {
            case 0:
                this.f3500b.lambda$release$4(this.f3501c);
                break;
            default:
                this.f3500b.lambda$isMeteringRepeatingAttached$13(this.f3501c);
                break;
        }
    }
}
