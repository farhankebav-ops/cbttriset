package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Object> f16473c = new ArrayList();

    public f(@NonNull JSONObject jSONObject) {
        this.f16471a = jSONObject.optInt("click_mode", 2);
        this.f16472b = jSONObject.optInt("wrong_click_time", 500);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reconfirm_click_region");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    this.f16473c.add(new g(jSONObjectOptJSONObject));
                }
            }
        }
    }

    @Override // sg.bigo.ads.api.core.c.a
    public final int a() {
        return this.f16471a;
    }

    @Override // sg.bigo.ads.api.core.c.a
    public final int b() {
        return this.f16472b;
    }
}
