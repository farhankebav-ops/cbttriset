package androidx.camera.core.impl.utils;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j, long j3) {
        this.mNumerator = j;
        this.mDenominator = j3;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }

    public LongRational(double d8) {
        this((long) (d8 * 10000.0d), WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
