package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class s implements x4.b, x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f5663b;

    public /* synthetic */ s(RateLimiterClient rateLimiterClient, int i2) {
        this.f5662a = i2;
        this.f5663b = rateLimiterClient;
    }

    @Override // x4.b
    public void accept(Object obj) throws Exception {
        switch (this.f5662a) {
            case 0:
                this.f5663b.lambda$increment$2((RateLimitProto.RateLimit) obj);
                break;
            default:
                this.f5663b.lambda$getRateLimits$7((Throwable) obj);
                break;
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        return this.f5663b.lambda$increment$3((RateLimitProto.RateLimit) obj);
    }
}
