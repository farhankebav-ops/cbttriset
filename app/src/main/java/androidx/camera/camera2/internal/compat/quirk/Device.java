package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import java.util.Locale;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Device {
    public static final Device INSTANCE = new Device();

    private Device() {
    }

    private final boolean equalsCaseInsensitive(String str, String str2) {
        return t.g0(str, str2);
    }

    private final boolean isDeviceFrom(String str) {
        String MANUFACTURER = Build.MANUFACTURER;
        k.d(MANUFACTURER, "MANUFACTURER");
        if (equalsCaseInsensitive(MANUFACTURER, str)) {
            return true;
        }
        String BRAND = Build.BRAND;
        k.d(BRAND, "BRAND");
        return equalsCaseInsensitive(BRAND, str);
    }

    private final boolean isItelDevice() {
        return isDeviceFrom("Itel");
    }

    public static final boolean isUniSocChipsetDevice() {
        if (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        k.d(HARDWARE, "HARDWARE");
        Locale locale = Locale.ROOT;
        String lowerCase = HARDWARE.toLowerCase(locale);
        k.d(lowerCase, "toLowerCase(...)");
        if (t.n0(lowerCase, "ums", false)) {
            return true;
        }
        if (INSTANCE.isItelDevice()) {
            String lowerCase2 = HARDWARE.toLowerCase(locale);
            k.d(lowerCase2, "toLowerCase(...)");
            if (t.n0(lowerCase2, "sp", false)) {
                return true;
            }
        }
        return false;
    }
}
