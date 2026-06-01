package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3851b;

    public /* synthetic */ l(Object obj, int i2) {
        this.f3850a = i2;
        this.f3851b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3850a) {
            case 0:
                ((EncoderCallback) this.f3851b).onEncodeStop();
                break;
            case 1:
                ((EncoderCallback) this.f3851b).onEncodeStart();
                break;
            case 2:
                ((EncoderCallback) this.f3851b).onEncodePaused();
                break;
            default:
                ((EncoderImpl.MediaCodecCallback) this.f3851b).reachEndData();
                break;
        }
    }
}
