package androidx.transition;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f4) {
        return (float) (Math.sqrt(Math.abs(f4) * 2.0f) * ((double) Math.signum(f4)));
    }

    public void addDataPoint(long j, float f4) {
        int i2 = (this.mIndex + 1) % 20;
        this.mIndex = i2;
        this.mTimeSamples[i2] = j;
        this.mDataSamples[i2] = f4;
    }

    public float calculateVelocity() {
        float fKineticEnergyToVelocity;
        int i2 = this.mIndex;
        if (i2 == 0 && this.mTimeSamples[i2] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j = this.mTimeSamples[i2];
        int i8 = 0;
        long j3 = j;
        while (true) {
            long j8 = this.mTimeSamples[i2];
            if (j8 == Long.MIN_VALUE) {
                break;
            }
            float f4 = j - j8;
            float fAbs = Math.abs(j8 - j3);
            if (f4 > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i2 == 0) {
                i2 = 20;
            }
            i2--;
            i8++;
            if (i8 >= 20) {
                break;
            }
            j3 = j8;
        }
        if (i8 < 2) {
            return 0.0f;
        }
        if (i8 == 2) {
            int i9 = this.mIndex;
            int i10 = i9 == 0 ? 19 : i9 - 1;
            long[] jArr = this.mTimeSamples;
            float f8 = jArr[i9] - jArr[i10];
            if (f8 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            fKineticEnergyToVelocity = (fArr[i9] - fArr[i10]) / f8;
        } else {
            int i11 = this.mIndex;
            int i12 = ((i11 - i8) + 21) % 20;
            int i13 = (i11 + 21) % 20;
            long j9 = this.mTimeSamples[i12];
            float f9 = this.mDataSamples[i12];
            int i14 = i12 + 1;
            float f10 = 0.0f;
            for (int i15 = i14 % 20; i15 != i13; i15 = (i15 + 1) % 20) {
                long j10 = this.mTimeSamples[i15];
                float f11 = j10 - j9;
                if (f11 != 0.0f) {
                    float f12 = this.mDataSamples[i15];
                    float f13 = (f12 - f9) / f11;
                    float fAbs2 = (Math.abs(f13) * (f13 - kineticEnergyToVelocity(f10))) + f10;
                    if (i15 == i14) {
                        fAbs2 *= 0.5f;
                    }
                    f10 = fAbs2;
                    f9 = f12;
                    j9 = j10;
                }
            }
            fKineticEnergyToVelocity = kineticEnergyToVelocity(f10);
        }
        return fKineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
