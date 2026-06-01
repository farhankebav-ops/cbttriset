package sg.bigo.ads;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.mimikridev.ads.gdpr.GDPR;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.c;
import sg.bigo.ads.common.m;
import sg.bigo.ads.common.n.d;
import sg.bigo.ads.common.n.e;
import sg.bigo.ads.common.p.h;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.controller.e.a;
import sg.bigo.ads.controller.e.e;
import sg.bigo.ads.controller.e.f;
import sg.bigo.ads.core.player.b;

/* JADX INFO: loaded from: classes4.dex */
public class BigoAdSdk {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static sg.bigo.ads.controller.e.a f13764d;
    private static volatile a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f13761a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f13762b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f13763c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CopyOnWriteArrayList<InitListener> f13765f = new CopyOnWriteArrayList<>();
    private static final List<Pair<String, String>> g = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.BigoAdSdk$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13772a;

        static {
            int[] iArr = new int[ConsentOptions.values().length];
            f13772a = iArr;
            try {
                iArr[ConsentOptions.LGPD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13772a[ConsentOptions.GDPR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13772a[ConsentOptions.CCPA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13772a[ConsentOptions.COPPA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface InitListener {
        void onInitialized();
    }

    public static void addExtraHost(@Nullable final String str, @Nullable final String str2) {
        d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.3
            @Override // java.lang.Runnable
            public final void run() {
                if (BigoAdSdk.f13764d == null || !BigoAdSdk.f13761a.get()) {
                    BigoAdSdk.g.add(Pair.create(str, str2));
                } else {
                    BigoAdSdk.f13764d.a(str, str2);
                }
            }
        });
    }

    @Nullable
    public static String getBidderToken() {
        String str;
        String str2;
        if (!f13761a.get()) {
            str = "BigoAdSdk";
            str2 = "Please initialize SDK before get bidder token.";
        } else {
            if (f13764d != null) {
                if (f13763c.compareAndSet(true, false)) {
                    sg.bigo.ads.controller.e.a aVar = f13764d;
                    f fVar = aVar.g;
                    if (fVar == null) {
                        fVar = new f();
                        aVar.g = fVar;
                    }
                    if (fVar.f16622a != null) {
                        synchronized (f.class) {
                            fVar.f16622a = null;
                        }
                    }
                }
                sg.bigo.ads.controller.e.a aVar2 = f13764d;
                if (aVar2.e == null) {
                    return null;
                }
                f fVar2 = aVar2.g;
                if (fVar2 == null) {
                    fVar2 = new f();
                    aVar2.g = fVar2;
                }
                sg.bigo.ads.controller.e.d dVar = aVar2.e;
                f.f16621b = true;
                h hVar = i.f15457a;
                int iW = hVar != null ? hVar.w() : 0;
                return iW != 1 ? iW != 2 ? fVar2.a(dVar) : (fVar2.f16622a == null || fVar2.f16623c == 0 || System.currentTimeMillis() - fVar2.f16623c > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) ? fVar2.b(dVar) : fVar2.a(dVar) : fVar2.b(dVar);
            }
            str = "BigoAdSdk";
            str2 = "Error to get bidder token with empty controller.";
        }
        sg.bigo.ads.common.t.a.a(0, str, str2);
        return null;
    }

    @NonNull
    public static String getHashId() {
        return "ad68540";
    }

    @NonNull
    public static String getSDKVersion() {
        return "50501";
    }

    @NonNull
    public static String getSDKVersionName() {
        return "5.5.1";
    }

    public static void initialize(@NonNull Context context, @NonNull AdConfig adConfig, @Nullable InitListener initListener) {
        boolean z2 = f13761a.get();
        boolean z7 = !z2;
        if (z2) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Bigo Ads SDK init had been invoked.");
        }
        if (sg.bigo.ads.controller.e.c.a().f16587b.get() == -1) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Bigo Ads SDK wait to initing due to empty config.");
            z7 = true;
        }
        if (!z7) {
            sg.bigo.ads.common.t.a.a(2, 5, "", "Avoid initializing Bigo Ads SDK repeatedly.");
            if (initListener != null) {
                initListener.onInitialized();
                return;
            }
            return;
        }
        if (initListener != null) {
            f13765f.add(initListener);
        }
        m.a(context);
        m.a(adConfig);
        Context applicationContext = context.getApplicationContext();
        m.a(applicationContext);
        if (f13762b.getAndSet(true)) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsDebug = adConfig.isDebug();
        sg.bigo.ads.common.y.a.a((int) (System.currentTimeMillis() / 1000));
        sg.bigo.ads.common.x.b.f16251a = applicationContext;
        sg.bigo.ads.common.m.b.a(applicationContext);
        sg.bigo.ads.common.d.a.a().a(applicationContext);
        b(context);
        t.a(zIsDebug);
        final String extra = adConfig.getExtra(AdConfig.EXTRA_KEY_HOST_RULES);
        final sg.bigo.ads.controller.e.a aVar = new sg.bigo.ads.controller.e.a(applicationContext, adConfig);
        f13764d = aVar;
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.1
            @Override // java.lang.Runnable
            public final void run() {
                BigoAdSdk.f13761a.set(true);
                BigoAdSdk.f13762b.set(false);
                BigoAdSdk.a(extra);
                sg.bigo.ads.common.t.a.a(2, 4, "", "Initialized Bigo Ads SDK successfully.");
                for (InitListener initListener2 : BigoAdSdk.f13765f) {
                    if (initListener2 != null) {
                        initListener2.onInitialized();
                    }
                }
                BigoAdSdk.f13765f.clear();
                if (c.a.a().isEmpty()) {
                    return;
                }
                d.a(3, new Runnable() { // from class: sg.bigo.ads.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        sg.bigo.ads.core.d.b.c(a.c());
                        a.b();
                    }
                });
            }
        };
        aVar.j = jElapsedRealtime;
        aVar.e.f16588a = adConfig;
        aVar.g = new f();
        d.a(new sg.bigo.ads.common.n.a() { // from class: sg.bigo.ads.controller.e.a.4
            @Override // sg.bigo.ads.common.n.a
            public final void a(Throwable th) {
                sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(th));
            }
        });
        d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.5
            /* JADX WARN: Removed duplicated region for block: B:24:0x0225  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x022b  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0253  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0259  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x02a1  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x02a6  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x02f2  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0390  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x03a5  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 942
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.e.a.AnonymousClass5.run():void");
            }
        });
        e.a(new sg.bigo.ads.common.n.a() { // from class: sg.bigo.ads.controller.e.a.6
            @Override // sg.bigo.ads.common.n.a
            public final void a(Throwable th) {
                String name = Thread.currentThread().getName();
                if (name.contains("ReportNet") || name.contains("Stat-Worker")) {
                    return;
                }
                sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(th));
            }
        });
    }

    public static boolean isInitialized() {
        return f13761a.get();
    }

    public static boolean isOffice() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setUserConsent(@androidx.annotation.NonNull final android.content.Context r4, @androidx.annotation.NonNull final sg.bigo.ads.ConsentOptions r5, final boolean r6) {
        /*
            boolean r0 = sg.bigo.ads.common.x.b.a()
            if (r0 != 0) goto Lc
            android.content.Context r0 = r4.getApplicationContext()
            sg.bigo.ads.common.x.b.f16251a = r0
        Lc:
            boolean r0 = sg.bigo.ads.common.m.b.a()
            if (r0 != 0) goto L19
            android.content.Context r0 = r4.getApplicationContext()
            sg.bigo.ads.common.m.b.a(r0)
        L19:
            sg.bigo.ads.c$1 r0 = new sg.bigo.ads.c$1
            r0.<init>()
            r1 = 3
            sg.bigo.ads.common.n.d.a(r1, r0)
            sg.bigo.ads.ConsentOptions r0 = sg.bigo.ads.ConsentOptions.GDPR
            r1 = 4
            java.lang.String r2 = ""
            r3 = 2
            if (r5 != r0) goto L41
            sg.bigo.ads.common.x.a.a(r6)
            boolean r0 = sg.bigo.ads.common.m.b.e(r4)
            if (r0 == 0) goto L41
            java.lang.String r4 = "Filter the consent status from user: "
        L35:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r4 = r4.concat(r5)
            sg.bigo.ads.common.t.a.a(r3, r1, r2, r4)
            return
        L41:
            a(r4, r5, r6)
            java.lang.String r4 = "Update the consent status from user: "
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.BigoAdSdk.setUserConsent(android.content.Context, sg.bigo.ads.ConsentOptions, boolean):void");
    }

    @NonNull
    public static a a(@NonNull Context context) {
        if (e == null) {
            e = new a(context);
        }
        if (!e.f15603c) {
            e.b(context);
        }
        return e;
    }

    private static void b(@NonNull Context context) {
        if (!sg.bigo.ads.common.m.b.f()) {
            sg.bigo.ads.common.t.a.a(0, 3, GDPR.TAG, "GDPRContent is not changed, so return");
            return;
        }
        sg.bigo.ads.common.m.b.g();
        f13763c.set(true);
        if (!sg.bigo.ads.common.x.b.a()) {
            sg.bigo.ads.common.x.b.f16251a = context.getApplicationContext();
        }
        if (!sg.bigo.ads.common.m.b.a()) {
            sg.bigo.ads.common.m.b.a(context.getApplicationContext());
        }
        if (!sg.bigo.ads.common.m.b.e(context)) {
            a(context, ConsentOptions.GDPR, sg.bigo.ads.common.x.a.l() != 2);
            sg.bigo.ads.common.t.a.a(0, 3, GDPR.TAG, "GDPR applies is null, so return");
        } else if (sg.bigo.ads.common.m.a.b()) {
            a(context, ConsentOptions.GDPR, sg.bigo.ads.common.m.a.a());
        } else {
            a(context, ConsentOptions.GDPR, true);
        }
    }

    public static a.C0306a<sg.bigo.ads.api.b> a(final sg.bigo.ads.api.b bVar, sg.bigo.ads.controller.c cVar) {
        String str;
        bVar.g.f15467f = System.currentTimeMillis();
        sg.bigo.ads.controller.a aVar = new sg.bigo.ads.controller.a(cVar);
        if (!f13761a.get()) {
            aVar.a(0, 1000, 0, "Please initialize SDK before request ads.", new Pair<>(bVar, null));
            return null;
        }
        b(f13764d.f16542a);
        final sg.bigo.ads.controller.e.a aVar2 = f13764d;
        if (q.a((CharSequence) aVar2.e.f16588a.getAppKey())) {
            aVar.a(0, 1013, 10000, "App id cannot be empty, please pass the id when initializing bigo sdk.", new Pair(bVar, null));
            return null;
        }
        sg.bigo.ads.api.core.d dVarB = bVar.b();
        if (dVarB != null) {
            aVar.a(0, dVarB.f15483a, dVarB.f15484b, dVarB.f15485c, new Pair(bVar, null));
            return null;
        }
        int i2 = 0;
        byte b8 = 0;
        if (!sg.bigo.ads.common.x.a.q()) {
            final a.C0306a<sg.bigo.ads.api.b> c0306a = new a.C0306a<>(bVar, aVar, b8 == true ? 1 : 0);
            d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.9
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    if (bVar.f()) {
                        ((sg.bigo.ads.api.b) c0306a.f16576a).b(0);
                        a.a(a.this, c0306a);
                    } else {
                        a.this.l.b();
                        a.this.f16546f.a(new e.a() { // from class: sg.bigo.ads.controller.e.a.9.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // sg.bigo.ads.controller.e.e.a
                            public final void a(int i8) {
                                a.a(a.this, 1, (Map) null);
                                ((sg.bigo.ads.api.b) c0306a.f16576a).b(i8);
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                a.a(a.this, c0306a);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // sg.bigo.ads.controller.e.e.a
                            public final void a(int i8, int i9, String str2) {
                                ((sg.bigo.ads.api.b) c0306a.f16576a).b(i8);
                                if (a.this.f16543b.N()) {
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    a.a(a.this, c0306a);
                                } else {
                                    AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                                    a.this.a(c0306a, 1008, i9, str2);
                                }
                            }
                        }, 1);
                    }
                }
            });
            return c0306a;
        }
        String str2 = "Missing CCPA consent";
        if (sg.bigo.ads.common.x.a.m() == 2) {
            str = "Missing GDPR consent";
            i2 = 1;
        } else {
            str = "Missing CCPA consent";
        }
        if (sg.bigo.ads.common.x.a.o() == 2) {
            i2++;
            str = "Missing LGPD consent";
        }
        if (sg.bigo.ads.common.x.a.n() == 2) {
            i2++;
        } else {
            str2 = str;
        }
        if (sg.bigo.ads.common.x.a.p() == 2) {
            i2++;
            str2 = "Missing COPPA consent";
        }
        if (i2 > 1) {
            str2 = "Missing user consent";
        }
        aVar.a(0, 1001, 800, str2, new Pair(bVar, null));
        return null;
    }

    private static void a(final Context context, @NonNull final ConsentOptions consentOptions, boolean z2) {
        boolean zA = a(consentOptions, z2);
        if (z2 || !zA) {
            return;
        }
        d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.2
            @Override // java.lang.Runnable
            public final void run() {
                HashMap map = new HashMap();
                map.put(ConsentOptions.GDPR, Integer.valueOf(sg.bigo.ads.common.x.a.m()));
                map.put(ConsentOptions.LGPD, Integer.valueOf(sg.bigo.ads.common.x.a.o()));
                map.put(ConsentOptions.CCPA, Integer.valueOf(sg.bigo.ads.common.x.a.n()));
                map.put(ConsentOptions.COPPA, Integer.valueOf(sg.bigo.ads.common.x.a.p()));
                map.remove(consentOptions);
                int iL = sg.bigo.ads.common.x.a.l();
                sg.bigo.ads.common.t.a.a(2, 5, "", "Revoking user consent...The cached data of user will be deleted now.");
                sg.bigo.ads.core.d.b.b bVar = sg.bigo.ads.core.d.c.a().f16897b;
                if (bVar != null) {
                    bVar.f16879c.f();
                }
                sg.bigo.ads.core.b.b.a aVar = sg.bigo.ads.core.b.b.a().f16812a;
                if (aVar != null) {
                    aVar.f16815b.g();
                }
                sg.bigo.ads.core.e.a.d dVarA = sg.bigo.ads.core.e.a.d.a();
                dVarA.e = context.getApplicationContext();
                dVarA.b();
                dVarA.f16952a.clear();
                sg.bigo.ads.core.player.b bVarA = sg.bigo.ads.core.player.b.a();
                Context context2 = context;
                sg.bigo.ads.common.h.b bVar2 = bVarA.g;
                if (bVar2 != null) {
                    sg.bigo.ads.common.h.b.b.a();
                    bVar2.f15744a.clear();
                    bVar2.f15746c.clear();
                    bVar2.f15745b.clear();
                    bVar2.f15747d.clear();
                }
                List<o> list = bVarA.f17314d;
                if (list != null) {
                    list.clear();
                }
                List<o> list2 = bVarA.e;
                if (list2 != null) {
                    list2.clear();
                }
                Map<String, b.a> map2 = bVarA.f17315f;
                if (map2 != null) {
                    map2.clear();
                }
                h.a.f15921a.e(context2);
                sg.bigo.ads.common.utils.f.b(new File(sg.bigo.ads.common.o.a(context)));
                sg.bigo.ads.common.g.a.a.a();
                sg.bigo.ads.common.x.a.s();
                BigoAdSdk.a(consentOptions);
                for (Map.Entry entry : map.entrySet()) {
                    int i2 = AnonymousClass5.f13772a[((ConsentOptions) entry.getKey()).ordinal()];
                    if (i2 == 1) {
                        sg.bigo.ads.common.x.a.e(((Integer) entry.getValue()).intValue());
                    } else if (i2 == 2) {
                        sg.bigo.ads.common.x.a.c(((Integer) entry.getValue()).intValue());
                    } else if (i2 == 3) {
                        sg.bigo.ads.common.x.a.d(((Integer) entry.getValue()).intValue());
                    } else if (i2 == 4) {
                        sg.bigo.ads.common.x.a.f(((Integer) entry.getValue()).intValue());
                    }
                }
                sg.bigo.ads.common.x.a.b(iL);
            }
        });
    }

    public static /* synthetic */ void a(final String str) {
        d.a(1, new Runnable() { // from class: sg.bigo.ads.BigoAdSdk.4
            @Override // java.lang.Runnable
            public final void run() {
                if (BigoAdSdk.f13764d != null) {
                    for (Pair pair : BigoAdSdk.g) {
                        BigoAdSdk.f13764d.a((String) pair.first, (String) pair.second);
                    }
                    Map<String, String> mapB = sg.bigo.ads.controller.a.d.b(str);
                    if (!k.a(mapB)) {
                        for (Map.Entry<String, String> entry : mapB.entrySet()) {
                            BigoAdSdk.f13764d.a(entry.getKey(), entry.getValue());
                        }
                    }
                }
                BigoAdSdk.g.clear();
            }
        });
    }

    public static /* synthetic */ boolean a(ConsentOptions consentOptions) {
        return a(consentOptions, false);
    }

    private static boolean a(@NonNull ConsentOptions consentOptions, boolean z2) {
        boolean z7;
        int i2 = z2 ? 1 : 2;
        int i8 = AnonymousClass5.f13772a[consentOptions.ordinal()];
        if (i8 == 1) {
            if (i2 != sg.bigo.ads.common.x.a.o()) {
                sg.bigo.ads.common.x.a.e(i2);
                z7 = true;
            }
            z7 = false;
        } else if (i8 == 2) {
            if (i2 != sg.bigo.ads.common.x.a.m()) {
                sg.bigo.ads.common.x.a.c(i2);
                z7 = true;
            }
            z7 = false;
        } else if (i8 != 3) {
            if (i8 == 4 && i2 != sg.bigo.ads.common.x.a.p()) {
                sg.bigo.ads.common.x.a.f(i2);
                z7 = true;
            }
            z7 = false;
        } else {
            if (i2 != sg.bigo.ads.common.x.a.n()) {
                sg.bigo.ads.common.x.a.d(i2);
                z7 = true;
            }
            z7 = false;
        }
        if (z7) {
            f13763c.set(true);
        }
        return z7;
    }
}
