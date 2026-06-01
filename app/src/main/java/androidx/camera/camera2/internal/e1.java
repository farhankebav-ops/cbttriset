package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e1 implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ZoomControl f3430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ZoomState f3431c;

    public /* synthetic */ e1(ZoomControl zoomControl, ZoomState zoomState, int i2) {
        this.f3429a = i2;
        this.f3430b = zoomControl;
        this.f3431c = zoomState;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3429a) {
            case 0:
                return this.f3430b.lambda$setZoomRatio$1(this.f3431c, completer);
            default:
                return this.f3430b.lambda$setLinearZoom$3(this.f3431c, completer);
        }
    }
}
