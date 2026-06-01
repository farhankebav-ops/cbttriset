package com.google.protobuf;

import com.google.protobuf.BytesValue;
import com.google.protobuf.BytesValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class BytesValueKtKt {
    /* JADX INFO: renamed from: -initializebytesValue, reason: not valid java name */
    public static final BytesValue m225initializebytesValue(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        BytesValueKt.Dsl.Companion companion = BytesValueKt.Dsl.Companion;
        BytesValue.Builder builderNewBuilder = BytesValue.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        BytesValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final BytesValue copy(BytesValue bytesValue, e6.l block) {
        kotlin.jvm.internal.k.e(bytesValue, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        BytesValueKt.Dsl.Companion companion = BytesValueKt.Dsl.Companion;
        BytesValue.Builder builder = bytesValue.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        BytesValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
