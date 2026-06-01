package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CompositionSettings;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.AdapterCameraInternal;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.workaround.StreamSharingForceEnabler;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";

    @GuardedBy("mLock")
    private final List<UseCase> mAppUseCases;

    @GuardedBy("mLock")
    private boolean mAttached;

    @GuardedBy("mLock")
    private final CameraConfig mCameraConfig;

    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;
    private final CameraIdentifier mCameraIdentifier;
    private final AdapterCameraInternal mCameraInternal;

    @GuardedBy("mLock")
    private final List<UseCase> mCameraUseCases;
    private final CompositionSettings mCompositionSettings;

    @GuardedBy("mLock")
    private List<CameraEffect> mEffects;

    @GuardedBy("mLock")
    private Range<Integer> mFrameRate;

    @GuardedBy("mLock")
    private Config mInteropConfig;
    private final Object mLock;

    @GuardedBy("mLock")
    private UseCase mPlaceholderForExtensions;
    private final AdapterCameraInternal mSecondaryCameraInternal;
    private final CompositionSettings mSecondaryCompositionSettings;

    @GuardedBy("mLock")
    private int mSessionType;

    @GuardedBy("mLock")
    private StreamSharing mStreamSharing;
    private final StreamSharingForceEnabler mStreamSharingForceEnabler;
    private final StreamSpecsCalculator mStreamSpecsCalculator;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @GuardedBy("mLock")
    private ViewPort mViewPort;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String str) {
            super(str);
        }

        public CameraException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    @VisibleForTesting
    public CameraUseCaseAdapter(CameraInternal cameraInternal, CameraCoordinator cameraCoordinator, StreamSpecsCalculator streamSpecsCalculator, UseCaseConfigFactory useCaseConfigFactory) {
        AdapterCameraInfo adapterCameraInfo = new AdapterCameraInfo(cameraInternal.getCameraInfoInternal(), CameraConfigs.defaultConfig());
        CompositionSettings compositionSettings = CompositionSettings.DEFAULT;
        this(cameraInternal, null, adapterCameraInfo, null, compositionSettings, compositionSettings, cameraCoordinator, streamSpecsCalculator, useCaseConfigFactory);
    }

    @GuardedBy("mLock")
    private void applyCalculatedUseCaseChanges(CalculatedUseCaseInfo calculatedUseCaseInfo) {
        updateViewPortAndSensorToBufferMatrix(calculatedUseCaseInfo.getPrimaryStreamSpecResult().getStreamSpecs(), calculatedUseCaseInfo.getCameraUseCases());
        updateEffects(this.mEffects, calculatedUseCaseInfo.getCameraUseCases(), calculatedUseCaseInfo.getAppUseCases());
        Iterator<UseCase> it = calculatedUseCaseInfo.getCameraUseCasesToDetach().iterator();
        while (it.hasNext()) {
            it.next().unbindFromCamera(this.mCameraInternal);
        }
        this.mCameraInternal.detachUseCases(calculatedUseCaseInfo.getCameraUseCasesToDetach());
        if (this.mSecondaryCameraInternal != null) {
            for (UseCase useCase : calculatedUseCaseInfo.getCameraUseCasesToDetach()) {
                AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
                Objects.requireNonNull(adapterCameraInternal);
                useCase.unbindFromCamera(adapterCameraInternal);
            }
            AdapterCameraInternal adapterCameraInternal2 = this.mSecondaryCameraInternal;
            Objects.requireNonNull(adapterCameraInternal2);
            adapterCameraInternal2.detachUseCases(calculatedUseCaseInfo.getCameraUseCasesToDetach());
        }
        if (calculatedUseCaseInfo.getCameraUseCasesToDetach().isEmpty()) {
            for (UseCase useCase2 : calculatedUseCaseInfo.getCameraUseCasesToKeep()) {
                Map<UseCase, StreamSpec> streamSpecs = calculatedUseCaseInfo.getPrimaryStreamSpecResult().getStreamSpecs();
                if (streamSpecs.containsKey(useCase2)) {
                    StreamSpec streamSpec = streamSpecs.get(useCase2);
                    Objects.requireNonNull(streamSpec);
                    Config implementationOptions = streamSpec.getImplementationOptions();
                    if (implementationOptions != null && hasImplementationOptionChanged(streamSpec, useCase2.getSessionConfig())) {
                        useCase2.updateSuggestedStreamSpecImplementationOptions(implementationOptions);
                        if (this.mAttached) {
                            this.mCameraInternal.onUseCaseUpdated(useCase2);
                            AdapterCameraInternal adapterCameraInternal3 = this.mSecondaryCameraInternal;
                            if (adapterCameraInternal3 != null) {
                                Objects.requireNonNull(adapterCameraInternal3);
                                adapterCameraInternal3.onUseCaseUpdated(useCase2);
                            }
                        }
                    }
                }
            }
        }
        for (UseCase useCase3 : calculatedUseCaseInfo.getCameraUseCasesToAttach()) {
            ConfigPair configPair = calculatedUseCaseInfo.getUseCaseConfigs().get(useCase3);
            Objects.requireNonNull(configPair);
            AdapterCameraInternal adapterCameraInternal4 = this.mSecondaryCameraInternal;
            if (adapterCameraInternal4 != null) {
                AdapterCameraInternal adapterCameraInternal5 = this.mCameraInternal;
                Objects.requireNonNull(adapterCameraInternal4);
                useCase3.bindToCamera(adapterCameraInternal5, adapterCameraInternal4, configPair.mExtendedConfig, configPair.mCameraConfig);
                useCase3.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(calculatedUseCaseInfo.getPrimaryStreamSpecResult().getStreamSpecs().get(useCase3)), ((StreamSpecQueryResult) Preconditions.checkNotNull(calculatedUseCaseInfo.getSecondaryStreamSpecResult())).getStreamSpecs().get(useCase3));
            } else {
                useCase3.bindToCamera(this.mCameraInternal, null, configPair.mExtendedConfig, configPair.mCameraConfig);
                useCase3.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(calculatedUseCaseInfo.getPrimaryStreamSpecResult().getStreamSpecs().get(useCase3)), null);
            }
        }
        if (this.mAttached) {
            this.mCameraInternal.attachUseCases(calculatedUseCaseInfo.getCameraUseCasesToAttach());
            AdapterCameraInternal adapterCameraInternal6 = this.mSecondaryCameraInternal;
            if (adapterCameraInternal6 != null) {
                Objects.requireNonNull(adapterCameraInternal6);
                adapterCameraInternal6.attachUseCases(calculatedUseCaseInfo.getCameraUseCasesToAttach());
            }
        }
        Iterator<UseCase> it2 = calculatedUseCaseInfo.getCameraUseCasesToAttach().iterator();
        while (it2.hasNext()) {
            it2.next().notifyState();
        }
        this.mAppUseCases.clear();
        this.mAppUseCases.addAll(calculatedUseCaseInfo.getAppUseCases());
        this.mCameraUseCases.clear();
        this.mCameraUseCases.addAll(calculatedUseCaseInfo.getCameraUseCases());
        this.mPlaceholderForExtensions = calculatedUseCaseInfo.getPlaceholderForExtensions();
        this.mStreamSharing = calculatedUseCaseInfo.getStreamSharing();
    }

    private void applyCameraConfig() {
        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
        AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
        if (adapterCameraInternal != null) {
            adapterCameraInternal.setExtendedConfig(this.mCameraConfig);
        }
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    private static Map<UseCase, Set<GroupableFeature>> applyFeatureGroup(Collection<UseCase> collection, ResolvedFeatureGroup resolvedFeatureGroup) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, useCase.getFeatureGroup());
            useCase.setFeatureGroup(resolvedFeatureGroup != null ? resolvedFeatureGroup.getFeatures() : null);
        }
        return map;
    }

    private static UseCaseConfig<?> attachUseCaseSharedConfigs(UseCase useCase, UseCaseConfig<?> useCaseConfig, int i2, Range<Integer> range) {
        MutableOptionsBundle mutableOptionsBundleFrom = useCaseConfig != null ? MutableOptionsBundle.from((Config) useCaseConfig) : MutableOptionsBundle.create();
        mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_SESSION_TYPE, Integer.valueOf(i2));
        if (!StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED.equals(range)) {
            mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, Config.OptionPriority.HIGH_PRIORITY_REQUIRED, range);
            mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_IS_STRICT_FRAME_RATE_REQUIRED, Boolean.TRUE);
        }
        return useCase.getUseCaseConfigBuilder(mutableOptionsBundleFrom).getUseCaseConfig();
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    @GuardedBy("mLock")
    private CalculatedUseCaseInfo calculateAndValidateUseCases(Collection<UseCase> collection, boolean z2, boolean z7) throws IllegalArgumentException {
        StreamSpecQueryResult streamSpecQueryResultCalculateSuggestedStreamSpecs;
        boolean z8 = z7;
        checkUnsupportedFeatureCombinationAndThrow(collection);
        if (!z2 && shouldForceEnableStreamSharing(collection)) {
            return calculateAndValidateUseCases(collection, true, z8);
        }
        StreamSharing streamSharingCreateOrReuseStreamSharing = createOrReuseStreamSharing(collection, z2);
        UseCase useCaseCalculatePlaceholderForExtensions = calculatePlaceholderForExtensions(collection, streamSharingCreateOrReuseStreamSharing);
        Collection<UseCase> collectionCalculateCameraUseCases = calculateCameraUseCases(collection, useCaseCalculatePlaceholderForExtensions, streamSharingCreateOrReuseStreamSharing);
        ArrayList arrayList = new ArrayList(collectionCalculateCameraUseCases);
        arrayList.removeAll(this.mCameraUseCases);
        ArrayList arrayList2 = new ArrayList(collectionCalculateCameraUseCases);
        arrayList2.retainAll(this.mCameraUseCases);
        ArrayList arrayList3 = new ArrayList(this.mCameraUseCases);
        arrayList3.removeAll(collectionCalculateCameraUseCases);
        Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory, this.mSessionType, this.mFrameRate);
        boolean zIsFeatureComboInvocation = isFeatureComboInvocation(arrayList, arrayList2);
        try {
            StreamSpecQueryResult streamSpecQueryResultCalculateSuggestedStreamSpecs2 = this.mStreamSpecsCalculator.calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), arrayList, arrayList2, this.mCameraConfig, this.mSessionType, this.mFrameRate, zIsFeatureComboInvocation, z8);
            try {
                if (this.mSecondaryCameraInternal != null) {
                    StreamSpecsCalculator streamSpecsCalculator = this.mStreamSpecsCalculator;
                    int cameraMode = getCameraMode();
                    AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
                    Objects.requireNonNull(adapterCameraInternal);
                    z8 = z7;
                    streamSpecQueryResultCalculateSuggestedStreamSpecs = streamSpecsCalculator.calculateSuggestedStreamSpecs(cameraMode, adapterCameraInternal.getCameraInfoInternal(), arrayList, arrayList2, this.mCameraConfig, this.mSessionType, this.mFrameRate, zIsFeatureComboInvocation, z8);
                } else {
                    streamSpecQueryResultCalculateSuggestedStreamSpecs = null;
                }
                return new CalculatedUseCaseInfo(collection, collectionCalculateCameraUseCases, arrayList, arrayList2, arrayList3, streamSharingCreateOrReuseStreamSharing, useCaseCalculatePlaceholderForExtensions, configs, streamSpecQueryResultCalculateSuggestedStreamSpecs2, streamSpecQueryResultCalculateSuggestedStreamSpecs);
            } catch (IllegalArgumentException e) {
                e = e;
                z8 = z7;
                if (z2 || !isStreamSharingAllowed()) {
                    throw e;
                }
                return calculateAndValidateUseCases(collection, true, z8);
            }
        } catch (IllegalArgumentException e4) {
            e = e4;
        }
    }

    public static Collection<UseCase> calculateCameraUseCases(Collection<UseCase> collection, UseCase useCase, StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.camera.core.UseCase calculatePlaceholderForExtensions(java.util.Collection<androidx.camera.core.UseCase> r3, androidx.camera.core.streamsharing.StreamSharing r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L15
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15
            if (r4 == 0) goto L17
            r1.add(r4)     // Catch: java.lang.Throwable -> L15
            java.util.Set r3 = r4.getChildren()     // Catch: java.lang.Throwable -> L15
            r1.removeAll(r3)     // Catch: java.lang.Throwable -> L15
            goto L17
        L15:
            r3 = move-exception
            goto L4c
        L17:
            boolean r3 = r2.isCoexistingPreviewImageCaptureRequired()     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            boolean r3 = isExtraPreviewRequired(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L33
            androidx.camera.core.UseCase r3 = r2.mPlaceholderForExtensions     // Catch: java.lang.Throwable -> L15
            boolean r3 = isPreview(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L2e
            androidx.camera.core.UseCase r3 = r2.mPlaceholderForExtensions     // Catch: java.lang.Throwable -> L15
            goto L4a
        L2e:
            androidx.camera.core.Preview r3 = r2.createExtraPreview()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L33:
            boolean r3 = isExtraImageCaptureRequired(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L49
            androidx.camera.core.UseCase r3 = r2.mPlaceholderForExtensions     // Catch: java.lang.Throwable -> L15
            boolean r3 = isImageCapture(r3)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L44
            androidx.camera.core.UseCase r3 = r2.mPlaceholderForExtensions     // Catch: java.lang.Throwable -> L15
            goto L4a
        L44:
            androidx.camera.core.ImageCapture r3 = r2.createExtraImageCapture()     // Catch: java.lang.Throwable -> L15
            goto L4a
        L49:
            r3 = 0
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r3
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.calculatePlaceholderForExtensions(java.util.Collection, androidx.camera.core.streamsharing.StreamSharing):androidx.camera.core.UseCase");
    }

    private static Matrix calculateSensorToBufferTransformMatrix(Rect rect, Size size) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private void checkUnsupportedFeatureCombinationAndThrow(Collection<UseCase> collection) throws IllegalArgumentException {
        if (hasExtension()) {
            if (hasNonSdrConfig(collection)) {
                throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
            }
            if (hasRawImageCapture(collection)) {
                throw new IllegalArgumentException("Extensions are not supported for use with Raw image capture.");
            }
        }
        synchronized (this.mLock) {
            try {
                if (!this.mEffects.isEmpty() && (hasUltraHdrImageCapture(collection) || hasRawImageCapture(collection))) {
                    throw new IllegalArgumentException("Ultra HDR image and Raw capture does not support for use with CameraEffect.");
                }
            } finally {
            }
        }
    }

    private static void clearFeatureGroup(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            it.next().setFeatureGroup(null);
        }
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview previewBuild = new Preview.Builder().setTargetName("Preview-Extra").build();
        previewBuild.setSurfaceProvider(new b());
        return previewBuild;
    }

    private StreamSharing createOrReuseStreamSharing(Collection<UseCase> collection, boolean z2) {
        synchronized (this.mLock) {
            try {
                Set<UseCase> streamSharingChildren = getStreamSharingChildren(collection, z2);
                if (streamSharingChildren.size() >= 2 || (hasExtension() && hasVideoCapture(streamSharingChildren))) {
                    StreamSharing streamSharing = this.mStreamSharing;
                    if (streamSharing == null || !streamSharing.getChildren().equals(streamSharingChildren)) {
                        if (!isStreamSharingChildrenCombinationValid(streamSharingChildren)) {
                            return null;
                        }
                        return new StreamSharing(this.mCameraInternal, this.mSecondaryCameraInternal, this.mCompositionSettings, this.mSecondaryCompositionSettings, streamSharingChildren, this.mUseCaseConfigFactory);
                    }
                    this.mStreamSharing.updateFeatureGroup(streamSharingChildren);
                    StreamSharing streamSharing2 = this.mStreamSharing;
                    Objects.requireNonNull(streamSharing2);
                    return streamSharing2;
                }
                return null;
            } finally {
            }
        }
    }

    private static UseCaseConfig<?> generateExtendedStreamSharingConfigFromPreview(UseCaseConfigFactory useCaseConfigFactory, StreamSharing streamSharing) {
        UseCaseConfig<?> defaultConfig = new Preview.Builder().build().getDefaultConfig(false, useCaseConfigFactory);
        if (defaultConfig == null) {
            return null;
        }
        MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) defaultConfig);
        mutableOptionsBundleFrom.removeOption(TargetConfig.OPTION_TARGET_CLASS);
        return streamSharing.getUseCaseConfigBuilder(mutableOptionsBundleFrom).getUseCaseConfig();
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            try {
                return this.mCameraCoordinator.getCameraOperatingMode() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2, int i2, Range<Integer> range) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, new ConfigPair(StreamSharing.isStreamSharing(useCase) ? generateExtendedStreamSharingConfigFromPreview(useCaseConfigFactory, (StreamSharing) useCase) : useCase.getDefaultConfig(false, useCaseConfigFactory), attachUseCaseSharedConfigs(useCase, useCase.getDefaultConfig(true, useCaseConfigFactory2), i2, range)));
        }
        return map;
    }

    private int getSharingTargets(boolean z2) {
        int targets;
        synchronized (this.mLock) {
            try {
                Iterator<CameraEffect> it = this.mEffects.iterator();
                CameraEffect cameraEffect = null;
                while (true) {
                    targets = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    CameraEffect next = it.next();
                    if (TargetUtils.getNumberOfTargets(next.getTargets()) > 1) {
                        Preconditions.checkState(cameraEffect == null, "Can only have one sharing effect.");
                        cameraEffect = next;
                    }
                }
                if (cameraEffect != null) {
                    targets = cameraEffect.getTargets();
                }
                if (z2) {
                    targets |= 3;
                }
            } finally {
            }
        }
        return targets;
    }

    private Set<UseCase> getStreamSharingChildren(Collection<UseCase> collection, boolean z2) {
        HashSet hashSet = new HashSet();
        int sharingTargets = getSharingTargets(z2);
        for (UseCase useCase : collection) {
            Preconditions.checkArgument(!StreamSharing.isStreamSharing(useCase), "Only support one level of sharing for now.");
            if (useCase.isEffectTargetsSupported(sharingTargets)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    private boolean hasExtension() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mCameraConfig.getSessionProcessor(null) != null;
        }
        return z2;
    }

    private static boolean hasImplementationOptionChanged(StreamSpec streamSpec, SessionConfig sessionConfig) {
        Config implementationOptions = streamSpec.getImplementationOptions();
        Config implementationOptions2 = sessionConfig.getImplementationOptions();
        Objects.requireNonNull(implementationOptions);
        if (implementationOptions.listOptions().size() != sessionConfig.getImplementationOptions().listOptions().size()) {
            return true;
        }
        for (Config.Option<?> option : implementationOptions.listOptions()) {
            if (!implementationOptions2.containsOption(option) || !Objects.equals(implementationOptions2.retrieveOption(option), implementationOptions.retrieveOption(option))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNonSdrConfig(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            if (isNotSdr(it.next().getCurrentConfig().getDynamicRange())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasRawImageCapture(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (isImageCapture(useCase)) {
                UseCaseConfig<?> currentConfig = useCase.getCurrentConfig();
                Config.Option<?> option = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
                if (currentConfig.containsOption(option) && ((Integer) Preconditions.checkNotNull((Integer) currentConfig.retrieveOption(option))).intValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasUltraHdrImageCapture(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (isImageCapture(useCase)) {
                UseCaseConfig<?> currentConfig = useCase.getCurrentConfig();
                Config.Option<?> option = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
                if (currentConfig.containsOption(option) && ((Integer) Preconditions.checkNotNull((Integer) currentConfig.retrieveOption(option))).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasVideoCapture(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            if (isVideoCapture(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    private static boolean isExtraImageCaptureRequired(Collection<UseCase> collection) {
        boolean z2 = false;
        boolean z7 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase) || StreamSharing.isStreamSharing(useCase)) {
                z2 = true;
            } else if (isImageCapture(useCase)) {
                z7 = true;
            }
        }
        return z2 && !z7;
    }

    private static boolean isExtraPreviewRequired(Collection<UseCase> collection) {
        boolean z2 = false;
        boolean z7 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase) || StreamSharing.isStreamSharing(useCase)) {
                z7 = true;
            } else if (isImageCapture(useCase)) {
                z2 = true;
            }
        }
        return z2 && !z7;
    }

    @SafeVarargs
    private static boolean isFeatureComboInvocation(List<UseCase>... listArr) {
        boolean z2 = false;
        for (List<UseCase> list : listArr) {
            Iterator<UseCase> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getFeatureGroup() != null) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                return z2;
            }
        }
        return z2;
    }

    private static boolean isImageCapture(UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isNotSdr(DynamicRange dynamicRange) {
        return (dynamicRange.getBitDepth() == 10) || (dynamicRange.getEncoding() != 1 && dynamicRange.getEncoding() != 0);
    }

    private static boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    private boolean isStreamSharingAllowed() {
        return (hasExtension() || this.mCameraCoordinator.getCameraOperatingMode() == 2 || this.mSessionType == 1) ? false : true;
    }

    public static boolean isStreamSharingChildrenCombinationValid(Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase useCase : collection) {
            for (int i2 = 0; i2 < 3; i2++) {
                int i8 = iArr[i2];
                if (useCase.isEffectTargetsSupported(i8)) {
                    if (hashSet.contains(Integer.valueOf(i8))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i8));
                }
            }
        }
        return true;
    }

    public static boolean isVideoCapture(UseCase useCase) {
        if (useCase != null) {
            if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                return useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            }
            Log.e(TAG, useCase + " UseCase does not have capture type.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$0(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new a(0, surface, surfaceTexture));
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    private static void restoreFeatureGroup(Map<UseCase, Set<GroupableFeature>> map) {
        for (Map.Entry<UseCase, Set<GroupableFeature>> entry : map.entrySet()) {
            entry.getKey().setFeatureGroup(entry.getValue());
        }
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            try {
                if (this.mInteropConfig != null) {
                    this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static List<CameraEffect> setEffectsOnUseCases(List<CameraEffect> list, Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(list);
        for (UseCase useCase : collection) {
            useCase.setEffect(null);
            for (CameraEffect cameraEffect : list) {
                if (useCase.isEffectTargetsSupported(cameraEffect.getTargets())) {
                    Preconditions.checkState(useCase.getEffect() == null, useCase + " already has effect" + useCase.getEffect());
                    useCase.setEffect(cameraEffect);
                    arrayList.remove(cameraEffect);
                }
            }
        }
        return arrayList;
    }

    private boolean shouldForceEnableStreamSharing(Collection<UseCase> collection) {
        if (hasExtension() && hasVideoCapture(collection)) {
            return true;
        }
        return this.mStreamSharingForceEnabler.shouldForceEnableStreamSharing(this.mCameraInternal.getCameraInfoInternal().getCameraId(), collection);
    }

    @VisibleForTesting
    public static void updateEffects(List<CameraEffect> list, Collection<UseCase> collection, Collection<UseCase> collection2) {
        List<CameraEffect> effectsOnUseCases = setEffectsOnUseCases(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<CameraEffect> effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList);
        if (effectsOnUseCases2.isEmpty()) {
            return;
        }
        Logger.w(TAG, "Unused effects: " + effectsOnUseCases2);
    }

    private void updateViewPortAndSensorToBufferMatrix(Map<UseCase, StreamSpec> map, Collection<UseCase> collection) {
        Map<UseCase, StreamSpec> map2;
        synchronized (this.mLock) {
            try {
                if (this.mViewPort == null || collection.isEmpty()) {
                    map2 = map;
                } else {
                    map2 = map;
                    Map<UseCase, Rect> mapCalculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraInfoInternal().getSensorRect(), this.mCameraInternal.getCameraInfoInternal().getLensFacing() == 0, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map2);
                    for (UseCase useCase : collection) {
                        useCase.setViewPortCropRect((Rect) Preconditions.checkNotNull(mapCalculateViewPortRects.get(useCase)));
                    }
                }
                for (UseCase useCase2 : collection) {
                    useCase2.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraInfoInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(map2.get(useCase2))).getResolution()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addUseCases(Collection<UseCase> collection) throws CameraException {
        addUseCases(collection, null);
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            try {
                if (!this.mAttached) {
                    if (!this.mCameraUseCases.isEmpty()) {
                        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
                        AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
                        if (adapterCameraInternal != null) {
                            adapterCameraInternal.setExtendedConfig(this.mCameraConfig);
                        }
                    }
                    this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                    AdapterCameraInternal adapterCameraInternal2 = this.mSecondaryCameraInternal;
                    if (adapterCameraInternal2 != null) {
                        adapterCameraInternal2.attachUseCases(this.mCameraUseCases);
                    }
                    restoreInteropConfig();
                    Iterator<UseCase> it = this.mCameraUseCases.iterator();
                    while (it.hasNext()) {
                        it.next().notifyState();
                    }
                    this.mAttached = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            try {
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
                    if (adapterCameraInternal != null) {
                        adapterCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    }
                    cacheInteropConfig();
                    this.mAttached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CameraIdentifier getAdapterIdentifier() {
        return this.mCameraIdentifier;
    }

    @Override // androidx.camera.core.Camera
    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControl();
    }

    @Override // androidx.camera.core.Camera
    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfo();
    }

    @VisibleForTesting
    public Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    public List<CameraEffect> getEffects() {
        List<CameraEffect> list;
        synchronized (this.mLock) {
            list = this.mEffects;
        }
        return list;
    }

    @Override // androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    public Range<Integer> getFrameRate() {
        Range<Integer> range;
        synchronized (this.mLock) {
            range = this.mFrameRate;
        }
        return range;
    }

    public CameraInfo getSecondaryCameraInfo() {
        AdapterCameraInternal adapterCameraInternal = this.mSecondaryCameraInternal;
        if (adapterCameraInternal != null) {
            return adapterCameraInternal.getCameraInfo();
        }
        return null;
    }

    public int getSessionType() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mSessionType;
        }
        return i2;
    }

    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public ViewPort getViewPort() {
        ViewPort viewPort;
        synchronized (this.mLock) {
            viewPort = this.mViewPort;
        }
        return viewPort;
    }

    public boolean isEquivalent(CameraUseCaseAdapter cameraUseCaseAdapter) {
        return getAdapterIdentifier().equals(cameraUseCaseAdapter.getAdapterIdentifier());
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return androidx.camera.core.c.b(this, useCaseArr);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return androidx.camera.core.c.c(this, useCaseArr);
    }

    public void removeAllUseCases() {
        synchronized (this.mLock) {
            removeUseCases(this.mAppUseCases);
        }
    }

    public void removeUseCases(Collection<UseCase> collection) {
        synchronized (this.mLock) {
            clearFeatureGroup(collection);
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(collection);
            applyCalculatedUseCaseChanges(calculateAndValidateUseCases(linkedHashSet, this.mSecondaryCameraInternal != null, false));
        }
    }

    public void setActiveResumingMode(boolean z2) {
        this.mCameraInternal.setActiveResumingMode(z2);
    }

    public void setEffects(List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    public void setFrameRate(Range<Integer> range) {
        synchronized (this.mLock) {
            this.mFrameRate = range;
        }
    }

    public void setSessionType(int i2) {
        synchronized (this.mLock) {
            this.mSessionType = i2;
        }
    }

    public void setViewPort(ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    public CalculatedUseCaseInfo simulateAddUseCases(Collection<UseCase> collection, ResolvedFeatureGroup resolvedFeatureGroup, boolean z2) throws CameraException {
        CalculatedUseCaseInfo calculatedUseCaseInfoCalculateAndValidateUseCases;
        Logger.d(TAG, "simulateAddUseCases: appUseCasesToAdd = " + collection + ", featureGroup = " + resolvedFeatureGroup);
        synchronized (this.mLock) {
            applyCameraConfig();
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.addAll(collection);
            Map<UseCase, Set<GroupableFeature>> mapApplyFeatureGroup = applyFeatureGroup(linkedHashSet, resolvedFeatureGroup);
            try {
                try {
                    calculatedUseCaseInfoCalculateAndValidateUseCases = calculateAndValidateUseCases(linkedHashSet, this.mSecondaryCameraInternal != null, z2);
                } catch (IllegalArgumentException e) {
                    throw new CameraException(e);
                }
            } finally {
                restoreFeatureGroup(mapApplyFeatureGroup);
            }
        }
        return calculatedUseCaseInfoCalculateAndValidateUseCases;
    }

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    public void addUseCases(Collection<UseCase> collection, ResolvedFeatureGroup resolvedFeatureGroup) throws CameraException {
        Logger.d(TAG, "addUseCases: appUseCasesToAdd = " + collection + ", featureGroup = " + resolvedFeatureGroup);
        synchronized (this.mLock) {
            try {
                applyCameraConfig();
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
                linkedHashSet.addAll(collection);
                Map<UseCase, Set<GroupableFeature>> mapApplyFeatureGroup = applyFeatureGroup(linkedHashSet, resolvedFeatureGroup);
                try {
                    applyCalculatedUseCaseChanges(calculateAndValidateUseCases(linkedHashSet, this.mSecondaryCameraInternal != null, false));
                } catch (IllegalArgumentException e) {
                    restoreFeatureGroup(mapApplyFeatureGroup);
                    throw new CameraException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(boolean z2, UseCase... useCaseArr) {
        Collection<UseCase> collectionAsList = Arrays.asList(useCaseArr);
        if (z2) {
            try {
                collectionAsList = calculateCameraUseCases(collectionAsList, null, createOrReuseStreamSharing(collectionAsList, true));
            } catch (IllegalArgumentException e) {
                Logger.d(TAG, "Unable to apply StreamSharing", e);
                return false;
            }
        }
        return this.mCameraInternal.getCameraInfoInternal().isUseCaseCombinationSupported(new ArrayList(collectionAsList), getCameraMode(), false, this.mCameraConfig);
    }

    public CameraUseCaseAdapter(CameraInternal cameraInternal, CameraInternal cameraInternal2, AdapterCameraInfo adapterCameraInfo, AdapterCameraInfo adapterCameraInfo2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, CameraCoordinator cameraCoordinator, StreamSpecsCalculator streamSpecsCalculator, UseCaseConfigFactory useCaseConfigFactory) {
        this.mAppUseCases = new ArrayList();
        this.mCameraUseCases = new ArrayList();
        this.mEffects = Collections.EMPTY_LIST;
        this.mSessionType = 0;
        this.mFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        this.mLock = new Object();
        this.mAttached = true;
        this.mInteropConfig = null;
        this.mStreamSharingForceEnabler = new StreamSharingForceEnabler();
        this.mCameraConfig = adapterCameraInfo.getCameraConfig();
        this.mCameraInternal = new AdapterCameraInternal(cameraInternal, adapterCameraInfo);
        if (cameraInternal2 != null && adapterCameraInfo2 != null) {
            this.mSecondaryCameraInternal = new AdapterCameraInternal(cameraInternal2, adapterCameraInfo2);
        } else {
            this.mSecondaryCameraInternal = null;
        }
        this.mCompositionSettings = compositionSettings;
        this.mSecondaryCompositionSettings = compositionSettings2;
        this.mCameraCoordinator = cameraCoordinator;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mCameraIdentifier = CameraIdentifier.fromAdapterInfos(adapterCameraInfo, adapterCameraInfo2);
        this.mStreamSpecsCalculator = streamSpecsCalculator;
    }
}
