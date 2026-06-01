package com.unity3d.ads.core.domain;

import com.unity3d.services.core.log.DeviceLog;
import q6.x;
import q6.y;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1 extends v5.a implements y {
    public CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1(x xVar) {
        super(xVar);
    }

    @Override // q6.y
    public void handleException(h hVar, Throwable th) {
        DeviceLog.debug("CleanUpExpiredOpportunity: " + th.getMessage());
    }
}
