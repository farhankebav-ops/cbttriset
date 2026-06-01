package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface CaptureSessionInterface {
    void cancelIssuedCaptureRequests();

    void close();

    List<CaptureConfig> getCaptureConfigs();

    SessionConfig getSessionConfig();

    boolean isInOpenState();

    void issueCaptureRequests(List<CaptureConfig> list);

    j2.q open(SessionConfig sessionConfig, CameraDevice cameraDevice, SynchronizedCaptureSession.Opener opener);

    j2.q release(boolean z2);

    void setSessionConfig(SessionConfig sessionConfig);

    void setStreamUseCaseMap(Map<DeferrableSurface, Long> map);
}
