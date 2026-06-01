package sg.bigo.ads.controller.e;

import android.content.ContentValues;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.controller.e.e;
import sg.bigo.ads.controller.f.a;
import sg.bigo.ads.controller.g.i;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, l>, a.InterfaceC0307a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Context f16542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final sg.bigo.ads.controller.b.d f16543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final sg.bigo.ads.controller.b.h f16544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final sg.bigo.ads.controller.a.b f16545d;

    @NonNull
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    final e f16546f;

    @Nullable
    public f g;
    final LinkedList<C0306a<? extends sg.bigo.ads.api.b>> h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final SparseArray<C0306a<i>> f16547i;
    public long j;

    @NonNull
    final b l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Context f16548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final sg.bigo.ads.controller.b f16549o;
    private final AtomicBoolean m = new AtomicBoolean(false);
    boolean k = true;

    /* JADX INFO: renamed from: sg.bigo.ads.controller.e.a$a, reason: collision with other inner class name */
    public static class C0306a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final T f16576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        final sg.bigo.ads.controller.c f16577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f16578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f16579d;
        public int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f16580f;
        public q g;

        private C0306a(@NonNull T t3, @NonNull sg.bigo.ads.controller.c cVar) {
            this.e = 1;
            this.f16580f = 0;
            this.f16576a = t3;
            this.f16577b = cVar;
        }

        public /* synthetic */ C0306a(Object obj, sg.bigo.ads.controller.c cVar, byte b8) {
            this(obj, cVar);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile int f16582b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f16583c = true;

        public b() {
        }

        public final void a() {
            if (this.f16582b == 0 || this.f16582b == 2) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task set.");
                sg.bigo.ads.common.n.d.a(3, this, 5000L);
                this.f16582b = 1;
            }
        }

        public final void b() {
            if (this.f16582b == 1 || this.f16582b == 2) {
                if (this.f16582b == 1) {
                    sg.bigo.ads.common.n.d.a(this);
                }
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task canceled.");
                this.f16582b = 3;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!sg.bigo.ads.common.f.b.e()) {
                b();
                return;
            }
            if (!this.f16583c || a.this.k) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Start to execute task.");
                this.f16582b = 4;
                a.this.f16546f.a(new e.a() { // from class: sg.bigo.ads.controller.e.a.b.1
                    @Override // sg.bigo.ads.controller.e.e.a
                    public final void a(int i2) {
                        a.a(a.this, 1, (Map) null);
                    }

                    @Override // sg.bigo.ads.controller.e.e.a
                    public final void a(int i2, int i8, String str) {
                    }
                }, 0);
            } else {
                this.f16583c = false;
                sg.bigo.ads.common.t.a.b("PrefetchConfigTask", "The network is unavailable now. Task paused.");
                this.f16582b = 2;
            }
        }

        public static /* synthetic */ void a(b bVar) {
            if (bVar.f16582b == 2) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task resumed.");
                bVar.a();
            }
        }
    }

    public a(@NonNull Context context, @NonNull AdConfig adConfig) {
        sg.bigo.ads.controller.b bVar = new sg.bigo.ads.controller.b() { // from class: sg.bigo.ads.controller.e.a.1
            @Override // sg.bigo.ads.controller.e
            public final void a(int i2, int i8, int i9, @NonNull String str, @Nullable Object obj) {
                StringBuilder sbW = a1.a.w(i2, "sdk config fetch error, seq=", ", code=", i8, ", subCode=");
                sbW.append(i9);
                sbW.append(", message=");
                sbW.append(str);
                sg.bigo.ads.common.t.a.a(0, "AdController", sbW.toString());
            }

            @Override // sg.bigo.ads.controller.b
            public final void a(int i2, @NonNull String str) {
                sg.bigo.ads.common.t.a.a(0, 3, "AdController", "sdk config fetch success, seqId=" + i2 + ", data=" + str);
            }
        };
        this.f16549o = bVar;
        this.f16542a = context;
        sg.bigo.ads.controller.b.d dVar = new sg.bigo.ads.controller.b.d(context);
        this.f16543b = dVar;
        sg.bigo.ads.api.a.i.f15457a = dVar;
        sg.bigo.ads.controller.b.h hVar = new sg.bigo.ads.controller.b.h(context);
        this.f16544c = hVar;
        d dVar2 = new d(context, adConfig, dVar);
        this.e = dVar2;
        sg.bigo.ads.controller.a.b bVar2 = new sg.bigo.ads.controller.a.b(context, dVar2, dVar);
        this.f16545d = bVar2;
        bVar2.g = bVar;
        sg.bigo.ads.common.u.a.e.a(bVar2.f16310a.m);
        sg.bigo.ads.common.u.g.f15987a = new sg.bigo.ads.common.u.a.a(dVar2);
        this.f16546f = new e(context, dVar, hVar, dVar2, bVar2);
        sg.bigo.ads.api.a.h hVar2 = sg.bigo.ads.api.a.i.f15457a;
        if (hVar2 != null) {
            sg.bigo.ads.api.a.b bVarQ = hVar2.q();
            if (bVarQ instanceof sg.bigo.ads.controller.b.b) {
                ((sg.bigo.ads.controller.b.b) bVarQ).f16392a = hVar;
            }
        }
        this.h = new LinkedList<>();
        this.f16547i = new SparseArray<>();
        this.l = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0235  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.e.a.a():void");
    }

    public final Context b() {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return this.f16542a;
            }
            Context context = this.f16548n;
            if (context != null) {
                return context;
            }
            Context contextCreateWindowContext = this.f16542a.createDisplayContext(((DisplayManager) this.f16542a.getSystemService(DisplayManager.class)).getDisplay(0)).createWindowContext(1001, null);
            this.f16548n = contextCreateWindowContext;
            return contextCreateWindowContext;
        } catch (Throwable unused) {
            return this.f16542a;
        }
    }

    @Override // sg.bigo.ads.controller.e
    public final /* synthetic */ void a(final int i2, final int i8, final int i9, @NonNull final String str, @Nullable l lVar) {
        final l lVar2 = lVar;
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                C0306a<i> c0306a = a.this.f16547i.get(i2);
                if (c0306a != null) {
                    sg.bigo.ads.api.b bVarK = c0306a.f16576a.k();
                    a.this.f16547i.remove(i2);
                    int i10 = i8;
                    String str2 = str;
                    if (i10 == 1005) {
                        if (i9 == -6) {
                            i10 = 1004;
                            str2 = "The sdk integration and ad request are successful, but no ad wins at this time.";
                        } else {
                            str2 = "Error from server: " + str;
                        }
                    }
                    c0306a.f16577b.a(i2, i10, i9, str2, Pair.create(bVarK, lVar2));
                }
                a.this.a();
            }
        });
    }

    @Override // sg.bigo.ads.controller.e
    public final /* synthetic */ void a(final int i2, @NonNull sg.bigo.ads.api.b bVar, @NonNull sg.bigo.ads.api.core.c[] cVarArr) {
        final sg.bigo.ads.api.b bVar2 = bVar;
        final sg.bigo.ads.api.core.c[] cVarArr2 = cVarArr;
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                C0306a<i> c0306a = a.this.f16547i.get(i2);
                if (c0306a != null) {
                    a.this.f16547i.remove(i2);
                    if (!k.a(cVarArr2)) {
                        sg.bigo.ads.api.core.g[] gVarArr = new sg.bigo.ads.api.core.g[cVarArr2.length];
                        int i8 = 0;
                        while (true) {
                            sg.bigo.ads.api.core.c[] cVarArr3 = cVarArr2;
                            if (i8 >= cVarArr3.length) {
                                break;
                            }
                            sg.bigo.ads.api.core.c cVar = cVarArr3[i8];
                            l lVarL = c0306a.f16576a.l();
                            sg.bigo.ads.api.b bVar3 = bVar2;
                            a aVar = a.this;
                            g.a aVar2 = new g.a(cVar, lVarL, bVar3, aVar.f16542a, aVar.b());
                            aVar2.f15501a = a.this.e;
                            gVarArr[i8] = aVar2.a();
                            if (sg.bigo.ads.api.core.b.d(cVar.x())) {
                                t.a();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("slot", cVar.b());
                                contentValues.put("log_id", Long.valueOf(cVar.Z()));
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                contentValues.put("start_time", Long.valueOf(jCurrentTimeMillis));
                                contentValues.put("end_time", Long.valueOf((cVar.L() * 1000) + jCurrentTimeMillis));
                                JSONObject jSONObjectAf = cVar.af();
                                contentValues.put("ad_data", jSONObjectAf == null ? "" : jSONObjectAf.toString());
                                contentValues.put("mtime", Long.valueOf(jCurrentTimeMillis));
                                sg.bigo.ads.common.g.a.a.b("tb_addata", contentValues);
                            }
                            i8++;
                        }
                        c0306a.f16577b.a(i2, bVar2, gVarArr);
                    }
                }
                a.this.a();
            }
        });
    }

    public final void a(String str, String str2) {
        this.f16545d.a(str, str2);
    }

    public final void a(@NonNull final C0306a<? extends sg.bigo.ads.api.b> c0306a, final int i2, final int i8, final String str) {
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.controller.e.a.11
            @Override // java.lang.Runnable
            public final void run() {
                c0306a.f16577b.a(0, i2, i8, str, new Pair(c0306a.f16576a, null));
            }
        });
    }

    public static /* synthetic */ void a(a aVar, int i2, Map map) {
        if (sg.bigo.ads.common.utils.q.a((CharSequence) aVar.e.f16590c.F()) || aVar.m.getAndSet(true)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jI = sg.bigo.ads.common.x.a.i();
        long jElapsedRealtime = aVar.j == 0 ? -1L : SystemClock.elapsedRealtime() - aVar.j;
        if (jCurrentTimeMillis - jI >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            sg.bigo.ads.core.d.b.a(jElapsedRealtime, i2, sg.bigo.ads.common.x.a.r(), sg.bigo.ads.common.m.b.e(), (Map<String, String>) map);
            sg.bigo.ads.common.x.a.c(jCurrentTimeMillis);
            sg.bigo.ads.core.d.b.a();
            sg.bigo.ads.core.d.b.a(aVar.e);
        }
    }

    public static /* synthetic */ void a(a aVar, final C0306a c0306a) {
        if (aVar.f16543b.H()) {
            sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.10
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    Ad adA;
                    sg.bigo.ads.api.b bVar = (sg.bigo.ads.api.b) c0306a.f16576a;
                    l lVarA = a.this.f16544c.a(bVar);
                    if ((lVarA != null ? lVarA.w() : false) || bVar.g()) {
                        a.this.h.addFirst(c0306a);
                    } else {
                        if (lVarA != null && (adA = b.a.f13844a.a(lVarA)) != null) {
                            sg.bigo.ads.controller.c cVar = c0306a.f16577b;
                            if ((cVar instanceof sg.bigo.ads.controller.a) && (((sg.bigo.ads.controller.a) cVar).f16259a instanceof sg.bigo.ads.controller.d)) {
                                sg.bigo.ads.controller.c cVar2 = ((sg.bigo.ads.controller.a) cVar).f16259a;
                                if (cVar2 instanceof sg.bigo.ads.controller.d) {
                                    ((sg.bigo.ads.controller.d) cVar2).a(lVarA, adA);
                                }
                            }
                        }
                        a.this.h.offer(c0306a);
                    }
                    a.this.a();
                }
            });
        } else {
            aVar.a(c0306a, 1005, 10004, "The country where the ad request comes from is not supported, please change your country to RU or US and have a try. Besides, check your COPPA setup on bigo's console. The app will fail to send an ad request if it's targeted children under 13.");
        }
    }

    @Override // sg.bigo.ads.controller.f.a.InterfaceC0307a
    public final void a(boolean z2) {
        this.k = z2;
        if (z2) {
            sg.bigo.ads.common.aa.b.a();
            b.a(this.l);
        }
    }
}
