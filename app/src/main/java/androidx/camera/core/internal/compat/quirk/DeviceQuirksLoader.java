package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings quirkSettings) {
        ArrayList arrayList = new ArrayList();
        if (quirkSettings.shouldEnableQuirk(ImageCaptureRotationOptionQuirk.class, ImageCaptureRotationOptionQuirk.load())) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(SurfaceOrderQuirk.class, SurfaceOrderQuirk.load())) {
            arrayList.add(new SurfaceOrderQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.load())) {
            arrayList.add(new CaptureFailedRetryQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(LowMemoryQuirk.class, LowMemoryQuirk.load())) {
            arrayList.add(new LowMemoryQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(LargeJpegImageQuirk.class, LargeJpegImageQuirk.load())) {
            arrayList.add(new LargeJpegImageQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(IncorrectJpegMetadataQuirk.class, IncorrectJpegMetadataQuirk.load())) {
            arrayList.add(new IncorrectJpegMetadataQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ImageCaptureFailedForSpecificCombinationQuirk.class, ImageCaptureFailedForSpecificCombinationQuirk.load())) {
            arrayList.add(new ImageCaptureFailedForSpecificCombinationQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(PreviewGreenTintQuirk.class, PreviewGreenTintQuirk.load())) {
            arrayList.add(PreviewGreenTintQuirk.INSTANCE);
        }
        return arrayList;
    }
}
