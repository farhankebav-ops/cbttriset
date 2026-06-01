package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface Camera2SessionConfig {
    List<Camera2OutputConfig> getOutputConfigs();

    Map<CaptureRequest.Key<?>, Object> getSessionParameters();

    int getSessionTemplateId();

    int getSessionType();
}
