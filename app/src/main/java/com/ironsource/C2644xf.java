package com.ironsource;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.ironsource.xf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2644xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2644xf f10528a = new C2644xf();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q5.f f10529b = n7.b.C(a.f10530a);

    /* JADX INFO: renamed from: com.ironsource.xf$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10530a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C2399je invoke() {
            return new C2399je(16, null, null, 6, null);
        }
    }

    private C2644xf() {
    }

    public final void a(Runnable action) {
        kotlin.jvm.internal.k.e(action, "action");
        a(this, action, 0L, 2, null);
    }

    private final C2399je a() {
        return (C2399je) f10529b.getValue();
    }

    public static /* synthetic */ void a(C2644xf c2644xf, Runnable runnable, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        c2644xf.a(runnable, j);
    }

    public final void a(Runnable action, long j) {
        kotlin.jvm.internal.k.e(action, "action");
        a().schedule(action, j, TimeUnit.MILLISECONDS);
    }
}
