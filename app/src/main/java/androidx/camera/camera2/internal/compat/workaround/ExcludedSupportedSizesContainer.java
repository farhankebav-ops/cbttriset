package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExcludedSupportedSizesContainer {
    private final String mCameraId;

    public ExcludedSupportedSizesContainer(String str) {
        this.mCameraId = str;
    }

    public List<Size> get(int i2) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        return excludedSupportedSizesQuirk == null ? new ArrayList() : excludedSupportedSizesQuirk.getExcludedSizes(this.mCameraId, i2);
    }

    public List<Size> get(Class<?> cls) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) DeviceQuirks.get(ExcludedSupportedSizesQuirk.class);
        if (excludedSupportedSizesQuirk == null) {
            return new ArrayList();
        }
        return excludedSupportedSizesQuirk.getExcludedSizes(this.mCameraId, cls);
    }
}
