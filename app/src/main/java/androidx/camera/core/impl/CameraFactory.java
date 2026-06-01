package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.internal.StreamSpecsCalculator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraFactory extends CameraPresenceMonitor {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Provider {
        CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector, long j, CameraXConfig cameraXConfig, StreamSpecsCalculator streamSpecsCalculator) throws InitializationException;
    }

    Set<String> getAvailableCameraIds();

    CameraInternal getCamera(String str) throws CameraUnavailableException;

    CameraCoordinator getCameraCoordinator();

    Object getCameraManager();

    Observable<List<CameraIdentifier>> getCameraPresenceSource();

    void shutdown();
}
