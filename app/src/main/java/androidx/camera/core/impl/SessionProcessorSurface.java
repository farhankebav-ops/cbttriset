package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionProcessorSurface extends DeferrableSurface {
    private final int mOutputConfigId;
    private final Surface mSurface;

    public SessionProcessorSurface(Surface surface, int i2) {
        this.mSurface = surface;
        this.mOutputConfigId = i2;
    }

    public int getOutputConfigId() {
        return this.mOutputConfigId;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public j2.q provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
