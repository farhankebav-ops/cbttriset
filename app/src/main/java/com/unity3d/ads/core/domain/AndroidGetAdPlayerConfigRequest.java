package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.AdFormatOuterClass;
import gatewayprotocol.v1.AdPlayerConfigRequestKt;
import gatewayprotocol.v1.AdPlayerConfigRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetAdPlayerConfigRequest implements GetAdPlayerConfigRequest {
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetAdPlayerConfigRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad) {
        k.e(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
    }

    @Override // com.unity3d.ads.core.domain.GetAdPlayerConfigRequest
    public Object invoke(String str, ByteString byteString, ByteString byteString2, AdFormatOuterClass.AdFormat adFormat, c<? super UniversalRequestOuterClass.UniversalRequest> cVar) {
        AdPlayerConfigRequestKt.Dsl.Companion companion = AdPlayerConfigRequestKt.Dsl.Companion;
        AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builderNewBuilder = AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        AdPlayerConfigRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setConfigurationToken(byteString2);
        dsl_create.setPlacementId(str);
        dsl_create.setImpressionOpportunityId(byteString);
        if (adFormat != null) {
            dsl_create.setAdFormat(adFormat);
        }
        AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest_build = dsl_create._build();
        UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
        UniversalRequestKt.PayloadKt.Dsl.Companion companion2 = UniversalRequestKt.PayloadKt.Dsl.Companion;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder builderNewBuilder2 = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        k.d(builderNewBuilder2, "newBuilder()");
        UniversalRequestKt.PayloadKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        dsl_create2.setAdPlayerConfigRequest(adPlayerConfigRequest_build);
        return this.getUniversalRequestForPayLoad.invoke(dsl_create2._build(), cVar);
    }
}
