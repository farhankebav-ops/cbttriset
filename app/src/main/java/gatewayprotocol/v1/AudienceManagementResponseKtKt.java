package gatewayprotocol.v1;

import gatewayprotocol.v1.AudienceManagementResponseKt;
import gatewayprotocol.v1.AudienceManagementResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AudienceManagementResponseKtKt {
    /* JADX INFO: renamed from: -initializeaudienceManagementResponse, reason: not valid java name */
    public static final AudienceManagementResponseOuterClass.AudienceManagementResponse m3391initializeaudienceManagementResponse(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        AudienceManagementResponseKt.Dsl.Companion companion = AudienceManagementResponseKt.Dsl.Companion;
        AudienceManagementResponseOuterClass.AudienceManagementResponse.Builder builderNewBuilder = AudienceManagementResponseOuterClass.AudienceManagementResponse.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        AudienceManagementResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final AudienceManagementResponseOuterClass.AudienceManagementResponse copy(AudienceManagementResponseOuterClass.AudienceManagementResponse audienceManagementResponse, e6.l block) {
        kotlin.jvm.internal.k.e(audienceManagementResponse, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        AudienceManagementResponseKt.Dsl.Companion companion = AudienceManagementResponseKt.Dsl.Companion;
        AudienceManagementResponseOuterClass.AudienceManagementResponse.Builder builder = audienceManagementResponse.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        AudienceManagementResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final ErrorOuterClass.Error getErrorOrNull(AudienceManagementResponseOuterClass.AudienceManagementResponseOrBuilder audienceManagementResponseOrBuilder) {
        kotlin.jvm.internal.k.e(audienceManagementResponseOrBuilder, "<this>");
        if (audienceManagementResponseOrBuilder.hasError()) {
            return audienceManagementResponseOrBuilder.getError();
        }
        return null;
    }
}
