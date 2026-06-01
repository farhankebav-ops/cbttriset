package com.ironsource.mediationsdk;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.ironsource.B7;
import com.ironsource.C2262c2;
import com.ironsource.C2270ca;
import com.ironsource.C2334g2;
import com.ironsource.C2395ja;
import com.ironsource.C2461n2;
import com.ironsource.C2531r4;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.Mb;
import com.ironsource.Q6;
import com.ironsource.V1;
import com.ironsource.V9;
import com.ironsource.W0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static final boolean A = false;
    private static d B = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9035c = "auctionId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9036d = "armData";
    public static final String e = "larmData";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9037f = "isAdUnitCapped";
    public static final String g = "settings";
    public static final String h = "waterfall";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9038i = "genericParams";
    public static final String j = "configurations";
    public static final String k = "instances";
    public static final String l = "${AUCTION_LOSS}";
    public static final String m = "${AUCTION_MBR}";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9039n = "${AUCTION_PRICE}";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9040o = "${DYNAMIC_DEMAND_SOURCE}";
    public static final String p = "${INSTANCE}";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9041q = "${INSTANCE_TYPE}";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9042r = "${PLACEMENT_NAME}";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f9043s = "adMarkup";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9044t = "dynamicDemandSource";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f9045u = "params";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9046v = "dlpl";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9047w = "adUnit";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9048x = "parallelLoad";
    public static final String y = "bidderExclusive";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9049z = "showPriorityEnabled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f9050a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B7 f9051b = Mb.U().i();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<C2461n2> f9053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C2461n2 f9054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f9055d;
        private JSONObject e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9056f;
        private String g;
        private V1 h;

        public a(String str) {
            this.f9052a = str;
        }

        public String a() {
            return this.f9052a;
        }

        public JSONObject b() {
            return this.e;
        }

        public int c() {
            return this.f9056f;
        }

        public String d() {
            return this.g;
        }

        public C2461n2 e() {
            return this.f9054c;
        }

        public JSONObject f() {
            return this.f9055d;
        }

        public V1 g() {
            return this.h;
        }

        public List<C2461n2> h() {
            return this.f9053b;
        }

        public com.ironsource.mediationsdk.demandOnly.p a(String str) {
            V1 v12 = this.h;
            if (v12 != null) {
                return v12.a(str);
            }
            return new p.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f9057d = 15000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f9059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9060c;

        public b(String str, String str2, String str3) {
            this.f9058a = str;
            this.f9059b = str2;
            this.f9060c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f9058a + ";" + this.f9059b + ";" + this.f9060c;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f9060c).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(f9057d);
                httpURLConnection.setConnectTimeout(f9057d);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                Mb.U().q().a(new C5(responseCode == 200 || responseCode == 204 ? D5.TROUBLESHOOTING_SEND_AUCTION_URL_SUCCESS : D5.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, new JSONObject().put(IronSourceConstants.EVENTS_PROVIDER, "Mediation").put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1).put(IronSourceConstants.EVENTS_EXT1, str).put(IronSourceConstants.EVENTS_ERROR_CODE, responseCode).put("reason", responseMessage)));
            } catch (Exception e) {
                C2531r4.d().a(e);
                StringBuilder sb = new StringBuilder("Send auction url failed with params - ");
                sb.append(str);
                sb.append(";");
                IronLog.INTERNAL.error(a1.a.j(e, sb));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum c {
        NOT_SECURE,
        SECURE
    }

    public static d b() {
        return B;
    }

    public a a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("auctionId");
        if (TextUtils.isEmpty(strOptString)) {
            throw new JSONException("Invalid auction response - auction id is missing");
        }
        a aVar = new a(strOptString);
        if (jSONObject.has("settings")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            aVar.f9054c = new C2461n2(jSONObject2);
            jSONObjectOptJSONObject = jSONObject2.has(f9036d) ? jSONObject2.optJSONObject(f9036d) : null;
            if (jSONObject2.has("genericParams")) {
                aVar.f9055d = jSONObject2.optJSONObject("genericParams");
            }
            if (jSONObject2.has("configurations")) {
                aVar.e = jSONObject2.optJSONObject("configurations");
            }
            if (jSONObject2.has(k)) {
                aVar.h = new V1.a(jSONObject2.optJSONObject(k));
            }
        }
        aVar.f9053b = new ArrayList();
        if (jSONObject.has(h)) {
            JSONArray jSONArray = jSONObject.getJSONArray(h);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C2461n2 c2461n2 = new C2461n2(jSONArray.getJSONObject(i2), i2, jSONObjectOptJSONObject);
                if (!c2461n2.m()) {
                    aVar.f9056f = 1002;
                    aVar.g = "waterfall " + i2;
                    IronLog.INTERNAL.verbose("AuctionResponseItem " + i2 + " not valid - parsing error");
                    throw new JSONException("invalid response");
                }
                aVar.f9053b.add(c2461n2);
            }
        }
        return aVar;
    }

    public String c(String str) {
        String string = "";
        try {
            if (!TextUtils.isEmpty(str) && C2395ja.a(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("params")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("parameters = " + jSONObject2);
                    if (jSONObject2.has("dynamicDemandSource")) {
                        string = jSONObject2.getString("dynamicDemandSource");
                        ironLog.verbose("demand source = " + string);
                        return string;
                    }
                }
            }
            return "";
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("exception " + e4.getMessage());
            return string;
        }
    }

    public Map<String, String> b(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        map.put(next, (String) obj);
                    }
                }
            }
            return map;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("exception " + e4.getMessage());
            return map;
        }
    }

    private c a() {
        c cVar = c.SECURE;
        return Build.VERSION.SDK_INT >= 28 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? c.NOT_SECURE : cVar : (ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & 134217728) != 0 ? c.NOT_SECURE : cVar;
    }

    public JSONObject a(i iVar) throws JSONException {
        IronSource.a aVar;
        boolean z2;
        List<String> list;
        int i2;
        int i8;
        IronSource.a aVarC = iVar.c();
        boolean zT = iVar.t();
        Map<String, Object> mapH = iVar.h();
        List<String> listL = iVar.l();
        h hVarE = iVar.e();
        int iO = iVar.o();
        ISBannerSize iSBannerSizeF = iVar.f();
        C2270ca c2270caN = iVar.n();
        boolean zP = iVar.p();
        boolean zQ = iVar.q();
        ArrayList<C2334g2> arrayListK = iVar.k();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> it = mapH.keySet().iterator();
        while (true) {
            aVar = aVarC;
            z2 = zT;
            String strA = "";
            list = listL;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            ISBannerSize iSBannerSize = iSBannerSizeF;
            JSONObject jSONObject3 = new JSONObject();
            C2270ca c2270ca = c2270caN;
            jSONObject3.put(Q6.f7480x0, 2);
            jSONObject3.put(Q6.f7456o0, new JSONObject((Map) mapH.get(next)));
            if (hVarE != null) {
                strA = hVarE.a(next);
            }
            jSONObject3.put(Q6.A0, strA);
            jSONObject3.put("ts", zQ ? 1 : 0);
            jSONObject2.put(next, jSONObject3);
            aVarC = aVar;
            zT = z2 ? 1 : 0;
            listL = list;
            iSBannerSizeF = iSBannerSize;
            c2270caN = c2270ca;
        }
        ISBannerSize iSBannerSize2 = iSBannerSizeF;
        C2270ca c2270ca2 = c2270caN;
        Iterator<String> it2 = list.iterator();
        while (true) {
            i2 = 1;
            if (!it2.hasNext()) {
                break;
            }
            String next2 = it2.next();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(Q6.f7480x0, 1);
            jSONObject4.put(Q6.A0, hVarE != null ? hVarE.a(next2) : "");
            jSONObject2.put(next2, jSONObject4);
        }
        int size = arrayListK.size();
        int i9 = 0;
        while (i9 < size) {
            C2334g2 c2334g2 = arrayListK.get(i9);
            i9++;
            C2334g2 c2334g22 = c2334g2;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(Q6.f7480x0, c2334g22.e() ? 2 : i2);
            Map<String, Object> mapF = c2334g22.f();
            if (!mapF.isEmpty()) {
                jSONObject5.put(Q6.f7456o0, new JSONObject(mapF));
            }
            jSONObject5.put(Q6.A0, hVarE != null ? hVarE.a(c2334g22.g()) : "");
            jSONObject5.put("ts", zQ ? 1 : 0);
            if (!c2334g22.h().isEmpty()) {
                jSONObject5.put(f9046v, c2334g22.h());
            }
            jSONObject2.put(c2334g22.g(), jSONObject5);
            i2 = 1;
        }
        jSONObject.put(Q6.f7477w0, jSONObject2);
        if (iVar.v()) {
            i8 = 1;
            jSONObject.put(Q6.f7478w1, 1);
        } else {
            i8 = 1;
        }
        if (iVar.s()) {
            jSONObject.put(Q6.f7475v1, i8);
        }
        new V9().b(ContextProvider.getInstance().getApplicationContext());
        JSONObject jSONObjectA = new C2262c2(W0.a(aVar)).a();
        a(jSONObjectA, false);
        jSONObjectA.put(Q6.f7482y0, iO);
        jSONObjectA.put(Q6.f7485z0, a().ordinal());
        if (c2270ca2 != null) {
            jSONObjectA.put(Q6.f7444i1, c2270ca2.i());
        }
        jSONObject.put(Q6.t0, jSONObjectA);
        if (iSBannerSize2 != null) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(Q6.f7461q0, iSBannerSize2.getDescription());
            jSONObject6.put(Q6.f7466s0, iSBannerSize2.getWidth());
            jSONObject6.put(Q6.f7464r0, iSBannerSize2.getHeight());
            jSONObject.put(Q6.f7458p0, jSONObject6);
        }
        jSONObject.put(Q6.k0, aVar.toString());
        if (iVar.b() != null) {
            jSONObject.put("adf", iVar.b());
        }
        if (iVar.d() != null) {
            jSONObject.put("mediationAdUnitId", iVar.d());
        }
        if (iVar.u() != null) {
            jSONObject.put(Q6.f7453n0, iVar.u());
        }
        jSONObject.put(Q6.f7471u0, !z2 ? 1 : 0);
        if (iVar.g() != null) {
            jSONObject.put(Q6.f7467s1, new JSONObject().put(Q6.f7469t1, iVar.g()));
        } else {
            Object objRemove = jSONObjectA.remove(Q6.f7467s1);
            if (objRemove != null) {
                jSONObject.put(Q6.f7467s1, objRemove);
            }
        }
        if (zP) {
            jSONObject.put(Q6.f7462q1, 1);
        }
        return jSONObject;
    }

    public String a(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7) {
        return str.replace(f9039n, str4).replace(l, str6).replace(m, str5).replace(p, str2).replace(f9041q, Integer.toString(i2)).replace(f9040o, str3).replace(f9042r, str7);
    }

    public String a(String str, int i2, C2461n2 c2461n2, String str2, String str3, String str4) {
        String strI = c2461n2.i();
        return a(str, c2461n2.c(), i2, b().c(c2461n2.k()), strI, b().a(strI, str2), str3, str4);
    }

    public void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    public String a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("adMarkup")) {
                    return jSONObject.getString("adMarkup");
                }
            }
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("exception " + e4.getMessage());
        }
        return str;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double d8 = Double.parseDouble(str);
        return Double.parseDouble(str2) == 0.0d ? "" : String.valueOf(Math.round((d8 / r7) * 1000.0d) / 1000.0d);
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null || jSONObject.length() <= 0 || TextUtils.isEmpty(jSONObject.optString(Q6.f7447k1)) || !this.f9050a.compareAndSet(false, true)) {
            return;
        }
        Mb.U().q().a(new C5(D5.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.a(z2, true, -1)));
    }
}
