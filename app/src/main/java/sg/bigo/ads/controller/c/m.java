package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements c.InterfaceC0279c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16495c;

    public m(@NonNull JSONObject jSONObject) {
        this.f16493a = jSONObject.optString("vendor_url");
        this.f16494b = jSONObject.optString("vendor_key");
        this.f16495c = jSONObject.optString("params");
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0279c
    public final String a() {
        return this.f16493a;
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0279c
    public final String b() {
        return this.f16494b;
    }

    @Override // sg.bigo.ads.api.core.c.InterfaceC0279c
    public final String c() {
        return this.f16495c;
    }
}
