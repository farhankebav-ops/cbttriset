package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {
    private final String buildVersion;
    private final boolean jailbroken;
    private final int platform;
    private final String version;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {
        private String buildVersion;
        private boolean jailbroken;
        private int platform;
        private byte set$0;
        private String version;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem build() {
            String str;
            String str2;
            if (this.set$0 == 3 && (str = this.version) != null && (str2 = this.buildVersion) != null) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform, str, str2, this.jailbroken);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.set$0 & 1) == 0) {
                sb.append(" platform");
            }
            if (this.version == null) {
                sb.append(" version");
            }
            if (this.buildVersion == null) {
                sb.append(" buildVersion");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException(a.i(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.buildVersion = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z2) {
            this.jailbroken = z2;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i2) {
            this.platform = i2;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.version = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.OperatingSystem) {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            if (this.platform == operatingSystem.getPlatform() && this.version.equals(operatingSystem.getVersion()) && this.buildVersion.equals(operatingSystem.getBuildVersion()) && this.jailbroken == operatingSystem.isJailbroken()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    @NonNull
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return ((((((this.platform ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ (this.jailbroken ? 1231 : 1237);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean isJailbroken() {
        return this.jailbroken;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OperatingSystem{platform=");
        sb.append(this.platform);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", buildVersion=");
        sb.append(this.buildVersion);
        sb.append(", jailbroken=");
        return a1.a.u(sb, this.jailbroken, "}");
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i2, String str, String str2, boolean z2) {
        this.platform = i2;
        this.version = str;
        this.buildVersion = str2;
        this.jailbroken = z2;
    }
}
