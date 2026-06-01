package androidx.camera.camera2.interop;

import androidx.camera.video.internal.audio.AudioStream;
import com.vungle.ads.internal.ui.VungleWebClient;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3559c;

    public /* synthetic */ c(Object obj, boolean z2, int i2) {
        this.f3557a = i2;
        this.f3559c = obj;
        this.f3558b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3557a) {
            case 0:
                ((Camera2CameraControl) this.f3559c).lambda$setActive$6(this.f3558b);
                break;
            case 1:
                ((AudioStream.AudioStreamCallback) this.f3559c).onSilenceStateChanged(this.f3558b);
                break;
            default:
                VungleWebClient.m3363notifyPropertiesChange$lambda25(this.f3558b, (VungleWebClient) this.f3559c);
                break;
        }
    }

    public /* synthetic */ c(boolean z2, VungleWebClient vungleWebClient) {
        this.f3557a = 2;
        this.f3558b = z2;
        this.f3559c = vungleWebClient;
    }
}
