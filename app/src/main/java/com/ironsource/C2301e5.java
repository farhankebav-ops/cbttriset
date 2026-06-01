package com.ironsource;

import android.content.Context;

/* JADX INFO: renamed from: com.ironsource.e5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2301e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2301e5 f8427a = new C2301e5();

    private C2301e5() {
    }

    private final int a(Context context, int i2) {
        return a.a.U(i2 / context.getResources().getDisplayMetrics().density);
    }

    public final int b(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return a(context, context.getResources().getDisplayMetrics().widthPixels);
    }

    public final int a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return a(context, context.getResources().getDisplayMetrics().heightPixels);
    }
}
