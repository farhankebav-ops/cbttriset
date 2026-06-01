package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class OverrideAeModeForStillCapture {
    private boolean mAePrecaptureStarted = false;
    private final boolean mHasAutoFlashUnderExposedQuirk;

    public OverrideAeModeForStillCapture(Quirks quirks) {
        this.mHasAutoFlashUnderExposedQuirk = quirks.get(AutoFlashUnderExposedQuirk.class) != null;
    }

    public void onAePrecaptureFinished() {
        this.mAePrecaptureStarted = false;
    }

    public void onAePrecaptureStarted() {
        this.mAePrecaptureStarted = true;
    }

    public boolean shouldSetAeModeAlwaysFlash(int i2) {
        return this.mAePrecaptureStarted && i2 == 0 && this.mHasAutoFlashUnderExposedQuirk;
    }
}
