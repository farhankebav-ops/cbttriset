package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.activity.j;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicRangesCompat {
    private final DynamicRangeProfilesCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface DynamicRangeProfilesCompatImpl {
        Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange);

        Set<DynamicRange> getSupportedDynamicRanges();

        boolean isExtraLatencyPresent(DynamicRange dynamicRange);

        DynamicRangeProfiles unwrap();
    }

    public DynamicRangesCompat(DynamicRangeProfilesCompatImpl dynamicRangeProfilesCompatImpl) {
        this.mImpl = dynamicRangeProfilesCompatImpl;
    }

    public static DynamicRangesCompat fromCameraCharacteristics(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        DynamicRangesCompat dynamicRangesCompat = Build.VERSION.SDK_INT >= 33 ? toDynamicRangesCompat(j.f(cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES))) : null;
        return dynamicRangesCompat == null ? DynamicRangesCompatBaseImpl.COMPAT_INSTANCE : dynamicRangesCompat;
    }

    @RequiresApi(33)
    public static DynamicRangesCompat toDynamicRangesCompat(DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new DynamicRangesCompat(new DynamicRangesCompatApi33Impl(dynamicRangeProfiles));
    }

    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange dynamicRange) {
        return this.mImpl.getDynamicRangeCaptureRequestConstraints(dynamicRange);
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mImpl.getSupportedDynamicRanges();
    }

    public boolean isExtraLatencyPresent(DynamicRange dynamicRange) {
        return this.mImpl.isExtraLatencyPresent(dynamicRange);
    }

    @RequiresApi(33)
    public DynamicRangeProfiles toDynamicRangeProfiles() {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.mImpl.unwrap();
    }
}
