package androidx.camera.core.processing;

import androidx.camera.core.impl.DeferrableSurface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f3725b;

    public /* synthetic */ n(DeferrableSurface deferrableSurface, int i2) {
        this.f3724a = i2;
        this.f3725b = deferrableSurface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3724a) {
            case 0:
                this.f3725b.close();
                break;
            default:
                this.f3725b.decrementUseCount();
                break;
        }
    }
}
