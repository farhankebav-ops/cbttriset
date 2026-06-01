package com.mimikridev.ads.appopen;

import com.mimikridev.ads.listener.OnShowAdCompleteListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements OnShowAdCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10663a;

    public /* synthetic */ b(int i2) {
        this.f10663a = i2;
    }

    @Override // com.mimikridev.ads.listener.OnShowAdCompleteListener
    public final void onShowAdComplete() {
        switch (this.f10663a) {
            case 0:
                AppOpenAdManager.lambda$showAdIfAvailable$0();
                break;
            case 1:
                AppOpenAdMob.lambda$showAdIfAvailable$0();
                break;
            default:
                AppOpenAdPangle.lambda$showAdIfAvailable$0();
                break;
        }
    }
}
