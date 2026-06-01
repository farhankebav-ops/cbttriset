package androidx.camera.extensions;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Identifier;
import androidx.camera.extensions.internal.ExtensionsUtils;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ExtensionCameraFilter implements CameraFilter {
    private final Identifier mId;
    private final VendorExtender mVendorExtender;

    public ExtensionCameraFilter(String str, VendorExtender vendorExtender) {
        this.mId = Identifier.create(str);
        this.mVendorExtender = vendorExtender;
    }

    @Override // androidx.camera.core.CameraFilter
    public List<CameraInfo> filter(List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo cameraInfo : list) {
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
            if (this.mVendorExtender.isExtensionAvailable(cameraInfoInternal.getCameraId(), ExtensionsUtils.getCameraCharacteristicsMap(cameraInfoInternal))) {
                arrayList.add(cameraInfo);
            }
        }
        return arrayList;
    }

    @Override // androidx.camera.core.CameraFilter
    public Identifier getIdentifier() {
        return this.mId;
    }
}
