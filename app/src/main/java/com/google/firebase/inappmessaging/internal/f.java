package com.google.firebase.inappmessaging.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements x4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DisplayCallbacksImpl f5632b;

    public /* synthetic */ f(DisplayCallbacksImpl displayCallbacksImpl, int i2) {
        this.f5631a = i2;
        this.f5632b = displayCallbacksImpl;
    }

    @Override // x4.a
    public final void run() throws Exception {
        switch (this.f5631a) {
            case 0:
                this.f5632b.lambda$updateWasImpressed$1();
                break;
            default:
                this.f5632b.lambda$impressionDetected$0();
                break;
        }
    }
}
