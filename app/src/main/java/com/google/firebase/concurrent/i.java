package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f5556b;

    public /* synthetic */ i(Runnable runnable, int i2) {
        this.f5555a = i2;
        this.f5556b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5555a) {
            case 0:
                return LimitedConcurrencyExecutorService.lambda$submit$1(this.f5556b);
            default:
                return PausableExecutorServiceImpl.lambda$submit$1(this.f5556b);
        }
    }
}
