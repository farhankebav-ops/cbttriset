package com.vungle.ads.internal.load;

import com.vungle.ads.VungleAdSize;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import java.io.Serializable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdRequest implements Serializable {
    private final BidPayload adMarkup;
    private final Placement placement;
    private final VungleAdSize requestAdSize;

    public AdRequest(Placement placement, BidPayload bidPayload, VungleAdSize vungleAdSize) {
        k.e(placement, "placement");
        this.placement = placement;
        this.adMarkup = bidPayload;
        this.requestAdSize = vungleAdSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AdRequest.class.equals(obj.getClass())) {
            AdRequest adRequest = (AdRequest) obj;
            if (!k.a(this.placement.getReferenceId(), adRequest.placement.getReferenceId()) || !k.a(this.requestAdSize, adRequest.requestAdSize)) {
                return false;
            }
            BidPayload bidPayload = this.adMarkup;
            BidPayload bidPayload2 = adRequest.adMarkup;
            if (bidPayload != null) {
                return k.a(bidPayload, bidPayload2);
            }
            if (bidPayload2 == null) {
                return true;
            }
        }
        return false;
    }

    public final BidPayload getAdMarkup() {
        return this.adMarkup;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final VungleAdSize getRequestAdSize() {
        return this.requestAdSize;
    }

    public int hashCode() {
        int iHashCode = this.placement.getReferenceId().hashCode() * 31;
        VungleAdSize vungleAdSize = this.requestAdSize;
        int iHashCode2 = (iHashCode + (vungleAdSize != null ? vungleAdSize.hashCode() : 0)) * 31;
        BidPayload bidPayload = this.adMarkup;
        return iHashCode2 + (bidPayload != null ? bidPayload.hashCode() : 0);
    }

    public String toString() {
        return "AdRequest{placementId='" + this.placement.getReferenceId() + "', adMarkup=" + this.adMarkup + ", requestAdSize=" + this.requestAdSize + '}';
    }
}
