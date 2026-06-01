package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.k;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i<T extends k<?>> extends sg.bigo.ads.controller.e.b<T> implements k.b {
    public AdCountDownButton A;
    final AtomicBoolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f14797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f14799c;
    public T y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected ViewGroup f14800z;

    public i(@NonNull Activity activity) {
        super(activity);
        this.f14797a = new AtomicBoolean(false);
        this.B = new AtomicBoolean(true);
        this.f14798b = 0L;
        this.f14799c = 0L;
    }

    private void b() {
        AdCountDownButton adCountDownButton = (AdCountDownButton) o(R.id.inter_btn_close);
        this.A = adCountDownButton;
        if (adCountDownButton != null) {
            adCountDownButton.setOnCloseListener(new AdCountDownButton.a() { // from class: sg.bigo.ads.ad.interstitial.i.1
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
                public final void a() {
                    i.this.d(true);
                }

                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
                public final void a(Rect rect) {
                    i.this.y.y = rect;
                }
            });
        }
    }

    public int B() {
        return 1;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        sg.bigo.ads.common.utils.n nVar;
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null && (nVar = adCountDownButton.f14165b) != null) {
            nVar.b();
        }
        if (this.y != null && this.f14797a.compareAndSet(false, true)) {
            this.y.a(B(), 2);
        }
        T t3 = this.y;
        if (t3 != null) {
            t3.destroy();
        }
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void N() {
        super.N();
        try {
            T t3 = (T) this.K;
            this.y = t3;
            if (t3 == null) {
                ap();
                return;
            }
            ao();
            if (O()) {
                int i2 = R.layout.bigo_ad_activity_popup;
                int i8 = this.I.getResources().getDisplayMetrics().widthPixels;
                int iC = sg.bigo.ads.common.utils.e.c(this.I);
                this.I.setContentView(sg.bigo.ads.common.utils.a.a(this.I, i2, null, false), new ViewGroup.LayoutParams(i8, iC));
            } else {
                n(R.layout.bigo_ad_activity_interstitial);
            }
            if (f()) {
                return;
            }
            Q();
        } catch (Exception unused) {
            a("Illegal InterstitialAd.");
        }
    }

    public boolean O() {
        return false;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final boolean P() {
        return O();
    }

    public final void Q() {
        m();
        this.f14800z = (ViewGroup) o(R.id.inter_main);
        int iR = R();
        Activity activity = this.I;
        ViewGroup viewGroup = this.f14800z;
        sg.bigo.ads.common.utils.a.a(activity, iR, viewGroup, viewGroup != null);
        b();
        g(iR);
        this.y.a(this);
        this.y.z();
    }

    @LayoutRes
    public abstract int R();

    public abstract boolean S();

    public final void T() {
        if (this.y != null && !this.f14797a.get()) {
            this.f14798b = (SystemClock.elapsedRealtime() - this.f14799c) + this.f14798b;
            this.y.a(B(), this.f14798b);
            this.f14798b = 0L;
        }
        ap();
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void U() {
        if (g() && this.B.compareAndSet(true, false)) {
            h();
        }
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void V() {
        if (i() && this.B.compareAndSet(false, true)) {
            j();
        }
    }

    public final void a(String str) {
        T t3 = this.y;
        if (t3 != null) {
            t3.e(str);
        }
        ap();
    }

    public void d(boolean z2) {
        T();
    }

    public abstract boolean f();

    public abstract void g(@LayoutRes int i2);

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void g(boolean z2) {
        if (z2) {
            ao();
        }
    }

    @CallSuper
    public void h() {
        h(false);
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.f14166c) {
            return;
        }
        adCountDownButton.c();
    }

    public boolean i() {
        return true;
    }

    @CallSuper
    public void j() {
        h(true);
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton == null || adCountDownButton.f14166c) {
            return;
        }
        adCountDownButton.b();
    }

    public abstract void m();

    public void b(String str) {
    }

    public boolean g() {
        return true;
    }

    public final void h(boolean z2) {
        this.B.set(z2);
        if (!z2) {
            this.f14799c = SystemClock.elapsedRealtime();
        } else {
            this.f14798b = (SystemClock.elapsedRealtime() - this.f14799c) + this.f14798b;
        }
    }

    public final void j(@DrawableRes int i2) {
        AdCountDownButton adCountDownButton = this.A;
        if (adCountDownButton != null) {
            adCountDownButton.setCloseImageResource(i2);
        }
    }

    public void C() {
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void W() {
    }

    @Override // sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void X() {
    }
}
