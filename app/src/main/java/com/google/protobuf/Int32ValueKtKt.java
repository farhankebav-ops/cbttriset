package com.google.protobuf;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Int32ValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Int32ValueKtKt {
    /* JADX INFO: renamed from: -initializeint32Value, reason: not valid java name */
    public static final Int32Value m235initializeint32Value(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builderNewBuilder = Int32Value.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Int32Value copy(Int32Value int32Value, e6.l block) {
        kotlin.jvm.internal.k.e(int32Value, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builder = int32Value.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
