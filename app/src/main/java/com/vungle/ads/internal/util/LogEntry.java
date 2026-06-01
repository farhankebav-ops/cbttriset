package com.vungle.ads.internal.util;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LogEntry {
    private String adSource;
    private Boolean adoEnabled;
    private String creativeId;
    private String eventId;
    private String mediationName;
    private Boolean partialDownloadEnabled;
    private String placementRefId;
    private String vmVersion;

    private final int hashCode(String str) {
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!LogEntry.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type com.vungle.ads.internal.util.LogEntry");
        LogEntry logEntry = (LogEntry) obj;
        return k.a(this.placementRefId, logEntry.placementRefId) && k.a(this.creativeId, logEntry.creativeId) && k.a(this.eventId, logEntry.eventId) && k.a(this.adSource, logEntry.adSource) && k.a(this.mediationName, logEntry.mediationName) && k.a(this.vmVersion, logEntry.vmVersion) && k.a(this.partialDownloadEnabled, logEntry.partialDownloadEnabled) && k.a(this.adoEnabled, logEntry.adoEnabled);
    }

    public final String getAdSource$vungle_ads_release() {
        return this.adSource;
    }

    public final Boolean getAdoEnabled$vungle_ads_release() {
        return this.adoEnabled;
    }

    public final String getCreativeId$vungle_ads_release() {
        return this.creativeId;
    }

    public final String getEventId$vungle_ads_release() {
        return this.eventId;
    }

    public final String getMediationName$vungle_ads_release() {
        return this.mediationName;
    }

    public final Boolean getPartialDownloadEnabled$vungle_ads_release() {
        return this.partialDownloadEnabled;
    }

    public final String getPlacementRefId$vungle_ads_release() {
        return this.placementRefId;
    }

    public final String getVmVersion$vungle_ads_release() {
        return this.vmVersion;
    }

    public final void setAdSource$vungle_ads_release(String str) {
        this.adSource = str;
    }

    public final void setAdoEnabled$vungle_ads_release(Boolean bool) {
        this.adoEnabled = bool;
    }

    public final void setCreativeId$vungle_ads_release(String str) {
        this.creativeId = str;
    }

    public final void setEventId$vungle_ads_release(String str) {
        this.eventId = str;
    }

    public final void setMediationName$vungle_ads_release(String str) {
        this.mediationName = str;
    }

    public final void setPartialDownloadEnabled$vungle_ads_release(Boolean bool) {
        this.partialDownloadEnabled = bool;
    }

    public final void setPlacementRefId$vungle_ads_release(String str) {
        this.placementRefId = str;
    }

    public final void setVmVersion$vungle_ads_release(String str) {
        this.vmVersion = str;
    }

    public String toString() {
        return "LogEntry(placementRefId=" + this.placementRefId + ", creativeId=" + this.creativeId + ", eventId=" + this.eventId + ", adSource=" + this.adSource + ", mediationName=" + this.mediationName + ", vmVersion=" + this.vmVersion + ", partialDownloadEnabled=" + this.partialDownloadEnabled + ", adoEnabled=" + this.adoEnabled + ')';
    }

    public int hashCode() {
        int iHashCode = ((((((((((hashCode(this.placementRefId) * 31) + hashCode(this.creativeId)) * 31) + hashCode(this.eventId)) * 31) + hashCode(this.adSource)) * 31) + hashCode(this.mediationName)) * 31) + hashCode(this.vmVersion)) * 31;
        Boolean bool = this.partialDownloadEnabled;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.adoEnabled;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }
}
