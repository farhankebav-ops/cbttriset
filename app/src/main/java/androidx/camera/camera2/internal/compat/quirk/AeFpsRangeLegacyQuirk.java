package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AeFpsRangeLegacyQuirk implements AeFpsRangeQuirk {
    private final Range<Integer> mAeFpsRange;

    public AeFpsRangeLegacyQuirk(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mAeFpsRange = pickSuitableFpsRange((Range[]) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private Range<Integer> getCorrectedFpsRange(Range<Integer> range) {
        int iIntValue = ((Integer) range.getUpper()).intValue();
        int iIntValue2 = ((Integer) range.getLower()).intValue();
        if (((Integer) range.getUpper()).intValue() >= 1000) {
            iIntValue = ((Integer) range.getUpper()).intValue() / 1000;
        }
        if (((Integer) range.getLower()).intValue() >= 1000) {
            iIntValue2 = ((Integer) range.getLower()).intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue));
    }

    public static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    private Range<Integer> pickSuitableFpsRange(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range<Integer> range2 : rangeArr) {
                Range<Integer> correctedFpsRange = getCorrectedFpsRange(range2);
                if (((Integer) correctedFpsRange.getUpper()).intValue() == 30 && (range == null || ((Integer) correctedFpsRange.getLower()).intValue() < ((Integer) range.getLower()).intValue())) {
                    range = correctedFpsRange;
                }
            }
        }
        return range;
    }

    @Override // androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk
    public Range<Integer> getTargetAeFpsRange() {
        Range<Integer> range = this.mAeFpsRange;
        return range != null ? range : StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }
}
