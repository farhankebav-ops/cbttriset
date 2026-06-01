package androidx.collection;

import e6.p;
import m6.j;
import q5.x;
import v5.c;
import x5.e;
import x5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1060}, m = "invokeSuspend")
public final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 extends h implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableScatterSet<E> this$0;
    final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet mutableScatterSet, MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, c cVar) {
        super(2, cVar);
        this.this$0 = mutableScatterSet;
        this.this$1 = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, cVar);
        mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0056 -> B:22:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0058 -> B:14:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0075 -> B:19:0x009b). Please report as a decompilation issue!!! */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            r21 = this;
            r0 = r21
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L35
            if (r2 != r5) goto L2d
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$3
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$2
            androidx.collection.MutableScatterSet r12 = (androidx.collection.MutableScatterSet) r12
            java.lang.Object r13 = r0.L$1
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r13 = (androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1) r13
            java.lang.Object r14 = r0.L$0
            m6.j r14 = (m6.j) r14
            r2.q.z0(r22)
            goto L9b
        L2d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L35:
            r2.q.z0(r22)
            java.lang.Object r2 = r0.L$0
            m6.j r2 = (m6.j) r2
            androidx.collection.MutableScatterSet<E> r6 = r0.this$0
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r7 = r0.this$1
            long[] r8 = r6.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto Lac
            r10 = r3
        L48:
            r11 = r8[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto La7
            int r13 = r10 - r9
            int r13 = ~r13
            int r13 = r13 >>> 31
            int r13 = 8 - r13
            r14 = r10
            r10 = r9
            r9 = r14
            r14 = r2
            r2 = r3
            r19 = r11
            r12 = r6
            r11 = r8
            r6 = r13
            r13 = r7
            r7 = r19
        L6c:
            if (r2 >= r6) goto L9e
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r7
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L9b
            int r3 = r9 << 3
            int r3 = r3 + r2
            r13.setCurrent(r3)
            java.lang.Object[] r4 = r12.elements
            r3 = r4[r3]
            r0.L$0 = r14
            r0.L$1 = r13
            r0.L$2 = r12
            r0.L$3 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            r14.a(r3, r0)
            w5.a r2 = w5.a.f17774a
            return r1
        L9b:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L6c
        L9e:
            if (r6 != r4) goto Lac
            r2 = r10
            r10 = r9
            r9 = r2
            r8 = r11
            r6 = r12
            r7 = r13
            r2 = r14
        La7:
            if (r10 == r9) goto Lac
            int r10 = r10 + 1
            goto L48
        Lac:
            q5.x r1 = q5.x.f13520a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(j jVar, c<? super x> cVar) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) create(jVar, cVar)).invokeSuspend(x.f13520a);
    }
}
