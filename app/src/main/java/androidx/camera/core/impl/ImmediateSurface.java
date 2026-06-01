package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(Surface surface, Size size, int i2) {
        super(size, i2);
        this.mSurface = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public j2.q provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }

    public ImmediateSurface(Surface surface) {
        this.mSurface = surface;
    }
}
