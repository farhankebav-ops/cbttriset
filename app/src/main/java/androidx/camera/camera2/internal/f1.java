package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ZoomControl f3440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoomState f3442d;

    public /* synthetic */ f1(ZoomControl zoomControl, CallbackToFutureAdapter.Completer completer, ZoomState zoomState, int i2) {
        this.f3439a = i2;
        this.f3440b = zoomControl;
        this.f3441c = completer;
        this.f3442d = zoomState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3439a) {
            case 0:
                this.f3440b.lambda$setZoomRatio$0(this.f3441c, this.f3442d);
                break;
            default:
                this.f3440b.lambda$setLinearZoom$2(this.f3441c, this.f3442d);
                break;
        }
    }
}
