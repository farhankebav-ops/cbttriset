package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.ad.b.b;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.common.p.h;

/* JADX INFO: loaded from: classes6.dex */
public class t extends k<sg.bigo.ads.core.a.a> {

    @Nullable
    public sg.bigo.ads.ad.interstitial.a.b A;

    @Nullable
    public sg.bigo.ads.ad.interstitial.a.a B;

    @Nullable
    b C;

    @Nullable
    l D;
    private final a E;
    private final Map<sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.interstitial.multi_img.b> F;
    private final Map<sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.interstitial.multi_img.b> G;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public sg.bigo.ads.ad.b.c f15129z;

    public class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        AdInteractionListener f15134a;

        public a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f15134a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
            k.b bVar = ((k) t.this).f14819x;
            if (bVar != null) {
                bVar.C();
            }
            if (t.this.D != null) {
                t.this.D.k = SystemClock.elapsedRealtime();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
            AdInteractionListener adInteractionListener = this.f15134a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(@NonNull AdError adError) {
            k.b bVar;
            if (this.f15134a != null) {
                if (adError.getCode() == 2002 && t.this.n()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeImpl", "don't call onAdError when video has impressed");
                } else {
                    this.f15134a.onAdError(adError);
                }
            }
            if (adError.getCode() != 2002 || (bVar = ((k) t.this).f14819x) == null) {
                return;
            }
            bVar.b(adError.getMessage());
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f15134a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
            if (t.this.D != null) {
                t.this.D.l = SystemClock.elapsedRealtime();
            }
            sg.bigo.ads.ad.interstitial.multi_img.b bVarC = t.this.C();
            if (bVarC != null) {
                bVarC.b();
            }
            sg.bigo.ads.ad.interstitial.multi_img.b bVarD = t.this.D();
            if (bVarD != null) {
                bVarD.b();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
            AdInteractionListener adInteractionListener = this.f15134a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdOpened();
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> f15136a;

        public b() {
        }
    }

    public t(@NonNull sg.bigo.ads.api.core.g gVar) {
        sg.bigo.ads.api.core.c cVar;
        sg.bigo.ads.api.a.m mVarE;
        int iA;
        super(gVar);
        a aVar = new a();
        this.E = aVar;
        this.F = new HashMap();
        this.G = new HashMap();
        sg.bigo.ads.ad.b.c cVarA = null;
        if (gVar != null && (cVar = gVar.f15496a) != null && (mVarE = cVar.e()) != null && ((33 == (iA = mVarE.a("video_play_page.ad_component_layout")) && !gVar.f15496a.ar()) || (6 == iA && gVar.f15496a.ar()))) {
            int iW = gVar.f15496a.w();
            if (iW == 1) {
                cVarA = new sg.bigo.ads.ad.b.a.f(gVar);
            } else if (iW == 2) {
                cVarA = new sg.bigo.ads.ad.b.a.g(gVar);
            }
        }
        cVarA = cVarA == null ? sg.bigo.ads.ad.b.a.a(gVar) : cVarA;
        if (cVarA == null) {
            throw new IllegalArgumentException("Illegal adx type.");
        }
        this.f15129z = cVarA;
        cVarA.a(true);
        if (this.f15129z instanceof sg.bigo.ads.ad.b.b) {
            this.C = new b();
        }
        this.f15129z.setAdInteractionListener(aVar);
        a((sg.bigo.ads.api.b.a) cVarA);
    }

    public static /* synthetic */ Pair a(t tVar, NativeAd nativeAd, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.core.c cVar) {
        sg.bigo.ads.core.f.a.p pVar;
        t tVar2;
        sg.bigo.ads.api.a.l lVar2;
        sg.bigo.ads.api.core.c cVar2;
        boolean z2 = nativeAd instanceof sg.bigo.ads.ad.b.d;
        sg.bigo.ads.core.player.c cVar3 = z2 ? ((sg.bigo.ads.ad.b.d) nativeAd).J : null;
        if (z2) {
            pVar = ((sg.bigo.ads.ad.b.d) nativeAd).K;
            lVar2 = lVar;
            cVar2 = cVar;
            tVar2 = tVar;
        } else {
            pVar = null;
            tVar2 = tVar;
            lVar2 = lVar;
            cVar2 = cVar;
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = new sg.bigo.ads.ad.interstitial.a.b(tVar2, lVar2, cVar2, cVar3, pVar);
        sg.bigo.ads.ad.interstitial.a.a aVar = new sg.bigo.ads.ad.interstitial.a.a(bVar.f14266a, tVar, lVar, cVar, z2 ? ((sg.bigo.ads.ad.b.d) nativeAd).J : null, z2 ? ((sg.bigo.ads.ad.b.d) nativeAd).K : null);
        int i2 = bVar.f14266a ? 1 : aVar.f14218a ? 2 : 0;
        if (cVar.e() != null) {
            i2 = cVar.h() ? i2 : 0;
        }
        cVar.d(i2);
        cVar.e((bVar.f14266a || (aVar.f14219b instanceof sg.bigo.ads.ad.interstitial.a.a.b)) ? 1 : 2);
        return new Pair(bVar, aVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        return G() ? sg.bigo.ads.ad.interstitial.h.a.class : y() ? F() ? sg.bigo.ads.ad.interstitial.j.a.class : z.class : y.class;
    }

    @Nullable
    public final sg.bigo.ads.ad.interstitial.multi_img.b C() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar instanceof sg.bigo.ads.ad.b.b) {
            return null;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVarB = this.F.get(cVar);
        if (bVarB == null) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.f15129z.f();
            if (aVar != null) {
                bVarB = sg.bigo.ads.ad.interstitial.multi_img.b.b(this.f15129z, aVar.e());
            }
            if (bVarB != null) {
                this.F.put(this.f15129z, bVarB);
            }
        }
        return bVarB;
    }

    @Nullable
    public final sg.bigo.ads.ad.interstitial.multi_img.b D() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar instanceof sg.bigo.ads.ad.b.b) {
            return null;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVarA = this.G.get(cVar);
        if (bVarA == null) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.f15129z.f();
            if (aVar != null) {
                bVarA = sg.bigo.ads.ad.interstitial.multi_img.b.a(this.f15129z, aVar.e());
            }
            if (bVarA != null) {
                this.G.put(this.f15129z, bVarA);
            }
        }
        return bVarA;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    @NonNull
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public final sg.bigo.ads.core.a.a f() {
        return (sg.bigo.ads.core.a.a) this.f15129z.f();
    }

    public final boolean F() {
        return ((sg.bigo.ads.core.a.a) this.f15129z.f()).aS();
    }

    public boolean G() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        return (cVar instanceof sg.bigo.ads.ad.b.a.f) || (cVar instanceof sg.bigo.ads.ad.b.a.g);
    }

