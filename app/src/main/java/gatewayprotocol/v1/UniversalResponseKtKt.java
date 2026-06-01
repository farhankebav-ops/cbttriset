package gatewayprotocol.v1;

import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.AudienceManagementResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.PrivacyUpdateResponseOuterClass;
import gatewayprotocol.v1.UniversalResponseKt;
import gatewayprotocol.v1.UniversalResponseOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UniversalResponseKtKt {
    /* JADX INFO: renamed from: -initializeuniversalResponse, reason: not valid java name */
    public static final UniversalResponseOuterClass.UniversalResponse m3444initializeuniversalResponse(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Builder builderNewBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        UniversalResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final UniversalResponseOuterClass.UniversalResponse copy(UniversalResponseOuterClass.UniversalResponse universalResponse, e6.l block) {
        kotlin.jvm.internal.k.e(universalResponse, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Builder builder = universalResponse.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        UniversalResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse getAdDataRefreshResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdDataRefreshResponse()) {
            return payloadOrBuilder.getAdDataRefreshResponse();
        }
        return null;
    }

    public static final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse getAdPlayerConfigResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdPlayerConfigResponse()) {
            return payloadOrBuilder.getAdPlayerConfigResponse();
        }
        return null;
    }

    public static final AdResponseOuterClass.AdResponse getAdResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdResponse()) {
            return payloadOrBuilder.getAdResponse();
        }
        return null;
    }

    public static final AudienceManagementResponseOuterClass.AudienceManagementResponse getAudienceManagementResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAudienceManagementResponse()) {
            return payloadOrBuilder.getAudienceManagementResponse();
        }
        return null;
    }

    public static final ErrorOuterClass.Error getErrorOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        kotlin.jvm.internal.k.e(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasError()) {
            return universalResponseOrBuilder.getError();
        }
        return null;
    }

    public static final InitializationResponseOuterClass.InitializationResponse getInitializationResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasInitializationResponse()) {
            return payloadOrBuilder.getInitializationResponse();
        }
        return null;
    }

    public static final MutableDataOuterClass.MutableData getMutableDataOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        kotlin.jvm.internal.k.e(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasMutableData()) {
            return universalResponseOrBuilder.getMutableData();
        }
        return null;
    }

    public static final UniversalResponseOuterClass.UniversalResponse.Payload getPayloadOrNull(UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        kotlin.jvm.internal.k.e(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasPayload()) {
            return universalResponseOrBuilder.getPayload();
        }
        return null;
    }

    public static final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse getPrivacyUpdateResponseOrNull(UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        kotlin.jvm.internal.k.e(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasPrivacyUpdateResponse()) {
            return payloadOrBuilder.getPrivacyUpdateResponse();
        }
        return null;
    }

    public static final UniversalResponseOuterClass.UniversalResponse.Payload copy(UniversalResponseOuterClass.UniversalResponse.Payload payload, e6.l block) {
        kotlin.jvm.internal.k.e(payload, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        UniversalResponseKt.PayloadKt.Dsl.Companion companion = UniversalResponseKt.PayloadKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder = payload.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        UniversalResponseKt.PayloadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
