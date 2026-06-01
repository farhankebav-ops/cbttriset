package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.camera.video.internal.encoder.Encoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3871b;

    public /* synthetic */ q(Object obj, int i2) {
        this.f3870a = i2;
        this.f3871b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3870a) {
            case 0:
                ((Recorder.SetupVideoTask.AnonymousClass1) this.f3871b).lambda$onFailure$0();
                break;
            case 1:
                ((VideoEncoderSession) this.f3871b).lambda$terminateNow$3();
                break;
            case 2:
                Recorder.lambda$stopInternal$14((Encoder) this.f3871b);
                break;
            default:
                ((VideoCapture) this.f3871b).notifyReset();
                break;
        }
    }
}
