package sg.bigo.ads.ad.banner;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.ironsource.InterfaceC2238ae;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InnerBannerAd;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.e.a;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends sg.bigo.ads.ad.c<InnerBannerAd, sg.bigo.ads.api.core.c> implements InnerBannerAd, sg.bigo.ads.api.b.d<InnerBannerAd> {
    private AbstractAdLoader A;
    private d.a<InnerBannerAd> B;
    private a C;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    InnerBannerAd f14007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FrameLayout f14008x;
    private sg.bigo.ads.api.core.g y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private b f14009z;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14019a = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Handler f14020b = new Handler(Looper.getMainLooper());

        public b() {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Enable bigo adx banner auto refreshing");
        }
    }

    public i(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.C = new a();
        if (!gVar.f15497b.w() && gVar.f15497b.j()) {
            b bVar = new b();
            this.f14009z = bVar;
            int iK = gVar.f15497b.k();
            if (iK >= 10) {
                bVar.f14019a = iK * 1000;
            }
        }
        InnerBannerAd innerBannerAdB = d.b(gVar);
        this.f14007w = innerBannerAdB;
        if (innerBannerAdB == null) {
            throw new IllegalArgumentException("UnifiedBannerWrapper Illegal adx type.");
        }
    }

    public static /* synthetic */ void e(i iVar) {
        sg.bigo.ads.api.b bVarA = iVar.f14024b.f15498c.a();
        if (bVarA != null) {
            bVarA.f15460c = 1;
            final a.C0306a[] c0306aArr = new a.C0306a[1];
            c0306aArr[0] = BigoAdSdk.a(bVarA, new sg.bigo.ads.controller.c() { // from class: sg.bigo.ads.ad.banner.i.4
                @Override // sg.bigo.ads.controller.e
                public final /* synthetic */ void a(int i2, int i8, int i9, @NonNull String str, @Nullable Pair<sg.bigo.ads.api.b, l> pair) {
                    sg.bigo.ads.api.b bVar;
                    q qVar;
                    q qVar2;
                    q qVar3;
                    q qVar4;
                    Pair<sg.bigo.ads.api.b, l> pair2 = pair;
                    sg.bigo.ads.common.t.a.a(2, "Banner", "Banner auto-refresh failed: ".concat(String.valueOf(str)));
                    String str2 = null;
                    if (pair2 != null) {
                        sg.bigo.ads.api.b bVar2 = (sg.bigo.ads.api.b) pair2.first;
                        if (bVar2 != null) {
                            bVar2.g.a();
                        }
                        bVar = bVar2;
                    } else {
                        bVar = null;
                    }
                    a.C0306a c0306a = c0306aArr[0];
                    l lVar = pair2 != null ? (l) pair2.second : null;
                    int i10 = (c0306a == null || (qVar4 = c0306a.g) == null) ? 3 : qVar4.f15525a ? 1 : 0;
                    boolean z2 = (c0306a == null || (qVar3 = c0306a.g) == null || !qVar3.f15526b) ? false : true;
                    int i11 = (c0306a == null || (qVar2 = c0306a.g) == null) ? 4 : qVar2.f15527c;
                    if (c0306a != null && (qVar = c0306a.g) != null) {
                        str2 = qVar.f15528d;
                    }
                    sg.bigo.ads.core.d.b.a(lVar, bVar, i8, i9, str, 1, 0, i10, z2, i11, str2);
                }

                @Override // sg.bigo.ads.controller.e
                public final /* synthetic */ void a(int i2, @NonNull sg.bigo.ads.api.b bVar, @NonNull sg.bigo.ads.api.core.g[] gVarArr) {
                    q qVar;
                    q qVar2;
                    q qVar3;
                    q qVar4;
                    sg.bigo.ads.api.core.g gVar = (sg.bigo.ads.api.core.g) k.b(gVarArr);
                    gVar.f15498c.g.a();
                    a.C0306a c0306a = c0306aArr[0];
                    sg.bigo.ads.core.d.b.a(new sg.bigo.ads.api.core.c[]{gVar.f15496a}, gVar.f15498c, gVar.f15497b.s() && gVar.f15496a.ac(), 1, 0, (c0306a == null || (qVar4 = c0306a.g) == null) ? 3 : qVar4.f15525a ? 1 : 0, (c0306a == null || (qVar3 = c0306a.g) == null || !qVar3.f15526b) ? false : true, (c0306a == null || (qVar2 = c0306a.g) == null) ? 4 : qVar2.f15527c, (c0306a == null || (qVar = c0306a.g) == null) ? null : qVar.f15528d);
                    i.a(i.this, gVar.f15496a, gVar);
                }
            });
        }
        sg.bigo.ads.common.t.a.a(0, 3, "Banner", "Start auto refreshing for bigo adx banner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x() {
        if (this.f14008x == null) {
            this.f14008x = new FrameLayout(this.f14024b.e);
        }
        if (this.f14007w == null) {
            return null;
        }
        this.f14008x.removeAllViews();
        u.a(this.f14007w.adView(), this.f14008x, null, -1);
        return this.f14008x;
    }

    @Override // sg.bigo.ads.api.b.a, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public final int compareTo(Ad ad) {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.compareTo(ad);
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final View adView() {
        String str;
        if (!sg.bigo.ads.common.n.d.b()) {
            t.a("adView() must run on UI thread");
        }
        if (isExpired()) {
            str = "The ad is expired.";
        } else {
            if (!this.f14028i) {
                FrameLayout frameLayout = this.f14008x;
                return frameLayout != null ? frameLayout : x();
            }
            str = "The ad is destroyed.";
        }
        b(2000, 1, str);
        return null;
    }

    @Override // sg.bigo.ads.api.b.a
    public final int b_() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.updateFormOpenTimes();
        }
        return 0;
    }

    @Override // sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            innerBannerAd.destroy();
        }
        b bVar = this.f14009z;
        if (bVar != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "bigo adx banner auto refreshing stop");
            bVar.f14020b.removeCallbacksAndMessages(null);
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    @Nullable
    public final AdBid getBid() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getBid();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getCreativeId() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getCreativeId();
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    @Nullable
    public final String getExtraInfo(String str) {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getExtraInfo(str);
        }
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getHeight() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getHeight();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final sg.bigo.ads.api.core.c getInnerBannerAdData() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getInnerBannerAdData();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final WebView getWebView() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd == null) {
            return null;
        }
        return innerBannerAd.getWebView();
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getWidth() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.getWidth();
        }
        return 0;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.isExpired();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final boolean isInnerBannerAdFromAutoRefresh() {
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            return innerBannerAd.isInnerBannerAdFromAutoRefresh();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        a aVar = this.C;
        aVar.f14017a = adInteractionListener;
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            innerBannerAd.setAdInteractionListener(aVar);
        }
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final int updateFormOpenTimes() {
        return 0;
    }

    public static /* synthetic */ void b(i iVar) {
        if (iVar.f14007w != null) {
            iVar.a();
            iVar.f14024b = iVar.y;
            iVar.f14007w.setAdInteractionListener(iVar.C);
            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.banner.i.3
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.x();
                }
            });
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    @NonNull
    public final sg.bigo.ads.api.core.c f() {
        return getInnerBannerAdData();
    }

    public static /* synthetic */ void a(i iVar, final InnerBannerAd innerBannerAd) {
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.banner.i.2
            @Override // java.lang.Runnable
            public final void run() {
                InnerBannerAd innerBannerAd2 = innerBannerAd;
                if (innerBannerAd2 != null) {
                    innerBannerAd2.destroy();
                }
            }
        });
    }

    public static /* synthetic */ void a(i iVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.core.g gVar) {
        InnerBannerAd innerBannerAdB = d.b(gVar);
        if (innerBannerAdB != null) {
            iVar.y = gVar;
            innerBannerAdB.markFromAutoFresh(cVar);
            innerBannerAdB.handleInnerBannerAdResponse(iVar.B);
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(@NonNull final d.a<InnerBannerAd> aVar) {
        super.a(aVar);
        if (this.A == null && (aVar instanceof AbstractAdLoader.b)) {
            this.A = ((AbstractAdLoader.b) aVar).a();
        }
        d.a<InnerBannerAd> aVar2 = new d.a<InnerBannerAd>() { // from class: sg.bigo.ads.ad.banner.i.1
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(@NonNull Ad ad) {
                InnerBannerAd innerBannerAd = (InnerBannerAd) ad;
                if (i.this.f14007w != null && i.this.f14007w != innerBannerAd) {
                    i.a(i.this, i.this.f14007w);
                }
                i.this.f14007w = innerBannerAd;
                if (!innerBannerAd.isInnerBannerAdFromAutoRefresh()) {
                    aVar.a(i.this);
                    return;
                }
                i.b(i.this);
                if (i.this.A != null) {
                    i.this.A.a((Ad) i.this, true);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                InnerBannerAd innerBannerAd = (InnerBannerAd) ad;
                if (innerBannerAd == null || !innerBannerAd.isInnerBannerAdFromAutoRefresh()) {
                    aVar.a(i.this, i2, i8, str);
                } else {
                    i.this.a(i2, i8, str);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                aVar.a(i.this, z2, i2, i8, str, z7);
            }
        };
        this.B = aVar2;
        InnerBannerAd innerBannerAd = this.f14007w;
        if (innerBannerAd != null) {
            innerBannerAd.handleInnerBannerAdResponse(aVar2);
        } else {
            aVar.a(this, 1005, InterfaceC2238ae.c.f8009d, "banner adx_type error");
        }
    }

    public class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        AdInteractionListener f14017a;

        public a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f14017a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(@NonNull AdError adError) {
            AdInteractionListener adInteractionListener = this.f14017a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdError(adError);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f14017a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
            if (i.this.f14009z != null) {
                final b bVar = i.this.f14009z;
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Start auto refreshing after " + (bVar.f14019a / 1000) + " s");
                bVar.f14020b.removeCallbacksAndMessages(null);
                bVar.f14020b.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.banner.i.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.e(i.this);
                    }
                }, (long) bVar.f14019a);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
        }
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void handleInnerBannerAdResponse(@NonNull d.a<InnerBannerAd> aVar) {
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void markFromAutoFresh(sg.bigo.ads.api.core.c cVar) {
    }
}
