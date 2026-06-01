package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.OptIn;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class CropRegionZoomImpl implements ZoomControl.ZoomImpl {
    public static final float MIN_DIGITAL_ZOOM = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private Rect mCurrentCropRect = null;
    private Rect mPendingZoomCropRegion = null;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;

    public CropRegionZoomImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
    }

    private static Rect getCropRectByRatio(Rect rect, float f4) {
        float fWidth = rect.width() / f4;
        float fHeight = rect.height() / f4;
        float fWidth2 = (rect.width() - fWidth) / 2.0f;
        float fHeight2 = (rect.height() - fHeight) / 2.0f;
        return new Rect((int) fWidth2, (int) fHeight2, (int) (fWidth2 + fWidth), (int) (fHeight2 + fHeight));
    }

    private Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public void addRequestOption(Camera2ImplConfig.Builder builder) {
        Rect rect = this.mCurrentCropRect;
        if (rect != null) {
            builder.setCaptureRequestOptionWithPriority(CaptureRequest.SCALER_CROP_REGION, rect, Config.OptionPriority.REQUIRED);
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        Rect rect = this.mCurrentCropRect;
        return rect != null ? rect : getSensorRect();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        Float f4 = (Float) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f4 == null) {
            return 1.0f;
        }
        return f4.floatValue() < getMinZoom() ? getMinZoom() : f4.floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult totalCaptureResult) {
        if (this.mPendingZoomRatioCompleter != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            Rect rect2 = this.mPendingZoomCropRegion;
            if (rect2 == null || !rect2.equals(rect)) {
                return;
            }
            this.mPendingZoomRatioCompleter.set(null);
            this.mPendingZoomRatioCompleter = null;
            this.mPendingZoomCropRegion = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mPendingZoomCropRegion = null;
        this.mCurrentCropRect = null;
        CallbackToFutureAdapter.Completer<Void> completer = this.mPendingZoomRatioCompleter;
        if (completer != null) {
            a1.a.B("Camera is not active.", completer);
            this.mPendingZoomRatioCompleter = null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float f4, CallbackToFutureAdapter.Completer<Void> completer) {
        this.mCurrentCropRect = getCropRectByRatio(getSensorRect(), f4);
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mPendingZoomRatioCompleter;
        if (completer2 != null) {
            a1.a.B("There is a new zoomRatio being set", completer2);
        }
        this.mPendingZoomCropRegion = this.mCurrentCropRect;
        this.mPendingZoomRatioCompleter = completer;
    }
}
