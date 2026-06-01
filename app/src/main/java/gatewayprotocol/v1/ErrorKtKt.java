package gatewayprotocol.v1;

import gatewayprotocol.v1.ErrorKt;
import gatewayprotocol.v1.ErrorOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ErrorKtKt {
    /* JADX INFO: renamed from: -initializeerror, reason: not valid java name */
    public static final ErrorOuterClass.Error m3407initializeerror(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        ErrorKt.Dsl.Companion companion = ErrorKt.Dsl.Companion;
        ErrorOuterClass.Error.Builder builderNewBuilder = ErrorOuterClass.Error.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        ErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final ErrorOuterClass.Error copy(ErrorOuterClass.Error error, e6.l block) {
        kotlin.jvm.internal.k.e(error, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        ErrorKt.Dsl.Companion companion = ErrorKt.Dsl.Companion;
        ErrorOuterClass.Error.Builder builder = error.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        ErrorKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
