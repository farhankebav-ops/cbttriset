package com.unity3d.ads.gatewayclient;

import com.google.protobuf.InvalidProtocolBufferException;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.AdActivity;
import e6.p;
import gatewayprotocol.v1.ErrorKt;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseKt;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import i6.d;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import r2.q;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonGatewayClient implements GatewayClient {
    public static final int CODE_400 = 400;
    public static final int CODE_599 = 599;
    public static final int CODE_TOO_MANY_REQUESTS = 429;
    public static final Companion Companion = new Companion(null);
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_PROTOBUF = "application/x-protobuf";
    public static final String HEADER_RETRY_AFTER = "Retry-After";
    public static final String HEADER_RETRY_ATTEMPT = "X-RETRY-ATTEMPT";
    private final HandleGatewayUniversalResponse handleGatewayUniversalResponse;
    private final HttpClient httpClient;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.gatewayclient.CommonGatewayClient$executeRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "executeRequest")
    public static final class AnonymousClass1 extends c {
        int I$0;
        long J$0;
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
            return CommonGatewayClient.this.executeRequest(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.gatewayclient.CommonGatewayClient$executeWithRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", l = {75, 81, 105}, m = "executeWithRetry")
    public static final class C29591 extends c {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C29591(v5.c<? super C29591> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonGatewayClient.this.executeWithRetry(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", l = {Sdk.SDKMetric.SDKMetricType.AD_START_TO_BACKGROUND_DURATION_MS_VALUE}, m = AdActivity.REQUEST_KEY_EXTRA)
    public static final class C29601 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C29601(v5.c<? super C29601> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonGatewayClient.this.request(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.gatewayclient.CommonGatewayClient$request$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient$request$2", f = "CommonGatewayClient.kt", l = {60}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ OperationType $operationType;
        final /* synthetic */ UniversalRequestOuterClass.UniversalRequest $request;
        final /* synthetic */ RequestPolicy $requestPolicy;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, UniversalRequestOuterClass.UniversalRequest universalRequest, RequestPolicy requestPolicy, OperationType operationType, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$url = str;
            this.$request = universalRequest;
            this.$requestPolicy = requestPolicy;
            this.$operationType = operationType;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return CommonGatewayClient.this.new AnonymousClass2(this.$url, this.$request, this.$requestPolicy, this.$operationType, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            CommonGatewayClient commonGatewayClient = CommonGatewayClient.this;
            String str = this.$url;
            UniversalRequestOuterClass.UniversalRequest universalRequest = this.$request;
            RequestPolicy requestPolicy = this.$requestPolicy;
            OperationType operationType = this.$operationType;
            this.label = 1;
            Object objExecuteWithRetry = commonGatewayClient.executeWithRetry(str, universalRequest, requestPolicy, operationType, this);
            return objExecuteWithRetry == aVar ? aVar : objExecuteWithRetry;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super UniversalResponseOuterClass.UniversalResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public CommonGatewayClient(HttpClient httpClient, HandleGatewayUniversalResponse handleGatewayUniversalResponse, SendDiagnosticEvent sendDiagnosticEvent, SessionRepository sessionRepository) {
        k.e(httpClient, "httpClient");
        k.e(handleGatewayUniversalResponse, "handleGatewayUniversalResponse");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(sessionRepository, "sessionRepository");
        this.httpClient = httpClient;
        this.handleGatewayUniversalResponse = handleGatewayUniversalResponse;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sessionRepository = sessionRepository;
    }

    private final HttpRequest buildHttpRequest(String str, Map<String, ? extends List<String>> map, RequestPolicy requestPolicy, UniversalRequestOuterClass.UniversalRequest universalRequest) {
        return new HttpRequest(str, null, RequestType.POST, universalRequest.toByteArray(), map, null, null, null, null, requestPolicy.getConnectTimeout(), requestPolicy.getReadTimeout(), requestPolicy.getWriteTimeout(), requestPolicy.getOverallTimeout(), true, null, null, 0, 115170, null);
    }

    private final long calculateDelayTime(long j, RequestPolicy requestPolicy, int i2) {
        return Math.min(calculateExponentialBackoff(j, requestPolicy, i2) + calculateJitter(requestPolicy.getRetryWaitBase(), requestPolicy.getRetryJitterPct()), requestPolicy.getRetryMaxInterval());
    }

    private final long calculateExponentialBackoff(long j, RequestPolicy requestPolicy, int i2) {
        if (i2 == 0) {
            return j;
        }
        return (long) (requestPolicy.getRetryScalingFactor() * j);
    }

    private final long calculateJitter(int i2, float f4) {
        if (f4 == 0.0f) {
            return 0L;
        }
        long j = (long) (i2 * f4);
        return d.f12038a.e(-j, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeRequest(com.unity3d.services.core.network.model.HttpRequest r22, int r23, com.unity3d.ads.core.data.model.OperationType r24, v5.c<? super com.unity3d.services.core.network.model.HttpResponse> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.gatewayclient.CommonGatewayClient.executeRequest(com.unity3d.services.core.network.model.HttpRequest, int, com.unity3d.ads.core.data.model.OperationType, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0185 -> B:50:0x018b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeWithRetry(java.lang.String r31, gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest r32, com.unity3d.ads.gatewayclient.RequestPolicy r33, com.unity3d.ads.core.data.model.OperationType r34, v5.c<? super gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.gatewayclient.CommonGatewayClient.executeWithRetry(java.lang.String, gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest, com.unity3d.ads.gatewayclient.RequestPolicy, com.unity3d.ads.core.data.model.OperationType, v5.c):java.lang.Object");
    }

    private final String getGatewayUrl(String str) {
        return !k.a(str, UnityAdsConstants.DefaultUrls.GATEWAY_URL) ? str : this.sessionRepository.getGatewayUrl();
    }

    private final Map<String, List<String>> getHeaders(int i2) {
        s5.f fVar = new s5.f();
        fVar.put("Content-Type", q.j0(HEADER_PROTOBUF));
        if (i2 > 0) {
            fVar.put(HEADER_RETRY_ATTEMPT, q.j0(String.valueOf(i2)));
        }
        return fVar.b();
    }

    private final UniversalResponseOuterClass.UniversalResponse getUniversalResponse(HttpResponse httpResponse, OperationType operationType) {
        try {
            Object body = httpResponse.getBody();
            if (body instanceof byte[]) {
                UniversalResponseOuterClass.UniversalResponse from = UniversalResponseOuterClass.UniversalResponse.parseFrom((byte[]) body);
                k.d(from, "parseFrom(responseBody)");
                return from;
            }
            if (!(body instanceof String)) {
                throw new InvalidProtocolBufferException("Could not parse response from gateway service");
            }
            byte[] bytes = ((String) body).getBytes(n6.a.f13073a);
            k.d(bytes, "this as java.lang.String).getBytes(charset)");
            UniversalResponseOuterClass.UniversalResponse from2 = UniversalResponseOuterClass.UniversalResponse.parseFrom(bytes);
            k.d(from2, "parseFrom(\n             ….UTF_8)\n                )");
            return from2;
        } catch (InvalidProtocolBufferException e) {
            DeviceLog.debug("Failed to parse response from gateway service with exception: %s", e.getLocalizedMessage());
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_parse_failure", null, r5.x.f0(new q5.i("operation", operationType.toString()), new q5.i("reason", "protobuf_parsing"), new q5.i("reason_debug", httpResponse.getBody().toString())), null, null, null, 58, null);
            UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
            UniversalResponseOuterClass.UniversalResponse.Builder builderNewBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
            k.d(builderNewBuilder, "newBuilder()");
            UniversalResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
            ErrorKt.Dsl.Companion companion2 = ErrorKt.Dsl.Companion;
            ErrorOuterClass.Error.Builder builderNewBuilder2 = ErrorOuterClass.Error.newBuilder();
            k.d(builderNewBuilder2, "newBuilder()");
            ErrorKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
            dsl_create2.setErrorText("ERROR: Could not parse response from gateway service");
            dsl_create.setError(dsl_create2._build());
            return dsl_create._build();
        }
    }

    private final void sendNetworkErrorDiagnosticEvent(UnityAdsNetworkException unityAdsNetworkException, int i2, OperationType operationType, o6.e eVar) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return;
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_failure_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), r5.x.g0(new q5.i("operation", operationType.toString()), new q5.i("retries", String.valueOf(i2)), new q5.i("protocol", String.valueOf(unityAdsNetworkException.getProtocol())), new q5.i("network_client", String.valueOf(unityAdsNetworkException.getClient())), new q5.i("reason_code", String.valueOf(unityAdsNetworkException.getCode())), new q5.i("reason_debug", unityAdsNetworkException.getMessage())), null, null, null, 56, null);
    }

    private final void sendNetworkSuccessDiagnosticEvent(HttpResponse httpResponse, int i2, OperationType operationType, o6.e eVar) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return;
        }
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_success_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(eVar)), r5.x.g0(new q5.i("operation", operationType.toString()), new q5.i("retries", String.valueOf(i2)), new q5.i("protocol", httpResponse.getProtocol()), new q5.i("network_client", httpResponse.getClient()), new q5.i("reason_code", String.valueOf(httpResponse.getStatusCode()))), null, null, null, 56, null);
    }

    private final boolean shouldRetry(int i2, long j, int i8) {
        return 400 <= i2 && i2 < 600 && j < ((long) i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.unity3d.ads.gatewayclient.GatewayClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object request(java.lang.String r14, gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest r15, com.unity3d.ads.gatewayclient.RequestPolicy r16, com.unity3d.ads.core.data.model.OperationType r17, v5.c<? super gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse> r18) throws java.lang.Throwable {
        /*
            r13 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.unity3d.ads.gatewayclient.CommonGatewayClient.C29601
            if (r1 == 0) goto L15
            r1 = r0
            com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1 r1 = (com.unity3d.ads.gatewayclient.CommonGatewayClient.C29601) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1 r1 = new com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            w5.a r9 = w5.a.f17774a
            int r2 = r1.label
            r10 = 1
            if (r2 == 0) goto L35
            if (r2 != r10) goto L2d
            java.lang.Object r1 = r1.L$0
            com.unity3d.ads.gatewayclient.RequestPolicy r1 = (com.unity3d.ads.gatewayclient.RequestPolicy) r1
            r2.q.z0(r0)
            goto L61
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            r2.q.z0(r0)
            int r0 = o6.a.f13207d
            int r0 = r16.getMaxDuration()
            o6.c r2 = o6.c.f13211c
            long r11 = r2.q.A0(r0, r2)
            com.unity3d.ads.gatewayclient.CommonGatewayClient$request$2 r2 = new com.unity3d.ads.gatewayclient.CommonGatewayClient$request$2
            r8 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r2.<init>(r4, r5, r6, r7, r8)
            r1.L$0 = r6
            r1.label = r10
            long r3 = q6.c0.E(r11)
            java.lang.Object r0 = q6.c0.J(r3, r2, r1)
            if (r0 != r9) goto L60
            return r9
        L60:
            r1 = r6
        L61:
            gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r0 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r0
            if (r0 == 0) goto L66
            return r0
        L66:
            com.unity3d.ads.core.data.model.exception.NetworkTimeoutException r2 = new com.unity3d.ads.core.data.model.exception.NetworkTimeoutException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Gateway request timed out after "
            r0.<init>(r3)
            int r1 = r1.getMaxDuration()
            r0.append(r1)
            java.lang.String r1 = "ms"
            r0.append(r1)
            java.lang.String r3 = r0.toString()
            r10 = 126(0x7e, float:1.77E-43)
            r11 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.gatewayclient.CommonGatewayClient.request(java.lang.String, gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest, com.unity3d.ads.gatewayclient.RequestPolicy, com.unity3d.ads.core.data.model.OperationType, v5.c):java.lang.Object");
    }
}
