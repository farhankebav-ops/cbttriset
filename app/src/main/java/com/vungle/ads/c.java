package com.vungle.ads;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VungleThreadPoolExecutor f11003b;

    public /* synthetic */ c(VungleThreadPoolExecutor vungleThreadPoolExecutor, int i2) {
        this.f11002a = i2;
        this.f11003b = vungleThreadPoolExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11002a) {
            case 0:
                AnalyticsClient.m3241initOrUpdate$lambda1(this.f11003b);
                break;
            case 1:
                VungleThreadPoolExecutor.m3316submit$lambda2(this.f11003b);
                break;
            case 2:
                VungleThreadPoolExecutor.m3314execute$lambda0(this.f11003b);
                break;
            default:
                VungleThreadPoolExecutor.m3315submit$lambda1(this.f11003b);
                break;
        }
    }
}
