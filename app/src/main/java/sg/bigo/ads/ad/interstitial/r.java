package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.api.VideoController;

/* JADX INFO: loaded from: classes6.dex */
public abstract class r extends i<t> {
    public static final sg.bigo.ads.core.adview.h F = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.r.1
        @Override // sg.bigo.ads.core.adview.h
        public final void a(int i2, int i8, int i9, int i10, int i11, int i12) {
            sg.bigo.ads.common.t.a.a(0, 4, "emptyClick", "emptyClick stop event Propagation");
        }
    };

    @Nullable
    protected sg.bigo.ads.ad.b.c C;

    @Nullable
    protected ViewGroup D;

    @Nullable
    protected Button E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f15119a;

    public r(@NonNull Activity activity) {
        super(activity);
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        VideoController videoControllerAa = aa();
        if (videoControllerAa != null) {
            videoControllerAa.setVideoLifeCallback(null);
            videoControllerAa.setLoadHTMLCallback(null);
            videoControllerAa.setProgressChangeListener(null);
        }
    }

    public int Y() {
        return 1;
    }

    @NonNull
    public final u Z() {
        if (this.f15119a == null) {
            this.f15119a = aq() ? sg.bigo.ads.ad.interstitial.d.a.a(this.C) : sg.bigo.ads.ad.interstitial.d.a.a(this.C, n());
        }
        return this.f15119a;
    }

    @Nullable
    public final VideoController aa() {
        sg.bigo.ads.ad.b.c cVar = this.C;
        if (cVar != null) {
            return cVar.getVideoController();
        }
        return null;
    }

    public final boolean ab() {
        T t3 = this.y;
        return t3 != 0 && ((t) t3).y();
    }

    public final boolean ac() {
        T t3 = this.y;
        return t3 != 0 && ((t) t3).F();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public void g(@LayoutRes int i2) {
        ViewGroup viewGroup = (ViewGroup) o(R.id.inter_native_ad_view);
        this.D = viewGroup;
        if (viewGroup == null) {
            a("can not find ad root view.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public void h() {
        super.h();
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialPage", "performResume");
        u uVar = this.f15119a;
        if (uVar != null) {
            uVar.b();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public void j() {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialPage", "performPause");
        u uVar = this.f15119a;
        if (uVar != null) {
            uVar.c();
        }
        if (ab()) {
            h(true);
        } else {
            super.j();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    @CallSuper
    public void m() {
        this.C = ((t) this.y).f15129z;
    }

    public abstract int n();
}
