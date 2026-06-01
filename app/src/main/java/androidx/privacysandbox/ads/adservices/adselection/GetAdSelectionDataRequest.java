package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext10OptIn
public final class GetAdSelectionDataRequest {
    private final Uri coordinatorOriginUri;
    private final AdTechIdentifier seller;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest request) {
                k.e(request, "request");
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = b.a().setSeller(request.getSeller().convertToAdServices$ads_adservices_release()).build();
                k.d(getAdSelectionDataRequestBuild, "Builder()\n              …                 .build()");
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 12), @RequiresExtension(extension = 31, version = 12)})
    public static final class Ext12Impl {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest request) {
                k.e(request, "request");
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = b.a().setSeller(request.getSeller().convertToAdServices$ads_adservices_release()).setCoordinatorOriginUri(request.getCoordinatorOriginUri()).build();
                k.d(getAdSelectionDataRequestBuild, "Builder()\n              …                 .build()");
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }

        private Ext12Impl() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetAdSelectionDataRequest(AdTechIdentifier seller) {
        this(seller, null, 2, 0 == true ? 1 : 0);
        k.e(seller, "seller");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.GetAdSelectionDataRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 12 || adServicesInfo.extServicesVersionS() >= 12) ? Ext12Impl.Companion.convertGetAdSelectionDataRequest(this) : Ext10Impl.Companion.convertGetAdSelectionDataRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        return k.a(this.seller, getAdSelectionDataRequest.seller) && k.a(this.coordinatorOriginUri, getAdSelectionDataRequest.coordinatorOriginUri);
    }

    public final Uri getCoordinatorOriginUri() {
        return this.coordinatorOriginUri;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int iHashCode = this.seller.hashCode() * 31;
        Uri uri = this.coordinatorOriginUri;
        return iHashCode + (uri != null ? uri.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.seller + ", coordinatorOriginUri=" + this.coordinatorOriginUri;
    }

    public GetAdSelectionDataRequest(AdTechIdentifier seller, Uri uri) {
        k.e(seller, "seller");
        this.seller = seller;
        this.coordinatorOriginUri = uri;
    }

    public /* synthetic */ GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri, int i2, f fVar) {
        this(adTechIdentifier, (i2 & 2) != 0 ? null : uri);
    }

    @ExperimentalFeatures.Ext12OptIn
    public static /* synthetic */ void getCoordinatorOriginUri$annotations() {
    }
}
