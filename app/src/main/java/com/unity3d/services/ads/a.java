package com.unity3d.services.ads;

import com.unity3d.ads.IUnityAdsInitializationListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IUnityAdsInitializationListener f10981b;

    public /* synthetic */ a(IUnityAdsInitializationListener iUnityAdsInitializationListener, int i2) {
        this.f10980a = i2;
        this.f10981b = iUnityAdsInitializationListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10980a) {
            case 0:
                UnityAdsImplementation.lambda$initialize$0(this.f10981b);
                break;
            default:
                this.f10981b.onInitializationComplete();
                break;
        }
    }
}
