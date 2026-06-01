package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FlashAvailabilityChecker {
    private static final String TAG = "FlashAvailability";

    private FlashAvailabilityChecker() {
    }

    public static boolean isFlashAvailable(CameraCharacteristicsProvider cameraCharacteristicsProvider) {
        return isFlashAvailable(false, cameraCharacteristicsProvider);
    }

    public static boolean isFlashAvailable(boolean z2, CameraCharacteristicsProvider cameraCharacteristicsProvider) {
        Boolean bool;
        try {
            bool = (Boolean) cameraCharacteristicsProvider.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e) {
            if (DeviceQuirks.get(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                Logger.d(TAG, String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)));
            } else {
                Logger.e(TAG, String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)), e);
            }
            if (z2) {
                throw e;
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            Logger.w(TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
