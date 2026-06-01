package androidx.camera.view;

import android.view.Surface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3895c;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f3893a = i2;
        this.f3894b = obj;
        this.f3895c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3893a) {
            case 0:
                return ((PendingValue) this.f3894b).lambda$setValue$0(this.f3895c, completer);
            default:
                return ((TextureViewImplementation) this.f3894b).lambda$tryToProvidePreviewSurface$1((Surface) this.f3895c, completer);
        }
    }
}
