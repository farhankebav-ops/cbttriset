package com.google.protobuf;

import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class SourceContextKtKt {
    /* JADX INFO: renamed from: -initializesourceContext, reason: not valid java name */
    public static final SourceContext m241initializesourceContext(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builderNewBuilder = SourceContext.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final SourceContext copy(SourceContext sourceContext, e6.l block) {
        kotlin.jvm.internal.k.e(sourceContext, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builder = sourceContext.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
