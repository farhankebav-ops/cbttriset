package androidx.camera.core.impl;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.camera.core.CameraInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface SessionProcessor {
    public static final int TYPE_CAMERA2_EXTENSION = 1;
    public static final int TYPE_VENDOR_LIBRARY = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CaptureCallback {
        void onCaptureCompleted(long j, int i2, CameraCaptureResult cameraCaptureResult);

        void onCaptureFailed(int i2);

        void onCaptureProcessProgressed(int i2);

        void onCaptureProcessStarted(int i2);

        void onCaptureSequenceAborted(int i2);

        void onCaptureSequenceCompleted(int i2);

        void onCaptureStarted(int i2, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CaptureSessionRequestProcessor {
        Pair<Long, Long> getRealtimeStillCaptureLatency();

        void setExtensionStrength(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100) int i2);
    }

    void abortCapture(int i2);

    void deInitSession();

    List<Pair<CameraCharacteristics.Key, Object>> getAvailableCharacteristicsKeyValues();

    int[] getExtensionAvailableStabilizationModes();

    Range<Float> getExtensionZoomRange();

    Pair<Integer, Integer> getImplementationType();

    Pair<Long, Long> getRealtimeCaptureLatency();

    Set<Integer> getSupportedCameraOperations();

    Map<Integer, List<Size>> getSupportedPostviewSize(Size size);

    SessionConfig initSession(CameraInfo cameraInfo, OutputSurfaceConfiguration outputSurfaceConfiguration);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor requestProcessor);

    void setCaptureSessionRequestProcessor(CaptureSessionRequestProcessor captureSessionRequestProcessor);

    void setParameters(Config config);

    int startCapture(boolean z2, TagBundle tagBundle, CaptureCallback captureCallback);

    int startRepeating(TagBundle tagBundle, CaptureCallback captureCallback);

    int startTrigger(Config config, TagBundle tagBundle, CaptureCallback captureCallback);

    void stopRepeating();
}
