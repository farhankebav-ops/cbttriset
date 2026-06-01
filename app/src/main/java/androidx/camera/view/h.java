package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.view.impl.ZoomGestureDetector;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Function, CallbackToFutureAdapter.Resolver, ZoomGestureDetector.OnZoomGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3900a;

    public /* synthetic */ h(Object obj) {
        this.f3900a = obj;
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        return ((PreviewStreamStateObserver) this.f3900a).lambda$startPreviewStreamStateFlow$1((Void) obj);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((TextureViewImplementation) this.f3900a).lambda$waitForNextFrame$3(completer);
    }

    @Override // androidx.camera.view.impl.ZoomGestureDetector.OnZoomGestureListener
    public boolean onZoomEvent(ZoomGestureDetector.ZoomEvent zoomEvent) {
        return ((PreviewView) this.f3900a).lambda$new$1(zoomEvent);
    }
}
