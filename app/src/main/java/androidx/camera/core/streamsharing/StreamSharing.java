package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CompositionSettings;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.concurrent.DualOutConfig;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.core.util.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j2.q;
import java.util.ArrayList;
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
public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final CompositionSettings mCompositionSettings;
    private final StreamSharingConfig mDefaultConfig;
    private DualSurfaceProcessorNode mDualSharingNode;
    private SurfaceProcessorNode mEffectNode;
    private SurfaceEdge mSecondaryCameraEdge;
    private final CompositionSettings mSecondaryCompositionSettings;
    SessionConfig.Builder mSecondarySessionConfigBuilder;
    private SurfaceEdge mSecondarySharingInputEdge;
    SessionConfig.Builder mSessionConfigBuilder;
    private SurfaceEdge mSharingInputEdge;
    private SurfaceProcessorNode mSharingNode;
    private final VirtualCameraAdapter mVirtualCameraAdapter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Control {
        q jpegSnapshot(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100) int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 359) int i8);
    }

    public StreamSharing(CameraInternal cameraInternal, CameraInternal cameraInternal2, CompositionSettings compositionSettings, CompositionSettings compositionSettings2, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(set));
        this.mDefaultConfig = getDefaultConfig(set);
        this.mCompositionSettings = compositionSettings;
        this.mSecondaryCompositionSettings = compositionSettings2;
        this.mVirtualCameraAdapter = new VirtualCameraAdapter(cameraInternal, cameraInternal2, set, useCaseConfigFactory, new Control() { // from class: androidx.camera.core.streamsharing.b
            @Override // androidx.camera.core.streamsharing.StreamSharing.Control
            public final q jpegSnapshot(int i2, int i8) {
                return this.f3745a.lambda$new$0(i2, i8);
            }
        });
        updateFeatureGroup(set);
    }

    private void addCameraErrorListener(SessionConfig.Builder builder, final String str, final String str2, final UseCaseConfig<?> useCaseConfig, final StreamSpec streamSpec, final StreamSpec streamSpec2) {
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.streamsharing.a
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.f3740a.lambda$addCameraErrorListener$1(str, str2, useCaseConfig, streamSpec, streamSpec2, sessionConfig, sessionError);
            }
        });
        this.mCloseableErrorListener = closeableErrorListener2;
        builder.setErrorListener(closeableErrorListener2);
    }

    private void clearPipeline() {
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
            this.mCloseableErrorListener = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSecondaryCameraEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSecondaryCameraEdge = null;
        }
        SurfaceEdge surfaceEdge3 = this.mSharingInputEdge;
        if (surfaceEdge3 != null) {
            surfaceEdge3.close();
            this.mSharingInputEdge = null;
        }
        SurfaceEdge surfaceEdge4 = this.mSecondarySharingInputEdge;
        if (surfaceEdge4 != null) {
            surfaceEdge4.close();
            this.mSecondarySharingInputEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mSharingNode = null;
        }
        DualSurfaceProcessorNode dualSurfaceProcessorNode = this.mDualSharingNode;
        if (dualSurfaceProcessorNode != null) {
            dualSurfaceProcessorNode.release();
            this.mDualSharingNode = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.mEffectNode;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.release();
            this.mEffectNode = null;
        }
    }

    @MainThread
    private List<SessionConfig> createPipelineAndUpdateChildrenSpecs(String str, String str2, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, StreamSpec streamSpec2) {
        Threads.checkMainThread();
        if (streamSpec2 == null) {
            createPrimaryCamera(str, str2, useCaseConfig, streamSpec, null);
            CameraInternal camera = getCamera();
            Objects.requireNonNull(camera);
            this.mSharingNode = getSharingNode(camera, streamSpec);
            boolean z2 = getViewPortCropRect() != null;
            Map<UseCase, OutConfig> childrenOutConfigs = this.mVirtualCameraAdapter.getChildrenOutConfigs(this.mSharingInputEdge, getTargetRotationInternal(), z2);
            SurfaceProcessorNode.Out outTransform2 = this.mSharingNode.transform(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(childrenOutConfigs.values())));
            HashMap map = new HashMap();
            for (Map.Entry<UseCase, OutConfig> entry : childrenOutConfigs.entrySet()) {
                map.put(entry.getKey(), outTransform2.get(entry.getValue()));
            }
            this.mVirtualCameraAdapter.setChildrenEdges(map, this.mVirtualCameraAdapter.getSelectedChildSizes(this.mSharingInputEdge, z2));
            Object[] objArr = {this.mSessionConfigBuilder.build()};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            return Collections.unmodifiableList(arrayList);
        }
        createPrimaryCamera(str, str2, useCaseConfig, streamSpec, streamSpec2);
        createSecondaryCamera(str, str2, useCaseConfig, streamSpec, streamSpec2);
        this.mDualSharingNode = getDualSharingNode(getCamera(), getSecondaryCamera(), streamSpec, this.mCompositionSettings, this.mSecondaryCompositionSettings);
        boolean z7 = getViewPortCropRect() != null;
        Map<UseCase, DualOutConfig> childrenOutConfigs2 = this.mVirtualCameraAdapter.getChildrenOutConfigs(this.mSharingInputEdge, this.mSecondarySharingInputEdge, getTargetRotationInternal(), z7);
        DualSurfaceProcessorNode.Out outTransform22 = this.mDualSharingNode.transform(DualSurfaceProcessorNode.In.of(this.mSharingInputEdge, this.mSecondarySharingInputEdge, new ArrayList(childrenOutConfigs2.values())));
        HashMap map2 = new HashMap();
        for (Map.Entry<UseCase, DualOutConfig> entry2 : childrenOutConfigs2.entrySet()) {
            map2.put(entry2.getKey(), outTransform22.get(entry2.getValue()));
        }
        this.mVirtualCameraAdapter.setChildrenEdges(map2, this.mVirtualCameraAdapter.getSelectedChildSizes(this.mSharingInputEdge, z7));
        Object[] objArr2 = {this.mSessionConfigBuilder.build(), this.mSecondarySessionConfigBuilder.build()};
        ArrayList arrayList2 = new ArrayList(2);
        for (int i2 = 0; i2 < 2; i2++) {
            Object obj2 = objArr2[i2];
            Objects.requireNonNull(obj2);
            arrayList2.add(obj2);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void createPrimaryCamera(String str, String str2, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, StreamSpec streamSpec2) {
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        boolean hasTransform = camera.getHasTransform();
        Rect cropRect = getCropRect(streamSpec.getResolution());
        Objects.requireNonNull(cropRect);
        CameraInternal camera2 = getCamera();
        Objects.requireNonNull(camera2);
        int relativeRotation = getRelativeRotation(camera2);
        CameraInternal camera3 = getCamera();
        Objects.requireNonNull(camera3);
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec, sensorToBufferTransformMatrix, hasTransform, cropRect, relativeRotation, -1, isMirroringRequired(camera3));
        this.mCameraEdge = surfaceEdge;
        CameraInternal camera4 = getCamera();
        Objects.requireNonNull(camera4);
        this.mSharingInputEdge = getSharingInputEdge(surfaceEdge, camera4);
        SessionConfig.Builder builderCreateSessionConfigBuilder = createSessionConfigBuilder(this.mCameraEdge, useCaseConfig, streamSpec);
        this.mSessionConfigBuilder = builderCreateSessionConfigBuilder;
        addCameraErrorListener(builderCreateSessionConfigBuilder, str, str2, useCaseConfig, streamSpec, streamSpec2);
    }

    private void createSecondaryCamera(String str, String str2, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, StreamSpec streamSpec2) {
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        CameraInternal secondaryCamera = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera);
        boolean hasTransform = secondaryCamera.getHasTransform();
        Rect cropRect = getCropRect(streamSpec2.getResolution());
        Objects.requireNonNull(cropRect);
        CameraInternal secondaryCamera2 = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera2);
        int relativeRotation = getRelativeRotation(secondaryCamera2);
        CameraInternal secondaryCamera3 = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera3);
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec2, sensorToBufferTransformMatrix, hasTransform, cropRect, relativeRotation, -1, isMirroringRequired(secondaryCamera3));
        this.mSecondaryCameraEdge = surfaceEdge;
        CameraInternal secondaryCamera4 = getSecondaryCamera();
        Objects.requireNonNull(secondaryCamera4);
        this.mSecondarySharingInputEdge = getSharingInputEdge(surfaceEdge, secondaryCamera4);
        SessionConfig.Builder builderCreateSessionConfigBuilder = createSessionConfigBuilder(this.mSecondaryCameraEdge, useCaseConfig, streamSpec2);
        this.mSecondarySessionConfigBuilder = builderCreateSessionConfigBuilder;
        addCameraErrorListener(builderCreateSessionConfigBuilder, str, str2, useCaseConfig, streamSpec, streamSpec2);
    }

    private SessionConfig.Builder createSessionConfigBuilder(SurfaceEdge surfaceEdge, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec) {
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(useCaseConfig, streamSpec.getResolution());
        propagateChildrenTemplate(builderCreateFrom);
        propagateChildrenCamera2Interop(streamSpec.getResolution(), builderCreateFrom);
        builderCreateFrom.addSurface(surfaceEdge.getDeferrableSurface(), streamSpec.getDynamicRange(), null, -1);
        builderCreateFrom.addRepeatingCameraCaptureCallback(this.mVirtualCameraAdapter.getParentMetadataCallback());
        if (streamSpec.getImplementationOptions() != null) {
            builderCreateFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        builderCreateFrom.setSessionType(streamSpec.getSessionType());
        applyExpectedFrameRateRange(builderCreateFrom, streamSpec);
        return builderCreateFrom;
    }

    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (!isStreamSharing(useCase)) {
            arrayList.add(useCase.getCurrentConfig().getCaptureType());
            return arrayList;
        }
        Iterator<UseCase> it = ((StreamSharing) useCase).getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getCurrentConfig().getCaptureType());
        }
        return arrayList;
    }

    private static int getChildTemplate(UseCase useCase) {
        return useCase.getCurrentConfig().getDefaultSessionConfig().getTemplateType();
    }

    private Rect getCropRect(Size size) {
        return getViewPortCropRect() != null ? getViewPortCropRect() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private Rect getCropRectAppliedByEffect(SurfaceEdge surfaceEdge) {
        return ((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1 ? TransformUtils.sizeToRect(surfaceEdge.getStreamSpec().getResolution()) : surfaceEdge.getCropRect();
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> set) {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : set) {
            if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(useCase.getCurrentConfig().getCaptureType());
            } else {
                Log.e(TAG, "A child does not have capture type.");
            }
        }
        mutableConfig.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableConfig.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        mutableConfig.insertOption(UseCaseConfig.OPTION_STREAM_USE_CASE, StreamUseCase.PREVIEW_VIDEO_STILL);
        return new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    private DualSurfaceProcessorNode getDualSharingNode(CameraInternal cameraInternal, CameraInternal cameraInternal2, StreamSpec streamSpec, CompositionSettings compositionSettings, CompositionSettings compositionSettings2) {
        return new DualSurfaceProcessorNode(cameraInternal, cameraInternal2, DualSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange(), compositionSettings, compositionSettings2));
    }

    private boolean getMirroringAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1) {
            CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
            if (cameraInternal.isFrontFacing() && cameraInternal.getHasTransform()) {
                return true;
            }
        }
        return false;
    }

    private int getRotationAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1) {
            return getRelativeRotation((CameraInternal) Preconditions.checkNotNull(getCamera()));
        }
        return 0;
    }

    private SurfaceEdge getSharingInputEdge(SurfaceEdge surfaceEdge, CameraInternal cameraInternal) {
        if (getEffect() == null || getEffect().getTransformation() == 2 || getEffect().getOutputOption() == 1) {
            return surfaceEdge;
        }
        this.mEffectNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        int rotationAppliedByEffect = getRotationAppliedByEffect();
        Rect cropRectAppliedByEffect = getCropRectAppliedByEffect(surfaceEdge);
        OutConfig outConfigOf = OutConfig.of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), cropRectAppliedByEffect, TransformUtils.getRotatedSize(cropRectAppliedByEffect, rotationAppliedByEffect), rotationAppliedByEffect, getMirroringAppliedByEffect(), true);
        SurfaceEdge surfaceEdge2 = this.mEffectNode.transform(SurfaceProcessorNode.In.of(surfaceEdge, Collections.singletonList(outConfigOf))).get(outConfigOf);
        Objects.requireNonNull(surfaceEdge2);
        return surfaceEdge2;
    }

    private SurfaceProcessorNode getSharingNode(CameraInternal cameraInternal, StreamSpec streamSpec) {
        if (getEffect() == null || getEffect().getOutputOption() != 1) {
            return new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange()));
        }
        SurfaceProcessorNode surfaceProcessorNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        this.mEffectNode = surfaceProcessorNode;
        return surfaceProcessorNode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isStreamSharing(UseCase useCase) {
        return useCase instanceof StreamSharing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCameraErrorListener$1(String str, String str2, UseCaseConfig useCaseConfig, StreamSpec streamSpec, StreamSpec streamSpec2, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (getCamera() == null) {
            return;
        }
        clearPipeline();
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(str, str2, useCaseConfig, streamSpec, streamSpec2));
        notifyReset();
        this.mVirtualCameraAdapter.resetChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ q lambda$new$0(int i2, int i8) {
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        return surfaceProcessorNode != null ? surfaceProcessorNode.getSurfaceProcessor().snapshot(i2, i8) : Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    private void propagateChildrenCamera2Interop(Size size, SessionConfig.Builder builder) {
        Iterator<UseCase> it = getChildren().iterator();
        while (it.hasNext()) {
            SessionConfig sessionConfigBuild = SessionConfig.Builder.createFrom(it.next().getCurrentConfig(), size).build();
            builder.addAllRepeatingCameraCaptureCallbacks(sessionConfigBuild.getRepeatingCameraCaptureCallbacks());
            builder.addAllCameraCaptureCallbacks(sessionConfigBuild.getSingleCameraCaptureCallbacks());
            builder.addAllSessionStateCallbacks(sessionConfigBuild.getSessionStateCallbacks());
            builder.addAllDeviceStateCallbacks(sessionConfigBuild.getDeviceStateCallbacks());
            builder.addImplementationOptions(sessionConfigBuild.getImplementationOptions());
        }
    }

    private void propagateChildrenTemplate(SessionConfig.Builder builder) {
        Iterator<UseCase> it = getChildren().iterator();
        int higherPriorityTemplateType = -1;
        while (it.hasNext()) {
            higherPriorityTemplateType = SessionConfig.getHigherPriorityTemplateType(higherPriorityTemplateType, getChildTemplate(it.next()));
        }
        if (higherPriorityTemplateType != -1) {
            builder.setTemplateType(higherPriorityTemplateType);
        }
    }

    @VisibleForTesting
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    public Set<UseCase> getChildren() {
        return this.mVirtualCameraAdapter.getChildren();
    }

    @Override // androidx.camera.core.UseCase
    public Set<DynamicRange> getSupportedDynamicRanges(CameraInfoInternal cameraInfoInternal) {
        Set<UseCase> children = getChildren();
        HashSet hashSet = null;
        if (children.isEmpty()) {
            return null;
        }
        Iterator<UseCase> it = children.iterator();
        while (it.hasNext()) {
            Set<DynamicRange> supportedDynamicRanges = it.next().getSupportedDynamicRanges(cameraInfoInternal);
            if (supportedDynamicRanges != null) {
                if (hashSet == null) {
                    hashSet = new HashSet(supportedDynamicRanges);
                } else {
                    hashSet.retainAll(supportedDynamicRanges);
                }
            }
        }
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    @VisibleForTesting
    public VirtualCameraAdapter getVirtualCameraAdapter() {
        return this.mVirtualCameraAdapter;
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        super.onBind();
        this.mVirtualCameraAdapter.bindChildren();
    }

    @Override // androidx.camera.core.UseCase
    public void onCameraControlReady() {
        super.onCameraControlReady();
        this.mVirtualCameraAdapter.notifyCameraControlReady();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        this.mVirtualCameraAdapter.mergeChildrenConfigs(builder.getMutableConfig());
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @MainThread
    public void onSessionStart() {
        super.onSessionStart();
        this.mVirtualCameraAdapter.notifySessionStart();
    }

    @Override // androidx.camera.core.UseCase
    @MainThread
    public void onSessionStop() {
        super.onSessionStop();
        this.mVirtualCameraAdapter.notifySessionStop();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        Object[] objArr = {this.mSessionConfigBuilder.build()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        updateSessionConfig(Collections.unmodifiableList(arrayList));
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec, StreamSpec streamSpec2) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + streamSpec + ", secondaryStreamSpec " + streamSpec2);
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getSecondaryCameraId(), getCurrentConfig(), streamSpec, streamSpec2));
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCameraAdapter.unbindChildren();
    }

    public void updateFeatureGroup(Set<UseCase> set) {
        setFeatureGroup(set.iterator().next().getFeatureGroup());
    }

    @VisibleForTesting
    public SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        StreamSharingConfig streamSharingConfig = this.mDefaultConfig;
        streamSharingConfig.getClass();
        Config config = useCaseConfigFactory.getConfig(UseCaseConfig.CC.c(streamSharingConfig), 1);
        if (z2) {
            config = o.b(config, this.mDefaultConfig.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @VisibleForTesting
    public SurfaceEdge getSharingInputEdge() {
        return this.mSharingInputEdge;
    }
}
