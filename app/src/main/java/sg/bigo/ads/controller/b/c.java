package sg.bigo.ads.controller.b;

import android.os.Parcel;
import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements sg.bigo.ads.api.a.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[][] f16400n = {new int[]{1, 2}, new int[]{3, 4}};
    int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16401a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16402b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f16403c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f16404d = 0;
    int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f16405f = 0;
    int g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    final a f16406i = new a(3);

    @NonNull
    final a j = new a(4);

    @NonNull
    final a k = new a(12);

    @NonNull
    final a l = new a(1);

    @NonNull
    final a m = new a(20);

    public class a implements sg.bigo.ads.common.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16407a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16408b = 20;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16409c = 5;
        private int e;

        public a(int i2) {
            this.e = i2;
        }

        @Override // sg.bigo.ads.common.f
        public final void a(@NonNull Parcel parcel) {
            parcel.writeInt(this.f16407a);
            parcel.writeInt(this.f16408b);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f16409c);
        }

        @Override // sg.bigo.ads.common.f
        public final void b(@NonNull Parcel parcel) {
            this.f16407a = parcel.readInt();
            this.f16408b = parcel.readInt();
            this.e = parcel.readInt();
            this.f16409c = parcel.readInt();
        }

        public final void a(JSONObject jSONObject) {
            String str;
            int i2 = this.e;
            if (i2 == 1) {
                this.f16407a = jSONObject.optInt("nat_load_fail_fill", 0);
                this.f16409c = jSONObject.optInt("nat_time_for_check_process", 5);
                str = "nat_min_video_loading_pro";
            } else if (i2 == 12) {
                this.f16407a = jSONObject.optInt("spl_load_fail_fill", 0);
                this.f16409c = jSONObject.optInt("spl_time_for_check_process", 5);
                str = "spl_min_video_loading_pro";
            } else if (i2 == 20) {
                this.f16407a = jSONObject.optInt("pop_load_fail_fill", 0);
                this.f16409c = jSONObject.optInt("pop_time_for_check_process", 5);
                str = "pop_min_video_loading_pro";
            } else if (i2 == 3) {
                this.f16407a = jSONObject.optInt("int_load_fail_fill", 0);
                this.f16409c = jSONObject.optInt("int_time_for_check_process", 5);
                str = "int_min_video_loading_pro";
            } else {
                if (i2 != 4) {
                    return;
                }
                this.f16407a = jSONObject.optInt("rew_load_fail_fill", 0);
                this.f16409c = jSONObject.optInt("rew_time_for_check_process", 5);
                str = "rew_min_video_loading_pro";
            }
            this.f16408b = jSONObject.optInt(str, 20);
        }
    }

    @Override // sg.bigo.ads.api.a.d
    public final int a() {
        return this.f16401a;
    }

    @Override // sg.bigo.ads.api.a.d
    public final int b(int i2) {
        a aVar;
        if (i2 == 1) {
            aVar = this.l;
        } else if (i2 == 12) {
            aVar = this.k;
        } else if (i2 == 20) {
            aVar = this.m;
        } else if (i2 == 3) {
            aVar = this.f16406i;
        } else {
            if (i2 != 4) {
                return 5;
            }
            aVar = this.j;
        }
        return aVar.f16409c;
    }

    @Override // sg.bigo.ads.api.a.d
    public final boolean c(int i2) {
        return i2 != 1 ? i2 != 12 ? i2 != 20 ? i2 != 3 ? i2 == 4 && this.j.f16407a == 1 : this.f16406i.f16407a == 1 : this.m.f16407a == 1 : this.k.f16407a == 1 : this.l.f16407a == 1;
    }

    @Override // sg.bigo.ads.api.a.d
    public final int d(int i2) {
        a aVar;
        if (i2 == 1) {
            aVar = this.l;
        } else if (i2 == 12) {
            aVar = this.k;
        } else if (i2 == 20) {
            aVar = this.m;
        } else if (i2 == 3) {
            aVar = this.f16406i;
        } else {
            if (i2 != 4) {
                return 20;
            }
            aVar = this.j;
        }
        return aVar.f16408b;
    }

    @Override // sg.bigo.ads.api.a.d
    public final int a(int i2) {
        if (i2 == 1) {
            return this.g;
        }
        if (i2 == 12) {
            return this.f16405f;
        }
        if (i2 == 20) {
            return this.h;
        }
        if (i2 == 3) {
            return this.f16404d;
        }
        if (i2 != 4) {
            return 0;
        }
        return this.e;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f16401a = parcel.readInt();
        this.f16402b = parcel.readString();
        this.f16403c = parcel.readString();
        this.f16404d = parcel.readInt();
        this.e = parcel.readInt();
        this.f16405f = parcel.readInt();
        this.g = parcel.readInt();
        n.b(parcel, this.f16406i);
        n.b(parcel, this.j);
        n.b(parcel, this.k);
        n.b(parcel, this.l);
        this.h = parcel.readInt();
        n.b(parcel, this.m);
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeInt(this.f16401a);
        parcel.writeString(this.f16402b);
        parcel.writeString(this.f16403c);
        parcel.writeInt(this.f16404d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f16405f);
        parcel.writeInt(this.g);
        n.a(parcel, this.f16406i);
        n.a(parcel, this.j);
        n.a(parcel, this.k);
        n.a(parcel, this.l);
        parcel.writeInt(this.h);
        n.a(parcel, this.m);
    }

    @Override // sg.bigo.ads.api.a.d
    public final boolean a(String str, int i2) {
        int i8 = !q.a((CharSequence) this.f16402b) ? 1 : 0;
        int i9 = !q.a((CharSequence) this.f16403c) ? 1 : 0;
        if (a(i2) > 0) {
            int i10 = f16400n[i8][i9];
            if (i10 != 1) {
                if (i10 != 2) {
                    return i10 == 3 && q.a(this.f16402b.split(","), str);
                }
                if (!q.a(this.f16403c.split(","), str)) {
                }
            }
            return true;
        }
        return false;
    }
}
