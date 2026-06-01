package com.vungle.ads.internal.util;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConcurrencyTimeoutProvider {
    public static final Companion Companion = new Companion(null);
    private static final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public final long getTimeout() {
        return ThreadUtil.INSTANCE.isMainThread() ? OPERATION_TIMEOUT : LocationRequestCompat.PASSIVE_INTERVAL;
    }
}
