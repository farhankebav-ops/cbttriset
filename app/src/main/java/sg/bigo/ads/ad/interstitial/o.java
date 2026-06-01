package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.b.a;
import sg.bigo.ads.api.b.d;

/* JADX INFO: loaded from: classes6.dex */
public class o extends k<sg.bigo.ads.api.core.i> {
    sg.bigo.ads.ad.banner.h A;
    protected sg.bigo.ads.ad.interstitial.i.a B;
    private final boolean C;
    private boolean D;
    private final AtomicBoolean E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.ad.banner.c<o> f14931z;

    public o(@NonNull sg.bigo.ads.api.core.g gVar) {
        sg.bigo.ads.api.a.m mVarE;
        super(gVar);
        try {
            sg.bigo.ads.api.core.i iVar = (sg.bigo.ads.api.core.i) f();
            sg.bigo.ads.ad.interstitial.i.a aVar = null;
            if (iVar != null && (mVarE = iVar.e()) != null) {
                n nVar = new n();
                nVar.f14927a = mVarE.a("video_play_page.ad_component_layout");
                nVar.f14928b = mVarE.a("video_play_page.force_staying_time");
                nVar.f14929c = mVarE.a("video_play_page.close_button_style");
                nVar.f14930d = mVarE.a("video_play_page.x_area");
                nVar.e = mVarE.a("video_play_page.duration");
                int i2 = nVar.f14927a;
                aVar = i2 != 1 ? i2 != 2 ? new sg.bigo.ads.ad.interstitial.i.a(this, this.f14024b.e, nVar) : new sg.bigo.ads.ad.interstitial.i.c(this, this.f14024b.e, nVar) : new sg.bigo.ads.ad.interstitial.i.b(this, this.f14024b.e, nVar);
            }
            this.B = aVar;
            this.E = new AtomicBoolean(false);
            boolean zAv = iVar.av();
            this.C = zAv;
            sg.bigo.ads.ad.banner.c<o> cVar = new sg.bigo.ads.ad.banner.c<>(this.f14024b.e, gVar, this, iVar, B(), new sg.bigo.ads.ad.banner.h() { // from class: sg.bigo.ads.ad.interstitial.o.1
                @Override // sg.bigo.ads.ad.banner.h
                public final void a() {
                    if (o.this.A != null) {
                        o.this.A.a();
                    }
                }

                @Override // sg.bigo.ads.ad.banner.h
                public final void b() {
                    o.d(o.this);
                    if (o.this.n()) {
                        o.this.D();
                    }
                }

                @Override // sg.bigo.ads.ad.banner.h
                public final void a(String str) {
                    a0.i(0, str, "InterstitialBannerAd onCustomJsOmImpression, adSessionId=", 3, "InterstitialBannerAd");
                    o.this.D();
                    sg.bigo.ads.core.d.b.a(o.this.f14024b.f15496a, (String) o.this.b("show_proportion", ""), o.this.i(), ((Integer) o.this.b("render_style", 0)).intValue());
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
                @Override // sg.bigo.ads.ad.banner.h
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void a(sg.bigo.ads.common.i r4, sg.bigo.ads.api.core.e r5) {
                    /*
                        r3 = this;
                        if (r4 == 0) goto L2a
                        sg.bigo.ads.ad.interstitial.o r0 = sg.bigo.ads.ad.interstitial.o.this
                        android.graphics.Rect r0 = r0.y
                        android.graphics.Point r1 = r4.f15792a
                        if (r1 == 0) goto L2a
                        android.graphics.Point r2 = r4.f15793b
                        if (r2 == 0) goto L2a
                        if (r0 != 0) goto L11
                        goto L2a
                    L11:
                        int r2 = r1.x
                        int r1 = r1.y
                        boolean r1 = r0.contains(r2, r1)
                        if (r1 == 0) goto L2a
                        android.graphics.Point r1 = r4.f15793b
                        int r2 = r1.x
                        int r1 = r1.y
                        boolean r0 = r0.contains(r2, r1)
                        if (r0 == 0) goto L2a
                        r0 = 33
                        goto L2b
                    L2a:
                        r0 = 0
                    L2b:
                        sg.bigo.ads.ad.interstitial.o r1 = sg.bigo.ads.ad.interstitial.o.this
                        r2 = 1
                        r1.a(r4, r0, r2, r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.o.AnonymousClass1.a(sg.bigo.ads.common.i, sg.bigo.ads.api.core.e):void");
                }
            }, zAv);
            this.f14931z = cVar;
            cVar.f13961b = 0;
            cVar.p = this.B;
        } catch (Exception unused) {
            throw new IllegalArgumentException("Error data type for ad!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.E.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialBannerAd", "InterstitialBannerAd report impression AdEvent");
            super.l();
        }
    }

    public static /* synthetic */ boolean d(o oVar) {
        oVar.D = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        return m.class;
    }

    public sg.bigo.ads.core.mraid.n B() {
        return sg.bigo.ads.core.mraid.n.INTERSTITIAL;
    }

    public final n C() {
        sg.bigo.ads.ad.interstitial.i.a aVar = this.B;
        if (aVar != null) {
            return aVar.f14804c;
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final void b(@NonNull Activity activity) {
        super.b(activity);
        sg.bigo.ads.ad.banner.c<o> cVar = this.f14931z;
        if (cVar != null) {
            cVar.f13966n = new WeakReference<>(activity);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        this.A = null;
        super.destroyInMainThread();
        this.f14931z.a();
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public String getCreativeId() {
        sg.bigo.ads.ad.banner.c<o> cVar = this.f14931z;
        return cVar != null ? cVar.d() : "";
    }

    @Override // sg.bigo.ads.ad.c
    public final void h() {
        super.h();
        sg.bigo.ads.ad.banner.c<o> cVar = this.f14931z;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void l() {
        if (!this.C || this.D) {
            D();
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialBannerAd", "BannerAd report impression AdEvent depend on om callback.");
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void m() {
        super.m();
        D();
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final boolean y() {
        return false;
    }

    public final void a(AdCountDownButton adCountDownButton, View view) {
        sg.bigo.ads.ad.interstitial.i.a aVar = this.B;
        if (aVar == null || adCountDownButton == null) {
            return;
        }
        int i2 = aVar.f14804c.f14929c;
        adCountDownButton.setCloseImageResource(i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? R.drawable.bigo_ad_ic_close : R.drawable.bigo_ad_ic_close5 : R.drawable.bigo_ad_ic_close4 : R.drawable.bigo_ad_ic_close3 : R.drawable.bigo_ad_ic_close2);
        adCountDownButton.setShowCloseButtonInCountdown(true);
        adCountDownButton.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.i.a.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ AdCountDownButton f14805a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ View f14806b;

            public AnonymousClass1(AdCountDownButton adCountDownButton2, View view2) {
                adCountDownButton = adCountDownButton2;
                view = view2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a aVar2 = a.this;
                int i8 = aVar2.f14804c.f14930d;
                if (i8 == 1) {
                    adCountDownButton.setBtnClickArea(1);
                    return;
                }
                if (i8 == 2) {
                    adCountDownButton.setBtnClickArea(2);
                    return;
                }
                if (i8 != 3) {
                    return;
                }
                AdCountDownButton adCountDownButton2 = adCountDownButton;
                View view2 = view;
                Rect rect = new Rect();
                adCountDownButton2.getHitRect(rect);
                rect.inset((-rect.width()) / 2, (-rect.height()) / 2);
                View closeView = adCountDownButton2.getCloseView();
                if (view2 == null || closeView == null) {
                    return;
                }
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.i.a.2

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ Rect f14808a;

                    /* JADX INFO: renamed from: b */
                    final /* synthetic */ View f14809b;

                    public AnonymousClass2(Rect rect2, View closeView2) {
                        rect = rect2;
                        view = closeView2;
                    }

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            return false;
                        }
                        if (motionEvent.getActionMasked() != 0) {
                            return true;
                        }
                        view.onTouchEvent(motionEvent);
                        return true;
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public void b(@NonNull d.a<InterstitialAd> aVar) {
        sg.bigo.ads.api.core.c cVar = this.f14024b.f15496a;
        if (!(cVar instanceof sg.bigo.ads.api.core.i)) {
            aVar.a(this, 1021, 1250, "InterstitialBannerAd with invalid AdData class type.");
            return;
        }
        sg.bigo.ads.api.core.i iVar = (sg.bigo.ads.api.core.i) cVar;
        if (iVar.aw() == null || TextUtils.isEmpty(iVar.aw().c())) {
            aVar.a(this, IronSourceError.ERROR_RV_SHOW_CALLED_DURING_SHOW, 1252, "Empty content.");
        } else {
            this.f14931z.a(new a.InterfaceC0277a() { // from class: sg.bigo.ads.ad.interstitial.o.2
                @Override // sg.bigo.ads.api.b.a.InterfaceC0277a
                public final void b() {
                }

                @Override // sg.bigo.ads.api.b.a.InterfaceC0277a
                public final void a(sg.bigo.ads.api.core.d dVar) {
                }
            });
            aVar.a(this);
        }
    }
}
