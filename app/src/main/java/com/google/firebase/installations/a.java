package com.google.firebase.installations;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f5668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f5669c;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z2, int i2) {
        this.f5667a = i2;
        this.f5668b = firebaseInstallations;
        this.f5669c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5667a) {
            case 0:
                this.f5668b.lambda$doRegistrationOrRefresh$3(this.f5669c);
                break;
            default:
                this.f5668b.lambda$getToken$2(this.f5669c);
                break;
        }
    }
}
