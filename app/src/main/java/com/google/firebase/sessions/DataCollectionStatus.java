package com.google.firebase.sessions;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class DataCollectionStatus {
    private final DataCollectionState crashlytics;
    private final DataCollectionState performance;
    private final double sessionSamplingRate;

    public DataCollectionStatus() {
        this(null, null, 0.0d, 7, null);
    }

    public static /* synthetic */ DataCollectionStatus copy$default(DataCollectionStatus dataCollectionStatus, DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dataCollectionState = dataCollectionStatus.performance;
        }
        if ((i2 & 2) != 0) {
            dataCollectionState2 = dataCollectionStatus.crashlytics;
        }
        if ((i2 & 4) != 0) {
            d8 = dataCollectionStatus.sessionSamplingRate;
        }
        return dataCollectionStatus.copy(dataCollectionState, dataCollectionState2, d8);
    }

    public final DataCollectionState component1() {
        return this.performance;
    }

    public final DataCollectionState component2() {
        return this.crashlytics;
    }

    public final double component3() {
        return this.sessionSamplingRate;
    }

    public final DataCollectionStatus copy(DataCollectionState performance, DataCollectionState crashlytics, double d8) {
        k.e(performance, "performance");
        k.e(crashlytics, "crashlytics");
        return new DataCollectionStatus(performance, crashlytics, d8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        return this.performance == dataCollectionStatus.performance && this.crashlytics == dataCollectionStatus.crashlytics && Double.compare(this.sessionSamplingRate, dataCollectionStatus.sessionSamplingRate) == 0;
    }

    public final DataCollectionState getCrashlytics() {
        return this.crashlytics;
    }

    public final DataCollectionState getPerformance() {
        return this.performance;
    }

    public final double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public int hashCode() {
        int iHashCode = (this.crashlytics.hashCode() + (this.performance.hashCode() * 31)) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.sessionSamplingRate);
        return iHashCode + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.performance + ", crashlytics=" + this.crashlytics + ", sessionSamplingRate=" + this.sessionSamplingRate + ')';
    }

    public DataCollectionStatus(DataCollectionState performance, DataCollectionState crashlytics, double d8) {
        k.e(performance, "performance");
        k.e(crashlytics, "crashlytics");
        this.performance = performance;
        this.crashlytics = crashlytics;
        this.sessionSamplingRate = d8;
    }

    public /* synthetic */ DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d8, int i2, f fVar) {
        this((i2 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i2 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i2 & 4) != 0 ? 1.0d : d8);
    }
}
