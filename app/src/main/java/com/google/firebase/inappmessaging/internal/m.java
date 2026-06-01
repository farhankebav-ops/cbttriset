package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class m implements x4.b, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q2.f f5644b;

    public /* synthetic */ m(q2.f fVar, int i2) {
        this.f5643a = i2;
        this.f5644b = fVar;
    }

    @Override // x4.b
    public void accept(Object obj) {
        InAppMessageStreamManager.logImpressionStatus(this.f5644b, (Boolean) obj);
    }

    @Override // x4.c
    public Object apply(Object obj) {
        switch (this.f5643a) {
            case 1:
                return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(this.f5644b, (Boolean) obj);
            default:
                return InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$10(this.f5644b, (Boolean) obj);
        }
    }
}
