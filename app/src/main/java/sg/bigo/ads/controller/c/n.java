package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class n implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f16498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f16499d;
    String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f16500f;
    String[] g;
    String[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f16501i;

    public n(@NonNull JSONObject jSONObject) {
        this.f16496a = jSONObject.optString(C2300e4.h.H0);
        this.f16497b = jSONObject.optString("title");
        this.f16498c = jSONObject.optString("rate");
        this.f16499d = jSONObject.optString("comments");
        this.e = jSONObject.optString("downloads");
        this.f16500f = jSONObject.optString("description");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("genre");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.g = new String[jSONArrayOptJSONArray.length()];
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                this.g[i2] = jSONArrayOptJSONArray.optString(i2);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("img");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
            this.h = new String[jSONArrayOptJSONArray2.length()];
            for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
                this.h[i8] = jSONArrayOptJSONArray2.optString(i8);
            }
        }
        this.f16501i = jSONObject.optString("name");
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String a() {
        return this.f16496a;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String b() {
        return this.f16497b;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String c() {
        return this.f16500f;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String[] d() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String[] e() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.core.c.d
    public final String f() {
        return this.f16501i;
    }
}
