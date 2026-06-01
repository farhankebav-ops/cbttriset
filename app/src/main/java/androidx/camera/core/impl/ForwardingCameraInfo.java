package androidx.camera.core.impl;

import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUseCaseAdapterProvider;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.ExperimentalZeroShutterLag;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.UseCase;
import androidx.camera.core.ZoomState;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.lifecycle.LiveData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingCameraInfo implements CameraInfoInternal {
    private final CameraInfoInternal mCameraInfoInternal;

    public ForwardingCameraInfo(CameraInfoInternal cameraInfoInternal) {
        this.mCameraInfoInternal = cameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraInfoInternal.addSessionCaptureCallback(executor, cameraCaptureCallback);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Integer> getAvailableCapabilities() {
        return this.mCameraInfoInternal.getAvailableCapabilities();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Object getCameraCharacteristics() {
        return this.mCameraInfoInternal.getCameraCharacteristics();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mCameraInfoInternal.getCameraId();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.CameraInfo
    public final /* synthetic */ CameraIdentifier getCameraIdentifier() {
        return k.b(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Quirks getCameraQuirks() {
        return this.mCameraInfoInternal.getCameraQuirks();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.CameraInfo
    public CameraSelector getCameraSelector() {
        return this.mCameraInfoInternal.getCameraSelector();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<CameraState> getCameraState() {
        return this.mCameraInfoInternal.getCameraState();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.mCameraInfoInternal.getEncoderProfilesProvider();
    }

    @Override // androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        return this.mCameraInfoInternal.getExposureState();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfoInternal.getImplementation();
    }

    @Override // androidx.camera.core.CameraInfo
    public String getImplementationType() {
        return this.mCameraInfoInternal.getImplementationType();
    }

    @Override // androidx.camera.core.CameraInfo
    public float getIntrinsicZoomRatio() {
        return this.mCameraInfoInternal.getIntrinsicZoomRatio();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getLensFacing() {
        return this.mCameraInfoInternal.getLensFacing();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getLowLightBoostState() {
        return this.mCameraInfoInternal.getLowLightBoostState();
    }

    @Override // androidx.camera.core.CameraInfo
    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public int getMaxTorchStrengthLevel() {
        return this.mCameraInfoInternal.getMaxTorchStrengthLevel();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Object getPhysicalCameraCharacteristics(String str) {
        return this.mCameraInfoInternal.getPhysicalCameraCharacteristics(str);
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<CameraInfo> getPhysicalCameraInfos() {
        return this.mCameraInfoInternal.getPhysicalCameraInfos();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Rect getSensorRect() {
        return this.mCameraInfoInternal.getSensorRect();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return this.mCameraInfoInternal.getSensorRotationDegrees();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mCameraInfoInternal.getSupportedDynamicRanges();
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        return this.mCameraInfoInternal.getSupportedFrameRateRanges();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighResolutions(int i2) {
        return this.mCameraInfoInternal.getSupportedHighResolutions(i2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Range<Integer>> getSupportedHighSpeedFrameRateRanges() {
        return this.mCameraInfoInternal.getSupportedHighSpeedFrameRateRanges();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Range<Integer>> getSupportedHighSpeedFrameRateRangesFor(Size size) {
        return this.mCameraInfoInternal.getSupportedHighSpeedFrameRateRangesFor(size);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighSpeedResolutions() {
        return this.mCameraInfoInternal.getSupportedHighSpeedResolutions();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedHighSpeedResolutionsFor(Range<Integer> range) {
        return this.mCameraInfoInternal.getSupportedHighSpeedResolutionsFor(range);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Set<Integer> getSupportedOutputFormats() {
        return this.mCameraInfoInternal.getSupportedOutputFormats();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public List<Size> getSupportedResolutions(int i2) {
        return this.mCameraInfoInternal.getSupportedResolutions(i2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public Timebase getTimebase() {
        return this.mCameraInfoInternal.getTimebase();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        return this.mCameraInfoInternal.getTorchState();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchStrengthLevel() {
        return this.mCameraInfoInternal.getTorchStrengthLevel();
    }

    @Override // androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        return this.mCameraInfoInternal.getZoomState();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        return this.mCameraInfoInternal.hasFlashUnit();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public /* synthetic */ boolean isCaptureProcessProgressSupported() {
        return k.f(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.CameraInfo
    public final /* synthetic */ boolean isFeatureGroupSupported(androidx.camera.core.SessionConfig sessionConfig) {
        return k.g(this, sessionConfig);
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        return this.mCameraInfoInternal.isFocusMeteringSupported(focusMeteringAction);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isHighSpeedSupported() {
        return this.mCameraInfoInternal.isHighSpeedSupported();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLogicalMultiCameraSupported() {
        return this.mCameraInfoInternal.isLogicalMultiCameraSupported();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isLowLightBoostSupported() {
        return this.mCameraInfoInternal.isLowLightBoostSupported();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public /* synthetic */ boolean isPostviewSupported() {
        return k.h(this);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isPreviewStabilizationSupported() {
        return this.mCameraInfoInternal.isPreviewStabilizationSupported();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isPrivateReprocessingSupported() {
        return this.mCameraInfoInternal.isPrivateReprocessingSupported();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ boolean isResolvedFeatureGroupSupported(ResolvedFeatureGroup resolvedFeatureGroup, androidx.camera.core.SessionConfig sessionConfig) {
        return k.i(this, resolvedFeatureGroup, sessionConfig);
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean isTorchStrengthSupported() {
        return this.mCameraInfoInternal.isTorchStrengthSupported();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ boolean isUseCaseCombinationSupported(List list) {
        return k.j(this, list);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isVideoStabilizationSupported() {
        return this.mCameraInfoInternal.isVideoStabilizationSupported();
    }

    @Override // androidx.camera.core.CameraInfo
    @ExperimentalZeroShutterLag
    public boolean isZslSupported() {
        return this.mCameraInfoInternal.isZslSupported();
    }

    @Override // androidx.camera.core.CameraInfo
    public Set<DynamicRange> querySupportedDynamicRanges(Set<DynamicRange> set) {
        return this.mCameraInfoInternal.querySupportedDynamicRanges(set);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public void setCameraUseCaseAdapterProvider(CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider) {
        this.mCameraInfoInternal.setCameraUseCaseAdapterProvider(cameraUseCaseAdapterProvider);
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int i2) {
        return this.mCameraInfoInternal.getSensorRotationDegrees(i2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.CameraInfo
    @ExperimentalSessionConfig
    public Set<Range<Integer>> getSupportedFrameRateRanges(androidx.camera.core.SessionConfig sessionConfig) {
        return this.mCameraInfoInternal.getSupportedFrameRateRanges(sessionConfig);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final /* synthetic */ boolean isUseCaseCombinationSupported(List list, int i2) {
        return k.k(this, list, i2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public /* synthetic */ boolean isUseCaseCombinationSupported(List list, int i2, boolean z2) {
        return k.l(this, list, i2, z2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean isUseCaseCombinationSupported(List<UseCase> list, int i2, boolean z2, CameraConfig cameraConfig) {
        return this.mCameraInfoInternal.isUseCaseCombinationSupported(list, i2, z2, cameraConfig);
    }
}
