package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.camera.core.impl.CaptureConfig;
import j2.q;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageCaptureControl {
    @MainThread
    void lockFlashMode();

    @MainThread
    q submitStillCaptureRequests(List<CaptureConfig> list);

    @MainThread
    void unlockFlashMode();
}
