package com.google.protobuf;

import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValueKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class DoubleValueKtKt {
    /* JADX INFO: renamed from: -initializedoubleValue, reason: not valid java name */
    public static final DoubleValue m226initializedoubleValue(e6.l block) {
        kotlin.jvm.internal.k.e(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builderNewBuilder = DoubleValue.newBuilder();
        kotlin.jvm.internal.k.d(builderNewBuilder, "newBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    public static final DoubleValue copy(DoubleValue doubleValue, e6.l block) {
        kotlin.jvm.internal.k.e(doubleValue, "<this>");
        kotlin.jvm.internal.k.e(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builder = doubleValue.toBuilder();
        kotlin.jvm.internal.k.d(builder, "this.toBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
