package com.unity3d.ads.core.domain;

import androidx.core.location.LocationRequestCompat;
import com.unity3d.ads.core.data.model.InitializationState;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AwaitInitialization {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(AwaitInitialization awaitInitialization, long j, c cVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i2 & 1) != 0) {
                j = LocationRequestCompat.PASSIVE_INTERVAL;
            }
            return awaitInitialization.invoke(j, cVar);
        }
    }

    Object invoke(long j, c<? super InitializationState> cVar);
}
