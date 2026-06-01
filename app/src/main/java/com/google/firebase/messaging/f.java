package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f5684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f5685c;

    public /* synthetic */ f(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource, int i2) {
        this.f5683a = i2;
        this.f5684b = firebaseMessaging;
        this.f5685c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5683a) {
            case 0:
                this.f5684b.lambda$deleteToken$9(this.f5685c);
                break;
            case 1:
                this.f5684b.lambda$getToken$7(this.f5685c);
                break;
            default:
                this.f5684b.lambda$deleteToken$8(this.f5685c);
                break;
        }
    }
}
