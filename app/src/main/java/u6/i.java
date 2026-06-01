package u6;

import q5.x;
import q6.a0;
import t6.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s6.l f17552f;
    public byte[] g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17553i;
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ t6.e[] l;
    public final /* synthetic */ o0 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t6.f f17554n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(t6.e[] eVarArr, o0 o0Var, t6.f fVar, v5.c cVar) {
        super(2, cVar);
        this.l = eVarArr;
        this.m = o0Var;
        this.f17554n = fVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        i iVar = new i(this.l, this.m, this.f17554n, cVar);
        iVar.k = obj;
        return iVar;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((a0) obj, (v5.c) obj2)).invokeSuspend(x.f13520a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
    
        if (r4 != 0) goto L18;
     */
    /* JADX WARN: Path cross not found for [B:40:0x00bf, B:34:0x00ae], limit reached: 44 */
    /* JADX WARN: Path cross not found for [B:41:0x00c1, B:18:0x007c], limit reached: 44 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[LOOP:0: B:29:0x009e->B:46:?, LOOP_START, PHI: r4 r11
  0x009e: PHI (r4v3 int) = (r4v2 int), (r4v4 int) binds: [B:26:0x0099, B:46:?] A[DONT_GENERATE, DONT_INLINE]
  0x009e: PHI (r11v4 r5.u) = (r11v3 r5.u), (r11v10 r5.u) binds: [B:26:0x0099, B:46:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d5 -> B:18:0x007c). Please report as a decompilation issue!!! */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
