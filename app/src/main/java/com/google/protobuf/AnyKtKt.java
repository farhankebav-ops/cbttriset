package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.AnyKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class AnyKtKt {
    /* JADX INFO: renamed from: -initializeany, reason: not valid java name */
    public static final Any m222initializeany(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builderNewBuilder = Any.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Any copy(Any any, e6.l block) {
        kotlin.jvm.internal.k.e(any, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builder = any.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
