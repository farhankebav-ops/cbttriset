package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.onesignal.core.internal.config.InfluenceConfigModel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class StretchedVideoResolutionQuirk implements Quirk {
    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    public Size getAlternativeResolution(int i2) {
        if (i2 == 4) {
            return new Size(640, 480);
        }
        if (i2 == 5) {
            return new Size(960, 720);
        }
        if (i2 != 6) {
            return null;
        }
        return new Size(InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1080);
    }
}
