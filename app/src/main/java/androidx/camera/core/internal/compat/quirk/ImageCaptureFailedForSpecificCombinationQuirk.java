package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageCaptureFailedForSpecificCombinationQuirk implements Quirk {
    private static final Set<String> PIXEL_MODELS = new HashSet(Arrays.asList("pixel 4a", "pixel 4a (5g)", "pixel 5", "pixel 5a"));

    private static boolean isOnePlus12() {
        return "oneplus".equalsIgnoreCase(Build.BRAND) && "cph2583".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isPixelProblematicDevice() {
        return AndroidStaticDeviceInfoDataSource.STORE_GOOGLE.equalsIgnoreCase(Build.BRAND) && PIXEL_MODELS.contains(Build.MODEL.toLowerCase());
    }

    private boolean isVideoCapturePreviewImageCaptureCombination(Collection<UseCase> collection) {
        if (collection.size() != 3) {
            return false;
        }
        boolean z2 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                z2 = true;
            } else if (useCase instanceof ImageCapture) {
                z8 = true;
            } else if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                z7 = useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            }
        }
        return z2 && z7 && z8;
    }

    public static boolean load() {
        return isOnePlus12() || isPixelProblematicDevice();
    }

    private boolean shouldForceEnableStreamSharingForOnePlus12(String str, Collection<UseCase> collection) {
        return str.equals("1") && isVideoCapturePreviewImageCaptureCombination(collection);
    }

    private boolean shouldForceEnableStreamSharingForPixelDevice(String str, Collection<UseCase> collection) {
        return str.equals("1") && isVideoCapturePreviewImageCaptureCombination(collection);
    }

    public boolean shouldForceEnableStreamSharing(String str, Collection<UseCase> collection) {
        if (isOnePlus12()) {
            return shouldForceEnableStreamSharingForOnePlus12(str, collection);
        }
        if (isPixelProblematicDevice()) {
            return shouldForceEnableStreamSharingForPixelDevice(str, collection);
        }
        return false;
    }
}
