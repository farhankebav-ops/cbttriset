package sg.bigo.ads.core.d.a;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16866a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16867b = 900000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, C0314a> f16868c;

    /* JADX INFO: renamed from: sg.bigo.ads.core.d.a.a$a, reason: collision with other inner class name */
    public static class C0314a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f16869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f16870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f16871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16872d;

        public static C0314a a(String str) {
            C0314a c0314a = new C0314a();
            c0314a.f16869a = str;
            c0314a.f16870b = true;
            c0314a.f16871c = true;
            c0314a.f16872d = 86400000;
            return c0314a;
        }

        public final void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                sg.bigo.ads.common.t.a.a(0, "Stats", "eventConfig is null.");
                return;
            }
            this.f16869a = jSONObject.optString("event_id");
            this.f16870b = jSONObject.optInt("status") == 1;
            this.f16871c = jSONObject.optInt("delay") == 1;
            int iOptInt = jSONObject.optInt("expired") * 1000;
            this.f16872d = iOptInt;
            if (iOptInt == 0) {
                this.f16872d = 86400000;
            }
        }
    }

    public a() {
        HashMap<String, C0314a> map = new HashMap<>();
        this.f16868c = map;
        b();
        map.put("06002002", C0314a.a("06002002"));
        map.put("06002007", C0314a.a("06002007"));
    }

    private void b() {
        this.f16866a = 10;
        this.f16867b = 900000;
        this.f16868c.clear();
    }

    public final int a() {
        return Math.round(this.f16866a * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.f16866a = jSONObject.optInt("delay_num", 10);
        int iOptInt = jSONObject.optInt("delay_interval") * 1000;
        this.f16867b = iOptInt;
        if (iOptInt == 0) {
            this.f16867b = 900000;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("event_config");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            C0314a c0314a = new C0314a();
            c0314a.a(jSONArrayOptJSONArray.optJSONObject(i2));
            if (q.b((CharSequence) c0314a.f16869a)) {
                this.f16868c.put(c0314a.f16869a, c0314a);
            }
        }
    }

    public final boolean a(String str) {
        C0314a c0314a = this.f16868c.get(str);
        if (c0314a == null) {
            return false;
        }
        return c0314a.f16870b;
    }
}
