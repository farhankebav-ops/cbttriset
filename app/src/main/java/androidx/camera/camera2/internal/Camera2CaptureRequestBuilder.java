package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class Camera2CaptureRequestBuilder {
    private static final String TAG = "Camera2CaptureRequestBuilder";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static CaptureRequest.Builder createReprocessCaptureRequest(CameraDevice cameraDevice, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    private Camera2CaptureRequestBuilder() {
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static void applyAeFpsRange(CaptureConfig captureConfig, CaptureRequest.Builder builder) {
        Range<Integer> expectedFrameRateRange = captureConfig.getExpectedFrameRateRange();
        if (!expectedFrameRateRange.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, expectedFrameRateRange);
        }
        Logger.d(TAG, "applyAeFpsRange: expectedFrameRateRange = " + expectedFrameRateRange);
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, Config config) {
        CaptureRequestOptions captureRequestOptionsBuild = CaptureRequestOptions.Builder.from(config).build();
        captureRequestOptionsBuild.getClass();
        for (Config.Option option : androidx.camera.core.impl.w.e(captureRequestOptionsBuild)) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.getToken();
            try {
                builder.set(key, androidx.camera.core.impl.w.f(captureRequestOptionsBuild, option));
            } catch (IllegalArgumentException unused) {
                Logger.e(TAG, "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    private static void applyTemplateParamsOverrideWorkaround(CaptureRequest.Builder builder, int i2, TemplateParamsOverride templateParamsOverride) {
        for (Map.Entry<CaptureRequest.Key<?>, Object> entry : templateParamsOverride.getOverrideParams(i2).entrySet()) {
            builder.set(entry.getKey(), entry.getValue());
        }
    }

    @VisibleForTesting
    public static void applyVideoStabilization(CaptureConfig captureConfig, CaptureRequest.Builder builder) {
        Integer videoStabilizationModeFromCaptureConfig = getVideoStabilizationModeFromCaptureConfig(captureConfig);
        if (videoStabilizationModeFromCaptureConfig != null) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, videoStabilizationModeFromCaptureConfig);
        }
        Logger.d(TAG, "applyVideoStabilization: mode = " + videoStabilizationModeFromCaptureConfig);
    }

    public static CaptureRequest build(CaptureConfig captureConfig, CameraDevice cameraDevice, Map<DeferrableSurface, Surface> map, boolean z2, TemplateParamsOverride templateParamsOverride) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> configuredSurfaces = getConfiguredSurfaces(captureConfig.getSurfaces(), map);
        if (configuredSurfaces.isEmpty()) {
            return null;
        }
        CameraCaptureResult cameraCaptureResult = captureConfig.getCameraCaptureResult();
        if (captureConfig.getTemplateType() == 5 && cameraCaptureResult != null && (cameraCaptureResult.getCaptureResult() instanceof TotalCaptureResult)) {
            Logger.d(TAG, "createReprocessCaptureRequest");
            builderCreateCaptureRequest = Api23Impl.createReprocessCaptureRequest(cameraDevice, (TotalCaptureResult) cameraCaptureResult.getCaptureResult());
        } else {
            Logger.d(TAG, "createCaptureRequest");
            if (captureConfig.getTemplateType() == 5) {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z2 ? 1 : 2);
            } else {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
            }
        }
        applyTemplateParamsOverrideWorkaround(builderCreateCaptureRequest, captureConfig.getTemplateType(), templateParamsOverride);
        applyAeFpsRange(captureConfig, builderCreateCaptureRequest);
        applyVideoStabilization(captureConfig, builderCreateCaptureRequest);
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, captureConfig.getImplementationOptions());
        Iterator<Surface> it = configuredSurfaces.iterator();
        while (it.hasNext()) {
            builderCreateCaptureRequest.addTarget(it.next());
        }
        builderCreateCaptureRequest.setTag(captureConfig.getTagBundle());
        return builderCreateCaptureRequest.build();
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig captureConfig, CameraDevice cameraDevice, TemplateParamsOverride templateParamsOverride) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        Logger.d(TAG, "template type = " + captureConfig.getTemplateType());
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        applyTemplateParamsOverrideWorkaround(builderCreateCaptureRequest, captureConfig.getTemplateType(), templateParamsOverride);
        applyAeFpsRange(captureConfig, builderCreateCaptureRequest);
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, captureConfig.getImplementationOptions());
        return builderCreateCaptureRequest.build();
    }

    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            Surface surface = map.get(it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        return arrayList;
    }

    public static Integer getVideoStabilizationModeFromCaptureConfig(CaptureConfig captureConfig) {
        if (captureConfig.getPreviewStabilizationMode() == 1 || captureConfig.getVideoStabilizationMode() == 1) {
            return 0;
        }
        if (captureConfig.getPreviewStabilizationMode() == 2) {
            return 2;
        }
        return captureConfig.getVideoStabilizationMode() == 2 ? 1 : null;
    }
}
