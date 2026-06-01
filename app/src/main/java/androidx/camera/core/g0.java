package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f3575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfo f3576c;

    public /* synthetic */ g0(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo, int i2) {
        this.f3574a = i2;
        this.f3575b = transformationInfoListener;
        this.f3576c = transformationInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3574a) {
            case 0:
                this.f3575b.onTransformationInfoUpdate(this.f3576c);
                break;
            default:
                this.f3575b.onTransformationInfoUpdate(this.f3576c);
                break;
        }
    }
}
