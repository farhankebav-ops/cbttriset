package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f5577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5579d;

    public /* synthetic */ f(CrashlyticsCore crashlyticsCore, String str, String str2, int i2) {
        this.f5576a = i2;
        this.f5577b = crashlyticsCore;
        this.f5578c = str;
        this.f5579d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5576a) {
            case 0:
                this.f5577b.lambda$setCustomKey$5(this.f5578c, this.f5579d);
                break;
            default:
                this.f5577b.lambda$setInternalKey$7(this.f5578c, this.f5579d);
                break;
        }
    }
}
