package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3685c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3683a = i2;
        this.f3684b = obj;
        this.f3685c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3683a) {
            case 0:
                ((DefaultSurfaceProcessor) this.f3684b).lambda$snapshot$6((DefaultSurfaceProcessor.PendingSnapshot) this.f3685c);
                break;
            case 1:
                ((SurfaceOutputImpl) this.f3684b).lambda$requestClose$1((AtomicReference) this.f3685c);
                break;
            case 2:
                ((DefaultSurfaceProcessor) this.f3684b).lambda$onInputSurface$2((SurfaceRequest) this.f3685c);
                break;
            case 3:
                ((DefaultSurfaceProcessor) this.f3684b).lambda$onOutputSurface$4((SurfaceOutput) this.f3685c);
                break;
            case 4:
                ((SurfaceProcessorWithExecutor) this.f3684b).lambda$onInputSurface$0((SurfaceRequest) this.f3685c);
                break;
            default:
                ((SurfaceProcessorWithExecutor) this.f3684b).lambda$onOutputSurface$1((SurfaceOutput) this.f3685c);
                break;
        }
    }
}
