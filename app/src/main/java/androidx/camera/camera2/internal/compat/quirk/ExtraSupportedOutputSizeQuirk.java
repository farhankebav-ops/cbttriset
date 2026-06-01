package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import com.onesignal.core.internal.config.InfluenceConfigModel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1080), new Size(960, 720)};
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isMotoE5Play();
    }

    public Size[] getExtraSupportedResolutions(int i2) {
        return (i2 == 34 && isMotoE5Play()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }

    public <T> Size[] getExtraSupportedResolutions(Class<T> cls) {
        if (StreamConfigurationMap.isOutputSupportedFor(cls) && isMotoE5Play()) {
            return getMotoE5PlayExtraSupportedResolutions();
        }
        return new Size[0];
    }
}
