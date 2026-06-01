package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f5539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f5540c;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i2) {
        this.f5538a = i2;
        this.f5539b = runnable;
        this.f5540c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f5538a) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f5539b, this.f5540c);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.f5539b, this.f5540c);
                break;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f5539b, this.f5540c);
                break;
        }
    }
}
