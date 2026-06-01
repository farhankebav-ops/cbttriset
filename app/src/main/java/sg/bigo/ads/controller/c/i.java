package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.o;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements o.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16482d;

    public i(@NonNull JSONObject jSONObject) {
        this.f16479a = jSONObject.optInt("w");
        this.f16480b = jSONObject.optInt("h");
        this.f16481c = jSONObject.optString("url");
        this.f16482d = jSONObject.optString("md5");
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final int a() {
        return this.f16479a;
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final int b() {
        return this.f16480b;
    }

    @Override // sg.bigo.ads.api.core.o.a
    public final String c() {
        return this.f16481c;
    }
}
