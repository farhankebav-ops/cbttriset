package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f4) {
        this.mDone = false;
        float f8 = this.mStage1Duration;
        if (f4 <= f8) {
            float f9 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f9) * f4) * f4) / (f8 * 2.0f)) + (f9 * f4);
        }
        int i2 = this.mNumberOfStages;
        if (i2 == 1) {
            return this.mStage1EndPosition;
        }
        float f10 = f4 - f8;
        float f11 = this.mStage2Duration;
        if (f10 < f11) {
            float f12 = this.mStage1EndPosition;
            float f13 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f13) * f10) * f10) / (f11 * 2.0f)) + (f13 * f10) + f12;
        }
        if (i2 == 2) {
            return this.mStage2EndPosition;
        }
        float f14 = f10 - f11;
        float f15 = this.mStage3Duration;
        if (f14 > f15) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f16 = this.mStage2EndPosition;
        float f17 = this.mStage3Velocity;
        return ((f17 * f14) + f16) - (((f17 * f14) * f14) / (f15 * 2.0f));
    }

    private void setup(float f4, float f8, float f9, float f10, float f11) {
        this.mDone = false;
        this.mStage3EndPosition = f8;
        if (f4 == 0.0f) {
            f4 = 1.0E-4f;
        }
        float f12 = f4 / f9;
        float f13 = (f12 * f4) / 2.0f;
        if (f4 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f8 - ((((-f4) / f9) * f4) / 2.0f)) * f9);
            if (fSqrt < f10) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f4;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f14 = (fSqrt - f4) / f9;
                this.mStage1Duration = f14;
                this.mStage2Duration = fSqrt / f9;
                this.mStage1EndPosition = ((f4 + fSqrt) * f14) / 2.0f;
                this.mStage2EndPosition = f8;
                this.mStage3EndPosition = f8;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = f10;
            this.mStage3Velocity = f10;
            float f15 = (f10 - f4) / f9;
            this.mStage1Duration = f15;
            float f16 = f10 / f9;
            this.mStage3Duration = f16;
            float f17 = ((f4 + f10) * f15) / 2.0f;
            float f18 = (f16 * f10) / 2.0f;
            this.mStage2Duration = ((f8 - f17) - f18) / f10;
            this.mStage1EndPosition = f17;
            this.mStage2EndPosition = f8 - f18;
            this.mStage3EndPosition = f8;
            return;
        }
        if (f13 >= f8) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f8;
            this.mStage1Duration = (2.0f * f8) / f4;
            return;
        }
        float f19 = f8 - f13;
        float f20 = f19 / f4;
        if (f20 + f12 < f11) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = f4;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f19;
            this.mStage2EndPosition = f8;
            this.mStage1Duration = f20;
            this.mStage2Duration = f12;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f4 * f4) / 2.0f) + (f9 * f8));
        float f21 = (fSqrt2 - f4) / f9;
        this.mStage1Duration = f21;
        float f22 = fSqrt2 / f9;
        this.mStage2Duration = f22;
        if (fSqrt2 < f10) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f4;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f21;
            this.mStage2Duration = f22;
            this.mStage1EndPosition = ((f4 + fSqrt2) * f21) / 2.0f;
            this.mStage2EndPosition = f8;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f4;
        this.mStage2Velocity = f10;
        this.mStage3Velocity = f10;
        float f23 = (f10 - f4) / f9;
        this.mStage1Duration = f23;
        float f24 = f10 / f9;
        this.mStage3Duration = f24;
        float f25 = ((f4 + f10) * f23) / 2.0f;
        float f26 = (f24 * f10) / 2.0f;
        this.mStage2Duration = ((f8 - f25) - f26) / f10;
        this.mStage1EndPosition = f25;
        this.mStage2EndPosition = f8 - f26;
        this.mStage3EndPosition = f8;
    }

    public void config(float f4, float f8, float f9, float f10, float f11, float f12) {
        this.mDone = false;
        this.mStartPosition = f4;
        boolean z2 = f4 > f8;
        this.mBackwards = z2;
        if (z2) {
            setup(-f9, f4 - f8, f11, f12, f10);
        } else {
            setup(f9, f8 - f4, f11, f12, f10);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f4) {
        StringBuilder sbX = a1.a.x(a1.a.r(a1.a.x(str, " ===== "), this.mType, "\n"), str);
        sbX.append(this.mBackwards ? "backwards" : "forward ");
        sbX.append(" time = ");
        sbX.append(f4);
        sbX.append("  stages ");
        String str2 = a1.a.q(sbX, "\n", this.mNumberOfStages) + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str2 = str2 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str2 = str2 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f8 = this.mStage1Duration;
        if (f4 <= f8) {
            return a1.a.D(str2, str, "stage 0\n");
        }
        int i2 = this.mNumberOfStages;
        if (i2 == 1) {
            return a1.a.D(str2, str, "end stage 0\n");
        }
        float f9 = f4 - f8;
        float f10 = this.mStage2Duration;
        return f9 < f10 ? a1.a.D(str2, str, " stage 1\n") : i2 == 2 ? a1.a.D(str2, str, "end stage 1\n") : f9 - f10 < this.mStage3Duration ? a1.a.D(str2, str, " stage 2\n") : a1.a.D(str2, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f4) {
        float fCalcY = calcY(f4);
        this.mLastPosition = fCalcY;
        this.mLastTime = f4;
        return this.mBackwards ? this.mStartPosition - fCalcY : this.mStartPosition + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f4) {
        float f8;
        float f9;
        float f10 = this.mStage1Duration;
        if (f4 <= f10) {
            f8 = this.mStage1Velocity;
            f9 = this.mStage2Velocity;
        } else {
            int i2 = this.mNumberOfStages;
            if (i2 == 1) {
                return 0.0f;
            }
            f4 -= f10;
            f10 = this.mStage2Duration;
            if (f4 >= f10) {
                if (i2 == 2) {
                    return 0.0f;
                }
                float f11 = f4 - f10;
                float f12 = this.mStage3Duration;
                if (f11 >= f12) {
                    return 0.0f;
                }
                float f13 = this.mStage3Velocity;
                return f13 - ((f11 * f13) / f12);
            }
            f8 = this.mStage2Velocity;
            f9 = this.mStage3Velocity;
        }
        return (((f9 - f8) * f4) / f10) + f8;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f4, float f8, float f9) {
            this.mDone = false;
            this.mDestination = f8;
            this.mInitialVelocity = f9;
            this.mInitialPos = f4;
            float f10 = (f8 - f4) / (f9 / 2.0f);
            this.mDuration = f10;
            this.mAcceleration = (-f9) / f10;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public String debug(String str, float f4) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f4) {
            if (f4 > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f4);
            return ((((this.mAcceleration * f4) / 2.0f) + this.mInitialVelocity) * f4) + this.mInitialPos;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity(float f4) {
            if (f4 > this.mDuration) {
                return 0.0f;
            }
            float f8 = (this.mAcceleration * f4) + this.mInitialVelocity;
            this.mLastVelocity = f8;
            return f8;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean isStopped() {
            return this.mDone;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity() {
            return this.mLastVelocity;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }
}
