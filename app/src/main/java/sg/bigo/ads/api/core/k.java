package sg.bigo.ads.api.core;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements sg.bigo.ads.api.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15515d;

    public k(@NonNull JSONObject jSONObject) {
        this.f15512a = jSONObject.optInt("w");
        this.f15513b = jSONObject.optInt("h");
        this.f15514c = jSONObject.optString("url");
        this.f15515d = jSONObject.optString("md5");
    }

    @Override // sg.bigo.ads.api.a.f
    public final int a() {
        return this.f15512a;
    }

    @Override // sg.bigo.ads.api.a.f
    public final int b() {
        return this.f15513b;
    }

    @Override // sg.bigo.ads.api.a.f
    public final String c() {
        return this.f15514c;
    }
}
