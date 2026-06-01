package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.a.j;
import sg.bigo.ads.common.l;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements sg.bigo.ads.common.f, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16284a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16285b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16286c = 12;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16287d = 3;
    public int e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16288f = 10;
    public int g = 5;
    private sg.bigo.ads.api.a.h h;

    public d(sg.bigo.ads.api.a.h hVar) {
        this.h = hVar;
    }

    @Override // sg.bigo.ads.common.l
    public final int a() {
        return this.f16284a;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        this.f16284a = n.a(parcel, 3);
        this.f16285b = n.a(parcel, 2);
        this.f16286c = n.a(parcel, 12);
        this.f16287d = n.a(parcel, 3);
        this.e = n.a(parcel, 3);
        this.f16288f = n.a(parcel, 10);
        this.g = n.a(parcel, 5);
    }

    @Override // sg.bigo.ads.common.l
    public final int c() {
        return this.f16285b;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean d() {
        return a(13);
    }

    @Override // sg.bigo.ads.common.l
    public final int e() {
        return this.f16286c;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean f() {
        return a(10);
    }

    @Override // sg.bigo.ads.common.l
    public final int g() {
        return this.f16287d;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean h() {
        return a(11);
    }

    @Override // sg.bigo.ads.common.l
    public final int i() {
        return this.e;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean j() {
        return a(12);
    }

    @Override // sg.bigo.ads.common.l
    public final int k() {
        return this.f16288f;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean l() {
        return a(11);
    }

    @Override // sg.bigo.ads.common.l
    public final int m() {
        return this.g;
    }

    @Override // sg.bigo.ads.common.l
    public final boolean n() {
        return a(12);
    }

    @Override // sg.bigo.ads.common.l
    public final boolean o() {
        return a(18);
    }

    @Override // sg.bigo.ads.common.l
    public final boolean p() {
        return a(13);
    }

    @NonNull
    public final String toString() {
        return super.toString();
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        synchronized (this) {
            parcel.writeInt(this.f16284a);
            parcel.writeInt(this.f16285b);
            parcel.writeInt(this.f16286c);
            parcel.writeInt(this.f16287d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f16288f);
            parcel.writeInt(this.g);
        }
    }

    @Override // sg.bigo.ads.common.l
    public final boolean b() {
        return a(13);
    }

    private boolean a(int i2) {
        sg.bigo.ads.api.a.h hVar = this.h;
        j jVarN = hVar != null ? hVar.n() : null;
        if (jVarN != null) {
            return jVarN.a(i2);
        }
        return false;
    }
}
