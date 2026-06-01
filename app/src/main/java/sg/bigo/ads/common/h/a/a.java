package sg.bigo.ads.common.h.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15740a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15741b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15742c = 40;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15743d = 432000000;

    public a() {
        c();
    }

    private void c() {
        this.f15740a = 3;
        this.f15741b = 20;
        this.f15742c = 40;
        this.f15743d = 432000000L;
    }

    public final int a() {
        int i2 = this.f15741b;
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public final boolean b() {
        return this.f15740a <= 0;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            c();
            return;
        }
        this.f15740a = jSONObject.optInt("download_parallel_num", 3);
        int iOptInt = jSONObject.optInt("num", 20);
        this.f15741b = iOptInt;
        this.f15742c = iOptInt * 2;
        long jOptInt = ((long) jSONObject.optInt("valid_period")) * 1000;
        if (jOptInt == 0) {
            jOptInt = 432000000;
        }
        this.f15743d = jOptInt;
    }
}
