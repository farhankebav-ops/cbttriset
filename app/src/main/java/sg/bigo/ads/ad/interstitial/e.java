package sg.bigo.ads.ad.interstitial;

import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f14621a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f14622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private sg.bigo.ads.common.utils.n f14623c;

    public interface a {
        boolean a(Runnable runnable);
    }

    public final void a() {
        this.f14621a = true;
        sg.bigo.ads.common.utils.n nVar = this.f14623c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @CallSuper
    public void b() {
        sg.bigo.ads.common.utils.n nVar;
        if (this.f14621a || (nVar = this.f14623c) == null || nVar.f16023i) {
            return;
        }
        nVar.c();
    }

    @CallSuper
    public void c() {
        sg.bigo.ads.common.utils.n nVar;
        if (this.f14621a || (nVar = this.f14623c) == null || nVar.f16023i) {
            return;
        }
        nVar.d();
    }

    public final void a(int i2, final Runnable runnable) {
        sg.bigo.ads.common.utils.n nVar = this.f14623c;
        if (nVar != null) {
            nVar.b();
        }
        this.f14621a = false;
        sg.bigo.ads.common.utils.n nVar2 = new sg.bigo.ads.common.utils.n(((long) i2) * 1000) { // from class: sg.bigo.ads.ad.interstitial.e.1
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                Runnable runnable2;
                e eVar = e.this;
                if (eVar.f14621a || (runnable2 = runnable) == null) {
                    return;
                }
                a aVar = eVar.f14622b;
                if (aVar != null) {
                    aVar.a(runnable2);
                } else {
                    runnable2.run();
                }
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.f14623c = nVar2;
        nVar2.c();
    }
}
