package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f4, float f8) {
            return f8 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f4, float f8) {
            return Math.abs(f8) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f4) {
            this.mFriction = f4 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f4) {
            this.mVelocityThreshold = f4 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f4, float f8, long j) {
            this.mMassState.mVelocity = (float) (Math.exp((j / 1000.0f) * this.mFriction) * ((double) f8));
            DynamicAnimation.MassState massState = this.mMassState;
            float f9 = massState.mVelocity;
            float f10 = ((f9 - f8) / this.mFriction) + f4;
            massState.mValue = f10;
            if (isAtEquilibrium(f10, f9)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f4, float f8) {
        return this.mFlingForce.getAcceleration(f4, f8);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f4, float f8) {
        return f4 >= this.mMaxValue || f4 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f4, f8);
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f4);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f4) {
        this.mFlingForce.setValueThreshold(f4);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j) {
        DynamicAnimation.MassState massStateUpdateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j);
        float f4 = massStateUpdateValueAndVelocity.mValue;
        this.mValue = f4;
        float f8 = massStateUpdateValueAndVelocity.mVelocity;
        this.mVelocity = f8;
        float f9 = this.mMinValue;
        if (f4 < f9) {
            this.mValue = f9;
            return true;
        }
        float f10 = this.mMaxValue;
        if (f4 <= f10) {
            return isAtEquilibrium(f4, f8);
        }
        this.mValue = f10;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f4) {
        super.setMaxValue(f4);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f4) {
        super.setMinValue(f4);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f4) {
        super.setStartVelocity(f4);
        return this;
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
