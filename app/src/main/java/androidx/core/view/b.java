package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements DifferentialMotionFlingController.FlingVelocityThresholdCalculator, DifferentialMotionFlingController.DifferentialVelocityProvider {
    @Override // androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator
    public void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i2) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, iArr, motionEvent, i2);
    }

    @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
    public float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i2);
    }
}
