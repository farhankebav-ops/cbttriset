package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CacheRepository;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonCleanAssets implements CleanAssets {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonCleanAssets$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CommonCleanAssets", f = "CommonCleanAssets.kt", l = {18, 19}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        long J$0;
        long J$1;
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
            return CommonCleanAssets.this.invoke(this);
        }
    }

    public CommonCleanAssets(CacheRepository cacheRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(cacheRepository, "cacheRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.CleanAssets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(v5.c<? super q5.x> r15) throws java.lang.Throwable {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.unity3d.ads.core.domain.CommonCleanAssets.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            com.unity3d.ads.core.domain.CommonCleanAssets$invoke$1 r0 = (com.unity3d.ads.core.domain.CommonCleanAssets.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.CommonCleanAssets$invoke$1 r0 = new com.unity3d.ads.core.domain.CommonCleanAssets$invoke$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            long r1 = r0.J$1
            long r3 = r0.J$0
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.CommonCleanAssets r0 = (com.unity3d.ads.core.domain.CommonCleanAssets) r0
            r2.q.z0(r15)
            goto L76
        L32:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L3a:
            long r4 = r0.J$0
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.CommonCleanAssets r2 = (com.unity3d.ads.core.domain.CommonCleanAssets) r2
            r2.q.z0(r15)
            goto L5c
        L44:
            r2.q.z0(r15)
            long r5 = o6.d.b()
            com.unity3d.ads.core.data.repository.CacheRepository r15 = r14.cacheRepository
            r0.L$0 = r14
            r0.J$0 = r5
            r0.label = r4
            java.lang.Object r15 = r15.getCacheSize(r0)
            if (r15 != r1) goto L5a
            goto L72
        L5a:
            r2 = r14
            r4 = r5
        L5c:
            java.lang.Number r15 = (java.lang.Number) r15
            long r6 = r15.longValue()
            com.unity3d.ads.core.data.repository.CacheRepository r15 = r2.cacheRepository
            r0.L$0 = r2
            r0.J$0 = r4
            r0.J$1 = r6
            r0.label = r3
            java.lang.Object r15 = r15.clearCache(r0)
            if (r15 != r1) goto L73
        L72:
            return r1
        L73:
            r0 = r2
            r3 = r4
            r1 = r6
        L76:
            com.unity3d.ads.core.domain.SendDiagnosticEvent r5 = r0.sendDiagnosticEvent
            o6.f r15 = new o6.f
            r15.<init>(r3)
            double r3 = com.unity3d.ads.core.extensions.TimeExtensionsKt.elapsedMillis(r15)
            java.lang.Double r7 = new java.lang.Double
            r7.<init>(r3)
            r15 = 1024(0x400, float:1.435E-42)
            long r3 = (long) r15
            long r1 = r1 / r3
            int r15 = (int) r1
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r15)
            q5.i r15 = new q5.i
            java.lang.String r1 = "size_kb"
            r15.<init>(r1, r0)
            java.util.Map r9 = r5.x.e0(r15)
            r12 = 52
            r13 = 0
            java.lang.String r6 = "native_clean_assets_task_success_time"
            r8 = 0
            r10 = 0
            r11 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            q5.x r15 = q5.x.f13520a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CommonCleanAssets.invoke(v5.c):java.lang.Object");
    }
}
