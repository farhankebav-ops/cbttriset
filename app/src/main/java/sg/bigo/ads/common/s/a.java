package sg.bigo.ads.common.s;

import android.content.Context;
import android.os.Parcel;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f15928a = r.f16036c.a(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f15931d;
    private double e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15932f;
    private String g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f15933i;

    public a(@NonNull Context context) {
        this(context, (byte) 0);
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeDouble(this.f15931d);
        parcel.writeDouble(this.e);
        parcel.writeString(this.f15932f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.f15933i);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f15931d = parcel.readDouble();
        this.e = parcel.readDouble();
        this.f15932f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.f15933i = parcel.readLong();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{longitude=");
        sb.append(this.f15931d);
        sb.append(", latitude=");
        sb.append(this.e);
        sb.append(", countryCode='");
        sb.append(this.f15932f);
        sb.append("', state='");
        sb.append(this.g);
        sb.append("', city='");
        sb.append(this.h);
        sb.append("', updateTime='");
        return a1.a.p(sb, this.f15933i, "'}");
    }

    private a(@NonNull Context context, byte b8) {
        this.f15930c = false;
        this.f15929b = context;
        this.f15933i = 0L;
    }

    public a(@NonNull Context context, @NonNull Parcel parcel) {
        this.f15930c = false;
        this.f15929b = context;
        b(parcel);
    }
}
