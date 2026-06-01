package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a0 {
    public static VideoCapabilities a(VideoOutput videoOutput, CameraInfo cameraInfo, int i2) {
        return VideoCapabilities.EMPTY;
    }

    public static Observable b(VideoOutput videoOutput) {
        return ConstantObservable.withValue(null);
    }

    public static Observable c(VideoOutput videoOutput) {
        return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
    }

    public static Observable d(VideoOutput videoOutput) {
        return ConstantObservable.withValue(Boolean.FALSE);
    }

    public static void f(VideoOutput videoOutput, SurfaceRequest surfaceRequest, Timebase timebase, boolean z2) {
        videoOutput.onSurfaceRequested(surfaceRequest);
    }

    public static void e(VideoOutput videoOutput, VideoOutput.SourceState sourceState) {
    }
}
