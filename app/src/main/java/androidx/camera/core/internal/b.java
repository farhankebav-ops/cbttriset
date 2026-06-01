package androidx.camera.core.internal;

import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Preview.SurfaceProvider {
    @Override // androidx.camera.core.Preview.SurfaceProvider
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        CameraUseCaseAdapter.lambda$createExtraPreview$1(surfaceRequest);
    }
}
