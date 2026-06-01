package com.unity3d.ads.core.domain.scar;

import com.google.protobuf.ByteString;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.AdFormatExtensions;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.AdFormatOuterClass;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import r5.r;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFetchSignalsAndSendUseCase implements FetchSignalsAndSendUseCase {
    private final HandleGetTokenRequest handleGetTokenRequest;
    private final ScarManager scarManager;
    private final a0 scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase$invoke$2", f = "AndroidFetchSignalsAndSendUseCase.kt", l = {36, Sdk.SDKMetric.SDKMetricType.AD_VISIBILITY_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ TokenConfiguration $tokenConfiguration;
        final /* synthetic */ ByteString $tokenId;
        final /* synthetic */ int $tokenNumber;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TokenConfiguration tokenConfiguration, int i2, ByteString byteString, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$tokenConfiguration = tokenConfiguration;
            this.$tokenNumber = i2;
            this.$tokenId = byteString;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = AndroidFetchSignalsAndSendUseCase.this.new AnonymousClass2(this.$tokenConfiguration, this.$tokenNumber, this.$tokenId, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidFetchSignalsAndSendUseCase(a0 scope, SessionRepository sessionRepository, ScarManager scarManager, HandleGetTokenRequest handleGetTokenRequest, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(scope, "scope");
        k.e(sessionRepository, "sessionRepository");
        k.e(scarManager, "scarManager");
        k.e(handleGetTokenRequest, "handleGetTokenRequest");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.scope = scope;
        this.sessionRepository = sessionRepository;
        this.scarManager = scarManager;
        this.handleGetTokenRequest = handleGetTokenRequest;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AdFormatOuterClass.AdFormat> getRequestedSignalFormats(TokenConfiguration tokenConfiguration) {
        if (tokenConfiguration == null) {
            return this.sessionRepository.getScarEligibleFormats();
        }
        AdFormatOuterClass.AdFormat protoAdFormat = AdFormatExtensions.toProtoAdFormat(tokenConfiguration.getAdFormat());
        if (!this.sessionRepository.getScarEligibleFormats().contains(protoAdFormat)) {
            protoAdFormat = null;
        }
        return protoAdFormat != null ? q.j0(protoAdFormat) : r.f13638a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getTags() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<AdFormatOuterClass.AdFormat> scarEligibleFormats = this.sessionRepository.getScarEligibleFormats();
        if (scarEligibleFormats.contains(AdFormatOuterClass.AdFormat.AD_FORMAT_BANNER)) {
            linkedHashMap.put("banner", a.g);
        }
        if (scarEligibleFormats.contains(AdFormatOuterClass.AdFormat.AD_FORMAT_REWARDED)) {
            linkedHashMap.put("rewarded", a.g);
        }
        if (scarEligibleFormats.contains(AdFormatOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL)) {
            linkedHashMap.put("interstitial", a.g);
        }
        return linkedHashMap;
    }

    @Override // com.unity3d.ads.core.domain.scar.FetchSignalsAndSendUseCase
    public Object invoke(int i2, ByteString byteString, TokenConfiguration tokenConfiguration, c<? super x> cVar) {
        c0.u(this.scope, null, new AnonymousClass2(tokenConfiguration, i2, byteString, null), 3);
        return x.f13520a;
    }
}
