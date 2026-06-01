package androidx.camera.core;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusMeteringAction {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final long DEFAULT_AUTO_CANCEL_DURATION_MILLIS = 5000;
    static final int DEFAULT_METERING_MODE = 7;
    public static final int FLAG_AE = 2;
    public static final int FLAG_AF = 1;
    public static final int FLAG_AWB = 4;
    private final long mAutoCancelDurationInMillis;
    private final List<MeteringPoint> mMeteringPointsAe;
    private final List<MeteringPoint> mMeteringPointsAf;
    private final List<MeteringPoint> mMeteringPointsAwb;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        long mAutoCancelDurationInMillis;
        final List<MeteringPoint> mMeteringPointsAe;
        final List<MeteringPoint> mMeteringPointsAf;
        final List<MeteringPoint> mMeteringPointsAwb;

        public Builder(MeteringPoint meteringPoint) {
            this(meteringPoint, 7);
        }

        public Builder addPoint(MeteringPoint meteringPoint) {
            return addPoint(meteringPoint, 7);
        }

        public FocusMeteringAction build() {
            return new FocusMeteringAction(this);
        }

        public Builder disableAutoCancel() {
            this.mAutoCancelDurationInMillis = 0L;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder removePoints(int i2) {
            if ((i2 & 1) != 0) {
                this.mMeteringPointsAf.clear();
            }
            if ((i2 & 2) != 0) {
                this.mMeteringPointsAe.clear();
            }
            if ((i2 & 4) != 0) {
                this.mMeteringPointsAwb.clear();
            }
            return this;
        }

        public Builder setAutoCancelDuration(@IntRange(from = 1) long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(j >= 1, "autoCancelDuration must be at least 1");
            this.mAutoCancelDurationInMillis = timeUnit.toMillis(j);
            return this;
        }

        public Builder(MeteringPoint meteringPoint, int i2) {
            this.mMeteringPointsAf = new ArrayList();
            this.mMeteringPointsAe = new ArrayList();
            this.mMeteringPointsAwb = new ArrayList();
            this.mAutoCancelDurationInMillis = 5000L;
            addPoint(meteringPoint, i2);
        }

        public Builder addPoint(MeteringPoint meteringPoint, int i2) {
            boolean z2 = false;
            Preconditions.checkArgument(meteringPoint != null, "Point cannot be null.");
            if (i2 >= 1 && i2 <= 7) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Invalid metering mode " + i2);
            if ((i2 & 1) != 0) {
                this.mMeteringPointsAf.add(meteringPoint);
            }
            if ((i2 & 2) != 0) {
                this.mMeteringPointsAe.add(meteringPoint);
            }
            if ((i2 & 4) != 0) {
                this.mMeteringPointsAwb.add(meteringPoint);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder(FocusMeteringAction focusMeteringAction) {
            ArrayList arrayList = new ArrayList();
            this.mMeteringPointsAf = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mMeteringPointsAe = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.mMeteringPointsAwb = arrayList3;
            this.mAutoCancelDurationInMillis = 5000L;
            arrayList.addAll(focusMeteringAction.getMeteringPointsAf());
            arrayList2.addAll(focusMeteringAction.getMeteringPointsAe());
            arrayList3.addAll(focusMeteringAction.getMeteringPointsAwb());
            this.mAutoCancelDurationInMillis = focusMeteringAction.getAutoCancelDurationInMillis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface MeteringMode {
    }

    public FocusMeteringAction(Builder builder) {
        this.mMeteringPointsAf = Collections.unmodifiableList(builder.mMeteringPointsAf);
        this.mMeteringPointsAe = Collections.unmodifiableList(builder.mMeteringPointsAe);
        this.mMeteringPointsAwb = Collections.unmodifiableList(builder.mMeteringPointsAwb);
        this.mAutoCancelDurationInMillis = builder.mAutoCancelDurationInMillis;
    }

    public long getAutoCancelDurationInMillis() {
        return this.mAutoCancelDurationInMillis;
    }

    public List<MeteringPoint> getMeteringPointsAe() {
        return this.mMeteringPointsAe;
    }

    public List<MeteringPoint> getMeteringPointsAf() {
        return this.mMeteringPointsAf;
    }

    public List<MeteringPoint> getMeteringPointsAwb() {
        return this.mMeteringPointsAwb;
    }

    public boolean isAutoCancelEnabled() {
        return this.mAutoCancelDurationInMillis > 0;
    }
}
