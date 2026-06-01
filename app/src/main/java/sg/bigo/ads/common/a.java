package sg.bigo.ads.common;

import android.os.Parcel;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15554a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15557d;

    private a() {
        this.f15555b = "";
        this.f15556c = true;
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f15555b);
        parcel.writeInt(this.f15556c ? 1 : 0);
        parcel.writeLong(this.f15557d);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f15555b = parcel.readString();
        this.f15556c = parcel.readInt() != 0;
        this.f15557d = parcel.readLong();
    }

    public final String toString() {
        return "{advertisingId='" + this.f15555b + "', isLimitAdTrackingEnabled=" + this.f15556c + ", lastUpdateTime=" + this.f15557d + '}';
    }

    public a(@NonNull Parcel parcel) {
        b(parcel);
    }

    public final boolean a() {
        return Math.abs(r.b() - this.f15557d) > r.f16037d.a(1);
    }

    public a(@NonNull String str, boolean z2) {
        this.f15555b = str;
        this.f15556c = z2;
        this.f15557d = r.b();
    }
}
