package com.google.firebase.sessions;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationInfo {
    private final AndroidApplicationInfo androidAppInfo;
    private final String appId;
    private final String deviceModel;
    private final LogEnvironment logEnvironment;
    private final String osVersion;
    private final String sessionSdkVersion;

    public ApplicationInfo(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        k.e(appId, "appId");
        k.e(deviceModel, "deviceModel");
        k.e(sessionSdkVersion, "sessionSdkVersion");
        k.e(osVersion, "osVersion");
        k.e(logEnvironment, "logEnvironment");
        k.e(androidAppInfo, "androidAppInfo");
        this.appId = appId;
        this.deviceModel = deviceModel;
        this.sessionSdkVersion = sessionSdkVersion;
        this.osVersion = osVersion;
        this.logEnvironment = logEnvironment;
        this.androidAppInfo = androidAppInfo;
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = applicationInfo.appId;
        }
        if ((i2 & 2) != 0) {
            str2 = applicationInfo.deviceModel;
        }
        if ((i2 & 4) != 0) {
            str3 = applicationInfo.sessionSdkVersion;
        }
        if ((i2 & 8) != 0) {
            str4 = applicationInfo.osVersion;
        }
        if ((i2 & 16) != 0) {
            logEnvironment = applicationInfo.logEnvironment;
        }
        if ((i2 & 32) != 0) {
            androidApplicationInfo = applicationInfo.androidAppInfo;
        }
        LogEnvironment logEnvironment2 = logEnvironment;
        AndroidApplicationInfo androidApplicationInfo2 = androidApplicationInfo;
        return applicationInfo.copy(str, str2, str3, str4, logEnvironment2, androidApplicationInfo2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.deviceModel;
    }

    public final String component3() {
        return this.sessionSdkVersion;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final LogEnvironment component5() {
        return this.logEnvironment;
    }

    public final AndroidApplicationInfo component6() {
        return this.androidAppInfo;
    }

    public final ApplicationInfo copy(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        k.e(appId, "appId");
        k.e(deviceModel, "deviceModel");
        k.e(sessionSdkVersion, "sessionSdkVersion");
        k.e(osVersion, "osVersion");
        k.e(logEnvironment, "logEnvironment");
        k.e(androidAppInfo, "androidAppInfo");
        return new ApplicationInfo(appId, deviceModel, sessionSdkVersion, osVersion, logEnvironment, androidAppInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        return k.a(this.appId, applicationInfo.appId) && k.a(this.deviceModel, applicationInfo.deviceModel) && k.a(this.sessionSdkVersion, applicationInfo.sessionSdkVersion) && k.a(this.osVersion, applicationInfo.osVersion) && this.logEnvironment == applicationInfo.logEnvironment && k.a(this.androidAppInfo, applicationInfo.androidAppInfo);
    }

    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.androidAppInfo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final LogEnvironment getLogEnvironment() {
        return this.logEnvironment;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSessionSdkVersion() {
        return this.sessionSdkVersion;
    }

    public int hashCode() {
        return this.androidAppInfo.hashCode() + ((this.logEnvironment.hashCode() + androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b(this.appId.hashCode() * 31, 31, this.deviceModel), 31, this.sessionSdkVersion), 31, this.osVersion)) * 31);
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", sessionSdkVersion=" + this.sessionSdkVersion + ", osVersion=" + this.osVersion + ", logEnvironment=" + this.logEnvironment + ", androidAppInfo=" + this.androidAppInfo + ')';
    }
}
