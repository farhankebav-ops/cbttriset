package k4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12700d;

    public y(n nVar, d dVar) {
        this.f12698b = nVar;
        this.f12699c = dVar;
        this.f12697a = 65535;
        this.f12700d = new w(this, 0, 65535, null);
    }

    public void a(boolean z2, w wVar, l7.j jVar, boolean z7) {
        r2.q.D(jVar, "source");
        int iMin = Math.min(wVar.f12693c, ((w) wVar.g.f12700d).f12693c);
        l7.j jVar2 = wVar.f12691a;
        boolean z8 = jVar2.f12868b > 0;
        int i2 = (int) jVar.f12868b;
        if (z8 || iMin < i2) {
            if (!z8 && iMin > 0) {
                wVar.b(iMin, false, jVar);
            }
            jVar2.write(jVar, (int) jVar.f12868b);
            wVar.f12695f = z2 | wVar.f12695f;
        } else {
            wVar.b(i2, z2, jVar);
        }
        if (z7) {
            try {
                ((d) this.f12699c).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void b(w wVar, int i2) {
        if (wVar == null) {
            ((w) this.f12700d).a(i2);
            c();
            return;
        }
        wVar.a(i2);
        x xVar = new x();
        wVar.c(Math.min(wVar.f12693c, ((w) wVar.g.f12700d).f12693c), xVar);
        if (xVar.f12696a > 0) {
            try {
                ((d) this.f12699c).flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public void c() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f12698b
            k4.n r0 = (k4.n) r0
            k4.w[] r1 = r0.i()
            java.util.List r2 = java.util.Arrays.asList(r1)
            java.util.Collections.shuffle(r2)
            java.lang.Object r2 = r13.f12700d
            k4.w r2 = (k4.w) r2
            int r2 = r2.f12693c
            int r3 = r1.length
        L16:
            r4 = 0
            if (r3 <= 0) goto L6a
            if (r2 <= 0) goto L6a
            float r5 = (float) r2
            float r6 = (float) r3
            float r5 = r5 / r6
            double r5 = (double) r5
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            r6 = r4
            r7 = r6
        L26:
            if (r7 >= r3) goto L68
            if (r2 <= 0) goto L68
            r8 = r1[r7]
            int r9 = r8.f12693c
            l7.j r10 = r8.f12691a
            long r11 = r10.f12868b
            int r11 = (int) r11
            int r9 = java.lang.Math.min(r9, r11)
            int r9 = java.lang.Math.max(r4, r9)
            int r11 = r8.f12694d
            int r9 = r9 - r11
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.min(r2, r9)
            if (r9 <= 0) goto L4e
            int r11 = r8.f12694d
            int r11 = r11 + r9
            r8.f12694d = r11
            int r2 = r2 - r9
        L4e:
            int r9 = r8.f12693c
            long r10 = r10.f12868b
            int r10 = (int) r10
            int r9 = java.lang.Math.min(r9, r10)
            int r9 = java.lang.Math.max(r4, r9)
            int r10 = r8.f12694d
            int r9 = r9 - r10
            if (r9 <= 0) goto L65
            int r9 = r6 + 1
            r1[r6] = r8
            r6 = r9
        L65:
            int r7 = r7 + 1
            goto L26
        L68:
            r3 = r6
            goto L16
        L6a:
            k4.x r1 = new k4.x
            r1.<init>()
            k4.w[] r0 = r0.i()
            int r2 = r0.length
            r3 = r4
        L75:
            if (r3 >= r2) goto L83
            r5 = r0[r3]
            int r6 = r5.f12694d
            r5.c(r6, r1)
            r5.f12694d = r4
            int r3 = r3 + 1
            goto L75
        L83:
            int r0 = r1.f12696a
            if (r0 <= 0) goto L96
            java.lang.Object r0 = r13.f12699c     // Catch: java.io.IOException -> L8f
            k4.d r0 = (k4.d) r0     // Catch: java.io.IOException -> L8f
            r0.flush()     // Catch: java.io.IOException -> L8f
            return
        L8f:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.y.c():void");
    }

    public y(int i2, s6.a aVar, t6.e eVar, v5.h hVar) {
        this.f12698b = eVar;
        this.f12697a = i2;
        this.f12699c = aVar;
        this.f12700d = hVar;
    }
}
