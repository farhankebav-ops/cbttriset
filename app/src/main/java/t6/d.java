package t6;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class d implements u6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5.h f17425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.a f17427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f17428d;
    public final Object e;

    public d(v5.h hVar, int i2, s6.a aVar) {
        this.f17425a = hVar;
        this.f17426b = i2;
        this.f17427c = aVar;
    }

    public final Object a(f fVar, v5.c cVar) throws Throwable {
        Object objJ = q6.c0.j(new s6.q(fVar, this, null, 2), cVar);
        return objJ == w5.a.f17774a ? objJ : q5.x.f13520a;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [e6.p, x5.i] */
    public Object b(s6.x xVar, v5.c cVar) {
        switch (this.f17428d) {
            case 0:
                Object objInvoke = ((x5.i) this.e).invoke(xVar, cVar);
                if (objInvoke != w5.a.f17774a) {
                    break;
                }
                break;
            default:
                Object objF = f(new u6.r(xVar), cVar);
                if (objF != w5.a.f17774a) {
                    break;
                }
                break;
        }
        return q5.x.f13520a;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [e6.p, x5.i] */
    public d c(v5.h hVar, int i2, s6.a aVar) {
        switch (this.f17428d) {
            case 0:
                return new d((e6.p) this.e, hVar, i2, aVar);
            default:
                return new d(i2, aVar, (e) this.e, hVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    @Override // t6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(t6.f r5, v5.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            int r0 = r4.f17428d
            switch(r0) {
                case 1: goto La;
                default: goto L5;
            }
        L5:
            java.lang.Object r5 = r4.a(r5, r6)
            return r5
        La:
            int r0 = r4.f17426b
            r1 = -3
            if (r0 != r1) goto L79
            v5.h r0 = r6.getContext()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            androidx.camera.camera2.internal.compat.workaround.a r2 = new androidx.camera.camera2.internal.compat.workaround.a
            r3 = 3
            r2.<init>(r3)
            v5.h r3 = r4.f17425a
            java.lang.Object r1 = r3.fold(r1, r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L2e
            v5.h r1 = r0.plus(r3)
            goto L33
        L2e:
            r1 = 0
            v5.h r1 = q6.c0.m(r0, r3, r1)
        L33:
            boolean r2 = kotlin.jvm.internal.k.a(r1, r0)
            if (r2 == 0) goto L42
            java.lang.Object r5 = r4.f(r5, r6)
            w5.a r6 = w5.a.f17774a
            if (r5 != r6) goto L82
            goto L84
        L42:
            v5.d r2 = v5.d.f17609a
            v5.f r3 = r1.get(r2)
            v5.f r0 = r0.get(r2)
            boolean r0 = kotlin.jvm.internal.k.a(r3, r0)
            if (r0 == 0) goto L79
            v5.h r0 = r6.getContext()
            boolean r2 = r5 instanceof u6.r
            if (r2 != 0) goto L65
            boolean r2 = r5 instanceof u6.n
            if (r2 == 0) goto L5f
            goto L65
        L5f:
            t6.y r2 = new t6.y
            r2.<init>(r5, r0)
            r5 = r2
        L65:
            t6.m r0 = new t6.m
            r2 = 0
            r3 = 3
            r0.<init>(r4, r2, r3)
            java.lang.Object r2 = v6.a.k(r1)
            java.lang.Object r5 = u6.c.b(r1, r5, r2, r0, r6)
            w5.a r6 = w5.a.f17774a
            if (r5 != r6) goto L82
            goto L84
        L79:
            java.lang.Object r5 = r4.a(r5, r6)
            w5.a r6 = w5.a.f17774a
            if (r5 != r6) goto L82
            goto L84
        L82:
            q5.x r5 = q5.x.f13520a
        L84:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.d.collect(t6.f, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // u6.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final t6.e e(v5.h r5, int r6, s6.a r7) {
        /*
            r4 = this;
            v5.h r0 = r4.f17425a
            v5.h r5 = r5.plus(r0)
            s6.a r1 = s6.a.f13718a
            s6.a r2 = r4.f17427c
            int r3 = r4.f17426b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.k.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            t6.d r5 = r4.c(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.d.e(v5.h, int, s6.a):t6.e");
    }

    public Object f(f fVar, v5.c cVar) {
        Object objCollect = ((e) this.e).collect(fVar, cVar);
        return objCollect == w5.a.f17774a ? objCollect : q5.x.f13520a;
    }

    public final String g() {
        ArrayList arrayList = new ArrayList(4);
        v5.i iVar = v5.i.f17610a;
        v5.h hVar = this.f17425a;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i2 = this.f17426b;
        if (i2 != -3) {
            arrayList.add("capacity=" + i2);
        }
        s6.a aVar = s6.a.f13718a;
        s6.a aVar2 = this.f17427c;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return a1.a.e(']', r5.l.c1(arrayList, ", ", null, null, null, 62), sb);
    }

    public final String toString() {
        switch (this.f17428d) {
            case 0:
                return "block[" + ((x5.i) this.e) + "] -> " + g();
            default:
                return ((e) this.e) + " -> " + g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2, s6.a aVar, e eVar, v5.h hVar) {
        this(hVar, i2, aVar);
        this.f17428d = 1;
        this.e = eVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(e6.p pVar, v5.h hVar, int i2, s6.a aVar) {
        this(hVar, i2, aVar);
        this.f17428d = 0;
        this.e = (x5.i) pVar;
    }
}
