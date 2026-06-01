package gatewayprotocol.v1;

import gatewayprotocol.v1.CachedAssetsConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CachedAssetsConfigurationKtKt {
    /* JADX INFO: renamed from: -initializecachedAssetsConfiguration, reason: not valid java name */
    public static final NativeConfigurationOuterClass.CachedAssetsConfiguration m3393initializecachedAssetsConfiguration(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        CachedAssetsConfigurationKt.Dsl.Companion companion = CachedAssetsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder builderNewBuilder = NativeConfigurationOuterClass.CachedAssetsConfiguration.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        CachedAssetsConfigurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final NativeConfigurationOuterClass.CachedAssetsConfiguration copy(NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration, e6.l block) {
        kotlin.jvm.internal.k.e(cachedAssetsConfiguration, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        CachedAssetsConfigurationKt.Dsl.Companion companion = CachedAssetsConfigurationKt.Dsl.Companion;
        NativeConfigurationOuterClass.CachedAssetsConfiguration.Builder builder = cachedAssetsConfiguration.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        CachedAssetsConfigurationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
