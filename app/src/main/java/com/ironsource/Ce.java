package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ce {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f6412b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ce f6411a = new Ce();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Be f6413c = Be.NOT_INIT;

    private Ce() {
    }

    public final synchronized Be a() {
        return f6413c;
    }

    public final Be b() {
        Boolean bool = f6412b;
        if (bool == null ? true : bool.equals(Boolean.FALSE)) {
            return Be.NOT_INIT;
        }
        if (kotlin.jvm.internal.k.a(bool, Boolean.TRUE)) {
            return f6413c;
        }
        throw new e2.s(3);
    }

    public final synchronized void a(Be be) {
        kotlin.jvm.internal.k.e(be, "<set-?>");
        f6413c = be;
    }

    public final void a(boolean z2) {
        f6412b = Boolean.valueOf(z2);
    }
}
