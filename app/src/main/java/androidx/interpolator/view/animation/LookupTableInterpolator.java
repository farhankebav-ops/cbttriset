package androidx.interpolator.view.animation;

import a1.a;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f8 = this.mStepSize;
        float f9 = (f4 - (iMin * f8)) / f8;
        float[] fArr2 = this.mValues;
        float f10 = fArr2[iMin];
        return a.a(fArr2[iMin + 1], f10, f9, f10);
    }
}
