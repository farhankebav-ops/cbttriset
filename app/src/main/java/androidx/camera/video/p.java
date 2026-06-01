package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3869d;

    public /* synthetic */ p(Object obj, Object obj2, Object obj3, int i2) {
        this.f3866a = i2;
        this.f3867b = obj;
        this.f3868c = obj2;
        this.f3869d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3866a) {
            case 0:
                ((Recorder.SetupVideoTask) this.f3867b).lambda$setupVideo$0((SurfaceRequest) this.f3868c, (Timebase) this.f3869d);
                break;
            default:
                VideoCapture.lambda$setupSurfaceUpdateNotifier$5((AtomicBoolean) this.f3867b, (SessionConfig.Builder) this.f3868c, (CameraCaptureCallback) this.f3869d);
                break;
        }
    }
}
