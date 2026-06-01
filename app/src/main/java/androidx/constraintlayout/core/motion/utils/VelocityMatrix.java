package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String sTag = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f4, float f8, int i2, int i8, float[] fArr) {
        float f9 = fArr[0];
        float f10 = fArr[1];
        float f11 = (f4 - 0.5f) * 2.0f;
        float f12 = (f8 - 0.5f) * 2.0f;
        float f13 = f9 + this.mDTranslateX;
        float f14 = f10 + this.mDTranslateY;
        float f15 = (this.mDScaleX * f11) + f13;
        float f16 = (this.mDScaleY * f12) + f14;
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d8 = radians;
        double d9 = i8 * f12;
        float fSin = (((float) ((Math.sin(d8) * ((double) ((-i2) * f11))) - (Math.cos(d8) * d9))) * radians2) + f15;
        float fCos = (radians2 * ((float) ((Math.cos(d8) * ((double) (i2 * f11))) - (Math.sin(d8) * d9)))) + f16;
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f4) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f4);
            this.mRotate = splineSet.get(f4);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f4);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f4) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f4);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator != null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 != null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f4);
        }
    }
}
