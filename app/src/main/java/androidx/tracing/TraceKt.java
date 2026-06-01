package androidx.tracing;

import e6.a;
import e6.l;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {

    /* JADX INFO: renamed from: androidx.tracing.TraceKt$traceAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.tracing.TraceKt", f = "Trace.kt", l = {76}, m = "traceAsync")
    public static final class AnonymousClass1<T> extends c {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TraceKt.traceAsync(null, 0, null, this);
        }
    }

    public static final <T> T trace(String label, a block) {
        k.e(label, "label");
        k.e(block, "block");
        Trace.beginSection(label);
        try {
            return (T) block.invoke();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object traceAsync(java.lang.String r4, int r5, e6.l r6, v5.c<? super T> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4a
        L2d:
            r6 = move-exception
            goto L4e
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            r2.q.z0(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2d
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r7 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r7 != r1) goto L4a
            return r1
        L4a:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            return r7
        L4e:
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, e6.l, v5.c):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i2, l lVar, v5.c<? super T> cVar) {
        Trace.beginAsyncSection(str, i2);
        try {
            return lVar.invoke(cVar);
        } finally {
            Trace.endAsyncSection(str, i2);
        }
    }

    public static final <T> T trace(a lazyLabel, a block) {
        k.e(lazyLabel, "lazyLabel");
        k.e(block, "block");
        boolean zIsEnabled = Trace.isEnabled();
        if (zIsEnabled) {
            Trace.beginSection((String) lazyLabel.invoke());
        }
        try {
            return (T) block.invoke();
        } finally {
            if (zIsEnabled) {
                Trace.endSection();
            }
        }
    }

    public static final <T> T traceAsync(a lazyMethodName, a lazyCookie, a block) {
        String str;
        int iIntValue;
        k.e(lazyMethodName, "lazyMethodName");
        k.e(lazyCookie, "lazyCookie");
        k.e(block, "block");
        if (Trace.isEnabled()) {
            str = (String) lazyMethodName.invoke();
            iIntValue = ((Number) lazyCookie.invoke()).intValue();
            Trace.beginAsyncSection(str, iIntValue);
        } else {
            str = null;
            iIntValue = 0;
        }
        try {
            return (T) block.invoke();
        } finally {
            if (str != null) {
                Trace.endAsyncSection(str, iIntValue);
            }
        }
    }
}
