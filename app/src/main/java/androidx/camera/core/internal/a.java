package androidx.camera.core.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3658c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3656a = i2;
        this.f3657b = obj;
        this.f3658c = obj2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3656a) {
            case 0:
                CameraUseCaseAdapter.lambda$createExtraPreview$0((Surface) this.f3657b, (SurfaceTexture) this.f3658c, (SurfaceRequest.Result) obj);
                break;
            default:
                ((DualSurfaceProcessor) this.f3657b).lambda$onOutputSurface$2((SurfaceOutput) this.f3658c, (SurfaceOutput.Event) obj);
                break;
        }
    }
}
