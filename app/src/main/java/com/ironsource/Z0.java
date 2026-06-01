package com.ironsource;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Z0 implements Parcelable {
    public static final Parcelable.Creator<Z0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7878d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<String> f7879f;
    private ArrayList<String> g;
    private ArrayList<String> h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<String> f7880i;
    private String j;
    private String k;
    private Map<String, String> l;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Parcelable.Creator<Z0> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Z0 createFromParcel(Parcel parcel) {
            return new Z0(parcel, 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Z0[] newArray(int i2) {
            return new Z0[i2];
        }
    }

    public /* synthetic */ Z0(Parcel parcel, int i2) {
        this(parcel);
    }

    private void i() {
        this.f7878d = false;
        this.e = -1;
        this.f7879f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.f7880i = new ArrayList<>();
        this.k = "";
        this.j = "";
        this.l = new HashMap();
    }

    public void a(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2) {
            this.g.remove(str);
        } else if (this.g.indexOf(str) == -1) {
            this.g.add(str);
        }
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && this.g.indexOf(str) > -1;
    }

    public boolean c(String str) {
        return !TextUtils.isEmpty(str) && this.f7880i.indexOf(str) > -1;
    }

    public String d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> e() {
        return this.l;
    }

    public String f() {
        return this.k;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public boolean j() {
        return this.f7878d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:");
            sb.append(this.f7878d);
            sb.append(", ");
            sb.append("displayedProduct:");
            sb.append(this.e);
            sb.append(", ");
            sb.append("ISReportInit:");
            sb.append(this.f7879f);
            sb.append(", ");
            sb.append("ISInitSuccess:");
            sb.append(this.g);
            sb.append(", ");
            sb.append("ISAppKey");
            sb.append(this.j);
            sb.append(", ");
            sb.append("ISUserId");
            sb.append(this.k);
            sb.append(", ");
            sb.append("ISExtraParams");
            sb.append(this.l);
            sb.append(", ");
        } catch (Throwable th) {
            C2531r4.d().a(th);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeByte(this.f7878d ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.e);
            parcel.writeString(this.f7875a);
            parcel.writeString(this.f7876b);
            parcel.writeString(this.f7877c);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(new JSONObject(this.l).toString());
        } catch (Throwable th) {
            C2531r4.d().a(th);
        }
    }

    public Z0() {
        i();
    }

    public boolean d(String str) {
        return !TextUtils.isEmpty(str) && this.f7879f.indexOf(str) > -1;
    }

    public boolean e(String str) {
        return !TextUtils.isEmpty(str) && this.h.indexOf(str) > -1;
    }

    public void f(String str) {
        this.f7877c = str;
    }

    public String g() {
        return this.f7875a;
    }

    public String h() {
        return this.f7876b;
    }

    public void j(String str) {
        this.f7876b = str;
    }

    public String b() {
        return this.f7877c;
    }

    public int c() {
        return this.e;
    }

    private Z0(Parcel parcel) {
        i();
        try {
            this.f7878d = parcel.readByte() != 0;
            this.e = parcel.readInt();
            this.f7875a = parcel.readString();
            this.f7876b = parcel.readString();
            this.f7877c = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = a(parcel.readString());
        } catch (Throwable th) {
            C2531r4.d().a(th);
            i();
        }
    }

    public void b(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            if (this.f7880i.indexOf(str) == -1) {
                this.f7880i.add(str);
                return;
            }
            return;
        }
        this.f7880i.remove(str);
    }

    public void c(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            if (this.f7879f.indexOf(str) == -1) {
                this.f7879f.add(str);
                return;
            }
            return;
        }
        this.f7879f.remove(str);
    }

    public void d(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            if (this.h.indexOf(str) == -1) {
                this.h.add(str);
                return;
            }
            return;
        }
        this.h.remove(str);
    }

    public void a(Map<String, String> map) {
        this.l = map;
    }

    public void a(boolean z2) {
        this.f7878d = z2;
    }

    public void a(int i2) {
        this.e = i2;
    }

    public void a() {
        this.e = -1;
    }

    private Map<String, String> a(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
        return map;
    }

    public void i(String str) {
        this.f7875a = str;
    }
}
