package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements VideoOutput {
    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo, int i2) {
        return a0.a(this, cameraInfo, i2);
    }

    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ Observable getMediaSpec() {
        return a0.b(this);
    }

    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ Observable getStreamInfo() {
        return a0.c(this);
    }

    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ Observable isSourceStreamRequired() {
        return a0.d(this);
    }

    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ void onSourceStateChanged(VideoOutput.SourceState sourceState) {
        a0.e(this, sourceState);
    }

    @Override // androidx.camera.video.VideoOutput
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        surfaceRequest.willNotProvideSurface();
    }

    @Override // androidx.camera.video.VideoOutput
    public final /* synthetic */ void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase, boolean z2) {
        a0.f(this, surfaceRequest, timebase, z2);
    }
}
