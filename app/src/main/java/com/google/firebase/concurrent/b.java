package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f5535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f5537d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j, TimeUnit timeUnit, int i2) {
        this.f5534a = i2;
        this.f5535b = delegatingScheduledExecutorService;
        this.e = obj;
        this.f5536c = j;
        this.f5537d = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f5534a) {
            case 0:
                return this.f5535b.lambda$schedule$2((Runnable) this.e, this.f5536c, this.f5537d, completer);
            default:
                return this.f5535b.lambda$schedule$5((Callable) this.e, this.f5536c, this.f5537d, completer);
        }
    }
}
