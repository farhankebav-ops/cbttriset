package sg.bigo.ads.controller.loader;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.b.d;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.f;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.controller.e.a;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractAdLoader<U extends Ad, T extends sg.bigo.ads.api.b> implements AdLoader<T>, d.a<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f16735a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, List<a>> f16736b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final f<U> f16737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16738d;

    public abstract class a implements sg.bigo.ads.controller.d<U> {

        @Nullable
        c[] e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        c[] f16774f;
        String h;

        @Nullable
        a.C0306a<sg.bigo.ads.api.b> j;
        sg.bigo.ads.api.b k;
        final AbstractAdLoader l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f16772c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f16773d = false;
        boolean g = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16771a = false;
        final Runnable m = new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.a.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The request is timeout.");
                a aVar = a.this;
                a.C0306a<sg.bigo.ads.api.b> c0306a = aVar.j;
                if (c0306a == null || aVar.g) {
                    return;
                }
                aVar.f16772c = true;
                c0306a.f16578c = true;
                if (c0306a.f16580f == 0) {
                    c0306a.f16580f = c0306a.e;
                }
                if (k.a(aVar.e)) {
                    a aVar2 = a.this;
                    sg.bigo.ads.controller.loader.a.a(aVar2.e, aVar2.j.f16580f);
                    a aVar3 = a.this;
                    int i2 = aVar3.f16772c ? 2 : aVar3.f16773d ? 4 : 1;
                    a.C0306a<sg.bigo.ads.api.b> c0306a2 = aVar3.j;
                    sg.bigo.ads.controller.loader.a.a(aVar3.e, i2, c0306a2 == null ? 1 : c0306a2.f16580f, true);
                }
                AbstractAdLoader<U, T>.a aVar4 = a.this;
                AbstractAdLoader.this.a(aVar4, 1011, 10206, "Ad request is timeout due to bad network.", new Pair<>(aVar4.j.f16576a, null));
            }
        };

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f16775i = SystemClock.elapsedRealtime();

        public a(AbstractAdLoader abstractAdLoader, sg.bigo.ads.api.b bVar, String str) {
            this.h = str;
            this.l = abstractAdLoader;
            this.k = bVar;
        }

        public final void a() {
            sg.bigo.ads.common.n.d.a(this.m);
            if (this.f16771a) {
                return;
            }
            this.f16771a = true;
            StringBuilder sb = new StringBuilder("Remove timeout task for session id: ");
            a.C0306a<sg.bigo.ads.api.b> c0306a = this.j;
            a0.g(0, 3, c0306a == null ? "unknown" : c0306a.f16576a.g.f15464b, "AbstractAdLoader", sb);
        }

        public final String b() {
            a.C0306a<sg.bigo.ads.api.b> c0306a = this.j;
            String str = c0306a == null ? null : c0306a.f16576a.f15458a;
            return TextUtils.isEmpty(str) ? this.h : str;
        }
    }

    public interface b<U extends Ad, T extends sg.bigo.ads.api.b> extends d.a<U> {
        AbstractAdLoader<U, T> a();
    }

    public AbstractAdLoader(AdLoadListener<U> adLoadListener, String str) {
        if (adLoadListener == null) {
            this.f16737c = new f<>();
        } else {
            this.f16737c = new f<>(adLoadListener);
        }
        this.f16738d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, AbstractAdLoader<U, T>.a aVar) {
        List<a> list;
        if (TextUtils.isEmpty(str) || (list = f16736b.get(str)) == null || list.size() <= 0) {
            return;
        }
        list.remove(aVar);
    }

    private boolean b(final T t3) {
        String[] strArrSplit;
        String str;
        boolean zIsInitialized = BigoAdSdk.isInitialized();
        boolean z2 = !zIsInitialized;
        if (!zIsInitialized) {
            Activity activityB = sg.bigo.ads.common.f.b.b();
            applicationContext = activityB != null ? activityB.getApplicationContext() : null;
            if (applicationContext == null) {
                applicationContext = sg.bigo.ads.common.f.b.a();
            }
            z2 = applicationContext != null;
        }
        String str2 = "";
        if (z2) {
            String str3 = t3.f15458a;
            if (str3 != null && !str3.isEmpty() && (strArrSplit = str3.split("-")) != null && strArrSplit.length >= 2 && (str = strArrSplit[0]) != null && !str.isEmpty()) {
                str2 = strArrSplit[0];
            }
            z2 = (str2 == null || str2.isEmpty()) ? false : true;
        }
        if (z2) {
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Initialize bigo sdk before requesting ad.");
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        AbstractAdLoader.this.a(t3);
                    }
                }
            }, 1000L);
            try {
                AdConfig.Builder builder = new AdConfig.Builder();
                builder.setAppId(str2);
                BigoAdSdk.initialize(applicationContext.getApplicationContext(), builder.build(), new BigoAdSdk.InitListener() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.3
                    @Override // sg.bigo.ads.BigoAdSdk.InitListener
                    public final void onInitialized() {
                        sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "Bigo ads sdk initialized before ad load.");
                        if (atomicBoolean.compareAndSet(false, true)) {
                            AbstractAdLoader.this.a(t3);
                        }
                    }
                });
                return z2;
            } catch (Exception unused) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    a(t3);
                }
            }
        }
        return z2;
    }

    public U a(@NonNull sg.bigo.ads.api.b bVar, g... gVarArr) {
        return null;
    }

    @Keep
    @CallSuper
    public void loadAd(T t3) {
        if (b(t3)) {
            return;
        }
        a(t3);
    }

    public U a(g gVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, AbstractAdLoader<U, T>.a aVar, U u2, int i2, int i8, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f16735a.remove(str);
        }
        aVar.a();
        aVar.g = true;
        b(aVar.b(), aVar);
        if (aVar.f16772c || aVar.f16773d) {
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The error ad has been timeout or assign");
        } else {
            a(str, aVar, sg.bigo.ads.controller.loader.a.a(u2), 0, i2, i8, str2, false, u2);
            a(u2, i2, i8, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final AbstractAdLoader<U, T>.a aVar, final c[] cVarArr, final int i2, final int i8, final int i9, final String str2, final boolean z2, final Ad ad) {
        boolean zC;
        String strD;
        h hVar;
        if (TextUtils.isEmpty(str)) {
            str = aVar.b();
        }
        final String str3 = str;
        if (TextUtils.isEmpty(str3) || (hVar = i.f15457a) == null) {
            zC = false;
            strD = null;
        } else {
            sg.bigo.ads.api.a.b bVarQ = hVar.q();
            zC = bVarQ.c(str3);
            strD = bVarQ.d(str3);
        }
        final String str4 = strD;
        final boolean z7 = zC;
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.7
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:102:0x0148  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x014b  */
            /* JADX WARN: Removed duplicated region for block: B:111:0x016c  */
            /* JADX WARN: Removed duplicated region for block: B:116:0x0178  */
            /* JADX WARN: Removed duplicated region for block: B:118:0x017c  */
            /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
            /* JADX WARN: Removed duplicated region for block: B:123:0x018e  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:94:0x0129  */
            /* JADX WARN: Removed duplicated region for block: B:96:0x0133  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 405
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.loader.AbstractAdLoader.AnonymousClass7.run():void");
            }
        });
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u2) {
        a((Ad) u2, true);
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u2, int i2, int i8, String str) {
        if (u2 instanceof sg.bigo.ads.api.b.a) {
            ((sg.bigo.ads.api.b.a) u2).a(i2, i8, str);
        }
        sg.bigo.ads.common.t.a.a(2, 5, "", "Failed to load ads: (" + i2 + ") " + str);
        this.f16737c.onError(new AdError(i2, str));
    }

    public final void a(Ad ad, boolean z2) {
        boolean z7 = ad instanceof sg.bigo.ads.api.b.a;
        if (z7) {
            ((sg.bigo.ads.api.b.a) ad).b();
        }
        if (z2) {
            if (z7) {
                ((sg.bigo.ads.api.b.a) ad).c();
            }
            this.f16737c.onAdLoaded(ad);
        }
    }

    @Override // sg.bigo.ads.api.b.d.a
    public final void a(U u2, boolean z2, int i2, int i8, String str, boolean z7) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final l lVar, final String str, @NonNull final AbstractAdLoader<U, T>.a aVar, final Ad ad) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.4
            @Override // java.lang.Runnable
            public final void run() {
                if (aVar.f16772c) {
                    b.a.f13844a.a(lVar, ad);
                    a.C0306a<sg.bigo.ads.api.b> c0306a = aVar.j;
                    StringBuilder sbY = a1.a.y("The request has been timeout before get ad from cache for session id: ", c0306a == null ? "unknown" : c0306a.f16576a.g.f15464b, ", ad: ");
                    sbY.append(String.valueOf(ad));
                    sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", sbY.toString());
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    AbstractAdLoader.f16735a.remove(str);
                }
                a.C0306a<sg.bigo.ads.api.b> c0306a2 = aVar.j;
                sg.bigo.ads.controller.loader.a.a(ad, c0306a2 == null ? "0" : c0306a2.f16576a.g.f15464b);
                a aVar2 = aVar;
                a.C0306a<sg.bigo.ads.api.b> c0306a3 = aVar2.j;
                if (c0306a3 != null) {
                    c0306a3.f16579d = true;
                    if (c0306a3.f16580f == 0) {
                        c0306a3.f16580f = c0306a3.e;
                    }
                }
                aVar2.g = true;
                AbstractAdLoader.b(str, aVar2);
                aVar.a();
                aVar.f16773d = true;
                c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
                a aVar3 = aVar;
                aVar3.f16774f = cVarArrA;
                a.C0306a<sg.bigo.ads.api.b> c0306a4 = aVar3.j;
                sg.bigo.ads.controller.loader.a.a(cVarArrA, 4, c0306a4 == null ? 1 : c0306a4.f16580f, true);
                AbstractAdLoader.this.a(str, aVar, cVarArrA, 1, 0, 0, null, true, ad);
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        aVar.l.a(ad, true);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(T r14) {
        /*
            r13 = this;
            r0 = 0
            r14.f15460c = r0
            java.lang.String r1 = r13.f16738d
            r14.a(r1)
            java.lang.String r6 = r14.f15458a
            sg.bigo.ads.controller.loader.AbstractAdLoader$1 r2 = new sg.bigo.ads.controller.loader.AbstractAdLoader$1
            r4 = r13
            r7 = r6
            r3 = r13
            r5 = r14
            r2.<init>(r4, r5, r6)
            boolean r14 = a(r6)
            if (r14 == 0) goto L2b
            android.util.Pair r12 = new android.util.Pair
            r14 = 0
            r12.<init>(r5, r14)
            r9 = 1012(0x3f4, float:1.418E-42)
            r10 = 10213(0x27e5, float:1.4311E-41)
            java.lang.String r11 = "The ad is loading"
            r7 = r13
            r8 = r2
            r7.a(r8, r9, r10, r11, r12)
            return
        L2b:
            boolean r14 = android.text.TextUtils.isEmpty(r6)
            if (r14 != 0) goto L3e
            java.util.Map<java.lang.String, java.lang.Long> r14 = sg.bigo.ads.controller.loader.AbstractAdLoader.f16735a
            long r3 = android.os.SystemClock.elapsedRealtime()
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r14.put(r6, r1)
        L3e:
            boolean r14 = android.text.TextUtils.isEmpty(r6)
            r1 = 3
            java.lang.String r3 = "AbstractAdLoader"
            r7 = -1
            if (r14 != 0) goto L76
            sg.bigo.ads.api.a.h r14 = sg.bigo.ads.api.a.i.f15457a
            if (r14 == 0) goto L76
            sg.bigo.ads.api.a.b r14 = r14.q()
            boolean r4 = r14.b(r6)
            if (r4 == 0) goto L76
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<sg.bigo.ads.controller.loader.AbstractAdLoader$a>> r4 = sg.bigo.ads.controller.loader.AbstractAdLoader.f16736b
            java.lang.Object r9 = r4.get(r6)
            java.util.List r9 = (java.util.List) r9
            if (r9 != 0) goto L69
            java.util.concurrent.CopyOnWriteArrayList r9 = new java.util.concurrent.CopyOnWriteArrayList
            r9.<init>()
            r4.put(r6, r9)
        L69:
            r9.add(r0, r2)
            long r9 = r14.e(r6)
            java.lang.String r14 = "Prepare for ad load, the tmax switch is on."
            sg.bigo.ads.common.t.a.a(r0, r1, r3, r14)
            goto L77
        L76:
            r9 = r7
        L77:
            sg.bigo.ads.controller.e.a$a r14 = sg.bigo.ads.BigoAdSdk.a(r5, r2)
            if (r14 == 0) goto L9c
            r2.j = r14
            int r14 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r14 <= 0) goto L9c
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r4 = "Start timeout task for "
            r14.<init>(r4)
            r14.append(r9)
            java.lang.String r4 = "s"
            r14.append(r4)
            java.lang.String r14 = r14.toString()
            sg.bigo.ads.common.t.a.a(r0, r1, r3, r14)
            a(r2, r9)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.loader.AbstractAdLoader.a(sg.bigo.ads.api.b):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(AbstractAdLoader<U, T>.a aVar, int i2, int i8, @NonNull String str, @Nullable Pair<sg.bigo.ads.api.b, l> pair) {
        l lVar;
        sg.bigo.ads.api.b bVar;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int i13;
        int i14;
        String str2;
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        if (pair != null) {
            bVar = (sg.bigo.ads.api.b) pair.first;
            lVar = (l) pair.second;
        } else {
            lVar = null;
            bVar = null;
        }
        if (bVar != null) {
            bVar.g.a();
        }
        String strL = lVar != null ? lVar.l() : null;
        if (TextUtils.isEmpty(strL) && bVar != null) {
            strL = bVar.f15458a;
        }
        if (TextUtils.isEmpty(strL)) {
            strL = aVar.h;
        }
        boolean z7 = i8 == 10213;
        if (!z7 && !TextUtils.isEmpty(strL)) {
            f16735a.remove(strL);
        }
        boolean z8 = i2 == 1011;
        boolean z9 = i8 == 10206;
        if (z9) {
            i9 = 3;
        } else {
            if (z7) {
                i10 = 3;
            } else if (aVar.f16772c) {
                i10 = 2;
            } else {
                i10 = aVar.f16773d ? 4 : 1;
            }
            a.C0306a<sg.bigo.ads.api.b> c0306a = aVar.j;
            int i15 = c0306a != null ? c0306a.f16580f : 0;
            int i16 = (c0306a == null || (qVar4 = c0306a.g) == null) ? 3 : qVar4.f15525a ? 1 : 0;
            if (c0306a == null || (qVar3 = c0306a.g) == null || !qVar3.f15526b) {
                i11 = 4;
                i12 = i15;
                z2 = false;
            } else {
                i11 = 4;
                i12 = i15;
                z2 = true;
            }
            if (c0306a != null && (qVar2 = c0306a.g) != null) {
                i11 = qVar2.f15527c;
            }
            if (c0306a == null || (qVar = c0306a.g) == null) {
                i13 = i16;
                i14 = i11;
                str2 = null;
            } else {
                i13 = i16;
                i14 = i11;
                str2 = qVar.f15528d;
            }
            i9 = 3;
            sg.bigo.ads.core.d.b.a(lVar, bVar, i2, i8, str, i10, i12, i13, z2, i14, str2);
        }
        aVar.a();
        aVar.g = true;
        b(aVar.b(), aVar);
        if (!z9 && (aVar.f16772c || aVar.f16773d || z8)) {
            sg.bigo.ads.common.t.a.a(0, i9, "AbstractAdLoader", "The error ad has been timeout or assign");
        } else {
            a(strL, aVar, null, 0, i2, i8, str, false, null);
            this.f16737c.onError(new AdError(i2, str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CallSuper
    public final void a(final AbstractAdLoader<U, T>.a aVar, final int i2, final l lVar, @NonNull sg.bigo.ads.api.b bVar, @NonNull g... gVarArr) {
        Ad adA = bVar.e() ? a(bVar, gVarArr) : a((g) k.b(gVarArr));
        if (adA == null) {
            a(aVar.b(), (AbstractAdLoader<U, T>.a) aVar, (Ad) null, 1005, 1009, "Unmatched ad type.");
            return;
        }
        if (!(adA instanceof d)) {
            a(lVar == null ? null : lVar.l(), (AbstractAdLoader<U, T>.a) aVar, adA, 1024, 1010, "Unknown ad.");
            return;
        }
        a.C0306a<sg.bigo.ads.api.b> c0306a = aVar.j;
        if (c0306a != null) {
            c0306a.e = 3;
        }
        c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(adA);
        int i8 = aVar.f16772c ? 2 : aVar.f16773d ? 4 : 1;
        a.C0306a<sg.bigo.ads.api.b> c0306a2 = aVar.j;
        sg.bigo.ads.controller.loader.a.a(cVarArrA, i8, c0306a2 == null ? 0 : c0306a2.f16580f, false);
        ((d) adA).a(new b<U, T>() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.5
            @Override // sg.bigo.ads.controller.loader.AbstractAdLoader.b
            public final AbstractAdLoader<U, T> a() {
                return AbstractAdLoader.this;
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(final U u2) {
                final AbstractAdLoader abstractAdLoader = AbstractAdLoader.this;
                final a aVar2 = aVar;
                final int i9 = i2;
                final l lVar2 = lVar;
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.loader.AbstractAdLoader.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        l lVar3 = lVar2;
                        String strL = lVar3 == null ? null : lVar3.l();
                        if (!TextUtils.isEmpty(strL)) {
                            AbstractAdLoader.f16735a.remove(strL);
                        }
                        a aVar3 = aVar2;
                        aVar3.g = true;
                        AbstractAdLoader.b(strL, aVar3);
                        aVar2.a();
                        AbstractAdLoader<U, T>.a aVar4 = aVar2;
                        if (aVar4.f16772c) {
                            AbstractAdLoader.this.a(aVar4, lVar2, u2, 1);
                        } else if (aVar4.f16773d) {
                            AbstractAdLoader.this.a(aVar4, lVar2, u2, 2);
                        } else {
                            AbstractAdLoader.this.a(strL, aVar4, sg.bigo.ads.controller.loader.a.a(u2), 1, 0, 0, null, true, u2);
                            AbstractAdLoader.this.a(u2, true);
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(U u2, int i9, int i10, String str) {
                AbstractAdLoader abstractAdLoader = AbstractAdLoader.this;
                l lVar2 = lVar;
                abstractAdLoader.a(lVar2 == null ? null : lVar2.l(), aVar, u2, i9, i10, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final void a(U u2, boolean z2, int i9, int i10, String str, boolean z7) {
            }
        });
    }

    private static void a(AbstractAdLoader<U, T>.a aVar, long j) {
        sg.bigo.ads.common.n.d.a(3, aVar.m, j * 1000);
    }

    @CallSuper
    public final void a(AbstractAdLoader<U, T>.a aVar, l lVar, @NonNull Ad ad, int i2) {
        List<a> list;
        a.C0306a<sg.bigo.ads.api.b> c0306a = aVar.j;
        String str = c0306a == null ? "unknown" : c0306a.f16576a.g.f15464b;
        a0.i(0, str, "The ad timeout for session id: ", 3, "AbstractAdLoader");
        if (lVar != null) {
            String strL = lVar.l();
            if (TextUtils.isEmpty(strL)) {
                strL = aVar.b();
            }
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
            for (int i8 = 0; cVarArrA != null && i8 < cVarArrA.length; i8++) {
                c cVar = cVarArrA[i8];
                cVar.T();
                cVar.c(i2);
                cVar.S();
            }
            a aVarRemove = (TextUtils.isEmpty(strL) || (list = f16736b.get(strL)) == null || list.size() <= 0) ? null : list.remove(0);
            if (aVarRemove != null) {
                a(lVar, strL, aVarRemove, ad);
                a0.i(0, str, "The timeout ad fill to another request for session id: ", 3, "AbstractAdLoader");
                return;
            }
            StringBuilder sbY = a1.a.y("The timeout ad put in cache for session id: ", str, ", ad: ");
            sbY.append(String.valueOf(ad));
            sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", sbY.toString());
            a(ad, false);
            b.a.f13844a.a(lVar, ad);
        }
    }

    private static boolean a(String str) {
        h hVar;
        if (!TextUtils.isEmpty(str) && (hVar = i.f15457a) != null && hVar.q().i(str)) {
            long j = i.f15457a.q().j(str);
            if (j < 0) {
                return false;
            }
            if (j == 0 && f16735a.containsKey(str)) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The slot request stop due to single ad mode.");
                return true;
            }
            long j3 = j * 1000;
            Long l = f16735a.get(str);
            if (l != null && SystemClock.elapsedRealtime() - l.longValue() < j3) {
                sg.bigo.ads.common.t.a.a(0, 3, "AbstractAdLoader", "The slot request stop due to single ad mode.");
                return true;
            }
        }
        return false;
    }
}
