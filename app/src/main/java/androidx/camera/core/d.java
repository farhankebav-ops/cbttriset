package androidx.camera.core;

import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.utils.futures.Futures;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static j2.q a(CameraControl cameraControl, boolean z2) {
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Not supported!"));
    }

    public static j2.q b(CameraControl cameraControl, int i2) {
        return Futures.immediateFailedFuture(new UnsupportedOperationException("Setting torch strength is not supported on the device."));
    }
}
