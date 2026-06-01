package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.extensions.internal.compat.quirk.AvoidCaptureProcessProgressAvailabilityCheckQuirk;
import androidx.camera.extensions.internal.compat.quirk.AvoidPostviewAvailabilityCheckQuirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionCharacteristicsAccessGuard {
    private final AvoidPostviewAvailabilityCheckQuirk avoidPostviewAvailabilityCheckQuirk = (AvoidPostviewAvailabilityCheckQuirk) DeviceQuirks.get(AvoidPostviewAvailabilityCheckQuirk.class);
    private final AvoidCaptureProcessProgressAvailabilityCheckQuirk avoidCaptureProcessProgressAvailabilityCheckQuirk = (AvoidCaptureProcessProgressAvailabilityCheckQuirk) DeviceQuirks.get(AvoidCaptureProcessProgressAvailabilityCheckQuirk.class);

    public final boolean allowCaptureProcessProgressAvailabilityCheck() {
        return this.avoidCaptureProcessProgressAvailabilityCheckQuirk == null;
    }

    public final boolean allowPostviewAvailabilityCheck() {
        return this.avoidPostviewAvailabilityCheckQuirk == null;
    }
}
