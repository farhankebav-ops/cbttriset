package sg.bigo.ads.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.core.i;

/* JADX INFO: loaded from: classes6.dex */
public interface o extends sg.bigo.ads.api.core.c {

    public interface a {
        int a();

        int b();

        String c();
    }

    public interface b {
        int a();

        long b();

        int c();

        long d();
    }

    public interface c {
        int a();

        int b();

        String c();
    }

    public interface d {
        long a();

        void a(long j);

        void a(boolean z2);

        boolean b();

        @IntRange(from = 1, to = 100)
        int c();

        boolean d();
    }

    @NonNull
    String a(Context context);

    void a(Pair<Bitmap, String> pair);

    void a(n nVar);

    @Nullable
    b aA();

    @Nullable
    d aB();

    int aC();

    int aD();

    long aE();

    boolean aF();

    boolean aG();

    int aH();

    String aI();

    String aJ();

    String aK();

    long aL();

    int aM();

    String aN();

    boolean aO();

    @Nullable
    String aP();

    @Nullable
    String aQ();

    boolean aR();

    boolean aS();

    @Nullable
    String aT();

    long aU();

    @Nullable
    n aV();

    boolean aW();

    void aX();

    String aY();

    boolean aZ();

    @Nullable
    a av();

    @Nullable
    i.b aw();

    @Nullable
    a[] ax();

    @Nullable
    c ay();

    @Nullable
    String az();

    @NonNull
    String b(Context context);

    void b(long j);

    void ba();

    boolean bb();

    void bc();

    int bd();

    int be();

    int bf();

    int bg();

    Pair<Bitmap, String> bh();

    boolean bi();

    void bj();

    void bk();

    boolean bl();

    String c(Context context);

    void c(String str);

    boolean c(@IntRange(from = 1, to = 100) long j);

    void d(String str);

    void f(int i2);

    void g(int i2);

    void h(int i2);

    void i(int i2);

    void j(int i2);

    void k(int i2);
}
