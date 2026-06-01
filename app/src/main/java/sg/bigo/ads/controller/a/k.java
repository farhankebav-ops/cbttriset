package sg.bigo.ads.controller.a;

import android.os.Parcel;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes6.dex */
public class k implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16386c;

    public k() {
    }

    @Override // sg.bigo.ads.common.f
    @CallSuper
    public void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f16386c);
        parcel.writeString(this.f16384a);
        n.a(parcel, this.f16385b);
    }

    @Override // sg.bigo.ads.common.f
    @CallSuper
    public void b(@NonNull Parcel parcel) {
        this.f16386c = n.a(parcel, "");
        this.f16384a = n.a(parcel, "");
        this.f16385b = n.b(parcel, false);
    }

    @NonNull
    public String toString() {
        return super.toString();
    }

    public k(String str, String str2, boolean z2) {
        this.f16386c = str;
        this.f16384a = str2;
        this.f16385b = z2;
    }
}
