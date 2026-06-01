package sg.bigo.ads.ad.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.ad.b.a.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.IconAds;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.b.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends e<IconAds, sg.bigo.ads.core.a.a> implements IconAds, d<IconAds> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f13824a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13825d;
    private final sg.bigo.ads.api.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f13826f;
    private final AtomicBoolean g;
    private final AtomicBoolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f13827i;
    private final AtomicBoolean j;
    private sg.bigo.ads.api.d k;
    private int l;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.a.a$a, reason: collision with other inner class name */
    public static class C0228a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final c f13837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final sg.bigo.ads.api.d f13838b;

        public C0228a(c cVar, sg.bigo.ads.api.d dVar) {
            this.f13837a = cVar;
            this.f13838b = dVar;
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            sg.bigo.ads.api.d dVar = this.f13838b;
            if (dVar != null) {
                dVar.b(this.f13837a);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
            sg.bigo.ads.api.d dVar = this.f13838b;
            if (dVar != null) {
                dVar.d(this.f13837a);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(@NonNull AdError adError) {
            sg.bigo.ads.api.d dVar = this.f13838b;
            if (dVar != null) {
                dVar.a(this.f13837a, adError);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            sg.bigo.ads.api.d dVar = this.f13838b;
            if (dVar != null) {
                dVar.a(this.f13837a);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
            sg.bigo.ads.api.d dVar = this.f13838b;
            if (dVar != null) {
                dVar.c(this.f13837a);
            }
        }
    }

    public a(b bVar, g... gVarArr) {
        super(bVar);
        this.e = new sg.bigo.ads.api.d() { // from class: sg.bigo.ads.ad.a.a.1
            @Override // sg.bigo.ads.api.d
            public final void a(@NonNull NativeAd nativeAd) {
                a.a(a.this, nativeAd);
                if (a.this.k != null) {
                    a.this.k.a(nativeAd);
                }
            }

            @Override // sg.bigo.ads.api.d
            public final void b(@NonNull NativeAd nativeAd) {
                if (a.this.k != null) {
                    a.this.k.b(nativeAd);
                }
            }

            @Override // sg.bigo.ads.api.d
            public final void c(@NonNull NativeAd nativeAd) {
                if (a.this.k != null) {
                    a.this.k.c(nativeAd);
                }
            }

            @Override // sg.bigo.ads.api.d
            public final void d(@NonNull NativeAd nativeAd) {
                if (a.this.k != null) {
                    a.this.k.d(nativeAd);
                }
            }

            @Override // sg.bigo.ads.api.d
            public final void a(@NonNull NativeAd nativeAd, @NonNull AdError adError) {
                if (a.this.k != null) {
                    a.this.k.a(nativeAd, adError);
                }
            }
        };
        ArrayList arrayList = new ArrayList();
        for (g gVar : gVarArr) {
            sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
            if (cVarA instanceof c) {
                arrayList.add((c) cVarA);
            }
        }
        c[] cVarArr = new c[arrayList.size()];
        k.a(arrayList, cVarArr);
        this.f13824a = cVarArr;
        this.f13826f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.f13827i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.l = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // sg.bigo.ads.api.b.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public sg.bigo.ads.core.a.a f() {
        for (c cVar : this.f13824a) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) cVar.f();
            if (aVar != null) {
                return aVar;
            }
        }
        return null;
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b() {
        if (this.f13826f.compareAndSet(false, true)) {
            Object obj = this.R;
            if (obj instanceof sg.bigo.ads.api.b.c) {
                this.l = ((sg.bigo.ads.api.b.c) obj).l();
            }
            boolean zBooleanValue = false;
            for (c cVar : this.f13824a) {
                if (cVar != null) {
                    cVar.b();
                    zBooleanValue |= ((Boolean) cVar.b("is_cache", Boolean.FALSE)).booleanValue();
                }
            }
            sg.bigo.ads.core.d.b.a(this, zBooleanValue);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void c() {
        if (this.g.compareAndSet(false, true)) {
            for (c cVar : this.f13824a) {
                if (cVar != null) {
                    cVar.c();
                }
            }
            a("filled");
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final String d() {
        return "";
    }

    @Override // sg.bigo.ads.api.Ad
    public final void destroy() {
        for (c cVar : this.f13824a) {
            cVar.destroy();
        }
        sg.bigo.ads.core.d.b.a(f(), SystemClock.elapsedRealtime() - this.f13825d);
    }

    @Override // sg.bigo.ads.api.b.a
    public final long e() {
        h hVar = i.f15457a;
        if (hVar != null) {
            return hVar.i();
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.b.a
    public final double g() {
        double dG = 0.0d;
        for (c cVar : this.f13824a) {
            dG += cVar.g();
        }
        return dG;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final AdBid getBid() {
        return null;
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getCreativeId() {
        return "";
    }

    @Override // sg.bigo.ads.api.Ad
    @Nullable
    public final String getExtraInfo(String str) {
        sg.bigo.ads.core.a.a aVarF = f();
        return aVarF != null ? aVarF.b(str) : "";
    }

    @Override // sg.bigo.ads.api.IconAds
    public final NativeAd[] getNativeAds() {
        c[] cVarArr = this.f13824a;
        return (NativeAd[]) Arrays.copyOf(cVarArr, cVarArr.length);
    }

    @Override // sg.bigo.ads.api.b.e
    public final int h() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.b.e
    public final int i() {
        return this.f13824a.length;
    }

    @Override // sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        for (c cVar : this.f13824a) {
            if (!cVar.isExpired()) {
                return false;
            }
        }
        return true;
    }

    @Override // sg.bigo.ads.api.b.e
    public final int j() {
        int i2 = 0;
        for (c cVar : this.f13824a) {
            if (!cVar.y) {
                i2++;
            }
        }
        return i2;
    }

    @Override // sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    @Deprecated
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i2, int i8, String str) {
        if (this.h.compareAndSet(false, true)) {
            for (c cVar : this.f13824a) {
                if (cVar != null) {
                    cVar.a(i2, i8, str);
                }
            }
            sg.bigo.ads.core.d.b.a(this, i2, i8, str);
        }
    }

    @Override // sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(sg.bigo.ads.api.d dVar) {
        this.k = dVar;
    }

    private void a(String str) {
        sg.bigo.ads.core.b.b.a().a(str, sg.bigo.ads.core.b.a.a(str, this.R.h(), this.R, null, null, null, null, this));
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(String str, String str2, int i2) {
        if (this.j.compareAndSet(false, true)) {
            sg.bigo.ads.core.d.b.a(this, str, str2, i2);
        }
    }

    public static /* synthetic */ void a(a aVar, NativeAd nativeAd) {
        if (aVar.f13827i.compareAndSet(false, true)) {
            aVar.f13825d = SystemClock.elapsedRealtime();
            aVar.a("impression");
            if (nativeAd instanceof c) {
                c cVar = (c) nativeAd;
                sg.bigo.ads.core.d.b.a(cVar.f14024b.e, aVar, (String) cVar.b("show_proportion", ""), cVar.i(), ((Integer) cVar.b("render_style", 0)).intValue(), cVar.u(), ((Long) cVar.b("attach_render_cost", -1L)).longValue(), SystemClock.elapsedRealtime() - cVar.l, -1, -1, -1);
            }
        }
    }

    @Override // sg.bigo.ads.api.b.d
    public final void a(@NonNull final d.a<IconAds> aVar) {
        final HashSet hashSet = new HashSet(Arrays.asList(this.f13824a));
        final HashSet hashSet2 = new HashSet();
        final d.a<IconAds> aVar2 = new d.a<IconAds>() { // from class: sg.bigo.ads.ad.a.a.2
            private void a() {
                if (k.a(hashSet)) {
                    if (k.a(hashSet2)) {
                        aVar.a(a.this, 1020, 1500, "all icon ads are invalid.");
                    } else {
                        aVar.a(a.this);
                    }
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad) {
                a();
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                a();
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                a();
            }
        };
        for (c cVar : this.f13824a) {
            cVar.a((sg.bigo.ads.api.b.a) this);
            cVar.b("filled");
            cVar.b("impression");
            cVar.c("06002008");
            cVar.c("06002010");
            cVar.c("06002029");
            cVar.setAdInteractionListener(new C0228a(cVar, this.e));
            cVar.a(new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.a.a.3
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    NativeAd nativeAd = (NativeAd) ad;
                    hashSet.remove(nativeAd);
                    hashSet2.add(nativeAd);
                    aVar2.a(a.this);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                    hashSet.remove((NativeAd) ad);
                    aVar2.a(a.this, i2, i8, str);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                    NativeAd nativeAd = (NativeAd) ad;
                    hashSet.remove(nativeAd);
                    hashSet2.add(nativeAd);
                    aVar2.a(a.this, z2, i2, i8, str, z7);
                }
            });
        }
    }

    @Override // sg.bigo.ads.api.b.g
    public final sg.bigo.ads.api.core.c[] a() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f13824a) {
            arrayList.add(cVar.f());
        }
        sg.bigo.ads.api.core.c[] cVarArr = new sg.bigo.ads.api.core.c[arrayList.size()];
        k.a(arrayList, cVarArr);
        return cVarArr;
    }
}
