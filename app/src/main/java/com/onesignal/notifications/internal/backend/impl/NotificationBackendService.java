package com.onesignal.notifications.internal.backend.impl;

import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationBackendService implements INotificationBackendService {
    private final IHttpClient _httpClient;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.backend.impl.NotificationBackendService", f = "NotificationBackendService.kt", l = {43}, m = "updateNotificationAsOpened")
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
            return NotificationBackendService.this.updateNotificationAsOpened(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.backend.impl.NotificationBackendService", f = "NotificationBackendService.kt", l = {24}, m = "updateNotificationAsReceived")
    public static final class C27691 extends c {
        int label;
        /* synthetic */ Object result;

        public C27691(v5.c<? super C27691> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationBackendService.this.updateNotificationAsReceived(null, null, null, null, this);
        }
    }

    public NotificationBackendService(IHttpClient _httpClient) {
        k.e(_httpClient, "_httpClient");
        this._httpClient = _httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.notifications.internal.backend.INotificationBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateNotificationAsOpened(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.onesignal.core.internal.device.IDeviceService.DeviceType r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1 r0 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService.AnonymousClass1) r0
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
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1 r0 = new com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsOpened$1
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
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r13 = "app_id"
            r3.put(r13, r9)
            java.lang.String r9 = "player_id"
            r3.put(r9, r11)
            java.lang.String r9 = "opened"
            r3.put(r9, r2)
            java.lang.String r9 = "device_type"
            int r11 = r12.getValue()
            r3.put(r9, r11)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r9 = "notifications/"
            java.lang.String r9 = a1.a.l(r9, r10)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r13 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.put$default(r1, r2, r3, r4, r5, r6, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsOpened(java.lang.String, java.lang.String, java.lang.String, com.onesignal.core.internal.device.IDeviceService$DeviceType, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.notifications.internal.backend.INotificationBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateNotificationAsReceived(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.onesignal.core.internal.device.IDeviceService.DeviceType r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService.C27691
            if (r0 == 0) goto L14
            r0 = r13
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1 r0 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService.C27691) r0
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
            com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1 r0 = new com.onesignal.notifications.internal.backend.impl.NotificationBackendService$updateNotificationAsReceived$1
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
            goto L6b
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            r2.q.z0(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r1 = "app_id"
            org.json.JSONObject r9 = r13.put(r1, r9)
            java.lang.String r13 = "player_id"
            org.json.JSONObject r9 = r9.put(r13, r11)
            java.lang.String r11 = "device_type"
            int r12 = r12.getValue()
            org.json.JSONObject r3 = r9.put(r11, r12)
            java.lang.String r9 = "JSONObject()\n           …_type\", deviceType.value)"
            kotlin.jvm.internal.k.d(r3, r9)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r9 = "notifications/"
            java.lang.String r11 = "/report_received"
            java.lang.String r9 = a1.a.m(r9, r10, r11)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r13 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.put$default(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L6b
            return r0
        L6b:
            com.onesignal.core.internal.http.HttpResponse r13 = (com.onesignal.core.internal.http.HttpResponse) r13
            boolean r9 = r13.isSuccess()
            if (r9 == 0) goto L76
            q5.x r9 = q5.x.f13520a
            return r9
        L76:
            com.onesignal.common.exceptions.BackendException r9 = new com.onesignal.common.exceptions.BackendException
            int r10 = r13.getStatusCode()
            java.lang.String r11 = r13.getPayload()
            java.lang.Integer r12 = r13.getRetryAfterSeconds()
            r9.<init>(r10, r11, r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsReceived(java.lang.String, java.lang.String, java.lang.String, com.onesignal.core.internal.device.IDeviceService$DeviceType, v5.c):java.lang.Object");
    }
}
