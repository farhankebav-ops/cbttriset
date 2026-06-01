package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f16281d = r.f16036c.a(1);
    public static final long e = r.f16035b.a(5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f16282f = r.f16034a.a(30);
    public long g;
    public long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16283i;

    public c(@NonNull String str) {
        super(str, "");
        this.f16283i = f16281d;
    }

    @Override // sg.bigo.ads.controller.a.a.b, sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        super.a(parcel);
        parcel.writeLong(this.f16283i);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
    }

    @Override // sg.bigo.ads.controller.a.a.b, sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        super.b(parcel);
        this.f16283i = n.a(parcel, f16281d);
        this.g = n.a(parcel, 0L);
        this.h = n.a(parcel, 0L);
    }

    @Override // sg.bigo.ads.controller.a.a.b
    public final void a(@NonNull JSONObject jSONObject, boolean z2, String str, int i2) {
        super.a(jSONObject, z2, str, i2);
        this.f16283i = Math.max(jSONObject.optLong("interval", f16281d / 1000) * 1000, f16282f);
    }

    public final boolean a() {
        long j = this.g;
        long j3 = this.h;
        if (j == j3) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j > j3 ? Math.abs(jCurrentTimeMillis - this.g) > e : Math.abs(jCurrentTimeMillis - this.h) > this.f16283i;
    }
}
