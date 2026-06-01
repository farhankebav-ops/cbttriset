package sg.bigo.ads.ad.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.b.c;
import sg.bigo.ads.ad.c.a.a.AnonymousClass2;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InnerBannerAd;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.e;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements c.b, InnerBannerAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private sg.bigo.ads.ad.b.c f14083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private sg.bigo.ads.ad.c.b f14084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f14085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f14086d;
    private sg.bigo.ads.ad.c.a.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private c f14087f;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14088i;
    private final g j;
    private long k;
    private d.a<InnerBannerAd> l;
    private final a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c.a f14089n;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d.a<NativeAd> f14094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d.a<NativeAd> f14095b;

        public b(final d.a<InnerBannerAd> aVar) {
            this.f14094a = new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.c.d.b.1
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    boolean z2 = false;
                    if (d.this.e == null) {
                        d.c(d.this);
                        d.this.a((d.a<InnerBannerAd>) aVar, 1, false);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner icon load success");
                    d.d(d.this);
                    if (d.this.f14084b != null) {
                        sg.bigo.ads.ad.c.a.a aVar2 = d.this.e;
                        ImageView imageView = d.this.f14084b.f14076a;
                        if (d.this.f14083a != null && d.this.f14083a.n()) {
                            z2 = true;
                        }
                        aVar2.a(imageView, z2);
                    }
                    d.this.a(1, 3);
                    d.this.a((d.a<InnerBannerAd>) aVar, 1, true);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner icon load failed");
                    d.c(d.this);
                    if (i8 == 10103) {
                        d.this.a(1, 1);
                    } else {
                        d.this.a(1, 4);
                    }
                    d.this.a((d.a<InnerBannerAd>) aVar, 1, false);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                }
            };
            this.f14095b = new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.c.d.b.2
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    NativeAd nativeAd = (NativeAd) ad;
                    boolean z2 = false;
                    if (d.this.e == null) {
                        d.c(d.this);
                        d.this.a((d.a<InnerBannerAd>) aVar, 1, false);
                        return;
                    }
                    d.d(d.this);
                    b.a(b.this, nativeAd, 3);
                    sg.bigo.ads.ad.c.a.a aVar2 = d.this.e;
                    aVar2.a(aVar2.new AnonymousClass2(), nativeAd instanceof sg.bigo.ads.ad.b.a.a);
                    sg.bigo.ads.ad.c.a.a aVar3 = d.this.e;
                    if (d.this.f14083a != null && d.this.f14083a.n()) {
                        z2 = true;
                    }
                    aVar3.a(z2);
                    d.this.a((d.a<InnerBannerAd>) aVar, 1, true);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                    b bVar;
                    int i9;
                    NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner main media load failed");
                    d.c(d.this);
                    if (i8 == 1401 || i8 == 10074 || i8 == 10103 || i8 == 1300) {
                        bVar = b.this;
                        i9 = 1;
                    } else {
                        bVar = b.this;
                        i9 = 4;
                    }
                    b.a(bVar, nativeAd, i9);
                    d.this.a((d.a<InnerBannerAd>) aVar, 1, false);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                }
            };
        }

        public final void a() {
            this.f14094a = null;
            this.f14095b = null;
        }

        public static /* synthetic */ void a(b bVar, NativeAd nativeAd, int i2) {
            d dVar;
            int i8;
            if (nativeAd instanceof sg.bigo.ads.ad.b.a.b) {
                dVar = d.this;
                i8 = 3;
            } else {
                if (!(nativeAd instanceof sg.bigo.ads.ad.b.a.a)) {
                    return;
                }
                dVar = d.this;
                i8 = 2;
            }
            dVar.a(i8, i2);
        }
    }

    public d(@NonNull g gVar) {
        this.g = 0;
        this.h = 0;
        this.f14088i = false;
        a aVar = new a();
        this.m = aVar;
        this.f14089n = new c.a() { // from class: sg.bigo.ads.ad.c.d.1
            @Override // sg.bigo.ads.ad.b.c.a
            public final void a() {
                if (d.this.e != null) {
                    d.this.e.f();
                }
            }
        };
        this.j = gVar;
        sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
        this.f14083a = cVarA;
        if (cVarA != null) {
            cVarA.setAdInteractionListener(aVar);
            this.f14087f = new c(gVar);
            this.f14084b = new sg.bigo.ads.ad.c.b(this.f14083a);
            i.b bVarAw = ((sg.bigo.ads.core.a.a) this.f14083a.f()).aw();
            sg.bigo.ads.ad.b.c cVar = this.f14083a;
            this.e = cVar != null ? sg.bigo.ads.ad.c.a.a.a(cVar, cVar.f14024b.f15500f, bVarAw) : null;
            this.f14085c = Boolean.FALSE;
            this.f14086d = null;
            this.g = 0;
            this.h = 0;
            this.f14088i = false;
        }
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.h;
        dVar.h = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d(d dVar) {
        int i2 = dVar.g;
        dVar.g = i2 + 1;
        return i2;
    }

    private int e() {
        c cVar = this.f14087f;
        return (cVar == null || cVar.f14082c != 2) ? 3 : 1;
    }

    public static /* synthetic */ boolean g(d dVar) {
        sg.bigo.ads.ad.b.c cVar = dVar.f14083a;
        return cVar != null && cVar.n();
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final View adView() {
        if (!sg.bigo.ads.common.n.d.b()) {
            t.a("adView() must run on UI thread");
        }
        if (this.f14083a == null) {
            return null;
        }
        if (isExpired()) {
            this.f14083a.b(2000, 1, "The ad is expired.");
            return null;
        }
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar.f14028i) {
            cVar.b(2000, 1, "The ad is destroyed.");
            return null;
        }
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            return aVar.e();
        }
        cVar.a(2000, "mNativeBannerRender is null.");
        return null;
    }

    @Override // sg.bigo.ads.ad.b.c.b
    public final void b() {
        this.f14088i = true;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Ad ad) {
        Ad ad2 = ad;
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.compareTo(ad2);
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.Ad
    public final void destroy() {
        destroyInMainThread();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void destroyInMainThread() {
        if (sg.bigo.ads.common.n.d.b()) {
            c();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.c.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.c();
                }
            });
        }
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) cVar.f(), SystemClock.elapsedRealtime() - this.k);
        }
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final AdBid getBid() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.getBid();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getCreativeId() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        return cVar != null ? cVar.getCreativeId() : "";
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getExtraInfo(String str) {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.getExtraInfo(str);
        }
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getHeight() {
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            return aVar.j();
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.api.InnerBannerAd
    public final sg.bigo.ads.api.core.c getInnerBannerAdData() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final WebView getWebView() {
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getWidth() {
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            return aVar.i();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void handleInnerBannerAdResponse(@NonNull d.a<InnerBannerAd> aVar) {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar == null) {
            aVar.a(this, 1005, 1253, "native banner mNativeAd is null");
            return;
        }
        cVar.b(true);
        this.l = aVar;
        if (this.f14086d == null) {
            this.f14086d = new b(aVar);
        }
        a(1, 2);
        a(2, 2);
        a(3, 2);
        sg.bigo.ads.ad.b.c cVar2 = this.f14083a;
        if (cVar2 != null) {
            cVar2.a((c.b) this);
            this.f14083a.a(this.f14086d.f14095b, 0);
        }
    }

    @Override // sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.isExpired();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final boolean isInnerBannerAdFromAutoRefresh() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return ((sg.bigo.ads.core.a.a) cVar.f()).bl();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void markFromAutoFresh(sg.bigo.ads.api.core.c cVar) {
        if (cVar instanceof o) {
            ((o) cVar).bk();
        }
        sg.bigo.ads.ad.b.c cVar2 = this.f14083a;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.m.f14092a = adInteractionListener;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final int updateFormOpenTimes() {
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar != null) {
            return cVar.b_();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b bVar = this.f14086d;
        if (bVar != null) {
            bVar.a();
            this.f14086d = null;
        }
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            aVar.h();
        }
        sg.bigo.ads.ad.c.b bVar2 = this.f14084b;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    private void d() {
        sg.bigo.ads.ad.c.b bVar;
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar == null || (bVar = this.f14084b) == null) {
            return;
        }
        aVar.a(bVar.f14076a, e());
    }

    @Override // sg.bigo.ads.ad.b.c.b
    public final void a() {
        a(this.l, 2, false);
        sg.bigo.ads.ad.c.b bVar = this.f14084b;
        d.a<NativeAd> aVar = this.f14086d.f14094a;
        sg.bigo.ads.ad.b.c cVar = bVar.f14077b;
        if (cVar != null) {
            sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) cVar.f();
            if (aVar2.av() == null) {
                aVar.a(bVar.f14077b, 3001, 10103, "banner icon is empty");
                return;
            }
            String strC = aVar2.av().c();
            if (q.a((CharSequence) strC)) {
                aVar.a(bVar.f14077b, 3001, 10103, "banner icon url is empty");
            } else if (sg.bigo.ads.api.a.i.f15457a.n().a(9) && URLUtil.isHttpUrl(strC)) {
                aVar.a(bVar.f14077b, 3001, 10118, "Invalid http banner icon url");
            } else {
                e.b(bVar.f14077b.f14024b.e, sg.bigo.ads.common.u.a.e.j(), strC, aVar2.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.c.b.1

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ d.a f14078a;

                    public AnonymousClass1(d.a aVar3) {
                        aVar = aVar3;
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, @NonNull String str, String str2) {
                        d.a aVar3;
                        b bVar2 = b.this;
                        sg.bigo.ads.ad.b.c cVar2 = bVar2.f14077b;
                        if (cVar2 == null || bVar2.f14076a == null || (aVar3 = aVar) == null) {
                            return;
                        }
                        aVar3.a(cVar2, i2, 3001, str);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull f fVar) {
                        b bVar2 = b.this;
                        sg.bigo.ads.ad.b.c cVar2 = bVar2.f14077b;
                        if (cVar2 == null || bVar2.f14076a == null || aVar == null) {
                            return;
                        }
                        cVar2.a(bitmap, 1);
                        b.this.f14076a.setImageBitmap(bitmap);
                        aVar.a(b.this.f14077b);
                    }
                });
            }
        }
    }

    public final void a(int i2, int i8) {
        String str;
        sg.bigo.ads.ad.b.c cVar = this.f14083a;
        if (cVar == null) {
            return;
        }
        if (i2 == 1) {
            str = "icon_sta";
        } else if (i2 == 2) {
            str = "img_sta";
        } else if (i2 != 3 || !(cVar instanceof sg.bigo.ads.ad.b.a.b)) {
            return;
        } else {
            str = "vid_sta";
        }
        cVar.a(str, Integer.valueOf(i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d.a<InnerBannerAd> aVar, int i2, boolean z2) {
        if (aVar == null) {
            return;
        }
        if (this.f14085c.booleanValue()) {
            return;
        }
        c cVar = this.f14087f;
        int i8 = 2;
        if (cVar != null && cVar.f14080a == 2 && i2 == 2) {
            d();
            aVar.a(this);
            this.f14085c = Boolean.TRUE;
            return;
        }
        sg.bigo.ads.ad.b.c cVar2 = this.f14083a;
        if (cVar2 != null && ((sg.bigo.ads.core.a.a) cVar2.f()).aR()) {
            i8 = 3;
        }
        if (!z2) {
            if (this.h == i8 || this.f14088i) {
                if (this.f14088i) {
                    aVar.a(this, 1005, 1006, "native banner VAST parse failed");
                } else {
                    aVar.a(this, 1005, 1253, "native banner download icon & main resources all failed");
                }
            }
        }
        d();
        aVar.a(this);
        this.f14085c = Boolean.TRUE;
    }

    public class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        AdInteractionListener f14092a;

        public a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f14092a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(@NonNull AdError adError) {
            if (this.f14092a != null) {
                if (adError.getCode() == 2002 && d.g(d.this)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "don't call onAdError when video has impressed");
                } else {
                    this.f14092a.onAdError(adError);
                }
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            d.this.k = SystemClock.elapsedRealtime();
            if (d.this.e != null && d.this.f14087f != null) {
                d.this.e.a(d.this.f14087f.f14081b);
            }
            if (d.this.f14083a != null) {
                d.this.f14083a.a(d.this.f14089n);
            }
            AdInteractionListener adInteractionListener = this.f14092a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
        }
    }
}
