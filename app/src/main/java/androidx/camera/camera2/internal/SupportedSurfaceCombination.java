package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.Logger;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.featuregroup.impl.feature.FpsRangeFeature;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraMode;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.SurfaceStreamSpecQueryResult;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalCamera2Interop.class})
public final class SupportedSurfaceCombination {
    private static final int FRAME_RATE_UNLIMITED = Integer.MAX_VALUE;
    private static final String TAG = "SupportedSurfaceCombination";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangeResolver mDynamicRangeResolver;
    private final ExtraSupportedSurfaceCombinationsContainer mExtraSupportedSurfaceCombinationsContainer;
    private final FeatureCombinationQuery mFeatureCombinationQuery;
    private final int mHardwareLevel;
    private final HighSpeedResolver mHighSpeedResolver;
    private boolean mIsBurstCaptureSupported;
    private final boolean mIsConcurrentCameraModeSupported;
    private boolean mIsManualSensorSupported;
    private final boolean mIsPreviewStabilizationSupported;
    private boolean mIsRawSupported;
    private final boolean mIsStreamUseCaseSupported;
    private boolean mIsUltraHighResolutionSensorSupported;

    @VisibleForTesting
    SurfaceSizeDefinition mSurfaceSizeDefinition;
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mUltraHighSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mConcurrentSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mPreviewStabilizationSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mHighSpeedSurfaceCombinations = new ArrayList();
    private final List<SurfaceCombination> mFcqSurfaceCombinations = new ArrayList();
    private final Map<FeatureSettings, List<SurfaceCombination>> mFeatureSettingsToSupportedCombinationsMap = new HashMap();
    private final List<SurfaceCombination> mSurfaceCombinations10Bit = new ArrayList();
    private final List<SurfaceCombination> mSurfaceCombinationsUltraHdr = new ArrayList();
    private final List<SurfaceCombination> mSurfaceCombinationsStreamUseCase = new ArrayList();
    List<Integer> mSurfaceSizeDefinitionFormats = new ArrayList();
    private final TargetAspectRatio mTargetAspectRatio = new TargetAspectRatio();
    private final ResolutionCorrector mResolutionCorrector = new ResolutionCorrector();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i2) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class BestSizesAndMaxFpsForConfigs {
        public static BestSizesAndMaxFpsForConfigs of(List<Size> list, List<Size> list2, int i2, int i8, int i9) {
            return new AutoValue_SupportedSurfaceCombination_BestSizesAndMaxFpsForConfigs(list, list2, i2, i8, i9);
        }

        public abstract List<Size> getBestSizes();

        public abstract List<Size> getBestSizesForStreamUseCase();

        public abstract int getMaxFpsForAllSizes();

        public abstract int getMaxFpsForBestSizes();

        public abstract int getMaxFpsForStreamUseCase();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum CheckingMethod {
        WITHOUT_FEATURE_COMBO,
        WITH_FEATURE_COMBO,
        WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class FeatureSettings {
        public static FeatureSettings of(int i2, boolean z2, int i8, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Range<Integer> range, boolean z12) {
            return new AutoValue_SupportedSurfaceCombination_FeatureSettings(i2, z2, i8, z7, z8, z9, z10, z11, range, z12);
        }

        public abstract int getCameraMode();

        public abstract int getRequiredMaxBitDepth();

        public abstract Range<Integer> getTargetFpsRange();

        public abstract boolean hasVideoCapture();

        public abstract boolean isFeatureComboInvocation();

        public abstract boolean isHighSpeedOn();

        public abstract boolean isPreviewStabilizationOn();

        public abstract boolean isStrictFpsRequired();

        public abstract boolean isUltraHdrOn();

        public abstract boolean requiresFeatureComboQuery();
    }

    public SupportedSurfaceCombination(Context context, String str, CameraManagerCompat cameraManagerCompat, CamcorderProfileHelper camcorderProfileHelper, FeatureCombinationQuery featureCombinationQuery) throws CameraUnavailableException {
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        this.mIsUltraHighResolutionSensorSupported = false;
        this.mIsManualSensorSupported = false;
        String str2 = (String) Preconditions.checkNotNull(str);
        this.mCameraId = str2;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(camcorderProfileHelper);
        this.mExtraSupportedSurfaceCombinationsContainer = new ExtraSupportedSurfaceCombinationsContainer();
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str2);
            this.mCharacteristics = cameraCharacteristicsCompat;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.mHardwareLevel = num != null ? num.intValue() : 2;
            int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (i2 == 3) {
                        this.mIsRawSupported = true;
                    } else if (i2 == 6) {
                        this.mIsBurstCaptureSupported = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i2 == 16) {
                        this.mIsUltraHighResolutionSensorSupported = true;
                    } else if (i2 == 1) {
                        this.mIsManualSensorSupported = true;
                    }
                }
            }
            DynamicRangeResolver dynamicRangeResolver = new DynamicRangeResolver(this.mCharacteristics);
            this.mDynamicRangeResolver = dynamicRangeResolver;
            this.mHighSpeedResolver = new HighSpeedResolver(this.mCharacteristics);
            generateSupportedCombinationList();
            if (this.mIsUltraHighResolutionSensorSupported) {
                generateUltraHighSupportedCombinationList();
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.mIsConcurrentCameraModeSupported = zHasSystemFeature;
            if (zHasSystemFeature) {
                generateConcurrentSupportedCombinationList();
            }
            if (dynamicRangeResolver.is10BitDynamicRangeSupported()) {
                generate10BitSupportedCombinationList();
            }
            boolean zIsStreamUseCaseSupported = StreamUseCaseUtil.isStreamUseCaseSupported(this.mCharacteristics);
            this.mIsStreamUseCaseSupported = zIsStreamUseCaseSupported;
            if (zIsStreamUseCaseSupported) {
                generateStreamUseCaseSupportedCombinationList();
            }
            boolean zIsPreviewStabilizationSupported = VideoStabilizationUtil.isPreviewStabilizationSupported(this.mCharacteristics);
            this.mIsPreviewStabilizationSupported = zIsPreviewStabilizationSupported;
            if (zIsPreviewStabilizationSupported) {
                generatePreviewStabilizationSupportedCombinationList();
            }
            generateSurfaceSizeDefinition();
            checkCustomization();
            this.mFeatureCombinationQuery = featureCombinationQuery;
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    private static Range<Integer> compareIntersectingRanges(Range<Integer> range, Range<Integer> range2, Range<Integer> range3) {
        double rangeLength = getRangeLength(range2.intersect(range));
        double rangeLength2 = getRangeLength(range3.intersect(range));
        double rangeLength3 = rangeLength2 / ((double) getRangeLength(range3));
        double rangeLength4 = rangeLength / ((double) getRangeLength(range2));
        return (rangeLength2 <= rangeLength ? rangeLength2 != rangeLength ? rangeLength4 >= 0.5d || rangeLength3 <= rangeLength4 : rangeLength3 <= rangeLength4 && (rangeLength3 != rangeLength4 || ((Integer) range3.getLower()).intValue() <= ((Integer) range2.getLower()).intValue()) : rangeLength3 < 0.5d && rangeLength3 < rangeLength4) ? range2 : range3;
    }

    private SessionConfig createFeatureComboSessionConfig(FeatureSettings featureSettings, List<SurfaceConfig> list, Map<SurfaceConfig, DynamicRange> map, List<UseCaseConfig<?>> list2, List<Integer> list3) {
        Range<Integer> targetFpsRange = featureSettings.getTargetFpsRange();
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            SurfaceConfig surfaceConfig = list.get(i2);
            Size resolution = surfaceConfig.getResolution(getUpdatedSurfaceSizeDefinitionByFormat(surfaceConfig.getImageFormat()));
            UseCaseConfig<?> useCaseConfig = list2.get(list3.get(i2).intValue());
            DynamicRange dynamicRange = map.get(surfaceConfig);
            Objects.requireNonNull(dynamicRange);
            SessionConfig.Builder builderA = androidx.camera.core.featuregroup.impl.a.a(useCaseConfig, resolution, dynamicRange);
            builderA.setExpectedFrameRateRange(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(targetFpsRange) ? FpsRangeFeature.DEFAULT_FPS_RANGE : targetFpsRange);
            if (featureSettings.isPreviewStabilizationOn()) {
                builderA.setPreviewStabilization(2);
            }
            validatingBuilder.add(builderA.build());
            Preconditions.checkState(validatingBuilder.isValid(), "Cannot create a combined SessionConfig for feature combo after adding " + useCaseConfig + " with " + surfaceConfig + " due to [" + validatingBuilder.getInvalidReason() + "]; surfaceConfigList = " + list + ", featureSettings = " + featureSettings + ", newUseCaseConfigs = " + list2);
        }
        return validatingBuilder.build();
    }

    private FeatureSettings createFeatureSettings(int i2, boolean z2, Map<UseCaseConfig<?>, DynamicRange> map, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Range<Integer> range, boolean z12) {
        int requiredMaxBitDepth = getRequiredMaxBitDepth(map);
        if (i2 != 0 && z8) {
            throw new IllegalArgumentException(a1.a.o("Camera device id is ", this.mCameraId, ". Ultra HDR is not currently supported in ", CameraMode.toLabelString(i2), " camera mode."));
        }
        if (i2 != 0 && requiredMaxBitDepth == 10) {
            throw new IllegalArgumentException(a1.a.o("Camera device id is ", this.mCameraId, ". 10 bit dynamic range is not currently supported in ", CameraMode.toLabelString(i2), " camera mode."));
        }
        if (i2 != 0 && z10) {
            throw new IllegalArgumentException(a1.a.o("Camera device id is ", this.mCameraId, ". Feature combination query is not currently supported in ", CameraMode.toLabelString(i2), " camera mode."));
        }
        if (z9 && z10) {
            throw new IllegalArgumentException("High-speed session is not supported with feature combination");
        }
        if (z9 && !this.mHighSpeedResolver.isHighSpeedSupported()) {
            throw new IllegalArgumentException("High-speed session is not supported on this device.");
        }
        if (z10 && range == StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED && z11) {
            range = FpsRangeFeature.DEFAULT_FPS_RANGE;
        }
        return FeatureSettings.of(i2, z2, requiredMaxBitDepth, z7, z8, z9, z10, z11, range, z12);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0117 A[PHI: r6 r7 r10
  0x0117: PHI (r6v2 boolean) = (r6v1 boolean), (r6v1 boolean), (r6v1 boolean), (r6v3 boolean) binds: [B:29:0x00e7, B:33:0x00f8, B:39:0x0105, B:43:0x0113] A[DONT_GENERATE, DONT_INLINE]
  0x0117: PHI (r7v3 int) = (r7v1 int), (r7v1 int), (r7v5 int), (r7v6 int) binds: [B:29:0x00e7, B:33:0x00f8, B:39:0x0105, B:43:0x0113] A[DONT_GENERATE, DONT_INLINE]
  0x0117: PHI (r10v3 java.util.List<android.util.Size>) = 
  (r10v1 java.util.List<android.util.Size>)
  (r10v1 java.util.List<android.util.Size>)
  (r10v5 java.util.List<android.util.Size>)
  (r10v6 java.util.List<android.util.Size>)
 binds: [B:29:0x00e7, B:33:0x00f8, B:39:0x0105, B:43:0x0113] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.camera.camera2.internal.SupportedSurfaceCombination.BestSizesAndMaxFpsForConfigs findBestSizesAndFps(final androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings r30, java.util.List<androidx.camera.core.impl.AttachedSurfaceInfo> r31, final java.util.List<androidx.camera.core.impl.UseCaseConfig<?>> r32, final java.util.List<java.lang.Integer> r33, java.util.List<java.util.List<android.util.Size>> r34, java.util.List<androidx.camera.core.impl.SurfaceConfig> r35, java.util.Map<androidx.camera.core.impl.UseCaseConfig<?>, androidx.camera.core.DynamicRange> r36, int r37, boolean r38) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.SupportedSurfaceCombination.findBestSizesAndFps(androidx.camera.camera2.internal.SupportedSurfaceCombination$FeatureSettings, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.Map, int, boolean):androidx.camera.camera2.internal.SupportedSurfaceCombination$BestSizesAndMaxFpsForConfigs");
    }

    private void generate10BitSupportedCombinationList() {
        this.mSurfaceCombinations10Bit.addAll(GuaranteedConfigurationsUtil.get10BitSupportedCombinationList());
    }

    private void generateConcurrentSupportedCombinationList() {
        this.mConcurrentSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getConcurrentSupportedCombinationList());
    }

    private void generateFcqSurfaceCombinations() {
        this.mFcqSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateQueryableFcqCombinations());
    }

    private void generateHighSpeedSupportedCombinationList() {
        if (this.mHighSpeedResolver.isHighSpeedSupported()) {
            this.mHighSpeedSurfaceCombinations.clear();
            Size maxSize = this.mHighSpeedResolver.getMaxSize();
            if (maxSize != null) {
                this.mHighSpeedSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateHighSpeedSupportedCombinationList(maxSize, getUpdatedSurfaceSizeDefinitionByFormat(34)));
            }
        }
    }

    private void generatePreviewStabilizationSupportedCombinationList() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.mPreviewStabilizationSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getPreviewStabilizationSupportedCombinationList());
        }
    }

    private void generateStreamUseCaseSupportedCombinationList() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.mSurfaceCombinationsStreamUseCase.addAll(GuaranteedConfigurationsUtil.getStreamUseCaseSupportedCombinationList());
        }
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateSupportedCombinationList(this.mHardwareLevel, this.mIsRawSupported, this.mIsBurstCaptureSupported));
        this.mSurfaceCombinations.addAll(this.mExtraSupportedSurfaceCombinationsContainer.get(this.mCameraId));
    }

    private void generateSurfaceSizeDefinition() {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(SizeUtil.RESOLUTION_VGA, new HashMap(), this.mDisplayInfoManager.getPreviewSize(), new HashMap(), getRecordSize(), new HashMap(), new HashMap(), new HashMap(), new HashMap());
    }

    private void generateUltraHdrSupportedCombinationList() {
        this.mSurfaceCombinationsUltraHdr.addAll(GuaranteedConfigurationsUtil.getUltraHdrSupportedCombinationList());
    }

    private void generateUltraHighSupportedCombinationList() {
        this.mUltraHighSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getUltraHighResolutionSupportedCombinationList());
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        Iterator<List<Size>> it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= it.next().size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / list.get(0).size();
        int i8 = size;
        for (int i9 = 0; i9 < list.size(); i9++) {
            List<Size> list2 = list.get(i9);
            for (int i10 = 0; i10 < size; i10++) {
                ((List) arrayList.get(i10)).add(list2.get((i10 % i8) / size2));
            }
            if (i9 < list.size() - 1) {
                i8 = size2;
                size2 /= list.get(i9 + 1).size();
            }
        }
        return arrayList;
    }

    private boolean getAndValidateIsStrictFpsRequired(boolean z2, Boolean bool) {
        if (bool == null || bool.booleanValue() == z2) {
            return z2;
        }
        throw new IllegalStateException("All isStrictFpsRequired should be the same");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    private CheckingMethod getCheckingMethod(Collection<DynamicRange> collection, Range<Integer> range, boolean z2, boolean z7, boolean z8) {
        if (!z8) {
            return CheckingMethod.WITHOUT_FEATURE_COMBO;
        }
        ?? Contains = collection.contains(DynamicRange.HLG_10_BIT);
        int i2 = Contains;
        if (range != null) {
            i2 = Contains;
            if (((Integer) range.getUpper()).intValue() == 60) {
                i2 = Contains + 1;
            }
        }
        if (z2) {
            i2++;
        }
        if (z7) {
            i2++;
        }
        return i2 > 1 ? CheckingMethod.WITH_FEATURE_COMBO : i2 == 1 ? CheckingMethod.WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT : CheckingMethod.WITHOUT_FEATURE_COMBO;
    }

    private Range<Integer> getClosestSupportedDeviceFrameRate(Range<Integer> range, int i2, Range<Integer>[] rangeArr) {
        Range<Integer> rangeCompareIntersectingRanges = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (rangeCompareIntersectingRanges.equals(range) || rangeArr == null) {
            return rangeCompareIntersectingRanges;
        }
        Range<T> range2 = new Range<>(Integer.valueOf(Math.min(((Integer) range.getLower()).intValue(), i2)), Integer.valueOf(Math.min(((Integer) range.getUpper()).intValue(), i2)));
        int rangeLength = 0;
        for (Range<Integer> range3 : rangeArr) {
            Objects.requireNonNull(range3);
            if (i2 >= ((Integer) range3.getLower()).intValue()) {
                if (rangeCompareIntersectingRanges.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
                    rangeCompareIntersectingRanges = range3;
                }
                if (range3.equals(range2)) {
                    return range3;
                }
                try {
                    int rangeLength2 = getRangeLength(range3.intersect(range2));
                    if (rangeLength == 0) {
                        rangeLength = rangeLength2;
                    } else {
                        if (rangeLength2 >= rangeLength) {
                            rangeCompareIntersectingRanges = compareIntersectingRanges(range2, rangeCompareIntersectingRanges, range3);
                            rangeLength = getRangeLength(range2.intersect(rangeCompareIntersectingRanges));
                        }
                        range3 = rangeCompareIntersectingRanges;
                    }
                } catch (IllegalArgumentException unused) {
                    if (rangeLength != 0 || (getRangeDistance(range3, range2) >= getRangeDistance(rangeCompareIntersectingRanges, range2) && (getRangeDistance(range3, range2) != getRangeDistance(rangeCompareIntersectingRanges, range2) || (((Integer) range3.getLower()).intValue() <= ((Integer) rangeCompareIntersectingRanges.getUpper()).intValue() && getRangeLength(range3) >= getRangeLength(rangeCompareIntersectingRanges))))) {
                    }
                }
                rangeCompareIntersectingRanges = range3;
            }
        }
        return rangeCompareIntersectingRanges;
    }

    private int getMaxFrameRate(int i2, Size size, boolean z2) {
        Preconditions.checkState(!z2 || i2 == 34);
        return z2 ? this.mHighSpeedResolver.getMaxFrameRate(size) : getMaxFrameRate(this.mCharacteristics, i2, size);
    }

    private Size getMaxOutputSizeByFormat(StreamConfigurationMap streamConfigurationMap, int i2, boolean z2, Rational rational) {
        Size[] highResolutionOutputSizes;
        Size[] outputSizes = getOutputSizes(streamConfigurationMap, i2, rational);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea();
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), compareSizesByArea);
        Size size2 = SizeUtil.RESOLUTION_ZERO;
        if (z2 && (highResolutionOutputSizes = Api23Impl.getHighResolutionOutputSizes(streamConfigurationMap, i2)) != null && highResolutionOutputSizes.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), compareSizesByArea);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), compareSizesByArea);
    }

    private int getMaxSupportedFpsFromAttachedSurfaces(List<AttachedSurfaceInfo> list, boolean z2) {
        int updatedMaximumFps = Integer.MAX_VALUE;
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            updatedMaximumFps = getUpdatedMaximumFps(updatedMaximumFps, attachedSurfaceInfo.getImageFormat(), attachedSurfaceInfo.getSize(), z2);
        }
        return updatedMaximumFps;
    }

    private static Size[] getOutputSizes(StreamConfigurationMap streamConfigurationMap, int i2, Rational rational) {
        Size[] outputSizes;
        try {
            outputSizes = i2 == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i2);
        } catch (Throwable unused) {
            outputSizes = null;
        }
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        if (rational == null) {
            return outputSizes;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : outputSizes) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                arrayList.add(size);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    private static int getRangeDistance(Range<Integer> range, Range<Integer> range2) {
        Preconditions.checkState((range.contains((Integer) range2.getUpper()) || range.contains((Integer) range2.getLower())) ? false : true, "Ranges must not intersect");
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    private static int getRangeLength(Range<Integer> range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    private Size getRecordSize() {
        try {
            Size recordSizeFromCamcorderProfile = getRecordSizeFromCamcorderProfile(Integer.parseInt(this.mCameraId));
            if (recordSizeFromCamcorderProfile != null) {
                return recordSizeFromCamcorderProfile;
            }
        } catch (NumberFormatException unused) {
        }
        Size recordSizeFromStreamConfigurationMap = getRecordSizeFromStreamConfigurationMap();
        return recordSizeFromStreamConfigurationMap != null ? recordSizeFromStreamConfigurationMap : SizeUtil.RESOLUTION_480P;
    }

    private Size getRecordSizeFromCamcorderProfile(int i2) {
        CamcorderProfile camcorderProfile;
        int[] iArr = {1, 13, 10, 8, 12, 6, 5, 4};
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = iArr[i8];
            if (this.mCamcorderProfileHelper.hasProfile(i2, i9) && (camcorderProfile = this.mCamcorderProfileHelper.get(i2, i9)) != null) {
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            }
        }
        return null;
    }

    private Size getRecordSizeFromStreamConfigurationMap() {
        Size[] outputSizes;
        try {
            outputSizes = this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap().getOutputSizes(MediaRecorder.class);
        } catch (Throwable unused) {
            outputSizes = null;
        }
        if (outputSizes == null) {
            return null;
        }
        Arrays.sort(outputSizes, new CompareSizesByArea(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = SizeUtil.RESOLUTION_1080P;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return null;
    }

    private static int getRequiredMaxBitDepth(Map<UseCaseConfig<?>, DynamicRange> map) {
        Iterator<DynamicRange> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().getBitDepth() == 10) {
                return 10;
            }
        }
        return 8;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private List<SurfaceCombination> getSurfaceCombinationsByFeatureSettings(FeatureSettings featureSettings) {
        List<SurfaceCombination> list;
        if (this.mFeatureSettingsToSupportedCombinationsMap.containsKey(featureSettings)) {
            return this.mFeatureSettingsToSupportedCombinationsMap.get(featureSettings);
        }
        ArrayList arrayList = new ArrayList();
        if (featureSettings.requiresFeatureComboQuery()) {
            if (this.mFcqSurfaceCombinations.isEmpty()) {
                generateFcqSurfaceCombinations();
            }
            arrayList.addAll(this.mFcqSurfaceCombinations);
            list = arrayList;
        } else if (featureSettings.isUltraHdrOn()) {
            if (this.mSurfaceCombinationsUltraHdr.isEmpty()) {
                generateUltraHdrSupportedCombinationList();
            }
            list = arrayList;
            if (featureSettings.getCameraMode() == 0) {
                arrayList.addAll(this.mSurfaceCombinationsUltraHdr);
                list = arrayList;
            }
        } else if (featureSettings.isHighSpeedOn()) {
            if (this.mHighSpeedSurfaceCombinations.isEmpty()) {
                generateHighSpeedSupportedCombinationList();
            }
            arrayList.addAll(this.mHighSpeedSurfaceCombinations);
            list = arrayList;
        } else if (featureSettings.getRequiredMaxBitDepth() == 8) {
            int cameraMode = featureSettings.getCameraMode();
            if (cameraMode == 1) {
                list = this.mConcurrentSurfaceCombinations;
            } else if (cameraMode != 2) {
                arrayList.addAll(featureSettings.isPreviewStabilizationOn() ? this.mPreviewStabilizationSurfaceCombinations : this.mSurfaceCombinations);
                list = arrayList;
            } else {
                arrayList.addAll(this.mUltraHighSurfaceCombinations);
                arrayList.addAll(this.mSurfaceCombinations);
                list = arrayList;
            }
        } else {
            list = arrayList;
            if (featureSettings.getRequiredMaxBitDepth() == 10) {
                list = arrayList;
                if (featureSettings.getCameraMode() == 0) {
                    arrayList.addAll(this.mSurfaceCombinations10Bit);
                    list = arrayList;
                }
            }
        }
        this.mFeatureSettingsToSupportedCombinationsMap.put(featureSettings, list);
        return list;
    }

    private Pair<List<SurfaceConfig>, Integer> getSurfaceConfigListAndFpsCeiling(FeatureSettings featureSettings, List<AttachedSurfaceInfo> list, List<Size> list2, List<UseCaseConfig<?>> list3, List<Integer> list4, int i2, Map<Integer, AttachedSurfaceInfo> map, Map<Integer, UseCaseConfig<?>> map2) {
        ArrayList arrayList = new ArrayList();
        for (AttachedSurfaceInfo attachedSurfaceInfo : list) {
            arrayList.add(attachedSurfaceInfo.getSurfaceConfig());
            if (map != null) {
                map.put(Integer.valueOf(arrayList.size() - 1), attachedSurfaceInfo);
            }
        }
        for (int i8 = 0; i8 < list2.size(); i8++) {
            Size size = list2.get(i8);
            UseCaseConfig<?> useCaseConfig = list3.get(list4.get(i8).intValue());
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(inputFormat, size, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat), featureSettings.getCameraMode(), featureSettings.requiresFeatureComboQuery() ? SurfaceConfig.ConfigSource.FEATURE_COMBINATION_TABLE : SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, useCaseConfig.getStreamUseCase()));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList.size() - 1), useCaseConfig);
            }
            i2 = getUpdatedMaximumFps(i2, useCaseConfig.getInputFormat(), size, featureSettings.isHighSpeedOn());
        }
        return new Pair<>(arrayList, Integer.valueOf(i2));
    }

    private Range<Integer> getTargetFpsRange(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, List<Integer> list3, boolean z2) {
        Range<Integer> updatedTargetFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            updatedTargetFrameRate = getUpdatedTargetFrameRate(it.next().getTargetFrameRate(), updatedTargetFrameRate, z2);
        }
        Iterator<Integer> it2 = list3.iterator();
        while (it2.hasNext()) {
            Range<Integer> targetFrameRate = list2.get(it2.next().intValue()).getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
            Objects.requireNonNull(targetFrameRate);
            updatedTargetFrameRate = getUpdatedTargetFrameRate(targetFrameRate, updatedTargetFrameRate, z2);
        }
        return updatedTargetFrameRate;
    }

    private int getUpdatedMaximumFps(int i2, int i8, Size size, boolean z2) {
        return Math.min(i2, getMaxFrameRate(i8, size, z2));
    }

    private Range<Integer> getUpdatedTargetFrameRate(Range<Integer> range, Range<Integer> range2, boolean z2) {
        Range<Integer> range3 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (range3.equals(range2) && range3.equals(range)) {
            return range3;
        }
        if (range3.equals(range2)) {
            return range;
        }
        if (range3.equals(range)) {
            return range2;
        }
        if (z2) {
            Preconditions.checkState(range == range2, "All targetFrameRate should be the same if strict fps is required");
            return range;
        }
        try {
            return range2.intersect(range);
        } catch (IllegalArgumentException unused) {
            return range2;
        }
    }

    private static List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<UseCaseConfig<?>> it = list.iterator();
        while (it.hasNext()) {
            int surfaceOccupancyPriority = it.next().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            int iIntValue = ((Integer) obj).intValue();
            for (UseCaseConfig<?> useCaseConfig : list) {
                if (iIntValue == useCaseConfig.getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCaseConfig)));
                }
            }
        }
        return arrayList;
    }

    private static boolean isConfigFrameRateAcceptable(int i2, Range<Integer> range, int i8) {
        return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(range) || i8 >= i2 || i8 >= ((Integer) range.getUpper()).intValue();
    }

    private boolean isStrictFpsRequired(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2) {
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        Boolean boolValueOf = null;
        while (it.hasNext()) {
            boolValueOf = Boolean.valueOf(getAndValidateIsStrictFpsRequired(it.next().isStrictFrameRateRequired(), boolValueOf));
        }
        Iterator<UseCaseConfig<?>> it2 = list2.iterator();
        while (it2.hasNext()) {
            boolValueOf = Boolean.valueOf(getAndValidateIsStrictFpsRequired(it2.next().isStrictFrameRateRequired(), boolValueOf));
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    private static boolean isUltraHdrOn(List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getImageFormat() == 4101) {
                return true;
            }
        }
        Iterator<UseCaseConfig<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getInputFormat() == 4101) {
                return true;
            }
        }
        return false;
    }

    private boolean isUseCasesCombinationSupported(FeatureSettings featureSettings, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<AttachedSurfaceInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurfaceConfig());
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea();
        for (UseCaseConfig<?> useCaseConfig : map.keySet()) {
            List<Size> list2 = map.get(useCaseConfig);
            Preconditions.checkArgument((list2 == null || list2.isEmpty()) ? false : true, "No available output size is found for " + useCaseConfig + ".");
            Size size = (Size) Collections.min(list2, compareSizesByArea);
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(inputFormat, size, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat), featureSettings.getCameraMode(), SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, useCaseConfig.getStreamUseCase()));
        }
        Map<SurfaceConfig, DynamicRange> map2 = Collections.EMPTY_MAP;
        List<UseCaseConfig<?>> list3 = Collections.EMPTY_LIST;
        return checkSupported(featureSettings, arrayList, map2, list3, list3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$findBestSizesAndFps$1(FeatureSettings featureSettings, List list, Map map, List list2, List list3) {
        return Boolean.valueOf(checkSupported(featureSettings, list, map, list2, list3));
    }

    private /* synthetic */ Boolean lambda$getOrderedSupportedStreamUseCaseSurfaceConfigList$0(List list) {
        return Boolean.valueOf(StreamUseCaseUtil.areStreamUseCasesAvailableForSurfaceConfigs(this.mCharacteristics, list));
    }

    private void populateReducedSizeListAndUniqueMaxFpsMap(FeatureSettings featureSettings, Range<Integer> range, Size size, int i2, StreamUseCase streamUseCase, boolean z2, Map<SurfaceConfig.ConfigSize, Set<Integer>> map, List<Size> list) {
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.transformSurfaceConfig(i2, size, getUpdatedSurfaceSizeDefinitionByFormat(i2), featureSettings.getCameraMode(), featureSettings.requiresFeatureComboQuery() ? SurfaceConfig.ConfigSource.FEATURE_COMBINATION_TABLE : SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCase).getConfigSize();
        Range<Integer> range2 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        int maxFrameRate = (!range2.equals(range) || z2) ? getMaxFrameRate(i2, size, featureSettings.isHighSpeedOn()) : Integer.MAX_VALUE;
        if (featureSettings.isFeatureComboInvocation()) {
            if (configSize == SurfaceConfig.ConfigSize.NOT_SUPPORT) {
                return;
            }
            if (!range2.equals(range) && maxFrameRate < ((Integer) range.getUpper()).intValue()) {
                return;
            }
        }
        Set<Integer> hashSet = map.get(configSize);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(configSize, hashSet);
        }
        if (hashSet.contains(Integer.valueOf(maxFrameRate))) {
            return;
        }
        list.add(size);
        hashSet.add(Integer.valueOf(maxFrameRate));
    }

    private void refreshPreviewSize() {
        this.mDisplayInfoManager.refresh();
        if (this.mSurfaceSizeDefinition == null) {
            generateSurfaceSizeDefinition();
        } else {
            this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(this.mSurfaceSizeDefinition.getAnalysisSize(), this.mSurfaceSizeDefinition.getS720pSizeMap(), this.mDisplayInfoManager.getPreviewSize(), this.mSurfaceSizeDefinition.getS1440pSizeMap(), this.mSurfaceSizeDefinition.getRecordSize(), this.mSurfaceSizeDefinition.getMaximumSizeMap(), this.mSurfaceSizeDefinition.getMaximum4x3SizeMap(), this.mSurfaceSizeDefinition.getMaximum16x9SizeMap(), this.mSurfaceSizeDefinition.getUltraMaximumSizeMap());
        }
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    private SurfaceStreamSpecQueryResult resolveSpecsByCheckingMethod(CheckingMethod checkingMethod, FeatureSettings featureSettings, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map, List<UseCaseConfig<?>> list2, List<Integer> list3, Map<UseCaseConfig<?>, DynamicRange> map2, boolean z2) {
        Logger.d(TAG, "resolveSpecsByCheckingMethod: checkingMethod = " + checkingMethod);
        int iOrdinal = checkingMethod.ordinal();
        if (iOrdinal == 1) {
            return resolveSpecsBySettings(createFeatureSettings(featureSettings.getCameraMode(), featureSettings.hasVideoCapture(), map2, featureSettings.isPreviewStabilizationOn(), featureSettings.isUltraHdrOn(), featureSettings.isHighSpeedOn(), featureSettings.isFeatureComboInvocation(), true, featureSettings.getTargetFpsRange(), featureSettings.isStrictFpsRequired()), list, map, list2, list3, map2, z2);
        }
        if (iOrdinal != 2) {
            return resolveSpecsBySettings(featureSettings, list, map, list2, list3, map2, z2);
        }
        try {
            return resolveSpecsBySettings(featureSettings, list, map, list2, list3, map2, z2);
        } catch (IllegalArgumentException e) {
            Logger.d(TAG, "Failed to find a supported combination without feature combo, trying again with feature combo", e);
            return resolveSpecsBySettings(createFeatureSettings(featureSettings.getCameraMode(), featureSettings.hasVideoCapture(), map2, featureSettings.isPreviewStabilizationOn(), featureSettings.isUltraHdrOn(), featureSettings.isHighSpeedOn(), featureSettings.isFeatureComboInvocation(), true, featureSettings.getTargetFpsRange(), featureSettings.isStrictFpsRequired()), list, map, list2, list3, map2, z2);
        }
    }

    private SurfaceStreamSpecQueryResult resolveSpecsBySettings(FeatureSettings featureSettings, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map, List<UseCaseConfig<?>> list2, List<Integer> list3, Map<UseCaseConfig<?>, DynamicRange> map2, boolean z2) {
        HashMap map3;
        HashMap map4;
        int i2;
        int i8;
        List<AttachedSurfaceInfo> list4 = list;
        List<UseCaseConfig<?>> list5 = list2;
        Logger.d(TAG, "resolveSpecsBySettings: featureSettings = " + featureSettings);
        if (!featureSettings.requiresFeatureComboQuery() && !isUseCasesCombinationSupported(featureSettings, list, map)) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + list4 + ". New configs: " + list5 + ". GroupableFeature settings: " + featureSettings);
        }
        Map<UseCaseConfig<?>, List<Size>> mapFilterSupportedSizes = filterSupportedSizes(map, featureSettings, z2);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list3.iterator();
        while (it.hasNext()) {
            UseCaseConfig<?> useCaseConfig = list5.get(it.next().intValue());
            List<Size> list6 = mapFilterSupportedSizes.get(useCaseConfig);
            if (list6 == null) {
                list6 = Collections.EMPTY_LIST;
            }
            arrayList.add(applyResolutionSelectionOrderRelatedWorkarounds(list6, useCaseConfig.getInputFormat()));
        }
        List<List<Size>> sizeArrangements = featureSettings.isHighSpeedOn() ? this.mHighSpeedResolver.getSizeArrangements(arrayList) : getAllPossibleSizeArrangements(arrayList);
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        HashMap map7 = new HashMap();
        HashMap map8 = new HashMap();
        boolean zContainsZslUseCase = StreamUseCaseUtil.containsZslUseCase(list4, list5);
        int maxSupportedFpsFromAttachedSurfaces = getMaxSupportedFpsFromAttachedSurfaces(list4, featureSettings.isHighSpeedOn());
        List<SurfaceConfig> orderedSupportedStreamUseCaseSurfaceConfigList = null;
        if (!this.mIsStreamUseCaseSupported || zContainsZslUseCase) {
            map3 = map7;
            map4 = map8;
            i2 = maxSupportedFpsFromAttachedSurfaces;
        } else {
            Iterator<List<Size>> it2 = sizeArrangements.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    map3 = map7;
                    map4 = map8;
                    i2 = maxSupportedFpsFromAttachedSurfaces;
                    break;
                }
                Pair<List<SurfaceConfig>, Integer> surfaceConfigListAndFpsCeiling = getSurfaceConfigListAndFpsCeiling(featureSettings, list4, it2.next(), list5, list3, maxSupportedFpsFromAttachedSurfaces, map7, map8);
                map3 = map7;
                map4 = map8;
                i2 = maxSupportedFpsFromAttachedSurfaces;
                orderedSupportedStreamUseCaseSurfaceConfigList = getOrderedSupportedStreamUseCaseSurfaceConfigList(featureSettings, (List) surfaceConfigListAndFpsCeiling.first, map3, map4);
                if (orderedSupportedStreamUseCaseSurfaceConfigList != null) {
                    break;
                }
                map3.clear();
                map4.clear();
                list5 = list2;
                map7 = map3;
                maxSupportedFpsFromAttachedSurfaces = i2;
                list4 = list;
                map8 = map4;
            }
            Logger.d(TAG, "orderedSurfaceConfigListForStreamUseCase = " + orderedSupportedStreamUseCaseSurfaceConfigList);
        }
        List<SurfaceConfig> list7 = orderedSupportedStreamUseCaseSurfaceConfigList;
        HashMap map9 = map3;
        HashMap map10 = map4;
        BestSizesAndMaxFpsForConfigs bestSizesAndMaxFpsForConfigsFindBestSizesAndFps = findBestSizesAndFps(featureSettings, list, list2, list3, sizeArrangements, list7, map2, i2, z2);
        Logger.d(TAG, "resolveSpecsBySettings: bestSizesAndFps = " + bestSizesAndMaxFpsForConfigsFindBestSizesAndFps);
        List<Size> bestSizes = bestSizesAndMaxFpsForConfigsFindBestSizesAndFps.getBestSizes();
        int maxFpsForBestSizes = bestSizesAndMaxFpsForConfigsFindBestSizesAndFps.getMaxFpsForBestSizes();
        List<Size> bestSizesForStreamUseCase = bestSizesAndMaxFpsForConfigsFindBestSizesAndFps.getBestSizesForStreamUseCase();
        int maxFpsForStreamUseCase = bestSizesAndMaxFpsForConfigsFindBestSizesAndFps.getMaxFpsForStreamUseCase();
        int maxFpsForAllSizes = bestSizesAndMaxFpsForConfigsFindBestSizesAndFps.getMaxFpsForAllSizes();
        if (bestSizes == null) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + " and Hardware level: " + this.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + " New configs: " + list2);
        }
        Range<Integer> closestSupportedDeviceFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (closestSupportedDeviceFrameRate.equals(featureSettings.getTargetFpsRange())) {
            i8 = maxFpsForAllSizes;
            if (featureSettings.isHighSpeedOn()) {
                closestSupportedDeviceFrameRate = getClosestSupportedDeviceFrameRate(HighSpeedResolver.DEFAULT_FPS, maxFpsForBestSizes, this.mHighSpeedResolver.getFrameRateRangesFor(bestSizes));
            }
        } else {
            Range<Integer>[] frameRateRangesFor = featureSettings.isHighSpeedOn() ? this.mHighSpeedResolver.getFrameRateRangesFor(bestSizes) : (Range[]) this.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            Range<Integer> closestSupportedDeviceFrameRate2 = getClosestSupportedDeviceFrameRate(featureSettings.getTargetFpsRange(), maxFpsForBestSizes, frameRateRangesFor);
            if (featureSettings.isFeatureComboInvocation() || featureSettings.isStrictFpsRequired()) {
                i8 = maxFpsForAllSizes;
                Preconditions.checkArgument(closestSupportedDeviceFrameRate2.equals(featureSettings.getTargetFpsRange()), "Target FPS range " + featureSettings.getTargetFpsRange() + " is not supported. Max FPS supported by the calculated best combination: " + maxFpsForBestSizes + ". Calculated best FPS range for device: " + closestSupportedDeviceFrameRate2 + ". Device supported FPS ranges: " + Arrays.toString(frameRateRangesFor));
            } else {
                i8 = maxFpsForAllSizes;
            }
            closestSupportedDeviceFrameRate = closestSupportedDeviceFrameRate2;
        }
        Iterator<UseCaseConfig<?>> it3 = list2.iterator();
        while (it3.hasNext()) {
            UseCaseConfig<?> next = it3.next();
            Iterator<UseCaseConfig<?>> it4 = it3;
            StreamSpec.Builder zslDisabled = StreamSpec.builder(bestSizes.get(list3.indexOf(Integer.valueOf(list2.indexOf(next))))).setSessionType(featureSettings.isHighSpeedOn() ? 1 : 0).setDynamicRange((DynamicRange) Preconditions.checkNotNull(map2.get(next))).setImplementationOptions(StreamUseCaseUtil.getStreamSpecImplementationOptions(next)).setZslDisabled(featureSettings.hasVideoCapture());
            if (!StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(closestSupportedDeviceFrameRate)) {
                zslDisabled.setExpectedFrameRateRange(closestSupportedDeviceFrameRate);
            }
            map6.put(next, zslDisabled.build());
            it3 = it4;
        }
        if (list7 != null && maxFpsForBestSizes == maxFpsForStreamUseCase && bestSizes.size() == bestSizesForStreamUseCase.size()) {
            int i9 = 0;
            while (true) {
                if (i9 < bestSizes.size()) {
                    if (!bestSizes.get(i9).equals(bestSizesForStreamUseCase.get(i9))) {
                        break;
                    }
                    i9++;
                } else if (!StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithInteropOverride(this.mCharacteristics, list, map6, map5)) {
                    StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(map6, map5, map9, map10, list7);
                }
            }
        }
        return new SurfaceStreamSpecQueryResult(map6, map5, i8);
    }

    private void updateMaximumSizeByFormat(Map<Integer, Size> map, int i2, Rational rational) {
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), i2, true, rational);
        if (maxOutputSizeByFormat != null) {
            map.put(Integer.valueOf(i2), maxOutputSizeByFormat);
        }
    }

    private void updateS720pOrS1440pSizeByFormat(Map<Integer, Size> map, Size size, int i2) {
        if (this.mIsConcurrentCameraModeSupported) {
            Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), i2, false, null);
            Integer numValueOf = Integer.valueOf(i2);
            if (maxOutputSizeByFormat != null) {
                size = (Size) Collections.min(Arrays.asList(size, maxOutputSizeByFormat), new CompareSizesByArea());
            }
            map.put(numValueOf, size);
        }
    }

    private void updateUltraMaximumSizeByFormat(Map<Integer, Size> map, int i2) {
        StreamConfigurationMap streamConfigurationMap;
        if (Build.VERSION.SDK_INT < 31 || !this.mIsUltraHighResolutionSensorSupported || (streamConfigurationMap = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) == null) {
            return;
        }
        map.put(Integer.valueOf(i2), getMaxOutputSizeByFormat(streamConfigurationMap, i2, true, null));
    }

    @VisibleForTesting
    public List<Size> applyResolutionSelectionOrderRelatedWorkarounds(List<Size> list, int i2) {
        Rational rational;
        int i8 = this.mTargetAspectRatio.get(this.mCameraId, this.mCharacteristics);
        if (i8 == 0) {
            rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        } else if (i8 != 1) {
            rational = null;
            if (i8 == 2) {
                Size maximumSize = getUpdatedSurfaceSizeDefinitionByFormat(256).getMaximumSize(256);
                if (maximumSize != null) {
                    rational = new Rational(maximumSize.getWidth(), maximumSize.getHeight());
                }
            } else if (i8 != 3) {
                throw new AssertionError(a1.a.g(i8, "Undefined targetAspectRatio: "));
            }
        } else {
            rational = AspectRatioUtil.ASPECT_RATIO_16_9;
        }
        if (rational != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Size size : list) {
                if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
                    arrayList.add(size);
                } else {
                    arrayList2.add(size);
                }
            }
            arrayList2.addAll(0, arrayList);
            list = arrayList2;
        }
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(i2), list);
    }

    public boolean checkSupported(FeatureSettings featureSettings, List<SurfaceConfig> list, Map<SurfaceConfig, DynamicRange> map, List<UseCaseConfig<?>> list2, List<Integer> list3) {
        Iterator<SurfaceCombination> it = getSurfaceCombinationsByFeatureSettings(featureSettings).iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 = it.next().getOrderedSupportedSurfaceConfigList(list) != null;
            if (z2) {
                break;
            }
        }
        if (!z2 || !featureSettings.requiresFeatureComboQuery()) {
            return z2;
        }
        SessionConfig sessionConfigCreateFeatureComboSessionConfig = createFeatureComboSessionConfig(featureSettings, list, map, list2, list3);
        boolean zIsSupported = this.mFeatureCombinationQuery.isSupported(sessionConfigCreateFeatureComboSessionConfig);
        Iterator<DeferrableSurface> it2 = sessionConfigCreateFeatureComboSessionConfig.getSurfaces().iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
        return zIsSupported;
    }

    @VisibleForTesting
    public Map<UseCaseConfig<?>, List<Size>> filterSupportedSizes(Map<UseCaseConfig<?>, List<Size>> map, FeatureSettings featureSettings, boolean z2) {
        HashMap map2 = new HashMap();
        for (UseCaseConfig<?> useCaseConfig : map.keySet()) {
            ArrayList arrayList = new ArrayList();
            HashMap map3 = new HashMap();
            List<Size> list = map.get(useCaseConfig);
            Objects.requireNonNull(list);
            Iterator<Size> it = list.iterator();
            while (it.hasNext()) {
                populateReducedSizeListAndUniqueMaxFpsMap(featureSettings, featureSettings.getTargetFpsRange(), it.next(), useCaseConfig.getInputFormat(), useCaseConfig.getStreamUseCase(), z2, map3, arrayList);
            }
            map2.put(useCaseConfig, arrayList);
        }
        return map2;
    }

    public List<SurfaceConfig> getOrderedSupportedStreamUseCaseSurfaceConfigList(FeatureSettings featureSettings, List<SurfaceConfig> list, Map<Integer, AttachedSurfaceInfo> map, Map<Integer, UseCaseConfig<?>> map2) {
        if (!StreamUseCaseUtil.shouldUseStreamUseCase(featureSettings)) {
            return null;
        }
        Iterator<SurfaceCombination> it = this.mSurfaceCombinationsStreamUseCase.iterator();
        while (it.hasNext()) {
            List<SurfaceConfig> orderedSupportedSurfaceConfigList = it.next().getOrderedSupportedSurfaceConfigList(list);
            if (orderedSupportedSurfaceConfigList != null && StreamUseCaseUtil.areCaptureTypesEligible(map, map2, orderedSupportedSurfaceConfigList) && lambda$getOrderedSupportedStreamUseCaseSurfaceConfigList$0(orderedSupportedSurfaceConfigList).booleanValue()) {
                return orderedSupportedSurfaceConfigList;
            }
        }
        return null;
    }

    public SurfaceStreamSpecQueryResult getSuggestedStreamSpecifications(int i2, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map, boolean z2, boolean z7, boolean z8, boolean z9) {
        boolean zIsStrictFpsRequired;
        Range<Integer> targetFpsRange;
        refreshPreviewSize();
        boolean zIsHighSpeedOn = HighSpeedResolver.isHighSpeedOn(list, map.keySet());
        Map<UseCaseConfig<?>, List<Size>> mapFilterCommonSupportedSizes = zIsHighSpeedOn ? this.mHighSpeedResolver.filterCommonSupportedSizes(map) : map;
        ArrayList arrayList = new ArrayList(mapFilterCommonSupportedSizes.keySet());
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(arrayList);
        Map<UseCaseConfig<?>, DynamicRange> mapResolveAndValidateDynamicRanges = this.mDynamicRangeResolver.resolveAndValidateDynamicRanges(list, arrayList, useCasesPriorityOrder);
        Logger.d(TAG, "resolvedDynamicRanges = " + mapResolveAndValidateDynamicRanges);
        boolean zIsUltraHdrOn = isUltraHdrOn(list, mapFilterCommonSupportedSizes);
        if (z9) {
            targetFpsRange = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            zIsStrictFpsRequired = false;
        } else {
            zIsStrictFpsRequired = isStrictFpsRequired(list, arrayList);
            targetFpsRange = getTargetFpsRange(list, arrayList, useCasesPriorityOrder, zIsStrictFpsRequired);
        }
        Range<Integer> range = targetFpsRange;
        boolean z10 = zIsStrictFpsRequired;
        if (z2 && !this.mIsPreviewStabilizationSupported && z8) {
            throw new IllegalArgumentException("Preview stabilization is not supported by the camera.");
        }
        return resolveSpecsByCheckingMethod(getCheckingMethod(mapResolveAndValidateDynamicRanges.values(), range, z2, zIsUltraHdrOn, z8), createFeatureSettings(i2, z7, mapResolveAndValidateDynamicRanges, z2, zIsUltraHdrOn, zIsHighSpeedOn, z8, false, range, z10), list, mapFilterCommonSupportedSizes, arrayList, useCasesPriorityOrder, mapResolveAndValidateDynamicRanges, z9);
    }

    @VisibleForTesting
    public SurfaceSizeDefinition getUpdatedSurfaceSizeDefinitionByFormat(int i2) {
        if (!this.mSurfaceSizeDefinitionFormats.contains(Integer.valueOf(i2))) {
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS720pSizeMap(), SizeUtil.RESOLUTION_720P, i2);
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS1440pSizeMap(), SizeUtil.RESOLUTION_1440P, i2);
            updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximumSizeMap(), i2, null);
            updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximum4x3SizeMap(), i2, AspectRatioUtil.ASPECT_RATIO_4_3);
            updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximum16x9SizeMap(), i2, AspectRatioUtil.ASPECT_RATIO_16_9);
            updateUltraMaximumSizeByFormat(this.mSurfaceSizeDefinition.getUltraMaximumSizeMap(), i2);
            this.mSurfaceSizeDefinitionFormats.add(Integer.valueOf(i2));
        }
        return this.mSurfaceSizeDefinition;
    }

    public SurfaceConfig transformSurfaceConfig(int i2, int i8, Size size, StreamUseCase streamUseCase) {
        return SurfaceConfig.transformSurfaceConfig(i8, size, getUpdatedSurfaceSizeDefinitionByFormat(i8), i2, SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCase);
    }

    private int getMaxFrameRate(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2, Size size) {
        StreamConfigurationMapCompat streamConfigurationMapCompat = cameraCharacteristicsCompat.getStreamConfigurationMapCompat();
        Objects.requireNonNull(streamConfigurationMapCompat);
        long outputMinFrameDuration = streamConfigurationMapCompat.getOutputMinFrameDuration(i2, size);
        if (outputMinFrameDuration > 0) {
            return (int) (1.0E9d / outputMinFrameDuration);
        }
        if (!this.mIsManualSensorSupported) {
            return Integer.MAX_VALUE;
        }
        Logger.w(TAG, "minFrameDuration: " + outputMinFrameDuration + " is invalid for imageFormat = " + i2 + ", size = " + size);
        return 0;
    }

    private void checkCustomization() {
    }
}
