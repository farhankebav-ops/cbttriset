package sg.bigo.ads.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16808a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16809b = 900000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16810c = 259200000;

    public a() {
        b();
    }

    private void b() {
        this.f16808a = 10;
        this.f16809b = 900000;
        this.f16810c = 259200000;
    }

    public final int a() {
        return Math.round(this.f16808a * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.f16808a = jSONObject.optInt("num", 10);
        int iOptInt = jSONObject.optInt("interval") * 1000;
        this.f16809b = iOptInt;
        if (iOptInt == 0) {
            this.f16809b = 900000;
        }
        this.f16810c = jSONObject.optInt("expired") * 1000;
    }
}
