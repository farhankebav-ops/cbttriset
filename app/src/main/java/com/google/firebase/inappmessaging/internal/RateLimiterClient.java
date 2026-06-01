package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.RateLimitProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.RateLimit;
import com.google.firebase.inappmessaging.internal.time.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class RateLimiterClient {
    private static final RateLimitProto.RateLimit EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    private s4.h cachedRateLimts = e5.e.f11264a;
    private final Clock clock;
    private final ProtoStorageClient storageClient;

    public RateLimiterClient(@RateLimit ProtoStorageClient protoStorageClient, Clock clock) {
        this.storageClient = protoStorageClient;
        this.clock = clock;
    }

    private void clearInMemCache() {
        this.cachedRateLimts = e5.e.f11264a;
    }

    private s4.h getRateLimits() {
        s4.h hVar = this.cachedRateLimts;
        s4.h hVar2 = this.storageClient.read(RateLimitProto.RateLimit.parser());
        s sVar = new s(this, 0);
        hVar2.getClass();
        w1.f fVar = z4.b.f17984d;
        e5.s sVar2 = new e5.s(hVar2, sVar, fVar);
        hVar.getClass();
        return new e5.s(new e5.g(hVar, sVar2, 2), fVar, new s(this, 1));
    }

    private static RateLimitProto.Counter increment(RateLimitProto.Counter counter) {
        return RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(counter.getValue() + 1).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initInMemCache, reason: merged with bridge method [inline-methods] */
    public void lambda$increment$2(RateLimitProto.RateLimit rateLimit) {
        this.cachedRateLimts = s4.h.a(rateLimit);
    }

    private boolean isLimitExpired(RateLimitProto.Counter counter, com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        return this.clock.now() - counter.getStartTimeEpoch() > rateLimit.timeToLiveMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRateLimits$7(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$increment$0(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return !isLimitExpired(counter, rateLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RateLimitProto.RateLimit lambda$increment$1(RateLimitProto.RateLimit rateLimit, com.google.firebase.inappmessaging.model.RateLimit rateLimit2, RateLimitProto.Counter counter) throws Exception {
        return RateLimitProto.RateLimit.newBuilder(rateLimit).putLimits(rateLimit2.limiterKey(), increment(counter)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s4.c lambda$increment$3(RateLimitProto.RateLimit rateLimit) throws Exception {
        return this.storageClient.write(rateLimit).c(new a(9, this, rateLimit));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s4.c lambda$increment$4(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) throws Exception {
        RateLimitProto.Counter limitsOrDefault = rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
        z4.b.a(limitsOrDefault, "The item is null");
        f5.c cVar = new f5.c(new f5.n(limitsOrDefault), new t(this, rateLimit, 1), 1);
        RateLimitProto.Counter counterNewCounter = newCounter();
        z4.b.a(counterNewCounter, "The item is null");
        return new f5.l(new f5.c(new f5.c(cVar, new f5.n(counterNewCounter), 4), new a(10, rateLimit2, rateLimit), 3), new s(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RateLimitProto.Counter lambda$isRateLimited$5(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.RateLimit rateLimit2) throws Exception {
        return rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$isRateLimited$6(com.google.firebase.inappmessaging.model.RateLimit rateLimit, RateLimitProto.Counter counter) throws Exception {
        return isLimitExpired(counter, rateLimit) || counter.getValue() < rateLimit.limit();
    }

    private RateLimitProto.Counter newCounter() {
        return RateLimitProto.Counter.newBuilder().setValue(0L).setStartTimeEpoch(this.clock.now()).build();
    }

    public s4.q isRateLimited(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        s4.h rateLimits = getRateLimits();
        e5.p pVarA = s4.h.a(RateLimitProto.RateLimit.getDefaultInstance());
        rateLimits.getClass();
        return new e5.o(new e5.g(new e5.k(new e5.g(rateLimits, pVarA, 2), new t(this, rateLimit, 2), 1), new t(this, rateLimit, 3), 0));
    }

    public s4.a increment(com.google.firebase.inappmessaging.model.RateLimit rateLimit) {
        s4.h rateLimits = getRateLimits();
        RateLimitProto.RateLimit rateLimit2 = EMPTY_RATE_LIMITS;
        rateLimits.getClass();
        z4.b.a(rateLimit2, "item is null");
        return new e5.j(new e5.g(rateLimits, s4.h.a(rateLimit2), 2), new t(this, rateLimit, 0));
    }
}
