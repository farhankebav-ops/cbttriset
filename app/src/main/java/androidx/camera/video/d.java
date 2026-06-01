package androidx.camera.video;

import androidx.camera.video.AudioSpec;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3796b;

    public /* synthetic */ d(int i2, int i8) {
        this.f3795a = i8;
        this.f3796b = i2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f3795a) {
            case 0:
                ((VideoSpec.Builder) obj).setEncodeFrameRate(this.f3796b);
                break;
            case 1:
                Recorder.Builder.lambda$setTargetVideoEncodingBitRate$1(this.f3796b, (VideoSpec.Builder) obj);
                break;
            case 2:
                ((AudioSpec.Builder) obj).setSource(this.f3796b);
                break;
            default:
                ((VideoSpec.Builder) obj).setAspectRatio(this.f3796b);
                break;
        }
    }
}
