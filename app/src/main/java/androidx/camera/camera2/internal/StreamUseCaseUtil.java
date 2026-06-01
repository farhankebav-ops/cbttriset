package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamUseCaseUtil {
    public static final StreamUseCaseUtil INSTANCE = new StreamUseCaseUtil();
    public static final Config.Option<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
    private static final String TAG = "StreamUseCaseUtil";

    static {
        Class cls = Long.TYPE;
        kotlin.jvm.internal.k.b(cls);
        Config.Option<Long> optionCreate = Config.Option.create("camera2.streamSpec.streamUseCase", cls);
        kotlin.jvm.internal.k.d(optionCreate, "create(...)");
        STREAM_USE_CASE_STREAM_SPEC_OPTION = optionCreate;
        s5.f fVar = new s5.f();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
            UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS;
            fVar.put(4L, n7.b.O(captureType, captureType2, captureType3));
            fVar.put(1L, n7.b.O(captureType, captureType2, captureType3));
            fVar.put(2L, n7.b.N(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE));
            fVar.put(3L, n7.b.N(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE));
        }
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = fVar.b();
        s5.f fVar2 = new s5.f();
        if (i2 >= 33) {
            UseCaseConfigFactory.CaptureType captureType4 = UseCaseConfigFactory.CaptureType.PREVIEW;
            UseCaseConfigFactory.CaptureType captureType5 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            fVar2.put(4L, n7.b.O(captureType4, UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, captureType5));
            fVar2.put(3L, n7.b.O(captureType4, captureType5));
        }
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = fVar2.b();
    }

    private StreamUseCaseUtil() {
    }

    public static final boolean areCaptureTypesEligible(Map<Integer, ? extends AttachedSurfaceInfo> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends UseCaseConfig<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        List<UseCaseConfigFactory.CaptureType> captureTypes;
        kotlin.jvm.internal.k.e(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        kotlin.jvm.internal.k.e(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        kotlin.jvm.internal.k.e(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i2 = 0; i2 < size; i2++) {
            long value = surfaceConfigsWithStreamUseCase.get(i2).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i2))) {
                AttachedSurfaceInfo attachedSurfaceInfo = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i2));
                StreamUseCaseUtil streamUseCaseUtil = INSTANCE;
                kotlin.jvm.internal.k.b(attachedSurfaceInfo);
                UseCaseConfigFactory.CaptureType captureType = attachedSurfaceInfo.getCaptureTypes().size() == 1 ? attachedSurfaceInfo.getCaptureTypes().get(0) : UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                kotlin.jvm.internal.k.b(captureType);
                List<UseCaseConfigFactory.CaptureType> captureTypes2 = attachedSurfaceInfo.getCaptureTypes();
                kotlin.jvm.internal.k.d(captureTypes2, "getCaptureTypes(...)");
                if (!streamUseCaseUtil.isEligibleCaptureType(captureType, value, captureTypes2)) {
                    return false;
                }
            } else {
                if (!surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i2))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                UseCaseConfig<?> useCaseConfig = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i2));
                kotlin.jvm.internal.k.b(useCaseConfig);
                UseCaseConfig<?> useCaseConfig2 = useCaseConfig;
                StreamUseCaseUtil streamUseCaseUtil2 = INSTANCE;
                UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig2.getCaptureType();
                kotlin.jvm.internal.k.d(captureType2, "getCaptureType(...)");
                if (useCaseConfig2.getCaptureType() == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
                    captureTypes = ((StreamSharingConfig) useCaseConfig2).getCaptureTypes();
                    kotlin.jvm.internal.k.d(captureTypes, "getCaptureTypes(...)");
                } else {
                    captureTypes = r5.r.f13638a;
                }
                if (!streamUseCaseUtil2.isEligibleCaptureType(captureType2, value, captureTypes)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean areStreamUseCasesAvailable(Set<Long> set, Set<Long> set2) {
        Iterator<Long> it = set2.iterator();
        while (it.hasNext()) {
            if (!set.contains(Long.valueOf(it.next().longValue()))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean areStreamUseCasesAvailableForSurfaceConfigs(CameraCharacteristicsCompat characteristicsCompat, List<SurfaceConfig> surfaceConfigs) {
        long[] jArr;
        kotlin.jvm.internal.k.e(characteristicsCompat, "characteristicsCompat");
        kotlin.jvm.internal.k.e(surfaceConfigs, "surfaceConfigs");
        if (Build.VERSION.SDK_INT >= 33 && (jArr = (long[]) characteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            Iterator<SurfaceConfig> it = surfaceConfigs.iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(Long.valueOf(it.next().getStreamUseCase().getValue()))) {
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean containsZslUseCase(List<? extends AttachedSurfaceInfo> attachedSurfaces, List<? extends UseCaseConfig<?>> newUseCaseConfigs) {
        kotlin.jvm.internal.k.e(attachedSurfaces, "attachedSurfaces");
        kotlin.jvm.internal.k.e(newUseCaseConfigs, "newUseCaseConfigs");
        for (AttachedSurfaceInfo attachedSurfaceInfo : attachedSurfaces) {
            List<UseCaseConfigFactory.CaptureType> captureTypes = attachedSurfaceInfo.getCaptureTypes();
            kotlin.jvm.internal.k.d(captureTypes, "getCaptureTypes(...)");
            UseCaseConfigFactory.CaptureType captureType = captureTypes.get(0);
            StreamUseCaseUtil streamUseCaseUtil = INSTANCE;
            Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
            kotlin.jvm.internal.k.b(implementationOptions);
            kotlin.jvm.internal.k.b(captureType);
            if (streamUseCaseUtil.isZslUseCase(implementationOptions, captureType)) {
                return true;
            }
        }
        for (UseCaseConfig<?> useCaseConfig : newUseCaseConfigs) {
            StreamUseCaseUtil streamUseCaseUtil2 = INSTANCE;
            UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig.getCaptureType();
            kotlin.jvm.internal.k.d(captureType2, "getCaptureType(...)");
            if (streamUseCaseUtil2.isZslUseCase(useCaseConfig, captureType2)) {
                return true;
            }
        }
        return false;
    }

    public static final Camera2ImplConfig getStreamSpecImplementationOptions(UseCaseConfig<?> useCaseConfig) {
        kotlin.jvm.internal.k.e(useCaseConfig, "useCaseConfig");
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        kotlin.jvm.internal.k.d(mutableOptionsBundleCreate, "create(...)");
        Config.Option<?> option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (useCaseConfig.containsOption(option)) {
            mutableOptionsBundleCreate.insertOption(option, useCaseConfig.retrieveOption(option));
        }
        Config.Option<?> option2 = UseCaseConfig.OPTION_ZSL_DISABLED;
        if (useCaseConfig.containsOption(option2)) {
            mutableOptionsBundleCreate.insertOption(option2, useCaseConfig.retrieveOption(option2));
        }
        Config.Option<?> option3 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (useCaseConfig.containsOption(option3)) {
            mutableOptionsBundleCreate.insertOption(option3, useCaseConfig.retrieveOption(option3));
        }
        Config.Option<?> option4 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (useCaseConfig.containsOption(option4)) {
            mutableOptionsBundleCreate.insertOption(option4, useCaseConfig.retrieveOption(option4));
        }
        return new Camera2ImplConfig(mutableOptionsBundleCreate);
    }

    private final Config getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(Config config, Long l) {
        Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (config.containsOption(option) && kotlin.jvm.internal.k.a(config.retrieveOption(option), l)) {
            return null;
        }
        MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from(config);
        kotlin.jvm.internal.k.d(mutableOptionsBundleFrom, "from(...)");
        mutableOptionsBundleFrom.insertOption(option, l);
        return new Camera2ImplConfig(mutableOptionsBundleFrom);
    }

    private final boolean isEligibleCaptureType(UseCaseConfigFactory.CaptureType captureType, long j, List<? extends UseCaseConfigFactory.CaptureType> list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType != UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
            if (map.containsKey(Long.valueOf(j))) {
                Set<UseCaseConfigFactory.CaptureType> set = map.get(Long.valueOf(j));
                kotlin.jvm.internal.k.b(set);
                if (set.contains(captureType)) {
                    return true;
                }
            }
            return false;
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
        if (!map2.containsKey(Long.valueOf(j))) {
            return false;
        }
        Set<UseCaseConfigFactory.CaptureType> set2 = map2.get(Long.valueOf(j));
        kotlin.jvm.internal.k.b(set2);
        Set<UseCaseConfigFactory.CaptureType> set3 = set2;
        if (list.size() != set3.size()) {
            return false;
        }
        Iterator<? extends UseCaseConfigFactory.CaptureType> it = list.iterator();
        while (it.hasNext()) {
            if (!set3.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isStreamUseCaseSupported(CameraCharacteristicsCompat characteristicsCompat) {
        long[] jArr;
        kotlin.jvm.internal.k.e(characteristicsCompat, "characteristicsCompat");
        return (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) characteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isValidCamera2InteropOverride(java.util.List<? extends androidx.camera.core.impl.AttachedSurfaceInfo> r10, java.util.List<? extends androidx.camera.core.impl.UseCaseConfig<?>> r11, java.util.Set<java.lang.Long> r12) {
        /*
            r9 = this;
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
            boolean r1 = r10.hasNext()
            r2 = 0
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L47
            java.lang.Object r10 = r10.next()
            androidx.camera.core.impl.AttachedSurfaceInfo r10 = (androidx.camera.core.impl.AttachedSurfaceInfo) r10
            androidx.camera.core.impl.Config r1 = r10.getImplementationOptions()
            kotlin.jvm.internal.k.b(r1)
            androidx.camera.core.impl.Config$Option<java.lang.Long> r6 = androidx.camera.camera2.impl.Camera2ImplConfig.STREAM_USE_CASE_OPTION
            boolean r1 = r1.containsOption(r6)
            if (r1 != 0) goto L2b
        L28:
            r1 = r4
            r10 = r5
            goto L49
        L2b:
            androidx.camera.core.impl.Config r10 = r10.getImplementationOptions()
            kotlin.jvm.internal.k.b(r10)
            java.lang.Object r10 = r10.retrieveOption(r6)
            kotlin.jvm.internal.k.b(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            long r6 = r10.longValue()
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 != 0) goto L44
            goto L28
        L44:
            r10 = r4
            r1 = r5
            goto L49
        L47:
            r10 = r5
            r1 = r10
        L49:
            java.util.Iterator r11 = r11.iterator()
        L4d:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L8d
            java.lang.Object r6 = r11.next()
            androidx.camera.core.impl.UseCaseConfig r6 = (androidx.camera.core.impl.UseCaseConfig) r6
            androidx.camera.core.impl.Config$Option<java.lang.Long> r7 = androidx.camera.camera2.impl.Camera2ImplConfig.STREAM_USE_CASE_OPTION
            boolean r8 = r6.containsOption(r7)
            if (r8 != 0) goto L68
            if (r10 == 0) goto L66
            r9.throwInvalidCamera2InteropOverrideException()
        L66:
            r1 = r4
            goto L4d
        L68:
            java.lang.Object r6 = r6.retrieveOption(r7)
            kotlin.jvm.internal.k.b(r6)
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 != 0) goto L7f
            if (r10 == 0) goto L66
            r9.throwInvalidCamera2InteropOverrideException()
            goto L66
        L7f:
            if (r1 == 0) goto L84
            r9.throwInvalidCamera2InteropOverrideException()
        L84:
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            r0.add(r10)
            r10 = r4
            goto L4d
        L8d:
            if (r1 != 0) goto L96
            boolean r10 = r9.areStreamUseCasesAvailable(r12, r0)
            if (r10 == 0) goto L96
            return r4
        L96:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.StreamUseCaseUtil.isValidCamera2InteropOverride(java.util.List, java.util.List, java.util.Set):boolean");
    }

    private final boolean isZslUseCase(Config config, UseCaseConfigFactory.CaptureType captureType) {
        Object objRetrieveOption = config.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE);
        kotlin.jvm.internal.k.b(objRetrieveOption);
        if (((Boolean) objRetrieveOption).booleanValue()) {
            return false;
        }
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (!config.containsOption(option)) {
            return false;
        }
        Object objRetrieveOption2 = config.retrieveOption(option);
        kotlin.jvm.internal.k.b(objRetrieveOption2);
        return TemplateTypeUtil.getSessionConfigTemplateType(captureType, ((Number) objRetrieveOption2).intValue()) == 5;
    }

    public static final boolean populateStreamUseCaseStreamSpecOptionWithInteropOverride(CameraCharacteristicsCompat characteristicsCompat, List<AttachedSurfaceInfo> attachedSurfaces, Map<UseCaseConfig<?>, StreamSpec> suggestedStreamSpecMap, Map<AttachedSurfaceInfo, StreamSpec> attachedSurfaceStreamSpecMap) {
        kotlin.jvm.internal.k.e(characteristicsCompat, "characteristicsCompat");
        kotlin.jvm.internal.k.e(attachedSurfaces, "attachedSurfaces");
        kotlin.jvm.internal.k.e(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        kotlin.jvm.internal.k.e(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 33) {
            ArrayList arrayList = new ArrayList(suggestedStreamSpecMap.keySet());
            Iterator<AttachedSurfaceInfo> it = attachedSurfaces.iterator();
            while (it.hasNext()) {
                Preconditions.checkNotNull(it.next().getImplementationOptions());
            }
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                Preconditions.checkNotNull(((StreamSpec) Preconditions.checkNotNull(suggestedStreamSpecMap.get((UseCaseConfig) obj))).getImplementationOptions());
            }
            long[] jArr = (long[]) characteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
            if (jArr != null && jArr.length != 0) {
                HashSet hashSet = new HashSet();
                for (long j : jArr) {
                    hashSet.add(Long.valueOf(j));
                }
                if (INSTANCE.isValidCamera2InteropOverride(attachedSurfaces, arrayList, hashSet)) {
                    for (AttachedSurfaceInfo attachedSurfaceInfo : attachedSurfaces) {
                        Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
                        StreamUseCaseUtil streamUseCaseUtil = INSTANCE;
                        kotlin.jvm.internal.k.b(implementationOptions);
                        Config updatedImplementationOptionsWithUseCaseStreamSpecOption = streamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions, (Long) implementationOptions.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION));
                        if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                            attachedSurfaceStreamSpecMap.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                        }
                    }
                    int size2 = arrayList.size();
                    while (i2 < size2) {
                        Object obj2 = arrayList.get(i2);
                        i2++;
                        UseCaseConfig<?> useCaseConfig = (UseCaseConfig) obj2;
                        StreamSpec streamSpec = suggestedStreamSpecMap.get(useCaseConfig);
                        kotlin.jvm.internal.k.b(streamSpec);
                        Config implementationOptions2 = streamSpec.getImplementationOptions();
                        StreamUseCaseUtil streamUseCaseUtil2 = INSTANCE;
                        kotlin.jvm.internal.k.b(implementationOptions2);
                        Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = streamUseCaseUtil2.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, (Long) implementationOptions2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION));
                        if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                            suggestedStreamSpecMap.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static final void populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(Map<UseCaseConfig<?>, StreamSpec> suggestedStreamSpecMap, Map<AttachedSurfaceInfo, StreamSpec> attachedSurfaceStreamSpecMap, Map<Integer, ? extends AttachedSurfaceInfo> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends UseCaseConfig<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        kotlin.jvm.internal.k.e(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        kotlin.jvm.internal.k.e(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        kotlin.jvm.internal.k.e(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        kotlin.jvm.internal.k.e(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        kotlin.jvm.internal.k.e(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i2 = 0; i2 < size; i2++) {
            long value = surfaceConfigsWithStreamUseCase.get(i2).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i2))) {
                AttachedSurfaceInfo attachedSurfaceInfo = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i2));
                kotlin.jvm.internal.k.b(attachedSurfaceInfo);
                Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
                StreamUseCaseUtil streamUseCaseUtil = INSTANCE;
                kotlin.jvm.internal.k.b(implementationOptions);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption = streamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions, Long.valueOf(value));
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                    attachedSurfaceStreamSpecMap.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                }
            } else {
                if (!surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i2))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                UseCaseConfig<?> useCaseConfig = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i2));
                kotlin.jvm.internal.k.b(useCaseConfig);
                UseCaseConfig<?> useCaseConfig2 = useCaseConfig;
                StreamSpec streamSpec = suggestedStreamSpecMap.get(useCaseConfig2);
                kotlin.jvm.internal.k.b(streamSpec);
                Config implementationOptions2 = streamSpec.getImplementationOptions();
                StreamUseCaseUtil streamUseCaseUtil2 = INSTANCE;
                kotlin.jvm.internal.k.b(implementationOptions2);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = streamUseCaseUtil2.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, Long.valueOf(value));
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                    StreamSpec streamSpecBuild = streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build();
                    kotlin.jvm.internal.k.d(streamSpecBuild, "build(...)");
                    suggestedStreamSpecMap.put(useCaseConfig2, streamSpecBuild);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void populateSurfaceToStreamUseCaseMapping(Collection<SessionConfig> sessionConfigs, Collection<? extends UseCaseConfig<?>> useCaseConfigs, Map<DeferrableSurface, Long> streamUseCaseMap) {
        kotlin.jvm.internal.k.e(sessionConfigs, "sessionConfigs");
        kotlin.jvm.internal.k.e(useCaseConfigs, "useCaseConfigs");
        kotlin.jvm.internal.k.e(streamUseCaseMap, "streamUseCaseMap");
        ArrayList arrayList = new ArrayList(useCaseConfigs);
        Iterator<SessionConfig> it = sessionConfigs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SessionConfig next = it.next();
            Config implementationOptions = next.getImplementationOptions();
            Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
            if (implementationOptions.containsOption(option) && next.getSurfaces().size() != 1) {
                Logger.e(TAG, String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Arrays.copyOf(new Object[]{Integer.valueOf(next.getSurfaces().size())}, 1)));
                return;
            }
            if (next.getImplementationOptions().containsOption(option)) {
                int i2 = 0;
                for (SessionConfig sessionConfig : sessionConfigs) {
                    if (((UseCaseConfig) arrayList.get(i2)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        kotlin.jvm.internal.k.d(sessionConfig.getSurfaces(), "getSurfaces(...)");
                        Preconditions.checkState(!r3.isEmpty(), "MeteringRepeating should contain a surface");
                        streamUseCaseMap.put(sessionConfig.getSurfaces().get(0), 1L);
                    } else {
                        Config implementationOptions2 = sessionConfig.getImplementationOptions();
                        Config.Option<Long> option2 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
                        if (implementationOptions2.containsOption(option2)) {
                            List<DeferrableSurface> surfaces = sessionConfig.getSurfaces();
                            kotlin.jvm.internal.k.d(surfaces, "getSurfaces(...)");
                            if (!surfaces.isEmpty()) {
                                DeferrableSurface deferrableSurface = sessionConfig.getSurfaces().get(0);
                                Object objRetrieveOption = sessionConfig.getImplementationOptions().retrieveOption(option2);
                                kotlin.jvm.internal.k.b(objRetrieveOption);
                                streamUseCaseMap.put(deferrableSurface, objRetrieveOption);
                            }
                        }
                    }
                    i2++;
                }
            }
        }
        Logger.d(TAG, "populateSurfaceToStreamUseCaseMapping() - streamUseCaseMap = " + streamUseCaseMap);
    }

    public static final boolean shouldUseStreamUseCase(SupportedSurfaceCombination.FeatureSettings featureSettings) {
        kotlin.jvm.internal.k.e(featureSettings, "featureSettings");
        return featureSettings.getCameraMode() == 0 && featureSettings.getRequiredMaxBitDepth() == 8 && !featureSettings.isHighSpeedOn();
    }

    private final void throwInvalidCamera2InteropOverrideException() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
