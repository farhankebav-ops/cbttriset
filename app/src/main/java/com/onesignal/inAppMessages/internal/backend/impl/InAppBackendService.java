package com.onesignal.inAppMessages.internal.backend.impl;

import a1.a;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.hydrators.InAppHydrator;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppBackendService implements IInAppBackendService {
    private final IDeviceService _deviceService;
    private final IHttpClient _httpClient;
    private final InAppHydrator _hydrator;
    private int htmlNetworkRequestAttemptCount;

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$attemptFetchWithRetries$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, 235, 247}, m = "attemptFetchWithRetries")
    public static final class AnonymousClass1 extends c {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.attemptFetchWithRetries(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$fetchInAppMessagesWithoutRywToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {255}, m = "fetchInAppMessagesWithoutRywToken")
    public static final class C27251 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27251(v5.c<? super C27251> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.fetchInAppMessagesWithoutRywToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {49}, m = "getIAMData")
    public static final class C27261 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27261(v5.c<? super C27261> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.getIAMData(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {79}, m = "getIAMPreviewData")
    public static final class C27271 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27271(v5.c<? super C27271> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.getIAMPreviewData(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {34, 37}, m = "listInAppMessages")
    public static final class C27281 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C27281(v5.c<? super C27281> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.listInAppMessages(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {110}, m = "sendIAMClick")
    public static final class C27291 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27291(v5.c<? super C27291> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.sendIAMClick(null, null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {170}, m = "sendIAMImpression")
    public static final class C27301 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27301(v5.c<? super C27301> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.sendIAMImpression(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService", f = "InAppBackendService.kt", l = {143}, m = "sendIAMPageImpression")
    public static final class C27311 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27311(v5.c<? super C27311> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppBackendService.this.sendIAMPageImpression(null, null, null, null, null, this);
        }
    }

    public InAppBackendService(IHttpClient _httpClient, IDeviceService _deviceService, InAppHydrator _hydrator) {
        k.e(_httpClient, "_httpClient");
        k.e(_deviceService, "_deviceService");
        k.e(_hydrator, "_hydrator");
        this._httpClient = _httpClient;
        this._deviceService = _deviceService;
        this._hydrator = _hydrator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Path cross not found for [B:49:0x010a, B:52:0x0128], limit reached: 56 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0108 -> B:52:0x0128). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0125 -> B:52:0x0128). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptFetchWithRetries(java.lang.String r22, com.onesignal.common.consistency.RywData r23, e6.a r24, v5.c<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.attemptFetchWithRetries(java.lang.String, com.onesignal.common.consistency.RywData, e6.a, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchInAppMessagesWithoutRywToken(java.lang.String r12, e6.a r13, v5.c<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27251
            if (r0 == 0) goto L13
            r0 = r14
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$fetchInAppMessagesWithoutRywToken$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$fetchInAppMessagesWithoutRywToken$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$fetchInAppMessagesWithoutRywToken$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r12 = r0.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r12 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r12
            r2.q.z0(r14)
            goto L55
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            r2.q.z0(r14)
            com.onesignal.core.internal.http.IHttpClient r14 = r11._httpClient
            com.onesignal.core.internal.http.impl.OptionalHeaders r4 = new com.onesignal.core.internal.http.impl.OptionalHeaders
            java.lang.Object r13 = r13.invoke()
            r8 = r13
            java.lang.Long r8 = (java.lang.Long) r8
            r9 = 7
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r14 = r14.get(r12, r4, r0)
            if (r14 != r1) goto L54
            return r1
        L54:
            r12 = r11
        L55:
            com.onesignal.core.internal.http.HttpResponse r14 = (com.onesignal.core.internal.http.HttpResponse) r14
            boolean r13 = r14.isSuccess()
            r0 = 0
            if (r13 == 0) goto L72
            java.lang.String r13 = r14.getPayload()
            if (r13 == 0) goto L6a
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>(r13)
            goto L6b
        L6a:
            r14 = r0
        L6b:
            if (r14 == 0) goto L72
            java.util.List r12 = r12.hydrateInAppMessages(r14)
            return r12
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.fetchInAppMessagesWithoutRywToken(java.lang.String, e6.a, v5.c):java.lang.Object");
    }

    private final String htmlPathForMessage(String str, String str2, String str3) {
        if (str2 != null) {
            StringBuilder sbZ = a.z("in_app_messages/", str, "/variants/", str2, "/html?app_id=");
            sbZ.append(str3);
            return sbZ.toString();
        }
        Logging.error$default("Unable to find a variant for in-app message " + str, null, 2, null);
        return null;
    }

    private final List<InAppMessage> hydrateInAppMessages(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("in_app_messages")) {
            return null;
        }
        JSONArray iamMessagesAsJSON = jSONObject.getJSONArray("in_app_messages");
        InAppHydrator inAppHydrator = this._hydrator;
        k.d(iamMessagesAsJSON, "iamMessagesAsJSON");
        return inAppHydrator.hydrateIAMMessages(iamMessagesAsJSON);
    }

    private final void printHttpErrorForInAppMessageRequest(String str, int i2, String str2) {
        Logging.error$default("Encountered a " + i2 + " error while attempting in-app message " + str + " request: " + str2, null, 2, null);
    }

    private final void printHttpSuccessForInAppMessageRequest(String str, String str2) {
        Logging.debug$default(a.n("Successful post for in-app message ", str, " request: ", str2), null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIAMData(java.lang.String r11, java.lang.String r12, java.lang.String r13, v5.c<? super com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27261
            if (r0 == 0) goto L14
            r0 = r14
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27261) r0
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
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMData$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r7 = 0
            r8 = 1
            r9 = 0
            if (r1 == 0) goto L37
            if (r1 != r8) goto L2f
            java.lang.Object r11 = r4.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r11 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r11
            r2.q.z0(r14)
            goto L57
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            r2.q.z0(r14)
            java.lang.String r2 = r10.htmlPathForMessage(r12, r13, r11)
            if (r2 != 0) goto L46
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r11 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r11.<init>(r7, r9)
            return r11
        L46:
            com.onesignal.core.internal.http.IHttpClient r1 = r10._httpClient
            r4.L$0 = r10
            r4.label = r8
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r14 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r14 != r0) goto L56
            return r0
        L56:
            r11 = r10
        L57:
            com.onesignal.core.internal.http.HttpResponse r14 = (com.onesignal.core.internal.http.HttpResponse) r14
            boolean r12 = r14.isSuccess()
            if (r12 == 0) goto L79
            r11.htmlNetworkRequestAttemptCount = r9
            org.json.JSONObject r12 = new org.json.JSONObject
            java.lang.String r13 = r14.getPayload()
            kotlin.jvm.internal.k.b(r13)
            r12.<init>(r13)
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r13 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            com.onesignal.inAppMessages.internal.hydrators.InAppHydrator r11 = r11._hydrator
            com.onesignal.inAppMessages.internal.InAppMessageContent r11 = r11.hydrateIAMMessageContent(r12)
            r13.<init>(r11, r9)
            return r13
        L79:
            int r12 = r14.getStatusCode()
            java.lang.String r13 = r14.getPayload()
            java.lang.String r0 = "html"
            r11.printHttpErrorForInAppMessageRequest(r0, r12, r13)
            com.onesignal.common.NetworkUtils r12 = com.onesignal.common.NetworkUtils.INSTANCE
            int r13 = r14.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r13 = r12.getResponseStatusType(r13)
            com.onesignal.common.NetworkUtils$ResponseStatusType r14 = com.onesignal.common.NetworkUtils.ResponseStatusType.RETRYABLE
            if (r13 != r14) goto La8
            int r13 = r11.htmlNetworkRequestAttemptCount
            int r12 = r12.getMaxNetworkRequestAttemptCount()
            if (r13 < r12) goto L9d
            goto La8
        L9d:
            int r12 = r11.htmlNetworkRequestAttemptCount
            int r12 = r12 + r8
            r11.htmlNetworkRequestAttemptCount = r12
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r11 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r11.<init>(r7, r8)
            return r11
        La8:
            r11.htmlNetworkRequestAttemptCount = r9
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r11 = new com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse
            r11.<init>(r7, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMData(java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getIAMPreviewData(java.lang.String r8, java.lang.String r9, v5.c<? super com.onesignal.inAppMessages.internal.InAppMessageContent> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27271
            if (r0 == 0) goto L14
            r0 = r10
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27271) r0
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
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$getIAMPreviewData$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r8 = r4.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r8 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r8
            r2.q.z0(r10)
            goto L60
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            r2.q.z0(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "in_app_messages/device_preview?preview_id="
            r10.<init>(r1)
            r10.append(r9)
            java.lang.String r9 = "&app_id="
            r10.append(r9)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.onesignal.core.internal.http.IHttpClient r1 = r7._httpClient
            r4.L$0 = r7
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r10 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.get$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L5f
            return r0
        L5f:
            r8 = r7
        L60:
            com.onesignal.core.internal.http.HttpResponse r10 = (com.onesignal.core.internal.http.HttpResponse) r10
            boolean r9 = r10.isSuccess()
            if (r9 == 0) goto L7b
            org.json.JSONObject r9 = new org.json.JSONObject
            java.lang.String r10 = r10.getPayload()
            kotlin.jvm.internal.k.b(r10)
            r9.<init>(r10)
            com.onesignal.inAppMessages.internal.hydrators.InAppHydrator r8 = r8._hydrator
            com.onesignal.inAppMessages.internal.InAppMessageContent r8 = r8.hydrateIAMMessageContent(r9)
            return r8
        L7b:
            int r9 = r10.getStatusCode()
            java.lang.String r10 = r10.getPayload()
            java.lang.String r0 = "html"
            r8.printHttpErrorForInAppMessageRequest(r0, r9, r10)
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMPreviewData(java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object listInAppMessages(java.lang.String r8, java.lang.String r9, com.onesignal.common.consistency.RywData r10, e6.a r11, v5.c<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r12) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27281
            if (r0 == 0) goto L13
            r0 = r12
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$listInAppMessages$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            r2.q.z0(r12)
            return r12
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            java.lang.Object r8 = r0.L$4
            r11 = r8
            e6.a r11 = (e6.a) r11
            java.lang.Object r8 = r0.L$3
            r10 = r8
            com.onesignal.common.consistency.RywData r10 = (com.onesignal.common.consistency.RywData) r10
            java.lang.Object r8 = r0.L$2
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r2 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r2
            r2.q.z0(r12)
            goto L71
        L4d:
            r2.q.z0(r12)
            java.lang.Long r12 = r10.getRywDelay()
            if (r12 == 0) goto L5b
            long r5 = r12.longValue()
            goto L5d
        L5b:
            r5 = 500(0x1f4, double:2.47E-321)
        L5d:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r11
            r0.label = r4
            java.lang.Object r12 = q6.c0.k(r5, r0)
            if (r12 != r1) goto L70
            goto L8e
        L70:
            r2 = r7
        L71:
            java.lang.String r12 = "/subscriptions/"
            java.lang.String r4 = "/iams"
            java.lang.String r5 = "apps/"
            java.lang.String r8 = a1.a.o(r5, r8, r12, r9, r4)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.L$2 = r9
            r0.L$3 = r9
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r8 = r2.attemptFetchWithRetries(r8, r10, r11, r0)
            if (r8 != r1) goto L8f
        L8e:
            return r1
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.listInAppMessages(java.lang.String, java.lang.String, com.onesignal.common.consistency.RywData, e6.a, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMClick(final java.lang.String r11, final java.lang.String r12, final java.lang.String r13, java.lang.String r14, final java.lang.String r15, final boolean r16, v5.c<? super q5.x> r17) throws java.lang.Throwable {
        /*
            r10 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27291
            if (r1 == 0) goto L16
            r1 = r0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1 r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27291) r1
            int r3 = r1.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r1.label = r3
        L14:
            r7 = r1
            goto L1c
        L16:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1 r1 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.result
            w5.a r8 = w5.a.f17774a
            int r1 = r7.label
            r9 = 1
            if (r1 == 0) goto L37
            if (r1 != r9) goto L2f
            java.lang.Object r1 = r7.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r1
            r2.q.z0(r0)
            goto L68
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            r2.q.z0(r0)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$json$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMClick$json$1
            r2 = r10
            r1 = r11
            r3 = r12
            r5 = r13
            r4 = r15
            r6 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.onesignal.core.internal.http.IHttpClient r1 = r10._httpClient
            java.lang.String r3 = "in_app_messages/"
            java.lang.String r4 = "/click"
            java.lang.String r3 = a1.a.m(r3, r14, r4)
            r7.L$0 = r10
            r7.label = r9
            r4 = 0
            r5 = 4
            r6 = 0
            r13 = r0
            r11 = r1
            r12 = r3
            r14 = r4
            r16 = r5
            r17 = r6
            r15 = r7
            java.lang.Object r0 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.post$default(r11, r12, r13, r14, r15, r16, r17)
            if (r0 != r8) goto L67
            return r8
        L67:
            r1 = r10
        L68:
            com.onesignal.core.internal.http.HttpResponse r0 = (com.onesignal.core.internal.http.HttpResponse) r0
            boolean r3 = r0.isSuccess()
            java.lang.String r4 = "engagement"
            if (r3 == 0) goto L7f
            java.lang.String r0 = r0.getPayload()
            kotlin.jvm.internal.k.b(r0)
            r1.printHttpSuccessForInAppMessageRequest(r4, r0)
            q5.x r0 = q5.x.f13520a
            return r0
        L7f:
            int r3 = r0.getStatusCode()
            java.lang.String r5 = r0.getPayload()
            r1.printHttpErrorForInAppMessageRequest(r4, r3, r5)
            com.onesignal.common.exceptions.BackendException r1 = new com.onesignal.common.exceptions.BackendException
            int r3 = r0.getStatusCode()
            java.lang.String r4 = r0.getPayload()
            java.lang.Integer r0 = r0.getRetryAfterSeconds()
            r1.<init>(r3, r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMImpression(final java.lang.String r9, final java.lang.String r10, final java.lang.String r11, java.lang.String r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27301
            if (r0 == 0) goto L14
            r0 = r13
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1 r0 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27301) r0
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
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r5.result
            w5.a r0 = w5.a.f17774a
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r9 = r5.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r9 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r9
            r2.q.z0(r13)
            goto L57
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            r2.q.z0(r13)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$json$1 r3 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMImpression$json$1
            r3.<init>(r9, r10, r11, r8)
            com.onesignal.core.internal.http.IHttpClient r1 = r8._httpClient
            java.lang.String r9 = "in_app_messages/"
            java.lang.String r10 = "/impression"
            java.lang.String r9 = a1.a.m(r9, r12, r10)
            r5.L$0 = r8
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            java.lang.Object r13 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.post$default(r1, r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L56
            return r0
        L56:
            r9 = r8
        L57:
            com.onesignal.core.internal.http.HttpResponse r13 = (com.onesignal.core.internal.http.HttpResponse) r13
            boolean r10 = r13.isSuccess()
            java.lang.String r11 = "impression"
            if (r10 == 0) goto L6e
            java.lang.String r10 = r13.getPayload()
            kotlin.jvm.internal.k.b(r10)
            r9.printHttpSuccessForInAppMessageRequest(r11, r10)
            q5.x r9 = q5.x.f13520a
            return r9
        L6e:
            int r10 = r13.getStatusCode()
            java.lang.String r12 = r13.getPayload()
            r9.printHttpErrorForInAppMessageRequest(r11, r10, r12)
            com.onesignal.common.exceptions.BackendException r9 = new com.onesignal.common.exceptions.BackendException
            int r10 = r13.getStatusCode()
            java.lang.String r11 = r13.getPayload()
            java.lang.Integer r12 = r13.getRetryAfterSeconds()
            r9.<init>(r10, r11, r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMImpression(java.lang.String, java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object sendIAMPageImpression(final java.lang.String r11, final java.lang.String r12, final java.lang.String r13, java.lang.String r14, final java.lang.String r15, v5.c<? super q5.x> r16) throws java.lang.Throwable {
        /*
            r10 = this;
            r0 = r16
            boolean r1 = r0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27311
            if (r1 == 0) goto L16
            r1 = r0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1 r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.C27311) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r2 & r3
            if (r5 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1 r1 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.result
            w5.a r9 = w5.a.f17774a
            int r1 = r6.label
            r7 = 1
            if (r1 == 0) goto L39
            if (r1 != r7) goto L31
            java.lang.Object r1 = r6.L$0
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService r1 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService) r1
            r2.q.z0(r0)
            r4 = r1
            r1 = r0
            goto L60
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            r2.q.z0(r0)
            com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$json$1 r0 = new com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService$sendIAMPageImpression$json$1
            r4 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r4 = r0
            com.onesignal.core.internal.http.IHttpClient r2 = r10._httpClient
            java.lang.String r1 = "in_app_messages/"
            java.lang.String r3 = "/pageImpression"
            java.lang.String r3 = a1.a.m(r1, r14, r3)
            r6.L$0 = r10
            r6.label = r7
            r5 = 0
            r7 = 4
            r8 = 0
            java.lang.Object r1 = com.onesignal.core.internal.http.IHttpClient.DefaultImpls.post$default(r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r9) goto L5f
            return r9
        L5f:
            r4 = r10
        L60:
            com.onesignal.core.internal.http.HttpResponse r1 = (com.onesignal.core.internal.http.HttpResponse) r1
            boolean r2 = r1.isSuccess()
            java.lang.String r3 = "page impression"
            if (r2 == 0) goto L77
            java.lang.String r1 = r1.getPayload()
            kotlin.jvm.internal.k.b(r1)
            r4.printHttpSuccessForInAppMessageRequest(r3, r1)
            q5.x r1 = q5.x.f13520a
            return r1
        L77:
            int r2 = r1.getStatusCode()
            java.lang.String r5 = r1.getPayload()
            r4.printHttpErrorForInAppMessageRequest(r3, r2, r5)
            com.onesignal.common.exceptions.BackendException r2 = new com.onesignal.common.exceptions.BackendException
            int r3 = r1.getStatusCode()
            java.lang.String r4 = r1.getPayload()
            java.lang.Integer r1 = r1.getRetryAfterSeconds()
            r2.<init>(r3, r4, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, v5.c):java.lang.Object");
    }
}
