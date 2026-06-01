package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public final class o implements c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16505d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16506f;
    private final String g;
    private final String h;

    public o(@NonNull JSONObject jSONObject) {
        this.f16502a = jSONObject.optString("imageurl");
        this.f16503b = jSONObject.optString("clickurl");
        this.f16504c = jSONObject.optString("longlegaltext");
        this.f16505d = jSONObject.optString("ad_info");
        this.e = jSONObject.optString("ad_link");
        this.f16506f = jSONObject.optInt("percent");
        this.g = jSONObject.optString("rec_rule");
        this.h = jSONObject.optString("user_privacy");
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String a() {
        return this.f16502a;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String b() {
        return this.f16503b;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String c() {
        return this.f16504c;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String d() {
        return this.f16505d;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String e() {
        return this.e;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final int f() {
        return this.f16506f;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String g() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.core.c.e
    public final String h() {
        return this.h;
    }
}
