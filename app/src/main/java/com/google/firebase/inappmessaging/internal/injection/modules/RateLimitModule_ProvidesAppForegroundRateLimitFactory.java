package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground"})
@ScopeMetadata
@DaggerGenerated
public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements Factory<RateLimit> {
    private final RateLimitModule module;

    public RateLimitModule_ProvidesAppForegroundRateLimitFactory(RateLimitModule rateLimitModule) {
        this.module = rateLimitModule;
    }

    public static RateLimitModule_ProvidesAppForegroundRateLimitFactory create(RateLimitModule rateLimitModule) {
        return new RateLimitModule_ProvidesAppForegroundRateLimitFactory(rateLimitModule);
    }

    public static RateLimit providesAppForegroundRateLimit(RateLimitModule rateLimitModule) {
        return (RateLimit) Preconditions.checkNotNullFromProvides(rateLimitModule.providesAppForegroundRateLimit());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public RateLimit get() {
        return providesAppForegroundRateLimit(this.module);
    }
}
