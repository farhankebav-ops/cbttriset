package z;

import android.media.MediaPlayer;
import j4.i0;
import j4.v0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f17887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17888c;

    public /* synthetic */ l(Object obj, boolean z2, int i2) {
        this.f17886a = i2;
        this.f17888c = obj;
        this.f17887b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17886a) {
            case 0:
                boolean z2 = this.f17887b;
                n nVar = (n) this.f17888c;
                if (!nVar.lEW() && nVar.NV != null) {
                    try {
                        nVar.oc = z2;
                        MediaPlayer mediaPlayer = ((j) nVar.NV).f17882i;
                        if (mediaPlayer != null) {
                            if (z2) {
                                mediaPlayer.setVolume(0.0f, 0.0f);
                            } else {
                                mediaPlayer.setVolume(1.0f, 1.0f);
                            }
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                    break;
                }
                break;
            case 1:
                n nVar2 = (n) this.f17888c;
                if (nVar2.NV != null) {
                    ((j) nVar2.NV).h = this.f17887b;
                }
                break;
            default:
                v0 v0Var = (v0) ((i0) this.f17888c).f12249b;
                if (this.f17887b) {
                    v0Var.l = true;
                    if (v0Var.f12513i > 0) {
                        e2.m mVar = v0Var.k;
                        mVar.f11240a = false;
                        mVar.b();
                    }
                }
                v0Var.f12516q = false;
                break;
        }
    }
}
