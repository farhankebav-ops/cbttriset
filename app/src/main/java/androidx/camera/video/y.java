package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3883b;

    public /* synthetic */ y(Object obj, int i2) {
        this.f3882a = i2;
        this.f3883b = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3882a) {
            case 0:
                return ((VideoEncoderSession) this.f3883b).lambda$configure$0(completer);
            default:
                return ((VideoEncoderSession) this.f3883b).lambda$configure$1(completer);
        }
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((Recorder) this.f3883b).lambda$configureInternal$8(transformationInfo);
    }
}
