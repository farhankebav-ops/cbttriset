package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.w0;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.r;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AdSelectionConfig {
    public static final Companion Companion = new Companion(null);
    private static final AdSelectionConfig EMPTY;
    private final AdSelectionSignals adSelectionSignals;
    private final List<AdTechIdentifier> customAudienceBuyers;
    private final Uri decisionLogicUri;
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;
    private final AdTechIdentifier seller;
    private final AdSelectionSignals sellerSignals;
    private final Uri trustedScoringSignalsUri;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AdSelectionConfig getEMPTY() {
            return AdSelectionConfig.EMPTY;
        }

        private Companion() {
        }
    }

    static {
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier("");
        Uri EMPTY2 = Uri.EMPTY;
        k.d(EMPTY2, "EMPTY");
        AdSelectionSignals adSelectionSignals = new AdSelectionSignals("");
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals("");
        k.d(EMPTY2, "EMPTY");
        EMPTY = new AdSelectionConfig(adTechIdentifier, EMPTY2, r.f13638a, adSelectionSignals, adSelectionSignals2, s.f13639a, EMPTY2);
    }

    public AdSelectionConfig(AdTechIdentifier seller, Uri decisionLogicUri, List<AdTechIdentifier> customAudienceBuyers, AdSelectionSignals adSelectionSignals, AdSelectionSignals sellerSignals, Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals, Uri trustedScoringSignalsUri) {
        k.e(seller, "seller");
        k.e(decisionLogicUri, "decisionLogicUri");
        k.e(customAudienceBuyers, "customAudienceBuyers");
        k.e(adSelectionSignals, "adSelectionSignals");
        k.e(sellerSignals, "sellerSignals");
        k.e(perBuyerSignals, "perBuyerSignals");
        k.e(trustedScoringSignalsUri, "trustedScoringSignalsUri");
        this.seller = seller;
        this.decisionLogicUri = decisionLogicUri;
        this.customAudienceBuyers = customAudienceBuyers;
        this.adSelectionSignals = adSelectionSignals;
        this.sellerSignals = sellerSignals;
        this.perBuyerSignals = perBuyerSignals;
        this.trustedScoringSignalsUri = trustedScoringSignalsUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final List<android.adservices.common.AdTechIdentifier> convertToAdServices(List<AdTechIdentifier> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTechIdentifier> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionConfig adSelectionConfigBuild = w0.d().setAdSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setCustomAudienceBuyers(convertToAdServices(this.customAudienceBuyers)).setDecisionLogicUri(this.decisionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).setPerBuyerSignals(convertToAdServices(this.perBuyerSignals)).setSellerSignals(this.sellerSignals.convertToAdServices$ads_adservices_release()).setTrustedScoringSignalsUri(this.trustedScoringSignalsUri).build();
        k.d(adSelectionConfigBuild, "Builder()\n            .s…Uri)\n            .build()");
        return adSelectionConfigBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        return k.a(this.seller, adSelectionConfig.seller) && k.a(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) && k.a(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) && k.a(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) && k.a(this.sellerSignals, adSelectionConfig.sellerSignals) && k.a(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) && k.a(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri);
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        return this.trustedScoringSignalsUri.hashCode() + ((this.perBuyerSignals.hashCode() + ((this.sellerSignals.hashCode() + ((this.adSelectionSignals.hashCode() + ((this.customAudienceBuyers.hashCode() + ((this.decisionLogicUri.hashCode() + (this.seller.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final Map<android.adservices.common.AdTechIdentifier, android.adservices.common.AdSelectionSignals> convertToAdServices(Map<AdTechIdentifier, AdSelectionSignals> map) {
        HashMap map2 = new HashMap();
        for (AdTechIdentifier adTechIdentifier : map.keySet()) {
            android.adservices.common.AdTechIdentifier adTechIdentifierConvertToAdServices$ads_adservices_release = adTechIdentifier.convertToAdServices$ads_adservices_release();
            AdSelectionSignals adSelectionSignals = map.get(adTechIdentifier);
            map2.put(adTechIdentifierConvertToAdServices$ads_adservices_release, adSelectionSignals != null ? adSelectionSignals.convertToAdServices$ads_adservices_release() : null);
        }
        return map2;
    }
}
