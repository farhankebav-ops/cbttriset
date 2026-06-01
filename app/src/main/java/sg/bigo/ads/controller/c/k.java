package sg.bigo.ads.controller.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONArray f16490d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16491f;
    private final String g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16492i;
    private final Map<String, String> j = new LinkedHashMap();
    private final String k;
    private final int l;

    public k(@NonNull JSONObject jSONObject) {
        this.f16487a = jSONObject.optString("land_url", "");
        this.f16488b = jSONObject.optString("deeplink_url", "");
        this.f16489c = jSONObject.optInt("web_ad_model", 0);
        this.e = jSONObject.optString("return_tracker_url", "");
        this.f16491f = jSONObject.optInt("land_preload_type", 0);
        this.g = jSONObject.optString("click_open_pkg", "");
        this.h = jSONObject.optInt("probe_interval", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pixel");
        if (jSONObjectOptJSONObject != null) {
            this.f16492i = jSONObjectOptJSONObject.optString("host", "");
            String strOptString = jSONObjectOptJSONObject.optString("value", "");
            if (!sg.bigo.ads.common.utils.q.a((CharSequence) strOptString)) {
                b(strOptString);
            }
        } else {
            this.f16492i = "";
        }
        this.k = jSONObject.optString("pre_landing_url", "");
        this.l = jSONObject.optInt("pre_landing_scene", 0);
        this.f16490d = jSONObject.optJSONArray("webview_bundle");
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String a() {
        return this.f16487a;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String b() {
        return this.f16488b;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final int c() {
        return this.f16489c;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final JSONArray d() {
        return this.f16490d;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String e() {
        return this.e;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final int f() {
        return this.f16491f;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String g() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String h() {
        return this.f16492i;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final Map<String, String> i() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final String j() {
        return this.k;
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final int k() {
        return this.l;
    }

    private void b(String str) {
        this.j.clear();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String strD : str.split(C2300e4.i.f8401c)) {
            if (strD.indexOf(C2300e4.i.f8399b) >= 0) {
                String strSubstring = strD.substring(0, strD.indexOf(C2300e4.i.f8399b));
                if (!TextUtils.isEmpty(strSubstring)) {
                    String str2 = this.j.get(strSubstring);
                    if (sg.bigo.ads.common.utils.q.b((CharSequence) str2)) {
                        strD = a1.a.D(str2, C2300e4.i.f8401c, strD);
                    }
                    this.j.put(strSubstring, strD);
                }
            }
        }
    }

    @Override // sg.bigo.ads.api.core.c.b
    public final void a(@NonNull String str) {
        this.f16487a = str;
    }
}
