package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AutoFlashAEModeDisabler {
    private final boolean mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled;
    private final boolean mIsImageCaptureFailWithAutoFlashQuirkEnabled;

    public AutoFlashAEModeDisabler(Quirks quirks) {
        this.mIsImageCaptureFailWithAutoFlashQuirkEnabled = quirks.contains(ImageCaptureFailWithAutoFlashQuirk.class);
        this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled = DeviceQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
    }

    public int getCorrectedAeMode(int i2) {
        if ((this.mIsImageCaptureFailWithAutoFlashQuirkEnabled || this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled) && i2 == 2) {
            return 1;
        }
        return i2;
    }
}
