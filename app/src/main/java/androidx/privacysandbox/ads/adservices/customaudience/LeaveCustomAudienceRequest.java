package androidx.privacysandbox.ads.adservices.customaudience;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LeaveCustomAudienceRequest {
    private final AdTechIdentifier buyer;
    private final String name;

    public LeaveCustomAudienceRequest(AdTechIdentifier buyer, String name) {
        k.e(buyer, "buyer");
        k.e(name, "name");
        this.buyer = buyer;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveCustomAudienceRequest)) {
            return false;
        }
        LeaveCustomAudienceRequest leaveCustomAudienceRequest = (LeaveCustomAudienceRequest) obj;
        return k.a(this.buyer, leaveCustomAudienceRequest.buyer) && k.a(this.name, leaveCustomAudienceRequest.name);
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() + (this.buyer.hashCode() * 31);
    }

    public String toString() {
        return "LeaveCustomAudience: buyer=" + this.buyer + ", name=" + this.name;
    }
}
