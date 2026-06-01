package androidx.collection;

import e6.p;
import m6.j;
import q5.x;
import v5.c;
import x5.e;
import x5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", l = {701}, m = "invokeSuspend")
public final class ScatterMap$MapWrapper$entries$1$iterator$1 extends h implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterMap<K, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScatterMap$MapWrapper$entries$1$iterator$1(ScatterMap<K, V> scatterMap, c<? super ScatterMap$MapWrapper$entries$1$iterator$1> cVar) {
        super(2, cVar);
        this.this$0 = scatterMap;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        ScatterMap$MapWrapper$entries$1$iterator$1 scatterMap$MapWrapper$entries$1$iterator$1 = new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, cVar);
        scatterMap$MapWrapper$entries$1$iterator$1.L$0 = obj;
        return scatterMap$MapWrapper$entries$1$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0050 -> B:22:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:14:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006d -> B:19:0x0097). Please report as a decompilation issue!!! */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            r20 = this;
            r0 = r20
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L31
            if (r2 != r5) goto L29
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$2
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$1
            androidx.collection.ScatterMap r12 = (androidx.collection.ScatterMap) r12
            java.lang.Object r13 = r0.L$0
            m6.j r13 = (m6.j) r13
            r2.q.z0(r21)
            goto L97
        L29:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L31:
            r2.q.z0(r21)
            java.lang.Object r2 = r0.L$0
            m6.j r2 = (m6.j) r2
            androidx.collection.ScatterMap<K, V> r6 = r0.this$0
            long[] r7 = r6.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto La5
            r9 = r3
        L42:
            r10 = r7[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto La0
            int r12 = r9 - r8
            int r12 = ~r12
            int r12 = r12 >>> 31
            int r12 = 8 - r12
            r13 = r12
            r12 = r6
            r6 = r13
            r13 = r2
            r2 = r3
            r18 = r10
            r11 = r7
            r10 = r8
            r7 = r18
        L64:
            if (r2 >= r6) goto L9a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r7
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L97
            int r3 = r9 << 3
            int r3 = r3 + r2
            androidx.collection.MapEntry r4 = new androidx.collection.MapEntry
            java.lang.Object[] r14 = r12.keys
            r14 = r14[r3]
            java.lang.Object[] r15 = r12.values
            r3 = r15[r3]
            r4.<init>(r14, r3)
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            r13.a(r4, r0)
            w5.a r2 = w5.a.f17774a
            return r1
        L97:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L64
        L9a:
            if (r6 != r4) goto La5
            r8 = r10
            r7 = r11
            r6 = r12
            r2 = r13
        La0:
            if (r9 == r8) goto La5
            int r9 = r9 + 1
            goto L42
        La5:
            q5.x r1 = q5.x.f13520a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(j jVar, c<? super x> cVar) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) create(jVar, cVar)).invokeSuspend(x.f13520a);
    }
}
