package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExtensionDisabledQuirk implements Quirk {
    private static boolean isAdvancedExtenderSupported() {
        return ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_2) && ExtensionVersion.isAdvancedExtenderSupported();
    }

    private static boolean isMoto() {
        return "motorola".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean isPixel5() {
        return AndroidStaticDeviceInfoDataSource.STORE_GOOGLE.equalsIgnoreCase(Build.BRAND) && "redfin".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean isRealme() {
        return "realme".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean isSamsungA52s5g() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "a52sxq".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean load() {
        return isPixel5() || isMoto() || isRealme() || isSamsungA52s5g();
    }

    private static boolean shouldDisableForSamsungA52s5g(String str) {
        return str.equals("0");
    }

    public boolean shouldDisableExtension(String str) {
        if (isPixel5() && !isAdvancedExtenderSupported()) {
            return true;
        }
        if (isMoto() && ExtensionVersion.isMaximumCompatibleVersion(Version.VERSION_1_1)) {
            return true;
        }
        if (isRealme() && ExtensionVersion.isMaximumCompatibleVersion(Version.VERSION_1_1)) {
            return true;
        }
        if (isSamsungA52s5g()) {
            return shouldDisableForSamsungA52s5g(str);
        }
        return false;
    }
}
