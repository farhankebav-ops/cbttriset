package com.google.protobuf;

import com.google.protobuf.StringValue;
import com.google.protobuf.StringValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class StringValueKtKt {
    /* JADX INFO: renamed from: -initializestringValue, reason: not valid java name */
    public static final StringValue m242initializestringValue(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builderNewBuilder = StringValue.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final StringValue copy(StringValue stringValue, e6.l block) {
        kotlin.jvm.internal.k.e(stringValue, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builder = stringValue.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
