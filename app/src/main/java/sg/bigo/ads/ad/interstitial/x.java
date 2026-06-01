package sg.bigo.ads.ad.interstitial;

/* JADX INFO: loaded from: classes6.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15197d;
    public int e;
    public int j;
    public boolean k;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15200n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15198f = false;
    public boolean g = false;
    public boolean h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15199i = 0;
    public int l = 0;

    public static int a(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 3;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 10;
        }
        return 5;
    }

    public static int b(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 != 1) {
            return i2 != 3 ? 5 : 10;
        }
        return 3;
    }
}
