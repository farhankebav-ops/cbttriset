package sg.bigo.ads.api.core;

/* JADX INFO: loaded from: classes6.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15540d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15537a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15538b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15539c = 0;
    public long e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15541f = 0;
    public String g = "";
    public boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f15542i = "";
    private long k = 0;
    private long l = 0;
    private long m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f15543n = 0;
    public boolean j = false;

    public u(int i2) {
        this.f15540d = i2;
    }

    public final void a(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i2 == 1) {
            if (this.k <= 0) {
                this.k = jCurrentTimeMillis;
            }
        } else if (i2 == 2) {
            if (this.l <= 0) {
                this.l = jCurrentTimeMillis;
            }
        } else {
            if (i2 != 3) {
                return;
            }
            if (this.m <= 0) {
                this.m = jCurrentTimeMillis;
            }
            if (this.f15543n <= 0) {
                this.f15543n = jCurrentTimeMillis;
            }
        }
    }

    public final void b(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i2 == 1) {
            if (this.f15538b <= 0) {
                long j = this.k;
                if (j > 0) {
                    this.f15538b = jCurrentTimeMillis - j;
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 2) {
            this.j = true;
            if (this.f15539c <= 0) {
                long j3 = this.l;
                if (j3 > 0) {
                    this.f15539c = jCurrentTimeMillis - j3;
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (this.e <= 0) {
                long j8 = this.m;
                if (j8 > 0) {
                    this.e = jCurrentTimeMillis - j8;
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 4 && this.f15541f <= 0) {
            long j9 = this.f15543n;
            if (j9 > 0) {
                this.f15541f = jCurrentTimeMillis - j9;
            }
        }
    }

    public final void a(String str, String str2, boolean z2) {
        this.g = str;
        this.f15542i = str2;
        this.h = z2;
    }
}
