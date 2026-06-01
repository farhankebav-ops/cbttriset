package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdData;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adselection.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AdData {
    private final Set<Integer> adCounterKeys;
    private final AdFilters adFilters;
    private final String adRenderId;
    private final String metadata;
    private final Uri renderUri;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                k.e(adData, "adData");
                AdData.Builder adCounterKeys = a.g().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters = adData.getAdFilters();
                android.adservices.common.AdData adDataBuild = adCounterKeys.setAdFilters(adFilters != null ? adFilters.convertToAdServices$ads_adservices_release() : null).setAdRenderId(adData.getAdRenderId()).build();
                k.d(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext4Impl {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                k.e(adData, "adData");
                if (!adData.getAdCounterKeys().isEmpty()) {
                    Log.w("AdData", "adCounterKeys is ignored. Min version to use adCounterKeys is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdFilters() != null) {
                    Log.w("AdData", "adFilters is ignored. Min version to use adFilters is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                android.adservices.common.AdData adDataBuild = a.g().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).build();
                k.d(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }

        private Ext4Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext8Impl {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                k.e(adData, "adData");
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                AdData.Builder adCounterKeys = a.g().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters = adData.getAdFilters();
                android.adservices.common.AdData adDataBuild = adCounterKeys.setAdFilters(adFilters != null ? adFilters.convertToAdServices$ads_adservices_release() : null).build();
                k.d(adDataBuild, "Builder()\n              …                 .build()");
                return adDataBuild;
            }

            private Companion() {
            }
        }

        private Ext8Impl() {
        }
    }

    @ExperimentalFeatures.Ext10OptIn
    public AdData(Uri renderUri, String metadata, Set<Integer> adCounterKeys, AdFilters adFilters, String str) {
        k.e(renderUri, "renderUri");
        k.e(metadata, "metadata");
        k.e(adCounterKeys, "adCounterKeys");
        this.renderUri = renderUri;
        this.metadata = metadata;
        this.adCounterKeys = adCounterKeys;
        this.adFilters = adFilters;
        this.adRenderId = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdData convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) ? Ext10Impl.Companion.convertAdData(this) : (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) ? Ext8Impl.Companion.convertAdData(this) : Ext4Impl.Companion.convertAdData(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return k.a(this.renderUri, adData.renderUri) && k.a(this.metadata, adData.metadata) && k.a(this.adCounterKeys, adData.adCounterKeys) && k.a(this.adFilters, adData.adFilters) && k.a(this.adRenderId, adData.adRenderId);
    }

    public final Set<Integer> getAdCounterKeys() {
        return this.adCounterKeys;
    }

    public final AdFilters getAdFilters() {
        return this.adFilters;
    }

    public final String getAdRenderId() {
        return this.adRenderId;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        int iHashCode = (this.adCounterKeys.hashCode() + androidx.camera.core.processing.util.a.b(this.renderUri.hashCode() * 31, 31, this.metadata)) * 31;
        AdFilters adFilters = this.adFilters;
        int iHashCode2 = (iHashCode + (adFilters != null ? adFilters.hashCode() : 0)) * 31;
        String str = this.adRenderId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + "', adCounterKeys=" + this.adCounterKeys + ", adFilters=" + this.adFilters + ", adRenderId=" + this.adRenderId;
    }

    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters, String str2, int i2, f fVar) {
        this(uri, str, (i2 & 4) != 0 ? t.f13640a : set, (i2 & 8) != 0 ? null : adFilters, (i2 & 16) != 0 ? null : str2);
    }

    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters, int i2, f fVar) {
        this(uri, str, (i2 & 4) != 0 ? t.f13640a : set, (i2 & 8) != 0 ? null : adFilters);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @ExperimentalFeatures.Ext8OptIn
    public AdData(Uri renderUri, String metadata, Set<Integer> adCounterKeys, AdFilters adFilters) {
        this(renderUri, metadata, adCounterKeys, adFilters, null);
        k.e(renderUri, "renderUri");
        k.e(metadata, "metadata");
        k.e(adCounterKeys, "adCounterKeys");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdData(Uri renderUri, String metadata) {
        this(renderUri, metadata, t.f13640a, null);
        k.e(renderUri, "renderUri");
        k.e(metadata, "metadata");
    }
}
