package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d8) {
        if (d8 <= 0.0d) {
            return;
        }
        double d9 = this.mStiffness;
        double d10 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d9 / ((double) this.mMass)) * d8) * 4.0d)) + 1.0d);
        double d11 = d8 / ((double) iSqrt);
        int i2 = 0;
        while (i2 < iSqrt) {
            float f4 = this.mPos;
            double d12 = this.mTargetPos;
            float f8 = this.mV;
            double d13 = d9;
            double d14 = ((-d9) * (((double) f4) - d12)) - (((double) f8) * d10);
            float f9 = this.mMass;
            double d15 = d10;
            double d16 = (((d14 / ((double) f9)) * d11) / 2.0d) + ((double) f8);
            double d17 = ((((-((((d11 * d16) / 2.0d) + ((double) f4)) - d12)) * d13) - (d16 * d15)) / ((double) f9)) * d11;
            double d18 = (d17 / 2.0d) + ((double) f8);
            float f10 = f8 + ((float) d17);
            this.mV = f10;
            float f11 = f4 + ((float) (d18 * d11));
            this.mPos = f11;
            int i8 = this.mBoundaryMode;
            if (i8 > 0) {
                if (f11 < 0.0f && (i8 & 1) == 1) {
                    this.mPos = -f11;
                    this.mV = -f10;
                }
                float f12 = this.mPos;
                if (f12 > 1.0f && (i8 & 2) == 2) {
                    this.mPos = 2.0f - f12;
                    this.mV = -this.mV;
                }
            }
            i2++;
            d9 = d13;
            d10 = d15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f4) {
        return null;
    }

    public float getAcceleration() {
        double d8 = this.mStiffness;
        return ((float) (((-d8) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f4) {
        compute(f4 - this.mLastTime);
        this.mLastTime = f4;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d8 = ((double) this.mPos) - this.mTargetPos;
        double d9 = this.mStiffness;
        double d10 = this.mV;
        return Math.sqrt((((d9 * d8) * d8) + ((d10 * d10) * ((double) this.mMass))) / d9) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f4, float f8, float f9, float f10, float f11, float f12, float f13, int i2) {
        this.mTargetPos = f8;
        this.mDamping = f12;
        this.mInitialized = false;
        this.mPos = f4;
        this.mLastVelocity = f9;
        this.mStiffness = f11;
        this.mMass = f10;
        this.mStopThreshold = f13;
        this.mBoundaryMode = i2;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f4) {
        return this.mV;
    }
}
