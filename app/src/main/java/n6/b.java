package n6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13078a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k6.d f13081d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f13082f;

    public b(c cVar) {
        this.f13082f = cVar;
        int length = cVar.f13083a.length();
        if (length < 0) {
            throw new IllegalArgumentException(a1.a.h(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f13079b = length;
        this.f13080c = length;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f13080c
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f13078a = r1
            r0 = 0
            r7.f13081d = r0
            return
        Lb:
            n6.c r2 = r7.f13082f
            int r3 = r2.f13084b
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.e
            int r6 = r6 + r5
            r7.e = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f13083a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            k6.d r0 = new k6.d
            int r1 = r7.f13079b
            java.lang.CharSequence r2 = r2.f13083a
            int r2 = n6.m.u0(r2)
            r0.<init>(r1, r2, r5)
            r7.f13081d = r0
            r7.f13080c = r4
            goto L79
        L34:
            e6.p r0 = r2.f13085c
            java.lang.CharSequence r3 = r2.f13083a
            int r6 = r7.f13080c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.invoke(r3, r6)
            q5.i r0 = (q5.i) r0
            if (r0 != 0) goto L58
            k6.d r0 = new k6.d
            int r1 = r7.f13079b
            java.lang.CharSequence r2 = r2.f13083a
            int r2 = n6.m.u0(r2)
            r0.<init>(r1, r2, r5)
            r7.f13081d = r0
            r7.f13080c = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f13498a
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f13499b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f13079b
            k6.d r3 = r2.q.D0(r3, r2)
            r7.f13081d = r3
            int r2 = r2 + r0
            r7.f13079b = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f13080c = r2
        L79:
            r7.f13078a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n6.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f13078a == -1) {
            a();
        }
        return this.f13078a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f13078a == -1) {
            a();
        }
        if (this.f13078a == 0) {
            throw new NoSuchElementException();
        }
        k6.d dVar = this.f13081d;
        kotlin.jvm.internal.k.c(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f13081d = null;
        this.f13078a = -1;
        return dVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