    @Override // sg.bigo.ads.ad.c
    @NonNull
    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return (ValueType) this.f15129z.b(str, valuetype);
    }

    @Override // sg.bigo.ads.api.b.a
    public final sg.bigo.ads.api.core.p c_() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        return cVar != null ? cVar.c_() : this.W;
    }

    @Override // sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        this.f15129z.destroy();
        this.C = null;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public String getCreativeId() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        return cVar != null ? cVar.getCreativeId() : "";
    }

    @Override // sg.bigo.ads.ad.c
    public final boolean n() {
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        return (cVar != null && cVar.n()) || super.n();
    }

    @Override // sg.bigo.ads.ad.c
    public final void s() {
        this.f15129z.s();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        this.E.f15134a = adInteractionListener;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final boolean y() {
        return ((sg.bigo.ads.core.a.a) this.f15129z.f()).aR();
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b(int i2) {
        super.b(i2);
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final void b(@NonNull Activity activity) {
        super.b(activity);
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar != null) {
            cVar.b(activity);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i2) {
        super.a(i2);
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public void b(@NonNull final d.a<InterstitialAd> aVar) {
        sg.bigo.ads.api.a.m mVarE;
        sg.bigo.ads.api.a.m mVarE2;
        sg.bigo.ads.api.a.m mVarE3;
        sg.bigo.ads.api.a.m mVarE4;
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        sg.bigo.ads.api.a.m mVarE5 = f().e();
        boolean z2 = true;
        if ((mVarE5 == null || (mVarE5.a("video_play_page.cta_color") != 3 && mVarE5.a("video_play_page.background_colour") != 3 && mVarE5.a("video_play_page.mediaview_colour") != 3 && mVarE5.a("video_play_page.ad_component_colour") != 3)) && (((mVarE = f().e()) == null || mVarE.a("mid_page.cta_color") != 3) && (((mVarE2 = f().e()) == null || (mVarE2.a("endpage.cta_color") != 3 && mVarE2.a("endpage.background_colour") != 3 && mVarE2.a("endpage.mediaview_colour") != 3)) && (((mVarE3 = f().e()) == null || (mVarE3.a("layer.cta_color") != 3 && mVarE3.a("layer.mediaview_colour") != 3)) && ((mVarE4 = f().e()) == null || (mVarE4.a("video_play_page.is_widget") != 1 && mVarE4.a("endpage.is_widget") != 1)))))) {
            z2 = false;
        }
        cVar.b(z2);
        this.f15129z.a(new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.interstitial.t.1
            private void a(int i2, int i8, String str) {
                t tVar = t.this;
                if (tVar.e || tVar.f14027f) {
                    return;
                }
                aVar.a(tVar, i2, i8, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                a(i2, i8, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, boolean z7, int i2, int i8, String str, boolean z8) {
                b.a aVar2;
                final NativeAd nativeAd = (NativeAd) ad;
                t tVar = t.this;
                if (tVar.e || tVar.f14027f || !(nativeAd instanceof sg.bigo.ads.ad.b.d)) {
                    return;
                }
                boolean z9 = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.b.d) nativeAd).f()).bh() != null || z7;
                if (!(t.this.f15129z instanceof sg.bigo.ads.ad.b.b)) {
                    if (z9) {
                        a(nativeAd);
                        return;
                    } else {
                        if (z8) {
                            a(i2, i8, str);
                            return;
                        }
                        return;
                    }
                }
                final sg.bigo.ads.ad.b.b bVar = (sg.bigo.ads.ad.b.b) t.this.f15129z;
                if (z9) {
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.this.f13878z != null) {
                                b.this.f13878z.a(nativeAd);
                            }
                        }
                    });
                } else {
                    if (!z8 || (aVar2 = bVar.f13878z) == null) {
                        return;
                    }
                    aVar2.a(i2, i8, str);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Type inference failed for: r6v3, types: [sg.bigo.ads.api.core.c] */
            /* JADX WARN: Type inference failed for: r9v0, types: [sg.bigo.ads.api.core.c] */
            @Override // sg.bigo.ads.api.b.d.a
            public void a(NativeAd nativeAd) {
                Set<Map.Entry<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>>> setEntrySet;
                Map.Entry<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> next;
                sg.bigo.ads.api.core.g gVar = t.this.f14024b;
                if (t.this.C != null) {
                    b bVar = t.this.C;
                    sg.bigo.ads.ad.b.c cVar2 = t.this.f15129z;
                    sg.bigo.ads.api.a.l lVar = gVar.f15497b;
                    HashMap map = new HashMap();
                    bVar.f15136a = map;
                    boolean z7 = false;
                    if (cVar2 instanceof sg.bigo.ads.ad.b.b) {
                        sg.bigo.ads.ad.b.b bVar2 = (sg.bigo.ads.ad.b.b) cVar2;
                        sg.bigo.ads.ad.b.d dVar = bVar2.f13877x;
                        sg.bigo.ads.ad.b.d dVar2 = bVar2.y;
                        if (dVar != null) {
                            map.put(cVar2, t.a(t.this, dVar, lVar, (sg.bigo.ads.api.core.c) dVar.f()));
                            z7 = true;
                        }
                        if (dVar2 != null) {
                            bVar.f15136a.put(cVar2, t.a(t.this, dVar2, lVar, (sg.bigo.ads.api.core.c) dVar2.f()));
                            z7 = true;
                        }
                    }
                    if (z7) {
                        b bVar3 = t.this.C;
                        Map<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> map2 = bVar3.f15136a;
                        Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a> value = null;
                        if (map2 != null && !map2.isEmpty() && (setEntrySet = bVar3.f15136a.entrySet()) != null && !setEntrySet.isEmpty() && (next = setEntrySet.iterator().next()) != null) {
                            value = next.getValue();
                        }
                        if (value != null) {
                            t.this.A = (sg.bigo.ads.ad.interstitial.a.b) value.first;
                            t.this.B = (sg.bigo.ads.ad.interstitial.a.a) value.second;
                        }
                    }
                }
                if (t.this.A == null || t.this.B == null) {
                    Pair pairA = t.a(t.this, nativeAd, gVar.f15497b, gVar.f15496a);
                    t.this.A = (sg.bigo.ads.ad.interstitial.a.b) pairA.first;
                    t.this.B = (sg.bigo.ads.ad.interstitial.a.a) pairA.second;
                }
                t tVar = t.this;
                if (tVar.e || tVar.f14027f) {
                    return;
                }
                tVar.a(tVar.f15129z, 0);
                aVar.a(t.this);
            }
        }, 0);
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final void a(int i2, int i8) {
        super.a(i2, i8);
        l lVar = this.D;
        if (lVar != null) {
            lVar.f14831s = true;
            lVar.m = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sg.bigo.ads.ad.b.c cVar, int i2) {
        while (cVar != null && i2 <= 5) {
            if (!(cVar instanceof sg.bigo.ads.ad.b.b)) {
                sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) cVar.f();
                sg.bigo.ads.api.a.m mVarE = aVar.e();
                sg.bigo.ads.ad.interstitial.multi_img.b bVarB = sg.bigo.ads.ad.interstitial.multi_img.b.b(cVar, mVarE);
                if (bVarB != null) {
                    this.F.put(cVar, bVarB);
                }
                sg.bigo.ads.ad.interstitial.multi_img.b bVarA = sg.bigo.ads.ad.interstitial.multi_img.b.a(cVar, mVarE);
                if (bVarA != null) {
                    this.G.put(cVar, bVarA);
                }
                if (bVarB == null && bVarA == null) {
                    return;
                }
                if (bVarB != null && bVarB.g == 1) {
                    bVarB.b();
                    return;
                }
                if (bVarA != null && bVarA.g == 1) {
                    bVarA.b();
                    return;
                }
                if (bVarB != null && bVarB.g == 2) {
                    a(aVar, bVarB);
                    return;
                } else {
                    if (bVarA == null || bVarA.g != 2) {
                        return;
                    }
                    a(aVar, bVarA);
                    return;
                }
            }
            sg.bigo.ads.ad.b.b bVar = (sg.bigo.ads.ad.b.b) cVar;
            i2++;
            a(bVar.f13877x, i2);
            cVar = bVar.y;
        }
    }

    private void a(sg.bigo.ads.core.a.a aVar, final sg.bigo.ads.ad.interstitial.multi_img.b bVar) {
        if (aVar.aR()) {
            sg.bigo.ads.core.player.b.a().a(aVar.aP(), new ValueCallback<Boolean>() { // from class: sg.bigo.ads.ad.interstitial.t.2
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Boolean bool) {
                    if (!bool.booleanValue()) {
                        bVar.b();
                    }
                }
            });
            return;
        }
        if (h.a.f15921a.a(aVar.aT())) {
            return;
        }
        bVar.b();
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z2, boolean z7) {
        super.a(z2, z7);
        sg.bigo.ads.ad.b.c cVar = this.f15129z;
        if (cVar != null) {
            cVar.a(z2, z7);
        }
    }
}
