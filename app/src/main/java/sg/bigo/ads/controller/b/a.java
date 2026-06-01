package sg.bigo.ads.controller.b;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
final class a implements sg.bigo.ads.api.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f16387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f16389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f16390d;
    String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f16391f;
    String g;

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeLong(this.f16387a);
        parcel.writeString(this.f16388b);
        parcel.writeString(this.f16389c);
        parcel.writeString(this.f16390d);
        parcel.writeString(this.e);
        parcel.writeString(this.f16391f);
        parcel.writeString(this.g);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f16387a = parcel.readLong();
        this.f16388b = parcel.readString();
        this.f16389c = parcel.readString();
        this.f16390d = parcel.readString();
        this.e = parcel.readString();
        this.f16391f = parcel.readString();
        this.g = parcel.readString();
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("{expressId=");
        sb.append(this.f16387a);
        sb.append(", name='");
        sb.append(this.f16388b);
        sb.append("', url='");
        sb.append(this.f16389c);
        sb.append("', md5='");
        sb.append(this.f16390d);
        sb.append("', style='");
        sb.append(this.e);
        sb.append("', adTypes='");
        sb.append(this.f16391f);
        sb.append("', fileId='");
        return a1.a.r(sb, this.g, "'}");
    }
}
