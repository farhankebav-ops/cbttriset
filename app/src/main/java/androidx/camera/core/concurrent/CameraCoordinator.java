package androidx.camera.core.concurrent;

import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.InternalCameraPresenceListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface CameraCoordinator extends InternalCameraPresenceListener {
    public static final int CAMERA_OPERATING_MODE_CONCURRENT = 2;
    public static final int CAMERA_OPERATING_MODE_SINGLE = 1;
    public static final int CAMERA_OPERATING_MODE_UNSPECIFIED = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CameraOperatingMode {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ConcurrentCameraModeListener {
        void onCameraOperatingModeUpdated(int i2, int i8);
    }

    void addListener(ConcurrentCameraModeListener concurrentCameraModeListener);

    List<CameraInfo> getActiveConcurrentCameraInfos();

    int getCameraOperatingMode();

    List<List<CameraSelector>> getConcurrentCameraSelectors();

    String getPairedConcurrentCameraId(String str);

    void init(CameraRepository cameraRepository);

    void removeListener(ConcurrentCameraModeListener concurrentCameraModeListener);

    void setActiveConcurrentCameraInfos(List<CameraInfo> list);

    void setCameraOperatingMode(int i2);

    void shutdown();
}
