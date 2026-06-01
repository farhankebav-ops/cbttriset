package androidx.camera.core;

import androidx.camera.core.CameraExecutor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3573b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f3572a = i2;
        this.f3573b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3572a) {
            case 0:
                CameraExecutor.AnonymousClass1.lambda$newThread$0((Runnable) this.f3573b);
                break;
            case 1:
                ((ImageAnalysisNonBlockingAnalyzer) this.f3573b).analyzeCachedImage();
                break;
            case 2:
                ((Preview) this.f3573b).notifyReset();
                break;
            default:
                ((SurfaceRequest) this.f3573b).lambda$new$3();
                break;
        }
    }
}
