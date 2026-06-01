package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateReset;
import e6.p;
import q5.k;
import q5.x;
import q6.a0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", l = {41}, m = "invokeSuspend")
public final class InitializeStateReset$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateReset.Params $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, c<? super InitializeStateReset$doWork$2> cVar) {
        super(2, cVar);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c A[Catch: all -> 0x0016, CancellationException -> 0x0019, TryCatch #2 {CancellationException -> 0x0019, all -> 0x0016, blocks: (B:6:0x0012, B:26:0x005f, B:31:0x006d, B:33:0x007c, B:35:0x0082, B:37:0x0090, B:38:0x0092, B:40:0x0095, B:42:0x00a1, B:43:0x00a8, B:44:0x00ab, B:45:0x00b0, B:46:0x00b7, B:47:0x00b8, B:48:0x00bf, B:29:0x0065, B:30:0x006c, B:15:0x002b, B:17:0x0036, B:19:0x003b, B:22:0x0043), top: B:59:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8 A[Catch: all -> 0x0016, CancellationException -> 0x0019, TryCatch #2 {CancellationException -> 0x0019, all -> 0x0016, blocks: (B:6:0x0012, B:26:0x005f, B:31:0x006d, B:33:0x007c, B:35:0x0082, B:37:0x0090, B:38:0x0092, B:40:0x0095, B:42:0x00a1, B:43:0x00a8, B:44:0x00ab, B:45:0x00b0, B:46:0x00b7, B:47:0x00b8, B:48:0x00bf, B:29:0x0065, B:30:0x006c, B:15:0x002b, B:17:0x0036, B:19:0x003b, B:22:0x0043), top: B:59:0x0006 }] */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super k> cVar) {
        return ((InitializeStateReset$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
