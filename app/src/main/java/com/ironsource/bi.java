package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class bi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LevelPlayAdError f8093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C2271cb f8094c;

    public /* synthetic */ bi(C2271cb c2271cb, LevelPlayAdError levelPlayAdError) {
        this.f8092a = 1;
        this.f8093b = levelPlayAdError;
        this.f8094c = c2271cb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8092a) {
            case 0:
                C2271cb.b(this.f8094c, this.f8093b);
                break;
            case 1:
                C2271cb.a(this.f8093b, this.f8094c);
                break;
            case 2:
                C2271cb.a(this.f8094c, this.f8093b);
                break;
            default:
                C2271cb.c(this.f8094c, this.f8093b);
                break;
        }
    }

    public /* synthetic */ bi(C2271cb c2271cb, LevelPlayAdError levelPlayAdError, int i2) {
        this.f8092a = i2;
        this.f8094c = c2271cb;
        this.f8093b = levelPlayAdError;
    }
}
