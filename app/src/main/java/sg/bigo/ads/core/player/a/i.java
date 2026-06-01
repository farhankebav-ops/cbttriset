package sg.bigo.ads.core.player.a;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f17308b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f17310d;
    public sg.bigo.ads.common.h.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17307a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f17309c = new Object();

    public final int a(byte[] bArr, long j) throws j {
        if (j < 0) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "buffer or offset or length is wrong");
            return 0;
        }
        int i2 = 0;
        while (!this.f17308b.c() && this.f17308b.a() < 8192 + j && !this.f17310d) {
            i2++;
            synchronized (this.f17307a) {
                try {
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "wait for downloading. thread=" + Thread.currentThread().getName() + ",url=" + this.e.f15728b + ",count=" + i2);
                    this.f17307a.wait(1000L);
                } catch (InterruptedException e) {
                    sg.bigo.ads.common.t.a.a(0, "ProxyCache", "Waiting source data is interrupted!" + e.toString());
                }
            }
            if (i2 >= 15) {
                sg.bigo.ads.common.t.a.a(0, "ProxyCache", "wait for downloading more than 15s.");
                throw new j(a1.a.h(i2, "Error reading source ", " times"));
            }
        }
        int iA = this.f17308b.a(bArr, j);
        if (iA <= 0) {
            sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "read end, size = ".concat(String.valueOf(iA)));
        }
        return iA;
    }
}
