package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OMData {
    private final String partnerName;
    private final String partnerVersion;
    private final String version;

    public OMData(String version, String partnerName, String partnerVersion) {
        k.e(version, "version");
        k.e(partnerName, "partnerName");
        k.e(partnerVersion, "partnerVersion");
        this.version = version;
        this.partnerName = partnerName;
        this.partnerVersion = partnerVersion;
    }

    public static /* synthetic */ OMData copy$default(OMData oMData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = oMData.version;
        }
        if ((i2 & 2) != 0) {
            str2 = oMData.partnerName;
        }
        if ((i2 & 4) != 0) {
            str3 = oMData.partnerVersion;
        }
        return oMData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.partnerName;
    }

    public final String component3() {
        return this.partnerVersion;
    }

    public final OMData copy(String version, String partnerName, String partnerVersion) {
        k.e(version, "version");
        k.e(partnerName, "partnerName");
        k.e(partnerVersion, "partnerVersion");
        return new OMData(version, partnerName, partnerVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OMData)) {
            return false;
        }
        OMData oMData = (OMData) obj;
        return k.a(this.version, oMData.version) && k.a(this.partnerName, oMData.partnerName) && k.a(this.partnerVersion, oMData.partnerVersion);
    }

    public final String getPartnerName() {
        return this.partnerName;
    }

    public final String getPartnerVersion() {
        return this.partnerVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.partnerVersion.hashCode() + a.b(this.version.hashCode() * 31, 31, this.partnerName);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OMData(version=");
        sb.append(this.version);
        sb.append(", partnerName=");
        sb.append(this.partnerName);
        sb.append(", partnerVersion=");
        return a1.a.e(')', this.partnerVersion, sb);
    }
}
