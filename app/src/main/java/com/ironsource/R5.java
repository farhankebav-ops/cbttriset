package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class R5 {
    public static final int e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f7541a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC2476o f7543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C2657yb f7544d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("loaded ads are expired");
            InterfaceC2476o interfaceC2476o = R5.this.f7543c;
            if (interfaceC2476o != null) {
                interfaceC2476o.a();
            }
        }
    }

    public R5(int i2, InterfaceC2476o interfaceC2476o) {
        this.f7543c = interfaceC2476o;
        this.f7542b = i2;
    }

    public boolean b() {
        return this.f7542b > 0;
    }

    public void a(long j) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis(this.f7542b) - Math.max(j, 0L);
            if (millis <= 0) {
                IronLog.INTERNAL.verbose("no delay - onAdExpired called");
                this.f7543c.a();
                return;
            }
            a();
            this.f7544d = new C2657yb(millis, this.f7541a, true);
            Calendar calendar = Calendar.getInstance();
            calendar.add(14, (int) millis);
            IronLog.INTERNAL.verbose("loaded ads will expire on: " + calendar.getTime() + " in " + String.format(Locale.getDefault(), "%.2f", Double.valueOf((millis / 1000.0d) / 60.0d)) + " minutes");
        }
    }

    public void a() {
        if (!b() || this.f7544d == null) {
            return;
        }
        IronLog.INTERNAL.verbose("canceling expiration timer");
        this.f7544d.e();
        this.f7544d = null;
    }
}
