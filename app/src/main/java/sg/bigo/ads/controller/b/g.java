package sg.bigo.ads.controller.b;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.ironsource.adqualitysdk.sdk.i.a0;
import sg.bigo.ads.api.a.k;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements k, sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f16431a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f16432b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f16433c = 0;

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        n.a(parcel, this.f16431a);
        n.a(parcel, this.f16432b);
        parcel.writeInt(this.f16433c);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f16431a = n.b(parcel, true);
        this.f16431a = n.b(parcel, false);
        this.f16433c = n.a(parcel, 0);
    }

    @Override // sg.bigo.ads.api.a.k
    public final int c() {
        return this.f16433c;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("{isNativeVideoClickable=");
        sb.append(this.f16431a);
        sb.append(", isNativeVideoClickable=");
        sb.append(this.f16431a);
        sb.append(", clickTriggerType=");
        return a0.c(sb, this.f16433c, '}');
    }

    @Override // sg.bigo.ads.api.a.k
    public final boolean a() {
        return this.f16431a;
    }

    @Override // sg.bigo.ads.api.a.k
    public final boolean b() {
        return this.f16432b;
    }
}
