package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import com.ironsource.A1;
import com.ironsource.Be;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.Ce;
import com.ironsource.D5;
import com.ironsource.Dc;
import com.ironsource.InterfaceC2466n7;
import com.ironsource.K1;
import com.ironsource.Mb;
import com.ironsource.Mc;
import com.ironsource.Me;
import com.ironsource.Qe;
import com.ironsource.V9;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.r;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class u implements Dc {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static u f9344z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Qe f9345a;
    private NetworkStateReceiver p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CountDownTimer f9353q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f9356t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Me f9357u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f9359w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9346b = e.f9372f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2466n7 f9347c = Mb.U().k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9348d = "appKey";
    private final String e = getClass().getSimpleName();
    private boolean l = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9351n = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<Mc> f9354r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9355s = "";
    private f y = new a();
    private Handler m = IronSourceThreadManager.INSTANCE.getInitHandler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9349f = 1;
    private int g = 0;
    private int h = 62;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9350i = 12;
    private int j = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicBoolean f9352o = new AtomicBoolean(true);
    private boolean k = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f9358v = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private V9 f9360x = new V9();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends f {
        public a() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x02a8 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:2:0x0000, B:4:0x0010, B:7:0x0023, B:9:0x002f, B:10:0x003e, B:12:0x0081, B:14:0x0094, B:16:0x00d1, B:17:0x00fa, B:19:0x012a, B:21:0x0130, B:22:0x0158, B:24:0x0183, B:26:0x018d, B:27:0x019a, B:28:0x01ae, B:30:0x01b4, B:31:0x01ce, B:33:0x01ee, B:68:0x02f7, B:34:0x0213, B:36:0x021b, B:37:0x022d, B:39:0x0233, B:40:0x023f, B:42:0x0246, B:43:0x0251, B:45:0x0257, B:46:0x0261, B:48:0x0265, B:50:0x0271, B:52:0x028e, B:53:0x0297, B:55:0x029c, B:67:0x02ed, B:57:0x02a8, B:59:0x02b0, B:61:0x02bb, B:62:0x02bf, B:63:0x02c9, B:65:0x02cf, B:66:0x02db), top: B:72:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 782
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.u.a.run():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class a extends CountDownTimer {
            public a(long j, long j3) {
                super(j, j3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                u uVar = u.this;
                if (uVar.l) {
                    return;
                }
                uVar.l = true;
                Iterator it = uVar.f9354r.iterator();
                while (it.hasNext()) {
                    ((Mc) it.next()).h("noInternetConnection");
                }
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (j <= 45000) {
                    u uVar = u.this;
                    uVar.f9358v = true;
                    Iterator it = uVar.f9354r.iterator();
                    while (it.hasNext()) {
                        ((Mc) it.next()).a();
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.f9353q = new a(RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS, 15000L).start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9363a;

        static {
            int[] iArr = new int[d.values().length];
            f9363a = iArr;
            try {
                iArr[d.INIT_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9363a[d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9363a[d.INITIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum d {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f9368a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f9369b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f9370c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f9371d = 3;
        public static int e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f9372f = 5;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public abstract class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f9374b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9373a = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected r.b f9375c = new a();

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class a implements r.b {
            public a() {
            }

            @Override // com.ironsource.mediationsdk.r.b
            public void a(String str) {
                f fVar = f.this;
                fVar.f9373a = false;
                fVar.f9374b = str;
            }
        }

        public f() {
        }
    }

    private u() {
    }

    public static synchronized u c() {
        try {
            if (f9344z == null) {
                f9344z = new u();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9344z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (Mb.U().g().g()) {
            Mb.U().q().a(new C5(D5.EP_CONFIG_RECEIVED, (JSONObject) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.k;
    }

    public void a(Context context, Me me) {
        this.f9360x.i(me.f().h());
        this.f9360x.c(me.f().d());
        A1 a1B = me.c().b();
        this.f9360x.a(a1B.a());
        this.f9360x.d(a1B.c().b());
        this.f9360x.b(a1B.k().b());
        this.f9360x.a(Boolean.valueOf(IronSourceUtils.c(context)));
        K1 k1F = me.c().b().f();
        this.f9360x.b(k1F.b());
        Mb.O().o().a(k1F.c());
    }

    public int b() {
        return this.f9346b;
    }

    public synchronized boolean d() {
        return this.f9358v;
    }

    public void f() {
        b(d.INIT_FAILED);
    }

    public synchronized void g() {
        int iA = a(a());
        this.f9346b = iA;
        this.f9360x.c(iA);
    }

    public synchronized void b(d dVar) {
        IronLog.INTERNAL.verbose("old status: " + a() + ", new status: " + dVar + ")");
        Ce.f6411a.a(Be.values()[dVar.ordinal()]);
    }

    private static int a(d dVar) {
        int i2 = c.f9363a[dVar.ordinal()];
        if (i2 == 1) {
            return e.f9371d;
        }
        if (i2 == 2) {
            return e.e;
        }
        if (i2 != 3) {
            return e.f9368a;
        }
        return e.f9369b;
    }

    public synchronized void a(Context context, String str, String str2, IronSource.a... aVarArr) {
        try {
            try {
                AtomicBoolean atomicBoolean = this.f9352o;
                if (atomicBoolean != null && atomicBoolean.compareAndSet(true, false)) {
                    b(d.INIT_IN_PROGRESS);
                    this.f9355s = str2;
                    this.f9356t = str;
                    if (IronSourceUtils.g(context)) {
                        this.m.post(this.y);
                    } else {
                        this.f9351n = true;
                        if (this.p == null) {
                            this.p = new NetworkStateReceiver(context, this);
                        }
                        context.registerReceiver(this.p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b());
                    }
                } else {
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, this.e + ": Multiple calls to init are not allowed", 2);
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ironsource.Dc
    public void a(boolean z2) {
        if (this.f9351n && z2) {
            CountDownTimer countDownTimer = this.f9353q;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f9351n = false;
            this.k = true;
            Mb.U().q().a(new C5(D5.INIT_AFTER_REACHABILITY_CHANGE, IronSourceUtils.b(false)));
            this.m.post(this.y);
        }
    }

    public synchronized d a() {
        return d.values()[Ce.f6411a.a().ordinal()];
    }
}
