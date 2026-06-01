package gatewayprotocol.v1;

import gatewayprotocol.v1.InitializationDeviceInfoKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationDeviceInfoKtKt {
    /* JADX INFO: renamed from: -initializeinitializationDeviceInfo, reason: not valid java name */
    public static final InitializationRequestOuterClass.InitializationDeviceInfo m3414initializeinitializationDeviceInfo(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        InitializationDeviceInfoKt.Dsl.Companion companion = InitializationDeviceInfoKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationDeviceInfo.Builder builderNewBuilder = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        InitializationDeviceInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final InitializationRequestOuterClass.InitializationDeviceInfo copy(InitializationRequestOuterClass.InitializationDeviceInfo initializationDeviceInfo, e6.l block) {
        kotlin.jvm.internal.k.e(initializationDeviceInfo, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        InitializationDeviceInfoKt.Dsl.Companion companion = InitializationDeviceInfoKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationDeviceInfo.Builder builder = initializationDeviceInfo.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        InitializationDeviceInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
