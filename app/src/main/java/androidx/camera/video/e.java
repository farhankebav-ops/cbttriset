package androidx.camera.video;

import androidx.camera.video.Recorder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Recorder f3798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Recorder.RecordingRecord f3799c;

    public /* synthetic */ e(Recorder recorder, Recorder.RecordingRecord recordingRecord, int i2) {
        this.f3797a = i2;
        this.f3798b = recorder;
        this.f3799c = recordingRecord;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3797a) {
            case 0:
                this.f3798b.lambda$resume$5(this.f3799c);
                break;
            default:
                this.f3798b.lambda$pause$4(this.f3799c);
                break;
        }
    }
}
