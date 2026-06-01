package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraPresenceProvider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraPresenceProvider.ListenerWrapper f3617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f3618c;

    public /* synthetic */ m(CameraPresenceProvider.ListenerWrapper listenerWrapper, Set set, int i2) {
        this.f3616a = i2;
        this.f3617b = listenerWrapper;
        this.f3618c = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3616a) {
            case 0:
                CameraPresenceProvider.notifyPublicCamerasRemoved$lambda$25$lambda$24(this.f3617b, this.f3618c);
                break;
            default:
                CameraPresenceProvider.notifyPublicCamerasAdded$lambda$23$lambda$22(this.f3617b, this.f3618c);
                break;
        }
    }
}
