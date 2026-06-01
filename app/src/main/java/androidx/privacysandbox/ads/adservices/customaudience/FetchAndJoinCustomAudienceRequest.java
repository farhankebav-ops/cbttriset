package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Instant;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext10OptIn
public final class FetchAndJoinCustomAudienceRequest {
    private final Instant activationTime;
    private final Instant expirationTime;
    private final Uri fetchUri;
    private final String name;
    private final AdSelectionSignals userBiddingSignals;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri fetchUri) {
        this(fetchUri, null, null, null, null, 30, null);
        k.e(fetchUri, "fetchUri");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        b.m();
        FetchAndJoinCustomAudienceRequest.Builder expirationTime = b.d(this.fetchUri).setName(this.name).setActivationTime(this.activationTime).setExpirationTime(this.expirationTime);
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequestBuild = expirationTime.setUserBiddingSignals(adSelectionSignals != null ? adSelectionSignals.convertToAdServices$ads_adservices_release() : null).build();
        k.d(fetchAndJoinCustomAudienceRequestBuild, "Builder(fetchUri)\n      …s())\n            .build()");
        return fetchAndJoinCustomAudienceRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        return k.a(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) && k.a(this.name, fetchAndJoinCustomAudienceRequest.name) && k.a(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) && k.a(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) && k.a(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals);
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    public final String getName() {
        return this.name;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int iHashCode = this.fetchUri.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.activationTime;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.expirationTime;
        int iHashCode4 = (iHashCode3 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        return iHashCode4 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0);
    }

    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri fetchUri, String str) {
        this(fetchUri, str, null, null, null, 28, null);
        k.e(fetchUri, "fetchUri");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri fetchUri, String str, Instant instant) {
        this(fetchUri, str, instant, null, null, 24, null);
        k.e(fetchUri, "fetchUri");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri fetchUri, String str, Instant instant, Instant instant2) {
        this(fetchUri, str, instant, instant2, null, 16, null);
        k.e(fetchUri, "fetchUri");
    }

    public FetchAndJoinCustomAudienceRequest(Uri fetchUri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals) {
        k.e(fetchUri, "fetchUri");
        this.fetchUri = fetchUri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    public /* synthetic */ FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, int i2, f fVar) {
        this(uri, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : instant, (i2 & 8) != 0 ? null : instant2, (i2 & 16) != 0 ? null : adSelectionSignals);
    }
}
