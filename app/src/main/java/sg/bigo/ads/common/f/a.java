package sg.bigo.ads.common.f;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private static final a e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f15608a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f15609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f15610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0284a f15611d;

    /* JADX INFO: renamed from: sg.bigo.ads.common.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0284a {
        void a(long j, long j3);

        void a(boolean z2, long j, long j3, long j8);
    }

    private a() {
        b();
    }

    public static a a() {
        return e;
    }

    public final void b() {
        this.f15609b = SystemClock.elapsedRealtime();
        this.f15610c = System.currentTimeMillis();
    }

    public final boolean c() {
        return this.f15609b > 0;
    }
}
