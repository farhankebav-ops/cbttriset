package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioSource.AudioSourceCallback f3812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3813c;

    public /* synthetic */ d(AudioSource.AudioSourceCallback audioSourceCallback, boolean z2, int i2) {
        this.f3811a = i2;
        this.f3812b = audioSourceCallback;
        this.f3813c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3811a) {
            case 0:
                this.f3812b.onSilenceStateChanged(this.f3813c);
                break;
            default:
                this.f3812b.onSuspendStateChanged(this.f3813c);
                break;
        }
    }
}
