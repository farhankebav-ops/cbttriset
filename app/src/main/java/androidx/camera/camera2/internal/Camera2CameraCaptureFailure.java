package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraCaptureFailure extends CameraCaptureFailure {
    private final CaptureFailure mCaptureFailure;

    public Camera2CameraCaptureFailure(CameraCaptureFailure.Reason reason, CaptureFailure captureFailure) {
        super(reason);
        this.mCaptureFailure = captureFailure;
    }

    @Override // androidx.camera.core.impl.CameraCaptureFailure
    public Object getCaptureFailure() {
        return this.mCaptureFailure;
    }
}
