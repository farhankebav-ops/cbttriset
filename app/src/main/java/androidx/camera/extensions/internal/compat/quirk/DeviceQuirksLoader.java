package androidx.camera.extensions.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings quirkSettings) {
        ArrayList arrayList = new ArrayList();
        if (quirkSettings.shouldEnableQuirk(ExtensionDisabledQuirk.class, ExtensionDisabledQuirk.load())) {
            arrayList.add(new ExtensionDisabledQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(CrashWhenOnDisableTooSoon.class, CrashWhenOnDisableTooSoon.load())) {
            arrayList.add(new CrashWhenOnDisableTooSoon());
        }
        if (quirkSettings.shouldEnableQuirk(GetAvailableKeysNeedsOnInit.class, GetAvailableKeysNeedsOnInit.load())) {
            arrayList.add(new GetAvailableKeysNeedsOnInit());
        }
        if (quirkSettings.shouldEnableQuirk(CaptureOutputSurfaceOccupiedQuirk.class, CaptureOutputSurfaceOccupiedQuirk.load())) {
            arrayList.add(new CaptureOutputSurfaceOccupiedQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(EnsurePostviewFormatEquivalenceQuirk.class, EnsurePostviewFormatEquivalenceQuirk.load())) {
            arrayList.add(new EnsurePostviewFormatEquivalenceQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(AvoidPostviewAvailabilityCheckQuirk.class, AvoidPostviewAvailabilityCheckQuirk.load())) {
            arrayList.add(new AvoidPostviewAvailabilityCheckQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(AvoidCaptureProcessProgressAvailabilityCheckQuirk.class, AvoidCaptureProcessProgressAvailabilityCheckQuirk.load())) {
            arrayList.add(new AvoidCaptureProcessProgressAvailabilityCheckQuirk());
        }
        return arrayList;
    }
}
