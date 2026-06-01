package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements SurfaceRequest.TransformationInfoListener, CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3706b;

    public /* synthetic */ f(Object obj, Object obj2) {
        this.f3705a = obj;
        this.f3706b = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((InternalImageProcessor) this.f3705a).lambda$safeProcess$1((ImageProcessor.Request) this.f3706b, completer);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((DefaultSurfaceProcessor) this.f3705a).lambda$onInputSurface$0((SurfaceRequest) this.f3706b, transformationInfo);
    }
}
