package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.AutoValue_RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RateLimit {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        public abstract RateLimit build();

        public abstract Builder setLimit(long j);

        public abstract Builder setLimiterKey(String str);

        public abstract Builder setTimeToLiveMillis(long j);
    }

    public static Builder builder() {
        return new AutoValue_RateLimit.Builder();
    }

    public abstract long limit();

    public abstract String limiterKey();

    public abstract long timeToLiveMillis();
}
