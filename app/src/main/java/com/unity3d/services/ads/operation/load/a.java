package com.unity3d.services.ads.operation.load;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadOperationState f10984b;

    public /* synthetic */ a(LoadOperationState loadOperationState, int i2) {
        this.f10983a = i2;
        this.f10984b = loadOperationState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10983a) {
            case 0:
                LoadModuleDecoratorTimeout.lambda$onOperationTimeout$0(this.f10984b);
                break;
            default:
                this.f10984b.lambda$onUnityAdsAdLoaded$1();
                break;
        }
    }
}
