package sg.bigo.ads.ad.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.bigosg.adsession.media.MediaEvents;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.ws.RealWebSocket;
import sg.bigo.ads.ad.b.g;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.o;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.c.b;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.j;
import sg.bigo.ads.core.f.a.k;
import sg.bigo.ads.core.f.a.l;
import sg.bigo.ads.core.f.a.n;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.b;

/* JADX INFO: loaded from: classes6.dex */
public class d extends c {

    @Nullable
    public sg.bigo.ads.core.player.c J;

    @Nullable
    public p K;
    public boolean L;
    private final a X;
    private g Y;
    private final sg.bigo.ads.core.g.c Z;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private b.a f13918x;
    private Pair<Boolean, Boolean> y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AtomicBoolean f13919z;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.d$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.a f13930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ sg.bigo.ads.core.a.a f13931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ sg.bigo.ads.api.core.c f13932d;

        public AnonymousClass4(int i2, d.a aVar, sg.bigo.ads.core.a.a aVar2, sg.bigo.ads.api.core.c cVar) {
            this.f13929a = i2;
            this.f13930b = aVar;
            this.f13931c = aVar2;
            this.f13932d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f13929a != 0) {
                d.this.z();
                this.f13930b.a(d.this, 1006, this.f13929a, "Invalid media video.");
                return;
            }
            d.this.y();
            d dVar = d.this;
            p pVar = dVar.K;
            if (!d.a(dVar, (int) ((pVar != null ? pVar.f17060s : 0L) / 1000))) {
                this.f13930b.a(d.this, IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT, 1402, "Invalid video duration.");
                return;
            }
            d.this.f13918x = new b.a() { // from class: sg.bigo.ads.ad.b.d.4.1
                @Override // sg.bigo.ads.core.player.b.a
                public final void a() {
                    if (d.this.f13919z.get() || AnonymousClass4.this.f13931c.bg() == 3 || AnonymousClass4.this.f13931c.bh() != null) {
                        sg.bigo.ads.common.t.a.a(0, 3, "onResourceDownloadBackup", "downloading or backup img is ready, stop to download img");
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "onResourceDownloadBackup", "begin to download backup img");
                    d.this.f13919z.set(true);
                    final Pair<Boolean, Boolean> pairD = d.this.D();
                    ArrayList arrayList = new ArrayList();
                    if (((Boolean) pairD.first).booleanValue()) {
                        arrayList.add(AnonymousClass4.this.f13931c.bm().f16997b);
                    }
                    String strAT = ((sg.bigo.ads.core.a.a) d.this.f()).aT();
                    if (!TextUtils.isEmpty(strAT) && URLUtil.isNetworkUrl(strAT)) {
                        arrayList.add(AnonymousClass4.this.f13931c.aT());
                    }
                    if (arrayList.size() == 0 && !((Boolean) pairD.second).booleanValue()) {
                        AnonymousClass4.this.f13931c.k(0);
                        return;
                    }
                    AnonymousClass4.this.f13931c.k(3);
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    sg.bigo.ads.common.p.e.a(d.this.f14024b.e, arrayList, anonymousClass4.f13931c.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.d.4.1.1
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i2, @NonNull String str, String str2) {
                            AnonymousClass4.this.f13931c.k(1);
                            if (((Boolean) pairD.second).booleanValue()) {
                                VideoController videoController = d.this.getVideoController();
                                if (videoController == null || videoController.getLoadHTMLCallback() == null) {
                                    AnonymousClass4.this.f13931c.bj();
                                } else {
                                    videoController.getLoadHTMLCallback().a();
                                }
                            }
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                            AnonymousClass4.this.f13931c.k(2);
                            AnonymousClass4.this.f13931c.a(new Pair<>(bitmap, fVar.e));
                            VideoController videoController = d.this.getVideoController();
                            if (videoController != null) {
                                videoController.notifyBackupResourceReady();
                            }
                        }
                    });
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void b(int i2) {
                    sg.bigo.ads.core.a.a aVar;
                    int i8;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    d dVar2 = d.this;
                    if (dVar2.e || dVar2.f14027f) {
                        return;
                    }
                    if (anonymousClass4.f13931c.aO()) {
                        aVar = AnonymousClass4.this.f13931c;
                        i8 = 3;
                    } else {
                        aVar = AnonymousClass4.this.f13931c;
                        i8 = 4;
                    }
                    aVar.h(i8);
                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                    anonymousClass42.f13930b.a(d.this, IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK, i2, "Failed to download media video.");
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(int i2) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    final d dVar2 = d.this;
                    final sg.bigo.ads.core.a.a aVar = anonymousClass4.f13931c;
                    if (!dVar2.G() && !dVar2.M && aVar != null && aVar.aR()) {
                        dVar2.M = true;
                        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.e.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    String strB = o.b(e.this.f14024b.e, aVar.aN());
                                    if (TextUtils.isEmpty(strB)) {
                                        return;
                                    }
                                    File file = new File(URI.create(strB));
                                    if (!file.exists() || file.length() <= 0) {
                                        return;
                                    }
                                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                                    e.this.y = sg.bigo.ads.common.w.b.a(bitmapDecodeFile);
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                    d.this.a("is_cache", Boolean.valueOf(i2 == 0));
                    AnonymousClass4.this.f13931c.ba();
                    d.a(d.this);
                    d dVar3 = d.this;
                    if (dVar3.e || dVar3.f14027f) {
                        return;
                    }
                    d.b(dVar3, i2);
                    AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                    anonymousClass42.f13930b.a(d.this);
                }

                @Override // sg.bigo.ads.core.player.b.a
                public final void a(String str, sg.bigo.ads.common.h.a aVar) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    d dVar2 = d.this;
                    if (dVar2.e || dVar2.f14027f) {
                        return;
                    }
                    anonymousClass4.f13931c.h(2);
                    if (AnonymousClass4.this.f13932d.x() != 1) {
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        anonymousClass42.f13930b.a(d.this, aVar.d(), IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, 10202, "video download failed and no backup creative resource.", true);
                    } else if (AnonymousClass4.this.f13931c.bh() != null || aVar.d()) {
                        AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                        anonymousClass43.f13930b.a(d.this);
                    } else {
                        sg.bigo.ads.core.d.b.a(AnonymousClass4.this.f13931c, aVar.f15728b, str, 0L, aVar.g / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, 2, MimeTypes.BASE_TYPE_VIDEO, aVar.f15734o);
                        AnonymousClass4 anonymousClass44 = AnonymousClass4.this;
                        anonymousClass44.f13930b.a(d.this, IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, 10202, "video download failed and no backup creative resource.");
                    }
                }
            };
            sg.bigo.ads.core.player.b bVarA = sg.bigo.ads.core.player.b.a();
            d dVar2 = d.this;
            bVarA.a(dVar2.f14024b.e, this.f13931c, dVar2.f13918x);
        }
    }

    public class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        AdInteractionListener f13936a;

        public a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f13936a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
            AdInteractionListener adInteractionListener = this.f13936a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(@NonNull AdError adError) {
            if (this.f13936a != null) {
                if (adError.getCode() == 2002 && d.this.n()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "don't call onAdError when video has impressed");
                } else {
                    this.f13936a.onAdError(adError);
                }
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f13936a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
            AdInteractionListener adInteractionListener = this.f13936a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdOpened();
            }
        }
    }

    public d(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.f13919z = new AtomicBoolean(false);
        this.X = new a();
        this.Z = new sg.bigo.ads.core.g.c() { // from class: sg.bigo.ads.ad.b.d.1
            @Override // sg.bigo.ads.core.g.c
            public final void a(String str, @Nullable Object obj, @Nullable int[] iArr) {
                d.a(d.this, str, obj, iArr);
            }

            @Override // sg.bigo.ads.core.g.c
            public final void a(String str, @Nullable int[] iArr) {
                d.a(d.this, str, iArr);
            }
        };
    }

    public static /* synthetic */ int a(d dVar, String str) {
        if (q.a((CharSequence) str)) {
            return 10074;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
        k kVarE = dVar.E();
        p pVarA = kVarE.a(dVar.f14024b.e, str);
        int i2 = kVarE.f17036a;
        String str2 = kVarE.f17038c;
        long j = kVarE.f17037b;
        if (i.f15457a.n().a(9) && URLUtil.isHttpUrl(str2)) {
            sg.bigo.ads.core.d.b.a(aVar, i2, str2, j, 10076, "Invalid http url");
            return 10076;
        }
        if (pVarA != null && pVarA.f17056n != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(pVarA.f17056n.f17018c.hashCode());
            pVarA.f17057o = sb.toString();
            dVar.J = new sg.bigo.ads.core.player.c(dVar.f14024b.e, pVarA, dVar.f14026d);
            aVar.a(pVarA);
            dVar.K = pVarA;
            dVar.D();
            sg.bigo.ads.core.d.b.a(aVar, i2, j);
            return 0;
        }
        sg.bigo.ads.core.f.a.e eVar = kVarE.f17039d;
        List<n> list = kVarE.e;
        if (eVar == null) {
            return 10075;
        }
        int i8 = eVar.f17023a;
        if (i8 != 10062) {
        }
        Context context = dVar.f14024b.e;
        sg.bigo.ads.core.f.a.f fVar = sg.bigo.ads.core.f.a.f.XML_PARSING_ERROR;
        sg.bigo.ads.core.player.c.a(context, list);
        sg.bigo.ads.core.d.b.a(aVar, i2, str2, j, i8, eVar.f17024b);
        return i8;
    }

    @Override // sg.bigo.ads.ad.b.c
    public final List<sg.bigo.ads.core.c.a> A() {
        List<sg.bigo.ads.core.c.a> list;
        p pVar = this.K;
        return (pVar == null || (list = pVar.C) == null || list.size() <= 0) ? super.A() : list;
    }

    @Override // sg.bigo.ads.ad.b.c
    public final boolean C() {
        return ((sg.bigo.ads.core.a.a) f()).aR();
    }

    public final Pair<Boolean, Boolean> D() {
        boolean z2;
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        Pair<Boolean, Boolean> pair = this.y;
        if (pair != null) {
            return pair;
        }
        p pVar = this.K;
        boolean z7 = false;
        if (pVar != null) {
            z2 = false;
            for (sg.bigo.ads.core.f.a.a aVar2 : pVar.A) {
                if (aVar2 != null) {
                    a.C0316a c0316aA = sg.bigo.ads.core.f.a.a.a(aVar2.f16995b);
                    if (!z7 && c0316aA != null && c0316aA.a()) {
                        aVar.a(c0316aA);
                        z7 = true;
                    }
                    a.C0316a c0316aA2 = sg.bigo.ads.core.f.a.a.a(aVar2.f16994a);
                    if (!z2 && c0316aA2 != null && c0316aA2.a()) {
                        aVar.b(c0316aA2);
                        z2 = true;
                    }
                }
            }
        } else {
            z2 = false;
        }
        Pair<Boolean, Boolean> pair2 = new Pair<>(Boolean.valueOf(z7), Boolean.valueOf(z2));
        this.y = pair2;
        return pair2;
    }

    @NonNull
    public k E() {
        int iG = this.f14024b.f15497b.g();
        h hVar = i.f15457a;
        return new k(iG, (hVar == null || hVar.r() == null) ? 0 : hVar.r().a());
    }

    @Override // sg.bigo.ads.ad.c
    public final void a_() {
        g gVar = this.Y;
        if (gVar == null || !gVar.a()) {
            super.a_();
            sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "BIGOAds impression method");
        }
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        VideoController videoController = getVideoController();
        if (videoController != null) {
            videoController.setVideoLifeCallback(null);
        }
        super.destroyInMainThread();
        sg.bigo.ads.core.player.c cVar = this.J;
        if (cVar != null) {
            if (cVar.f17373c && !cVar.f17372b) {
                cVar.f17372b = true;
            }
            p pVar = cVar.f17371a;
            if (pVar != null) {
                ArrayList<n> arrayList = pVar.l;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    n nVar = arrayList.get(i2);
                    i2++;
                    cVar.a(nVar, "va_des");
                }
            }
            sg.bigo.ads.common.t.a.a(0, 3, "AdTracker", "destroy");
            cVar.f17375f = null;
        }
        g gVar = this.Y;
        if (gVar != null) {
            sg.bigo.ads.core.player.b.d dVar = gVar.h;
            if (dVar != null) {
                u.b(dVar);
                gVar.h.d();
                gVar.h = null;
            }
            gVar.f13944a = null;
            gVar.f13946c = null;
            gVar.g = null;
            gVar.f13947d = null;
            this.Y = null;
        }
        this.f13918x = null;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.api.NativeAd
    public NativeAd.CreativeType getCreativeType() {
        return NativeAd.CreativeType.VIDEO;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.api.NativeAd
    @Nullable
    public VideoController getVideoController() {
        MediaView mediaView = this.F;
        if (mediaView != null) {
            return mediaView.getVideoController();
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public void h() {
        super.h();
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        sg.bigo.ads.core.player.c cVar = this.J;
        if (cVar != null) {
            if (!cVar.f17372b) {
                cVar.f17372b = true;
            }
            sg.bigo.ads.core.player.c.a(aVar, 1);
            ArrayList<n> arrayList = cVar.f17371a.f17050a;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                n nVar = arrayList.get(i2);
                i2++;
                cVar.a(nVar, "va_show");
            }
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    @CallSuper
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(this.X);
        this.X.f13936a = adInteractionListener;
    }

    public static /* synthetic */ void b(d dVar, int i2) {
        ((sg.bigo.ads.core.a.a) dVar.f()).h(i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 3 : 4 : 1);
    }

    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.c
    public final void a(Point point, int i2, int i8, @NonNull sg.bigo.ads.api.core.e eVar) {
        super.a(point, i2, i8, eVar);
        sg.bigo.ads.core.player.c cVar = this.J;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(@NonNull ViewGroup viewGroup, MediaView mediaView, @Nullable ImageView imageView, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list, int i2, @Nullable View... viewArr) {
        super.a(viewGroup, mediaView, imageView, adOptionsView, list, i2, viewArr);
        sg.bigo.ads.core.player.c cVar = this.J;
        if (cVar != null) {
            cVar.f17375f = ((c) this).D;
        }
    }

    public static /* synthetic */ void a(d dVar) {
        VideoController videoController = dVar.getVideoController();
        if (videoController != null) {
            videoController.notifyResourceReady();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static /* synthetic */ void a(d dVar, String str, Object obj, int[] iArr) {
        sg.bigo.ads.core.a.a aVar;
        d.a<T> aVar2;
        aVar = (sg.bigo.ads.core.a.a) dVar.f();
        str.getClass();
        switch (str) {
            case "AdLoaded":
                g gVar = dVar.Y;
                if (gVar != null && (aVar2 = gVar.e) != 0) {
                    aVar2.a(gVar.f13944a);
                    break;
                }
                break;
            case "AdVideoThirdQuartile":
                sg.bigo.ads.core.player.c cVar = dVar.J;
                if (cVar != null) {
                    Iterator<Integer> it = cVar.j.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        if (75 >= iIntValue) {
                            if (iIntValue == 75) {
                                sg.bigo.ads.core.c.b bVar = cVar.f17375f;
                                if (bVar != null) {
                                    bVar.a(b.EnumC0313b.f16859c);
                                }
                                iIntValue = 5;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue);
                            it.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVideoMidpoint":
                sg.bigo.ads.core.player.c cVar2 = dVar.J;
                if (cVar2 != null) {
                    Iterator<Integer> it2 = cVar2.j.iterator();
                    while (it2.hasNext()) {
                        int iIntValue2 = it2.next().intValue();
                        if (50 >= iIntValue2) {
                            if (iIntValue2 == 50) {
                                sg.bigo.ads.core.c.b bVar2 = cVar2.f17375f;
                                if (bVar2 != null) {
                                    bVar2.a(b.EnumC0313b.f16858b);
                                }
                                iIntValue2 = 4;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue2);
                            it2.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVideoFirstQuartile":
                sg.bigo.ads.core.player.c cVar3 = dVar.J;
                if (cVar3 != null) {
                    Iterator<Integer> it3 = cVar3.j.iterator();
                    while (it3.hasNext()) {
                        int iIntValue3 = it3.next().intValue();
                        if (25 >= iIntValue3) {
                            if (iIntValue3 == 25) {
                                sg.bigo.ads.core.c.b bVar3 = cVar3.f17375f;
                                if (bVar3 != null) {
                                    bVar3.a(b.EnumC0313b.f16857a);
                                }
                                iIntValue3 = 3;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue3);
                            it3.remove();
                        }
                    }
                    break;
                }
                break;
            case "AdVPAIDClickThru":
                if (iArr != null && iArr.length > 0) {
                    dVar.a(obj instanceof sg.bigo.ads.common.i ? (sg.bigo.ads.common.i) obj : null, 12, 5);
                    break;
                }
                break;
            case "AdError":
                g gVar2 = dVar.Y;
                if (gVar2 != null) {
                    String str2 = obj instanceof String ? (String) obj : "VPAID error";
                    d.a<T> aVar3 = gVar2.e;
                    if (aVar3 != 0) {
                        aVar3.a(gVar2.f13944a, 1006, 10222, str2);
                    }
                    break;
                }
                break;
            case "AdVPAIDImpression":
                g gVar3 = dVar.Y;
                if (gVar3 != null && gVar3.a()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "NativeVideoAdImpl", "vpaid impression method");
                    super.a_();
                    break;
                }
                break;
            case "AdVideoStart":
                sg.bigo.ads.core.player.c cVar4 = dVar.J;
                if (cVar4 != null) {
                    Iterator<Integer> it4 = cVar4.j.iterator();
                    while (it4.hasNext()) {
                        int iIntValue4 = it4.next().intValue();
                        if (iIntValue4 <= 0) {
                            if (iIntValue4 == 0) {
                                sg.bigo.ads.core.c.b bVar4 = cVar4.f17375f;
                                if (bVar4 != null) {
                                    bVar4.a(cVar4.f17371a.f17060s, cVar4.g ? 0.0f : 1.0f);
                                }
                                iIntValue4 = 2;
                            }
                            sg.bigo.ads.core.player.c.a(aVar, iIntValue4);
                            it4.remove();
                        }
                    }
                    break;
                }
                break;
        }
    }

    public static /* synthetic */ void a(d dVar, String str, int[] iArr) {
        VideoController videoController;
        VideoController.VideoLifeCallback videoLifeCallback;
        VideoController.d progressChangeListener;
        VideoController.a backupLoadCallback;
        sg.bigo.ads.core.a.a aVar;
        int i2;
        videoController = dVar.getVideoController();
        if (videoController != null) {
            videoLifeCallback = videoController.getVideoLifeCallback();
            progressChangeListener = videoController.getProgressChangeListener();
            backupLoadCallback = videoController.getBackupLoadCallback();
        } else {
            videoLifeCallback = null;
            progressChangeListener = null;
            backupLoadCallback = null;
        }
        aVar = (sg.bigo.ads.core.a.a) dVar.f();
        str.getClass();
        i2 = 0;
        switch (str) {
            case "AdClosed":
                sg.bigo.ads.core.player.c cVar = dVar.J;
                if (cVar != null) {
                    cVar.a(cVar.f17371a.e, "va_close");
                    break;
                }
                break;
            case "AdBackupImgReady":
                if (backupLoadCallback != null) {
                    backupLoadCallback.i(((iArr == null || iArr.length <= 0) ? 0 : iArr[0]) != 0);
                    break;
                }
                break;
            case "AdLoaded":
                sg.bigo.ads.core.player.c cVar2 = dVar.J;
                if (cVar2 != null) {
                    cVar2.f17373c = true;
                    break;
                }
                break;
            case "AdVideoBuffered":
                if (videoLifeCallback instanceof VideoController.b) {
                    ((VideoController.b) videoLifeCallback).b();
                    break;
                }
                break;
            case "AdVideoComplete":
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoEnd();
                }
                sg.bigo.ads.core.player.c cVar3 = dVar.J;
                if (cVar3 != null) {
                    cVar3.a(cVar3.f17371a.f17053d, "va_comp");
                    cVar3.a(cVar3.f17371a.f17051b, "va_prog1");
                    cVar3.a(cVar3.f17371a.f17052c, "va_prog2");
                    if (!cVar3.f17376i) {
                        cVar3.f17376i = true;
                        sg.bigo.ads.core.player.c.a(aVar, 6);
                        sg.bigo.ads.core.c.b bVar = cVar3.f17375f;
                        if (bVar != null) {
                            bVar.a(b.EnumC0313b.f16860d);
                        }
                    }
                }
                boolean z2 = dVar instanceof sg.bigo.ads.ad.b.a.b;
                if (((sg.bigo.ads.api.core.b.e(aVar.x()) && dVar.f14024b.f15497b.h()) || z2 || dVar.L) && videoController != null) {
                    videoController.play();
                    break;
                }
                break;
            case "AdVolumeChange":
                if (iArr != null && iArr.length > 0) {
                    int i8 = iArr[0];
                    if (videoLifeCallback != null) {
                        videoLifeCallback.onMuteChange(i8 == 0);
                    }
                    sg.bigo.ads.core.player.c cVar4 = dVar.J;
                    if (cVar4 != null) {
                        sg.bigo.ads.core.player.c.a(aVar, i8 == 0 ? 7 : 17);
                        p pVar = cVar4.f17371a;
                        if (pVar != null) {
                            Iterator<j> it = pVar.g.iterator();
                            while (it.hasNext()) {
                                j next = it.next();
                                if ((i8 == 0 && next.f17034a) || (i8 == 100 && !next.f17034a)) {
                                    cVar4.a(next, "va_mst");
                                    it.remove();
                                }
                            }
                        }
                        cVar4.g = i8 / 100 == 0;
                        sg.bigo.ads.core.c.b bVar2 = cVar4.f17375f;
                        if (bVar2 != null) {
                            float f4 = i8 / 100.0f;
                            MediaEvents mediaEvents = bVar2.f16845a;
                            if (mediaEvents != null && bVar2.f16846b) {
                                mediaEvents.volumeChange(f4);
                                bVar2.a("video volume change: ".concat(String.valueOf(f4)));
                                break;
                            }
                        }
                    }
                }
                break;
            case "AdSkipped":
                sg.bigo.ads.core.player.c cVar5 = dVar.J;
                if (cVar5 != null) {
                    cVar5.a(cVar5.f17371a.f17054f, "va_skip");
                    sg.bigo.ads.core.c.b bVar3 = cVar5.f17375f;
                    if (bVar3 != null) {
                        bVar3.b(b.a.e);
                    }
                    break;
                }
                break;
            case "AdError":
            case "AdVideoTooLate":
                sg.bigo.ads.core.player.c cVar6 = dVar.J;
                if (cVar6 != null) {
                    String str2 = sg.bigo.ads.core.f.a.f.GENERAL_LINEAR_AD_ERROR.g;
                    ArrayList<n> arrayList = cVar6.f17371a.k;
                    if (arrayList != null) {
                        Iterator<n> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            n next2 = it2.next();
                            String str3 = next2.f17045b;
                            if (q.a((CharSequence) str3) || (next2.f17046c && !next2.f17047d)) {
                                sg.bigo.ads.common.t.a.a(0, "VASTController", "invalidate tracking url or is tracked");
                            } else {
                                String strA = sg.bigo.ads.core.player.c.a(str3);
                                String strA2 = q.a((CharSequence) strA) ? "" : q.a(strA, "[ERRORCODE]", str2, false);
                                next2.f17046c = true;
                                if (!q.a((CharSequence) strA2)) {
                                    cVar6.e.a(cVar6.h, "va_err", strA2, "bigoad");
                                    a0.i(0, strA2, "Send track info, action: va_err, url: ", 3, "VASTController");
                                }
                            }
                            it2.remove();
                        }
                    }
                    sg.bigo.ads.core.player.c.a(aVar, 16);
                    if (iArr != null) {
                        dVar.a(2002, "Video error: " + iArr[0]);
                    }
                    break;
                }
                break;
            case "AdVideoPaused":
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPause();
                }
                sg.bigo.ads.core.player.c cVar7 = dVar.J;
                if (cVar7 != null) {
                    cVar7.f17374d = true;
                    ArrayList<n> arrayList2 = cVar7.f17371a.h;
                    int size = arrayList2.size();
                    while (i2 < size) {
                        n nVar = arrayList2.get(i2);
                        i2++;
                        cVar7.a(nVar, "va_pau");
                    }
                    sg.bigo.ads.core.c.b bVar4 = cVar7.f17375f;
                    if (bVar4 != null) {
                        bVar4.b(b.a.f16852a);
                    }
                    break;
                }
                break;
            case "AdVideoStart":
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoStart();
                    break;
                }
                break;
            case "AdVideoBuffering":
                if (videoLifeCallback instanceof VideoController.b) {
                    ((VideoController.b) videoLifeCallback).a();
                    break;
                }
                break;
            case "AdVideoPlaying":
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPlay();
                }
                sg.bigo.ads.core.player.c cVar8 = dVar.J;
                if (cVar8 != null && cVar8.f17374d) {
                    cVar8.f17374d = false;
                    ArrayList<n> arrayList3 = cVar8.f17371a.f17055i;
                    int size2 = arrayList3.size();
                    while (i2 < size2) {
                        n nVar2 = arrayList3.get(i2);
                        i2++;
                        cVar8.a(nVar2, "va_res");
                    }
                    sg.bigo.ads.core.c.b bVar5 = cVar8.f17375f;
                    if (bVar5 != null) {
                        bVar5.b(b.a.f16853b);
                    }
                    break;
                }
                break;
            case "AdRemainingTimeChange":
                if (iArr != null && iArr.length > 2) {
                    sg.bigo.ads.core.player.c cVar9 = dVar.J;
                    if (cVar9 != null && iArr.length > 2) {
                        int i9 = iArr[0];
                        int i10 = iArr[2];
                        Iterator<l> it3 = cVar9.f17371a.f17051b.iterator();
                        while (it3.hasNext()) {
                            l next3 = it3.next();
                            if (i10 >= next3.f17042a) {
                                cVar9.a(next3, "va_prog1");
                                it3.remove();
                            }
                        }
                        Iterator<sg.bigo.ads.core.f.a.c> it4 = cVar9.f17371a.f17052c.iterator();
                        while (it4.hasNext()) {
                            sg.bigo.ads.core.f.a.c next4 = it4.next();
                            if (i9 >= next4.f17021a) {
                                cVar9.a(next4, "va_prog2");
                                it4.remove();
                            }
                        }
                        Iterator<Integer> it5 = cVar9.k.iterator();
                        while (it5.hasNext()) {
                            int iIntValue = it5.next().intValue();
                            if (i9 >= iIntValue) {
                                if (iIntValue == 2000) {
                                    iIntValue = 11;
                                } else if (iIntValue == 3000) {
                                    iIntValue = 12;
                                } else if (iIntValue == 5000) {
                                    iIntValue = 13;
                                } else if (iIntValue == 8000) {
                                    iIntValue = 14;
                                } else if (iIntValue == 10000) {
                                    iIntValue = 15;
                                }
                                sg.bigo.ads.core.player.c.a(aVar, iIntValue);
                                it5.remove();
                            }
                        }
                        Iterator<Integer> it6 = cVar9.j.iterator();
                        while (it6.hasNext()) {
                            int iIntValue2 = it6.next().intValue();
                            if (i10 >= iIntValue2) {
                                if (iIntValue2 == 0) {
                                    sg.bigo.ads.core.c.b bVar6 = cVar9.f17375f;
                                    if (bVar6 != null) {
                                        bVar6.a(cVar9.f17371a.f17060s, cVar9.g ? 0.0f : 1.0f);
                                    }
                                    iIntValue2 = 2;
                                } else if (iIntValue2 == 25) {
                                    sg.bigo.ads.core.c.b bVar7 = cVar9.f17375f;
                                    if (bVar7 != null) {
                                        bVar7.a(b.EnumC0313b.f16857a);
                                    }
                                    iIntValue2 = 3;
                                } else if (iIntValue2 == 50) {
                                    sg.bigo.ads.core.c.b bVar8 = cVar9.f17375f;
                                    if (bVar8 != null) {
                                        bVar8.a(b.EnumC0313b.f16858b);
                                    }
                                    iIntValue2 = 4;
                                } else if (iIntValue2 == 75) {
                                    sg.bigo.ads.core.c.b bVar9 = cVar9.f17375f;
                                    if (bVar9 != null) {
                                        bVar9.a(b.EnumC0313b.f16859c);
                                    }
                                    iIntValue2 = 5;
                                }
                                sg.bigo.ads.core.player.c.a(aVar, iIntValue2);
                                it6.remove();
                            }
                        }
                    }
                    if (progressChangeListener != null) {
                        progressChangeListener.a(iArr[0], iArr[1]);
                    }
                    break;
                }
                break;
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public void a(@Nullable MediaView mediaView) {
        g gVar;
        if (this.K == null || mediaView == null) {
            return;
        }
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) f();
        if (!aVar.aS() || (gVar = this.Y) == null) {
            mediaView.a(aVar, this.K, this.Z);
            VideoController videoController = mediaView.getVideoController();
            if (videoController != null) {
                videoController.mute(this.f14024b.f15497b.i());
                return;
            }
            return;
        }
        boolean zI = this.f14024b.f15497b.i();
        if (gVar.f13947d != null) {
            mediaView.a(gVar.h);
            VideoController videoController2 = mediaView.getVideoController();
            if (videoController2 != null) {
                videoController2.mute(zI);
            }
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public void a(@NonNull final d.a<NativeAd> aVar, int i2) {
        sg.bigo.ads.api.a.j jVarN;
        final sg.bigo.ads.api.core.c cVar = this.f14024b.f15496a;
        if (!(cVar instanceof sg.bigo.ads.core.a.a)) {
            aVar.a(this, IronSourceError.ERROR_RV_LOAD_FAIL_UNEXPECTED, 1400, "NativeVideo with invalid AdData class type.");
            return;
        }
        o.c cVarAy = ((sg.bigo.ads.core.a.a) cVar).ay();
        if (cVarAy == null) {
            aVar.a(this, IronSourceError.ERROR_RV_LOAD_FAIL_WRONG_AUCTION_ID, 1401, "Missing media video.");
            return;
        }
        final String strC = cVarAy.c();
        h hVar = i.f15457a;
        if (hVar == null || (jVarN = hVar.n()) == null || !jVarN.a(14)) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.a(aVar, cVar, d.a(d.this, strC), false);
                }
            });
        } else {
            sg.bigo.ads.common.u.a.e.f().execute(new Runnable() { // from class: sg.bigo.ads.ad.b.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.a(aVar, cVar, d.a(d.this, strC), true);
                }
            });
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(@NonNull d.a<NativeAd> aVar, @NonNull sg.bigo.ads.api.core.c cVar, int i2, boolean z2) {
        m mVarE;
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) f();
        if (!aVar2.aS()) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(i2, aVar, aVar2, cVar);
            if (z2) {
                sg.bigo.ads.common.n.d.a(1, anonymousClass4);
                return;
            } else {
                anonymousClass4.run();
                return;
            }
        }
        this.W.f15524a = aVar2.bo();
        g gVar = new g(this.f14024b.e, this.Z, aVar2, this.K, aVar, this);
        this.Y = gVar;
        int iX = gVar.f13946c.x();
        if (iX == 1 || iX == 2 || !(iX == 3 || iX == 4 || (iX == 12 ? !((mVarE = gVar.f13946c.e()) == null || 6 != mVarE.a("video_play_page.ad_component_layout", 1)) : iX == 20))) {
            gVar.e.a(gVar.f13944a, 1006, 10066, "Failed to support VPAID.");
            return;
        }
        g.AnonymousClass1 anonymousClass1 = new g.AnonymousClass1(i2);
        if (z2) {
            sg.bigo.ads.common.n.d.a(1, anonymousClass1);
        } else {
            anonymousClass1.run();
        }
    }

    public static /* synthetic */ boolean a(d dVar, int i2) {
        return ((sg.bigo.ads.core.a.a) dVar.f()).x() != 4 || i2 >= 5;
    }
}
