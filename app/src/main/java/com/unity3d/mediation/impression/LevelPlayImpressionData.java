package com.unity3d.mediation.impression;

import java.text.DecimalFormat;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayImpressionData {
    public static final a Companion = new a(null);
    public static final String IMPRESSION_DATA_KEY_ABTEST = "ab";
    public static final String IMPRESSION_DATA_KEY_AD_FORMAT = "adFormat";
    public static final String IMPRESSION_DATA_KEY_AD_NETWORK = "adNetwork";
    public static final String IMPRESSION_DATA_KEY_AUCTION_ID = "auctionId";
    public static final String IMPRESSION_DATA_KEY_COUNTRY = "country";
    public static final String IMPRESSION_DATA_KEY_CREATIVE_ID = "creativeId";
    public static final String IMPRESSION_DATA_KEY_ENCRYPTED_CPM = "encryptedCPM";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_ID = "instanceId";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_NAME = "instanceName";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_ID = "mediationAdUnitId";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_NAME = "mediationAdUnitName";
    public static final String IMPRESSION_DATA_KEY_PLACEMENT = "placement";
    public static final String IMPRESSION_DATA_KEY_PRECISION = "precision";
    public static final String IMPRESSION_DATA_KEY_REVENUE = "revenue";
    public static final String IMPRESSION_DATA_KEY_SEGMENT_NAME = "segmentName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f10939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DecimalFormat f10940b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }

    public LevelPlayImpressionData(JSONObject allData) {
        k.e(allData, "allData");
        this.f10939a = allData;
        this.f10940b = new DecimalFormat("#.#####");
    }

    public final String getAb() {
        String it = this.f10939a.optString("ab", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getAdFormat() {
        String it = this.f10939a.optString("adFormat", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getAdNetwork() {
        String it = this.f10939a.optString("adNetwork", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final JSONObject getAllData() {
        return this.f10939a;
    }

    public final String getAuctionId() {
        String it = this.f10939a.optString("auctionId", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getCountry() {
        String it = this.f10939a.optString("country", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getCreativeId() {
        String it = this.f10939a.optString("creativeId", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getEncryptedCPM() {
        String it = this.f10939a.optString("encryptedCPM", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getInstanceId() {
        String it = this.f10939a.optString("instanceId", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getInstanceName() {
        String it = this.f10939a.optString("instanceName", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getMediationAdUnitId() {
        String it = this.f10939a.optString("mediationAdUnitId", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getMediationAdUnitName() {
        String it = this.f10939a.optString("mediationAdUnitName", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getPlacement() {
        String it = this.f10939a.optString("placement", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final String getPrecision() {
        String it = this.f10939a.optString("precision", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final Double getRevenue() {
        double dOptDouble = this.f10939a.optDouble("revenue");
        Double dValueOf = Double.valueOf(dOptDouble);
        if (Double.isNaN(dOptDouble)) {
            return null;
        }
        return dValueOf;
    }

    public final String getSegmentName() {
        String it = this.f10939a.optString("segmentName", "");
        k.d(it, "it");
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public String toString() {
        LevelPlayImpressionData levelPlayImpressionData;
        String str;
        String auctionId = getAuctionId();
        String mediationAdUnitName = getMediationAdUnitName();
        String mediationAdUnitId = getMediationAdUnitId();
        String adFormat = getAdFormat();
        String country = getCountry();
        String ab = getAb();
        String segmentName = getSegmentName();
        String placement = getPlacement();
        String adNetwork = getAdNetwork();
        String instanceName = getInstanceName();
        String instanceId = getInstanceId();
        if (getRevenue() == null) {
            str = null;
            levelPlayImpressionData = this;
        } else {
            levelPlayImpressionData = this;
            str = levelPlayImpressionData.f10940b.format(levelPlayImpressionData.getRevenue());
        }
        String precision = levelPlayImpressionData.getPrecision();
        String encryptedCPM = levelPlayImpressionData.getEncryptedCPM();
        String creativeId = levelPlayImpressionData.getCreativeId();
        StringBuilder sbZ = a1.a.z("auctionId: '", auctionId, "', mediationAdUnitName: '", mediationAdUnitName, "', mediationAdUnitId: '");
        androidx.camera.core.processing.util.a.A(sbZ, mediationAdUnitId, "', adFormat: '", adFormat, "', country: '");
        androidx.camera.core.processing.util.a.A(sbZ, country, "', ab: '", ab, "', segmentName: '");
        androidx.camera.core.processing.util.a.A(sbZ, segmentName, "', placement: '", placement, "', adNetwork: '");
        androidx.camera.core.processing.util.a.A(sbZ, adNetwork, "', instanceName: '", instanceName, "', instanceId: '");
        androidx.camera.core.processing.util.a.A(sbZ, instanceId, "', revenue: ", str, ", precision: '");
        androidx.camera.core.processing.util.a.A(sbZ, precision, "', encryptedCPM: '", encryptedCPM, "', creativeId: '");
        return a1.a.r(sbZ, creativeId, "'");
    }
}
