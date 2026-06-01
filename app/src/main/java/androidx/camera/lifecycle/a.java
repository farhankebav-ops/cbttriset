package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.CameraXConfig;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import j2.q;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    static {
        LifecycleCameraProvider.Companion companion = LifecycleCameraProvider.Companion;
    }

    public static Object a(Context context, CameraXConfig cameraXConfig, c cVar) {
        return LifecycleCameraProvider.Companion.createInstance(context, cameraXConfig, cVar);
    }

    public static Object b(Context context, c cVar) {
        return LifecycleCameraProvider.Companion.createInstance(context, cVar);
    }

    public static q c(Context context) {
        return LifecycleCameraProvider.Companion.createInstanceAsync(context);
    }

    public static q d(Context context, CameraXConfig cameraXConfig) {
        return LifecycleCameraProvider.Companion.createInstanceAsync(context, cameraXConfig);
    }
}
