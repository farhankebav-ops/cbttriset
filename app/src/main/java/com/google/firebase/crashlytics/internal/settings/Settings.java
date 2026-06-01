package com.google.firebase.crashlytics.internal.settings;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z2, boolean z7, boolean z8) {
            this.collectReports = z2;
            this.collectAnrs = z7;
            this.collectBuildIds = z8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i2, int i8) {
            this.maxCustomExceptionEvents = i2;
            this.maxCompleteSessionsCount = i8;
        }
    }

    public Settings(long j, SessionData sessionData, FeatureFlagData featureFlagData, int i2, int i8, double d8, double d9, int i9) {
        this.expiresAtMillis = j;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i2;
        this.cacheDuration = i8;
        this.onDemandUploadRatePerMinute = d8;
        this.onDemandBackoffBase = d9;
        this.onDemandBackoffStepDurationSeconds = i9;
    }

    public boolean isExpired(long j) {
        return this.expiresAtMillis < j;
    }
}
