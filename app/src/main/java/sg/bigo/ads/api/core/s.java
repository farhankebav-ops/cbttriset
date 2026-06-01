package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class s implements sg.bigo.ads.api.a.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15533a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15534b = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15535c = 21600000;

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f15533a + "," + this.f15534b + "," + this.f15535c);
    }

    @Override // sg.bigo.ads.api.a.n
    public final long b() {
        return this.f15534b;
    }

    @Override // sg.bigo.ads.api.a.n
    public final long c() {
        return this.f15535c;
    }

    @Override // sg.bigo.ads.api.a.n
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f15533a = jSONObject.optInt("duration_on", 0);
            this.f15534b = jSONObject.optLong("duration_valid_interval", 5000L);
            this.f15535c = jSONObject.optLong("suspend_limit", 21600000L);
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            String string = parcel.readString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length >= 3) {
                this.f15533a = sg.bigo.ads.common.utils.q.a(strArrSplit[0], 0);
                this.f15534b = sg.bigo.ads.common.utils.q.a(strArrSplit[1], 5000L);
                this.f15535c = sg.bigo.ads.common.utils.q.a(strArrSplit[2], 21600000L);
            }
        }
    }

    @Override // sg.bigo.ads.api.a.n
    public final boolean a() {
        return this.f15533a == 1;
    }
}
