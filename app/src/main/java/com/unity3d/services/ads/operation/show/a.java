package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShowOperationState f10986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UnityAds.UnityAdsShowError f10987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10988d;

    public /* synthetic */ a(ShowOperationState showOperationState, UnityAds.UnityAdsShowError unityAdsShowError, String str, int i2) {
        this.f10985a = i2;
        this.f10986b = showOperationState;
        this.f10987c = unityAdsShowError;
        this.f10988d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10985a) {
            case 0:
                this.f10986b.onUnityAdsShowFailure(this.f10987c, this.f10988d);
                break;
            default:
                this.f10986b.lambda$onUnityAdsShowFailure$0(this.f10987c, this.f10988d);
                break;
        }
    }
}
