package androidx.camera.extensions;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class CameraExtensionsInfos {
    private static final CameraExtensionsInfo NORMAL_MODE_CAMERA_EXTENSIONS_INFO = new CameraExtensionsInfo() { // from class: androidx.camera.extensions.CameraExtensionsInfos.1
        @Override // androidx.camera.extensions.CameraExtensionsInfo
        public final /* synthetic */ LiveData getCurrentExtensionMode() {
            return b.a(this);
        }

        @Override // androidx.camera.extensions.CameraExtensionsInfo
        public final /* synthetic */ LiveData getExtensionStrength() {
            return b.b(this);
        }

        @Override // androidx.camera.extensions.CameraExtensionsInfo
        public final /* synthetic */ boolean isCurrentExtensionModeAvailable() {
            return b.c(this);
        }

        @Override // androidx.camera.extensions.CameraExtensionsInfo
        public final /* synthetic */ boolean isExtensionStrengthAvailable() {
            return b.d(this);
        }
    };

    private CameraExtensionsInfos() {
    }

    public static CameraExtensionsInfo from(CameraInfo cameraInfo) {
        Preconditions.checkArgument(cameraInfo instanceof AdapterCameraInfo, "The input camera info must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((AdapterCameraInfo) cameraInfo).getSessionProcessor();
        return sessionProcessor instanceof CameraExtensionsInfo ? (CameraExtensionsInfo) sessionProcessor : NORMAL_MODE_CAMERA_EXTENSIONS_INFO;
    }
}
