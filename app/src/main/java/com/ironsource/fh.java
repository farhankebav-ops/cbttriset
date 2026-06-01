package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class fh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LevelPlayAdInfo f8555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Da f8556c;

    public /* synthetic */ fh(LevelPlayAdInfo levelPlayAdInfo, Da da, int i2) {
        this.f8554a = i2;
        this.f8555b = levelPlayAdInfo;
        this.f8556c = da;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8554a) {
            case 0:
                Da.d(this.f8555b, this.f8556c);
                break;
            case 1:
                Da.b(this.f8555b, this.f8556c);
                break;
            case 2:
                Da.a(this.f8555b, this.f8556c);
                break;
            case 3:
                Da.e(this.f8555b, this.f8556c);
                break;
            default:
                Da.c(this.f8555b, this.f8556c);
                break;
        }
    }
}
