package androidx.camera.camera2.internal;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface ZslControl {
    void addZslConfig(SessionConfig.Builder builder);

    void clearZslConfig();

    ImageProxy dequeueImageFromBuffer();

    boolean enqueueImageToImageWriter(ImageProxy imageProxy);

    boolean isZslDisabledByFlashMode();

    boolean isZslDisabledByUserCaseConfig();

    void setZslDisabledByFlashMode(boolean z2);

    void setZslDisabledByUserCaseConfig(boolean z2);
}
