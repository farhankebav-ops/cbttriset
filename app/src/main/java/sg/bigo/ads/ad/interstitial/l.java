package sg.bigo.ads.ad.interstitial;

import android.os.SystemClock;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14821a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14822b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f14823c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f14824d = 4;
    int e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14825f = 6;
    int g = 7;
    int h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f14826i = 1;
    int j = 2;
    long k = 0;
    long l = 0;
    long m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int[] f14827n = new int[10];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long[] f14828o = new long[10];
    long[] p = new long[10];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean[][] f14829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean[][] f14830r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f14831s;

    public l() {
        Class cls = Boolean.TYPE;
        this.f14829q = (boolean[][]) Array.newInstance((Class<?>) cls, 10, 10);
        this.f14830r = (boolean[][]) Array.newInstance((Class<?>) cls, 10, 10);
        this.f14831s = false;
    }

    private int a() {
        return (this.k == 0 || SystemClock.elapsedRealtime() - this.k > 5000) ? this.j : this.f14826i;
    }

    public final void a(int i2) {
        try {
            long[] jArr = this.f14828o;
            if (jArr[i2] == 0) {
                jArr[i2] = SystemClock.elapsedRealtime();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(sg.bigo.ads.api.core.c cVar, int i2) {
        try {
            long[] jArr = this.f14828o;
            if (jArr[i2] == 0) {
                jArr[i2] = SystemClock.elapsedRealtime();
            }
            if (this.p[i2] != 0) {
                int[] iArr = this.f14827n;
                int i8 = iArr[i2];
                iArr[i2] = 0;
                a(cVar, i2, i8);
            }
        } catch (Exception unused) {
        }
    }

    private void a(sg.bigo.ads.api.core.c cVar, int i2, int i8) {
        try {
            boolean[] zArr = this.f14830r[i8];
            if (zArr[i2]) {
                return;
            }
            zArr[i2] = true;
            sg.bigo.ads.core.d.b.a(cVar, i2, i8, SystemClock.elapsedRealtime() - this.p[i2]);
        } catch (Exception unused) {
        }
    }

    public final void a(sg.bigo.ads.api.core.c cVar, int i2, int i8, int i9, int i10, int i11) {
        try {
            this.p[i2] = SystemClock.elapsedRealtime();
            this.f14827n[i2] = a();
            a(cVar, i2, this.f14827n[i2], i8, i9, i10, i11);
        } catch (Exception unused) {
        }
    }

    private void a(sg.bigo.ads.api.core.c cVar, int i2, int i8, int i9, int i10, int i11, int i12) {
        long jElapsedRealtime;
        long j;
        try {
            if (this.f14831s) {
                return;
            }
            boolean[] zArr = this.f14829q[i8];
            if (zArr[i2]) {
                return;
            }
            zArr[i2] = true;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.f14828o[i2];
            if (i2 == this.f14821a) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.f14828o[i2];
            } else {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                j = this.l;
            }
            sg.bigo.ads.core.d.b.a(cVar, i2, i8, jElapsedRealtime2, jElapsedRealtime - j, i9, i10, i11, i12);
        } catch (Exception unused) {
        }
    }
}
