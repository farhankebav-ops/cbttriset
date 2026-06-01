package gatewayprotocol.v1;

import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.InitializationResponseKt;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationResponseKtKt {
    /* JADX INFO: renamed from: -initializeinitializationResponse, reason: not valid java name */
    public static final InitializationResponseOuterClass.InitializationResponse m3416initializeinitializationResponse(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        InitializationResponseKt.Dsl.Companion companion = InitializationResponseKt.Dsl.Companion;
        InitializationResponseOuterClass.InitializationResponse.Builder builderNewBuilder = InitializationResponseOuterClass.InitializationResponse.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        InitializationResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final InitializationResponseOuterClass.InitializationResponse copy(InitializationResponseOuterClass.InitializationResponse initializationResponse, e6.l block) {
        kotlin.jvm.internal.k.e(initializationResponse, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        InitializationResponseKt.Dsl.Companion companion = InitializationResponseKt.Dsl.Companion;
        InitializationResponseOuterClass.InitializationResponse.Builder builder = initializationResponse.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        InitializationResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final ErrorOuterClass.Error getErrorOrNull(InitializationResponseOuterClass.InitializationResponseOrBuilder initializationResponseOrBuilder) {
        kotlin.jvm.internal.k.e(initializationResponseOrBuilder, "<this>");
        if (initializationResponseOrBuilder.hasError()) {
            return initializationResponseOrBuilder.getError();
        }
        return null;
    }

    public static final NativeConfigurationOuterClass.NativeConfiguration getNativeConfigurationOrNull(InitializationResponseOuterClass.InitializationResponseOrBuilder initializationResponseOrBuilder) {
        kotlin.jvm.internal.k.e(initializationResponseOrBuilder, "<this>");
        if (initializationResponseOrBuilder.hasNativeConfiguration()) {
            return initializationResponseOrBuilder.getNativeConfiguration();
        }
        return null;
    }
}
