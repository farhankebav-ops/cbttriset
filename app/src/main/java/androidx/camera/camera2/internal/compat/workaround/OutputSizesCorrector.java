package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class OutputSizesCorrector {
    private static final String TAG = "OutputSizesCorrector";
    private final String mCameraId;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final ExtraSupportedOutputSizeQuirk mExtraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);

    public OutputSizesCorrector(String str) {
        this.mCameraId = str;
        this.mExcludedSupportedSizesContainer = new ExcludedSupportedSizesContainer(str);
    }

    private void addExtraSupportedOutputSizesByClass(List<Size> list, Class<?> cls) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.mExtraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(cls);
        if (extraSupportedResolutions.length > 0) {
            list.addAll(Arrays.asList(extraSupportedResolutions));
        }
    }

    private void addExtraSupportedOutputSizesByFormat(List<Size> list, int i2) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.mExtraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(i2);
        if (extraSupportedResolutions.length > 0) {
            list.addAll(Arrays.asList(extraSupportedResolutions));
        }
    }

    private void excludeProblematicOutputSizesByClass(List<Size> list, Class<?> cls) {
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(cls);
        if (list2.isEmpty()) {
            return;
        }
        list.removeAll(list2);
    }

    private void excludeProblematicOutputSizesByFormat(List<Size> list, int i2) {
        List<Size> list2 = this.mExcludedSupportedSizesContainer.get(i2);
        if (list2.isEmpty()) {
            return;
        }
        list.removeAll(list2);
    }

    public Size[] applyQuirks(Size[] sizeArr, int i2) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        addExtraSupportedOutputSizesByFormat(arrayList, i2);
        excludeProblematicOutputSizesByFormat(arrayList, i2);
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    public <T> Size[] applyQuirks(Size[] sizeArr, Class<T> cls) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        addExtraSupportedOutputSizesByClass(arrayList, cls);
        excludeProblematicOutputSizesByClass(arrayList, cls);
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
