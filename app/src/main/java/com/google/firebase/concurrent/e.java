package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements DelegatingScheduledFuture.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f5546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f5547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f5548d;
    public final /* synthetic */ long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f5549f;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j, long j3, TimeUnit timeUnit, int i2) {
        this.f5545a = i2;
        this.f5546b = delegatingScheduledExecutorService;
        this.f5547c = runnable;
        this.f5548d = j;
        this.e = j3;
        this.f5549f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f5545a) {
            case 0:
                return this.f5546b.lambda$scheduleAtFixedRate$8(this.f5547c, this.f5548d, this.e, this.f5549f, completer);
            default:
                return this.f5546b.lambda$scheduleWithFixedDelay$11(this.f5547c, this.f5548d, this.e, this.f5549f, completer);
        }
    }
}
