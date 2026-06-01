package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k<U extends sg.bigo.ads.api.core.c> extends sg.bigo.ads.ad.d<InterstitialAd, U> implements InterstitialAd {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    protected b f14819x;
    protected Rect y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f14820z;

    public interface a<T extends k> {
        T getAdInstance(@NonNull sg.bigo.ads.api.core.g gVar);
    }

    public interface b {
        void C();

        void b(String str);
    }

    public k(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
    }

    public abstract Class<? extends sg.bigo.ads.controller.e.b<?>> A();

    @CallSuper
    public void a(int i2, int i8) {
        k();
    }

    public void b(@NonNull Activity activity) {
    }

    public abstract void b(@NonNull d.a<InterstitialAd> aVar);

    @Override // sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        this.f14819x = null;
    }

    @CallSuper
    public final void e(String str) {
        a(2003, str);
    }

    @Override // sg.bigo.ads.api.InterstitialAd
    public void show() {
        a((Activity) null, true);
    }

    public int x() {
        if (y()) {
            return this.f14024b.f15497b.c();
        }
        return 0;
    }

    public abstract boolean y();

    @CallSuper
    public final void z() {
        t();
        j();
        this.f14820z = SystemClock.elapsedRealtime();
        sg.bigo.ads.core.d.b.a(this.f14024b.f15496a, this);
    }

    public final void a(int i2, long j) {
        sg.bigo.ads.core.d.b.a(this.f14024b.f15496a, i2, this.f14820z > 0 ? SystemClock.elapsedRealtime() - this.f14820z : 0L, j, this);
    }

    @Override // sg.bigo.ads.api.InterstitialAd
    public void show(@Nullable Activity activity) {
        a(activity, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.app.Activity] */
    private void a(@Nullable Activity activity, boolean z2) {
        sg.bigo.ads.api.a.h hVar;
        a(activity == 0, z2);
        if (activity != 0) {
            b(activity);
        }
        sg.bigo.ads.core.d.b.a(f());
        if (isExpired()) {
            b(2000, 1, "The ad is expired.");
            return;
        }
        if (this.f14028i) {
            b(2000, 1, "The ad is destroyed.");
            return;
        }
        if (n()) {
            a(2003, "This ad cannot be shown repeatedly");
            return;
        }
        try {
            U uF = f();
            if (uF instanceof sg.bigo.ads.api.core.o) {
                sg.bigo.ads.api.core.o oVar = (sg.bigo.ads.api.core.o) uF;
                if (oVar.aR()) {
                    File file = new File(oVar.b(this.f14024b.e));
                    if (!file.exists() && !new File(file.getParentFile(), sg.bigo.ads.common.utils.f.c(file.getName())).exists()) {
                        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) uF, new AdError(2010, "resource clear."), true);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (activity != 0) {
            a(1);
        }
        if (activity == 0 && (hVar = sg.bigo.ads.api.a.i.f15457a) != null && hVar.n().a(16)) {
            activity = sg.bigo.ads.common.f.b.b();
            a(2);
        }
        if (activity == 0) {
            activity = this.f14024b.e;
        }
        int iA = this.S.a();
        this.T = iA;
        sg.bigo.ads.api.b.a aVar = this.U;
        if (aVar != null) {
            aVar.c(iA);
        }
        a(activity);
    }

    public void a(Context context) {
        if (sg.bigo.ads.controller.landing.d.a(context, A(), this, f() != null && f().ar())) {
            return;
        }
        a(2004, "This ad cannot be open");
    }

    public final void a(b bVar) {
        this.f14819x = bVar;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(@NonNull d.a<InterstitialAd> aVar) {
        super.a(aVar);
        b(aVar);
    }
}
