package gatewayprotocol.v1;

import gatewayprotocol.v1.PiiKt;
import gatewayprotocol.v1.PiiOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PiiKtKt {
    /* JADX INFO: renamed from: -initializepii, reason: not valid java name */
    public static final PiiOuterClass.Pii m3424initializepii(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder builderNewBuilder = PiiOuterClass.Pii.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        PiiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final PiiOuterClass.Pii copy(PiiOuterClass.Pii pii, e6.l block) {
        kotlin.jvm.internal.k.e(pii, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder builder = pii.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        PiiKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
