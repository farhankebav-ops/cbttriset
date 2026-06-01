package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface VendorExtender {
    SessionProcessor createSessionProcessor(Context context);

    List<Pair<CameraCharacteristics.Key, Object>> getAvailableCharacteristicsKeyValues();

    Range<Long> getEstimatedCaptureLatencyRange(Size size);

    List<Pair<Integer, Size[]>> getSupportedCaptureOutputResolutions();

    List<CaptureResult.Key> getSupportedCaptureResultKeys();

    Map<Integer, List<Size>> getSupportedPostviewResolutions(Size size);

    List<Pair<Integer, Size[]>> getSupportedPreviewOutputResolutions();

    Size[] getSupportedYuvAnalysisResolutions();

    void init(CameraInfo cameraInfo);

    boolean isCaptureProcessProgressAvailable();

    boolean isCurrentExtensionModeAvailable();

    boolean isExtensionAvailable(String str, Map<String, CameraCharacteristics> map);

    boolean isExtensionStrengthAvailable();

    boolean isPostviewAvailable();

    boolean willReceiveOnCaptureCompleted();
}
