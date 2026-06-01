package sg.bigo.ads.core.b;

import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f16811c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sg.bigo.ads.core.b.b.a f16812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f16813b = new AtomicBoolean(false);

    private b() {
    }

    public static b a() {
        return f16811c;
    }

    public final void a(String str, @NonNull Map<String, Object> map) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        if (!this.f16813b.get()) {
            sg.bigo.ads.common.t.a.a(0, 3, "Callback", "please execute init first");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        this.f16812a.a(str, jSONObject);
    }
}
