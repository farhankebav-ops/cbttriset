package com.unity3d.ads.adplayer;

import a1.a;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidShowOptions implements ShowOptions {
    private final boolean isOfferwallAd;
    private final boolean isScarAd;
    private final String offerwallPlacementName;
    private final String placementId;
    private final String scarAdString;
    private final String scarAdUnitId;
    private final String scarQueryId;
    private final Map<String, Object> unityAdsShowOptions;

    public AndroidShowOptions(Map<String, ? extends Object> map, String str, boolean z2, String str2, String str3, String str4, boolean z7, String str5) {
        this.unityAdsShowOptions = map;
        this.placementId = str;
        this.isScarAd = z2;
        this.scarQueryId = str2;
        this.scarAdString = str3;
        this.scarAdUnitId = str4;
        this.isOfferwallAd = z7;
        this.offerwallPlacementName = str5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AndroidShowOptions copy$default(AndroidShowOptions androidShowOptions, Map map, String str, boolean z2, String str2, String str3, String str4, boolean z7, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = androidShowOptions.unityAdsShowOptions;
        }
        if ((i2 & 2) != 0) {
            str = androidShowOptions.placementId;
        }
        if ((i2 & 4) != 0) {
            z2 = androidShowOptions.isScarAd;
        }
        if ((i2 & 8) != 0) {
            str2 = androidShowOptions.scarQueryId;
        }
        if ((i2 & 16) != 0) {
            str3 = androidShowOptions.scarAdString;
        }
        if ((i2 & 32) != 0) {
            str4 = androidShowOptions.scarAdUnitId;
        }
        if ((i2 & 64) != 0) {
            z7 = androidShowOptions.isOfferwallAd;
        }
        if ((i2 & 128) != 0) {
            str5 = androidShowOptions.offerwallPlacementName;
        }
        boolean z8 = z7;
        String str6 = str5;
        String str7 = str3;
        String str8 = str4;
        return androidShowOptions.copy(map, str, z2, str2, str7, str8, z8, str6);
    }

    public final Map<String, Object> component1() {
        return this.unityAdsShowOptions;
    }

    public final String component2() {
        return this.placementId;
    }

    public final boolean component3() {
        return this.isScarAd;
    }

    public final String component4() {
        return this.scarQueryId;
    }

    public final String component5() {
        return this.scarAdString;
    }

    public final String component6() {
        return this.scarAdUnitId;
    }

    public final boolean component7() {
        return this.isOfferwallAd;
    }

    public final String component8() {
        return this.offerwallPlacementName;
    }

    public final AndroidShowOptions copy(Map<String, ? extends Object> map, String str, boolean z2, String str2, String str3, String str4, boolean z7, String str5) {
        return new AndroidShowOptions(map, str, z2, str2, str3, str4, z7, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidShowOptions)) {
            return false;
        }
        AndroidShowOptions androidShowOptions = (AndroidShowOptions) obj;
        return k.a(this.unityAdsShowOptions, androidShowOptions.unityAdsShowOptions) && k.a(this.placementId, androidShowOptions.placementId) && this.isScarAd == androidShowOptions.isScarAd && k.a(this.scarQueryId, androidShowOptions.scarQueryId) && k.a(this.scarAdString, androidShowOptions.scarAdString) && k.a(this.scarAdUnitId, androidShowOptions.scarAdUnitId) && this.isOfferwallAd == androidShowOptions.isOfferwallAd && k.a(this.offerwallPlacementName, androidShowOptions.offerwallPlacementName);
    }

    public final String getOfferwallPlacementName() {
        return this.offerwallPlacementName;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getScarAdString() {
        return this.scarAdString;
    }

    public final String getScarAdUnitId() {
        return this.scarAdUnitId;
    }

    public final String getScarQueryId() {
        return this.scarQueryId;
    }

    public final Map<String, Object> getUnityAdsShowOptions() {
        return this.unityAdsShowOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Map<String, Object> map = this.unityAdsShowOptions;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        String str = this.placementId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z2 = this.isScarAd;
        ?? r22 = z2;
        if (z2) {
            r22 = 1;
        }
        int i2 = (iHashCode2 + r22) * 31;
        String str2 = this.scarQueryId;
        int iHashCode3 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scarAdString;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scarAdUnitId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z7 = this.isOfferwallAd;
        int i8 = (iHashCode5 + (z7 ? 1 : z7)) * 31;
        String str5 = this.offerwallPlacementName;
        return i8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isOfferwallAd() {
        return this.isOfferwallAd;
    }

    public final boolean isScarAd() {
        return this.isScarAd;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AndroidShowOptions(unityAdsShowOptions=");
        sb.append(this.unityAdsShowOptions);
        sb.append(", placementId=");
        sb.append(this.placementId);
        sb.append(", isScarAd=");
        sb.append(this.isScarAd);
        sb.append(", scarQueryId=");
        sb.append(this.scarQueryId);
        sb.append(", scarAdString=");
        sb.append(this.scarAdString);
        sb.append(", scarAdUnitId=");
        sb.append(this.scarAdUnitId);
        sb.append(", isOfferwallAd=");
        sb.append(this.isOfferwallAd);
        sb.append(", offerwallPlacementName=");
        return a.e(')', this.offerwallPlacementName, sb);
    }

    public /* synthetic */ AndroidShowOptions(Map map, String str, boolean z2, String str2, String str3, String str4, boolean z7, String str5, int i2, f fVar) {
        this(map, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? false : z7, (i2 & 128) != 0 ? null : str5);
    }
}
