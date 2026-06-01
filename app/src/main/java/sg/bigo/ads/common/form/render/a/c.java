package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.form.render.a.a;
import sg.bigo.ads.common.form.render.c;
import sg.bigo.ads.common.view.PrivacyCheckBox;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements a.InterfaceC0286a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public Context f15662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Map<String, Object> f15663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f15664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.c[] f15665d;
    public View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PrivacyCheckBox f15666f;
    public c.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private Map<String, String> f15667i = new ConcurrentHashMap();
    public List<a> g = new ArrayList();

    public c(@NonNull e eVar, @Nullable Map<String, Object> map, @NonNull Context context, c.a aVar) {
        this.f15662a = context;
        this.f15664c = eVar;
        this.f15663b = map;
        this.f15665d = eVar.m();
        this.h = aVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.f15667i.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    public final boolean b() {
        PrivacyCheckBox privacyCheckBox = this.f15666f;
        return privacyCheckBox != null && privacyCheckBox.f16097a;
    }

    @Override // sg.bigo.ads.common.form.render.a.a.InterfaceC0286a
    public final void a(String str, String str2) {
        this.f15667i.put(str, str2);
        c.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }
}
