package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class V7 implements Tf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7733c;
    private static final T9 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final T9 f7735f;
    private static final T9 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V7 f7731a = new V7();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f7732b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final q5.f f7734d = n7.b.C(a.f7736a);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7736a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2399je invoke() {
            return new C2399je(0, null, null, 7, null);
        }
    }

    static {
        T9 t9 = new T9("isadplayer-background");
        t9.start();
        t9.a();
        e = t9;
        T9 t92 = new T9("isadplayer-publisher-callbacks");
        t92.start();
        t92.a();
        f7735f = t92;
        T9 t93 = new T9("isadplayer-release");
        t93.start();
        t93.a();
        g = t93;
    }

    private V7() {
    }

    private final boolean f(Runnable runnable) {
        return f7733c && b().getQueue().contains(runnable);
    }

    public final void a(boolean z2) {
        f7733c = z2;
    }

    public final void b(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        a(this, action, 0L, 2, null);
    }

    public final void c(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        b(this, action, 0L, 2, null);
    }

    public final void d(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final void e(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        if (f(action)) {
            b().remove(action);
        } else {
            g.b(action);
        }
    }

    private final C2399je b() {
        return (C2399je) f7734d.getValue();
    }

    public static /* synthetic */ void c(V7 v7, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        v7.d(runnable, j);
    }

    @Override // com.ironsource.Tf
    public void a(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final boolean d() {
        return f7733c;
    }

    public static /* synthetic */ void a(V7 v7, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        v7.b(runnable, j);
    }

    public final void b(Runnable action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        e.a(action, j);
    }

    public final void c(Runnable action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        f7735f.a(action, j);
    }

    public final void d(Runnable action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        f7732b.postDelayed(action, j);
    }

    public static /* synthetic */ void b(V7 v7, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        v7.c(runnable, j);
    }

    @Override // com.ironsource.Tf
    public void a(Runnable action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        if (f7733c) {
            b().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            g.a(action, j);
        }
    }

    public final ThreadPoolExecutor c() {
        return b();
    }

    public final Looper a() {
        return e.getLooper();
    }
}
