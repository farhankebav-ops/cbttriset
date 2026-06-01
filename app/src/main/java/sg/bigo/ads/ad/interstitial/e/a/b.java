package sg.bigo.ads.ad.interstitial.e.a;

import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f14629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f14630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f14631d;
    protected final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f14632f;
    protected final int g;
    protected final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final int f14633i;
    protected final int j;
    protected final a k = new a(this, 0);
    protected final int l;
    protected final int m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f14634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14637d;
        public final int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f14638f;
        public final int g;
        public final int h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f14639i;
        public final int j;
        public final int k;
        public final int l;

        /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private a(@androidx.annotation.NonNull sg.bigo.ads.ad.interstitial.e.a.b r9) {
            /*
                r8 = this;
                r8.<init>()
                int r0 = sg.bigo.ads.ad.interstitial.d.f14442b
                int r1 = r9.h()
                r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                r3 = 3
                r4 = 1041865114(0x3e19999a, float:0.15)
                r5 = 0
                r6 = -1
                r7 = 2
                if (r1 == r7) goto L3c
                if (r1 == r3) goto L25
                r8.f14634a = r5
                r8.f14635b = r6
                int r1 = sg.bigo.ads.common.w.b.a(r0, r4)
                r8.f14636c = r1
                r8.f14637d = r0
                r8.f14638f = r0
                goto L41
            L25:
                r1 = 1
                r8.f14634a = r1
                r1 = 1050253722(0x3e99999a, float:0.3)
                int r1 = sg.bigo.ads.common.w.b.a(r2, r1)
                r8.f14635b = r1
            L31:
                int r1 = sg.bigo.ads.common.w.b.a(r6, r4)
                r8.f14636c = r1
                r8.f14637d = r6
                r8.f14638f = r6
                goto L41
            L3c:
                r8.f14634a = r5
                r8.f14635b = r2
                goto L31
            L41:
                int r1 = r8.f14638f
                r2 = 128(0x80, float:1.8E-43)
                int r1 = sg.bigo.ads.common.w.b.a(r1, r2)
                r8.e = r1
                int r1 = r9.e()
                if (r1 == r7) goto L5d
                r2 = 4
                if (r1 == r2) goto L5d
                int r1 = r8.f14635b
                r8.g = r1
                int r1 = r8.f14636c
                r8.h = r1
                goto L61
            L5d:
                r8.g = r5
                r8.h = r5
            L61:
                r8.f14639i = r6
                int r0 = sg.bigo.ads.common.w.b.a(r0, r4)
                r8.j = r0
                int r9 = r9.g()
                if (r9 == r7) goto L81
                if (r9 == r3) goto L79
                r9 = -16736769(0xffffffffff009dff, float:-1.7096155E38)
                r8.k = r9
                r8.l = r5
                return
            L79:
                r9 = 872415231(0x33ffffff, float:1.1920928E-7)
                r8.k = r9
                r8.l = r6
                return
            L81:
                r9 = -14972829(0xffffffffff1b8863, float:-2.067385E38)
                r8.k = r9
                r8.l = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.e.a.b.a.<init>(sg.bigo.ads.ad.interstitial.e.a.b):void");
        }

        public /* synthetic */ a(b bVar, byte b8) {
            this(bVar);
        }
    }

    public b(int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f14629b = i2;
        this.f14630c = i8;
        this.f14631d = i9;
        this.e = i10;
        this.f14632f = i11;
        this.g = i12;
        this.h = i13;
        this.f14633i = i14;
        this.j = i15;
        this.l = i16;
        this.m = i17;
    }

    public static int a(b bVar) {
        if (bVar == null) {
            return 0;
        }
        if (bVar.a()) {
            return 1;
        }
        int iE = bVar.e();
        int i2 = 3;
        if (iE == 3 || iE == 4) {
            return 2;
        }
        if (iE != 5) {
            i2 = 6;
            if (iE != 6) {
                return 4;
            }
        }
        return i2;
    }

    public int b() {
        return 9;
    }

    @NonNull
    public final a c() {
        return this.k;
    }

    public final int d() {
        int i2 = this.f14629b;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) {
            return i2;
        }
        return 0;
    }

    public int e() {
        int i2 = this.f14630c;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return i2;
        }
        return 1;
    }

    public int f() {
        int i2 = this.f14630c;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            return i2;
        }
        return 1;
    }

    public final int g() {
        int i2 = this.f14631d;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return i2;
        }
        return 1;
    }

    public final int h() {
        int i2 = this.e;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return i2;
        }
        return 1;
    }

    public final int i() {
        return Math.max(1, this.f14632f);
    }

    public final long j() {
        return r.f16034a.a(Math.min(99, Math.max(0, this.g)));
    }

    public final long k() {
        int i2 = this.h;
        return i2 < 0 ? r.f16034a.a(0) : r.f16034a.a(i2);
    }

    public final int l() {
        int i2 = this.f14633i;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return i2;
        }
        return 3;
    }

    public final int m() {
        int i2 = this.l;
        if (i2 < 0 || i2 > 4) {
            return 0;
        }
        return i2;
    }

    public final int n() {
        return Math.max(1, this.m);
    }

    public final int o() {
        int i2 = this.j;
        if (i2 < 0) {
            return -1;
        }
        return i2;
    }

    public static boolean b(b bVar) {
        return bVar == null || bVar.d() == 0;
    }

    public boolean a() {
        return false;
    }
}
