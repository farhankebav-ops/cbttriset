package k4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12694d;
    public final v e;
    public final /* synthetic */ y g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.j f12691a = new l7.j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12695f = false;

    public w(y yVar, int i2, int i8, v vVar) {
        this.g = yVar;
        this.f12692b = i2;
        this.f12693c = i8;
        this.e = vVar;
    }

    public final int a(int i2) {
        if (i2 <= 0 || Integer.MAX_VALUE - i2 >= this.f12693c) {
            int i8 = this.f12693c + i2;
            this.f12693c = i8;
            return i8;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.f12692b);
    }

    public final void b(int i2, boolean z2, l7.j jVar) {
        do {
            int iMin = Math.min(i2, ((d) this.g.f12699c).f12625b.f12615a.f12963d);
            int i8 = -iMin;
            ((w) this.g.f12700d).a(i8);
            a(i8);
            try {
                boolean z7 = false;
                ((d) this.g.f12699c).a(jVar.f12868b == ((long) iMin) && z2, this.f12692b, jVar, iMin);
                j4.c cVar = (j4.c) this.e;
                synchronized (cVar.f12135b) {
                    r2.q.H(cVar.f12138f, "onStreamAllocated was not called, but it seems the stream is active");
                    int i9 = cVar.e;
                    boolean z8 = i9 < 32768;
                    int i10 = i9 - iMin;
                    cVar.e = i10;
                    boolean z9 = i10 < 32768;
                    if (!z8 && z9) {
                        z7 = true;
                    }
                }
                if (z7) {
                    cVar.f();
                }
                i2 -= iMin;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (i2 > 0);
    }

    public final void c(int i2, x xVar) {
        int i8 = this.f12693c;
        y yVar = this.g;
        int iMin = Math.min(i2, Math.min(i8, ((w) yVar.f12700d).f12693c));
        int i9 = 0;
        while (true) {
            l7.j jVar = this.f12691a;
            long j = jVar.f12868b;
            if (j <= 0 || iMin <= 0) {
                return;
            }
            if (iMin >= j) {
                int i10 = (int) j;
                i9 += i10;
                b(i10, this.f12695f, jVar);
            } else {
                i9 += iMin;
                b(iMin, false, jVar);
            }
            xVar.f12696a++;
            iMin = Math.min(i2 - i9, Math.min(this.f12693c, ((w) yVar.f12700d).f12693c));
        }
    }
}
