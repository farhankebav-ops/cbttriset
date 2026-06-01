package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraControl {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class OperationCanceledException extends Exception {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(String str) {
            super(str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(String str, Throwable th) {
            super(str, th);
        }
    }

    j2.q cancelFocusAndMetering();

    j2.q enableLowLightBoostAsync(boolean z2);

    j2.q enableTorch(boolean z2);

    j2.q setExposureCompensationIndex(int i2);

    j2.q setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f4);

    j2.q setTorchStrengthLevel(@IntRange(from = 1) int i2);

    j2.q setZoomRatio(float f4);

    j2.q startFocusAndMetering(FocusMeteringAction focusMeteringAction);
}
