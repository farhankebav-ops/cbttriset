package androidx.camera.core.internal;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class SupportedOutputSizesSorterLegacy {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;

    public SupportedOutputSizesSorterLegacy(CameraInfoInternal cameraInfoInternal, Rational rational) {
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        this.mFullFovRatio = rational;
        boolean z2 = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z2 = false;
        }
        this.mIsSensorLandscapeResolution = z2;
    }

    private static Size flipSizeByRotation(Size size, int i2, int i8, int i9) {
        return (size == null || !isRotationNeeded(i2, i8, i9)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    private static Rational getAspectRatioGroupKeyOfTargetSize(Size size, List<Size> list) {
        if (size == null) {
            return null;
        }
        for (Rational rational : SupportedOutputSizesSorter.getResolutionListGroupingAspectRatioKeys(list)) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                return rational;
            }
        }
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational getTargetAspectRatioByLegacyApi(ImageOutputConfig imageOutputConfig, List<Size> list) {
        if (imageOutputConfig.hasTargetAspectRatio()) {
            return SupportedOutputSizesSorter.getTargetAspectRatioRationalValue(imageOutputConfig.getTargetAspectRatio(), this.mIsSensorLandscapeResolution);
        }
        Size targetSize = getTargetSize(imageOutputConfig);
        if (targetSize != null) {
            return getAspectRatioGroupKeyOfTargetSize(targetSize, list);
        }
        return null;
    }

    private Size getTargetSize(ImageOutputConfig imageOutputConfig) {
        return flipSizeByRotation(imageOutputConfig.getTargetResolution(null), imageOutputConfig.getTargetRotation(0), this.mLensFacing, this.mSensorOrientation);
    }

    private static boolean isRotationNeeded(int i2, int i8, int i9) {
        int relativeImageRotation = CameraOrientationUtil.getRelativeImageRotation(CameraOrientationUtil.surfaceRotationToDegrees(i2), i9, 1 == i8);
        return relativeImageRotation == 90 || relativeImageRotation == 270;
    }

    public List<Size> sortSupportedOutputSizes(List<Size> list, UseCaseConfig<?> useCaseConfig) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        ArrayList arrayList2 = new ArrayList();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        Size maxResolution = imageOutputConfig.getMaxResolution(null);
        int i2 = 0;
        Size size = (Size) arrayList.get(0);
        if (maxResolution == null || SizeUtil.getArea(size) < SizeUtil.getArea(maxResolution)) {
            maxResolution = size;
        }
        Size targetSize = getTargetSize(imageOutputConfig);
        Size size2 = SizeUtil.RESOLUTION_VGA;
        int area = SizeUtil.getArea(size2);
        if (SizeUtil.getArea(maxResolution) < area) {
            size2 = SizeUtil.RESOLUTION_ZERO;
        } else if (targetSize != null && SizeUtil.getArea(targetSize) < area) {
            size2 = targetSize;
        }
        int size3 = arrayList.size();
        int i8 = 0;
        while (i8 < size3) {
            Object obj = arrayList.get(i8);
            i8++;
            Size size4 = (Size) obj;
            if (SizeUtil.getArea(size4) <= SizeUtil.getArea(maxResolution) && SizeUtil.getArea(size4) >= SizeUtil.getArea(size2) && !arrayList2.contains(size4)) {
                arrayList2.add(size4);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size2 + "\nmaxSize = " + maxResolution + "\ninitial size list: " + arrayList);
        }
        Rational targetAspectRatioByLegacyApi = getTargetAspectRatioByLegacyApi(imageOutputConfig, arrayList2);
        if (targetSize == null) {
            targetSize = imageOutputConfig.getDefaultResolution(null);
        }
        ArrayList arrayList3 = new ArrayList();
        new HashMap();
        if (targetAspectRatioByLegacyApi == null) {
            arrayList3.addAll(arrayList2);
            if (targetSize != null) {
                SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(arrayList3, targetSize, true);
                return arrayList3;
            }
        } else {
            Map<Rational, List<Size>> mapGroupSizesByAspectRatio = SupportedOutputSizesSorter.groupSizesByAspectRatio(arrayList2);
            if (targetSize != null) {
                Iterator<Rational> it = mapGroupSizesByAspectRatio.keySet().iterator();
                while (it.hasNext()) {
                    SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(mapGroupSizesByAspectRatio.get(it.next()), targetSize, true);
                }
            }
            ArrayList arrayList4 = new ArrayList(mapGroupSizesByAspectRatio.keySet());
            Collections.sort(arrayList4, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioByLegacyApi, this.mFullFovRatio));
            int size5 = arrayList4.size();
            while (i2 < size5) {
                Object obj2 = arrayList4.get(i2);
                i2++;
                for (Size size6 : mapGroupSizesByAspectRatio.get((Rational) obj2)) {
                    if (!arrayList3.contains(size6)) {
                        arrayList3.add(size6);
                    }
                }
            }
        }
        return arrayList3;
    }
}
