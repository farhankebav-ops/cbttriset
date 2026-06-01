package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class EncoderNotUsePersistentInputSurfaceQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = Arrays.asList("SM-N9208", "SM-G920V");

    public static boolean load() {
        return DEVICE_MODELS.contains(Build.MODEL.toUpperCase());
    }
}
