package gatewayprotocol.v1;

import gatewayprotocol.v1.MediationInfoKt;
import gatewayprotocol.v1.MediationInfoOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediationInfoKtKt {
    /* JADX INFO: renamed from: -initializemediationInfo, reason: not valid java name */
    public static final MediationInfoOuterClass.MediationInfo m3418initializemediationInfo(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        MediationInfoKt.Dsl.Companion companion = MediationInfoKt.Dsl.Companion;
        MediationInfoOuterClass.MediationInfo.Builder builderNewBuilder = MediationInfoOuterClass.MediationInfo.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        MediationInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final MediationInfoOuterClass.MediationInfo copy(MediationInfoOuterClass.MediationInfo mediationInfo, e6.l block) {
        kotlin.jvm.internal.k.e(mediationInfo, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        MediationInfoKt.Dsl.Companion companion = MediationInfoKt.Dsl.Companion;
        MediationInfoOuterClass.MediationInfo.Builder builder = mediationInfo.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        MediationInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
