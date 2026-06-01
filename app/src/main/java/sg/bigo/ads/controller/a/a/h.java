package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16309d;
    public long e;

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        synchronized (this) {
            parcel.writeLong(this.f16306a);
            parcel.writeLong(this.f16307b);
            parcel.writeLong(this.f16308c);
            parcel.writeLong(this.f16309d);
            parcel.writeLong(this.e);
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        synchronized (this) {
            this.f16306a = n.a(parcel, 0L);
            this.f16307b = n.a(parcel, 0L);
            this.f16308c = n.a(parcel, 0L);
            this.f16309d = n.a(parcel, 0L);
            this.e = n.a(parcel, 0L);
        }
    }

    @NonNull
    public final String toString() {
        return super.toString();
    }
}
