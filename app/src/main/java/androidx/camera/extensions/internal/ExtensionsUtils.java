package androidx.camera.extensions.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExtensionsUtils {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Set<String> getPhysicalCameraIds(CameraCharacteristics cameraCharacteristics) {
            try {
                return cameraCharacteristics.getPhysicalCameraIds();
            } catch (Exception unused) {
                return Collections.EMPTY_SET;
            }
        }
    }

    private ExtensionsUtils() {
    }

    public static Map<String, CameraCharacteristics> getCameraCharacteristicsMap(CameraInfoInternal cameraInfoInternal) {
        Set<String> physicalCameraIds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String cameraId = cameraInfoInternal.getCameraId();
        CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) cameraInfoInternal.getCameraCharacteristics();
        linkedHashMap.put(cameraId, cameraCharacteristics);
        if (Build.VERSION.SDK_INT >= 28 && (physicalCameraIds = Api28Impl.getPhysicalCameraIds(cameraCharacteristics)) != null) {
            for (String str : physicalCameraIds) {
                if (!Objects.equals(str, cameraId)) {
                    linkedHashMap.put(str, (CameraCharacteristics) cameraInfoInternal.getPhysicalCameraCharacteristics(str));
                }
            }
        }
        return linkedHashMap;
    }

    public static Set<Integer> getSupportedCameraOperations(List<CaptureRequest.Key<?>> list) {
        HashSet hashSet = new HashSet();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            if (list.contains(CaptureRequest.CONTROL_ZOOM_RATIO) || list.contains(CaptureRequest.SCALER_CROP_REGION)) {
                hashSet.add(0);
            }
        } else if (list.contains(CaptureRequest.SCALER_CROP_REGION)) {
            hashSet.add(0);
        }
        if (list.containsAll(Arrays.asList(CaptureRequest.CONTROL_AF_TRIGGER, CaptureRequest.CONTROL_AF_MODE))) {
            hashSet.add(1);
        }
        if (list.contains(CaptureRequest.CONTROL_AF_REGIONS)) {
            hashSet.add(2);
        }
        if (list.contains(CaptureRequest.CONTROL_AE_REGIONS)) {
            hashSet.add(3);
        }
        if (list.contains(CaptureRequest.CONTROL_AWB_REGIONS)) {
            hashSet.add(4);
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
        if (list.containsAll(Arrays.asList(key, CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER))) {
            hashSet.add(5);
        }
        if (list.containsAll(Arrays.asList(key, CaptureRequest.FLASH_MODE))) {
            hashSet.add(6);
        }
        if (list.contains(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)) {
            hashSet.add(7);
        }
        if (i2 >= 34 && list.contains(CaptureRequest.EXTENSION_STRENGTH)) {
            hashSet.add(8);
        }
        return hashSet;
    }
}
