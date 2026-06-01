package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class k implements x4.b, x4.c, x4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f5641b;

    public /* synthetic */ k(InAppMessageStreamManager inAppMessageStreamManager, int i2) {
        this.f5640a = i2;
        this.f5641b = inAppMessageStreamManager;
    }

    @Override // x4.b
    public void accept(Object obj) throws Exception {
        switch (this.f5640a) {
            case 0:
                this.f5641b.lambda$createFirebaseInAppMessageStream$18((r2.o) obj);
                break;
            default:
                this.f5641b.lambda$createFirebaseInAppMessageStream$6((r2.o) obj);
                break;
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        switch (this.f5640a) {
            case 1:
                return this.f5641b.lambda$createFirebaseInAppMessageStream$21((String) obj);
            default:
                return this.f5641b.lambda$createFirebaseInAppMessageStream$11((q2.f) obj);
        }
    }

    @Override // x4.d
    public boolean test(Object obj) {
        return this.f5641b.lambda$getTriggeredInAppMessageMaybe$25((q2.f) obj);
    }
}
