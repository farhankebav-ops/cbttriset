package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.o;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16486d;

    public j(@NonNull JSONObject jSONObject) {
        this.f16483a = jSONObject.optInt("video_impression_area_rate", 0);
        this.f16484b = jSONObject.optLong("video_impression_time", 0L);
        this.f16485c = jSONObject.optInt("image_impression_area_rate", 0);
        this.f16486d = jSONObject.optLong("image_impression_time", 0L);
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final int a() {
        return this.f16483a;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final long b() {
        return this.f16484b;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final int c() {
        return this.f16485c;
    }

    @Override // sg.bigo.ads.api.core.o.b
    public final long d() {
        return this.f16486d;
    }
}
