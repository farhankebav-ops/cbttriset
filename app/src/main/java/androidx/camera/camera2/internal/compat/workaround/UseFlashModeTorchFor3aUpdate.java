package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class UseFlashModeTorchFor3aUpdate {
    private static final String TAG = "UseFlashModeTorchFor3aUpdate";
    private final TorchFlashRequiredFor3aUpdateQuirk mTorchFlashRequiredFor3AUpdateQuirk;

    public UseFlashModeTorchFor3aUpdate(Quirks quirks) {
        this.mTorchFlashRequiredFor3AUpdateQuirk = (TorchFlashRequiredFor3aUpdateQuirk) quirks.get(TorchFlashRequiredFor3aUpdateQuirk.class);
    }

    public boolean shouldUseFlashModeTorch() {
        TorchFlashRequiredFor3aUpdateQuirk torchFlashRequiredFor3aUpdateQuirk = this.mTorchFlashRequiredFor3AUpdateQuirk;
        boolean z2 = torchFlashRequiredFor3aUpdateQuirk != null && torchFlashRequiredFor3aUpdateQuirk.isFlashModeTorchRequired();
        Logger.d(TAG, "shouldUseFlashModeTorch: " + z2);
        return z2;
    }
}
