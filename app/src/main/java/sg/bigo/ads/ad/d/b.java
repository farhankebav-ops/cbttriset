package sg.bigo.ads.ad.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.banner.c;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.m;
import sg.bigo.ads.ad.interstitial.o;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public class b extends m implements c.a {
    public b(@NonNull Activity activity) {
        super(activity);
        activity.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        super.D();
        ((o) this.y).f14931z.f13967o = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final int R() {
        return R.layout.bigo_ad_activity_popup_banner;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    @CallSuper
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.banner.c.a
    public final void a(int i2, int i8) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(this.I, 10) + i2;
        layoutParams.leftMargin = Math.max((i8 - this.A.getMeasuredWidth()) - sg.bigo.ads.common.utils.e.a(this.I, 10), 0);
        layoutParams.setMarginStart(Math.max((i8 - this.A.getMeasuredWidth()) - sg.bigo.ads.common.utils.e.a(this.I, 10), 0));
        this.A.setLayoutParams(layoutParams);
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final void g(@LayoutRes int i2) {
        super.g(i2);
        T t3 = this.y;
        if (t3 != 0) {
            ((o) t3).f14931z.f13967o = this;
            AdCountDownButton adCountDownButton = this.A;
            if (adCountDownButton != null) {
                adCountDownButton.setShowCloseButtonInCountdown(false);
                this.A.setTakeoverTickEvent(false);
                this.A.a(((o) this.y).x(), (AdCountDownButton.b) null);
            }
        }
        final View viewO = o(R.id.inter_container);
        final View viewO2 = o(R.id.inter_banner_container);
        u.a(viewO, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.d.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                sg.bigo.ads.common.w.b.a(sg.bigo.ads.common.utils.b.a(2), viewO);
                sg.bigo.ads.common.utils.b.a(viewO2);
            }
        });
    }
}
