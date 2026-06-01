package androidx.camera.core.internal;

import android.graphics.Rect;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceStreamSpecQueryResult;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.streamsharing.StreamSharing;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamSpecsCalculatorImpl implements StreamSpecsCalculator {
    private CameraDeviceSurfaceManager cameraDeviceSurfaceManager;
    private final UseCaseConfigFactory useCaseConfigFactory;

    public StreamSpecsCalculatorImpl(UseCaseConfigFactory useCaseConfigFactory, CameraDeviceSurfaceManager cameraDeviceSurfaceManager) {
        k.e(useCaseConfigFactory, "useCaseConfigFactory");
        this.useCaseConfigFactory = useCaseConfigFactory;
        this.cameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
    }

    private final Pair<Map<UseCase, StreamSpec>, Map<AttachedSurfaceInfo, UseCase>> calculateSuggestedStreamSpecsForAttachedUseCases(int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> list) {
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        k.d(cameraId, "getCameraId(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (UseCase useCase : list) {
            StreamSpec attachedStreamSpec = useCase.getAttachedStreamSpec();
            if (attachedStreamSpec == null) {
                throw new IllegalArgumentException("Attached stream spec cannot be null for already attached use cases.");
            }
            CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.cameraDeviceSurfaceManager;
            if (cameraDeviceSurfaceManager == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int imageFormat = useCase.getImageFormat();
            Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
            if (attachedSurfaceResolution == null) {
                throw new IllegalArgumentException("Attached surface resolution cannot be null for already attached use cases.");
            }
            SurfaceConfig surfaceConfigTransformSurfaceConfig = cameraDeviceSurfaceManager.transformSurfaceConfig(i2, cameraId, imageFormat, attachedSurfaceResolution, useCase.getCurrentConfig().getStreamUseCase());
            k.d(surfaceConfigTransformSurfaceConfig, "transformSurfaceConfig(...)");
            int imageFormat2 = useCase.getImageFormat();
            Size attachedSurfaceResolution2 = useCase.getAttachedSurfaceResolution();
            k.b(attachedSurfaceResolution2);
            DynamicRange dynamicRange = attachedStreamSpec.getDynamicRange();
            List<UseCaseConfigFactory.CaptureType> captureTypes = StreamSharing.getCaptureTypes(useCase);
            Config implementationOptions = attachedStreamSpec.getImplementationOptions();
            int sessionType = useCase.getCurrentConfig().getSessionType(0);
            Range<Integer> targetFrameRate = useCase.getCurrentConfig().getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
            if (targetFrameRate == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            AttachedSurfaceInfo attachedSurfaceInfoCreate = AttachedSurfaceInfo.create(surfaceConfigTransformSurfaceConfig, imageFormat2, attachedSurfaceResolution2, dynamicRange, captureTypes, implementationOptions, sessionType, targetFrameRate, useCase.getCurrentConfig().isStrictFrameRateRequired());
            k.d(attachedSurfaceInfoCreate, "create(...)");
            arrayList.add(attachedSurfaceInfoCreate);
            linkedHashMap2.put(attachedSurfaceInfoCreate, useCase);
            linkedHashMap.put(useCase, attachedStreamSpec);
        }
        return new Pair<>(linkedHashMap, linkedHashMap2);
    }

    private final StreamSpecQueryResult calculateSuggestedStreamSpecsForNewUseCases(int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> list, Map<AttachedSurfaceInfo, ? extends UseCase> map, Map<UseCase, ? extends CameraUseCaseAdapter.ConfigPair> map2, boolean z2, boolean z7) {
        int iComponent3;
        Rect sensorRect;
        String cameraId = cameraInfoInternal.getCameraId();
        k.d(cameraId, "getCameraId(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list.isEmpty()) {
            iComponent3 = Integer.MAX_VALUE;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            try {
                sensorRect = cameraInfoInternal.getSensorRect();
            } catch (NullPointerException unused) {
                sensorRect = null;
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal, sensorRect != null ? TransformUtils.rectToSize(sensorRect) : null);
            while (true) {
                boolean z8 = false;
                for (UseCase useCase : list) {
                    CameraUseCaseAdapter.ConfigPair configPair = map2.get(useCase);
                    if (configPair == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    CameraUseCaseAdapter.ConfigPair configPair2 = configPair;
                    UseCaseConfig<?> useCaseConfigMergeConfigs = useCase.mergeConfigs(cameraInfoInternal, configPair2.mExtendedConfig, configPair2.mCameraConfig);
                    k.d(useCaseConfigMergeConfigs, "mergeConfigs(...)");
                    linkedHashMap2.put(useCaseConfigMergeConfigs, useCase);
                    List<Size> sortedSupportedOutputSizes = supportedOutputSizesSorter.getSortedSupportedOutputSizes(useCaseConfigMergeConfigs);
                    k.d(sortedSupportedOutputSizes, "getSortedSupportedOutputSizes(...)");
                    linkedHashMap3.put(useCaseConfigMergeConfigs, sortedSupportedOutputSizes);
                    if ((useCase instanceof Preview) || (useCase instanceof StreamSharing)) {
                        if (useCaseConfigMergeConfigs.getPreviewStabilizationMode() == 2) {
                            z8 = true;
                        }
                    }
                }
                CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.cameraDeviceSurfaceManager;
                if (cameraDeviceSurfaceManager == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                SurfaceStreamSpecQueryResult suggestedStreamSpecs = cameraDeviceSurfaceManager.getSuggestedStreamSpecs(i2, cameraId, new ArrayList(map.keySet()), linkedHashMap3, z8, CameraUseCaseAdapter.hasVideoCapture(list), z2, z7);
                k.d(suggestedStreamSpecs, "getSuggestedStreamSpecs(...)");
                Map<UseCaseConfig<?>, StreamSpec> mapComponent1 = suggestedStreamSpecs.component1();
                Map<AttachedSurfaceInfo, StreamSpec> mapComponent2 = suggestedStreamSpecs.component2();
                iComponent3 = suggestedStreamSpecs.component3();
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    Object value = entry.getValue();
                    StreamSpec streamSpec = mapComponent1.get(entry.getKey());
                    if (streamSpec == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    linkedHashMap.put(value, streamSpec);
                }
                for (Map.Entry<AttachedSurfaceInfo, StreamSpec> entry2 : mapComponent2.entrySet()) {
                    if (map.containsKey(entry2.getKey())) {
                        UseCase useCase2 = map.get(entry2.getKey());
                        if (useCase2 == null) {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        linkedHashMap.put(useCase2, entry2.getValue());
                    }
                }
            }
        }
        return new StreamSpecQueryResult(linkedHashMap, iComponent3);
    }

    @Override // androidx.camera.core.internal.StreamSpecsCalculator
    public StreamSpecQueryResult calculateSuggestedStreamSpecs(int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, List<? extends UseCase> attachedUseCases, CameraConfig cameraConfig, int i8, Range<Integer> targetFrameRate, boolean z2, boolean z7) {
        k.e(cameraInfoInternal, "cameraInfoInternal");
        k.e(newUseCases, "newUseCases");
        k.e(attachedUseCases, "attachedUseCases");
        k.e(cameraConfig, "cameraConfig");
        k.e(targetFrameRate, "targetFrameRate");
        Pair<Map<UseCase, StreamSpec>, Map<AttachedSurfaceInfo, UseCase>> pairCalculateSuggestedStreamSpecsForAttachedUseCases = calculateSuggestedStreamSpecsForAttachedUseCases(i2, cameraInfoInternal, attachedUseCases);
        Object second = pairCalculateSuggestedStreamSpecsForAttachedUseCases.second;
        k.d(second, "second");
        Map<UseCase, CameraUseCaseAdapter.ConfigPair> configs = CameraUseCaseAdapter.getConfigs(newUseCases, cameraConfig.getUseCaseConfigFactory(), this.useCaseConfigFactory, i8, targetFrameRate);
        k.d(configs, "getConfigs(...)");
        StreamSpecQueryResult streamSpecQueryResultCalculateSuggestedStreamSpecsForNewUseCases = calculateSuggestedStreamSpecsForNewUseCases(i2, cameraInfoInternal, newUseCases, (Map) second, configs, z2, z7);
        Object first = pairCalculateSuggestedStreamSpecsForAttachedUseCases.first;
        k.d(first, "first");
        return new StreamSpecQueryResult(x.i0((Map) first, streamSpecQueryResultCalculateSuggestedStreamSpecsForNewUseCases.getStreamSpecs()), streamSpecQueryResultCalculateSuggestedStreamSpecsForNewUseCases.getMaxSupportedFrameRate());
    }

    @Override // androidx.camera.core.internal.StreamSpecsCalculator
    public void setCameraDeviceSurfaceManager(CameraDeviceSurfaceManager cameraDeviceSurfaceManager) {
        k.e(cameraDeviceSurfaceManager, "cameraDeviceSurfaceManager");
        this.cameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
    }

    public /* synthetic */ StreamSpecsCalculatorImpl(UseCaseConfigFactory useCaseConfigFactory, CameraDeviceSurfaceManager cameraDeviceSurfaceManager, int i2, kotlin.jvm.internal.f fVar) {
        this(useCaseConfigFactory, (i2 & 2) != 0 ? null : cameraDeviceSurfaceManager);
    }
}
