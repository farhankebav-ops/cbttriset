package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements x4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImpressionStorageClient f5635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r2.f f5636c;

    public /* synthetic */ h(ImpressionStorageClient impressionStorageClient, r2.f fVar, int i2) {
        this.f5634a = i2;
        this.f5635b = impressionStorageClient;
        this.f5636c = fVar;
    }

    @Override // x4.a
    public final void run() throws Exception {
        switch (this.f5634a) {
            case 0:
                this.f5635b.lambda$clearImpressions$3(this.f5636c);
                break;
            default:
                this.f5635b.lambda$storeImpression$0(this.f5636c);
                break;
        }
    }
}
