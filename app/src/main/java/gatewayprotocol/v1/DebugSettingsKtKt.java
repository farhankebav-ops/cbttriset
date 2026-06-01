package gatewayprotocol.v1;

import gatewayprotocol.v1.DebugSettingsKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DebugSettingsKtKt {
    /* JADX INFO: renamed from: -initializedebugSettings, reason: not valid java name */
    public static final NativeConfigurationOuterClass.DebugSettings m3397initializedebugSettings(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        DebugSettingsKt.Dsl.Companion companion = DebugSettingsKt.Dsl.Companion;
        NativeConfigurationOuterClass.DebugSettings.Builder builderNewBuilder = NativeConfigurationOuterClass.DebugSettings.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        DebugSettingsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final NativeConfigurationOuterClass.DebugSettings copy(NativeConfigurationOuterClass.DebugSettings debugSettings, e6.l block) {
        kotlin.jvm.internal.k.e(debugSettings, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        DebugSettingsKt.Dsl.Companion companion = DebugSettingsKt.Dsl.Companion;
        NativeConfigurationOuterClass.DebugSettings.Builder builder = debugSettings.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        DebugSettingsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
