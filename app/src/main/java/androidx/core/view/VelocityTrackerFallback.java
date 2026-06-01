package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i2 = this.mDataPointsBufferSize;
        if (i2 < 2) {
            return 0.0f;
        }
        int i8 = this.mDataPointsBufferLastUsedIndex;
        int i9 = ((i8 + 20) - (i2 - 1)) % 20;
        long j3 = this.mEventTimes[i8];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[i9];
            if (j3 - j <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i9 = (i9 + 1) % 20;
        }
        int i10 = this.mDataPointsBufferSize;
        if (i10 < 2) {
            return 0.0f;
        }
        if (i10 == 2) {
            int i11 = (i9 + 1) % 20;
            if (j == jArr[i11]) {
                return 0.0f;
            }
            return this.mMovements[i11] / (r2 - j);
        }
        float f4 = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < this.mDataPointsBufferSize - 1; i13++) {
            int i14 = i13 + i9;
            long[] jArr2 = this.mEventTimes;
            long j8 = jArr2[i14 % 20];
            int i15 = (i14 + 1) % 20;
            if (jArr2[i15] != j8) {
                i12++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f4);
                float f8 = this.mMovements[i15] / (this.mEventTimes[i15] - j8);
                float fAbs = (Math.abs(f8) * (f8 - fKineticEnergyToVelocity)) + f4;
                if (i12 == 1) {
                    fAbs *= 0.5f;
                }
                f4 = fAbs;
            }
        }
        return kineticEnergyToVelocity(f4);
    }

    private static float kineticEnergyToVelocity(float f4) {
        return (f4 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f4) * 2.0f));
    }

    public void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i2 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i2;
        int i8 = this.mDataPointsBufferSize;
        if (i8 != 20) {
            this.mDataPointsBufferSize = i8 + 1;
        }
        this.mMovements[i2] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i2) {
        computeCurrentVelocity(i2, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int i2) {
        if (i2 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i2, float f4) {
        float currentVelocity = getCurrentVelocity() * i2;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f4))) {
            this.mLastComputedVelocity = -Math.abs(f4);
        } else if (this.mLastComputedVelocity > Math.abs(f4)) {
            this.mLastComputedVelocity = Math.abs(f4);
        }
    }
}
