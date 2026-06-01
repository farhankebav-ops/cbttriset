package gatewayprotocol.v1;

import gatewayprotocol.v1.TestDataKt;
import gatewayprotocol.v1.TestDataOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TestDataKtKt {
    /* JADX INFO: renamed from: -initializetestData, reason: not valid java name */
    public static final TestDataOuterClass.TestData m3435initializetestData(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        TestDataOuterClass.TestData.Builder builderNewBuilder = TestDataOuterClass.TestData.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        TestDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final TestDataOuterClass.TestData copy(TestDataOuterClass.TestData testData, e6.l block) {
        kotlin.jvm.internal.k.e(testData, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        TestDataOuterClass.TestData.Builder builder = testData.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        TestDataKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
