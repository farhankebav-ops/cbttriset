package androidx.camera.video;

import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3865a;

    public /* synthetic */ o(int i2) {
        this.f3865a = i2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3865a) {
            case 0:
                Recorder.RecordingRecord.lambda$new$0((Uri) obj);
                break;
            default:
                Recorder.lambda$composeRecorderMediaSpec$9((VideoSpec.Builder) obj);
                break;
        }
    }
}
