package androidx.camera.featurecombinationquery;

import android.hardware.camera2.CameraAccessException;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface CameraDeviceSetupCompatProvider {
    CameraDeviceSetupCompat getCameraDeviceSetupCompat(String str) throws CameraAccessException;
}
