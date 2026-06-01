package sg.bigo.ads.api.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.api.core.q;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T extends Ad, U extends sg.bigo.ads.api.core.c> implements Ad, d<T> {

    @NonNull
    protected final sg.bigo.ads.api.b R;

    @NonNull
    protected sg.bigo.ads.common.v.a S;
    protected a U;
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    protected int T = sg.bigo.ads.common.v.a.f16050a;
    protected int V = 0;
    protected final p W = new p();

    /* JADX INFO: renamed from: sg.bigo.ads.api.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0277a {
        void a(sg.bigo.ads.api.core.d dVar);

        void b();
    }

    public a(@NonNull sg.bigo.ads.api.b bVar) {
        this.R = bVar;
    }

    public final a I() {
        return this.U;
    }

    @Nullable
    public final q J() {
        sg.bigo.ads.api.core.c cVarF = f();
        if (cVarF != null) {
            return cVarF.Y();
        }
        return null;
    }

    public final int K() {
        return this.T;
    }

    @NonNull
    public final sg.bigo.ads.api.b L() {
        return this.R;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Ad ad) {
        if (ad == null) {
            return 1;
        }
        return g() >= (ad instanceof a ? ((a) ad).g() : 0.0d) ? 1 : -1;
    }

    public abstract void a(int i2, int i8, String str);

    public abstract void b();

    public void b(int i2) {
        this.Q = i2;
    }

    public int b_() {
        int i2 = this.V + 1;
        this.V = i2;
        return i2;
    }

    public abstract void c();

    public void c(int i2) {
        this.T = i2;
    }

    public p c_() {
        return this.W;
    }

    public abstract String d();

    public abstract long e();

    @NonNull
    public abstract U f();

    public double g() {
        AdBid bid = getBid();
        return bid != null ? bid.getPrice() : (sg.bigo.ads.common.j.a.a(d(), e()) * 1.0d) / 1.0E8d;
    }

    public void a(int i2) {
        this.P = i2;
    }

    public void a(String str, String str2, int i2) {
    }

    public void a(boolean z2, boolean z7) {
        this.O = z7 ? 1 : !z2 ? 2 : 3;
    }
}
