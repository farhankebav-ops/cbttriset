package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3687b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f3686a = i2;
        this.f3687b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3686a) {
            case 0:
                ((SurfaceRequest) this.f3687b).willNotProvideSurface();
                break;
            case 1:
                ((DefaultSurfaceProcessor) this.f3687b).lambda$release$5();
                break;
            case 2:
                DefaultSurfaceProcessor.lambda$snapshot$7((CallbackToFutureAdapter.Completer) this.f3687b);
                break;
            case 3:
                ((SurfaceOutput) this.f3687b).close();
                break;
            default:
                ((SurfaceProcessorNode) this.f3687b).lambda$release$2();
                break;
        }
    }
}
