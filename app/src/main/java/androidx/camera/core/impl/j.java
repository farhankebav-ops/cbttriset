package androidx.camera.core.impl;

import androidx.camera.camera2.internal.concurrent.Camera2CameraCoordinator;
import androidx.camera.core.CameraFilter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements CameraFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3615b;

    public /* synthetic */ j(Object obj, int i2) {
        this.f3614a = i2;
        this.f3615b = obj;
    }

    @Override // androidx.camera.core.CameraFilter
    public final List filter(List list) {
        switch (this.f3614a) {
            case 0:
                return k.o((CameraInfoInternal) this.f3615b, list);
            default:
                return Camera2CameraCoordinator.lambda$createCameraSelectorById$0((String) this.f3615b, list);
        }
    }

    @Override // androidx.camera.core.CameraFilter
    public final /* synthetic */ Identifier getIdentifier() {
        switch (this.f3614a) {
        }
        return androidx.camera.core.g.a(this);
    }
}
