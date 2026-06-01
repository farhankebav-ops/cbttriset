package androidx.camera.core.impl;

import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.annotation.OptIn;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUseCaseAdapterProvider;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalSessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback);

    Set<Integer> getAvailableCapabilities();

    Object getCameraCharacteristics();

    String getCameraId();

    @Override // androidx.camera.core.CameraInfo
    CameraIdentifier getCameraIdentifier();

    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    CameraSelector getCameraSelector();

    EncoderProfilesProvider getEncoderProfilesProvider();

    CameraInfoInternal getImplementation();

    Object getPhysicalCameraCharacteristics(String str);

    Rect getSensorRect();

    Set<DynamicRange> getSupportedDynamicRanges();

    @Override // androidx.camera.core.CameraInfo
    @ExperimentalSessionConfig
    Set<Range<Integer>> getSupportedFrameRateRanges(androidx.camera.core.SessionConfig sessionConfig);

    List<Size> getSupportedHighResolutions(int i2);

    Set<Range<Integer>> getSupportedHighSpeedFrameRateRanges();

    Set<Range<Integer>> getSupportedHighSpeedFrameRateRangesFor(Size size);

    List<Size> getSupportedHighSpeedResolutions();

    List<Size> getSupportedHighSpeedResolutionsFor(Range<Integer> range);

    Set<Integer> getSupportedOutputFormats();

    List<Size> getSupportedResolutions(int i2);

    Timebase getTimebase();

    boolean isCaptureProcessProgressSupported();

    @Override // androidx.camera.core.CameraInfo
    @ExperimentalSessionConfig
    boolean isFeatureGroupSupported(androidx.camera.core.SessionConfig sessionConfig);

    boolean isHighSpeedSupported();

    boolean isPostviewSupported();

    boolean isPreviewStabilizationSupported();

    @OptIn(markerClass = {ExperimentalSessionConfig.class})
    boolean isResolvedFeatureGroupSupported(ResolvedFeatureGroup resolvedFeatureGroup, androidx.camera.core.SessionConfig sessionConfig);

    boolean isUseCaseCombinationSupported(List<UseCase> list);

    boolean isUseCaseCombinationSupported(List<UseCase> list, int i2);

    boolean isUseCaseCombinationSupported(List<UseCase> list, int i2, boolean z2);

    boolean isUseCaseCombinationSupported(List<UseCase> list, int i2, boolean z2, CameraConfig cameraConfig);

    boolean isVideoStabilizationSupported();

    void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback);

    void setCameraUseCaseAdapterProvider(CameraUseCaseAdapterProvider cameraUseCaseAdapterProvider);
}
