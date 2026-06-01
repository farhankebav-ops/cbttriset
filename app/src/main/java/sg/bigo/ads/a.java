package sg.bigo.ads;

import android.content.Context;
import android.os.Parcel;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13773a;

    public a(@NonNull Context context) {
        super(context);
    }

    @Override // sg.bigo.ads.common.e
    public final String a() {
        return "bigo_app.dat";
    }

    @Override // sg.bigo.ads.common.e
    public final String b() {
        return "bigo_app.dat";
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f13773a);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f13773a = n.a(parcel, "");
    }
}
