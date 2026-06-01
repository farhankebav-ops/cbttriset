package com.google.protobuf;

import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ListValueKtKt {
    /* JADX INFO: renamed from: -initializelistValue, reason: not valid java name */
    public static final ListValue m237initializelistValue(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final ListValue copy(ListValue listValue, e6.l block) {
        kotlin.jvm.internal.k.e(listValue, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builder = listValue.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
