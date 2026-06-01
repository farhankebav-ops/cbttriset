package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ForceCloseDeferrableSurface {
    private final boolean mHasConfigureSurfaceToSecondarySessionFailQuirk;
    private final boolean mHasPreviewOrientationIncorrectQuirk;
    private final boolean mHasTextureViewIsClosedQuirk;

    public ForceCloseDeferrableSurface(Quirks quirks, Quirks quirks2) {
        this.mHasTextureViewIsClosedQuirk = quirks2.contains(TextureViewIsClosedQuirk.class);
        this.mHasPreviewOrientationIncorrectQuirk = quirks.contains(PreviewOrientationIncorrectQuirk.class);
        this.mHasConfigureSurfaceToSecondarySessionFailQuirk = quirks.contains(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public void onSessionEnd(List<DeferrableSurface> list) {
        if (!shouldForceClose() || list == null) {
            return;
        }
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        Logger.d("ForceCloseDeferrableSurface", "deferrableSurface closed");
    }

    public boolean shouldForceClose() {
        return this.mHasTextureViewIsClosedQuirk || this.mHasPreviewOrientationIncorrectQuirk || this.mHasConfigureSurfaceToSecondarySessionFailQuirk;
    }
}
