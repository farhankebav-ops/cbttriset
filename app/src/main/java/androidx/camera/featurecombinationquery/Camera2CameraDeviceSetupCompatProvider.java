package androidx.camera.featurecombinationquery;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 35)
class Camera2CameraDeviceSetupCompatProvider implements CameraDeviceSetupCompatProvider {
    private final CameraManager mCameraManager;

    public Camera2CameraDeviceSetupCompatProvider(Context context) {
        this.mCameraManager = (CameraManager) context.getSystemService(CameraManager.class);
    }

    @Override // androidx.camera.featurecombinationquery.CameraDeviceSetupCompatProvider
    public CameraDeviceSetupCompat getCameraDeviceSetupCompat(String str) throws CameraAccessException {
        return new Camera2CameraDeviceSetupCompat(this.mCameraManager, str);
    }
}
