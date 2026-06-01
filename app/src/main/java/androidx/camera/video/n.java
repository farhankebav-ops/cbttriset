package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3864c;

    public /* synthetic */ n(int i2, Object obj, Object obj2) {
        this.f3862a = i2;
        this.f3863b = obj;
        this.f3864c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f3862a) {
            case 0:
                ((Recorder.RecordingRecord) this.f3863b).lambda$updateVideoRecordEvent$6((VideoRecordEvent) this.f3864c);
                break;
            case 1:
                ((VideoCapture.AnonymousClass2) this.f3863b).lambda$onCaptureCompleted$0((SessionConfig.Builder) this.f3864c);
                break;
            case 2:
                ((VideoEncoderSession) this.f3863b).lambda$configureVideoEncoderInternal$4((Surface) this.f3864c);
                break;
            case 3:
                ((Executor) this.f3863b).execute((Runnable) this.f3864c);
                break;
            case 4:
                ((Recorder) this.f3863b).lambda$onSourceStateChanged$1((VideoOutput.SourceState) this.f3864c);
                break;
            default:
                ((VideoCapture) this.f3863b).lambda$createPipeline$2((DeferrableSurface) this.f3864c);
                break;
        }
    }
}
