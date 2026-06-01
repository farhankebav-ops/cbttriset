package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: com.ironsource.xa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2639xa {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10501i = "WaterfallLifeCycleHolder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.mediationsdk.t f10505d;
    private final List<String> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10506f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<com.ironsource.mediationsdk.t>> f10502a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10503b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10504c = "";
    private final Timer g = new Timer();
    ConcurrentHashMap<String, AdInfo> h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.ironsource.xa$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10507a;

        public a(String str) {
            this.f10507a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f10507a + " from memory");
                C2639xa.this.f10502a.remove(this.f10507a);
                ironLog.verbose("waterfall size is currently " + C2639xa.this.f10502a.size());
                ironLog.verbose("removing adInfo with id " + this.f10507a + " from memory");
                C2639xa.this.h.remove(this.f10507a);
                ironLog.verbose("adInfo size is currently " + C2639xa.this.h.size());
            } finally {
                cancel();
            }
        }
    }

    public C2639xa(List<String> list, int i2) {
        this.e = list;
        this.f10506f = i2;
    }

    public synchronized void a(com.ironsource.mediationsdk.t tVar) {
        try {
            IronLog.INTERNAL.verbose();
            com.ironsource.mediationsdk.t tVar2 = this.f10505d;
            if (tVar2 != null && !tVar2.equals(tVar)) {
                this.f10505d.q();
            }
            this.f10505d = tVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean b(com.ironsource.mediationsdk.t r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> L2f
            r0.verbose()     // Catch: java.lang.Throwable -> L2f
            r1 = 1
            if (r6 == 0) goto L55
            boolean r2 = r6.o()     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L10
            goto L55
        L10:
            com.ironsource.mediationsdk.t r2 = r5.f10505d     // Catch: java.lang.Throwable -> L2f
            r3 = 0
            if (r2 != 0) goto L16
            goto L56
        L16:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch: java.lang.Throwable -> L2f
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch: java.lang.Throwable -> L2f
            if (r2 != r4) goto L31
            com.ironsource.mediationsdk.t r2 = r5.f10505d     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r2.c()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = r6.c()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L31
            goto L55
        L2f:
            r6 = move-exception
            goto L76
        L31:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch: java.lang.Throwable -> L2f
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch: java.lang.Throwable -> L2f
            if (r2 == r4) goto L45
            java.util.List<java.lang.String> r2 = r5.e     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = r6.j()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L56
        L45:
            com.ironsource.mediationsdk.t r2 = r5.f10505d     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r2.j()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = r6.j()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L56
        L55:
            r3 = r1
        L56:
            if (r3 == 0) goto L72
            if (r6 == 0) goto L72
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = r6.c()     // Catch: java.lang.Throwable -> L2f
            r2.append(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = " will not be added to the auction request"
            r2.append(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L2f
            r0.verbose(r6)     // Catch: java.lang.Throwable -> L2f
        L72:
            r6 = r3 ^ 1
            monitor-exit(r5)
            return r6
        L76:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2f
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2639xa.b(com.ironsource.mediationsdk.t):boolean");
    }

    public CopyOnWriteArrayList<com.ironsource.mediationsdk.t> c() {
        CopyOnWriteArrayList<com.ironsource.mediationsdk.t> copyOnWriteArrayList = this.f10502a.get(this.f10503b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.f10503b;
    }

    public int e() {
        return this.f10502a.size();
    }

    public com.ironsource.mediationsdk.t f() {
        return this.f10505d;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean g() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.mediationsdk.t r0 = r2.f10505d     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            java.lang.String r0 = r0.u()     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = r2.f10504c     // Catch: java.lang.Throwable -> L13
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            r0 = 1
            goto L16
        L13:
            r0 = move-exception
            goto L18
        L15:
            r0 = 0
        L16:
            monitor-exit(r2)
            return r0
        L18:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2639xa.g():boolean");
    }

    public void a(CopyOnWriteArrayList<com.ironsource.mediationsdk.t> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        com.google.android.gms.ads.internal.client.a.p("updating new waterfall with id ", str, ironLog);
        b();
        this.f10502a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.f10504c)) {
            if (g()) {
                StringBuilder sb = new StringBuilder("ad from previous waterfall ");
                sb.append(this.f10504c);
                sb.append(" is still showing - the current waterfall ");
                com.google.android.gms.ads.internal.client.a.u(sb, this.f10503b, " will be deleted instead", ironLog);
                String str2 = this.f10503b;
                this.f10503b = this.f10504c;
                this.f10504c = str2;
            }
            this.g.schedule(new a(this.f10504c), this.f10506f);
        }
        this.f10504c = this.f10503b;
        this.f10503b = str;
    }

    private void b() {
        for (com.ironsource.mediationsdk.t tVar : c()) {
            if (!tVar.equals(this.f10505d)) {
                tVar.q();
            }
        }
    }

    public boolean a() {
        return this.f10502a.size() > 5;
    }

    public void a(String str, Y8 y8, Bb bb) {
        if (TextUtils.isEmpty(str) || y8 == null) {
            return;
        }
        this.h.put(str, new AdInfo(y8, bb));
    }

    public AdInfo a(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }
}
