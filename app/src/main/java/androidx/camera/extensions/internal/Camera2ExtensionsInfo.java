package androidx.camera.extensions.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.d0;
import androidx.camera.core.Logger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2ExtensionsInfo {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "Camera2ExtensionsInfo";

    @GuardedBy("lock")
    private final Map<String, CameraExtensionCharacteristics> cachedCharacteristics;

    @GuardedBy("lock")
    private final Map<String, List<Integer>> cachedSupportedExtensions;

    @GuardedBy("lock")
    private final Map<String, List<Size>> cachedSupportedOutputSizes;
    private final CameraManager cameraManager;
    private final Object lock;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public Camera2ExtensionsInfo(CameraManager cameraManager) {
        k.e(cameraManager, "cameraManager");
        this.cameraManager = cameraManager;
        this.lock = new Object();
        this.cachedCharacteristics = new LinkedHashMap();
        this.cachedSupportedOutputSizes = new LinkedHashMap();
        this.cachedSupportedExtensions = new LinkedHashMap();
    }

    private final String getCachedOutputSizesKey(String str, int i2, int i8) {
        return str + '-' + i2 + '-' + i8;
    }

    @RequiresApi(31)
    private final List<Integer> getSupportedExtensions(String str) {
        List<Integer> supportedExtensions;
        synchronized (this.lock) {
            supportedExtensions = this.cachedSupportedExtensions.get(str);
            if (supportedExtensions == null) {
                supportedExtensions = getExtensionCharacteristics(str).getSupportedExtensions();
                this.cachedSupportedExtensions.put(str, supportedExtensions);
                k.d(supportedExtensions, "also(...)");
            }
        }
        return supportedExtensions;
    }

    @RequiresApi(31)
    public final CameraExtensionCharacteristics getExtensionCharacteristics(String cameraId) {
        CameraExtensionCharacteristics cameraExtensionCharacteristicsE;
        k.e(cameraId, "cameraId");
        synchronized (this.lock) {
            cameraExtensionCharacteristicsE = d0.e(this.cachedCharacteristics.get(cameraId));
            if (cameraExtensionCharacteristicsE == null) {
                cameraExtensionCharacteristicsE = this.cameraManager.getCameraExtensionCharacteristics(cameraId);
                this.cachedCharacteristics.put(cameraId, cameraExtensionCharacteristicsE);
                k.d(cameraExtensionCharacteristicsE, "also(...)");
            }
        }
        return cameraExtensionCharacteristicsE;
    }

    public final List<Size> getSupportedOutputSizes(String cameraId, int i2, int i8) {
        List<Size> list;
        k.e(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 31) {
            return r.f13638a;
        }
        String cachedOutputSizesKey = getCachedOutputSizesKey(cameraId, i2, i8);
        synchronized (this.lock) {
            list = this.cachedSupportedOutputSizes.get(cachedOutputSizesKey);
        }
        if (list != null) {
            return list;
        }
        try {
            List<Size> extensionSupportedSizes = i8 == 34 ? getExtensionCharacteristics(cameraId).getExtensionSupportedSizes(i2, SurfaceTexture.class) : getExtensionCharacteristics(cameraId).getExtensionSupportedSizes(i2, i8);
            synchronized (this.lock) {
                this.cachedSupportedOutputSizes.put(cachedOutputSizesKey, extensionSupportedSizes);
            }
            k.b(extensionSupportedSizes);
            return extensionSupportedSizes;
        } catch (IllegalArgumentException e) {
            StringBuilder sbS = androidx.camera.core.processing.util.a.s("Failed to retrieve supported output sizes for camera ", i2, cameraId, ", mode ", ", format ");
            sbS.append(i8);
            Logger.e(TAG, sbS.toString(), e);
            return r.f13638a;
        }
    }

    public final boolean isExtensionAvailable(String cameraId, int i2) {
        k.e(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        return getSupportedExtensions(cameraId).contains(Integer.valueOf(i2));
    }
}
