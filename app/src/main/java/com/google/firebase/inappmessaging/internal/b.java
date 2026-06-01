package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements x4.b, x4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CampaignCacheClient f5622b;

    public /* synthetic */ b(CampaignCacheClient campaignCacheClient, int i2) {
        this.f5621a = i2;
        this.f5622b = campaignCacheClient;
    }

    @Override // x4.b
    public void accept(Object obj) throws Exception {
        switch (this.f5621a) {
            case 0:
                this.f5622b.lambda$get$2((r2.o) obj);
                break;
            default:
                this.f5622b.lambda$get$3((Throwable) obj);
                break;
        }
    }

    @Override // x4.d
    public boolean test(Object obj) {
        return this.f5622b.isResponseValid((r2.o) obj);
    }
}
