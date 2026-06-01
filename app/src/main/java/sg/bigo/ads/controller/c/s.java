package sg.bigo.ads.controller.c;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.o;

/* JADX INFO: loaded from: classes6.dex */
public final class s implements o.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16524c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16525d;
    private final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16526f;

    public s(@NonNull JSONObject jSONObject) {
        this.f16522a = jSONObject.optInt("play_ad_downloading", 0) == 1;
        this.f16523b = jSONObject.optInt("play_ad_threshold", 50);
        this.f16525d = jSONObject.optLong("play_ad_min_second", 6L) * 1000;
        this.e = jSONObject.optLong("threshold_max_second", 15L) * 1000;
    }

    @Override // sg.bigo.ads.api.core.o.d
    public final long a() {
        return this.f16526f;
    }

    @Override // sg.bigo.ads.api.core.o.d
    public final boolean b() {
        return this.f16522a;
    }

    @Override // sg.bigo.ads.api.core.o.d
    @IntRange(from = 1, to = 100)
    public final int c() {
        if (!this.f16522a) {
            return 100;
        }
        long j = this.f16526f;
        if (j <= this.f16525d) {
            return 100;
        }
        long j3 = this.e;
        return j <= j3 ? this.f16523b : j < (3 * j3) / 2 ? (int) ((((long) this.f16523b) * j3) / j) : (this.f16523b * 2) / 3;
    }

    @Override // sg.bigo.ads.api.core.o.d
    public final boolean d() {
        return this.f16524c;
    }

    @Override // sg.bigo.ads.api.core.o.d
    public final void a(long j) {
        this.f16526f = j;
    }

    @Override // sg.bigo.ads.api.core.o.d
    public final void a(boolean z2) {
        this.f16524c = z2;
    }
}
