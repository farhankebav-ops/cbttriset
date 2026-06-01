package androidx.camera.core.impl.utils.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f3641b;

    public /* synthetic */ b(int i2, q qVar) {
        this.f3640a = i2;
        this.f3641b = qVar;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3640a) {
            case 0:
                return Futures.lambda$transformAsyncOnCompletion$8(this.f3641b, completer);
            default:
                return Futures.lambda$nonCancellationPropagating$0(this.f3641b, completer);
        }
    }
}
