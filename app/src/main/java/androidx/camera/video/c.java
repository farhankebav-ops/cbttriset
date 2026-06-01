package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3794c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f3792a = i2;
        this.f3793b = obj;
        this.f3794c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3792a) {
            case 0:
                return ((Recorder) this.f3793b).lambda$updateEncoderCallbacks$11((Recorder.RecordingRecord) this.f3794c, completer);
            case 1:
                return ((Recorder) this.f3793b).lambda$updateEncoderCallbacks$13((Recorder.RecordingRecord) this.f3794c, completer);
            default:
                return ((VideoCapture) this.f3793b).lambda$setupSurfaceUpdateNotifier$6((SessionConfig.Builder) this.f3794c, completer);
        }
    }
}
