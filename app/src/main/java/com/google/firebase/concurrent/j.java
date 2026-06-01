package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f5558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5559c;

    public /* synthetic */ j(Object obj, int i2, Runnable runnable) {
        this.f5557a = i2;
        this.f5558b = runnable;
        this.f5559c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5557a) {
            case 0:
                return LimitedConcurrencyExecutorService.lambda$submit$0(this.f5558b, this.f5559c);
            default:
                return PausableExecutorServiceImpl.lambda$submit$0(this.f5558b, this.f5559c);
        }
    }
}
