package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.Bb;
import com.ironsource.C2531r4;
import com.ironsource.Y8;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdInfo {
    private final Y8 impressionData;
    private final Bb loadArmData;

    public AdInfo(Y8 y8, Bb bb) {
        this.impressionData = y8;
        this.loadArmData = bb;
    }

    public final String getAb() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.a() == null) {
            return "";
        }
        String strA = this.impressionData.a();
        k.d(strA, "impressionData.ab");
        return strA;
    }

    public final String getAdNetwork() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.c() == null) {
            return "";
        }
        String strC = this.impressionData.c();
        k.d(strC, "impressionData.adNetwork");
        return strC;
    }

    public final String getAuctionId() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.e() == null) {
            return "";
        }
        String strE = this.impressionData.e();
        k.d(strE, "impressionData.auctionId");
        return strE;
    }

    public final String getCountry() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.f() == null) {
            return "";
        }
        String strF = this.impressionData.f();
        k.d(strF, "impressionData.country");
        return strF;
    }

    public final String getEncryptedCPM() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.h() == null) {
            return "";
        }
        String strH = this.impressionData.h();
        k.d(strH, "impressionData.encryptedCPM");
        return strH;
    }

    public final String getInstanceId() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.i() == null) {
            return "";
        }
        String strI = this.impressionData.i();
        k.d(strI, "impressionData.instanceId");
        return strI;
    }

    public final String getInstanceName() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.j() == null) {
            return "";
        }
        String strJ = this.impressionData.j();
        k.d(strJ, "impressionData.instanceName");
        return strJ;
    }

    public final String getPrecision() {
        Bb bb = this.loadArmData;
        if (bb != null) {
            return bb.c();
        }
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.n() == null) {
            return "";
        }
        String strN = this.impressionData.n();
        k.d(strN, "impressionData.precision");
        return strN;
    }

    public final double getRevenue() {
        Bb bb = this.loadArmData;
        if (bb != null) {
            return bb.d();
        }
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.o() == null) {
            return 0.0d;
        }
        Double dO = this.impressionData.o();
        k.d(dO, "impressionData.revenue");
        return dO.doubleValue();
    }

    public final String getSegmentName() {
        Y8 y8 = this.impressionData;
        if (y8 == null || y8.p() == null) {
            return "";
        }
        String strP = this.impressionData.p();
        k.d(strP, "impressionData.segmentName");
        return strP;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auctionId", getAuctionId());
            jSONObject.put("country", getCountry());
            jSONObject.put("ab", getAb());
            jSONObject.put("segmentName", getSegmentName());
            jSONObject.put("adNetwork", getAdNetwork());
            jSONObject.put("instanceName", getInstanceName());
            jSONObject.put("instanceId", getInstanceId());
            jSONObject.put("revenue", getRevenue());
            jSONObject.put("precision", getPrecision());
            jSONObject.put("encryptedCPM", getEncryptedCPM());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("error while parsing ad info " + e.getMessage());
        }
        String string = jSONObject.toString();
        k.d(string, "adInfoData.toString()");
        return string;
    }
}
