package androidx.camera.core.impl;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.SessionProcessor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class z {
    public static List a(SessionProcessor sessionProcessor) {
        return Collections.EMPTY_LIST;
    }

    public static int[] b(SessionProcessor sessionProcessor) {
        for (Pair<CameraCharacteristics.Key, Object> pair : sessionProcessor.getAvailableCharacteristicsKeyValues()) {
            if (((CameraCharacteristics.Key) pair.first).equals(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) {
                return (int[]) pair.second;
            }
        }
        return null;
    }

    public static Range c(SessionProcessor sessionProcessor) {
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        for (Pair<CameraCharacteristics.Key, Object> pair : sessionProcessor.getAvailableCharacteristicsKeyValues()) {
            if (((CameraCharacteristics.Key) pair.first).equals(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE)) {
                return (Range) pair.second;
            }
        }
        return null;
    }

    public static Pair d(SessionProcessor sessionProcessor) {
        return Pair.create(0, 0);
    }

    public static Pair e(SessionProcessor sessionProcessor) {
        return null;
    }

    public static Set f(SessionProcessor sessionProcessor) {
        return Collections.EMPTY_SET;
    }

    public static Map g(SessionProcessor sessionProcessor, Size size) {
        return Collections.EMPTY_MAP;
    }

    public static int i(SessionProcessor sessionProcessor, Config config, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        return -1;
    }

    public static void h(SessionProcessor sessionProcessor, SessionProcessor.CaptureSessionRequestProcessor captureSessionRequestProcessor) {
    }
}
