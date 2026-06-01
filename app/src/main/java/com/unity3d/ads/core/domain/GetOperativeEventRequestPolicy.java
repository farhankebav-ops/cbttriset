package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetOperativeEventRequestPolicy implements GetRequestPolicy {
    private final SessionRepository sessionRepository;

    public GetOperativeEventRequestPolicy(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetRequestPolicy
    public RequestPolicy invoke() {
        return new RequestPolicy(this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getMaxDuration(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getRetryMaxInterval(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getRetryWaitBase(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getRetryJitterPct(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getRetryScalingFactor(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getTimeoutPolicy().getConnectTimeoutMs(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getTimeoutPolicy().getReadTimeoutMs(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getTimeoutPolicy().getWriteTimeoutMs(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getTimeoutPolicy().getOverallTimeoutMs(), this.sessionRepository.getNativeConfiguration().getOperativeEventPolicy().getRetryPolicy().getShouldStoreLocally());
    }
}
