package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext8OptIn
public final class UpdateAdCounterHistogramRequest {
    private final int adEventType;
    private final long adSelectionId;
    private final AdTechIdentifier callerAdTech;

    public UpdateAdCounterHistogramRequest(long j, int i2, AdTechIdentifier callerAdTech) {
        k.e(callerAdTech, "callerAdTech");
        this.adSelectionId = j;
        this.adEventType = i2;
        this.callerAdTech = callerAdTech;
        if (i2 == 0) {
            throw new IllegalArgumentException("Win event types cannot be manually updated.");
        }
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Ad event type must be one of AD_EVENT_TYPE_IMPRESSION, AD_EVENT_TYPE_VIEW, or AD_EVENT_TYPE_CLICK");
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.UpdateAdCounterHistogramRequest convertToAdServices$ads_adservices_release() {
        b.A();
        android.adservices.adselection.UpdateAdCounterHistogramRequest updateAdCounterHistogramRequestBuild = b.l(this.adSelectionId, this.adEventType, this.callerAdTech.convertToAdServices$ads_adservices_release()).build();
        k.d(updateAdCounterHistogramRequestBuild, "Builder(\n               …   )\n            .build()");
        return updateAdCounterHistogramRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) obj;
        return this.adSelectionId == updateAdCounterHistogramRequest.adSelectionId && this.adEventType == updateAdCounterHistogramRequest.adEventType && k.a(this.callerAdTech, updateAdCounterHistogramRequest.callerAdTech);
    }

    public final int getAdEventType() {
        return this.adEventType;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final AdTechIdentifier getCallerAdTech() {
        return this.callerAdTech;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        return this.callerAdTech.hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + this.adEventType) * 31);
    }

    public String toString() {
        int i2 = this.adEventType;
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.adSelectionId + ", adEventType=" + (i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "Invalid ad event type" : "AD_EVENT_TYPE_CLICK" : "AD_EVENT_TYPE_VIEW" : "AD_EVENT_TYPE_IMPRESSION" : "AD_EVENT_TYPE_WIN") + ", callerAdTech=" + this.callerAdTech;
    }
}
