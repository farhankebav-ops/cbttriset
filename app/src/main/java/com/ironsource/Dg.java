package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC2547s3;
import com.ironsource.N0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Dg<Smash extends AbstractC2547s3<?>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    AbstractC2547s3<?> f6641d;
    private final List<String> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6642f;
    Eg h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> f6638a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6639b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6640c = "";
    private final Timer g = new Timer();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f6643i = 5;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6644a;

        public a(String str) {
            this.f6644a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f6644a + " from memory");
                Dg.this.f6638a.remove(this.f6644a);
                ironLog.verbose("waterfall size is currently " + Dg.this.f6638a.size());
            } finally {
                cancel();
            }
        }
    }

    public Dg(List<String> list, int i2, Eg eg) {
        this.e = list;
        this.f6642f = i2;
        this.h = eg;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean e() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.s3<?> r0 = r2.f6641d     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            boolean r0 = r0.C()     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            com.ironsource.s3<?> r0 = r2.f6641d     // Catch: java.lang.Throwable -> L1b
            java.lang.String r0 = r0.h()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = r2.f6640c     // Catch: java.lang.Throwable -> L1b
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L1d
            r0 = 1
            goto L1e
        L1b:
            r0 = move-exception
            goto L20
        L1d:
            r0 = 0
        L1e:
            monitor-exit(r2)
            return r0
        L20:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Dg.e():boolean");
    }

    public synchronized void a(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose();
        AbstractC2547s3<?> abstractC2547s32 = this.f6641d;
        if (abstractC2547s32 != null && !abstractC2547s32.equals(abstractC2547s3)) {
            this.f6641d.M();
        }
    }

    public synchronized void b(AbstractC2547s3<?> abstractC2547s3) {
        IronLog.INTERNAL.verbose();
        this.f6641d = abstractC2547s3;
    }

    public String c() {
        return this.f6639b;
    }

    public AbstractC2547s3<?> d() {
        return this.f6641d;
    }

    public List<Smash> b() {
        CopyOnWriteArrayList<Smash> copyOnWriteArrayList = this.f6638a.get(this.f6639b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {all -> 0x0012, blocks: (B:3:0x0001, B:31:0x004b, B:6:0x0008, B:8:0x000d, B:13:0x0014, B:15:0x0018, B:18:0x001f, B:20:0x0023, B:23:0x0030, B:25:0x0034, B:27:0x003c), top: B:36:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(com.ironsource.N0.a r1, java.lang.String r2, java.lang.String r3, com.ironsource.mediationsdk.LoadWhileShowSupportState r4, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface r5, com.ironsource.mediationsdk.IronSource.a r6) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r5 = r0.a(r5, r6, r2)     // Catch: java.lang.Throwable -> L12
            if (r5 == 0) goto L8
            goto L48
        L8:
            com.ironsource.N0$a r5 = com.ironsource.N0.a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch: java.lang.Throwable -> L12
            r6 = 1
            if (r1 == r5) goto L14
            com.ironsource.N0$a r5 = com.ironsource.N0.a.MANUAL_WITH_LOAD_ON_SHOW     // Catch: java.lang.Throwable -> L12
            if (r1 == r5) goto L14
            goto L49
        L12:
            r1 = move-exception
            goto L63
        L14:
            com.ironsource.s3<?> r1 = r0.f6641d     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L49
            boolean r1 = r1.C()     // Catch: java.lang.Throwable -> L12
            if (r1 != 0) goto L1f
            goto L49
        L1f:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch: java.lang.Throwable -> L12
            if (r4 != r1) goto L30
            com.ironsource.s3<?> r1 = r0.f6641d     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L12
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L30
            goto L48
        L30:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch: java.lang.Throwable -> L12
            if (r4 == r1) goto L3c
            java.util.List<java.lang.String> r1 = r0.e     // Catch: java.lang.Throwable -> L12
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L49
        L3c:
            com.ironsource.s3<?> r1 = r0.f6641d     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.n()     // Catch: java.lang.Throwable -> L12
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L49
        L48:
            r6 = 0
        L49:
            if (r6 != 0) goto L61
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r3.<init>()     // Catch: java.lang.Throwable -> L12
            r3.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = " will not be added to the auction request"
            r3.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L12
            r1.verbose(r2)     // Catch: java.lang.Throwable -> L12
        L61:
            monitor-exit(r0)
            return r6
        L63:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.Dg.a(com.ironsource.N0$a, java.lang.String, java.lang.String, com.ironsource.mediationsdk.LoadWhileShowSupportState, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface, com.ironsource.mediationsdk.IronSource$a):boolean");
    }

    public boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.a aVar, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(C2627wf.a(aVar))) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    public void a(N0.a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        com.google.android.gms.ads.internal.client.a.p("updating new waterfall with id ", str, ironLog);
        a();
        if (aVar != N0.a.AUTOMATIC_LOAD_WHILE_SHOW && aVar != N0.a.MANUAL_WITH_LOAD_ON_SHOW) {
            this.f6638a.clear();
            this.f6638a.put(str, copyOnWriteArrayList);
        } else {
            this.f6638a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.f6640c)) {
                if (e()) {
                    StringBuilder sb = new StringBuilder("ad from previous waterfall ");
                    sb.append(this.f6640c);
                    sb.append(" is still showing - the current waterfall ");
                    com.google.android.gms.ads.internal.client.a.u(sb, this.f6639b, " will be deleted instead", ironLog);
                    String str2 = this.f6639b;
                    this.f6639b = this.f6640c;
                    this.f6640c = str2;
                }
                this.g.schedule(new a(this.f6640c), this.f6642f);
            }
        }
        this.f6640c = this.f6639b;
        this.f6639b = str;
        if (this.f6638a.size() > 5) {
            this.h.a(this.f6638a.size());
        }
    }

    private void a() {
        for (Smash smash : b()) {
            if (!smash.equals(this.f6641d)) {
                smash.M();
            }
        }
    }
}
