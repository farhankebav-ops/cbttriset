package gatewayprotocol.v1;

import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.BannerSizeKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerSizeKtKt {
    /* JADX INFO: renamed from: -initializebannerSize, reason: not valid java name */
    public static final AdRequestOuterClass.BannerSize m3392initializebannerSize(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.Companion;
        AdRequestOuterClass.BannerSize.Builder builderNewBuilder = AdRequestOuterClass.BannerSize.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        BannerSizeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final AdRequestOuterClass.BannerSize copy(AdRequestOuterClass.BannerSize bannerSize, e6.l block) {
        kotlin.jvm.internal.k.e(bannerSize, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.Companion;
        AdRequestOuterClass.BannerSize.Builder builder = bannerSize.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        BannerSizeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
