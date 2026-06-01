package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.n2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2461n2 {
    public static final String A = "nurl";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9465o = "adMarkup";
    public static final String p = "instance";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9466q = "adData";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9467r = "price";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9468s = "serverData";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f9469t = "loadTimeout";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9470u = "order";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9471v = "show";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9472w = "price";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9473x = "notifications";
    public static final String y = "burl";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9474z = "lurl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f9477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9478d;
    private Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9479f;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<String> f9480i;
    private final List<String> j;
    private final List<String> k;
    private Y8 l;
    private Bb m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9481n;

    public C2461n2(String str) {
        this.f9475a = null;
        this.f9476b = "";
        this.f9477c = null;
        this.f9478d = "";
        this.e = null;
        this.f9479f = -1;
        this.g = -1;
        this.h = -1;
        this.f9480i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = null;
        this.m = null;
        this.f9481n = true;
        this.f9475a = str;
    }

    private void a(JSONObject jSONObject, int i2) {
        this.f9479f = i2;
        this.g = i2;
        this.h = i2;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt(f9471v, i2);
            this.g = iOptInt;
            this.h = jSONObject.optInt("price", iOptInt);
        }
    }

    public List<String> b() {
        return this.f9480i;
    }

    public String c() {
        return this.f9475a;
    }

    public Bb d() {
        return this.m;
    }

    public int e() {
        return this.f9479f;
    }

    public Integer f() {
        return this.e;
    }

    public List<String> g() {
        return this.j;
    }

    public List<String> h() {
        return this.k;
    }

    public String i() {
        return this.f9478d;
    }

    public int j() {
        return this.h;
    }

    public String k() {
        return this.f9476b;
    }

    public int l() {
        return this.g;
    }

    public boolean m() {
        return this.f9481n;
    }

    public JSONObject a() {
        return this.f9477c;
    }

    public Y8 a(String str) {
        Y8 y8 = this.l;
        if (y8 == null) {
            return null;
        }
        Y8 y82 = new Y8(y8);
        y82.a(com.ironsource.mediationsdk.d.f9042r, str);
        return y82;
    }

    private void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        if (jSONObject.has(str)) {
            list.addAll(C2395ja.b(jSONObject.getJSONArray(str)));
        }
    }

    public C2461n2(JSONObject jSONObject) {
        this(jSONObject, -1, null);
    }

    public C2461n2(JSONObject jSONObject, int i2, JSONObject jSONObject2) {
        this.f9475a = null;
        this.f9476b = "";
        this.f9477c = null;
        this.f9478d = "";
        this.e = null;
        this.f9479f = -1;
        this.g = -1;
        this.h = -1;
        ArrayList arrayList = new ArrayList();
        this.f9480i = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.j = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.k = arrayList3;
        this.l = null;
        this.m = null;
        this.f9481n = true;
        try {
            if (jSONObject.has(p)) {
                this.f9475a = jSONObject.getString(p);
            }
            if (jSONObject.has("adMarkup")) {
                this.f9476b = jSONObject.getString("adMarkup");
            } else if (jSONObject.has(f9468s)) {
                this.f9476b = jSONObject.getJSONObject(f9468s).toString();
            }
            this.f9477c = jSONObject.optJSONObject("adData");
            this.f9478d = jSONObject.optString("price", "0");
            if (jSONObject.has(f9473x)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(f9473x);
                a(jSONObject3, y, arrayList);
                a(jSONObject3, f9474z, arrayList2);
                a(jSONObject3, A, arrayList3);
            }
            this.l = new Y8(C2395ja.a(jSONObject2, jSONObject.optJSONObject(com.ironsource.mediationsdk.d.f9036d)));
            this.m = jSONObject.has(com.ironsource.mediationsdk.d.e) ? Bb.a(jSONObject.getJSONObject(com.ironsource.mediationsdk.d.e)) : null;
            this.e = jSONObject.has(f9469t) ? Integer.valueOf((int) TimeUnit.MILLISECONDS.toSeconds(jSONObject.getLong(f9469t))) : null;
            a(jSONObject.optJSONObject(f9470u), i2);
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.f9481n = false;
            IronLog.INTERNAL.error("exception " + e.getMessage());
        }
    }
}
