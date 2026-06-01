package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class t implements x4.c, x4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RateLimiterClient f5665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RateLimit f5666c;

    public /* synthetic */ t(RateLimiterClient rateLimiterClient, RateLimit rateLimit, int i2) {
        this.f5664a = i2;
        this.f5665b = rateLimiterClient;
        this.f5666c = rateLimit;
    }

    @Override // x4.c
    public Object apply(Object obj) {
        switch (this.f5664a) {
            case 0:
                return this.f5665b.lambda$increment$4(this.f5666c, (RateLimitProto.RateLimit) obj);
            default:
                return this.f5665b.lambda$isRateLimited$5(this.f5666c, (RateLimitProto.RateLimit) obj);
        }
    }

    @Override // x4.d
    public boolean test(Object obj) {
        switch (this.f5664a) {
            case 1:
                return this.f5665b.lambda$increment$0(this.f5666c, (RateLimitProto.Counter) obj);
            default:
                return this.f5665b.lambda$isRateLimited$6(this.f5666c, (RateLimitProto.Counter) obj);
        }
    }
}
