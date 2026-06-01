package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MaxPreviewSize {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    public Size getMaxPreviewResolution(Size size) {
        Size verifiedResolution;
        ExtraCroppingQuirk extraCroppingQuirk = this.mExtraCroppingQuirk;
        return (extraCroppingQuirk == null || (verifiedResolution = extraCroppingQuirk.getVerifiedResolution(SurfaceConfig.ConfigType.PRIV)) == null) ? size : verifiedResolution.getHeight() * verifiedResolution.getWidth() > size.getHeight() * size.getWidth() ? verifiedResolution : size;
    }

    @VisibleForTesting
    public MaxPreviewSize(ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }
}
