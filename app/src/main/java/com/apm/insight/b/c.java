package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4279b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4280a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4281c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f4282d;

    public c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (c.this.f4281c) {
                    return;
                }
                c.this.f4280a.d();
                long unused = c.f4279b = SystemClock.uptimeMillis();
                if (com.apm.insight.runtime.i.a().b()) {
                    m.a().a(c.this.f4282d, 500L);
                } else {
                    m.a().a(c.this.f4282d, 500L);
                }
                com.apm.insight.runtime.b.a(c.f4279b);
            }
        };
        this.f4282d = runnable;
        this.f4280a = bVar;
        m.a().a(runnable, 5000L);
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - f4279b <= 15000;
    }

    public final void b() {
        this.f4281c = true;
    }

    public final void a() {
        if (this.f4281c) {
            return;
        }
        m.a().a(this.f4282d, 5000L);
    }
}
