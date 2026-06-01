package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Quirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;
import androidx.camera.extensions.internal.compat.quirk.EnsurePostviewFormatEquivalenceQuirk;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PostviewFormatValidator {
    private final Quirk quirk = DeviceQuirks.get(EnsurePostviewFormatEquivalenceQuirk.class);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getPostviewFormatSelector$lambda$1$lambda$0(int i2, List supportedPostviewFormats) {
        k.e(supportedPostviewFormats, "supportedPostviewFormats");
        if (supportedPostviewFormats.contains(Integer.valueOf(i2))) {
            return i2;
        }
        return 0;
    }

    public final CameraConfig.PostviewFormatSelector getPostviewFormatSelector() {
        if (this.quirk != null) {
            return new b();
        }
        CameraConfig.PostviewFormatSelector DEFAULT_POSTVIEW_FORMAT_SELECTOR = CameraConfig.DEFAULT_POSTVIEW_FORMAT_SELECTOR;
        k.d(DEFAULT_POSTVIEW_FORMAT_SELECTOR, "DEFAULT_POSTVIEW_FORMAT_SELECTOR");
        return DEFAULT_POSTVIEW_FORMAT_SELECTOR;
    }
}
