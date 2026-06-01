package androidx.camera.video;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3861c;

    public /* synthetic */ l(int i2, Object obj, Object obj2) {
        this.f3859a = i2;
        this.f3860b = obj;
        this.f3861c = obj2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3859a) {
            case 0:
                Recorder.RecordingRecord.lambda$initializeRecording$4((MediaStoreOutputOptions) this.f3860b, (Context) this.f3861c, (Uri) obj);
                break;
            default:
                ((Recorder) this.f3860b).lambda$updateEncoderCallbacks$12((CallbackToFutureAdapter.Completer) this.f3861c, (Throwable) obj);
                break;
        }
    }
}
