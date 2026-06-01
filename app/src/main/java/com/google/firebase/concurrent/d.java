package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f5542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f5543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f5544d;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i2) {
        this.f5541a = i2;
        this.f5542b = delegatingScheduledExecutorService;
        this.f5543c = runnable;
        this.f5544d = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5541a) {
            case 0:
                this.f5542b.lambda$scheduleWithFixedDelay$10(this.f5543c, this.f5544d);
                break;
            case 1:
                this.f5542b.lambda$scheduleAtFixedRate$7(this.f5543c, this.f5544d);
                break;
            default:
                this.f5542b.lambda$schedule$1(this.f5543c, this.f5544d);
                break;
        }
    }
}
