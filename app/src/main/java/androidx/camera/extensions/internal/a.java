package androidx.camera.extensions.internal;

import android.content.Context;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static SessionProcessor a(VendorExtender vendorExtender, Context context) {
        return null;
    }

    public static List b(VendorExtender vendorExtender) {
        return Collections.EMPTY_LIST;
    }

    public static Range c(VendorExtender vendorExtender, Size size) {
        return null;
    }

    public static List d(VendorExtender vendorExtender) {
        return Collections.EMPTY_LIST;
    }

    public static List e(VendorExtender vendorExtender) {
        return Collections.EMPTY_LIST;
    }

    public static Map f(VendorExtender vendorExtender, Size size) {
        return Collections.EMPTY_MAP;
    }

    public static List g(VendorExtender vendorExtender) {
        return Collections.EMPTY_LIST;
    }

    public static Size[] h(VendorExtender vendorExtender) {
        return new Size[0];
    }

    public static boolean j(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean k(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean l(VendorExtender vendorExtender, String str, Map map) {
        return false;
    }

    public static boolean m(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean n(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean o(VendorExtender vendorExtender) {
        Version version = Version.VERSION_1_2;
        if (ClientVersion.isMaximumCompatibleVersion(version) || ExtensionVersion.isMaximumCompatibleVersion(version)) {
            return false;
        }
        return !vendorExtender.getSupportedCaptureResultKeys().isEmpty();
    }

    public static void i(VendorExtender vendorExtender, CameraInfo cameraInfo) {
    }
}
