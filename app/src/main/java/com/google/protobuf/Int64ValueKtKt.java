package com.google.protobuf;

import com.google.protobuf.Int64Value;
import com.google.protobuf.Int64ValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Int64ValueKtKt {
    /* JADX INFO: renamed from: -initializeint64Value, reason: not valid java name */
    public static final Int64Value m236initializeint64Value(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builderNewBuilder = Int64Value.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Int64Value copy(Int64Value int64Value, e6.l block) {
        kotlin.jvm.internal.k.e(int64Value, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builder = int64Value.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
