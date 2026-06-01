package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> BUILD_MODELS = Arrays.asList("itel w6004");
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = Arrays.asList("sm-j700f", "sm-j710f");

    public static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        List<String> list = BUILD_MODELS_FRONT_CAMERA;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        return (list.contains(str.toLowerCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) || BUILD_MODELS.contains(str.toLowerCase(locale));
    }
}
