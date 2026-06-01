package sg.bigo.ads.ad.interstitial.e;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.IconAds;
import sg.bigo.ads.api.IconAdsRequest;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f14645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sg.bigo.ads.ad.interstitial.e.a.a f14646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sg.bigo.ads.ad.interstitial.e.a.c f14647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final sg.bigo.ads.ad.interstitial.g.a f14648d;
    public IconAds e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14649f;
    public b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f14650i;
    public sg.bigo.ads.ad.interstitial.e.a j;
    public sg.bigo.ads.ad.interstitial.e.a k;
    public n l;
    public n m;
    public final a g = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14651n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f14652o = "";
    public boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<NativeAd> f14653q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<NativeAd> f14654r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<Integer, Boolean> f14655s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<Integer, Boolean> f14656t = new ConcurrentHashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    List<Integer> f14657u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    List<Integer> f14658v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final sg.bigo.ads.api.d f14659w = new sg.bigo.ads.api.d() { // from class: sg.bigo.ads.ad.interstitial.e.c.1
        private int a(@NonNull NativeAd nativeAd, @NonNull List<NativeAd> list) {
            c cVar = c.this;
            int iA = sg.bigo.ads.ad.interstitial.e.a.b.a(cVar.p ? cVar.f14646b : cVar.f14647c);
            int iIndexOf = list.indexOf(nativeAd);
            if (iA == 0) {
                return 0;
            }
            return iIndexOf / iA;
        }

        @Override // sg.bigo.ads.api.d
        public final void b(@NonNull NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
            n nVar = c.this.l;
            if (nVar != null) {
                nVar.b();
                c.this.l = null;
            }
            n nVar2 = c.this.m;
            if (nVar2 != null) {
                nVar2.b();
                c.this.m = null;
            }
        }

        @Override // sg.bigo.ads.api.d
        public final void c(@NonNull NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
        }

        @Override // sg.bigo.ads.api.d
        public final void d(@NonNull NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
        }

        @Override // sg.bigo.ads.api.d
        public final void a(@NonNull NativeAd nativeAd) {
            sg.bigo.ads.ad.interstitial.e.a.b bVar;
            List<Integer> list;
            List<NativeAd> list2;
            Map<Integer, Boolean> map;
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad impression.");
            c cVar = c.this;
            if (cVar.p) {
                bVar = cVar.f14646b;
                list = cVar.f14657u;
                list2 = cVar.f14653q;
                map = cVar.f14655s;
            } else {
                bVar = cVar.f14647c;
                list = cVar.f14658v;
                list2 = cVar.f14654r;
                map = cVar.f14656t;
            }
            c.a(bVar, list, list2, map, a(nativeAd, list2));
        }

        @Override // sg.bigo.ads.api.d
        public final void a(@NonNull NativeAd nativeAd, @NonNull AdError adError) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad error, code=" + adError.getCode() + ", message=" + adError.getMessage());
        }
    };

    public static class a implements IconAdsRequest.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14669a;

        private a() {
            this.f14669a = 1;
        }

        @Override // sg.bigo.ads.api.IconAdsRequest.b
        public final int a() {
            return this.f14669a;
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f14670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final ViewGroup f14672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public final sg.bigo.ads.ad.interstitial.e.a.b f14673d;
        private boolean e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14674f;

        private b(@NonNull ViewGroup viewGroup, @NonNull sg.bigo.ads.ad.interstitial.e.a.b bVar) {
            this.f14672c = viewGroup;
            this.f14673d = bVar;
            this.f14670a = 0L;
            this.f14671b = false;
            this.e = false;
            this.f14674f = false;
        }

        public final ValueAnimator a(@Nullable Integer num) {
            if (num == null) {
                return null;
            }
            return sg.bigo.ads.common.w.b.a(this.f14672c, num.intValue(), new b.a() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f14675a = 300;

                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return this.f14675a;
                }
            });
        }

        public abstract boolean a();

        public final void b() {
            this.f14671b = true;
            this.e = false;
            this.f14672c.removeCallbacks(this);
        }

        public final void c() {
            this.e = false;
            this.f14674f = true;
            this.f14672c.removeCallbacks(this);
        }

        public final boolean d() {
            if (this.f14671b || this.e) {
                return false;
            }
            this.e = true;
            this.f14674f = false;
            if (this.f14670a == 0) {
                this.f14670a = SystemClock.elapsedRealtime();
            }
            this.f14672c.postDelayed(this, Math.max(this.f14673d.j() - (SystemClock.elapsedRealtime() - this.f14670a), 0L));
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.f14671b && !this.f14674f && a()) {
                this.f14671b = true;
            }
            this.e = false;
        }

        public /* synthetic */ b(ViewGroup viewGroup, sg.bigo.ads.ad.interstitial.e.a.b bVar, byte b8) {
            this(viewGroup, bVar);
        }

        public final void a(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable Integer num, final sg.bigo.ads.ad.interstitial.e.a aVar) {
            u.b(view);
            viewGroup.addView(view);
            sg.bigo.ads.common.e.a.a(view, 100.0f);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            }
            final ValueAnimator valueAnimatorA = a(num);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.1f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setAnimationListener(new b.c() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.2
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    b.this.a(aVar);
                }

                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    ValueAnimator valueAnimator = valueAnimatorA;
                    if (valueAnimator != null) {
                        valueAnimator.start();
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }

        public void a(final sg.bigo.ads.ad.interstitial.e.a aVar) {
            if (aVar != null && aVar.f14628c > 0) {
                aVar.f14627b.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        sg.bigo.ads.ad.interstitial.e.a aVar2 = aVar;
                        aVar2.f14627b.setFlipInterval(aVar2.f14628c);
                        aVar.f14627b.c();
                    }
                });
            }
        }
    }

    public c(@NonNull t tVar, @NonNull m mVar, @Nullable sg.bigo.ads.ad.interstitial.g.a aVar) {
        this.f14645a = tVar;
        this.f14646b = new sg.bigo.ads.ad.interstitial.e.a.a(mVar);
        this.f14647c = new sg.bigo.ads.ad.interstitial.e.a.c(mVar, aVar == null || aVar.g());
        this.f14648d = aVar;
    }

    public static /* synthetic */ List a(IconAds iconAds) {
        if (!(iconAds instanceof sg.bigo.ads.ad.a.a)) {
            if (iconAds != null) {
                return Arrays.asList(iconAds.getNativeAds());
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (sg.bigo.ads.ad.b.a.c cVar : ((sg.bigo.ads.ad.a.a) iconAds).f13824a) {
            if (!cVar.isExpired() && !cVar.f14028i) {
                if (cVar.f13873x) {
                    arrayList.add(cVar);
                } else if (!cVar.y) {
                    arrayList2.add(cVar);
                }
            }
        }
        arrayList.addAll(arrayList2);
        sg.bigo.ads.ad.b.a.c[] cVarArr = new sg.bigo.ads.ad.b.a.c[arrayList.size()];
        sg.bigo.ads.common.utils.k.a(arrayList, cVarArr);
        return Arrays.asList(cVarArr);
    }

    private void d() {
        b();
        sg.bigo.ads.ad.interstitial.e.a aVar = this.j;
        if (aVar != null) {
            aVar.f14627b.d();
            u.b(this.j.f14626a);
        }
        this.j = null;
    }

    public final void b() {
        b bVar = this.h;
        if (bVar != null) {
            bVar.b();
        }
        this.h = null;
    }

    public final void c() {
        b bVar = this.f14650i;
        if (bVar != null) {
            bVar.b();
        }
        this.f14650i = null;
    }

    public static /* synthetic */ n a(c cVar, final sg.bigo.ads.ad.interstitial.e.a.b bVar, final List list) {
        int iO;
        if (bVar == null || !bVar.a() || (iO = bVar.o()) < 0) {
            return null;
        }
        return new n(r.f16034a.a(iO)) { // from class: sg.bigo.ads.ad.interstitial.e.c.5
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                NativeAd nativeAd = (NativeAd) list.get(0);
                if (nativeAd instanceof sg.bigo.ads.ad.b.c) {
                    sg.bigo.ads.ad.b.a.c cVar2 = (sg.bigo.ads.ad.b.a.c) nativeAd;
                    if (cVar2.g) {
                        return;
                    }
                    cVar2.a(bVar.b(), 22);
                }
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
    }

    public static void b(sg.bigo.ads.ad.interstitial.e.a aVar, b bVar) {
        if (aVar == null) {
            if (bVar != null) {
                bVar.d();
            }
        } else {
            int i2 = aVar.f14628c;
            if (i2 > 0) {
                aVar.f14627b.setFlipInterval(i2);
                aVar.f14627b.c();
            }
        }
    }

    public final void a(ViewGroup viewGroup, final int i2) {
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.f14645a.f(), i2);
        this.p = true;
        if (viewGroup == null) {
            a(this.f14646b, "endPageView is null", i2);
            return;
        }
        if (sg.bigo.ads.ad.interstitial.e.a.b.b(this.f14646b)) {
            a(this.f14646b, "config is invalid", i2);
            return;
        }
        if (!a(i2)) {
            a(this.f14646b, "icon request hasScene return false", i2);
            return;
        }
        d();
        b bVar = new b(viewGroup, this.f14646b) { // from class: sg.bigo.ads.ad.interstitial.e.c.3
            {
                byte b8 = 0;
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
            
                if (r3 == 2) goto L34;
             */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean a() {
                /*
                    Method dump skipped, instruction units count: 227
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.e.c.AnonymousClass3.a():boolean");
            }
        };
        this.h = bVar;
        bVar.d();
    }

    public final void a(sg.bigo.ads.ad.interstitial.e.a.b bVar, String str, int i2) {
        if (bVar != null) {
            sg.bigo.ads.core.d.b.a(this.f14645a.f(), str, i2, bVar.i(), this.f14652o, bVar.f());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void a(sg.bigo.ads.ad.interstitial.e.a.b r7, java.util.List r8, java.util.List r9, java.util.Map r10, int r11) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.e.c.a(sg.bigo.ads.ad.interstitial.e.a.b, java.util.List, java.util.List, java.util.Map, int):void");
    }

    public static void a(sg.bigo.ads.ad.interstitial.e.a aVar, b bVar) {
        if (aVar != null) {
            aVar.f14627b.d();
        } else if (bVar != null) {
            bVar.c();
        }
    }

    public static /* synthetic */ void a(c cVar, int i2) {
        Ad ad = cVar.e;
        if (ad instanceof sg.bigo.ads.api.b.e) {
            ((sg.bigo.ads.api.b.e) ad).f15469b = i2;
        }
    }

    public static /* synthetic */ void a(c cVar, sg.bigo.ads.ad.interstitial.e.a.b bVar, int i2, List list) {
        if (bVar == null || list == null) {
            return;
        }
        sg.bigo.ads.core.d.b.a(cVar.f14645a.f(), i2, bVar.i(), cVar.f14652o, list.size(), bVar.f(), bVar.a());
    }

    public static /* synthetic */ void a(c cVar, boolean z2) {
        Ad ad = cVar.e;
        if (ad instanceof sg.bigo.ads.api.b.e) {
            ((sg.bigo.ads.api.b.e) ad).f15470c = z2;
        }
    }

    public final boolean a() {
        t tVar = this.f14645a;
        return tVar.f14028i || tVar.f15129z.f14028i;
    }

    public final boolean a(int i2) {
        return (this.f14649f & i2) == i2;
    }
}
