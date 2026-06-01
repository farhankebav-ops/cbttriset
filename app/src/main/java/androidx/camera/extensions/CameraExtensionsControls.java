package androidx.camera.extensions;

import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.AdapterCameraControl;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class CameraExtensionsControls {
    private CameraExtensionsControls() {
    }

    public static CameraExtensionsControl from(CameraControl cameraControl) {
        Preconditions.checkArgument(cameraControl instanceof AdapterCameraControl, "The input camera control must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((AdapterCameraControl) cameraControl).getSessionProcessor();
        if (sessionProcessor instanceof CameraExtensionsControl) {
            return (CameraExtensionsControl) sessionProcessor;
        }
        return null;
    }
}
