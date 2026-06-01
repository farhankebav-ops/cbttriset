package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext10OptIn
public final class PersistAdSelectionResultRequest {
    private final long adSelectionId;
    private final byte[] adSelectionResult;
    private final AdTechIdentifier seller;

    public PersistAdSelectionResultRequest(long j) {
        this(j, null, null, 6, null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        PersistAdSelectionResultRequest.Builder adSelectionId = b.c().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier = this.seller;
        android.adservices.adselection.PersistAdSelectionResultRequest persistAdSelectionResultRequestBuild = adSelectionId.setSeller(adTechIdentifier != null ? adTechIdentifier.convertToAdServices$ads_adservices_release() : null).setAdSelectionResult(this.adSelectionResult).build();
        k.d(persistAdSelectionResultRequestBuild, "Builder()\n            .s…ult)\n            .build()");
        return persistAdSelectionResultRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        return this.adSelectionId == persistAdSelectionResultRequest.adSelectionId && k.a(this.seller, persistAdSelectionResultRequest.seller) && Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        long j = this.adSelectionId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        AdTechIdentifier adTechIdentifier = this.seller;
        int iHashCode = (i2 + (adTechIdentifier != null ? adTechIdentifier.hashCode() : 0)) * 31;
        byte[] bArr = this.adSelectionResult;
        return iHashCode + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    public PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier) {
        this(j, adTechIdentifier, null, 4, null);
    }

    public PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr) {
        this.adSelectionId = j;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    public /* synthetic */ PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr, int i2, f fVar) {
        this(j, (i2 & 2) != 0 ? null : adTechIdentifier, (i2 & 4) != 0 ? null : bArr);
    }
}
