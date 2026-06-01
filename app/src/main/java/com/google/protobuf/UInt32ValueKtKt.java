package com.google.protobuf;

import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class UInt32ValueKtKt {
    /* JADX INFO: renamed from: -initializeuInt32Value, reason: not valid java name */
    public static final UInt32Value m246initializeuInt32Value(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builderNewBuilder = UInt32Value.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final UInt32Value copy(UInt32Value uInt32Value, e6.l block) {
        kotlin.jvm.internal.k.e(uInt32Value, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builder = uInt32Value.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
