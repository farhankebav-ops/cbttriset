package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IdentityBackendService implements IIdentityBackendService {
    private final IHttpClient _httpClient;

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.IdentityBackendService", f = "IdentityBackendService.kt", l = {40}, m = "deleteAlias")
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdentityBackendService.this.deleteAlias(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.IdentityBackendService$setAlias$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.IdentityBackendService", f = "IdentityBackendService.kt", l = {23}, m = "setAlias")
    public static final class C28331 extends c {
        int label;
        /* synthetic */ Object result;

        public C28331(v5.c<? super C28331> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdentityBackendService.this.setAlias(null, null, null, null, this);
        }
    }

    public IdentityBackendService(IHttpClient _httpClient) {
        k.e(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.IIdentityBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteAlias(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.onesignal.user.internal.backend.impl.IdentityBackendService.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1 r0 = (com.onesignal.user.internal.backend.impl.IdentityBackendService.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1 r0 = new com.onesignal.user.internal.backend.impl.IdentityBackendService$deleteAlias$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r12)
            goto L60
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            r2.q.z0(r12)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r3 = "apps/"
            r12.<init>(r3)
            r12.append(r8)
            java.lang.String r8 = "/users/by/"
            r12.append(r8)
            r12.append(r9)
            r8 = 47
            r12.append(r8)
            java.lang.String r8 = "/identity/"
            java.lang.String r8 = a1.a.s(r12, r10, r8, r11)
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r12 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.delete$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L60
            return r0
        L60:
            com.onesignal.core.internal.http.HttpResponse r12 = (com.onesignal.core.internal.http.HttpResponse) r12
            boolean r8 = r12.isSuccess()
            if (r8 == 0) goto L6b
            q5.x r8 = q5.x.f13520a
            return r8
        L6b:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r12.getStatusCode()
            java.lang.String r10 = r12.getPayload()
            java.lang.Integer r11 = r12.getRetryAfterSeconds()
            r8.<init>(r9, r10, r11)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.IdentityBackendService.deleteAlias(java.lang.String, java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.IIdentityBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setAlias(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13, v5.c<? super java.util.Map<java.lang.String, java.lang.String>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.IdentityBackendService.setAlias(java.lang.String, java.lang.String, java.lang.String, java.util.Map, v5.c):java.lang.Object");
    }
}
