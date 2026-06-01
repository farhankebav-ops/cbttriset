package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionBackendService implements ISubscriptionBackendService {
    private final IHttpClient _httpClient;

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.SubscriptionBackendService$createSubscription$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", l = {26}, m = "createSubscription")
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
            return SubscriptionBackendService.this.createSubscription(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", l = {80}, m = "deleteSubscription")
    public static final class C28341 extends c {
        int label;
        /* synthetic */ Object result;

        public C28341(v5.c<? super C28341> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionBackendService.this.deleteSubscription(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", l = {108}, m = "getIdentityFromSubscription")
    public static final class C28351 extends c {
        int label;
        /* synthetic */ Object result;

        public C28351(v5.c<? super C28351> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionBackendService.this.getIdentityFromSubscription(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", l = {97}, m = "transferSubscription")
    public static final class C28361 extends c {
        int label;
        /* synthetic */ Object result;

        public C28361(v5.c<? super C28361> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionBackendService.this.transferSubscription(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.SubscriptionBackendService", f = "SubscriptionBackendService.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE}, m = "updateSubscription")
    public static final class C28371 extends c {
        int label;
        /* synthetic */ Object result;

        public C28371(v5.c<? super C28371> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionBackendService.this.updateSubscription(null, null, null, this);
        }
    }

    public SubscriptionBackendService(IHttpClient _httpClient) {
        k.e(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createSubscription(java.lang.String r10, java.lang.String r11, java.lang.String r12, com.onesignal.user.internal.backend.SubscriptionObject r13, v5.c<? super q5.i> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.createSubscription(java.lang.String, java.lang.String, java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteSubscription(java.lang.String r8, java.lang.String r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28341
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28341) r0
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
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$deleteSubscription$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r10)
            goto L4b
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            r2.q.z0(r10)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.String r10 = "apps/"
            java.lang.String r3 = "/subscriptions/"
            java.lang.String r8 = a1.a.n(r10, r8, r3, r9)
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r10 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.delete$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L4b
            return r0
        L4b:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r8 = r10.isSuccess()
            if (r8 == 0) goto L56
            q5.x r8 = q5.x.f13520a
            return r8
        L56:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r10.getStatusCode()
            java.lang.String r0 = r10.getPayload()
            java.lang.Integer r10 = r10.getRetryAfterSeconds()
            r8.<init>(r9, r0, r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.deleteSubscription(java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIdentityFromSubscription(java.lang.String r8, java.lang.String r9, v5.c<? super java.util.Map<java.lang.String, java.lang.String>> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28351
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28351) r0
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
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$getIdentityFromSubscription$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r10)
            goto L4d
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            r2.q.z0(r10)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.String r10 = "/subscriptions/"
            java.lang.String r3 = "/user/identity"
            java.lang.String r5 = "apps/"
            java.lang.String r8 = a1.a.o(r5, r8, r10, r9, r3)
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r10 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L4d
            return r0
        L4d:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r8 = r10.isSuccess()
            if (r8 == 0) goto La4
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r9 = r10.getPayload()
            kotlin.jvm.internal.k.b(r9)
            r8.<init>(r9)
            java.lang.String r9 = "identity"
            org.json.JSONObject r8 = com.onesignal.common.JSONObjectExtensionsKt.safeJSONObject(r8, r9)
            if (r8 == 0) goto La1
            java.util.Map r8 = com.onesignal.common.JSONObjectExtensionsKt.toMap(r8)
            if (r8 == 0) goto La1
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            int r10 = r8.size()
            int r10 = r5.x.d0(r10)
            r9.<init>(r10)
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L84:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto La0
            java.lang.Object r10 = r8.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r0 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r9.put(r0, r10)
            goto L84
        La0:
            return r9
        La1:
            r5.s r8 = r5.s.f13639a
            return r8
        La4:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r10.getStatusCode()
            java.lang.String r0 = r10.getPayload()
            java.lang.Integer r10 = r10.getRetryAfterSeconds()
            r8.<init>(r9, r0, r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.getIdentityFromSubscription(java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object transferSubscription(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28361
            if (r0 == 0) goto L14
            r0 = r13
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$transferSubscription$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.result
            w5.a r0 = w5.a.f17774a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r13)
            goto L66
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            r2.q.z0(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r11 = r1.put(r11, r12)
            java.lang.String r12 = "identity"
            org.json.JSONObject r3 = r13.put(r12, r11)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r11 = "/subscriptions/"
            java.lang.String r12 = "/owner"
            java.lang.String r13 = "apps/"
            java.lang.String r9 = a1.a.o(r13, r9, r11, r10, r12)
            java.lang.String r10 = "requestJSON"
            kotlin.jvm.internal.k.d(r3, r10)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r13 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.patch$default(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L66
            return r0
        L66:
            com.onesignal.core.internal.http.HttpResponse r13 = (com.onesignal.core.internal.http.HttpResponse) r13
            boolean r9 = r13.isSuccess()
            if (r9 == 0) goto L71
            q5.x r9 = q5.x.f13520a
            return r9
        L71:
            com.onesignal.common.exceptions.BackendException r9 = new com.onesignal.common.exceptions.BackendException
            int r10 = r13.getStatusCode()
            java.lang.String r11 = r13.getPayload()
            java.lang.Integer r12 = r13.getRetryAfterSeconds()
            r9.<init>(r10, r11, r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.transferSubscription(java.lang.String, java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.ISubscriptionBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateSubscription(java.lang.String r9, java.lang.String r10, com.onesignal.user.internal.backend.SubscriptionObject r11, v5.c<? super com.onesignal.common.consistency.RywData> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28371
            if (r0 == 0) goto L14
            r0 = r12
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1 r0 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.C28371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1 r0 = new com.onesignal.user.internal.backend.impl.SubscriptionBackendService$updateSubscription$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r5.result
            w5.a r0 = w5.a.f17774a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r12)
            goto L61
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            r2.q.z0(r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            com.onesignal.user.internal.backend.impl.JSONConverter r1 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r11 = r1.convertToJSON(r11)
            java.lang.String r1 = "subscription"
            org.json.JSONObject r3 = r12.put(r1, r11)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r11 = "apps/"
            java.lang.String r12 = "/subscriptions/"
            java.lang.String r9 = a1.a.n(r11, r9, r12, r10)
            java.lang.String r10 = "requestJSON"
            kotlin.jvm.internal.k.d(r3, r10)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r12 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.patch$default(r1, r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L61
            return r0
        L61:
            com.onesignal.core.internal.http.HttpResponse r12 = (com.onesignal.core.internal.http.HttpResponse) r12
            boolean r9 = r12.isSuccess()
            if (r9 == 0) goto L93
            java.lang.String r9 = r12.getPayload()
            r10 = 0
            if (r9 == 0) goto L76
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>(r9)
            goto L77
        L76:
            r11 = r10
        L77:
            if (r11 == 0) goto L80
            java.lang.String r9 = "ryw_token"
            java.lang.String r9 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r11, r9)
            goto L81
        L80:
            r9 = r10
        L81:
            if (r11 == 0) goto L8a
            java.lang.String r12 = "ryw_delay"
            java.lang.Long r11 = com.onesignal.common.JSONObjectExtensionsKt.safeLong(r11, r12)
            goto L8b
        L8a:
            r11 = r10
        L8b:
            if (r9 == 0) goto L92
            com.onesignal.common.consistency.RywData r10 = new com.onesignal.common.consistency.RywData
            r10.<init>(r9, r11)
        L92:
            return r10
        L93:
            com.onesignal.common.exceptions.BackendException r9 = new com.onesignal.common.exceptions.BackendException
            int r10 = r12.getStatusCode()
            java.lang.String r11 = r12.getPayload()
            java.lang.Integer r12 = r12.getRetryAfterSeconds()
            r9.<init>(r10, r11, r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.SubscriptionBackendService.updateSubscription(java.lang.String, java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject, v5.c):java.lang.Object");
    }
}
