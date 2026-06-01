package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.model.RateLimit;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class RateLimitModule {
    private static final String APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY = "APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY";

    @Provides
    @AppForeground
    public RateLimit providesAppForegroundRateLimit() {
        return RateLimit.builder().setLimit(1L).setLimiterKey(APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY).setTimeToLiveMillis(TimeUnit.DAYS.toMillis(1L)).build();
    }
}
