package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {
    private final Double batteryLevel;
    private final int batteryVelocity;
    private final long diskUsed;
    private final int orientation;
    private final boolean proximityOn;
    private final long ramUsed;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {
        private Double batteryLevel;
        private int batteryVelocity;
        private long diskUsed;
        private int orientation;
        private boolean proximityOn;
        private long ramUsed;
        private byte set$0;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device build() {
            if (this.set$0 == 31) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.batteryLevel, this.batteryVelocity, this.proximityOn, this.orientation, this.ramUsed, this.diskUsed);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.set$0 & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.set$0 & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.set$0 & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.set$0 & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException(a.i(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d8) {
            this.batteryLevel = d8;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i2) {
            this.batteryVelocity = i2;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j) {
            this.diskUsed = j;
            this.set$0 = (byte) (this.set$0 | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i2) {
            this.orientation = i2;
            this.set$0 = (byte) (this.set$0 | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z2) {
            this.proximityOn = z2;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j) {
            this.ramUsed = j;
            this.set$0 = (byte) (this.set$0 | 8);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Device) {
            CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
            Double d8 = this.batteryLevel;
            if (d8 != null ? d8.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
                if (this.batteryVelocity == device.getBatteryVelocity() && this.proximityOn == device.isProximityOn() && this.orientation == device.getOrientation() && this.ramUsed == device.getRamUsed() && this.diskUsed == device.getDiskUsed()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    @Nullable
    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getDiskUsed() {
        return this.diskUsed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long getRamUsed() {
        return this.ramUsed;
    }

    public int hashCode() {
        Double d8 = this.batteryLevel;
        int iHashCode = ((((((((d8 == null ? 0 : d8.hashCode()) ^ 1000003) * 1000003) ^ this.batteryVelocity) * 1000003) ^ (this.proximityOn ? 1231 : 1237)) * 1000003) ^ this.orientation) * 1000003;
        long j = this.ramUsed;
        long j3 = this.diskUsed;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public boolean isProximityOn() {
        return this.proximityOn;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Device{batteryLevel=");
        sb.append(this.batteryLevel);
        sb.append(", batteryVelocity=");
        sb.append(this.batteryVelocity);
        sb.append(", proximityOn=");
        sb.append(this.proximityOn);
        sb.append(", orientation=");
        sb.append(this.orientation);
        sb.append(", ramUsed=");
        sb.append(this.ramUsed);
        sb.append(", diskUsed=");
        return a1.a.p(sb, this.diskUsed, "}");
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(@Nullable Double d8, int i2, boolean z2, int i8, long j, long j3) {
        this.batteryLevel = d8;
        this.batteryVelocity = i2;
        this.proximityOn = z2;
        this.orientation = i8;
        this.ramUsed = j;
        this.diskUsed = j3;
    }
}
