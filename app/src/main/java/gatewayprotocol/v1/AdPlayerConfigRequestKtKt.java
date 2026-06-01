package gatewayprotocol.v1;

import gatewayprotocol.v1.AdPlayerConfigRequestKt;
import gatewayprotocol.v1.AdPlayerConfigRequestOuterClass;
import gatewayprotocol.v1.MediationInfoOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdPlayerConfigRequestKtKt {
    /* JADX INFO: renamed from: -initializeadPlayerConfigRequest, reason: not valid java name */
    public static final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest m3385initializeadPlayerConfigRequest(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        AdPlayerConfigRequestKt.Dsl.Companion companion = AdPlayerConfigRequestKt.Dsl.Companion;
        AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builderNewBuilder = AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        AdPlayerConfigRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest copy(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest, e6.l block) {
        kotlin.jvm.internal.k.e(adPlayerConfigRequest, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        AdPlayerConfigRequestKt.Dsl.Companion companion = AdPlayerConfigRequestKt.Dsl.Companion;
        AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builder = adPlayerConfigRequest.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        AdPlayerConfigRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final MediationInfoOuterClass.MediationInfo getMediationInfoOrNull(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequestOrBuilder adPlayerConfigRequestOrBuilder) {
        kotlin.jvm.internal.k.e(adPlayerConfigRequestOrBuilder, "<this>");
        if (adPlayerConfigRequestOrBuilder.hasMediationInfo()) {
            return adPlayerConfigRequestOrBuilder.getMediationInfo();
        }
        return null;
    }
}
