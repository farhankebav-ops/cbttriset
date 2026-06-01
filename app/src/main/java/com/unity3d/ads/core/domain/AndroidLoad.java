package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidLoad implements Load {
    private final AdRepository adRepository;
    private final w defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetAdPlayerConfigRequest getAdPlayerConfigRequest;
    private final GetAdRequest getAdRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final HandleGatewayAdResponse handleGatewayAdResponse;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidLoad$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidLoad$invoke$2", f = "AndroidLoad.kt", l = {72, 76, 93, 97, Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ AdRequestOuterClass.BannerSize $bannerSize;
        final /* synthetic */ Context $context;
        final /* synthetic */ HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup $headerBiddingAdMarkup;
        final /* synthetic */ UnityAdsLoadOptions $loadOptions;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ String $placement;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AdRequestOuterClass.BannerSize bannerSize, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, ByteString byteString, String str, UnityAdsLoadOptions unityAdsLoadOptions, Context context, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$bannerSize = bannerSize;
            this.$headerBiddingAdMarkup = headerBiddingAdMarkup;
            this.$opportunityId = byteString;
            this.$placement = str;
            this.$loadOptions = unityAdsLoadOptions;
            this.$context = context;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = AndroidLoad.this.new AnonymousClass2(this.$bannerSize, this.$headerBiddingAdMarkup, this.$opportunityId, this.$placement, this.$loadOptions, this.$context, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:115:0x0347, code lost:
        
            if (r0 == r9) goto L116;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:100:0x027f A[Catch: UnityAdsNetworkException -> 0x0025, TryCatch #3 {UnityAdsNetworkException -> 0x0025, blocks: (B:9:0x001e, B:117:0x034a, B:119:0x0350, B:121:0x035e, B:122:0x0371, B:123:0x0378, B:126:0x037d, B:127:0x0383, B:92:0x022b, B:96:0x023e, B:98:0x0263, B:100:0x027f, B:102:0x02e8, B:103:0x02f4, B:105:0x0301, B:106:0x0312, B:107:0x0318, B:111:0x0334, B:91:0x0226, B:21:0x0056, B:78:0x01de, B:64:0x0162, B:68:0x0175, B:63:0x015d, B:29:0x0086, B:50:0x0115, B:32:0x0097, B:34:0x00a3, B:36:0x00b9, B:41:0x00c2, B:44:0x00ca, B:46:0x00f0, B:70:0x01a3, B:72:0x01c2, B:74:0x01c6, B:43:0x00c7), top: B:138:0x0012 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0173  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0263 A[Catch: UnityAdsNetworkException -> 0x0025, TryCatch #3 {UnityAdsNetworkException -> 0x0025, blocks: (B:9:0x001e, B:117:0x034a, B:119:0x0350, B:121:0x035e, B:122:0x0371, B:123:0x0378, B:126:0x037d, B:127:0x0383, B:92:0x022b, B:96:0x023e, B:98:0x0263, B:100:0x027f, B:102:0x02e8, B:103:0x02f4, B:105:0x0301, B:106:0x0312, B:107:0x0318, B:111:0x0334, B:91:0x0226, B:21:0x0056, B:78:0x01de, B:64:0x0162, B:68:0x0175, B:63:0x015d, B:29:0x0086, B:50:0x0115, B:32:0x0097, B:34:0x00a3, B:36:0x00b9, B:41:0x00c2, B:44:0x00ca, B:46:0x00f0, B:70:0x01a3, B:72:0x01c2, B:74:0x01c6, B:43:0x00c7), top: B:138:0x0012 }] */
        /* JADX WARN: Type inference failed for: r12v10 */
        /* JADX WARN: Type inference failed for: r12v2, types: [int] */
        /* JADX WARN: Type inference failed for: r12v3, types: [int] */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v9 */
        /* JADX WARN: Type inference failed for: r33v0 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v28, types: [int] */
        /* JADX WARN: Type inference failed for: r3v31, types: [int] */
        /* JADX WARN: Type inference failed for: r3v32 */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v35 */
        /* JADX WARN: Type inference failed for: r3v36 */
        /* JADX WARN: Type inference failed for: r3v37 */
        /* JADX WARN: Type inference failed for: r3v38 */
        /* JADX WARN: Type inference failed for: r3v39 */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r35) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 909
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidLoad.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super LoadResult> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidLoad(w defaultDispatcher, GetAdRequest getAdRequest, GetAdPlayerConfigRequest getAdPlayerConfigRequest, GetRequestPolicy getRequestPolicy, HandleGatewayAdResponse handleGatewayAdResponse, SessionRepository sessionRepository, GatewayClient gatewayClient, AdRepository adRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(getAdRequest, "getAdRequest");
        k.e(getAdPlayerConfigRequest, "getAdPlayerConfigRequest");
        k.e(getRequestPolicy, "getRequestPolicy");
        k.e(handleGatewayAdResponse, "handleGatewayAdResponse");
        k.e(sessionRepository, "sessionRepository");
        k.e(gatewayClient, "gatewayClient");
        k.e(adRepository, "adRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.defaultDispatcher = defaultDispatcher;
        this.getAdRequest = getAdRequest;
        this.getAdPlayerConfigRequest = getAdPlayerConfigRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.handleGatewayAdResponse = handleGatewayAdResponse;
        this.sessionRepository = sessionRepository;
        this.gatewayClient = gatewayClient;
        this.adRepository = adRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdObject getTmpAdObject(ByteString byteString, String str, boolean z2, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, UnityAdsLoadOptions unityAdsLoadOptions) {
        ByteString EMPTY = ByteString.EMPTY;
        k.d(EMPTY, "EMPTY");
        return new AdObject(byteString, str, EMPTY, false, null, null, null, false, null, null, null, unityAdsLoadOptions, z2, diagnosticAdType, null, null, 50680, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadResult.Failure handleGatewayException(UnityAdsNetworkException unityAdsNetworkException) {
        boolean z2 = unityAdsNetworkException instanceof NetworkTimeoutException;
        return new LoadResult.Failure(z2 ? UnityAds.UnityAdsLoadError.TIMEOUT : UnityAds.UnityAdsLoadError.INTERNAL_ERROR, z2 ? LoadResult.MSG_TIMEOUT : unityAdsNetworkException instanceof GatewayException ? unityAdsNetworkException.getMessage() : LoadResult.MSG_COMMUNICATION_FAILURE, unityAdsNetworkException, z2 ? "timeout" : "gateway", unityAdsNetworkException.getMessage(), false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestAdmCount(boolean z2) {
        if (z2) {
            this.sessionRepository.incrementBannerLoadRequestAdmCount();
        } else {
            this.sessionRepository.incrementLoadRequestAdmCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestCount(boolean z2) {
        if (z2) {
            this.sessionRepository.incrementBannerLoadRequestCount();
        } else {
            this.sessionRepository.incrementLoadRequestCount();
        }
    }

    @Override // com.unity3d.ads.core.domain.Load
    public Object invoke(Context context, String str, ByteString byteString, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, c<? super LoadResult> cVar) {
        return c0.H(new AnonymousClass2(bannerSize, headerBiddingAdMarkup, byteString, str, unityAdsLoadOptions, context, null), this.defaultDispatcher, cVar);
    }
}
