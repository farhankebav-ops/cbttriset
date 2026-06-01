package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener, PreviewViewImplementation.OnSurfaceNotInUseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3898c;

    public /* synthetic */ f(PreviewView.AnonymousClass1 anonymousClass1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.f3897b = anonymousClass1;
        this.f3896a = previewStreamStateObserver;
        this.f3898c = cameraInternal;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((PreviewStreamStateObserver) this.f3896a).lambda$waitForCaptureResult$2((CameraInfo) this.f3897b, (List) this.f3898c, completer);
    }

    @Override // androidx.camera.view.PreviewViewImplementation.OnSurfaceNotInUseListener
    public void onSurfaceNotInUse() {
        ((PreviewView.AnonymousClass1) this.f3897b).lambda$onSurfaceRequested$2((PreviewStreamStateObserver) this.f3896a, (CameraInternal) this.f3898c);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((PreviewView.AnonymousClass1) this.f3896a).lambda$onSurfaceRequested$1((CameraInternal) this.f3897b, (SurfaceRequest) this.f3898c, transformationInfo);
    }

    public /* synthetic */ f(Object obj, Object obj2, Object obj3) {
        this.f3896a = obj;
        this.f3897b = obj2;
        this.f3898c = obj3;
    }
}
