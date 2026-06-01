package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.vungle.ads.internal.protos.Sdk;
import e6.l;
import e6.p;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import o6.d;
import o6.f;
import q5.j;
import q5.x;
import r2.q;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidHandleGatewayAdResponse implements HandleGatewayAdResponse {
    private final AdPlayerScope adPlayerScope;
    private final AdRepository adRepository;
    private final CacheWebViewAssets cacheWebViewAssets;
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetAdPlayer getAdPlayer;
    private final HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer;
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;
    private final GetOperativeEventApi getOperativeEventApi;
    private final GetWebViewBridgeUseCase getWebViewBridge;
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse", f = "AndroidHandleGatewayAdResponse.kt", l = {236, 242}, m = "cleanup")
    public static final class AnonymousClass1 extends c {
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
            return AndroidHandleGatewayAdResponse.this.cleanup(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse", f = "AndroidHandleGatewayAdResponse.kt", l = {97, 114, 145, 188, 192, Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE}, m = "invoke")
    public static final class C29011 extends c {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C29011(v5.c<? super C29011> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidHandleGatewayAdResponse.this.invoke(null, null, null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2", f = "AndroidHandleGatewayAdResponse.kt", l = {162}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ a0 $adPlayer;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(a0 a0Var, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$adPlayer = a0Var;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$adPlayer, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(AllowedPiiOuterClass.AllowedPii allowedPii, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(allowedPii, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                AllowedPiiOuterClass.AllowedPii allowedPii = (AllowedPiiOuterClass.AllowedPii) this.L$0;
                AdPlayer adPlayer = (AdPlayer) this.$adPlayer.f12717a;
                byte[] byteArray = allowedPii.toByteArray();
                k.d(byteArray, "it.toByteArray()");
                this.label = 1;
                if (adPlayer.onAllowedPiiChange(byteArray, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3", f = "AndroidHandleGatewayAdResponse.kt", l = {176}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements l {
        final /* synthetic */ AdObject $tmpAdObject;
        final /* synthetic */ String $webViewUrl;
        final /* synthetic */ AndroidWebViewContainer $webviewContainer;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AndroidWebViewContainer androidWebViewContainer, String str, AdObject adObject, v5.c<? super AnonymousClass3> cVar) {
            super(1, cVar);
            this.$webviewContainer = androidWebViewContainer;
            this.$webViewUrl = str;
            this.$tmpAdObject = adObject;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return AndroidHandleGatewayAdResponse.this.new AnonymousClass3(this.$webviewContainer, this.$webViewUrl, this.$tmpAdObject, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            long j;
            Object objM;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            x xVar = x.f13520a;
            if (i2 == 0) {
                q.z0(obj);
                AndroidWebViewContainer androidWebViewContainer = this.$webviewContainer;
                String str = this.$webViewUrl;
                long jB = d.b();
                try {
                    this.J$0 = jB;
                    this.label = 1;
                    if (androidWebViewContainer.loadUrl(str, this) == aVar) {
                        return aVar;
                    }
                    j = jB;
                    objM = xVar;
                } catch (Throwable th2) {
                    th = th2;
                    j = jB;
                    objM = q.M(th);
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                try {
                    q.z0(obj);
                    objM = xVar;
                } catch (Throwable th3) {
                    th = th3;
                    objM = q.M(th);
                }
            }
            long jA = f.a(j);
            AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse = AndroidHandleGatewayAdResponse.this;
            SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, !(objM instanceof j) ? "native_load_file_task_success_time" : "native_load_file_task_failure_time", new Double(o6.a.h(jA, o6.c.f13211c)), null, null, this.$tmpAdObject, null, 44, null);
            q.z0(objM);
            return xVar;
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((AnonymousClass3) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4", f = "AndroidHandleGatewayAdResponse.kt", l = {193}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends i implements p {
        final /* synthetic */ a0 $adPlayer;
        final /* synthetic */ LoadEvent $loadEvent;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(LoadEvent loadEvent, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, a0 a0Var, v5.c<? super AnonymousClass4> cVar) {
            super(2, cVar);
            this.$loadEvent = loadEvent;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = a0Var;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidHandleGatewayAdResponse.this.new AnonymousClass4(this.$loadEvent, this.$opportunityId, this.$response, this.$adPlayer, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse = AndroidHandleGatewayAdResponse.this;
                Error error = new Error(((LoadEvent.Error) this.$loadEvent).getMessage());
                ByteString byteString = this.$opportunityId;
                AdResponseOuterClass.AdResponse adResponse = this.$response;
                AdPlayer adPlayer = (AdPlayer) this.$adPlayer.f12717a;
                this.label = 1;
                if (androidHandleGatewayAdResponse.cleanup(error, byteString, adResponse, adPlayer, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(q6.a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass4) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$5", f = "AndroidHandleGatewayAdResponse.kt", l = {Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends i implements p {
        final /* synthetic */ a0 $adPlayer;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        final /* synthetic */ CancellationException $t;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(CancellationException cancellationException, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, a0 a0Var, v5.c<? super AnonymousClass5> cVar) {
            super(2, cVar);
            this.$t = cancellationException;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = a0Var;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidHandleGatewayAdResponse.this.new AnonymousClass5(this.$t, this.$opportunityId, this.$response, this.$adPlayer, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse = AndroidHandleGatewayAdResponse.this;
                CancellationException cancellationException = this.$t;
                ByteString byteString = this.$opportunityId;
                AdResponseOuterClass.AdResponse adResponse = this.$response;
                AdPlayer adPlayer = (AdPlayer) this.$adPlayer.f12717a;
                this.label = 1;
                if (androidHandleGatewayAdResponse.cleanup(cancellationException, byteString, adResponse, adPlayer, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(q6.a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass5) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidHandleGatewayAdResponse(AdRepository adRepository, AndroidGetWebViewContainerUseCase getWebViewContainerUseCase, GetWebViewBridgeUseCase getWebViewBridge, DeviceInfoRepository deviceInfoRepository, HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer, CampaignRepository campaignRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, GetLatestWebViewConfiguration getLatestWebViewConfiguration, AdPlayerScope adPlayerScope, GetAdPlayer getAdPlayer, CacheWebViewAssets cacheWebViewAssets) {
        k.e(adRepository, "adRepository");
        k.e(getWebViewContainerUseCase, "getWebViewContainerUseCase");
        k.e(getWebViewBridge, "getWebViewBridge");
        k.e(deviceInfoRepository, "deviceInfoRepository");
        k.e(getHandleInvocationsFromAdViewer, "getHandleInvocationsFromAdViewer");
        k.e(campaignRepository, "campaignRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(getOperativeEventApi, "getOperativeEventApi");
        k.e(getLatestWebViewConfiguration, "getLatestWebViewConfiguration");
        k.e(adPlayerScope, "adPlayerScope");
        k.e(getAdPlayer, "getAdPlayer");
        k.e(cacheWebViewAssets, "cacheWebViewAssets");
        this.adRepository = adRepository;
        this.getWebViewContainerUseCase = getWebViewContainerUseCase;
        this.getWebViewBridge = getWebViewBridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.getHandleInvocationsFromAdViewer = getHandleInvocationsFromAdViewer;
        this.campaignRepository = campaignRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getLatestWebViewConfiguration = getLatestWebViewConfiguration;
        this.adPlayerScope = adPlayerScope;
        this.getAdPlayer = getAdPlayer;
        this.cacheWebViewAssets = cacheWebViewAssets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object cleanup(java.lang.Throwable r15, com.google.protobuf.ByteString r16, gatewayprotocol.v1.AdResponseOuterClass.AdResponse r17, com.unity3d.ads.adplayer.AdPlayer r18, v5.c<? super q5.x> r19) throws java.lang.Throwable {
        /*
            r14 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1 r1 = (com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r9 = r1
            goto L1c
        L16:
            com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1 r1 = new com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r9.result
            w5.a r1 = w5.a.f17774a
            int r2 = r9.label
            q5.x r12 = q5.x.f13520a
            r13 = 2
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L39
            if (r2 != r13) goto L31
            r2.q.z0(r0)
            goto Lac
        L31:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L39:
            java.lang.Object r15 = r9.L$0
            com.unity3d.ads.adplayer.AdPlayer r15 = (com.unity3d.ads.adplayer.AdPlayer) r15
            r2.q.z0(r0)
            goto L9e
        L41:
            r2.q.z0(r0)
            gatewayprotocol.v1.OperativeEventErrorDataKt$Dsl$Companion r0 = gatewayprotocol.v1.OperativeEventErrorDataKt.Dsl.Companion
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorData$Builder r2 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.k.d(r2, r4)
            gatewayprotocol.v1.OperativeEventErrorDataKt$Dsl r0 = r0._create(r2)
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r2 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED
            r0.setErrorType(r2)
            java.lang.Throwable r2 = r15.getCause()
            if (r2 == 0) goto L64
            java.lang.String r2 = r2.getMessage()
            if (r2 != 0) goto L6c
        L64:
            java.lang.String r2 = r15.getMessage()
            if (r2 != 0) goto L6c
            java.lang.String r2 = ""
        L6c:
            r0.setMessage(r2)
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorData r15 = r0._build()
            com.unity3d.ads.core.domain.events.GetOperativeEventApi r2 = r14.getOperativeEventApi
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType r0 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR
            com.google.protobuf.ByteString r5 = r17.getTrackingToken()
            java.lang.String r4 = "response.trackingToken"
            kotlin.jvm.internal.k.d(r5, r4)
            com.google.protobuf.ByteString r6 = r15.toByteString()
            java.lang.String r15 = "operativeEventErrorData.toByteString()"
            kotlin.jvm.internal.k.d(r6, r15)
            r15 = r18
            r9.L$0 = r15
            r9.label = r3
            r7 = 0
            r8 = 0
            r10 = 48
            r11 = 0
            r4 = r16
            r3 = r0
            java.lang.Object r0 = com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r0 != r1) goto L9e
            goto Lab
        L9e:
            if (r15 == 0) goto Lac
            r0 = 0
            r9.L$0 = r0
            r9.label = r13
            java.lang.Object r15 = r15.destroy(r9)
            if (r15 != r1) goto Lac
        Lab:
            return r1
        Lac:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse.cleanup(java.lang.Throwable, com.google.protobuf.ByteString, gatewayprotocol.v1.AdResponseOuterClass$AdResponse, com.unity3d.ads.adplayer.AdPlayer, v5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0422 A[Catch: CancellationException -> 0x04a2, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x04a2, blocks: (B:106:0x041b, B:108:0x0422), top: B:161:0x041b }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0237 A[Catch: CancellationException -> 0x00ee, TryCatch #13 {CancellationException -> 0x00ee, blocks: (B:112:0x0456, B:125:0x04af, B:127:0x04e4, B:134:0x04fd, B:129:0x04ea, B:131:0x04f0, B:133:0x04f8, B:91:0x02e8, B:31:0x00e7, B:68:0x022d, B:70:0x0237, B:72:0x024d, B:77:0x0263, B:79:0x026c, B:82:0x0285, B:138:0x0508, B:78:0x0267), top: B:184:0x00e7, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024d A[Catch: CancellationException -> 0x00ee, TryCatch #13 {CancellationException -> 0x00ee, blocks: (B:112:0x0456, B:125:0x04af, B:127:0x04e4, B:134:0x04fd, B:129:0x04ea, B:131:0x04f0, B:133:0x04f8, B:91:0x02e8, B:31:0x00e7, B:68:0x022d, B:70:0x0237, B:72:0x024d, B:77:0x0263, B:79:0x026c, B:82:0x0285, B:138:0x0508, B:78:0x0267), top: B:184:0x00e7, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0301  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v2, types: [kotlin.jvm.internal.a0] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r18v10, types: [kotlin.jvm.internal.a0] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13, types: [kotlin.jvm.internal.a0] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object, kotlin.jvm.internal.a0] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v21, types: [kotlin.jvm.internal.a0] */
    /* JADX WARN: Type inference failed for: r8v35 */
    @Override // com.unity3d.ads.core.domain.HandleGatewayAdResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(com.unity3d.ads.UnityAdsLoadOptions r47, com.google.protobuf.ByteString r48, gatewayprotocol.v1.AdResponseOuterClass.AdResponse r49, android.content.Context r50, java.lang.String r51, gatewayprotocol.v1.DiagnosticEventRequestOuterClass.DiagnosticAdType r52, boolean r53, v5.c<? super com.unity3d.ads.core.data.model.LoadResult> r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse.invoke(com.unity3d.ads.UnityAdsLoadOptions, com.google.protobuf.ByteString, gatewayprotocol.v1.AdResponseOuterClass$AdResponse, android.content.Context, java.lang.String, gatewayprotocol.v1.DiagnosticEventRequestOuterClass$DiagnosticAdType, boolean, v5.c):java.lang.Object");
    }
}
