package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class PreviewPixelHDRnetQuirk implements Quirk {
    private static final List<String> SUPPORTED_DEVICES = Arrays.asList("sunfish", "bramble", "redfin", "barbet");

    public static boolean load() {
        return "Google".equals(Build.MANUFACTURER) && SUPPORTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.getDefault()));
    }
}
