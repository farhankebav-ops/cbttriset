package androidx.camera.video;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3858b;

    public /* synthetic */ k(Object obj, int i2) {
        this.f3857a = i2;
        this.f3858b = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3857a) {
            case 0:
                Recorder.RecordingRecord.lambda$initializeRecording$2((MediaStoreOutputOptions) this.f3858b, (Uri) obj);
                break;
            case 1:
                Recorder.RecordingRecord.lambda$initializeRecording$5((ParcelFileDescriptor) this.f3858b, (Uri) obj);
                break;
            case 2:
                ((VideoEncoderSession) this.f3858b).onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                break;
            case 3:
                ((Recorder) this.f3858b).lambda$setupAndStartMediaMuxer$10((Uri) obj);
                break;
            default:
                ((VideoSpec.Builder) obj).setQualitySelector((QualitySelector) this.f3858b);
                break;
        }
    }
}
