package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = new f();

    CameraConfig getConfig(CameraInfo cameraInfo, Context context);
}
