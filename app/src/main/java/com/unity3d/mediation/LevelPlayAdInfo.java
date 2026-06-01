package com.unity3d.mediation;

import com.ironsource.Bb;
import com.ironsource.Y8;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Y8 f10914d;
    private final Bb e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LevelPlayAdSize f10915f;
    private final String g;
    private final Map<String, Object> h;

    public LevelPlayAdInfo(String adId, String adUnitId, String adFormat, Y8 y8, Bb bb, LevelPlayAdSize levelPlayAdSize, String str, Map<String, ? extends Object> adapterData) {
        k.e(adId, "adId");
        k.e(adUnitId, "adUnitId");
        k.e(adFormat, "adFormat");
        k.e(adapterData, "adapterData");
        this.f10911a = adId;
        this.f10912b = adUnitId;
        this.f10913c = adFormat;
        this.f10914d = y8;
        this.e = bb;
        this.f10915f = levelPlayAdSize;
        this.g = str;
        this.h = adapterData;
    }

    private final String a() {
        return this.f10911a;
    }

    private final String b() {
        return this.f10912b;
    }

    private final String c() {
        return this.f10913c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LevelPlayAdInfo copy$default(LevelPlayAdInfo levelPlayAdInfo, String str, String str2, String str3, Y8 y8, Bb bb, LevelPlayAdSize levelPlayAdSize, String str4, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = levelPlayAdInfo.f10911a;
        }
        if ((i2 & 2) != 0) {
            str2 = levelPlayAdInfo.f10912b;
        }
        if ((i2 & 4) != 0) {
            str3 = levelPlayAdInfo.f10913c;
        }
        if ((i2 & 8) != 0) {
            y8 = levelPlayAdInfo.f10914d;
        }
        if ((i2 & 16) != 0) {
            bb = levelPlayAdInfo.e;
        }
        if ((i2 & 32) != 0) {
            levelPlayAdSize = levelPlayAdInfo.f10915f;
        }
        if ((i2 & 64) != 0) {
            str4 = levelPlayAdInfo.g;
        }
        if ((i2 & 128) != 0) {
            map = levelPlayAdInfo.h;
        }
        String str5 = str4;
        Map map2 = map;
        Bb bb2 = bb;
        LevelPlayAdSize levelPlayAdSize2 = levelPlayAdSize;
        return levelPlayAdInfo.copy(str, str2, str3, y8, bb2, levelPlayAdSize2, str5, map2);
    }

    private final Y8 d() {
        return this.f10914d;
    }

    private final Bb e() {
        return this.e;
    }

    private final LevelPlayAdSize f() {
        return this.f10915f;
    }

    private final String g() {
        return this.g;
    }

    private final Map<String, Object> h() {
        return this.h;
    }

    public final LevelPlayAdInfo copy(String adId, String adUnitId, String adFormat, Y8 y8, Bb bb, LevelPlayAdSize levelPlayAdSize, String str, Map<String, ? extends Object> adapterData) {
        k.e(adId, "adId");
        k.e(adUnitId, "adUnitId");
        k.e(adFormat, "adFormat");
        k.e(adapterData, "adapterData");
        return new LevelPlayAdInfo(adId, adUnitId, adFormat, y8, bb, levelPlayAdSize, str, adapterData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelPlayAdInfo)) {
            return false;
        }
        LevelPlayAdInfo levelPlayAdInfo = (LevelPlayAdInfo) obj;
        return k.a(this.f10911a, levelPlayAdInfo.f10911a) && k.a(this.f10912b, levelPlayAdInfo.f10912b) && k.a(this.f10913c, levelPlayAdInfo.f10913c) && k.a(this.f10914d, levelPlayAdInfo.f10914d) && k.a(this.e, levelPlayAdInfo.e) && k.a(this.f10915f, levelPlayAdInfo.f10915f) && k.a(this.g, levelPlayAdInfo.g) && k.a(this.h, levelPlayAdInfo.h);
    }

    public final String getAb() {
        Y8 y8 = this.f10914d;
        String strA = y8 != null ? y8.a() : null;
        return strA == null ? "" : strA;
    }

    public final String getAdFormat() {
        Y8 y8 = this.f10914d;
        String strB = y8 != null ? y8.b() : null;
        return strB == null ? this.f10913c : strB;
    }

    public final String getAdId() {
        return this.f10911a;
    }

    public final String getAdNetwork() {
        Y8 y8 = this.f10914d;
        String strC = y8 != null ? y8.c() : null;
        return strC == null ? "" : strC;
    }

    public final LevelPlayAdSize getAdSize() {
        return this.f10915f;
    }

    public final String getAdUnitId() {
        Y8 y8 = this.f10914d;
        String strK = y8 != null ? y8.k() : null;
        return strK == null ? this.f10912b : strK;
    }

    public final String getAdUnitName() {
        Y8 y8 = this.f10914d;
        String strL = y8 != null ? y8.l() : null;
        return strL == null ? "" : strL;
    }

    public final String getAuctionId() {
        Y8 y8 = this.f10914d;
        String strE = y8 != null ? y8.e() : null;
        return strE == null ? "" : strE;
    }

    public final String getCountry() {
        Y8 y8 = this.f10914d;
        String strF = y8 != null ? y8.f() : null;
        return strF == null ? "" : strF;
    }

    public final String getCreativeId() {
        Y8 y8 = this.f10914d;
        String strG = y8 != null ? y8.g() : null;
        return strG == null ? "" : strG;
    }

    public final String getEncryptedCPM() {
        Y8 y8 = this.f10914d;
        String strH = y8 != null ? y8.h() : null;
        return strH == null ? "" : strH;
    }

    public final String getInstanceId() {
        Y8 y8 = this.f10914d;
        String strI = y8 != null ? y8.i() : null;
        return strI == null ? "" : strI;
    }

    public final String getInstanceName() {
        Y8 y8 = this.f10914d;
        String strJ = y8 != null ? y8.j() : null;
        return strJ == null ? "" : strJ;
    }

    public final String getPlacementName() {
        String str = this.g;
        return str == null ? "" : str;
    }

    public final String getPrecision() {
        String strC;
        Bb bb = this.e;
        if (bb != null && (strC = bb.c()) != null) {
            return strC;
        }
        Y8 y8 = this.f10914d;
        String strN = y8 != null ? y8.n() : null;
        return strN == null ? "" : strN;
    }

    public final double getRevenue() {
        Bb bb = this.e;
        if (bb != null) {
            return bb.d();
        }
        Y8 y8 = this.f10914d;
        Double dO = y8 != null ? y8.o() : null;
        if (dO != null) {
            return dO.doubleValue();
        }
        return 0.0d;
    }

    public final String getSegmentName() {
        Y8 y8 = this.f10914d;
        String strP = y8 != null ? y8.p() : null;
        return strP == null ? "" : strP;
    }

    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b(this.f10911a.hashCode() * 31, 31, this.f10912b), 31, this.f10913c);
        Y8 y8 = this.f10914d;
        int iHashCode = (iB + (y8 == null ? 0 : y8.hashCode())) * 31;
        Bb bb = this.e;
        int iHashCode2 = (iHashCode + (bb == null ? 0 : bb.hashCode())) * 31;
        LevelPlayAdSize levelPlayAdSize = this.f10915f;
        int iHashCode3 = (iHashCode2 + (levelPlayAdSize == null ? 0 : levelPlayAdSize.hashCode())) * 31;
        String str = this.g;
        return this.h.hashCode() + ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public String toString() {
        String adId = getAdId();
        String adUnitId = getAdUnitId();
        String adUnitName = getAdUnitName();
        LevelPlayAdSize levelPlayAdSize = this.f10915f;
        String adFormat = getAdFormat();
        String placementName = getPlacementName();
        String auctionId = getAuctionId();
        String country = getCountry();
        String ab = getAb();
        String segmentName = getSegmentName();
        String adNetwork = getAdNetwork();
        String instanceName = getInstanceName();
        String instanceId = getInstanceId();
        double revenue = getRevenue();
        String precision = getPrecision();
        String encryptedCPM = getEncryptedCPM();
        String creativeId = getCreativeId();
        StringBuilder sbZ = a1.a.z("adId: ", adId, ", adUnitId: ", adUnitId, ", adUnitName: ");
        sbZ.append(adUnitName);
        sbZ.append(", adSize: ");
        sbZ.append(levelPlayAdSize);
        sbZ.append(", adFormat: ");
        androidx.camera.core.processing.util.a.A(sbZ, adFormat, ", placementName: ", placementName, ", auctionId: ");
        androidx.camera.core.processing.util.a.A(sbZ, auctionId, ", country: ", country, ", ab: ");
        androidx.camera.core.processing.util.a.A(sbZ, ab, ", segmentName: ", segmentName, ", adNetwork: ");
        androidx.camera.core.processing.util.a.A(sbZ, adNetwork, ", instanceName: ", instanceName, ", instanceId: ");
        sbZ.append(instanceId);
        sbZ.append(", revenue: ");
        sbZ.append(revenue);
        androidx.camera.core.processing.util.a.A(sbZ, ", precision: ", precision, ", encryptedCPM: ", encryptedCPM);
        return a1.a.r(sbZ, ", creativeId: ", creativeId);
    }

    public /* synthetic */ LevelPlayAdInfo(String str, String str2, String str3, Y8 y8, Bb bb, LevelPlayAdSize levelPlayAdSize, String str4, Map map, int i2, f fVar) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : y8, (i2 & 16) != 0 ? null : bb, (i2 & 32) != 0 ? null : levelPlayAdSize, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? s.f13639a : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayAdInfo(LevelPlayAdInfo adInfo, String str) {
        this(adInfo.f10911a, adInfo.f10912b, adInfo.f10913c, adInfo.f10914d, adInfo.e, adInfo.f10915f, str, adInfo.h);
        k.e(adInfo, "adInfo");
    }
}
