package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f4, float f8) {
        this.mWidth = f4;
        this.mHeight = f8;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    private int getRelativeCameraOrientation(boolean z2) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z2 ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PointF convertPoint(float f4, float f8) {
        float f9 = this.mWidth;
        float f10 = this.mHeight;
        boolean z2 = this.mCameraInfo.getLensFacing() == 0;
        int relativeCameraOrientation = getRelativeCameraOrientation(z2);
        if (relativeCameraOrientation != 90 && relativeCameraOrientation != 270) {
            f8 = f4;
            f4 = f8;
            f10 = f9;
            f9 = f10;
        }
        if (relativeCameraOrientation == 90) {
            f4 = f9 - f4;
        } else if (relativeCameraOrientation == 180) {
            f8 = f10 - f8;
            f4 = f9 - f4;
        } else if (relativeCameraOrientation == 270) {
            f8 = f10 - f8;
        }
        if (z2) {
            f8 = f10 - f8;
        }
        return new PointF(f8 / f10, f4 / f9);
    }
}
