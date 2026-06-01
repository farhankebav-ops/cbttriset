package androidx.activity;

import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {173}, m = "reportWhenComplete")
    public static final class AnonymousClass1 extends x5.c {
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
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r5, e6.l r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.activity.FullyDrawnReporterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r5 = r0.L$0
            androidx.activity.FullyDrawnReporter r5 = (androidx.activity.FullyDrawnReporter) r5
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r6 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            r2.q.z0(r7)
            r5.addReporter()
            boolean r7 = r5.isFullyDrawnReported()
            if (r7 == 0) goto L44
            return r3
        L44:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L4f
            return r1
        L4f:
            r5.removeReporter()
            return r3
        L53:
            r5.removeReporter()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, e6.l, v5.c):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, e6.l lVar, v5.c<? super x> cVar) {
        fullyDrawnReporter.addReporter();
        boolean zIsFullyDrawnReported = fullyDrawnReporter.isFullyDrawnReported();
        x xVar = x.f13520a;
        if (zIsFullyDrawnReported) {
            return xVar;
        }
        try {
            lVar.invoke(cVar);
            return xVar;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
