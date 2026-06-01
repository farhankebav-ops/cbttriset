package androidx.camera.video;

import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface VideoOutput {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo, int i2);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<MediaSpec> getMediaSpec();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<StreamInfo> getStreamInfo();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<Boolean> isSourceStreamRequired();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSourceStateChanged(SourceState sourceState);

    void onSurfaceRequested(SurfaceRequest surfaceRequest);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase, boolean z2);
}
