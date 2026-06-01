package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class q implements c.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f16513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16516d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16517f;
    private final int g;
    private final String[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String[] f16518i;

    public q(@NonNull JSONObject jSONObject) {
        this.f16513a = jSONObject;
        this.f16514b = jSONObject.optInt("type", 0);
        this.f16515c = jSONObject.optString("value", "");
        this.f16516d = jSONObject.optString("name", "");
        this.e = jSONObject.optString("uuid", "");
        this.f16517f = jSONObject.optInt("replace", 0);
        this.g = jSONObject.optInt("norepeat", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reg");
        if (jSONArrayOptJSONArray == null) {
            this.h = new String[0];
            this.f16518i = new String[0];
            return;
        }
        this.h = new String[jSONArrayOptJSONArray.length()];
        this.f16518i = new String[jSONArrayOptJSONArray.length()];
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                this.h[i2] = jSONObjectOptJSONObject.optString("token", "");
                this.f16518i[i2] = jSONObjectOptJSONObject.optString("value", "");
            }
        }
    }

    @Override // sg.bigo.ads.api.core.c.f
    public final JSONObject a() {
        return this.f16513a;
    }
}
