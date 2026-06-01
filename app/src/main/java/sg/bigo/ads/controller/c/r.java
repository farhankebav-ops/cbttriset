package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.o;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements o.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16521c;

    public r(@NonNull JSONObject jSONObject) {
        this.f16519a = jSONObject.optInt("w");
        this.f16520b = jSONObject.optInt("h");
        this.f16521c = jSONObject.optString("data");
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final int a() {
        return this.f16519a;
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final int b() {
        return this.f16520b;
    }

    @Override // sg.bigo.ads.api.core.o.c
    public final String c() {
        return this.f16521c;
    }
}
