package com.google.protobuf;

import com.google.protobuf.Struct;
import com.google.protobuf.StructKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class StructKtKt {
    /* JADX INFO: renamed from: -initializestruct, reason: not valid java name */
    public static final Struct m243initializestruct(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        StructKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Struct copy(Struct struct, e6.l block) {
        kotlin.jvm.internal.k.e(struct, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builder = struct.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        StructKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
