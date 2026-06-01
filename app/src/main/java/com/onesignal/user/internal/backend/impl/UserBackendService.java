package com.onesignal.user.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IUserBackendService;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UserBackendService implements IUserBackendService {
    private final IHttpClient _httpClient;

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.UserBackendService", f = "UserBackendService.kt", l = {42}, m = "createUser")
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
            return UserBackendService.this.createUser(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.UserBackendService", f = "UserBackendService.kt", l = {94}, m = "getUser")
    public static final class C28381 extends c {
        int label;
        /* synthetic */ Object result;

        public C28381(v5.c<? super C28381> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserBackendService.this.getUser(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.UserBackendService$updateUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.user.internal.backend.impl.UserBackendService", f = "UserBackendService.kt", l = {71}, m = "updateUser")
    public static final class C28391 extends c {
        int label;
        /* synthetic */ Object result;

        public C28391(v5.c<? super C28391> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserBackendService.this.updateUser(null, null, null, null, false, null, this);
        }
    }

    public UserBackendService(IHttpClient _httpClient) {
        k.e(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.IUserBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createUser(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.List<com.onesignal.user.internal.backend.SubscriptionObject> r11, java.util.Map<java.lang.String, java.lang.String> r12, v5.c<? super com.onesignal.user.internal.backend.CreateUserResponse> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.onesignal.user.internal.backend.impl.UserBackendService.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1 r0 = (com.onesignal.user.internal.backend.impl.UserBackendService.AnonymousClass1) r0
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
            com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1 r0 = new com.onesignal.user.internal.backend.impl.UserBackendService$createUser$1
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
            goto L8e
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            r2.q.z0(r13)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            boolean r13 = r10.isEmpty()
            if (r13 != 0) goto L4d
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            org.json.JSONObject r10 = com.onesignal.common.JSONObjectExtensionsKt.putMap(r13, r10)
            java.lang.String r13 = "identity"
            r3.put(r13, r10)
        L4d:
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L5e
            com.onesignal.user.internal.backend.impl.JSONConverter r10 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONArray r10 = r10.convertToJSON(r11)
            java.lang.String r11 = "subscriptions"
            r3.put(r11, r10)
        L5e:
            boolean r10 = r12.isEmpty()
            if (r10 != 0) goto L72
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            org.json.JSONObject r10 = com.onesignal.common.JSONObjectExtensionsKt.putMap(r10, r12)
            java.lang.String r11 = "properties"
            r3.put(r11, r10)
        L72:
            java.lang.String r10 = "refresh_device_metadata"
            r3.put(r10, r2)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r10 = "apps/"
            java.lang.String r11 = "/users"
            java.lang.String r9 = a1.a.m(r10, r9, r11)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r13 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.post$default(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L8e
            return r0
        L8e:
            com.onesignal.core.internal.http.HttpResponse r13 = (com.onesignal.core.internal.http.HttpResponse) r13
            boolean r9 = r13.isSuccess()
            if (r9 == 0) goto La9
            com.onesignal.user.internal.backend.impl.JSONConverter r9 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r10 = new org.json.JSONObject
            java.lang.String r11 = r13.getPayload()
            kotlin.jvm.internal.k.b(r11)
            r10.<init>(r11)
            com.onesignal.user.internal.backend.CreateUserResponse r9 = r9.convertToCreateUserResponse(r10)
            return r9
        La9:
            com.onesignal.common.exceptions.BackendException r9 = new com.onesignal.common.exceptions.BackendException
            int r10 = r13.getStatusCode()
            java.lang.String r11 = r13.getPayload()
            java.lang.Integer r12 = r13.getRetryAfterSeconds()
            r9.<init>(r10, r11, r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.createUser(java.lang.String, java.util.Map, java.util.List, java.util.Map, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.user.internal.backend.IUserBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getUser(java.lang.String r8, java.lang.String r9, java.lang.String r10, v5.c<? super com.onesignal.user.internal.backend.CreateUserResponse> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.user.internal.backend.impl.UserBackendService.C28381
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1 r0 = (com.onesignal.user.internal.backend.impl.UserBackendService.C28381) r0
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
            com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1 r0 = new com.onesignal.user.internal.backend.impl.UserBackendService$getUser$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            r2.q.z0(r11)
            goto L61
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            r2.q.z0(r11)
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r3 = "apps/"
            r11.<init>(r3)
            r11.append(r8)
            java.lang.String r8 = "/users/by/"
            r11.append(r8)
            r11.append(r9)
            r8 = 47
            r11.append(r8)
            r11.append(r10)
            java.lang.String r8 = r11.toString()
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r11 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L61
            return r0
        L61:
            com.onesignal.core.internal.http.HttpResponse r11 = (com.onesignal.core.internal.http.HttpResponse) r11
            boolean r8 = r11.isSuccess()
            if (r8 == 0) goto L79
            com.onesignal.user.internal.backend.impl.JSONConverter r8 = com.onesignal.user.internal.backend.impl.JSONConverter.INSTANCE
            org.json.JSONObject r9 = new org.json.JSONObject
            java.lang.String r10 = r11.getPayload()
            r9.<init>(r10)
            com.onesignal.user.internal.backend.CreateUserResponse r8 = r8.convertToCreateUserResponse(r9)
            return r8
        L79:
            com.onesignal.common.exceptions.BackendException r8 = new com.onesignal.common.exceptions.BackendException
            int r9 = r11.getStatusCode()
            java.lang.String r10 = r11.getPayload()
            java.lang.Integer r11 = r11.getRetryAfterSeconds()
            r8.<init>(r9, r10, r11)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.getUser(java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.user.internal.backend.IUserBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateUser(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.onesignal.user.internal.backend.PropertiesObject r8, boolean r9, com.onesignal.user.internal.backend.PropertiesDeltasObject r10, v5.c<? super com.onesignal.common.consistency.RywData> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.impl.UserBackendService.updateUser(java.lang.String, java.lang.String, java.lang.String, com.onesignal.user.internal.backend.PropertiesObject, boolean, com.onesignal.user.internal.backend.PropertiesDeltasObject, v5.c):java.lang.Object");
    }
}
