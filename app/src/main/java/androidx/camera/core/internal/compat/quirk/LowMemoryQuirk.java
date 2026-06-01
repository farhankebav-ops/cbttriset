package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class LowMemoryQuirk implements Quirk {
    private static final Set<String> DEVICE_MODELS = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));

    public static boolean load() {
        return DEVICE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
