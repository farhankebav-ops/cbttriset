package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.i;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16478c;

    public h(@NonNull JSONObject jSONObject) {
        this.f16476a = jSONObject.optInt("w");
        this.f16477b = jSONObject.optInt("h");
        this.f16478c = jSONObject.optString("data");
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final int a() {
        return this.f16476a;
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final int b() {
        return this.f16477b;
    }

    @Override // sg.bigo.ads.api.core.i.b
    public final String c() {
        return this.f16478c;
    }
}
