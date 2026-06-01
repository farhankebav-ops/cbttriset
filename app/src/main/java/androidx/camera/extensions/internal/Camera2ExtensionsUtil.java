package androidx.camera.extensions.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2ExtensionsUtil {
    public static final Camera2ExtensionsUtil INSTANCE = new Camera2ExtensionsUtil();
    private static final String TAG = "Camera2ExtensionsUtil";

    private Camera2ExtensionsUtil() {
    }

    public static final Map<String, CameraExtensionCharacteristics> createCameraId2CameraExtensionCharacteristicsMap(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        if (Build.VERSION.SDK_INT < 31) {
            return s.f13639a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            CameraManager cameraManager = (CameraManager) applicationContext.getSystemService(CameraManager.class);
            for (String str : cameraManager.getCameraIdList()) {
                k.b(str);
                CameraExtensionCharacteristics cameraExtensionCharacteristics = cameraManager.getCameraExtensionCharacteristics(str);
                k.d(cameraExtensionCharacteristics, "getCameraExtensionCharacteristics(...)");
                linkedHashMap.put(str, cameraExtensionCharacteristics);
            }
            return linkedHashMap;
        } catch (CameraAccessException e) {
            Log.e(TAG, "Failed to retrieve CameraExtensionCharacteristics info. ", e);
            return linkedHashMap;
        }
    }

    public static final boolean shouldUseCamera2Extensions(int i2) {
        return i2 == 1;
    }

    @RequiresApi(31)
    public final int convertCamera2ModeToCameraXMode(int i2) {
        if (i2 == 0) {
            return 5;
        }
        if (i2 == 1) {
            return 4;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new IllegalArgumentException("Unavailable Camera2 extension mode (" + i2 + ')');
    }

    @RequiresApi(31)
    public final int convertCameraXModeToCamera2Mode(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 == 2) {
            return 3;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 5) {
            return 0;
        }
        throw new IllegalArgumentException("Unavailable CameraX extension mode (" + i2 + ')');
    }
}
