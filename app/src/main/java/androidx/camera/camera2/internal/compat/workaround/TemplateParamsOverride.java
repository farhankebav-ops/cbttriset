package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TemplateParamsOverride {
    private final boolean mWorkaroundByCaptureIntentPreview;
    private final boolean mWorkaroundByCaptureIntentStillCapture;

    public TemplateParamsOverride(Quirks quirks) {
        this.mWorkaroundByCaptureIntentPreview = androidx.camera.camera2.internal.compat.quirk.a.b(quirks);
        this.mWorkaroundByCaptureIntentStillCapture = quirks.contains(ImageCaptureFailedForVideoSnapshotQuirk.class);
    }

    public Map<CaptureRequest.Key<?>, Object> getOverrideParams(int i2) {
        if (i2 == 3 && this.mWorkaroundByCaptureIntentPreview) {
            HashMap map = new HashMap();
            map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            return Collections.unmodifiableMap(map);
        }
        if (i2 != 4 || !this.mWorkaroundByCaptureIntentStillCapture) {
            return Collections.EMPTY_MAP;
        }
        HashMap map2 = new HashMap();
        map2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
        return Collections.unmodifiableMap(map2);
    }
}
