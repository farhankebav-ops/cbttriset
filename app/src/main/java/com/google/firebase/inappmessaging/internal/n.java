package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class n implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InAppMessageStreamManager f5646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5647c;

    public /* synthetic */ n(InAppMessageStreamManager inAppMessageStreamManager, String str, int i2) {
        this.f5645a = i2;
        this.f5646b = inAppMessageStreamManager;
        this.f5647c = str;
    }

    @Override // x4.c
    public final Object apply(Object obj) {
        switch (this.f5645a) {
            case 0:
                return this.f5646b.lambda$getTriggeredInAppMessageMaybe$27(this.f5647c, (q2.f) obj);
            default:
                return this.f5646b.lambda$createFirebaseInAppMessageStream$12(this.f5647c, (q2.f) obj);
        }
    }
}
