package com.unity3d.ads.core.data.model;

import androidx.camera.core.processing.util.a;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdObject {
    private final AdPlayer adPlayer;
    private final DiagnosticEventRequestOuterClass.DiagnosticAdType adType;
    private final boolean isHeaderBidding;
    private boolean isOfferwallAd;
    private boolean isScarAd;
    private final UnityAdsLoadOptions loadOptions;
    private String offerwallPlacementName;
    private final ByteString opportunityId;
    private final String placementId;
    private String playerServerId;
    private String scarAdString;
    private String scarAdUnitId;
    private String scarQueryId;
    private q0 state;
    private ByteString trackingToken;
    private q0 ttl;

    public AdObject(ByteString opportunityId, String placementId, ByteString trackingToken, boolean z2, String str, String str2, String str3, boolean z7, String str4, AdPlayer adPlayer, String str5, UnityAdsLoadOptions loadOptions, boolean z8, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, q0 ttl, q0 state) {
        k.e(opportunityId, "opportunityId");
        k.e(placementId, "placementId");
        k.e(trackingToken, "trackingToken");
        k.e(loadOptions, "loadOptions");
        k.e(adType, "adType");
        k.e(ttl, "ttl");
        k.e(state, "state");
        this.opportunityId = opportunityId;
        this.placementId = placementId;
        this.trackingToken = trackingToken;
        this.isScarAd = z2;
        this.scarQueryId = str;
        this.scarAdUnitId = str2;
        this.scarAdString = str3;
        this.isOfferwallAd = z7;
        this.offerwallPlacementName = str4;
        this.adPlayer = adPlayer;
        this.playerServerId = str5;
        this.loadOptions = loadOptions;
        this.isHeaderBidding = z8;
        this.adType = adType;
        this.ttl = ttl;
        this.state = state;
    }

    public final ByteString component1() {
        return this.opportunityId;
    }

    public final AdPlayer component10() {
        return this.adPlayer;
    }

    public final String component11() {
        return this.playerServerId;
    }

    public final UnityAdsLoadOptions component12() {
        return this.loadOptions;
    }

    public final boolean component13() {
        return this.isHeaderBidding;
    }

    public final DiagnosticEventRequestOuterClass.DiagnosticAdType component14() {
        return this.adType;
    }

    public final q0 component15() {
        return this.ttl;
    }

    public final q0 component16() {
        return this.state;
    }

    public final String component2() {
        return this.placementId;
    }

    public final ByteString component3() {
        return this.trackingToken;
    }

    public final boolean component4() {
        return this.isScarAd;
    }

    public final String component5() {
        return this.scarQueryId;
    }

    public final String component6() {
        return this.scarAdUnitId;
    }

    public final String component7() {
        return this.scarAdString;
    }

    public final boolean component8() {
        return this.isOfferwallAd;
    }

    public final String component9() {
        return this.offerwallPlacementName;
    }

    public final AdObject copy(ByteString opportunityId, String placementId, ByteString trackingToken, boolean z2, String str, String str2, String str3, boolean z7, String str4, AdPlayer adPlayer, String str5, UnityAdsLoadOptions loadOptions, boolean z8, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, q0 ttl, q0 state) {
        k.e(opportunityId, "opportunityId");
        k.e(placementId, "placementId");
        k.e(trackingToken, "trackingToken");
        k.e(loadOptions, "loadOptions");
        k.e(adType, "adType");
        k.e(ttl, "ttl");
        k.e(state, "state");
        return new AdObject(opportunityId, placementId, trackingToken, z2, str, str2, str3, z7, str4, adPlayer, str5, loadOptions, z8, adType, ttl, state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdObject)) {
            return false;
        }
        AdObject adObject = (AdObject) obj;
        return k.a(this.opportunityId, adObject.opportunityId) && k.a(this.placementId, adObject.placementId) && k.a(this.trackingToken, adObject.trackingToken) && this.isScarAd == adObject.isScarAd && k.a(this.scarQueryId, adObject.scarQueryId) && k.a(this.scarAdUnitId, adObject.scarAdUnitId) && k.a(this.scarAdString, adObject.scarAdString) && this.isOfferwallAd == adObject.isOfferwallAd && k.a(this.offerwallPlacementName, adObject.offerwallPlacementName) && k.a(this.adPlayer, adObject.adPlayer) && k.a(this.playerServerId, adObject.playerServerId) && k.a(this.loadOptions, adObject.loadOptions) && this.isHeaderBidding == adObject.isHeaderBidding && this.adType == adObject.adType && k.a(this.ttl, adObject.ttl) && k.a(this.state, adObject.state);
    }

    public final AdPlayer getAdPlayer() {
        return this.adPlayer;
    }

    public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.adType;
    }

    public final UnityAdsLoadOptions getLoadOptions() {
        return this.loadOptions;
    }

    public final String getOfferwallPlacementName() {
        return this.offerwallPlacementName;
    }

    public final ByteString getOpportunityId() {
        return this.opportunityId;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getPlayerServerId() {
        return this.playerServerId;
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

    public final q0 getState() {
        return this.state;
    }

    public final ByteString getTrackingToken() {
        return this.trackingToken;
    }

    public final q0 getTtl() {
        return this.ttl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = (this.trackingToken.hashCode() + a.b(this.opportunityId.hashCode() * 31, 31, this.placementId)) * 31;
        boolean z2 = this.isScarAd;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = (iHashCode + r02) * 31;
        String str = this.scarQueryId;
        int iHashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scarAdUnitId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scarAdString;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z7 = this.isOfferwallAd;
        ?? r03 = z7;
        if (z7) {
            r03 = 1;
        }
        int i8 = (iHashCode4 + r03) * 31;
        String str4 = this.offerwallPlacementName;
        int iHashCode5 = (i8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        AdPlayer adPlayer = this.adPlayer;
        int iHashCode6 = (iHashCode5 + (adPlayer == null ? 0 : adPlayer.hashCode())) * 31;
        String str5 = this.playerServerId;
        int iHashCode7 = (this.loadOptions.hashCode() + ((iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31)) * 31;
        boolean z8 = this.isHeaderBidding;
        return this.state.hashCode() + ((this.ttl.hashCode() + ((this.adType.hashCode() + ((iHashCode7 + (z8 ? 1 : z8)) * 31)) * 31)) * 31);
    }

    public final boolean isHeaderBidding() {
        return this.isHeaderBidding;
    }

    public final boolean isOfferwallAd() {
        return this.isOfferwallAd;
    }

    public final boolean isScarAd() {
        return this.isScarAd;
    }

    public final void setOfferwallAd(boolean z2) {
        this.isOfferwallAd = z2;
    }

    public final void setOfferwallPlacementName(String str) {
        this.offerwallPlacementName = str;
    }

    public final void setPlayerServerId(String str) {
        this.playerServerId = str;
    }

    public final void setScarAd(boolean z2) {
        this.isScarAd = z2;
    }

    public final void setScarAdString(String str) {
        this.scarAdString = str;
    }

    public final void setScarAdUnitId(String str) {
        this.scarAdUnitId = str;
    }

    public final void setScarQueryId(String str) {
        this.scarQueryId = str;
    }

    public final void setState(q0 q0Var) {
        k.e(q0Var, "<set-?>");
        this.state = q0Var;
    }

    public final void setTrackingToken(ByteString byteString) {
        k.e(byteString, "<set-?>");
        this.trackingToken = byteString;
    }

    public final void setTtl(q0 q0Var) {
        k.e(q0Var, "<set-?>");
        this.ttl = q0Var;
    }

    public String toString() {
        return "AdObject(opportunityId=" + this.opportunityId + ", placementId=" + this.placementId + ", trackingToken=" + this.trackingToken + ", isScarAd=" + this.isScarAd + ", scarQueryId=" + this.scarQueryId + ", scarAdUnitId=" + this.scarAdUnitId + ", scarAdString=" + this.scarAdString + ", isOfferwallAd=" + this.isOfferwallAd + ", offerwallPlacementName=" + this.offerwallPlacementName + ", adPlayer=" + this.adPlayer + ", playerServerId=" + this.playerServerId + ", loadOptions=" + this.loadOptions + ", isHeaderBidding=" + this.isHeaderBidding + ", adType=" + this.adType + ", ttl=" + this.ttl + ", state=" + this.state + ')';
    }

    public /* synthetic */ AdObject(ByteString byteString, String str, ByteString byteString2, boolean z2, String str2, String str3, String str4, boolean z7, String str5, AdPlayer adPlayer, String str6, UnityAdsLoadOptions unityAdsLoadOptions, boolean z8, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, q0 q0Var, q0 q0Var2, int i2, f fVar) {
        this(byteString, str, byteString2, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? false : z7, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : adPlayer, (i2 & 1024) != 0 ? null : str6, unityAdsLoadOptions, z8, diagnosticAdType, (i2 & 16384) != 0 ? x0.c(null) : q0Var, (i2 & 32768) != 0 ? x0.c(AdObjectState.INIT) : q0Var2);
    }
}
