package sg.bigo.ads.controller.h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f16675d;

    public a(String str) {
        a(str);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f16674c = jSONObject.optString("data");
            this.f16672a = jSONObject.optInt("code");
            this.f16673b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            r.a(jSONObject.optInt("timestamp", 0));
            this.f16675d = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.equals("data", next) && !TextUtils.equals("code", next) && !TextUtils.equals(NotificationCompat.CATEGORY_MESSAGE, next)) {
                    this.f16675d.put(next, jSONObject.opt(next));
                }
            }
        } catch (JSONException unused) {
            this.f16674c = "";
            this.f16672a = 1005;
            this.f16673b = "Invalid response.";
        }
    }

    public final boolean a() {
        return this.f16672a == 1;
    }
}
