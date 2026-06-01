package com.ironsource.mediationsdk;

import com.ironsource.C2358h8;
import com.ironsource.C2580u2;
import com.ironsource.Ed;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final n f9256f = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f9257a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f9258b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9260d;
    private int e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSource.a f9261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f9262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9263c;

        public a(IronSource.a aVar, IronSourceError ironSourceError, String str) {
            this.f9261a = aVar;
            this.f9262b = ironSourceError;
            this.f9263c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("onAdLoadFailed - invokeCallback after delaying");
            n.this.a(this.f9261a, this.f9262b);
            n.this.f9258b.put(this.f9263c, Boolean.FALSE);
        }
    }

    private n() {
    }

    public static synchronized n a() {
        return f9256f;
    }

    public synchronized void b(IronSource.a aVar, IronSourceError ironSourceError) {
        if (b(aVar)) {
            return;
        }
        String string = aVar.toString();
        if (!this.f9257a.containsKey(string)) {
            a(aVar, ironSourceError);
            return;
        }
        long jA = ((long) a(aVar)) * 1000;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f9257a.get(string).longValue();
        if (jCurrentTimeMillis > jA) {
            a(aVar, ironSourceError);
            return;
        }
        this.f9258b.put(string, Boolean.TRUE);
        long j = jA - jCurrentTimeMillis;
        IronLog.INTERNAL.verbose("delaying callback by " + j);
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(aVar, ironSourceError, string), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IronSource.a aVar, IronSourceError ironSourceError) {
        this.f9257a.put(aVar.toString(), Long.valueOf(System.currentTimeMillis()));
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            Ed.a().a(ironSourceError);
            return;
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            C2358h8.a().a(ironSourceError);
            return;
        }
        if (aVar == IronSource.a.BANNER) {
            C2580u2.a().a(ironSourceError);
            return;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + aVar);
    }

    public void a(IronSource.a aVar, int i2) {
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            this.f9260d = i2;
            return;
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            this.f9259c = i2;
            return;
        }
        if (aVar == IronSource.a.BANNER) {
            this.e = i2;
            return;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + aVar);
    }

    public synchronized boolean b(IronSource.a aVar) {
        if (!this.f9258b.containsKey(aVar.toString())) {
            return false;
        }
        return this.f9258b.get(aVar.toString()).booleanValue();
    }

    private int a(IronSource.a aVar) {
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            return this.f9260d;
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            return this.f9259c;
        }
        if (aVar == IronSource.a.BANNER) {
            return this.e;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + aVar);
        return 0;
    }
}
