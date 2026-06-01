package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.time.Instant;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomAudience {
    private final Instant activationTime;
    private final List<AdData> ads;
    private final Uri biddingLogicUri;
    private final AdTechIdentifier buyer;
    private final Uri dailyUpdateUri;
    private final Instant expirationTime;
    private final String name;
    private final TrustedBiddingData trustedBiddingSignals;
    private final AdSelectionSignals userBiddingSignals;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private Instant activationTime;
        private List<AdData> ads;
        private Uri biddingLogicUri;
        private AdTechIdentifier buyer;
        private Uri dailyUpdateUri;
        private Instant expirationTime;
        private String name;
        private TrustedBiddingData trustedBiddingData;
        private AdSelectionSignals userBiddingSignals;

        public Builder(AdTechIdentifier buyer, String name, Uri dailyUpdateUri, Uri biddingLogicUri, List<AdData> ads) {
            k.e(buyer, "buyer");
            k.e(name, "name");
            k.e(dailyUpdateUri, "dailyUpdateUri");
            k.e(biddingLogicUri, "biddingLogicUri");
            k.e(ads, "ads");
            this.buyer = buyer;
            this.name = name;
            this.dailyUpdateUri = dailyUpdateUri;
            this.biddingLogicUri = biddingLogicUri;
            this.ads = ads;
        }

        public final CustomAudience build() {
            return new CustomAudience(this.buyer, this.name, this.dailyUpdateUri, this.biddingLogicUri, this.ads, this.activationTime, this.expirationTime, this.userBiddingSignals, this.trustedBiddingData);
        }

        public final Builder setActivationTime(Instant activationTime) {
            k.e(activationTime, "activationTime");
            this.activationTime = activationTime;
            return this;
        }

        public final Builder setAds(List<AdData> ads) {
            k.e(ads, "ads");
            this.ads = ads;
            return this;
        }

        public final Builder setBiddingLogicUri(Uri biddingLogicUri) {
            k.e(biddingLogicUri, "biddingLogicUri");
            this.biddingLogicUri = biddingLogicUri;
            return this;
        }

        public final Builder setBuyer(AdTechIdentifier buyer) {
            k.e(buyer, "buyer");
            this.buyer = buyer;
            return this;
        }

        public final Builder setDailyUpdateUri(Uri dailyUpdateUri) {
            k.e(dailyUpdateUri, "dailyUpdateUri");
            this.dailyUpdateUri = dailyUpdateUri;
            return this;
        }

        public final Builder setExpirationTime(Instant expirationTime) {
            k.e(expirationTime, "expirationTime");
            this.expirationTime = expirationTime;
            return this;
        }

        public final Builder setName(String name) {
            k.e(name, "name");
            this.name = name;
            return this;
        }

        public final Builder setTrustedBiddingData(TrustedBiddingData trustedBiddingSignals) {
            k.e(trustedBiddingSignals, "trustedBiddingSignals");
            this.trustedBiddingData = trustedBiddingSignals;
            return this;
        }

        public final Builder setUserBiddingSignals(AdSelectionSignals userBiddingSignals) {
            k.e(userBiddingSignals, "userBiddingSignals");
            this.userBiddingSignals = userBiddingSignals;
            return this;
        }
    }

    public CustomAudience(AdTechIdentifier buyer, String name, Uri dailyUpdateUri, Uri biddingLogicUri, List<AdData> ads, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, TrustedBiddingData trustedBiddingData) {
        k.e(buyer, "buyer");
        k.e(name, "name");
        k.e(dailyUpdateUri, "dailyUpdateUri");
        k.e(biddingLogicUri, "biddingLogicUri");
        k.e(ads, "ads");
        this.buyer = buyer;
        this.name = name;
        this.dailyUpdateUri = dailyUpdateUri;
        this.biddingLogicUri = biddingLogicUri;
        this.ads = ads;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
        this.trustedBiddingSignals = trustedBiddingData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) obj;
        return k.a(this.buyer, customAudience.buyer) && k.a(this.name, customAudience.name) && k.a(this.activationTime, customAudience.activationTime) && k.a(this.expirationTime, customAudience.expirationTime) && k.a(this.dailyUpdateUri, customAudience.dailyUpdateUri) && k.a(this.userBiddingSignals, customAudience.userBiddingSignals) && k.a(this.trustedBiddingSignals, customAudience.trustedBiddingSignals) && k.a(this.ads, customAudience.ads);
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final List<AdData> getAds() {
        return this.ads;
    }

    public final Uri getBiddingLogicUri() {
        return this.biddingLogicUri;
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final Uri getDailyUpdateUri() {
        return this.dailyUpdateUri;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final String getName() {
        return this.name;
    }

    public final TrustedBiddingData getTrustedBiddingSignals() {
        return this.trustedBiddingSignals;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(this.buyer.hashCode() * 31, 31, this.name);
        Instant instant = this.activationTime;
        int iHashCode = (iB + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.expirationTime;
        int iHashCode2 = (this.dailyUpdateUri.hashCode() + ((iHashCode + (instant2 != null ? instant2.hashCode() : 0)) * 31)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        int iHashCode3 = (iHashCode2 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0)) * 31;
        TrustedBiddingData trustedBiddingData = this.trustedBiddingSignals;
        int iHashCode4 = trustedBiddingData != null ? trustedBiddingData.hashCode() : 0;
        return this.ads.hashCode() + ((this.biddingLogicUri.hashCode() + ((iHashCode3 + iHashCode4) * 31)) * 31);
    }

    public String toString() {
        return "CustomAudience: buyer=" + this.biddingLogicUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", dailyUpdateUri=" + this.dailyUpdateUri + ", userBiddingSignals=" + this.userBiddingSignals + ", trustedBiddingSignals=" + this.trustedBiddingSignals + ", biddingLogicUri=" + this.biddingLogicUri + ", ads=" + this.ads;
    }

    public /* synthetic */ CustomAudience(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List list, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, TrustedBiddingData trustedBiddingData, int i2, f fVar) {
        this(adTechIdentifier, str, uri, uri2, list, (i2 & 32) != 0 ? null : instant, (i2 & 64) != 0 ? null : instant2, (i2 & 128) != 0 ? null : adSelectionSignals, (i2 & 256) != 0 ? null : trustedBiddingData);
    }
}
