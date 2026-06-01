package sg.bigo.ads.ad.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.b.d;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public d f13877x;

    @Nullable
    public d y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public a f13878z;

    public abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        protected final d.a<NativeAd> f13881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        protected final d.a<NativeAd> f13882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        protected final d.a<NativeAd> f13883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        final List<d> f13884d = new ArrayList();

        @NonNull
        public final String[] e = {"", ""};

        @NonNull
        private final List<sg.bigo.ads.common.p.g> k = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f13885f = 0;
        protected int g = 0;
        protected boolean h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected boolean f13886i = false;

        public a(final d.a<NativeAd> aVar) {
            this.f13883c = aVar;
            this.f13881a = new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.b.a.1
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    final NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(nativeAd);
                        }
                    });
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                    a.this.a(i2, i8, str);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                    aVar.a((NativeAd) ad, z2, i2, i8, str, z7);
                }
            };
            this.f13882b = new d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.b.a.2
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    final NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(nativeAd);
                        }
                    });
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, int i2, int i8, String str) {
                    a.this.a(i2, i8, str);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z2, int i2, int i8, String str, boolean z7) {
                    aVar.a((NativeAd) ad, z2, i2, i8, str, z7);
                }
            };
        }

        public final d.a<NativeAd> a() {
            return this.f13881a;
        }

        public final d.a<NativeAd> b() {
            return this.f13882b;
        }

        public abstract void c();

        public final void a(final int i2, final int i8, final String str) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) b.this.f();
                    if (aVar != null) {
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar.c(str2);
                    }
                    a aVar2 = a.this;
                    int i9 = aVar2.g + 1;
                    aVar2.g = i9;
                    if (aVar2.h || aVar2.f13886i) {
                        return;
                    }
                    int i10 = aVar2.f13885f;
                    if (i9 + i10 == 2) {
                        d.a<NativeAd> aVar3 = aVar2.f13883c;
                        b bVar = b.this;
                        if (i10 > 0) {
                            aVar3.a(bVar);
                            a.this.h = true;
                        } else {
                            aVar3.a(bVar, i2, i8, str);
                            a.this.f13886i = true;
                        }
                    }
                }
            });
        }

        private void a(@NonNull final d dVar) {
            final String strAT;
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
            if (aVar != null) {
                strAT = aVar.aT();
                if (TextUtils.isEmpty(strAT) || !URLUtil.isNetworkUrl(strAT)) {
                    strAT = aVar.az();
                }
            } else {
                strAT = null;
            }
            if (TextUtils.isEmpty(strAT) || !URLUtil.isNetworkUrl(strAT)) {
                return;
            }
            sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.b.a.3
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i2, @NonNull String str, String str2) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                    if (dVar == b.this.f13877x) {
                        a.this.e[0] = strAT;
                    } else if (dVar == b.this.y) {
                        a.this.e[1] = strAT;
                    }
                }
            };
            this.k.add(gVar);
            sg.bigo.ads.common.p.e.a(b.this.f14024b.e, strAT, aVar.al(), gVar);
        }

        public final void a(NativeAd nativeAd) {
            if ((nativeAd instanceof d) && !this.f13884d.contains(nativeAd)) {
                d dVar = (d) nativeAd;
                if (nativeAd == b.this.f13877x) {
                    this.f13884d.add(0, dVar);
                } else {
                    this.f13884d.add(dVar);
                }
                a(dVar);
            }
            c();
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.b$b, reason: collision with other inner class name */
    public class C0232b extends a {
        public C0232b(d.a<NativeAd> aVar) {
            super(aVar);
        }

        @Override // sg.bigo.ads.ad.b.b.a
        public final void c() {
            int i2 = this.f13885f + 1;
            this.f13885f = i2;
            if (this.h || this.f13886i || i2 + this.g != 2) {
                return;
            }
            this.f13883c.a(b.this);
            this.h = true;
        }
    }

    public class c extends a {
        public c(d.a<NativeAd> aVar) {
            super(aVar);
        }

        @Override // sg.bigo.ads.ad.b.b.a
        public final void c() {
            this.f13885f++;
            if (this.h || this.f13886i) {
                return;
            }
            this.f13883c.a(b.this);
            this.h = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [sg.bigo.ads.api.core.c] */
    public b(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        ?? F = f();
        List<sg.bigo.ads.api.core.c> listAm = F.am();
        this.f13877x = new d(gVar.a(F));
        if (listAm == null || listAm.size() <= 0) {
            return;
        }
        this.y = new d(gVar.a(listAm.get(0)));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.destroy();
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.destroy();
        }
        if (this.f14031q) {
            return;
        }
        this.f14031q = true;
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f(), SystemClock.elapsedRealtime() - this.k);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.setAdInteractionListener(adInteractionListener);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.setAdInteractionListener(adInteractionListener);
        }
    }

    @Nullable
    public final List<d> x() {
        a aVar = this.f13878z;
        if (aVar != null) {
            return aVar.f13884d;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i2) {
        super.a(i2);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.a(i2);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.a(i2);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b(int i2) {
        super.b(i2);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.b(i2);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.b(i2);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void c(int i2) {
        super.c(i2);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.c(i2);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.c(i2);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void a(sg.bigo.ads.api.b.a aVar) {
        super.a(aVar);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.a(aVar);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.a(aVar);
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void b(Activity activity) {
        super.b(activity);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.b(activity);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.b(activity);
        }
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(@NonNull d.a<NativeAd> aVar, int i2) {
        m mVarE;
        if (aVar == null) {
            return;
        }
        d dVar = this.f13877x;
        d dVar2 = this.y;
        int iA = 0;
        int i8 = dVar == null ? 0 : 1;
        if (dVar2 != null) {
            i8++;
        }
        if (i8 == 0) {
            aVar.a(this, IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE, 10205, "Double video empty ads.");
            return;
        }
        if (i8 == 1) {
            if (dVar == null) {
                dVar = dVar2;
            }
            dVar.a(aVar, i2);
            return;
        }
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) f();
        if (aVar2 != null && (mVarE = aVar2.e()) != null) {
            iA = mVarE.a("multi_ads.ad_fill_tactic");
        }
        a c0232b = iA == 2 ? new C0232b(aVar) : new c(aVar);
        dVar.a(c0232b.a(), i2);
        dVar2.a(c0232b.b(), i2);
        this.f13878z = c0232b;
    }

    @Override // sg.bigo.ads.ad.b.e
    public final void b(boolean z2) {
        super.b(z2);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.b(z2);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.b(z2);
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(boolean z2) {
        super.a(z2);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.a(z2);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.a(z2);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z2, boolean z7) {
        super.a(z2, z7);
        d dVar = this.f13877x;
        if (dVar != null) {
            dVar.a(z2, z7);
        }
        d dVar2 = this.y;
        if (dVar2 != null) {
            dVar2.a(z2, z7);
        }
    }
}
