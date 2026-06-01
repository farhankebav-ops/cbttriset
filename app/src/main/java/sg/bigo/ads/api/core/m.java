package sg.bigo.ads.api.core;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements sg.bigo.ads.api.a.j, sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15519a = 0;

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeLong(this.f15519a);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f15519a = parcel.readLong();
    }

    public final String toString() {
        return "{value=" + this.f15519a + '}';
    }

    @Override // sg.bigo.ads.api.a.j
    public final boolean a(int i2) {
        return (this.f15519a & (1 << i2)) != 0;
    }
}
