package androidx.camera.core;

import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3565c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3563a = i2;
        this.f3564b = obj;
        this.f3565c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3563a) {
            case 0:
                ((AndroidImageReaderProxy) this.f3564b).lambda$setOnImageAvailableListener$0((ImageReaderProxy.OnImageAvailableListener) this.f3565c);
                break;
            case 1:
                ((CameraX) this.f3564b).lambda$shutdownInternal$3((CallbackToFutureAdapter.Completer) this.f3565c);
                break;
            case 2:
                ImageAnalysis.lambda$createPipeline$1((SafeCloseImageReaderProxy) this.f3564b, (SafeCloseImageReaderProxy) this.f3565c);
                break;
            case 3:
                ((MetadataImageReader) this.f3564b).lambda$enqueueImageProxy$1((ImageReaderProxy.OnImageAvailableListener) this.f3565c);
                break;
            case 4:
                ((Preview.SurfaceProvider) this.f3564b).onSurfaceRequested((SurfaceRequest) this.f3565c);
                break;
            default:
                ((Preview) this.f3564b).lambda$createPipeline$0((CameraInternal) this.f3565c);
                break;
        }
    }
}
