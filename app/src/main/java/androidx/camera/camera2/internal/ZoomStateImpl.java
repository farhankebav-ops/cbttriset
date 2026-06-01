package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.AdapterCameraInfo;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ZoomStateImpl implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    public ZoomStateImpl(float f4, float f8) {
        this.mMaxZoomRatio = f4;
        this.mMinZoomRatio = f8;
    }

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void setLinearZoom(float f4) throws IllegalArgumentException {
        if (f4 <= 1.0f && f4 >= 0.0f) {
            this.mLinearZoom = f4;
            this.mZoomRatio = AdapterCameraInfo.getZoomRatioByPercentage(f4, this.mMinZoomRatio, this.mMaxZoomRatio);
        } else {
            throw new IllegalArgumentException("Requested linearZoom " + f4 + " is not within valid range [0..1]");
        }
    }

    public void setZoomRatio(float f4) throws IllegalArgumentException {
        float f8 = this.mMaxZoomRatio;
        if (f4 <= f8) {
            float f9 = this.mMinZoomRatio;
            if (f4 >= f9) {
                this.mZoomRatio = f4;
                this.mLinearZoom = AdapterCameraInfo.getPercentageByRatio(f4, f9, f8);
                return;
            }
        }
        throw new IllegalArgumentException("Requested zoomRatio " + f4 + " is not within valid range [" + this.mMinZoomRatio + " , " + this.mMaxZoomRatio + C2300e4.i.e);
    }
}
