package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3913b;

    public /* synthetic */ o(Object obj, int i2) {
        this.f3912a = i2;
        this.f3913b = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3912a) {
            case 0:
                SurfaceViewImplementation.SurfaceRequestCallback.lambda$tryToComplete$0((PreviewViewImplementation.OnSurfaceNotInUseListener) this.f3913b, (SurfaceRequest.Result) obj);
                break;
            default:
                ((CallbackToFutureAdapter.Completer) this.f3913b).set((SurfaceRequest.Result) obj);
                break;
        }
    }
}
