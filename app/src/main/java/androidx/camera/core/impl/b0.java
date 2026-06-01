package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseAttachState;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements UseCaseAttachState.AttachStateFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3612a;

    public /* synthetic */ b0(int i2) {
        this.f3612a = i2;
    }

    @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        switch (this.f3612a) {
            case 0:
                return useCaseAttachInfo.getAttached();
            case 1:
                return useCaseAttachInfo.getAttached();
            case 2:
                return useCaseAttachInfo.getAttached();
            default:
                return UseCaseAttachState.lambda$getActiveAndAttachedSessionConfigs$3(useCaseAttachInfo);
        }
    }
}
