package com.ironsource;

import android.app.Activity;

/* JADX INFO: renamed from: com.ironsource.n6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2465n6 implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f9489a;

    public C2465n6(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        this.f9489a = activity;
    }

    @Override // com.ironsource.I
    public final /* synthetic */ void a(Xb xb) {
        jh.a(this, xb);
    }

    @Override // com.ironsource.I
    public final /* synthetic */ void a(C2648y2 c2648y2) {
        jh.c(this, c2648y2);
    }

    @Override // com.ironsource.I
    public void a(C2427l6 fullscreenAdInstance) {
        kotlin.jvm.internal.k.e(fullscreenAdInstance, "fullscreenAdInstance");
        fullscreenAdInstance.a(this.f9489a);
    }
}
