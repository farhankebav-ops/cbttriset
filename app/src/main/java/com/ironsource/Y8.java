package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Y8 {
    public static final String A = "adNetwork";
    public static final String B = "instanceName";
    public static final String C = "instanceId";
    public static final String D = "revenue";
    public static final String E = "precision";
    public static final String F = "encryptedCPM";
    public static final String G = "creativeId";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7850r = "auctionId";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7851s = "adUnit";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7852t = "adFormat";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7853u = "mediationAdUnitName";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7854v = "mediationAdUnitId";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f7855w = "country";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7856x = "ab";
    public static final String y = "segmentName";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f7857z = "placement";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f7858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7861d;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7862f;
    private String g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7863i;
    private String j;
    private String k;
    private String l;
    private Double m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f7864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f7865o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DecimalFormat f7866q = new DecimalFormat("#.#####");

    public Y8(JSONObject jSONObject) {
        Double dValueOf = null;
        this.f7859b = null;
        this.f7860c = null;
        this.f7861d = null;
        this.e = null;
        this.f7862f = null;
        this.g = null;
        this.h = null;
        this.f7863i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f7864n = null;
        this.f7865o = null;
        this.p = null;
        if (jSONObject != null) {
            try {
                this.f7858a = jSONObject;
                this.f7859b = jSONObject.optString("auctionId", null);
                this.f7860c = jSONObject.optString("mediationAdUnitName", null);
                this.f7861d = jSONObject.optString("mediationAdUnitId", null);
                this.e = jSONObject.optString("adFormat", null);
                this.f7862f = jSONObject.optString("country", null);
                this.g = jSONObject.optString("ab", null);
                this.h = jSONObject.optString("segmentName", null);
                this.f7863i = jSONObject.optString("placement", null);
                this.j = jSONObject.optString("adNetwork", null);
                this.k = jSONObject.optString("instanceName", null);
                this.l = jSONObject.optString("instanceId", null);
                this.f7864n = jSONObject.optString("precision", null);
                this.f7865o = jSONObject.optString("encryptedCPM", null);
                this.p = jSONObject.optString("creativeId", null);
                double dOptDouble = jSONObject.optDouble("revenue");
                if (!Double.isNaN(dOptDouble)) {
                    dValueOf = Double.valueOf(dOptDouble);
                }
                this.m = dValueOf;
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("error parsing impression " + e.getMessage());
            }
        }
    }

    public void a(String str, String str2) {
        String str3 = this.f7863i;
        if (str3 != null) {
            String strReplace = str3.replace(str, str2);
            this.f7863i = strReplace;
            JSONObject jSONObject = this.f7858a;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", strReplace);
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.j;
    }

    public JSONObject d() {
        return this.f7858a;
    }

    public String e() {
        return this.f7859b;
    }

    public String f() {
        return this.f7862f;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.f7865o;
    }

    public String i() {
        return this.l;
    }

    public String j() {
        return this.k;
    }

    public String k() {
        return this.f7861d;
    }

    public String l() {
        return this.f7860c;
    }

    public String m() {
        return this.f7863i;
    }

    public String n() {
        return this.f7864n;
    }

    public Double o() {
        return this.m;
    }

    public String p() {
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("auctionId: '");
        sb.append(this.f7859b);
        sb.append("', mediationAdUnitName: '");
        sb.append(this.f7860c);
        sb.append("', mediationAdUnitId: '");
        sb.append(this.f7861d);
        sb.append("', adFormat: '");
        sb.append(this.e);
        sb.append("', country: '");
        sb.append(this.f7862f);
        sb.append("', ab: '");
        sb.append(this.g);
        sb.append("', segmentName: '");
        sb.append(this.h);
        sb.append("', placement: '");
        sb.append(this.f7863i);
        sb.append("', adNetwork: '");
        sb.append(this.j);
        sb.append("', instanceName: '");
        sb.append(this.k);
        sb.append("', instanceId: '");
        sb.append(this.l);
        sb.append("', revenue: ");
        Double d8 = this.m;
        sb.append(d8 == null ? null : this.f7866q.format(d8));
        sb.append(", precision: '");
        sb.append(this.f7864n);
        sb.append("', encryptedCPM: '");
        sb.append(this.f7865o);
        sb.append("', creativeId: '");
        return a1.a.e('\'', this.p, sb);
    }

    public String a() {
        return this.g;
    }

    public Y8(Y8 y8) {
        this.f7859b = null;
        this.f7860c = null;
        this.f7861d = null;
        this.e = null;
        this.f7862f = null;
        this.g = null;
        this.h = null;
        this.f7863i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f7864n = null;
        this.f7865o = null;
        this.p = null;
        this.f7858a = y8.f7858a;
        this.f7859b = y8.f7859b;
        this.f7860c = y8.f7860c;
        this.f7861d = y8.f7861d;
        this.e = y8.e;
        this.f7862f = y8.f7862f;
        this.g = y8.g;
        this.h = y8.h;
        this.f7863i = y8.f7863i;
        this.j = y8.j;
        this.k = y8.k;
        this.l = y8.l;
        this.f7864n = y8.f7864n;
        this.f7865o = y8.f7865o;
        this.m = y8.m;
        this.p = y8.p;
    }
}
