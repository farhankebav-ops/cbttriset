package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class mi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2450mb f9453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LevelPlayAdInfo f9454c;

    public /* synthetic */ mi(C2450mb c2450mb, LevelPlayAdInfo levelPlayAdInfo, int i2) {
        this.f9452a = i2;
        this.f9453b = c2450mb;
        this.f9454c = levelPlayAdInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9452a) {
            case 0:
                C2450mb.a(this.f9453b, this.f9454c);
                break;
            default:
                C2450mb.b(this.f9453b, this.f9454c);
                break;
        }
    }
}
