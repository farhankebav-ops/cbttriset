package androidx.camera.core;

import androidx.camera.core.RetryPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements RetryPolicy {
    @Override // androidx.camera.core.RetryPolicy
    public final /* synthetic */ long getTimeoutInMillis() {
        return d0.a(this);
    }

    @Override // androidx.camera.core.RetryPolicy
    public final RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState executionState) {
        return RetryPolicy.RetryConfig.NOT_RETRY;
    }
}
