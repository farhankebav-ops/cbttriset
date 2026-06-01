package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3674c;

    public /* synthetic */ l(int i2, Object obj, Object obj2) {
        this.f3672a = i2;
        this.f3673b = obj;
        this.f3674c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3672a) {
            case 0:
                return ((CameraX) this.f3673b).lambda$initInternal$0((Context) this.f3674c, completer);
            default:
                return ((SurfaceRequest) this.f3673b).lambda$initialSurfaceRecreationCompleter$7((AtomicReference) this.f3674c, completer);
        }
    }
}
