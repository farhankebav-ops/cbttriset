package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CameraCharacteristicsCompat {
    private final CameraCharacteristicsCompatImpl mCameraCharacteristicsImpl;
    private final String mCameraId;

    @GuardedBy("this")
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache = new HashMap();
    private StreamConfigurationMapCompat mStreamConfigurationMapCompat = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CameraCharacteristicsCompatImpl {
        <T> T get(CameraCharacteristics.Key<T> key);

        Set<String> getPhysicalCameraIds();

        CameraCharacteristics unwrap();
    }

    private CameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(cameraCharacteristics);
        } else {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsBaseImpl(cameraCharacteristics);
        }
        this.mCameraId = str;
    }

    private boolean hasFlashUnit() {
        Boolean bool = (Boolean) get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        return bool != null && bool.booleanValue();
    }

    private boolean isKeyNonCacheable(CameraCharacteristics.Key<?> key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    @VisibleForTesting
    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics, String str) {
        return new CameraCharacteristicsCompat(cameraCharacteristics, str);
    }

    public <T> T get(CameraCharacteristics.Key<T> key) {
        if (isKeyNonCacheable(key)) {
            return (T) this.mCameraCharacteristicsImpl.get(key);
        }
        synchronized (this) {
            try {
                T t3 = (T) this.mValuesCache.get(key);
                if (t3 != null) {
                    return t3;
                }
                T t7 = (T) this.mCameraCharacteristicsImpl.get(key);
                if (t7 != null) {
                    this.mValuesCache.put((CameraCharacteristics.Key<?>) key, t7);
                }
                return t7;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public int getDefaultTorchStrengthLevel() {
        Integer num = (!hasFlashUnit() || Build.VERSION.SDK_INT < 35) ? null : (Integer) get(CameraCharacteristics.FLASH_TORCH_STRENGTH_DEFAULT_LEVEL);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    @IntRange(from = 1)
    public int getMaxTorchStrengthLevel() {
        Integer num = (!hasFlashUnit() || Build.VERSION.SDK_INT < 35) ? null : (Integer) get(CameraCharacteristics.FLASH_TORCH_STRENGTH_MAX_LEVEL);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public Set<String> getPhysicalCameraIds() {
        return this.mCameraCharacteristicsImpl.getPhysicalCameraIds();
    }

    public StreamConfigurationMapCompat getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.mStreamConfigurationMapCompat = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(streamConfigurationMap, new OutputSizesCorrector(this.mCameraId));
            } catch (AssertionError | NullPointerException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.mStreamConfigurationMapCompat;
    }

    public boolean isTorchStrengthLevelSupported() {
        return hasFlashUnit() && Build.VERSION.SDK_INT >= 35 && getMaxTorchStrengthLevel() > 1;
    }

    public boolean isZoomOverrideAvailable() {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 34 && (iArr = (int[]) this.mCameraCharacteristicsImpl.get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES)) != null) {
            for (int i2 : iArr) {
                if (i2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristicsImpl.unwrap();
    }
}
