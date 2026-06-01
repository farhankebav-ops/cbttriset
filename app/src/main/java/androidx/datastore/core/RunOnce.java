package androidx.datastore.core;

import q5.x;
import q6.c0;
import q6.q;
import q6.r;
import x5.c;
import x5.e;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RunOnce {
    private final z6.a runMutex = d.a();
    private final q didRun = c0.a();

    /* JADX INFO: renamed from: androidx.datastore.core.RunOnce$runIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {544, 497}, m = "runIfNeeded")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RunOnce.this.runIfNeeded(this);
        }
    }

    public final Object awaitComplete(v5.c<? super x> cVar) {
        Object objT = ((r) this.didRun).t(cVar);
        return objT == w5.a.f17774a ? objT : x.f13520a;
    }

    public abstract Object doRun(v5.c<? super x> cVar);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object runIfNeeded(v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.RunOnce.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            q5.x r5 = q5.x.f13520a
            r6 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.L$1
            z6.a r1 = (z6.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L35
            goto L8b
        L35:
            r8 = move-exception
            goto L9b
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3f:
            java.lang.Object r2 = r0.L$1
            z6.a r2 = (z6.a) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.RunOnce r4 = (androidx.datastore.core.RunOnce) r4
            r2.q.z0(r8)
            r8 = r2
            goto L6c
        L4c:
            r2.q.z0(r8)
            q6.q r8 = r7.didRun
            q6.n1 r8 = (q6.n1) r8
            boolean r8 = r8.K()
            if (r8 == 0) goto L5a
            return r5
        L5a:
            z6.a r8 = r7.runMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            z6.c r8 = (z6.c) r8
            java.lang.Object r2 = r8.d(r0)
            if (r2 != r1) goto L6b
            goto L88
        L6b:
            r4 = r7
        L6c:
            q6.q r2 = r4.didRun     // Catch: java.lang.Throwable -> L98
            q6.n1 r2 = (q6.n1) r2     // Catch: java.lang.Throwable -> L98
            boolean r2 = r2.K()     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L7c
            z6.c r8 = (z6.c) r8
            r8.f(r6)
            return r5
        L7c:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L98
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L98
            r0.label = r3     // Catch: java.lang.Throwable -> L98
            java.lang.Object r0 = r4.doRun(r0)     // Catch: java.lang.Throwable -> L98
            if (r0 != r1) goto L89
        L88:
            return r1
        L89:
            r1 = r8
            r0 = r4
        L8b:
            q6.q r8 = r0.didRun     // Catch: java.lang.Throwable -> L35
            q6.r r8 = (q6.r) r8     // Catch: java.lang.Throwable -> L35
            r8.N(r5)     // Catch: java.lang.Throwable -> L35
            z6.c r1 = (z6.c) r1
            r1.f(r6)
            return r5
        L98:
            r0 = move-exception
            r1 = r8
            r8 = r0
        L9b:
            z6.c r1 = (z6.c) r1
            r1.f(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(v5.c):java.lang.Object");
    }
}
