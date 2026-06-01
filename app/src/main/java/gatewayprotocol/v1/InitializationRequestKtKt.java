package gatewayprotocol.v1;

import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.InitializationRequestKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationRequestKtKt {
    /* JADX INFO: renamed from: -initializeinitializationRequest, reason: not valid java name */
    public static final InitializationRequestOuterClass.InitializationRequest m3415initializeinitializationRequest(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationRequest.Builder builderNewBuilder = InitializationRequestOuterClass.InitializationRequest.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        InitializationRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final InitializationRequestOuterClass.InitializationRequest copy(InitializationRequestOuterClass.InitializationRequest initializationRequest, e6.l block) {
        kotlin.jvm.internal.k.e(initializationRequest, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationRequest.Builder builder = initializationRequest.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        InitializationRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final ClientInfoOuterClass.ClientInfo getClientInfoOrNull(InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        kotlin.jvm.internal.k.e(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasClientInfo()) {
            return initializationRequestOrBuilder.getClientInfo();
        }
        return null;
    }

    public static final InitializationRequestOuterClass.InitializationDeviceInfo getDeviceInfoOrNull(InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        kotlin.jvm.internal.k.e(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasDeviceInfo()) {
            return initializationRequestOrBuilder.getDeviceInfo();
        }
        return null;
    }
}
