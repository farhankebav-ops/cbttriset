package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ci implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2271cb f8166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LevelPlayAdInfo f8167c;

    public /* synthetic */ ci(C2271cb c2271cb, LevelPlayAdInfo levelPlayAdInfo, int i2) {
        this.f8165a = i2;
        this.f8166b = c2271cb;
        this.f8167c = levelPlayAdInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8165a) {
            case 0:
                C2271cb.a(this.f8166b, this.f8167c);
                break;
            case 1:
                C2271cb.d(this.f8166b, this.f8167c);
                break;
            case 2:
                C2271cb.c(this.f8166b, this.f8167c);
                break;
            default:
                C2271cb.b(this.f8166b, this.f8167c);
                break;
        }
    }
}
