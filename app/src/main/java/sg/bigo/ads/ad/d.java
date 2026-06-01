package sg.bigo.ads.ad;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d<T extends Ad, U extends sg.bigo.ads.api.core.c> extends c<T, U> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    protected d<T, U>.a f14103w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f14104x;

    public final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f14109f;
        private long g;
        private int h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f14110i = 0;
        private long j = 0;
        private boolean k = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14105a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f14106b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f14107c = false;
        private boolean l = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Runnable f14108d = new Runnable() { // from class: sg.bigo.ads.ad.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                View view;
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f14028i || ((aVar.f14106b && aVar.f14107c) || (view = dVar.f14025c) == null)) {
                    aVar.a();
                    return;
                }
                Rect rect = new Rect();
                boolean z2 = sg.bigo.ads.common.ab.a.a(view, rect) || (d.this.n() && sg.bigo.ads.api.core.b.b(d.this.o()));
                if (z2) {
                    a aVar2 = a.this;
                    if (aVar2.f14105a == -1) {
                        aVar2.f14105a = u.a(view) ? 1 : 0;
                    }
                }
                if (z2) {
                    a aVar3 = a.this;
                    if (!aVar3.f14106b) {
                        a.a(aVar3, rect);
                    }
                    a aVar4 = a.this;
                    if (!aVar4.f14107c) {
                        a.b(aVar4, rect);
                    }
                }
                a aVar5 = a.this;
                if (aVar5.f14106b && aVar5.f14107c) {
                    aVar5.a();
                } else {
                    sg.bigo.ads.common.n.d.a(2, aVar5.f14108d, 500L);
                }
            }
        };

        public a() {
        }

        private float a(@NonNull Rect rect) {
            d dVar = d.this;
            if (dVar.f14025c == null || sg.bigo.ads.api.core.b.b(dVar.f14024b.f15496a.x())) {
                return 0.0f;
            }
            float height = d.this.f14025c.getHeight() * 1.0f * d.this.f14025c.getWidth();
            float fHeight = rect.height() * 1.0f * rect.width();
            if (height <= 0.0f) {
                return 0.0f;
            }
            return fHeight / height;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                r6 = this;
                boolean r0 = r6.l
                if (r0 == 0) goto L5
                return
            L5:
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = r0.p()
                r1 = 2
                if (r0 != r1) goto L15
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                long r2 = sg.bigo.ads.ad.d.a(r0)
                goto L1b
            L15:
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                long r2 = sg.bigo.ads.ad.d.b(r0)
            L1b:
                r6.f14109f = r2
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = r0.p()
                if (r0 != r1) goto L2c
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = sg.bigo.ads.ad.d.c(r0)
                goto L32
            L2c:
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = sg.bigo.ads.ad.d.d(r0)
            L32:
                r6.h = r0
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = r0.o()
                sg.bigo.ads.ad.d r2 = sg.bigo.ads.ad.d.this
                int r2 = r2.p()
                r3 = 1000(0x3e8, float:1.401E-42)
                r4 = 1
                if (r0 == r4) goto L53
                if (r0 == r1) goto L58
                r5 = 3
                if (r0 == r5) goto L58
                r5 = 4
                if (r0 == r5) goto L56
                r5 = 12
                if (r0 == r5) goto L53
                r3 = 0
                goto L58
            L53:
                if (r2 == r1) goto L56
                goto L58
            L56:
                r3 = 2000(0x7d0, float:2.803E-42)
            L58:
                long r2 = (long) r3
                r6.g = r2
                java.lang.Runnable r0 = r6.f14108d
                sg.bigo.ads.common.n.d.a(r1, r0)
                r6.l = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.d.a.b():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ void b(sg.bigo.ads.ad.d.a r9, android.graphics.Rect r10) {
            /*
                long r0 = r9.j
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto Le
                long r0 = android.os.SystemClock.elapsedRealtime()
                r9.j = r0
            Le:
                float r10 = r9.a(r10)
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                android.view.View r1 = r0.f14025c
                int r0 = r0.o()
                sg.bigo.ads.ad.d r2 = sg.bigo.ads.ad.d.this
                int r2 = r2.p()
                r3 = 1
                if (r1 == 0) goto L6f
                int r4 = r1.getMeasuredWidth()
                if (r4 <= 0) goto L6f
                int r4 = r1.getMeasuredHeight()
                if (r4 <= 0) goto L6f
                int r4 = r1.getHeight()
                int r1 = r1.getWidth()
                int r1 = r1 * r4
                r4 = 1050253722(0x3e99999a, float:0.3)
                r5 = 242000(0x3b150, float:3.39114E-40)
                r6 = 2
                r7 = 1056964608(0x3f000000, float:0.5)
                if (r0 == r3) goto L5c
                if (r0 == r6) goto L50
                r8 = 3
                if (r0 == r8) goto L81
                r8 = 4
                if (r0 == r8) goto L81
                r8 = 12
                if (r0 == r8) goto L5c
                goto L6f
            L50:
                if (r1 <= r5) goto L57
                int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r0 <= 0) goto L6f
                goto L81
            L57:
                int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r0 <= 0) goto L6f
                goto L81
            L5c:
                if (r2 != r6) goto L63
                int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r0 <= 0) goto L6f
                goto L81
            L63:
                if (r1 <= r5) goto L6a
                int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r0 <= 0) goto L6f
                goto L81
            L6a:
                int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r0 <= 0) goto L6f
                goto L81
            L6f:
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                int r0 = r0.o()
                boolean r0 = sg.bigo.ads.api.core.b.b(r0)
                if (r0 == 0) goto La4
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                boolean r0 = r0.h
                if (r0 != 0) goto La4
            L81:
                long r0 = android.os.SystemClock.elapsedRealtime()
                long r4 = r9.j
                long r0 = r0 - r4
                long r4 = r9.g
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 < 0) goto La4
                sg.bigo.ads.ad.d r0 = sg.bigo.ads.ad.d.this
                java.lang.Float r10 = java.lang.Float.valueOf(r10)
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r2 = 0
                r1[r2] = r10
                java.lang.String r10 = "%.4f"
                java.lang.String r10 = sg.bigo.ads.common.utils.q.a(r10, r1)
                r0.d(r10)
                r9.f14107c = r3
            La4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.d.a.b(sg.bigo.ads.ad.d$a, android.graphics.Rect):void");
        }

        public final void a() {
            sg.bigo.ads.common.n.d.a(this.f14108d);
            this.l = false;
        }

        public final void a(final View view, boolean z2) {
            d.this.f14025c = view;
            if (view == null) {
                return;
            }
            if (z2) {
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.d.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b();
                    }
                });
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.ad.d.a.3
                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view2) {
                        a.this.b();
                        view.removeOnAttachStateChangeListener(this);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view2) {
                        a.this.a();
                    }
                });
            }
        }

        public static /* synthetic */ void a(a aVar, Rect rect) {
            float fA;
            if (aVar.f14110i == 0) {
                aVar.f14110i = SystemClock.elapsedRealtime();
            }
            if (aVar.k) {
                fA = 0.0f;
            } else {
                fA = aVar.a(rect);
                View view = d.this.f14025c;
                int i2 = aVar.h;
                if ((view != null && view.getMeasuredHeight() > 0 && view.getMeasuredWidth() > 0 && (i2 == 0 || i2 <= 100.0f * fA)) || (sg.bigo.ads.api.core.b.b(d.this.o()) && !d.this.h)) {
                    aVar.k = true;
                }
            }
            long jMax = aVar.f14105a == 1 ? Math.max(r.f16034a.a(1), aVar.f14109f) : aVar.f14109f;
            if (!aVar.k || SystemClock.elapsedRealtime() - aVar.f14110i < jMax) {
                return;
            }
            if (fA == 0.0f) {
                fA = aVar.a(rect);
            }
            d.this.a("show_proportion", q.a("%.4f", Float.valueOf(fA)));
            d.this.a_();
            aVar.f14106b = true;
        }
    }

    public d(@NonNull g gVar) {
        super(gVar);
        this.f14104x = false;
        this.f14103w = new a();
    }

    public static /* synthetic */ long a(d dVar) {
        o.b bVarAA;
        sg.bigo.ads.api.core.c cVar = dVar.f14024b.f15496a;
        if (!(cVar instanceof o) || (bVarAA = ((o) cVar).aA()) == null) {
            return 0L;
        }
        return bVarAA.b();
    }

    public static /* synthetic */ long b(d dVar) {
        o.b bVarAA;
        sg.bigo.ads.api.core.c cVar = dVar.f14024b.f15496a;
        if (!(cVar instanceof o) || (bVarAA = ((o) cVar).aA()) == null) {
            return 0L;
        }
        return bVarAA.d();
    }

    public static /* synthetic */ int c(d dVar) {
        o.b bVarAA;
        sg.bigo.ads.api.core.c cVar = dVar.f14024b.f15496a;
        if (!(cVar instanceof o) || (bVarAA = ((o) cVar).aA()) == null) {
            return 0;
        }
        return bVarAA.a();
    }

    public static /* synthetic */ int d(d dVar) {
        o.b bVarAA;
        sg.bigo.ads.api.core.c cVar = dVar.f14024b.f15496a;
        if (!(cVar instanceof o) || (bVarAA = ((o) cVar).aA()) == null) {
            return 0;
        }
        return bVarAA.c();
    }

    @Override // sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        this.f14103w.a();
    }

    @Override // sg.bigo.ads.ad.c
    @CallSuper
    public final void k() {
        super.k();
        this.f14103w.a();
    }

    public final void w() {
        this.f14103w.b();
    }

    @Override // sg.bigo.ads.ad.c
    public void a() {
        super.a();
        d<T, U>.a aVar = this.f14103w;
        if (aVar != null) {
            aVar.a();
        }
        this.f14104x = false;
        this.f14103w = new a();
    }

    public final void d(String str) {
        if (this.f14104x) {
            return;
        }
        this.f14104x = true;
        String strI = i();
        int iIntValue = ((Integer) b("render_style", 0)).intValue();
        if (a("06002029")) {
            sg.bigo.ads.core.d.b.a(this, str, strI, iIntValue);
        }
        sg.bigo.ads.api.b.a aVar = this.U;
        if (aVar != null) {
            aVar.a(str, strI, iIntValue);
        }
    }

    public final void a(View view, boolean z2) {
        this.f14103w.a(view, z2);
    }
}
