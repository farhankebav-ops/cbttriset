package androidx.camera.camera2.interop;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControl f3553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3554c;

    public /* synthetic */ a(Camera2CameraControl camera2CameraControl, CallbackToFutureAdapter.Completer completer, int i2) {
        this.f3552a = i2;
        this.f3553b = camera2CameraControl;
        this.f3554c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3552a) {
            case 0:
                this.f3553b.lambda$clearCaptureRequestOptions$4(this.f3554c);
                break;
            case 1:
                this.f3553b.lambda$setCaptureRequestOptions$0(this.f3554c);
                break;
            default:
                this.f3553b.lambda$addCaptureRequestOptions$2(this.f3554c);
                break;
        }
    }
}
