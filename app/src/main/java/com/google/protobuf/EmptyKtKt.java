package com.google.protobuf;

import com.google.protobuf.Empty;
import com.google.protobuf.EmptyKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptyKtKt {
    /* JADX INFO: renamed from: -initializeempty, reason: not valid java name */
    public static final Empty m228initializeempty(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builderNewBuilder = Empty.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final Empty copy(Empty empty, e6.l block) {
        kotlin.jvm.internal.k.e(empty, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builder = empty.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
