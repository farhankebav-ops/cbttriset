package sg.bigo.ads.core.e.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.k;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f16962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f16963d;
    JSONObject e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16964f;
    private String g;
    private String[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f16965i;
    private String j;
    private int k;
    private final Map<String, String> l;
    private sg.bigo.ads.common.g m;

    public e(JSONObject jSONObject) {
        this(jSONObject, null);
    }

    private boolean f() {
        return this.f16962c == 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g() {
        /*
            Method dump skipped, instruction units count: 938
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.e.a.e.g():java.lang.String");
    }

    public final void a(@NonNull String str, @NonNull String str2) {
        this.l.put(str, str2);
    }

    public final boolean b() {
        return this.k != 0 && r.a() / 1000 > ((long) this.k);
    }

    public final boolean c() {
        return this.f16960a == 0;
    }

    @NonNull
    public final sg.bigo.ads.common.u.a d() {
        k.b aVar;
        if (TextUtils.isEmpty(this.j)) {
            e();
            a0.g(0, 3, this.j, "ThirdTrack", new StringBuilder("getRealUrl url = "));
        }
        if (c() && f()) {
            k kVar = d.a().f16955d;
            if (kVar != null) {
                aVar = kVar.a(this.j);
                sg.bigo.ads.common.t.a.a(0, 3, "ThirdTrack", "replaceHost new url = " + aVar.a());
            } else {
                sg.bigo.ads.common.t.a.a(0, "ThirdTrack", "replaceHost handle is null, replace failed");
                aVar = null;
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new k.a(this.j);
        }
        return new sg.bigo.ads.core.e.a(aVar);
    }

    public final void e() {
        this.j = g();
        a0.g(0, 3, this.j, "ThirdTrack", new StringBuilder("updateRealUrl url = "));
        JSONObject jSONObject = this.e;
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("real_url", this.j);
            } catch (JSONException unused) {
            }
        }
    }

    public final String toString() {
        return "type=" + this.f16960a + ",name=" + this.f16961b + ",url=" + this.j;
    }

    public e(JSONObject jSONObject, sg.bigo.ads.common.g gVar) {
        this.m = gVar;
        this.e = jSONObject;
        this.l = new HashMap();
        this.f16960a = jSONObject.optInt("type", 0);
        this.f16964f = jSONObject.optString("value", "");
        this.f16961b = jSONObject.optString("name", "");
        this.g = jSONObject.optString("uuid", "");
        this.k = jSONObject.optInt("expired");
        this.f16962c = jSONObject.optInt("replace", 0);
        this.f16963d = jSONObject.optInt("norepeat", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reg");
        if (jSONArrayOptJSONArray != null) {
            this.h = new String[jSONArrayOptJSONArray.length()];
            this.f16965i = new String[jSONArrayOptJSONArray.length()];
            a(jSONArrayOptJSONArray);
        }
        this.j = jSONObject.optString("real_url");
    }

    private void a(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optJSONObject(i2) != null) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                this.h[i2] = jSONObjectOptJSONObject.optString("token", "");
                this.f16965i[i2] = jSONObjectOptJSONObject.optString("value", "");
            }
        }
    }

    public final boolean a() {
        return "bigo_tracker".equals(this.g);
    }
}
