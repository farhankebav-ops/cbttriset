package z;

import com.bytedance.sdk.openadsdk.core.rp.tV.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EO f17891c;

    public m(EO eo) {
        this.f17891c = eo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long currentPosition;
        EO eo = this.f17891c;
        if (((n) eo).NV != null) {
            try {
                if (!this.f17890b) {
                    j jVar = (j) ((n) eo).NV;
                    jVar.getClass();
                    try {
                        currentPosition = jVar.f17882i.getCurrentPosition();
                    } catch (Throwable unused) {
                        currentPosition = 0;
                    }
                    ((n) eo).ea = Math.max(this.f17889a, currentPosition);
                }
                long unused2 = ((n) eo).ea;
            } catch (Throwable th) {
                th.toString();
            }
        }
        if (((n) eo).zPa != null) {
            ((n) eo).zPa.sendEmptyMessageDelayed(100, 0L);
        }
    }
}
