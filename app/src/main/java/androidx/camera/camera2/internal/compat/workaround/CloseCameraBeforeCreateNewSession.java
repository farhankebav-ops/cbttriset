package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CloseCameraBeforeCreateNewSession {
    private CloseCameraBeforeCreateNewSession() {
    }

    public static boolean shouldCloseCamera(Quirks quirks) {
        return quirks.contains(LegacyCameraOutputConfigNullPointerQuirk.class) || quirks.contains(CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk.class);
    }
}
