package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3731b;

    public /* synthetic */ p(Object obj, int i2) {
        this.f3730a = i2;
        this.f3731b = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3730a) {
            case 0:
                return ((SurfaceEdge.SettableSurface) this.f3731b).lambda$new$0(completer);
            default:
                return ((SurfaceOutputImpl) this.f3731b).lambda$new$0(completer);
        }
    }
}
